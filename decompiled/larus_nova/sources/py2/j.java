package py2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j extends ny2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f531007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f531008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f531009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f531010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f531011f;

    public j() {
        super("jsbPerf");
    }

    public final String toString() {
        return "JsbInfoData(bridgeName=" + this.f531007b + ", statusCode=" + this.f531008c + ", statusDescription=null, protocolVersion=null, costTime=" + this.f531009d + ", invokeTime=" + this.f531010e + ", callbackTime=" + this.f531011f + ", fireEventTime=0)";
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        bz2.e.i(r100, "bridge_name", this.f531007b);
        bz2.e.f(r100, "status_code", this.f531008c);
        bz2.e.i(r100, "status_description", null);
        bz2.e.i(r100, "protocol_version", null);
        bz2.e.g(r100, HiAnalyticsConstant.BI_KEY_COST_TIME, this.f531009d);
        bz2.e.g(r100, "invoke_ts", this.f531010e);
        bz2.e.g(r100, "callback_ts", this.f531011f);
        bz2.e.g(r100, "fireEvent_ts", 0);
    }
}
