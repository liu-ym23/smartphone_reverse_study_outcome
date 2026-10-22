package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class SliderKt$RangeSlider$2$3$1 extends FunctionReferenceImpl implements Function1<Float, Float> {
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    public SliderKt$RangeSlider$2$3$1(ClosedFloatingPointRange<Float> r7, Ref.FloatRef r8, Ref.FloatRef r9) {
        this.$valueRange = r7;
        this.$minPx = r8;
        this.$maxPx = r9;
        super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
    }

    public final Float invoke(float r4) {
        return Float.valueOf(SliderKt.AnonymousClass2.access$invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, r4));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).floatValue());
    }
}
