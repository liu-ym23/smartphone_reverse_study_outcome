package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0001\u0018\u0000 N2\u00020\u0001:\u0001NB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010B\u001a\u00020\bJ\u001d\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u001a¢\u0006\u0004\bI\u0010JJ\u0006\u0010K\u001a\u00020\bJ\u0006\u0010L\u001a\u00020\bJ\u0006\u0010M\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR+\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R+\u0010#\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\"\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010 R+\u0010&\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010 R+\u0010)\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010 R\u001c\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00102\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00106\u001a\u0004\u0018\u0001052\b\u0010\u0019\u001a\u0004\u0018\u000105@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020;0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020=0:X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010>\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00138F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\"\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R\u001c\u0010C\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\bD\u0010.\"\u0004\bE\u00100¨\u0006O"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "onLayerPropertyChanged", "Lkotlin/Function0;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function0;)V", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "getPlacementSpec", "setPlacementSpec", "fadeOutSpec", "getFadeOutSpec", "setFadeOutSpec", "value", "", "isRunningMovingAwayAnimation", "()Z", "<set-?>", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "(Z)V", "isPlacementAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isAppearanceAnimationInProgress", "setAppearanceAnimationInProgress", "isAppearanceAnimationInProgress$delegate", "isDisappearanceAnimationInProgress", "setDisappearanceAnimationInProgress", "isDisappearanceAnimationInProgress$delegate", "isDisappearanceAnimationFinished", "setDisappearanceAnimationFinished", "isDisappearanceAnimationFinished$delegate", "rawOffset", "getRawOffset-nOcc-ac", "()J", "setRawOffset--gyyYBs", "(J)V", "J", "finalOffset", "getFinalOffset-nOcc-ac", "setFinalOffset--gyyYBs", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "visibilityAnimation", "Landroidx/compose/animation/core/AnimationVector1D;", "placementDelta", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta$delegate", "cancelPlacementAnimation", "lookaheadOffset", "getLookaheadOffset-nOcc-ac", "setLookaheadOffset--gyyYBs", "animatePlacementDelta", "delta", "isMovingAway", "animatePlacementDelta-ar5cAso", "(JZ)V", "animateAppearance", "animateDisappearance", "release", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutItemAnimation {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final long NotInitialized = 0;
    private final CoroutineScope coroutineScope;
    private FiniteAnimationSpec<Float> fadeInSpec;
    private FiniteAnimationSpec<Float> fadeOutSpec;
    private long finalOffset;
    private final GraphicsContext graphicsContext;
    private final MutableState isAppearanceAnimationInProgress$delegate;
    private final MutableState isDisappearanceAnimationFinished$delegate;
    private final MutableState isDisappearanceAnimationInProgress$delegate;
    private final MutableState isPlacementAnimationInProgress$delegate;
    private boolean isRunningMovingAwayAnimation;
    private GraphicsLayer layer;
    private long lookaheadOffset;
    private final Function0<Unit> onLayerPropertyChanged;
    private final MutableState placementDelta$delegate;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    private long rawOffset;
    private final Animatable<Float, AnimationVector1D> visibilityAnimation;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation$Companion;", "", "<init>", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX INFO: renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m1151getNotInitializednOccac() {
            return LazyLayoutItemAnimation.access$getNotInitialized$cp();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public AnonymousClass1(LazyLayoutItemAnimation r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Animatable r5 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);
            Float r2 = Boxing.boxFloat(1.0f);
            this.label = 1;
            if (r5.snapTo(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2", f = "LazyLayoutItemAnimation.kt", i = {}, l = {183, 185}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ boolean $shouldResetValue;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public AnonymousClass2(boolean r1, LazyLayoutItemAnimation r2, FiniteAnimationSpec<Float> r3, GraphicsLayer r4, Continuation<? super AnonymousClass2> r5) {
            this.$shouldResetValue = r1;
            this.this$0 = r2;
            this.$spec = r3;
            this.$layer = r4;
            super(2, r5);
        }

        public static /* synthetic */ Unit a(GraphicsLayer r0, LazyLayoutItemAnimation r1, Animatable r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass2(this.$shouldResetValue, this.this$0, this.$spec, this.$layer, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L12
        L23:
            AnimationResult r14 = (AnimationResult) r13;     // Catch: Throwable -> L12
            LazyLayoutItemAnimation.access$setAppearanceAnimationInProgress(this.this$0, false);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L12
        L20:
            Animatable r4 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);     // Catch: Throwable -> L12
            Float r5 = Boxing.boxFloat(1.0f);     // Catch: Throwable -> L12
            FiniteAnimationSpec<Float> r6 = this.$spec;     // Catch: Throwable -> L12
            final GraphicsLayer r15 = this.$layer;     // Catch: Throwable -> L12
            final LazyLayoutItemAnimation r2 = this.this$0;     // Catch: Throwable -> L12
            Function1 r8 = new f(r15, r2);     // Catch: Throwable -> L12
            this.label = 2;     // Catch: Throwable -> L12
            r13 = Animatable.animateTo$default(r4, r5, r6, null, r8, this, 4, null);     // Catch: Throwable -> L12
            if (r13 != r0) goto L23;
            return r0;
        L14:
            ResultKt.throwOnFailure(r13);
            if (this.$shouldResetValue == false) goto L20;
            Animatable r16 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);     // Catch: Throwable -> L12
            Float r3 = Boxing.boxFloat(MenuKt.ClosedAlphaTarget);     // Catch: Throwable -> L12
            this.label = 1;     // Catch: Throwable -> L12
            if (r16.snapTo(r3, this) != r0) goto L20;
            return r0;
        L12:
            th = move-exception;
            LazyLayoutItemAnimation.access$setAppearanceAnimationInProgress(this.this$0, false);
            throw th;
        }

        private static final Unit invokeSuspend$lambda$0(GraphicsLayer r0, LazyLayoutItemAnimation r1, Animatable r2) {
            r0.setAlpha(((Number) r2.getValue()).floatValue());
            LazyLayoutItemAnimation.access$getOnLayerPropertyChanged$p(r1).invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public C01951(LazyLayoutItemAnimation r1, FiniteAnimationSpec<Float> r2, GraphicsLayer r3, Continuation<? super C01951> r4) {
            this.this$0 = r1;
            this.$spec = r2;
            this.$layer = r3;
            super(2, r4);
        }

        public static /* synthetic */ Unit a(GraphicsLayer r0, LazyLayoutItemAnimation r1, Animatable r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01951(this.this$0, this.$spec, this.$layer, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L7
        L15:
            LazyLayoutItemAnimation.access$setDisappearanceAnimationFinished(this.this$0, true);     // Catch: Throwable -> L7
            LazyLayoutItemAnimation.access$setDisappearanceAnimationInProgress(this.this$0, false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r13);
            Animatable r4 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);     // Catch: Throwable -> L7
            Float r5 = Boxing.boxFloat(MenuKt.ClosedAlphaTarget);     // Catch: Throwable -> L7
            FiniteAnimationSpec<Float> r6 = this.$spec;     // Catch: Throwable -> L7
            final GraphicsLayer r14 = this.$layer;     // Catch: Throwable -> L7
            final LazyLayoutItemAnimation r2 = this.this$0;     // Catch: Throwable -> L7
            Function1 r8 = new g(r14, r2);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (Animatable.animateTo$default(r4, r5, r6, null, r8, this, 4, null) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            LazyLayoutItemAnimation.access$setDisappearanceAnimationInProgress(this.this$0, false);
            throw th;
        }

        private static final Unit invokeSuspend$lambda$0(GraphicsLayer r0, LazyLayoutItemAnimation r1, Animatable r2) {
            r0.setAlpha(((Number) r2.getValue()).floatValue());
            LazyLayoutItemAnimation.access$getOnLayerPropertyChanged$p(r1).invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public C01961(LazyLayoutItemAnimation r1, Continuation<? super C01961> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01961(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            LazyLayoutItemAnimation.m1141access$setPlacementDeltagyyYBs(this.this$0, IntOffset.Companion.getZero-nOcc-ac());
            LazyLayoutItemAnimation.access$setPlacementAnimationInProgress(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Animatable r7 = LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0);
            IntOffset r2 = IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac());
            this.label = 1;
            if (r7.snapTo(r2, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public C01971(LazyLayoutItemAnimation r1, Continuation<? super C01971> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01971(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Animatable r5 = LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0);
            this.label = 1;
            if (r5.stop(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$2", f = "LazyLayoutItemAnimation.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public C01982(LazyLayoutItemAnimation r1, Continuation<? super C01982> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01982(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Animatable r5 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);
            this.label = 1;
            if (r5.stop(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$3", f = "LazyLayoutItemAnimation.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public AnonymousClass3(LazyLayoutItemAnimation r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Animatable r5 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);
            this.label = 1;
            if (r5.stop(this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Unit a() {
        return _init_$lambda$0();
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        long r0 = Integer.MAX_VALUE;
        NotInitialized = IntOffset.constructor-impl((r0 & 4294967295L) | (r0 << 32));
    }

    public final void animateAppearance() {
        GraphicsLayer r4 = this.layer;
        FiniteAnimationSpec<Float> r3 = this.fadeInSpec;
        if (isAppearanceAnimationInProgress() == true) goto L13;
        if (r3 == null) goto L13;
        if (r4 == null) goto L13;
        setAppearanceAnimationInProgress(true);
        boolean r1 = !isDisappearanceAnimationInProgress();
        if (r1 == false) goto L10;
        r4.setAlpha(MenuKt.ClosedAlphaTarget);
    L10:
        BuildersKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(r1, this, r3, r4, null), 3, null);
        return;
    L13:
        if (isDisappearanceAnimationInProgress() == false) goto L18;
        if (r4 == null) goto L16;
        r4.setAlpha(1.0f);
    L16:
        BuildersKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    public final void animateDisappearance() {
        GraphicsLayer r0 = this.layer;
        FiniteAnimationSpec<Float> r1 = this.fadeOutSpec;
        if (r0 != null) goto L5;
        return;
    L5:
        if (isDisappearanceAnimationInProgress() == true) goto L11;
        if (r1 == null) goto L12;
        setDisappearanceAnimationInProgress(true);
        BuildersKt.launch$default(this.coroutineScope, null, null, new C01951(this, r1, r0, null), 3, null);
        return;
    L12:
        return;
    }

    /* JADX INFO: renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public final long m1146getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta$delegate.getValue()).unbox-impl();
    }

    public final boolean isAppearanceAnimationInProgress() {
        return ((Boolean) this.isAppearanceAnimationInProgress$delegate.getValue()).booleanValue();
    }

    public final boolean isDisappearanceAnimationFinished() {
        return ((Boolean) this.isDisappearanceAnimationFinished$delegate.getValue()).booleanValue();
    }

    public final boolean isDisappearanceAnimationInProgress() {
        return ((Boolean) this.isDisappearanceAnimationInProgress$delegate.getValue()).booleanValue();
    }

    public final boolean isPlacementAnimationInProgress() {
        return ((Boolean) this.isPlacementAnimationInProgress$delegate.getValue()).booleanValue();
    }

    public final void cancelPlacementAnimation() {
        if (isPlacementAnimationInProgress() == false) goto L6;
        BuildersKt.launch$default(this.coroutineScope, null, null, new C01961(this, null), 3, null);
        return;
    }

    public final void release() {
        if (isPlacementAnimationInProgress() == false) goto L6;
        setPlacementAnimationInProgress(false);
        BuildersKt.launch$default(this.coroutineScope, null, null, new C01971(this, null), 3, null);
    L6:
        if (isAppearanceAnimationInProgress() == false) goto L9;
        setAppearanceAnimationInProgress(false);
        BuildersKt.launch$default(this.coroutineScope, null, null, new C01982(this, null), 3, null);
    L9:
        if (isDisappearanceAnimationInProgress() == false) goto L11;
        setDisappearanceAnimationInProgress(false);
        BuildersKt.launch$default(this.coroutineScope, null, null, new AnonymousClass3(this, null), 3, null);
    L11:
        this.isRunningMovingAwayAnimation = false;
        m1142setPlacementDeltagyyYBs(IntOffset.Companion.getZero-nOcc-ac());
        this.rawOffset = NotInitialized;
        GraphicsLayer r0 = this.layer;
        if (r0 == null) goto L16;
        GraphicsContext r1 = this.graphicsContext;
        if (r1 == null) goto L16;
        r1.releaseGraphicsLayer(r0);
    L16:
        this.layer = null;
        this.fadeInSpec = null;
        this.fadeOutSpec = null;
        this.placementSpec = null;
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ long access$getNotInitialized$cp() {
        return NotInitialized;
    }

    public final FiniteAnimationSpec<Float> getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec<Float> getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    /* JADX INFO: renamed from: getFinalOffset-nOcc-ac, reason: not valid java name */
    public final long m1144getFinalOffsetnOccac() {
        return this.finalOffset;
    }

    public final GraphicsLayer getLayer() {
        return this.layer;
    }

    /* JADX INFO: renamed from: getLookaheadOffset-nOcc-ac, reason: not valid java name */
    public final long m1145getLookaheadOffsetnOccac() {
        return this.lookaheadOffset;
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    /* JADX INFO: renamed from: getRawOffset-nOcc-ac, reason: not valid java name */
    public final long m1147getRawOffsetnOccac() {
        return this.rawOffset;
    }

    public final boolean isRunningMovingAwayAnimation() {
        return this.isRunningMovingAwayAnimation;
    }

    public static final /* synthetic */ Function0 access$getOnLayerPropertyChanged$p(LazyLayoutItemAnimation r0) {
        return r0.onLayerPropertyChanged;
    }

    public static final /* synthetic */ Animatable access$getPlacementDeltaAnimation$p(LazyLayoutItemAnimation r0) {
        return r0.placementDeltaAnimation;
    }

    public static final /* synthetic */ Animatable access$getVisibilityAnimation$p(LazyLayoutItemAnimation r0) {
        return r0.visibilityAnimation;
    }

    private final void setAppearanceAnimationInProgress(boolean r2) {
        this.isAppearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setDisappearanceAnimationFinished(boolean r2) {
        this.isDisappearanceAnimationFinished$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setDisappearanceAnimationInProgress(boolean r2) {
        this.isDisappearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setPlacementAnimationInProgress(boolean r2) {
        this.isPlacementAnimationInProgress$delegate.setValue(Boolean.valueOf(r2));
    }

    /* JADX INFO: renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    private final void m1142setPlacementDeltagyyYBs(long r2) {
        this.placementDelta$delegate.setValue(IntOffset.box-impl(r2));
    }

    public final void setFadeInSpec(FiniteAnimationSpec<Float> r1) {
        this.fadeInSpec = r1;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec<Float> r1) {
        this.fadeOutSpec = r1;
    }

    /* JADX INFO: renamed from: setFinalOffset--gyyYBs, reason: not valid java name */
    public final void m1148setFinalOffsetgyyYBs(long r1) {
        this.finalOffset = r1;
    }

    /* JADX INFO: renamed from: setLookaheadOffset--gyyYBs, reason: not valid java name */
    public final void m1149setLookaheadOffsetgyyYBs(long r1) {
        this.lookaheadOffset = r1;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> r1) {
        this.placementSpec = r1;
    }

    /* JADX INFO: renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public final void m1150setRawOffsetgyyYBs(long r1) {
        this.rawOffset = r1;
    }

    public static final /* synthetic */ void access$setAppearanceAnimationInProgress(LazyLayoutItemAnimation r0, boolean r1) {
        r0.setAppearanceAnimationInProgress(r1);
    }

    public static final /* synthetic */ void access$setDisappearanceAnimationFinished(LazyLayoutItemAnimation r0, boolean r1) {
        r0.setDisappearanceAnimationFinished(r1);
    }

    public static final /* synthetic */ void access$setDisappearanceAnimationInProgress(LazyLayoutItemAnimation r0, boolean r1) {
        r0.setDisappearanceAnimationInProgress(r1);
    }

    public static final /* synthetic */ void access$setPlacementAnimationInProgress(LazyLayoutItemAnimation r0, boolean r1) {
        r0.setPlacementAnimationInProgress(r1);
    }

    /* JADX INFO: renamed from: access$setPlacementDelta--gyyYBs, reason: not valid java name */
    public static final /* synthetic */ void m1141access$setPlacementDeltagyyYBs(LazyLayoutItemAnimation r0, long r1) {
        r0.m1142setPlacementDeltagyyYBs(r1);
    }

    public static final /* synthetic */ void access$setRunningMovingAwayAnimation$p(LazyLayoutItemAnimation r0, boolean r1) {
        r0.isRunningMovingAwayAnimation = r1;
    }

    /* JADX INFO: renamed from: animatePlacementDelta-ar5cAso, reason: not valid java name */
    public final void m1143animatePlacementDeltaar5cAso(long r12, boolean r14) {
        FiniteAnimationSpec<IntOffset> r2 = this.placementSpec;
        if (r2 != null) goto L5;
        return;
    L5:
        long r3 = IntOffset.minus-qkQi6aY(m1146getPlacementDeltanOccac(), r12);
        m1142setPlacementDeltagyyYBs(r3);
        setPlacementAnimationInProgress(true);
        this.isRunningMovingAwayAnimation = r14;
        BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$animatePlacementDelta$1(this, r2, r3, null), 3, null);
    }

    public LazyLayoutItemAnimation(CoroutineScope r22, GraphicsContext r23, Function0<Unit> r24) {
        this.coroutineScope = r22;
        this.graphicsContext = r23;
        this.onLayerPropertyChanged = r24;
        Boolean r2 = Boolean.FALSE;
        this.isPlacementAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(r2, null, 2, null);
        this.isAppearanceAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(r2, null, 2, null);
        this.isDisappearanceAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(r2, null, 2, null);
        this.isDisappearanceAnimationFinished$delegate = SnapshotStateKt.mutableStateOf$default(r2, null, 2, null);
        long r5 = NotInitialized;
        this.rawOffset = r5;
        IntOffset.Companion r3 = IntOffset.Companion;
        this.finalOffset = r3.getZero-nOcc-ac();
        if (r23 == null) goto L5;
        GraphicsLayer r1 = r23.createGraphicsLayer();
    L6:
        this.layer = r1;
        this.placementDeltaAnimation = new Animatable(IntOffset.box-impl(r3.getZero-nOcc-ac()), VectorConvertersKt.getVectorConverter(r3), null, null, 12, null);
        this.visibilityAnimation = new Animatable(Float.valueOf(1.0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        this.placementDelta$delegate = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(r3.getZero-nOcc-ac()), null, 2, null);
        this.lookaheadOffset = r5;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public /* synthetic */ LazyLayoutItemAnimation(CoroutineScope r1, GraphicsContext r2, Function0 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = new e();
    L8:
        this(r1, r2, r3);
    }
}
