package d36;

import com.bytedance.ies.bullet.service.base.c1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f466734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f466735b;

    public d() {
        c1 r100 = new c1("bdx_monitor_cpu", null, null, null, null, 254);
        r100.f247794d = new JSONObject();
        r100.f247795e = new JSONObject();
        this.f466734a = r100;
        c1 r101 = new c1("bdx_monitor_memory", null, null, null, null, 254);
        r101.f247794d = new JSONObject();
        r101.f247795e = new JSONObject();
        this.f466735b = r101;
    }
}
