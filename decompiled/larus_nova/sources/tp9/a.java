package tp9;

import android.animation.TypeEvaluator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements TypeEvaluator<float[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f547063a;

    public a(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "mArray");
        this.f547063a = r100;
    }

    @Override // android.animation.TypeEvaluator
    public final float[] evaluate(float r100, float[] r101, float[] r102) {
        float[] r103 = r101;
        float[] r104 = r102;
        Intrinsics.checkNotNullParameter(r103, "startValue");
        Intrinsics.checkNotNullParameter(r104, "endValue");
        float[] r105 = this.f547063a;
        int r106 = r105.length;
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L5;
        float r108 = r103[r107];
        r105[r107] = r108 + ((r104[r107] - r108) * r100);
        r107 = r107 + 1;
        goto L3
    L5:
        return r105;
    }
}
