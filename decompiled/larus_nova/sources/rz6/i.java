package rz6;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements m<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f539964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f539965b;

    @Override // rz6.m
    public final oz6.a<PointF, PointF> a() {
        oz6.a<Float, Float> r100 = this.f539964a.a();
        return new oz6.m((oz6.c) r100, (oz6.c) this.f539965b.a());
    }

    public i(b r100, b r101) {
        this.f539964a = r100;
        this.f539965b = r101;
    }
}
