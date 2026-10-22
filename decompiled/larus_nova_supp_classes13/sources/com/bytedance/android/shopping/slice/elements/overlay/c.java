package com.bytedance.android.shopping.slice.elements.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends BaseSlcViewManager<PDPOverLayVG> {
    public PDPOverLayVG H3;

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.android.shopping.slice.elements.overlay.PDPOverLayVG] */
    public final View A0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ?? r0 = new PDPOverLayVG(r2);
        r0.setSlcDisplayMetrics(((BaseSlcViewManager) this).a.w.f);
        Unit r3 = Unit.INSTANCE;
        this.H3 = r0;
        return r0;
    }

    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((PDPOverLayVG) getView()).dispatchHoverEvent(r2) == false) goto L7;
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    L7:
        return super.E(r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.widget.FrameLayout, com.bytedance.android.shopping.slice.elements.overlay.PDPOverLayVG] */
    public final void H0(Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "props");
        ?? r1 = this.H3;
        if (r1 == 0) goto L55;
        Intrinsics.checkNotNullParameter(r12, "props");
        if (r1.f != null) goto L58;
        Object r0 = r12.get("specification_hint");
        ArrayList r3 = null;
        if ((r0 instanceof String) == true) goto L10;
        r0 = null;
    L10:
        String r2 = (String) r0;
        List r13 = (List) r12.get("specifications");
        if (r13 == null) goto L48;
        List r14 = r13;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L47;
        Object r5 = r15.next();
        if ((r5 instanceof Map) == true) goto L18;
        r5 = null;
    L18:
        Map r6 = (Map) r5;
        if (r6 == null) goto L21;
        Object r7 = r6.get("information");
    L23:
        if ((r7 instanceof String) == true) goto L25;
        r7 = null;
    L25:
        String r8 = (String) r7;
        if (r6 == null) goto L28;
        Object r9 = r6.get("picture");
    L30:
        if ((r9 instanceof Map) == true) goto L32;
        r9 = null;
    L32:
        Map r10 = (Map) r9;
        if (r10 == null) goto L45;
        Object r11 = r10.get("url");
        if ((r11 instanceof String) == true) goto L37;
        r11 = null;
    L37:
        String r16 = (String) r11;
        Integer r17 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r10.get("width"));
        int r18 = 100;
        if (r17 == null) goto L40;
        int r19 = r17.intValue();
    L41:
        Integer r20 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r10.get("height"));
        if (r20 == null) goto L44;
        r18 = r20.intValue();
    L44:
        b r21 = new b(r16, r19, r18);
    L46:
        r4.add(new d(r8, r21));
        goto L14
    L40:
        r19 = 100;
        goto L41
    L45:
        r21 = null;
        goto L46
    L28:
        r9 = null;
        goto L30
    L21:
        r7 = null;
        goto L23
    L47:
        r3 = r4;
    L48:
        if (r2 == null) goto L56;
        if (r3 == null) goto L57;
        r1.addView(new e(r1.getContext(), r3, r1.c), new FrameLayout.LayoutParams(-2, -2));
        f r22 = new f(r1.getContext(), r2, r1.c);
        r1.f = r22;
        r1.addView(r22, new FrameLayout.LayoutParams(-2, -1));
        return;
    L57:
        return;
    L56:
        return;
    L58:
        return;
    }
}
