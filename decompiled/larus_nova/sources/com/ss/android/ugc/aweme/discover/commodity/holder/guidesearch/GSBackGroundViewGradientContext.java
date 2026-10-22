package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GSBackGroundViewGradientContext;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GSBackGroundViewGradientContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f450175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f450176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f450177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f450178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f450179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f450180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f450181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f450182h;

    public GSBackGroundViewGradientContext() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GSBackGroundViewGradientContext) == false) goto L22;
        GSBackGroundViewGradientContext r101 = (GSBackGroundViewGradientContext) r100;
        if (this.f450175a == r101.f450175a) goto L8;
        return false;
    L8:
        if (this.f450176b == r101.f450176b) goto L10;
        return false;
    L10:
        if (Float.compare(this.f450177c, r101.f450177c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f450178d, r101.f450178d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f450179e, r101.f450179e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f450180f, r101.f450180f) == 0) goto L18;
        return false;
    L18:
        if (this.f450181g == r101.f450181g) goto L20;
        return false;
    L20:
        if (this.f450182h == r101.f450182h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        return (((((((((((((this.f450175a * 31) + this.f450176b) * 31) + Float.floatToIntBits(this.f450177c)) * 31) + Float.floatToIntBits(this.f450178d)) * 31) + Float.floatToIntBits(this.f450179e)) * 31) + Float.floatToIntBits(this.f450180f)) * 31) + this.f450181g) * 31) + this.f450182h;
    }

    public final String toString() {
        return "GSBackGroundViewGradientContext(startColor=" + this.f450175a + ", endColor=" + this.f450176b + ", startX=" + this.f450177c + ", startY=" + this.f450178d + ", endX=" + this.f450179e + ", endY=" + this.f450180f + ", width=" + this.f450181g + ", height=" + this.f450182h + ")";
    }

    public /* synthetic */ GSBackGroundViewGradientContext(int r110) {
        this(0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0);
    }

    public GSBackGroundViewGradientContext(int r100, int r101, float r102, float r103, float r104, float r105, int r106, int r107) {
        this.f450175a = r100;
        this.f450176b = r101;
        this.f450177c = r102;
        this.f450178d = r103;
        this.f450179e = r104;
        this.f450180f = r105;
        this.f450181g = r106;
        this.f450182h = r107;
    }

    public static GSBackGroundViewGradientContext a(GSBackGroundViewGradientContext r100, int r110, int r111, float r112, float r113, float r114, float r115, int r116, int r117, int r118) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.f450175a;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.f450176b;
    L11:
        if ((r118 & 4) == 0) goto L13;
        float r103 = r100.f450177c;
    L15:
        if ((r118 & 8) == 0) goto L17;
        float r104 = r100.f450178d;
    L19:
        if ((r118 & 16) == 0) goto L21;
        float r105 = r100.f450179e;
    L23:
        if ((r118 & 32) == 0) goto L25;
        float r106 = r100.f450180f;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.f450181g;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r108 = r100.f450182h;
    L34:
        r100.getClass();
        return new GSBackGroundViewGradientContext(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L34
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
