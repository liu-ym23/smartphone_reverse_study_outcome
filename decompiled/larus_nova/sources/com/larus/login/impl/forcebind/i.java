package com.larus.login.impl.forcebind;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f357709a = 0;

    static {
    }

    public i() {
    }

    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("current_page", "chat");
        r101.put("source", "new_reg_required_bind_douyin_tel");
        r101.put("click_option", r100);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("bind_douyin_popup_click");
        r103.f21463a.merge(r102);
        r103.b();
    }
}
