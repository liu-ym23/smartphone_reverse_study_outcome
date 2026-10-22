package com.bytedance.ee.bear.middleground.comment.control;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f231227a;

    public j(Ref.BooleanRef r100) {
        this.f231227a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.b0
    public final void a(com.bytedance.ee.bear.middleground.comment.export.bean.b r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        Ref.BooleanRef r101 = this.f231227a;
        r101.element = r100.f231374a;
    }
}
