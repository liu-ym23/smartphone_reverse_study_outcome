package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class DrawerKt$BottomDrawer$1 implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[BottomDrawerValue.values().length];
            r0[BottomDrawerValue.Closed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BottomDrawerValue.Open.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BottomDrawerValue.Expanded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DrawerKt$BottomDrawer$1(boolean r1, BottomDrawerState r2, Function2<? super Composer, ? super Integer, Unit> r3, long r4, CoroutineScope r6, Shape r7, long r8, long r10, float r12, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r13) {
        this.$gesturesEnabled = r1;
        this.$drawerState = r2;
        this.$content = r3;
        this.$scrimColor = r4;
        this.$scope = r6;
        this.$drawerShape = r7;
        this.$drawerBackgroundColor = r8;
        this.$drawerContentColor = r10;
        this.$drawerElevation = r12;
        this.$drawerContent = r13;
    }

    public static /* synthetic */ boolean a(BottomDrawerState r0, CoroutineScope r1) {
        return invoke$lambda$11$lambda$10$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit b(BottomDrawerState r0, float r1, boolean r2, IntSize r3) {
        return invoke$lambda$11$lambda$5$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit c(String r0, BottomDrawerState r1, CoroutineScope r2, SemanticsPropertyReceiver r3) {
        return invoke$lambda$11$lambda$10$lambda$9(r0, r1, r2, r3);
    }

    public static /* synthetic */ IntOffset d(BottomDrawerState r0, Density r1) {
        return invoke$lambda$11$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit e(boolean r0, BottomDrawerState r1, CoroutineScope r2) {
        return invoke$lambda$11$lambda$2$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit f(float r0, float r1, boolean r2, DraggableAnchorsConfig r3) {
        return invoke$lambda$11$lambda$5$lambda$4$lambda$3(r0, r1, r2, r3);
    }

    private static final boolean invoke$lambda$11$lambda$10$lambda$9$lambda$8(BottomDrawerState r7, CoroutineScope r8) {
        if (r7.confirmStateChange$material(BottomDrawerValue.Closed) == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new DrawerKt$BottomDrawer$1$1$4$1$1$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final IntOffset invoke$lambda$11$lambda$7$lambda$6(BottomDrawerState r4, Density r5) {
        long r6 = ((long) MathKt.roundToInt(r4.requireOffset$material())) & 4294967295L;
        return IntOffset.box-impl(IntOffset.constructor-impl(r6 | (((long) 0) << 32)));
    }

    private static final Unit invoke$lambda$11$lambda$2$lambda$1(boolean r6, BottomDrawerState r7, CoroutineScope r8) {
        if (r6 == false) goto L7;
        if (r7.confirmStateChange$material(BottomDrawerValue.Closed) == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new DrawerKt$BottomDrawer$1$1$1$1$1(r7, null), 3, null);
    L7:
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope r26, Composer r27, int r28) {
        if ((r28 & 6) == 0) goto L5;
        int r3 = r28;
    L11:
        if ((r3 & 19) == 18) goto L13;
        boolean r4 = true;
    L15:
        if (r27.shouldExecute(r4, r3 & 1) == true) goto L17;
        r27.skipToGroupEnd();
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(468886998, r3, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:591)");
    L19:
        final float r9 = Constraints.getMaxHeight-impl(r26.mo838getConstraintsmsEJaDk());
        if (Constraints.getMaxWidth-impl(r26.mo838getConstraintsmsEJaDk()) <= Constraints.getMaxHeight-impl(r26.mo838getConstraintsmsEJaDk())) goto L22;
        final boolean r10 = true;
    L23:
        Density r5 = (Density) r27.consume(CompositionLocalsKt.getLocalDensity());
        Modifier r6 = Modifier.Companion;
        Modifier r11 = SizeKt.m1018sizeInqDBjuR0$default(r6, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r5.toDp-u2uoSUM(Constraints.getMaxWidth-impl(r26.mo838getConstraintsmsEJaDk())), r5.toDp-u2uoSUM(Constraints.getMaxHeight-impl(r26.mo838getConstraintsmsEJaDk())), 3, null);
        if (this.$gesturesEnabled == false) goto L26;
        Modifier r1 = NestedScrollModifierKt.nestedScroll$default(r6, this.$drawerState.getNestedScrollConnection$material(), null, 2, null);
    L28:
        if (r27.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L30;
        boolean r18 = true;
    L31:
        Modifier r2 = AnchoredDraggableKt.anchoredDraggable$default(r6.then(r1), this.$drawerState.getAnchoredDraggableState$material(), Orientation.Vertical, this.$gesturesEnabled, r18, null, false, 48, null);
        Function2<Composer, Integer, Unit> r7 = this.$content;
        long r8 = this.$scrimColor;
        final boolean r12 = this.$gesturesEnabled;
        final BottomDrawerState r14 = this.$drawerState;
        final CoroutineScope r15 = this.$scope;
        Shape r13 = this.$drawerShape;
        long r16 = this.$drawerBackgroundColor;
        long r17 = this.$drawerContentColor;
        float r19 = this.$drawerElevation;
        final Function3<ColumnScope, Composer, Integer, Unit> r20 = this.$drawerContent;
        MeasurePolicy r110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r21 = ComposablesKt.getCurrentCompositeKeyHash(r27, 0);
        CompositionLocalMap r22 = r27.getCurrentCompositionLocalMap();
        Modifier r23 = ComposedModifierKt.materializeModifier(r27, r2);
        ComposeUiNode.Companion r24 = ComposeUiNode.Companion;
        Function0 r0 = r24.getConstructor();
        if ((r27.getApplier() instanceof Applier) == true) goto L34;
        ComposablesKt.invalidApplier();
    L34:
        r27.startReusableNode();
        if (r27.getInserting() == false) goto L37;
        r27.createNode(r0);
    L38:
        Composer r25 = Updater.constructor-impl(r27);
        Updater.set-impl(r25, r110, r24.getSetMeasurePolicy());
        Updater.set-impl(r25, r22, r24.getSetResolvedCompositionLocals());
        Function2 r29 = r24.getSetCompositeKeyHash();
        if (r25.getInserting() == false) goto L41;
    L42:
        r25.updateRememberedValue(Integer.valueOf(r21));
        r25.apply(Integer.valueOf(r21), r29);
    L43:
        Updater.set-impl(r25, r23, r24.getSetModifier());
        BoxScopeInstance r30 = BoxScopeInstance.INSTANCE;
        r7.invoke(r27, 0);
        boolean r31 = (r27.changed(r12) | r27.changedInstance(r14)) | r27.changedInstance(r15);
        Object r32 = r27.rememberedValue();
        if (r31 == false) goto L46;
    L47:
        r32 = new w3(r12, r14, r15);
        r27.updateRememberedValue(r32);
    L48:
        Function0 r33 = (Function0) r32;
        if (r14.getTargetValue() == BottomDrawerValue.Closed) goto L51;
        boolean r34 = true;
    L52:
        DrawerKt.m2044access$BottomDrawerScrim3JVO9M(r8, r33, r34, r27, 0);
        final String r35 = Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2170getNavigationMenuUdPEhr4(), r27, 6);
        boolean r36 = (r27.changed(r9) | r27.changed(r10)) | r27.changedInstance(r14);
        Object r37 = r27.rememberedValue();
        if (r36 == false) goto L55;
    L56:
        r37 = new x3(r14, r9, r10);
        r27.updateRememberedValue(r37);
    L57:
        Modifier r38 = OnRemeasuredModifierKt.onSizeChanged(r11, (Function1) r37);
        boolean r39 = r27.changedInstance(r14);
        Object r40 = r27.rememberedValue();
        if (r39 == false) goto L60;
    L61:
        r40 = new y3(r14);
        r27.updateRememberedValue(r40);
    L62:
        Modifier r41 = OffsetKt.offset(r38, (Function1) r40);
        boolean r42 = (r27.changed(r35) | r27.changedInstance(r14)) | r27.changedInstance(r15);
        Object r43 = r27.rememberedValue();
        if (r42 == false) goto L65;
    L66:
        r43 = new z3(r35, r14, r15);
        r27.updateRememberedValue(r43);
    L67:
        SurfaceKt.m2175SurfaceFjzlyU(SemanticsModifierKt.semantics$default(r41, false, (Function1) r43, 1, null), r13, r16, r17, null, r19, ComposableLambdaKt.rememberComposableLambda(1691510868, true, new DrawerKt$BottomDrawer$1$1$5(r20), r27, 54), r27, 1572864, 16);
        r27.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
        return;
    L72:
        return;
    L65:
        if (r43 != Composer.Companion.getEmpty()) goto L67;
    L60:
        if (r40 != Composer.Companion.getEmpty()) goto L62;
    L55:
        if (r37 != Composer.Companion.getEmpty()) goto L57;
    L51:
        r34 = false;
        goto L52
    L46:
        if (r32 != Composer.Companion.getEmpty()) goto L48;
    L41:
        if (Intrinsics.areEqual(r25.rememberedValue(), Integer.valueOf(r21)) == true) goto L43;
    L37:
        r27.useNode();
        goto L38
    L30:
        r18 = false;
        goto L31
    L26:
        r1 = r6;
        goto L28
    L22:
        r10 = false;
        goto L23
    L13:
        r4 = false;
        goto L15
    L5:
        if (r27.changed(r26) == false) goto L7;
        int r44 = 4;
    L8:
        r3 = r28 | r44;
        goto L11
    L7:
        r44 = 2;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((BoxWithConstraintsScope) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$11$lambda$10$lambda$9(String r0, final BottomDrawerState r1, final CoroutineScope r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setPaneTitle(r3, r0);
        if (r1.isOpen() == false) goto L6;
        SemanticsPropertiesKt.dismiss$default(r3, null, new b4(r1, r2), 1, null);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$11$lambda$5$lambda$4(BottomDrawerState r4, final float r5, final boolean r6, IntSize r7) {
        final float r8 = (int) (r7.unbox-impl() & 4294967295L);
        DraggableAnchors<BottomDrawerValue> r9 = AnchoredDraggableKt.DraggableAnchors(new a4(r5, r8, r6));
        if (r4.getAnchoredDraggableState$material().getAnchors().getSize() <= 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
    L10:
        int r11 = WhenMappings.$EnumSwitchMapping$0[r4.getTargetValue().ordinal()];
        if (r11 != 1) goto L13;
        BottomDrawerValue r12 = BottomDrawerValue.Closed;
    L27:
        r4.getAnchoredDraggableState$material().updateAnchors(r9, r12);
        return Unit.INSTANCE;
    L13:
        if (r11 != 2) goto L15;
    L19:
        r12 = BottomDrawerValue.Open;
        if (r9.hasAnchorFor(r12) == true) goto L27;
        r12 = BottomDrawerValue.Expanded;
        if (r9.hasAnchorFor(r12) == true) goto L27;
        r12 = BottomDrawerValue.Closed;
        goto L27
    L15:
        if (r11 == 3) goto L19;
        throw new NoWhenBranchMatchedException();
    L8:
        if (r9.hasAnchorFor(r4.getCurrentValue()) == false) goto L10;
        r12 = r4.getCurrentValue();
        goto L27
    L5:
        r10 = false;
        goto L6
    }

    private static final Unit invoke$lambda$11$lambda$5$lambda$4$lambda$3(float r2, float r3, boolean r4, DraggableAnchorsConfig r5) {
        r5.at(BottomDrawerValue.Closed, r2);
        float r0 = 0.5f * r2;
        if (r3 > r0) goto L5;
        if (r4 == true) goto L5;
    L7:
        if (r3 <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L10;
        r5.at(BottomDrawerValue.Expanded, Math.max(androidx.compose.material3.MenuKt.ClosedAlphaTarget, r2 - r3));
    L10:
        return Unit.INSTANCE;
    L5:
        r5.at(BottomDrawerValue.Open, r0);
        goto L7
    }
}
