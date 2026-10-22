package com.ivy.ivykit.plugin.impl.jsb;

import android.app.Activity;
import android.view.View;
import com.bytedance.ai.bridge.core.adapter.XBridge3ToAIBridgeAdapter;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class n implements IBDXBridgeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bx7.a f278402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final le7.a<?> f278403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f278404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f278405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f278406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f278407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PlatformType f278408g;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final View getEngineView() {
        return this.f278402a.getEngineView();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final Activity getOwnerActivity() {
        return this.f278402a.getOwnerActivity();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final le7.a<?> getBridgeCall() {
        return this.f278403b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final String getCallId() {
        return this.f278404c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getContainerID() {
        return this.f278405d;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final ue7.d getJsEventDelegate() {
        return this.f278406e;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getNamespace() {
        return this.f278407f;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f278408g;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) this.f278402a.getService(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final void setCallId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f278404c = r100;
    }

    public n(XBridge3ToAIBridgeAdapter.a r100, com.bytedance.sdk.xbridge.cn.platform.web.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bridgeCall");
        this.f278402a = r100;
        this.f278403b = r101;
        this.f278404c = UUID.randomUUID().toString();
        this.f278405d = r100.f35253b;
        this.f278406e = new m(this);
        this.f278407f = "";
        this.f278408g = r101.O;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f278402a.sendEvent(r100, r101);
    }
}
