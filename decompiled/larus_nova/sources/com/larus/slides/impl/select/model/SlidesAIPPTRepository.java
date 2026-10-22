package com.larus.slides.impl.select.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class SlidesAIPPTRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SlidesAIPPTRepository f369645a = null;

    static {
        f369645a = new SlidesAIPPTRepository();
    }

    public SlidesAIPPTRepository() {
    }

    public final Object a(a r110, Continuation<? super com.larus.network.http.a<b>> r111) {
        if ((r111 instanceof SlidesAIPPTRepository$genImages$1) == false) goto L7;
        SlidesAIPPTRepository$genImages$1 r100 = (SlidesAIPPTRepository$genImages$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SlidesAIPPTRepository$genImages$1 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L51:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        FLogger.f375446a.i("CommerceCreditRepo", "genImages end");
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceCreditRepo", "genImages start");
        e.a r106 = e.f369646a;
        if (e.f369647b != null) goto L25;
        monitor-enter(r106);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (e.f369647b != null) goto L20;
        e.f369647b = new e();     // Catch: Throwable -> L22
    L20:
        monitor-exit(r106);
    L25:
        r112.label = 1;
        JSONArray r107 = new JSONArray();
        List<c> r108 = r110.d();
        if (r108 == null) goto L48;
        Iterator<T> r109 = r108.iterator();
    L29:
        if (r109.hasNext() == false) goto L48;
        c r113 = (c) r109.next();
        JSONObject r114 = new JSONObject();
        if (r113 == null) goto L35;
        String r115 = r113.b();
        if (r115 == null) goto L35;
        r114.put("uri", r115);
    L35:
        if (r113 == null) goto L39;
        String r116 = r113.c();
        if (r116 == null) goto L39;
        r114.put("url", r116);
    L39:
        if (r113 == null) goto L43;
        Integer r117 = r113.d();
        if (r117 == null) goto L43;
        r114.put("width", r117.intValue());
    L43:
        if (r113 == null) goto L47;
        Integer r118 = r113.a();
        if (r118 == null) goto L47;
        r114.put("height", r118.intValue());
    L47:
        r107.put(r114);
    L48:
        JSONObject r119 = new JSONObject();
        r119.put("scene", 1);
        r119.put("query", r110.b());
        r119.put(MapBundleKey.OfflineMapKey.OFFLINE_RATION, r110.c());
        r119.put("reference_images", r107);
        r119.put("need_short_link", r110.a());
        Unit r120 = Unit.INSTANCE;
        Map r121 = MapsKt.mapOf(TuplesKt.to("scene", "SlidesAIPPTGenerateImage"));
        RequestContext r122 = new RequestContext();
        r122.timeout_connect = 60000;
        r122.timeout_read = 60000;
        r122.timeout_write = 60000;
        r102 = HttpExtKt.k(ServiceType.BASIC_SERVICE, b.class, "/alice/aippt/gen_images", r119, null, null, true, r121, r122, null, r112, 560);
        if (r102 != r103) goto L51;
        return r103;
    L7:
        r100 = new SlidesAIPPTRepository$genImages$1(this, r111);
        goto L8
    }
}
