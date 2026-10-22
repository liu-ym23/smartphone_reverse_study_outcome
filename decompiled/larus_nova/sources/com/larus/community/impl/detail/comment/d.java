package com.larus.community.impl.detail.comment;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.larus.platform.model.comment.api.CommentItemCustomType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements rq9.e {
    public d() {
    }

    @Override // rq9.e
    public final int a() {
        return R.layout.larus_creation_detail_comment_empty_item;
    }

    @Override // rq9.e
    public final void b(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    @Override // rq9.e
    public final CommentItemCustomType c() {
        return CommentItemCustomType.EMPTY;
    }
}
