package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.component;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECHotAtmosphereView> {

    public static final class a {
    }

    static {
    }

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        super(r2);
    }

    public final void H0(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        Object r6 = r5.get("model");
        if (r6 == null) goto L21;
        JSONObject r7 = z1.g(u0.d(r6));
        if (r7 == null) goto L7;
        ECHotAtmosphere r2 = new ECHotAtmosphere();
        r2.uiType = 0;
        r2.img = r7.optString("avatar");
        r2.num = r7.optString("price");
        r2.prefix = r7.optString("prefix");
    L8:
        if (r2 == null) goto L18;
        ECHotAtmosphereView r8 = k1();
        if (r8 == null) goto L12;
        r8.setVisibility(0);
    L12:
        ECHotAtmosphereView r9 = k1();
        if (r9 == null) goto L15;
        r9.l(false);
    L15:
        ECHotAtmosphereView r10 = k1();
        if (r10 == null) goto L25;
        int r0 = ECHotAtmosphereView.D;
        r10.j(r2, true, false);
        return;
    L25:
        return;
    L18:
        ECHotAtmosphereView r11 = k1();
        if (r11 == null) goto L27;
        r11.setVisibility(8);
        return;
    L27:
        return;
    L7:
        r2 = null;
        goto L8
    L21:
        ECHotAtmosphereView r12 = k1();
        if (r12 == null) goto L29;
        r12.setVisibility(8);
        Unit r13 = Unit.INSTANCE;
        return;
    }

    public final View n1(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ECHotAtmosphereView r0 = new ECHotAtmosphereView(r4, null);
        ECHotAtmosphereView.g(r0, true, true, null, 4);
        return r0;
    }
}
