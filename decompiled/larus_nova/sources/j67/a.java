package j67;

import android.content.Context;
import android.os.Bundle;
import com.aiassistant.security.keymanager.KeyManager;
import com.aiassistant.security.keymanager.KeyManagerResult;
import com.aiassistant.security.secretdata.AddResult;
import com.aiassistant.security.secretdata.QueryResult;
import com.aiassistant.security.secretdata.SecretData;
import com.aiassistant.security.secretdata.SecretDataManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f497527a;

    /* JADX INFO: renamed from: j67.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static final class C6396a implements b {
        @Override // j67.a.b
        public final void a() {
        }

        @Override // j67.a.b
        public final void b() {
        }

        @Override // j67.a.b
        public final void c() {
        }

        @Override // j67.a.b
        public final void d() {
        }

        @Override // j67.a.b
        public final void e() {
        }

        @Override // j67.a.b
        public final void f() {
        }

        @Override // j67.a.b
        public final void g() {
        }

        @Override // j67.a.b
        public final void i() {
        }

        @Override // j67.a.b
        public final void j() {
        }

        @Override // j67.a.b
        public final void k() {
        }

        @Override // j67.a.b
        public final void keyAlgorithmEcc() {
        }

        @Override // j67.a.b
        public final void kmSuccess() {
        }

        @Override // j67.a.b
        public final String l() {
            return "com.aiassistant.security";
        }

        @Override // j67.a.b
        public final void o() {
        }

        @Override // j67.a.b
        public final void p() {
        }

        @Override // j67.a.b
        public final void purposeAttestKey() {
        }

        @Override // j67.a.b
        public final void q() {
        }

        @Override // j67.a.b
        public final void r() {
        }

        @Override // j67.a.b
        public final void s() {
        }

        @Override // j67.a.b
        public final void u() {
        }

        public C6396a() {
        }

        @Override // j67.a.b
        public final int deleteKey(Context r100, String r101, Bundle r102) {
            return KeyManager.getInstance().deleteKey(r100, r101, r102);
        L4:
            k67.b.b("SecurityFrameworkCompat", "deleteKey failed");
            return -1;
        }

        @Override // j67.a.b
        public final int generateKeyPair(Context r100, String r101, Bundle r102) {
            return KeyManager.getInstance().generateKeyPair(r100, r101, r102);
        L4:
            k67.b.b("SecurityFrameworkCompat", "generateKeyPair failed");
            return -1;
        }

        @Override // j67.a.b
        public final c keyAttestation(Context r100, String r101, Bundle r102) {
            KeyManagerResult r103 = KeyManager.getInstance().keyAttestation(r100, r101, r102);     // Catch: Throwable -> L8
            if (r103 != null) goto L7;
            return c.a();
        L7:
            return new c(r103.getResultCode(), r103.getCertChain(), r103.getOutData());
        L8:
            k67.b.b("SecurityFrameworkCompat", "keyAttestation failed");
            return c.a();
        }

        @Override // j67.a.b
        public final int m(Context r100, String r101, Bundle r102) {
            return SecretDataManager.getInstance().deleteData(r100, r101, r102);
        L4:
            k67.b.b("SecurityFrameworkCompat", "SecretDataManager.deleteData failed");
            return -1;
        }

        @Override // j67.a.b
        public final c n(Context r100, byte[] r101, Bundle r102) {
            KeyManagerResult r103 = KeyManager.getInstance().sign(r100, "pcc_sign_key", r101, r102);     // Catch: Throwable -> L9
            if (r103 != null) goto L8;
            return c.a();
        L8:
            return new c(r103.getResultCode(), r103.getCertChain(), r103.getOutData());
        L9:
            k67.b.b("SecurityFrameworkCompat", "sign failed");
            return c.a();
        }

        @Override // j67.a.b
        public final e t(Context r100, String r101, Bundle r102) {
            QueryResult r103 = SecretDataManager.getInstance().queryData(r100, r101, r102);     // Catch: Throwable -> L17
            if (r103 == null) goto L6;
            List<SecretData> r104 = r103.getDataList();     // Catch: Throwable -> L17
            if (r104 != null) goto L10;
        L14:
            String r105 = null;
        L16:
            return new e(false, r103.getResultCode(), r105);
        L10:
            if (r104.isEmpty() == true) goto L14;
            SecretData r106 = (SecretData) ListProtector.get(r104, 0);     // Catch: Throwable -> L17
            if (r106 == null) goto L14;
            r105 = r106.privateData;     // Catch: Throwable -> L17
            goto L16
        L6:
            return new e(true, -1, null);
        L17:
            k67.b.b("SecurityFrameworkCompat", "SecretDataManager.queryData failed");
            return new e(true, -1, null);
        }

        @Override // j67.a.b
        public final int h(Context r100, String r101, String r102, String r103, String r104, Bundle r105) {
            SecretData r106 = new SecretData();     // Catch: Throwable -> L7
            r106.privateData = r101;     // Catch: Throwable -> L7
            r106.associate = r102;     // Catch: Throwable -> L7
            r106.alias = r103;     // Catch: Throwable -> L7
            r106.dataType = r104;     // Catch: Throwable -> L7
            AddResult r107 = SecretDataManager.getInstance().addData(r100, r106, r105);     // Catch: Throwable -> L7
            if (r107 == null) goto L11;
            return r107.getResultCode();
        L11:
            return -1;
        L7:
            k67.b.b("SecurityFrameworkCompat", "SecretDataManager.addData failed");
            return -1;
        }
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();

        int deleteKey(Context r100, String r101, Bundle r102);

        void e();

        void f();

        void g();

        int generateKeyPair(Context r100, String r101, Bundle r102);

        int h(Context r100, String r101, String r102, String r103, String r104, Bundle r105);

        void i();

        void j();

        void k();

        void keyAlgorithmEcc();

        c keyAttestation(Context r100, String r101, Bundle r102);

        void kmSuccess();

        String l();

        int m(Context r100, String r101, Bundle r102);

        c n(Context r100, byte[] r101, Bundle r102);

        void o();

        void p();

        void purposeAttestKey();

        void q();

        void r();

        void s();

        e t(Context r100, String r101, Bundle r102);

        void u();
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f497528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Certificate> f497529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f497530c;

        public static c a() {
            return new c(-1, Collections.emptyList(), null);
        }

        public c(int r100, List r101, byte[] r102) {
            this.f497528a = r100;
            if (r101 != null) goto L6;
            r101 = Collections.emptyList();
        L6:
            this.f497529b = r101;
            this.f497530c = r102;
        }
    }

    public static final class d implements b {
        @Override // j67.a.b
        public final void a() {
        }

        @Override // j67.a.b
        public final void b() {
        }

        @Override // j67.a.b
        public final void c() {
        }

        @Override // j67.a.b
        public final void d() {
        }

        @Override // j67.a.b
        public final void e() {
        }

        @Override // j67.a.b
        public final void f() {
        }

        @Override // j67.a.b
        public final void g() {
        }

        @Override // j67.a.b
        public final void i() {
        }

        @Override // j67.a.b
        public final void j() {
        }

        @Override // j67.a.b
        public final void k() {
        }

        @Override // j67.a.b
        public final void keyAlgorithmEcc() {
        }

        @Override // j67.a.b
        public final void kmSuccess() {
        }

        @Override // j67.a.b
        public final String l() {
            return "com.obric.security";
        }

        @Override // j67.a.b
        public final void o() {
        }

        @Override // j67.a.b
        public final void p() {
        }

        @Override // j67.a.b
        public final void purposeAttestKey() {
        }

        @Override // j67.a.b
        public final void q() {
        }

        @Override // j67.a.b
        public final void r() {
        }

        @Override // j67.a.b
        public final void s() {
        }

        @Override // j67.a.b
        public final void u() {
        }

        public d() {
        }

        @Override // j67.a.b
        public final int deleteKey(Context r100, String r101, Bundle r102) {
            return com.obric.security.keymanager.KeyManager.getInstance().deleteKey(r100, r101, r102);
        L4:
            k67.b.b("SecurityFrameworkCompat", "deleteKey failed");
            return -1;
        }

        @Override // j67.a.b
        public final int generateKeyPair(Context r100, String r101, Bundle r102) {
            return com.obric.security.keymanager.KeyManager.getInstance().generateKeyPair(r100, r101, r102);
        L4:
            k67.b.b("SecurityFrameworkCompat", "generateKeyPair failed");
            return -1;
        }

        @Override // j67.a.b
        public final c keyAttestation(Context r100, String r101, Bundle r102) {
            com.obric.security.keymanager.KeyManagerResult r103 = com.obric.security.keymanager.KeyManager.getInstance().keyAttestation(r100, r101, r102);     // Catch: Throwable -> L8
            if (r103 != null) goto L7;
            return c.a();
        L7:
            return new c(r103.getResultCode(), r103.getCertChain(), r103.getOutData());
        L8:
            k67.b.b("SecurityFrameworkCompat", "keyAttestation failed");
            return c.a();
        }

        @Override // j67.a.b
        public final int m(Context r100, String r101, Bundle r102) {
            return com.obric.security.secretdata.SecretDataManager.getInstance().deleteData(r100, r101, r102);
        L4:
            k67.b.b("SecurityFrameworkCompat", "SecretDataManager.deleteData failed");
            return -1;
        }

        @Override // j67.a.b
        public final c n(Context r100, byte[] r101, Bundle r102) {
            com.obric.security.keymanager.KeyManagerResult r103 = com.obric.security.keymanager.KeyManager.getInstance().sign(r100, "pcc_sign_key", r101, r102);     // Catch: Throwable -> L9
            if (r103 != null) goto L8;
            return c.a();
        L8:
            return new c(r103.getResultCode(), r103.getCertChain(), r103.getOutData());
        L9:
            k67.b.b("SecurityFrameworkCompat", "sign failed");
            return c.a();
        }

        @Override // j67.a.b
        public final e t(Context r100, String r101, Bundle r102) {
            com.obric.security.secretdata.QueryResult r103 = com.obric.security.secretdata.SecretDataManager.getInstance().queryData(r100, r101, r102);     // Catch: Throwable -> L17
            if (r103 == null) goto L6;
            List<com.obric.security.secretdata.SecretData> r104 = r103.getDataList();     // Catch: Throwable -> L17
            if (r104 != null) goto L10;
        L14:
            String r105 = null;
        L16:
            return new e(false, r103.getResultCode(), r105);
        L10:
            if (r104.isEmpty() == true) goto L14;
            com.obric.security.secretdata.SecretData r106 = (com.obric.security.secretdata.SecretData) ListProtector.get(r104, 0);     // Catch: Throwable -> L17
            if (r106 == null) goto L14;
            r105 = r106.privateData;     // Catch: Throwable -> L17
            goto L16
        L6:
            return new e(true, -1, null);
        L17:
            k67.b.b("SecurityFrameworkCompat", "SecretDataManager.queryData failed");
            return new e(true, -1, null);
        }

        @Override // j67.a.b
        public final int h(Context r100, String r101, String r102, String r103, String r104, Bundle r105) {
            com.obric.security.secretdata.SecretData r106 = new com.obric.security.secretdata.SecretData();     // Catch: Throwable -> L7
            r106.privateData = r101;     // Catch: Throwable -> L7
            r106.associate = r102;     // Catch: Throwable -> L7
            r106.alias = r103;     // Catch: Throwable -> L7
            r106.dataType = r104;     // Catch: Throwable -> L7
            com.obric.security.secretdata.AddResult r107 = com.obric.security.secretdata.SecretDataManager.getInstance().addData(r100, r106, r105);     // Catch: Throwable -> L7
            if (r107 == null) goto L11;
            return r107.getResultCode();
        L11:
            return -1;
        L7:
            k67.b.b("SecurityFrameworkCompat", "SecretDataManager.addData failed");
            return -1;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f497531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f497532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f497533c;

        public e(boolean r100, int r101, String r102) {
            this.f497531a = r100;
            this.f497532b = r101;
            this.f497533c = r102;
        }
    }

    public a() {
    }

    public static b b() {
        b r100 = f497527a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        monitor-enter(a.class);
        b r101 = f497527a;     // Catch: Throwable -> L31
        if (r101 == null) goto L12;
        monitor-exit(a.class);     // Catch: Throwable -> L31
        return r101;
    L12:
        boolean r102 = false;
        a("com.obric.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L15 Throwable -> L31
        boolean r103 = true;
    L36:
        a("com.aiassistant.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L20 Throwable -> L31
        r102 = true;
    L22:
        if (r103 == false) goto L24;
        b r104 = new d();     // Catch: Throwable -> L31
    L26:
        f497527a = r104;     // Catch: Throwable -> L31
        k67.b.e("SecurityFrameworkCompat", "Using security framework package: " + r104.l());     // Catch: Throwable -> L31
        monitor-exit(a.class);     // Catch: Throwable -> L31
        return r104;
    L24:
        if (r102 == false) goto L29;
        r104 = new C6396a();     // Catch: Throwable -> L31
        goto L26
    L29:
        k67.b.c("SecurityFrameworkCompat", "No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L31
        throw new IllegalStateException("No supported security framework found. Tried: com.obric.security.secretdata.SecretDataManager, com.aiassistant.security.secretdata.SecretDataManager");     // Catch: Throwable -> L31
    L20:
        e = move-exception;
        k67.b.c("SecurityFrameworkCompat", "Class not found:" + e);     // Catch: Throwable -> L31
        goto L22
    L15:
        e = move-exception;
        k67.b.c("SecurityFrameworkCompat", "Class not found:" + e);     // Catch: Throwable -> L31
        r103 = false;
    L31:
        th = move-exception;
        throw th;
    }

    public static int c() {
        b().kmSuccess();
        return 0;
    }

    public static String e() {
        b().b();
        return "query_mode";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static void a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName(r100, false, null);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class.forName(r100, false, null);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName(r100);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public static e d(Context r100, String r101, Bundle r102) {
        return b().t(r100, r101, r102);
    }
}
