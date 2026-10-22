package com.bytedance.ee.bear.templates.center.list.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o implements gqa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListView f239020a;

    public o(BaseTemplateListView r100) {
        this.f239020a = r100;
    }

    @Override // gqa.b
    public final void O0(cqa.h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        q.a r101 = this.f239020a.f238981d;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
