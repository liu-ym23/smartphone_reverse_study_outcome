package androidx.compose.foundation.contextmenu;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u000e\u001aN\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0011\u001a:\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0013\u001a=\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\u0017¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u0018\u001ai\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2*\b\u0002\u0010\u001e\u001a$\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\b\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0002\u0010$\u001a!\u0010,\u001a\u00020\u00102\b\b\u0003\u0010-\u001a\u00020.2\b\b\u0003\u0010/\u001a\u00020.H\u0001¢\u0006\u0002\u00100\u001a/\u00101\u001a\u00020\u001f*\u0002022\b\b\u0001\u00103\u001a\u00020.2\b\b\u0001\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b6\u00107\u001a\"\u00108\u001a\u0004\u0018\u000109*\u0002022\b\b\u0001\u00103\u001a\u00020.2\b\b\u0001\u00104\u001a\u00020.H\u0002\u001a\u001d\u0010:\u001a\u00020\u001f*\u0004\u0018\u0001092\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b;\u0010<\u001a\u001d\u0010=\u001a\u00020\u001f*\u0004\u0018\u0001092\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b>\u0010<\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010'\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006?"}, d2 = {"DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "ContextMenuPopup", "", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "colors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuColumnBuilder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuColumn", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ContextMenuItem", "label", "", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "iconColor", "onClick", "(Ljava/lang/String;ZLandroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DisabledAlpha", "", "DefaultContextMenuColors", "getDefaultContextMenuColors$annotations", "()V", "getDefaultContextMenuColors", "()Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "computeContextMenuColors", "backgroundStyleId", "", "foregroundStyleId", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "resolveColor", "Landroid/content/Context;", "resId", "attrId", "defaultColor", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColorStateList", "Landroid/content/res/ColorStateList;", "enabledColor", "enabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "disabledColor", "disabledColor-4WTKRHQ", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuUi_androidKt {
    private static final ContextMenuColors DefaultContextMenuColors = null;
    private static final PopupProperties DefaultPopupProperties = null;
    private static final float DisabledAlpha = 0.38f;

    private static final Unit ContextMenuColumn$lambda$3(ContextMenuColors r6, Modifier r7, Function3 r8, int r9, int r10, Composer r11, int r12) {
        ContextMenuColumn(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuColumnBuilder$lambda$2(Modifier r6, ContextMenuColors r7, Function1 r8, int r9, int r10, Composer r11, int r12) {
        ContextMenuColumnBuilder(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuItem$lambda$9(String r10, boolean r11, ContextMenuColors r12, Modifier r13, Function3 r14, Function0 r15, int r16, int r17, Composer r18, int r19) {
        ContextMenuItem(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuPopup$lambda$0(PopupPositionProvider r7, Function0 r8, Modifier r9, Function1 r10, int r11, int r12, Composer r13, int r14) {
        ContextMenuPopup(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit ContextMenuPopup$lambda$1(PopupPositionProvider r9, Function0 r10, Modifier r11, ContextMenuColors r12, Function1 r13, int r14, int r15, Composer r16, int r17) {
        ContextMenuPopup(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ContextMenuColors r0, Modifier r1, Function3 r2, int r3, int r4, Composer r5, int r6) {
        return ContextMenuColumn$lambda$3(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit b(PopupPositionProvider r0, Function0 r1, Modifier r2, ContextMenuColors r3, Function1 r4, int r5, int r6, Composer r7, int r8) {
        return ContextMenuPopup$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit c(String r0, boolean r1, ContextMenuColors r2, Modifier r3, Function3 r4, Function0 r5, int r6, int r7, Composer r8, int r9) {
        return ContextMenuItem$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit d(boolean r0, Function0 r1) {
        return ContextMenuItem$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit e(Modifier r0, ContextMenuColors r1, Function1 r2, int r3, int r4, Composer r5, int r6) {
        return ContextMenuColumnBuilder$lambda$2(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit f(PopupPositionProvider r0, Function0 r1, Modifier r2, Function1 r3, int r4, int r5, Composer r6, int r7) {
        return ContextMenuPopup$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void getDefaultContextMenuColors$annotations() {
    }

    static {
        DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, null);
        Color.Companion r1 = Color.Companion;
        DefaultContextMenuColors = new ContextMenuColors(r1.getWhite-0d7_KjU(), r1.getBlack-0d7_KjU(), r1.getBlack-0d7_KjU(), Color.copy-wmQWz5c$default(r1.getBlack-0d7_KjU(), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(r1.getBlack-0d7_KjU(), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
    }

    public static final ContextMenuColors getDefaultContextMenuColors() {
        return DefaultContextMenuColors;
    }

    private static final Unit ContextMenuItem$lambda$5$lambda$4(boolean r0, Function0 r1) {
        if (r0 == false) goto L5;
        r1.invoke();
    L5:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: disabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m490disabledColor4WTKRHQ(ColorStateList r4, long r5) {
        int r0 = ColorKt.toArgb-8_81llA(r5);
        if (r4 == null) goto L5;
        Integer r6 = Integer.valueOf(r4.getColorForState(new int[]{-16842910}, r0));
    L6:
        if (r6 != null) goto L8;
        return r5;
    L8:
        if (r6.intValue() != r0) goto L11;
        return r5;
    L11:
        return ColorKt.Color(r6.intValue());
    L5:
        r6 = null;
        goto L6
    }

    /* JADX INFO: renamed from: enabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m491enabledColor4WTKRHQ(ColorStateList r4, long r5) {
        int r0 = ColorKt.toArgb-8_81llA(r5);
        if (r4 == null) goto L5;
        Integer r6 = Integer.valueOf(r4.getColorForState(new int[]{R.attr.state_enabled}, r0));
    L6:
        if (r6 != null) goto L8;
        return r5;
    L8:
        if (r6.intValue() != r0) goto L11;
        return r5;
    L11:
        return ColorKt.Color(r6.intValue());
    L5:
        r6 = null;
        goto L6
    }

    private static final ColorStateList resolveColorStateList(Context r2, int r3, int r4) {
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{r4});
        ColorStateList r6 = r5.getColorStateList(0);
        r5.recycle();
        return r6;
    }

    /* JADX INFO: renamed from: resolveColor-g2O1Hgs, reason: not valid java name */
    private static final long m492resolveColorg2O1Hgs(Context r2, int r3, int r4, long r5) {
        TypedArray r6 = r2.obtainStyledAttributes(r3, new int[]{r4});
        int r7 = ColorKt.toArgb-8_81llA(r5);
        int r8 = r6.getColor(0, r7);
        r6.recycle();
        if (r8 != r7) goto L6;
        return r5;
    L6:
        return ColorKt.Color(r8);
    }

    public static final ContextMenuColors computeContextMenuColors(int r20, int r21, Composer r22, int r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        int r1 = R.style.Widget.PopupMenu;
    L7:
        if ((r24 & 2) == 0) goto L9;
        int r2 = R.style.TextAppearance.Widget.PopupMenu.Large;
    L11:
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventStart(1689505294, r23, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:383)");
    L13:
        Context r3 = (Context) r22.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Configuration r4 = (Configuration) r22.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        boolean r5 = r22.changed(r3);
        boolean r6 = r22.changed(r4) | r5;
        Object r7 = r22.rememberedValue();
        if (r6 == false) goto L16;
    L17:
        ContextMenuColors r8 = DefaultContextMenuColors;
        long r9 = m492resolveColorg2O1Hgs(r3, r1, R.attr.colorBackground, r8.m468getBackgroundColor0d7_KjU());
        ColorStateList r10 = resolveColorStateList(r3, r2, R.attr.textColorPrimary);
        long r13 = m491enabledColor4WTKRHQ(r10, r8.m472getTextColor0d7_KjU());
        long r17 = m490disabledColor4WTKRHQ(r10, r8.m470getDisabledTextColor0d7_KjU());
        r7 = new ContextMenuColors(r9, r13, r13, r17, r17, null);
        r22.updateRememberedValue(r7);
    L18:
        ContextMenuColors r11 = (ContextMenuColors) r7;
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
    L21:
        return r11;
    L16:
        if (r7 != Composer.Companion.getEmpty()) goto L18;
    L9:
        r2 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }

    public static final void ContextMenuColumn(final ContextMenuColors r29, Modifier r30, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(621449936);
        if ((r34 & 1) == 0) goto L6;
        int r5 = r33 | 6;
    L13:
        int r6 = r34 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L23:
        Modifier r8 = r30;
    L25:
        if ((r34 & 4) == 0) goto L28;
        r5 = r5 | 384;
    L35:
        if ((r5 & 147) == 146) goto L37;
        boolean r9 = true;
    L39:
        if (r1.shouldExecute(r9, r5 & 1) == false) goto L61;
        if (r6 == 0) goto L42;
        Modifier r7 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(621449936, r5, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumn (ContextMenuUi.android.kt:158)");
    L46:
        ContextMenuSpec r0 = ContextMenuSpec.INSTANCE;
        Modifier r13 = r7;
        Modifier r2 = ScrollKt.verticalScroll$default(PaddingKt.m962paddingVpY3zN4$default(IntrinsicKt.width(BackgroundKt.m342backgroundbw27NRU$default(ShadowKt.shadow-s4CzXII$default(r13, r0.m486getMenuContainerElevationD9Ej5fM(), RoundedCornerShapeKt.m1334RoundedCornerShape0680j_4(r0.m476getCornerRadiusD9Ej5fM()), false, 0, 0, 28, null), r29.m468getBackgroundColor0d7_KjU(), null, 2, null), IntrinsicSize.Max), MenuKt.ClosedAlphaTarget, r0.m487getVerticalPaddingD9Ej5fM(), 1, null), ScrollKt.rememberScrollState(0, r1, 0, 1), false, null, false, 14, null);
        int r10 = (r5 << 3) & 7168;
        int r11 = r10 >> 3;
        int r12 = r11 & 14;
        MeasurePolicy r14 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r1, (r11 & 112) | r12);
        long r15 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r16 = (int) (r15 ^ (r15 >>> 32));
        CompositionLocalMap r17 = r1.getCurrentCompositionLocalMap();
        Modifier r3 = ComposedModifierKt.materializeModifier(r1, r2);
        ComposeUiNode.Companion r18 = ComposeUiNode.Companion;
        Function0 r19 = r18.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L49;
        ComposablesKt.invalidApplier();
    L49:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L52;
        r1.createNode(r19);
    L53:
        Composer r110 = Updater.constructor-impl(r1);
        Updater.set-impl(r110, r14, r18.getSetMeasurePolicy());
        Updater.set-impl(r110, r17, r18.getSetResolvedCompositionLocals());
        Function2 r20 = r18.getSetCompositeKeyHash();
        if (r110.getInserting() == false) goto L56;
    L57:
        r110.updateRememberedValue(Integer.valueOf(r16));
        r110.apply(Integer.valueOf(r16), r20);
    L58:
        Updater.set-impl(r110, r3, r18.getSetModifier());
        r31.invoke(ColumnScopeInstance.INSTANCE, r1, Integer.valueOf(((r10 >> 6) & 112) | 6));
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
    L62:
        ScopeUpdateScope r21 = r1.endRestartGroup();
        if (r21 == null) goto L66;
        final Modifier r4 = r7;
        r21.updateScope(new k(r29, r4, r31, r33, r34));
        return;
    L66:
        return;
    L56:
        if (Intrinsics.areEqual(r110.rememberedValue(), Integer.valueOf(r16)) == true) goto L58;
    L52:
        r1.useNode();
        goto L53
    L42:
        r7 = r8;
        goto L44
    L61:
        r1.skipToGroupEnd();
        r7 = r8;
        goto L62
    L37:
        r9 = false;
        goto L39
    L28:
        if ((r33 & 384) != 0) goto L35;
        if (r1.changedInstance(r31) == false) goto L32;
        int r22 = 256;
    L33:
        r5 = r5 | r22;
        goto L35
    L32:
        r22 = 128;
        goto L33
    L17:
        if ((r33 & 48) != 0) goto L23;
        r8 = r30;
        if (r1.changed(r8) == false) goto L21;
        int r23 = 32;
    L22:
        r5 = r5 | r23;
        goto L25
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r5 = r33;
        goto L13
    L8:
        if (r1.changed(r29) == false) goto L10;
        int r24 = 4;
    L11:
        r5 = r24 | r33;
        goto L13
    L10:
        r24 = 2;
        goto L11
    }

    public static final void ContextMenuColumnBuilder(Modifier r7, final ContextMenuColors r8, final Function1<? super ContextMenuScope, Unit> r9, Composer r10, final int r11, final int r12) {
        Composer r13 = r10.startRestartGroup(-1430784946);
        int r1 = r12 & 1;
        if (r1 == 0) goto L6;
        int r2 = r11 | 6;
    L13:
        int r3 = r12 & 2;
        if (r3 == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r12 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L34:
        if ((r2 & 147) == 146) goto L36;
        boolean r4 = true;
    L38:
        if (r13.shouldExecute(r4, r2 & 1) == false) goto L49;
        if (r1 == 0) goto L41;
        r7 = Modifier.Companion;
    L41:
        if (r3 == 0) goto L44;
        r8 = DefaultContextMenuColors;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(-1430784946, r2, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumnBuilder (ContextMenuUi.android.kt:141)");
    L46:
        ComposableLambda r5 = ComposableLambdaKt.rememberComposableLambda(860259975, true, new AnonymousClass1(r9, r8), r13, 54);
        int r6 = (((r2 >> 3) & 14) | 384) | ((r2 << 3) & 112);
        ContextMenuColumn(r8, r7, r5, r13, r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L50;
        ComposerKt.traceEventEnd();
    L50:
        final Modifier r14 = r7;
        final ContextMenuColors r15 = r8;
        ScopeUpdateScope r16 = r13.endRestartGroup();
        if (r16 == null) goto L54;
        r16.updateScope(new j(r14, r15, r9, r11, r12));
        return;
    L54:
        return;
    L49:
        r13.skipToGroupEnd();
        goto L50
    L36:
        r4 = false;
        goto L38
    L27:
        if ((r11 & 384) != 0) goto L34;
        if (r13.changedInstance(r9) == false) goto L31;
        int r17 = 256;
    L32:
        r2 = r2 | r17;
        goto L34
    L31:
        r17 = 128;
        goto L32
    L17:
        if ((r11 & 48) != 0) goto L24;
        if (r13.changed(r8) == false) goto L21;
        int r18 = 32;
    L22:
        r2 = r2 | r18;
        goto L24
    L21:
        r18 = 16;
        goto L22
    L6:
        if ((r11 & 6) == 0) goto L8;
        r2 = r11;
        goto L13
    L8:
        if (r13.changed(r7) == false) goto L10;
        int r19 = 4;
    L11:
        r2 = r19 | r11;
        goto L13
    L10:
        r19 = 2;
        goto L11
    }

    public static final void ContextMenuPopup(final PopupPositionProvider r9, final Function0<Unit> r10, Modifier r11, final Function1<? super ContextMenuScope, Unit> r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(712057293);
        if ((r15 & 1) == 0) goto L6;
        int r1 = r14 | 6;
    L14:
        if ((r15 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r15 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r15 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r1 & 1171) == 1170) goto L46;
        boolean r3 = true;
    L48:
        if (r16.shouldExecute(r3, r1 & 1) == false) goto L57;
        if (r2 == 0) goto L52;
        r11 = Modifier.Companion;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(712057293, r1, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:108)");
    L54:
        int r7 = (((r1 & 14) | (r1 & 112)) | (r1 & 896)) | ((r1 << 3) & 57344);
        Modifier r4 = r11;
        ContextMenuPopup(r9, r10, r4, computeContextMenuColors(0, 0, r16, 0, 3), r12, r16, r7, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L58;
        ComposerKt.traceEventEnd();
    L58:
        final Modifier r5 = r11;
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L62;
        r17.updateScope(new i(r9, r10, r5, r12, r14, r15));
        return;
    L62:
        return;
    L57:
        r16.skipToGroupEnd();
        goto L58
    L46:
        r3 = false;
        goto L48
    L37:
        if ((r14 & 3072) != 0) goto L44;
        if (r16.changedInstance(r12) == false) goto L41;
        int r6 = 2048;
    L42:
        r1 = r1 | r6;
        goto L44
    L41:
        r6 = 1024;
        goto L42
    L27:
        if ((r14 & 384) != 0) goto L34;
        if (r16.changed(r11) == false) goto L31;
        int r8 = 256;
    L32:
        r1 = r1 | r8;
        goto L34
    L31:
        r8 = 128;
        goto L32
    L17:
        if ((r14 & 48) != 0) goto L23;
        if (r16.changedInstance(r10) == false) goto L21;
        int r18 = 32;
    L22:
        r1 = r1 | r18;
        goto L23
    L21:
        r18 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r1 = r14;
        goto L14
    L8:
        if (r16.changed(r9) == false) goto L10;
        int r19 = 4;
    L11:
        r1 = r19 | r14;
        goto L14
    L10:
        r19 = 2;
        goto L11
    }

    public static final void ContextMenuPopup(final PopupPositionProvider r16, final Function0<Unit> r17, Modifier r18, final ContextMenuColors r19, final Function1<? super ContextMenuScope, Unit> r20, Composer r21, final int r22, final int r23) {
        Composer r1 = r21.startRestartGroup(1447189339);
        if ((r23 & 1) == 0) goto L6;
        int r3 = r22 | 6;
    L14:
        if ((r23 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L23:
        int r7 = r23 & 4;
        if (r7 == 0) goto L27;
        r3 = r3 | 384;
    L33:
        Modifier r8 = r18;
    L35:
        if ((r23 & 8) == 0) goto L38;
        r3 = r3 | 3072;
    L45:
        if ((r23 & 16) == 0) goto L48;
        r3 = r3 | 24576;
    L55:
        if ((r3 & 9363) == 9362) goto L57;
        boolean r9 = true;
    L59:
        if (r1.shouldExecute(r9, r3 & 1) == false) goto L70;
        if (r7 == 0) goto L62;
        final Modifier r15 = Modifier.Companion;
    L64:
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventStart(1447189339, r3, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:126)");
    L66:
        AndroidPopup_androidKt.Popup(r16, r17, DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(795909757, true, new AnonymousClass2(r15, r19, r20), r1, 54), r1, ((r3 & 14) | 3456) | (r3 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventEnd();
    L69:
        final Modifier r4 = r15;
    L71:
        ScopeUpdateScope r10 = r1.endRestartGroup();
        if (r10 == null) goto L75;
        r10.updateScope(new l(r16, r17, r4, r19, r20, r22, r23));
        return;
    L75:
        return;
    L62:
        r15 = r8;
        goto L64
    L70:
        r1.skipToGroupEnd();
        r4 = r8;
        goto L71
    L57:
        r9 = false;
        goto L59
    L48:
        if ((r22 & 24576) != 0) goto L55;
        if (r1.changedInstance(r20) == false) goto L52;
        int r11 = 16384;
    L53:
        r3 = r3 | r11;
        goto L55
    L52:
        r11 = 8192;
        goto L53
    L38:
        if ((r22 & 3072) != 0) goto L45;
        if (r1.changed(r19) == false) goto L42;
        int r12 = 2048;
    L43:
        r3 = r3 | r12;
        goto L45
    L42:
        r12 = 1024;
        goto L43
    L27:
        if ((r22 & 384) != 0) goto L33;
        r8 = r18;
        if (r1.changed(r8) == false) goto L31;
        int r13 = 256;
    L32:
        r3 = r3 | r13;
        goto L35
    L31:
        r13 = 128;
        goto L32
    L17:
        if ((r22 & 48) != 0) goto L23;
        if (r1.changedInstance(r17) == false) goto L21;
        int r14 = 32;
    L22:
        r3 = r3 | r14;
        goto L23
    L21:
        r14 = 16;
        goto L22
    L6:
        if ((r22 & 6) == 0) goto L8;
        r3 = r22;
        goto L14
    L8:
        if (r1.changed(r16) == false) goto L10;
        int r5 = 4;
    L11:
        r3 = r5 | r22;
        goto L14
    L10:
        r5 = 2;
        goto L11
    }

    public static final void ContextMenuItem(final String r32, final boolean r33, final ContextMenuColors r34, Modifier r35, Function3<? super Color, ? super Composer, ? super Integer, Unit> r36, final Function0<Unit> r37, Composer r38, final int r39, final int r40) {
        Composer r15 = r38.startRestartGroup(-1027365588);
        if ((r40 & 1) == 0) goto L6;
        int r1 = r39 | 6;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r40 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r40 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        int r4 = r40 & 16;
        if (r4 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        final Function3<? super Color, ? super Composer, ? super Integer, Unit> r5 = r36;
    L56:
        if ((r40 & 32) == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        int r6 = r1;
        if ((74899 & r6) == 74898) goto L68;
        boolean r3 = true;
    L70:
        if (r15.shouldExecute(r3, r6 & 1) == false) goto L133;
        if (r2 == 0) goto L73;
        Modifier r24 = Modifier.Companion;
    L75:
        if (r4 == 0) goto L78;
        r5 = null;
    L78:
        if (ComposerKt.isTraceInProgress() == false) goto L80;
        ComposerKt.traceEventStart(-1027365588, r6, -1, "androidx.compose.foundation.contextmenu.ContextMenuItem (ContextMenuUi.android.kt:196)");
    L80:
        ContextMenuSpec r7 = ContextMenuSpec.INSTANCE;
        Alignment.Vertical r8 = r7.getLabelVerticalTextAlignment();
        Arrangement.HorizontalOrVertical r9 = Arrangement.INSTANCE.m806spacedBy0680j_4(r7.m480getHorizontalPaddingD9Ej5fM());
        if ((r6 & 112) != 32) goto L83;
        boolean r0 = true;
    L85:
        if ((r6 & 458752) != 131072) goto L87;
        boolean r10 = true;
    L88:
        boolean r11 = r0 | r10;
        Object r12 = r15.rememberedValue();
        if (r11 == false) goto L91;
    L92:
        r12 = new m(r33, r37);
        r15.updateRememberedValue(r12);
    L93:
        Function3<? super Color, ? super Composer, ? super Integer, Unit> r14 = r5;
        Modifier r13 = PaddingKt.m962paddingVpY3zN4$default(SizeKt.m1017sizeInqDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.m379clickableoSLSa3U$default(r24, r33, r32, null, null, (Function0) r12, 12, null), MenuKt.ClosedAlphaTarget, 1, null), r7.m475getContainerWidthMinD9Ej5fM(), r7.m485getListItemHeightD9Ej5fM(), r7.m474getContainerWidthMaxD9Ej5fM(), r7.m485getListItemHeightD9Ej5fM()), r7.m480getHorizontalPaddingD9Ej5fM(), MenuKt.ClosedAlphaTarget, 2, null);
        MeasurePolicy r16 = RowKt.rowMeasurePolicy(r9, r8, r15, 54);
        long r17 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r18 = (int) (r17 ^ (r17 >>> 32));
        CompositionLocalMap r19 = r15.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r15, r13);
        ComposeUiNode.Companion r21 = ComposeUiNode.Companion;
        Function0 r22 = r21.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L96;
        ComposablesKt.invalidApplier();
    L96:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L99;
        r15.createNode(r22);
    L100:
        Composer r23 = Updater.constructor-impl(r15);
        Updater.set-impl(r23, r16, r21.getSetMeasurePolicy());
        Updater.set-impl(r23, r19, r21.getSetResolvedCompositionLocals());
        Function2 r25 = r21.getSetCompositeKeyHash();
        if (r23.getInserting() == false) goto L103;
    L104:
        r23.updateRememberedValue(Integer.valueOf(r18));
        r23.apply(Integer.valueOf(r18), r25);
    L105:
        Updater.set-impl(r23, r20, r21.getSetModifier());
        RowScopeInstance r26 = RowScopeInstance.INSTANCE;
        if (r14 != null) goto L109;
        r15.startReplaceGroup(-1483499797);
    L108:
        r15.endReplaceGroup();
        if (r33 == false) goto L128;
        long r27 = r34.m472getTextColor0d7_KjU();
    L129:
        r5 = r14;
        Composer r28 = r15;
        BasicTextKt.m1356BasicTextRWo7tUw(r32, r26.weight(Modifier.Companion, 1.0f, true), r7.m488textStyle8_81llA(r27), null, 0, false, 1, 0, null, null, r28, (r6 & 14) | 1572864, 952);
        r28.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventEnd();
    L132:
        final Modifier r29 = r24;
    L134:
        ScopeUpdateScope r110 = r28.endRestartGroup();
        if (r110 == null) goto L138;
        r110.updateScope(new n(r32, r33, r34, r29, r5, r37, r39, r40));
        return;
    L138:
        return;
    L128:
        r27 = r34.m470getDisabledTextColor0d7_KjU();
        goto L129
    L109:
        r15.startReplaceGroup(-1483499796);
        Modifier r30 = SizeKt.m1010requiredSizeInqDBjuR0$default(Modifier.Companion, r7.m481getIconSizeD9Ej5fM(), MenuKt.ClosedAlphaTarget, r7.m481getIconSizeD9Ej5fM(), r7.m481getIconSizeD9Ej5fM(), 2, null);
        MeasurePolicy r31 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r111 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r41 = (int) (r111 ^ (r111 >>> 32));
        CompositionLocalMap r42 = r15.getCurrentCompositionLocalMap();
        Modifier r43 = ComposedModifierKt.materializeModifier(r15, r30);
        Function0 r112 = r21.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L112;
        ComposablesKt.invalidApplier();
    L112:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L115;
        r15.createNode(r112);
    L116:
        Composer r113 = Updater.constructor-impl(r15);
        Updater.set-impl(r113, r31, r21.getSetMeasurePolicy());
        Updater.set-impl(r113, r42, r21.getSetResolvedCompositionLocals());
        Function2 r44 = r21.getSetCompositeKeyHash();
        if (r113.getInserting() == false) goto L119;
    L120:
        r113.updateRememberedValue(Integer.valueOf(r41));
        r113.apply(Integer.valueOf(r41), r44);
    L121:
        Updater.set-impl(r113, r43, r21.getSetModifier());
        BoxScopeInstance r45 = BoxScopeInstance.INSTANCE;
        if (r33 == false) goto L124;
        long r46 = r34.m471getIconColor0d7_KjU();
    L125:
        r14.invoke(Color.box-impl(r46), r15, 0);
        r15.endNode();
        Unit r47 = Unit.INSTANCE;
        goto L108
    L124:
        r46 = r34.m469getDisabledIconColor0d7_KjU();
        goto L125
    L119:
        if (Intrinsics.areEqual(r113.rememberedValue(), Integer.valueOf(r41)) == true) goto L121;
    L115:
        r15.useNode();
        goto L116
    L103:
        if (Intrinsics.areEqual(r23.rememberedValue(), Integer.valueOf(r18)) == true) goto L105;
    L99:
        r15.useNode();
        goto L100
    L91:
        if (r12 != Composer.Companion.getEmpty()) goto L93;
    L87:
        r10 = false;
        goto L88
    L83:
        r0 = false;
        goto L85
    L73:
        r24 = r35;
        goto L75
    L133:
        r28 = r15;
        r28.skipToGroupEnd();
        r29 = r35;
        goto L134
    L68:
        r3 = false;
        goto L70
    L59:
        if ((r39 & 196608) != 0) goto L65;
        if (r15.changedInstance(r37) == false) goto L63;
        int r48 = 131072;
    L64:
        r1 = r1 | r48;
        goto L65
    L63:
        r48 = 65536;
        goto L64
    L48:
        if ((r39 & 24576) != 0) goto L54;
        r5 = r36;
        if (r15.changedInstance(r5) == false) goto L52;
        int r49 = 16384;
    L53:
        r1 = r1 | r49;
        goto L56
    L52:
        r49 = 8192;
        goto L53
    L37:
        if ((r39 & 3072) != 0) goto L44;
        if (r15.changed(r35) == false) goto L41;
        int r50 = 2048;
    L42:
        r1 = r1 | r50;
        goto L44
    L41:
        r50 = 1024;
        goto L42
    L27:
        if ((r39 & 384) != 0) goto L33;
        if (r15.changed(r34) == false) goto L31;
        int r51 = 256;
    L32:
        r1 = r1 | r51;
        goto L33
    L31:
        r51 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r15.changed(r33) == false) goto L21;
        int r52 = 32;
    L22:
        r1 = r1 | r52;
        goto L24
    L21:
        r52 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r1 = r39;
        goto L14
    L8:
        if (r15.changed(r32) == false) goto L10;
        int r53 = 4;
    L11:
        r1 = r53 | r39;
        goto L14
    L10:
        r53 = 2;
        goto L11
    }
}
