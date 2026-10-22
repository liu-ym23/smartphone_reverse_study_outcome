package x20;

import ac2.s;
import ac2.z;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.common.utility.Logger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.ugc.live.sdk.msg.network.HttpMethod;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.sendByteLinkApiRequest", owner = "JiangXZ")
public final class e extends a implements h {
    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public e() {
    }

    public static com.ss.ugc.live.sdk.msg.network.f a(IBDXBridgeContext r100, a.b r101, HttpMethod r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
        LinkedHashMap r103 = new LinkedHashMap();
        Map<String, Object> r104 = r101.getHeaders();
        if (r104 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r105 = r104.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        Map.Entry<String, Object> r106 = r105.next();
        r103.put(r106.getKey(), r106.getValue().toString());
    L8:
        LinkedHashMap r107 = new LinkedHashMap();
        Map<String, Object> r108 = r101.getQueryParams();
        if (r108 == null) goto L14;
        Iterator<Map.Entry<String, Object>> r109 = r108.entrySet().iterator();
    L12:
        if (r109.hasNext() == false) goto L14;
        Map.Entry<String, Object> r110 = r109.next();
        r107.put(r110.getKey(), r110.getValue().toString());
    L14:
        IMiddlewareNetworkService r111 = (IMiddlewareNetworkService) k.f(IMiddlewareNetworkService.class);
        if (r111 == null) goto L17;
        r107.putAll(r111.getCommonParams());
    L17:
        IMiddlewareHostNetwork r112 = (IMiddlewareHostNetwork) k.f(IMiddlewareHostNetwork.class);
        if (r112 == null) goto L20;
        r107.putAll(r112.getCommonParams());
    L20:
        String r113 = r101.getHttpURL();
        boolean r114 = false;
        byte[] r115 = null;
        if (r113 != null) goto L23;
    L31:
        Set<String> r116 = SecurityContextUtils.f269807a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r117 = "x-security-argus";
        if ("x-security-argus".length() <= 0) goto L34;
        boolean r118 = true;
    L35:
        if (r118 == true) goto L38;
        r117 = null;
    L38:
        String r119 = SecurityContextUtils.d(r100);
        if (r119.length() <= 0) goto L41;
        r114 = true;
    L41:
        if (r114 == true) goto L44;
        r119 = null;
    L44:
        if (r117 == null) goto L47;
        if (r119 == null) goto L47;
        String r120 = (String) r103.put(r117, r119);
    L47:
        com.ss.ugc.live.sdk.msg.network.f.a r121 = new com.ss.ugc.live.sdk.msg.network.f.a();
        String r122 = r101.getHttpURL();
        if (r122 != null) goto L50;
        r122 = "";
    L50:
        com.ss.ugc.live.sdk.msg.network.f r123 = r121.f458310a;
        r123.f458299b = r122;
        r123.f458300c = r103;
        com.ss.ugc.live.sdk.msg.network.f.a r124 = r121.query(r107);
        r124.f458310a.f458298a = r102;
        Number r125 = r101.getTimeout();
        if (r125 == null) goto L53;
        long r126 = r125.longValue();
    L54:
        com.ss.ugc.live.sdk.msg.network.f r127 = r124.f458310a;
        r127.f458306i = r126;
        r127.f458304g = "application/json";
        r127.f458309l = true;
        String r128 = r101.getPayload();
        if (r128 == null) goto L57;
        r115 = r128.getBytes(Charsets.UTF_8);
    L57:
        r124.f458310a.f458302e = r115;
        return r124.a();
    L53:
        r126 = 2000;
        goto L54
    L34:
        r118 = false;
        goto L35
    L23:
        if (r113.length() <= 0) goto L25;
        boolean r129 = true;
    L26:
        if (r129 == true) goto L29;
        r113 = null;
    L29:
        if (r113 == null) goto L31;
        r103.putAll(s.a(r113, false));
        goto L31
    L25:
        r129 = false;
        goto L26
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a.b r103 = (a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Number r104 = r103.getMethod();
        if (Intrinsics.areEqual(r104, 1) == false) goto L6;
        com.ss.ugc.live.sdk.msg.network.f r105 = a(r100, r103, HttpMethod.GET);
    L8:
        long r106 = r103.getServiceID().longValue();
        z r107 = ac2.c.f2568a;
        Intrinsics.checkNotNullParameter(r105, "httpRequest");
        Logger.i("LiveUplink", "start sendRequest");
        Observable.create(new ac2.b(r106, r105)).subscribeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe(new c(r102, r103), new d(r102, r103));
        return;
    L6:
        if (Intrinsics.areEqual(r104, 2) == false) goto L9;
        r105 = a(r100, r103, HttpMethod.POST);
        goto L8
    L9:
        r102.onFailure(0, "Method isNot Support", (XBaseResultModel) ne7.e.b(a.c.class));
    }
}
