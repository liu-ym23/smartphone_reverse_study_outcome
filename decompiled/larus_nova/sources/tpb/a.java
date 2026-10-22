package tpb;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.larkconfig.userconfig.api.ExternalSearchConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JSONField(name = "maxMemberCount")
    private int f547076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JSONField(name = "maxRecallTime")
    private long f547077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JSONField(name = "vcHeartBeatCycle")
    private int f547078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JSONField(name = "vcHeartBeatExpire")
    private int f547079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JSONField(name = "domain")
    private String f547080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JSONField(name = "docsDomains")
    private List<String> f547081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JSONField(name = "createDocsUrl")
    private String f547082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JSONField(name = "addresses")
    private Map<String, String> f547083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JSONField(name = "customerServiceUrl")
    private String f547084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JSONField(name = "onCallChat")
    private boolean f547085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JSONField(name = "androidAppStores")
    private List<String> f547086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JSONField(name = "guideToRateDelayHours")
    private int f547087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @JSONField(name = "isAutoTranslateEnable")
    private boolean f547088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @JSONField(name = "isRedPacketEnable")
    private boolean f547089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @JSONField(name = "secretChatEnable")
    private boolean f547090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @JSONField(name = "recallGroupChatterValidLimit")
    private int f547091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @JSONField(name = "externalSearches")
    private List<ExternalSearchConfig> f547092q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @JSONField(name = "notificationBannerRefreshTime")
    private long f547093r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @JSONField(name = "createExternalChatMaxMemberCount")
    private int f547094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @JSONField(name = "urlRegex")
    private Map<Integer, String> f547095t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @JSONField(name = "cryptoChatState")
    private int f547096u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @JSONField(name = "urgent_num")
    private List<String> f547097v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @JSONField(name = "urgent_num_update_time")
    private Long f547098w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @JSONField(name = "residency")
    private String f547099x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @JSONField(name = "is_show_residency")
    private boolean f547100y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @JSONField(name = "residency_help_url")
    private String f547101z;

    public final List<String> a() {
        List<String> r100 = this.f547081f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new ArrayList();
    }

    public a() {
        this.f547085j = false;
        this.f547087l = -1;
        this.f547088m = false;
        this.f547089n = false;
        this.f547091p = -1;
        this.f547093r = 0;
        this.f547094s = 0;
        this.f547095t = new HashMap();
        this.f547096u = 3;
    }

    public final Map<Integer, String> b() {
        return this.f547095t;
    }

    public final boolean c() {
        return this.f547088m;
    }

    public final void A(Map<Integer, String> r100) {
        this.f547095t = r100;
    }

    public final void B(int r100) {
        this.f547078c = r100;
    }

    public final void C(int r100) {
        this.f547079d = r100;
    }

    public final void d(Map<String, String> r100) {
        this.f547083h = r100;
    }

    public final void e(List<String> r100) {
        this.f547086k = r100;
    }

    public final void f(boolean r100) {
        this.f547088m = r100;
    }

    public final void g(int r100) {
        this.f547076a = r100;
    }

    public final void h(String r100) {
        this.f547082g = r100;
    }

    public final void i(int r100) {
        this.f547094s = r100;
    }

    public final void j(int r100) {
        this.f547096u = r100;
    }

    public final void k(String r100) {
        this.f547084i = r100;
    }

    public final void l(List<String> r100) {
        this.f547081f = r100;
    }

    public final void m(String r100) {
        this.f547080e = r100;
    }

    public final void n(List<ExternalSearchConfig> r100) {
        this.f547092q = r100;
    }

    public final void o(int r100) {
        this.f547087l = r100;
    }

    public final void p(long r100) {
        this.f547077b = r100;
    }

    public final void q(long r100) {
        this.f547093r = r100;
    }

    public final void r(boolean r100) {
        this.f547085j = r100;
    }

    public final void s(int r100) {
        this.f547091p = r100;
    }

    public final void t(boolean r100) {
        this.f547089n = r100;
    }

    public final void u(String r100) {
        this.f547099x = r100;
    }

    public final void v(String r100) {
        this.f547101z = r100;
    }

    public final void w(boolean r100) {
        this.f547090o = r100;
    }

    public final void x(boolean r100) {
        this.f547100y = r100;
    }

    public final void y(List<String> r100) {
        this.f547097v = r100;
    }

    public final void z(Long r100) {
        this.f547098w = r100;
    }
}
