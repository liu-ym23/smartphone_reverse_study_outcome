package com.bytedance.ee.bear.document.comment;

import com.bytedance.ee.bear.document.comment.bean.MenuCallbackData;
import com.ss.android.lark.reaction.widget.panel.ReactionPanelFacade;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x1 implements ReactionPanelFacade.b {
    public final /* synthetic */ tb5.m a;
    public final /* synthetic */ CommentPlugin.l0 b;

    public final void b() {
    }

    public x1(CommentPlugin.l0 r1, tb5.m r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void a(String r4, int r5) {
        this.a.a(new MenuCallbackData("REACTION", r4, CommentPlugin.access$6100(this.b.a)));
    }
}
