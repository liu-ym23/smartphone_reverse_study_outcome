package com.ss.android.lark.image.compose.common;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0005H\u0014J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0014R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/image/compose/common/CirclePlaceholderPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "", "strokeColor", "<init>", "(JFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyAlpha", "", "applyColorFilter", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CirclePlaceholderPainter extends Painter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f426252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f426253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f426254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f426255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f426256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorFilter f426257f;

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo5530getIntrinsicSizeNHjbRc() {
        return this.f426255d;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float r100) {
        this.f426256e = r100;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(ColorFilter r100) {
        this.f426257f = r100;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(DrawScope r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        float r110 = 2;
        float r100 = RangesKt.coerceAtMost(Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() >> 32)), Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax))) / r110;
        float r111 = Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() >> 32)) / r110;
        float r112 = Float.intBitsToFloat((int) (r210.mo5322getSizeNHjbRc() & BodyPartID.bodyIdMax)) / r110;
        DrawScope.CC.m5394drawCircleVaOC9Bg$default(r210, this.f426252a, r100, Offset.m4574constructorimpl((Float.floatToRawIntBits(r111) << 32) | (((long) Float.floatToRawIntBits(r112)) & BodyPartID.bodyIdMax)), this.f426256e, null, this.f426257f, 0, 80, null);
        float r101 = this.f426253b;
        if (r101 <= 0.0f) goto L6;
        DrawScope.CC.m5394drawCircleVaOC9Bg$default(r210, this.f426254c, r100 - (r101 / r110), Offset.m4574constructorimpl((Float.floatToRawIntBits(r111) << 32) | (((long) Float.floatToRawIntBits(r112)) & BodyPartID.bodyIdMax)), this.f426256e, new Stroke(this.f426253b, 0.0f, 0, 0, null, 30, null), this.f426257f, 0, 64, null);
        return;
    }

    public CirclePlaceholderPainter(long r100, float r101, long r102) {
        this.f426252a = r100;
        this.f426253b = r101;
        this.f426254c = r102;
        this.f426255d = Size.Companion.m4659getUnspecifiedNHjbRc();
        this.f426256e = 1.0f;
    }
}
