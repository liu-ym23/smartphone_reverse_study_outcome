package com.ss.android.lark.chameleon.util;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import kotlin.UByte;

/* JADX INFO: loaded from: classes35.dex */
public class EncriptUtils {
    public static final String DEFAULT_PATTERN_STR = "((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}";
    private static final char[] HEX_CHARS = null;
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_SHA1 = "SHA-1";
    private static final String TAG = "EncriptUtils";
    public static final String URL_PARAM = "url";
    private static SecretKey sSecretKey = null;
    public static Pattern tokenPattern = null;
    public static final String tokenTips = "token is sensitive **** ";

    public EncriptUtils() {
    }

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        tokenPattern = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
    }

    public static boolean check(String r100) {
        if (r100 != null) goto L10;
        return false;
    L10:
        return tokenPattern.matcher(r100).find();
    L7:
        e = move-exception;
        Log.e(TAG, e.getMessage(), e);
        return false;
    }

    public static String getHostOrParam(String r100) {
        Uri r101 = UriProtector.parse(r100);
        String r102 = UriProtector.getQueryParameter(r101, "url");
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r101 = UriProtector.parse(r102);
    L6:
        if (r101.getHost() != null) goto L8;
        return r100;
    L8:
        return r101.getHost();
    }

    public static String getRandomString(int r100) {
        Random r101 = new Random();
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L6;
        r102.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(r101.nextInt(62)));
        r103 = r103 + 1;
        goto L3
    L6:
        return r102.toString();
    }

    public static String handleEncription(Object r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        String r101 = r100.toString();
        if ("".equals(r101) == false) goto L16;
        return r101;
    L16:
        Matcher r102 = tokenPattern.matcher(r101);     // Catch: Exception -> L13
    L10:
        if (r102.find() == false) goto L15;
        String r103 = r102.group();     // Catch: Exception -> L13
        r101 = r101.replaceAll(r103, handleEncription(r103));     // Catch: Exception -> L13
    L15:
        return r101;
    L13:
        e = move-exception;
        Log.e(TAG, "handleEncription exception:" + e);
        goto L15
    }

    public static void injectTokenPattern(String r100) {
        Log.i(TAG, "inject token pattern");
        tokenPattern = PatternProtector.compile(r100);
    }

    public static String maskAllToken(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return r100;
    L16:
        long r101 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L13
        StringBuffer r102 = new StringBuffer();     // Catch: Throwable -> L13
        Matcher r103 = tokenPattern.matcher(r100);     // Catch: Throwable -> L13
        r103.reset();     // Catch: Throwable -> L13
    L7:
        if (r103.find() == false) goto L9;
        r103.appendReplacement(r102, maskObjToken(r103.group()));     // Catch: Throwable -> L13
        goto L7
    L9:
        r103.appendTail(r102);     // Catch: Throwable -> L13
        String r104 = r102.toString();     // Catch: Throwable -> L13
        if ((SystemClock.elapsedRealtimeNanos() - r101) <= KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL) goto L12;
        Log.e(TAG, "maskAllToken, takes too much time, result msg: " + r104);     // Catch: Throwable -> L13
    L12:
        return r104;
    L13:
        th = move-exception;
        Log.e(TAG, "maskAllToken", th);
        return replaceToken(r100);
    }

    public static String maskObjToken(String r100) {
    L15:
        th = move-exception;
        Log.e(TAG, th.getMessage(), th);
        return "";
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L14:
        return "";
    L6:
        if (r100.length() < 6) goto L14;
        int r101 = 0;
        String r102 = r100.substring(0, 3);     // Catch: Throwable -> L15
        String r103 = r100.substring(r100.length() - 3, r100.length());     // Catch: Throwable -> L15
        StringBuilder r104 = new StringBuilder("*");     // Catch: Throwable -> L15
    L10:
        if (r101 >= (r100.length() - 6)) goto L12;
        r104.append("*");     // Catch: Throwable -> L15
        r101 = r101 + 1;     // Catch: Throwable -> L15
        goto L10
    L12:
        return r102 + r104.toString() + r103;
    }

    public static String replaceToken(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r100;
    L10:
        return tokenPattern.matcher(r100).replaceAll("token is sensitive **** ");
    L7:
        e = move-exception;
        Log.e(TAG, e.getMessage(), e);
        return r100;
    }

    public static String replaceUrl(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        Uri r101 = UriProtector.parse(r100);
        return r101.getHost() + replaceToken(r101.getPath());
    L6:
        return "";
    }

    private static String toHexString(byte[] r100) {
        if (r100 == null) goto L6;
        return toHexString(r100, 0, r100.length);
    L6:
        throw new NullPointerException("bytes is null");
    }

    public static String transformMD5(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L14;
        return null;
    L14:
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L11
        r101.update(r100.getBytes());     // Catch: Exception -> L11
        byte[] r102 = r101.digest();     // Catch: Exception -> L11
        String r103 = "";
        int r104 = 0;
    L7:
        if (r104 >= r102.length) goto L10;
        r103 = r103 + Integer.toHexString((r102[r104] & UByte.MAX_VALUE) | (-256)).substring(6);     // Catch: Exception -> L11
        r104 = r104 + 1;
        goto L7
    L10:
        return r103;
    L11:
        e = move-exception;
        Log.e(TAG, "transformMD5 ", e);
        return null;
    }

    public static String transformSHA1(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        byte[] r101 = r100.getBytes();
        MessageDigest r102 = MessageDigest.getInstance("SHA-1");     // Catch: Exception -> L13
        r102.update(r101);     // Catch: Exception -> L13
        byte[] r103 = r102.digest();     // Catch: Exception -> L13
        String r104 = "";
        int r105 = 0;
    L9:
        if (r105 >= r103.length) goto L12;
        r104 = r104 + Integer.toHexString((r103[r105] & UByte.MAX_VALUE) | (-256)).substring(6);     // Catch: Exception -> L13
        r105 = r105 + 1;
        goto L9
    L12:
        return r104;
    L13:
        e = move-exception;
        Log.e(TAG, "transformSHA1 ", e);
        return null;
    }

    public static String handleEncription(String r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        if ("".equals(r100) == false) goto L9;
        return r100;
    L9:
        return transformSHA1("08a441" + transformMD5(r100.concat("42b91e")));
    }

    private static String toHexString(byte[] r100, int r110, int r111) {
        if (r100 == null) goto L14;
        if (r110 < 0) goto L12;
        if ((r110 + r111) > r100.length) goto L12;
        int r101 = r111 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r111) goto L10;
        int r105 = r100[r103 + r110] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = HEX_CHARS;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L7
    L10:
        return new String(r102, 0, r101);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }
}
