package com.lynx.animax.property;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f380408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f380409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnimaXValueParam f380410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AnimaXValueParam f380411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f380412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f380413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f380414g;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AnimaXFrameInfo{frames=");
        r100.append(this.f380408a);
        r100.append("->");
        r100.append(this.f380409b);
        r100.append(", startValue=");
        Object r101 = this.f380410c;
        Object r102 = "null";
        if (r101 != null) goto L6;
        r101 = "null";
    L6:
        r100.append(r101);
        r100.append(", endValue=");
        AnimaXValueParam r103 = this.f380411d;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        r100.append(", progress=[linear=");
        r100.append(String.format("%.2f", new Object[]{Float.valueOf(this.f380412e)}));
        r100.append(", interpolated=");
        r100.append(String.format("%.2f", new Object[]{Float.valueOf(this.f380413f)}));
        r100.append(", overall=");
        r100.append(String.format("%.2f", new Object[]{Float.valueOf(this.f380414g)}));
        r100.append("]}");
        return r100.toString();
    }

    public a(float r100, float r101, AnimaXValueParam r102, AnimaXValueParam r103, float r104, float r105, float r106) {
        this.f380408a = r100;
        this.f380409b = r101;
        this.f380410c = r102;
        this.f380411d = r103;
        this.f380412e = r104;
        this.f380413f = r105;
        this.f380414g = r106;
    }
}
