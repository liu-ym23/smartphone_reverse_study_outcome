package com.story.ai.biz.comment.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.widget.ExpandableTextView;
import com.story.ai.biz.comment.model.CommentListItem;
import com.story.ai.biz.comment.model.CommentSection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j0 implements ExpandableTextView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentSection f459821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f459822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommentListItem f459823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f459824d;

    @Override // com.larus.common_ui.widget.ExpandableTextView.d
    public final void b() {
    }

    @Override // com.larus.common_ui.widget.ExpandableTextView.d
    public final void a(ExpandableTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ((CommentListItem) this.f459821a).setTextExpandState(0);
        w r101 = this.f459822b.f459816b;
        if (r101 == null) goto L6;
        CommentListItem r102 = this.f459823c;
        this.f459824d.getLayoutPosition();
        r101.a(r102, r100);
        return;
    }

    @Override // com.larus.common_ui.widget.ExpandableTextView.d
    public final void c(ExpandableTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ((CommentListItem) this.f459821a).setTextExpandState(1);
    }

    public j0(CommentSection r100, h0 r101, CommentListItem r102, RecyclerView.ViewHolder r103) {
        this.f459821a = r100;
        this.f459822b = r101;
        this.f459823c = r102;
        this.f459824d = r103;
    }
}
