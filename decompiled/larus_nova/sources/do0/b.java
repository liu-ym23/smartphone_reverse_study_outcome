package do0;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469400a = 0;

    static {
    }

    public static void a(int r100, Object r101) {
        HashMap r102 = new HashMap();
        r102.put("code", String.valueOf(r100));
        r102.put("data", String.valueOf(r101));
        LiveSlardarMonitor.monitorStatus("ttlive_service_ds_limit", 0, r102);
    }
}
