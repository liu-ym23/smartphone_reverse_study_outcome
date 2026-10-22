package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u00010B\u007f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010 \u001a\u00020!H\u0016J{\u0010\"\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\b#J\f\u0010$\u001a\u00020\u0005*\u00020%H\u0016J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0004\b,\u0010*J\b\u0010-\u001a\u00020\u0005H\u0014J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "enabled", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHapticFeedbackEnabled", "()Z", "setHapticFeedbackEnabled", "(Z)V", "longKeyPressJobs", "Landroidx/collection/MutableLongObjectMap;", "Lkotlinx/coroutines/Job;", "doubleKeyClickStates", "Landroidx/compose/foundation/CombinedClickableNode$DoubleKeyClickState;", "createPointerInputNodeIfNeeded", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "update", "update-2tQrsxU", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "onClickKeyDownEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onClickKeyDownEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onReset", "resetKeyPressState", "DoubleKeyClickState", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CombinedClickableNode extends AbstractClickableNode {
    private final MutableLongObjectMap<DoubleKeyClickState> doubleKeyClickStates;
    private boolean hapticFeedbackEnabled;
    private final MutableLongObjectMap<Job> longKeyPressJobs;
    private Function0<Unit> onDoubleClick;
    private Function0<Unit> onLongClick;
    private String onLongClickLabel;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/CombinedClickableNode$DoubleKeyClickState;", "", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "doubleTapMinTimeMillisElapsed", "", "getDoubleTapMinTimeMillisElapsed", "()Z", "setDoubleTapMinTimeMillisElapsed", "(Z)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DoubleKeyClickState {
        public static final int $stable = 8;
        private boolean doubleTapMinTimeMillisElapsed;
        private final Job job;

        public final boolean getDoubleTapMinTimeMillisElapsed() {
            return this.doubleTapMinTimeMillisElapsed;
        }

        public final Job getJob() {
            return this.job;
        }

        public DoubleKeyClickState(Job r1) {
            this.job = r1;
        }

        public final void setDoubleTapMinTimeMillisElapsed(boolean r1) {
            this.doubleTapMinTimeMillisElapsed = r1;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements PointerInputEventHandler {
        final /* synthetic */ CombinedClickableNode this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$createPointerInputNodeIfNeeded$1$3", f = "Clickable.kt", i = {}, l = {1121}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
            /* synthetic */ long J$0;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CombinedClickableNode this$0;

            public AnonymousClass3(CombinedClickableNode r1, Continuation<? super AnonymousClass3> r2) {
                this.this$0 = r1;
                super(3, r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
                return m398invoked4ec7I((PressGestureScope) r3, ((Offset) r4).unbox-impl(), (Continuation) r5);
            }

            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m398invoked4ec7I(PressGestureScope r3, long r4, Continuation<? super Unit> r6) {
                AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r6);
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
                CombinedClickableNode r2 = this.this$0;
                this.label = 1;
                if (r2.m305handlePressInteractiond4ec7I(r7, r3, this) != r0) goto L14;
                return r0;
            }
        }

        public AnonymousClass1(CombinedClickableNode r1) {
            this.this$0 = r1;
        }

        public static /* synthetic */ Unit a(CombinedClickableNode r0, Offset r1) {
            return invoke$lambda$2(r0, r1);
        }

        public static /* synthetic */ Unit b(CombinedClickableNode r0, Offset r1) {
            return invoke$lambda$0(r0, r1);
        }

        public static /* synthetic */ Unit c(CombinedClickableNode r0, Offset r1) {
            return invoke$lambda$1(r0, r1);
        }

        private static final Unit invoke$lambda$0(CombinedClickableNode r0, Offset r1) {
            Function0 r2 = CombinedClickableNode.access$getOnDoubleClick$p(r0);
            if (r2 == null) goto L6;
            r2.invoke();
        L6:
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$1(CombinedClickableNode r0, Offset r1) {
            Function0 r2 = CombinedClickableNode.access$getOnLongClick$p(r0);
            if (r2 == null) goto L6;
            r2.invoke();
        L6:
            if (r0.getHapticFeedbackEnabled() == false) goto L9;
            ((HapticFeedback) CompositionLocalConsumerModifierNodeKt.currentValueOf(r0, CompositionLocalsKt.getLocalHapticFeedback())).performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getLongPress-5zf0vsI());
        L9:
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$2(CombinedClickableNode r0, Offset r1) {
            if (r0.getEnabled() == false) goto L6;
            r0.getOnClick().invoke();
        L6:
            return Unit.INSTANCE;
        }

        public final Object invoke(PointerInputScope r10, Continuation<? super Unit> r11) {
            if (this.this$0.getEnabled() == true) goto L5;
        L7:
            Function1 r4 = null;
        L9:
            if (this.this$0.getEnabled() == true) goto L11;
        L13:
            Function1 r5 = null;
        L14:
            AnonymousClass3 r6 = new AnonymousClass3(this.this$0, null);
            final CombinedClickableNode r0 = this.this$0;
            Object r12 = TapGestureDetectorKt.detectTapGestures(r10, r4, r5, r6, new l0(r0), r11);
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
            return r12;
        L18:
            return Unit.INSTANCE;
        L11:
            if (CombinedClickableNode.access$getOnLongClick$p(this.this$0) == null) goto L13;
            final CombinedClickableNode r1 = this.this$0;
            r5 = new k0(r1);
            goto L14
        L5:
            if (CombinedClickableNode.access$getOnDoubleClick$p(this.this$0) == null) goto L7;
            final CombinedClickableNode r2 = this.this$0;
            r4 = new j0(r2);
            goto L9
        }
    }

    public /* synthetic */ CombinedClickableNode(Function0 r1, String r2, Function0 r3, Function0 r4, boolean r5, MutableInteractionSource r6, IndicationNodeFactory r7, boolean r8, boolean r9, String r10, Role r11, DefaultConstructorMarker r12) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ boolean c(CombinedClickableNode r0) {
        return applyAdditionalSemantics$lambda$0(r0);
    }

    private final void resetKeyPressState() {
        MutableLongObjectMap<Job> r1 = this.longKeyPressJobs;
        Object[] r2 = r1.values;
        long[] r3 = r1.metadata;
        int r4 = r3.length - 2;
        long r11 = -9187201950435737472L;
        if (r4 < 0) goto L19;
        int r15 = 0;
    L5:
        long r5 = r3[r15];
        if (((((~r5) << 7) & r5) & r11) == r11) goto L17;
        int r7 = 8 - ((~(r15 - r4)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r7) goto L16;
        if ((r5 & 255) >= 128) goto L12;
        boolean r20 = true;
    L13:
        if (r20 == false) goto L15;
        Job.DefaultImpls.cancel$default((Job) r2[(r15 << 3) + r8], null, 1, null);
    L15:
        r5 = r5 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r20 = false;
        goto L13
    L16:
        if (r7 != 8) goto L19;
    L17:
        if (r15 == r4) goto L19;
        r15 = r15 + 1;
        r11 = -9187201950435737472L;
    L19:
        r1.clear();
        MutableLongObjectMap<DoubleKeyClickState> r6 = this.doubleKeyClickStates;
        Object[] r9 = r6.values;
        long[] r10 = r6.metadata;
        int r12 = r10.length - 2;
        if (r12 < 0) goto L39;
        int r13 = 0;
    L22:
        long r14 = r10[r13];
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L37;
        int r16 = 8 - ((~(r13 - r12)) >>> 31);
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L34;
        if ((r14 & 255) >= 128) goto L29;
        boolean r18 = true;
    L30:
        if (r18 == false) goto L32;
        Job.DefaultImpls.cancel$default(((DoubleKeyClickState) r9[(r13 << 3) + r17]).getJob(), null, 1, null);
    L32:
        r14 = r14 >> 8;
        r17 = r17 + 1;
        goto L25
    L29:
        r18 = false;
        goto L30
    L34:
        if (r16 != 8) goto L39;
    L37:
        if (r13 == r12) goto L39;
        r13 = r13 + 1;
    L39:
        r6.clear();
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1(this));
    }

    public void onReset() {
        super/*androidx.compose.ui.Modifier.Node*/.onReset();
        resetKeyPressState();
    }

    public final boolean getHapticFeedbackEnabled() {
        return this.hapticFeedbackEnabled;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void onCancelKeyInput() {
        resetKeyPressState();
    }

    public static final /* synthetic */ MutableLongObjectMap access$getDoubleKeyClickStates$p(CombinedClickableNode r0) {
        return r0.doubleKeyClickStates;
    }

    public static final /* synthetic */ Function0 access$getOnDoubleClick$p(CombinedClickableNode r0) {
        return r0.onDoubleClick;
    }

    public static final /* synthetic */ Function0 access$getOnLongClick$p(CombinedClickableNode r0) {
        return r0.onLongClick;
    }

    private static final boolean applyAdditionalSemantics$lambda$0(CombinedClickableNode r0) {
        Function0<Unit> r1 = r0.onLongClick;
        if (r1 == null) goto L7;
        r1.invoke();
        return true;
    L7:
        return true;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver r3) {
        if (this.onLongClick == null) goto L6;
        SemanticsPropertiesKt.onLongClick(r3, this.onLongClickLabel, new i0(this));
        return;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo */
    public boolean mo308onClickKeyDownEventZmokQxo(KeyEvent r11) {
        long r0 = KeyEvent_androidKt.getKey-ZmokQxo(r11);
        if (this.onLongClick != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        DoubleKeyClickState r4 = this.doubleKeyClickStates.get(r0);
        if (r4 != null) goto L11;
    L16:
        return r12;
    L11:
        if (r4.getJob().isActive() == false) goto L15;
        Job.DefaultImpls.cancel$default(r4.getJob(), null, 1, null);
        if (r4.getDoubleTapMinTimeMillisElapsed() == true) goto L16;
        getOnClick().invoke();
        this.doubleKeyClickStates.remove(r0);
        goto L16
    L15:
        this.doubleKeyClickStates.remove(r0);
        goto L16
    L5:
        if (this.longKeyPressJobs.get(r0) != null) goto L7;
        this.longKeyPressJobs.set(r0, BuildersKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyDownEvent$1(this, null), 3, null));
        r12 = true;
        goto L8
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo */
    public boolean mo309onClickKeyUpEventZmokQxo(KeyEvent r12) {
        long r0 = KeyEvent_androidKt.getKey-ZmokQxo(r12);
        boolean r4 = false;
        if (this.longKeyPressJobs.get(r0) == null) goto L12;
        Job r13 = this.longKeyPressJobs.get(r0);
        if (r13 != null) goto L7;
    L10:
        this.longKeyPressJobs.remove(r0);
        goto L12
    L7:
        if (r13.isActive() == false) goto L9;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
        goto L10
    L9:
        r4 = true;
    L12:
        if (this.onDoubleClick != null) goto L14;
        if (r4 == true) goto L24;
        getOnClick().invoke();
    L24:
        return true;
    L14:
        if (this.doubleKeyClickStates.get(r0) != null) goto L17;
        if (r4 == true) goto L24;
        this.doubleKeyClickStates.set(r0, new DoubleKeyClickState(BuildersKt.launch$default(getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyUpEvent$2(this, r0, null), 3, null)));
        goto L24
    L17:
        if (r4 == true) goto L21;
        Function0<Unit> r14 = this.onDoubleClick;
        if (r14 == null) goto L21;
        r14.invoke();
    L21:
        this.doubleKeyClickStates.remove(r0);
        goto L24
    }

    public final void setHapticFeedbackEnabled(boolean r1) {
        this.hapticFeedbackEnabled = r1;
    }

    /* JADX INFO: renamed from: update-2tQrsxU, reason: not valid java name */
    public final void m397update2tQrsxU(Function0<Unit> r11, String r12, Function0<Unit> r13, Function0<Unit> r14, MutableInteractionSource r15, IndicationNodeFactory r16, boolean r17, boolean r18, String r19, Role r20) {
        if (Intrinsics.areEqual(this.onLongClickLabel, r12) == true) goto L5;
        this.onLongClickLabel = r12;
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L5:
        boolean r4 = false;
        if (this.onLongClick != null) goto L8;
        boolean r0 = true;
    L9:
        if (r13 != null) goto L11;
        boolean r5 = true;
    L12:
        if (r0 == r5) goto L14;
        disposeInteractions();
        SemanticsModifierNodeKt.invalidateSemantics(this);
        boolean r1 = true;
    L15:
        this.onLongClick = r13;
        if (this.onDoubleClick != null) goto L18;
        boolean r2 = true;
    L19:
        if (r14 != null) goto L21;
        r4 = true;
    L21:
        if (r2 == r4) goto L23;
        r1 = true;
    L23:
        this.onDoubleClick = r14;
        if (getEnabled() == r18) goto L26;
        boolean r9 = true;
    L27:
        m313updateCommonO2vRcR0(r15, r16, r17, r18, r19, r20, r11);
        if (r9 == false) goto L31;
        resetPointerInputHandler();
        return;
    L31:
        return;
    L26:
        r9 = r1;
        goto L27
    L18:
        r2 = false;
        goto L19
    L14:
        r1 = false;
        goto L15
    L11:
        r5 = false;
        goto L12
    L8:
        r0 = false;
        goto L9
    }

    private CombinedClickableNode(Function0<Unit> r11, String r12, Function0<Unit> r13, Function0<Unit> r14, boolean r15, MutableInteractionSource r16, IndicationNodeFactory r17, boolean r18, boolean r19, String r20, Role r21) {
        super(r16, r17, r18, r19, r20, r21, r11, null);
        this.onLongClickLabel = r12;
        this.onLongClick = r13;
        this.onDoubleClick = r14;
        this.hapticFeedbackEnabled = r15;
        this.longKeyPressJobs = LongObjectMapKt.mutableLongObjectMapOf();
        this.doubleKeyClickStates = LongObjectMapKt.mutableLongObjectMapOf();
    }
}
