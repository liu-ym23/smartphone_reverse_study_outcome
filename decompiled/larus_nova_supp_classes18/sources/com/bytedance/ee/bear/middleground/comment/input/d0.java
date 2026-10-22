package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 implements View.OnClickListener {
    public final /* synthetic */ BaseInputComment a;

    public d0(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        BaseInputComment r6 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r0 = r6.a.d0;
        CommentInputRequest r7 = r6.j;
        String r1 = r7.comment_id;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r8 = r7.reply_id;
        if (r8 == null) goto L9;
        r2 = r8;
    L9:
        r0.g("image_selection_click", r1, r2, null);
        this.a.b.I().invoke(this.a.j);
    }
}
