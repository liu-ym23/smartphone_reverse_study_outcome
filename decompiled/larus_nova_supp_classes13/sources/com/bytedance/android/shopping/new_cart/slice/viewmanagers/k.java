package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.slice.widgets.CartLynxPendantView;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.android.ecom.arch.slice.render.elements.b<CartLynxPendantView> {
    public String H3;
    public final Function0<CartSliceCustomWidgetAdapterComponent> I3;

    public final void H0(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "props");
        Object r0 = r6.get("schema");
        Object r2 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        Object r3 = r6.get("config");
        if ((r3 instanceof String) == true) goto L8;
        r3 = null;
    L8:
        String r4 = (String) r3;
        Object r5 = r6.get("pass_param");
        if ((r5 instanceof Map) == true) goto L11;
        r5 = null;
    L11:
        Map<String, ? extends Object> r7 = (Map) r5;
        Object r8 = r6.get("loadFromCache");
        if ((r8 instanceof String) == false) goto L16;
        r2 = r8;
    L16:
        if (Intrinsics.areEqual((String) r2, "1") == false) goto L18;
        return;
    L18:
        JSONObject r9 = z1.g(r4);
        if ((!Intrinsics.areEqual(this.H3, r1)) == false) goto L21;
        this.H3 = r1;
        ((CartLynxPendantView) l1()).c(r1, r9, this.I3, r7);
        return;
    L21:
        ((CartLynxPendantView) l1()).d(r7);
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new CartLynxPendantView(r5, null, 6, 0);
    }

    public k(SlcTemplateContext r2, Function0<CartSliceCustomWidgetAdapterComponent> r3) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        Intrinsics.checkNotNullParameter(r3, "provider");
        super(r2);
        this.I3 = r3;
    }
}
