package com.larus.live.impl.bridge.request;

import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.lynx.tasm.LynxError;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class b implements u56.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f355785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC4403a f355786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ XBridgePlatformType f355787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ XRequestMethod f355788e;

    @Override // u56.a
    public final void c(Integer r110, Throwable r111, int r112) {
        Intrinsics.checkNotNullParameter(r111, LynxError.LYNX_THROWABLE);
        if ((r111 instanceof NetworkNotAvailabeException) == false) goto L5;
        int r100 = -1001;
    L6:
        XRequestMethod r101 = this.f355788e;
        String r102 = this.f355784a;
        String r103 = this.f355785b;
        int r104 = -408;
        if (r110 == null) goto L9;
        int r105 = r110.intValue();
    L10:
        Integer r106 = Integer.valueOf(r105);
        String r107 = r111.toString();
        String r108 = this.f355787d.name();
        r101.g(r102, r103, r106, r100, r107, r108);
        a.InterfaceC4403a r109 = this.f355786c;
        e r113 = new e();
        if (r110 != null) goto L13;
        Integer r114 = -408;
    L14:
        r113.f355799a = r114;
        r113.f355800b = Integer.valueOf(r112);
        LinkedHashMap r115 = new LinkedHashMap();
        if (r110 == null) goto L17;
        r104 = r110.intValue();
    L17:
        r115.put("errCode", Integer.valueOf(r104));
        String r116 = r111.getMessage();
        if (r116 != null) goto L20;
        r116 = "";
    L20:
        r115.put("message", r116);
        r115.put("prompts", "");
        r113.f355802d = r115;
        Unit r117 = Unit.INSTANCE;
        r109.a(r100, "", r113);
        return;
    L13:
        r114 = r110;
        goto L14
    L9:
        r105 = -408;
        goto L10
    L5:
        r100 = 0;
        goto L6
    }

    public b(d r100, a.InterfaceC4403a r101, XBridgePlatformType r102, XRequestMethod r103) {
        this.f355786c = r101;
        this.f355787d = r102;
        this.f355788e = r103;
        this.f355784a = r100.a();
        this.f355785b = r100.getUrl();
    }

    @Override // u56.a
    public final void a(JSONObject r100, LinkedHashMap<String, String> r101, Integer r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r101, "responseHeader");
        a.InterfaceC4403a r104 = this.f355786c;
        e r105 = new e();
        if (r102 != null) goto L5;
        r102 = -1;
    L5:
        r105.f355799a = r102;
        r105.f355800b = Integer.valueOf(r103);
        r105.f355801c = r101;
        String r106 = r101.get(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Throwable -> L15
        LinkedHashMap r107 = new LinkedHashMap();     // Catch: Throwable -> L15
        Iterator<String> r108 = r100.keys();     // Catch: Throwable -> L15
    L8:
        if (r108.hasNext() == false) goto L11;
        String r109 = r108.next();     // Catch: Throwable -> L15
        r107.put(r109, r100.get(r109));     // Catch: Throwable -> L15
        goto L8
    L11:
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r107.put("_Header_RequestID", r106);     // Catch: Throwable -> L15
        r105.f355802d = r107;     // Catch: Throwable -> L15
    L16:
        r104.b(r105, "");
        return;
    L15:
        int r110 = XRequestMethod.f355774c;
        goto L16
    }

    @Override // u56.a
    public final Unit b(JSONObject r100, LinkedHashMap<String, String> r110, String r111, Throwable r112, Integer r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r110, "responseHeader");
        Intrinsics.checkNotNullParameter(r111, "rawResponse");
        Intrinsics.checkNotNullParameter(r112, LynxError.LYNX_THROWABLE);
        String r101 = this.f355784a;
        String r102 = this.f355785b;
        String r103 = r112.toString();
        String r104 = this.f355787d.name();
        this.f355788e.g(r101, r102, r113, 0, r103, r104);
        a.InterfaceC4403a r105 = this.f355786c;
        String r115 = r112.toString();
        e r106 = new e();
        if (r113 != null) goto L5;
        r113 = -1;
    L5:
        r106.f355799a = r113;
        r106.f355800b = Integer.valueOf(r114);
        r106.f355801c = r110;
        String r116 = r110.get(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Throwable -> L15
        LinkedHashMap r117 = new LinkedHashMap();     // Catch: Throwable -> L15
        Iterator<String> r118 = r100.keys();     // Catch: Throwable -> L15
    L8:
        if (r118.hasNext() == false) goto L11;
        String r107 = r118.next();     // Catch: Throwable -> L15
        r117.put(r107, r100.get(r107));     // Catch: Throwable -> L15
        goto L8
    L11:
        if (r116 != null) goto L13;
        r116 = "";
    L13:
        r117.put("_Header_RequestID", r116);     // Catch: Throwable -> L15
        r106.f355802d = r117;     // Catch: Throwable -> L15
    L16:
        r106.f355803e = r111;
        Unit r108 = Unit.INSTANCE;
        r105.a(0, r115, r106);
        return Unit.INSTANCE;
    L15:
        int r109 = XRequestMethod.f355774c;
        goto L16
    }
}
