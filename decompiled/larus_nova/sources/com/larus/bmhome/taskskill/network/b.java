package com.larus.bmhome.taskskill.network;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f314373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f314374b;

    public static final class a {
        public final void a() {
            if (b.f314374b != null) goto L13;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (b.f314374b != null) goto L8;
            b.f314374b = new b();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return;
        }

        public a() {
        }
    }

    static {
        f314373a = new a();
    }

    public b() {
    }
}
