package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.larksuite.component.ui.button.LKUICheckBox2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 implements LKUICheckBox2.b {
    public final /* synthetic */ BaseInputComment a;

    public g0(BaseInputComment r1) {
        this.a = r1;
    }

    public final void a(LKUICheckBox2 r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "buttonView");
        BaseInputComment r6 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r0 = r6.a.d0;
        if (r5 == false) goto L5;
        String r7 = "reading_authority";
    L6:
        CommentInputRequest r8 = r6.j;
        String r1 = r8.comment_id;
        String r2 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        String r9 = r8.reply_id;
        if (r9 == null) goto L13;
        r2 = r9;
    L13:
        r0.g(r7, r1, r2, null);
        return;
    L5:
        r7 = "cancel_reading_authority";
        goto L6
    }
}
