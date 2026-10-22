package esc;

import android.graphics.Matrix;
import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Paint;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static final void b(Matrix r210, float[] r211) {
        Intrinsics.checkNotNullParameter(r210, "$this$setFromInternal");
        Intrinsics.checkNotNullParameter(r211, "matrix");
        float r100 = r211[0];
        float r101 = r211[1];
        float r102 = r211[2];
        float r103 = r211[3];
        float r110 = r211[4];
        float r111 = r211[5];
        float r112 = r211[6];
        float r113 = r211[7];
        float r114 = r211[8];
        float r212 = r211[12];
        float r213 = r211[13];
        float r214 = r211[15];
        r211[0] = r100;
        r211[1] = r110;
        r211[2] = r212;
        r211[3] = r101;
        r211[4] = r111;
        r211[5] = r213;
        r211[6] = r103;
        r211[7] = r113;
        r211[8] = r214;
        r210.setValues(r211);
        r211[0] = r100;
        r211[1] = r101;
        r211[2] = r102;
        r211[3] = r103;
        r211[4] = r110;
        r211[5] = r111;
        r211[6] = r112;
        r211[7] = r113;
        r211[8] = r114;
    }

    public static final void a(Canvas r110, MutableRect r111, Paint r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r112, "paint");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        AndroidCanvas_androidKt.getNativeCanvas(r110).saveLayer(r111.getLeft(), r111.getTop(), r111.getRight(), r111.getBottom(), r112.asFrameworkPaint(), 19);
        return;
    L5:
        AndroidCanvas_androidKt.getNativeCanvas(r110).saveLayer(r111.getLeft(), r111.getTop(), r111.getRight(), r111.getBottom(), r112.asFrameworkPaint());
    }
}
