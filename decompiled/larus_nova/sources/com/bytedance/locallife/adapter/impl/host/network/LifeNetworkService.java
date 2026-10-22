package com.bytedance.locallife.adapter.impl.host.network;

import android.net.Uri;
import android.os.Bundle;
import com.alipay.sdk.m.p.e;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.experiment.f;
import com.bytedance.locallife.biz.perf.LifeFontFileCache;
import com.bytedance.locallife.biz.prefetch.newsdk.PrefetchManager;
import com.bytedance.locallife.biz.prefetch.newsdk.h;
import com.bytedance.locallife.biz.prefetch.newsdk.i;
import com.bytedance.locallife.biz.prefetch.newsdk.j;
import com.bytedance.locallife.biz.prefetch.newsdk.m;
import com.bytedance.locallife.dito.data.k;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.rxjava2.adapter.RxJava2CallAdapterFactory;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.lynx.tasm.LynxError;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes20.dex */
public class LifeNetworkService implements qt6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f256474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f256475b;

    public interface a {
        @Streaming
        @GET
        Call<TypedInput> a(@Url String r100);
    }

    @Override // qt6.b
    public final void h() {
    }

    @Override // qt6.b
    public final void j(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
    }

    @Override // qt6.b
    public final void m() {
    }

    @Override // qt6.b
    public final Map k() {
        return new LinkedHashMap();
    }

    public LifeNetworkService() {
        this.f256474a = new c();
        this.f256475b = LazyKt.lazy(new LifeNetworkService$commonInterceptor$2(this));
    }

    @Override // qt6.b
    public final Object d(Map r100) {
        Object r101 = null;
        if (f.c("goods_detail_page") == true) goto L5;
        return null;
    L5:
        i<com.bytedance.locallife.biz.prefetch.newsdk.f> r102 = PrefetchManager.f256936a;
        if (r100 == null) goto L8;
        String r103 = (String) ((LinkedHashMap) r100).get("prefetch_request_data_key");
    L9:
        if (r103 == null) goto L19;
        i<m<?>> r104 = PrefetchManager.f256938c;
        m<?> r105 = r104.get(r103);
        if (r105 == null) goto L14;
        Object r106 = r105.f256968b;
    L15:
        if (r106 == null) goto L18;
        r101 = r106;
    L18:
        r104.remove(r103);
        goto L19
    L14:
        r106 = null;
    L19:
        return r101;
    L8:
        r103 = null;
        goto L9
    }

    @Override // qt6.b
    public final Map<String, String> e(Uri r100) {
        if (r100 == null) goto L4;
        List<Pair<String, String>> r101 = yo6.a.f568668a;
        return yo6.a.a(new yo6.a.c(r100), new LinkedHashMap());
    L4:
        return new LinkedHashMap();
    }

    @Override // qt6.b
    public final String i(Bundle r100) {
        if (f.c("poi_detail") == true) goto L5;
        return null;
    L5:
        i<com.bytedance.locallife.biz.prefetch.newsdk.f> r101 = PrefetchManager.f256936a;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getString("prefetch_request_data_key");
    }

    @Override // qt6.b
    public final Map<String, String> l(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "queryParams");
        List<Pair<String, String>> r101 = yo6.a.f568668a;
        return yo6.a.a(new yo6.a.C8366a(r100), new LinkedHashMap());
    }

    @Override // qt6.b
    public final Object n(Bundle r100) {
        Object r101 = null;
        if (f.c("poi_detail") == true) goto L5;
        return null;
    L5:
        i<com.bytedance.locallife.biz.prefetch.newsdk.f> r102 = PrefetchManager.f256936a;
        if (r100 == null) goto L19;
        String r103 = r100.getString("prefetch_request_data_key", "");
        if (r103 == null) goto L19;
        i<m<?>> r104 = PrefetchManager.f256938c;
        m<?> r105 = r104.get(r103);
        if (r105 == null) goto L14;
        Object r106 = r105.f256968b;
    L15:
        if (r106 == null) goto L18;
        r101 = r106;
    L18:
        r104.remove(r103);
        goto L19
    L14:
        r106 = null;
    L19:
        return r101;
    }

    @Override // qt6.b
    public final Object c(Bundle r100, final k r101) {
        if (f.c("poi_detail") == true) goto L5;
        return r101;
    L5:
        i<com.bytedance.locallife.biz.prefetch.newsdk.f> r102 = PrefetchManager.f256936a;
        Function0<Object> r103 = new LifeNetworkService$createScenePrefetchQueryData$1(r101);
        Intrinsics.checkNotNullParameter(r103, e.f25671s);
        int r104 = m.f256966c;
        Object r105 = r103.invoke();
        StringBuilder r106 = new StringBuilder();
        r106.append(System.currentTimeMillis());
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        r106.append(r107);
        m r108 = new m(r106.toString(), r105);
        PrefetchManager.f256938c.put(r108.f256967a, r108);
        String r109 = r108.f256967a;
        Intrinsics.checkNotNullParameter(r109, "key");
        if (r100 == null) goto L13;
        r100.putString("prefetch_request_data_key", r109);
    L13:
        return r108.f256968b;
    L8:
        r107 = 0;
        goto L9
    }

    @Override // qt6.b
    public final <T> T create(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return (T) b(r100, r101, CollectionsKt.emptyList());
    }

    @Override // qt6.b
    public final Map<String, String> f(String r100, Map<String, String> r101) {
        List<Pair<String, String>> r102 = yo6.a.f568668a;
        LinkedHashMap r103 = new LinkedHashMap();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r103.put("Life-Biz-Code", r100);
        if (r101 == null) goto L10;
        String r104 = r101.get("life_btm_virtual_token");
        if (r104 == null) goto L10;
        String r105 = (String) r103.put("Life-Btm-Virtual-Token", r104);
    L10:
        yo6.a.b(r103, r101);
        return r103;
    }

    @Override // qt6.b
    public final <T> T b(String r100, Class<T> r101, List<? extends Interceptor> r102) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "interceptors");
        return (T) o(r100, r101, r102, null);
    }

    @Override // qt6.b
    public final void g(String r100, final String r101, Function1<? super String, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "resName");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r110, "callback");
        LifeFontFileCache.f256819a.a(HostServiceUtilsKt.E().getApplicationContext(), r100, r101, r110, new LifeNetworkService$downloadFile$1(this, r101));
    }

    public final <T> T o(String r100, Class<T> r101, List<? extends Interceptor> r102, Converter.Factory r103) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "interceptors");
        ArrayList r104 = new ArrayList();
        r104.addAll(CollectionsKt.listOf((Interceptor) this.f256475b.getValue()));
        r104.addAll(r102);
        return (T) RetrofitUtils.createService(RetrofitUtils.createSsRetrofit(r100, r104, r103, RxJava2CallAdapterFactory.create()), r101);
    }

    @Override // qt6.b
    public final <T> T a(String r100, boolean r101, Class<T> r102, List<? extends Interceptor> r103, String r104, Converter.Factory r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Intrinsics.checkNotNullParameter(r102, "clazz");
        Intrinsics.checkNotNullParameter(r103, "interceptors");
        Intrinsics.checkNotNullParameter(r104, "scene");
        if (f.c(r104) == false) goto L5;
        if (r110 == null) goto L18;
        ConcurrentHashMap<String, com.bytedance.locallife.biz.prefetch.newsdk.c> r106 = j.f256954a;
        boolean r107 = !r101;
        Intrinsics.checkNotNullParameter(r110, ST.UUID_DEVICE);
        ConcurrentHashMap<String, com.bytedance.locallife.biz.prefetch.newsdk.c> r108 = j.f256954a;
        monitor-enter(r108);
        com.bytedance.locallife.biz.prefetch.newsdk.c r109 = r108.get(r110);     // Catch: Throwable -> L15
        if (r107 == false) goto L12;
        r108.remove(r110);     // Catch: Throwable -> L15
    L12:
        monitor-exit(r108);
        if (r109 == null) goto L18;
    L19:
        ArrayList r111 = new ArrayList();
        if (r101 == false) goto L22;
        Interceptor r112 = new h(r109);
    L23:
        r111.add(r112);
        r111.addAll(r103);
        return (T) o(r100, r102, r111, r105);
    L22:
        r112 = new com.bytedance.locallife.biz.prefetch.newsdk.b(r109);
    L15:
        th = move-exception;
        throw th;
    L18:
        r109 = new com.bytedance.locallife.biz.prefetch.newsdk.a(r104);
        goto L19
    L5:
        return (T) o(r100, r102, r103, r105);
    }
}
