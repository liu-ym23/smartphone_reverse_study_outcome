package du5;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import kotlin.UByte;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SecretKey f470042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f470043b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Pattern f470044c;

    static {
        f470043b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        f470044c = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
    }

    public static void b() {
        if (f470042a != null) goto L6;
        f470042a = a.c(new char[]{Typography.dollar, '5', '2', '*', 'y', Symlink.UNIX_ID, 'q'});
        return;
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L10;
        return false;
    L10:
        return f470044c.matcher(r100).find();
    L7:
        e = move-exception;
        tt5.a.f("EncriptUtils", e, false);
        return false;
    }

    public static String c(int r100) {
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

    public static String d(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        b();
        SecretKey r101 = f470042a;
        return a.a(Base64.decode(r100, 0), r101);
    L6:
        return "";
    }

    public static String e(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        b();
        return Base64.encodeToString(a.b(r100, f470042a), 0);
    L6:
        return "";
    }

    public static String f(Object r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        String r101 = r100.toString();
        if ("".equals(r101) == false) goto L16;
        return r101;
    L16:
        Matcher r102 = f470044c.matcher(r101);     // Catch: Exception -> L13
    L10:
        if (r102.find() == false) goto L15;
        String r103 = r102.group();     // Catch: Exception -> L13
        r101 = r101.replaceAll(r103, g(r103));     // Catch: Exception -> L13
    L15:
        return r101;
    L13:
        e = move-exception;
        tt5.a.d("EncriptUtils", "handleEncription exception:" + e);
        goto L15
    }

    public static String g(String r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        String r101 = "";
        if ("".equals(r100) == false) goto L8;
        return r100;
    L8:
        String r102 = "08a441" + n(r100.concat("42b91e"));
        if (TextUtils.isEmpty(r102) == true) goto L25;
        byte[] r103 = r102.getBytes();
        MessageDigest r104 = MessageDigest.getInstance("SHA-1");     // Catch: Exception -> L18
        r104.update(r103);     // Catch: Exception -> L18
        byte[] r105 = r104.digest();     // Catch: Exception -> L18
        int r106 = 0;
    L14:
        if (r106 >= r105.length) goto L24;
        r101 = r101 + Integer.toHexString((r105[r106] & UByte.MAX_VALUE) | (-256)).substring(6);     // Catch: Exception -> L18
        r106 = r106 + 1;
        goto L14
    L24:
        return r101;
    L18:
        e = move-exception;
        tt5.a.e("EncriptUtils", "transformSHA1 ", e, false);
        return null;
    L25:
        return null;
    }

    public static String h(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return r100;
    L16:
        long r101 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L13
        StringBuffer r102 = new StringBuffer();     // Catch: Throwable -> L13
        Matcher r103 = f470044c.matcher(r100);     // Catch: Throwable -> L13
        r103.reset();     // Catch: Throwable -> L13
    L7:
        if (r103.find() == false) goto L9;
        r103.appendReplacement(r102, i(r103.group()));     // Catch: Throwable -> L13
        goto L7
    L9:
        r103.appendTail(r102);     // Catch: Throwable -> L13
        String r104 = r102.toString();     // Catch: Throwable -> L13
        if ((SystemClock.elapsedRealtimeNanos() - r101) <= KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL) goto L12;
        tt5.a.d("EncriptUtils", "maskAllToken, takes too much time, result msg: " + r104);     // Catch: Throwable -> L13
    L12:
        return r104;
    L13:
        th = move-exception;
        tt5.a.e("EncriptUtils", "maskAllToken", th, false);
        return k(r100);
    }

    public static String i(String r100) {
    L15:
        th = move-exception;
        tt5.a.f("EncriptUtils", th, false);
        return "";
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L14:
        return "";
    L6:
        if (r100.length() < 6) goto L14;
        String r101 = r100.substring(0, 3);     // Catch: Throwable -> L15
        String r102 = r100.substring(r100.length() - 3, r100.length());     // Catch: Throwable -> L15
        StringBuilder r103 = new StringBuilder("*");     // Catch: Throwable -> L15
        int r104 = 0;
    L10:
        if (r104 >= (r100.length() - 6)) goto L12;
        r103.append("*");     // Catch: Throwable -> L15
        r104 = r104 + 1;     // Catch: Throwable -> L15
        goto L10
    L12:
        return r101 + r103.toString() + r102;
    }

    public static String j(VFSPath r100) {
        InputStream r101 = null;
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L16 Throwable -> L24
        if (r102 != null) goto L6;
        return null;
    L6:
        r101 = ay4.d.a().l(r100);     // Catch: Exception -> L16 Throwable -> L24
        byte[] r103 = new byte[8192];     // Catch: Exception -> L16 Throwable -> L24
    L7:
        int r104 = r101.read(r103, 0, 8192);     // Catch: Exception -> L16 Throwable -> L24
        if (r104 <= 0) goto L10;
        r102.update(r103, 0, r104);     // Catch: Exception -> L16 Throwable -> L24
        goto L7
    L10:
        r101.close();     // Catch: Exception -> L16 Throwable -> L24
        String r105 = m(r102.digest());     // Catch: Exception -> L16 Throwable -> L24
        r101.close();     // Catch: IOException -> L13
    L15:
        return r105;
    L13:
        e = move-exception;
        tt5.a.e("EncriptUtils", "md5Hex(): ", e, false);
        goto L15
    L16:
        e = move-exception;
        tt5.a.e("EncriptUtils", "md5Hex(): failed", e, false);     // Catch: Throwable -> L24
        if (r101 != null) goto L31;
    L23:
        return "";
    L31:
        r101.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        tt5.a.e("EncriptUtils", "md5Hex(): ", e, false);
    L24:
        th = move-exception;
        if (r101 != null) goto L33;
    L30:
        throw th;
    L33:
        r101.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        tt5.a.e("EncriptUtils", "md5Hex(): ", e, false);
        goto L30
    }

    public static String k(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r100;
    L10:
        return f470044c.matcher(r100).replaceAll("token is sensitive **** ");
    L7:
        e = move-exception;
        tt5.a.g(e);
        return r100;
    }

    public static String l(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        Uri r101 = UriProtector.parse(r100);
        return r101.getHost() + k(r101.getPath());
    L6:
        return "";
    }

    public static String m(byte[] r110) {
        if (r110 == null) goto L13;
        int r100 = r110.length;
        if ((0 + r100) > r110.length) goto L11;
        int r101 = r100 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r100) goto L9;
        int r105 = r110[r103 + 0] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = f470043b;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L6
    L9:
        return new String(r102, 0, r101);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }

    public static String n(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return null;
    L15:
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        r101.update(r100.getBytes());     // Catch: Exception -> L12
        byte[] r102 = r101.digest();     // Catch: Exception -> L12
        String r103 = "";
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L11;
        r103 = r103 + Integer.toHexString((r102[r104] & UByte.MAX_VALUE) | (-256)).substring(6);     // Catch: Exception -> L12
        r104 = r104 + 1;
        goto L8
    L11:
        return r103;
    L12:
        e = move-exception;
        tt5.a.e("EncriptUtils", "transformMD5 ", e, false);
        return null;
    }
}
