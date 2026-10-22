package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.adapter.ReactionViewHolder;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardAdapterAddin.CardAdapterActionEventHandler f231496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactionViewHolder f231497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommentBean.CommentDetail f231498c;

    public l(CardAdapterAddin.CardAdapterActionEventHandler r100, ReactionViewHolder r101, CommentBean.CommentDetail r102) {
        this.f231496a = r100;
        this.f231497b = r101;
        this.f231498c = r102;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        this.f231496a.d(this.f231497b, this.f231498c);
        return true;
    }
}
