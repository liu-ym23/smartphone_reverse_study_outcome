package com.ss.android.lark.widget.linked_emojicon.widget;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f446457a;

    public static f a() {
        if (f446457a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f446457a != null) goto L9;
        f446457a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f446457a;
    }

    public f() {
    }
}
