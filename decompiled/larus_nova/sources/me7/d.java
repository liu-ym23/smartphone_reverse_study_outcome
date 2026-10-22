package me7;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements IBDXBridgeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f513516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final le7.a<?> f513517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f513518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f513519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PlatformType f513520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ue7.d f513521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f513522g;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final View getEngineView() {
        return this.f513516a.f513512b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final Activity getOwnerActivity() {
        return this.f513516a.getOwnerActivity();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final le7.a<?> getBridgeCall() {
        return this.f513517b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final String getCallId() {
        return this.f513522g;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getContainerID() {
        return this.f513518c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final ue7.d getJsEventDelegate() {
        return this.f513521f;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getNamespace() {
        return this.f513519d;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f513520e;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) this.f513516a.getService(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final void setCallId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f513522g = r100;
    }

    public d(c r100, le7.a<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeCall");
        this.f513516a = r100;
        this.f513517b = r101;
        this.f513518c = r100.f513511a;
        this.f513519d = r100.f513513c;
        this.f513520e = r100.getPlatformType();
        this.f513521f = r100.getJsEventDelegate();
        this.f513522g = r101.f508945c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f513516a.sendEvent(r100, r101);
    }
}
