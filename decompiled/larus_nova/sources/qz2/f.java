package qz2;

import com.bytedance.android.monitorV2.util.l;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends fz2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f535315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f535316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f535317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f535318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f535319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f535320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f535321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f535322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f535323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f535324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f535325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f535326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f535327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f535328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, Object> f535329p;

    public f() {
        super("performance");
        this.f535328o = System.currentTimeMillis();
    }

    public final void a(int r100) {
        nz2.b.f("LynxState", "set lynx_state = " + r100);
        this.f535327n = r100;
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        l.a(r100, this.f535326m);
        l.p(r100, "fp", Double.valueOf(this.f535315b));
        l.p(r100, "fmp", Double.valueOf(this.f535316c));
        l.p(r100, "tti", Double.valueOf(this.f535317d));
        l.p(r100, "Layout", Double.valueOf(this.f535318e));
        l.p(r100, "render_page", Double.valueOf(this.f535324k));
        l.p(r100, "Diff_root_create", Double.valueOf(this.f535319f));
        l.p(r100, "Diff_same_root", Double.valueOf(this.f535320g));
        l.p(r100, "tasm_binary_decode", Double.valueOf(this.f535322i));
        l.p(r100, "tasm_end_decode_finish_load_template", Double.valueOf(this.f535321h));
        l.p(r100, "tasm_finish_load_template", Double.valueOf(this.f535323j));
        l.n(r100, "state", this.f535327n);
        l.o(r100, "report_ts", this.f535328o);
        JSONObject r101 = new JSONObject();
        Map<String, Object> r102 = this.f535329p;
        Object r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.get("metrics");
    L6:
        if (r104 == null) goto L12;
        Map<String, Object> r105 = this.f535329p;
        if (r105 == null) goto L10;
        Object r106 = r105.get("metrics");
    L11:
        l.p(r101, "metrics", l.r(String.valueOf(r106)));
        goto L12
    L10:
        r106 = null;
    L12:
        Map<String, Object> r107 = this.f535329p;
        if (r107 == null) goto L15;
        Object r108 = r107.get(LynxMonitorService.KEY_SETUP_TIMING);
    L16:
        if (r108 == null) goto L22;
        Map<String, Object> r109 = this.f535329p;
        if (r109 == null) goto L20;
        Object r110 = r109.get(LynxMonitorService.KEY_SETUP_TIMING);
    L21:
        l.p(r101, LynxMonitorService.KEY_SETUP_TIMING, l.r(String.valueOf(r110)));
        goto L22
    L20:
        r110 = null;
    L22:
        Map<String, Object> r111 = this.f535329p;
        if (r111 == null) goto L25;
        Object r112 = r111.get(LynxMonitorService.KEY_UPDATE_TIMING);
    L26:
        if (r112 == null) goto L32;
        Map<String, Object> r113 = this.f535329p;
        if (r113 == null) goto L30;
        Object r114 = r113.get(LynxMonitorService.KEY_UPDATE_TIMING);
    L31:
        l.p(r101, LynxMonitorService.KEY_UPDATE_TIMING, l.r(String.valueOf(r114)));
        goto L32
    L30:
        r114 = null;
    L32:
        Map<String, Object> r115 = this.f535329p;
        if (r115 == null) goto L35;
        Object r116 = r115.get(LynxMonitorService.KEY_EXTRA_TIMING);
    L36:
        if (r116 == null) goto L42;
        Map<String, Object> r117 = this.f535329p;
        if (r117 == null) goto L40;
        Object r118 = r117.get(LynxMonitorService.KEY_EXTRA_TIMING);
    L41:
        l.p(r101, LynxMonitorService.KEY_EXTRA_TIMING, l.r(String.valueOf(r118)));
        goto L42
    L40:
        r118 = null;
    L42:
        Map<String, Object> r119 = this.f535329p;
        if (r119 == null) goto L45;
        Object r120 = r119.get("thread_strategy");
    L46:
        if (r120 == null) goto L52;
        Map<String, Object> r121 = this.f535329p;
        if (r121 == null) goto L50;
        Object r122 = r121.get("thread_strategy");
    L51:
        l.p(r101, "thread_strategy", r122);
        goto L52
    L50:
        r122 = null;
    L52:
        Map<String, Object> r123 = this.f535329p;
        if (r123 == null) goto L55;
        Object r124 = r123.get("url");
    L57:
        if (String.valueOf(r124).length() <= 0) goto L59;
        boolean r125 = true;
    L60:
        if (r125 == false) goto L65;
        Map<String, Object> r126 = this.f535329p;
        if (r126 == null) goto L64;
        r103 = r126.get("url");
    L64:
        l.p(r101, "url", r103);
    L65:
        l.a(r100, r101);
        d r127 = this.f535325l;
        if (r127 == null) goto L69;
        r127.fillInJsonObject(r100);
        return;
    L69:
        return;
    L59:
        r125 = false;
        goto L60
    L55:
        r124 = null;
        goto L57
    L45:
        r120 = null;
        goto L46
    L35:
        r116 = null;
        goto L36
    L25:
        r112 = null;
        goto L26
    L15:
        r108 = null;
        goto L16
    L5:
        r104 = null;
        goto L6
    }
}
