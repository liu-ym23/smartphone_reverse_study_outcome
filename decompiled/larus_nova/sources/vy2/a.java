package vy2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends ny2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f557565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f557566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f557567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f557568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f557569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f557570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f557571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f557572i;

    public a() {
        super("blank");
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        bz2.e.h(r100, "effective_percentage", Float.valueOf(this.f557565b));
        bz2.e.f(r100, "view_height", this.f557566c);
        bz2.e.f(r100, "view_width", this.f557567d);
        bz2.e.f(r100, "view_alpha", this.f557571h);
        bz2.e.f(r100, "element_count", this.f557572i);
        bz2.e.g(r100, "collect_time", this.f557569f);
        bz2.e.g(r100, "calculate_time", this.f557570g);
        bz2.e.g(r100, HiAnalyticsConstant.BI_KEY_COST_TIME, this.f557568e);
        bz2.e.f(r100, "detect_type", 0);
    }
}
