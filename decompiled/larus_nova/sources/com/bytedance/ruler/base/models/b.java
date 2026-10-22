package com.bytedance.ruler.base.models;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f267653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f267654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f267655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f267656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f267657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f267658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f267659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f267660h;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L22;
        b r101 = (b) r100;
        if (this.f267653a == r101.f267653a) goto L8;
        return false;
    L8:
        if (this.f267654b == r101.f267654b) goto L10;
        return false;
    L10:
        if (this.f267655c == r101.f267655c) goto L12;
        return false;
    L12:
        if (this.f267656d == r101.f267656d) goto L14;
        return false;
    L14:
        if (this.f267657e == r101.f267657e) goto L16;
        return false;
    L16:
        if (this.f267658f == r101.f267658f) goto L18;
        return false;
    L18:
        if (this.f267659g == r101.f267659g) goto L20;
        return false;
    L20:
        if (this.f267660h == r101.f267660h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        long r100 = this.f267653a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f267654b;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        long r105 = this.f267655c;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f267656d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f267657e;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.f267658f;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.f267659g;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        boolean r115 = this.f267660h;
        if (r115 == true) goto L10;
        r103 = r115;
    L10:
        return r114 + r103;
    }

    public final String toString() {
        return "Performance(paramsCost=" + this.f267653a + ", strategySelectFromCache=" + this.f267654b + ", selectSceneCost=" + this.f267655c + ", selectStrategyCost=" + this.f267656d + ", buildRulescost=" + this.f267657e + ", execRulesCost=" + this.f267658f + ", blackListCost=" + this.f267659g + ", strategySelectFromTrie=" + this.f267660h + ")";
    }

    public b(int r100) {
        this.f267653a = 0;
        this.f267654b = false;
        this.f267655c = 0;
        this.f267656d = 0;
        this.f267657e = 0;
        this.f267658f = 0;
        this.f267659g = 0;
        this.f267660h = false;
    }
}
