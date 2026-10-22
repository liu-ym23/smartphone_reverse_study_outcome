package com.bytedance.bdturing.livedetect.pty;

import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static c a(JSONObject r13, ArrayList<Float> r14) {
        c r2 = new c();
        r2.e = r13.optInt("status", -1);
        r2.f = r13.optString("log", "");
        r2.c = r14;
        JSONArray r15 = r13.optJSONArray("face_info");
        if (r15 != null) goto L5;
    L54:
        return r2;
    L5:
        if (r15.length() <= 0) goto L54;
        int r3 = 0;
    L8:
        if (r3 >= r15.length()) goto L54;
        JSONObject r4 = JSONArrayProtectorUtils.getJSONObject(r15, r3);     // Catch: Exception -> L51
        RectF r6 = null;
        if (r4.has("kps") == false) goto L27;
        JSONArray r5 = JSONObjectProtectorUtils.getJSONArray(r4, "kps");     // Catch: Exception -> L51
        if (r5 != null) goto L14;
    L23:
        ArrayList r7 = null;
    L24:
        if (r7 == null) goto L27;
        ((ArrayList) r2.a).add(r7);     // Catch: Exception -> L51
        goto L27
    L14:
        if (r5.length() <= 0) goto L23;
        r7 = new ArrayList();     // Catch: Exception -> L51
        PointF r9 = null;
        int r8 = 0;
    L17:
        if (r8 >= r5.length()) goto L24;
        double r10 = r5.optDouble(r8);     // Catch: Exception -> L51
        if ((r8 % 2) != 0) goto L21;
        r9 = new PointF();     // Catch: Exception -> L51
        r9.x = (float) r10;     // Catch: Exception -> L51
    L22:
        r8 = r8 + 1;     // Catch: Exception -> L51
        goto L17
    L21:
        r9.y = (float) r10;     // Catch: Exception -> L51
        r7.add(r9);     // Catch: Exception -> L51
    L27:
        if (r4.has("box") == false) goto L53;
        JSONArray r11 = JSONObjectProtectorUtils.getJSONArray(r4, "box");     // Catch: Exception -> L51
        if (r11 != null) goto L31;
    L48:
        if (r6 == null) goto L53;
        ((ArrayList) r2.b).add(r6);     // Catch: Exception -> L51
        goto L53
    L31:
        if (r11.length() != 4) goto L48;
        int r12 = 0;
    L34:
        if (r12 >= r11.length()) goto L48;
        double r16 = r11.optDouble(r12);     // Catch: Exception -> L51
        int r17 = r12 % 4;     // Catch: Exception -> L51
        if (r17 != 0) goto L39;
        r6 = new RectF();     // Catch: Exception -> L51
        r6.left = (float) r16;     // Catch: Exception -> L51
    L47:
        r12 = r12 + 1;     // Catch: Exception -> L51
        goto L34
    L39:
        if (r17 != 1) goto L42;
        r6.top = (float) r16;     // Catch: Exception -> L51
        goto L47
    L42:
        if (r17 != 2) goto L45;
        r6.right = (float) r16;     // Catch: Exception -> L51
        goto L47
    L45:
        if (r17 != 3) goto L47;
        r6.bottom = (float) r16;     // Catch: Exception -> L51
    L53:
        r3 = r3 + 1;
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    }
}
