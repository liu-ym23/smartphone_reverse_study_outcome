package com.bytedance.ug.sdk.luckycat.impl.browser.bridge;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import hj7.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class LuckyCatLoginBridge implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBridgeContext f271108a;

    public LuckyCatLoginBridge() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        JSONObject r100 = new JSONObject();
        String r101 = "cancel";
        if (m.a.f271349a.r() == false) goto L7;
        int r102 = 1;
        r101 = "success";
        int r103 = 1;
    L22:
        r100.put("status", r102);     // Catch: JSONException -> L10
    L15:
        IBridgeContext r104 = this.f271108a;
        if (r104 == null) goto L18;
        r104.callback(a.a(r103, r100, r101));
    L18:
        this.f271108a = null;
        return;
    L10:
        JSONException e100 = e;
    L14:
        e100.printStackTrace();
        goto L15
    L7:
        r102 = 2;
        r103 = 0;
    L12:
        e = move-exception;
        r103 = 0;
        e100 = e;
        goto L14
    }

    @BridgeMethod("luckycatIsLogin")
    public void isLogin(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();
    L9:
        e = move-exception;
        r100.callback(a.a(0, r101, e.toString()));
        return;
    L4:
        if (m.a.f271349a.r() == false) goto L6;
        int r102 = 1;
    L7:
        r101.put("is_login", r102);     // Catch: JSONException -> L9
        r100.callback(a.a(1, r101, "success"));     // Catch: JSONException -> L9
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @BridgeMethod("is_login")
    public void isLoginOld(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();
    L9:
        e = move-exception;
        r100.callback(a.a(0, r101, e.toString()));
        return;
    L4:
        if (m.a.f271349a.r() == false) goto L6;
        int r102 = 1;
    L7:
        r101.put("is_login", r102);     // Catch: JSONException -> L9
        r100.callback(a.a(1, r101, "success"));     // Catch: JSONException -> L9
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @BridgeMethod("luckycatLogin")
    public void login(@BridgeContext IBridgeContext r100, @BridgeParam("platform") String r101, @BridgeParam("enter_from") String r102) {
        Activity r103 = r100.getActivity();
        if (r103 != null) goto L6;
        r100.callback(a.a(0, null, "context null"));
        return;
    L6:
        this.f271108a = r100;
        m.a.f271349a.u(r103, r101, r102);
    }

    @BridgeMethod("login")
    public void loginOld(@BridgeContext IBridgeContext r100, @BridgeParam("platform") String r101, @BridgeParam("enter_from") String r102) {
        Activity r103 = r100.getActivity();
        if (r103 != null) goto L6;
        r100.callback(a.a(0, null, "context null"));
        return;
    L6:
        this.f271108a = r100;
        m.a.f271349a.u(r103, r101, r102);
    }
}
