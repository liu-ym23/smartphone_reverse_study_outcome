package v4c;

import com.alipay.sdk.m.p.e;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.g;
import com.ss.android.lark.security.compliance.infra.network.h;
import com.ss.android.lark.security.compliance.infra.util.f;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static final void c(g r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        List<String> r101 = w4c.c.a().m0();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        String r103 = u4c.a.f548750a;
        u4c.a.a("scs_network_state_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("path", r100.getPath()), TuplesKt.to("domain", r100.getHost()), TuplesKt.to("event_type", "REPORTNETREQUESTSTART")}), null, null, 0, 28);
        return;
    L5:
        if (r101.contains(r100.getPath()) != true) goto L7;
        r102 = true;
        goto L8
    }

    public static final <T> h<T> a(String r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r101, "type");
        JsonObject r102 = (JsonObject) f.b().fromJson(r100, JsonObject.class);     // Catch: Exception -> L7
        if (r102 != null) goto L27;
        r102 = new JsonObject();     // Catch: Exception -> L7
    L27:
        int r103 = r102.get("code").getAsInt();     // Catch: Throwable -> L11
    L29:
        JsonElement r104 = r102.get("msg");     // Catch: Throwable -> L18
        if (r104 != null) goto L16;
        r104 = r102.get("message");     // Catch: Throwable -> L18
    L16:
        String r105 = r104.getAsString();     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L18
    L20:
        h<T> r106 = new h(r103, r105, r102);
        T r107 = (T) f.b().fromJson(r102.get("data").getAsJsonObject(), r101);
    L25:
        r106.f440448d = r107;
        return r106;
    L23:
        th = move-exception;
        int r108 = ScsLogger.f440428a;
        ScsLogger.c("RequestManager", "parseResponseBody()-get data error. " + ExceptionsKt.stackTraceToString(th) + ' ');
        r107 = null;
    L18:
        th = move-exception;
        int r109 = ScsLogger.f440428a;
        ScsLogger.d("RequestManager", "parseResponseBody()-get message error. " + ExceptionsKt.stackTraceToString(th) + ' ');
        r105 = "Response message is null";
    L11:
        th = move-exception;
        int r110 = ScsLogger.f440428a;
        ScsLogger.c("RequestManager", "parseResponseBody()-get code error. " + ExceptionsKt.stackTraceToString(th) + ' ');
        r103 = 0;
    L7:
        r102 = new JsonObject();
        goto L27
    }

    public static void b(g r100, Integer r101, String r102, Integer r103, Integer r110, String r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r101 = -1;
    L6:
        if ((r112 & 4) == 0) goto L9;
        r102 = "unknown error message";
    L9:
        if ((r112 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r112 & 16) == 0) goto L15;
        r110 = null;
    L15:
        if ((r112 & 32) == 0) goto L17;
        r111 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, "request");
        String r113 = u4c.a.f548750a;
        u4c.a.a("scs_network_state_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("domain", r100.getHost()), TuplesKt.to("path", r100.getPath()), TuplesKt.to(e.f25671s, r100.getMethod()), TuplesKt.to("error_code", r101), TuplesKt.to("error_msg", r102), TuplesKt.to("x_tt_logid", r111), TuplesKt.to("event_type", "REPORTNETERROR"), TuplesKt.to(UniContext.KEY_OF_BIZ_CODE, r103), TuplesKt.to("http_code", r110)}), null, null, 0, 28);
    }
}
