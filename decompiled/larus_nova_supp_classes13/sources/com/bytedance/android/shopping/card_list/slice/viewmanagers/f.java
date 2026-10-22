package com.bytedance.android.shopping.card_list.slice.viewmanagers;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.card_list.slice.widgets.j;
import com.bytedance.android.shopping.card_list.slice.widgets.k;
import com.bytedance.android.shopping.card_list.slice.widgets.l;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends BaseSlcViewManager<j> {
    public final SlcTemplateContext H3;

    public f(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.H3 = r2;
    }

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new j(r3, this.H3);
    }

    public final void H0(Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "props");
        Object r0 = r12.get("gradient_colors");
        Object r2 = null;
        if ((r0 instanceof List) == true) goto L5;
        r0 = null;
    L5:
        List r1 = (List) r0;
        Object r3 = r12.get("handler_color");
        if ((r3 instanceof String) == true) goto L8;
        r3 = null;
    L8:
        String r4 = (String) r3;
        float r5 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r12.get("current_progress_status"), 0.0f);
        float r6 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r12.get("last_progress_status"), 0.0f);
        Object r7 = r12.get("animate");
        if ((r7 instanceof Boolean) == true) goto L11;
        r7 = null;
    L11:
        Boolean r8 = (Boolean) r7;
        if (r8 == null) goto L14;
        boolean r9 = r8.booleanValue();
    L15:
        Object r10 = r12.get("bg_color");
        if ((r10 instanceof String) == true) goto L18;
        r10 = null;
    L18:
        String r11 = (String) r10;
        Integer r13 = CartViewExtentionsKt.a(r12.get("animation_boundary"));
        if (r13 == null) goto L21;
        int r14 = r13.intValue();
    L22:
        Object r15 = r12.get("gradient_bg_color");
        if ((r15 instanceof String) == false) goto L26;
        r2 = r15;
    L26:
        String r16 = (String) r2;
        j r17 = (j) getView();
        Float r18 = Float.valueOf(r6);
        Float r19 = Float.valueOf(r5);
        r17.getClass();
        if (r1 == null) goto L78;
        if (r11 == null) goto L79;
        if (r4 == null) goto L84;
        Integer r20 = s.b(r11);
        if (r20 == null) goto L34;
        int r21 = r20.intValue();
    L35:
        r17.c = r21;
        Integer r22 = s.b((String) CollectionsKt.getOrNull(r1, 0));
        if (r22 == null) goto L38;
        int r23 = r22.intValue();
    L39:
        r17.d = r23;
        Integer r24 = s.b((String) CollectionsKt.getOrNull(r1, 1));
        if (r24 == null) goto L42;
        int r25 = r24.intValue();
    L43:
        r17.e = r25;
        Integer r26 = s.b(r16);
        if (r26 == null) goto L46;
        int r27 = r26.intValue();
    L47:
        r17.f = r27;
        Integer r28 = s.b(r4);
        if (r28 == null) goto L50;
        int r29 = r28.intValue();
    L51:
        r17.h = r29;
        CollectionsKt.listOf(new Integer[]{Integer.valueOf(r17.d), Integer.valueOf(r17.e)});
        r17.a();
        if (r18 == null) goto L54;
        float r30 = r18.floatValue();
    L55:
        if (r19 == null) goto L57;
        float r31 = r19.floatValue();
    L58:
        if (r9 == true) goto L60;
        int r32 = (int) r31;
        if (r32 == r17.getProgress()) goto L83;
        r17.setProgress(r32);
        return;
    L83:
        return;
    L60:
        if (r30 != 0.0f) goto L65;
        if (r31 <= 0.0f) goto L65;
        r17.animate().alpha(1.0f).setDuration(200).start();
    L69:
        int r33 = r14 * 100;
        float r34 = Math.abs((r31 - r30) + r33) * 10;
        int r35 = (int) r31;
        if (r35 != r17.getProgress()) goto L72;
        return;
    L72:
        if (r34 <= 0) goto L81;
        ValueAnimator r36 = ValueAnimator.ofInt(new int[]{r17.getProgress(), r35 + r33});
        r36.addUpdateListener(new l(r17));
        r36.setInterpolator(new AccelerateDecelerateInterpolator());
        r36.setDuration((long) r34);
        r36.start();
        return;
    L81:
        return;
    L65:
        if (r31 != 0.0f) goto L69;
        if (r30 <= 0.0f) goto L69;
        r17.animate().alpha(0.0f).setDuration(200).withEndAction(new k(r17)).start();
        goto L69
    L57:
        r31 = 0.0f;
        goto L58
    L54:
        r30 = 0.0f;
        goto L55
    L50:
        r29 = 0;
        goto L51
    L46:
        r27 = 0;
        goto L47
    L42:
        r25 = 0;
        goto L43
    L38:
        r23 = 0;
        goto L39
    L34:
        r21 = 0;
        goto L35
    L84:
        return;
    L79:
        return;
    L78:
        return;
    L21:
        r14 = 0;
        goto L22
    L14:
        r9 = false;
        goto L15
    }
}
