package com.bytedance.praisedialoglib.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y57.d f266635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y57.a f266636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y57.e f266637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y57.c f266638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y57.b f266639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f266640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f266641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f266642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f266643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public x57.b f266644j;

    /* JADX INFO: renamed from: com.bytedance.praisedialoglib.manager.a$a, reason: collision with other inner class name */
    public static class C3729a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f266645a = null;

        static {
            f266645a = new a();
        }
    }

    public final ArrayList<String> a() {
        if (TextUtils.isEmpty(this.f266642h) == false) goto L5;
        return null;
    L5:
        String[] r100 = this.f266642h.split("\\|");
        if (r100.length > 0) goto L8;
        return null;
    L8:
        ArrayList<String> r101 = new ArrayList();
        Collections.addAll(r101, r100);
        if (r101.isEmpty() == true) goto L11;
        return r101;
    L11:
        return null;
    }

    public final ArrayList<String> b() {
        if (TextUtils.isEmpty(this.f266643i) == false) goto L5;
        return null;
    L5:
        String[] r100 = this.f266643i.split("\\|");
        if (r100.length > 0) goto L8;
        return null;
    L8:
        ArrayList<String> r101 = new ArrayList();
        Collections.addAll(r101, r100);
        if (r101.isEmpty() == true) goto L11;
        return r101;
    L11:
        return null;
    }

    public final String c() {
        y57.a r100 = this.f266636b;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getPackageName();
    }

    public final Activity d() {
        y57.a r100 = this.f266636b;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getTopActivity();
    }

    public final boolean e() {
        y57.c r100 = this.f266638d;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        return false;
    }

    public a() {
        this.f266640f = "";
        this.f266642h = "";
        this.f266643i = "";
    }

    public final void f(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.toString();
        this.f266640f = r100.optString("app_market_order", "");
        boolean r101 = false;
        if (r100.optInt("market_feedback_dialog_enable", 0) <= 0) goto L7;
        r101 = true;
    L7:
        this.f266641g = r101;
        r100.optString("market_feedback_url", "");
        this.f266642h = r100.optString("guide_style_1_market_list", "");
        this.f266643i = r100.optString("guide_style_2_market_list", "");
        r100.optString("guide_style_3_market_list", "");
    }

    public void startActivity(Context r100, Intent r101) {
        y57.e r102 = this.f266637c;
        if (r102 == null) goto L5;
        r102.startActivity(r100, r101);
        return;
    L5:
        r100.startActivity(r101);
    }

    public void startActivityForResult(Activity r100, Intent r101) {
        y57.e r102 = this.f266637c;
        if (r102 == null) goto L5;
        r102.startActivityForResult(r100, r101, 100);
        return;
    L5:
        r100.startActivityForResult(r101, 100);
    }
}
