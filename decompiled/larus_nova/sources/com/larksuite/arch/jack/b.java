package com.larksuite.arch.jack;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<c> f282794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f282795b;

    @Override // com.larksuite.arch.jack.c
    public final void dispose() {
        if (this.f282795b == true) goto L23;
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (this.f282795b == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        this.f282795b = true;     // Catch: Throwable -> L20
        Set<c> r100 = this.f282794a;     // Catch: Throwable -> L20
        if (r100 == null) goto L17;
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L20
    L15:
        if (r101.hasNext() == false) goto L17;
        ((c) r101.next()).dispose();     // Catch: Throwable -> L20
    L17:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    }

    public b() {
        this.f282794a = Collections.synchronizedSet(new LinkedHashSet());
    }

    public final boolean delete(c r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        if (this.f282795b == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.f282795b == false) goto L11;
        monitor-exit(this);
        return false;
    L11:
        if (this.f282794a.remove(r100) == true) goto L14;
        monitor-exit(this);
        return false;
    L14:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return true;
    }
}
