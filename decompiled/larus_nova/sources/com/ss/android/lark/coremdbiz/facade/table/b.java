package com.ss.android.lark.coremdbiz.facade.table;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements com.ss.android.lark.coremd.base.parse.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.d f420166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f420167b;

    public final CharSequence b(s r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        return a(r100, com.ss.android.lark.coremd.base.parse.b.f419537a);
    }

    public b(com.ss.android.lark.coremd.base.parse.d r100, c r101) {
        this.f420166a = r100;
        this.f420167b = r101;
    }

    @Override // com.ss.android.lark.coremd.base.parse.d
    public final CharSequence a(s r100, com.ss.android.lark.coremd.base.parse.b r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "markdownContext");
        return this.f420166a.a(r100, this.f420167b.f420171d.b(r101));
    }
}
