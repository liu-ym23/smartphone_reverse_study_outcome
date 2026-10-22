package xc7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.bridge.BridgeManager;
import com.bytedance.sdk.bridge.Logger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f563228c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f563229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f563230b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f563231a = null;

        static {
            f563231a = new h();
        }
    }

    static {
    }

    public h() {
    }

    public static void a(h r100, String r101, String r102) throws JSONException {
        r100.getClass();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        Logger.f269563c.getClass();
        Logger.b();
        return;
    L5:
        JSONObject r103 = new JSONObject(r101);
        r103.optString("message");
        if (r103.optInt("status") == 0) goto L8;
        Logger.f269563c.getClass();
        Logger.b();
        return;
    L8:
        JSONObject r104 = r103.optJSONObject("data");
        if (r104 != null) goto L11;
        Logger.f269563c.getClass();
        Logger.b();
        return;
    L11:
        JSONObject r105 = r104.optJSONObject("packages");
        if (r105 != null) goto L14;
        Logger.f269563c.getClass();
        Logger.b();
        return;
    L14:
        String r106 = r105.optString(r102);
        com.bytedance.sdk.bridge.auth.privilege.d r107 = com.bytedance.sdk.bridge.auth.privilege.d.a.f269571a;
        r107.getClass();
        Context r108 = BridgeManager.INSTANCE.getBridgeConfig().getApplication();
        if (r108 == null) goto L19;
        ThreadMethodProxy.start(new PthreadThreadV2(new com.bytedance.sdk.bridge.auth.privilege.c(r108, r106), "JsBridgeAuthManager"));
        r107.c(r106);
        return;
    L19:
        throw new RuntimeException("BridgeSDK can not get application context");
    }
}
