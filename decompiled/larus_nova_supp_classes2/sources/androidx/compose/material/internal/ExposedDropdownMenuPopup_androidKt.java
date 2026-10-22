package androidx.compose.material.internal;

import android.view.View;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a:\u0010\u0000\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0001¢\u0006\u0002\u0010\b\u001a+\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0083\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012²\u0006\u0015\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u008a\u0084\u0002"}, d2 = {"ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = null;

    private static final Unit ExposedDropdownMenuPopup$lambda$17(Function0 r6, PopupPositionProvider r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        ExposedDropdownMenuPopup(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final String LocalPopupTestTag$lambda$18() {
        return "DEFAULT_TEST_TAG";
    }

    public static /* synthetic */ DisposableEffectResult a(PopupLayout r0, PopupPositionProvider r1, DisposableEffectScope r2) {
        return ExposedDropdownMenuPopup$lambda$12$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(Function0 r0, PopupPositionProvider r1, Function2 r2, int r3, int r4, Composer r5, int r6) {
        return ExposedDropdownMenuPopup$lambda$17(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ UUID c() {
        return ExposedDropdownMenuPopup$lambda$2$lambda$1();
    }

    public static /* synthetic */ Unit d(PopupLayout r0, Function0 r1, String r2, LayoutDirection r3) {
        return ExposedDropdownMenuPopup$lambda$9$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit e(PopupLayout r0, LayoutCoordinates r1) {
        return ExposedDropdownMenuPopup$lambda$15$lambda$14(r0, r1);
    }

    public static /* synthetic */ DisposableEffectResult f(PopupLayout r0, Function0 r1, String r2, LayoutDirection r3, DisposableEffectScope r4) {
        return ExposedDropdownMenuPopup$lambda$7$lambda$6(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ String g() {
        return LocalPopupTestTag$lambda$18();
    }

    static {
        LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new g(), 1, null);
    }

    private static final UUID ExposedDropdownMenuPopup$lambda$2$lambda$1() {
        return UUID.randomUUID();
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    private static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> r0) {
        return (Function2) r0.getValue();
    }

    public static final /* synthetic */ Function2 access$ExposedDropdownMenuPopup$lambda$0(State r0) {
        return ExposedDropdownMenuPopup$lambda$0(r0);
    }

    private static final Unit ExposedDropdownMenuPopup$lambda$15$lambda$14(PopupLayout r9, LayoutCoordinates r10) {
        LayoutCoordinates r11 = r10.getParentLayoutCoordinates();
        Intrinsics.checkNotNull(r11);
        long r0 = r11.getSize-YbymL2g();
        long r2 = LayoutCoordinatesKt.positionInWindow(r11);
        int r4 = MathKt.roundToInt(Float.intBitsToFloat((int) (r2 >> 32)));
        int r3 = MathKt.roundToInt(Float.intBitsToFloat((int) (r2 & 4294967295L)));
        r9.setParentBounds(IntRectKt.IntRect-VbeCjmY(IntOffset.constructor-impl((((long) r4) << 32) | (4294967295L & ((long) r3))), r0));
        r9.updatePosition();
        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult ExposedDropdownMenuPopup$lambda$12$lambda$11(PopupLayout r0, PopupPositionProvider r1, DisposableEffectScope r2) {
        r0.setPositionProvider(r1);
        r0.updatePosition();
        return new ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$lambda$12$lambda$11$$inlined$onDispose$1();
    }

    private static final Unit ExposedDropdownMenuPopup$lambda$9$lambda$8(PopupLayout r0, Function0 r1, String r2, LayoutDirection r3) {
        r0.updateParameters(r1, r2, r3);
        return Unit.INSTANCE;
    }

    private static final void SimpleStack(Modifier r6, Function2<? super Composer, ? super Integer, Unit> r7, Composer r8, int r9) {
        Object r0 = r8.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L5;
        r0 = ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1.INSTANCE;
        r8.updateRememberedValue(r0);
    L5:
        MeasurePolicy r1 = (MeasurePolicy) r0;
        int r2 = ((r9 >> 3) & 14) | 384;
        int r10 = ((r9 << 3) & 112) | r2;
        int r3 = ComposablesKt.getCurrentCompositeKeyHash(r8, 0);
        CompositionLocalMap r4 = r8.getCurrentCompositionLocalMap();
        Modifier r11 = ComposedModifierKt.materializeModifier(r8, r6);
        ComposeUiNode.Companion r5 = ComposeUiNode.Companion;
        Function0 r12 = r5.getConstructor();
        int r13 = ((r10 << 6) & 896) | 6;
        if ((r8.getApplier() instanceof Applier) == true) goto L8;
        ComposablesKt.invalidApplier();
    L8:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L11;
        r8.createNode(r12);
    L12:
        Composer r14 = Updater.constructor-impl(r8);
        Updater.set-impl(r14, r1, r5.getSetMeasurePolicy());
        Updater.set-impl(r14, r4, r5.getSetResolvedCompositionLocals());
        Function2 r15 = r5.getSetCompositeKeyHash();
        if (r14.getInserting() == false) goto L15;
    L16:
        r14.updateRememberedValue(Integer.valueOf(r3));
        r14.apply(Integer.valueOf(r3), r15);
    L17:
        Updater.set-impl(r14, r11, r5.getSetModifier());
        r7.invoke(r8, Integer.valueOf((r13 >> 6) & 14));
        r8.endNode();
        return;
    L15:
        if (Intrinsics.areEqual(r14.rememberedValue(), Integer.valueOf(r3)) == true) goto L17;
    L11:
        r8.useNode();
        goto L12
    }

    private static final DisposableEffectResult ExposedDropdownMenuPopup$lambda$7$lambda$6(final PopupLayout r0, Function0 r1, String r2, LayoutDirection r3, DisposableEffectScope r4) {
        r0.show();
        r0.updateParameters(r1, r2, r3);
        return new ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$lambda$7$lambda$6$$inlined$onDispose$1(r0);
    }

    public static final void ExposedDropdownMenuPopup(Function0<Unit> r20, final PopupPositionProvider r21, final Function2<? super Composer, ? super Integer, Unit> r22, Composer r23, final int r24, final int r25) {
        Composer r10 = r23.startRestartGroup(1705178815);
        int r1 = r25 & 1;
        if (r1 == 0) goto L6;
        int r3 = r24 | 6;
        Function0<Unit> r2 = r20;
    L14:
        if ((r25 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r25 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L33:
        int r13 = r3;
        boolean r15 = true;
        if ((r13 & 147) == 146) goto L36;
        boolean r4 = true;
    L38:
        if (r10.shouldExecute(r4, r13 & 1) == false) goto L107;
        if (r1 == 0) goto L41;
        Function0<Unit> r6 = null;
    L43:
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventStart(1705178815, r13, -1, "androidx.compose.material.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.android.kt:80)");
    L45:
        View r5 = (View) r10.consume(AndroidCompositionLocals_androidKt.getLocalView());
        Density r7 = (Density) r10.consume(CompositionLocalsKt.getLocalDensity());
        final String r8 = (String) r10.consume(LocalPopupTestTag);
        Enum r9 = (LayoutDirection) r10.consume(CompositionLocalsKt.getLocalLayoutDirection());
        CompositionContext r11 = ComposablesKt.rememberCompositionContext(r10, 0);
        State r0 = SnapshotStateKt.rememberUpdatedState(r22, r10, (r13 >> 6) & 14);
        Object[] r12 = new Object[0];
        Object r14 = r10.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r14 != r16.getEmpty()) goto L48;
        r14 = new a();
        r10.updateRememberedValue(r14);
    L48:
        UUID r17 = (UUID) RememberSaveableKt.rememberSaveable(r12, (Function0) r14, r10, 48);
        Object r18 = r10.rememberedValue();
        if (r18 != r16.getEmpty()) goto L51;
        PopupLayout r19 = new PopupLayout(r6, r8, r5, r7, r21, r17);
        r19.setContent(r11, ComposableLambdaKt.composableLambdaInstance(1879981140, true, new ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1(r19, r0)));
        r10.updateRememberedValue(r19);
        Object r110 = r19;
    L52:
        final PopupLayout r111 = (PopupLayout) r110;
        boolean r26 = r10.changedInstance(r111);
        int r27 = r13 & 14;
        if (r27 != 4) goto L55;
        boolean r28 = true;
    L56:
        boolean r29 = ((r26 | r28) | r10.changed(r8)) | r10.changed(r9.ordinal());
        Object r30 = r10.rememberedValue();
        if (r29 == false) goto L59;
    L62:
        final Enum r31 = r9;
        final Function0<Unit> r32 = r6;
        r30 = new b(r111, r32, r8, r31);
        r10.updateRememberedValue(r30);
    L63:
        EffectsKt.DisposableEffect(r111, (Function1) r30, r10, 0);
        boolean r33 = r10.changedInstance(r111);
        if (r27 != 4) goto L66;
        boolean r34 = true;
    L67:
        boolean r35 = ((r34 | r33) | r10.changed(r8)) | r10.changed(r31.ordinal());
        Object r36 = r10.rememberedValue();
        if (r35 == false) goto L70;
    L71:
        r36 = new c(r111, r32, r8, r31);
        r10.updateRememberedValue(r36);
    L72:
        EffectsKt.SideEffect((Function0) r36, r10, 0);
        boolean r37 = r10.changedInstance(r111);
        if ((r13 & 112) == 32) goto L76;
        r15 = false;
    L76:
        boolean r38 = r37 | r15;
        Object r39 = r10.rememberedValue();
        if (r38 == false) goto L79;
    L80:
        r39 = new d(r111, r21);
        r10.updateRememberedValue(r39);
    L81:
        EffectsKt.DisposableEffect(r21, (Function1) r39, r10, (r13 >> 3) & 14);
        Modifier.Companion r40 = Modifier.Companion;
        boolean r41 = r10.changedInstance(r111);
        Object r42 = r10.rememberedValue();
        if (r41 == false) goto L84;
    L85:
        r42 = new e(r111);
        r10.updateRememberedValue(r42);
    L86:
        Modifier r43 = OnGloballyPositionedModifierKt.onGloballyPositioned(r40, (Function1) r42);
        boolean r44 = r10.changedInstance(r111) | r10.changed(r31.ordinal());
        Object r45 = r10.rememberedValue();
        if (r44 == false) goto L89;
    L90:
        r45 = new ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1(r111, r31);
        r10.updateRememberedValue(r45);
    L91:
        MeasurePolicy r46 = (MeasurePolicy) r45;
        int r47 = ComposablesKt.getCurrentCompositeKeyHash(r10, 0);
        CompositionLocalMap r48 = r10.getCurrentCompositionLocalMap();
        Modifier r49 = ComposedModifierKt.materializeModifier(r10, r43);
        ComposeUiNode.Companion r50 = ComposeUiNode.Companion;
        Function0 r51 = r50.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L94;
        ComposablesKt.invalidApplier();
    L94:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L97;
        r10.createNode(r51);
    L98:
        Composer r52 = Updater.constructor-impl(r10);
        Updater.set-impl(r52, r46, r50.getSetMeasurePolicy());
        Updater.set-impl(r52, r48, r50.getSetResolvedCompositionLocals());
        Function2 r53 = r50.getSetCompositeKeyHash();
        if (r52.getInserting() == false) goto L101;
    L102:
        r52.updateRememberedValue(Integer.valueOf(r47));
        r52.apply(Integer.valueOf(r47), r53);
    L103:
        Updater.set-impl(r52, r49, r50.getSetModifier());
        r10.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventEnd();
    L106:
        final Function0<Unit> r54 = r32;
    L108:
        ScopeUpdateScope r55 = r10.endRestartGroup();
        if (r55 == null) goto L112;
        r55.updateScope(new f(r54, r21, r22, r24, r25));
        return;
    L112:
        return;
    L101:
        if (Intrinsics.areEqual(r52.rememberedValue(), Integer.valueOf(r47)) == true) goto L103;
    L97:
        r10.useNode();
        goto L98
    L89:
        if (r45 != r16.getEmpty()) goto L91;
    L84:
        if (r42 != r16.getEmpty()) goto L86;
    L79:
        if (r39 != r16.getEmpty()) goto L81;
    L70:
        if (r36 != r16.getEmpty()) goto L72;
    L66:
        r34 = false;
        goto L67
    L59:
        if (r30 == r16.getEmpty()) goto L62;
        r31 = r9;
        r32 = r6;
        goto L63
    L55:
        r28 = false;
        goto L56
    L51:
        r110 = r18;
        goto L52
    L41:
        r6 = r2;
        goto L43
    L107:
        r10.skipToGroupEnd();
        r54 = r2;
        goto L108
    L36:
        r4 = false;
        goto L38
    L27:
        if ((r24 & 384) != 0) goto L33;
        if (r10.changedInstance(r22) == false) goto L31;
        int r56 = 256;
    L32:
        r3 = r3 | r56;
        goto L33
    L31:
        r56 = 128;
        goto L32
    L17:
        if ((r24 & 48) != 0) goto L24;
        if (r10.changed(r21) == false) goto L21;
        int r57 = 32;
    L22:
        r3 = r3 | r57;
        goto L24
    L21:
        r57 = 16;
        goto L22
    L6:
        if ((r24 & 6) != 0) goto L12;
        r2 = r20;
        if (r10.changedInstance(r2) == false) goto L10;
        int r58 = 4;
    L11:
        r3 = r58 | r24;
        goto L14
    L10:
        r58 = 2;
        goto L11
    L12:
        r2 = r20;
        r3 = r24;
        goto L14
    }
}
