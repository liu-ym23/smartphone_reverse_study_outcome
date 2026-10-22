package ua7;

import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.impl.c0;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.util.Map;
import org.json.JSONObject;
import ua7.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T extends b> extends com.bytedance.sdk.account.impl.a {
    private boolean cancel;

    public void cancel() {
        this.cancel = true;
        cancelApi();
    }

    public abstract void onResponse(T r100);

    public Map<String, String> onSendBDAccountEvent(T r100) {
        return null;
    }

    public JSONObject onSendEvent(String r100) {
        return null;
    }

    private void updateMonitorTime() {
        wa7.a r100 = this.mJobController;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof c0) == false) goto L20;
        long r101 = System.currentTimeMillis();
        com.bytedance.sdk.account.impl.b r102 = ((c0) r100).f268957f;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.f268940a == false) goto L22;
        r102.f268946g = r101;
        String r103 = UriProtector.parse(r102.f268941b.f508352a).getPath().toLowerCase();     // Catch: Throwable -> L14
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L14
        r104.put("path", r103);     // Catch: Throwable -> L14
        r104.put(CronetDataStorageAccess.LOGID, r102.f268942c.f508370f);     // Catch: Throwable -> L14
        r104.put("error_code", r102.f268942c.f508366b);     // Catch: Throwable -> L14
        r104.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r102.f268942c.f508367c);     // Catch: Throwable -> L14
        r104.put("trigger_error_handler", r102.f268947h);     // Catch: Throwable -> L14
        r104.put("trigger_bdturing", false);     // Catch: Throwable -> L14
        r104.put("trigger_retry", r102.f268948i);     // Catch: Throwable -> L14
        r104.put("duration_total", r102.f268946g - r102.f268943d);     // Catch: Throwable -> L14
        r104.put("duration_callin_beforesend", r102.f268944e - r102.f268943d);     // Catch: Throwable -> L14
        r104.put("duration_send_request", r102.f268945f - r102.f268944e);     // Catch: Throwable -> L14
        r104.put("duration_aftersend_callout", r102.f268946g - r102.f268945f);     // Catch: Throwable -> L14
        com.bytedance.sdk.account.monitor.a.a("passport_net_request_monitor", r104);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Logger.e("AccountApiMonitor", "sendEvent", th);
        return;
    L22:
        return;
    }

    public a() {
    }

    public boolean isCancel() {
        return this.cancel;
    }

    public final void dispatchOnResponse(T r100) {
        if (isCancel() == true) goto L6;
        updateMonitorTime();
        onResponse(r100);
        return;
    }
}
