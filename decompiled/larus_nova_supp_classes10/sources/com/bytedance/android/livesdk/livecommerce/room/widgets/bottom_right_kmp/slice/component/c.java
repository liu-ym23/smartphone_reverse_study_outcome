package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.component;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.ECAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.ECAtmosphereView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECAtmosphereView> {

    public static final class a {
    }

    static {
    }

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        Object r0 = r4.get("hot_sale_model");
        if (r0 == null) goto L16;
        ECHotAtmosphere r5 = (ECHotAtmosphere) u0.b(u0.d(r0), ECHotAtmosphere.class);
        if (r5 == null) goto L12;
        ECAtmosphereView r1 = (ECAtmosphereView) k1();
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        ECAtmosphereView r2 = (ECAtmosphereView) k1();
        if (r2 == null) goto L34;
        r2.b(r5);
        return;
    L34:
        return;
    L12:
        ECAtmosphereView r6 = (ECAtmosphereView) k1();
        if (r6 == null) goto L36;
        r6.setVisibility(8);
        return;
    L36:
        return;
    L16:
        Object r7 = r4.get("goods_atmosphere");
        if (r7 == null) goto L30;
        ECAtmosphere r8 = (ECAtmosphere) u0.b(u0.d(r7), ECAtmosphere.class);
        if (r8 == null) goto L26;
        ECAtmosphereView r3 = (ECAtmosphereView) k1();
        if (r3 == null) goto L23;
        r3.setVisibility(0);
    L23:
        ECAtmosphereView r9 = (ECAtmosphereView) k1();
        if (r9 == null) goto L37;
        r9.a(r8);
        return;
    L37:
        return;
    L26:
        ECAtmosphereView r10 = (ECAtmosphereView) k1();
        if (r10 == null) goto L39;
        r10.setVisibility(8);
        return;
    L39:
        return;
    L30:
        ECAtmosphereView r11 = (ECAtmosphereView) k1();
        if (r11 == null) goto L40;
        r11.setVisibility(8);
        return;
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new ECAtmosphereView(r5, null, 6, 0);
    }
}
