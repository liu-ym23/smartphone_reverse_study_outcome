package dj4;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Matrix, Unit> f468918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f468919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f468920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f468921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f468922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f468923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f468924g;

    public final void a() {
        Matrix r100 = this.f468919b;
        r100.setValues(this.f468922e);
        r100.mapRect(this.f468921d, this.f468920c);
        r100.postTranslate(this.f468923f - this.f468921d.centerX(), this.f468924g - this.f468921d.centerY());
        this.f468918a.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Rect r100, float[] r101, Function1<? super Matrix, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "values");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f468918a = r102;
        this.f468919b = new Matrix();
        this.f468920c = new RectF(r100);
        this.f468921d = new RectF();
        this.f468922e = (float[]) r101.clone();
        a();
    }
}
