package com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.d;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends DynamicParamsController {
    public final Map<String, Double> e;
    public String f;
    public boolean g;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a$a, reason: collision with other inner class name */
    public static final class C0108a {
    }

    static {
    }

    public a() {
        this.e = new LinkedHashMap();
    }

    public static final void c(a r3, DynamicParamsType r4, Object r5) {
        r3.getClass();
        if ((r5 instanceof String) == true) goto L5;
        r5 = null;
    L5:
        String r6 = (String) r5;
        if (r6 == null) goto L14;
        Map r7 = cd.a.e(new JSONObject(r6));     // Catch: JSONException -> L9
        r3.b(MapsKt.mapOf(new Pair[]{TuplesKt.to("paramsType", Integer.valueOf(r4.getValue())), TuplesKt.to("params", r7)}));     // Catch: JSONException -> L9
        r3.g = true;     // Catch: JSONException -> L9
        Lazy r8 = ECMallLogUtil.a;     // Catch: JSONException -> L9
        ECMallLogUtil.c(d.c.b, "handleWhiteBoardParams ," + r7);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "paras white board dynamic params error");
        return;
    }
}
