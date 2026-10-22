package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.relocation.BringIntoViewModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001<B3\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010 \u001a\u00020\rJ\u0010\u0010%\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020'H\u0002J\f\u0010-\u001a\u00020\u000e*\u00020.H\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u001dH\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020\u000eH\u0002J\u0010\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\rH\u0002J\b\u00108\u001a\u00020\u000eH\u0002J\u0014\u00109\u001a\u00020\u000e*\u00020\b2\u0006\u0010:\u001a\u00020;H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006="}, d2 = {"Landroidx/compose/foundation/FocusableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "onFocusChange", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "focusedInteraction", "Landroidx/compose/foundation/interaction/FocusInteraction$Focus;", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "globalLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusTargetNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "requestFocus", "focusedBoundsObserver", "Landroidx/compose/foundation/FocusedBoundsObserverNode;", "getFocusedBoundsObserver", "()Landroidx/compose/foundation/FocusedBoundsObserverNode;", "update", "focusState", "Landroidx/compose/ui/focus/FocusState;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "onFocusStateChange", "previousState", "currentState", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onReset", "onObservedReadsChanged", "onGloballyPositioned", "coordinates", "retrievePinnableContainer", "Landroidx/compose/ui/layout/PinnableContainer;", "notifyObserverWhenAttached", "emitInteraction", "isFocused", "disposeInteractionSource", "emitWithFallback", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "TraverseKey", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusableNode extends DelegatingNode implements SemanticsModifierNode, GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, TraversableNode {
    public static final int $stable = 0;
    private static final TraverseKey TraverseKey = null;
    private final FocusTargetModifierNode focusTargetNode;
    private FocusInteraction.Focus focusedInteraction;
    private LayoutCoordinates globalLayoutCoordinates;
    private MutableInteractionSource interactionSource;
    private final Function1<Boolean, Unit> onFocusChange;
    private PinnableContainer.PinnedHandle pinnedHandle;
    private final boolean shouldAutoInvalidate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/FocusableNode$TraverseKey;", "", "<init>", "()V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TraverseKey {
        private TraverseKey() {
        }

        public /* synthetic */ TraverseKey(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableNode$applySemantics$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        public AnonymousClass1(Object r8) {
            super(0, r8, FocusableNode.class, "requestFocus", "requestFocus()Z", 0);
        }

        public final Boolean invoke() {
            return Boolean.valueOf(((FocusableNode) ((CallableReference) this).receiver).requestFocus());
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m403invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableNode$emitWithFallback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.FocusableNode$emitWithFallback$1", f = "Focusable.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.m0 $handler;
        final /* synthetic */ Interaction $interaction;
        final /* synthetic */ MutableInteractionSource $this_emitWithFallback;
        int label;

        public C01261(MutableInteractionSource r1, Interaction r2, kotlinx.coroutines.m0 r3, Continuation<? super C01261> r4) {
            this.$this_emitWithFallback = r1;
            this.$interaction = r2;
            this.$handler = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01261(this.$this_emitWithFallback, this.$interaction, this.$handler, r5);
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
        L11:
            kotlinx.coroutines.m0 r5 = this.$handler;
            if (r5 == null) goto L15;
            r5.dispose();
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableInteractionSource r6 = this.$this_emitWithFallback;
            Interaction r2 = this.$interaction;
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.FocusableNode$onFocusStateChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.FocusableNode$onFocusStateChange$1", f = "Focusable.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FocusableNode this$0;

        public C01271(FocusableNode r1, Continuation<? super C01271> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01271(this.this$0, r3);
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
            FocusableNode r5 = this.this$0;
            this.label = 1;
            if (BringIntoViewModifierNodeKt.bringIntoView$default(r5, null, this, 1, null) != r0) goto L12;
            return r0;
        }
    }

    static {
        TraverseKey = new TraverseKey(null);
        $stable = 8;
    }

    public /* synthetic */ FocusableNode(MutableInteractionSource r1, int r2, Function1 r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public static /* synthetic */ Unit a(Ref.ObjectRef r0, FocusableNode r1) {
        return retrievePinnableContainer$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(MutableInteractionSource r0, Interaction r1, Throwable r2) {
        return emitWithFallback$lambda$6(r0, r1, r2);
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

    private final void disposeInteractionSource() {
        MutableInteractionSource r0 = this.interactionSource;
        if (r0 == null) goto L7;
        FocusInteraction.Focus r1 = this.focusedInteraction;
        if (r1 == null) goto L7;
        r0.tryEmit(new FocusInteraction.Unfocus(r1));
    L7:
        this.focusedInteraction = null;
    }

    private final void notifyObserverWhenAttached() {
        LayoutCoordinates r0 = this.globalLayoutCoordinates;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        if (r0.isAttached() == false) goto L11;
        FocusedBoundsObserverNode r1 = getFocusedBoundsObserver();
        if (r1 == null) goto L12;
        r1.onFocusBoundsChanged(this.globalLayoutCoordinates);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final PinnableContainer retrievePinnableContainer() {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new n0(r0, this));
        return (PinnableContainer) r0.element;
    }

    public final FocusState getFocusState() {
        return this.focusTargetNode.getFocusState();
    }

    public void onReset() {
        PinnableContainer.PinnedHandle r0 = this.pinnedHandle;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.pinnedHandle = null;
    }

    public final boolean requestFocus() {
        return FocusTargetModifierNode.-CC.requestFocus-3ESFkO8$default(this.focusTargetNode, 0, 1, null);
    }

    private final FocusedBoundsObserverNode getFocusedBoundsObserver() {
        if (isAttached() == false) goto L8;
        TraversableNode r0 = TraversableNodeKt.findNearestAncestor(this, FocusedBoundsObserverNode.TraverseKey);
        if ((r0 instanceof FocusedBoundsObserverNode) == true) goto L7;
        return null;
    L7:
        return (FocusedBoundsObserverNode) r0;
    L8:
        return null;
    }

    public void onObservedReadsChanged() {
        PinnableContainer r0 = retrievePinnableContainer();
        if (this.focusTargetNode.getFocusState().isFocused() == false) goto L12;
        PinnableContainer.PinnedHandle r1 = this.pinnedHandle;
        if (r1 == null) goto L7;
        r1.release();
    L7:
        if (r0 == null) goto L9;
        PinnableContainer.PinnedHandle r2 = r0.pin();
    L10:
        this.pinnedHandle = r2;
        return;
    L9:
        r2 = null;
        goto L10
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public Object getTraverseKey() {
        return TraverseKey;
    }

    private final void emitInteraction(boolean r4) {
        MutableInteractionSource r0 = this.interactionSource;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 == false) goto L10;
        FocusInteraction.Focus r5 = this.focusedInteraction;
        if (r5 == null) goto L9;
        emitWithFallback(r0, new FocusInteraction.Unfocus(r5));
        this.focusedInteraction = null;
    L9:
        FocusInteraction.Focus r6 = new FocusInteraction.Focus();
        emitWithFallback(r0, r6);
        this.focusedInteraction = r6;
        return;
    L10:
        FocusInteraction.Focus r7 = this.focusedInteraction;
        if (r7 == null) goto L16;
        emitWithFallback(r0, new FocusInteraction.Unfocus(r7));
        this.focusedInteraction = null;
        return;
    }

    public void applySemantics(SemanticsPropertyReceiver r4) {
        SemanticsPropertiesKt.setFocused(r4, this.focusTargetNode.getFocusState().isFocused());
        SemanticsPropertiesKt.requestFocus$default(r4, null, new AnonymousClass1(this), 1, null);
    }

    public void onGloballyPositioned(LayoutCoordinates r2) {
        this.globalLayoutCoordinates = r2;
        if (this.focusTargetNode.getFocusState().isFocused() == true) goto L6;
        return;
    L6:
        if (r2.isAttached() == false) goto L8;
        notifyObserverWhenAttached();
        return;
    L8:
        FocusedBoundsObserverNode r3 = getFocusedBoundsObserver();
        if (r3 == null) goto L13;
        r3.onFocusBoundsChanged(null);
        return;
    }

    public final void update(MutableInteractionSource r2) {
        if (Intrinsics.areEqual(this.interactionSource, r2) == true) goto L6;
        disposeInteractionSource();
        this.interactionSource = r2;
        return;
    }

    private final void emitWithFallback(final MutableInteractionSource r9, final Interaction r10) {
        if (isAttached() == false) goto L9;
        Job r0 = getCoroutineScope().getCoroutineContext().get(Job.Key);
        if (r0 == null) goto L7;
        kotlinx.coroutines.m0 r1 = r0.invokeOnCompletion(new m0(r9, r10));
    L8:
        BuildersKt.launch$default(getCoroutineScope(), null, null, new C01261(r9, r10, r1, null), 3, null);
        return;
    L7:
        r1 = null;
        goto L8
    L9:
        r9.tryEmit(r10);
    }

    private final void onFocusStateChange(FocusState r7, FocusState r8) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        boolean r9 = r8.isFocused();
        if (r9 != r7.isFocused()) goto L8;
        return;
    L8:
        Function1<Boolean, Unit> r10 = this.onFocusChange;
        if (r10 == null) goto L11;
        r10.invoke(Boolean.valueOf(r9));
    L11:
        PinnableContainer.PinnedHandle r11 = null;
        if (r9 == false) goto L17;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new C01271(this, null), 3, null);
        PinnableContainer r0 = retrievePinnableContainer();
        if (r0 == null) goto L16;
        r11 = r0.pin();
    L16:
        this.pinnedHandle = r11;
        notifyObserverWhenAttached();
    L23:
        SemanticsModifierNodeKt.invalidateSemantics(this);
        emitInteraction(r9);
        return;
    L17:
        PinnableContainer.PinnedHandle r1 = this.pinnedHandle;
        if (r1 == null) goto L20;
        r1.release();
    L20:
        this.pinnedHandle = null;
        FocusedBoundsObserverNode r2 = getFocusedBoundsObserver();
        if (r2 == null) goto L23;
        r2.onFocusBoundsChanged(null);
        goto L23
    }

    private static final Unit retrievePinnableContainer$lambda$0(Ref.ObjectRef r1, FocusableNode r2) {
        r1.element = CompositionLocalConsumerModifierNodeKt.currentValueOf(r2, PinnableContainerKt.getLocalPinnableContainer());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FocusableNode(MutableInteractionSource r1, int r2, Function1<? super Boolean, Unit> r3) {
        this.interactionSource = r1;
        this.onFocusChange = r3;
        this.focusTargetNode = delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode-PYyLHbc(r2, new FocusableNode$focusTargetNode$1(this)));
    }

    public static final /* synthetic */ void access$onFocusStateChange(FocusableNode r0, FocusState r1, FocusState r2) {
        r0.onFocusStateChange(r1, r2);
    }

    private static final Unit emitWithFallback$lambda$6(MutableInteractionSource r0, Interaction r1, Throwable r2) {
        r0.tryEmit(r1);
        return Unit.INSTANCE;
    }

    public /* synthetic */ FocusableNode(MutableInteractionSource r1, int r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = Focusability.Companion.getAlways-LCbbffg();
    L5:
        DefaultConstructorMarker r6 = null;
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3, r6);
    }
}
