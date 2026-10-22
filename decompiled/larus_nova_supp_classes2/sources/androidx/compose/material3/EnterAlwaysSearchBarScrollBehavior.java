package androidx.compose.material3;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000 02\u00020\u0001:\u00010BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010%\u001a\u00020&*\u00020&H\u0016J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "canScroll", "Lkotlin/Function0;", "", "reverseLayout", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "<init>", "(FFLkotlin/jvm/functions/Function0;ZLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;)V", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "getReverseLayout", "()Z", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "_offset", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "scrollOffset", "getScrollOffset", "()F", "setScrollOffset", "(F)V", "<set-?>", "scrollOffsetLimit", "getScrollOffsetLimit", "setScrollOffsetLimit", "scrollOffsetLimit$delegate", "Landroidx/compose/runtime/MutableFloatState;", "searchBarScrollBehavior", "Landroidx/compose/ui/Modifier;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "settleSearchBar", "Landroidx/compose/ui/unit/Velocity;", "velocity", "settleSearchBar-OhffZ5M", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class EnterAlwaysSearchBarScrollBehavior implements SearchBarScrollBehavior {
    public static final Companion Companion = null;
    private MutableFloatState _offset;
    private final Function0<Boolean> canScroll;
    private final DecayAnimationSpec<Float> flingAnimationSpec;
    private final NestedScrollConnection nestedScrollConnection;
    private final boolean reverseLayout;
    private final MutableFloatState scrollOffsetLimit$delegate;
    private final AnimationSpec<Float> snapAnimationSpec;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/EnterAlwaysSearchBarScrollBehavior;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ EnterAlwaysSearchBarScrollBehavior a(Function0 r0, AnimationSpec r1, DecayAnimationSpec r2, List r3) {
            return Saver$lambda$1(r0, r1, r2, r3);
        }

        public static /* synthetic */ List b(SaverScope r0, EnterAlwaysSearchBarScrollBehavior r1) {
            return Saver$lambda$0(r0, r1);
        }

        private static final List Saver$lambda$0(SaverScope r2, EnterAlwaysSearchBarScrollBehavior r3) {
            return CollectionsKt.listOf(new Object[]{Float.valueOf(r3.getScrollOffset()), Float.valueOf(r3.getScrollOffsetLimit()), Boolean.valueOf(r3.getReverseLayout())});
        }

        public final Saver<EnterAlwaysSearchBarScrollBehavior, ?> Saver(final Function0<Boolean> r3, final AnimationSpec<Float> r4, final DecayAnimationSpec<Float> r5) {
            return ListSaverKt.listSaver(new ga(), new ha(r3, r4, r5));
        }

        private static final EnterAlwaysSearchBarScrollBehavior Saver$lambda$1(Function0 r9, AnimationSpec r10, DecayAnimationSpec r11, List r12) {
            Object r0 = ListProtector.get(r12, 0);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Float");
            float r3 = ((Float) r0).floatValue();
            Object r1 = ListProtector.get(r12, 1);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Float");
            float r4 = ((Float) r1).floatValue();
            Object r13 = ListProtector.get(r12, 2);
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Boolean");
            return new EnterAlwaysSearchBarScrollBehavior(r3, r4, r9, ((Boolean) r13).booleanValue(), r10, r11);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$searchBarScrollBehavior$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.EnterAlwaysSearchBarScrollBehavior$searchBarScrollBehavior$2", f = "SearchBar.kt", i = {}, l = {904}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        /* synthetic */ float F$0;
        int label;
        final /* synthetic */ EnterAlwaysSearchBarScrollBehavior this$0;

        public AnonymousClass2(EnterAlwaysSearchBarScrollBehavior r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((CoroutineScope) r1, ((Number) r2).floatValue(), (Continuation) r3);
        }

        public final Object invoke(CoroutineScope r2, float r3, Continuation<? super Unit> r4) {
            AnonymousClass2 r5 = new AnonymousClass2(this.this$0, r4);
            r5.F$0 = r3;
            return r5.invokeSuspend(Unit.INSTANCE);
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
            float r5 = this.F$0;
            EnterAlwaysSearchBarScrollBehavior r2 = this.this$0;
            this.label = 1;
            if (EnterAlwaysSearchBarScrollBehavior.m2652access$settleSearchBarOhffZ5M(r2, r5, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(EnterAlwaysSearchBarScrollBehavior r0, IntSize r1) {
        return searchBarScrollBehavior$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit b(Ref.FloatRef r0, EnterAlwaysSearchBarScrollBehavior r1, Ref.FloatRef r2, AnimationScope r3) {
        return settleSearchBar_OhffZ5M$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ MeasureResult c(EnterAlwaysSearchBarScrollBehavior r0, MeasureScope r1, Measurable r2, Constraints r3) {
        return searchBarScrollBehavior$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit d(Placeable r0, int r1, Placeable.PlacementScope r2) {
        return searchBarScrollBehavior$lambda$2$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(EnterAlwaysSearchBarScrollBehavior r0, AnimationScope r1) {
        return settleSearchBar_OhffZ5M$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit f(EnterAlwaysSearchBarScrollBehavior r0, float r1) {
        return searchBarScrollBehavior$lambda$0(r0, r1);
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getScrollOffset() {
        return this._offset.getFloatValue();
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public float getScrollOffsetLimit() {
        return this.scrollOffsetLimit$delegate.getFloatValue();
    }

    public final Function0<Boolean> getCanScroll() {
        return this.canScroll;
    }

    public final DecayAnimationSpec<Float> getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public Modifier searchBarScrollBehavior(Modifier r12) {
        Orientation r2 = Orientation.Vertical;
        return OnRemeasuredModifierKt.onSizeChanged(LayoutModifierKt.layout(ClipKt.clipToBounds(DraggableKt.draggable$default(r12, DraggableKt.DraggableState(new aa(this)), r2, ((Boolean) this.canScroll.invoke()).booleanValue(), null, false, null, new AnonymousClass2(this, null), false, 184, null)), new ba(this)), new ca(this));
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setScrollOffset(float r4) {
        this._offset.setFloatValue(RangesKt.coerceIn(r4, getScrollOffsetLimit(), MenuKt.ClosedAlphaTarget));
    }

    @Override // androidx.compose.material3.SearchBarScrollBehavior
    public void setScrollOffsetLimit(float r2) {
        this.scrollOffsetLimit$delegate.setFloatValue(r2);
    }

    private static final Unit searchBarScrollBehavior$lambda$0(EnterAlwaysSearchBarScrollBehavior r1, float r2) {
        r1.setScrollOffset(r1.getScrollOffset() + r2);
        return Unit.INSTANCE;
    }

    private static final Unit searchBarScrollBehavior$lambda$3(EnterAlwaysSearchBarScrollBehavior r4, IntSize r5) {
        r4.setScrollOffsetLimit(-((int) (r5.unbox-impl() & 4294967295L)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: settleSearchBar-OhffZ5M, reason: not valid java name */
    private final Object m2653settleSearchBarOhffZ5M(float r24, Continuation<? super Velocity> r25) {
        if ((r25 instanceof EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1) == false) goto L7;
        EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1 r2 = (EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1) r25;
        int r3 = r2.label;
        if ((r3 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r2.label = r3 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r1 = r2.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        Ref.FloatRef r5 = (Ref.FloatRef) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L49:
        final Ref.FloatRef r13 = r5;
    L51:
        return Velocity.box-impl(VelocityKt.Velocity(MenuKt.ClosedAlphaTarget, r13.element));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r6 = r2.F$0;
        Ref.FloatRef r7 = (Ref.FloatRef) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L36:
        float r8 = r6;
        r13 = r7;
    L38:
        if (getScrollOffsetLimit() >= getScrollOffset()) goto L51;
        if (getScrollOffset() >= MenuKt.ClosedAlphaTarget) goto L51;
        AnimationState r9 = AnimationStateKt.AnimationState$default(getScrollOffset(), MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
        if (r8 >= 0.5f) goto L44;
        float r10 = MenuKt.ClosedAlphaTarget;
    L45:
        Float r12 = Boxing.boxFloat(r10);
        AnimationSpec<Float> r14 = this.snapAnimationSpec;
        Function1 r15 = new fa(this);
        r2.L$0 = r13;
        r2.label = 2;
        if (SuspendAnimationKt.animateTo$default(r9, r12, r14, false, r15, r2, 4, null) != r11) goto L48;
        return r11;
    L48:
        r5 = r13;
        goto L49
    L44:
        r10 = getScrollOffsetLimit();
        goto L45
    L16:
        ResultKt.throwOnFailure(r1);
        boolean r16 = false;
        if (getScrollOffsetLimit() != MenuKt.ClosedAlphaTarget) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == true) goto L22;
        r8 = getScrollOffset() / getScrollOffsetLimit();
    L24:
        if (r8 < 0.01f) goto L53;
        if (r8 != 1.0f) goto L28;
        r16 = true;
    L28:
        if (r16 == true) goto L53;
        r13 = new Ref.FloatRef();
        r13.element = r24;
        if (Math.abs(r24) <= 1.0f) goto L38;
        final Ref.FloatRef r18 = new Ref.FloatRef();
        AnimationState r19 = AnimationStateKt.AnimationState$default(MenuKt.ClosedAlphaTarget, r24, 0, 0, false, 28, null);
        DecayAnimationSpec<Float> r20 = this.flingAnimationSpec;
        Function1 r21 = new ea(r18, this, r13);
        r2.L$0 = r13;
        r2.F$0 = r8;
        r2.label = 1;
        if (SuspendAnimationKt.animateDecay$default(r19, r20, false, r21, r2, 2, null) != r11) goto L35;
        return r11;
    L35:
        r6 = r8;
        r7 = r13;
    L53:
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    L22:
        r8 = MenuKt.ClosedAlphaTarget;
        goto L24
    L19:
        r17 = false;
    L7:
        r2 = new EnterAlwaysSearchBarScrollBehavior$settleSearchBar$1(this, r25);
        goto L8
    }

    private static final Unit settleSearchBar_OhffZ5M$lambda$5(EnterAlwaysSearchBarScrollBehavior r0, AnimationScope r1) {
        r0.setScrollOffset(((Number) r1.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$settleSearchBar-OhffZ5M, reason: not valid java name */
    public static final /* synthetic */ Object m2652access$settleSearchBarOhffZ5M(EnterAlwaysSearchBarScrollBehavior r0, float r1, Continuation r2) {
        return r0.m2653settleSearchBarOhffZ5M(r1, r2);
    }

    private static final Unit searchBarScrollBehavior$lambda$2$lambda$1(Placeable r8, int r9, Placeable.PlacementScope r10) {
        Placeable.PlacementScope.placeWithLayer$default(r10, r8, 0, r9, MenuKt.ClosedAlphaTarget, null, 12, null);
        return Unit.INSTANCE;
    }

    private static final MeasureResult searchBarScrollBehavior$lambda$2(EnterAlwaysSearchBarScrollBehavior r8, MeasureScope r9, Measurable r10, Constraints r11) {
        final Placeable r12 = r10.measure-BRTryo0(r11.unbox-impl());
        final int r13 = MathKt.roundToInt(r8.getScrollOffset());
        int r3 = RangesKt.coerceAtLeast(r12.getHeight() + r13, 0);
        return MeasureScope.-CC.layout$default(r9, r12.getWidth(), r3, null, new da(r12, r13), 4, null);
    }

    private static final Unit settleSearchBar_OhffZ5M$lambda$4(Ref.FloatRef r3, EnterAlwaysSearchBarScrollBehavior r4, Ref.FloatRef r5, AnimationScope r6) {
        float r0 = ((Number) r6.getValue()).floatValue() - r3.element;
        float r1 = r4.getScrollOffset();
        r4.setScrollOffset(r1 + r0);
        float r7 = Math.abs(r1 - r4.getScrollOffset());
        r3.element = ((Number) r6.getValue()).floatValue();
        r5.element = ((Number) r6.getVelocity()).floatValue();
        if (Math.abs(r0 - r7) <= 0.5f) goto L6;
        r6.cancelAnimation();
    L6:
        return Unit.INSTANCE;
    }

    public EnterAlwaysSearchBarScrollBehavior(float r1, float r2, Function0<Boolean> r3, boolean r4, AnimationSpec<Float> r5, DecayAnimationSpec<Float> r6) {
        this.canScroll = r3;
        this.reverseLayout = r4;
        this.snapAnimationSpec = r5;
        this.flingAnimationSpec = r6;
        this._offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(r1);
        this.scrollOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r2);
        this.nestedScrollConnection = new EnterAlwaysSearchBarScrollBehavior$nestedScrollConnection$1(this);
    }
}
