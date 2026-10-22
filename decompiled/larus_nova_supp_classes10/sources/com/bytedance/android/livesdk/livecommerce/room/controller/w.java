package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w {
    public static final /* synthetic */ int h = 0;
    public Map<String, String> a;
    public Map<String, String> b;
    public JSONObject c;
    public String d;
    public String e;
    public String f;
    public boolean g;

    public static final class a {
        public static String b() {
            return ControllerCenter.b(null).a();
        }

        public static JSONObject a(RoomContextController r4) {
            w r5 = ControllerCenter.b(r4);
            JSONObject r0 = r5.c;
            if (r0 != null) goto L28;
            Map<String, String> r1 = r5.a;
            if (r1 == null) goto L26;
            String r2 = r1.get("multi_room_data");
            if (r2 == null) goto L11;
            JSONObject r3 = z1.g(r2);
            if (r3 == null) goto L11;
        L12:
            String r6 = r1.get("task_enter_from");
            if (r6 == null) goto L15;
            r3.put("task_enter_from", r6);
        L15:
            String r7 = r1.get("task_type");
            if (r7 == null) goto L18;
            r3.put("task_type", r7);
        L18:
            String r8 = r1.get("task_request_params");
            if (r8 == null) goto L21;
            r3.put("task_request_params", r8);
        L21:
            String r9 = r1.get("extra_params");
            if (r9 == null) goto L24;
            r3.put("extra_params", r9);
        L24:
            r5.c = r3;
            return r3;
        L11:
            r3 = new JSONObject();
            goto L12
        L26:
            return new JSONObject();
        L28:
            return r0;
        }

        public static String c(Map r9) {
            if (r9 == null) goto L7;
            String r10 = (String) r9.get("multi_room_data");
            if (r10 == null) goto L7;
            JSONObject r11 = z1.g(r10);
            if (r11 == null) goto L7;
        L8:
            ArrayList r0 = new ArrayList();
            Iterator r12 = StringsKt.split$default(r11.optString("ecom_scene_id"), new String[]{","}, false, 0, 6, null).iterator();
        L10:
            if (r12.hasNext() == false) goto L19;
            String r1 = (String) r12.next();
            if (r1.length() <= 0) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == false) goto L10;
            if (((HashSet) ExtraController.l.getValue()).contains(r1) == false) goto L10;
            r0.add(r1);
            goto L10
        L14:
            r2 = false;
            goto L15
        L19:
            r0.add("1001");
            return CollectionsKt.joinToString$default(r0, ",", null, null, 0, null, null, 62, null);
        L7:
            r11 = new JSONObject();
            goto L8
        }
    }

    static {
    }

    public w() {
    }

    public final String a() {
        int r0 = RoomContextController.h;
        if (RoomContextController.a.a().x() == true) goto L6;
        return "1001";
    L6:
        String r1 = this.d;
        if (r1 == null) goto L9;
        return r1;
    L9:
        String r2 = a.c(this.b);
        this.d = r2;
        return r2;
    }
}
