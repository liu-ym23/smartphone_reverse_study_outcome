package com.bytedance.locallife.bridge.groupon.method;

import android.text.TextUtils;
import com.bytedance.locallife.groupon.session.NearbySessionViewModel;
import com.bytedance.locallife.groupon.session.SessionParamsType;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "setSession", owner = "sirius.lin")
public final class z extends qo6.s {

    public static final class a {
    }

    static {
    }

    public z() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        qo6.s.b r113 = (qo6.s.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Objects.toString(r110.getOwnerActivity());
        if (TextUtils.isEmpty(r113.getRootId()) == true) goto L51;
        if (TextUtils.isEmpty(r113.getSessionId()) == true) goto L51;
        HashMap<String, NearbySessionViewModel> r114 = com.bytedance.locallife.groupon.session.c.f258809a;
        String r115 = r113.getRootId();
        Intrinsics.checkNotNullParameter(r115, "key");
        NearbySessionViewModel r116 = com.bytedance.locallife.groupon.session.c.f258809a.get(r115);
        if (r116 != null) goto L10;
    L55:
        r112.onSuccess(new a0(), "success");
        return;
    L10:
        if (r116.addSession(new com.bytedance.locallife.groupon.session.d(r113.getSessionId()), r113.getParentSessionId()) == true) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "addSession failed", null, 4, null);
    L12:
        String r100 = r113.getKey();
        Unit r101 = null;
        if (r100 == null) goto L31;
        String r102 = r113.getType();
        if (r102 == null) goto L27;
        SessionParamsType r103 = SessionParamsType.TRACK_PARAMS;
        if (Intrinsics.areEqual(r102, r103.toString()) == false) goto L19;
        r116.setSession(r113.getSessionId(), r100, r113.getValue(), r103);
    L26:
        Unit r104 = Unit.INSTANCE;
    L28:
        if (r104 != null) goto L30;
        NearbySessionViewModel.setSession$default(r116, r113.getSessionId(), r100, r113.getValue(), null, 8, null);
    L30:
        Unit r105 = Unit.INSTANCE;
    L32:
        if (r105 != null) goto L55;
        JSONObject r106 = new JSONObject(r113.getValue());     // Catch: JSONException -> L49
        HashMap<String, Object> r107 = new HashMap();     // Catch: JSONException -> L49
        r107.putAll(com.bytedance.locallife.common.utils.f.e(r106));     // Catch: JSONException -> L49
        String r108 = r113.getType();     // Catch: JSONException -> L49
        if (r108 == null) goto L46;
        SessionParamsType r109 = SessionParamsType.TRACK_PARAMS;     // Catch: JSONException -> L49
        if (Intrinsics.areEqual(r108, r109.toString()) == false) goto L38;
        r116.setSession(r113.getSessionId(), r107, r109);     // Catch: JSONException -> L49
    L45:
        r101 = Unit.INSTANCE;     // Catch: JSONException -> L49
        goto L46
    L38:
        SessionParamsType r117 = SessionParamsType.SCHEMA_PARAMS;     // Catch: JSONException -> L49
        if (Intrinsics.areEqual(r108, r117.toString()) == false) goto L41;
        r116.setSession(r113.getSessionId(), r107, r117);     // Catch: JSONException -> L49
        goto L45
    L41:
        SessionParamsType r118 = SessionParamsType.EXTRA_PARAMS;     // Catch: JSONException -> L49
        if (Intrinsics.areEqual(r108, r118.toString()) == false) goto L44;
        r116.setSession(r113.getSessionId(), r107, r118);     // Catch: JSONException -> L49
        goto L45
    L44:
        r116.setSession(r113.getSessionId(), r107, SessionParamsType.COMMON_PARAMS);     // Catch: JSONException -> L49
    L46:
        if (r101 != null) goto L55;
        NearbySessionViewModel.setSession$default(r116, r113.getSessionId(), r107, null, 4, null);     // Catch: JSONException -> L49
    L49:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "obj is invalid", null, 4, null);
        goto L55
    L19:
        SessionParamsType r119 = SessionParamsType.SCHEMA_PARAMS;
        if (Intrinsics.areEqual(r102, r119.toString()) == false) goto L22;
        r116.setSession(r113.getSessionId(), r100, r113.getValue(), r119);
        goto L26
    L22:
        SessionParamsType r120 = SessionParamsType.EXTRA_PARAMS;
        if (Intrinsics.areEqual(r102, r120.toString()) == false) goto L25;
        r116.setSession(r113.getSessionId(), r100, r113.getValue(), r120);
        goto L26
    L25:
        r116.setSession(r113.getSessionId(), r100, r113.getValue(), SessionParamsType.COMMON_PARAMS);
        goto L26
    L27:
        r104 = null;
        goto L28
    L31:
        r105 = null;
    L51:
        if (TextUtils.isEmpty(r113.getRootId()) == false) goto L53;
        String r121 = "rootId";
    L54:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, r121.concat(" is null"), null, 4, null);
        goto L55
    L53:
        r121 = "sessionId";
        goto L54
    }
}
