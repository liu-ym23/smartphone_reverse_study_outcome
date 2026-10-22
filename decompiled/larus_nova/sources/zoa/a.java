package zoa;

import java.security.KeyStore;
import xoa.b;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static KeyStore f573163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f573164c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C8484a f573165a;

    /* JADX INFO: renamed from: zoa.a$a, reason: collision with other inner class name */
    public class C8484a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f573166a;

        public C8484a(a r100) {
            this.f573166a = r100;
        }
    }

    public static synchronized void a() {
        monitor-enter(a.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f573164c == null) goto L8;
        monitor-exit(a.class);
        return;
    L8:
        apa.a.a("AzerothKeyStore", "init");     // Catch: Throwable -> L16
        KeyStore r100 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L11 Throwable -> L16
        r100.load(null);     // Catch: Exception -> L11 Throwable -> L16
        f573163b = r100;     // Catch: Exception -> L11 Throwable -> L16
        apa.a.a("AzerothKeyStore", "AndroidKeyStore init success");     // Catch: Exception -> L11 Throwable -> L16
    L13:
        f573164c = new a();     // Catch: Throwable -> L16
        monitor-exit(a.class);
        return;
    L11:
        e = move-exception;
        b r101 = xoa.a.f564690a;     // Catch: Throwable -> L16
        xoa.a.a(e, "AndroidKeyStore init fail", fpa.a.a());     // Catch: Throwable -> L16
        goto L13
    }

    public a() {
        this.f573165a = new C8484a(this);
    }
}
