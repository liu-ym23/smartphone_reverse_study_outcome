package com.ss.android.lark.chameleon.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes35.dex */
public class EncryptUtil {
    public static final String DEFAULT_PATTERN_STR = "((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}";
    private static final String TAG = "EncryptUtil";
    public static final String TOKEN_TIPS = "token is sensitive **** ";
    public static Pattern tokenPattern;

    public EncryptUtil() {
    }

    static {
        tokenPattern = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
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
        Log.e(TAG, "", th);
        return "";
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L14:
        return "";
    L6:
        if (r100.length() < 6) goto L14;
        int r101 = 0;
        String r102 = r100.substring(0, 3);     // Catch: Throwable -> L15
        String r103 = r100.substring(r100.length() - 3);     // Catch: Throwable -> L15
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
        Log.e(TAG, "", e);
        return r100;
    }
}
