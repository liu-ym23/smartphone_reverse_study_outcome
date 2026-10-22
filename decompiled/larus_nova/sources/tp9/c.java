package tp9;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Matrix, Unit> f547066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f547067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f547068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f547069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f547070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f547071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f547072g;

    public final void a() {
        Matrix r100 = this.f547067b;
        r100.setValues(this.f547070e);
        r100.mapRect(this.f547069d, this.f547068c);
        r100.postTranslate(this.f547071f - this.f547069d.centerX(), this.f547072g - this.f547069d.centerY());
        this.f547066a.invoke(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Rect r100, float[] r101, Function1<? super Matrix, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "values");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f547066a = r102;
        this.f547067b = new Matrix();
        this.f547068c = new RectF(r100);
        this.f547069d = new RectF();
        this.f547070e = (float[]) r101.clone();
        a();
    }
}
