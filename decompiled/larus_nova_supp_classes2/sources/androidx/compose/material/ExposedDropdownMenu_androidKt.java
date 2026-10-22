package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\"\u0010\r\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "expandable", "Lkotlin/Function0;", "menuLabel", "", "updateHeight", "windowBounds", "Landroidx/compose/ui/unit/IntRect;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "material", "width", "menuHeight"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_androidKt {
    private static final Unit ExposedDropdownMenuBox$lambda$21(boolean r7, Function1 r8, Modifier r9, Function3 r10, int r11, int r12, Composer r13, int r14) {
        ExposedDropdownMenuBox(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function1 r0, boolean r1) {
        return ExposedDropdownMenuBox$lambda$14$lambda$13(r0, r1);
    }

    public static /* synthetic */ Unit b(boolean r0, Function1 r1, Modifier r2, Function3 r3, int r4, int r5, Composer r6, int r7) {
        return ExposedDropdownMenuBox$lambda$21(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ boolean c(Function0 r0) {
        return expandable$lambda$23$lambda$22(r0);
    }

    public static /* synthetic */ Unit d(MutableIntState r0, int r1) {
        return ExposedDropdownMenuBox$lambda$12$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit e(WindowBoundsCalculator r0, Ref r1, int r2, MutableIntState r3) {
        return ExposedDropdownMenuBox$lambda$20$lambda$19(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit f(Ref r0, WindowBoundsCalculator r1, int r2, MutableIntState r3, MutableIntState r4, LayoutCoordinates r5) {
        return ExposedDropdownMenuBox$lambda$12$lambda$11(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit g(String r0, Function0 r1, SemanticsPropertyReceiver r2) {
        return expandable$lambda$23(r0, r1, r2);
    }

    public static /* synthetic */ Unit h(MutableIntState r0, int r1) {
        return ExposedDropdownMenuBox$lambda$20$lambda$19$lambda$18(r0, r1);
    }

    public static /* synthetic */ Unit i(boolean r0, FocusRequester r1) {
        return ExposedDropdownMenuBox$lambda$17$lambda$16(r0, r1);
    }

    private static final int ExposedDropdownMenuBox$lambda$1(MutableIntState r0) {
        return r0.getIntValue();
    }

    private static final int ExposedDropdownMenuBox$lambda$4(MutableIntState r0) {
        return r0.getIntValue();
    }

    public static final /* synthetic */ int access$ExposedDropdownMenuBox$lambda$1(MutableIntState r0) {
        return ExposedDropdownMenuBox$lambda$1(r0);
    }

    public static final /* synthetic */ int access$ExposedDropdownMenuBox$lambda$4(MutableIntState r0) {
        return ExposedDropdownMenuBox$lambda$4(r0);
    }

    private static final boolean expandable$lambda$23$lambda$22(Function0 r0) {
        r0.invoke();
        return true;
    }

    private static final Unit ExposedDropdownMenuBox$lambda$12$lambda$11$lambda$10(MutableIntState r0, int r1) {
        ExposedDropdownMenuBox$lambda$5(r0, r1);
        return Unit.INSTANCE;
    }

    private static final Unit ExposedDropdownMenuBox$lambda$14$lambda$13(Function1 r0, boolean r1) {
        r0.invoke(Boolean.valueOf(!r1));
        return Unit.INSTANCE;
    }

    private static final Unit ExposedDropdownMenuBox$lambda$17$lambda$16(boolean r2, FocusRequester r3) {
        if (r2 == false) goto L5;
        FocusRequester.requestFocus-3ESFkO8$default(r3, 0, 1, null);
    L5:
        return Unit.INSTANCE;
    }

    private static final void ExposedDropdownMenuBox$lambda$2(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    private static final Unit ExposedDropdownMenuBox$lambda$20$lambda$19$lambda$18(MutableIntState r0, int r1) {
        ExposedDropdownMenuBox$lambda$5(r0, r1);
        return Unit.INSTANCE;
    }

    private static final void ExposedDropdownMenuBox$lambda$5(MutableIntState r0, int r1) {
        r0.setIntValue(r1);
    }

    private static final Modifier expandable(Modifier r2, final Function0<Unit> r3, final String r4) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(r2, r3, new AnonymousClass1(r3)), false, new g5(r4, r3), 1, null);
    }

    private static final Unit expandable$lambda$23(String r1, final Function0 r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r1);
        SemanticsPropertiesKt.onClick$default(r3, null, new h5(r2), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit ExposedDropdownMenuBox$lambda$20$lambda$19(WindowBoundsCalculator r1, Ref r2, int r3, final MutableIntState r4) {
        updateHeight(r1.getVisibleWindowBounds(), (LayoutCoordinates) r2.getValue(), r3, new f5(r4));
        return Unit.INSTANCE;
    }

    private static final void updateHeight(IntRect r2, LayoutCoordinates r3, int r4, Function1<? super Integer, Unit> r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        r5.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(r3).getTop() - r2.getTop(), (r2.getBottom() - r2.getTop()) - LayoutCoordinatesKt.boundsInWindow(r3).getBottom())) - r4));
    }

    private static final Unit ExposedDropdownMenuBox$lambda$12$lambda$11(Ref r3, WindowBoundsCalculator r4, int r5, MutableIntState r6, final MutableIntState r7, LayoutCoordinates r8) {
        ExposedDropdownMenuBox$lambda$2(r6, (int) (r8.getSize-YbymL2g() >> 32));
        r3.setValue(r8);
        updateHeight(r4.getVisibleWindowBounds(), (LayoutCoordinates) r3.getValue(), r5, new i5(r7));
        return Unit.INSTANCE;
    }

    public static final void ExposedDropdownMenuBox(final boolean r21, final Function1<? super Boolean, Unit> r22, Modifier r23, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> r24, Composer r25, final int r26, final int r27) {
        Composer r3 = r25.startRestartGroup(-1337700255);
        if ((r27 & 1) == 0) goto L6;
        int r6 = r26 | 6;
    L14:
        if ((r27 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L23:
        int r8 = r27 & 4;
        if (r8 == 0) goto L27;
        r6 = r6 | 384;
    L33:
        Modifier r10 = r23;
    L35:
        if ((r27 & 8) == 0) goto L38;
        r6 = r6 | 3072;
    L45:
        if ((r6 & 1171) == 1170) goto L47;
        boolean r11 = true;
    L49:
        if (r3.shouldExecute(r11, r6 & 1) == false) goto L122;
        if (r8 == 0) goto L53;
        r10 = Modifier.Companion;
    L53:
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventStart(-1337700255, r6, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:94)");
    L55:
        final Density r0 = (Density) r3.consume(CompositionLocalsKt.getLocalDensity());
        final WindowBoundsCalculator r9 = ExposedDropdownMenu_android.platformWindowBoundsCalculator(r3, 0);
        Object r12 = r3.rememberedValue();
        Composer.Companion r13 = Composer.Companion;
        if (r12 != r13.getEmpty()) goto L58;
        r12 = SnapshotIntStateKt.mutableIntStateOf(0);
        r3.updateRememberedValue(r12);
    L58:
        final MutableIntState r14 = (MutableIntState) r12;
        Object r15 = r3.rememberedValue();
        if (r15 != r13.getEmpty()) goto L61;
        r15 = SnapshotIntStateKt.mutableIntStateOf(0);
        r3.updateRememberedValue(r15);
    L61:
        final MutableIntState r16 = (MutableIntState) r15;
        int r17 = r0.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
        Object r18 = r3.rememberedValue();
        if (r18 != r13.getEmpty()) goto L64;
        r18 = new Ref();
        r3.updateRememberedValue(r18);
    L64:
        final Ref r19 = (Ref) r18;
        int r7 = ExposedDropdownMenuBox$lambda$4(r16);
        int r20 = ExposedDropdownMenuBox$lambda$1(r14);
        boolean r28 = (r3.changed(r0) | r3.changed(r7)) | r3.changed(r20);
        Object r29 = r3.rememberedValue();
        if (r28 == false) goto L67;
    L68:
        r29 = new ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1(r0, r16, r14);
        r3.updateRememberedValue(r29);
    L69:
        ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 r30 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) r29;
        Object r1 = r3.rememberedValue();
        if (r1 != r13.getEmpty()) goto L72;
        r1 = new FocusRequester();
        r3.updateRememberedValue(r1);
    L72:
        final FocusRequester r2 = (FocusRequester) r1;
        boolean r31 = (r3.changedInstance(r19) | r3.changedInstance(r9)) | r3.changed(r17);
        Object r5 = r3.rememberedValue();
        if (r31 == false) goto L75;
    L78:
        final int r32 = r17;
        r5 = new a5(r19, r9, r32, r14, r16);
        r3.updateRememberedValue(r5);
    L79:
        Modifier r33 = OnGloballyPositionedModifierKt.onGloballyPositioned(r10, (Function1) r5);
        if ((r6 & 112) != 32) goto L82;
        boolean r110 = true;
    L83:
        int r111 = r6 & 14;
        Modifier r112 = r10;
        if (r111 != 4) goto L86;
        boolean r113 = true;
    L87:
        boolean r114 = r113 | r110;
        Object r115 = r3.rememberedValue();
        if (r114 == false) goto L90;
    L91:
        r115 = new b5(r22, r21);
        r3.updateRememberedValue(r115);
    L92:
        Modifier r34 = FocusRequesterModifierKt.focusRequester(expandable(r33, (Function0) r115, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2169getExposedDropdownMenuUdPEhr4(), r3, 6)), r2);
        MeasurePolicy r116 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r117 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r118 = r3.getCurrentCompositionLocalMap();
        Modifier r35 = ComposedModifierKt.materializeModifier(r3, r34);
        ComposeUiNode.Companion r119 = ComposeUiNode.Companion;
        Function0 r4 = r119.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L95;
        ComposablesKt.invalidApplier();
    L95:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L98;
        r3.createNode(r4);
    L99:
        Composer r36 = Updater.constructor-impl(r3);
        Updater.set-impl(r36, r116, r119.getSetMeasurePolicy());
        Updater.set-impl(r36, r118, r119.getSetResolvedCompositionLocals());
        Function2 r120 = r119.getSetCompositeKeyHash();
        if (r36.getInserting() == false) goto L102;
    L103:
        r36.updateRememberedValue(Integer.valueOf(r117));
        r36.apply(Integer.valueOf(r117), r120);
    L104:
        Updater.set-impl(r36, r35, r119.getSetModifier());
        BoxScopeInstance r37 = BoxScopeInstance.INSTANCE;
        r24.invoke(r30, r3, Integer.valueOf((r6 >> 6) & 112));
        r3.endNode();
        if (r111 != 4) goto L107;
        boolean r121 = true;
    L108:
        Object r38 = r3.rememberedValue();
        if (r121 == false) goto L111;
    L112:
        r38 = new c5(r21, r2);
        r3.updateRememberedValue(r38);
    L113:
        EffectsKt.SideEffect((Function0) r38, r3, 0);
        boolean r39 = (r3.changedInstance(r9) | r3.changedInstance(r19)) | r3.changed(r32);
        Object r40 = r3.rememberedValue();
        if (r39 == false) goto L116;
    L117:
        r40 = new d5(r9, r19, r32, r16);
        r3.updateRememberedValue(r40);
    L118:
        ExposedDropdownMenu_android.OnPlatformWindowBoundsChange((Function0) r40, r3, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L121;
        ComposerKt.traceEventEnd();
    L121:
        r10 = r112;
    L123:
        ScopeUpdateScope r41 = r3.endRestartGroup();
        if (r41 == null) goto L127;
        final Modifier r42 = r10;
        r41.updateScope(new e5(r21, r22, r42, r24, r26, r27));
        return;
    L127:
        return;
    L116:
        if (r40 != r13.getEmpty()) goto L118;
    L111:
        if (r38 != r13.getEmpty()) goto L113;
    L107:
        r121 = false;
        goto L108
    L102:
        if (Intrinsics.areEqual(r36.rememberedValue(), Integer.valueOf(r117)) == true) goto L104;
    L98:
        r3.useNode();
        goto L99
    L90:
        if (r115 != r13.getEmpty()) goto L92;
    L86:
        r113 = false;
        goto L87
    L82:
        r110 = false;
        goto L83
    L75:
        if (r5 == r13.getEmpty()) goto L78;
        r32 = r17;
        goto L79
    L67:
        if (r29 != r13.getEmpty()) goto L69;
    L122:
        r3.skipToGroupEnd();
        goto L123
    L47:
        r11 = false;
        goto L49
    L38:
        if ((r26 & 3072) != 0) goto L45;
        if (r3.changedInstance(r24) == false) goto L42;
        int r122 = 2048;
    L43:
        r6 = r6 | r122;
        goto L45
    L42:
        r122 = 1024;
        goto L43
    L27:
        if ((r26 & 384) != 0) goto L33;
        r10 = r23;
        if (r3.changed(r10) == false) goto L31;
        int r123 = 256;
    L32:
        r6 = r6 | r123;
        goto L35
    L31:
        r123 = 128;
        goto L32
    L17:
        if ((r26 & 48) != 0) goto L23;
        if (r3.changedInstance(r22) == false) goto L21;
        int r43 = 32;
    L22:
        r6 = r6 | r43;
        goto L23
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r26 & 6) == 0) goto L8;
        r6 = r26;
        goto L14
    L8:
        if (r3.changed(r21) == false) goto L10;
        int r44 = 4;
    L11:
        r6 = r44 | r26;
        goto L14
    L10:
        r44 = 2;
        goto L11
    }
}
