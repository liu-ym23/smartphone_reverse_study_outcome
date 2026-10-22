package com.ss.android.lark.chat.utils;

/* JADX INFO: loaded from: classes35.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f416736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f416737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f416738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f416739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f416740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f416741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f416742g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f416743a = null;

        static {
            f416743a = new u();
        }
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();

        void b();

        void c();

        void d(int[] r100);

        a1 e(boolean r100);
    }

    public final void a() {
        this.f416738c = false;
        this.f416739d = false;
        this.f416740e = false;
        this.f416741f = false;
        this.f416742g = 0;
        c();
        monitor-enter(this);
        this.f416737b = null;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        c r100 = this.f416736a;     // Catch: Throwable -> L10
        if (r100 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r100.a();     // Catch: Throwable -> L10
        this.f416736a = null;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void e() {
        monitor-enter(this);
        b r100 = this.f416737b;     // Catch: Throwable -> L10
        if (r100 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r100.a();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public u() {
        this.f416738c = false;
        this.f416739d = false;
        this.f416740e = false;
        this.f416741f = false;
        this.f416742g = 0;
    }

    public final synchronized a1 b(boolean r100) {
        monitor-enter(this);
        c r101 = this.f416736a;     // Catch: Throwable -> L14
        if (r101 != null) goto L6;
    L11:
        monitor-exit(this);
        return null;
    L6:
        if (this.f416738c == false) goto L11;
        a1 r102 = r101.e(r100);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r102;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(b r100) {
        monitor-enter(this);
        this.f416737b = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
