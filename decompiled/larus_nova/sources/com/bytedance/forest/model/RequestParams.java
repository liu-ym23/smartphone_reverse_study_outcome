package com.bytedance.forest.model;

import android.webkit.WebResourceRequest;
import com.bytedance.forest.pollyfill.NetWorker;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public class RequestParams {
    public boolean A;
    public boolean B;
    public WebResourceRequest C;
    public NetWorker D;
    public boolean E;
    public int F;
    public boolean G;
    public final Map<String, String> H;
    public Set<String> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f244270J;
    public boolean K;
    public boolean L;
    public boolean M;
    public Scene N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<FetcherType> f244271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f244272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f244273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f244274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f244275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f244276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f244277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f244278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f244279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f244280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f244281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f244282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f244283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f244284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f244285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f244286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f244287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f244288r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f244289s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Boolean f244290t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Boolean f244291u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f244292v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f244293w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f244294x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f244295y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f244296z;

    public RequestParams() {
        this(0);
    }

    public final Map<String, Object> a() {
        return (Map) this.f244295y.getValue();
    }

    public final String b() {
        Object r100 = a().get("x-forest-injected-ua");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public RequestParams(Scene r100) {
        this.N = r100;
        NetWorker r101 = d.f244330a;
        this.f244271a = d.f244333d;
        this.f244272b = "";
        this.f244280j = true;
        this.f244293w = "";
        this.f244295y = LazyKt.lazy(RequestParams$customParams$2.INSTANCE);
        this.H = new LinkedHashMap();
        this.L = true;
    }

    public final void c(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        a().put("x-forest-preload-from", r100);
    }

    public /* synthetic */ RequestParams(int r100) {
        this(Scene.OTHER);
    }

    public RequestParams(RequestParams r100, boolean r101) {
        this(r100.N);
        this.f244271a = r100.f244271a;
        this.f244272b = r100.f244272b;
        this.f244273c = r100.f244273c;
        this.f244274d = r100.f244274d;
        this.f244275e = r100.f244275e;
        this.f244276f = r100.f244276f;
        this.f244277g = r100.f244277g;
        this.f244278h = r100.f244278h;
        this.f244279i = r100.f244279i;
        this.f244280j = r100.f244280j;
        this.f244281k = r100.f244281k;
        this.f244282l = r100.f244282l;
        this.f244283m = r100.f244283m;
        this.f244284n = r100.f244284n;
        this.f244285o = r100.f244285o;
        this.f244286p = r100.f244286p;
        this.f244287q = r100.f244287q;
        this.f244288r = r100.f244288r;
        this.f244289s = r100.f244289s;
        this.f244290t = r100.f244290t;
        this.f244291u = r100.f244291u;
        this.f244292v = r100.f244292v;
        this.f244293w = r100.f244293w;
        this.f244294x = r100.f244294x;
        a().putAll(r100.a());
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
        this.D = r100.D;
        this.E = r100.E;
        this.F = r100.F;
        this.G = r100.G;
        this.M = r100.M;
        this.f244296z = r101;
        this.H.putAll(r100.H);
        this.I = r100.I;
        this.f244270J = r100.f244270J;
        this.K = r100.K;
        this.L = r100.L;
    }
}
