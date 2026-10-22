package com.bytedance.ee.bear.middleground.comment.control;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements b0 {
    public final /* synthetic */ Ref.BooleanRef a;

    public j(Ref.BooleanRef r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.b0
    public final void a(com.bytedance.ee.bear.middleground.comment.export.bean.b r2) {
        Intrinsics.checkNotNullParameter(r2, "permission");
        Ref.BooleanRef r0 = this.a;
        r0.element = r2.a;
    }
}
