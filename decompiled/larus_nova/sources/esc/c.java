package esc;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Paint;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    public static final void a(Canvas r100, MutableRect r101, Paint r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r102, "paint");
        r100.drawRect(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom(), r102);
    }

    public static final void b(Canvas r100, MutableRect r101, Paint r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r102, "paint");
        r100.saveLayer(MutableRectKt.toRect(r101), r102);
    }
}
