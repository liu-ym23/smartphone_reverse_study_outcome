package z86;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.iesgurd.core.ReqType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f570921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f570922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f570923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f570924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f570925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReqType f570926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f570927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f570928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f570929i;

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("api_version", "settings_v3");
        r100.put(BdpAppEventConstant.HTTP_STATUS, this.f570921a);
        r100.put(LocationMonitorConst.ERR_MSG, this.f570923c);
        r100.put("req_type", this.f570926f.getType());
        r100.put("err_code", this.f570922b);
        r100.put("x_tlb_probe", this.f570927g);
        r100.put("local_version", this.f570929i);
        r100.put("version", this.f570928h);
        String r101 = this.f570924d;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        r100.put("x_tt_logid", this.f570924d);
    L12:
        if (this.f570925e == false) goto L14;
        r100.put("is_retry", 1);
    L14:
        y86.a.c("geckosdk_query_settings", r100);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public b() {
        this.f570926f = ReqType.NORMAL;
    }
}
