package com.bytedance.android.shopping.slice;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.util.h;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.anchorv4.experiment.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpSliceRegister {
    public static boolean a;
    public static volatile JSONObject b;
    public static final Function0<JSONObject> c = null;
    public static final Lazy d = null;

    static {
        c = PdpSliceRegister$pdpSliceSettingProvider$1.INSTANCE;
        d = LazyKt.lazy(PdpSliceRegister$preloadInfo$2.INSTANCE);
    }

    public static Function0 a() {
        int r0 = i.a;
        JSONObject r1 = (JSONObject) c.invoke();
        if (r1 == null) goto L9;
        if (r1.optBoolean("disable_preload_pdp_template", false) != true) goto L9;
        return null;
    L9:
        return PdpSliceRegister$getPreloadInfoProvider$1.INSTANCE;
    }

    public static void c() {
        h.a(PdpSliceRegister$register$1.INSTANCE);
    }

    public static void b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "pdp", "pdp_slice_template", wh.a.b(r4), a());
    }
}
