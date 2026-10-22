package com.ss.android.lark.coremdbiz.facade.plugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class q implements com.ss.android.lark.widget.span.v.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.o<v7b.l> f420157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.span.v f420158b;

    @Override // com.ss.android.lark.widget.span.v.b
    public final void a() {
        com.ss.android.lark.coremd.base.parse.m r100 = this.f420157a.d();
        com.ss.android.lark.widget.span.v r101 = this.f420158b;
        Intrinsics.checkNotNull(r101);
        r100.a(r101, false);
    }

    @Override // com.ss.android.lark.widget.span.v.b
    public final void onLoadFailed() {
        com.ss.android.lark.coremd.base.parse.m r100 = this.f420157a.d();
        com.ss.android.lark.widget.span.v r101 = this.f420158b;
        Intrinsics.checkNotNull(r101);
        r100.a(r101, false);
    }

    public q(com.ss.android.lark.coremd.impl.parse.i r100, com.ss.android.lark.widget.span.v r101) {
        this.f420157a = r100;
        this.f420158b = r101;
    }
}
