package com.larus.commercecredit.impl.model;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C4173a f325719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f325720b;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.model.a$a, reason: collision with other inner class name */
    public static final class C4173a {
        public final void a() {
            if (a.f325720b != null) goto L13;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (a.f325720b != null) goto L8;
            a.f325720b = new a();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return;
        }

        public C4173a() {
        }
    }

    static {
        f325719a = new C4173a();
    }

    public a() {
    }
}
