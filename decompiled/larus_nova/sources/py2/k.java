package py2;

import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class k extends ny2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f531012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f531013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f531014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f531015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f531016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f531017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f531018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f531019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f531020i;

    public k() {
        this.f531012a = null;
        this.f531013b = bz2.g.a();
        this.f531014c = null;
        this.f531015d = null;
        this.f531016e = 0;
    }

    @Override // ny2.a
    public void b(JSONObject r100) {
        bz2.e.i(r100, "navigation_id", this.f531013b);
        bz2.e.i(r100, "url", this.f531012a);
        bz2.e.i(r100, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, this.f531014c);
        bz2.e.g(r100, "click_start", this.f531016e);
        bz2.e.i(r100, "sdk_version", "1.2.2-rc.3.1-bugfix");
        bz2.e.i(r100, "virtual_aid", this.f531017f);
        bz2.e.h(r100, PerfLog.PARAM_KEY_CONTEXT_ID, this.f531018g);
        bz2.e.h(r100, "debug_context", new JSONObject());
        long r101 = this.f531019h;
        if (r101 == 0) goto L5;
        bz2.e.g(r100, "container_init_ts", r101);
    L5:
        Boolean r102 = this.f531020i;
        if (r102 == null) goto L9;
        bz2.e.h(r100, "container_reuse", r102);
        return;
    }
}
