package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class n implements com.bytedance.ies.bullet.service.base.bridge.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<IBDXBridgeContext> f246298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.a f246299b;

    @Override // com.bytedance.ies.bullet.service.base.bridge.b.a
    public final void a(JSONObject r110) {
        if (r110 == null) goto L24;
        PlatformType r100 = null;
        if (com.bytedance.ies.bullet.service.base.h.n() == false) goto L17;
        IBDXBridgeContext r101 = this.f246298a.get();
        if (r101 == null) goto L9;
        le7.a<?> r102 = r101.getBridgeCall();
    L10:
        if (r102 == null) goto L17;
        if (r110.remove("ignoreJSB2Error") == null) goto L15;
        boolean r103 = true;
    L16:
        r102.I = r103;
        goto L17
    L15:
        r103 = false;
        goto L16
    L9:
        r102 = null;
    L17:
        IBDXBridgeContext r104 = this.f246298a.get();
        if (r104 == null) goto L21;
        r100 = r104.getPlatformType();
    L21:
        if (r100 != PlatformType.LYNX) goto L23;
        Object r105 = r110.remove("code");
        r110.remove("__data");
        JSONObject r106 = new JSONObject();
        r106.put("data", r110);
        r106.put("__msg_type", "callback");
        r106.put(com.heytap.mcssdk.constant.b.f276361k, CastLongProtector.parseLong(r110.optString("__callback_id", "0")));
        r106.put("__callback_id", "0");
        r106.put("code", r105);
        IDLXBridgeMethod.a r107 = this.f246299b;
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("__jsb2__data__", r106);
        r107.invoke(r108);
        goto L24
    L23:
        IDLXBridgeMethod.a r109 = this.f246299b;
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("__jsb2__data__", r110);
        r109.invoke(r111);
    L24:
        if (r110 != null) goto L27;
        IDLXBridgeMethod.a r112 = this.f246299b;
        LinkedHashMap r113 = new LinkedHashMap();
        r113.put("__jsb2__data__", new JSONObject());
        r112.invoke(r113);
        return;
    }

    public n(WeakReference<IBDXBridgeContext> r100, IDLXBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "weakBridgeContext");
        Intrinsics.checkNotNullParameter(r101, "callBack");
        this.f246298a = r100;
        this.f246299b = r101;
    }
}
