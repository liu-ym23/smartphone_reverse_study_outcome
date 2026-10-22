package f7;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.annie.bridge.method.audio.a f475741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f475742b;

    public a(com.bytedance.android.annie.bridge.method.audio.a r100, int r101) {
        this.f475741a = r100;
        this.f475742b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSBridgeManager r100 = this.f475741a.f38545a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.sendJSEvent("networkStatusChange", new JSONObject().put(GearStrategyConsts.EV_QUALITY, this.f475742b));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
