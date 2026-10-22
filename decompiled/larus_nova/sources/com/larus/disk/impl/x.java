package com.larus.disk.impl;

import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f330824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f330825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f330826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f330827d;

    public final boolean a() {
        Object r100 = this.f330824a;
        monitor-enter(r100);
        boolean r101 = false;
        if (this.f330825b == false) goto L7;
    L11:
        monitor-exit(r100);
        return r101;
    L7:
        if (this.f330827d == false) goto L11;
        this.f330826c = false;     // Catch: Throwable -> L13
        this.f330827d = false;     // Catch: Throwable -> L13
        r101 = true;
    L13:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Object r100 = this.f330824a;
        monitor-enter(r100);
        boolean r101 = true;
        this.f330826c = true;     // Catch: Throwable -> L12
        if (this.f330825b == false) goto L9;
        r101 = false;
    L9:
        this.f330827d = r101;     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public x() {
        this.f330824a = new Object();
    }

    public final boolean b(boolean r100) {
        Object r101 = this.f330824a;
        monitor-enter(r101);
        boolean r102 = false;
        this.f330825b = false;     // Catch: Throwable -> L13
        if (r100 == true) goto L8;
    L10:
        this.f330827d = r102;     // Catch: Throwable -> L13
        monitor-exit(r101);
        return r102;
    L8:
        if (this.f330826c == false) goto L10;
        r102 = true;
    L13:
        th = move-exception;
        throw th;
    }
}
