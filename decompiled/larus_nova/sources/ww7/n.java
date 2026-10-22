package ww7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile w f561682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f561683b = null;

    static {
        f561683b = new n();
    }

    public n() {
    }

    public final synchronized String b(Context r100) {
        monitor-enter(this);
    L49:
        th = move-exception;
        throw th;
    L4:
        if (f561682a != null) goto L6;
        f561682a = new w(r100);     // Catch: Throwable -> L49
    L6:
        String r101 = "";
        SharedPreferences r102 = f561682a.f561721a;     // Catch: Throwable -> L49
        boolean r103 = true;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L47;
        SharedPreferences r105 = f561682a.f561721a;     // Catch: Throwable -> L49
        if (r105 != null) goto L16;
    L18:
        r103 = false;
    L19:
        if (r103 == false) goto L46;
        SharedPreferences r106 = f561682a.f561721a;     // Catch: Throwable -> L49
        if (r106 == null) goto L23;
        String r107 = r106.getString("key_push_token", "");     // Catch: Throwable -> L49
    L24:
        SharedPreferences r108 = f561682a.f561721a;     // Catch: Throwable -> L49
        if (r108 == null) goto L27;
        String r109 = r108.getString("key_aes_gcm", "");     // Catch: Throwable -> L49
    L28:
        byte[] r110 = Base64.decode(r109, 0);     // Catch: Throwable -> L49
        String r111 = "";
        if (TextUtils.isEmpty(r107) == true) goto L43;
        if (r110 == null) goto L43;
        if (r110.length < 16) goto L43;
        SecretKeySpec r112 = new SecretKeySpec(r110, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L40 Throwable -> L49
        Cipher r113 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L40 Throwable -> L49
        String r114 = r107.substring(0, 24);     // Catch: Exception -> L40 Throwable -> L49
        String r115 = r107.substring(24);     // Catch: Exception -> L40 Throwable -> L49
        if (TextUtils.isEmpty(r114) == true) goto L43;
        if (TextUtils.isEmpty(r115) == true) goto L43;
        r113.init(2, r112, new GCMParameterSpec(128, i.i(r114)));     // Catch: Exception -> L40 Throwable -> L49
        r111 = new String(r113.doFinal(i.i(r115)), StandardCharsets.UTF_8);     // Catch: Exception -> L40 Throwable -> L49
        goto L43
    L40:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L49
    L43:
        if (TextUtils.isEmpty(r111) == true) goto L45;
        r101 = r111;
        goto L47
    L45:
        f561682a.a("key_aes_gcm");     // Catch: Throwable -> L49
        f561682a.a("key_push_token");     // Catch: Throwable -> L49
        goto L47
    L27:
        r109 = "";
        goto L28
    L23:
        r107 = "";
        goto L24
    L46:
        f561682a.a("key_push_token");     // Catch: Throwable -> L49
        goto L47
    L16:
        if (r105.contains("key_aes_gcm") == false) goto L18;
    L47:
        monitor-exit(this);
        return r101;
    L9:
        if (r102.contains("key_push_token") == false) goto L11;
        r104 = true;
        goto L12
    }

    public final synchronized void a(Context r110, String r111) {
        monitor-enter(this);
    L61:
        th = move-exception;
        throw th;
    L4:
        if (f561682a != null) goto L7;
        f561682a = new w(r110);     // Catch: Throwable -> L61
    L7:
        if (TextUtils.isEmpty(r111) == false) goto L9;
        f561682a.a("key_push_token");     // Catch: Throwable -> L61
    L59:
        monitor-exit(this);
        return;
    L9:
        String r112 = i.d(r110, r110.getPackageName());     // Catch: Throwable -> L61
        byte[] r100 = i.i("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22");     // Catch: Throwable -> L61
        byte[] r113 = i.i(r112);     // Catch: Throwable -> L61
        byte[] r101 = new byte[32];     // Catch: Exception -> L13 Throwable -> L61
        new SecureRandom().nextBytes(r101);     // Catch: Exception -> L13 Throwable -> L61
    L14:
        int r102 = 0;
    L16:
        if (r102 >= r100.length) goto L18;
        r100[r102] = (byte) (r100[r102] << 4);     // Catch: Throwable -> L61
        r102 = r102 + 1;     // Catch: Throwable -> L61
        goto L16
    L18:
        int r103 = r100.length;     // Catch: Throwable -> L61
        byte[] r104 = null;
        if (r113.length == r103) goto L21;
        byte[] r105 = null;
    L24:
        if (r105 == null) goto L30;
        int r114 = 0;
    L28:
        if (r114 >= r105.length) goto L30;
        r105[r114] = (byte) (r105[r114] >> 6);     // Catch: Throwable -> L61
        r114 = r114 + 1;     // Catch: Throwable -> L61
    L30:
        if (r105 == null) goto L37;
        int r115 = r105.length;     // Catch: Throwable -> L61
        if (r101.length != r115) goto L37;
        r104 = new byte[r115];     // Catch: Throwable -> L61
        int r106 = 0;
    L35:
        if (r106 >= r115) goto L37;
        r104[r106] = (byte) (r105[r106] ^ r101[r106]);     // Catch: Throwable -> L61
        r106 = r106 + 1;     // Catch: Throwable -> L61
    L37:
        String r116 = Base64.encodeToString(r104, 0);     // Catch: Throwable -> L61
        boolean r107 = f561682a.b("key_aes_gcm", r116);     // Catch: Throwable -> L61
        byte[] r117 = Base64.decode(r116, 0);     // Catch: Throwable -> L61
        String r108 = "";
        if (TextUtils.isEmpty(r111) == true) goto L55;
        if (r117 == null) goto L55;
        if (r117.length < 16) goto L55;
        byte[] r109 = new byte[12];     // Catch: Exception -> L46 Throwable -> L61
        new SecureRandom().nextBytes(r109);     // Catch: Exception -> L46 Throwable -> L61
    L47:
        byte[] r118 = r111.getBytes(StandardCharsets.UTF_8);     // Catch: GeneralSecurityException -> L53 Throwable -> L61
        SecretKeySpec r119 = new SecretKeySpec(r117, CryptoConst.ALGORITHM_AES);     // Catch: GeneralSecurityException -> L53 Throwable -> L61
        Cipher r120 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: GeneralSecurityException -> L53 Throwable -> L61
        r120.init(1, r119, new GCMParameterSpec(128, r109));     // Catch: GeneralSecurityException -> L53 Throwable -> L61
        byte[] r121 = r120.doFinal(r118);     // Catch: GeneralSecurityException -> L53 Throwable -> L61
        if (r121 == null) goto L55;
        if (r121.length == 0) goto L55;
        r108 = i.e(r109) + i.e(r121);     // Catch: GeneralSecurityException -> L53 Throwable -> L61
    L46:
        r109 = new byte[0];     // Catch: GeneralSecurityException -> L53 Throwable -> L61
    L53:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L61
    L55:
        if (r107 == false) goto L59;
        if (TextUtils.isEmpty(r108) == true) goto L59;
        f561682a.b("key_push_token", r108);     // Catch: Throwable -> L61
        goto L59
    L21:
        r105 = new byte[r103];     // Catch: Throwable -> L61
        int r122 = 0;
    L22:
        if (r122 >= r103) goto L24;
        r105[r122] = (byte) (r100[r122] ^ r113[r122]);     // Catch: Throwable -> L61
        r122 = r122 + 1;     // Catch: Throwable -> L61
        goto L22
    L13:
        r101 = new byte[0];     // Catch: Throwable -> L61
        goto L14
    }
}
