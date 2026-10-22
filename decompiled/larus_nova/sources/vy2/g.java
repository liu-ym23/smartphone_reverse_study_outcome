package vy2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends ny2.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f557594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f557595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f557596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f557597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f557598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f557599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f557600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f557601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public double f557602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f557603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f557604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f557605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f557606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f557607o;

    public g() {
        super("performance");
        this.f557607o = System.currentTimeMillis();
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        bz2.e.a(r100, this.f557605m);
        bz2.e.h(r100, "fp", Double.valueOf(this.f557594b));
        bz2.e.h(r100, "fmp", Double.valueOf(this.f557595c));
        bz2.e.h(r100, "tti", Double.valueOf(this.f557596d));
        bz2.e.h(r100, "Layout", Double.valueOf(this.f557597e));
        bz2.e.h(r100, "render_page", Double.valueOf(this.f557603k));
        bz2.e.h(r100, "Diff_root_create", Double.valueOf(this.f557598f));
        bz2.e.h(r100, "Diff_same_root", Double.valueOf(this.f557599g));
        bz2.e.h(r100, "tasm_binary_decode", Double.valueOf(this.f557601i));
        bz2.e.h(r100, "tasm_end_decode_finish_load_template", Double.valueOf(this.f557600h));
        bz2.e.h(r100, "tasm_finish_load_template", Double.valueOf(this.f557602j));
        bz2.e.f(r100, "state", this.f557606n);
        bz2.e.g(r100, "report_ts", this.f557607o);
        d r101 = this.f557604l;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
