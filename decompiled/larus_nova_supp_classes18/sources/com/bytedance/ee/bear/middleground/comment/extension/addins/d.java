package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Runnable {
    public final /* synthetic */ p1 a;
    public final /* synthetic */ CommentInputRequest b;
    public final /* synthetic */ String c;

    public d(p1 r1, CommentInputRequest r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        p1 r0 = this.a;
        ScrollCommentBean r1 = new ScrollCommentBean();
        CommentInputRequest r2 = this.b;
        String r3 = this.c;
        r1.cur_comment_id = r2.comment_id;
        r1.replyId = r3;
        r0.hc(r1);
        com.bytedance.ee.bear.middleground.comment.bitablediscuss.i r4 = (com.bytedance.ee.bear.middleground.comment.bitablediscuss.i) this.a;
        CommentInputRequest r5 = this.b;
        r4.H50(r5.comment_id, this.c, r5.type);
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
