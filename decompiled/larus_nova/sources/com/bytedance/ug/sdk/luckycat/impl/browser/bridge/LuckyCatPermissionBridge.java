package com.bytedance.ug.sdk.luckycat.impl.browser.bridge;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import pi7.d;

/* JADX INFO: loaded from: classes22.dex */
public class LuckyCatPermissionBridge implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String[]> f271109a = null;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f271110a;

        public a(IBridgeContext r100) {
            this.f271110a = r100;
        }
    }

    public LuckyCatPermissionBridge() {
    }

    static {
        HashMap r100 = new HashMap();
        f271109a = r100;
        r100.put("camera", new String[]{"android.permission.CAMERA"});
        r100.put("calendar", new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"});
        r100.put("location", new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        r100.put("activity_recognition", new String[]{"android.permission.ACTIVITY_RECOGNITION"});
    }

    @BridgeMethod("luckycatApplyPermission")
    public void applyPermission(@BridgeContext IBridgeContext r100, @BridgeParam("permission") String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        r100.callback(hj7.a.a(0, null, "permission is null"));
        return;
    L8:
        HashMap r102 = (HashMap) f271109a;
        if (r102.containsKey(r101) == false) goto L11;
        String[] r103 = (String[]) r102.get(r101);
    L12:
        m r104 = m.a.f271349a;
        if (r104.l(r100.getActivity(), r103) == false) goto L21;
        JSONObject r105 = new JSONObject();
        r105.put("status", "permitted");     // Catch: JSONException -> L17
    L19:
        r100.callback(hj7.a.a(1, r105, ""));
        return;
    L17:
        e = move-exception;
        e.toString();
        goto L19
    L21:
        r104.requestPermissions(r100.getActivity(), r103, new a(r100));
        return;
    L11:
        r103 = new String[]{r101};
        goto L12
    }

    @BridgeMethod("luckycatCheckPermission")
    public void checkPermission(@BridgeContext IBridgeContext r100, @BridgeParam("permission") String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        r100.callback(hj7.a.a(0, null, "permission is null"));
        return;
    L8:
        Map<String, String[]> r102 = f271109a;
        if (((HashMap) r102).containsKey(r101) == false) goto L11;
        String[] r103 = (String[]) ((HashMap) r102).get(r101);
    L12:
        boolean r104 = m.a.f271349a.l(r100.getActivity(), r103);
        JSONObject r105 = new JSONObject();
        if (r104 == false) goto L16;
        String r106 = "permitted";
    L23:
        r105.put("status", r106);     // Catch: JSONException -> L19
    L21:
        r100.callback(hj7.a.a(1, r105, ""));
        return;
    L19:
        e = move-exception;
        e.toString();
        goto L21
    L16:
        r106 = "denied";
        goto L23
    L11:
        r103 = new String[]{r101};
        goto L12
    }
}
