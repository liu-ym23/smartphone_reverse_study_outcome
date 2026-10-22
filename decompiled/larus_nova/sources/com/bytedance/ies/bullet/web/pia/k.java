package com.bytedance.ies.bullet.web.pia;

import android.app.Activity;
import android.view.View;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.platform.web.WebPlatformDataProcessor;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements PiaMethod.a<JSONObject, Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WebPlatformDataProcessor f248322d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f248323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f248324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDLXBridgeMethod f248325c;

    public static final class a {
    }

    public static final class b implements IBDXBridgeContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d47.a f248326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final le7.a<?> f248327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f248328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f248329d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PlatformType f248330e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final l f248331f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f248332g;

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final View getEngineView() {
            return null;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final Activity getOwnerActivity() {
            return null;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final <T> T getService(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            return null;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
        public final le7.a<?> getBridgeCall() {
            return this.f248327b;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
        public final String getCallId() {
            return this.f248332g;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final String getContainerID() {
            return this.f248329d;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final ue7.d getJsEventDelegate() {
            return this.f248331f;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final String getNamespace() {
            return this.f248328c;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final PlatformType getPlatformType() {
            return this.f248330e;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
        public final void setCallId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f248332g = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
        public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            this.f248326a.a(r100, r101);
        }

        public b(m47.o r100, com.bytedance.sdk.xbridge.cn.platform.web.b r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "piaBridge");
            Intrinsics.checkNotNullParameter(r101, "bridgeCall");
            Intrinsics.checkNotNullParameter(r102, "namespace");
            this.f248326a = r100;
            this.f248327b = r101;
            this.f248328c = r102;
            this.f248329d = "";
            this.f248330e = r101.O;
            this.f248331f = new l(this);
            this.f248332g = UUID.randomUUID().toString();
        }
    }

    static {
        f248322d = new WebPlatformDataProcessor();
    }

    public k(String r100, String r101, IDLXBridgeMethod r102) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        Intrinsics.checkNotNullParameter(r102, "xBridgeMethod");
        this.f248323a = r100;
        this.f248324b = r101;
        this.f248325c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.a
    public final void a(m47.o r100, Object r101, m47.h r102, m47.i r103) {
        JSONObject r104 = (JSONObject) r101;
        Intrinsics.checkNotNullParameter(r100, "bridge");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r103, "reject");
        if (r104 != null) goto L5;
        r104 = new JSONObject();
    L5:
        Map<String, Map<Class<?>, Object>> r105 = x26.a.f562251a;
        w26.g r106 = (w26.g) x26.a.a(w26.g.class);
        if (r106 == null) goto L12;
        w26.e r107 = (w26.e) r106.n0(w26.e.class);
        if (r107 == null) goto L12;
        Boolean r108 = r107.F1();
        if (r108 == null) goto L12;
        boolean r109 = r108.booleanValue();
    L13:
        if (r109 == false) goto L26;
        String r110 = this.f248325c.getName();
        if (Intrinsics.areEqual(r110, "x.request") == false) goto L18;
        String r111 = "header";
    L21:
        if (r111 == null) goto L26;
        JSONObject r112 = r104.optJSONObject(r111);
        if (r112 != null) goto L25;
        r112 = new JSONObject();
    L25:
        r112.put("Anniex-Prefetch", "1");
        r104.put(r111, r112);
        goto L26
    L18:
        if (Intrinsics.areEqual(r110, "fetch") == false) goto L20;
        r111 = "headers";
        goto L21
    L20:
        r111 = null;
    L26:
        Map<String, Object> r113 = f248322d.l(r104, this.f248325c.getClass());
        if (r113 != null) goto L31;
        r113 = ConvertUtils.INSTANCE.jsonToMap(r104);
        if (r113 != null) goto L31;
        r113 = MapsKt.emptyMap();
    L31:
        String r114 = "";
        com.bytedance.sdk.xbridge.cn.platform.web.b r115 = new com.bytedance.sdk.xbridge.cn.platform.web.b(this.f248324b, r104, "");
        if (Intrinsics.areEqual(this.f248323a, "webcast") == false) goto L34;
        r114 = "webcast";
    L34:
        b r116 = new b(r100, r115, r114);
        if (Intrinsics.areEqual(this.f248323a, "webcast") == false) goto L37;
        IDLXBridgeMethod.a r117 = new n(r102, this, r116, r103);
    L38:
        this.f248325c.realHandle(r116, r113, r117);
        if ((this.f248325c instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == false) goto L42;
        r100.getContext().b(new m(this));
        return;
    L42:
        return;
    L37:
        r117 = new o(r102, r103);
    L12:
        r109 = true;
        goto L13
    }
}
