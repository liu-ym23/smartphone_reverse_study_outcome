package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0017\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020\u000fH\u0016JQ\u0010(\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b)J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,H\u0004¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,H\u0004¢\u0006\u0004\b0\u0010.R\u0014\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/foundation/ClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "isSuspendingPointerInputEnabled", "isSuspendingPointerInputEnabled$annotations", "()V", "createPointerInputNodeIfNeeded", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getExtendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/unit/IntSize;", "getExtendedTouchPadding-hWWAJMo", "(J)J", "downEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "update", "update-O2vRcR0", "onClickKeyDownEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onClickKeyDownEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ClickableNode extends AbstractClickableNode {
    public static final int $stable = 8;
    private PointerInputChange downEvent;
    private final boolean isSuspendingPointerInputEnabled;

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableNode$createPointerInputNodeIfNeeded$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements PointerInputEventHandler {
        final /* synthetic */ ClickableNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.ClickableNode$createPointerInputNodeIfNeeded$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.ClickableNode$createPointerInputNodeIfNeeded$1$1", f = "Clickable.kt", i = {}, l = {959}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00121 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
            /* synthetic */ long J$0;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ClickableNode this$0;

            public C00121(ClickableNode r1, Continuation<? super C00121> r2) {
                this.this$0 = r1;
                super(3, r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
                return m395invoked4ec7I((PressGestureScope) r3, ((Offset) r4).unbox-impl(), (Continuation) r5);
            }

            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m395invoked4ec7I(PressGestureScope r3, long r4, Continuation<? super Unit> r6) {
                C00121 r0 = new C00121(this.this$0, r6);
                r0.L$0 = r3;
                r0.J$0 = r4;
                return r0.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L14:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                PressGestureScope r7 = (PressGestureScope) this.L$0;
                long r3 = this.J$0;
                if (this.this$0.getEnabled() == false) goto L14;
                ClickableNode r2 = this.this$0;
                this.label = 1;
                if (r2.m305handlePressInteractiond4ec7I(r7, r3, this) != r0) goto L14;
                return r0;
            }
        }

        public AnonymousClass1(ClickableNode r1) {
            this.this$0 = r1;
        }

        public static /* synthetic */ Unit a(ClickableNode r0, Offset r1) {
            return invoke$lambda$0(r0, r1);
        }

        private static final Unit invoke$lambda$0(ClickableNode r0, Offset r1) {
            if (r0.getEnabled() == false) goto L6;
            r0.getOnClick().invoke();
        L6:
            return Unit.INSTANCE;
        }

        public final Object invoke(PointerInputScope r4, Continuation<? super Unit> r5) {
            C00121 r0 = new C00121(this.this$0, null);
            final ClickableNode r1 = this.this$0;
            Object r6 = TapGestureDetectorKt.detectTapAndPress(r4, r0, new h0(r1), r5);
            if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r6;
        L6:
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ ClickableNode(MutableInteractionSource r1, IndicationNodeFactory r2, boolean r3, boolean r4, String r5, Role r6, Function0 r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    private static /* synthetic */ void isSuspendingPointerInputEnabled$annotations() {
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo */
    public final boolean mo308onClickKeyDownEventZmokQxo(KeyEvent r1) {
        return false;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        if (this.isSuspendingPointerInputEnabled == true) goto L7;
        return null;
    L7:
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1(this));
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void onCancelPointerInput() {
        super.onCancelPointerInput();
        if (this.downEvent == null) goto L6;
        this.downEvent = null;
        handlePressInteractionCancel();
        return;
    }

    /* JADX INFO: renamed from: getExtendedTouchPadding-hWWAJMo, reason: not valid java name */
    private final long m393getExtendedTouchPaddinghWWAJMo(long r9) {
        long r0 = DelegatableNodeKt.requireDensity(this).toSize-XkaWNTQ(((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getMinimumTouchTargetSize-MYxV2XQ());
        float r3 = Math.max(MenuKt.ClosedAlphaTarget, Float.intBitsToFloat((int) (r0 >> 32)) - ((int) (r9 >> 32))) / 2.0f;
        float r10 = Math.max(MenuKt.ClosedAlphaTarget, Float.intBitsToFloat((int) (r0 & 4294967295L)) - ((int) (r9 & 4294967295L))) / 2.0f;
        long r1 = Float.floatToRawIntBits(r3);
        return Size.constructor-impl((((long) Float.floatToRawIntBits(r10)) & 4294967295L) | (r1 << 32));
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo */
    public final boolean mo309onClickKeyUpEventZmokQxo(KeyEvent r1) {
        getOnClick().invoke();
        return true;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    public void mo311onPointerEventH0pRuoY(PointerEvent r9, PointerEventPass r10, long r11) {
        super.mo311onPointerEventH0pRuoY(r9, r10, r11);
        if (this.isSuspendingPointerInputEnabled == false) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (r10 != PointerEventPass.Main) goto L42;
        PointerInputChange r12 = this.downEvent;
        if (r12 == null) goto L10;
        List r0 = r9.getChanges();
        int r4 = r0.size();
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L20;
        if (PointerEventKt.changedToUp((PointerInputChange) ListProtector.get(r0, r5)) == false) goto L18;
        r5 = r5 + 1;
        goto L15
    L18:
        boolean r1 = false;
    L21:
        if (r1 == false) goto L26;
        ((PointerInputChange) ListProtector.get(r9.getChanges(), 0)).consume();
        if (getEnabled() == false) goto L25;
        m306handlePressInteractionReleasek4lQ0M(r12.getPosition-F1C5BW0());
        getOnClick().invoke();
    L25:
        this.downEvent = null;
        return;
    L26:
        long r6 = m393getExtendedTouchPaddinghWWAJMo(r11);
        List r13 = r9.getChanges();
        int r14 = r13.size();
        int r3 = 0;
    L27:
        if (r3 >= r14) goto L38;
        PointerInputChange r7 = (PointerInputChange) ListProtector.get(r13, r3);
        if (r7.isConsumed() == false) goto L31;
    L34:
        boolean r8 = true;
    L35:
        if (r8 == true) goto L39;
        r3 = r3 + 1;
    L39:
        if (r2 == false) goto L70;
        this.downEvent = null;
        handlePressInteractionCancel();
        return;
    L70:
        return;
    L31:
        if (PointerEventKt.isOutOfBounds-jwHxaWs(r7, r11, r6) == true) goto L34;
        r8 = false;
        goto L35
    L38:
        r2 = false;
        goto L39
    L20:
        r1 = true;
        goto L21
    L10:
        if (TapGestureDetectorKt.isChangedToDown$default(r9, true, false, 2, null) == false) goto L66;
        PointerInputChange r15 = (PointerInputChange) ListProtector.get(r9.getChanges(), 0);
        r15.consume();
        this.downEvent = r15;
        if (getEnabled() == false) goto L67;
        m307handlePressInteractionStartk4lQ0M(r15.getPosition-F1C5BW0());
        return;
    L67:
        return;
    L66:
        return;
    L42:
        if (r10 == PointerEventPass.Final) goto L44;
        return;
    L44:
        if (this.downEvent == null) goto L73;
        List r16 = r9.getChanges();
        int r17 = r16.size();
        int r18 = 0;
    L46:
        if (r18 >= r17) goto L56;
        PointerInputChange r19 = (PointerInputChange) ListProtector.get(r16, r18);
        if (r19.isConsumed() == true) goto L50;
    L52:
        boolean r110 = false;
    L53:
        if (r110 == true) goto L57;
        r18 = r18 + 1;
    L57:
        if (r2 == false) goto L74;
        this.downEvent = null;
        handlePressInteractionCancel();
        return;
    L74:
        return;
    L50:
        if (Intrinsics.areEqual(r19, this.downEvent) == true) goto L52;
        r110 = true;
        goto L53
    L56:
        r2 = false;
        goto L57
    }

    private ClickableNode(MutableInteractionSource r10, IndicationNodeFactory r11, boolean r12, boolean r13, String r14, Role r15, Function0<Unit> r16) {
        super(r10, r11, r12, r13, r14, r15, r16, null);
        if (ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.isSuspendingPointerInputEnabled = r0;
        return;
    L5:
        if (ComposeFoundationFlags.isNonSuspendingPointerInputInClickableEnabled == false) goto L8;
        r0 = false;
        goto L9
    }

    /* JADX INFO: renamed from: update-O2vRcR0, reason: not valid java name */
    public final void m394updateO2vRcR0(MutableInteractionSource r1, IndicationNodeFactory r2, boolean r3, boolean r4, String r5, Role r6, Function0<Unit> r7) {
        m313updateCommonO2vRcR0(r1, r2, r3, r4, r5, r6, r7);
    }
}
