package com.larus.bmhome.taskskill;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f314331a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter(r100, "toStatus");
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("current_page", "chat");
        r102.put("to_status", r100);
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("local_computer_use_entrance_click", r102);
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("current_page", "chat");
        r102.put("setting_item", "operation_permission");
        r102.put("click_from", r100);
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("super_task_setting_confirm", r102);
    }
}
