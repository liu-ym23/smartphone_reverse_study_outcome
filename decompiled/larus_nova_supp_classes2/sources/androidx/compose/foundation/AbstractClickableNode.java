package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b!\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001nBM\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\b\u00101\u001a\u00020\rH\u0002J\n\u00102\u001a\u0004\u0018\u00010#H&J\f\u00103\u001a\u00020\u0015*\u000204H\u0016JS\u00105\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0004¢\u0006\u0002\b6J\u0006\u00107\u001a\u00020\u0015J\b\u00108\u001a\u00020\u0015H\u0016J\u0006\u00109\u001a\u00020\u0015J\b\u0010:\u001a\u00020\u0015H\u0004J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\rH\u0002J\b\u0010=\u001a\u00020\u0015H\u0002J\b\u0010>\u001a\u00020\u0015H\u0002J'\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020\u0015H\u0016J\u0015\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020K¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\r2\u0006\u0010J\u001a\u00020KH$¢\u0006\u0004\bO\u0010MJ\u0017\u0010P\u001a\u00020\r2\u0006\u0010J\u001a\u00020KH$¢\u0006\u0004\bQ\u0010MJ\b\u0010R\u001a\u00020\u0015H\u0014J\u0015\u0010S\u001a\u00020\r2\u0006\u0010J\u001a\u00020K¢\u0006\u0004\bT\u0010MJ\n\u0010W\u001a\u00020\u0015*\u000204J\u000f\u0010X\u001a\u0004\u0018\u00010\u0015H\u0004¢\u0006\u0002\u0010YJ\u0017\u0010\\\u001a\u00020\u00152\u0006\u0010]\u001a\u00020-H\u0004¢\u0006\u0004\b^\u0010_J\u0017\u0010`\u001a\u00020\u00152\u0006\u0010]\u001a\u00020-H\u0004¢\u0006\u0004\ba\u0010_J\b\u0010b\u001a\u00020\u0015H\u0004J\u001c\u0010c\u001a\u00020\u0015*\u00020d2\u0006\u0010]\u001a\u00020-H\u0084@¢\u0006\u0004\be\u0010fJ\b\u0010g\u001a\u00020\rH\u0002J\b\u0010h\u001a\u00020\u0015H\u0002J\b\u0010i\u001a\u00020\u0015H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\rX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020'0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0004\n\u0002\u0010.R\u0010\u0010/\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010U\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bV\u0010\u001aR\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010j\u001a\u00020kX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010m¨\u0006o"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "getEnabled", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "localIndicationNodeFactory", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "indicationNode", "Landroidx/compose/ui/node/DelegatableNode;", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "currentKeyPressInteractions", "Landroidx/collection/MutableLongObjectMap;", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "J", "userProvidedInteractionSource", "lazilyCreateIndication", "shouldLazilyCreateIndication", "createPointerInputNodeIfNeeded", "applyAdditionalSemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "updateCommon", "updateCommon-O2vRcR0", "onAttach", "onObservedReadsChanged", "onDetach", "disposeInteractions", "onFocusChange", "isFocused", "recreateIndicationIfNeeded", "initializeIndicationAndInteractionSourceIfNeeded", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyDownEvent", "onClickKeyDownEvent-ZmokQxo", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "onCancelKeyInput", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "resetPointerInputHandler", "()Lkotlin/Unit;", "delayJob", "Lkotlinx/coroutines/Job;", "handlePressInteractionStart", "offset", "handlePressInteractionStart-k-4lQ0M", "(J)V", "handlePressInteractionRelease", "handlePressInteractionRelease-k-4lQ0M", "handlePressInteractionCancel", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "handlePressInteraction-d-4ec7I", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delayPressInteraction", "emitHoverEnter", "emitHoverExit", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "TraverseKey", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, SemanticsModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public static final int $stable = 0;
    public static final TraverseKey TraverseKey = null;
    private long centerOffset;
    private final MutableLongObjectMap<PressInteraction.Press> currentKeyPressInteractions;
    private Job delayJob;
    private boolean enabled;
    private final FocusableNode focusableNode;
    private HoverInteraction.Enter hoverInteraction;
    private DelegatableNode indicationNode;
    private IndicationNodeFactory indicationNodeFactory;
    private MutableInteractionSource interactionSource;
    private boolean lazilyCreateIndication;
    private IndicationNodeFactory localIndicationNodeFactory;
    private Function0<Unit> onClick;
    private String onClickLabel;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private PressInteraction.Press pressInteraction;
    private Role role;
    private final boolean shouldAutoInvalidate;
    private final Object traverseKey;
    private boolean useLocalIndication;
    private MutableInteractionSource userProvidedInteractionSource;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/AbstractClickableNode$TraverseKey;", "", "<init>", "()V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TraverseKey {
        private TraverseKey() {
        }

        public /* synthetic */ TraverseKey(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        TraverseKey = new TraverseKey(null);
        $stable = 8;
    }

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource r1, IndicationNodeFactory r2, boolean r3, boolean r4, String r5, Role r6, Function0 r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ boolean a(AbstractClickableNode r0) {
        return applySemantics$lambda$12(r0);
    }

    public static /* synthetic */ Unit b(AbstractClickableNode r0) {
        return onObservedReadsChanged$lambda$1(r0);
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver r1) {
    }

    public abstract SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded();

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final /* synthetic */ long m304getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.-CC.$default$getTouchBoundsExpansion-RZrCHBk(this);
    }

    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.-CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    public void onCancelKeyInput() {
    }

    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo, reason: not valid java name */
    public abstract boolean mo308onClickKeyDownEventZmokQxo(KeyEvent r1);

    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo, reason: not valid java name */
    public abstract boolean mo309onClickKeyUpEventZmokQxo(KeyEvent r1);

    public final /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.-CC.$default$onDensityChange(this);
    }

    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean m312onPreKeyEventZmokQxo(KeyEvent r1) {
        return false;
    }

    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.-CC.$default$onViewConfigurationChange(this);
    }

    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.-CC.$default$sharePointerInputWithSiblings(this);
    }

    private final void emitHoverEnter() {
        if (this.hoverInteraction != null) goto L9;
        HoverInteraction.Enter r0 = new HoverInteraction.Enter();
        MutableInteractionSource r1 = this.interactionSource;
        if (r1 == null) goto L7;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(r1, r0, null), 3, null);
    L7:
        this.hoverInteraction = r0;
        return;
    }

    private final void emitHoverExit() {
        HoverInteraction.Enter r0 = this.hoverInteraction;
        if (r0 == null) goto L9;
        HoverInteraction.Exit r1 = new HoverInteraction.Exit(r0);
        MutableInteractionSource r2 = this.interactionSource;
        if (r2 == null) goto L7;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(r2, r1, null), 3, null);
    L7:
        this.hoverInteraction = null;
        return;
    }

    private final void initializeIndicationAndInteractionSourceIfNeeded() {
        if (this.indicationNode == null) goto L6;
        return;
    L6:
        if (this.useLocalIndication == false) goto L8;
        IndicationNodeFactory r0 = this.localIndicationNodeFactory;
    L9:
        if (r0 != null) goto L11;
        return;
    L11:
        if (this.interactionSource != null) goto L13;
        this.interactionSource = InteractionSourceKt.MutableInteractionSource();
    L13:
        this.focusableNode.update(this.interactionSource);
        MutableInteractionSource r1 = this.interactionSource;
        Intrinsics.checkNotNull(r1);
        DelegatableNode r2 = r0.create(r1);
        delegate(r2);
        this.indicationNode = r2;
        return;
    L8:
        r0 = this.indicationNodeFactory;
        goto L9
    }

    private final void recreateIndicationIfNeeded() {
        DelegatableNode r0 = this.indicationNode;
        if (r0 == null) goto L5;
    L6:
        if (r0 == null) goto L8;
        undelegate(r0);
    L8:
        this.indicationNode = null;
        initializeIndicationAndInteractionSourceIfNeeded();
        return;
    L5:
        if (this.lazilyCreateIndication == false) goto L6;
    }

    private final boolean shouldLazilyCreateIndication() {
        if (this.userProvidedInteractionSource != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void disposeInteractions() {
        MutableInteractionSource r1 = this.interactionSource;
        if (r1 == null) goto L27;
        PressInteraction.Press r2 = this.pressInteraction;
        if (r2 == null) goto L7;
        r1.tryEmit(new PressInteraction.Cancel(r2));
    L7:
        HoverInteraction.Enter r3 = this.hoverInteraction;
        if (r3 == null) goto L10;
        r1.tryEmit(new HoverInteraction.Exit(r3));
    L10:
        MutableLongObjectMap<PressInteraction.Press> r4 = this.currentKeyPressInteractions;
        Object[] r5 = r4.values;
        long[] r6 = r4.metadata;
        int r7 = r6.length - 2;
        if (r7 < 0) goto L27;
        int r8 = 0;
    L13:
        long r9 = r6[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r10 = 8 - ((~(r8 - r7)) >>> 31);
        int r11 = 0;
    L16:
        if (r11 >= r10) goto L24;
        if ((255 & r9) >= 128) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == false) goto L23;
        r1.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) r5[(r8 << 3) + r11]));
    L23:
        r9 = r9 >> 8;
        r11 = r11 + 1;
        goto L16
    L20:
        r12 = false;
        goto L21
    L24:
        if (r10 != 8) goto L27;
    L25:
        if (r8 == r7) goto L27;
        r8 = r8 + 1;
    L27:
        this.pressInteraction = null;
        this.hoverInteraction = null;
        this.currentKeyPressInteractions.clear();
    }

    public final void handlePressInteractionCancel() {
        MutableInteractionSource r0 = this.interactionSource;
        if (r0 == null) goto L19;
        Job r1 = this.delayJob;
        boolean r2 = false;
        if (r1 == null) goto L10;
        if (r1.isActive() != true) goto L10;
        r2 = true;
    L10:
        if (r2 == false) goto L14;
        Job r3 = this.delayJob;
        if (r3 == null) goto L17;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L17:
        this.pressInteraction = null;
        return;
    L14:
        PressInteraction.Press r4 = this.pressInteraction;
        if (r4 == null) goto L17;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionCancel$1$1$1(r4, r0, null), 3, null);
        goto L17
    }

    public void onCancelPointerInput() {
        MutableInteractionSource r0 = this.interactionSource;
        if (r0 == null) goto L7;
        HoverInteraction.Enter r1 = this.hoverInteraction;
        if (r1 == null) goto L7;
        r0.tryEmit(new HoverInteraction.Exit(r1));
    L7:
        this.hoverInteraction = null;
        SuspendingPointerInputModifierNode r2 = this.pointerInputNode;
        if (r2 == null) goto L11;
        r2.onCancelPointerInput();
        return;
    }

    public void onObservedReadsChanged() {
        if (this.useLocalIndication == false) goto L6;
        ObserverModifierNodeKt.observeReads(this, new b(this));
        return;
    }

    public final Unit resetPointerInputHandler() {
        SuspendingPointerInputModifierNode r0 = this.pointerInputNode;
        if (r0 == null) goto L5;
        r0.resetPointerInputHandler();
        return Unit.INSTANCE;
    L5:
        return null;
    }

    private final boolean delayPressInteraction() {
        if (ClickableKt.hasScrollableContainer(this) == false) goto L5;
    L8:
        return true;
    L5:
        if (Clickable_androidKt.isComposeRootInScrollableContainer(this) == true) goto L8;
        return false;
    }

    public final void onAttach() {
        onObservedReadsChanged();
        if (this.lazilyCreateIndication == true) goto L6;
        initializeIndicationAndInteractionSourceIfNeeded();
    L6:
        if (this.enabled == false) goto L9;
        delegate(this.focusableNode);
        return;
    }

    public final void onDetach() {
        disposeInteractions();
        if (this.userProvidedInteractionSource != null) goto L5;
        this.interactionSource = null;
    L5:
        DelegatableNode r0 = this.indicationNode;
        if (r0 == null) goto L8;
        undelegate(r0);
    L8:
        this.indicationNode = null;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public static final /* synthetic */ boolean access$delayPressInteraction(AbstractClickableNode r0) {
        return r0.delayPressInteraction();
    }

    public static final /* synthetic */ void access$emitHoverEnter(AbstractClickableNode r0) {
        r0.emitHoverEnter();
    }

    public static final /* synthetic */ void access$emitHoverExit(AbstractClickableNode r0) {
        r0.emitHoverExit();
    }

    public static final /* synthetic */ Job access$getDelayJob$p(AbstractClickableNode r0) {
        return r0.delayJob;
    }

    public static final /* synthetic */ MutableInteractionSource access$getInteractionSource$p(AbstractClickableNode r0) {
        return r0.interactionSource;
    }

    public static final /* synthetic */ PressInteraction.Press access$getPressInteraction$p(AbstractClickableNode r0) {
        return r0.pressInteraction;
    }

    private static final boolean applySemantics$lambda$12(AbstractClickableNode r0) {
        r0.onClick.invoke();
        return true;
    }

    private final void onFocusChange(boolean r19) {
        if (r19 == false) goto L6;
        initializeIndicationAndInteractionSourceIfNeeded();
        return;
    L6:
        if (this.interactionSource == null) goto L24;
        MutableLongObjectMap<PressInteraction.Press> r1 = this.currentKeyPressInteractions;
        Object[] r2 = r1.values;
        long[] r3 = r1.metadata;
        int r4 = r3.length - 2;
        if (r4 < 0) goto L24;
        int r5 = 0;
    L10:
        long r6 = r3[r5];
        if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r8 = 8 - ((~(r5 - r4)) >>> 31);
        int r10 = 0;
    L13:
        if (r10 >= r8) goto L21;
        if ((255 & r6) >= 128) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L20;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onFocusChange$1$1(this, (PressInteraction.Press) r2[(r5 << 3) + r10], null), 3, null);
    L20:
        r6 = r6 >> 8;
        r10 = r10 + 1;
        goto L13
    L17:
        r11 = false;
        goto L18
    L21:
        if (r8 != 8) goto L24;
    L22:
        if (r5 == r4) goto L24;
        r5 = r5 + 1;
    L24:
        this.currentKeyPressInteractions.clear();
        onCancelKeyInput();
    }

    private static final Unit onObservedReadsChanged$lambda$1(AbstractClickableNode r2) {
        Indication r0 = (Indication) CompositionLocalConsumerModifierNodeKt.currentValueOf(r2, IndicationKt.getLocalIndication());
        if ((r0 instanceof IndicationNodeFactory) == true) goto L5;
        InlineClassHelperKt.throwIllegalArgumentException(ClickableKt.access$unsupportedIndicationExceptionMessage(r0));
    L5:
        IndicationNodeFactory r1 = r2.localIndicationNodeFactory;
        IndicationNodeFactory r3 = (IndicationNodeFactory) r0;
        r2.localIndicationNodeFactory = r3;
        if (r1 == null) goto L11;
        if (Intrinsics.areEqual(r3, r1) == true) goto L11;
        r2.recreateIndicationIfNeeded();
    L11:
        return Unit.INSTANCE;
    }

    public final void applySemantics(SemanticsPropertyReceiver r3) {
        Role r0 = this.role;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        SemanticsPropertiesKt.setRole-kuIjeqM(r3, r0.unbox-impl());
    L5:
        SemanticsPropertiesKt.onClick(r3, this.onClickLabel, new a(this));
        if (this.enabled == false) goto L8;
        this.focusableNode.applySemantics(r3);
    L9:
        applyAdditionalSemantics(r3);
        return;
    L8:
        SemanticsPropertiesKt.disabled(r3);
        goto L9
    }

    /* JADX INFO: renamed from: handlePressInteractionRelease-k-4lQ0M, reason: not valid java name */
    public final void m306handlePressInteractionReleasek4lQ0M(long r14) {
        MutableInteractionSource r4 = this.interactionSource;
        if (r4 == null) goto L17;
        Job r0 = this.delayJob;
        boolean r1 = false;
        if (r0 == null) goto L10;
        if (r0.isActive() != true) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L12;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1(this, r14, r4, null), 3, null);
    L15:
        this.pressInteraction = null;
        return;
    L12:
        PressInteraction.Press r15 = this.pressInteraction;
        if (r15 == null) goto L15;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionRelease$1$2$1(r15, r4, null), 3, null);
        goto L15
    }

    /* JADX INFO: renamed from: handlePressInteractionStart-k-4lQ0M, reason: not valid java name */
    public final void m307handlePressInteractionStartk4lQ0M(long r10) {
        MutableInteractionSource r0 = this.interactionSource;
        if (r0 == null) goto L9;
        PressInteraction.Press r1 = new PressInteraction.Press(r10, null);
        if (delayPressInteraction() == false) goto L7;
        this.delayJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$1(r0, r1, this, null), 3, null);
        return;
    L7:
        this.pressInteraction = r1;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$handlePressInteractionStart$1$2(r0, r1, null), 3, null);
        return;
    }

    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean m310onKeyEventZmokQxo(KeyEvent r13) {
        initializeIndicationAndInteractionSourceIfNeeded();
        long r0 = KeyEvent_androidKt.getKey-ZmokQxo(r13);
        if (this.enabled == false) goto L18;
        if (ClickableKt.m373access$isPressZmokQxo(r13) == false) goto L18;
        if (this.currentKeyPressInteractions.containsKey(r0) == true) goto L12;
        PressInteraction.Press r2 = new PressInteraction.Press(this.centerOffset, null);
        this.currentKeyPressInteractions.set(r0, r2);
        if (this.interactionSource == null) goto L11;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, r2, null), 3, null);
    L11:
        boolean r1 = true;
    L14:
        if (mo308onClickKeyDownEventZmokQxo(r13) == true) goto L31;
        if (r1 == true) goto L32;
    L29:
        return false;
    L32:
        return true;
    L31:
        return true;
    L12:
        r1 = false;
    L18:
        if (this.enabled == false) goto L29;
        if (ClickableKt.m372access$isClickZmokQxo(r13) == false) goto L29;
        PressInteraction.Press r3 = this.currentKeyPressInteractions.remove(r0);
        if (r3 != null) goto L24;
    L27:
        if (r3 == null) goto L29;
        return true;
    L24:
        if (this.interactionSource == null) goto L26;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2(this, r3, null), 3, null);
    L26:
        mo309onClickKeyUpEventZmokQxo(r13);
        goto L27
    }

    public static final /* synthetic */ void access$onFocusChange(AbstractClickableNode r0, boolean r1) {
        r0.onFocusChange(r1);
    }

    public static final /* synthetic */ void access$setPressInteraction$p(AbstractClickableNode r0, PressInteraction.Press r1) {
        r0.pressInteraction = r1;
    }

    /* JADX INFO: renamed from: handlePressInteraction-d-4ec7I, reason: not valid java name */
    public final Object m305handlePressInteractiond4ec7I(PressGestureScope r9, long r10, Continuation<? super Unit> r12) {
        MutableInteractionSource r4 = this.interactionSource;
        if (r4 == null) goto L8;
        Object r11 = CoroutineScopeKt.coroutineScope(new AbstractClickableNode$handlePressInteraction$2$1(r9, r10, r4, this, null), r12);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r11;
    L8:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo311onPointerEventH0pRuoY(PointerEvent r11, PointerEventPass r12, long r13) {
        long r0 = IntSizeKt.getCenter-ozmzZPI(r13);
        float r2 = IntOffset.getX-impl(r0);
        float r1 = IntOffset.getY-impl(r0);
        this.centerOffset = Offset.constructor-impl((Float.floatToRawIntBits(r2) << 32) | (Float.floatToRawIntBits(r1) & 4294967295L));
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled == false) goto L13;
        if (r12 != PointerEventPass.Main) goto L13;
        int r3 = r11.getType-7fucELk();
        PointerEventType.Companion r4 = PointerEventType.Companion;
        if (PointerEventType.equals-impl0(r3, r4.getEnter-7fucELk()) == false) goto L10;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
        goto L13
    L10:
        if (PointerEventType.equals-impl0(r3, r4.getExit-7fucELk()) == false) goto L13;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
    L13:
        if (this.pointerInputNode != null) goto L17;
        SuspendingPointerInputModifierNode r5 = createPointerInputNodeIfNeeded();
        if (r5 == null) goto L17;
        this.pointerInputNode = delegate(r5);
    L17:
        SuspendingPointerInputModifierNode r6 = this.pointerInputNode;
        if (r6 == null) goto L21;
        r6.onPointerEvent-H0pRuoY(r11, r12, r13);
        return;
    }

    private AbstractClickableNode(MutableInteractionSource r1, IndicationNodeFactory r2, boolean r3, boolean r4, String r5, Role r6, Function0<Unit> r7) {
        this.interactionSource = r1;
        this.indicationNodeFactory = r2;
        this.useLocalIndication = r3;
        this.onClickLabel = r5;
        this.role = r6;
        this.enabled = r4;
        this.onClick = r7;
        this.focusableNode = new FocusableNode(this.interactionSource, Focusability.Companion.getSystemDefined-LCbbffg(), new AbstractClickableNode$focusableNode$1(this), null);
        this.currentKeyPressInteractions = LongObjectMapKt.mutableLongObjectMapOf();
        this.centerOffset = Offset.Companion.getZero-F1C5BW0();
        this.userProvidedInteractionSource = this.interactionSource;
        this.lazilyCreateIndication = shouldLazilyCreateIndication();
        this.traverseKey = TraverseKey;
    }

    /* JADX INFO: renamed from: updateCommon-O2vRcR0, reason: not valid java name */
    public final void m313updateCommonO2vRcR0(MutableInteractionSource r3, IndicationNodeFactory r4, boolean r5, boolean r6, String r7, Role r8, Function0<Unit> r9) {
        boolean r1 = true;
        if (Intrinsics.areEqual(this.userProvidedInteractionSource, r3) == true) goto L5;
        disposeInteractions();
        this.userProvidedInteractionSource = r3;
        this.interactionSource = r3;
        boolean r10 = true;
    L7:
        if (Intrinsics.areEqual(this.indicationNodeFactory, r4) == true) goto L10;
        this.indicationNodeFactory = r4;
        r10 = true;
    L10:
        if (this.useLocalIndication == r5) goto L16;
        this.useLocalIndication = r5;
        if (r5 == false) goto L14;
        onObservedReadsChanged();
    L14:
        r10 = true;
    L16:
        if (this.enabled == r6) goto L22;
        if (r6 == false) goto L19;
        delegate(this.focusableNode);
    L20:
        SemanticsModifierNodeKt.invalidateSemantics(this);
        this.enabled = r6;
        goto L22
    L19:
        undelegate(this.focusableNode);
        disposeInteractions();
    L22:
        if (Intrinsics.areEqual(this.onClickLabel, r7) == true) goto L25;
        this.onClickLabel = r7;
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L25:
        if (Intrinsics.areEqual(this.role, r8) == true) goto L27;
        this.role = r8;
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L27:
        this.onClick = r9;
        if (this.lazilyCreateIndication == shouldLazilyCreateIndication()) goto L34;
        boolean r11 = shouldLazilyCreateIndication();
        this.lazilyCreateIndication = r11;
        if (r11 == true) goto L34;
        if (this.indicationNode != null) goto L34;
    L35:
        if (r1 == false) goto L37;
        recreateIndicationIfNeeded();
    L37:
        this.focusableNode.update(this.interactionSource);
        return;
    L34:
        r1 = r10;
        goto L35
    L5:
        r10 = false;
        goto L7
    }
}
