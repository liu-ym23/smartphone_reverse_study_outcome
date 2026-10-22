package com.larus.praise.config;

import android.app.Activity;
import android.content.Context;
import com.ixigua.lib.track.TrackParams;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import com.larus.search.api.IBrowserService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ds9.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements y57.a {

    /* JADX INFO: renamed from: com.larus.praise.config.a$a, reason: collision with other inner class name */
    public static final class C4474a {
    }

    static {
    }

    public a() {
    }

    @Override // y57.a
    public final void a() {
    }

    @Override // y57.a
    public final void b() {
    }

    @Override // y57.a
    public final void d() {
    }

    @Override // y57.a
    public final String getAppId() {
        return String.valueOf(AppHost.f326268a.getAppId());
    }

    @Override // y57.a
    public final String getHost() {
        HttpConst.f359979a.getClass();
        return HttpConst.f360025x;
    }

    @Override // y57.a
    public final String getPackageName() {
        String r100 = AppHost.f326268a.getApplication().getPackageName();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // y57.a
    public final Activity getTopActivity() {
        return AppHost.f326268a.a().getCurrentActivity();
    }

    @Override // y57.a
    public final void c(Context r100) {
        if (r100 == null) goto L7;
        IBrowserService r101 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r101 == null) goto L8;
        HttpConst.f359979a.getClass();
        r101.j(r100, HttpConst.E);
        return;
    L8:
        return;
    }

    @Override // y57.a
    public final void onEvent(String r100, JSONObject r101) {
        String r102 = cs9.a.f465188a;
        int r103 = h.f469893a;
        String r104 = cs9.a.f465188a;
        String r105 = cs9.a.f465189b;
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r106 = true;
        if (r104 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r107 == true) goto L11;
        r101.put("scene", r104);
    L11:
        if (r105 != null) goto L13;
    L16:
        if (r106 == true) goto L19;
        r101.put(MusicAppletPage.KEY_MESSAGE_ID, r105);
    L19:
        switch(r100.hashCode()) {
            case 319288017: goto L42;
            case 319638801: goto L34;
            case 841578353: goto L30;
            case 1304211044: goto L26;
            case 1680087751: goto L22;
            default: goto L45;
        };
    L45:
        IApplog.f287053a.reportEvent(r100, r101);
        return;
    L22:
        if (r100.equals("evaluate_jump_market") == false) goto L45;
        Intrinsics.checkNotNullParameter(r101, "params");
        TrackParams r108 = new TrackParams().merge(r101);
        by7.a r109 = new by7.a("evaluate_jump_market");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L26:
        if (r100.equals("evaluate_pop_close") == false) goto L45;
        Intrinsics.checkNotNullParameter(r101, "params");
        TrackParams r110 = new TrackParams().merge(r101);
        by7.a r111 = new by7.a("evaluate_pop_close");
        r111.f21463a.merge(r110);
        r111.b();
        return;
    L30:
        if (r100.equals("evaluate_pop_bad") == false) goto L45;
        Intrinsics.checkNotNullParameter(r101, "params");
        TrackParams r112 = new TrackParams().merge(r101);
        by7.a r113 = new by7.a("evaluate_pop_bad");
        r113.f21463a.merge(r112);
        r113.b();
        return;
    L34:
        if (r100.equals("evaluate_pop_show") == false) goto L45;
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("is_system", "0");     // Catch: JSONException -> L38
    L40:
        TrackParams r114 = new TrackParams().merge(r101);
        by7.a r115 = new by7.a("evaluate_pop_show");
        r115.f21463a.merge(r114);
        r115.b();
        return;
    L38:
        e = move-exception;
        FLogger.f375446a.e("EvaluateEventHelper", "error in EvaluateEventHelper evaluatePopShow " + e.getLocalizedMessage());
        goto L40
    L42:
        if (r100.equals("evaluate_pop_good") == false) goto L45;
        Intrinsics.checkNotNullParameter(r101, "params");
        TrackParams r116 = new TrackParams().merge(r101);
        by7.a r117 = new by7.a("evaluate_pop_good");
        r117.f21463a.merge(r116);
        r117.b();
        return;
    L13:
        if (r105.length() == 0) goto L16;
        r106 = false;
        goto L16
    L5:
        if (r104.length() == 0) goto L8;
        r107 = false;
        goto L9
    }
}
