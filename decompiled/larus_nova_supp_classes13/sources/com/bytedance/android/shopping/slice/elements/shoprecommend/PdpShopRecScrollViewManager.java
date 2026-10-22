package com.bytedance.android.shopping.slice.elements.shoprecommend;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.scroll.SlcScrollElementView;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpShopRecScrollViewManager extends com.bytedance.android.ecom.arch.slice.render.elements.scroll.c {
    public final SlcTemplateContext Y3;

    public PdpShopRecScrollViewManager(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcContext");
        super(r2);
        this.Y3 = r2;
        ((BaseSlcViewManager) this).j3 = true;
    }

    public final /* bridge */ /* synthetic */ View A0(Context r1) {
        return I1(r1);
    }

    public final SlcScrollElementView I1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        a r0 = new a(r2);
        r0.setOnTabChangeListener(new PdpShopRecScrollViewManager$onCreateView$$inlined$apply$lambda$1(this));
        return r0;
    }

    public final Map<String, Object> z0(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "dataCtx");
        Object r0 = r8.get("data");
        Object r2 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map r1 = (Map) r0;
        int r3 = 0;
        if (r1 != null) goto L8;
    L32:
        if (r1 != null) goto L34;
    L48:
        return r8;
    L34:
        if (r1.get("recommend_tabs") == null) goto L48;
        Object r4 = getView();
        if ((r4 instanceof a) == true) goto L38;
        r4 = null;
    L38:
        a r5 = (a) r4;
        if (r5 == null) goto L48;
        Object r6 = r1.get("recommend_tabs");
        if ((r6 instanceof List) == false) goto L44;
        r2 = r6;
    L44:
        List r7 = (List) r2;
        if (r7 == null) goto L47;
        r3 = r7.size();
    L47:
        r5.setTabCount(r3);
        goto L48
    L8:
        if (r1.get("current_tab") == null) goto L32;
        Object r9 = getView();
        if ((r9 instanceof a) == true) goto L12;
        r9 = null;
    L12:
        a r10 = (a) r9;
        if (r10 == null) goto L32;
        if ((r1.get("current_tab") instanceof Double) == false) goto L23;
        Object r11 = r1.get("current_tab");
        if ((r11 instanceof Double) == true) goto L19;
        r11 = null;
    L19:
        Double r12 = (Double) r11;
        if (r12 == null) goto L30;
        int r13 = (int) r12.doubleValue();
    L31:
        r10.e(r13);
    L30:
        r13 = 0;
        goto L31
    L23:
        if ((r1.get("current_tab") instanceof Integer) == false) goto L30;
        Object r14 = r1.get("current_tab");
        if ((r14 instanceof Integer) == true) goto L27;
        r14 = null;
    L27:
        Integer r15 = (Integer) r14;
        if (r15 == null) goto L30;
        r13 = r15.intValue();
        goto L31
    }
}
