package q67;

import android.content.Intent;
import com.bytedance.common.push.BaseJson;
import com.bytedance.push.PushSupporter;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y77.b f531806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f531807b;

    public abstract String b();

    public void e() {
        com.bytedance.push.utils.f.b("AbsSignalReporterAdapter", "[onReceiveSignal]unregister");
    }

    public a() {
    }

    public void c(Intent r100) {
        com.bytedance.push.utils.f.b("AbsSignalReporterAdapter", "[onReceiveSignal]intent:" + r100);
    }

    public void d(String r100, y77.b r101) {
        com.bytedance.push.utils.f.b("AbsSignalReporterAdapter", "[startSignalReport]signalName:" + b() + " triggerScene:" + r100 + " signalReportConfig:" + r101);
        this.f531806a = r101;
        this.f531807b = r100;
        JSONObject r102 = new JSONObject();
        add(r102, "signal_name", b());
        PushSupporter.get().getMultiProcessMonitor().monitorEvent("push_monitor_signal_trigger", r102, null, null);
    }
}
