package v64;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import f06.d;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static String a(Context r100, String r101) {
        Cursor r102 = null;
        byte[] r103 = c(r101.substring(0, 24));     // Catch: Throwable -> L19
        byte[] r104 = c(r101.substring(24));     // Catch: Throwable -> L19
        Cursor r105 = e(r100.getContentResolver(), Uri.parse("content://com.huawei.hwid.pps.apiprovider/oaid_scp/get"));     // Catch: Throwable -> L19
        if (r105 != null) goto L31;
    L16:
        if (r105 != null) goto L29;
    L18:
        return null;
    L29:
        r105.close();     // Catch: Exception -> L25
        goto L18
    L31:
    L14:
        Throwable th10 = th;
        r102 = r105;
    L21:
        if (r102 == null) goto L37;
        r102.close();     // Catch: Exception -> L26
        throw th10;
    L38:
        throw th10;
    L37:
        throw th10;
    L6:
        if (r105.moveToNext() == false) goto L16;
        int r106 = r105.getColumnIndex("op_wk");     // Catch: Throwable -> L14
        if (r106 < 0) goto L16;
        String r107 = r105.getString(r106);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r107) == true) goto L16;
        SecretKeySpec r108 = new SecretKeySpec(c(r107), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L14
        GCMParameterSpec r109 = new GCMParameterSpec(128, r103);     // Catch: Throwable -> L14
        Cipher r110 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Throwable -> L14
        r110.init(2, r108, r109);     // Catch: Throwable -> L14
        String r111 = new String(r110.doFinal(r104), "UTF-8");     // Catch: Throwable -> L14
        r105.close();     // Catch: Exception -> L24
    L13:
        return r111;
    L19:
        th = move-exception;
        th10 = th;
        goto L21
    }

    public static byte[] c(String r100) {
        int r101 = 0;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        int r102 = r100.length();
        byte[] r103 = new byte[r102 / 2];
    L7:
        if (r101 >= r102) goto L9;
        r103[r101 / 2] = (byte) ((Character.digit(r100.charAt(r101), 16) << 4) + Character.digit(r100.charAt(r101 + 1), 16));
        r101 = r101 + 2;
        goto L7
    L9:
        return r103;
    L5:
        return new byte[0];
    }

    public static c b(Context r100) {
        c r101 = new c();
        if (r100 != null) goto L5;
        return r101;
    L5:
        long r102 = SystemClock.elapsedRealtime();
        String r103 = f(r100.getContentResolver(), "oaid_limit_state");     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r103) == false) goto L9;
        r103 = Settings.Global.getString(r100.getContentResolver(), "oaid_limit_state");     // Catch: Exception -> L25
    L9:
        boolean r104 = "true".equalsIgnoreCase(r103);     // Catch: Exception -> L25
        if (r104 == false) goto L14;
        r101.f553397a = "00000000-0000-0000-0000-000000000000";     // Catch: Exception -> L25
        r101.f553398b = r104;     // Catch: Exception -> L25
        r101.f553400d = SystemClock.elapsedRealtime() - r102;     // Catch: Exception -> L25
        return r101;
    L14:
        String r105 = f(r100.getContentResolver(), "oaid");     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r105) == false) goto L17;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == false) goto L23;
        r101.f553397a = r105;     // Catch: Exception -> L25
        r101.f553398b = r104;     // Catch: Exception -> L25
        r101.f553400d = SystemClock.elapsedRealtime() - r102;     // Catch: Exception -> L25
        r101.f553401e = "secure";     // Catch: Exception -> L25
        return r101;
    L23:
        r101.f553397a = Settings.Global.getString(r100.getContentResolver(), "oaid");     // Catch: Exception -> L25
        r101.f553398b = r104;     // Catch: Exception -> L25
        r101.f553400d = SystemClock.elapsedRealtime() - r102;     // Catch: Exception -> L25
        r101.f553401e = "global";     // Catch: Exception -> L25
        return r101;
    L17:
        if ("00000000-0000-0000-0000-000000000000".equals(r105) == true) goto L19;
        r106 = true;
    L25:
        e = move-exception;
        r101.f553399c = "honor error: " + e;
        r101.f553400d = SystemClock.elapsedRealtime() - r102;
        return r101;
    }

    public static c d(Context r100) {
        c r101 = new c();
        if (r100 != null) goto L6;
        r101.f553399c = "context is null";
        return r101;
    L6:
        long r102 = SystemClock.elapsedRealtime();
        String r103 = Settings.Global.getString(r100.getContentResolver(), "pps_oaid_c");     // Catch: Exception -> L24
        r101.f553398b = Boolean.parseBoolean(Settings.Global.getString(r100.getContentResolver(), "pps_track_limit"));     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r103) == false) goto L19;
        String r104 = Settings.Global.getString(r100.getContentResolver(), "pps_oaid");     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r104) == false) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L26;
        r101.f553397a = r104;     // Catch: Exception -> L24
        r101.f553400d = SystemClock.elapsedRealtime() - r102;     // Catch: Exception -> L24
        r101.f553401e = "pps_oaid";     // Catch: Exception -> L24
        return r101;
    L26:
        return r101;
    L12:
        if ("00000000-0000-0000-0000-000000000000".equals(r104) == true) goto L14;
        r105 = true;
        goto L15
    L19:
        if (r103.length() < 24) goto L22;
        r101.f553397a = a(r100, r103);     // Catch: Exception -> L24
        r101.f553400d = SystemClock.elapsedRealtime() - r102;     // Catch: Exception -> L24
        r101.f553401e = "pps_oaid_c";     // Catch: Exception -> L24
        return r101;
    L22:
        r101.f553399c = "oaid too short";     // Catch: Exception -> L24
        r101.f553401e = "pps_oaid_c";     // Catch: Exception -> L24
        r101.f553400d = SystemClock.elapsedRealtime() - r102;     // Catch: Exception -> L24
        return r101;
    L24:
        e = move-exception;
        r101.f553399c = "huawei error:" + e;
        r101.f553400d = SystemClock.elapsedRealtime() - r102;
        goto L26
    }

    public static Cursor e(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    public static String f(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }
}
