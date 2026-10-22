package com.larus.bmhome.chat.auth;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public class a {
    public a() {
    }

    public static void f(a r100, String r101, JSONObject r102) {
        r100.getClass();
        by7.a r103 = new by7.a(r101);
        TrackParams r104 = new TrackParams().merge(r102);
        r103.f21463a.merge(r104);
        r103.b();
    }

    public final void d(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "previousPage");
        Intrinsics.checkNotNullParameter(r103, "botId");
        JSONObject r104 = new JSONObject();
        r104.put("current_page", r100);
        r104.put("previous_page", r101);
        r104.put("enter_from", r101);
        r104.put("bot_id", r103);
        r104.put("conversation_id", r102);
        r104.put("page", r100);
        f(this, CheckPointType.ENTER_PAGE, r104);
    }

    public final void e(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "previousPage");
        Intrinsics.checkNotNullParameter(r102, "pluginName");
        Intrinsics.checkNotNullParameter(r103, "pluginId");
        Intrinsics.checkNotNullParameter(r106, "botId");
        Intrinsics.checkNotNullParameter(r110, "authStatus");
        JSONObject r107 = new JSONObject();
        r107.put("current_page", r100);
        r107.put("previous_page", r101);
        r107.put("plugin_name", r102);
        r107.put("plugin_id", r103);
        if (r104 == null) goto L5;
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r104);
    L5:
        if (r105 == null) goto L7;
        r107.put("conversation_id", r105);
    L7:
        r107.put("bot_id", r106);
        r107.put(LocationMonitorConst.AUTH_STATUS, r110);
        f(this, "show_plugin_auth", r107);
    }

    public final void c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "previousPage");
        Intrinsics.checkNotNullParameter(r102, "pluginName");
        Intrinsics.checkNotNullParameter(r103, "pluginId");
        Intrinsics.checkNotNullParameter(r106, "botId");
        Intrinsics.checkNotNullParameter(r110, "authStatus");
        Intrinsics.checkNotNullParameter(r111, "clickChoice");
        JSONObject r107 = new JSONObject();
        r107.put("current_page", r100);
        r107.put("previous_page", r101);
        r107.put("plugin_name", r102);
        r107.put("plugin_id", r103);
        if (r104 == null) goto L5;
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r104);
    L5:
        if (r105 == null) goto L7;
        r107.put("conversation_id", r105);
    L7:
        r107.put("bot_id", r106);
        r107.put(LocationMonitorConst.AUTH_STATUS, r110);
        r107.put("click_choice", r111);
        f(this, "click_plugin_auth", r107);
    }
}
