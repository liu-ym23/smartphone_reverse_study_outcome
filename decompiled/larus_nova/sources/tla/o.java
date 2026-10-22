package tla;

/* JADX INFO: loaded from: classes34.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f546726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f546727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f546728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f546729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f546730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f546731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f546732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f546733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f546734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f546735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f546736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f546737l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f546738m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f546739n;

    @Override // tla.n
    public final float b() {
        if (this.f546736k == false) goto L6;
        return -c(this.f546739n);
    L6:
        return c(this.f546739n);
    }

    public o() {
        this.f546736k = false;
    }

    @Override // tla.n
    public final boolean a() {
        if (b() < 1.0E-5f) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(this.f546734i - this.f546738m) >= 1.0E-5f) goto L7;
        return true;
    }

    public final float c(float r100) {
        float r101 = this.f546729d;
        if (r100 > r101) goto L6;
        float r102 = this.f546726a;
        return r102 + (((this.f546727b - r102) * r100) / r101);
    L6:
        int r103 = this.f546735j;
        if (r103 != 1) goto L9;
        return 0.0f;
    L9:
        float r104 = r100 - r101;
        float r105 = this.f546730e;
        if (r104 >= r105) goto L14;
        float r106 = this.f546727b;
        return r106 + (((this.f546728c - r106) * r104) / r105);
    L14:
        if (r103 != 2) goto L16;
        return 0.0f;
    L16:
        float r107 = r104 - r105;
        float r108 = this.f546731f;
        if (r107 >= r108) goto L20;
        float r109 = this.f546728c;
        return r109 - ((r107 * r109) / r108);
    L20:
        return 0.0f;
    }

    @Override // tla.n
    public final float getInterpolation(float r100) {
        float r101 = this.f546729d;
        if (r100 > r101) goto L5;
        float r102 = this.f546726a;
        float r103 = (r102 * r100) + ((((this.f546727b - r102) * r100) * r100) / (r101 * 2.0f));
    L18:
        this.f546738m = r103;
        this.f546739n = r100;
        if (this.f546736k == false) goto L22;
        return this.f546737l - r103;
    L22:
        return this.f546737l + r103;
    L5:
        int r104 = this.f546735j;
        if (r104 != 1) goto L8;
        r103 = this.f546732g;
        goto L18
    L8:
        float r105 = r100 - r101;
        float r106 = this.f546730e;
        if (r105 >= r106) goto L12;
        float r107 = this.f546732g;
        float r108 = this.f546727b;
        r103 = (r107 + (r108 * r105)) + ((((this.f546728c - r108) * r105) * r105) / (r106 * 2.0f));
        goto L18
    L12:
        if (r104 != 2) goto L14;
        r103 = this.f546733h;
        goto L18
    L14:
        float r109 = r105 - r106;
        float r110 = this.f546731f;
        if (r109 > r110) goto L17;
        float r111 = this.f546733h;
        float r112 = this.f546728c * r109;
        r103 = (r111 + r112) - ((r112 * r109) / (r110 * 2.0f));
        goto L18
    L17:
        r103 = this.f546734i;
        goto L18
    }

    public final void d(float r100, float r110, float r111, float r112, float r113) {
        this.f546734i = r110;
        if (r100 != 0.0f) goto L5;
        r100 = 1.0E-4f;
    L5:
        float r101 = r100 / r111;
        float r102 = (r101 * r100) / 2.0f;
        if (r100 >= 0.0f) goto L14;
        float r114 = (float) Math.sqrt((r110 - ((((-r100) / r111) * r100) / 2.0f)) * r111);
        if (r114 >= r112) goto L11;
        this.f546735j = 2;
        this.f546726a = r100;
        this.f546727b = r114;
        this.f546728c = 0.0f;
        float r115 = (r114 - r100) / r111;
        this.f546729d = r115;
        this.f546730e = r114 / r111;
        this.f546732g = ((r100 + r114) * r115) / 2.0f;
        this.f546733h = r110;
        this.f546734i = r110;
        return;
    L11:
        this.f546735j = 3;
        this.f546726a = r100;
        this.f546727b = r112;
        this.f546728c = r112;
        float r116 = (r112 - r100) / r111;
        this.f546729d = r116;
        float r117 = r112 / r111;
        this.f546731f = r117;
        float r103 = ((r100 + r112) * r116) / 2.0f;
        float r118 = (r117 * r112) / 2.0f;
        this.f546730e = ((r110 - r103) - r118) / r112;
        this.f546732g = r103;
        this.f546733h = r110 - r118;
        this.f546734i = r110;
        return;
    L14:
        if (r102 < r110) goto L17;
        this.f546735j = 1;
        this.f546726a = r100;
        this.f546727b = 0.0f;
        this.f546732g = r110;
        this.f546729d = (2.0f * r110) / r100;
        return;
    L17:
        float r104 = r110 - r102;
        float r105 = r104 / r100;
        if ((r105 + r101) >= r113) goto L21;
        this.f546735j = 2;
        this.f546726a = r100;
        this.f546727b = r100;
        this.f546728c = 0.0f;
        this.f546732g = r104;
        this.f546733h = r110;
        this.f546729d = r105;
        this.f546730e = r101;
        return;
    L21:
        float r119 = (float) Math.sqrt((r111 * r110) + ((r100 * r100) / 2.0f));
        float r106 = (r119 - r100) / r111;
        this.f546729d = r106;
        float r107 = r119 / r111;
        this.f546730e = r107;
        if (r119 >= r112) goto L25;
        this.f546735j = 2;
        this.f546726a = r100;
        this.f546727b = r119;
        this.f546728c = 0.0f;
        this.f546729d = r106;
        this.f546730e = r107;
        this.f546732g = ((r100 + r119) * r106) / 2.0f;
        this.f546733h = r110;
        return;
    L25:
        this.f546735j = 3;
        this.f546726a = r100;
        this.f546727b = r112;
        this.f546728c = r112;
        float r120 = (r112 - r100) / r111;
        this.f546729d = r120;
        float r121 = r112 / r111;
        this.f546731f = r121;
        float r108 = ((r100 + r112) * r120) / 2.0f;
        float r122 = (r121 * r112) / 2.0f;
        this.f546730e = ((r110 - r108) - r122) / r112;
        this.f546732g = r108;
        this.f546733h = r110 - r122;
        this.f546734i = r110;
    }
}
