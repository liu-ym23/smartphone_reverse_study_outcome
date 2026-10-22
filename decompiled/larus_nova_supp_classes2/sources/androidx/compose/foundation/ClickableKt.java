package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u000b\u001aK\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000e\u001aS\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0011\u001a{\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u0017\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0018\u001aq\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u0019\u001a\u008d\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u001a\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u001b\u001aA\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001e\b\u0004\u0010\u001d\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u00010\u001eH\u0080\b\u001a\f\u0010(\u001a\u00020\u0003*\u00020)H\u0000\u001a\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\"\u0018\u0010 \u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0018\u0010$\u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#\"\u0018\u0010&\u001a\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#¨\u0006+"}, d2 = {"clickable", "Landroidx/compose/ui/Modifier;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "clickable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "clickable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "combinedClickable-f5TDLPQ", "combinedClickable-hoGz1lA", "combinedClickable-cJG_KMw", "combinedClickable-auXiCPI", "combinedClickable-XVZzFYc", "clickableWithIndicationIfNeeded", "createClickable", "Lkotlin/Function2;", "Landroidx/compose/foundation/IndicationNodeFactory;", "isPress", "Landroidx/compose/ui/input/key/KeyEvent;", "isPress-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isClick", "isClick-ZmokQxo", "isEnter", "isEnter-ZmokQxo", "hasScrollableContainer", "Landroidx/compose/ui/node/TraversableNode;", "unsupportedIndicationExceptionMessage", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ClickableKt {
    public static /* synthetic */ boolean a(Ref.BooleanRef r0, TraversableNode r1) {
        return hasScrollableContainer$lambda$8(r0, r1);
    }

    /* JADX INFO: renamed from: access$isClick-ZmokQxo, reason: not valid java name */
    public static final /* synthetic */ boolean m372access$isClickZmokQxo(KeyEvent r0) {
        return m390isClickZmokQxo(r0);
    }

    /* JADX INFO: renamed from: access$isPress-ZmokQxo, reason: not valid java name */
    public static final /* synthetic */ boolean m373access$isPressZmokQxo(KeyEvent r0) {
        return m392isPressZmokQxo(r0);
    }

    public static final /* synthetic */ String access$unsupportedIndicationExceptionMessage(Indication r0) {
        return unsupportedIndicationExceptionMessage(r0);
    }

    public static final boolean hasScrollableContainer(TraversableNode r3) {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        TraversableNodeKt.traverseAncestors(r3, ScrollableContainerNode.TraverseKey, new g0(r0));
        return r0.element;
    }

    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    private static final boolean m390isClickZmokQxo(KeyEvent r2) {
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(r2), KeyEventType.Companion.getKeyUp-CS__XNY()) == true) goto L5;
    L7:
        return false;
    L5:
        if (m391isEnterZmokQxo(r2) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m391isEnterZmokQxo(KeyEvent r4) {
        long r0 = KeyEvent_androidKt.getKey-ZmokQxo(r4);
        Key.Companion r5 = Key.Companion;
        if (Key.equals-impl0(r0, r5.getDirectionCenter-EK5gGoQ()) == false) goto L5;
    L12:
        return true;
    L5:
        if (Key.equals-impl0(r0, r5.getEnter-EK5gGoQ()) == true) goto L12;
        if (Key.equals-impl0(r0, r5.getNumPadEnter-EK5gGoQ()) == true) goto L12;
        if (Key.equals-impl0(r0, r5.getSpacebar-EK5gGoQ()) == true) goto L12;
        return false;
    }

    /* JADX INFO: renamed from: isPress-ZmokQxo, reason: not valid java name */
    private static final boolean m392isPressZmokQxo(KeyEvent r2) {
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(r2), KeyEventType.Companion.getKeyDown-CS__XNY()) == true) goto L5;
    L7:
        return false;
    L5:
        if (m391isEnterZmokQxo(r2) == false) goto L7;
        return true;
    }

    private static final String unsupportedIndicationExceptionMessage(Indication r2) {
        return "clickable only supports IndicationNodeFactory instances provided to LocalIndication, but Indication was provided instead. Either migrate the Indication implementation to implement IndicationNodeFactory, or use the other clickable overload that takes an Indication parameter, and explicitly pass LocalIndication.current there. You can also use ComposeFoundationFlags.isNonComposedClickableEnabled to temporarily opt-out; note that this flag will be removed in a future release and is only intended to be a temporary migration aid. The Indication instance provided here was: " + r2;
    }

    private static final boolean hasScrollableContainer$lambda$8(Ref.BooleanRef r2, TraversableNode r3) {
        if (r2.element == true) goto L8;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode");
        if (((ScrollableContainerNode) r3).getEnabled() == true) goto L8;
        boolean r4 = false;
    L9:
        r2.element = r4;
        return !r4;
    L8:
        r4 = true;
        goto L9
    }

    public static final Modifier clickableWithIndicationIfNeeded(Modifier r2, MutableInteractionSource r3, final Indication r4, final Function2<? super MutableInteractionSource, ? super IndicationNodeFactory, ? extends Modifier> r5) {
        if ((r4 instanceof IndicationNodeFactory) == false) goto L6;
        Modifier r6 = (Modifier) r5.invoke(r3, r4);
    L12:
        return r2.then(r6);
    L6:
        if (r4 != null) goto L8;
        r6 = (Modifier) r5.invoke(r3, null);
        goto L12
    L8:
        if (r3 == null) goto L10;
        r6 = IndicationKt.indication(Modifier.Companion, r3, r4).then((Modifier) r5.invoke(r3, null));
        goto L12
    L10:
        r6 = ComposedModifierKt.composed$default(Modifier.Companion, null, new AnonymousClass1(r4, r5), 1, null);
        goto L12
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* JADX INFO: renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final /* synthetic */ Modifier m376clickableXHw0xAI(Modifier r2, final boolean r3, final String r4, final Role r5, final Function0 r6) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(r3, r4, r5, r6);
    L7:
        return ComposedModifierKt.composed(r2, r0, new ClickableKt$clickable$2(r3, r4, r5, r6));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: clickable-oSLSa3U, reason: not valid java name */
    public static final Modifier m378clickableoSLSa3U(Modifier r10, final boolean r11, final String r12, final Role r13, final MutableInteractionSource r14, final Function0<Unit> r15) {
        if (ComposeFoundationFlags.isNonComposedClickableEnabled == false) goto L6;
        return r10.then(new ClickableElement(r14, null, true, r11, r12, r13, r15, null));
    L6:
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L8;
        Function1<InspectorInfo, Unit> r0 = new ClickableKt$clickableoSLSa3U$$inlined$debugInspectorInfo$1(r11, r12, r13, r14, r15);
    L10:
        return ComposedModifierKt.composed(r10, r0, new ClickableKt$clickable$4(r14, r11, r12, r13, r15));
    L8:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L10
    }

    /* JADX INFO: renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m374clickableO2vRcR0(Modifier r11, MutableInteractionSource r12, final Indication r13, final boolean r14, final String r15, final Role r16, final Function0<Unit> r17) {
        if ((r13 instanceof IndicationNodeFactory) == false) goto L6;
        ClickableElement r9 = new ClickableElement(r12, (IndicationNodeFactory) r13, false, r14, r15, r16, r17, null);
    L12:
        return r11.then(r9);
    L6:
        if (r13 != null) goto L8;
        r9 = new ClickableElement(r12, null, false, r14, r15, r16, r17, null);
        goto L12
    L8:
        if (r12 == null) goto L10;
        r9 = IndicationKt.indication(Modifier.Companion, r12, r13).then(new ClickableElement(r12, null, false, r14, r15, r16, r17, null));
        goto L12
    L10:
        r9 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ClickableKt$clickableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(r13, r14, r15, r16, r17), 1, null);
        goto L12
    }

    /* JADX INFO: renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m377clickableXHw0xAI$default(Modifier r1, boolean r2, String r3, Role r4, Function0 r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        return m376clickableXHw0xAI(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: clickable-oSLSa3U$default, reason: not valid java name */
    public static /* synthetic */ Modifier m379clickableoSLSa3U$default(Modifier r6, boolean r7, String r8, Role r9, MutableInteractionSource r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Role r3 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        MutableInteractionSource r4 = null;
    L19:
        return m378clickableoSLSa3U(r6, r1, r2, r3, r4, r11);
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r1 = r7;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final /* synthetic */ Modifier m384combinedClickablecJG_KMw(Modifier r10, final boolean r11, final String r12, final Role r13, final String r14, final Function0 r15, final Function0 r16, final Function0 r17) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(r11, r12, r13, r17, r16, r15, r14);
    L7:
        return ComposedModifierKt.composed(r10, r0, new ClickableKt$combinedClickable$6(r11, r12, r13, r14, r15, r16, r17));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: clickable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m375clickableO2vRcR0$default(Modifier r7, MutableInteractionSource r8, Indication r9, boolean r10, String r11, Role r12, Function0 r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r14 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r14 & 16) == 0) goto L13;
        Role r5 = null;
    L15:
        return m374clickableO2vRcR0(r7, r8, r9, r3, r4, r5, r13);
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed")
    /* JADX INFO: renamed from: combinedClickable-f5TDLPQ, reason: not valid java name */
    public static final /* synthetic */ Modifier m386combinedClickablef5TDLPQ(Modifier r11, final boolean r12, final String r13, final Role r14, final String r15, final Function0 r16, final Function0 r17, final boolean r18, final Function0 r19) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new ClickableKt$combinedClickablef5TDLPQ$$inlined$debugInspectorInfo$1(r12, r13, r14, r19, r17, r16, r15, r18);
    L7:
        return ComposedModifierKt.composed(r11, r0, new ClickableKt$combinedClickable$2(r12, r13, r14, r15, r16, r17, r18, r19));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final /* synthetic */ Modifier m380combinedClickableXVZzFYc(Modifier r15, MutableInteractionSource r16, final Indication r17, final boolean r18, final String r19, final Role r20, final String r21, final Function0 r22, final Function0 r23, final Function0 r24) {
        if ((r17 instanceof IndicationNodeFactory) == false) goto L6;
        CombinedClickableElement r13 = new CombinedClickableElement(r16, (IndicationNodeFactory) r17, false, r18, r19, r20, r24, r21, r22, r23, true, null);
    L12:
        return r15.then(r13);
    L6:
        if (r17 != null) goto L8;
        r13 = new CombinedClickableElement(r16, null, false, r18, r19, r20, r24, r21, r22, r23, true, null);
        goto L12
    L8:
        if (r16 == null) goto L10;
        r13 = IndicationKt.indication(Modifier.Companion, r16, r17).then(new CombinedClickableElement(r16, null, false, r18, r19, r20, r24, r21, r22, r23, true, null));
        goto L12
    L10:
        r13 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ClickableKt$combinedClickableXVZzFYc$$inlined$clickableWithIndicationIfNeeded$1(r17, r18, r19, r20, r24, r21, r22, r23), 1, null);
        goto L12
    }

    /* JADX INFO: renamed from: combinedClickable-cJG_KMw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m385combinedClickablecJG_KMw$default(Modifier r9, boolean r10, String r11, Role r12, String r13, Function0 r14, Function0 r15, Function0 r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r17 & 4) == 0) goto L13;
        Role r4 = null;
    L15:
        if ((r17 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r17 & 16) == 0) goto L21;
        Function0 r6 = null;
    L23:
        if ((r17 & 32) == 0) goto L25;
        Function0 r7 = null;
    L27:
        return m384combinedClickablecJG_KMw(r9, r2, r3, r4, r5, r6, r7, r16);
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    /* JADX INFO: renamed from: combinedClickable-hoGz1lA, reason: not valid java name */
    public static final Modifier m388combinedClickablehoGz1lA(Modifier r15, final boolean r16, final String r17, final Role r18, final String r19, final Function0<Unit> r20, final Function0<Unit> r21, final boolean r22, final MutableInteractionSource r23, final Function0<Unit> r24) {
        if (ComposeFoundationFlags.isNonComposedClickableEnabled == false) goto L6;
        return r15.then(new CombinedClickableElement(r23, null, true, r16, r17, r18, r24, r19, r20, r21, r22, null));
    L6:
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L8;
        Function1<InspectorInfo, Unit> r1 = new ClickableKt$combinedClickablehoGz1lA$$inlined$debugInspectorInfo$1(r16, r17, r18, r24, r21, r20, r19, r22);
    L10:
        return ComposedModifierKt.composed(r15, r1, new ClickableKt$combinedClickable$4(r23, r16, r17, r18, r19, r20, r21, r22, r24));
    L8:
        r1 = InspectableValueKt.getNoInspectorInfo();
        goto L10
    }

    /* JADX INFO: renamed from: combinedClickable-auXiCPI, reason: not valid java name */
    public static final Modifier m382combinedClickableauXiCPI(Modifier r15, MutableInteractionSource r16, final Indication r17, final boolean r18, final String r19, final Role r20, final String r21, final Function0<Unit> r22, final Function0<Unit> r23, final boolean r24, final Function0<Unit> r25) {
        if ((r17 instanceof IndicationNodeFactory) == false) goto L6;
        CombinedClickableElement r13 = new CombinedClickableElement(r16, (IndicationNodeFactory) r17, false, r18, r19, r20, r25, r21, r22, r23, r24, null);
    L12:
        return r15.then(r13);
    L6:
        if (r17 != null) goto L8;
        r13 = new CombinedClickableElement(r16, null, false, r18, r19, r20, r25, r21, r22, r23, r24, null);
        goto L12
    L8:
        if (r16 == null) goto L10;
        r13 = IndicationKt.indication(Modifier.Companion, r16, r17).then(new CombinedClickableElement(r16, null, false, r18, r19, r20, r25, r21, r22, r23, r24, null));
        goto L12
    L10:
        r13 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ClickableKt$combinedClickableauXiCPI$$inlined$clickableWithIndicationIfNeeded$1(r17, r18, r19, r20, r25, r21, r22, r23, r24), 1, null);
        goto L12
    }

    /* JADX INFO: renamed from: combinedClickable-f5TDLPQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m387combinedClickablef5TDLPQ$default(Modifier r11, boolean r12, String r13, Role r14, String r15, Function0 r16, Function0 r17, boolean r18, Function0 r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Role r5 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Function0 r7 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Function0 r8 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r9 = true;
    L31:
        return m386combinedClickablef5TDLPQ(r11, r3, r4, r5, r6, r7, r8, r9, r19);
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    /* JADX INFO: renamed from: combinedClickable-XVZzFYc$default, reason: not valid java name */
    public static /* synthetic */ Modifier m381combinedClickableXVZzFYc$default(Modifier r12, MutableInteractionSource r13, Indication r14, boolean r15, String r16, Role r17, String r18, Function0 r19, Function0 r20, Function0 r21, int r22, Object r23) {
        if ((r22 & 4) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r22 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r22 & 16) == 0) goto L13;
        Role r7 = null;
    L15:
        if ((r22 & 32) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r22 & 64) == 0) goto L21;
        Function0 r9 = null;
    L23:
        if ((r22 & 128) == 0) goto L25;
        Function0 r10 = null;
    L27:
        return m380combinedClickableXVZzFYc(r12, r13, r14, r5, r6, r7, r8, r9, r10, r21);
    L25:
        r10 = r20;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    /* JADX INFO: renamed from: combinedClickable-hoGz1lA$default, reason: not valid java name */
    public static /* synthetic */ Modifier m389combinedClickablehoGz1lA$default(Modifier r13, boolean r14, String r15, Role r16, String r17, Function0 r18, Function0 r19, boolean r20, MutableInteractionSource r21, Function0 r22, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        Role r6 = null;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r23 & 16) == 0) goto L21;
        Function0 r8 = null;
    L23:
        if ((r23 & 32) == 0) goto L25;
        Function0 r9 = null;
    L27:
        if ((r23 & 64) == 0) goto L29;
        boolean r10 = true;
    L31:
        if ((r23 & 128) == 0) goto L33;
        MutableInteractionSource r11 = null;
    L35:
        return m388combinedClickablehoGz1lA(r13, r4, r5, r6, r7, r8, r9, r10, r11, r22);
    L33:
        r11 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r7 = r17;
        goto L19
    L13:
        r6 = r16;
        goto L15
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    /* JADX INFO: renamed from: combinedClickable-auXiCPI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m383combinedClickableauXiCPI$default(Modifier r14, MutableInteractionSource r15, Indication r16, boolean r17, String r18, Role r19, String r20, Function0 r21, Function0 r22, boolean r23, Function0 r24, int r25, Object r26) {
        if ((r25 & 4) == 0) goto L5;
        boolean r6 = true;
    L7:
        if ((r25 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r25 & 16) == 0) goto L13;
        Role r8 = null;
    L15:
        if ((r25 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r25 & 64) == 0) goto L21;
        Function0 r10 = null;
    L23:
        if ((r25 & 128) == 0) goto L25;
        Function0 r11 = null;
    L27:
        if ((r25 & 256) == 0) goto L29;
        boolean r12 = true;
    L31:
        return m382combinedClickableauXiCPI(r14, r15, r16, r6, r7, r8, r9, r10, r11, r12, r24);
    L29:
        r12 = r23;
        goto L31
    L25:
        r11 = r22;
        goto L27
    L21:
        r10 = r21;
        goto L23
    L17:
        r9 = r20;
        goto L19
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }
}
