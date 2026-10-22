package com.bytedance.lynx.service.network;

import android.content.Context;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpResponse;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.ILynxHttpService;
import com.lynx.tasm.service.IServiceProvider;
import com.lynx.tasm.utils.j;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import i8a.i;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes21.dex */
public class LynxHttpService implements ILynxHttpService {
    private static final String KEY_CLIENT_CODE = "clientCode";
    private static final String KEY_ERROR_MESSAGE = "errorMessage";
    private static final String KEY_NEED_COMMON_PARAMS = "needCommonParams";
    private static final String KEY_PRIORITY_LEVEL = "priorityLevel";
    private static final String KEY_URL_PARAMS = "params";
    private static final String TAG = "LynxHttpService";
    private static volatile LynxHttpService mInstance;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HttpRequest f264895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f264896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z5a.a f264897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f264898d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f264899e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicBoolean f264900f;

        /* JADX INFO: renamed from: com.bytedance.lynx.service.network.LynxHttpService$a$a, reason: collision with other inner class name */
        public class C3712a implements ExpandCallback<TypedInput> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f264901a;

            @Override // com.bytedance.retrofit2.ExpandCallback
            public final void onAsyncPreRequest(RequestBuilder r100) {
            }

            @Override // com.bytedance.retrofit2.Callback
            public final void onResponse(Call<TypedInput> r100, SsResponse<TypedInput> r101) {
            }

            public C3712a(a r100) {
                this.f264901a = r100;
            }

            @Override // com.bytedance.retrofit2.ExpandCallback
            public final void onAsyncResponse(Call<TypedInput> r100, final SsResponse<TypedInput> r101) {
                boolean r102 = false;
                if (this.f264901a.f264900f.compareAndSet(false, true) == true) goto L6;
                return;
            L6:
                if (this.f264901a.e() == false) goto L41;
                final a r103 = this.f264901a;
                r103.getClass();
                final HttpResponse r104 = new HttpResponse();
                r104.f381375c = r103.f264895a.f381369b;
                TraceEvent.beginSection("NetworkModule.callback", new LynxHttpService$NetTask$1(r103, r104, r101));
                r104.f381373a = r101.code();
                a.b(r104, r101.headers());
                TraceEvent.endSection("NetworkModule.callback");
                int r105 = b.f264902a;
                LLog.i("NetworkModule", "onRequestResponseStreaming");
                r103.f264896b.a(r104);
                JavaOnlyMap r106 = r104.getHttpHeaders();
                if (r106 == null) goto L15;
                Iterator<Map.Entry<String, Object>> r107 = r106.entrySet().iterator();
            L11:
                if (r107.hasNext() == false) goto L15;
                Map.Entry<String, Object> r108 = r107.next();
                if ("Content-Type".equalsIgnoreCase(r108.getKey()) == false) goto L11;
                Object r109 = r108.getValue();
            L16:
                if (r109 != null) goto L18;
            L60:
                InputStream r110 = r101.body().in();     // Catch: Throwable -> L30 Exception -> L32
                if (r102 == false) goto L24;
                r103.f264897c.f(r110);     // Catch: Throwable -> L30 Exception -> L32
            L27:
                r103.f264897c.c();
                if (r100 == null) goto L67;
            L36:
                r100.cancel();
                return;
            L67:
                return;
            L24:
                if (r103.f264898d == false) goto L26;
                r103.f264897c.a(r110);     // Catch: Throwable -> L30 Exception -> L32
                goto L27
            L26:
                r103.f264897c.e(r110);     // Catch: Throwable -> L30 Exception -> L32
            L32:
                e = move-exception;
                r103.f264897c.d(e.toString());     // Catch: Throwable -> L30
                r103.f264897c.c();
                if (r100 != null) goto L36;
                return;
            L30:
                th = move-exception;
                r103.f264897c.c();
                if (r100 == null) goto L40;
                r100.cancel();
            L40:
                throw th;
            L18:
                if (r109.toString().toLowerCase().startsWith("text/event-stream") == false) goto L60;
                r102 = true;
            L15:
                r109 = null;
                goto L16
            L41:
                final a r111 = this.f264901a;
                r111.getClass();
                final HttpResponse r112 = new HttpResponse();
                r112.f381375c = r111.f264895a.f381369b;
                TraceEvent.beginSection("NetworkModule.callback", new LynxHttpService$NetTask$2(r111, r112));     // Catch: Throwable -> L46 Exception -> L48
                r112.f381373a = r101.code();     // Catch: Throwable -> L46 Exception -> L48
                a.b(r112, r101.headers());     // Catch: Throwable -> L46 Exception -> L48
                if (r101.body() == null) goto L50;
                r112.f381377e = a.d(r101.body().in());     // Catch: Throwable -> L46 Exception -> L48
            L50:
                if (r100 != null) goto L54;
            L55:
                TraceEvent.endSection("NetworkModule.callback");
                int r113 = b.f264902a;
                LLog.i("NetworkModule", "onRequestResponse");
                r111.f264896b.a(r112);
                return;
            L54:
                r100.cancel();
            L48:
                e = move-exception;
                a.c(r112, e.getClass().getSimpleName() + ":" + e.getMessage(), TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK, 0);     // Catch: Throwable -> L46
                if (r100 == null) goto L55;
            L46:
                th = move-exception;
                if (r100 == null) goto L59;
                r100.cancel();
            L59:
                throw th;
            }

