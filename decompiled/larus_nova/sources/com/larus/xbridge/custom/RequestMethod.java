package com.larus.xbridge.custom;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.lynx.bridge.LynxBridgeModule;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@XBridgeMethod(name = "request")
public final class RequestMethod extends com.bytedance.sdk.xbridge.cn.network.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f379681e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @XBridgeMethodName(name = "request", params = {"addCommonParams", "url", com.alipay.sdk.m.p.e.f25671s, ContainerPosition.BODY, "bodyType", "params", "header", LynxBridgeModule.KEY_USE_UI_THREAD, "usePrefetch"}, results = {"httpCode", "clientCode", "header", "response", "responseType", "rawResponse", "prefetchStatus"})
    public final String f379682d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/xbridge/custom/RequestMethod$RequestMethodType;", "", com.alipay.sdk.m.p.e.f25671s, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMethod", "()Ljava/lang/String;", "GET", "POST", "PUT", "DELETE", "UNSUPPORTED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RequestMethodType extends Enum<RequestMethodType> {
        public static final a Companion = null;
        public static final RequestMethodType DELETE = null;
        public static final RequestMethodType GET = null;
        public static final RequestMethodType POST = null;
        public static final RequestMethodType PUT = null;
        public static final RequestMethodType UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestMethodType[] f379683a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f379684b = null;
        private final String method;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RequestMethodType> getEntries() {
            return f379684b;
        }

        static {
            RequestMethodType r100 = new RequestMethodType("GET", 0, MonitorConstants.CONNECT_TYPE_GET);
            GET = r100;
            RequestMethodType r101 = new RequestMethodType("POST", 1, UGCMonitor.TYPE_POST);
            POST = r101;
            RequestMethodType r102 = new RequestMethodType("PUT", 2, "put");
            PUT = r102;
            RequestMethodType r103 = new RequestMethodType("DELETE", 3, "delete");
            DELETE = r103;
            RequestMethodType r104 = new RequestMethodType("UNSUPPORTED", 4, "unsupported");
            UNSUPPORTED = r104;
            RequestMethodType[] r105 = {r100, r101, r102, r103, r104};
            f379683a = r105;
            f379684b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static RequestMethodType[] values() {
            return (RequestMethodType[]) f379683a.clone();
        }

        public final String getMethod() {
            return this.method;
        }

        public static RequestMethodType valueOf(String r100) {
            return (RequestMethodType) r27.a.a(RequestMethodType.class, r100);
        }

        public RequestMethodType(String r100, int r101, String r102) {
            super(r100, r101);
            this.method = r102;
        }
    }

    public static final class a {
    }

    public interface b {
        String a();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    static {
    }

    public RequestMethod() {
        this.f379682d = "request";
    }

    @Override // com.bytedance.sdk.xbridge.cn.network.a, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f379682d;
    }

    public static final void a(RequestMethod r100) {
        r100.getClass();
        id7.c.f489344d.getClass();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(final IBDXBridgeContext r210, XBaseParamModel r211, final CompletionBlock r212) {
        final com.bytedance.sdk.xbridge.cn.network.a.b r100 = (com.bytedance.sdk.xbridge.cn.network.a.b) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        final long r101 = System.currentTimeMillis();
        Boolean r102 = r100.getUsePrefetch();
        Activity r103 = r210.getOwnerActivity();
        if (r103 == null) goto L5;
        Context r104 = r103.getApplicationContext();
    L6:
        final m16.b r110 = (m16.b) r210.getService(m16.b.class);
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r105) == false) goto L20;
        if (r104 == null) goto L20;
        if ((r100.getBody() instanceof Map) == false) goto L12;
        Object r106 = r100.getBody();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        JSONObject r107 = new JSONObject((Map) r106);
    L13:
        String r111 = r100.getUrl();
        String r112 = r100.getMethod();
        Map<String, String> r113 = com.bytedance.ies.bullet.prefetchv2.u.a(r100.getHeader());
        Map<String, String> r114 = com.bytedance.ies.bullet.prefetchv2.u.a(r100.getParams());
        boolean r115 = r100.getAddCommonParams();
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, com.alipay.sdk.m.p.e.f25671s);
        com.bytedance.ies.bullet.prefetchv2.p r108 = new com.bytedance.ies.bullet.prefetchv2.p(r111, r112, r113, r114, r107, r115, false, false, ISmModel.VERSION_0600);
        com.bytedance.ies.bullet.prefetchv2.a0 r109 = com.bytedance.ies.bullet.prefetchv2.a0.f247513a;
        com.bytedance.ies.bullet.prefetchv2.v r116 = com.bytedance.ies.bullet.prefetchv2.a0.a(r108);
        if (r116 == null) goto L16;
        CompletionBlock.DefaultImpls.onSuccess$default(r212, h2.a(r116, 2), null, 2, null);
        c(r110, r100.getUrl(), true, 2, "hit cache", System.currentTimeMillis() - r101, r116.f247608h);
        return;
    L16:
        com.bytedance.ies.bullet.prefetchv2.z r117 = com.bytedance.ies.bullet.prefetchv2.a0.c(r108);
        if (r117 == null) goto L20;
        r117.d(new b2(r212, this, r110, r100, r101));
        return;
    L12:
        r107 = new JSONObject();
    L20:
        if (Intrinsics.areEqual(r102, r105) == false) goto L22;
        int r118 = com.bytedance.ies.bullet.prefetchv2.j.f247548a;
        com.bytedance.ies.bullet.prefetchv2.j.b("未命中prefetch，请检查bridge请求参数跟配置是否匹配: " + r100.getUrl());
        com.larus.utils.t0.a(new y1(r110, this, r100, r101));
    L22:
        RequestMethodType.a r119 = RequestMethodType.Companion;
        String r120 = r100.getMethod();
        r119.getClass();
        if (r120 != null) goto L42;
        RequestMethodType r121 = RequestMethodType.UNSUPPORTED;
    L28:
        final RequestMethodType r122 = r121;
        final PlatformType r123 = r210.getPlatformType();
        if (r122 != RequestMethodType.UNSUPPORTED) goto L31;
        b(r210, r100.getMethod(), r100.getUrl(), 0, -3, "Illegal method " + r100.getMethod(), r123.name());
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "Illegal method " + r100.getMethod(), null, 4, null);
        return;
    L31:
        final Map<String, Object> r124 = r100.getHeader();
        final Object r125 = r100.getBody();
        final String r126 = r100.getBodyType();
        final Map<String, Object> r127 = r100.getParams();
        if (TextUtils.isEmpty(r100.getUrl()) == false) goto L34;
        b(r210, r100.getMethod(), r100.getUrl(), 0, -3, "Illegal empty url", r123.name());
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "url is empty", null, 4, null);
        return;
    L34:
        final long r128 = System.currentTimeMillis();
        int r129 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostThreadPoolExecutorDepend r130 = XBaseRuntime.f270109o;
        if (r130 != null) goto L37;
        r130 = new qe7.d();
    L37:
        ExecutorService r131 = r130.getNormalThreadExecutor();
        if (r131 != null) goto L40;
        r131 = TTExecutors.getNormalExecutor();
    L40:
        r131.execute(new z1(r124, r210, r100, r127, r123, r122, r125, r126, this, r128, r212));
        return;
    L42:
        r121 = RequestMethodType.valueOf(r120.toUpperCase(Locale.ROOT));     // Catch: Exception -> L26
    L26:
        r121 = RequestMethodType.UNSUPPORTED;
        goto L28
    L5:
        r104 = null;
        goto L6
    }

    public final void b(final IBDXBridgeContext r110, final String r111, final String r112, final Integer r113, final int r114, final String r115, final String r116) {
        int r100 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostThreadPoolExecutorDepend r101 = XBaseRuntime.f270109o;
        if (r101 != null) goto L5;
        r101 = new qe7.d();
    L5:
        ExecutorService r102 = r101.getNormalThreadExecutor();
        if (r102 != null) goto L8;
        r102 = TTExecutors.getNormalExecutor();
    L8:
        r102.execute(new a2(r111, r112, r113, r114, r115, r116, r110));
    }

    public final void c(m16.b r110, String r111, boolean r112, int r113, String r114, long r115, String r210) {
        int r100 = com.bytedance.ies.bullet.prefetchv2.o.f247562a;
        if (r110 == null) goto L10;
        h16.e r101 = (h16.e) r110.c(h16.e.class);
        if (r101 == null) goto L10;
        BulletContext r102 = r101.getBulletContext();
        if (r102 == null) goto L10;
        String r103 = r102.f246438f;
        if (r103 == null) goto L10;
    L11:
        String r104 = r103;
        if (r110 == null) goto L18;
        h16.e r105 = (h16.e) r110.c(h16.e.class);
        if (r105 == null) goto L18;
        BulletContext r106 = r105.getBulletContext();
        if (r106 == null) goto L18;
        a36.a r107 = r106.f246449q;
    L19:
        com.bytedance.ies.bullet.prefetchv2.o.a(new com.bytedance.ies.bullet.prefetchv2.n(r104, r107, r111, r112, r113, r114, r115, r210));
        return;
    L18:
        r107 = null;
    L10:
        r103 = "default_bid";
        goto L11
    }
}
