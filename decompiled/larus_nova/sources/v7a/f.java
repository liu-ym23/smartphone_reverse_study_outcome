package v7a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f553505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f553506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f553507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap.Config f553508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f553509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f553510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f553511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f553512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f553513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f553514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<b> f553515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f553516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f553517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f553518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f553519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f553520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f553521r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f553522s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f553523t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f553524u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f553525v;

    public final int hashCode() {
        String r100 = this.f553504a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f553505b) * 31) + this.f553506c) * 31;
        Bitmap.Config r104 = this.f553508e;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((((((r103 + r105) * 31) + (this.f553509f ? 1 : 0)) * 31) + (this.f553510g ? 1 : 0)) * 31) + (this.f553511h ? 1 : 0)) * 31) + (this.f553514k ? 1 : 0)) * 31;
        List<b> r107 = this.f553515l;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Rect r110 = this.f553524u;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public f(g r100) {
        this.f553511h = true;
        this.f553513j = null;
        this.f553518o = false;
        this.f553519p = false;
        this.f553520q = false;
        this.f553521r = false;
        this.f553522s = false;
        this.f553523t = 0.0f;
        this.f553525v = true;
        this.f553504a = r100.f553526a;
        this.f553505b = r100.f553527b;
        this.f553514k = r100.f553535j;
        this.f553513j = r100.f553533h;
        this.f553506c = r100.f553528c;
        this.f553507d = r100.f553529d;
        this.f553508e = r100.f553530e;
        this.f553510g = r100.f553531f;
        this.f553512i = r100.f553532g;
        this.f553515l = r100.f553534i;
        this.f553509f = r100.f553538m;
        this.f553511h = r100.f553537l;
        this.f553516m = r100.f553539n;
        this.f553517n = r100.f553536k;
        this.f553518o = r100.f553540o;
        this.f553525v = r100.f553541p;
        this.f553519p = r100.f553542q;
        this.f553520q = r100.f553543r;
        this.f553521r = r100.f553544s;
        this.f553522s = r100.f553545t;
        this.f553523t = r100.f553546u;
        this.f553524u = r100.f553547v;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L39:
        return false;
    L8:
        if (f.class != r100.getClass()) goto L39;
        f r101 = (f) r100;
        if (this.f553505b == r101.f553505b) goto L14;
        return false;
    L14:
        if (this.f553506c == r101.f553506c) goto L17;
        return false;
    L17:
        if (this.f553509f == r101.f553509f) goto L20;
        return false;
    L20:
        if (this.f553510g == r101.f553510g) goto L23;
        return false;
    L23:
        if (this.f553511h == r101.f553511h) goto L26;
        return false;
    L26:
        if (this.f553514k == r101.f553514k) goto L29;
        return false;
    L29:
        if (Objects.equals(this.f553504a, r101.f553504a) == true) goto L32;
        return false;
    L32:
        if (this.f553508e == r101.f553508e) goto L35;
        return false;
    L35:
        if (Objects.equals(this.f553524u, r101.f553524u) == true) goto L38;
        return false;
    L38:
        return Objects.equals(this.f553515l, r101.f553515l);
    }
}
