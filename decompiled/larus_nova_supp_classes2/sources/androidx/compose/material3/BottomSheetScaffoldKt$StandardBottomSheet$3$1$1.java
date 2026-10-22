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
public final class BottomSheetScaffoldKt$StandardBottomSheet$3$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $dismissActionLabel;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ String $expandActionLabel;
    final /* synthetic */ String $partialExpandActionLabel;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ SheetState $state;

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

    public BottomSheetScaffoldKt$StandardBottomSheet$3$1$1(SheetState r1, CoroutineScope r2, boolean r3, String r4, String r5, String r6, Function2<? super Composer, ? super Integer, Unit> r7) {
        this.$state = r1;
        this.$scope = r2;
        this.$sheetSwipeEnabled = r3;
        this.$expandActionLabel = r4;
        this.$partialExpandActionLabel = r5;
        this.$dismissActionLabel = r6;
        this.$dragHandle = r7;
    }

    public static /* synthetic */ boolean a(CoroutineScope r0, SheetState r1) {
        return invoke$lambda$7$lambda$6$lambda$5$lambda$2(r0, r1);
    }

    public static /* synthetic */ boolean b(CoroutineScope r0, SheetState r1) {
        return invoke$lambda$7$lambda$6$lambda$5$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit c(SheetState r0, boolean r1, String r2, String r3, String r4, CoroutineScope r5, SemanticsPropertyReceiver r6) {
        return invoke$lambda$7$lambda$6(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit d(SheetState r0, CoroutineScope r1) {
        return invoke$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ boolean e(CoroutineScope r0, SheetState r1) {
        return invoke$lambda$7$lambda$6$lambda$5$lambda$4(r0, r1);
    }

    private static final Unit invoke$lambda$1$lambda$0(SheetState r16, CoroutineScope r17) {
        SheetValue r1 = r16.getCurrentValue();
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 != 1) goto L5;
        BuildersKt.launch$default(r17, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1(r16, null), 3, null);
    L10:
        return Unit.INSTANCE;
    L5:
        if (r2 == 2) goto L7;
        BuildersKt.launch$default(r17, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3(r16, null), 3, null);
        goto L10
    L7:
        BuildersKt.launch$default(r17, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2(r16, null), 3, null);
        goto L10
    }

    private static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$2(CoroutineScope r6, SheetState r7) {
        BuildersKt.launch$default(r6, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$2$1$1$1$1(r7, null), 3, null);
        return true;
    }

    private static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$3(CoroutineScope r6, SheetState r7) {
        BuildersKt.launch$default(r6, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$2$1$1$2$1(r7, null), 3, null);
        return true;
    }

    private static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$4(CoroutineScope r6, SheetState r7) {
        BuildersKt.launch$default(r6, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$2$1$1$3$1(r7, null), 3, null);
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
        ComposerKt.traceEventStart(-511691176, r14, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:336)");
    L11:
        Modifier.Companion r5 = Modifier.Companion;
        boolean r15 = r13.changed(this.$state) | r13.changedInstance(this.$scope);
        final SheetState r1 = this.$state;
        final CoroutineScope r2 = this.$scope;
        Object r4 = r13.rememberedValue();
        if (r15 == false) goto L14;
    L15:
        r4 = new f2(r1, r2);
        r13.updateRememberedValue(r4);
    L16:
        Modifier r16 = ClickableKt.m377clickableXHw0xAI$default(r5, false, null, null, (Function0) r4, 7, null);
        boolean r3 = ((((r13.changed(this.$state) | r13.changed(this.$sheetSwipeEnabled)) | r13.changed(this.$expandActionLabel)) | r13.changedInstance(this.$scope)) | r13.changed(this.$partialExpandActionLabel)) | r13.changed(this.$dismissActionLabel);
        final SheetState r6 = this.$state;
        final boolean r7 = this.$sheetSwipeEnabled;
        final String r8 = this.$expandActionLabel;
        final String r9 = this.$partialExpandActionLabel;
        final String r10 = this.$dismissActionLabel;
        final CoroutineScope r11 = this.$scope;
        Object r12 = r13.rememberedValue();
        if (r3 == false) goto L19;
    L20:
        r12 = new g2(r6, r7, r8, r9, r10, r11);
        r13.updateRememberedValue(r12);
    L21:
        Modifier r17 = SemanticsModifierKt.semantics(r16, true, (Function1) r12);
        Function2<Composer, Integer, Unit> r18 = this.$dragHandle;
        MeasurePolicy r19 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r20 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r21 = r13.getCurrentCompositionLocalMap();
        Modifier r110 = ComposedModifierKt.materializeModifier(r13, r17);
        ComposeUiNode.Companion r22 = ComposeUiNode.Companion;
        Function0 r23 = r22.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L24;
        ComposablesKt.invalidApplier();
    L24:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L27;
        r13.createNode(r23);
    L28:
        Composer r24 = Updater.constructor-impl(r13);
        Updater.set-impl(r24, r19, r22.getSetMeasurePolicy());
        Updater.set-impl(r24, r21, r22.getSetResolvedCompositionLocals());
        Function2 r25 = r22.getSetCompositeKeyHash();
        if (r24.getInserting() == false) goto L31;
    L32:
        r24.updateRememberedValue(Integer.valueOf(r20));
        r24.apply(Integer.valueOf(r20), r25);
    L33:
        Updater.set-impl(r24, r110, r22.getSetModifier());
        BoxScopeInstance r111 = BoxScopeInstance.INSTANCE;
        r18.invoke(r13, 0);
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
        return;
    L38:
        return;
    L31:
        if (Intrinsics.areEqual(r24.rememberedValue(), Integer.valueOf(r20)) == true) goto L33;
    L27:
        r13.useNode();
        goto L28
    L19:
        if (r12 != Composer.Companion.getEmpty()) goto L21;
    L14:
        if (r4 != Composer.Companion.getEmpty()) goto L16;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$7$lambda$6(final SheetState r2, boolean r3, String r4, String r5, String r6, final CoroutineScope r7, SemanticsPropertyReceiver r8) {
        if (r2.getAnchoredDraggableState$material3().getAnchors().getSize() <= 1) goto L17;
        if (r3 == false) goto L17;
        SheetValue r9 = r2.getCurrentValue();
        SheetValue r0 = SheetValue.PartiallyExpanded;
        if (r9 != r0) goto L11;
        if (((Boolean) r2.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.Expanded)).booleanValue() == false) goto L14;
        SemanticsPropertiesKt.expand(r8, r4, new h2(r7, r2));
    L14:
        if (r2.getSkipHiddenState$material3() == true) goto L17;
        SemanticsPropertiesKt.dismiss(r8, r6, new j2(r7, r2));
        goto L17
    L11:
        if (((Boolean) r2.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(r0)).booleanValue() == false) goto L14;
        SemanticsPropertiesKt.collapse(r8, r5, new i2(r7, r2));
    L17:
        return Unit.INSTANCE;
    }
}
