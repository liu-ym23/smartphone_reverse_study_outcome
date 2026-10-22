package com.bytedance.salamander.ability;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.platform.lynx.i;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.c;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ue7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class RtsBridge extends BDXBridge<ReadableMap, Object> implements d {
    public final String k;
    public final String l;
    public a m;
    public final Lazy n;
    public final Boolean o;

    public final c j() {
        return (i) this.n.getValue();
    }

    public final void u() {
        a r0 = this.m;
        if (r0 == null) goto L9;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rtsBridgeContext");
        r0 = null;
    L7:
        r0.b();
        return;
    }

    public final IDLXBridgeMethod.XBridgeThreadType n(le7.a<ReadableMap> r2) {
        Intrinsics.checkNotNullParameter(r2, "call");
        Intrinsics.areEqual(this.o, Boolean.FALSE);
        return null;
    }

    public RtsBridge(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerID");
        super(r2, r3);
        this.k = r3;
        this.l = "default_bid";
        this.n = LazyKt.lazy(RtsBridge$bridgeHandler$2.INSTANCE);
        this.o = Boolean.FALSE;
    }

    public final void a(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        JSONObject r0 = new JSONObject();
        if (r4 == null) goto L5;
        JSONObject r1 = new JSONObject(r4);
    L6:
        r0.put("data", r1);
        JavaOnlyArray r5 = new JavaOnlyArray();
        com.bytedance.sdk.xbridge.cn.platform.lynx.d.a.getClass();
        r5.pushMap(com.bytedance.sdk.xbridge.cn.platform.lynx.d.m(r0));
        a r2 = this.m;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rtsBridgeContext");
        r2 = null;
    L10:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r5, "params");
        r2.e.sendGlobalEvent(r3, r5);
        return;
    L5:
        r1 = new JSONObject();
        goto L6
    }
}
