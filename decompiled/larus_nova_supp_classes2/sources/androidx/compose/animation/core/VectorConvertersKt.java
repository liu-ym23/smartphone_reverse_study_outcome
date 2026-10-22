package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aJ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0006\u001a!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0080\b\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0014\"\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001a\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u001d\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020 8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010!\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020#8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010$\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020&8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010'\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020)8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010*\"!\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020,8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010-\"\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"TwoWayConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "convertToVector", "Lkotlin/Function1;", "convertFromVector", "lerp", "", "start", "stop", "fraction", "VectorConverter", "Landroidx/compose/animation/core/AnimationVector1D;", "Lkotlin/Float$Companion;", "getVectorConverter", "(Lkotlin/jvm/internal/FloatCompanionObject;)Landroidx/compose/animation/core/TwoWayConverter;", "", "Lkotlin/Int$Companion;", "(Lkotlin/jvm/internal/IntCompanionObject;)Landroidx/compose/animation/core/TwoWayConverter;", "FloatToVector", "IntToVector", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "Landroidx/compose/ui/geometry/Rect$Companion;", "(Landroidx/compose/ui/geometry/Rect$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/Dp$Companion;", "(Landroidx/compose/ui/unit/Dp$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/ui/unit/DpOffset$Companion;", "(Landroidx/compose/ui/unit/DpOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/Size$Companion;", "(Landroidx/compose/ui/geometry/Size$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntOffset$Companion;", "(Landroidx/compose/ui/unit/IntOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/IntSize$Companion;", "(Landroidx/compose/ui/unit/IntSize$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "DpToVector", "DpOffsetToVector", "SizeToVector", "OffsetToVector", "IntOffsetToVector", "IntSizeToVector", "RectToVector", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class VectorConvertersKt {
    private static final TwoWayConverter<DpOffset, AnimationVector2D> DpOffsetToVector = null;
    private static final TwoWayConverter<Dp, AnimationVector1D> DpToVector = null;
    private static final TwoWayConverter<Float, AnimationVector1D> FloatToVector = null;
    private static final TwoWayConverter<IntOffset, AnimationVector2D> IntOffsetToVector = null;
    private static final TwoWayConverter<IntSize, AnimationVector2D> IntSizeToVector = null;
    private static final TwoWayConverter<Integer, AnimationVector1D> IntToVector = null;
    private static final TwoWayConverter<Offset, AnimationVector2D> OffsetToVector = null;
    private static final TwoWayConverter<Rect, AnimationVector4D> RectToVector = null;
    private static final TwoWayConverter<Size, AnimationVector2D> SizeToVector = null;

    public static /* synthetic */ float a(AnimationVector1D r0) {
        return FloatToVector$lambda$1(r0);
    }

    public static /* synthetic */ AnimationVector2D b(IntSize r0) {
        return IntSizeToVector$lambda$14(r0);
    }

    public static /* synthetic */ AnimationVector2D c(IntOffset r0) {
        return IntOffsetToVector$lambda$12(r0);
    }

    public static /* synthetic */ AnimationVector4D d(Rect r0) {
        return RectToVector$lambda$16(r0);
    }

    public static /* synthetic */ int e(AnimationVector1D r0) {
        return IntToVector$lambda$3(r0);
    }

    public static /* synthetic */ DpOffset f(AnimationVector2D r0) {
        return DpOffsetToVector$lambda$7(r0);
    }

    public static /* synthetic */ Size g(AnimationVector2D r0) {
        return SizeToVector$lambda$9(r0);
    }

    public static /* synthetic */ AnimationVector2D h(Offset r0) {
        return OffsetToVector$lambda$10(r0);
    }

    public static /* synthetic */ Offset i(AnimationVector2D r0) {
        return OffsetToVector$lambda$11(r0);
    }

    public static /* synthetic */ IntSize j(AnimationVector2D r0) {
        return IntSizeToVector$lambda$15(r0);
    }

    public static /* synthetic */ AnimationVector2D k(DpOffset r0) {
        return DpOffsetToVector$lambda$6(r0);
    }

    public static /* synthetic */ IntOffset l(AnimationVector2D r0) {
        return IntOffsetToVector$lambda$13(r0);
    }

    public static final float lerp(float r1, float r2, float r3) {
        return (r1 * (1 - r3)) + (r2 * r3);
    }

    public static /* synthetic */ Rect m(AnimationVector4D r0) {
        return RectToVector$lambda$17(r0);
    }

    public static /* synthetic */ AnimationVector2D n(Size r0) {
        return SizeToVector$lambda$8(r0);
    }

    public static /* synthetic */ AnimationVector1D o(int r0) {
        return IntToVector$lambda$2(r0);
    }

    public static /* synthetic */ AnimationVector1D p(float r0) {
        return FloatToVector$lambda$0(r0);
    }

    public static /* synthetic */ AnimationVector1D q(Dp r0) {
        return DpToVector$lambda$4(r0);
    }

    public static /* synthetic */ Dp r(AnimationVector1D r0) {
        return DpToVector$lambda$5(r0);
    }

    static {
        FloatToVector = TwoWayConverter(new r0(), new i1());
        IntToVector = TwoWayConverter(new s0(), new t0());
        DpToVector = TwoWayConverter(new u0(), new v0());
        DpOffsetToVector = TwoWayConverter(new w0(), new x0());
        SizeToVector = TwoWayConverter(new y0(), new z0());
        OffsetToVector = TwoWayConverter(new a1(), new b1());
        IntOffsetToVector = TwoWayConverter(new c1(), new d1());
        IntSizeToVector = TwoWayConverter(new e1(), new f1());
        RectToVector = TwoWayConverter(new g1(), new h1());
    }

    private static final AnimationVector2D DpOffsetToVector$lambda$6(DpOffset r4) {
        return new AnimationVector2D(DpOffset.getX-D9Ej5fM(r4.unbox-impl()), DpOffset.getY-D9Ej5fM(r4.unbox-impl()));
    }

    private static final DpOffset DpOffsetToVector$lambda$7(AnimationVector2D r6) {
        float r0 = Dp.constructor-impl(r6.getV1());
        float r7 = Dp.constructor-impl(r6.getV2());
        return DpOffset.box-impl(DpOffset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L)));
    }

    private static final AnimationVector1D DpToVector$lambda$4(Dp r1) {
        return new AnimationVector1D(r1.unbox-impl());
    }

    private static final Dp DpToVector$lambda$5(AnimationVector1D r0) {
        return Dp.box-impl(Dp.constructor-impl(r0.getValue()));
    }

    private static final AnimationVector1D FloatToVector$lambda$0(float r1) {
        return new AnimationVector1D(r1);
    }

    private static final float FloatToVector$lambda$1(AnimationVector1D r0) {
        return r0.getValue();
    }

    private static final AnimationVector2D IntOffsetToVector$lambda$12(IntOffset r4) {
        return new AnimationVector2D(IntOffset.getX-impl(r4.unbox-impl()), IntOffset.getY-impl(r4.unbox-impl()));
    }

    private static final IntOffset IntOffsetToVector$lambda$13(AnimationVector2D r6) {
        int r0 = Math.round(r6.getV1());
        return IntOffset.box-impl(IntOffset.constructor-impl((((long) r0) << 32) | (((long) Math.round(r6.getV2())) & 4294967295L)));
    }

    private static final AnimationVector2D IntSizeToVector$lambda$14(IntSize r6) {
        return new AnimationVector2D((int) (r6.unbox-impl() >> 32), (int) (r6.unbox-impl() & 4294967295L));
    }

    private static final IntSize IntSizeToVector$lambda$15(AnimationVector2D r6) {
        int r0 = Math.round(r6.getV1());
        int r1 = 0;
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        int r7 = Math.round(r6.getV2());
        if (r7 < 0) goto L9;
        r1 = r7;
    L9:
        long r2 = ((long) r0) << 32;
        return IntSize.box-impl(IntSize.constructor-impl((((long) r1) & 4294967295L) | r2));
    }

    private static final AnimationVector1D IntToVector$lambda$2(int r1) {
        return new AnimationVector1D(r1);
    }

    private static final int IntToVector$lambda$3(AnimationVector1D r0) {
        return (int) r0.getValue();
    }

    private static final AnimationVector2D OffsetToVector$lambda$10(Offset r6) {
        return new AnimationVector2D(Float.intBitsToFloat((int) (r6.unbox-impl() >> 32)), Float.intBitsToFloat((int) (r6.unbox-impl() & 4294967295L)));
    }

    private static final Offset OffsetToVector$lambda$11(AnimationVector2D r6) {
        float r0 = r6.getV1();
        float r7 = r6.getV2();
        return Offset.box-impl(Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L)));
    }

    private static final AnimationVector4D RectToVector$lambda$16(Rect r4) {
        return new AnimationVector4D(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
    }

    private static final Rect RectToVector$lambda$17(AnimationVector4D r4) {
        return new Rect(r4.getV1(), r4.getV2(), r4.getV3(), r4.getV4());
    }

    private static final AnimationVector2D SizeToVector$lambda$8(Size r6) {
        return new AnimationVector2D(Float.intBitsToFloat((int) (r6.unbox-impl() >> 32)), Float.intBitsToFloat((int) (r6.unbox-impl() & 4294967295L)));
    }

    private static final Size SizeToVector$lambda$9(AnimationVector2D r6) {
        float r0 = r6.getV1();
        float r7 = r6.getV2();
        return Size.box-impl(Size.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L)));
    }

    public static final TwoWayConverter<Offset, AnimationVector2D> getVectorConverter(Offset.Companion r0) {
        return OffsetToVector;
    }

    public static final TwoWayConverter<Rect, AnimationVector4D> getVectorConverter(Rect.Companion r0) {
        return RectToVector;
    }

    public static final TwoWayConverter<Size, AnimationVector2D> getVectorConverter(Size.Companion r0) {
        return SizeToVector;
    }

    public static final TwoWayConverter<Dp, AnimationVector1D> getVectorConverter(Dp.Companion r0) {
        return DpToVector;
    }

    public static final TwoWayConverter<DpOffset, AnimationVector2D> getVectorConverter(DpOffset.Companion r0) {
        return DpOffsetToVector;
    }

    public static final TwoWayConverter<IntOffset, AnimationVector2D> getVectorConverter(IntOffset.Companion r0) {
        return IntOffsetToVector;
    }

    public static final TwoWayConverter<IntSize, AnimationVector2D> getVectorConverter(IntSize.Companion r0) {
        return IntSizeToVector;
    }

    public static final TwoWayConverter<Float, AnimationVector1D> getVectorConverter(FloatCompanionObject r0) {
        return FloatToVector;
    }

    public static final TwoWayConverter<Integer, AnimationVector1D> getVectorConverter(IntCompanionObject r0) {
        return IntToVector;
    }

    public static final <T, V extends AnimationVector> TwoWayConverter<T, V> TwoWayConverter(Function1<? super T, ? extends V> r1, Function1<? super V, ? extends T> r2) {
        return new TwoWayConverterImpl(r1, r2);
    }
}
