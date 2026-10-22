package nx3;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static final List<String> b = null;
    public static final String[] c = null;
    public static final String[] d = null;
    public static final String[] e = null;
    public final com.bytedance.applog.b a;

    public static String[] e() {
        KeyGenerator r1 = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L8
        SecureRandom r2 = new SecureRandom();     // Catch: Throwable -> L8
        r1.init(128, r2);     // Catch: Throwable -> L8
        byte[] r3 = new byte[8];     // Catch: Throwable -> L8
        r2.nextBytes(r3);     // Catch: Throwable -> L8
        String[] r0 = {a(r1.generateKey().getEncoded()), a(r3)};     // Catch: Throwable -> L8
        if (g(r0) == false) goto L6;
        return r0;
    L6:
        return null;
    L11:
        return null;
    }

    static {
        b = Collections.singletonList("EncryptUtils");
        c = new String[]{"aid", "app_version", "tt_data", "device_id"};
        d = new String[]{"aid", "version_code", "ab_version", "iid", "device_platform", "device_id", "app_log_priority"};
        e = new String[]{"tt_data", "device_platform"};
    }

    public d(com.bytedance.applog.b r1) {
        this.a = r1;
    }

    public static String a(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r5 == null) goto L11;
        if (r1 >= r5.length) goto L11;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L9;
        r0.append('0');
    L9:
        r0.append(r2);
        r1 = r1 + 1;
    L11:
        return r0.toString();
    }

    public static byte[] f(byte[] r5) {
        GZIPInputStream r1 = null;
        if (r5.length > 0) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        ByteArrayInputStream r2 = new ByteArrayInputStream(r5);     // Catch: Throwable -> L22 IOException -> L31
    L57:
        GZIPInputStream r6 = new GZIPInputStream(r2);     // Catch: Throwable -> L19 IOException -> L21
        goto L32
    L53:
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L16 IOException -> L18
    L10:
        int r4 = r6.read(r3);     // Catch: Throwable -> L16 IOException -> L18
        if (r4 < 0) goto L49;
        r0.write(r3, 0, r4);     // Catch: Throwable -> L16 IOException -> L18
    L49:
        r6.close();     // Catch: IOException -> L40
    L47:
        r2.close();     // Catch: IOException -> L41
    L39:
        return r0.toByteArray();
    L18:
        r1 = r6;
    L16:
        Throwable th = th;
        r1 = r6;
    L24:
        if (r1 != null) goto L51;
    L28:
        if (r2 == null) goto L60;
        r2.close();     // Catch: IOException -> L42
        throw th;
    L61:
        throw th;
    L60:
        throw th;
    L51:
        r1.close();     // Catch: IOException -> L27
    L19:
        th = move-exception;
        th = th;
    L32:
        if (r1 != null) goto L43;
    L36:
        if (r2 == null) goto L39;
    L43:
        r1.close();     // Catch: IOException -> L35
    L31:
        r2 = null;
    L22:
        th = move-exception;
        th = th;
        r2 = null;
        goto L24
    }

    public static boolean g(String[] r3) {
        if (r3 != null) goto L5;
    L16:
        return false;
    L5:
        if (r3.length != 2) goto L16;
        if (TextUtils.isEmpty(r3[0]) == true) goto L16;
        if (r3[0].length() != 32) goto L16;
        if (TextUtils.isEmpty(r3[1]) == true) goto L16;
        if (r3[1].length() != 16) goto L16;
        return true;
    }

    public final byte[] c(byte[] r4) {
        if (r4 != null) goto L6;
        return new byte[0];
    L6:
        if (this.a.v == true) goto L8;
    L13:
        return r4;
    L8:
        if (this.a.getInitConfig() == null) goto L10;
        this.a.getInitConfig().getClass();
    L10:
        r4 = EncryptorUtil.b(r4, r4.length);
        if (r4 != null) goto L13;
        this.a.W.b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);
        goto L13
    }

    public final String d(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return r9;
    L6:
        if (this.a.v == true) goto L8;
        return r9;
    L8:
        Uri r10 = UriProtector.parse(r9);
        String r0 = r10.getQuery();
        ArrayList r1 = new ArrayList();
        String[] r2 = c;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        String r5 = r2[r4];
        String r6 = UriProtector.getQueryParameter(r10, r5);
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r1.add(new Pair(r5, r6));
    L13:
        r4 = r4 + 1;
        goto L9
    L14:
        Uri.Builder r11 = r10.buildUpon();
        r11.clearQuery();
        Iterator r7 = r1.iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        Pair r8 = (Pair) r7.next();
        r11.appendQueryParameter((String) r8.first, (String) r8.second);
        goto L16
    L18:
        r11.appendQueryParameter("tt_info", new String(Base64.encode(h(r0), 8)));
        return r11.build().toString();
    }

    public final byte[] h(String r7) {
        GZIPOutputStream r1 = null;
        byte[] r8 = r7.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L5
    L8:
        if (this.a.v == false) goto L28;
        if (r8 != null) goto L11;
        r8 = new byte[0];
        goto L28
    L11:
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r3 = new GZIPOutputStream(r2);     // Catch: Throwable -> L18
        r3.write(r8);     // Catch: Throwable -> L16
        r3.close();     // Catch: IOException -> L29
    L41:
    L16:
        th = th;
        r1 = r3;
    L31:
        n.w().s(b, "gzip write failed", th, new Object[0]);     // Catch: Throwable -> L23
        if (r1 == null) goto L22;
        r1.close();     // Catch: IOException -> L29
    L23:
        th = move-exception;
        if (r1 != null) goto L33;
    L26:
        throw th;
    L33:
        r1.close();     // Catch: IOException -> L30
    L18:
        th = th;
    L22:
        r8 = r2.toByteArray();
    L28:
        return c(r8);
    L5:
        e = move-exception;
        this.a.t0.s(b, "get bytes failed", e, new Object[0]);
        r8 = null;
        goto L8
    }

    public static byte[] b(byte[] r7, String r8, String r9) {
        Cipher r1 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L11
        int r3 = r8.length();     // Catch: Throwable -> L11
        byte[] r4 = new byte[r3];     // Catch: Throwable -> L11
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L6;
        r4[r5] = (byte) r8.charAt(r5);     // Catch: Throwable -> L11
        r5 = r5 + 1;     // Catch: Throwable -> L11
        goto L4
    L6:
        SecretKeySpec r2 = new SecretKeySpec(r4, "AES");     // Catch: Throwable -> L11
        int r6 = r9.length();     // Catch: Throwable -> L11
        byte[] r10 = new byte[r6];     // Catch: Throwable -> L11
        int r11 = 0;
    L7:
        if (r11 >= r6) goto L9;
        r10[r11] = (byte) r9.charAt(r11);     // Catch: Throwable -> L11
        r11 = r11 + 1;     // Catch: Throwable -> L11
        goto L7
    L9:
        r1.init(2, r2, new IvParameterSpec(r10));     // Catch: Throwable -> L11
        return r1.doFinal(r7);
    L11:
        th = move-exception;
        n.w().s(b, "Cannot decrypt aes cbc", th, new Object[0]);
        return null;
    }
}
