package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class x {
    public static /* synthetic */ void b(y r6, View r7, CommentBean.CommentDetail r8, CardAdapter r9, int r10) {
        r6.o(r7, r8, r9, r10, 1);
    }

    public static /* synthetic */ void a(y r7, String r8, int r9, boolean r10, boolean r11, boolean r12, View r13, int r14) {
        if ((r14 & 16) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r14 & 32) == 0) goto L9;
        r13 = null;
    L9:
        r7.A(r8, r9, r10, r11, r5, r13);
        return;
    L5:
        r5 = r12;
        goto L7
    }
}
