package com.ss.android.ugc.route_monitor.impl.route_out.control;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.android.ugc.route_monitor.utils.Logger;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454656a = 0;

    static {
    }

    public static void a(ControlRule r100, String r101, int r102) {
        Logger r103 = Logger.f454747c;
        r100.getRuleId();
        r103.b();
        c(r100, r101, Integer.valueOf(r102));
    }

    public static void c(ControlRule r100, String r101, Integer r102) {
        ihc.f r103 = com.ss.android.ugc.route_monitor.c.a();
        JSONObject r104 = new JSONObject();
        r104.put("cert_id", r100.getCertId());
        r104.put("rule_id", r100.getRuleId());
        r104.put("key", r101);
        if (r102 == null) goto L5;
        r104.put(WikiFolderPushPlugin.OPT, r102.intValue());
    L5:
        r103.i();
    }

    public static void b(ControlRule r100, String r101, int r102, Object r103) {
        Logger r104 = Logger.f454747c;
        r100.getRuleId();
        Objects.toString(r103);
        r104.b();
        c(r100, r101, Integer.valueOf(r102));
    }
}
