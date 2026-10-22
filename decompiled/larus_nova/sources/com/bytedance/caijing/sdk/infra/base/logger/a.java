package com.bytedance.caijing.sdk.infra.base.logger;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202761a = 0;

    static {
    }

    public static void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter("CJPayNetworkManager", "tag");
        Intrinsics.checkNotNullParameter(r100, "path");
        CJLogger.b("CJPayNetworkManager", "server_api_call:[" + r100 + "]:[" + r101 + ']');
    }

    public static void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter("CJPayNetworkManager", "tag");
        Intrinsics.checkNotNullParameter(r100, "path");
        CJLogger.d("CJPayNetworkManager", "server_api_call:[" + r100 + "]:[" + r101 + ']');
    }

    public static void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter("CJPayNetworkManager", "tag");
        Intrinsics.checkNotNullParameter(r100, "path");
        CJLogger.b("CJPayNetworkManager", "server_api_callback:[" + r100 + "]:[" + r101 + "]:[]");
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "name");
        CJLogger.b(r100, "branch:[" + r101 + "]:[" + r102 + ']');
    }

    public static void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "name");
        CJLogger.d(r100, "branch:[" + r101 + "]:[" + r102 + ']');
    }

    public static void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "name");
        CJLogger.b(r100, "business:[" + r101 + "]:[" + r102 + ']');
    }

    public static void d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "name");
        CJLogger.d(r100, "business:[" + r101 + "]:[" + r102 + ']');
    }

    public static void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "name");
        CJLogger.b(r100, "exception:[" + r101 + "]:[" + r102 + ']');
    }

    public static void i(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("CJPayNetworkManager", "tag");
        Intrinsics.checkNotNullParameter(r100, "path");
        CJLogger.d("CJPayNetworkManager", "server_api_callback:[" + r100 + "]:[" + r101 + "]:[" + r102 + ']');
    }

    public static void j(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.IDENTIFIER);
        JSONObject r103 = new JSONObject();
        r103.put("page_name", r101);
        r103.put(LocationMonitorConst.IDENTIFIER, r102);
        CJLogger.d("Page", "page_event:[" + r100 + "]:[" + r103 + ']');
    }
}
