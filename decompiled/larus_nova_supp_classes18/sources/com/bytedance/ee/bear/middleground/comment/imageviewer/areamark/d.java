package com.bytedance.ee.bear.middleground.comment.imageviewer.areamark;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentAreaMarkLayout;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements SubsamplingScaleImageView.i {
    public final /* synthetic */ a a;
    public final /* synthetic */ Ref.ObjectRef<CommentAreaMarkLayout> b;
    public final /* synthetic */ View c;

    public final void a(RectF r4) {
        Intrinsics.checkNotNullParameter(r4, "rectF");
        tt5.a.h("CommentImageAreaMarkRender", "onMatrixChanged rectF:" + r4);
        a r0 = this.a;
        CommentAreaMarkLayout r1 = (CommentAreaMarkLayout) this.b.element;
        LargeImageView r2 = this.c;
        r0.getClass();
        a.a(r1, r4, a.b(r2));
    }

    public d(a r1, Ref.ObjectRef r2, LargeImageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
