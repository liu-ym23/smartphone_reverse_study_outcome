package yg1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.monitor.cloudmessage.consts.CloudControlInf;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements IHostPlugin.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f567479a;

    public d(c r100) {
        this.f567479a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onCancel(String r100) {
        ALogger.d("LoadLiveSourceTask", "install camera cancel");
        this.f567479a.getClass();
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L5
        r101.put(CloudControlInf.PLUGIN, "camera");     // Catch: Throwable -> L5
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_download_camera_plugin_fail", 0, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onSuccess(String r100) {
        ALogger.d("LoadLiveSourceTask", "install camera success");
        this.f567479a.getClass();
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L5
        r101.put(CloudControlInf.PLUGIN, "camera");     // Catch: Throwable -> L5
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_download_camera_plugin_success", 1, r101);     // Catch: Throwable -> L5
    L7:
        this.f567479a.getClass();
        c.a();
        this.f567479a.getClass();
        c.b();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }
}
