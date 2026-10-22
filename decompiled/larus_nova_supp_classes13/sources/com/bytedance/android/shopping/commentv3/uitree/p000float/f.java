package com.bytedance.android.shopping.commentv3.uitree.p000float;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.CommentBtmId;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EntranceType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import ic3.e;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import t53.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements com.bytedance.android.shopping.commentv3.uitree.list.f {
    public final /* synthetic */ FloatWindowUI a;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FloatWindowUI r0 = this.a.a;     // Catch: Throwable -> L6
            int r1 = FloatWindowUI.o;     // Catch: Throwable -> L6
            View r2 = r0.c;     // Catch: Throwable -> L6
            if (r2 == null) goto L9;
            r2.requestLayout();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.f
    public final void b() {
    }

    public f(FloatWindowUI r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.f
    public final void a(int r13) {
        FloatWindowUI r0 = this.a;
        r0.m = r13;
        if (r13 <= ((Number) r0.n.getValue()).intValue()) goto L59;
        ImageView r14 = this.a.i;
        fc3.a r1 = null;
        if (r14 != null) goto L7;
    L8:
        ImageView r15 = this.a.i;
        if (r15 == null) goto L11;
        r15.setAlpha(0.5f);
    L11:
        ImageView r16 = this.a.i;
        if (r16 == null) goto L14;
        ExtensionsKt.visible(r16);
    L14:
        Context r17 = this.a.getContext();
        if (r17 == null) goto L27;
        b r3 = b.a;
        com.bytedance.android.shopping.commentv3.data.b r4 = this.a.e;
        if (r4 == null) goto L21;
        CommentParams r5 = r4.a;
        if (r5 == null) goto L21;
        String r6 = r5.getProductId();
    L22:
        r3.getClass();
        b.c(r17, true, r6);
        int r18 = e.a;
        com.bytedance.android.shopping.commentv3.data.b r19 = this.a.e;
        if (r19 == null) goto L25;
        fc3.a r7 = r19.b;
    L26:
        e.a.a(r7, EventName.SHOW.getEvent(), EntranceType.LIST_IMAGE_SCROLL_TOP.getType(), new LinkedHashMap(), CommentBtmId.FLOAT_TO_TOP.getId(), this.a.i, 48);
        goto L27
    L25:
        r7 = null;
    L21:
        r6 = null;
    L27:
        ImageView r110 = this.a.j;
        if (r110 != null) goto L30;
    L31:
        c r111 = (c) this.a.b.getValue();
        if (r111 == null) goto L59;
        if (r111.b != true) goto L59;
        ImageView r112 = this.a.j;
        if (r112 == null) goto L38;
        r112.setAlpha(0.5f);
    L38:
        ImageView r113 = this.a.j;
        if (r113 == null) goto L42;
        ExtensionsKt.visible(r113);
    L42:
        if (this.a.getContext() == null) goto L59;
        b r114 = b.a;
        com.bytedance.android.shopping.commentv3.data.b r2 = this.a.e;
        String r8 = "pic";
        if (r2 != null) goto L46;
    L48:
        String r9 = "list";
    L49:
        Context r10 = this.a.getContext();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r9, "commentSwitchType");
        u53.e r115 = new u53.e();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r115.a = r9;
        t53.e.c(r115, r10, null);
        int r116 = e.a;
        com.bytedance.android.shopping.commentv3.data.b r117 = this.a.e;
        if (r117 == null) goto L52;
        r1 = r117.b;
    L52:
        fc3.a r11 = r1;
        String r12 = EventName.SHOW.getEvent();
        String r20 = EntranceType.LIST_PIC_MODE_SWITCH.getType();
        Pair[] r118 = new Pair[1];
        com.bytedance.android.shopping.commentv3.data.b r21 = this.a.e;
        if (r21 != null) goto L55;
    L57:
        r8 = "list";
    L58:
        r118[0] = TuplesKt.to("comment_switch_type", r8);
        e.a.a(r11, r12, r20, MapsKt.mutableMapOf(r118), CommentBtmId.FLOAT_MULTI_SWITCH.getId(), this.a.j, 48);
        goto L59
    L55:
        if (r21.c() != true) goto L57;
    L46:
        if (r2.c() != true) goto L48;
        r9 = "pic";
        goto L49
    L30:
        if (r110.getVisibility() == 0) goto L59;
    L7:
        if (r14.getVisibility() == 0) goto L27;
    L59:
        FloatWindowUI r119 = this.a;
        if (r119.m > ((Number) r119.n.getValue()).intValue()) goto L79;
        ImageView r120 = this.a.i;
        if (r120 != null) goto L64;
    L65:
        ImageView r121 = this.a.i;
        if (r121 == null) goto L68;
        ExtensionsKt.gone(r121);
    L68:
        ImageView r122 = this.a.j;
        if (r122 != null) goto L71;
    L72:
        ImageView r123 = this.a.j;
        if (r123 == null) goto L75;
        ExtensionsKt.gone(r123);
    L75:
        View r124 = this.a.c;
        if (r124 == null) goto L80;
        r124.post(new a(this));
        return;
    L80:
        return;
    L71:
        if (r122.getVisibility() == 8) goto L75;
    L64:
        if (r120.getVisibility() == 8) goto L68;
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.f
    public final void c(int r5) {
        ImageView r0 = this.a.i;
        if (r0 != null) goto L5;
    L14:
        ImageView r1 = this.a.j;
        if (r1 != null) goto L17;
        return;
    L17:
        if (r1.getVisibility() != 0) goto L28;
        if (r5 != 1) goto L22;
        ImageView r6 = this.a.j;
        if (r6 == null) goto L29;
        r6.setAlpha(0.5f);
        return;
    L29:
        return;
    L22:
        if (r5 != 0) goto L31;
        ImageView r7 = this.a.j;
        if (r7 == null) goto L32;
        r7.setAlpha(1.0f);
        return;
    L32:
        return;
    L31:
        return;
    L28:
        return;
    L5:
        if (r0.getVisibility() != 0) goto L14;
        if (r5 != 1) goto L10;
        ImageView r2 = this.a.i;
        if (r2 == null) goto L14;
        r2.setAlpha(0.5f);
        goto L14
    L10:
        if (r5 != 0) goto L14;
        ImageView r3 = this.a.i;
        if (r3 == null) goto L14;
        r3.setAlpha(1.0f);
        goto L14
    }
}
