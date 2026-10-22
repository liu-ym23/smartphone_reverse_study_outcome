package com.bytedance.ug.sdk.luckycat.impl.browser.bridge;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.utils.a;
import com.ss.android.cert.manager.constants.EventConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class LuckyCatStepBridge implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f271111a;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        if (this.f271111a == false) goto L6;
        this.f271111a = false;
        m.a.f271349a.o();
        return;
    }

    public LuckyCatStepBridge() {
        this.f271111a = false;
    }

    public static boolean a(Context r100) {
        if (r100 != null) goto L4;
    L13:
        return true;
    L4:
        if (r100.getApplicationInfo() == null) goto L13;
        if (Build.BRAND.toLowerCase().equals(DimLocationCheckUtil.XIAOMI) == false) goto L10;
        m r101 = m.a.f271349a;
        a.c("LuckyCatConfigManager", "isPedometerSupportXiaomi:true");
    L12:
        return false;
    L10:
        if (r100.getApplicationInfo().targetSdkVersion < 29) goto L12;
        goto L12
    }

    @BridgeMethod("luckycatIsStepCountSupport")
    public void isSupportPedometer(@BridgeContext IBridgeContext r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        m r101 = m.a.f271349a;
        if (r101.k(r100.getActivity(), "android.permission.ACTIVITY_RECOGNITION") == false) goto L7;
    L10:
        r101.o();
        b(r100, -16, true, "pedometer not init");
        return;
    L7:
        if (a(r100.getActivity()) == false) goto L10;
        b(r100, -6, false, "no activity recognition permission");
    }

    @BridgeMethod("luckycatRegisterStepListener")
    public void registerPedometerListener(@BridgeContext IBridgeContext r100) {
        this.f271111a = true;
        m r101 = m.a.f271349a;
        r101.o();
        JSONObject r102 = new JSONObject();
        r101.o();     // Catch: JSONException -> L5
        r102.put("count", -1);     // Catch: JSONException -> L5
    L7:
        m r103 = m.a.f271349a;
        if (r103.f271344l == false) goto L10;
        Activity r104 = r100.getActivity();
        r103.o();
        Toast.makeText(r104, "not support pedometer", 0).show();
    L10:
        r103.o();
        r100.callback(hj7.a.a(0, r102, "success"));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @BridgeMethod("luckycatTryInitPedometerSDK")
    public void tryInitPedometerSDK(@BridgeContext IBridgeContext r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        m r101 = m.a.f271349a;
        if (r101.k(r100.getActivity(), "android.permission.ACTIVITY_RECOGNITION") == false) goto L7;
    L10:
        r101.o();
        r101.o();
        return;
    L7:
        if (a(r100.getActivity()) == false) goto L10;
        b(r100, -6, false, "no activity recognition permission");
    }

    @BridgeMethod("luckycatUnregisterStepListener")
    public void unRegisterPedometerListener(@BridgeContext IBridgeContext r100) {
        m r101 = m.a.f271349a;
        r101.o();
        r101.o();
        r100.callback(hj7.a.a(0, null, "failed"));
    }

    public static void b(IBridgeContext r100, int r101, boolean r102, String r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r104 = new JSONObject();
        r104.put("detail_status", r103);     // Catch: JSONException -> L7
        r104.put("is_support", false);     // Catch: JSONException -> L7
        r104.put("is_init", false);     // Catch: JSONException -> L7
        r104.put(EventConstant.Value.HAS_PERMISSION, r102);     // Catch: JSONException -> L7
    L9:
        r100.callback(hj7.a.a(r101, r104, "failed"));
        return;
    L7:
        e = move-exception;
        e.toString();
        goto L9
    }
}
