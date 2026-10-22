package p47;

import com.bytedance.pia.core.metrics.MetricsType;
import com.bytedance.pia.core.utils.ThreadUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f527683a;

    public /* synthetic */ a(h r100) {
        this.f527683a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h r100 = this.f527683a;
        if (r100.f527706d == true) goto L7;
        r100.f527706d = true;
        Map<String, Object> r101 = r100.f527707e;
        HashMap r102 = (HashMap) r101;
        r102.put("url", r100.f527704b);
        ((HashMap) r100.f527707e).put("pia_sdk_version", "2.0.0");
        ThreadUtil.d(new e(r100, MetricsType.PV, r100.f527707e));
        return;
    }
}
