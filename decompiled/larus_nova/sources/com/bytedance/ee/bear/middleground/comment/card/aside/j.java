package com.bytedance.ee.bear.middleground.comment.card.aside;

import com.bytedance.ee.bear.middleground.comment.control.y;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements PointRecoderRecyclerView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsidePageAdapter f230949a;

    public j(AsidePageAdapter r100) {
        this.f230949a = r100;
    }

    @Override // com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView.a
    public final void a(float r100) {
        y r101 = this.f230949a.f230921i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r101 = null;
    L5:
        r101.m(r100);
    }
}
