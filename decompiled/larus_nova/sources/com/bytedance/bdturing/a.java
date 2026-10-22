package com.bytedance.bdturing;

import android.view.MotionEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f201738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f201739b;

    /* JADX INFO: renamed from: com.bytedance.bdturing.a$a, reason: collision with other inner class name */
    public interface InterfaceC2906a {
        void a(JSONObject r100);
    }

    public a() {
        this.f201738a = 0;
    }

    public final void a(MotionEvent r110, InterfaceC2906a r111) {
        if ((System.currentTimeMillis() - this.f201739b) >= 1000) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L16;
        this.f201739b = System.currentTimeMillis();
        JSONObject r101 = new JSONObject();
        float r102 = r110.getPressure();
        float r103 = r110.getTouchMajor();
        JSONArray r104 = new JSONArray();
        long r105 = this.f201739b - this.f201738a;
        r104.put(r110.getX());     // Catch: JSONException -> L10
        r104.put(r110.getY());     // Catch: JSONException -> L10
        r101.put("force", r102);     // Catch: JSONException -> L10
        r101.put("majorRadius", r103);     // Catch: JSONException -> L10
        r101.put("click_coordinate", r104);     // Catch: JSONException -> L10
        r101.put("click_duration", r105);     // Catch: JSONException -> L10
        r101.put("operate_duration", 0);     // Catch: JSONException -> L10
    L12:
        r111.a(r101);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L16:
        return;
    L5:
        r100 = false;
        goto L6
    }
}
