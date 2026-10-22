package com.github.alexzhirkevich.customqrgenerator.dsl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/graphics/Canvas;", "Landroid/graphics/Paint;", "drawPaint", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE, "(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Paint;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class DslExtensionsKt$pathShape$1 extends Lambda implements Function3<Canvas, Paint, Paint, Unit> {
    final /* synthetic */ Function2<Path, Integer, Unit> $builder;

    /* JADX WARN: Multi-variable type inference failed */
    public DslExtensionsKt$pathShape$1(Function2<? super Path, ? super Integer, Unit> r100) {
        this.$builder = r100;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Canvas r100, Paint r101, Paint r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$drawShape");
        Intrinsics.checkNotNullParameter(r101, "drawPaint");
        Intrinsics.checkNotNullParameter(r102, "<anonymous parameter 1>");
        Path r103 = new Path();
        this.$builder.invoke(r103, Integer.valueOf(Math.min(r100.getWidth(), r100.getHeight())));
        r100.drawPath(r103, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Canvas r100, Paint r101, Paint r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
