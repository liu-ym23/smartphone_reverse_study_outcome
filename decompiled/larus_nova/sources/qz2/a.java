package qz2;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.monitorV2.util.l;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f535269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f535270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f535271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f535272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f535273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f535274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f535275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f535276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f535277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f535278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f535279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f535280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f535281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f535282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f535283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f535284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f535285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f535286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public jz2.e f535287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Map<String, Integer> f535288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map<String, Integer> f535289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f535290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f535291x;

    public a() {
        super("blank");
        int r100 = d.f535304h;
        this.f535280m = -1;
        this.f535281n = -1.0f;
        this.f535284q = "";
        this.f535291x = "";
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        l.p(r100, "effective_percentage", Float.valueOf(this.f535269b));
        l.n(r100, "view_height", this.f535270c);
        l.n(r100, "view_width", this.f535271d);
        l.n(r100, "view_alpha", this.f535282o);
        l.n(r100, "element_count", this.f535283p);
        l.o(r100, "collect_time", this.f535273f);
        l.o(r100, "calculate_time", this.f535274g);
        l.o(r100, HiAnalyticsConstant.BI_KEY_COST_TIME, this.f535272e);
        l.n(r100, "detect_type", this.f535275h);
        l.o(r100, "enter_page_time", this.f535276i);
        l.o(r100, "detect_start_time", this.f535277j);
        float r101 = this.f535281n;
        if (r101 <= 0) goto L5;
        l.p(r100, "max_blank_rect_radio", Float.valueOf(r101));
    L5:
        JSONObject r102 = new JSONObject();
        int r103 = this.f535278k;
        if (r103 == 0) goto L8;
        l.n(r102, "http_rtt_ms", r103);
    L8:
        int r104 = this.f535279l;
        if (r104 == 0) goto L11;
        l.n(r102, "transport_rtt_ms", r104);
    L11:
        int r105 = this.f535280m;
        if (r105 < 0) goto L14;
        l.n(r102, "load_state", r105);
    L14:
        Unit r106 = Unit.INSTANCE;
        l.p(r100, "assist_info", r102);
        l.q(r100, SimplayerImageStrategy.RESULT_BITMAP, this.f535284q);
        l.n(r100, "bitmap_width", this.f535285r);
        l.n(r100, "bitmap_height", this.f535286s);
        jz2.e r107 = this.f535287t;
        if (r107 == null) goto L17;
        r107.fillInJsonObject(r100);
    L17:
        Map<String, Integer> r108 = this.f535288u;
        if (r108 == null) goto L20;
        l.p(r100, SlcElement.KEY_ELEMENTS, new JSONObject(r108));
    L20:
        Map<String, Integer> r109 = this.f535289v;
        if (r109 == null) goto L23;
        l.p(r100, "valid_elements", new JSONObject(r109));
    L23:
        l.p(r100, "has_valid_element", Boolean.valueOf(this.f535290w));
    }
}
