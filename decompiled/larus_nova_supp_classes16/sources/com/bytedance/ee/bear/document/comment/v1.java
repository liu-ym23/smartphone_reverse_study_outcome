package com.bytedance.ee.bear.document.comment;

import android.view.View;
import com.bytedance.ee.bear.document.comment.bean.MenuCallbackData;
import com.bytedance.ee.bear.document.comment.bean.ReactionPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v1 implements com.ss.android.lark.reaction.widget.panel.e.a {
    public final /* synthetic */ tb5.m a;
    public final /* synthetic */ ReactionPanel.OperationItem b;
    public final /* synthetic */ CommentPlugin.l0 c;

    public final void a(View r7) {
        this.a.a(new MenuCallbackData(this.b.getId(), CommentPlugin.access$6100(this.c.a)));
        if (CommentPlugin.access$4000(this.c.a) != null) goto L5;
        return;
    L5:
        if (CommentPlugin.access$4000(this.c.a).a() != null) goto L7;
        return;
    L7:
        if (CommentPlugin.access$4000(this.c.a).a().d() != null) goto L9;
        return;
    L9:
        if ("REPLY".equalsIgnoreCase(this.b.getId()) == false) goto L11;
    L12:
        CommentPlugin.access$4000(this.c.a).a().d().c(System.currentTimeMillis(), "full_comment", this.b.getId().toLowerCase(), "reaction_menu");
        return;
    L11:
        if ("EDIT".equalsIgnoreCase(this.b.getId()) == true) goto L12;
    }

    public v1(CommentPlugin.l0 r1, tb5.m r2, ReactionPanel.OperationItem r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
