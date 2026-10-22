package n4a;

/* JADX INFO: loaded from: classes32.dex */
public final class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f517432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f517433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f517434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f517435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f517436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f517437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f517438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f517439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f517440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f517441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f517442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f517443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f517444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f517445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f517446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f517447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f517448q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f517449r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f517450s;

    public k3(int r100, boolean r101) {
        this.f517432a = 0;
        this.f517433b = 0;
        this.f517434c = 0;
        this.f517435d = 0;
        this.f517436e = 0;
        this.f517437f = 0;
        this.f517438g = 0;
        this.f517439h = 0;
        this.f517440i = 0;
        this.f517441j = 0;
        this.f517442k = -113;
        this.f517443l = 0;
        this.f517444m = false;
        this.f517445n = 32767;
        this.f517446o = Integer.MAX_VALUE;
        this.f517447p = Integer.MAX_VALUE;
        this.f517448q = true;
        this.f517449r = 99;
        this.f517450s = 0;
        this.f517443l = r100;
        this.f517444m = r101;
    }

    public final String b() {
        String r100 = a();
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.length() > 0) goto L7;
        return "";
    L7:
        return (this.f517448q ? 1 : 0) + "#" + r100;
    }

    public final k3 c() {
        k3 r100 = new k3(this.f517443l, this.f517444m);
        r100.f517432a = this.f517432a;
        r100.f517433b = this.f517433b;
        r100.f517434c = this.f517434c;
        r100.f517435d = this.f517435d;
        r100.f517436e = this.f517436e;
        r100.f517437f = this.f517437f;
        r100.f517438g = this.f517438g;
        r100.f517439h = this.f517439h;
        r100.f517440i = this.f517440i;
        r100.f517441j = this.f517441j;
        r100.f517442k = this.f517442k;
        r100.f517445n = this.f517445n;
        r100.f517446o = this.f517446o;
        r100.f517447p = this.f517447p;
        r100.f517448q = this.f517448q;
        r100.f517449r = this.f517449r;
        r100.f517450s = this.f517450s;
        return r100;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof k3) == false) goto L72;
        k3 r101 = (k3) r100;
        int r102 = r101.f517443l;
        if (r102 == 1) goto L63;
        if (r102 == 2) goto L52;
        if (r102 == 3) goto L41;
        if (r102 == 4) goto L30;
        if (r102 == 5) goto L19;
        return false;
    L19:
        if (this.f517443l == 5) goto L22;
        return false;
    L22:
        if (r101.f517434c == this.f517434c) goto L24;
    L28:
        return false;
    L24:
        if (r101.f517436e != this.f517436e) goto L28;
        if (r101.f517447p != this.f517447p) goto L28;
        return true;
    L30:
        if (this.f517443l == 4) goto L33;
        return false;
    L33:
        if (r101.f517434c == this.f517434c) goto L35;
    L39:
        return false;
    L35:
        if (r101.f517435d != this.f517435d) goto L39;
        if (r101.f517433b != this.f517433b) goto L39;
        return true;
    L41:
        if (this.f517443l == 3) goto L44;
        return false;
    L44:
        if (r101.f517434c == this.f517434c) goto L46;
    L50:
        return false;
    L46:
        if (r101.f517435d != this.f517435d) goto L50;
        if (r101.f517433b != this.f517433b) goto L50;
        return true;
    L52:
        if (this.f517443l == 2) goto L55;
        return false;
    L55:
        if (r101.f517441j == this.f517441j) goto L57;
    L61:
        return false;
    L57:
        if (r101.f517440i != this.f517440i) goto L61;
        if (r101.f517439h != this.f517439h) goto L61;
        return true;
    L63:
        if (this.f517443l == 1) goto L66;
        return false;
    L66:
        if (r101.f517434c != this.f517434c) goto L72;
        if (r101.f517435d != this.f517435d) goto L72;
        if (r101.f517433b != this.f517433b) goto L72;
        return true;
    L72:
        return false;
    }

    public final int hashCode() {
        int r100 = String.valueOf(this.f517443l).hashCode();
        if (this.f517443l != 2) goto L5;
        int r101 = String.valueOf(this.f517441j).hashCode() + String.valueOf(this.f517440i).hashCode();
        int r102 = this.f517439h;
    L7:
        return r100 + (r101 + String.valueOf(r102).hashCode());
    L5:
        r101 = String.valueOf(this.f517434c).hashCode() + String.valueOf(this.f517435d).hashCode();
        r102 = this.f517433b;
        goto L7
    }

    public final String a() {
        int r100 = this.f517443l;
        if (r100 != 1) goto L5;
    L15:
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f517443l);
        r101.append("#");
        r101.append(this.f517432a);
        r101.append("#");
        r101.append(this.f517433b);
        r101.append("#0#");
        if (this.f517443l != 5) goto L18;
        long r102 = this.f517436e;
    L19:
        r101.append(r102);
        return r101.toString();
    L18:
        r102 = this.f517435d;
        goto L19
    L5:
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L15;
        if (r100 == 5) goto L15;
        return null;
    L14:
        return this.f517443l + "#" + this.f517439h + "#" + this.f517440i + "#" + this.f517441j;
    }
}
