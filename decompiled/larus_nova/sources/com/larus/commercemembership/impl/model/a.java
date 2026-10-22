package com.larus.commercemembership.impl.model;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C4176a f325875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f325876b;

    /* JADX INFO: renamed from: com.larus.commercemembership.impl.model.a$a, reason: collision with other inner class name */
    public static final class C4176a {
        public final void a() {
            if (a.f325876b != null) goto L13;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (a.f325876b != null) goto L8;
            a.f325876b = new a();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return;
        }

        public C4176a() {
        }
    }

    static {
        f325875a = new C4176a();
    }

    public a() {
    }
}
