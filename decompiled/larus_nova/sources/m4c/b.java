package m4c;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.larksuite.framework.utils.d;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f511908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile m4c.a.C6771a f511909b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f511910a = null;

        static {
            f511910a = new b();
        }
    }

    public final m4c.a.C6771a b() throws GeneralSecurityException {
        if (this.f511909b != null) goto L5;
        c r100 = new c(new PolarisFileWrapper(c("aes_Key_lock")));
        RandomAccessFile r101 = r100.f511911a;     // Catch: Throwable -> L49
        if (r101 != null) goto L53;
    L14:
        boolean r102 = false;
        if (PreferenceManager.getDefaultSharedPreferences(LarkAppContext.inst().getContext()).getBoolean("encrypts_flagkPreference", false) == false) goto L31;
        if (this.f511908a.exists() == false) goto L31;
        if (TextUtils.isEmpty(d(this.f511908a)) == true) goto L31;
        com.ss.android.lark.seccache.impl.a.c();     // Catch: Throwable -> L49
        l4c.a r103 = l4c.b.a();     // Catch: Throwable -> L49
        PolarisFileWrapper r104 = this.f511908a;     // Catch: Throwable -> L49
        r103.getClass();     // Catch: Throwable -> L49
        boolean r105 = r103.a();     // Catch: Exception -> L23 KeyStoreException -> L28 Throwable -> L49
        r103.f507361d.getClass();     // Catch: Exception -> L23 KeyStoreException -> L28 Throwable -> L49
        byte[] r106 = com.ss.android.lark.seccache.impl.b.b(r104, r105);     // Catch: Exception -> L23 KeyStoreException -> L28 Throwable -> L49
    L25:
        this.f511909b = m4c.a.a(new String(r106));     // Catch: Throwable -> L49
        m4c.a.C6771a r107 = this.f511909b;     // Catch: Throwable -> L49
        r100.a();
        return r107;
    L28:
        e = move-exception;
        throw e;     // Catch: Throwable -> L49
    L23:
        e = move-exception;
        Log.e("SecCacheModule", e);     // Catch: Throwable -> L49
        r106 = new byte[0];     // Catch: Throwable -> L49
    L31:
        if (this.f511908a.exists() == false) goto L46;
        String r108 = d(this.f511908a);     // Catch: Throwable -> L49
        if (TextUtils.isEmpty(r108) == true) goto L46;
        int r109 = m4c.a.f511904a;     // Catch: Throwable -> L49
        if (r108.split(":").length != 2) goto L38;
        r102 = true;
    L38:
        if (r102 == false) goto L46;
        this.f511909b = m4c.a.a(r108);     // Catch: GeneralSecurityException -> L42 Throwable -> L44 Throwable -> L49
        m4c.a.C6771a r110 = this.f511909b;     // Catch: GeneralSecurityException -> L42 Throwable -> L44 Throwable -> L49
        r100.a();
        return r110;
    L44:
        e = move-exception;
        Log.e("AesKeyPreferenceHelper", "invalid aes key content, regenerate", e);     // Catch: Throwable -> L49
    L46:
        this.f511909b = a();     // Catch: Throwable -> L49
        e(this.f511908a, this.f511909b.toString());     // Catch: Throwable -> L49
        r100.a();
        return this.f511909b;
    L53:
        r100.f511912b = r101.getChannel().lock();     // Catch: Exception -> L12 Throwable -> L49
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r100.a();
        throw th;
    L5:
        return this.f511909b;
    }

    public b() {
        this.f511908a = new PolarisFileWrapper(c("kPreference"));
    }

    public static m4c.a.C6771a a() throws GeneralSecurityException {
        String r100 = LarkAppContext.inst().getContext().getPackageName();
        int r101 = m4c.a.f511904a;
        byte[] r102 = new byte[128];
        SecureRandom.getInstance("SHA1PRNG").nextBytes(r102);
        PBEKeySpec r103 = new PBEKeySpec(r100.toCharArray(), r102, 100, 384);
        byte[] r104 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(r103).getEncoded();
        byte[] r105 = new byte[16];
        System.arraycopy(r104, 0, r105, 0, 16);
        byte[] r106 = new byte[32];
        System.arraycopy(r104, 16, r106, 0, 32);
        return new m4c.a.C6771a(new SecretKeySpec(r105, CryptoConst.ALGORITHM_AES), new SecretKeySpec(r106, "HmacSHA256"));
    }

    public static String c(String r100) {
        File r101 = LarkAppContext.inst().getContext().getFilesDir();
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getAbsolutePath().concat(HTTP.URL_DEFAULT.concat(r100));
    }

    public static String d(PolarisFileWrapper r100) {
        PolarisFileReaderWrapper r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r100);     // Catch: Throwable -> L15 Exception -> L17
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L11 Exception -> L13
        char[] r104 = new char[128];     // Catch: Throwable -> L11 Exception -> L13
    L5:
        int r105 = r102.read(r104);     // Catch: Throwable -> L11 Exception -> L13
        if (r105 == (-1)) goto L8;
        r103.append(r104, 0, r105);     // Catch: Throwable -> L11 Exception -> L13
        goto L5
    L8:
        String r106 = r103.toString();     // Catch: Throwable -> L11 Exception -> L13
        d.b(new Closeable[]{r102});
        return r106;
    L13:
        e = e;
    L19:
        Log.e("AesKeyPreferenceHelper", "read content failed", e);     // Catch: Throwable -> L11
        d.b(new Closeable[]{r102});
        return null;
    L11:
        th = th;
        r101 = r102;
    L22:
        d.b(new Closeable[]{r101});
        throw th;
    L17:
        e = e;
        r102 = null;
    L15:
        th = th;
        goto L22
    }

    public static void e(PolarisFileWrapper r100, String r101) {
        PolarisFileWriterWrapper r102 = null;
        PolarisFileWriterWrapper r103 = new PolarisFileWriterWrapper(r100);     // Catch: Throwable -> L10 IOException -> L12
        r103.write(r101);     // Catch: Throwable -> L6 IOException -> L8
        r103.flush();     // Catch: Throwable -> L6 IOException -> L8
        d.b(new Closeable[]{r103});
    L19:
        return;
    L8:
        e = e;
        r102 = r103;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L10
        d.b(new Closeable[]{r102});
    L6:
        th = th;
    L17:
        d.b(new Closeable[]{r103});
        throw th;
    L10:
        th = th;
        r103 = r102;
    L12:
        e = e;
        goto L13
    }
}
