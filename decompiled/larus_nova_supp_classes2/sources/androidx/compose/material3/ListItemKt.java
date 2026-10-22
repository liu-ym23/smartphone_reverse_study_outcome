package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
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
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¦\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001at\u0010\u0012\u001a\u00020\u00012\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0004H\u0003¢\u0006\u0002\u0010\u0018\u001aK\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%\u001aS\u0010&\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0004\b/\u00100\u001an\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001072\b\u00109\u001a\u0004\u0018\u0001072\b\u0010:\u001a\u0004\u0018\u0001072\b\u0010;\u001a\u0004\u0018\u0001072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\u001aH\u0002\u001a2\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0011\u0010F\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0003¢\u0006\u0004\bG\u0010H\u001a\u0014\u0010^\u001a\u00020=*\u00020_2\u0006\u0010`\u001a\u00020\u001aH\u0002\u001a\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0002¢\u0006\u0004\ba\u0010b\"\u001e\u0010I\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u001e\u0010O\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u001e\u0010R\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bS\u0010K\u001a\u0004\bT\u0010M\"\u001e\u0010U\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bV\u0010K\u001a\u0004\bW\u0010M\"\u001e\u0010X\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bY\u0010K\u001a\u0004\bZ\u0010M\"\u001e\u0010[\u001a\u00020\u000e8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\b\\\u0010K\u001a\u0004\b]\u0010M¨\u0006c"}, d2 = {"ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItemLayout", "leading", "trailing", "headline", "overline", "supporting", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculateWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "leadingWidth", "trailingWidth", "headlineWidth", "overlineWidth", "supportingWidth", "horizontalPadding", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateWidth-yeHjK3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIJ)I", "calculateHeight", "leadingHeight", "trailingHeight", "headlineHeight", "overlineHeight", "supportingHeight", "listItemType", "Landroidx/compose/material3/ListItemType;", "verticalPadding", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIIJ)I", "place", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "width", "height", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "isThreeLine", "", "startPadding", "endPadding", "topPadding", "ProvideTextStyleFromToken", "color", "Landroidx/compose/ui/graphics/Color;", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "content", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ListItemVerticalPadding", "getListItemVerticalPadding$annotations", "()V", "getListItemVerticalPadding", "()F", "F", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "getListItemThreeLineVerticalPadding", "ListItemStartPadding", "getListItemStartPadding$annotations", "getListItemStartPadding", "ListItemEndPadding", "getListItemEndPadding$annotations", "getListItemEndPadding", "LeadingContentEndPadding", "getLeadingContentEndPadding$annotations", "getLeadingContentEndPadding", "TrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "getTrailingContentStartPadding", "isSupportingMultilineHeuristic", "Landroidx/compose/ui/unit/Density;", "estimatedSupportingHeight", "verticalPadding-yh95HIg", "(I)F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListItemKt {
    private static final float LeadingContentEndPadding = 0.0f;
    private static final float ListItemEndPadding = 0.0f;
    private static final float ListItemStartPadding = 0.0f;
    private static final float ListItemThreeLineVerticalPadding = 0.0f;
    private static final float ListItemVerticalPadding = 0.0f;
    private static final float TrailingContentStartPadding = 0.0f;

    private static final Unit ListItemLayout$lambda$8(Function2 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, int r12, Composer r13, int r14) {
        ListItemLayout(r7, r8, r9, r10, r11, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ListItem_HXNGIdc$lambda$6(Function2 r13, Modifier r14, Function2 r15, Function2 r16, Function2 r17, Function2 r18, ListItemColors r19, float r20, float r21, int r22, int r23, Composer r24, int r25) {
        m2828ListItemHXNGIdc(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit ProvideTextStyleFromToken_3J_VO9M$lambda$12(long r6, TypographyKeyTokens r8, Function2 r9, int r10, Composer r11, int r12) {
        m2829ProvideTextStyleFromToken3JVO9M(r6, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, Modifier r1, Function2 r2, Function2 r3, Function2 r4, Function2 r5, ListItemColors r6, float r7, float r8, int r9, int r10, Composer r11, int r12) {
        return ListItem_HXNGIdc$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit b(SemanticsPropertyReceiver r0) {
        return ListItem_HXNGIdc$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Unit c(Function2 r0, Function2 r1, Function2 r2, Function2 r3, Function2 r4, int r5, Composer r6, int r7) {
        return ListItemLayout$lambda$8(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit d(long r0, TypographyKeyTokens r2, Function2 r3, int r4, Composer r5, int r6) {
        return ProvideTextStyleFromToken_3J_VO9M$lambda$12(r0, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit e(Placeable r0, int r1, boolean r2, int r3, Placeable r4, Placeable r5, Placeable r6, int r7, Placeable r8, int r9, int r10, Placeable.PlacementScope r11) {
        return place$lambda$11(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void getLeadingContentEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemStartPadding$annotations() {
    }

    public static /* synthetic */ void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getListItemVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getTrailingContentStartPadding$annotations() {
    }

    static {
        ListItemVerticalPadding = Dp.constructor-impl(8);
        ListItemThreeLineVerticalPadding = Dp.constructor-impl(12);
        float r0 = 16;
        ListItemStartPadding = Dp.constructor-impl(r0);
        ListItemEndPadding = Dp.constructor-impl(r0);
        LeadingContentEndPadding = Dp.constructor-impl(r0);
        TrailingContentStartPadding = Dp.constructor-impl(r0);
    }

    public static final float getLeadingContentEndPadding() {
        return LeadingContentEndPadding;
    }

    public static final float getListItemEndPadding() {
        return ListItemEndPadding;
    }

    public static final float getListItemStartPadding() {
        return ListItemStartPadding;
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemThreeLineVerticalPadding;
    }

    public static final float getListItemVerticalPadding() {
        return ListItemVerticalPadding;
    }

    public static final float getTrailingContentStartPadding() {
        return TrailingContentStartPadding;
    }

    private static final Unit ListItem_HXNGIdc$lambda$5$lambda$4(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$verticalPadding-yh95HIg, reason: not valid java name */
    public static final /* synthetic */ float m2833access$verticalPaddingyh95HIg(int r0) {
        return m2836verticalPaddingyh95HIg(r0);
    }

    /* JADX INFO: renamed from: verticalPadding-yh95HIg, reason: not valid java name */
    private static final float m2836verticalPaddingyh95HIg(int r1) {
        if (ListItemType.m2842equalsimpl0(r1, ListItemType.Companion.m2848getThreeLineAlXitO8()) == false) goto L6;
        return ListItemThreeLineVerticalPadding;
    L6:
        return ListItemVerticalPadding;
    }

    public static final /* synthetic */ boolean access$isSupportingMultilineHeuristic(Density r0, int r1) {
        return isSupportingMultilineHeuristic(r0, r1);
    }

    private static final boolean isSupportingMultilineHeuristic(Density r2, int r3) {
        if (r3 <= r2.roundToPx--R2X_6o(TextUnitKt.getSp(30))) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: ProvideTextStyleFromToken-3J-VO9M, reason: not valid java name */
    private static final void m2829ProvideTextStyleFromToken3JVO9M(final long r7, final TypographyKeyTokens r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-285397024);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changed(r9.ordinal()) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r12 & 384) != 0) goto L25;
        if (r13.changedInstance(r10) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r13.shouldExecute(r4, r1 & 1) == true) goto L31;
        r13.skipToGroupEnd();
    L37:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L41;
        r14.updateScope(new jd(r7, r9, r10, r12));
        return;
    L41:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-285397024, r1, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:703)");
    L33:
        ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(r7, TypographyKt.getValue(r9, r13, (r1 >> 3) & 14), r10, r13, (r1 & 14) | (r1 & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
        goto L37
    L27:
        r4 = false;
        goto L29
    L5:
        if (r13.changed(r7) == false) goto L7;
        int r5 = 4;
    L8:
        r1 = r5 | r12;
        goto L11
    L7:
        r5 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$ProvideTextStyleFromToken-3J-VO9M, reason: not valid java name */
    public static final /* synthetic */ void m2830access$ProvideTextStyleFromToken3JVO9M(long r0, TypographyKeyTokens r2, Function2 r3, Composer r4, int r5) {
        m2829ProvideTextStyleFromToken3JVO9M(r0, r2, r3, r4, r5);
    }

    private static final void ListItemLayout(final Function2<? super Composer, ? super Integer, Unit> r9, final Function2<? super Composer, ? super Integer, Unit> r10, final Function2<? super Composer, ? super Integer, Unit> r11, final Function2<? super Composer, ? super Integer, Unit> r12, final Function2<? super Composer, ? super Integer, Unit> r13, Composer r14, final int r15) {
        Composer r16 = r14.startRestartGroup(-61277522);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L11:
        if ((r15 & 48) != 0) goto L18;
        if (r16.changedInstance(r10) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r15 & 384) != 0) goto L25;
        if (r16.changedInstance(r11) == false) goto L22;
        int r5 = 256;
    L23:
        r1 = r1 | r5;
        goto L25
    L22:
        r5 = 128;
    L25:
        if ((r15 & 3072) != 0) goto L32;
        if (r16.changedInstance(r12) == false) goto L29;
        int r6 = 2048;
    L30:
        r1 = r1 | r6;
        goto L32
    L29:
        r6 = 1024;
    L32:
        if ((r15 & 24576) != 0) goto L39;
        if (r16.changedInstance(r13) == false) goto L36;
        int r7 = 16384;
    L37:
        r1 = r1 | r7;
        goto L39
    L36:
        r7 = 8192;
    L39:
        if ((r1 & 9363) == 9362) goto L41;
        boolean r8 = true;
    L43:
        if (r16.shouldExecute(r8, r1 & 1) == true) goto L45;
        r16.skipToGroupEnd();
    L85:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L89;
        r17.updateScope(new kd(r9, r10, r11, r12, r13, r15));
        return;
    L89:
        return;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(-61277522, r1, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:181)");
    L47:
        Object r0 = r16.rememberedValue();
        Composer.Companion r2 = Composer.Companion;
        if (r0 != r2.getEmpty()) goto L50;
        r0 = new ListItemMeasurePolicy();
        r16.updateRememberedValue(r0);
    L50:
        ListItemMeasurePolicy r3 = (ListItemMeasurePolicy) r0;
        Function2[] r18 = new Function2[5];
        r18[0] = r11;
        if (r12 != null) goto L53;
        Function2<? super Composer, ? super Integer, Unit> r19 = ComposableSingletons$ListItemKt.INSTANCE.m2531getLambda$489887388$material3();
    L54:
        r18[1] = r19;
        if (r13 != null) goto L57;
        Function2<? super Composer, ? super Integer, Unit> r20 = ComposableSingletons$ListItemKt.INSTANCE.getLambda$1629163587$material3();
    L58:
        r18[2] = r20;
        if (r9 != null) goto L61;
        Function2<? super Composer, ? super Integer, Unit> r21 = ComposableSingletons$ListItemKt.INSTANCE.m2532getLambda$546752734$material3();
    L62:
        r18[3] = r21;
        if (r10 != null) goto L65;
        Function2<? super Composer, ? super Integer, Unit> r22 = ComposableSingletons$ListItemKt.INSTANCE.getLambda$1572298241$material3();
    L66:
        r18[4] = r22;
        List r23 = CollectionsKt.listOf(r18);
        Modifier.Companion r24 = Modifier.Companion;
        Function2 r25 = LayoutKt.combineAsVirtualLayouts(r23);
        Object r26 = r16.rememberedValue();
        if (r26 != r2.getEmpty()) goto L69;
        r26 = MultiContentMeasurePolicyKt.createMeasurePolicy(r3);
        r16.updateRememberedValue(r26);
    L69:
        MeasurePolicy r27 = (MeasurePolicy) r26;
        int r28 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r29 = r16.getCurrentCompositionLocalMap();
        Modifier r30 = ComposedModifierKt.materializeModifier(r16, r24);
        ComposeUiNode.Companion r31 = ComposeUiNode.Companion;
        Function0 r32 = r31.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L72;
        ComposablesKt.invalidApplier();
    L72:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L75;
        r16.createNode(r32);
    L76:
        Composer r33 = Updater.constructor-impl(r16);
        Updater.set-impl(r33, r27, r31.getSetMeasurePolicy());
        Updater.set-impl(r33, r29, r31.getSetResolvedCompositionLocals());
        Function2 r34 = r31.getSetCompositeKeyHash();
        if (r33.getInserting() == false) goto L79;
    L80:
        r33.updateRememberedValue(Integer.valueOf(r28));
        r33.apply(Integer.valueOf(r28), r34);
    L81:
        Updater.set-impl(r33, r30, r31.getSetModifier());
        r25.invoke(r16, 0);
        r16.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventEnd();
        goto L85
    L79:
        if (Intrinsics.areEqual(r33.rememberedValue(), Integer.valueOf(r28)) == true) goto L81;
    L75:
        r16.useNode();
        goto L76
    L65:
        r22 = r10;
        goto L66
    L61:
        r21 = r9;
        goto L62
    L57:
        r20 = r13;
        goto L58
    L53:
        r19 = r12;
        goto L54
    L41:
        r8 = false;
        goto L43
    L5:
        if (r16.changedInstance(r9) == false) goto L7;
        int r35 = 4;
    L8:
        r1 = r35 | r15;
        goto L11
    L7:
        r35 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$ListItemLayout(Function2 r0, Function2 r1, Function2 r2, Function2 r3, Function2 r4, Composer r5, int r6) {
        ListItemLayout(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: access$calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final /* synthetic */ int m2832access$calculateWidthyeHjK3Y(IntrinsicMeasureScope r0, int r1, int r2, int r3, int r4, int r5, int r6, long r7) {
        return m2835calculateWidthyeHjK3Y(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    private static final int m2835calculateWidthyeHjK3Y(IntrinsicMeasureScope r0, int r1, int r2, int r3, int r4, int r5, int r6, long r7) {
        if (Constraints.getHasBoundedWidth-impl(r7) == true) goto L5;
        int r8 = r6 + r1;
        return (r8 + Math.max(r3, Math.max(r4, r5))) + r2;
    L5:
        return Constraints.getMaxWidth-impl(r7);
    }

    /* JADX INFO: renamed from: access$calculateHeight-N4Jib3Y, reason: not valid java name */
    public static final /* synthetic */ int m2831access$calculateHeightN4Jib3Y(IntrinsicMeasureScope r0, int r1, int r2, int r3, int r4, int r5, int r6, int r7, long r8) {
        return m2834calculateHeightN4Jib3Y(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: calculateHeight-N4Jib3Y, reason: not valid java name */
    private static final int m2834calculateHeightN4Jib3Y(IntrinsicMeasureScope r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, long r10) {
        ListItemType.Companion r0 = ListItemType.Companion;
        if (ListItemType.m2842equalsimpl0(r8, r0.m2847getOneLineAlXitO8()) == false) goto L6;
        float r11 = ListTokens.INSTANCE.getListItemOneLineContainerHeight-D9Ej5fM();
    L10:
        return RangesKt.coerceAtMost(Math.max(Math.max(Constraints.getMinHeight-impl(r10), r2.roundToPx-0680j_4(r11)), r9 + Math.max(r3, Math.max((r5 + r6) + r7, r4))), Constraints.getMaxHeight-impl(r10));
    L6:
        if (ListItemType.m2842equalsimpl0(r8, r0.m2849getTwoLineAlXitO8()) == false) goto L8;
        r11 = ListTokens.INSTANCE.getListItemTwoLineContainerHeight-D9Ej5fM();
        goto L10
    L8:
        r11 = ListTokens.INSTANCE.getListItemThreeLineContainerHeight-D9Ej5fM();
        goto L10
    }

    /* JADX INFO: renamed from: ListItem-HXNGIdc, reason: not valid java name */
    public static final void m2828ListItemHXNGIdc(final Function2<? super Composer, ? super Integer, Unit> r28, Modifier r29, Function2<? super Composer, ? super Integer, Unit> r30, Function2<? super Composer, ? super Integer, Unit> r31, Function2<? super Composer, ? super Integer, Unit> r32, Function2<? super Composer, ? super Integer, Unit> r33, ListItemColors r34, float r35, float r36, Composer r37, final int r38, final int r39) {
        Composer r2 = r37.startRestartGroup(487133126);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L13:
        int r4 = r39 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r39 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r8 = r39 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        int r12 = r39 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L57:
        int r14 = r39 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Function2<? super Composer, ? super Integer, Unit> r15 = r33;
    L69:
        if ((r38 & 1572864) != 0) goto L78;
        if ((r39 & 64) == 0) goto L73;
    L75:
        int r17 = 524288;
    L76:
        r3 = r3 | r17;
        goto L78
    L73:
        if (r2.changed(r34) == false) goto L75;
        r17 = 1048576;
    L78:
        int r0 = r39 & 128;
        if (r0 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        int r5 = r39 & 256;
        if (r5 == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((r3 & 38347923) == 38347922) goto L101;
        boolean r7 = true;
    L103:
        if (r2.shouldExecute(r7, r3 & 1) == false) goto L161;
        r2.startDefaults();
        Function2 r18 = null;
        if ((r38 & 1) != 0) goto L107;
    L113:
        if (r4 == 0) goto L115;
        Modifier r9 = Modifier.Companion;
    L116:
        if (r6 == 0) goto L118;
        final Function2<? super Composer, ? super Integer, Unit> r10 = null;
    L119:
        if (r8 == 0) goto L121;
        final Function2<? super Composer, ? super Integer, Unit> r11 = null;
    L122:
        if (r12 == 0) goto L124;
        final Function2<? super Composer, ? super Integer, Unit> r25 = null;
    L125:
        if (r14 == 0) goto L128;
        r15 = null;
    L128:
        if ((r39 & 64) == 0) goto L130;
        ListItemColors r13 = ListItemDefaults.INSTANCE.colors(r2, 6);
        r3 = r3 & (-3670017);
    L131:
        if (r0 == 0) goto L133;
        float r1 = ListItemDefaults.INSTANCE.m2827getElevationD9Ej5fM();
    L134:
        if (r5 == 0) goto L136;
        final float r16 = ListItemDefaults.INSTANCE.m2827getElevationD9Ej5fM();
    L137:
        float r19 = r1;
        final Function2<? super Composer, ? super Integer, Unit> r20 = r15;
        ListItemColors r27 = r13;
        int r110 = r3;
        final ListItemColors r21 = r27;
    L138:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L141;
        ComposerKt.traceEventStart(487133126, r110, -1, "androidx.compose.material3.ListItem (ListItem.kt:104)");
    L141:
        final ComposableLambda r111 = ComposableLambdaKt.rememberComposableLambda(629852750, true, new ListItemKt$ListItem$decoratedHeadlineContent$1(r21, r28), r2, 54);
        if (r11 != null) goto L144;
        r2.startReplaceGroup(-510713870);
        r2.endReplaceGroup();
        ComposableLambda r22 = null;
    L145:
        if (r10 != null) goto L147;
        r2.startReplaceGroup(-510395686);
        r2.endReplaceGroup();
        ComposableLambda r23 = null;
    L148:
        if (r25 != null) goto L150;
        r2.startReplaceGroup(-510083888);
        r2.endReplaceGroup();
        ComposableLambda r24 = null;
    L151:
        if (r20 != null) goto L153;
        r2.startReplaceGroup(-509666659);
        r2.endReplaceGroup();
    L154:
        Modifier.Companion r26 = Modifier.Companion;
        Object r40 = r2.rememberedValue();
        if (r40 != Composer.Companion.getEmpty()) goto L157;
        r40 = new md();
        r2.updateRememberedValue(r40);
    L157:
        final ComposableLambda r310 = r24;
        final Function2 r311 = r18;
        final ComposableLambda r312 = r23;
        final ComposableLambda r313 = r22;
        int r41 = r110 >> 9;
        SurfaceKt.m3213SurfaceT9BRK9s(SemanticsModifierKt.semantics(r26, true, (Function1) r40).then(r9), ListItemDefaults.INSTANCE.getShape(r2, 6), r21.m2810containerColor0d7_KjU$material3(), r21.m2821headlineColorvNxB06k$material3(true), r19, r16, null, ComposableLambdaKt.rememberComposableLambda(1192488737, true, new ListItemKt$ListItem$2(r310, r311, r111, r312, r313), r2, 54), r2, ((57344 & r41) | 12582912) | (r41 & 458752), 64);
        if (ComposerKt.isTraceInProgress() == false) goto L160;
        ComposerKt.traceEventEnd();
    L160:
        final ListItemColors r42 = r21;
        final float r43 = r19;
        final Function2<? super Composer, ? super Integer, Unit> r44 = r20;
        Function2<? super Composer, ? super Integer, Unit> r45 = r11;
        final Function2<? super Composer, ? super Integer, Unit> r46 = r10;
    L162:
        ScopeUpdateScope r112 = r2.endRestartGroup();
        if (r112 == null) goto L166;
        final Modifier r47 = r9;
        final Function2<? super Composer, ? super Integer, Unit> r48 = r45;
        final Function2<? super Composer, ? super Integer, Unit> r49 = r25;
        r112.updateScope(new nd(r28, r47, r46, r48, r49, r44, r42, r43, r16, r38, r39));
        return;
    L166:
        return;
    L153:
        r2.startReplaceGroup(-509666658);
        r18 = ComposableLambdaKt.rememberComposableLambda(1946411067, true, new ListItemKt$ListItem$decoratedTrailingContent$1$1(r21, r20), r2, 54);
        r2.endReplaceGroup();
        goto L154
    L150:
        r2.startReplaceGroup(-510083887);
        r24 = ComposableLambdaKt.rememberComposableLambda(449548451, true, new ListItemKt$ListItem$decoratedLeadingContent$1$1(r21, r25), r2, 54);
        r2.endReplaceGroup();
        goto L151
    L147:
        r2.startReplaceGroup(-510395685);
        r23 = ComposableLambdaKt.rememberComposableLambda(372414991, true, new ListItemKt$ListItem$decoratedOverlineContent$1$1(r21, r10), r2, 54);
        r2.endReplaceGroup();
        goto L148
    L144:
        r2.startReplaceGroup(-510713869);
        r22 = ComposableLambdaKt.rememberComposableLambda(-1291211644, true, new ListItemKt$ListItem$decoratedSupportingContent$1$1(r21, r11), r2, 54);
        r2.endReplaceGroup();
        goto L145
    L136:
        r16 = r36;
        goto L137
    L133:
        r1 = r35;
        goto L134
    L130:
        r13 = r34;
        goto L131
    L124:
        r25 = r32;
        goto L125
    L121:
        r11 = r31;
        goto L122
    L118:
        r10 = r30;
        goto L119
    L115:
        r9 = r29;
        goto L116
    L107:
        if (r2.getDefaultsInvalid() == true) goto L113;
        r2.skipToGroupEnd();
        if ((r39 & 64) == 0) goto L112;
        r3 = r3 & (-3670017);
    L112:
        r9 = r29;
        r10 = r30;
        r11 = r31;
        r25 = r32;
        r19 = r35;
        r16 = r36;
        r110 = r3;
        r20 = r15;
        r21 = r34;
        goto L138
    L161:
        r2.skipToGroupEnd();
        r9 = r29;
        r46 = r30;
        r45 = r31;
        r25 = r32;
        r42 = r34;
        r43 = r35;
        r16 = r36;
        r44 = r15;
        goto L162
    L101:
        r7 = false;
        goto L103
    L92:
        if ((r38 & 100663296) != 0) goto L99;
        if (r2.changed(r36) == false) goto L96;
        int r113 = 67108864;
    L97:
        r3 = r3 | r113;
        goto L99
    L96:
        r113 = 33554432;
        goto L97
    L82:
        if ((r38 & 12582912) != 0) goto L88;
        if (r2.changed(r35) == false) goto L86;
        int r114 = 8388608;
    L87:
        r3 = r3 | r114;
        goto L88
    L86:
        r114 = 4194304;
        goto L87
    L61:
        if ((196608 & r38) != 0) goto L67;
        r15 = r33;
        if (r2.changedInstance(r15) == false) goto L65;
        int r115 = 131072;
    L66:
        r3 = r3 | r115;
        goto L69
    L65:
        r115 = 65536;
        goto L66
    L50:
        if ((r38 & 24576) != 0) goto L57;
        if (r2.changedInstance(r32) == false) goto L54;
        int r116 = 16384;
    L55:
        r3 = r3 | r116;
        goto L57
    L54:
        r116 = 8192;
        goto L55
    L39:
        if ((r38 & 3072) != 0) goto L46;
        if (r2.changedInstance(r31) == false) goto L43;
        int r117 = 2048;
    L44:
        r3 = r3 | r117;
        goto L46
    L43:
        r117 = 1024;
        goto L44
    L28:
        if ((r38 & 384) != 0) goto L35;
        if (r2.changedInstance(r30) == false) goto L32;
        int r50 = 256;
    L33:
        r3 = r3 | r50;
        goto L35
    L32:
        r50 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L24;
        if (r2.changed(r29) == false) goto L21;
        int r51 = 32;
    L22:
        r3 = r3 | r51;
        goto L24
    L21:
        r51 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L13
    L8:
        if (r2.changedInstance(r28) == false) goto L10;
        int r52 = 4;
    L11:
        r3 = r52 | r38;
        goto L13
    L10:
        r52 = 2;
        goto L11
    }

    public static final /* synthetic */ MeasureResult access$place(MeasureScope r0, int r1, int r2, Placeable r3, Placeable r4, Placeable r5, Placeable r6, Placeable r7, boolean r8, int r9, int r10, int r11) {
        return place(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    private static final MeasureResult place(MeasureScope r14, final int r15, final int r16, final Placeable r17, final Placeable r18, final Placeable r19, final Placeable r20, final Placeable r21, final boolean r22, final int r23, final int r24, final int r25) {
        return MeasureScope.-CC.layout$default(r14, r15, r16, null, new ld(r17, r23, r22, r25, r19, r20, r21, r16, r18, r15, r24), 4, null);
    }

    private static final Unit place$lambda$11(Placeable r10, int r11, boolean r12, int r13, Placeable r14, Placeable r15, Placeable r16, int r17, Placeable r18, int r19, int r20, Placeable.PlacementScope r21) {
        if (r10 == null) goto L8;
        if (r12 == false) goto L6;
        int r4 = r13;
    L7:
        Placeable.PlacementScope.placeRelative$default(r21, r10, r11, r4, MenuKt.ClosedAlphaTarget, 4, null);
        goto L8
    L6:
        r4 = Alignment.Companion.getCenterVertically().align(r10.getHeight(), r17);
    L8:
        int r1 = LayoutUtilKt.getWidthOrZero(r10) + r11;
        if (r12 == false) goto L11;
        int r9 = r13;
    L12:
        if (r15 == null) goto L14;
        Placeable.PlacementScope.placeRelative$default(r21, r15, r1, r9, MenuKt.ClosedAlphaTarget, 4, null);
    L14:
        int r22 = r9 + LayoutUtilKt.getHeightOrZero(r15);
        if (r14 == null) goto L17;
        Placeable.PlacementScope.placeRelative$default(r21, r14, r1, r22, MenuKt.ClosedAlphaTarget, 4, null);
    L17:
        int r5 = r22 + LayoutUtilKt.getHeightOrZero(r14);
        if (r16 == null) goto L20;
        Placeable.PlacementScope.placeRelative$default(r21, r16, r1, r5, MenuKt.ClosedAlphaTarget, 4, null);
    L20:
        if (r18 == null) goto L27;
        int r2 = (r19 - r20) - r18.getWidth();
        if (r12 == false) goto L24;
        int r0 = r13;
    L25:
        Placeable.PlacementScope.placeRelative$default(r21, r18, r2, r0, MenuKt.ClosedAlphaTarget, 4, null);
        goto L27
    L24:
        r0 = Alignment.Companion.getCenterVertically().align(r18.getHeight(), r17);
    L27:
        return Unit.INSTANCE;
    L11:
        int r3 = (LayoutUtilKt.getHeightOrZero(r14) + LayoutUtilKt.getHeightOrZero(r15)) + LayoutUtilKt.getHeightOrZero(r16);
        r9 = Alignment.Companion.getCenterVertically().align(r3, r17);
        goto L12
    }
}
