package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import android.content.Context;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@XBridgeMethod(name = "ttcjpay.checkCJPlugin")
public final class j extends com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f202647k;

    public static final class a {
    }

    static {
    }

    public j() {
        this.f202647k = "ttcjpay.checkCJPlugin";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f202647k;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.a, com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod
    public final void e(Context r100, JSONObject r101, IXPayBaseMethod.c r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r103 = r101.optString("action");
        if (r103 == null) goto L27;
        int r104 = r103.hashCode();
        if (r104 == (-1601163630)) goto L21;
        if (r104 == (-1430593133)) goto L18;
        if (r104 != (-733034575)) goto L27;
        if (r103.equals("check_cjplugin") == false) goto L27;
        ve4.a.f554342a.getClass();
        CJHostService r105 = (CJHostService) ve4.a.a(CJHostService.class);
        if (r105 == null) goto L16;
        r105.getEnvController();
    L16:
        JSONObject r106 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r106, "cj_plugin_status", "unknown");
        Unit r107 = Unit.INSTANCE;
        r102.success(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_data", r106)}));
        return;
    L18:
        if (r103.equals("load_cjplugin") == false) goto L27;
    L23:
        ve4.a.f554342a.getClass();
        CJHostService r108 = (CJHostService) ve4.a.a(CJHostService.class);
        if (r108 == null) goto L26;
        r108.getEnvController();
    L26:
        JSONObject r109 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r109, "error_msg", "CJHostService is null or getEnvController is null");
        Unit r110 = Unit.INSTANCE;
        r102.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_data", r109)}), "CJHostService is null or getEnvController is null");
        return;
    L21:
        if (r103.equals("prepare_cjplugin") == true) goto L23;
    L27:
        JSONObject r111 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r111, "error_msg", "action is invalid");
        Unit r112 = Unit.INSTANCE;
        r102.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cj_data", r111)}), "action is invalid");
    }
}
