package n0;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes28.dex */
public final class i implements m<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f516552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f516553b;

    @Override // n0.m
    public final j0.a<PointF, PointF> a() {
        j0.a<Float, Float> r100 = this.f516552a.a();
        return new j0.m((j0.c) r100, (j0.c) this.f516553b.a());
    }

    public i(b r100, b r101) {
        this.f516552a = r100;
        this.f516553b = r101;
    }
}
