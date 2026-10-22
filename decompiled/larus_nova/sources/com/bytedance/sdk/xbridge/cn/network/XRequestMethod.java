package com.bytedance.sdk.xbridge.cn.network;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import bolts.Task;
import com.byted.cast.common.source.ISendResultListener;
import com.bytedance.android.anniex.ability.service.IAnnieXAccountService;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.InjectLoginStateParams;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.prefetchv2.a0;
import com.bytedance.ies.bullet.prefetchv2.h;
import com.bytedance.ies.bullet.prefetchv2.n;
import com.bytedance.ies.bullet.prefetchv2.p;
import com.bytedance.ies.bullet.prefetchv2.u;
import com.bytedance.ies.bullet.prefetchv2.v;
import com.bytedance.ies.bullet.prefetchv2.y;
import com.bytedance.ies.bullet.prefetchv2.z;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.salamander.anniex.g7;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import q26.j;
import te7.i;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.request")
public final class XRequestMethod extends com.bytedance.sdk.xbridge.cn.network.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f269864d = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/XRequestMethod$RequestMethodType;", "", "", com.alipay.sdk.m.p.e.f25671s, "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GET", "POST", "PUT", "DELETE", "UNSUPPORTED", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum RequestMethodType extends Enum<RequestMethodType> {
        public static final a Companion = null;
        public static final RequestMethodType DELETE = null;
        public static final RequestMethodType GET = null;
        public static final RequestMethodType POST = null;
        public static final RequestMethodType PUT = null;
        public static final RequestMethodType UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestMethodType[] f269865a = null;
        private final String method;

        public static final class a {
            public a() {
            }
        }

        public static RequestMethodType valueOf(String r100) {
            return (RequestMethodType) r27.a.a(RequestMethodType.class, r100);
        }

        public static RequestMethodType[] values() {
            return (RequestMethodType[]) f269865a.clone();
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
            f269865a = new RequestMethodType[]{r100, r101, r102, r103, r104};
            Companion = new a();
        }

        public final String getMethod() {
            return this.method;
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

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f269867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f269868c;

        public c(com.bytedance.sdk.xbridge.cn.network.a.b r100, IBDXBridgeContext r101, v r102) {
            this.f269866a = r100;
            this.f269867b = r101;
            this.f269868c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            de7.b r100 = de7.b.f468072a;
            String r101 = this.f269866a.getStreamSessionId();
            Intrinsics.checkNotNull(r101);
            IBDXBridgeContext r102 = this.f269867b;
            v r103 = this.f269868c;
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            Intrinsics.checkNotNullParameter(r102, "bridgeContext");
            if (r103 == null) goto L7;
            ByteArrayOutputStream r110 = r103.f247609i;
            if (r110 == null) goto L7;
            byte[] r111 = r110.toByteArray();
            int r112 = r111.length;
            String r104 = Base64.encodeToString(r111, 2);
            Map<String, ? extends Object> r113 = new LinkedHashMap();
            r113.put("streamLoadType", 1);
            r113.put("content-range", "bytes=0-" + r112);
            r113.put("data", r104);
            r113.put("length", Integer.valueOf(r104.length()));
            r113.put("streamSessionId", r101);
            r113.put("stage", "inProgress");
            r113.put("dataType", TTVideoEngineInterface.PLAY_API_KEY_BASE64);
            Unit r105 = Unit.INSTANCE;
            r102.sendEvent("x.requestChunkData", r113);
            HybridLogger r106 = HybridLogger.f246343a;
            HybridLogger.m("XPrefetch", "发送流式 Prefetch 全部缓存数据 size = " + r112, null, null, 12);
        L8:
            if (r103 != null) goto L10;
        L12:
            boolean r107 = false;
        L13:
            if (r107 == false) goto L16;
            Map<String, ? extends Object> r108 = new LinkedHashMap();
            r108.put("streamLoadType", 1);
            r108.put("length", Integer.valueOf(r112));
            r108.put("stage", BitableAnalytic.SelectSceneClickType.COMPLETE);
            r108.put("streamSessionId", r101);
            r108.put("dataType", TTVideoEngineInterface.PLAY_API_KEY_BASE64);
            Unit r109 = Unit.INSTANCE;
            r102.sendEvent("x.requestChunkData", r108);
            return;
        L16:
            return;
        L10:
            if (r103.f247610j != true) goto L12;
            r107 = true;
        L7:
            r112 = 0;
            goto L8
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class d implements z.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f269870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f269871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> f269872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ XRequestMethod f269873e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ m16.b f269874f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f269875g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f269876h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f269877i;

        @Override // com.bytedance.ies.bullet.prefetchv2.z.b
        public final void a(p r100, v r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "result");
            Ref.IntRef r102 = this.f269876h;
            de7.b r103 = de7.b.f468072a;
            String r104 = this.f269869a.getStreamSessionId();
            Intrinsics.checkNotNull(r104);
            r102.element = r103.a(r104, this.f269876h.element, this.f269870b, r101);
            if (this.f269877i.element == true) goto L6;
            CompletionBlock.DefaultImpls.onSuccess$default(this.f269872d, com.bytedance.sdk.xbridge.cn.network.e.a(r101, 1), null, 2, null);
            this.f269877i.element = true;
            return;
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.z.a
        public final void b(p r110, Throwable r111) {
            Intrinsics.checkNotNullParameter(r110, "request");
            Intrinsics.checkNotNullParameter(r111, LynxError.LYNX_THROWABLE);
            HybridLogger r100 = HybridLogger.f246343a;
            HybridLogger.i("XPrefetch", "task observe failed, error: " + r111.getMessage(), null, 12);
            de7.b r101 = de7.b.f468072a;
            String r102 = this.f269869a.getStreamSessionId();
            Intrinsics.checkNotNull(r102);
            IBDXBridgeContext r103 = this.f269870b;
            v r104 = this.f269871c;
            Intrinsics.checkNotNullParameter(r102, "sessionId");
            Intrinsics.checkNotNullParameter(r103, "bridgeContext");
            Intrinsics.checkNotNullParameter(r111, "e");
            LinkedHashMap r105 = new LinkedHashMap();
            r105.put("streamLoadType", 1);
            r105.put("stage", BitableAnalytic.SelectSceneClickType.COMPLETE);
            r105.put("streamSessionId", r102);
            r105.put("dataType", TTVideoEngineInterface.PLAY_API_KEY_BASE64);
            int r106 = 0;
            r105.put("clientCode", 0);
            if (r104 == null) goto L7;
            Integer r107 = r104.f247601a;
            if (r107 == null) goto L7;
            r106 = r107.intValue();
        L7:
            r105.put("httpCode", Integer.valueOf(r106));
            String r108 = r111.getMessage();
            if (r108 != null) goto L10;
            r108 = "un known error";
        L10:
            r105.put("msg", r108);
            Unit r109 = Unit.INSTANCE;
            r103.sendEvent("x.requestChunkData", r105);
            CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r112 = this.f269872d;
            String r113 = r111.toString();
            XBaseModel r114 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
            com.bytedance.sdk.xbridge.cn.network.a.c r115 = (com.bytedance.sdk.xbridge.cn.network.a.c) r114;
            r115.setHttpCode(-408);
            r115.setClientCode(r115.getClientCode());
            r115.setPrefetchStatus(1);
            r115.setRawResponse(r115.getRawResponse());
            r112.onFailure(-688, r113, (XBaseResultModel) r114);
            this.f269873e.f(this.f269874f, this.f269869a.getUrl(), false, 1, r111.toString(), System.currentTimeMillis() - this.f269875g, r110.f247576m);
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.z.b
        public final void c(p r100, v r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "result");
            Ref.IntRef r102 = this.f269876h;
            de7.b r103 = de7.b.f468072a;
            String r104 = this.f269869a.getStreamSessionId();
            Intrinsics.checkNotNull(r104);
            r102.element = r103.a(r104, this.f269876h.element, this.f269870b, r101);
            if (this.f269877i.element == true) goto L6;
            CompletionBlock.DefaultImpls.onSuccess$default(this.f269872d, com.bytedance.sdk.xbridge.cn.network.e.a(r101, 1), null, 2, null);
            this.f269877i.element = true;
            return;
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.z.a
        public final void d(p r100, v r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "result");
            de7.b r102 = de7.b.f468072a;
            String r103 = this.f269869a.getStreamSessionId();
            Intrinsics.checkNotNull(r103);
            r102.a(r103, this.f269876h.element, this.f269870b, r101);
            if (this.f269877i.element == true) goto L6;
            CompletionBlock.DefaultImpls.onSuccess$default(this.f269872d, com.bytedance.sdk.xbridge.cn.network.e.a(r101, 1), null, 2, null);
            this.f269877i.element = true;
            return;
        }

        public d(com.bytedance.sdk.xbridge.cn.network.a.b r100, IBDXBridgeContext r101, v r102, CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r103, XRequestMethod r104, m16.b r105, long r106, Ref.IntRef r107, Ref.BooleanRef r110) {
            this.f269869a = r100;
            this.f269870b = r101;
            this.f269871c = r102;
            this.f269872d = r103;
            this.f269873e = r104;
            this.f269874f = r105;
            this.f269875g = r106;
            this.f269876h = r107;
            this.f269877i = r110;
        }
    }

    public static final class e implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> f269878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XRequestMethod f269879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m16.b f269880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f269882e;

        @Override // com.bytedance.ies.bullet.prefetchv2.z.a
        public final void b(p r110, Throwable r111) {
            Intrinsics.checkNotNullParameter(r110, "request");
            Intrinsics.checkNotNullParameter(r111, LynxError.LYNX_THROWABLE);
            CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r100 = this.f269878a;
            String r101 = r111.toString();
            XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
            com.bytedance.sdk.xbridge.cn.network.a.c r103 = (com.bytedance.sdk.xbridge.cn.network.a.c) r102;
            r103.setHttpCode(-408);
            r103.setClientCode(r103.getClientCode());
            r103.setPrefetchStatus(1);
            r103.setRawResponse(r103.getRawResponse());
            Unit r104 = Unit.INSTANCE;
            r100.onFailure(-688, r101, (XBaseResultModel) r102);
            this.f269879b.f(this.f269880c, this.f269881d.getUrl(), false, 1, r111.toString(), System.currentTimeMillis() - this.f269882e, r110.f247576m);
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.z.a
        public final void d(p r110, v r111) {
            Intrinsics.checkNotNullParameter(r110, "request");
            Intrinsics.checkNotNullParameter(r111, "result");
            CompletionBlock.DefaultImpls.onSuccess$default(this.f269878a, com.bytedance.sdk.xbridge.cn.network.e.a(r111, 1), null, 2, null);
            this.f269879b.f(this.f269880c, this.f269881d.getUrl(), true, 1, "hit pending success", System.currentTimeMillis() - this.f269882e, r111.f247608h);
        }

        public e(CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r100, XRequestMethod r101, m16.b r102, com.bytedance.sdk.xbridge.cn.network.a.b r103, long r104) {
            this.f269878a = r100;
            this.f269879b = r101;
            this.f269880c = r102;
            this.f269881d = r103;
            this.f269882e = r104;
        }
    }

    public static final class f<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m16.b f269883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XRequestMethod f269884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f269886d;

        public f(m16.b r100, XRequestMethod r101, com.bytedance.sdk.xbridge.cn.network.a.b r102, long r103) {
            this.f269883a = r100;
            this.f269884b = r101;
            this.f269885c = r102;
            this.f269886d = r103;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            m16.b r100 = this.f269883a;
            h r101 = null;
            if (r100 == null) goto L9;
            h16.e r102 = (h16.e) r100.c(h16.e.class);
            if (r102 == null) goto L9;
            BulletContext r103 = r102.getBulletContext();
            if (r103 == null) goto L9;
            String r104 = r103.getSessionId();
        L10:
            if (r104 == null) goto L12;
            r101 = y.a(r104).f247612a;
        L12:
            XRequestMethod r105 = this.f269884b;
            m16.b r106 = this.f269883a;
            String r107 = this.f269885c.getUrl();
            long r108 = System.currentTimeMillis() - this.f269886d;
            if (r101 == null) goto L16;
            String r109 = r101.f247545b;
            if (r109 == null) goto L16;
        L17:
            String r110 = r109;
            int r111 = XRequestMethod.f269864d;
            r105.f(r106, r107, false, 0, "prefetch missed", r108, r110);
            return;
        L16:
            r109 = "unknown";
        L9:
            r104 = null;
            goto L10
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f269887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f269888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f269890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PlatformType f269891e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ XRequestMethod f269892f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ RequestMethodType f269893g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> f269894h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f269895i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Object f269896j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f269897k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f269898l;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f269899a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ LinkedHashMap<String, String> f269900b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f269901c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ IHostNetworkDepend f269902d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269903e;

            public a(String r100, LinkedHashMap<String, String> r101, c r102, IHostNetworkDepend r103, com.bytedance.sdk.xbridge.cn.network.a.b r104) {
                this.f269899a = r100;
                this.f269900b = r101;
                this.f269901c = r102;
                this.f269902d = r103;
                this.f269903e = r104;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                te7.e r100 = te7.e.f545589a;
                String r101 = this.f269899a;
                LinkedHashMap<String, String> r102 = this.f269900b;
                c r103 = this.f269901c;
                IHostNetworkDepend r104 = this.f269902d;
                boolean r105 = this.f269903e.getAddCommonParams();
                Boolean r106 = this.f269903e.isCustomizedCookie();
                if (r106 == null) goto L5;
                boolean r107 = r106.booleanValue();
            L6:
                te7.e.d(r100, r101, r102, r103, r104, r105, r107);
                return;
            L5:
                r107 = false;
                goto L6
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public static final class b implements te7.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f269904a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f269905b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269906c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ XRequestMethod f269907d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ IBDXBridgeContext f269908e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ long f269909f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> f269910g;

            @Override // te7.a
            public final void a(JSONObject r210, LinkedHashMap<String, String> r211, Integer r212, int r213) {
                Intrinsics.checkNotNullParameter(r210, ContainerPosition.BODY);
                Intrinsics.checkNotNullParameter(r211, "responseHeader");
                String r110 = r211.get(NetResponse.HEADER_KEY_LOG_ID);
                String r111 = r211.get(OkHttpEventListener.X_TT_TRACE_ID);
                com.bytedance.sdk.xbridge.cn.network.a.b r100 = this.f269906c;
                XRequestMethod r101 = this.f269907d;
                IBDXBridgeContext r102 = this.f269908e;
                Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L57
                Map<String, Object> r104 = r100.getExtraInfo();     // Catch: Throwable -> L57
                if (r104 == null) goto L11;
                Object r105 = r104.get("errorNoField");     // Catch: Throwable -> L57
                if (r105 == null) goto L11;
                String r112 = r105.toString();     // Catch: Throwable -> L57
                if (r112 == null) goto L11;
                List r106 = StringsKt.split$default(r112, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L57
            L12:
                Map<String, Object> r107 = r100.getExtraInfo();     // Catch: Throwable -> L57
                if (r107 == null) goto L19;
                Object r108 = r107.get("errorMsgField");     // Catch: Throwable -> L57
                if (r108 == null) goto L19;
                String r113 = r108.toString();     // Catch: Throwable -> L57
                if (r113 == null) goto L19;
                List r109 = StringsKt.split$default(r113, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L57
            L21:
                if (r106 == null) goto L33;
                int r114 = r106.size();     // Catch: Throwable -> L57
                if (r114 == 1) goto L30;
                if (r114 == 2) goto L26;
                Integer r115 = 0;     // Catch: Throwable -> L57
            L31:
                if (r115 == null) goto L33;
                int r116 = r115.intValue();     // Catch: Throwable -> L57
            L34:
                if (r109 == null) goto L43;
                int r117 = r109.size();     // Catch: Throwable -> L57
                if (r117 == 1) goto L42;
                if (r117 != 2) goto L43;
                JSONObject r118 = r210.optJSONObject((String) ListProtector.get(r109, 0));     // Catch: Throwable -> L57
                if (r118 == null) goto L43;
                String r119 = r118.optString((String) ListProtector.get(r109, 1));     // Catch: Throwable -> L57
            L44:
                if (r116 == 0) goto L52;
                String r120 = this.f269904a;     // Catch: Throwable -> L57
                String r121 = this.f269905b;     // Catch: Throwable -> L57
                if (r212 == null) goto L48;
                int r122 = r212.intValue();     // Catch: Throwable -> L57
            L50:
                int r123 = 0;
                XRequestMethod.b(r101, r102, r120, r121, r122, 1, "fetch success", r116, r119, r110);     // Catch: Throwable -> L55
            L53:
                Object r124 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L55
            L61:
                if (Result.m9452exceptionOrNullimpl(r124) == null) goto L63;
                int r125 = XRequestMethod.f269864d;
            L63:
                XRequestMethod r126 = this.f269907d;
                this.f269906c.getUrl();
                XRequestMethod.a(r126);
                XRequestMethod r127 = this.f269907d;
                String r128 = this.f269908e.getContainerID();
                String r129 = this.f269905b;
                String r130 = this.f269904a;
                long r131 = System.currentTimeMillis() - this.f269909f;
                r127.getClass();
                XRequestMethod.e(r128, r129, r130, -1, "JSON Parse Error", r212, r110, r111, null, r131, true);
                CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r132 = this.f269910g;
                XBaseModel r133 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
                com.bytedance.sdk.xbridge.cn.network.a.c r134 = (com.bytedance.sdk.xbridge.cn.network.a.c) r133;
                if (r212 == null) goto L66;
                Integer r135 = r212;
            L67:
                r134.setHttpCode(r135);
                r134.setPrefetchStatus(Integer.valueOf(r123));
                r134.setClientCode(Integer.valueOf(r213));
                r134.setHeader(r211);
                LinkedHashMap r136 = new LinkedHashMap();     // Catch: Throwable -> L77
                Iterator<String> r137 = r210.keys();     // Catch: Throwable -> L77
            L70:
                if (r137.hasNext() == false) goto L73;
                String r138 = r137.next();     // Catch: Throwable -> L77
                r136.put(r138, r210.get(r138));     // Catch: Throwable -> L77
                goto L70
            L73:
                if (r110 != null) goto L75;
                r110 = "";
            L75:
                r136.put("_Header_RequestID", r110);     // Catch: Throwable -> L77
                r134.setResponse(ne7.e.a(r136));     // Catch: Throwable -> L77
            L78:
                CompletionBlock.DefaultImpls.onSuccess$default(r132, (XBaseResultModel) r133, null, 2, null);
                return;
            L77:
                int r139 = XRequestMethod.f269864d;
                goto L78
            L66:
                r135 = -1;
            L55:
                th = th;
            L59:
                Result.Companion r140 = Result.Companion;
                r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
                goto L61
            L48:
                r122 = -1;
                goto L50
            L52:
                r123 = 0;
                goto L53
            L42:
                r119 = r210.optString((String) ListProtector.get(r109, 0));     // Catch: Throwable -> L57
            L43:
                r119 = null;
                goto L44
            L26:
                JSONObject r141 = r210.optJSONObject((String) ListProtector.get(r106, 0));     // Catch: Throwable -> L57
                if (r141 == null) goto L29;
                r115 = Integer.valueOf(r141.optInt((String) ListProtector.get(r106, 1)));     // Catch: Throwable -> L57
                goto L31
            L29:
                r115 = null;
                goto L31
            L30:
                r115 = Integer.valueOf(r210.optInt((String) ListProtector.get(r106, 0)));     // Catch: Throwable -> L57
            L33:
                r116 = 0;
            L19:
                r109 = null;
            L11:
                r106 = null;
            L57:
                th = th;
                r123 = 0;
                goto L59
            }

            @Override // te7.a
            public final void c(Integer r210, LinkedHashMap<String, String> r211, Throwable r212, int r213) {
                Intrinsics.checkNotNullParameter(r212, LynxError.LYNX_THROWABLE);
                XRequestMethod r100 = this.f269907d;
                this.f269906c.getUrl();
                XRequestMethod.a(r100);
                String r101 = null;
                if ((r212 instanceof NetworkNotAvailabeException) == false) goto L6;
                int r102 = -1001;
                Integer r110 = null;
                boolean r103 = true;
                int r111 = -1001;
            L20:
                if (r210 == null) goto L22;
                int r112 = r210.intValue();
            L23:
                if (r211 == null) goto L25;
                String r214 = r211.get(NetResponse.HEADER_KEY_LOG_ID);
            L26:
                if (r211 == null) goto L28;
                r101 = r211.get(OkHttpEventListener.X_TT_TRACE_ID);
            L28:
                XRequestMethod r104 = this.f269907d;
                String r105 = this.f269908e.getContainerID();
                String r113 = this.f269905b;
                String r114 = this.f269904a;
                String r115 = r212.getMessage();
                if (r115 != null) goto L31;
                r115 = "";
            L31:
                r104.getClass();
                int r106 = r112;
                XRequestMethod.e(r105, r113, r114, r111, r115, r110, r214, r101, r212.toString(), System.currentTimeMillis() - this.f269909f, !r103);
                XRequestMethod.b(this.f269907d, this.f269908e, this.f269904a, this.f269905b, r106, r102, r212.toString(), 0, null, r214);
                CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r107 = this.f269910g;
                String r108 = "Request failed, httpCode: " + r106 + ", clientCode:" + r213 + ", message: " + r212;
                XBaseModel r109 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
                com.bytedance.sdk.xbridge.cn.network.a.c r116 = (com.bytedance.sdk.xbridge.cn.network.a.c) r109;
                r116.setPrefetchStatus(0);
                r116.setHttpCode(Integer.valueOf(r106));
                r116.setClientCode(Integer.valueOf(r213));
                LinkedHashMap r117 = new LinkedHashMap();
                if (r210 == null) goto L34;
                int r215 = r210.intValue();
            L35:
                r117.put("errCode", Integer.valueOf(r215));
                String r118 = r212.getMessage();
                if (r118 != null) goto L38;
                r118 = "";
            L38:
                r117.put("message", r118);
                String r119 = "";
                r117.put("prompts", r119);
                if (r214 == null) goto L42;
                r119 = r214;
            L42:
                r117.put("_Header_RequestID", r119);
                r116.setResponse(ne7.e.a(r117));
                Unit r120 = Unit.INSTANCE;
                r107.onFailure(r102, r108, (XBaseResultModel) r109);
                return;
            L34:
                r215 = -408;
                goto L35
            L25:
                r214 = null;
                goto L26
            L22:
                r112 = -408;
                goto L23
            L6:
                if ((r212 instanceof HttpResponseException) == false) goto L13;
                HttpResponseException r121 = (HttpResponseException) r212;
                if (r121.getStatusCode() < 400) goto L10;
                r103 = true;
            L11:
                Integer r122 = Integer.valueOf(r121.getStatusCode());
                r102 = r121.getStatusCode();
                r110 = r122;
                r111 = 1;
                goto L20
            L10:
                r103 = false;
                goto L11
            L13:
                if ((r212 instanceof CronetIOException) == false) goto L15;
                CronetIOException r123 = (CronetIOException) r212;
                Integer r124 = Integer.valueOf(r123.getStatusCode());
                r102 = r123.getStatusCode();
                Integer r125 = r124;
                int r126 = r213;
            L19:
                r111 = r126;
                r110 = r125;
                r103 = true;
                goto L20
            L15:
                if (r210 == null) goto L17;
                int r127 = r210.intValue();
            L18:
                r126 = r127;
                r125 = null;
                r102 = 0;
                goto L19
            L17:
                r127 = -408;
                goto L18
            }

            public b(com.bytedance.sdk.xbridge.cn.network.a.b r100, XRequestMethod r101, IBDXBridgeContext r102, long r103, CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r104) {
                this.f269906c = r100;
                this.f269907d = r101;
                this.f269908e = r102;
                this.f269909f = r103;
                this.f269910g = r104;
                this.f269904a = r100.getMethod();
                this.f269905b = r100.getUrl();
            }

            @Override // te7.a
            public final Unit b(JSONObject r110, LinkedHashMap<String, String> r210, String r211, Throwable r212, Integer r213, int r214) {
                Intrinsics.checkNotNullParameter(r110, ContainerPosition.BODY);
                Intrinsics.checkNotNullParameter(r210, "responseHeader");
                Intrinsics.checkNotNullParameter(r211, "rawResponse");
                Intrinsics.checkNotNullParameter(r212, LynxError.LYNX_THROWABLE);
                String r111 = r210.get(NetResponse.HEADER_KEY_LOG_ID);
                String r112 = r210.get(OkHttpEventListener.X_TT_TRACE_ID);
                XRequestMethod r100 = this.f269907d;
                this.f269906c.getUrl();
                XRequestMethod.a(r100);
                XRequestMethod r101 = this.f269907d;
                String r102 = this.f269908e.getContainerID();
                String r103 = this.f269905b;
                String r104 = this.f269904a;
                String r113 = r212.toString();
                long r114 = System.currentTimeMillis() - this.f269909f;
                r101.getClass();
                XRequestMethod.e(r102, r103, r104, -1, "JSON Parse Error", r213, r111, r112, r113, r114, false);
                XRequestMethod r105 = this.f269907d;
                IBDXBridgeContext r106 = this.f269908e;
                String r107 = this.f269904a;
                String r108 = this.f269905b;
                if (r213 == null) goto L5;
                int r109 = r213.intValue();
            L6:
                XRequestMethod.b(r105, r106, r107, r108, r109, 0, r212.toString(), 0, null, r111);
                CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r115 = this.f269910g;
                String r116 = r212.toString();
                XBaseModel r117 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
                com.bytedance.sdk.xbridge.cn.network.a.c r118 = (com.bytedance.sdk.xbridge.cn.network.a.c) r117;
                if (r213 == null) goto L9;
                Integer r119 = r213;
            L10:
                r118.setHttpCode(r119);
                r118.setClientCode(Integer.valueOf(r214));
                r118.setPrefetchStatus(0);
                r118.setHeader(r210);
                LinkedHashMap r120 = new LinkedHashMap();     // Catch: Throwable -> L20
                Iterator<String> r121 = r110.keys();     // Catch: Throwable -> L20
            L13:
                if (r121.hasNext() == false) goto L16;
                String r122 = r121.next();     // Catch: Throwable -> L20
                r120.put(r122, r110.get(r122));     // Catch: Throwable -> L20
                goto L13
            L16:
                if (r111 != null) goto L18;
                r111 = "";
            L18:
                r120.put("_Header_RequestID", r111);     // Catch: Throwable -> L20
                r118.setResponse(ne7.e.a(r120));     // Catch: Throwable -> L20
            L21:
                r118.setRawResponse(r211);
                Unit r123 = Unit.INSTANCE;
                r115.onFailure(0, r116, (XBaseResultModel) r117);
                return Unit.INSTANCE;
            L20:
                int r124 = XRequestMethod.f269864d;
                goto L21
            L9:
                r119 = -1;
                goto L10
            L5:
                r109 = -1;
                goto L6
            }
        }

        public static final class c implements te7.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> f269911a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IBDXBridgeContext f269912b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269913c;

            @Override // te7.b
            public final void a(i r210) {
                i r100 = r210;
                String r101 = "clientCode";
                String r102 = "httpCode";
                String r103 = "";
                InputStream r104 = r210.e();
                int r110 = r100.f545613b.element;
                Integer r111 = r210.b();
                if (r104 != null) goto L132;
                CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r105 = this.f269911a;
                XBaseModel r106 = ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class));
                com.bytedance.sdk.xbridge.cn.network.a.c r107 = (com.bytedance.sdk.xbridge.cn.network.a.c) r106;
                r107.setHttpCode(Integer.valueOf(r110));
                r107.setClientCode(r111);
                Unit r108 = Unit.INSTANCE;
                r105.onFailure(0, ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_BODY_IS_NULL, (XBaseResultModel) r106);
                return;
            L132:
                BufferedInputStream r112 = new BufferedInputStream(r104);     // Catch: Throwable -> L69 Exception -> L71
            L134:
                byte[] r109 = new byte[com.bytedance.ies.bullet.service.base.h.c()];     // Catch: Throwable -> L63 Exception -> L66
                IBDXBridgeContext r113 = this.f269912b;     // Catch: Throwable -> L63 Exception -> L66
                com.bytedance.sdk.xbridge.cn.network.a.b r114 = this.f269913c;     // Catch: Throwable -> L63 Exception -> L66
                int r115 = 0;
            L8:
                int r116 = r112.read(r109);     // Catch: Throwable -> L63 Exception -> L66
                String r117 = r103;
                if (r116 == (-1)) goto L28;
                BufferedInputStream r118 = r112;
                String r119 = Base64.encodeToString(r109, 0, r116, 2);     // Catch: Exception -> L25 Throwable -> L59
                LinkedHashMap r120 = new LinkedHashMap();     // Catch: Exception -> L25 Throwable -> L59
                byte[] r211 = r109;
                r120.put("streamLoadType", 1);     // Catch: Exception -> L25 Throwable -> L59
                String r212 = r101;
                StringBuilder r121 = new StringBuilder();     // Catch: Exception -> L23 Throwable -> L59
                String r213 = r102;
                r121.append("bytes=");     // Catch: Exception -> L21 Throwable -> L59
                int r122 = r115;
                r121.append(r122);     // Catch: Exception -> L21 Throwable -> L59
                r121.append('-');     // Catch: Exception -> L21 Throwable -> L59
                int r123 = r122 + r116;     // Catch: Exception -> L21 Throwable -> L59
                r121.append(r123);     // Catch: Exception -> L21 Throwable -> L59
                r120.put("content-range", r121.toString());     // Catch: Exception -> L21 Throwable -> L59
                r120.put("data", r119);     // Catch: Exception -> L21 Throwable -> L59
                r120.put("length", Integer.valueOf(r116));     // Catch: Exception -> L21 Throwable -> L59
                String r124 = r114.getStreamSessionId();     // Catch: Exception -> L21 Throwable -> L59
                if (r124 != null) goto L19;
                r124 = r117;
            L19:
                r120.put("streamSessionId", r124);     // Catch: Exception -> L21 Throwable -> L59
                r120.put("stage", "inProgress");     // Catch: Exception -> L21 Throwable -> L59
                r120.put("dataType", TTVideoEngineInterface.PLAY_API_KEY_BASE64);     // Catch: Exception -> L21 Throwable -> L59
                Unit r125 = Unit.INSTANCE;     // Catch: Exception -> L21 Throwable -> L59
                r113.sendEvent("x.requestChunkData", r120);     // Catch: Exception -> L21 Throwable -> L59
                r115 = r123;
                r103 = r117;
                r112 = r118;
                r109 = r211;
                r101 = r212;
                r102 = r213;
                r100 = r210;
            L21:
                e = e;
                i r126 = r210;
                String r127 = r213;
            L41:
                BufferedInputStream r128 = r118;
                String r129 = r212;
            L130:
                HybridLogger r130 = HybridLogger.f246343a;     // Catch: Throwable -> L95
                HybridLogger.i("XPrefetch", "performStreamRequest error reason: " + e.getMessage(), null, 12);     // Catch: Throwable -> L95
                IBDXBridgeContext r131 = this.f269912b;     // Catch: Throwable -> L93
                LinkedHashMap r132 = new LinkedHashMap();     // Catch: Throwable -> L93
                com.bytedance.sdk.xbridge.cn.network.a.b r133 = this.f269913c;     // Catch: Throwable -> L93
                r132.put("streamLoadType", 1);     // Catch: Throwable -> L93
                String r134 = r133.getStreamSessionId();     // Catch: Throwable -> L93
                if (r134 != null) goto L78;
                r134 = r117;
            L78:
                r132.put("streamSessionId", r134);     // Catch: Throwable -> L93
                r132.put("dataType", "arraybuffer");     // Catch: Throwable -> L93
                r132.put("stage", BitableAnalytic.SelectSceneClickType.COMPLETE);     // Catch: Throwable -> L93
                r132.put(r127, Integer.valueOf(r126.f545613b.element));     // Catch: Throwable -> L93
                Integer r135 = r210.b();     // Catch: Throwable -> L93
                if (r135 == null) goto L81;
                int r136 = r135.intValue();     // Catch: Throwable -> L93
            L82:
                r132.put(r129, Integer.valueOf(r136));     // Catch: Throwable -> L93
                String r137 = e.getMessage();     // Catch: Throwable -> L93
                if (r137 != null) goto L85;
                r137 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
            L85:
                r132.put("msg", r137);     // Catch: Throwable -> L93
                Unit r138 = Unit.INSTANCE;     // Catch: Throwable -> L93
                r131.sendEvent("x.requestChunkData", r132);     // Catch: Throwable -> L93
                r210.a();     // Catch: IOException -> L90
                if (r128 == null) goto L138;
                r128.close();     // Catch: IOException -> L90
                return;
            L138:
                return;
            L90:
                e = move-exception;
                e.printStackTrace();
                return;
            L81:
                r136 = 0;
            L93:
                th = th;
            L98:
                Throwable r139 = th;
            L115:
                r210.a();     // Catch: IOException -> L103
                if (r128 == null) goto L140;
                r128.close();     // Catch: IOException -> L103
                throw r139;
            L140:
                throw r139;
            L103:
                e = move-exception;
                e.printStackTrace();
                throw r139;
            L95:
                th = th;
                BufferedInputStream r140 = r128;
            L97:
                r128 = r140;
            L23:
                e = e;
            L24:
                String r214 = r102;
                r126 = r210;
                r128 = r118;
                r129 = r212;
                r127 = r214;
            L59:
                th = th;
            L65:
                r139 = th;
                r128 = r118;
            L25:
                e = e;
                r212 = r101;
                goto L24
            L28:
                r212 = r101;
                String r215 = r102;
                r118 = r112;
                LinkedHashMap r141 = new LinkedHashMap();     // Catch: Throwable -> L59 Exception -> L61
                r141.put("streamLoadType", 1);     // Catch: Throwable -> L59 Exception -> L61
                String r142 = r114.getStreamSessionId();     // Catch: Throwable -> L59 Exception -> L61
                if (r142 != null) goto L32;
                r142 = r117;
            L32:
                r141.put("streamSessionId", r142);     // Catch: Throwable -> L59 Exception -> L61
                r141.put("dataType", TTVideoEngineInterface.PLAY_API_KEY_BASE64);     // Catch: Throwable -> L59 Exception -> L61
                r141.put("stage", BitableAnalytic.SelectSceneClickType.COMPLETE);     // Catch: Throwable -> L59 Exception -> L61
                r126 = r210;
                r127 = r215;
                r141.put(r127, Integer.valueOf(r126.f545613b.element));     // Catch: Exception -> L53 Throwable -> L55
                Integer r143 = r210.b();     // Catch: Exception -> L53 Throwable -> L55
                if (r143 != null) goto L117;
                int r144 = 0;
            L43:
                r129 = r212;
                r141.put(r129, Integer.valueOf(r144));     // Catch: Exception -> L51 Throwable -> L55
                Unit r145 = Unit.INSTANCE;     // Catch: Exception -> L51 Throwable -> L55
                r113.sendEvent("x.requestChunkData", r141);     // Catch: Exception -> L51 Throwable -> L55
            L113:
                r210.a();     // Catch: IOException -> L48
                r118.close();     // Catch: IOException -> L48
            L137:
                return;
            L48:
                e = move-exception;
                e.printStackTrace();
            L51:
                e = e;
            L68:
                r128 = r118;
                goto L130
            L117:
                r144 = r143.intValue();     // Catch: Exception -> L40 Throwable -> L55
            L40:
                e = e;
            L53:
                e = e;
                r129 = r212;
            L57:
                e = e;
            L58:
                r129 = r212;
                r127 = r215;
            L55:
                th = th;
                goto L65
            L61:
                e = e;
                r126 = r210;
                goto L58
            L66:
                e = e;
                r126 = r100;
                r117 = r103;
                r118 = r112;
                String r216 = r102;
                r129 = r101;
                r127 = r216;
            L63:
                th = th;
                r118 = r112;
            L71:
                e = e;
                r126 = r100;
                r117 = "";
                r129 = "clientCode";
                r127 = "httpCode";
                r128 = null;
            L69:
                th = th;
                r140 = null;
                goto L97
            }

            public c(CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r100, IBDXBridgeContext r101, com.bytedance.sdk.xbridge.cn.network.a.b r102) {
                this.f269911a = r100;
                this.f269912b = r101;
                this.f269913c = r102;
            }
        }

        public static final class d implements te7.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ XRequestMethod f269914a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f269915b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IBDXBridgeContext f269916c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> f269917d;

            @Override // te7.b
            public final void a(i r110) {
                String r100 = r110.c();
                boolean r101 = true;
                if (r100.length() <= 0) goto L5;
                boolean r102 = true;
            L6:
                BufferedInputStream r103 = null;
                ByteArrayOutputStream r104 = null;
                r104 = null;
                r104 = null;
                if (r102 == true) goto L10;
                r100 = null;
            L10:
                if (r100 != null) goto L22;
                Throwable r105 = r110.d();
                if (r105 == null) goto L21;
                r100 = r105.getMessage();
                if (r100 == null) goto L21;
                if (r100.length() > 0) goto L19;
                r101 = false;
            L19:
                if (r101 == true) goto L22;
            L21:
                r100 = null;
            L22:
                InputStream r106 = r110.e();
                int r107 = r110.f545613b.element;
                Integer r111 = r110.b();
                if (r106 != null) goto L26;
                int r112 = XRequestMethod.f269864d;
                XRequestMethod r113 = this.f269914a;
                this.f269915b.getUrl();
                XRequestMethod.a(r113);
                ThreadUtils.a().post(new com.bytedance.sdk.xbridge.cn.network.b(this.f269917d, r100, r107, r111));
                return;
            L26:
                LinkedHashMap<String, String> r108 = r110.f545612a;
                BufferedInputStream r109 = new BufferedInputStream(r106);     // Catch: Throwable -> L43 Exception -> L45
                ByteArrayOutputStream r114 = new ByteArrayOutputStream();     // Catch: Exception -> L41 Throwable -> L57
                byte[] r115 = new byte[4096];     // Catch: Throwable -> L37 Exception -> L39
            L31:
                int r116 = r109.read(r115);     // Catch: Throwable -> L37 Exception -> L39
                if (r116 == (-1)) goto L34;
                r114.write(r115, 0, r116);     // Catch: Throwable -> L37 Exception -> L39
                goto L31
            L34:
                String r117 = Base64.encodeToString(r114.toByteArray(), 2);     // Catch: Throwable -> L37 Exception -> L39
                XRequestMethod r118 = this.f269914a;     // Catch: Throwable -> L37 Exception -> L39
                this.f269915b.getUrl();     // Catch: Throwable -> L37 Exception -> L39
                XRequestMethod.a(r118);     // Catch: Throwable -> L37 Exception -> L39
                ThreadUtils.a().post(new com.bytedance.sdk.xbridge.cn.network.c(this.f269917d, r108, r117, r107, r111));     // Catch: Throwable -> L37 Exception -> L39
                r110.a();     // Catch: IOException -> L54
                r109.close();     // Catch: IOException -> L54
                r114.close();     // Catch: IOException -> L54
                return;
            L39:
                Exception e100 = e;
                r104 = r114;
            L47:
                XRequestMethod r119 = this.f269914a;     // Catch: Throwable -> L57
                this.f269915b.getUrl();     // Catch: Throwable -> L57
                XRequestMethod.a(r119);     // Catch: Throwable -> L57
                ThreadUtils.a().post(new com.bytedance.sdk.xbridge.cn.network.d(this.f269917d, e100, r107, r111));     // Catch: Throwable -> L57
                r110.a();     // Catch: IOException -> L54
                if (r109 == null) goto L51;
                r109.close();     // Catch: IOException -> L54
            L51:
                if (r104 == null) goto L79;
                r104.close();     // Catch: IOException -> L54
                return;
            L79:
                return;
            L37:
                Throwable th10 = th;
                r104 = r114;
            L59:
                ByteArrayOutputStream r120 = r104;
                r103 = r109;
                ByteArrayOutputStream r121 = r120;
            L73:
                r110.a();     // Catch: IOException -> L66
                if (r103 == null) goto L63;
                r103.close();     // Catch: IOException -> L66
            L63:
                if (r121 == null) goto L82;
                r121.close();     // Catch: IOException -> L66
                throw th10;
            L82:
                throw th10;
            L66:
                e = move-exception;
                e.printStackTrace();
                throw th10;
            L41:
                e = move-exception;
                e100 = e;
            L57:
                th = move-exception;
                th10 = th;
                goto L59
            L54:
                e = move-exception;
                e.printStackTrace();
                return;
            L45:
                e = move-exception;
                e100 = e;
                r109 = null;
            L43:
                th = move-exception;
                th10 = th;
                r121 = null;
                goto L73
            L5:
                r102 = false;
                goto L6
            }

            public d(XRequestMethod r100, com.bytedance.sdk.xbridge.cn.network.a.b r101, IBDXBridgeContext r102, long r103, CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r104) {
                this.f269914a = r100;
                this.f269915b = r101;
                this.f269916c = r102;
                this.f269917d = r104;
            }
        }

        public g(Map<String, ? extends Object> r100, IBDXBridgeContext r101, com.bytedance.sdk.xbridge.cn.network.a.b r102, Map<String, ? extends Object> r103, PlatformType r104, XRequestMethod r105, RequestMethodType r106, CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r107, int r108, Object r110, String r111, long r112) {
            this.f269887a = r100;
            this.f269888b = r101;
            this.f269889c = r102;
            this.f269890d = r103;
            this.f269891e = r104;
            this.f269892f = r105;
            this.f269893g = r106;
            this.f269894h = r107;
            this.f269895i = r108;
            this.f269896j = r110;
            this.f269897k = r111;
            this.f269898l = r112;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            te7.e r100 = te7.e.f545589a;
            Map<String, Object> r101 = this.f269887a;
            r100.getClass();
            LinkedHashMap r102 = te7.e.f(r101);
            if (r102.containsKey(com.alipay.sdk.m.p.e.f25658f) == false) goto L6;
            String r103 = (String) r102.get(com.alipay.sdk.m.p.e.f25658f);
        L9:
            te7.e.b(r102, this.f269888b);
            m16.b r104 = (m16.b) this.f269888b.getService(m16.b.class);
            if (r104 == null) goto L14;
            m16.c r105 = r104.a(b.class);
            if (r105 == null) goto L14;
            b r106 = (b) r105.provideInstance();
        L15:
            if (r106 == null) goto L20;
            this.f269889c.getUrl();
            String r107 = r106.a();
            if (r107 != null) goto L19;
            r107 = this.f269889c.getUrl();
        L19:
            String r108 = te7.e.a(r107, this.f269890d, this.f269891e, this.f269889c.getAddCommonParams());
        L21:
            String r109 = r108;
            XRequestMethod r110 = this.f269892f;
            IBDXBridgeContext r111 = this.f269888b;
            r110.getClass();
            m16.b r112 = (m16.b) r111.getService(m16.b.class);
            if (r112 == null) goto L26;
            h16.e r113 = (h16.e) r112.c(h16.e.class);
            if (r113 == null) goto L26;
            BulletContext r114 = r113.getBulletContext();
        L27:
            if (r114 == null) goto L33;
            t36.d r115 = r114.f246437e;
            if (r115 == null) goto L33;
            Map<String, String> r116 = r115.c();
            if (r116 == null) goto L33;
            String r117 = r116.get("enable_access_token");
        L35:
            if (r117 == null) goto L42;
            Integer r118 = StringsKt.toIntOrNull(r117);
            if (r118 == null) goto L42;
            if (r118.intValue() != 1) goto L42;
            boolean r119 = true;
        L43:
            if (r119 == false) goto L54;
            Lazy<ArgusGlobalDelegate> r120 = ArgusGlobalDelegate.f245624c;
            ArgusGlobalDelegate r121 = ArgusGlobalDelegate.a.a();
            if (r121 != null) goto L47;
            boolean r122 = false;
        L48:
            if (r122 == false) goto L54;
            AnnieXServiceCenter.f40313a.getClass();
            IAnnieXAccountService r123 = (IAnnieXAccountService) AnnieXServiceCenter.d("default_bid", IAnnieXAccountService.class);
            if (r123 == null) goto L54;
            String r124 = r123.e();
            if (r124 == null) goto L54;
            r102.put("Authorization", r124);
            goto L54
        L47:
            r122 = r121.c(new InjectLoginStateParams(r109, InjectLoginStateParams.SceneType.X_REQUEST)).d();
        L54:
            b r125 = new b(this.f269889c, this.f269892f, this.f269888b, this.f269898l, this.f269894h);
            XRequestMethod r126 = this.f269892f;
            com.bytedance.sdk.xbridge.cn.network.a.b r127 = this.f269889c;
            IBDXBridgeContext r128 = this.f269888b;
            long r129 = this.f269898l;
            CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r130 = this.f269894h;
            d r131 = new d(r126, r127, r128, r129, r130);
            c r132 = new c(r130, r128, r127);
            if (com.bytedance.sdk.xbridge.cn.utils.g.e() == null) goto L58;
            IHostNetworkDepend r133 = com.bytedance.sdk.xbridge.cn.utils.g.e();
            Intrinsics.checkNotNull(r133);
        L61:
            UGLogger.a r134 = new UGLogger.a();
            r134.a("session_id", this.f269888b.getContainerID());
            UGLogger.c r135 = UGLogger.f270252a;
            UGLogger.c("BulletSdk", "x.request do request by net depend", "BridgeProcessing", MapsKt.mapOf(TuplesKt.to(com.alipay.sdk.m.p.e.f25671s, this.f269893g.getMethod())), r134);
            String r136 = this.f269893g.getMethod();
            switch(r136.hashCode()) {
                case -1335458389: goto L133;
                case 102230: goto L122;
                case 111375: goto L106;
                case 3446944: goto L65;
                default: goto L148;
            };
        L148:
            return;
        L65:
            if (r136.equals(UGCMonitor.TYPE_POST) == false) goto L149;
            if (r103 != null) goto L69;
            r103 = "application/x-www-form-urlencoded";
        L69:
            r102.put("Content-Type", r103);
            Object r137 = this.f269896j;
            if ((r137 instanceof String) == false) goto L88;
            if (Intrinsics.areEqual(this.f269897k, TTVideoEngineInterface.PLAY_API_KEY_BASE64) == false) goto L78;
            byte[] r138 = Base64.decode((String) this.f269896j, 0);
            boolean r139 = this.f269889c.getAddCommonParams();
            Boolean r140 = this.f269889c.isCustomizedCookie();
            if (r140 == null) goto L76;
            boolean r141 = r140.booleanValue();
        L77:
            r100.getClass();
            te7.e.r(r109, r102, r103, r138, r131, r133, r139, r141);
            return;
        L76:
            r141 = false;
            goto L77
        L78:
            String r142 = (String) this.f269896j;
            Charset r143 = Charsets.UTF_8;
            if (r142 == null) goto L86;
            byte[] r144 = r142.getBytes(r143);
            boolean r145 = this.f269889c.getAddCommonParams();
            Boolean r146 = this.f269889c.isCustomizedCookie();
            if (r146 == null) goto L83;
            boolean r147 = r146.booleanValue();
        L84:
            te7.e.p(r109, r102, r103, r144, r125, r133, r145, r147, this.f269895i);
            return;
        L83:
            r147 = false;
            goto L84
        L86:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L88:
            if (r137 == null) goto L97;
            if ((r137 instanceof List) == false) goto L97;
            byte[] r148 = new JSONArray((Collection) this.f269896j).toString().getBytes(Charsets.UTF_8);
            boolean r149 = this.f269889c.getAddCommonParams();
            Boolean r150 = this.f269889c.isCustomizedCookie();
            if (r150 == null) goto L94;
            boolean r151 = r150.booleanValue();
        L95:
            te7.e.p(r109, r102, r103, r148, r125, r133, r149, r151, this.f269895i);
            return;
        L94:
            r151 = false;
        L97:
            if ((r137 instanceof Map) == false) goto L99;
            JSONObject r152 = new JSONObject((Map) this.f269896j);
        L100:
            boolean r153 = this.f269889c.getAddCommonParams();
            Boolean r154 = this.f269889c.isCustomizedCookie();
            if (r154 == null) goto L103;
            boolean r155 = r154.booleanValue();
        L104:
            te7.e.n(r109, r102, r103, r152, r125, r133, r153, r155, this.f269895i);
            return;
        L103:
            r155 = false;
            goto L104
        L99:
            r152 = new JSONObject();
            goto L100
        L149:
            return;
        L106:
            if (r136.equals("put") == false) goto L150;
            Object r156 = this.f269896j;
            if (r156 != null) goto L111;
        L113:
            JSONObject r157 = new JSONObject();
        L114:
            if (r103 != null) goto L116;
            r103 = "application/x-www-form-urlencoded";
        L116:
            boolean r158 = this.f269889c.getAddCommonParams();
            Boolean r159 = this.f269889c.isCustomizedCookie();
            if (r159 == null) goto L119;
            boolean r160 = r159.booleanValue();
        L120:
            te7.e.u(r109, r102, r103, r157, r125, r133, r158, r160, this.f269895i);
            return;
        L119:
            r160 = false;
            goto L120
        L111:
            if ((r156 instanceof Map) == false) goto L113;
            r157 = new JSONObject((Map) this.f269896j);
            goto L114
        L150:
            return;
        L122:
            if (r136.equals(MonitorConstants.CONNECT_TYPE_GET) == true) goto L125;
            return;
        L125:
            if (Intrinsics.areEqual(this.f269889c.getStreamLoadType(), 1) == false) goto L127;
            Task.callInBackground(new a(r109, r102, r132, r133, this.f269889c));
            CompletionBlock.DefaultImpls.onSuccess$default(this.f269894h, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(com.bytedance.sdk.xbridge.cn.network.a.c.class)), null, 2, null);
            return;
        L127:
            boolean r161 = this.f269889c.getAddCommonParams();
            Boolean r162 = this.f269889c.isCustomizedCookie();
            if (r162 == null) goto L130;
            boolean r163 = r162.booleanValue();
        L131:
            te7.e.i(r109, r102, r125, r133, r161, r163, this.f269895i);
            return;
        L130:
            r163 = false;
            goto L131
        L133:
            if (r136.equals("delete") == false) goto L152;
            boolean r164 = this.f269889c.getAddCommonParams();
            Boolean r165 = this.f269889c.isCustomizedCookie();
            if (r165 == null) goto L138;
            boolean r166 = r165.booleanValue();
        L139:
            r100.delete(r109, r102, r125, r133, r164, r166, this.f269895i);
            return;
        L138:
            r166 = false;
            goto L139
        L152:
            return;
        L58:
            if (this.f269889c.getAddCommonParams() == false) goto L60;
            r133 = com.bytedance.sdk.xbridge.cn.utils.g.d();
            goto L61
        L60:
            r133 = com.bytedance.sdk.xbridge.cn.utils.g.g();
        L42:
            r119 = false;
        L33:
            r117 = null;
        L26:
            r114 = null;
            goto L27
        L20:
            r108 = te7.e.a(this.f269889c.getUrl(), this.f269890d, this.f269891e, this.f269889c.getAddCommonParams());
        L14:
            r106 = null;
            goto L15
        L6:
            if (r102.containsKey("Content-Type") == false) goto L8;
            r103 = (String) r102.get("Content-Type");
            goto L9
        L8:
            r103 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    static {
    }

    public XRequestMethod() {
    }

    public static final void a(XRequestMethod r100) {
        r100.getClass();
        id7.c.f489344d.getClass();
    }

    public final void c(IBDXBridgeContext r210, com.bytedance.sdk.xbridge.cn.network.a.b r211, CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r212) {
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r211, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        long r100 = System.currentTimeMillis();
        Boolean r101 = r211.getUsePrefetch();
        Activity r102 = r210.getOwnerActivity();
        if (r102 == null) goto L5;
        Context r103 = r102.getApplicationContext();
    L6:
        m16.b r104 = (m16.b) r210.getService(m16.b.class);
        if (r104 == null) goto L15;
        h16.e r105 = (h16.e) r104.c(h16.e.class);
        if (r105 == null) goto L15;
        o r106 = r105.getKitView();
        if (r106 == null) goto L15;
        j r107 = r106.getContext();
        if (r107 == null) goto L15;
        String r108 = r107.getBid();
    L16:
        boolean r109 = StringsKt.equals$default(r108, "miniapp", false, 2, null);
        Boolean r110 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r110) == false) goto L54;
        if (r103 != null) goto L21;
        if (r109 == false) goto L54;
    L21:
        if ((r211.getBody() instanceof Map) == false) goto L23;
        Object r111 = r211.getBody();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        JSONObject r112 = new JSONObject((Map) r111);
    L24:
        JSONObject r113 = r112;
        String r114 = r211.getUrl();
        String r115 = r211.getMethod();
        Map<String, String> r116 = u.a(r211.getHeader());
        Map<String, String> r117 = u.a(r211.getParams());
        boolean r213 = r211.getAddCommonParams();
        Boolean r118 = r211.isCustomizedCookie();
        if (r118 == null) goto L27;
        boolean r214 = r118.booleanValue();
    L28:
        p r119 = new p(r114, r115, r116, r117, r113, r213, r214, Intrinsics.areEqual(r211.getStreamLoadType(), 1), 1024);
        a0 r120 = a0.f247513a;
        v r121 = a0.a(r119);
        if (Intrinsics.areEqual(r211.getStreamLoadType(), 1) == false) goto L43;
        if (r121 == null) goto L32;
        ByteArrayOutputStream r122 = r121.f247609i;
    L33:
        if (r122 != null) goto L35;
    L42:
        HybridLogger.i("XPrefetch", "not use cache pipedInputStream", null, 12);
    L46:
        z r123 = a0.c(r119);
        if (r123 == null) goto L54;
        if (Intrinsics.areEqual(r211.getStreamLoadType(), 1) == false) goto L51;
        r123.d(new d(r211, r210, r121, r212, this, r104, r100, new Ref.IntRef(), new Ref.BooleanRef()));
        return;
    L51:
        r123.d(new e(r212, this, r104, r211, r100));
        return;
    L35:
        if (r121.f247610j != true) goto L42;
        if (r211.getStreamSessionId() != null) goto L40;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "streamSessionId is null", null, 4, null);
        return;
    L40:
        Task.callInBackground(new c(r211, r210, r121));
        CompletionBlock.DefaultImpls.onSuccess$default(r212, com.bytedance.sdk.xbridge.cn.network.e.a(r121, 2), null, 2, null);
        f(r104, r211.getUrl(), true, 2, "hit cache", System.currentTimeMillis() - r100, r121.f247608h);
        return;
    L32:
        r122 = null;
        goto L33
    L43:
        if (r121 == null) goto L46;
        CompletionBlock.DefaultImpls.onSuccess$default(r212, com.bytedance.sdk.xbridge.cn.network.e.a(r121, 2), null, 2, null);
        f(r104, r211.getUrl(), true, 2, "hit cache", System.currentTimeMillis() - r100, r121.f247608h);
        return;
    L27:
        r214 = false;
        goto L28
    L23:
        r112 = new JSONObject();
    L54:
        if (Intrinsics.areEqual(r101, r110) == false) goto L56;
        int r124 = com.bytedance.ies.bullet.prefetchv2.j.f247548a;
        com.bytedance.ies.bullet.prefetchv2.j.b("未命中prefetch，请检查bridge请求参数跟配置是否匹配: " + r211.getUrl());
        Task.callInBackground(new f(r104, this, r211, r100));
    L56:
        RequestMethodType.a r125 = RequestMethodType.Companion;
        String r126 = r211.getMethod();
        r125.getClass();
        if (r126 != null) goto L86;
        RequestMethodType r127 = RequestMethodType.UNSUPPORTED;
    L62:
        RequestMethodType r128 = r127;
        PlatformType r129 = r210.getPlatformType();
        if (r128 != RequestMethodType.UNSUPPORTED) goto L66;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "Illegal method " + r211.getMethod(), null, 4, null);
        return;
    L66:
        Map<String, Object> r130 = r211.getHeader();
        Object r131 = r211.getBody();
        String r132 = r211.getBodyType();
        Map<String, Object> r133 = r211.getParams();
        Number r134 = r211.getMaxLength();
        if (r134 == null) goto L69;
        int r135 = r134.intValue();
    L71:
        if (TextUtils.isEmpty(r211.getUrl()) == false) goto L75;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "url is empty", null, 4, null);
        return;
    L75:
        if (r135 <= 10485760) goto L78;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "maxLength too large: " + r135 + ", exceed max size 10MB, maybe cause oom", null, 4, null);
        return;
    L78:
        long r136 = System.currentTimeMillis();
        int r137 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostThreadPoolExecutorDepend r138 = XBaseRuntime.f270109o;
        if (r138 != null) goto L81;
        r138 = new qe7.d();
    L81:
        ExecutorService r139 = r138.getNormalThreadExecutor();
        if (r139 != null) goto L84;
        r139 = TTExecutors.getNormalExecutor();
    L84:
        r139.execute(new g(r130, r210, r211, r133, r129, this, r128, r212, r135, r131, r132, r136));
        return;
    L69:
        r135 = -1;
        goto L71
    L86:
        r127 = RequestMethodType.valueOf(r126.toUpperCase(Locale.ROOT));     // Catch: Exception -> L60
    L60:
        r127 = RequestMethodType.UNSUPPORTED;
    L15:
        r108 = null;
        goto L16
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        c(r100, (com.bytedance.sdk.xbridge.cn.network.a.b) r101, r102);
    }

    public final void f(m16.b r110, String r111, boolean r112, int r113, String r114, long r115, String r210) {
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
        com.bytedance.ies.bullet.prefetchv2.o.a(new n(r104, r107, r111, r112, r113, r114, r115, r210));
        return;
    L18:
        r107 = null;
    L10:
        r103 = "default_bid";
        goto L11
    }

    public static final void b(XRequestMethod r110, IBDXBridgeContext r111, String r112, String r113, int r114, int r115, String r116, int r117, String r210, String r211) {
        r110.getClass();
        int r100 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        Intrinsics.checkNotNullParameter(r111, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostThreadPoolExecutorDepend r101 = XBaseRuntime.f270109o;
        if (r101 != null) goto L5;
        r101 = new qe7.d();
    L5:
        ExecutorService r102 = r101.getNormalThreadExecutor();
        if (r102 != null) goto L8;
        r102 = TTExecutors.getNormalExecutor();
    L8:
        r102.execute(new de7.d(r111, r112, r113, r114, r115, r116, r117, r210, r211));
    }

    public static void e(String r100, String r101, String r102, int r103, String r104, Integer r105, String r106, String r110, String r111, long r112, boolean r113) {
        SLMonitorCompat r107 = SLMonitorCompat.f41001a;
        g7 r108 = new g7();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r108.f268086a = r102;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r108.f268087b = r101;
        r108.f268088c = r103;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r108.f268089d = r104;
        if (r111 != null) goto L5;
        r111 = "";
    L5:
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r108.f268090e = r111;
        if (r105 == null) goto L8;
        int r109 = r105.intValue();
    L9:
        r108.f268091f = r109;
        if (r110 != null) goto L12;
        r110 = "";
    L12:
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r108.f268093h = r110;
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r108.f268094i = r106;
        r108.f268095j = System.currentTimeMillis();
        r108.f268092g = r112;
        r108.f268096k = r113;
        Unit r114 = Unit.INSTANCE;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r108, "xRequestParams");
        if (SLMonitorCompat.f41002b == false) goto L20;
        com.bytedance.android.anniex.monitor.salamander.c.f41013a.a(r100).z(r108);
        return;
    L20:
        return;
    L8:
        r109 = 0;
        goto L9
    }
}
