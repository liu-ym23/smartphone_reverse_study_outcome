package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends BaseSlcViewManager<com.bytedance.android.shopping.new_cart.slice.widgets.e> {
    public final SlcTemplateContext H3;

    public static final class a {
    }

    static {
    }

    public o(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.H3 = r2;
    }

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.shopping.new_cart.slice.widgets.e(r3, this.H3);
    }

    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((com.bytedance.android.shopping.new_cart.slice.widgets.e) getView()).dispatchHoverEvent(r2) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    public final void H0(Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r15, "props");
        Object r0 = r15.get("count_down_seconds");
        Object r2 = null;
        if ((r0 instanceof Number) == true) goto L5;
        r0 = null;
    L5:
        Number r1 = (Number) r0;
        if (r1 == null) goto L40;
        long r5 = r1.longValue();
        Object r3 = r15.get("native_origin_count_time_stamp");
        if ((r3 instanceof Number) == true) goto L10;
        r3 = null;
    L10:
        Number r4 = (Number) r3;
        if (r4 == null) goto L13;
        long r6 = r4.longValue() * ((long) 1000);
    L14:
        long r7 = r6;
        Object r8 = r15.get("count_down_type");
        if ((r8 instanceof Number) == true) goto L17;
        r8 = null;
    L17:
        Number r9 = (Number) r8;
        if (r9 == null) goto L20;
        long r10 = r9.longValue();
    L21:
        long r11 = r10;
        Object r12 = r15.get("font_color");
        if ((r12 instanceof String) == true) goto L24;
        r12 = null;
    L24:
        String r13 = (String) r12;
        if (r13 != null) goto L27;
        r13 = "#BF161823";
    L27:
        String r14 = r13;
        Object r16 = r15.get("suffix_text");
        if ((r16 instanceof Map) == true) goto L30;
        r16 = null;
    L30:
        Map<String, ? extends Object> r17 = (Map) r16;
        Object r18 = r15.get("font_size");
        if ((r18 instanceof Number) == false) goto L34;
        r2 = r18;
    L34:
        Number r19 = (Number) r2;
        if (r19 == null) goto L37;
        int r20 = r19.intValue();
    L38:
        ((com.bytedance.android.shopping.new_cart.slice.widgets.e) getView()).d(r20, r5, r7, r11, r14, r17, com.bytedance.android.ecom.arch.slice.render.util.b.f(r15.get("count_down_zero_action"), 2));
        return;
    L37:
        r20 = 14;
        goto L38
    L20:
        r10 = 1;
        goto L21
    L13:
        r6 = System.currentTimeMillis();
        goto L14
    }
}
