package com.bytedance.awemeopen.apps.framework.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements TypeEvaluator<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f197711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f197712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f197713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f197714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f197715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f197716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f197717g;

    public i(PointF r100, PointF r101) {
        this.f197711a = new PointF();
        float r102 = r100.x * 3.0f;
        float r103 = r101.x * 3.0f;
        this.f197712b = r102 - r103;
        this.f197713c = r103 - (r102 * 2.0f);
        this.f197714d = r102;
        float r104 = r100.y * 3.0f;
        float r105 = r101.y * 3.0f;
        this.f197715e = r104 - r105;
        this.f197716f = r105 - (2.0f * r104);
        this.f197717g = r104;
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r100, PointF r101, PointF r102) {
        PointF r103 = r101;
        PointF r104 = r102;
        float r105 = r103.x;
        float r106 = r105 * 3.0f;
        float r107 = r103.y;
        float r108 = 3.0f * r107;
        PointF r109 = this.f197711a;
        r109.x = (((((((((r104.x - r105) + this.f197712b) * r100) + r106) + this.f197713c) * r100) - r106) + this.f197714d) * r100) + r105;
        r109.y = (r100 * ((((((((r104.y - r107) + this.f197715e) * r100) + r108) + this.f197716f) * r100) - r108) + this.f197717g)) + r107;
        return r109;
    }
}
