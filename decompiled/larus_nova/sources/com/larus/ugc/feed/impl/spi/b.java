package com.larus.ugc.feed.impl.spi;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import g0a.e;
import g0a.h;
import g0a.i;
import g0a.j;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.x2;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements e {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // g0a.e
    public final void JA(h r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        JSONObject r101 = new JSONObject();
        r101.put("current_page", r100.f479506a);     // Catch: JSONException -> L5
    L7:
        by7.a r102 = new by7.a("click_create_button");
        r102.f21463a.merge(new TrackParams().merge(r101));
        r102.b();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        g.f365738a.monitorEventForSlardar("click_create_button", r101, null, null);     // Catch: Throwable -> L10
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L20;
        FLogger.f375446a.e("CommunityCreateTrackerAndroidImpl", "slardar report failed for click_create_button: " + r105.getMessage());
        return;
    L20:
        return;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        e = move-exception;
        FLogger.f375446a.e("CommunityCreateTrackerAndroidImpl", "mobClickCreateButton json error: " + e.getMessage());
        goto L7
    }

    @Override // g0a.e
    public final void wF(j r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        x2.f(r110.f479513a, r110.f479514b, r110.f479515c, r110.f479516d, r110.f479517e, r110.f479518f, r110.f479519g, Long.valueOf(r110.f479520h));
    }

    @Override // g0a.e
    public final void zh(i r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        JSONObject r101 = new JSONObject();
        r101.putOpt("template_page_type", null);     // Catch: JSONException -> L5
        r101.put("current_page", r100.f479507a);     // Catch: JSONException -> L5
        r101.put("bot_id", null);     // Catch: JSONException -> L5
        r101.put("tab_id", r100.f479508b);     // Catch: JSONException -> L5
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r100.f479509c);     // Catch: JSONException -> L5
        r101.put("from_tab_id", r100.f479510d);     // Catch: JSONException -> L5
        r101.put("tab_type", r100.f479511e);     // Catch: JSONException -> L5
        r101.put("enter_method", r100.f479512f);     // Catch: JSONException -> L5
    L7:
        by7.a r102 = new by7.a("enter_ai_generate_tab_category_page");
        r102.f21463a.merge(new TrackParams().merge(r101));
        r102.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CommunityCreateTrackerAndroidImpl", "mobEnterTab json error: " + e.getMessage());
        goto L7
    }
}
