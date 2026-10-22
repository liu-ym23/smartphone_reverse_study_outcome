package com.ss.android.lark.widget.richtext;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f448310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f448311b;

    public static f a() {
        if (f448310a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f448310a != null) goto L9;
        f448310a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f448310a;
    }

    public f() {
    }
}
