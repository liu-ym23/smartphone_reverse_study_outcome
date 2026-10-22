package z86;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ReqType f570930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f570931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f570932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f570933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f570934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f570935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f570936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f570937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f570938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f570939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j f570940k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f570941l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f570942m;

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("api_version", this.f570936g);
        r100.put(BdpAppEventConstant.HTTP_STATUS, this.f570931b);
        r100.put(LocationMonitorConst.ERR_MSG, this.f570934e);
        r100.put("req_type", this.f570930a.getType());
        r100.put("is_intercept", this.f570932c);
        r100.put("err_code", this.f570933d);
        r100.put("x_tlb_probe", this.f570941l);
        String r101 = this.f570935f;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        r100.put("x_tt_logid", this.f570935f);
    L12:
        if (this.f570937h.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        r100.put("access_key", this.f570937h);
    L18:
        if (this.f570938i.length() <= 0) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L24;
        r100.put("channels", this.f570938i);
    L24:
        if (this.f570939j.length() <= 0) goto L26;
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r100.put("group_name", this.f570939j);
    L30:
        if (this.f570942m == false) goto L32;
        r100.put("is_retry", 1);
    L32:
        j r107 = this.f570940k;
        if (r107 == null) goto L42;
        r100.put("lazy_model", r107.f250712e);
        IESGurdUpdatePriority r108 = r107.f250718k;
        if (r108 == IESGurdUpdatePriority.MIDDLE) goto L38;
        r100.put("download_priority", r108);
    L38:
        if (r107.f250715h.length() <= 0) goto L40;
        r102 = true;
    L40:
        if (r102 == false) goto L42;
        r100.put("tag", r107.f250715h);
    L42:
        y86.a.c("geckosdk_query_pkgs", r100);
        return;
    L26:
        r106 = false;
        goto L27
    L20:
        r105 = false;
        goto L21
    L14:
        r104 = false;
        goto L15
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public c() {
        this.f570930a = ReqType.NORMAL;
        this.f570937h = "";
        this.f570938i = "";
        this.f570939j = "";
    }
}
