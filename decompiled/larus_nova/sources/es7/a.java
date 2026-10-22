package es7;

import com.douyin.janna.api.CapabilityType;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f473774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f473775b;

    /* JADX INFO: renamed from: es7.a$a, reason: collision with other inner class name */
    public static class C5812a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f473776a = null;

        static {
            f473776a = new a();
        }
    }

    public a() {
        this.f473774a = false;
        if (b.f473777c == null) goto L5;
    L16:
        b r100 = b.f473777c;
    L17:
        this.f473775b = r100;
        return;
    L5:
        monitor-enter(b.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (b.f473777c != null) goto L11;
        b.f473777c = new b();     // Catch: Throwable -> L13
        r100 = b.f473777c;     // Catch: Throwable -> L13
        monitor-exit(b.class);     // Catch: Throwable -> L13
        goto L17
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L13
        goto L16
    }

    public final boolean a(CapabilityType r100) {
        if (this.f473774a == true) goto L5;
        return false;
    L5:
        com.douyin.janna.platform.a r101 = this.f473775b.f473779b;
        if (r101 != null) goto L9;
        return false;
    L9:
        return r101.d(r100);
    }
}
