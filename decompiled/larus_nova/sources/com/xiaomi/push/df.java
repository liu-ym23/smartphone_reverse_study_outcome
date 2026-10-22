package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public class df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile df f463335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private de f379a;

    public df() {
    }

    public static df a() {
        if (f463335a != null) goto L15;
        monitor-enter(df.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463335a != null) goto L9;
        f463335a = new df();     // Catch: Throwable -> L11
    L9:
        monitor-exit(df.class);     // Catch: Throwable -> L11
    L15:
        return f463335a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public de m8937a() {
        return this.f379a;
    }

    public void a(de r100) {
        this.f379a = r100;
    }
}