            @Override // com.bytedance.retrofit2.Callback
            public final void onFailure(Call<TypedInput> r100, Throwable r101) {
                if (this.f264901a.f264900f.compareAndSet(false, true) == true) goto L5;
                return;
            L5:
                a r102 = this.f264901a;
                r102.getClass();
                HttpResponse r103 = new HttpResponse();
                r103.f381375c = r102.f264895a.f381369b;
                if ((r101 instanceof NetworkNotAvailabeException) == false) goto L9;
                a.c(r103, r101.getClass().getSimpleName() + ":" + r101.getMessage(), TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK, ((NetworkNotAvailabeException) r101).getCronetInternalErrorCode());
            L17:
                int r104 = b.f264902a;
                LLog.i("NetworkModule", "onRequestFailure");
                r102.f264896b.a(r103);
                if (r102.e() == false) goto L23;
                z5a.a r105 = r102.f264897c;
                if (r105 == null) goto L24;
                r105.d(r103.getStatusText());
                r102.f264897c.c();
                return;
            L24:
                return;
            L23:
                return;
            L9:
                if ((r101 instanceof CronetIOException) == false) goto L12;
                StringBuilder r106 = new StringBuilder();
                r106.append(r101.getClass().getSimpleName());
                r106.append(":");
                r106.append(r101.getMessage());
                r106.append(",");
                CronetIOException r107 = (CronetIOException) r101;
                r106.append(r107.getStatusCode());
                a.c(r103, r106.toString(), r107.getStatusCode(), r107.getCronetInternalErrorCode());
                goto L17
            L12:
                if ((r101 instanceof HttpResponseException) == false) goto L15;
                StringBuilder r108 = new StringBuilder();
                r108.append(r101.getClass().getSimpleName());
                r108.append(":");
                r108.append(r101.getMessage());
                r108.append(",");
                HttpResponseException r109 = (HttpResponseException) r101;
                r108.append(r109.getStatusCode());
                a.c(r103, r108.toString(), r109.getStatusCode(), 0);
                goto L17
            L15:
                if ((r101 instanceof Exception) == false) goto L17;
                a.c(r103, r101.getClass().getSimpleName() + ":" + r101.getMessage(), TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK, 0);
                goto L17
            }
        }

        public final void a() {
            int r100 = b.f264902a;
            HttpRequest r101 = this.f264895a;
            String r102 = r101.f381368a;
            String r103 = r101.f381369b;
            JavaOnlyMap r104 = r101.f381371d;
            if (r103 == null) goto L47;
            JavaOnlyMap r105 = r101.f381372e;
            boolean r106 = r105.getBoolean(LynxHttpService.KEY_NEED_COMMON_PARAMS, true);
            ReadableMap r107 = r105.getMap("params", new JavaOnlyMap());
            int r108 = r105.getInt(LynxHttpService.KEY_PRIORITY_LEVEL, 1);
            Map<String, String> r110 = j.a(r107);
            Pair<String, String> r109 = UrlUtils.parseUrl(r103, r110);     // Catch: IOException -> L44
            String r111 = r104.getString("Content-Type");
            byte[] r112 = this.f264895a.f381370c;
            if (r112 == null) goto L9;
            TypedByteArray r113 = new TypedByteArray(r111, r112, new String[0]);
        L10:
            TypedByteArray r114 = r113;
            Map<String, String> r115 = j.a(r104);
            ArrayList r116 = new ArrayList();
            Iterator r117 = ((HashMap) r115).entrySet().iterator();
        L12:
            if (r117.hasNext() == false) goto L16;
            Map.Entry r118 = (Map.Entry) r117.next();
            if (r118.getValue() == null) goto L12;
            r116.add(new Header((String) r118.getKey(), (String) r118.getValue()));
            goto L12
        L16:
            RequestContext r119 = new RequestContext();
            r119.isCustomizedCookie = this.f264895a.f381371d.hasKey("Cookie");
            String r120 = (String) r109.first;
            int r121 = b.f264902a;
            com.bytedance.lynx.service.network.a r122 = new com.bytedance.lynx.service.network.a();
            Retrofit r123 = new Retrofit.Builder().setEndpoint(r120).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor()).client(r122).build();
            String r124 = (String) r109.second;
            if (r102.equalsIgnoreCase("GET") == false) goto L29;
            if (e() == false) goto L21;
            Call<TypedInput> r125 = ((NetApi) r123.create(NetApi.class)).doGetStreaming(r106, -1, r124, r110, r116, r119);
        L40:
            r125.enqueue(new C3712a(this));
            return;
        L21:
            if (r108 != 0) goto L23;
            r125 = ((NetApi) r123.create(NetApi.class)).doGetLow(r106, -1, r124, r110, r116, r119);
            goto L40
        L23:
            if (r108 != 2) goto L25;
            r125 = ((NetApi) r123.create(NetApi.class)).doGetHigh(r106, -1, r124, r110, r116, r119);
            goto L40
        L25:
            if (r108 != 3) goto L27;
            r125 = ((NetApi) r123.create(NetApi.class)).doGetImmediate(r106, -1, r124, r110, r116, r119);
            goto L40
        L27:
            r125 = ((NetApi) r123.create(NetApi.class)).doGet(r106, -1, r124, r110, r116, r119);
            goto L40
        L29:
            if (r102.equalsIgnoreCase("POST") == false) goto L43;
            if (e() == false) goto L33;
            r125 = ((NetApi) r123.create(NetApi.class)).doPostStreaming(r106, -1, r124, r110, r116, r114, r119);
            goto L40
        L33:
            if (r108 != 0) goto L35;
            r125 = ((NetApi) r123.create(NetApi.class)).doPostLow(r106, -1, r124, r110, r116, r114, r119);
            goto L40
        L35:
            if (r108 != 2) goto L37;
            r125 = ((NetApi) r123.create(NetApi.class)).doPostHigh(r106, -1, r124, r110, r116, r114, r119);
            goto L40
        L37:
            if (r108 != 3) goto L39;
            r125 = ((NetApi) r123.create(NetApi.class)).doPostImmediate(r106, -1, r124, r110, r116, r114, r119);
            goto L40
        L39:
            r125 = ((NetApi) r123.create(NetApi.class)).doPost(r106, -1, r124, r110, r116, r114, r119);
            goto L40
        L43:
            throw new IllegalArgumentException("Unsupported HTTP Method.");
        L9:
            r113 = new TypedByteArray(r111, new byte[0], new String[0]);
        L45:
            throw new IllegalArgumentException("Unsupported HTTP url. url is not valid.");
        L47:
            throw new IllegalArgumentException("Unsupported HTTP url. url is empty.");
        }

        public final boolean e() {
            if (this.f264898d == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f264899e == true) goto L8;
            return false;
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

        public static byte[] d(InputStream r100) throws IOException {
            BufferedInputStream r101 = new BufferedInputStream(r100);
            ByteArrayOutputStream r102 = new ByteArrayOutputStream();
            byte[] r103 = new byte[4096];
        L3:
            int r104 = r101.read(r103);
            if (r104 == (-1)) goto L5;
            r102.write(r103, 0, r104);
            goto L3
        L5:
            r101.close();
            return r102.toByteArray();
        }

        public static void b(HttpResponse r100, List r101) {
            ArrayList r102 = new ArrayList();
            JavaOnlyMap r103 = r100.getHttpHeaders();
            Iterator r104 = r101.iterator();
            String r105 = "set-cookie";
        L4:
            if (r104.hasNext() == false) goto L10;
            Header r106 = (Header) r104.next();
            if ("set-cookie".equalsIgnoreCase(r106.getName()) == true) goto L7;
            r103.putString(r106.getName(), r106.getValue());
            goto L4
        L7:
            r105 = r106.getName();
            r102.add(r106.getValue());
            goto L4
        L10:
            if (r102.size() <= 0) goto L25;
            StringBuilder r107 = new StringBuilder();
            Iterator r108 = r102.iterator();
            if (r108.hasNext() == false) goto L16;
        L13:
            r107.append((CharSequence) r108.next());
            if (r108.hasNext() == false) goto L16;
            r107.append(", ");
        L16:
            r103.putString(r105, r107.toString());
            return;
        }

        public a(HttpRequest r100, i r101, z5a.a r102) {
            this.f264895a = r100;
            this.f264896b = r101;
            this.f264900f = new AtomicBoolean(false);
            this.f264897c = r102;
            this.f264898d = r100.f381372e.getBoolean("useStreaming", false);
            this.f264899e = r100.f381372e.getBoolean("enableFetchAPIStandardStreaming", false);
        }

        public static void c(HttpResponse r100, String r101, int r102, int r103) {
            r100.f381374b = r101;
            r100.f381373a = r102;
            r100.getCustomInfo().put(LynxHttpService.KEY_CLIENT_CODE, Integer.valueOf(r103));
            r100.getCustomInfo().put("errorMessage", r101);
        }
    }

    private LynxHttpService() {
    }

    @Override // com.lynx.tasm.service.ILynxHttpService, com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ Class getServiceClass() {
        return ILynxHttpService.CC.$default$getServiceClass(this);
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ void onInitialize(Context r100) {
        IServiceProvider.CC.$default$onInitialize(this, r100);
    }

    public static LynxHttpService getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(LynxHttpService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new LynxHttpService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxHttpService.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    @Override // com.lynx.tasm.service.ILynxHttpService
    public void request(HttpRequest r100, i r101) {
        doRequest(r100, r101, null);
    }

    private void doRequest(HttpRequest r100, i r101, z5a.a r102) {
        LLog.i("NetworkModule", "call http request with url: " + r100.f381369b);
        TraceEvent.beginSection("NetworkModule.call");
        int r103 = b.f264902a;
        new a(r100, r101, r102).run();
        TraceEvent.endSection("NetworkModule.call");
    }

    @Override // com.lynx.tasm.service.ILynxHttpService
    public void requestStreaming(HttpRequest r100, i r101, z5a.a r102) {
        doRequest(r100, r101, r102);
    }
}
