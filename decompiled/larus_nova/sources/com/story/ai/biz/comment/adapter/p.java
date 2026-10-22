package com.story.ai.biz.comment.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.model.comment.api.AbsCustomCommentHolder;
import com.story.ai.biz.comment.model.CommentSection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class p extends dnc.a<CommentSection> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rq9.g f459833a;

    @Override // dnc.a
    public final int c() {
        return 0;
    }

    @Override // dnc.a
    public final int b() {
        return CommentSection.CommentItemType.CUSTOM.ordinal();
    }

    public p(rq9.g r100) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.f459833a = r100;
    }

    @Override // dnc.a
    public final RecyclerView.ViewHolder d(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f459833a.a(r100);
    }

    @Override // dnc.a
    public final void a(RecyclerView.ViewHolder r100, CommentSection r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof AbsCustomCommentHolder) == false) goto L5;
        AbsCustomCommentHolder r103 = (AbsCustomCommentHolder) r100;
    L6:
        if (r103 == null) goto L8;
        r103.T3();
    L8:
        Intrinsics.checkNotNullParameter(r100, "holder");
        return;
    L5:
        r103 = null;
        goto L6
    }
}
