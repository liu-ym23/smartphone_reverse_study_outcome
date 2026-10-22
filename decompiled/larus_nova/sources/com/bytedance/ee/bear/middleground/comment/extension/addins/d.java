package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p1 f231444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentInputRequest f231445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f231446c;

    public d(p1 r100, CommentInputRequest r101, String r102) {
        this.f231444a = r100;
        this.f231445b = r101;
        this.f231446c = r102;
    }

    public final void a() {
        p1 r100 = this.f231444a;
        ScrollCommentBean r101 = new ScrollCommentBean();
        CommentInputRequest r102 = this.f231445b;
        String r103 = this.f231446c;
        r101.cur_comment_id = r102.comment_id;
        r101.replyId = r103;
        r100.hc(r101);
        com.bytedance.ee.bear.middleground.comment.bitablediscuss.i r104 = (com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) this.f231444a;
        CommentInputRequest r105 = this.f231445b;
        r104.H50(r105.comment_id, this.f231446c, r105.type);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
