package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
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
public final class DrawerKt$ModalDrawer$1 implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX WARN: Multi-variable type inference failed */
    public DrawerKt$ModalDrawer$1(DrawerState r1, boolean r2, CoroutineScope r3, long r4, Shape r6, long r7, long r9, float r11, Function2<? super Composer, ? super Integer, Unit> r12, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r13) {
        this.$drawerState = r1;
        this.$gesturesEnabled = r2;
        this.$scope = r3;
        this.$scrimColor = r4;
        this.$drawerShape = r6;
        this.$drawerBackgroundColor = r7;
        this.$drawerContentColor = r9;
        this.$drawerElevation = r11;
        this.$content = r12;
        this.$drawerContent = r13;
    }

    public static /* synthetic */ Unit a(boolean r0, DrawerState r1, CoroutineScope r2) {
        return invoke$lambda$14$lambda$5$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ IntOffset b(DrawerState r0, Density r1) {
        return invoke$lambda$14$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ boolean c(DrawerState r0, CoroutineScope r1) {
        return invoke$lambda$14$lambda$13$lambda$12$lambda$11(r0, r1);
    }

    public static /* synthetic */ Unit d(DrawerState r0, Density r1, float r2, float r3) {
        return invoke$lambda$2$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(float r0, float r1, DraggableAnchorsConfig r2) {
        return invoke$lambda$2$lambda$1$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit f(String r0, DrawerState r1, CoroutineScope r2, SemanticsPropertyReceiver r3) {
        return invoke$lambda$14$lambda$13$lambda$12(r0, r1, r2, r3);
    }

    public static /* synthetic */ float g(float r0, float r1, DrawerState r2) {
        return invoke$lambda$14$lambda$7$lambda$6(r0, r1, r2);
    }

    private static final IntOffset invoke$lambda$14$lambda$10$lambda$9(DrawerState r4, Density r5) {
        return IntOffset.box-impl(IntOffset.constructor-impl((((long) MathKt.roundToInt(r4.requireOffset$material())) << 32) | (((long) 0) & 4294967295L)));
    }

    private static final boolean invoke$lambda$14$lambda$13$lambda$12$lambda$11(DrawerState r7, CoroutineScope r8) {
        if (((Boolean) r7.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(DrawerValue.Closed)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new DrawerKt$ModalDrawer$1$2$6$1$1$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final Unit invoke$lambda$14$lambda$5$lambda$4(boolean r6, DrawerState r7, CoroutineScope r8) {
        if (r6 == false) goto L7;
        if (((Boolean) r7.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(DrawerValue.Closed)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new DrawerKt$ModalDrawer$1$2$2$1$1(r7, null), 3, null);
    L7:
        return Unit.INSTANCE;
    }

    private static final float invoke$lambda$14$lambda$7$lambda$6(float r0, float r1, DrawerState r2) {
        return DrawerKt.access$calculateFraction(r0, r1, r2.requireOffset$material());
    }

    private static final Unit invoke$lambda$2$lambda$1$lambda$0(float r1, float r2, DraggableAnchorsConfig r3) {
        r3.at(DrawerValue.Closed, r1);
        r3.at(DrawerValue.Open, r2);
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope r28, Composer r29, int r30) {
        if ((r30 & 6) == 0) goto L5;
        int r2 = r30;
    L11:
        if ((r2 & 19) == 18) goto L13;
        boolean r3 = true;
    L15:
        if (r29.shouldExecute(r3, r2 & 1) == true) goto L17;
        r29.skipToGroupEnd();
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1549911011, r2, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:464)");
    L19:
        long r10 = r28.mo838getConstraintsmsEJaDk();
        if (Constraints.getHasBoundedWidth-impl(r10) == false) goto L78;
        final float r1 = -Constraints.getMaxWidth-impl(r10);
        final Density r4 = (Density) r29.consume(CompositionLocalsKt.getLocalDensity());
        boolean r5 = (r29.changed(this.$drawerState) | r29.changed(r4)) | r29.changed(r1);
        final DrawerState r6 = this.$drawerState;
        Object r7 = r29.rememberedValue();
        if (r5 == false) goto L24;
    L25:
        r7 = new f4(r6, r4, r1);
        r29.updateRememberedValue(r7);
    L26:
        EffectsKt.SideEffect((Function0) r7, r29, 0);
        if (r29.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L29;
        boolean r18 = true;
    L30:
        Modifier.Companion r12 = Modifier.Companion;
        Modifier r8 = AnchoredDraggableKt.anchoredDraggable$default(r12, this.$drawerState.getAnchoredDraggableState$material(), Orientation.Horizontal, this.$gesturesEnabled, r18, null, false, 48, null);
        final DrawerState r14 = this.$drawerState;
        final boolean r9 = this.$gesturesEnabled;
        final CoroutineScope r15 = this.$scope;
        long r11 = this.$scrimColor;
        Shape r13 = this.$drawerShape;
        long r16 = this.$drawerBackgroundColor;
        long r17 = this.$drawerContentColor;
        float r19 = this.$drawerElevation;
        Function2<Composer, Integer, Unit> r20 = this.$content;
        final Function3<ColumnScope, Composer, Integer, Unit> r21 = this.$drawerContent;
        Alignment.Companion r22 = Alignment.Companion;
        MeasurePolicy r0 = BoxKt.maybeCachedBoxMeasurePolicy(r22.getTopStart(), false);
        int r23 = ComposablesKt.getCurrentCompositeKeyHash(r29, 0);
        CompositionLocalMap r24 = r29.getCurrentCompositionLocalMap();
        Modifier r25 = ComposedModifierKt.materializeModifier(r29, r8);
        ComposeUiNode.Companion r26 = ComposeUiNode.Companion;
        Function0 r27 = r26.getConstructor();
        if ((r29.getApplier() instanceof Applier) == true) goto L33;
        ComposablesKt.invalidApplier();
    L33:
        r29.startReusableNode();
        if (r29.getInserting() == false) goto L36;
        r29.createNode(r27);
    L37:
        Composer r31 = Updater.constructor-impl(r29);
        Updater.set-impl(r31, r0, r26.getSetMeasurePolicy());
        Updater.set-impl(r31, r24, r26.getSetResolvedCompositionLocals());
        Function2 r32 = r26.getSetCompositeKeyHash();
        if (r31.getInserting() == false) goto L40;
    L41:
        r31.updateRememberedValue(Integer.valueOf(r23));
        r31.apply(Integer.valueOf(r23), r32);
    L42:
        Updater.set-impl(r31, r25, r26.getSetModifier());
        BoxScopeInstance r33 = BoxScopeInstance.INSTANCE;
        MeasurePolicy r34 = BoxKt.maybeCachedBoxMeasurePolicy(r22.getTopStart(), false);
        int r35 = ComposablesKt.getCurrentCompositeKeyHash(r29, 0);
        CompositionLocalMap r36 = r29.getCurrentCompositionLocalMap();
        Modifier r37 = ComposedModifierKt.materializeModifier(r29, r12);
        Function0 r38 = r26.getConstructor();
        if ((r29.getApplier() instanceof Applier) == true) goto L45;
        ComposablesKt.invalidApplier();
    L45:
        r29.startReusableNode();
        if (r29.getInserting() == false) goto L48;
        r29.createNode(r38);
    L49:
        Composer r39 = Updater.constructor-impl(r29);
        Updater.set-impl(r39, r34, r26.getSetMeasurePolicy());
        Updater.set-impl(r39, r36, r26.getSetResolvedCompositionLocals());
        Function2 r40 = r26.getSetCompositeKeyHash();
        if (r39.getInserting() == false) goto L52;
    L53:
        r39.updateRememberedValue(Integer.valueOf(r35));
        r39.apply(Integer.valueOf(r35), r40);
    L54:
        Updater.set-impl(r39, r37, r26.getSetModifier());
        r20.invoke(r29, 0);
        r29.endNode();
        boolean r41 = r14.isOpen();
        boolean r42 = (r29.changed(r9) | r29.changed(r14)) | r29.changedInstance(r15);
        Object r43 = r29.rememberedValue();
        if (r42 == false) goto L57;
    L58:
        r43 = new g4(r9, r14, r15);
        r29.updateRememberedValue(r43);
    L59:
        Function0 r44 = (Function0) r43;
        boolean r45 = r29.changed(r1) | r29.changed(r14);
        Object r46 = r29.rememberedValue();
        if (r45 == false) goto L62;
    L63:
        r46 = new h4(r1, r14);
        r29.updateRememberedValue(r46);
    L64:
        DrawerKt.m2045access$ScrimBx497Mc(r41, r44, (Function0) r46, r11, r29, 0);
        final String r47 = Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2170getNavigationMenuUdPEhr4(), r29, 6);
        Density r48 = (Density) r29.consume(CompositionLocalsKt.getLocalDensity());
        Modifier r49 = SizeKt.m1017sizeInqDBjuR0(r12, r48.toDp-u2uoSUM(Constraints.getMinWidth-impl(r10)), r48.toDp-u2uoSUM(Constraints.getMinHeight-impl(r10)), r48.toDp-u2uoSUM(Constraints.getMaxWidth-impl(r10)), r48.toDp-u2uoSUM(Constraints.getMaxHeight-impl(r10)));
        boolean r50 = r29.changed(r14);
        Object r51 = r29.rememberedValue();
        if (r50 == false) goto L67;
    L68:
        r51 = new i4(r14);
        r29.updateRememberedValue(r51);
    L69:
        Modifier r52 = PaddingKt.m964paddingqDBjuR0$default(OffsetKt.offset(r49, (Function1) r51), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, DrawerKt.access$getEndDrawerPadding$p(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 11, null);
        boolean r53 = (r29.changed(r47) | r29.changed(r14)) | r29.changedInstance(r15);
        Object r54 = r29.rememberedValue();
        if (r53 == false) goto L72;
    L73:
        r54 = new j4(r47, r14, r15);
        r29.updateRememberedValue(r54);
    L74:
        SurfaceKt.m2175SurfaceFjzlyU(SemanticsModifierKt.semantics$default(r52, false, (Function1) r54, 1, null), r13, r16, r17, null, r19, ComposableLambdaKt.rememberComposableLambda(1265707871, true, new DrawerKt$ModalDrawer$1$2$7(r21), r29, 54), r29, 1572864, 16);
        r29.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L81;
        ComposerKt.traceEventEnd();
        return;
    L81:
        return;
    L72:
        if (r54 != Composer.Companion.getEmpty()) goto L74;
    L67:
        if (r51 != Composer.Companion.getEmpty()) goto L69;
    L62:
        if (r46 != Composer.Companion.getEmpty()) goto L64;
    L57:
        if (r43 != Composer.Companion.getEmpty()) goto L59;
    L52:
        if (Intrinsics.areEqual(r39.rememberedValue(), Integer.valueOf(r35)) == true) goto L54;
    L48:
        r29.useNode();
        goto L49
    L40:
        if (Intrinsics.areEqual(r31.rememberedValue(), Integer.valueOf(r23)) == true) goto L42;
    L36:
        r29.useNode();
        goto L37
    L29:
        r18 = false;
        goto L30
    L24:
        if (r7 != Composer.Companion.getEmpty()) goto L26;
    L78:
        throw new IllegalStateException("Drawer shouldn't have infinite width");
    L13:
        r3 = false;
        goto L15
    L5:
        if (r29.changed(r28) == false) goto L7;
        int r55 = 4;
    L8:
        r2 = r30 | r55;
        goto L11
    L7:
        r55 = 2;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((BoxWithConstraintsScope) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$14$lambda$13$lambda$12(String r0, final DrawerState r1, final CoroutineScope r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setPaneTitle(r3, r0);
        if (r1.isOpen() == false) goto L6;
        SemanticsPropertiesKt.dismiss$default(r3, null, new e4(r1, r2), 1, null);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$2$lambda$1(DrawerState r0, Density r1, final float r2, final float r3) {
        r0.setDensity$material(r1);
        DraggableAnchors r4 = AnchoredDraggableKt.DraggableAnchors(new d4(r2, r3));
        AnchoredDraggableState.updateAnchors$default(r0.getAnchoredDraggableState$material(), r4, null, 2, null);
        return Unit.INSTANCE;
    }
}
