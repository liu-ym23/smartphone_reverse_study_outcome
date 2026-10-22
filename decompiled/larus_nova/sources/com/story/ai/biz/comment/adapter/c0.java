package com.story.ai.biz.comment.adapter;

import com.larus.nova.R;
import com.story.ai.biz.comment.model.CommentSection;

/* JADX INFO: loaded from: classes38.dex */
public final class c0 extends dnc.a<CommentSection> {
    @Override // dnc.a
    public final int c() {
        return R.layout.larus_comment_loading_item_layout;
    }

    @Override // dnc.a
    public final int b() {
        return CommentSection.CommentItemType.LOADING.ordinal();
    }

    public c0() {
    }
}
