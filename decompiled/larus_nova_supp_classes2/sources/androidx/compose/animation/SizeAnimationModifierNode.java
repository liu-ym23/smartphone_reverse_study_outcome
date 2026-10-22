package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001:\u0001?B[\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012:\b\u0002\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fH\u0002¢\u0006\u0004\b'\u0010(J\b\u00102\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020\rH\u0016J#\u00104\u001a\u000205*\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001fH\u0016¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004¢\u0006\u0004\b>\u0010(R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017RL\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR \u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0082\u000e¢\u0006\n\n\u0002\u0010\u001d\"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010+\u001a\u0004\u0018\u00010*2\b\u0010)\u001a\u0004\u0018\u00010*8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006@"}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "alignment", "Landroidx/compose/ui/Alignment;", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startSize", "endSize", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getListener", "()Lkotlin/jvm/functions/Function2;", "setListener", "(Lkotlin/jvm/functions/Function2;)V", "lookaheadSize", "J", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "lookaheadConstraintsAvailable", "", "targetConstraints", "default", "targetConstraints-ZezNO4M", "(J)J", "<set-?>", "Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "animData", "getAnimData", "()Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "setAnimData", "(Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;)V", "animData$delegate", "Landroidx/compose/runtime/MutableState;", "onReset", "onAttach", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animateTo", "targetSize", "animateTo-mzRDjE0", "AnimData", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SizeAnimationModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    private Alignment alignment;
    private final MutableState animData$delegate;
    private AnimationSpec<IntSize> animationSpec;
    private Function2<? super IntSize, ? super IntSize, Unit> listener;
    private long lookaheadConstraints;
    private boolean lookaheadConstraintsAvailable;
    private long lookaheadSize;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJ0\u0010\u0013\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "", "anim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "startSize", "<init>", "(Landroidx/compose/animation/core/Animatable;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnim", "()Landroidx/compose/animation/core/Animatable;", "getStartSize-YbymL2g", "()J", "setStartSize-ozmzZPI", "(J)V", "J", "component1", "component2", "component2-YbymL2g", "copy", "copy-O0kMr_c", "(Landroidx/compose/animation/core/Animatable;J)Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "equals", "", "other", "hashCode", "", "toString", "", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnimData {
        public static final int $stable = 8;
        private final Animatable<IntSize, AnimationVector2D> anim;
        private long startSize;

        public /* synthetic */ AnimData(Animatable r1, long r2, DefaultConstructorMarker r4) {
            this(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-O0kMr_c$default, reason: not valid java name */
        public static /* synthetic */ AnimData m218copyO0kMr_c$default(AnimData r0, Animatable r1, long r2, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.anim;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.startSize;
        L9:
            return r0.m220copyO0kMr_c(r1, r2);
        }

        public final Animatable<IntSize, AnimationVector2D> component1() {
            return this.anim;
        }

        /* JADX INFO: renamed from: component2-YbymL2g, reason: not valid java name */
        public final long m219component2YbymL2g() {
            return this.startSize;
        }

        /* JADX INFO: renamed from: copy-O0kMr_c, reason: not valid java name */
        public final AnimData m220copyO0kMr_c(Animatable<IntSize, AnimationVector2D> r3, long r4) {
            return new AnimData(r3, r4, null);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof AnimData) == true) goto L8;
            return false;
        L8:
            AnimData r9 = (AnimData) r8;
            if (Intrinsics.areEqual(this.anim, r9.anim) == true) goto L12;
            return false;
        L12:
            if (IntSize.equals-impl0(this.startSize, r9.startSize) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.anim.hashCode() * 31) + IntSize.hashCode-impl(this.startSize);
        }

        public String toString() {
            return "AnimData(anim=" + this.anim + ", startSize=" + IntSize.toString-impl(this.startSize) + ')';
        }

        public final Animatable<IntSize, AnimationVector2D> getAnim() {
            return this.anim;
        }

        /* JADX INFO: renamed from: getStartSize-YbymL2g, reason: not valid java name */
        public final long m221getStartSizeYbymL2g() {
            return this.startSize;
        }

        /* JADX INFO: renamed from: setStartSize-ozmzZPI, reason: not valid java name */
        public final void m222setStartSizeozmzZPI(long r1) {
            this.startSize = r1;
        }

        private AnimData(Animatable<IntSize, AnimationVector2D> r1, long r2) {
            this.anim = r1;
            this.startSize = r2;
        }
    }

    public final AnimData getAnimData() {
        return (AnimData) this.animData$delegate.getValue();
    }

    public void onAttach() {
        super.onAttach();
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraintsAvailable = false;
    }

    public void onReset() {
        super.onReset();
        setAnimData(null);
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final AnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function2<IntSize, IntSize, Unit> getListener() {
        return this.listener;
    }

    /* JADX INFO: renamed from: setLookaheadConstraints-BRTryo0, reason: not valid java name */
    private final void m214setLookaheadConstraintsBRTryo0(long r1) {
        this.lookaheadConstraints = r1;
        this.lookaheadConstraintsAvailable = true;
    }

    /* JADX INFO: renamed from: targetConstraints-ZezNO4M, reason: not valid java name */
    private final long m215targetConstraintsZezNO4M(long r2) {
        if (this.lookaheadConstraintsAvailable == true) goto L5;
        return r2;
    L5:
        return this.lookaheadConstraints;
    }

    /* JADX INFO: renamed from: animateTo-mzRDjE0, reason: not valid java name */
    public final long m216animateTomzRDjE0(long r15) {
        AnimData r6 = getAnimData();
        boolean r0 = true;
        if (r6 != null) goto L5;
        long r4 = 1;
        r6 = new AnimData(new Animatable(IntSize.box-impl(r15), VectorConvertersKt.getVectorConverter(IntSize.Companion), IntSize.box-impl(IntSize.constructor-impl((r4 & 4294967295L) | (r4 << 32))), null, 8, null), r15, null);
    L15:
        setAnimData(r6);
        return r6.getAnim().getValue().unbox-impl();
    L5:
        if (IntSize.equals-impl0(r15, r6.getAnim().getValue().unbox-impl()) == false) goto L7;
    L9:
        r0 = false;
    L11:
        if (IntSize.equals-impl0(r15, r6.getAnim().getTargetValue().unbox-impl()) == false) goto L13;
        if (r0 == false) goto L15;
    L13:
        r6.m222setStartSizeozmzZPI(r6.getAnim().getValue().unbox-impl());
        BuildersKt.launch$default(getCoroutineScope(), null, null, new SizeAnimationModifierNode$animateTo$data$1$1(r6, r15, this, null), 3, null);
        goto L15
    L7:
        if (r6.getAnim().isRunning() == true) goto L9;
        goto L9
    }

    public final void setAlignment(Alignment r1) {
        this.alignment = r1;
    }

    public final void setAnimData(AnimData r2) {
        this.animData$delegate.setValue(r2);
    }

    public final void setAnimationSpec(AnimationSpec<IntSize> r1) {
        this.animationSpec = r1;
    }

    public final void setListener(Function2<? super IntSize, ? super IntSize, Unit> r1) {
        this.listener = r1;
    }

    public SizeAnimationModifierNode(AnimationSpec<IntSize> r7, Alignment r8, Function2<? super IntSize, ? super IntSize, Unit> r9) {
        this.animationSpec = r7;
        this.alignment = r8;
        this.listener = r9;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.animData$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m217measure3p2s80s(final MeasureScope r21, Measurable r22, long r23) {
        if (r21.isLookingAhead() == false) goto L5;
        m214setLookaheadConstraintsBRTryo0(r23);
        Placeable r2 = r22.measure-BRTryo0(r23);
    L6:
        final Placeable r7 = r2;
        int r3 = r7.getWidth();
        final long r4 = IntSize.constructor-impl((((long) r3) << 32) | (((long) r7.getHeight()) & 4294967295L));
        if (r21.isLookingAhead() == false) goto L10;
        this.lookaheadSize = r4;
        long r0 = r4;
    L14:
        final int r14 = (int) (r0 >> 32);
        final int r15 = (int) (r0 & 4294967295L);
        return MeasureScope.-CC.layout$default(r21, r14, r15, null, new SizeAnimationModifierNode$measure$2(this, r4, r14, r15, r21, r7), 4, null);
    L10:
        if (AnimationModifierKt.m148isValidozmzZPI(this.lookaheadSize) == false) goto L12;
        long r5 = this.lookaheadSize;
    L13:
        r0 = ConstraintsKt.constrain-4WqzIAM(r23, m216animateTomzRDjE0(r5));
        goto L14
    L12:
        r5 = r4;
        goto L13
    L5:
        r2 = r22.measure-BRTryo0(m215targetConstraintsZezNO4M(r23));
        goto L6
    }

    public /* synthetic */ SizeAnimationModifierNode(AnimationSpec r1, Alignment r2, Function2 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = Alignment.Companion.getTopStart();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }
}
