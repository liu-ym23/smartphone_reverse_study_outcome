package com.bytedance.bdturing.livedetect.pty;

import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static c a(JSONObject r110, ArrayList<Float> r111) {
        c r100 = new c();
        r100.f201927e = r110.optInt("status", -1);
        r100.f201928f = r110.optString("log", "");
        r100.f201925c = r111;
        JSONArray r112 = r110.optJSONArray("face_info");
        if (r112 != null) goto L5;
    L54:
        return r100;
    L5:
        if (r112.length() <= 0) goto L54;
        int r101 = 0;
    L8:
        if (r101 >= r112.length()) goto L54;
        JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r112, r101);     // Catch: Exception -> L51
        RectF r103 = null;
        if (r102.has("kps") == false) goto L27;
        JSONArray r104 = JSONObjectProtectorUtils.getJSONArray(r102, "kps");     // Catch: Exception -> L51
        if (r104 != null) goto L14;
    L23:
        ArrayList r105 = null;
    L24:
        if (r105 == null) goto L27;
        ((ArrayList) r100.f201923a).add(r105);     // Catch: Exception -> L51
        goto L27
    L14:
        if (r104.length() <= 0) goto L23;
        r105 = new ArrayList();     // Catch: Exception -> L51
        PointF r106 = null;
        int r107 = 0;
    L17:
        if (r107 >= r104.length()) goto L24;
        double r113 = r104.optDouble(r107);     // Catch: Exception -> L51
        if ((r107 % 2) != 0) goto L21;
        r106 = new PointF();     // Catch: Exception -> L51
        r106.x = (float) r113;     // Catch: Exception -> L51
    L22:
        r107 = r107 + 1;     // Catch: Exception -> L51
        goto L17
    L21:
        r106.y = (float) r113;     // Catch: Exception -> L51
        r105.add(r106);     // Catch: Exception -> L51
    L27:
        if (r102.has("box") == false) goto L53;
        JSONArray r108 = JSONObjectProtectorUtils.getJSONArray(r102, "box");     // Catch: Exception -> L51
        if (r108 != null) goto L31;
    L48:
        if (r103 == null) goto L53;
        ((ArrayList) r100.f201924b).add(r103);     // Catch: Exception -> L51
        goto L53
    L31:
        if (r108.length() != 4) goto L48;
        int r109 = 0;
    L34:
        if (r109 >= r108.length()) goto L48;
        double r114 = r108.optDouble(r109);     // Catch: Exception -> L51
        int r115 = r109 % 4;     // Catch: Exception -> L51
        if (r115 != 0) goto L39;
        r103 = new RectF();     // Catch: Exception -> L51
        r103.left = (float) r114;     // Catch: Exception -> L51
    L47:
        r109 = r109 + 1;     // Catch: Exception -> L51
        goto L34
    L39:
        if (r115 != 1) goto L42;
        r103.top = (float) r114;     // Catch: Exception -> L51
        goto L47
    L42:
        if (r115 != 2) goto L45;
        r103.right = (float) r114;     // Catch: Exception -> L51
        goto L47
    L45:
        if (r115 != 3) goto L47;
        r103.bottom = (float) r114;     // Catch: Exception -> L51
    L53:
        r101 = r101 + 1;
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    }
}
