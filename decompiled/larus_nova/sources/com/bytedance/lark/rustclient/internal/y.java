package com.bytedance.lark.rustclient.internal;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class y extends d implements com.ss.android.lark.passportc.api.r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f254043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.m f254044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f254045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Deque<com.bytedance.lark.sdk.refactor.q> f254046i;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public final void g() {
        Iterator<T> r100 = this.f254046i.iterator();
    L4:
        if (r100.hasNext() == false) goto L7;
        com.bytedance.lark.sdk.refactor.q r101 = (com.bytedance.lark.sdk.refactor.q) r100.next();
        Intrinsics.checkNotNull(r101);
        a(r101);
        goto L4
    L7:
        if (((LinkedList) this.f254046i).size() <= 0) goto L9;
        w.d(this.f254043f, this.f254044g.getSession().f438138b, ((LinkedList) this.f254046i).size(), false);
    L9:
        ((LinkedList) this.f254046i).clear();
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final com.ss.android.lark.passportc.api.m getPassport() {
        return this.f254044g;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        AtomicBoolean r101 = this.f254045h;
        monitor-enter(r101);
        this.f254045h.set(false);     // Catch: Throwable -> L7
        g();     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void v(com.bytedance.lark.sdk.refactor.q r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        AtomicBoolean r101 = this.f254045h;
        monitor-enter(r101);
        AtomicBoolean r102 = this.f254045h;     // Catch: Throwable -> L17
        if (r102.get() == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L13;
        ((LinkedList) this.f254046i).addLast(r100);     // Catch: Throwable -> L17
    L11:
        if (((LinkedList) this.f254046i).size() <= 1000) goto L14;
        ((LinkedList) this.f254046i).removeFirst();     // Catch: Throwable -> L17
    L14:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r101);
        return;
    L13:
        a(r100);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void y(com.bytedance.lark.sdk.refactor.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        b(r100);
    }

    public y(k r100, List<? extends com.bytedance.lark.rustclient.api.j> r101, com.ss.android.lark.passportc.api.m r102) {
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "interceptors");
        Intrinsics.checkNotNullParameter(r102, "passport");
        super(r101, r100);
        this.f254043f = r100;
        this.f254044g = r102;
        this.f254045h = new AtomicBoolean(true);
        this.f254046i = new LinkedList();
    }
}
