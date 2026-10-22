package ira;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f495510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f495511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f495512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f495513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f495514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f495515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f495516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f495517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f495518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f495519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f495520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f495521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f495522m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSONObject f495523n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f495524a;

        public a() {
            this.f495524a = new c();
        }
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("\tcategory: ");
        r100.append(this.f495510a);
        r100.append("\t\ttag: ");
        r100.append(this.f495511b);
        r100.append("\t\nlabel: ");
        r100.append(this.f495512c);
        r100.append("\nisAd: ");
        r100.append(this.f495513d);
        r100.append("\t\ncid: ");
        r100.append(this.f495514e);
        r100.append("\t\ngroupId：");
        r100.append(this.f495515f);
        r100.append("\nlogExtra: ");
        r100.append(this.f495516g);
        r100.append("\t\nextValue: 0\nextJson: ");
        r100.append(this.f495517h);
        r100.append("\nclickTrackUrl: ");
        String r101 = "";
        r100.append("");
        r100.append(" \neventSource : 0    \nisV3: ");
        r100.append(this.f495520k);
        r100.append("    \nV3EventName: ");
        r100.append(this.f495521l);
        r100.append("    \nV3EventParams: ");
        JSONObject r102 = this.f495522m;
        if (r102 == null) goto L5;
        String r103 = String.valueOf(r102);
    L6:
        r100.append(r103);
        r100.append("\nV1EventParams: ");
        JSONObject r104 = this.f495523n;
        if (r104 == null) goto L9;
        r101 = String.valueOf(r104);
    L9:
        r100.append(r101);
        return r100.toString();
    L5:
        r103 = "";
        goto L6
    }

    public c() {
    }
}
