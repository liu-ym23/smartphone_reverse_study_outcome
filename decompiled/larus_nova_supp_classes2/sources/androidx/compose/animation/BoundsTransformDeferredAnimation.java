package androidx.compose.animation;

import androidx.collection.SieveCacheKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001d\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J6\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<J\u0018\u0010=\u001a\u00020\u00062\u0006\u00107\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u001c\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0013R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010#\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b#\u0010$R/\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010)R\u0013\u0010,\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b-\u0010\u001eR\u0016\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006>"}, d2 = {"Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "", "<init>", "()V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "targetSize", "Landroidx/compose/ui/geometry/Size;", "J", "targetOffset", "Landroidx/compose/ui/geometry/Offset;", "isPending", "", "updateTargetSize", "", "size", "updateTargetSize-uvyYCjk", "(J)V", "updateTargetOffset", "offset", "updateTargetOffset-k-4lQ0M", "currentPosition", "currentSize", "getCurrentSize-NH-jbRc", "()J", "setCurrentSize-uvyYCjk", "currentBounds", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "updateCurrentBounds", "position", "updateCurrentBounds-tz77jQw", "(JJ)V", "isIdle", "()Z", "<set-?>", "animatedValue", "getAnimatedValue", "setAnimatedValue", "(Landroidx/compose/ui/geometry/Rect;)V", "animatedValue$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getValue", "directManipulationParents", "", "Landroidx/compose/ui/layout/LayoutCoordinates;", "additionalOffset", "updateTargetOffsetAndAnimate", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "directManipulationParentsDirty", "includeMotionFrameOfReference", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "animate", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BoundsTransformDeferredAnimation {
    public static final int $stable = 8;
    private long additionalOffset;
    private Animatable<Rect, AnimationVector4D> animatable;
    private final MutableState animatedValue$delegate;
    private long currentPosition;
    private long currentSize;
    private List<LayoutCoordinates> directManipulationParents;
    private boolean isPending;
    private long targetOffset;
    private long targetSize;

    /* JADX INFO: renamed from: androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1", f = "AnimateBoundsModifier.kt", i = {}, l = {425}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Animatable<Rect, AnimationVector4D> $anim;
        final /* synthetic */ BoundsTransform $boundsTransform;
        final /* synthetic */ Rect $target;
        int label;
        final /* synthetic */ BoundsTransformDeferredAnimation this$0;

        public AnonymousClass1(Animatable<Rect, AnimationVector4D> r1, Rect r2, BoundsTransform r3, BoundsTransformDeferredAnimation r4, Continuation<? super AnonymousClass1> r5) {
            this.$anim = r1;
            this.$target = r2;
            this.$boundsTransform = r3;
            this.this$0 = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$anim, this.$target, this.$boundsTransform, this.this$0, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            Animatable<Rect, AnimationVector4D> r2 = this.$anim;
            Rect r11 = this.$target;
            BoundsTransform r3 = this.$boundsTransform;
            Rect r4 = this.this$0.getCurrentBounds();
            Intrinsics.checkNotNull(r4);
            FiniteAnimationSpec<Rect> r5 = r3.transform(r4, this.$target);
            this.label = 1;
            if (Animatable.animateTo$default(r2, r11, r5, null, null, this, 12, null) != r0) goto L12;
            return r0;
        }
    }

    private final Rect getAnimatedValue() {
        return (Rect) this.animatedValue$delegate.getValue();
    }

    public final Rect getCurrentBounds() {
        long r0 = this.currentSize;
        long r2 = this.currentPosition;
        boolean r6 = true;
        if ((SieveCacheKt.InvalidMapping & r2) == 9205357640488583168L) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
    L13:
        return null;
    L8:
        if (r0 != 9205357640488583168L) goto L11;
        r6 = false;
    L11:
        if (r6 == false) goto L13;
        return RectKt.Rect-tz77jQw(r2, r0);
    L5:
        r4 = false;
        goto L6
    }

    public final boolean isIdle() {
        if (this.isPending == true) goto L13;
        Animatable<Rect, AnimationVector4D> r0 = this.animatable;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.isRunning() != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public BoundsTransformDeferredAnimation() {
        Size.Companion r0 = Size.Companion;
        this.targetSize = r0.getUnspecified-NH-jbRc();
        Offset.Companion r1 = Offset.Companion;
        this.targetOffset = r1.getUnspecified-F1C5BW0();
        this.currentPosition = r1.getUnspecified-F1C5BW0();
        this.currentSize = r0.getUnspecified-NH-jbRc();
        this.animatedValue$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.additionalOffset = r1.getZero-F1C5BW0();
    }

    public final Rect getValue() {
        if (isIdle() == false) goto L6;
        return null;
    L6:
        return getAnimatedValue();
    }

    /* JADX INFO: renamed from: getCurrentSize-NH-jbRc, reason: not valid java name */
    public final long m154getCurrentSizeNHjbRc() {
        return this.currentSize;
    }

    private final void setAnimatedValue(Rect r2) {
        this.animatedValue$delegate.setValue(r2);
    }

    /* JADX INFO: renamed from: updateTargetOffset-k-4lQ0M, reason: not valid java name */
    private final void m153updateTargetOffsetk4lQ0M(long r11) {
        boolean r4 = false;
        if ((this.targetOffset & SieveCacheKt.InvalidMapping) == 9205357640488583168L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        this.targetOffset = r11;
        if ((this.currentPosition & SieveCacheKt.InvalidMapping) != 9205357640488583168L) goto L13;
        r4 = true;
    L13:
        if (r4 == false) goto L16;
        this.currentPosition = r11;
        return;
    L16:
        return;
    L8:
        if (IntOffset.equals-impl0(IntOffsetKt.round-k-4lQ0M(r11), IntOffsetKt.round-k-4lQ0M(this.targetOffset)) == true) goto L10;
        this.isPending = true;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: setCurrentSize-uvyYCjk, reason: not valid java name */
    public final void m155setCurrentSizeuvyYCjk(long r1) {
        this.currentSize = r1;
    }

    /* JADX INFO: renamed from: updateTargetSize-uvyYCjk, reason: not valid java name */
    public final void m157updateTargetSizeuvyYCjk(long r9) {
        boolean r2 = false;
        if (this.targetSize == 9205357640488583168L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        this.targetSize = r9;
        if (this.currentSize != 9205357640488583168L) goto L13;
        r2 = true;
    L13:
        if (r2 == false) goto L16;
        this.currentSize = r9;
        return;
    L16:
        return;
    L8:
        if (IntSize.equals-impl0(IntSizeKt.roundToIntSize-uvyYCjk(r9), IntSizeKt.roundToIntSize-uvyYCjk(this.targetSize)) == true) goto L10;
        this.isPending = true;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private final Rect animate(CoroutineScope r15, BoundsTransform r16) {
        long r0 = this.targetOffset;
        boolean r4 = true;
        if ((SieveCacheKt.InvalidMapping & r0) == 9205357640488583168L) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L18;
        long r3 = this.targetSize;
        if (r3 != 9205357640488583168L) goto L11;
        r4 = false;
    L11:
        if (r4 == false) goto L18;
        Rect r5 = RectKt.Rect-tz77jQw(r0, r3);
        Animatable<Rect, AnimationVector4D> r1 = this.animatable;
        if (r1 != null) goto L15;
        r1 = new Animatable(r5, VectorConvertersKt.getVectorConverter(Rect.Companion), null, null, 12, null);
    L15:
        Animatable<Rect, AnimationVector4D> r6 = r1;
        this.animatable = r6;
        if (this.isPending == false) goto L18;
        this.isPending = false;
        BuildersKt.launch$default(r15, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(r6, r5, r16, this, null), 1, null);
    L18:
        Animatable<Rect, AnimationVector4D> r7 = this.animatable;
        if (r7 == null) goto L23;
        Rect r8 = r7.getValue();
        if (r8 == null) goto L23;
        return r8;
    L23:
        return Rect.Companion.getZero();
    L5:
        r2 = false;
        goto L6
    }

    /* JADX INFO: renamed from: updateCurrentBounds-tz77jQw, reason: not valid java name */
    public final void m156updateCurrentBoundstz77jQw(long r1, long r3) {
        this.currentPosition = r1;
        this.currentSize = r3;
    }

    public final void updateTargetOffsetAndAnimate(LookaheadScope r9, Placeable.PlacementScope r10, CoroutineScope r11, boolean r12, boolean r13, BoundsTransform r14) {
        LayoutCoordinates r2 = r10.getCoordinates();
        if (r2 == null) goto L36;
        LayoutCoordinates r1 = r9.getLookaheadScopeCoordinates(r10);
        long r3 = Offset.Companion.getZero-F1C5BW0();
        if (r13 == true) goto L30;
        if (r12 == false) goto L30;
        List<LayoutCoordinates> r15 = this.directManipulationParents;
        if (r15 != null) goto L10;
        r15 = new ArrayList();
    L10:
        int r16 = 0;
        LayoutCoordinates r0 = r2;
    L12:
        if (Intrinsics.areEqual(r9.toLookaheadCoordinates(r0), r1) == true) goto L24;
        if (r0.getIntroducesMotionFrameOfReference() == true) goto L16;
    L22:
        r0 = r0.getParentCoordinates();
        if (r0 != null) goto L12;
    L16:
        if (r15.size() != r16) goto L19;
        r15.add(r0);
        r3 = Offset.plus-MK-Hz9U(r3, LayoutCoordinatesKt.positionInParent(r0));
    L21:
        r16 = r16 + 1;
        goto L22
    L19:
        if (Intrinsics.areEqual(ListProtector.get(r15, r16), r0) == true) goto L21;
        long r4 = Offset.minus-MK-Hz9U(r3, LayoutCoordinatesKt.positionInParent((LayoutCoordinates) ListProtector.get(r15, r16)));
        ListProtector.set(r15, r16, r0);
        r3 = Offset.plus-MK-Hz9U(r4, LayoutCoordinatesKt.positionInParent(r0));
    L24:
        int r5 = r15.size() - 1;
        if (r16 > r5) goto L29;
    L26:
        r3 = Offset.minus-MK-Hz9U(r3, LayoutCoordinatesKt.positionInParent((LayoutCoordinates) ListProtector.get(r15, r5)));
        ListProtector.remove(r15, r15.size() - 1);
        if (r5 == r16) goto L29;
        r5 = r5 - 1;
    L29:
        this.directManipulationParents = r15;
    L30:
        this.additionalOffset = Offset.plus-MK-Hz9U(this.additionalOffset, r3);
        m153updateTargetOffsetk4lQ0M(Offset.plus-MK-Hz9U(LookaheadScope.-CC.localLookaheadPositionOf-au-aQtc$default(r9, r1, r2, 0, r13, 2, null), this.additionalOffset));
        setAnimatedValue(animate(r11, r14).translate-k-4lQ0M(Offset.constructor-impl(this.additionalOffset ^ (-9223372034707292160L))));
        return;
    }
}
