package v26;

import android.webkit.WebResourceRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {
    public List<String> A;
    public String B;
    public String C;
    public WebResourceRequest D;
    public Integer E;
    public Map<String, String> F;
    public boolean G;
    public boolean H;
    public String I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f552698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f552699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f552700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f552701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f552702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f552703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f552704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f552705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f552706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f552707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f552708k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f552709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f552710m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f552711n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f552712o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f552713p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f552714q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f552715r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f552716s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<String> f552717t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f552718u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f552719v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f552720w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f552721x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f552722y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public w16.a f552723z;

    public /* synthetic */ l() {
        this("");
    }

    public final String toString() {
        return "[accessKey=" + this.f552698a + ", loaderConfig=" + this.f552699b + ", dynamic=" + this.f552703f + ",onlyLocal=" + this.f552704g + ", channel=" + this.f552705h + ",bundle=" + this.f552706i + ", group=" + this.f552707j + ",cdnUrl=" + this.f552708k + ",enableCached:" + this.f552714q + "]\n[fallbackDomains=" + this.f552717t + ",shuffle = " + this.f552718u + ",cdnNoCache=" + this.f552719v + "，maxAttempt=" + this.f552720w + "，isRemote=" + this.f552721x + ",useInteraction = " + this.f552722y + ']';
    }

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "accessKey");
        this.f552698a = r100;
        this.f552699b = new a(false);
        this.f552701d = "";
        this.f552702e = 1000;
        this.f552705h = "";
        this.f552706i = "";
        this.f552708k = "";
        this.f552709l = true;
        this.f552710m = true;
        this.f552711n = "";
        this.f552712o = "";
        this.f552714q = true;
        this.f552717t = new ArrayList();
        this.A = CollectionsKt.emptyList();
        this.B = "";
        this.G = true;
        this.I = "default_bid";
    }

    public final void a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f552701d = r100.f552701d;
        this.f552699b = r100.f552699b;
        this.f552702e = r100.f552702e;
        this.f552703f = r100.f552703f;
        this.f552704g = r100.f552704g;
        this.f552705h = r100.f552705h;
        this.f552706i = r100.f552706i;
        this.f552707j = r100.f552707j;
        this.f552708k = r100.f552708k;
        this.f552713p = r100.f552713p;
        this.f552714q = r100.f552714q;
        this.f552711n = r100.f552711n;
        this.f552710m = r100.f552710m;
        this.f552709l = r100.f552709l;
        this.f552715r = r100.f552715r;
        this.f552717t = r100.f552717t;
        this.f552718u = r100.f552718u;
        this.f552719v = r100.f552719v;
        this.f552720w = r100.f552720w;
        this.f552722y = r100.f552722y;
        this.f552723z = r100.f552723z;
        this.B = r100.B;
        this.I = r100.I;
        this.F = r100.F;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f552701d = r100;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f552708k = r100;
    }
}
