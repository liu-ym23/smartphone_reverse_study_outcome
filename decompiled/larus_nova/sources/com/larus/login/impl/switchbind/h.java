package com.larus.login.impl.switchbind;

import com.ixigua.lib.track.TrackParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f358249a = 0;

    static {
    }

    public h() {
    }

    public static void a(String r100, SwitchBindFragment r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("current_page", "douyin_account_rebind");     // Catch: JSONException -> L5
        r102.put("button_name", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        if (r101 == null) goto L10;
        r104.f21464b = r101;
    L10:
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("SwitchBindMobUtil", "[onClickButton] " + e);
        goto L7
    }
}
