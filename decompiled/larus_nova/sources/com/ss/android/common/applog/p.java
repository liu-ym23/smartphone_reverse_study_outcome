package com.ss.android.common.applog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes6.dex */
public final class p implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile p f408199b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<o> f408200a;

    public static p b() {
        if (f408199b != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f408199b != null) goto L9;
        f408199b = new p();     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
    L15:
        return f408199b;
    }

    public p() {
        this.f408200a = new CopyOnWriteArraySet();
    }

    @Override // com.ss.android.common.applog.o
    public final void a(String r100, long r101, boolean r102) {
        Iterator<o> r103 = this.f408200a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        r103.next().a(r100, r101, r102);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L4
    }
}
