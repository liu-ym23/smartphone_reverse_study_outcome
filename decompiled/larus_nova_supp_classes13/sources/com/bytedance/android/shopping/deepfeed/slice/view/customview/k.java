package com.bytedance.android.shopping.deepfeed.slice.view.customview;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b {
    public k(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateCtx");
        super(r2);
    }

    public final /* bridge */ /* synthetic */ View A0(Context r1) {
        return J1(r1);
    }

    public final void H0(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        Object r6 = r5.get("longPressAction");
        Object r1 = null;
        if ((r6 instanceof Map) == true) goto L5;
        r6 = null;
    L5:
        Map r7 = (Map) r6;
        if (r7 == null) goto L8;
        Object r0 = r7.get("type");
    L10:
        if ((r0 instanceof String) == true) goto L12;
        r0 = null;
    L12:
        String r2 = (String) r0;
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        if (r7 == null) goto L17;
        Object r8 = r7.get("fields");
    L19:
        if ((r8 instanceof Map) == true) goto L21;
        r8 = null;
    L21:
        Map r9 = (Map) r8;
        View r3 = getView();
        if ((r3 instanceof DeepFeedSlcLongPressView) == false) goto L25;
        r1 = r3;
    L25:
        DeepFeedSlcLongPressView r4 = (DeepFeedSlcLongPressView) r1;
        if (r4 == null) goto L29;
        r4.l = new Pair(r2, r9);
        return;
    L29:
        return;
    L17:
        r8 = null;
        goto L19
    L8:
        r0 = null;
        goto L10
    }

    public final SlcFlexElementView J1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        DeepFeedSlcLongPressView r0 = new DeepFeedSlcLongPressView(r3);
        SlcTemplateContext r4 = ((BaseSlcViewManager) this).a;
        Intrinsics.checkNotNullParameter(r4, "templateCtx");
        r0.k = r4;
        return r0;
    }
}
