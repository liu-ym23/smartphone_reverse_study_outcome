package com.bytedance.android.shopping.commentv3.uitree.p000float;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.CommentBtmId;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.base.c;
import fc3.a;
import java.util.LinkedHashMap;
import t53.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ FloatWindowUI a;

    public e(FloatWindowUI r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        FloatWindowUI r12 = this.a;
        int r0 = FloatWindowUI.o;
        com.bytedance.android.shopping.commentv3.uitree.list.e r13 = (com.bytedance.android.shopping.commentv3.uitree.list.e) r12.l.getValue();
        if (r13 == null) goto L5;
        r13.c();
    L5:
        Context r14 = this.a.getContext();
        if (r14 == null) goto L18;
        b r1 = b.a;
        com.bytedance.android.shopping.commentv3.data.b r2 = this.a.e;
        a r3 = null;
        if (r2 == null) goto L12;
        CommentParams r4 = r2.a;
        if (r4 == null) goto L12;
        String r5 = r4.getProductId();
    L13:
        r1.getClass();
        b.c(r14, false, r5);
        int r15 = ic3.e.a;
        c r16 = this.a.g;
        if (r16 == null) goto L16;
        r3 = r16.d;
    L16:
        ic3.e.a.a(r3, EventName.CLICK.getEvent(), EntranceType.LIST_IMAGE_SCROLL_TOP.getType(), new LinkedHashMap(), CommentBtmId.FLOAT_TO_TOP.getId(), this.a.i, 48);
        return;
    L12:
        r5 = null;
        goto L13
    }
}
