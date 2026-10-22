package jz2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class k extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f501161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f501162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f501163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f501164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f501165f;

    public k() {
        super("jsbPerf");
    }

    @Override // fz2.b
    public final String toString() {
        return "JsbInfoData(bridgeName=" + this.f501161b + ", statusCode=" + this.f501162c + ", statusDescription=null, protocolVersion=null, costTime=" + this.f501163d + ", invokeTime=" + this.f501164e + ", callbackTime=" + this.f501165f + ", fireEventTime=0)";
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        com.bytedance.android.monitorV2.util.l.q(r100, "bridge_name", this.f501161b);
        com.bytedance.android.monitorV2.util.l.n(r100, "status_code", this.f501162c);
        com.bytedance.android.monitorV2.util.l.q(r100, "status_description", null);
        com.bytedance.android.monitorV2.util.l.q(r100, "protocol_version", null);
        com.bytedance.android.monitorV2.util.l.o(r100, HiAnalyticsConstant.BI_KEY_COST_TIME, this.f501163d);
        com.bytedance.android.monitorV2.util.l.o(r100, "invoke_ts", this.f501164e);
        com.bytedance.android.monitorV2.util.l.o(r100, "callback_ts", this.f501165f);
        com.bytedance.android.monitorV2.util.l.o(r100, "fireEvent_ts", 0);
    }
}
