package com.larus.suggest.impl.popup;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f369905a = 0;

    static {
    }

    public v() {
    }

    public static /* synthetic */ void b(String r100, String r101) {
        a("candidate_unavailable", 5, r100, r101, null, null, null);
    }

    public static void a(String r100, int r101, String r102, String r103, Boolean r104, Boolean r105, Boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        JSONObject r107 = new JSONObject();
        r107.put("error_code", r101);
        r107.put("error_msg", r100);
        r107.put("event_type", "biz_intercept_dialog");
        r107.put("activity_id", r102);
        r107.put("group_id", r103);
        r107.put("is_minor_checked", r104);
        r107.put("is_minor_showed", r105);
        r107.put("is_commerce_shown", r106);
        com.larus.platform.service.o.f365780a.reportEvent("dev_nex_pulse_dialog_monitor", r107);
    }
}
