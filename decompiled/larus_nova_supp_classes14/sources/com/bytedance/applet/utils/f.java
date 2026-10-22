package com.bytedance.applet.utils;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements d {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function3<Integer, String, String, Boolean> c;
    public final /* synthetic */ e d;

    @Override // com.bytedance.applet.utils.d
    public final void a(boolean r30, boolean r31, boolean r32) {
        if (r30 == false) goto L5;
        String r4 = "Location has succeeded.";
    L10:
        FLogger.a.i("LocationUiAppActionInterceptor", "location uiu result success=" + r30 + " permissionDenied=" + r31 + " isPermissionServiceDisabled=" + r32 + " msgId=" + this.a + " questionId=" + this.b);
        boolean r5 = false;
        if (r30 == false) goto L13;
        int r1 = 0;
    L18:
        Function3<Integer, String, String, Boolean> r2 = this.c;
        e r6 = this.d;
        JSONObject r7 = new JSONObject();
        JSONArray r8 = new JSONArray();
        JSONObject r9 = new JSONObject();
        r9.put("type", "text");
        r9.put("text", r4);
        Unit r10 = Unit.INSTANCE;
        r7.put("content", r8.put(r9));
        if (r1 == 0) goto L21;
        r5 = true;
    L21:
        r7.put("isError", r5);
        JSONObject r11 = new JSONObject();
        r11.put("errorCode", r1);
        r11.put("errorMsg", r4);
        r7.put("structuredContent", r11);
        String r12 = r7.toString();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r12, "jsonString");
        r2.invoke(0, "", StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r12, "\\", "\\\\", false, 4, null), "\"", "\\\"", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null), "\t", "\\t", false, 4, null));
        return;
    L13:
        if (r31 == false) goto L15;
        r1 = 50002;
        goto L18
    L15:
        if (r32 == false) goto L17;
        r1 = 50003;
        goto L18
    L17:
        r1 = 50001;
        goto L18
    L5:
        if (r31 == false) goto L7;
        r4 = "Location failed for lack of application permission.";
        goto L10
    L7:
        if (r32 == false) goto L9;
        r4 = "Location failed because location service is disabled.";
        goto L10
    L9:
        r4 = "Location failed to get result.";
        goto L10
    }

    public f(String r1, String r2, com.bytedance.applet.event.a r3, e r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
