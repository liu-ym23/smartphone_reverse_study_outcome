package com.bytedance.caijing.sdk.infra.base.impl.container;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements IBDXBridgeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f202500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f202501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f202502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f202503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f202504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PlatformType f202505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ BulletServiceImpl.b f202506g;

    public static final class a extends le7.a<String> {
        public final String M;
        public final PlatformType N;
        public final String O;

        public a() {
            super("unknown");
            this.M = "fakeBridgeCall";
            this.N = PlatformType.WEB;
            this.O = "fakeBridgeCall";
        }

        @Override // le7.a
        public final String b() {
            return this.M;
        }

        @Override // le7.a
        public final PlatformType c() {
            return this.N;
        }

        @Override // le7.a
        public final String d() {
            return this.O;
        }
    }

    public static final class b implements ue7.d {
        public b() {
        }

        @Override // ue7.d
        public final void a(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final View getEngineView() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final Activity getOwnerActivity() {
        XCoreBridgeMethod r100 = (XCoreBridgeMethod) this.f202506g.g(XCoreBridgeMethod.class);
        if (r100 == null) goto L5;
        Context r101 = (Context) r100.provideContext(Context.class);
    L7:
        if ((r101 instanceof Activity) == true) goto L9;
        return null;
    L9:
        return (Activity) r101;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final le7.a<?> getBridgeCall() {
        return this.f202500a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final String getCallId() {
        return this.f202501b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getContainerID() {
        return this.f202502c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final ue7.d getJsEventDelegate() {
        return this.f202503d;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getNamespace() {
        return this.f202504e;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f202505f;
    }

    public e(BulletServiceImpl.b r100) {
        this.f202506g = r100;
        this.f202500a = new a();
        this.f202501b = "bridgeCall.id";
        this.f202502c = "";
        this.f202503d = new b();
        this.f202504e = "";
        this.f202505f = PlatformType.WEB;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        XCoreBridgeMethod r101 = (XCoreBridgeMethod) this.f202506g.g(XCoreBridgeMethod.class);
        if (r101 == null) goto L6;
        T r102 = (T) r101.provideContext(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        XCoreBridgeMethod r103 = (XCoreBridgeMethod) this.f202506g.g(XCoreBridgeMethod.class);
        if (r103 == null) goto L11;
        m16.b r104 = (m16.b) r103.provideContext(m16.b.class);
        if (r104 == null) goto L11;
        return (T) r104.c(r100);
    L11:
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final void setCallId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f202501b = r100;
    }
}
