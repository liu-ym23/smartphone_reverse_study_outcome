package androidx.compose.foundation;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u000e\u0010\u0016\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/HoverableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "updateInteractionSource", "", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onDetach", "emitEnter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitExit", "tryEmitExit", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {
    private HoverInteraction.Enter hoverInteraction;
    private MutableInteractionSource interactionSource;

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitEnter$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", i = {0}, l = {106}, m = "emitEnter", n = {"interaction"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HoverableNode this$0;

        public AnonymousClass1(HoverableNode r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return HoverableNode.access$emitEnter(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.HoverableNode$emitExit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", i = {}, l = {114}, m = "emitExit", n = {}, s = {})
    public static final class C01281 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HoverableNode this$0;

        public C01281(HoverableNode r1, Continuation<? super C01281> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return HoverableNode.access$emitExit(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final /* synthetic */ long m408getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.-CC.$default$getTouchBoundsExpansion-RZrCHBk(this);
    }

    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.-CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public final /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.-CC.$default$onDensityChange(this);
    }

    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.-CC.$default$onViewConfigurationChange(this);
    }

    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.-CC.$default$sharePointerInputWithSiblings(this);
    }

    private final void tryEmitExit() {
        HoverInteraction.Enter r0 = this.hoverInteraction;
        if (r0 == null) goto L6;
        HoverInteraction.Exit r1 = new HoverInteraction.Exit(r0);
        this.interactionSource.tryEmit(r1);
        this.hoverInteraction = null;
        return;
    }

    public void onCancelPointerInput() {
        tryEmitExit();
    }

    public void onDetach() {
        tryEmitExit();
    }

    public HoverableNode(MutableInteractionSource r1) {
        this.interactionSource = r1;
    }

    private final Object emitEnter(Continuation<? super Unit> r5) {
        if ((r5 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r5;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        HoverInteraction.Enter r4 = (HoverInteraction.Enter) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L20:
        this.hoverInteraction = r4;
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        if (this.hoverInteraction != null) goto L22;
        HoverInteraction.Enter r7 = new HoverInteraction.Enter();
        MutableInteractionSource r8 = this.interactionSource;
        r0.L$0 = r7;
        r0.label = 1;
        if (r8.emit(r7, r0) != r2) goto L19;
        return r2;
    L19:
        r4 = r7;
    L7:
        r0 = new AnonymousClass1(this, r5);
        goto L8
    }

    private final Object emitExit(Continuation<? super Unit> r5) {
        if ((r5 instanceof C01281) == false) goto L7;
        C01281 r0 = (C01281) r5;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L19:
        this.hoverInteraction = null;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        HoverInteraction.Enter r7 = this.hoverInteraction;
        if (r7 == null) goto L21;
        HoverInteraction.Exit r4 = new HoverInteraction.Exit(r7);
        MutableInteractionSource r8 = this.interactionSource;
        r0.label = 1;
        if (r8.emit(r4, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new C01281(this, r5);
        goto L8
    }

    public final void updateInteractionSource(MutableInteractionSource r2) {
        if (Intrinsics.areEqual(this.interactionSource, r2) == true) goto L6;
        tryEmitExit();
        this.interactionSource = r2;
        return;
    }

    public static final /* synthetic */ Object access$emitEnter(HoverableNode r0, Continuation r1) {
        return r0.emitEnter(r1);
    }

    public static final /* synthetic */ Object access$emitExit(HoverableNode r0, Continuation r1) {
        return r0.emitExit(r1);
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m409onPointerEventH0pRuoY(PointerEvent r7, PointerEventPass r8, long r9) {
        if (r8 != PointerEventPass.Main) goto L11;
        int r10 = r7.getType-7fucELk();
        PointerEventType.Companion r11 = PointerEventType.Companion;
        if (PointerEventType.equals-impl0(r10, r11.getEnter-7fucELk()) == false) goto L8;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null), 3, null);
        return;
    L8:
        if (PointerEventType.equals-impl0(r10, r11.getExit-7fucELk()) == false) goto L13;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$2(this, null), 3, null);
        return;
    L13:
        return;
    }
}
