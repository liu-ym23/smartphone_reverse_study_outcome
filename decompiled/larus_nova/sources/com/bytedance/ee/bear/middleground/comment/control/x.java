package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class x {
    public static /* synthetic */ void b(y r100, View r101, CommentBean.CommentDetail r102, CardAdapter r103, int r110) {
        r100.o(r101, r102, r103, r110, 1);
    }

    public static /* synthetic */ void a(y r100, String r101, int r102, boolean r110, boolean r111, boolean r112, View r113, int r114) {
        if ((r114 & 16) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r114 & 32) == 0) goto L9;
        r113 = null;
    L9:
        r100.A(r101, r102, r110, r111, r103, r113);
        return;
    L5:
        r103 = r112;
        goto L7
    }
}
