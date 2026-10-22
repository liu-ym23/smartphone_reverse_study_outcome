package com.larus.live.impl.bridge.request;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.ies.xbridge.t;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f355779b;

    /* JADX INFO: renamed from: com.larus.live.impl.bridge.request.a$a, reason: collision with other inner class name */
    public interface InterfaceC4403a {
        void a(int r100, String r101, e r102);

        void b(e r100, String r101);
    }

    public static final class b implements InterfaceC4403a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f355780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f355781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ XBridgePlatformType f355782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f355783d;

        @Override // com.larus.live.impl.bridge.request.a.InterfaceC4403a
        public final void b(e r110, String r111) {
            Intrinsics.checkNotNullParameter(r110, "result");
            Intrinsics.checkNotNullParameter(r111, "msg");
            int r100 = e.f355798g;
            Map<String, Object> r101 = e.a.a(r110);
            if (r101 != null) goto L6;
            this.f355780a.f(this.f355781b.a(), this.f355781b.getUrl(), -1, -5, "Invalid results", this.f355782c.name());
            XCoreBridgeMethod.onFailure$default(this.f355780a, this.f355783d, -5, null, null, 12, null);
            return;
        L6:
            this.f355780a.onSuccess(this.f355783d, r101, r111);
        }

        @Override // com.larus.live.impl.bridge.request.a.InterfaceC4403a
        public final void a(int r100, String r101, e r110) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            if (r110 == null) goto L5;
            int r102 = e.f355798g;
            Map<String, Object> r111 = e.a.a(r110);
        L6:
            if (r111 != null) goto L9;
            XCoreBridgeMethod.onFailure$default(this.f355780a, this.f355783d, r100, r101, null, 8, null);
            return;
        L9:
            this.f355780a.onFailure(this.f355783d, r100, r101, r111);
            return;
        L5:
            r111 = new LinkedHashMap();
            goto L6
        }

        public b(a r100, d r101, XBridgePlatformType r102, XBridgeMethod.Callback r103) {
            this.f355780a = r100;
            this.f355781b = r101;
            this.f355782c = r102;
            this.f355783d = r103;
        }
    }

    public abstract void e(d r100, b r101, XBridgePlatformType r102);

    public a() {
        this.f355778a = "x.request";
        this.f355779b = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f355779b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f355778a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<d> provideParamModel() {
        return d.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<e> provideResultModel() {
        return e.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = d.f355790h;
        Intrinsics.checkNotNullParameter(r110, "data");
        String r101 = s.f(r110, "url", "");
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L13;
        String r104 = s.f(r110, com.alipay.sdk.m.p.e.f25671s, "");
        if (r104.length() != 0) goto L12;
        r102 = true;
    L12:
        if (r102 == true) goto L13;
        t r105 = r110.get(ContainerPosition.BODY);
        XReadableMap r106 = s.e(r110, "params");
        XReadableMap r113 = s.e(r110, "header");
        String r114 = s.f(r110, "bodyType", "");
        boolean r115 = s.b(r110, "addCommonParams", true);
        d r116 = new d();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r116.f355791a = r101;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r116.f355792b = r104;
        r116.f355794d = r105;
        r116.f355796f = r106;
        r116.f355797g = r113;
        r116.f355795e = r114;
        r116.f355793c = r115;
        d r107 = r116;
    L15:
        if (r107 != null) goto L18;
        f(s.f(r110, com.alipay.sdk.m.p.e.f25671s, ""), s.f(r110, "url", ""), -1, -3, "Invalid params", r112.name());
        XCoreBridgeMethod.onFailure$default(this, r111, -3, null, null, 12, null);
        return;
    L18:
        e(r107, new b(this, r107, r112, r111), r112);
        return;
    L13:
        r107 = null;
        goto L15
    L5:
        r103 = false;
        goto L7
    }

    public final void f(final String r110, final String r111, final Integer r112, final int r113, final String r114, final String r115) {
        r56.c r100 = (r56.c) provideContext(r56.c.class);
        r56.c r101 = r56.c.f536312g;
        TTExecutors.getNormalExecutor().execute(new yi9.a(r110, r111, r112, r113, r114, r115, this));
    }
}
