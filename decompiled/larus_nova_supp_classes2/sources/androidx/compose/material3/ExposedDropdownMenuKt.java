package androidx.compose.material3;

import android.view.KeyEvent;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001aa\u0010\u001b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b&\u0010'\u001a\"\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020/H\u0002\u001a\u000e\u00105\u001a\u000203*\u0004\u0018\u000106H\u0002\"\u0018\u0010(\u001a\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0018\u0010,\u001a\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+\"\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109*8\b\u0007\u0010\u0012\"\u00020\u000e2\u00020\u000eB*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0006\b\u001a\u0012\u0002\b\f¨\u0006:²\u0006\f\u0010;\u001a\u0004\u0018\u000106X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020/X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020/X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "hasGreaterOrEqualPriorityThan", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "that", "hasGreaterOrEqualPriorityThan-vVDBVkM", "(Ljava/lang/String;Ljava/lang/String;)Z", "MenuAnchorType", "Lkotlin/Deprecated;", "message", "Renamed to ExposedDropdownMenuAnchorType", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "ExposedDropdownMenuAnchorType", "imports", "expandable", "Lkotlin/Function0;", "anchorType", "alwaysFocusable", "Landroidx/compose/runtime/MutableState;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-3-2CpT8", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/MutableState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "isClick", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnterMinusSpacebar", "isEnterMinusSpacebar-ZmokQxo", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/unit/IntRect;", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "verticalMargin", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = 0.0f;

    private static final Unit ExposedDropdownMenuBox$lambda$23(boolean r7, Function1 r8, Modifier r9, Function3 r10, int r11, int r12, Composer r13, int r14) {
        ExposedDropdownMenuBox(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Renamed to ExposedDropdownMenuAnchorType", replaceWith = @ReplaceWith(expression = "ExposedDropdownMenuAnchorType", imports = {}))
    public static /* synthetic */ void MenuAnchorType$annotations() {
    }

    public static /* synthetic */ Unit a(WindowBoundsCalculator r0, int r1, MutableState r2, MutableIntState r3, MutableIntState r4, LayoutCoordinates r5) {
        return ExposedDropdownMenuBox$lambda$15$lambda$14(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit b(String r0, boolean r1, String r2, String r3, String r4, Function0 r5, SoftwareKeyboardController r6, SemanticsPropertyReceiver r7) {
        return expandable_3_2CpT8$lambda$25(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit c(Function1 r0) {
        return ExposedDropdownMenuBox$lambda$22$lambda$21(r0);
    }

    public static /* synthetic */ boolean d(Function0 r0, String r1, SoftwareKeyboardController r2) {
        return expandable_3_2CpT8$lambda$25$lambda$24(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(boolean r0, FocusRequester r1) {
        return ExposedDropdownMenuBox$lambda$20$lambda$19(r0, r1);
    }

    public static /* synthetic */ Unit f(WindowBoundsCalculator r0, int r1, MutableState r2, MutableIntState r3) {
        return ExposedDropdownMenuBox$lambda$18$lambda$17(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit g(boolean r0, Function1 r1, Modifier r2, Function3 r3, int r4, int r5, Composer r6, int r7) {
        return ExposedDropdownMenuBox$lambda$23(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    static {
        ExposedDropdownMenuItemHorizontalPadding = Dp.constructor-impl(16);
    }

    public static final /* synthetic */ float access$getExposedDropdownMenuItemHorizontalPadding$p() {
        return ExposedDropdownMenuItemHorizontalPadding;
    }

    private static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> r0) {
        return (LayoutCoordinates) r0.getValue();
    }

    private static final Unit ExposedDropdownMenuBox$lambda$22$lambda$21(Function1 r1) {
        r1.invoke(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private static final int ExposedDropdownMenuBox$lambda$5(MutableIntState r0) {
        return r0.getIntValue();
    }

    private static final int ExposedDropdownMenuBox$lambda$8(MutableIntState r0) {
        return r0.getIntValue();
    }

    public static final /* synthetic */ int access$ExposedDropdownMenuBox$lambda$5(MutableIntState r0) {
        return ExposedDropdownMenuBox$lambda$5(r0);
    }

    public static final /* synthetic */ int access$ExposedDropdownMenuBox$lambda$8(MutableIntState r0) {
        return ExposedDropdownMenuBox$lambda$8(r0);
    }

    /* JADX INFO: renamed from: access$isClick-ZmokQxo, reason: not valid java name */
    public static final /* synthetic */ boolean m2691access$isClickZmokQxo(KeyEvent r0) {
        return m2695isClickZmokQxo(r0);
    }

    /* JADX INFO: renamed from: access$isEnterMinusSpacebar-ZmokQxo, reason: not valid java name */
    public static final /* synthetic */ boolean m2692access$isEnterMinusSpacebarZmokQxo(KeyEvent r0) {
        return m2696isEnterMinusSpacebarZmokQxo(r0);
    }

    private static final Rect getAnchorBounds(LayoutCoordinates r4) {
        if (r4 == null) goto L8;
        if (r4.isAttached() == false) goto L8;
        return RectKt.Rect-tz77jQw(LayoutCoordinatesKt.positionInWindow(r4), IntSizeKt.toSize-ozmzZPI(r4.getSize-YbymL2g()));
    L8:
        return Rect.Companion.getZero();
    }

    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    private static final boolean m2695isClickZmokQxo(KeyEvent r4) {
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(r4), KeyEventType.Companion.getKeyUp-CS__XNY()) == true) goto L5;
    L9:
        return false;
    L5:
        if (m2696isEnterMinusSpacebarZmokQxo(r4) == false) goto L7;
    L8:
        return true;
    L7:
        if (Key.equals-impl0(KeyEvent_androidKt.getKey-ZmokQxo(r4), Key.Companion.getSpacebar-EK5gGoQ()) == false) goto L9;
        goto L8
    }

    /* JADX INFO: renamed from: isEnterMinusSpacebar-ZmokQxo, reason: not valid java name */
    private static final boolean m2696isEnterMinusSpacebarZmokQxo(KeyEvent r4) {
        long r0 = KeyEvent_androidKt.getKey-ZmokQxo(r4);
        Key.Companion r5 = Key.Companion;
        if (Key.equals-impl0(r0, r5.getDirectionCenter-EK5gGoQ()) == false) goto L5;
    L10:
        return true;
    L5:
        if (Key.equals-impl0(r0, r5.getEnter-EK5gGoQ()) == true) goto L10;
        if (Key.equals-impl0(r0, r5.getNumPadEnter-EK5gGoQ()) == true) goto L10;
        return false;
    }

    private static final Unit ExposedDropdownMenuBox$lambda$20$lambda$19(boolean r2, FocusRequester r3) {
        if (r2 == false) goto L5;
        FocusRequester.requestFocus-3ESFkO8$default(r3, 0, 1, null);
    L5:
        return Unit.INSTANCE;
    }

    private static final void ExposedDropdownMenuBox$lambda$3(MutableState<LayoutCoordinates> r0, LayoutCoordinates r1) {
        r0.setValue(r1);
    }

    private static final void ExposedDropdownMenuBox$lambda$6(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    private static final void ExposedDropdownMenuBox$lambda$9(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    /* JADX INFO: renamed from: access$hasGreaterOrEqualPriorityThan-vVDBVkM, reason: not valid java name */
    public static final /* synthetic */ boolean m2690access$hasGreaterOrEqualPriorityThanvVDBVkM(String r0, String r1) {
        return m2694hasGreaterOrEqualPriorityThanvVDBVkM(r0, r1);
    }

    /* JADX INFO: renamed from: hasGreaterOrEqualPriorityThan-vVDBVkM, reason: not valid java name */
    private static final boolean m2694hasGreaterOrEqualPriorityThanvVDBVkM(String r2, String r3) {
        ExposedDropdownMenuAnchorType.Companion r0 = ExposedDropdownMenuAnchorType.Companion;
        if (ExposedDropdownMenuAnchorType.m2671equalsimpl0(r2, r0.m2676getPrimaryNotEditableoYjWRB4()) == false) goto L5;
    L11:
        return true;
    L5:
        if (ExposedDropdownMenuAnchorType.m2671equalsimpl0(r2, r0.m2675getPrimaryEditableoYjWRB4()) == true) goto L11;
        if (ExposedDropdownMenuAnchorType.m2671equalsimpl0(r2, r0.m2677getSecondaryEditableoYjWRB4()) == true) goto L13;
        return false;
    L13:
        return ExposedDropdownMenuAnchorType.m2671equalsimpl0(r3, r0.m2677getSecondaryEditableoYjWRB4());
    }

    private static final int calculateMaxHeight(IntRect r4, Rect r5, int r6) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = r4.getTop() + r6;
        int r2 = r4.getBottom() - r6;
        if (r5.getTop() <= r4.getBottom()) goto L8;
    L11:
        int r7 = r2 - r1;
    L13:
        return Math.max(r7, 0);
    L8:
        if (r5.getBottom() < r4.getTop()) goto L11;
        r7 = MathKt.roundToInt(Math.max(r5.getTop() - r1, r2 - r5.getBottom()));
        goto L13
    }

    private static final boolean expandable_3_2CpT8$lambda$25$lambda$24(Function0 r0, String r1, SoftwareKeyboardController r2) {
        r0.invoke();
        if (ExposedDropdownMenuAnchorType.m2671equalsimpl0(r1, ExposedDropdownMenuAnchorType.Companion.m2675getPrimaryEditableoYjWRB4()) == false) goto L8;
        if (r2 == null) goto L9;
        r2.show();
        return true;
    L9:
        return true;
    L8:
        return true;
    }

    private static final Unit ExposedDropdownMenuBox$lambda$18$lambda$17(WindowBoundsCalculator r0, int r1, MutableState r2, MutableIntState r3) {
        ExposedDropdownMenuBox$lambda$9(r3, calculateMaxHeight(r0.getVisibleWindowBounds(), getAnchorBounds(ExposedDropdownMenuBox$lambda$2(r2)), r1));
        return Unit.INSTANCE;
    }

    private static final Unit ExposedDropdownMenuBox$lambda$15$lambda$14(WindowBoundsCalculator r2, int r3, MutableState r4, MutableIntState r5, MutableIntState r6, LayoutCoordinates r7) {
        ExposedDropdownMenuBox$lambda$3(r4, r7);
        ExposedDropdownMenuBox$lambda$6(r5, (int) (r7.getSize-YbymL2g() >> 32));
        ExposedDropdownMenuBox$lambda$9(r6, calculateMaxHeight(r2.getVisibleWindowBounds(), getAnchorBounds(ExposedDropdownMenuBox$lambda$2(r4)), r3));
        return Unit.INSTANCE;
    }

    public static final void ExposedDropdownMenuBox(final boolean r29, final Function1<? super Boolean, Unit> r30, Modifier r31, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r11 = r33.startRestartGroup(1597265892);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r35 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r4 = r31;
    L35:
        if ((r35 & 8) == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        int r8 = r1;
        if ((r8 & 1171) == 1170) goto L47;
        boolean r2 = true;
    L49:
        if (r11.shouldExecute(r2, r8 & 1) == false) goto L139;
        if (r3 == 0) goto L52;
        Modifier r6 = Modifier.Companion;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(1597265892, r8, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:141)");
    L56:
        final WindowBoundsCalculator r5 = ExposedDropdownMenu_androidKt.platformWindowBoundsCalculator(r11, 0);
        Density r0 = (Density) r11.consume(CompositionLocalsKt.getLocalDensity());
        int r7 = r0.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
        Object r9 = r11.rememberedValue();
        Composer.Companion r23 = Composer.Companion;
        if (r9 != r23.getEmpty()) goto L59;
        r9 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r11.updateRememberedValue(r9);
    L59:
        final MutableState r10 = (MutableState) r9;
        Object r12 = r11.rememberedValue();
        if (r12 != r23.getEmpty()) goto L62;
        r12 = SnapshotIntStateKt.mutableIntStateOf(0);
        r11.updateRememberedValue(r12);
    L62:
        final MutableIntState r21 = (MutableIntState) r12;
        Object r13 = r11.rememberedValue();
        if (r13 != r23.getEmpty()) goto L65;
        r13 = SnapshotIntStateKt.mutableIntStateOf(0);
        r11.updateRememberedValue(r13);
    L65:
        MutableIntState r14 = (MutableIntState) r13;
        Object r15 = r11.rememberedValue();
        if (r15 != r23.getEmpty()) goto L68;
        r15 = new FocusRequester();
        r11.updateRememberedValue(r15);
    L68:
        FocusRequester r16 = (FocusRequester) r15;
        SoftwareKeyboardController r19 = (SoftwareKeyboardController) r11.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
        String r20 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911751), r11, 0);
        String r22 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911750), r11, 0);
        String r24 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911752), r11, 0);
        Object r17 = r11.rememberedValue();
        if (r17 != r23.getEmpty()) goto L72;
        r17 = SnapshotStateKt.mutableStateOf$default(ExposedDropdownMenuAnchorType.m2668boximpl(ExposedDropdownMenuAnchorType.Companion.m2676getPrimaryNotEditableoYjWRB4()), null, 2, null);
        r11.updateRememberedValue(r17);
    L72:
        MutableState r18 = (MutableState) r17;
        Object r25 = r11.rememberedValue();
        if (r25 != r23.getEmpty()) goto L75;
        r25 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r11.updateRememberedValue(r25);
    L75:
        MutableState r26 = (MutableState) r25;
        int r27 = r8 & 14;
        if (r27 != 4) goto L78;
        boolean r110 = true;
    L79:
        int r111 = r8 & 112;
        if (r111 != 32) goto L82;
        boolean r28 = true;
    L83:
        boolean r36 = ((r110 | r28) | r11.changed(r5)) | r11.changed(r0);
        Object r37 = r11.rememberedValue();
        if (r36 == false) goto L86;
    L89:
        FocusRequester r210 = r16;
        final int r112 = r7;
        MutableIntState r38 = r14;
        Modifier r211 = r6;
        Composer r113 = r11;
        ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r39 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(r16, r29, r26, r20, r22, r24, r19, r18, r30, r21, r38);
        r113.updateRememberedValue(r39);
        r37 = r39;
    L90:
        ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r40 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) r37;
        boolean r41 = r113.changedInstance(r5) | r113.changed(r112);
        Object r42 = r113.rememberedValue();
        if (r41 == false) goto L93;
    L94:
        final int r114 = r112;
        final MutableIntState r212 = r38;
        r42 = new va(r5, r114, r10, r21, r212);
        r113.updateRememberedValue(r42);
    L95:
        r4 = r211;
        Modifier r43 = OnGloballyPositionedModifierKt.onGloballyPositioned(r4, (Function1) r42);
        MeasurePolicy r44 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r45 = ComposablesKt.getCurrentCompositeKeyHash(r113, 0);
        CompositionLocalMap r46 = r113.getCurrentCompositionLocalMap();
        Modifier r47 = ComposedModifierKt.materializeModifier(r113, r43);
        ComposeUiNode.Companion r48 = ComposeUiNode.Companion;
        Function0 r49 = r48.getConstructor();
        if ((r113.getApplier() instanceof Applier) == true) goto L98;
        ComposablesKt.invalidApplier();
    L98:
        r113.startReusableNode();
        if (r113.getInserting() == false) goto L101;
        r113.createNode(r49);
    L102:
        Composer r50 = Updater.constructor-impl(r113);
        Updater.set-impl(r50, r44, r48.getSetMeasurePolicy());
        Updater.set-impl(r50, r46, r48.getSetResolvedCompositionLocals());
        Function2 r51 = r48.getSetCompositeKeyHash();
        if (r50.getInserting() == false) goto L105;
    L106:
        r50.updateRememberedValue(Integer.valueOf(r45));
        r50.apply(Integer.valueOf(r45), r51);
    L107:
        Updater.set-impl(r50, r47, r48.getSetModifier());
        BoxScopeInstance r52 = BoxScopeInstance.INSTANCE;
        r32.invoke(r40, r113, Integer.valueOf((r8 >> 6) & 112));
        r113.endNode();
        if (r29 == false) goto L115;
        r113.startReplaceGroup(209894723);
        boolean r53 = r113.changedInstance(r5) | r113.changed(r112);
        Object r54 = r113.rememberedValue();
        if (r53 == false) goto L112;
    L113:
        final MutableIntState r55 = r38;
        r54 = new wa(r5, r112, r10, r55);
        r113.updateRememberedValue(r54);
    L114:
        ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) r54, r113, 0);
        r113.endReplaceGroup();
    L117:
        if (r27 != 4) goto L119;
        boolean r56 = true;
    L120:
        Object r57 = r113.rememberedValue();
        if (r56 == false) goto L123;
    L124:
        final FocusRequester r58 = r210;
        r57 = new xa(r29, r58);
        r113.updateRememberedValue(r57);
    L125:
        EffectsKt.SideEffect((Function0) r57, r113, 0);
        if (r111 != 32) goto L128;
        boolean r59 = true;
    L129:
        Object r60 = r113.rememberedValue();
        if (r59 == false) goto L132;
    L135:
        r60 = new ya(r30);
        r113.updateRememberedValue(r60);
    L136:
        BackHandler_androidKt.BackHandler(r29, (Function0) r60, r113, r27, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L140;
        ComposerKt.traceEventEnd();
    L140:
        final Modifier r61 = r4;
        ScopeUpdateScope r62 = r113.endRestartGroup();
        if (r62 == null) goto L144;
        r62.updateScope(new za(r29, r30, r61, r32, r34, r35));
        return;
    L144:
        return;
    L132:
        if (r60 != r23.getEmpty()) goto L136;
    L128:
        r59 = false;
        goto L129
    L123:
        if (r57 != r23.getEmpty()) goto L125;
    L119:
        r56 = false;
        goto L120
    L112:
        if (r54 != r23.getEmpty()) goto L114;
    L115:
        r113.startReplaceGroup(210228190);
        r113.endReplaceGroup();
        goto L117
    L105:
        if (Intrinsics.areEqual(r50.rememberedValue(), Integer.valueOf(r45)) == true) goto L107;
    L101:
        r113.useNode();
        goto L102
    L93:
        if (r42 != r23.getEmpty()) goto L95;
    L86:
        if (r37 == r23.getEmpty()) goto L89;
        r210 = r16;
        r112 = r7;
        r211 = r6;
        r38 = r14;
        r113 = r11;
        goto L90
    L82:
        r28 = false;
        goto L83
    L78:
        r110 = false;
        goto L79
    L52:
        r6 = r4;
        goto L54
    L139:
        r113 = r11;
        r113.skipToGroupEnd();
        goto L140
    L47:
        r2 = false;
        goto L49
    L38:
        if ((r34 & 3072) != 0) goto L44;
        if (r11.changedInstance(r32) == false) goto L42;
        int r63 = 2048;
    L43:
        r1 = r1 | r63;
        goto L44
    L42:
        r63 = 1024;
        goto L43
    L27:
        if ((r34 & 384) != 0) goto L33;
        r4 = r31;
        if (r11.changed(r4) == false) goto L31;
        int r64 = 256;
    L32:
        r1 = r1 | r64;
        goto L35
    L31:
        r64 = 128;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L23;
        if (r11.changedInstance(r30) == false) goto L21;
        int r65 = 32;
    L22:
        r1 = r1 | r65;
        goto L23
    L21:
        r65 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L14
    L8:
        if (r11.changed(r29) == false) goto L10;
        int r66 = 4;
    L11:
        r1 = r66 | r34;
        goto L14
    L10:
        r66 = 2;
        goto L11
    }

    private static final Unit expandable_3_2CpT8$lambda$25(final String r1, boolean r2, String r3, String r4, String r5, final Function0 r6, final SoftwareKeyboardController r7, SemanticsPropertyReceiver r8) {
        if (ExposedDropdownMenuAnchorType.m2671equalsimpl0(r1, ExposedDropdownMenuAnchorType.Companion.m2677getSecondaryEditableoYjWRB4()) == false) goto L9;
        SemanticsPropertiesKt.setRole-kuIjeqM(r8, Role.Companion.getButton-o7Vup1c());
        if (r2 == true) goto L8;
        r3 = r4;
    L8:
        SemanticsPropertiesKt.setStateDescription(r8, r3);
        SemanticsPropertiesKt.setContentDescription(r8, r5);
    L10:
        SemanticsPropertiesKt.onClick$default(r8, null, new ua(r6, r1, r7), 1, null);
        return Unit.INSTANCE;
    L9:
        SemanticsPropertiesKt.setRole-kuIjeqM(r8, Role.Companion.getDropdownList-o7Vup1c());
        goto L10
    }

    /* JADX INFO: renamed from: access$expandable-3-2CpT8, reason: not valid java name */
    public static final /* synthetic */ Modifier m2689access$expandable32CpT8(Modifier r0, boolean r1, Function0 r2, String r3, MutableState r4, String r5, String r6, String r7, SoftwareKeyboardController r8) {
        return m2693expandable32CpT8(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: expandable-3-2CpT8, reason: not valid java name */
    private static final Modifier m2693expandable32CpT8(Modifier r10, final boolean r11, final Function0<Unit> r12, final String r13, final MutableState<Boolean> r14, final String r15, final String r16, final String r17, final SoftwareKeyboardController r18) {
        return SemanticsModifierKt.semantics$default(KeyInputModifierKt.onPreviewKeyEvent(SuspendingPointerInputFilterKt.pointerInput(r10, r12, new ExposedDropdownMenuKt$expandable$1(r13, r12)), new ExposedDropdownMenuKt$expandable$2(r13, r12, r11, r14)), false, new ta(r13, r11, r15, r16, r17, r12, r18), 1, null);
    }
}
