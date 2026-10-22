package com.bytedance.ee.bear.templates.search.base;

import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements gqa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseView f239387a;

    public d(BaseView r100) {
        this.f239387a = r100;
    }

    @Override // gqa.b
    public final void O0(h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        f.a r101 = this.f239387a.f239372e;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
