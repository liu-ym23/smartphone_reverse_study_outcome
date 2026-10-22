package com.bytedance.android.shopping.card_list.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends BaseSlcViewManager<com.bytedance.android.shopping.card_list.slice.widgets.e> {
    public String H3;
    public final Lazy I3;
    public final SlcTemplateContext J3;
    public final boolean K3;

    public h(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.J3 = r2;
        this.K3 = true;
        this.I3 = LazyKt.lazy(new LynxPendantVM$provider$2(this));
    }

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new com.bytedance.android.shopping.card_list.slice.widgets.e(r3, this.K3);
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [android.view.View, android.widget.FrameLayout, com.bytedance.android.shopping.card_list.slice.widgets.e, java.lang.Object] */
    public final void H0(Map<String, ? extends Object> r21) {
        Intrinsics.checkNotNullParameter(r21, "props");
        Object r2 = r21.get("schema");
        Object r4 = null;
        if ((r2 instanceof String) == true) goto L5;
        r2 = null;
    L5:
        String r3 = (String) r2;
        Object r5 = r21.get("config");
        if ((r5 instanceof String) == true) goto L8;
        r5 = null;
    L8:
        String r6 = (String) r5;
        Object r7 = r21.get("pass_param");
        if ((r7 instanceof Map) == true) goto L11;
        r7 = null;
    L11:
        Map<String, ? extends Object> r8 = (Map) r7;
        Object r1 = r21.get("loadFromCache");
        if ((r1 instanceof String) == false) goto L16;
        r4 = r1;
    L16:
        if (Intrinsics.areEqual((String) r4, "1") == false) goto L18;
        return;
    L18:
        JSONObject r9 = z1.g(r6);
        boolean r10 = true;
        if ((!Intrinsics.areEqual(this.H3, r3)) == false) goto L33;
        this.H3 = r3;
        ?? r11 = (com.bytedance.android.shopping.card_list.slice.widgets.e) getView();
        CardListSliceCustomWidgetAdapterComponent r12 = (CardListSliceCustomWidgetAdapterComponent) this.I3.getValue();
        r11.getClass();
        if (r3 != null) goto L23;
    L26:
        if (r10 == false) goto L28;
        r11.setVisibility(8);
        return;
    L28:
        String r13 = UUID.randomUUID().toString();
        HashMap r14 = j.a;
        j.h(r13, r9);
        String r15 = UriProtector.parse(r3).buildUpon().appendQueryParameter("mega_object_id", r13).build().toString();
        r11.removeAllViews();
        r11.setVisibility(0);
        r11.c = ECLiveHybridUtil.b(r11.getContext(), r15, null, null, new com.bytedance.android.shopping.card_list.slice.widgets.d(r11, r12, r3), null, null, false, null, null, false, 4076);
        r11.b(r8);
        l r16 = r11.c;
        if (r16 == null) goto L36;
        View r17 = r16.getHybridView();
        if (r17 == null) goto L37;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-1, -1);
        r18.gravity = 8388613;
        r11.addView(r17, r18);
        return;
    L37:
        return;
    L36:
        return;
    L23:
        if (r3.length() == 0) goto L26;
        r10 = false;
        goto L26
    L33:
        ((com.bytedance.android.shopping.card_list.slice.widgets.e) getView()).b(r8);
    }
}
