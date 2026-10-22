package com.bytedance.locallife.bridge.groupon.method;

import android.text.TextUtils;
import com.bytedance.locallife.groupon.session.NearbySessionViewModel;
import com.bytedance.locallife.groupon.session.SessionParamsType;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "getSession", owner = "sirius.lin")
public final class e extends qo6.d {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        qo6.d.b r113 = (qo6.d.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Objects.toString(r110.getOwnerActivity());
        if (TextUtils.isEmpty(r113.getRootId()) == false) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "rootSessionId is null", null, 4, null);
        return;
    L5:
        HashMap<String, NearbySessionViewModel> r114 = com.bytedance.locallife.groupon.session.c.f258809a;
        String r115 = r113.getRootId();
        Intrinsics.checkNotNullParameter(r115, "key");
        NearbySessionViewModel r116 = com.bytedance.locallife.groupon.session.c.f258809a.get(r115);
        if (r116 == null) goto L49;
        String r100 = r113.getKey();
        if (r100 != null) goto L10;
        String r101 = r113.getType();
        if (r101 != null) goto L19;
        HashMap<String, Object> r117 = r116.getSessionParams(r113.getSessionId());
        if (r117 == null) goto L47;
        Map<String, Object> r118 = com.bytedance.locallife.groupon.basic.utils.b.a(r117);
    L48:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, new f(r118), null, 2, null);
        return;
    L47:
        r118 = null;
        goto L48
    L19:
        if (Intrinsics.areEqual(r101, SessionParamsType.TRACK_PARAMS.toString()) == false) goto L26;
        HashMap<String, Object> r119 = r116.getTrackParams(r113.getSessionId());
        if (r119 == null) goto L23;
        Map<String, Object> r120 = com.bytedance.locallife.groupon.basic.utils.b.a(r119);
    L24:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, new f(r120), null, 2, null);
        return;
    L23:
        r120 = null;
        goto L24
    L26:
        if (Intrinsics.areEqual(r101, SessionParamsType.SCHEMA_PARAMS.toString()) == false) goto L33;
        HashMap<String, Object> r121 = r116.getSchemaParams(r113.getSessionId());
        if (r121 == null) goto L30;
        Map<String, Object> r122 = com.bytedance.locallife.groupon.basic.utils.b.a(r121);
    L31:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, new f(r122), null, 2, null);
        return;
    L30:
        r122 = null;
        goto L31
    L33:
        if (Intrinsics.areEqual(r101, SessionParamsType.EXTRA_PARAMS.toString()) == false) goto L39;
        HashMap<String, Object> r123 = r116.getExtraParams(r113.getSessionId());
        if (r123 == null) goto L37;
        Map<String, Object> r124 = com.bytedance.locallife.groupon.basic.utils.b.a(r123);
    L38:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, new f(r124), null, 2, null);
        return;
    L37:
        r124 = null;
        goto L38
    L39:
        HashMap<String, Object> r125 = r116.getCommomParams(r113.getSessionId());
        if (r125 == null) goto L42;
        Map<String, Object> r126 = com.bytedance.locallife.groupon.basic.utils.b.a(r125);
    L43:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, new f(r126), null, 2, null);
        return;
    L42:
        r126 = null;
        goto L43
    L10:
        if (TextUtils.isEmpty(r113.getSessionId()) == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "sessionId is null", null, 4, null);
        return;
    L12:
        HashMap r102 = new HashMap();
        Object r127 = r116.get(r113.getSessionId(), r100);
        if (r127 == null) goto L15;
        r102.put(r100, r127);
    L15:
        Unit r128 = Unit.INSTANCE;
        CompletionBlock.DefaultImpls.onSuccess$default(r112, new f(r102), null, 2, null);
        return;
    L49:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, " rootSessionId not find", null, 4, null);
    }
}
