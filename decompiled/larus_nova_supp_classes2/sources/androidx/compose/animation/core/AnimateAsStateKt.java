package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aW\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u000e\u001aO\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0005\u001a\u00020\u00102\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aO\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0005\u001a\u00020\u00152\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aO\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0005\u001a\u00020\u001a2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u001b\u0010\u0017\u001aM\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010\u0005\u001a\u00020\u001e2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u001f\u001aM\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00042\u0006\u0010\u0005\u001a\u00020\"2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\"0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010#\u001aO\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00042\u0006\u0010\u0005\u001a\u00020&2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020&0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b'\u0010\u0017\u001aO\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00042\u0006\u0010\u0005\u001a\u00020*2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020*0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b+\u0010\u0017\u001a}\u0010-\u001a\b\u0012\u0004\u0012\u0002H.0\u0004\"\u0004\b\u0000\u0010.\"\b\b\u0001\u0010/*\u0002002\u0006\u0010\u0005\u001a\u0002H.2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H.0\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H.2\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u00103\u001aM\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00022\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u00104\u001aE\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0005\u001a\u00020\u00102\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b5\u00106\u001aE\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0005\u001a\u00020\u00152\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b7\u00108\u001aE\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0005\u001a\u00020\u001a2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b9\u00108\u001aC\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010\u0005\u001a\u00020\u001e2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010:\u001aC\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00042\u0006\u0010\u0005\u001a\u00020\"2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\"0\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010;\u001aE\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00042\u0006\u0010\u0005\u001a\u00020&2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020&0\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b<\u00108\u001aE\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00042\u0006\u0010\u0005\u001a\u00020*2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020*0\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b=\u00108\u001as\u0010-\u001a\b\u0012\u0004\u0012\u0002H.0\u0004\"\u0004\b\u0000\u0010.\"\b\b\u0001\u0010/*\u0002002\u0006\u0010\u0005\u001a\u0002H.2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H.0\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H.2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0002\u0010>\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?²\u0006\u001e\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u00020\r\u0018\u00010\f\"\u0004\b\u0000\u0010.X\u008a\u0084\u0002²\u0006\u0016\u0010A\u001a\b\u0012\u0004\u0012\u0002H.0\u0007\"\u0004\b\u0000\u0010.X\u008a\u0084\u0002"}, d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "animateFloatAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "visibilityThreshold", "label", "", "finishedListener", "Lkotlin/Function1;", "", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDpAsState", "Landroidx/compose/ui/unit/Dp;", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "dpDefaultSpring", "animateSizeAsState", "Landroidx/compose/ui/geometry/Size;", "animateSizeAsState-YLp_XPw", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "sizeDefaultSpring", "animateOffsetAsState", "Landroidx/compose/ui/geometry/Offset;", "animateOffsetAsState-7362WCg", "offsetDefaultSpring", "animateRectAsState", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "rectDefaultSpring", "animateIntAsState", "", "(ILandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intDefaultSpring", "animateIntOffsetAsState", "Landroidx/compose/ui/unit/IntOffset;", "animateIntOffsetAsState-HyPO7BM", "intOffsetDefaultSpring", "animateIntSizeAsState", "Landroidx/compose/ui/unit/IntSize;", "animateIntSizeAsState-4goxYXU", "intSizeDefaultSpring", "animateValueAsState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState-LjSzlW0", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateOffsetAsState-N6fFfp4", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState-8f6pmRE", "animateIntSizeAsState-zTRF_AQ", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core", "listener", "animSpec"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimateAsStateKt {
    private static final SpringSpec<Float> defaultAnimation = null;
    private static final SpringSpec<Dp> dpDefaultSpring = null;
    private static final SpringSpec<Integer> intDefaultSpring = null;
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = null;
    private static final SpringSpec<IntSize> intSizeDefaultSpring = null;
    private static final SpringSpec<Offset> offsetDefaultSpring = null;
    private static final SpringSpec<Rect> rectDefaultSpring = null;
    private static final SpringSpec<Size> sizeDefaultSpring = null;

    static {
        defaultAnimation = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
        dpDefaultSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Dp.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion)), 3, null);
        sizeDefaultSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Size.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Size.Companion)), 3, null);
        offsetDefaultSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Offset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.Companion)), 3, null);
        rectDefaultSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, null);
        intDefaultSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, null);
        intOffsetDefaultSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
        intSizeDefaultSpring = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, null);
    }

    public static /* synthetic */ Unit a(Channel r0, Object r1) {
        return animateValueAsState$lambda$9$lambda$8(r0, r1);
    }

    public static final /* synthetic */ Function1 access$animateValueAsState$lambda$4(State r0) {
        return animateValueAsState$lambda$4(r0);
    }

    public static final /* synthetic */ AnimationSpec access$animateValueAsState$lambda$6(State r0) {
        return animateValueAsState$lambda$6(r0);
    }

    private static final <T> Function1<T, Unit> animateValueAsState$lambda$4(State<? extends Function1<? super T, Unit>> r0) {
        return (Function1) r0.getValue();
    }

    private static final <T> AnimationSpec<T> animateValueAsState$lambda$6(State<? extends AnimationSpec<T>> r0) {
        return (AnimationSpec) r0.getValue();
    }

    private static final Unit animateValueAsState$lambda$9$lambda$8(Channel r0, Object r1) {
        r0.trySend-JP2dKIU(r1);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateDpAsState-Kz89ssw, reason: not valid java name */
    public static final /* synthetic */ State m239animateDpAsStateKz89ssw(float r9, AnimationSpec r10, Function1 r11, Composer r12, int r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r10 = dpDefaultSpring;
    L5:
        AnimationSpec r2 = r10;
        if ((r14 & 4) == 0) goto L8;
        r11 = null;
    L8:
        Function1 r5 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(704104481, r13, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:462)");
    L11:
        State r15 = animateValueAsState(Dp.box-impl(r9), VectorConvertersKt.getVectorConverter(Dp.Companion), r2, null, null, r5, r12, ((r13 & 14) | ((r13 << 3) & 896)) | ((r13 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r15;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateIntAsState(int r9, AnimationSpec r10, Function1 r11, Composer r12, int r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r10 = intDefaultSpring;
    L5:
        AnimationSpec r2 = r10;
        if ((r14 & 4) == 0) goto L8;
        r11 = null;
    L8:
        Function1 r5 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-842612981, r13, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:534)");
    L11:
        State r15 = animateValueAsState(Integer.valueOf(r9), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), r2, null, null, r5, r12, ((r13 & 14) | ((r13 << 3) & 896)) | ((r13 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r15;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateIntOffsetAsState-8f6pmRE, reason: not valid java name */
    public static final /* synthetic */ State m240animateIntOffsetAsState8f6pmRE(long r9, AnimationSpec r11, Function1 r12, Composer r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r11 = intOffsetDefaultSpring;
    L5:
        AnimationSpec r2 = r11;
        if ((r15 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Function1 r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(1010307371, r14, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:552)");
    L11:
        State r10 = animateValueAsState(IntOffset.box-impl(r9), VectorConvertersKt.getVectorConverter(IntOffset.Companion), r2, null, null, r5, r13, ((r14 & 14) | ((r14 << 3) & 896)) | ((r14 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r10;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateIntSizeAsState-zTRF_AQ, reason: not valid java name */
    public static final /* synthetic */ State m243animateIntSizeAsStatezTRF_AQ(long r9, AnimationSpec r11, Function1 r12, Composer r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r11 = intSizeDefaultSpring;
    L5:
        AnimationSpec r2 = r11;
        if ((r15 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Function1 r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1749239765, r14, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:570)");
    L11:
        State r10 = animateValueAsState(IntSize.box-impl(r9), VectorConvertersKt.getVectorConverter(IntSize.Companion), r2, null, null, r5, r13, ((r14 & 14) | ((r14 << 3) & 896)) | ((r14 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r10;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateOffsetAsState-N6fFfp4, reason: not valid java name */
    public static final /* synthetic */ State m245animateOffsetAsStateN6fFfp4(long r9, AnimationSpec r11, Function1 r12, Composer r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r11 = offsetDefaultSpring;
    L5:
        AnimationSpec r2 = r11;
        if ((r15 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Function1 r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-456513133, r14, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:498)");
    L11:
        State r10 = animateValueAsState(Offset.box-impl(r9), VectorConvertersKt.getVectorConverter(Offset.Companion), r2, null, null, r5, r13, ((r14 & 14) | ((r14 << 3) & 896)) | ((r14 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r10;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateRectAsState(Rect r9, AnimationSpec r10, Function1 r11, Composer r12, int r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r10 = rectDefaultSpring;
    L5:
        AnimationSpec r2 = r10;
        if ((r14 & 4) == 0) goto L8;
        r11 = null;
    L8:
        Function1 r5 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-782613967, r13, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:516)");
    L11:
        State r15 = animateValueAsState(r9, VectorConvertersKt.getVectorConverter(Rect.Companion), r2, null, null, r5, r12, ((r13 & 14) | ((r13 << 3) & 896)) | ((r13 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r15;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateSizeAsState-LjSzlW0, reason: not valid java name */
    public static final /* synthetic */ State m246animateSizeAsStateLjSzlW0(long r9, AnimationSpec r11, Function1 r12, Composer r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r11 = sizeDefaultSpring;
    L5:
        AnimationSpec r2 = r11;
        if ((r15 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Function1 r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(875212471, r14, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:480)");
    L11:
        State r10 = animateValueAsState(Size.box-impl(r9), VectorConvertersKt.getVectorConverter(Size.Companion), r2, null, null, r5, r13, ((r14 & 14) | ((r14 << 3) & 896)) | ((r14 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r10;
    }

    /* JADX INFO: renamed from: animateDpAsState-AjpBEmI, reason: not valid java name */
    public static final State<Dp> m238animateDpAsStateAjpBEmI(float r9, AnimationSpec<Dp> r10, String r11, Function1<? super Dp, Unit> r12, Composer r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r10 = dpDefaultSpring;
    L5:
        AnimationSpec<Dp> r2 = r10;
        if ((r15 & 4) == 0) goto L8;
        r11 = "DpAnimation";
    L8:
        String r4 = r11;
        if ((r15 & 8) == 0) goto L11;
        r12 = null;
    L11:
        Function1<? super Dp, Unit> r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(-1407150062, r14, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:111)");
    L14:
        Dp r0 = Dp.box-impl(r9);
        TwoWayConverter<Dp, AnimationVector1D> r1 = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int r16 = (r14 & 14) | ((r14 << 3) & 896);
        int r17 = r14 << 6;
        State<Dp> r18 = animateValueAsState(r0, r1, r2, null, r4, r5, r13, (r16 | (57344 & r17)) | (r17 & 458752), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r18;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloatAsState(float r8, AnimationSpec r9, float r10, Function1 r11, Composer r12, int r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r9 = defaultAnimation;
    L5:
        AnimationSpec r1 = r9;
        if ((r14 & 4) == 0) goto L8;
        float r2 = 0.01f;
    L10:
        if ((r14 & 8) == 0) goto L12;
        r11 = null;
    L12:
        Function1 r4 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventStart(1091643291, r13, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:446)");
    L15:
        State<Float> r15 = animateFloatAsState(r8, r1, r2, null, r4, r12, (((r13 & 14) | (r13 & 112)) | (r13 & 896)) | ((r13 << 3) & 57344), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L18;
        ComposerKt.traceEventEnd();
    L18:
        return r15;
    L8:
        r2 = r10;
        goto L10
    }

    public static final State<Integer> animateIntAsState(int r9, AnimationSpec<Integer> r10, String r11, Function1<? super Integer, Unit> r12, Composer r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r10 = intDefaultSpring;
    L5:
        AnimationSpec<Integer> r2 = r10;
        if ((r15 & 4) == 0) goto L8;
        r11 = "IntAnimation";
    L8:
        String r4 = r11;
        if ((r15 & 8) == 0) goto L11;
        r12 = null;
    L11:
        Function1<? super Integer, Unit> r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(428074472, r14, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:270)");
    L14:
        Integer r0 = Integer.valueOf(r9);
        TwoWayConverter<Integer, AnimationVector1D> r1 = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int r16 = (r14 & 14) | ((r14 << 3) & 896);
        int r17 = r14 << 6;
        State<Integer> r18 = animateValueAsState(r0, r1, r2, null, r4, r5, r13, (r16 | (57344 & r17)) | (r17 & 458752), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r18;
    }

    /* JADX INFO: renamed from: animateIntOffsetAsState-HyPO7BM, reason: not valid java name */
    public static final State<IntOffset> m241animateIntOffsetAsStateHyPO7BM(long r11, AnimationSpec<IntOffset> r13, String r14, Function1<? super IntOffset, Unit> r15, Composer r16, int r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        AnimationSpec<IntOffset> r4 = intOffsetDefaultSpring;
    L7:
        if ((r18 & 4) == 0) goto L9;
        String r6 = "IntOffsetAnimation";
    L11:
        if ((r18 & 8) == 0) goto L13;
        Function1<? super IntOffset, Unit> r7 = null;
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-696782904, r17, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:309)");
    L17:
        int r0 = r17 << 6;
        State<IntOffset> r1 = animateValueAsState(IntOffset.box-impl(r11), VectorConvertersKt.getVectorConverter(IntOffset.Companion), r4, null, r6, r7, r16, (((r17 & 14) | ((r17 << 3) & 896)) | (57344 & r0)) | (r0 & 458752), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r1;
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: animateIntSizeAsState-4goxYXU, reason: not valid java name */
    public static final State<IntSize> m242animateIntSizeAsState4goxYXU(long r11, AnimationSpec<IntSize> r13, String r14, Function1<? super IntSize, Unit> r15, Composer r16, int r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        AnimationSpec<IntSize> r4 = intSizeDefaultSpring;
    L7:
        if ((r18 & 4) == 0) goto L9;
        String r6 = "IntSizeAnimation";
    L11:
        if ((r18 & 8) == 0) goto L13;
        Function1<? super IntSize, Unit> r7 = null;
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(582576328, r17, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:347)");
    L17:
        int r0 = r17 << 6;
        State<IntSize> r1 = animateValueAsState(IntSize.box-impl(r11), VectorConvertersKt.getVectorConverter(IntSize.Companion), r4, null, r6, r7, r16, (((r17 & 14) | ((r17 << 3) & 896)) | (57344 & r0)) | (r0 & 458752), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r1;
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: animateOffsetAsState-7362WCg, reason: not valid java name */
    public static final State<Offset> m244animateOffsetAsState7362WCg(long r11, AnimationSpec<Offset> r13, String r14, Function1<? super Offset, Unit> r15, Composer r16, int r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        AnimationSpec<Offset> r4 = offsetDefaultSpring;
    L7:
        if ((r18 & 4) == 0) goto L9;
        String r6 = "OffsetAnimation";
    L11:
        if ((r18 & 8) == 0) goto L13;
        Function1<? super Offset, Unit> r7 = null;
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(357896800, r17, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:191)");
    L17:
        int r0 = r17 << 6;
        State<Offset> r1 = animateValueAsState(Offset.box-impl(r11), VectorConvertersKt.getVectorConverter(Offset.Companion), r4, null, r6, r7, r16, (((r17 & 14) | ((r17 << 3) & 896)) | (57344 & r0)) | (r0 & 458752), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r1;
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public static final State<Rect> animateRectAsState(Rect r9, AnimationSpec<Rect> r10, String r11, Function1<? super Rect, Unit> r12, Composer r13, int r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r10 = rectDefaultSpring;
    L5:
        AnimationSpec<Rect> r2 = r10;
        if ((r15 & 4) == 0) goto L8;
        r11 = "RectAnimation";
    L8:
        String r4 = r11;
        if ((r15 & 8) == 0) goto L11;
        r12 = null;
    L11:
        Function1<? super Rect, Unit> r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(536062978, r14, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:232)");
    L14:
        TwoWayConverter<Rect, AnimationVector4D> r1 = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int r16 = (r14 & 14) | ((r14 << 3) & 896);
        int r17 = r14 << 6;
        State<Rect> r18 = animateValueAsState(r9, r1, r2, null, r4, r5, r13, (r16 | (57344 & r17)) | (r17 & 458752), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r18;
    }

    /* JADX INFO: renamed from: animateSizeAsState-YLp_XPw, reason: not valid java name */
    public static final State<Size> m247animateSizeAsStateYLp_XPw(long r11, AnimationSpec<Size> r13, String r14, Function1<? super Size, Unit> r15, Composer r16, int r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        AnimationSpec<Size> r4 = sizeDefaultSpring;
    L7:
        if ((r18 & 4) == 0) goto L9;
        String r6 = "SizeAnimation";
    L11:
        if ((r18 & 8) == 0) goto L13;
        Function1<? super Size, Unit> r7 = null;
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(1374633148, r17, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:152)");
    L17:
        int r0 = r17 << 6;
        State<Size> r1 = animateValueAsState(Size.box-impl(r11), VectorConvertersKt.getVectorConverter(Size.Companion), r4, null, r6, r7, r16, (((r17 & 14) | ((r17 << 3) & 896)) | (57344 & r0)) | (r0 & 458752), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r1;
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public static final State<Float> animateFloatAsState(float r11, AnimationSpec<Float> r12, float r13, String r14, Function1<? super Float, Unit> r15, Composer r16, int r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        AnimationSpec<Float> r1 = defaultAnimation;
    L7:
        if ((r18 & 4) == 0) goto L9;
        float r2 = 0.01f;
    L11:
        if ((r18 & 8) == 0) goto L13;
        String r4 = "FloatAnimation";
    L15:
        if ((r18 & 16) == 0) goto L17;
        Function1<? super Float, Unit> r7 = null;
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L22;
        ComposerKt.traceEventStart(668842840, r17, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:67)");
    L22:
        if (r1 != defaultAnimation) goto L37;
        r16.startReplaceGroup(1144108831);
        if (((r17 & 896) ^ 384) <= 256) goto L28;
        if (r16.changed(r2) == false) goto L28;
    L29:
        boolean r3 = true;
    L31:
        Object r5 = r16.rememberedValue();
        if (r3 == false) goto L34;
    L35:
        r5 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Float.valueOf(r2), 3, null);
        r16.updateRememberedValue(r5);
    L36:
        AnimationSpec<Float> r6 = (SpringSpec) r5;
        r16.endReplaceGroup();
    L38:
        int r0 = r17 << 3;
        State<Float> r8 = animateValueAsState(Float.valueOf(r11), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), r6, Float.valueOf(r2), r4, r7, r16, (((r17 & 14) | (r0 & 7168)) | (57344 & r0)) | (r0 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventEnd();
    L41:
        return r8;
    L34:
        if (r5 != Composer.Companion.getEmpty()) goto L36;
    L28:
        if ((r17 & 384) == 256) goto L29;
        r3 = false;
        goto L31
    L37:
        r16.startReplaceGroup(1144218757);
        r16.endReplaceGroup();
        r6 = r1;
        goto L38
    L17:
        r7 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValueAsState(Object r12, TwoWayConverter r13, AnimationSpec r14, Object r15, Function1 r16, Composer r17, int r18, int r19) {
        if ((r19 & 4) == 0) goto L9;
        Object r1 = r17.rememberedValue();
        if (r1 != Composer.Companion.getEmpty()) goto L8;
        r1 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
        r17.updateRememberedValue(r1);
    L8:
        AnimationSpec r5 = (SpringSpec) r1;
    L11:
        if ((r19 & 8) == 0) goto L13;
        Object r6 = null;
    L15:
        if ((r19 & 16) == 0) goto L17;
        Function1 r8 = null;
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-846382129, r18, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:591)");
    L21:
        int r2 = r18 & 8;
        State r0 = animateValueAsState(r12, r13, r5, r6, "ValueAnimation", r8, r17, (((r2 << 9) | ((((r2 | 24576) | (r18 & 14)) | (r18 & 112)) | (r18 & 896))) | (r18 & 7168)) | ((r18 << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r0;
    L17:
        r8 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    }

    public static final <T, V extends AnimationVector> State<T> animateValueAsState(final T r14, TwoWayConverter<T, V> r15, AnimationSpec<T> r16, T r17, String r18, Function1<? super T, Unit> r19, Composer r20, int r21, int r22) {
        if ((r22 & 4) == 0) goto L8;
        Object r3 = r20.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L7;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
        r20.updateRememberedValue(r3);
    L7:
        AnimationSpec<T> r4 = (SpringSpec) r3;
    L10:
        if ((r22 & 8) == 0) goto L12;
        T r5 = null;
    L14:
        if ((r22 & 16) == 0) goto L16;
        String r6 = "ValueAnimation";
    L18:
        if ((r22 & 32) == 0) goto L20;
        Function1<? super T, Unit> r7 = null;
    L22:
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventStart(-1994373980, r21, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:395)");
    L24:
        Object r8 = r20.rememberedValue();
        Composer.Companion r10 = Composer.Companion;
        if (r8 != r10.getEmpty()) goto L27;
        r8 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r20.updateRememberedValue(r8);
    L27:
        MutableState r9 = (MutableState) r8;
        Object r11 = r20.rememberedValue();
        if (r11 != r10.getEmpty()) goto L30;
        r11 = new Animatable(r14, r15, r5, r6);
        r20.updateRememberedValue(r11);
    L30:
        Animatable r12 = (Animatable) r11;
        State r13 = SnapshotStateKt.rememberUpdatedState(r7, r20, (r21 >> 15) & 14);
        if (r5 != null) goto L33;
    L37:
        State r23 = SnapshotStateKt.rememberUpdatedState(r4, r20, 0);
        Object r24 = r20.rememberedValue();
        if (r24 != r10.getEmpty()) goto L40;
        r24 = ChannelKt.Channel$default(-1, null, null, 6, null);
        r20.updateRememberedValue(r24);
    L40:
        final Channel r25 = (Channel) r24;
        boolean r26 = r20.changedInstance(r25);
        if (((r21 & 14) ^ 6) <= 4) goto L45;
        if (r20.changedInstance(r14) == false) goto L45;
    L46:
        boolean r2 = true;
    L48:
        boolean r27 = r2 | r26;
        Object r28 = r20.rememberedValue();
        if (r27 == false) goto L51;
    L52:
        r28 = new b(r25, r14);
        r20.updateRememberedValue(r28);
    L53:
        EffectsKt.SideEffect((Function0) r28, r20, 0);
        boolean r0 = ((r20.changedInstance(r25) | r20.changedInstance(r12)) | r20.changed(r23)) | r20.changed(r13);
        Object r29 = r20.rememberedValue();
        if (r0 == false) goto L56;
    L57:
        r29 = new AnimateAsStateKt$animateValueAsState$3$1(r25, r12, r23, r13, null);
        r20.updateRememberedValue(r29);
    L58:
        EffectsKt.LaunchedEffect(r25, (Function2) r29, r20, 0);
        State<T> r1 = (State) r9.getValue();
        if (r1 != null) goto L62;
        r1 = r12.asState();
    L62:
        if (ComposerKt.isTraceInProgress() == false) goto L64;
        ComposerKt.traceEventEnd();
    L64:
        return r1;
    L56:
        if (r29 != r10.getEmpty()) goto L58;
    L51:
        if (r28 != r10.getEmpty()) goto L53;
    L45:
        if ((r21 & 6) == 4) goto L46;
        r2 = false;
        goto L48
    L33:
        if ((r4 instanceof SpringSpec) == false) goto L37;
        SpringSpec r30 = (SpringSpec) r4;
        if (Intrinsics.areEqual(r30.getVisibilityThreshold(), r5) == true) goto L37;
        r4 = AnimationSpecKt.spring(r30.getDampingRatio(), r30.getStiffness(), r5);
        goto L37
    L20:
        r7 = r19;
        goto L22
    L16:
        r6 = r18;
        goto L18
    L12:
        r5 = r17;
        goto L14
    L8:
        r4 = r16;
        goto L10
    }
}
