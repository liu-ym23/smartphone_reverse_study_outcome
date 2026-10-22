package com.larus.init.task;

import android.net.Uri;
import com.bytedance.router.listener.error.ErrorType;
import com.bytedance.router.listener.error.SmartRouterException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.chat.IMarkdownResolver;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.route.HomeRouterServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class i0 implements r97.b {
    public /* synthetic */ i0() {
    }

    public final void a(ErrorType r110, com.bytedance.router.c r111, SmartRouterException r112) {
        int r100 = InitSmartRouterTask.f351091b;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("ErrorListener: errorType -> ");
        r102.append(r110);
        r102.append(" , error -> ");
        r102.append(r112.getMessage());
        r102.append(" , uri -> ");
        String r103 = null;
        if (r111 == null) goto L5;
        Uri r104 = r111.f267530d;
    L6:
        r102.append(r104);
        r101.e("SmartRouter", r102.toString(), r112);
        IApplog.Companion r105 = IApplog.f287053a;
        JSONObject r106 = new JSONObject();
        r106.put("errorType", r110);
        r106.put("errorMessage", r112.getMessage());
        HomeRouterServiceDelegate r107 = HomeRouterServiceDelegate.f344101a;
        if (r111 == null) goto L11;
        Uri r108 = r111.f267530d;
        if (r108 == null) goto L11;
        String r109 = r108.toString();
    L12:
        r106.put(RemoteMessageConst.Notification.INTENT_URI, r107.e(r109));
        Unit r113 = Unit.INSTANCE;
        r105.reportEvent("rd_open_route_error", r106);
        AppHost.Companion r114 = AppHost.f326268a;
        if (r114.isTestChannel() == false) goto L19;
        StringBuilder r115 = new StringBuilder("SmartRouter: uri:");
        if (r111 == null) goto L17;
        Uri r116 = r111.f267530d;
    L18:
        r115.append(r116);
        r115.append(", errorType -> ");
        r115.append(r110);
        r115.append(" , error -> ");
        r115.append(r112.getMessage());
        t19.s.j(t19.s.f544207a, r114.getApplication().getApplicationContext(), r115.toString(), null, false, 28);
        goto L19
    L17:
        r116 = null;
    L19:
        com.larus.platform.service.g r117 = com.larus.platform.service.g.f365738a;
        Intrinsics.checkNotNull(r112);
        Pair[] r118 = new Pair[2];
        if (r111 == null) goto L24;
        Uri r119 = r111.f267530d;
        if (r119 == null) goto L24;
        String r120 = r119.toString();
    L25:
        String r121 = "";
        if (r120 != null) goto L28;
        r120 = "";
    L28:
        r118[0] = TuplesKt.to("uri", r120);
        if (r110 == null) goto L31;
        String r122 = r110.toString();
    L32:
        if (r122 == null) goto L35;
        r121 = r122;
    L35:
        r118[1] = TuplesKt.to("errorType", r121);
        r117.ensureNotReachHere(r112, "SmartRouter OnError", MapsKt.mapOf(r118));
        IMarkdownResolver r123 = (IMarkdownResolver) ServiceManager.get().getService(IMarkdownResolver.class);
        if (r123 == null) goto L46;
        if (r110 == null) goto L39;
        String r124 = r110.name();
    L40:
        if (r111 == null) goto L44;
        Uri r125 = r111.f267530d;
        if (r125 == null) goto L44;
        r103 = r125.toString();
    L44:
        r123.a(r124, r103, r112.getMessage());
        return;
    L39:
        r124 = null;
        goto L40
    L46:
        return;
    L31:
        r122 = null;
    L24:
        r120 = null;
    L11:
        r109 = null;
        goto L12
    L5:
        r104 = null;
        goto L6
    }
}
