package com.bytedance.ee.bear.middleground.comment.card;

import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements PointRecoderRecyclerView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentPagerAdapter2 f230979a;

    public g(CommentPagerAdapter2 r100) {
        this.f230979a = r100;
    }

    @Override // com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView.a
    public final void a(float r100) {
        com.bytedance.ee.bear.middleground.comment.control.y r101 = this.f230979a.f230760h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        r101 = null;
    L5:
        r101.m(r100);
    }
}
