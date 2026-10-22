package com.bytedance.salamander.ability;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.platform.lynx.i;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.c;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ue7.d;

/* JADX INFO: loaded from: classes16.dex */
public final class RtsBridge extends BDXBridge<ReadableMap, Object> implements d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f267768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f267769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f267770m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f267771n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f267772o;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final c<ReadableMap, Object> j() {
        return (i) this.f267771n.getValue();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final void u() {
        a r100 = this.f267770m;
        if (r100 == null) goto L9;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rtsBridgeContext");
        r100 = null;
    L7:
        r100.b();
        return;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.BDXBridge
    public final IDLXBridgeMethod.XBridgeThreadType n(le7.a<ReadableMap> r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.areEqual(this.f267772o, Boolean.FALSE);
        return null;
    }

    public RtsBridge(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerID");
        super(r100, r101);
        this.f267768k = r101;
        this.f267769l = "default_bid";
        this.f267771n = LazyKt.lazy(RtsBridge$bridgeHandler$2.INSTANCE);
        this.f267772o = Boolean.FALSE;
    }

    @Override // ue7.d
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        JSONObject r102 = new JSONObject();
        if (r101 == null) goto L5;
        JSONObject r103 = new JSONObject(r101);
    L6:
        r102.put("data", r103);
        JavaOnlyArray r104 = new JavaOnlyArray();
        com.bytedance.sdk.xbridge.cn.platform.lynx.d.f269973a.getClass();
        r104.pushMap(com.bytedance.sdk.xbridge.cn.platform.lynx.d.m(r102));
        a r105 = this.f267770m;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rtsBridgeContext");
        r105 = null;
    L10:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r104, "params");
        r105.f267773e.sendGlobalEvent(r100, r104);
        return;
    L5:
        r103 = new JSONObject();
        goto L6
    }
}
