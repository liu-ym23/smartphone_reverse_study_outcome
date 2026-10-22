package androidx.compose.material3;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt$ModalBottomSheetContent$7$2$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $animateToDismiss;
    final /* synthetic */ String $collapseActionLabel;
    final /* synthetic */ String $dismissActionLabel;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ String $expandActionLabel;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ SheetState $sheetState;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SheetValue.values().length];
            r0[SheetValue.Expanded.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SheetValue.PartiallyExpanded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public ModalBottomSheetKt$ModalBottomSheetContent$7$2$1(SheetState r1, Function0<Unit> r2, CoroutineScope r3, boolean r4, String r5, String r6, String r7, Function2<? super Composer, ? super Integer, Unit> r8) {
        this.$sheetState = r1;
        this.$animateToDismiss = r2;
        this.$scope = r3;
        this.$sheetGesturesEnabled = r4;
        this.$dismissActionLabel = r5;
        this.$expandActionLabel = r6;
        this.$collapseActionLabel = r7;
        this.$dragHandle = r8;
    }

    public static /* synthetic */ boolean a(SheetState r0, CoroutineScope r1, SheetState r2) {
        return invoke$lambda$7$lambda$6$lambda$5$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ boolean b(SheetState r0, CoroutineScope r1) {
        return invoke$lambda$7$lambda$6$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ boolean c(Function0 r0) {
        return invoke$lambda$7$lambda$6$lambda$5$lambda$2(r0);
    }

    public static /* synthetic */ Unit d(boolean r0, SheetState r1, String r2, String r3, String r4, Function0 r5, CoroutineScope r6, SemanticsPropertyReceiver r7) {
        return invoke$lambda$7$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit e(SheetState r0, Function0 r1, CoroutineScope r2) {
        return invoke$lambda$1$lambda$0(r0, r1, r2);
    }

    private static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$2(Function0 r0) {
        r0.invoke();
        return true;
    }

    private static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$4(SheetState r7, CoroutineScope r8) {
        if (((Boolean) r7.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.PartiallyExpanded)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r8, null, null, new ModalBottomSheetKt$ModalBottomSheetContent$7$2$1$2$1$1$3$1(r7, null), 3, null);
        return true;
    L7:
        return true;
    }

    public final void invoke(Composer r13, int r14) {
        if ((r14 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r13.shouldExecute(r0, r14 & 1) == true) goto L9;
        r13.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(2000500644, r14, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.kt:383)");
    L11:
        Modifier.Companion r5 = Modifier.Companion;
        boolean r15 = (r13.changed(this.$sheetState) | r13.changed(this.$animateToDismiss)) | r13.changedInstance(this.$scope);
        final SheetState r1 = this.$sheetState;
        final Function0<Unit> r2 = this.$animateToDismiss;
        final CoroutineScope r4 = this.$scope;
        Object r9 = r13.rememberedValue();
        if (r15 == false) goto L14;
    L15:
        r9 = new xe(r1, r2, r4);
        r13.updateRememberedValue(r9);
    L16:
        Modifier r16 = ClickableKt.m377clickableXHw0xAI$default(r5, false, null, null, (Function0) r9, 7, null);
        boolean r3 = (((((r13.changed(this.$sheetGesturesEnabled) | r13.changed(this.$sheetState)) | r13.changed(this.$dismissActionLabel)) | r13.changed(this.$animateToDismiss)) | r13.changed(this.$expandActionLabel)) | r13.changedInstance(this.$scope)) | r13.changed(this.$collapseActionLabel);
        final boolean r6 = this.$sheetGesturesEnabled;
        final SheetState r7 = this.$sheetState;
        final String r8 = this.$dismissActionLabel;
        final String r10 = this.$expandActionLabel;
        final String r11 = this.$collapseActionLabel;
        final Function0<Unit> r12 = this.$animateToDismiss;
        final CoroutineScope r17 = this.$scope;
        Object r18 = r13.rememberedValue();
        if (r3 == false) goto L19;
    L20:
        r18 = new ye(r6, r7, r8, r10, r11, r12, r17);
        r13.updateRememberedValue(r18);
    L21:
        Modifier r19 = SemanticsModifierKt.semantics(r16, true, (Function1) r18);
        Function2<Composer, Integer, Unit> r20 = this.$dragHandle;
        MeasurePolicy r21 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r22 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r23 = r13.getCurrentCompositionLocalMap();
        Modifier r110 = ComposedModifierKt.materializeModifier(r13, r19);
        ComposeUiNode.Companion r24 = ComposeUiNode.Companion;
        Function0 r25 = r24.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L24;
        ComposablesKt.invalidApplier();
    L24:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L27;
        r13.createNode(r25);
    L28:
        Composer r26 = Updater.constructor-impl(r13);
        Updater.set-impl(r26, r21, r24.getSetMeasurePolicy());
        Updater.set-impl(r26, r23, r24.getSetResolvedCompositionLocals());
        Function2 r27 = r24.getSetCompositeKeyHash();
        if (r26.getInserting() == false) goto L31;
    L32:
        r26.updateRememberedValue(Integer.valueOf(r22));
        r26.apply(Integer.valueOf(r22), r27);
    L33:
        Updater.set-impl(r26, r110, r24.getSetModifier());
        BoxScopeInstance r111 = BoxScopeInstance.INSTANCE;
        r20.invoke(r13, 0);
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
        return;
    L38:
        return;
    L31:
        if (Intrinsics.areEqual(r26.rememberedValue(), Integer.valueOf(r22)) == true) goto L33;
    L27:
        r13.useNode();
        goto L28
    L19:
        if (r18 != Composer.Companion.getEmpty()) goto L21;
    L14:
        if (r9 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$1$lambda$0(SheetState r16, Function0 r17, CoroutineScope r18) {
        SheetValue r1 = r16.getCurrentValue();
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 != 1) goto L5;
        r17.invoke();
        Unit r0 = Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L5:
        if (r2 == 2) goto L7;
        BuildersKt.launch$default(r18, null, null, new ModalBottomSheetKt$ModalBottomSheetContent$7$2$1$1$1$2(r16, null), 3, null);
        goto L10
    L7:
        BuildersKt.launch$default(r18, null, null, new ModalBottomSheetKt$ModalBottomSheetContent$7$2$1$1$1$1(r16, null), 3, null);
        goto L10
    }

    private static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$3(SheetState r6, CoroutineScope r7, SheetState r8) {
        if (((Boolean) r6.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.Expanded)).booleanValue() == false) goto L7;
        BuildersKt.launch$default(r7, null, null, new ModalBottomSheetKt$ModalBottomSheetContent$7$2$1$2$1$1$2$1(r8, null), 3, null);
        return true;
    L7:
        return true;
    }

    private static final Unit invoke$lambda$7$lambda$6(boolean r0, final SheetState r1, String r2, String r3, String r4, final Function0 r5, final CoroutineScope r6, SemanticsPropertyReceiver r7) {
        if (r0 == false) goto L10;
        SemanticsPropertiesKt.dismiss(r7, r2, new ue(r5));
        if (r1.getCurrentValue() != SheetValue.PartiallyExpanded) goto L7;
        SemanticsPropertiesKt.expand(r7, r3, new ve(r1, r6, r1));
        goto L10
    L7:
        if (r1.getHasPartiallyExpandedState() == false) goto L10;
        SemanticsPropertiesKt.collapse(r7, r4, new we(r1, r6));
    L10:
        return Unit.INSTANCE;
    }
}
