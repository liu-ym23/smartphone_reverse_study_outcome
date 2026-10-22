package com.larus.connector;

import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f330230a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("current_page", "chat");
        r103.put("enter_method", "chat_action_bar");
        r103.put("click_from", "action");
        r103.put("connector_id", r100);
        r103.put("connector_action", r101);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("connector_click", r103);
    }

    public static void b(String r100, String r101, String r102) {
        com.larus.platform.service.o r103 = com.larus.platform.service.o.f365780a;
        JSONObject r104 = new JSONObject();
        r104.put("current_page", "chat");
        r104.put("enter_method", "chat_action_bar");
        r104.put("connector_id", r100);
        r104.put("connector_name", r101);
        r104.put("connector_status", r102);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("connector_show", r104);
    }
}
