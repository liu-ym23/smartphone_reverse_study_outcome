package p19;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.graphics.MatrixKt;
import com.github.alexzhirkevich.customqrgenerator.vector.style.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f527332a;

    public c(float r100) {
        this.f527332a = r100;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
    public final Path a(float r100, com.github.alexzhirkevich.customqrgenerator.style.c r101) {
        Intrinsics.checkNotNullParameter(r101, "neighbors");
        Path r102 = new Path();
        float r103 = r100 / 8.0f;
        r102.addRoundRect(new RectF(0.0f, 0.0f, r100, r100), new float[]{r103, r103, r103, r103, r103, r103, r103, r103}, Path.Direction.CW);
        float r104 = 1;
        float r105 = r104 / ((float) Math.sqrt(2.0f));
        r102.transform(MatrixKt.scaleMatrix(r105, r105));
        float r106 = (r100 * (r104 - r105)) / 2;
        r102.transform(MatrixKt.translationMatrix(r106, r106));
        r102.transform(MatrixKt.scaleMatrix(RangesKt.coerceIn(this.f527332a, 0.0f, 1.0f), RangesKt.coerceIn(this.f527332a, 0.0f, 1.0f)));
        return r102;
    }
}
