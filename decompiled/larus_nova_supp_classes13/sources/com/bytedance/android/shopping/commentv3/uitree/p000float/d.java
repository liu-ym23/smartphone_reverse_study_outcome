package com.bytedance.android.shopping.commentv3.uitree.p000float;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.CommentBtmId;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.MultiPicMode;
import com.bytedance.android.shopping.commentv3.data.b;
import fc3.a;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t53.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ FloatWindowUI a;

    public d(FloatWindowUI r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        FloatWindowUI r0 = this.a;
        int r1 = FloatWindowUI.o;
        b r2 = r0.e;
        if (r2 != null) goto L5;
        return;
    L5:
        t53.b r3 = t53.b.a;
        String r4 = "pic";
        if (r2.c() == false) goto L8;
        String r5 = "pic";
    L9:
        Context r6 = this.a.getContext();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "commentSwitchType");
        u53.d r7 = new u53.d();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r7.a = r5;
        e.c(r7, r6, null);
        int r8 = ic3.e.a;
        c r9 = this.a.g;
        if (r9 == null) goto L12;
        a r10 = r9.d;
    L13:
        String r11 = EventName.CLICK.getEvent();
        String r12 = EntranceType.LIST_PIC_MODE_SWITCH.getType();
        boolean r14 = true;
        Pair[] r15 = new Pair[1];
        b r16 = this.a.e;
        if (r16 != null) goto L16;
    L18:
        r4 = "list";
    L19:
        r15[0] = TuplesKt.to("comment_switch_type", r4);
        ic3.e.a.a(r10, r11, r12, MapsKt.mutableMapOf(r15), CommentBtmId.FLOAT_MULTI_SWITCH.getId(), r13, 48);
        Map<String, Object> r17 = r2.e.d.a;
        MultiPicMode r18 = MultiPicMode.LIST;
        int r19 = nc3.a.b(r17, "multi_pic_mode", r18.getMode());
        MultiPicMode r20 = MultiPicMode.PIC;
        if (r19 == r20.getMode()) goto L23;
        r14 = false;
    L23:
        if (r14 == false) goto L25;
        r2.e.a(r18);
    L26:
        FloatWindowUI r110 = this.a;
        if (r2.c() == false) goto L31;
        ImageView r111 = r110.j;
        if (r111 == null) goto L34;
        r111.setImageResource(2131234323);
    L34:
        r2.h.e(null);
        return;
    L31:
        ImageView r112 = r110.j;
        if (r112 == null) goto L34;
        r112.setImageResource(2131234325);
        goto L34
    L25:
        r2.e.a(r20);
        goto L26
    L16:
        if (r16.c() != true) goto L18;
    L12:
        r10 = null;
        goto L13
    L8:
        r5 = "list";
        goto L9
    }
}
