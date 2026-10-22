package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJM\u0010)\u001a\u00020*2=\u0010+\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020*0,\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0&\u0012\u0006\u0012\u0004\u0018\u00010'0\u001eH\u0096@¢\u0006\u0002\u0010/J\u0017\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020%H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020*2\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\b7\u00103J\b\u00108\u001a\u00020\u000bH\u0016J4\u00109\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010:\u001a\u00020*H\u0016J\b\u0010;\u001a\u00020*H\u0002J\b\u0010<\u001a\u00020*H\u0016J'\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\f\u0010F\u001a\u00020**\u00020GH\u0016J\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020*H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010$\u001a \b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0&\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010(¨\u0006J"}, d2 = {"Landroidx/compose/foundation/gestures/Scrollable2DNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "drag", "", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "startDragImmediately", "update", "onAttach", "updateDefaultFlingBehavior", "onDensityChange", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "setScrollSemanticsActions", "clearScrollSemanticsActions", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Scrollable2DNode extends DragGestureNode implements SemanticsModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private final DefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;
    private final ScrollableContainerNode scrollableContainerNode;
    private final ScrollingLogic2D scrollingLogic;
    private final boolean shouldAutoInvalidate;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.Scrollable2DNode$setScrollSemanticsActions$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "offset"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.Scrollable2DNode$setScrollSemanticsActions$2", f = "Scrollable2D.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {
        /* synthetic */ long J$0;
        int label;
        final /* synthetic */ Scrollable2DNode this$0;

        public AnonymousClass2(Scrollable2DNode r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.J$0 = ((Offset) r3).unbox-impl();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
            return m665invoke3MmeM6k(((Offset) r3).unbox-impl(), (Continuation) r4);
        }

        /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
        public final Object m665invoke3MmeM6k(long r1, Continuation<? super Offset> r3) {
            return create(Offset.box-impl(r1), r3).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r3 = this.J$0;
            ScrollingLogic2D r7 = Scrollable2DNode.access$getScrollingLogic$p(this.this$0);
            this.label = 1;
            r6 = Scrollable2DKt.m661access$semanticsScrollByd4ec7I(r7, r3, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ boolean b(Scrollable2DNode r0, float r1, float r2) {
        return setScrollSemanticsActions$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ boolean c(Scrollable2DNode r0) {
        return scrollingLogic$lambda$0(r0);
    }

    private final void clearScrollSemanticsActions() {
        this.scrollByAction = null;
        this.scrollByOffsetAction = null;
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M */
    public void mo543onDragStartedk4lQ0M(long r1) {
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new z1(this);
        this.scrollByOffsetAction = new AnonymousClass2(this, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    private final void updateDefaultFlingBehavior() {
        if (isAttached() == true) goto L5;
        return;
    L5:
        Density r0 = DelegatableNodeKt.requireDensity(this);
        this.defaultFlingBehavior.updateDensity(r0);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDensityChange() {
        onCancelPointerInput();
        updateDefaultFlingBehavior();
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public void onAttach() {
        updateDefaultFlingBehavior();
    }

    public static final /* synthetic */ ScrollingLogic2D access$getScrollingLogic$p(Scrollable2DNode r0) {
        return r0.scrollingLogic;
    }

    private static final boolean scrollingLogic$lambda$0(Scrollable2DNode r0) {
        return r0.isAttached();
    }

    public void applySemantics(SemanticsPropertyReceiver r4) {
        if (getEnabled() == true) goto L5;
    L9:
        Function2<? super Float, ? super Float, Boolean> r0 = this.scrollByAction;
        if (r0 == null) goto L12;
        SemanticsPropertiesKt.scrollBy$default(r4, null, r0, 1, null);
    L12:
        Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> r1 = this.scrollByOffsetAction;
        if (r1 == null) goto L16;
        SemanticsPropertiesKt.scrollByOffset(r4, r1);
        return;
    L16:
        return;
    L5:
        if (this.scrollByAction != null) goto L7;
    L8:
        setScrollSemanticsActions();
        goto L9
    L7:
        if (this.scrollByOffsetAction != null) goto L9;
        goto L8
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-TH1AsA0 */
    public void mo544onDragStoppedTH1AsA0(long r8) {
        BuildersKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new Scrollable2DNode$onDragStopped$1(this, r8, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        Object r7 = this.scrollingLogic.scroll(MutatePriority.UserInput, new Scrollable2DNode$drag$2$1(r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    private static final boolean setScrollSemanticsActions$lambda$5(Scrollable2DNode r6, float r7, float r8) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, null, new Scrollable2DNode$setScrollSemanticsActions$1$1(r6, r7, r8, null), 3, null);
        return true;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo590onPointerEventH0pRuoY(PointerEvent r7, PointerEventPass r8, long r9) {
        List r0 = r7.getChanges();
        int r1 = r0.size();
        boolean r2 = false;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        PointerInputChange r4 = (PointerInputChange) ListProtector.get(r0, r3);
        if (((Boolean) getCanDrag().invoke(r4)).booleanValue() == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        r2 = true;
    L8:
        if (r2 == false) goto L13;
        super.mo590onPointerEventH0pRuoY(r7, r8, r9);
        return;
    }

    public Scrollable2DNode(Scrollable2DState r9, OverscrollEffect r10, FlingBehavior r11, boolean r12, MutableInteractionSource r13) {
        MotionDurationScale r1 = null;
        super(ScrollableKt.getCanDragCalculation(), r12, r13, null);
        this.overscrollEffect = r10;
        this.flingBehavior = r11;
        NestedScrollDispatcher r14 = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = r14;
        this.scrollableContainerNode = delegate(new ScrollableContainerNode(r12));
        DefaultFlingBehavior r15 = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.getUnityDensity()), r1, 2, r1);
        this.defaultFlingBehavior = r15;
        OverscrollEffect r4 = this.overscrollEffect;
        FlingBehavior r0 = this.flingBehavior;
        if (r0 != null) goto L5;
        FlingBehavior r5 = r15;
    L6:
        ScrollingLogic2D r16 = new ScrollingLogic2D(r9, r4, r5, r14, new a2(this));
        this.scrollingLogic = r16;
        ScrollableNestedScrollConnection r17 = new ScrollableNestedScrollConnection(r16, r12);
        this.nestedScrollConnection = r17;
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(r17, r14));
        return;
    L5:
        r5 = r0;
        goto L6
    }

    public final void update(Scrollable2DState r10, OverscrollEffect r11, boolean r12, FlingBehavior r13, MutableInteractionSource r14) {
        if (getEnabled() == r12) goto L5;
        this.nestedScrollConnection.setEnabled(r12);
        this.scrollableContainerNode.update(r12);
        boolean r8 = true;
    L6:
        if (r13 != null) goto L8;
        FlingBehavior r3 = this.defaultFlingBehavior;
    L9:
        boolean r5 = this.scrollingLogic.update(r10, r11, r3, this.nestedScrollDispatcher);
        this.overscrollEffect = r11;
        this.flingBehavior = r13;
        DragGestureNode.update$default(this, ScrollableKt.getCanDragCalculation(), r12, r14, null, r5, 8, null);
        if (r8 == false) goto L13;
        clearScrollSemanticsActions();
        SemanticsModifierNodeKt.invalidateSemantics(this);
        return;
    L13:
        return;
    L8:
        r3 = r13;
        goto L9
    L5:
        r8 = false;
        goto L6
    }
}
