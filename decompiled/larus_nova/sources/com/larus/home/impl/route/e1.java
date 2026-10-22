package com.larus.home.impl.route;

import android.net.Uri;
import com.bytedance.ai.api.navi.AppletNaviThirdApp;
import com.bytedance.ai.api.navi.IAppletNaviService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class e1 implements IAppletNaviService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c1 f346077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f346078b;

    public e1(c1 r100, Uri r101) {
        this.f346077a = r100;
        this.f346078b = r101;
    }

    @Override // com.bytedance.ai.api.navi.IAppletNaviService.a
    public final void onResult(int r100, String r101) {
        if (r101 != null) goto L5;
        String r102 = "null";
    L11:
        c1 r103 = this.f346077a;
        Uri r104 = this.f346078b;
        r103.getClass();
        String r105 = UriProtector.getQueryParameter(r104, "trace_info");
        if (r105 == null) goto L20;
        JSONObject r106 = new JSONObject(r105);     // Catch: JSONException -> L15
        r106.put("app_name", r102);     // Catch: JSONException -> L15
        TrackParams r107 = new TrackParams().merge(r106);     // Catch: JSONException -> L15
        by7.a r108 = new by7.a("start_navigate");     // Catch: JSONException -> L15
        r108.f21463a.merge(r107);     // Catch: JSONException -> L15
        r108.b();     // Catch: JSONException -> L15
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("ThirdAppInterceptor", "wrong trace_info", e);
        return;
    L20:
        return;
    L5:
        if (Intrinsics.areEqual(r101, AppletNaviThirdApp.AMAP) == false) goto L7;
        r102 = "awe";
        goto L11
    L7:
        r102 = "baidu";
        if (Intrinsics.areEqual(r101, "baidu") == true) goto L11;
        r102 = "unknown";
        goto L11
    }
}
