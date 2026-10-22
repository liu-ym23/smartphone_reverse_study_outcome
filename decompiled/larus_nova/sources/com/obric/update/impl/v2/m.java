package com.obric.update.impl.v2;

import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricBannerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f404127d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final goa.a f404128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final goa.b f404129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f404130c;

    public static final class a {
    }

    static {
    }

    public m(goa.a r100, goa.b r101, o r102) {
        Intrinsics.checkNotNullParameter(r100, "flowContext");
        Intrinsics.checkNotNullParameter(r101, "stateHolder");
        Intrinsics.checkNotNullParameter(r102, "gateways");
        this.f404128a = r100;
        this.f404129b = r101;
        this.f404130c = r102;
    }

    public final JSONObject a(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("stage", r100);
        r103.put("result", r101);
        boolean r104 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L11;
        r103.put("reason", r102);
    L11:
        IObricUpdateService r106 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        Boolean r107 = null;
        if (r106 == null) goto L14;
        String r108 = r106.m();
    L15:
        r103.put("trigger_source", r108);
        r103.put("update_state", this.f404129b.f481960b);
        IObricUpdateService r109 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r109 == null) goto L20;
        ObricBannerType r110 = r109.getBannerType();
        if (r110 == null) goto L20;
        int r111 = r110.getValue();
    L21:
        r103.put("banner_type", r111);
        this.f404130c.f404134d.getClass();     // Catch: Exception -> L24
        Boolean r112 = Boolean.valueOf(com.obric.update.impl.v2.gateway.c.b());     // Catch: Exception -> L24
    L25:
        if (r112 == null) goto L27;
        boolean r113 = r112.booleanValue();
    L28:
        r103.put(ParamKeyConstants.WebViewConstants.IS_WIFI, r113);
        this.f404130c.f404134d.getClass();     // Catch: Exception -> L31
        r107 = Boolean.valueOf(com.obric.update.impl.v2.gateway.c.a());     // Catch: Exception -> L31
    L32:
        if (r107 == null) goto L34;
        r104 = r107.booleanValue();
    L34:
        r103.put("is_network_available", r104);
        r103.put("is_app_foreground", this.f404128a.f481950a);
        r103.put("is_user_manual_download", this.f404128a.f481951b);
        r103.put("is_wifi_auto_download", this.f404128a.f481952c);
        r103.put("is_wifi_auto_interfered", this.f404128a.f481953d);
        r103.put("is_zeus_plugin_preinstalling", this.f404128a.f481956g);
        r103.put("is_downloading", this.f404128a.f481954e);
        return r103;
    L27:
        r113 = false;
    L24:
        r112 = null;
    L20:
        r111 = 0;
        goto L21
    L14:
        r108 = null;
        goto L15
    L5:
        if (r102.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    public final void c(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "reason");
        b(r100, "blocked", r101, r102);
    }

    public static void d(m r100, String r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "stage");
        r100.b(r101, "start", r102, null);
    }

    public static void e(m r100, String r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "stage");
        r100.b(r101, "success", r102, null);
    }

    public final void b(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "result");
        JSONObject r104 = a(r100, r101, r102);     // Catch: Exception -> L14
        if (r103 == null) goto L10;
        Iterator<String> r105 = r103.keys();     // Catch: Exception -> L14
        if (r105 == null) goto L10;
    L8:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();     // Catch: Exception -> L14
        r104.put(r106, r103.opt(r106));     // Catch: Exception -> L14
    L10:
        IObricUpdateService r107 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Exception -> L14
        if (r107 == null) goto L20;
        r107.h("obric_update_pipeline", r104);     // Catch: Exception -> L14
        return;
    L20:
        return;
    L14:
        e = move-exception;
        FLogger.f375446a.i("ObricUpdatePipelineReporter", "report error: stage=" + r100 + ",err=" + e);
    }
}
