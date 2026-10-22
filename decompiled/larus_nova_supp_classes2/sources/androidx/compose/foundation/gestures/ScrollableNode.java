package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.autofill.HintConstants;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005BO\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u00104\u001a\u0002052\u0006\u00106\u001a\u00020.H\u0016¢\u0006\u0004\b7\u00108JM\u00109\u001a\u0002052=\u0010:\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110<¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002050;\u0012\n\u0012\b\u0012\u0004\u0012\u0002050/\u0012\u0006\u0012\u0004\u0018\u0001000'H\u0096@¢\u0006\u0002\u0010>J\u0017\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020.H\u0016¢\u0006\u0004\bA\u00108J\u0017\u0010B\u001a\u0002052\u0006\u0010C\u001a\u00020DH\u0016¢\u0006\u0004\bE\u00108J\u0017\u0010F\u001a\u0002052\u0006\u0010C\u001a\u00020DH\u0002¢\u0006\u0004\bG\u00108J\b\u0010H\u001a\u00020\u000fH\u0016J\b\u0010I\u001a\u000205H\u0002JN\u0010J\u001a\u0002052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010K\u001a\u000205H\u0016J\b\u0010L\u001a\u000205H\u0002J\b\u0010M\u001a\u000205H\u0016J\u0017\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020PH\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020PH\u0016¢\u0006\u0004\bT\u0010RJ'\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0016¢\u0006\u0004\b\\\u0010]J\f\u0010^\u001a\u000205*\u00020_H\u0016J\b\u0010`\u001a\u000205H\u0002J\b\u0010a\u001a\u000205H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010&\u001a4\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u000f\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010-\u001a \b\u0001\u0012\u0004\u0012\u00020.\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0/\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "mouseWheelScrollingLogic", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic;", "dispatchScrollDeltaInfo", "", "delta", "dispatchScrollDeltaInfo-k-4lQ0M", "(J)V", "drag", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "onWheelScrollStopped", "onWheelScrollStopped-TH1AsA0", "startDragImmediately", "ensureMouseWheelScrollNodeInitialized", "update", "onAttach", "updateDefaultFlingBehavior", "onDensityChange", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "setScrollSemanticsActions", "clearScrollSemanticsActions", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollableNode extends DragGestureNode implements KeyInputModifierNode, SemanticsModifierNode, CompositionLocalConsumerModifierNode, OnScrollChangedDispatcher {
    public static final int $stable = 8;
    private final ContentInViewNode contentInViewNode;
    private final DefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private MouseWheelScrollingLogic mouseWheelScrollingLogic;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;
    private final ScrollableContainerNode scrollableContainerNode;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableNode$ensureMouseWheelScrollNodeInitialized$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function2<Velocity, Continuation<? super Unit>, Object>, SuspendFunction {
        public AnonymousClass1(Object r8) {
            super(2, r8, ScrollableNode.class, "onWheelScrollStopped", "onWheelScrollStopped-TH1AsA0(J)V", 4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
            return m688invokesFctU(((Velocity) r3).unbox-impl(), (Continuation) r4);
        }

        /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
        public final Object m688invokesFctU(long r2, Continuation<? super Unit> r4) {
            return ScrollableNode.access$ensureMouseWheelScrollNodeInitialized$onWheelScrollStopped((ScrollableNode) ((AdaptedFunctionReference) this).receiver, r2, r4);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "offset"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$2", f = "Scrollable.kt", i = {}, l = {532}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {
        /* synthetic */ long J$0;
        int label;
        final /* synthetic */ ScrollableNode this$0;

        public AnonymousClass2(ScrollableNode r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.J$0 = ((Offset) r3).unbox-impl();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
            return m689invoke3MmeM6k(((Offset) r3).unbox-impl(), (Continuation) r4);
        }

        /* JADX INFO: renamed from: invoke-3MmeM6k, reason: not valid java name */
        public final Object m689invoke3MmeM6k(long r1, Continuation<? super Offset> r3) {
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
            ScrollingLogic r7 = ScrollableNode.access$getScrollingLogic$p(this.this$0);
            this.label = 1;
            r6 = ScrollableKt.m667access$semanticsScrollByd4ec7I(r7, r3, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ boolean b(ScrollableNode r0) {
        return scrollingLogic$lambda$0(r0);
    }

    public static /* synthetic */ boolean c(ScrollableNode r0, float r1, float r2) {
        return setScrollSemanticsActions$lambda$6(r0, r1, r2);
    }

    private final void clearScrollSemanticsActions() {
        this.scrollByAction = null;
        this.scrollByOffsetAction = null;
    }

    public static /* synthetic */ Unit d(ScrollableNode r0, LayoutCoordinates r1) {
        return _init_$lambda$1(r0, r1);
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

    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean m687onPreKeyEventZmokQxo(KeyEvent r1) {
        return false;
    }

    private final void ensureMouseWheelScrollNodeInitialized() {
        if (this.mouseWheelScrollingLogic != null) goto L5;
        this.mouseWheelScrollingLogic = new MouseWheelScrollingLogic(this.scrollingLogic, AndroidScrollable_androidKt.platformScrollConfig(this), new AnonymousClass1(this), DelegatableNodeKt.requireDensity(this));
    L5:
        MouseWheelScrollingLogic r0 = this.mouseWheelScrollingLogic;
        if (r0 == null) goto L9;
        r0.startReceivingMouseWheelEvents(getCoroutineScope());
        return;
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new f2(this);
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

    public void onAttach() {
        updateDefaultFlingBehavior();
        MouseWheelScrollingLogic r0 = this.mouseWheelScrollingLogic;
        if (r0 == null) goto L6;
        r0.updateDensity(DelegatableNodeKt.requireDensity(this));
        return;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDensityChange() {
        onCancelPointerInput();
        updateDefaultFlingBehavior();
        MouseWheelScrollingLogic r0 = this.mouseWheelScrollingLogic;
        if (r0 == null) goto L6;
        r0.updateDensity(DelegatableNodeKt.requireDensity(this));
        return;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public static final /* synthetic */ ScrollingLogic access$getScrollingLogic$p(ScrollableNode r0) {
        return r0.scrollingLogic;
    }

    /* JADX INFO: renamed from: onWheelScrollStopped-TH1AsA0, reason: not valid java name */
    private final void m685onWheelScrollStoppedTH1AsA0(long r8) {
        BuildersKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onWheelScrollStopped$1(this, r8, null), 3, null);
    }

    private static final boolean scrollingLogic$lambda$0(ScrollableNode r0) {
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

    @Override // androidx.compose.foundation.gestures.OnScrollChangedDispatcher
    /* JADX INFO: renamed from: dispatchScrollDeltaInfo-k-4lQ0M */
    public void mo616dispatchScrollDeltaInfok4lQ0M(long r2) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        DelegatableNodeKt.dispatchOnScrollChanged-Uv8p0NA(this, r2);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-TH1AsA0 */
    public void mo544onDragStoppedTH1AsA0(long r8) {
        BuildersKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onDragStopped$1(this, r8, null), 3, null);
    }

    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean m686onKeyEventZmokQxo(KeyEvent r11) {
        if (getEnabled() == false) goto L25;
        long r0 = KeyEvent_androidKt.getKey-ZmokQxo(r11);
        Key.Companion r2 = Key.Companion;
        if (Key.equals-impl0(r0, r2.getPageDown-EK5gGoQ()) == true) goto L9;
        if (Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(r11), r2.getPageUp-EK5gGoQ()) == false) goto L25;
    L9:
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(r11), KeyEventType.Companion.getKeyDown-CS__XNY()) == false) goto L25;
        if (KeyEvent_androidKt.isCtrlPressed-ZmokQxo(r11) == true) goto L25;
        if (this.scrollingLogic.isVertical() == false) goto L19;
        int r1 = (int) (this.contentInViewNode.m557getViewportSizeYbymL2g$foundation_release() & 4294967295L);
        if (Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(r11), r2.getPageUp-EK5gGoQ()) == false) goto L17;
        float r12 = r1;
    L18:
        long r3 = Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r12)) & 4294967295L));
    L24:
        BuildersKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(this, r3, null), 3, null);
        return true;
    L17:
        r12 = -r1;
        goto L18
    L19:
        int r4 = (int) (this.contentInViewNode.m557getViewportSizeYbymL2g$foundation_release() >> 32);
        if (Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(r11), r2.getPageUp-EK5gGoQ()) == false) goto L22;
        float r13 = r4;
    L23:
        long r6 = Float.floatToRawIntBits(r13);
        r3 = Offset.constructor-impl((((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L) | (r6 << 32));
        goto L24
    L22:
        r13 = -r4;
    L25:
        return false;
    }

    private static final Unit _init_$lambda$1(ScrollableNode r0, LayoutCoordinates r1) {
        r0.contentInViewNode.onFocusBoundsChanged(r1);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        ScrollingLogic r0 = this.scrollingLogic;
        Object r7 = r0.scroll(MutatePriority.UserInput, new ScrollableNode$drag$2$1(r5, r0, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$ensureMouseWheelScrollNodeInitialized$onWheelScrollStopped(ScrollableNode r0, long r1, Continuation r3) {
        return ensureMouseWheelScrollNodeInitialized$onWheelScrollStopped(r0, r1, r3);
    }

    private static final /* synthetic */ Object ensureMouseWheelScrollNodeInitialized$onWheelScrollStopped(ScrollableNode r0, long r1, Continuation r3) {
        r0.m685onWheelScrollStoppedTH1AsA0(r1);
        return Unit.INSTANCE;
    }

    private static final boolean setScrollSemanticsActions$lambda$6(ScrollableNode r6, float r7, float r8) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, null, new ScrollableNode$setScrollSemanticsActions$1$1(r6, r7, r8, null), 3, null);
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
        if (r2 == false) goto L11;
        super.mo590onPointerEventH0pRuoY(r7, r8, r9);
    L11:
        if (getEnabled() == true) goto L13;
        return;
    L13:
        if (r8 == PointerEventPass.Initial) goto L15;
    L17:
        MouseWheelScrollingLogic r5 = this.mouseWheelScrollingLogic;
        if (r5 == null) goto L24;
        r5.m607onPointerEventH0pRuoY(r7, r8, r9);
        return;
    L24:
        return;
    L15:
        if (PointerEventType.equals-impl0(r7.getType-7fucELk(), PointerEventType.Companion.getScroll-7fucELk()) == false) goto L17;
        ensureMouseWheelScrollNodeInitialized();
        goto L17
    }

    public ScrollableNode(ScrollableState r17, OverscrollEffect r18, FlingBehavior r19, Orientation r20, boolean r21, boolean r22, MutableInteractionSource r23, BringIntoViewSpec r24) {
        super(ScrollableKt.getCanDragCalculation(), r21, r23, r20);
        this.overscrollEffect = r18;
        this.flingBehavior = r19;
        NestedScrollDispatcher r12 = new NestedScrollDispatcher();
        this.nestedScrollDispatcher = r12;
        this.scrollableContainerNode = delegate(new ScrollableContainerNode(r21));
        MotionDurationScale r13 = null;
        DefaultFlingBehavior r0 = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.getUnityDensity()), r13, 2, r13);
        this.defaultFlingBehavior = r0;
        OverscrollEffect r2 = this.overscrollEffect;
        FlingBehavior r1 = this.flingBehavior;
        if (r1 != null) goto L5;
        FlingBehavior r3 = r0;
    L6:
        ScrollingLogic r15 = new ScrollingLogic(r17, r2, r3, r20, r22, r12, this, new g2(this));
        this.scrollingLogic = r15;
        ScrollableNestedScrollConnection r4 = new ScrollableNestedScrollConnection(r15, r21);
        this.nestedScrollConnection = r4;
        ContentInViewNode r5 = delegate(new ContentInViewNode(r20, r15, r22, r24));
        this.contentInViewNode = r5;
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(r4, r12));
        delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode-PYyLHbc$default(Focusability.Companion.getNever-LCbbffg(), null, 2, null));
        delegate(new BringIntoViewResponderNode(r5));
        delegate(new FocusedBoundsObserverNode(new h2(this)));
        return;
    L5:
        r3 = r1;
        goto L6
    }

    public final void update(ScrollableState r16, Orientation r17, OverscrollEffect r18, boolean r19, boolean r20, FlingBehavior r21, MutableInteractionSource r22, BringIntoViewSpec r23) {
        if (getEnabled() == r19) goto L5;
        this.nestedScrollConnection.setEnabled(r19);
        this.scrollableContainerNode.update(r19);
        boolean r7 = true;
    L6:
        if (r21 != null) goto L8;
        FlingBehavior r13 = this.defaultFlingBehavior;
    L9:
        boolean r5 = this.scrollingLogic.update(r16, r17, r18, r20, r13, this.nestedScrollDispatcher);
        this.contentInViewNode.update(r17, r20, r23);
        this.overscrollEffect = r18;
        this.flingBehavior = r21;
        Function1<PointerInputChange, Boolean> r1 = ScrollableKt.getCanDragCalculation();
        if (this.scrollingLogic.isVertical() == false) goto L12;
        Orientation r0 = Orientation.Vertical;
    L13:
        update(r1, r19, r22, r0, r5);
        if (r7 == false) goto L17;
        clearScrollSemanticsActions();
        SemanticsModifierNodeKt.invalidateSemantics(this);
        return;
    L17:
        return;
    L12:
        r0 = Orientation.Horizontal;
        goto L13
    L8:
        r13 = r21;
        goto L9
    L5:
        r7 = false;
        goto L6
    }
}
