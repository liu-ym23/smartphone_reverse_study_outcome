package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/AnimationDataConverter;", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/foundation/gestures/AnimationData;", "Landroidx/compose/animation/core/AnimationVector4D;", "<init>", "()V", "convertToVector", "Lkotlin/Function1;", "getConvertToVector", "()Lkotlin/jvm/functions/Function1;", "convertFromVector", "getConvertFromVector", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnimationDataConverter implements TwoWayConverter<AnimationData, AnimationVector4D> {
    public static final AnimationDataConverter INSTANCE = null;

    static {
        INSTANCE = new AnimationDataConverter();
    }

    private AnimationDataConverter() {
    }

    public static /* synthetic */ AnimationData a(AnimationVector4D r0) {
        return _get_convertFromVector_$lambda$1(r0);
    }

    public static /* synthetic */ AnimationVector4D b(AnimationData r0) {
        return _get_convertToVector_$lambda$0(r0);
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1<AnimationVector4D, AnimationData> getConvertFromVector() {
        return new a0();
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1<AnimationData, AnimationVector4D> getConvertToVector() {
        return new z();
    }

    private static final AnimationData _get_convertFromVector_$lambda$1(AnimationVector4D r9) {
        float r1 = r9.getV1();
        float r0 = r9.getV2();
        float r2 = r9.getV3();
        return new AnimationData(r1, Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (4294967295L & Float.floatToRawIntBits(r2))), r9.getV4(), null);
    }

    private static final AnimationVector4D _get_convertToVector_$lambda$0(AnimationData r7) {
        return new AnimationVector4D(r7.getZoom(), Float.intBitsToFloat((int) (r7.m550getOffsetF1C5BW0() >> 32)), Float.intBitsToFloat((int) (r7.m550getOffsetF1C5BW0() & 4294967295L)), r7.getDegrees());
    }
}
