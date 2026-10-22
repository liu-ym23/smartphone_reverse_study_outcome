package ol2;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Shader;
import com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements GradientAndItalicTextView.a {
    public final int[] a;
    public final float[] b;
    public final Function2<Integer, Integer, Pair<PointF, PointF>> c;

    @Override // com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView.a
    public final LinearGradient a(int r10, int r11) {
        Function2<Integer, Integer, Pair<PointF, PointF>> r0 = this.c;
        if (r0 == null) goto L6;
        Pair r1 = (Pair) r0.invoke(Integer.valueOf(r10), Integer.valueOf(r11));
        if (r1 == null) goto L6;
    L7:
        PointF r12 = (PointF) r1.component1();
        PointF r13 = (PointF) r1.component2();
        return new LinearGradient(r12.x, r12.y, r13.x, r13.y, this.a, this.b, Shader.TileMode.CLAMP);
    L6:
        r1 = TuplesKt.to(new PointF(0.0f, 0.0f), new PointF(r10, r11));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int[] r2, float[] r3, Function2<? super Integer, ? super Integer, ? extends Pair<? extends PointF, ? extends PointF>> r4) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        Intrinsics.checkNotNullParameter(r3, "gradientPositions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
