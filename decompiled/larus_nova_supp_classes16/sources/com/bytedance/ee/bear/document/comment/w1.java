package com.bytedance.ee.bear.document.comment;

import android.widget.PopupWindow;
import com.bytedance.ee.bear.document.comment.bean.MenuCallbackData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w1 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ tb5.m a;
    public final /* synthetic */ CommentPlugin.l0 b;

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.a.a(new MenuCallbackData("CANCEL", CommentPlugin.access$6100(this.b.a)));
    }

    public w1(CommentPlugin.l0 r1, tb5.m r2) {
        this.b = r1;
        this.a = r2;
    }
}
