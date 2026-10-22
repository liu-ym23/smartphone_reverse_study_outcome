package ol2;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Shader;
import com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements GradientAndItalicTextView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f524135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f524136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Integer, Integer, Pair<PointF, PointF>> f524137c;

    @Override // com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView.a
    public final LinearGradient a(int r110, int r111) {
        Function2<Integer, Integer, Pair<PointF, PointF>> r100 = this.f524137c;
        if (r100 == null) goto L6;
        Pair<PointF, PointF> r101 = r100.invoke(Integer.valueOf(r110), Integer.valueOf(r111));
        if (r101 == null) goto L6;
    L7:
        PointF r112 = r101.component1();
        PointF r113 = r101.component2();
        return new LinearGradient(r112.x, r112.y, r113.x, r113.y, this.f524135a, this.f524136b, Shader.TileMode.CLAMP);
    L6:
        r101 = TuplesKt.to(new PointF(0.0f, 0.0f), new PointF(r110, r111));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int[] r100, float[] r101, Function2<? super Integer, ? super Integer, ? extends Pair<? extends PointF, ? extends PointF>> r102) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        Intrinsics.checkNotNullParameter(r101, "gradientPositions");
        this.f524135a = r100;
        this.f524136b = r101;
        this.f524137c = r102;
    }
}
