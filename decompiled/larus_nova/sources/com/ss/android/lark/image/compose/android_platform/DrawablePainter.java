package com.ss.android.lark.image.compose.android_platform;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\u0012\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0014J\f\u0010/\u001a\u00020 *\u000200H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010-\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0015¨\u00061"}, d2 = {"Lcom/ss/android/lark/image/compose/android_platform/DrawablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "<set-?>", "", "drawInvalidateTick", "getDrawInvalidateTick", "()I", "setDrawInvalidateTick", "(I)V", "drawInvalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/geometry/Size;", "drawableIntrinsicSize", "getDrawableIntrinsicSize-NH-jbRc", "()J", "setDrawableIntrinsicSize-uvyYCjk", "(J)V", "drawableIntrinsicSize$delegate", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "callback$delegate", "Lkotlin/Lazy;", "onRemembered", "", "onAbandoned", "onForgotten", "applyAlpha", "", "alpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyLayoutDirection", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrawablePainter extends Painter implements RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f426226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableState f426227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableState f426228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f426229d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f426230a = null;

        static {
            int[] r100 = new int[LayoutDirection.values().length];
            r100[LayoutDirection.Ltr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LayoutDirection.Rtl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f426230a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo5530getIntrinsicSizeNHjbRc() {
        return ((Size) this.f426228c.getValue()).m4656unboximpl();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        Object r100 = this.f426226a;
        if ((r100 instanceof Animatable) == false) goto L5;
        ((Animatable) r100).stop();
    L5:
        this.f426226a.setVisible(false, false);
        this.f426226a.setCallback(null);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        this.f426226a.setCallback((Drawable.Callback) this.f426229d.getValue());
        this.f426226a.setVisible(true, true);
        Object r100 = this.f426226a;
        if ((r100 instanceof Animatable) == false) goto L6;
        ((Animatable) r100).start();
        return;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        onForgotten();
    }

    public DrawablePainter(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f426226a = r100;
        this.f426227b = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.f426228c = SnapshotStateKt.mutableStateOf$default(Size.m4639boximpl(BaseImageComponentKt.b(r100)), null, 2, null);
        this.f426229d = LazyKt.lazy(new DrawablePainter$callback$2(this));
        if (r100.getIntrinsicWidth() >= 0) goto L5;
        return;
    L5:
        if (r100.getIntrinsicHeight() < 0) goto L9;
        r100.setBounds(0, 0, r100.getIntrinsicWidth(), r100.getIntrinsicHeight());
        return;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float r100) {
        this.f426226a.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(r100 * 255), 0, 255));
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(ColorFilter r100) {
        Drawable r101 = this.f426226a;
        if (r100 == null) goto L5;
        android.graphics.ColorFilter r102 = AndroidColorFilter_androidKt.asAndroidColorFilter(r100);
    L6:
        r101.setColorFilter(r102);
        return true;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyLayoutDirection(LayoutDirection r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutDirection");
        int r101 = 0;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        Drawable r102 = this.f426226a;
        int r103 = a.f426230a[r100.ordinal()];
        if (r103 == 1) goto L12;
        if (r103 != 2) goto L10;
        r101 = 1;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        return r102.setLayoutDirection(r101);
    L13:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(DrawScope r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Canvas r101 = r100.getDrawContext().getCanvas();
        ((Number) this.f426227b.getValue()).intValue();
        this.f426226a.setBounds(0, 0, MathKt.roundToInt(Float.intBitsToFloat((int) (r100.mo5322getSizeNHjbRc() >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (r100.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax))));
        r101.save();     // Catch: Throwable -> L6
        this.f426226a.draw(AndroidCanvas_androidKt.getNativeCanvas(r101));     // Catch: Throwable -> L6
        r101.restore();
        return;
    L6:
        th = move-exception;
        r101.restore();
        throw th;
    }
}
