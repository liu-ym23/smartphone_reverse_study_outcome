package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a}\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u009b\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u009b\u0001\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u001e\u0010\u001c\u001ak\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b \u0010!\u001a\u008b\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b#\u0010$\u001a{\u0010%\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072,\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b+\u0010!\u001a\u009d\u0001\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0004\b-\u0010.\u001a\u0091\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b/\u00100\u001a\u0091\u0001\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b1\u00100\u001a\u008d\u0001\u00102\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072.\b\u0002\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b3\u0010\u0012\u001a\u0097\u0001\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00192.\b\u0002\u0010\t\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b5\u00106¨\u00067"}, d2 = {"PrimaryTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "PrimaryScrollableTabRow", "scrollState", "Landroidx/compose/foundation/ScrollState;", "edgePadding", "Landroidx/compose/ui/unit/Dp;", "minTabWidth", "PrimaryScrollableTabRow-cx2KkNY", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-cx2KkNY", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-xam5sdo", "(ILandroidx/compose/ui/Modifier;JJFFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "tabPositions", "TabRowWithSubcomposeImpl-DTcfvLk", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow-qhFBPw4", "TabRow", "TabRow-pAZo6Ak", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt {
    private static final Unit PrimaryScrollableTabRow_cx2KkNY$lambda$2(int r16, Modifier r17, ScrollState r18, long r19, long r21, float r23, Function3 r24, Function2 r25, float r26, Function2 r27, int r28, int r29, Composer r30, int r31) {
        m3261PrimaryScrollableTabRowcx2KkNY(r16, r17, r18, r19, r21, r23, r24, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit PrimaryScrollableTabRow_qhFBPw4$lambda$8(int r15, Modifier r16, ScrollState r17, long r18, long r20, float r22, Function3 r23, Function2 r24, Function2 r25, int r26, int r27, Composer r28, int r29) {
        m3262PrimaryScrollableTabRowqhFBPw4(r15, r16, r17, r18, r20, r22, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    private static final Unit PrimaryTabRow_pAZo6Ak$lambda$0(int r13, Modifier r14, long r15, long r17, Function3 r19, Function2 r20, Function2 r21, int r22, int r23, Composer r24, int r25) {
        m3263PrimaryTabRowpAZo6Ak(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit ScrollableTabRowImpl_xam5sdo$lambda$5(int r15, Modifier r16, long r17, long r19, float r21, float r22, ScrollState r23, Function3 r24, Function2 r25, Function2 r26, int r27, Composer r28, int r29) {
        m3265ScrollableTabRowImplxam5sdo(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r28, RecomposeScopeImplKt.updateChangedFlags(r27 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$7(int r15, Function3 r16, Modifier r17, long r18, long r20, float r22, Function2 r23, Function2 r24, ScrollState r25, int r26, int r27, Composer r28, int r29) {
        m3266ScrollableTabRowWithSubcomposeImplqhFBPw4(r15, r16, r17, r18, r20, r22, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    private static final Unit ScrollableTabRow_sKfQg0A$lambda$11(int r14, Modifier r15, long r16, long r18, float r20, Function3 r21, Function2 r22, Function2 r23, int r24, int r25, Composer r26, int r27) {
        m3264ScrollableTabRowsKfQg0A(r14, r15, r16, r18, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit SecondaryScrollableTabRow_cx2KkNY$lambda$3(int r16, Modifier r17, ScrollState r18, long r19, long r21, float r23, Function3 r24, Function2 r25, float r26, Function2 r27, int r28, int r29, Composer r30, int r31) {
        m3267SecondaryScrollableTabRowcx2KkNY(r16, r17, r18, r19, r21, r23, r24, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit SecondaryScrollableTabRow_qhFBPw4$lambda$9(int r15, Modifier r16, ScrollState r17, long r18, long r20, float r22, Function3 r23, Function2 r24, Function2 r25, int r26, int r27, Composer r28, int r29) {
        m3268SecondaryScrollableTabRowqhFBPw4(r15, r16, r17, r18, r20, r22, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), r27);
        return Unit.INSTANCE;
    }

    private static final Unit SecondaryTabRow_pAZo6Ak$lambda$1(int r13, Modifier r14, long r15, long r17, Function3 r19, Function2 r20, Function2 r21, int r22, int r23, Composer r24, int r25) {
        m3269SecondaryTabRowpAZo6Ak(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit TabRowImpl_DTcfvLk$lambda$4(Modifier r11, long r12, long r14, Function3 r16, Function2 r17, Function2 r18, int r19, Composer r20, int r21) {
        m3271TabRowImplDTcfvLk(r11, r12, r14, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TabRowWithSubcomposeImpl_DTcfvLk$lambda$6(Modifier r11, long r12, long r14, Function3 r16, Function2 r17, Function2 r18, int r19, Composer r20, int r21) {
        m3272TabRowWithSubcomposeImplDTcfvLk(r11, r12, r14, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TabRow_pAZo6Ak$lambda$10(int r13, Modifier r14, long r15, long r17, Function3 r19, Function2 r20, Function2 r21, int r22, int r23, Composer r24, int r25) {
        m3270TabRowpAZo6Ak(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(int r0, Modifier r1, ScrollState r2, long r3, long r5, float r7, Function3 r8, Function2 r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        return SecondaryScrollableTabRow_qhFBPw4$lambda$9(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit b(int r0, Modifier r1, ScrollState r2, long r3, long r5, float r7, Function3 r8, Function2 r9, float r10, Function2 r11, int r12, int r13, Composer r14, int r15) {
        return SecondaryScrollableTabRow_cx2KkNY$lambda$3(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit c(int r0, Modifier r1, long r2, long r4, Function3 r6, Function2 r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        return PrimaryTabRow_pAZo6Ak$lambda$0(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit d(Modifier r0, long r1, long r3, Function3 r5, Function2 r6, Function2 r7, int r8, Composer r9, int r10) {
        return TabRowImpl_DTcfvLk$lambda$4(r0, r1, r3, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit e(int r0, Modifier r1, long r2, long r4, Function3 r6, Function2 r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        return SecondaryTabRow_pAZo6Ak$lambda$1(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit f(int r0, Function3 r1, Modifier r2, long r3, long r5, float r7, Function2 r8, Function2 r9, ScrollState r10, int r11, int r12, Composer r13, int r14) {
        return ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$7(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit g(int r0, Modifier r1, long r2, long r4, float r6, float r7, ScrollState r8, Function3 r9, Function2 r10, Function2 r11, int r12, Composer r13, int r14) {
        return ScrollableTabRowImpl_xam5sdo$lambda$5(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit h(int r0, Modifier r1, long r2, long r4, float r6, Function3 r7, Function2 r8, Function2 r9, int r10, int r11, Composer r12, int r13) {
        return ScrollableTabRow_sKfQg0A$lambda$11(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit i(int r0, Modifier r1, ScrollState r2, long r3, long r5, float r7, Function3 r8, Function2 r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        return PrimaryScrollableTabRow_qhFBPw4$lambda$8(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit j(Modifier r0, long r1, long r3, Function3 r5, Function2 r6, Function2 r7, int r8, Composer r9, int r10) {
        return TabRowWithSubcomposeImpl_DTcfvLk$lambda$6(r0, r1, r3, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit k(int r0, Modifier r1, ScrollState r2, long r3, long r5, float r7, Function3 r8, Function2 r9, float r10, Function2 r11, int r12, int r13, Composer r14, int r15) {
        return PrimaryScrollableTabRow_cx2KkNY$lambda$2(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit l(int r0, Modifier r1, long r2, long r4, Function3 r6, Function2 r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        return TabRow_pAZo6Ak$lambda$10(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    /* JADX INFO: renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    private static final void m3271TabRowImplDTcfvLk(final Modifier r23, final long r24, final long r26, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, final Function2<? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32) {
        Composer r1 = r31.startRestartGroup(1955286154);
        if ((r32 & 6) == 0) goto L5;
        int r3 = r32;
    L11:
        if ((r32 & 48) != 0) goto L19;
        if (r1.changed(r24) == false) goto L15;
        int r10 = 32;
    L16:
        r3 = r3 | r10;
        goto L19
    L15:
        r10 = 16;
    L19:
        if ((r32 & 384) != 0) goto L26;
        if (r1.changed(r26) == false) goto L23;
        int r11 = 256;
    L24:
        r3 = r3 | r11;
        goto L26
    L23:
        r11 = 128;
    L26:
        if ((r32 & 3072) != 0) goto L33;
        if (r1.changedInstance(r28) == false) goto L30;
        int r12 = 2048;
    L31:
        r3 = r3 | r12;
        goto L33
    L30:
        r12 = 1024;
    L33:
        if ((r32 & 24576) != 0) goto L40;
        if (r1.changedInstance(r29) == false) goto L37;
        int r13 = 16384;
    L38:
        r3 = r3 | r13;
        goto L40
    L37:
        r13 = 8192;
    L40:
        if ((196608 & r32) != 0) goto L47;
        if (r1.changedInstance(r30) == false) goto L44;
        int r14 = 131072;
    L45:
        r3 = r3 | r14;
        goto L47
    L44:
        r14 = 65536;
    L47:
        if ((74899 & r3) == 74898) goto L49;
        boolean r15 = true;
    L51:
        if (r1.shouldExecute(r15, r3 & 1) == true) goto L53;
        r1.skipToGroupEnd();
    L59:
        ScopeUpdateScope r16 = r1.endRestartGroup();
        if (r16 == null) goto L63;
        r16.updateScope(new ks(r23, r24, r26, r28, r29, r30, r32));
        return;
    L63:
        return;
    L53:
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventStart(1955286154, r3, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:398)");
    L55:
        Modifier r17 = SelectableGroupKt.selectableGroup(r23);
        ComposableLambda r19 = ComposableLambdaKt.rememberComposableLambda(830280655, true, new TabRowKt$TabRowImpl$1(r30, r29, r28), r1, 54);
        int r0 = r3 << 3;
        SurfaceKt.m3213SurfaceT9BRK9s(r17, null, r24, r26, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, r19, r1, ((r0 & 896) | 12582912) | (r0 & 7168), 114);
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventEnd();
        goto L59
    L49:
        r15 = false;
        goto L51
    L5:
        if (r1.changed(r23) == false) goto L7;
        int r4 = 4;
    L8:
        r3 = r4 | r32;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    private static final void m3272TabRowWithSubcomposeImplDTcfvLk(final Modifier r23, final long r24, final long r26, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, final Function2<? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32) {
        Composer r1 = r31.startRestartGroup(148841506);
        if ((r32 & 6) == 0) goto L5;
        int r3 = r32;
    L11:
        if ((r32 & 48) != 0) goto L19;
        if (r1.changed(r24) == false) goto L15;
        int r10 = 32;
    L16:
        r3 = r3 | r10;
        goto L19
    L15:
        r10 = 16;
    L19:
        if ((r32 & 384) != 0) goto L26;
        if (r1.changed(r26) == false) goto L23;
        int r11 = 256;
    L24:
        r3 = r3 | r11;
        goto L26
    L23:
        r11 = 128;
    L26:
        if ((r32 & 3072) != 0) goto L33;
        if (r1.changedInstance(r28) == false) goto L30;
        int r12 = 2048;
    L31:
        r3 = r3 | r12;
        goto L33
    L30:
        r12 = 1024;
    L33:
        if ((r32 & 24576) != 0) goto L40;
        if (r1.changedInstance(r29) == false) goto L37;
        int r13 = 16384;
    L38:
        r3 = r3 | r13;
        goto L40
    L37:
        r13 = 8192;
    L40:
        if ((196608 & r32) != 0) goto L47;
        if (r1.changedInstance(r30) == false) goto L44;
        int r14 = 131072;
    L45:
        r3 = r3 | r14;
        goto L47
    L44:
        r14 = 65536;
    L47:
        if ((74899 & r3) == 74898) goto L49;
        boolean r15 = true;
    L51:
        if (r1.shouldExecute(r15, r3 & 1) == true) goto L53;
        r1.skipToGroupEnd();
    L59:
        ScopeUpdateScope r16 = r1.endRestartGroup();
        if (r16 == null) goto L63;
        r16.updateScope(new ns(r23, r24, r26, r28, r29, r30, r32));
        return;
    L63:
        return;
    L53:
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventStart(148841506, r3, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:762)");
    L55:
        Modifier r17 = SelectableGroupKt.selectableGroup(r23);
        ComposableLambda r19 = ComposableLambdaKt.rememberComposableLambda(-1815327065, true, new TabRowKt$TabRowWithSubcomposeImpl$1(r30, r29, r28), r1, 54);
        int r0 = r3 << 3;
        SurfaceKt.m3213SurfaceT9BRK9s(r17, null, r24, r26, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, r19, r1, ((r0 & 896) | 12582912) | (r0 & 7168), 114);
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventEnd();
        goto L59
    L49:
        r15 = false;
        goto L51
    L5:
        if (r1.changed(r23) == false) goto L7;
        int r4 = 4;
    L8:
        r3 = r4 | r32;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m3263PrimaryTabRowpAZo6Ak(final int r21, Modifier r22, long r23, long r25, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r27, Function2<? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r2 = r30.startRestartGroup(-1012974221);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 6;
    L13:
        int r4 = r32 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r31 & 384) != 0) goto L36;
        if ((r32 & 4) != 0) goto L32;
        if (r2.changed(r23) == false) goto L32;
        int r8 = 256;
    L33:
        r3 = r3 | r8;
    L32:
        r8 = 128;
    L36:
        if ((r31 & 3072) == 0) goto L38;
        long r9 = r25;
    L46:
        int r11 = r32 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r12 = r27;
    L57:
        int r13 = r32 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Function2<? super Composer, ? super Integer, Unit> r14 = r28;
    L69:
        if ((r32 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L80:
        if ((r3 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L122;
        r2.startDefaults();
        if ((r31 & 1) != 0) goto L88;
    L97:
        if (r4 == 0) goto L99;
        Modifier r1 = Modifier.Companion;
    L101:
        if ((r32 & 4) == 0) goto L103;
        long r18 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(r2, 6);
        r3 = r3 & (-897);
    L105:
        if ((r32 & 8) == 0) goto L107;
        r9 = TabRowDefaults.INSTANCE.getPrimaryContentColor(r2, 6);
        r3 = r3 & (-7169);
    L108:
        if (r11 == 0) goto L110;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r6 = ComposableLambdaKt.rememberComposableLambda(1338273762, true, new TabRowKt$PrimaryTabRow$1(r21), r2, 54);
    L111:
        if (r13 == 0) goto L113;
        Function2<? super Composer, ? super Integer, Unit> r7 = ComposableSingletons$TabRowKt.INSTANCE.m2541getLambda$1429684928$material3();
    L114:
        int r5 = r3;
        long r10 = r18;
    L115:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventStart(-1012974221, r5, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
    L118:
        int r15 = r5 >> 3;
        int r20 = (((((r15 & 14) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168)) | (57344 & r15)) | (r15 & 458752);
        m3271TabRowImplDTcfvLk(r1, r10, r9, r6, r7, r29, r2, r20);
        if (ComposerKt.isTraceInProgress() == false) goto L121;
        ComposerKt.traceEventEnd();
    L121:
        long r16 = r10;
        r14 = r7;
        Modifier r17 = r1;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r19 = r6;
    L123:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L127;
        final Modifier r24 = r17;
        final long r26 = r16;
        final long r33 = r9;
        final Function2<? super Composer, ? super Integer, Unit> r34 = r14;
        r110.updateScope(new ms(r21, r24, r26, r33, r19, r34, r29, r31, r32));
        return;
    L127:
        return;
    L113:
        r7 = r14;
        goto L114
    L110:
        r6 = r12;
        goto L111
    L107:
        r9 = r9;
        goto L108
    L103:
        r18 = r23;
        goto L105
    L99:
        r1 = r22;
        goto L101
    L88:
        if (r2.getDefaultsInvalid() == true) goto L97;
        r2.skipToGroupEnd();
        if ((r32 & 4) == 0) goto L94;
        r3 = r3 & (-897);
    L94:
        if ((r32 & 8) == 0) goto L96;
        r3 = r3 & (-7169);
    L96:
        r1 = r22;
        r5 = r3;
        r6 = r12;
        r7 = r14;
        r10 = r23;
        goto L115
    L122:
        r2.skipToGroupEnd();
        r17 = r22;
        r16 = r23;
        r19 = r12;
        goto L123
    L82:
        r0 = false;
        goto L84
    L72:
        if ((r31 & 1572864) != 0) goto L80;
        if (r2.changedInstance(r29) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L80
    L76:
        r111 = 524288;
        goto L77
    L61:
        if ((196608 & r31) != 0) goto L67;
        r14 = r28;
        if (r2.changedInstance(r14) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L50:
        if ((r31 & 24576) != 0) goto L56;
        r12 = r27;
        if (r2.changedInstance(r12) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L57
    L54:
        r113 = 8192;
        goto L55
    L38:
        if ((r32 & 8) != 0) goto L42;
        r9 = r25;
        if (r2.changed(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r9 = r25;
        goto L43
    L17:
        if ((r31 & 48) != 0) goto L25;
        if (r2.changed(r22) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L25
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r3 = r31;
        goto L13
    L8:
        if (r2.changed(r21) == false) goto L10;
        int r36 = 4;
    L11:
        r3 = r36 | r31;
        goto L13
    L10:
        r36 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    public static final void m3269SecondaryTabRowpAZo6Ak(final int r21, Modifier r22, long r23, long r25, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r27, Function2<? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r2 = r30.startRestartGroup(563434725);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 6;
    L13:
        int r4 = r32 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r31 & 384) != 0) goto L36;
        if ((r32 & 4) != 0) goto L32;
        if (r2.changed(r23) == false) goto L32;
        int r8 = 256;
    L33:
        r3 = r3 | r8;
    L32:
        r8 = 128;
    L36:
        if ((r31 & 3072) == 0) goto L38;
        long r9 = r25;
    L46:
        int r11 = r32 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r12 = r27;
    L57:
        int r13 = r32 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Function2<? super Composer, ? super Integer, Unit> r14 = r28;
    L69:
        if ((r32 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L80:
        if ((r3 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L122;
        r2.startDefaults();
        if ((r31 & 1) != 0) goto L88;
    L97:
        if (r4 == 0) goto L99;
        Modifier r1 = Modifier.Companion;
    L101:
        if ((r32 & 4) == 0) goto L103;
        long r18 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(r2, 6);
        r3 = r3 & (-897);
    L105:
        if ((r32 & 8) == 0) goto L107;
        r9 = TabRowDefaults.INSTANCE.getSecondaryContentColor(r2, 6);
        r3 = r3 & (-7169);
    L108:
        if (r11 == 0) goto L110;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r6 = ComposableLambdaKt.rememberComposableLambda(959948692, true, new TabRowKt$SecondaryTabRow$1(r21), r2, 54);
    L111:
        if (r13 == 0) goto L113;
        Function2<? super Composer, ? super Integer, Unit> r7 = ComposableSingletons$TabRowKt.INSTANCE.m2544getLambda$463596174$material3();
    L114:
        int r5 = r3;
        long r10 = r18;
    L115:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventStart(563434725, r5, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
    L118:
        int r15 = r5 >> 3;
        int r20 = (((((r15 & 14) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168)) | (57344 & r15)) | (r15 & 458752);
        m3271TabRowImplDTcfvLk(r1, r10, r9, r6, r7, r29, r2, r20);
        if (ComposerKt.isTraceInProgress() == false) goto L121;
        ComposerKt.traceEventEnd();
    L121:
        long r16 = r10;
        r14 = r7;
        Modifier r17 = r1;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r19 = r6;
    L123:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L127;
        final Modifier r24 = r17;
        final long r26 = r16;
        final long r33 = r9;
        final Function2<? super Composer, ? super Integer, Unit> r34 = r14;
        r110.updateScope(new vs(r21, r24, r26, r33, r19, r34, r29, r31, r32));
        return;
    L127:
        return;
    L113:
        r7 = r14;
        goto L114
    L110:
        r6 = r12;
        goto L111
    L107:
        r9 = r9;
        goto L108
    L103:
        r18 = r23;
        goto L105
    L99:
        r1 = r22;
        goto L101
    L88:
        if (r2.getDefaultsInvalid() == true) goto L97;
        r2.skipToGroupEnd();
        if ((r32 & 4) == 0) goto L94;
        r3 = r3 & (-897);
    L94:
        if ((r32 & 8) == 0) goto L96;
        r3 = r3 & (-7169);
    L96:
        r1 = r22;
        r5 = r3;
        r6 = r12;
        r7 = r14;
        r10 = r23;
        goto L115
    L122:
        r2.skipToGroupEnd();
        r17 = r22;
        r16 = r23;
        r19 = r12;
        goto L123
    L82:
        r0 = false;
        goto L84
    L72:
        if ((r31 & 1572864) != 0) goto L80;
        if (r2.changedInstance(r29) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L80
    L76:
        r111 = 524288;
        goto L77
    L61:
        if ((196608 & r31) != 0) goto L67;
        r14 = r28;
        if (r2.changedInstance(r14) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L50:
        if ((r31 & 24576) != 0) goto L56;
        r12 = r27;
        if (r2.changedInstance(r12) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L57
    L54:
        r113 = 8192;
        goto L55
    L38:
        if ((r32 & 8) != 0) goto L42;
        r9 = r25;
        if (r2.changed(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r9 = r25;
        goto L43
    L17:
        if ((r31 & 48) != 0) goto L25;
        if (r2.changed(r22) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L25
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r3 = r31;
        goto L13
    L8:
        if (r2.changed(r21) == false) goto L10;
        int r36 = 4;
    L11:
        r3 = r36 | r31;
        goto L13
    L10:
        r36 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Replaced with PrimaryTabRow and SecondaryTabRow.", replaceWith = @ReplaceWith(expression = "SecondaryTabRow(selectedTabIndex, modifier, containerColor, contentColor, indicator, divider, tabs)", imports = {}))
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m3270TabRowpAZo6Ak(final int r21, Modifier r22, long r23, long r25, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r27, Function2<? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r2 = r30.startRestartGroup(1445190381);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 6;
    L13:
        int r4 = r32 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r31 & 384) != 0) goto L36;
        if ((r32 & 4) != 0) goto L32;
        if (r2.changed(r23) == false) goto L32;
        int r8 = 256;
    L33:
        r3 = r3 | r8;
    L32:
        r8 = 128;
    L36:
        if ((r31 & 3072) == 0) goto L38;
        long r9 = r25;
    L46:
        int r11 = r32 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r12 = r27;
    L57:
        int r13 = r32 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Function2<? super Composer, ? super Integer, Unit> r14 = r28;
    L69:
        if ((r32 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L80:
        if ((r3 & 599187) == 599186) goto L82;
        boolean r0 = true;
    L84:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L122;
        r2.startDefaults();
        if ((r31 & 1) != 0) goto L88;
    L97:
        if (r4 == 0) goto L99;
        Modifier r1 = Modifier.Companion;
    L101:
        if ((r32 & 4) == 0) goto L103;
        long r18 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(r2, 6);
        r3 = r3 & (-897);
    L105:
        if ((r32 & 8) == 0) goto L107;
        r9 = TabRowDefaults.INSTANCE.getPrimaryContentColor(r2, 6);
        r3 = r3 & (-7169);
    L108:
        if (r11 == 0) goto L110;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r6 = ComposableLambdaKt.rememberComposableLambda(906699528, true, new TabRowKt$TabRow$1(r21), r2, 54);
    L111:
        if (r13 == 0) goto L113;
        Function2<? super Composer, ? super Integer, Unit> r7 = ComposableSingletons$TabRowKt.INSTANCE.m2540getLambda$1132537920$material3();
    L114:
        int r5 = r3;
        long r10 = r18;
    L115:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventStart(1445190381, r5, -1, "androidx.compose.material3.TabRow (TabRow.kt:1348)");
    L118:
        int r15 = r5 >> 3;
        int r20 = (((((r15 & 14) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168)) | (57344 & r15)) | (r15 & 458752);
        m3272TabRowWithSubcomposeImplDTcfvLk(r1, r10, r9, r6, r7, r29, r2, r20);
        if (ComposerKt.isTraceInProgress() == false) goto L121;
        ComposerKt.traceEventEnd();
    L121:
        long r16 = r10;
        r14 = r7;
        Modifier r17 = r1;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r19 = r6;
    L123:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L127;
        final Modifier r24 = r17;
        final long r26 = r16;
        final long r33 = r9;
        final Function2<? super Composer, ? super Integer, Unit> r34 = r14;
        r110.updateScope(new us(r21, r24, r26, r33, r19, r34, r29, r31, r32));
        return;
    L127:
        return;
    L113:
        r7 = r14;
        goto L114
    L110:
        r6 = r12;
        goto L111
    L107:
        r9 = r9;
        goto L108
    L103:
        r18 = r23;
        goto L105
    L99:
        r1 = r22;
        goto L101
    L88:
        if (r2.getDefaultsInvalid() == true) goto L97;
        r2.skipToGroupEnd();
        if ((r32 & 4) == 0) goto L94;
        r3 = r3 & (-897);
    L94:
        if ((r32 & 8) == 0) goto L96;
        r3 = r3 & (-7169);
    L96:
        r1 = r22;
        r5 = r3;
        r6 = r12;
        r7 = r14;
        r10 = r23;
        goto L115
    L122:
        r2.skipToGroupEnd();
        r17 = r22;
        r16 = r23;
        r19 = r12;
        goto L123
    L82:
        r0 = false;
        goto L84
    L72:
        if ((r31 & 1572864) != 0) goto L80;
        if (r2.changedInstance(r29) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L80
    L76:
        r111 = 524288;
        goto L77
    L61:
        if ((196608 & r31) != 0) goto L67;
        r14 = r28;
        if (r2.changedInstance(r14) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L50:
        if ((r31 & 24576) != 0) goto L56;
        r12 = r27;
        if (r2.changedInstance(r12) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L57
    L54:
        r113 = 8192;
        goto L55
    L38:
        if ((r32 & 8) != 0) goto L42;
        r9 = r25;
        if (r2.changed(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r9 = r25;
        goto L43
    L17:
        if ((r31 & 48) != 0) goto L25;
        if (r2.changed(r22) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L25
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r3 = r31;
        goto L13
    L8:
        if (r2.changed(r21) == false) goto L10;
        int r36 = 4;
    L11:
        r3 = r36 | r31;
        goto L13
    L10:
        r36 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Replaced with PrimaryScrollableTabRow and SecondaryScrollableTabRow tab variants.", replaceWith = @ReplaceWith(expression = "SecondaryScrollableTabRow(selectedTabIndex, modifier, containerColor, contentColor, edgePadding, indicator, divider, tabs)", imports = {}))
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m3264ScrollableTabRowsKfQg0A(final int r27, Modifier r28, long r29, long r31, float r33, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r34, Function2<? super Composer, ? super Integer, Unit> r35, final Function2<? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r12 = r37.startRestartGroup(847049916);
        if ((r39 & 1) == 0) goto L6;
        int r1 = r38 | 6;
    L13:
        int r2 = r39 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r38 & 384) != 0) goto L36;
        if ((r39 & 4) != 0) goto L32;
        if (r12.changed(r29) == false) goto L32;
        int r6 = 256;
    L33:
        r1 = r1 | r6;
    L32:
        r6 = 128;
    L36:
        if ((r38 & 3072) == 0) goto L38;
        long r7 = r31;
    L46:
        int r8 = r39 & 16;
        if (r8 == 0) goto L50;
        r1 = r1 | 24576;
    L56:
        float r9 = r33;
    L57:
        int r10 = r39 & 32;
        if (r10 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r11 = r34;
    L68:
        int r16 = r39 & 64;
        if (r16 == 0) goto L72;
        r1 = r1 | 1572864;
    L79:
        if ((r39 & 128) == 0) goto L82;
        r1 = r1 | 12582912;
    L90:
        if ((r1 & 4793491) == 4793490) goto L92;
        boolean r0 = true;
    L94:
        if (r12.shouldExecute(r0, r1 & 1) == false) goto L132;
        r12.startDefaults();
        if ((r38 & 1) != 0) goto L98;
    L108:
        if (r2 == 0) goto L110;
        Modifier r3 = Modifier.Companion;
    L112:
        if ((r39 & 4) == 0) goto L114;
        long r18 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(r12, 6);
        r1 = r1 & (-897);
    L116:
        if ((r39 & 8) == 0) goto L118;
        r1 = r1 & (-7169);
        r7 = TabRowDefaults.INSTANCE.getPrimaryContentColor(r12, 6);
    L118:
        if (r8 == 0) goto L120;
        r9 = TabRowDefaults.INSTANCE.m3259getScrollableTabRowEdgeStartPaddingD9Ej5fM();
    L120:
        if (r10 == 0) goto L122;
        r11 = ComposableLambdaKt.rememberComposableLambda(-720441215, true, new TabRowKt$ScrollableTabRow$1(r27), r12, 54);
    L122:
        if (r16 == 0) goto L124;
        Modifier r17 = r3;
        Function2<? super Composer, ? super Integer, Unit> r24 = ComposableSingletons$TabRowKt.INSTANCE.m2543getLambda$358046007$material3();
    L107:
        long r20 = r7;
        float r22 = r9;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r23 = r11;
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventStart(847049916, r1, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1413)");
    L128:
        int r4 = (r1 & 14) | ((r1 >> 12) & 112);
        int r5 = r1 << 3;
        int r19 = (((((r4 | (r5 & 896)) | (r5 & 7168)) | (57344 & r5)) | (r5 & 458752)) | (3670016 & r1)) | (r1 & 29360128);
        Modifier r13 = r17;
        long r14 = r18;
        Function2<? super Composer, ? super Integer, Unit> r15 = r24;
        Composer r26 = r12;
        m3266ScrollableTabRowWithSubcomposeImplqhFBPw4(r27, r23, r13, r14, r20, r22, r15, r36, ScrollKt.rememberScrollState(0, r12, 0, 1), r12, r19, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L131;
        ComposerKt.traceEventEnd();
    L131:
        final Modifier r21 = r17;
        final long r25 = r18;
        final long r30 = r20;
        final float r32 = r22;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r40 = r23;
        final Function2<? super Composer, ? super Integer, Unit> r41 = r24;
    L133:
        ScopeUpdateScope r110 = r26.endRestartGroup();
        if (r110 == null) goto L137;
        r110.updateScope(new os(r27, r21, r25, r30, r32, r40, r41, r36, r38, r39));
        return;
    L137:
        return;
    L124:
        r24 = r35;
        r17 = r3;
        goto L107
    L114:
        r18 = r29;
        goto L116
    L110:
        r3 = r28;
        goto L112
    L98:
        if (r12.getDefaultsInvalid() == true) goto L108;
        r12.skipToGroupEnd();
        if ((r39 & 4) == 0) goto L104;
        r1 = r1 & (-897);
    L104:
        if ((r39 & 8) == 0) goto L106;
        r1 = r1 & (-7169);
    L106:
        r17 = r28;
        r18 = r29;
        r24 = r35;
        goto L107
    L132:
        r26 = r12;
        r26.skipToGroupEnd();
        r21 = r28;
        r25 = r29;
        r30 = r7;
        r32 = r9;
        r40 = r11;
        r41 = r35;
        goto L133
    L92:
        r0 = false;
        goto L94
    L82:
        if ((r38 & 12582912) != 0) goto L90;
        if (r12.changedInstance(r36) == false) goto L86;
        int r111 = 8388608;
    L87:
        r1 = r1 | r111;
        goto L90
    L86:
        r111 = 4194304;
        goto L87
    L72:
        if ((r38 & 1572864) != 0) goto L79;
        if (r12.changedInstance(r35) == false) goto L76;
        int r112 = 1048576;
    L77:
        r1 = r1 | r112;
        goto L79
    L76:
        r112 = 524288;
        goto L77
    L61:
        if ((196608 & r38) != 0) goto L67;
        r11 = r34;
        if (r12.changedInstance(r11) == false) goto L65;
        int r113 = 131072;
    L66:
        r1 = r1 | r113;
        goto L68
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r38 & 24576) != 0) goto L56;
        r9 = r33;
        if (r12.changed(r9) == false) goto L54;
        int r114 = 16384;
    L55:
        r1 = r1 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L38:
        if ((r39 & 8) != 0) goto L42;
        r7 = r31;
        if (r12.changed(r7) == false) goto L43;
        int r42 = 2048;
    L44:
        r1 = r1 | r42;
    L43:
        r42 = 1024;
        goto L44
    L42:
        r7 = r31;
        goto L43
    L17:
        if ((r38 & 48) != 0) goto L25;
        if (r12.changed(r28) == false) goto L21;
        int r43 = 32;
    L22:
        r1 = r1 | r43;
        goto L25
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r1 = r38;
        goto L13
    L8:
        if (r12.changed(r27) == false) goto L10;
        int r44 = 4;
    L11:
        r1 = r44 | r38;
        goto L13
    L10:
        r44 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary Compatibility.")
    /* JADX INFO: renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final /* synthetic */ void m3262PrimaryScrollableTabRowqhFBPw4(final int r28, Modifier r29, ScrollState r30, long r31, long r33, float r35, Function3 r36, Function2 r37, final Function2 r38, Composer r39, final int r40, final int r41) {
        Composer r12 = r39.startRestartGroup(1501129198);
        if ((r41 & 1) == 0) goto L6;
        int r1 = r40 | 6;
    L13:
        int r2 = r41 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r40 & 384) != 0) goto L36;
        if ((r41 & 4) != 0) goto L32;
        if (r12.changed(r30) == false) goto L32;
        int r5 = 256;
    L33:
        r1 = r1 | r5;
    L32:
        r5 = 128;
    L36:
        if ((r40 & 3072) != 0) goto L47;
        if ((r41 & 8) != 0) goto L43;
        if (r12.changed(r31) == false) goto L43;
        int r7 = 2048;
    L44:
        r1 = r1 | r7;
    L43:
        r7 = 1024;
    L47:
        if ((r40 & 24576) == 0) goto L49;
        long r8 = r33;
    L57:
        int r9 = r41 & 32;
        if (r9 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        float r10 = r35;
    L68:
        int r11 = r41 & 64;
        if (r11 == 0) goto L72;
        r1 = r1 | 1572864;
    L78:
        int r0 = r41 & 128;
        if (r0 == 0) goto L82;
        r1 = r1 | 12582912;
    L89:
        if ((r41 & 256) == 0) goto L92;
        r1 = r1 | 100663296;
    L100:
        if ((r1 & 38347923) == 38347922) goto L102;
        boolean r3 = true;
    L104:
        if (r12.shouldExecute(r3, r1 & 1) == false) goto L152;
        r12.startDefaults();
        if ((r40 & 1) != 0) goto L108;
    L120:
        if (r2 == 0) goto L122;
        Modifier r4 = Modifier.Companion;
    L124:
        if ((r41 & 4) == 0) goto L126;
        ScrollState r6 = ScrollKt.rememberScrollState(0, r12, 0, 1);
        r1 = r1 & (-897);
    L128:
        if ((r41 & 8) == 0) goto L130;
        long r18 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(r12, 6);
        r1 = r1 & (-7169);
    L132:
        if ((r41 & 16) == 0) goto L134;
        long r13 = TabRowDefaults.INSTANCE.getPrimaryContentColor(r12, 6);
        r1 = r1 & (-57345);
    L135:
        if (r9 == 0) goto L137;
        float r14 = TabRowDefaults.INSTANCE.m3259getScrollableTabRowEdgeStartPaddingD9Ej5fM();
    L138:
        if (r11 == 0) goto L140;
        Function3 r15 = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new TabRowKt$PrimaryScrollableTabRow$3(r28), r12, 54);
    L141:
        if (r0 == 0) goto L143;
        Function2 r26 = ComposableSingletons$TabRowKt.INSTANCE.m2542getLambda$306947391$material3();
    L144:
        float r24 = r14;
        long r22 = r13;
        Function3 r25 = r15;
        long r20 = r18;
        Modifier r19 = r4;
        ScrollState r110 = r6;
    L145:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventStart(1501129198, r1, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:1205)");
    L148:
        float r16 = TabRowDefaults.INSTANCE.m3260getScrollableTabRowMinTabWidthD9Ej5fM();
        int r17 = (((((((((r1 & 14) | 100663296) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | ((r1 << 3) & 1879048192);
        Composer r27 = r12;
        m3261PrimaryScrollableTabRowcx2KkNY(r28, r19, r110, r20, r22, r24, r25, r26, r16, r38, r12, r17, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L151;
        ComposerKt.traceEventEnd();
    L151:
        final Modifier r21 = r19;
        final ScrollState r23 = r110;
        final long r32 = r20;
        final long r34 = r22;
        final float r42 = r24;
        final Function3 r43 = r25;
        final Function2 r111 = r26;
    L153:
        ScopeUpdateScope r112 = r27.endRestartGroup();
        if (r112 == null) goto L157;
        r112.updateScope(new ls(r28, r21, r23, r32, r34, r42, r43, r111, r38, r40, r41));
        return;
    L157:
        return;
    L143:
        r26 = r37;
        goto L144
    L140:
        r15 = r36;
        goto L141
    L137:
        r14 = r10;
        goto L138
    L134:
        r13 = r8;
        goto L135
    L130:
        r18 = r31;
        goto L132
    L126:
        r6 = r30;
        goto L128
    L122:
        r4 = r29;
        goto L124
    L108:
        if (r12.getDefaultsInvalid() == true) goto L120;
        r12.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L114;
        r1 = r1 & (-897);
    L114:
        if ((r41 & 8) == 0) goto L117;
        r1 = r1 & (-7169);
    L117:
        if ((r41 & 16) == 0) goto L119;
        r1 = r1 & (-57345);
    L119:
        r19 = r29;
        r110 = r30;
        r20 = r31;
        r25 = r36;
        r26 = r37;
        r22 = r8;
        r24 = r10;
        goto L145
    L152:
        r27 = r12;
        r27.skipToGroupEnd();
        r21 = r29;
        r23 = r30;
        r32 = r31;
        r43 = r36;
        r34 = r8;
        r42 = r10;
        r111 = r37;
        goto L153
    L102:
        r3 = false;
        goto L104
    L92:
        if ((r40 & 100663296) != 0) goto L100;
        if (r12.changedInstance(r38) == false) goto L96;
        int r113 = 67108864;
    L97:
        r1 = r1 | r113;
        goto L100
    L96:
        r113 = 33554432;
        goto L97
    L82:
        if ((r40 & 12582912) != 0) goto L89;
        if (r12.changedInstance(r37) == false) goto L86;
        int r114 = 8388608;
    L87:
        r1 = r1 | r114;
        goto L89
    L86:
        r114 = 4194304;
        goto L87
    L72:
        if ((r40 & 1572864) != 0) goto L78;
        if (r12.changedInstance(r36) == false) goto L76;
        int r115 = 1048576;
    L77:
        r1 = r1 | r115;
        goto L78
    L76:
        r115 = 524288;
        goto L77
    L61:
        if ((196608 & r40) != 0) goto L67;
        r10 = r35;
        if (r12.changed(r10) == false) goto L65;
        int r116 = 131072;
    L66:
        r1 = r1 | r116;
        goto L68
    L65:
        r116 = 65536;
        goto L66
    L49:
        if ((r41 & 16) != 0) goto L53;
        r8 = r33;
        if (r12.changed(r8) == false) goto L54;
        int r44 = 16384;
    L55:
        r1 = r1 | r44;
    L54:
        r44 = 8192;
        goto L55
    L53:
        r8 = r33;
        goto L54
    L17:
        if ((r40 & 48) != 0) goto L25;
        if (r12.changed(r29) == false) goto L21;
        int r45 = 32;
    L22:
        r1 = r1 | r45;
        goto L25
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r1 = r40;
        goto L13
    L8:
        if (r12.changed(r28) == false) goto L10;
        int r46 = 4;
    L11:
        r1 = r46 | r40;
        goto L13
    L10:
        r46 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ScrollableTabRowImpl-xam5sdo, reason: not valid java name */
    private static final void m3265ScrollableTabRowImplxam5sdo(final int r27, final Modifier r28, final long r29, final long r31, final float r33, final float r34, final ScrollState r35, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r36, final Function2<? super Composer, ? super Integer, Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, Composer r39, final int r40) {
        Composer r1 = r39.startRestartGroup(414860860);
        if ((r40 & 6) == 0) goto L5;
        int r3 = r40;
    L11:
        if ((r40 & 48) != 0) goto L18;
        if (r1.changed(r28) == false) goto L15;
        int r4 = 32;
    L16:
        r3 = r3 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r40 & 384) != 0) goto L25;
        if (r1.changed(r29) == false) goto L22;
        int r5 = 256;
    L23:
        r3 = r3 | r5;
        goto L25
    L22:
        r5 = 128;
    L25:
        if ((r40 & 3072) != 0) goto L32;
        if (r1.changed(r31) == false) goto L29;
        int r6 = 2048;
    L30:
        r3 = r3 | r6;
        goto L32
    L29:
        r6 = 1024;
    L32:
        if ((r40 & 24576) != 0) goto L39;
        if (r1.changed(r33) == false) goto L36;
        int r7 = 16384;
    L37:
        r3 = r3 | r7;
        goto L39
    L36:
        r7 = 8192;
    L39:
        if ((196608 & r40) != 0) goto L46;
        if (r1.changed(r34) == false) goto L43;
        int r8 = 131072;
    L44:
        r3 = r3 | r8;
        goto L46
    L43:
        r8 = 65536;
    L46:
        if ((1572864 & r40) != 0) goto L53;
        if (r1.changed(r35) == false) goto L50;
        int r9 = 1048576;
    L51:
        r3 = r3 | r9;
        goto L53
    L50:
        r9 = 524288;
    L53:
        if ((r40 & 12582912) != 0) goto L60;
        if (r1.changedInstance(r36) == false) goto L57;
        int r10 = 8388608;
    L58:
        r3 = r3 | r10;
        goto L60
    L57:
        r10 = 4194304;
    L60:
        if ((100663296 & r40) != 0) goto L67;
        if (r1.changedInstance(r37) == false) goto L64;
        int r11 = 67108864;
    L65:
        r3 = r3 | r11;
        goto L67
    L64:
        r11 = 33554432;
    L67:
        if ((805306368 & r40) != 0) goto L75;
        if (r1.changedInstance(r38) == false) goto L71;
        int r17 = 536870912;
    L72:
        r3 = r3 | r17;
        goto L75
    L71:
        r17 = 268435456;
    L75:
        if ((r3 & 306783379) == 306783378) goto L77;
        boolean r0 = true;
    L79:
        if (r1.shouldExecute(r0, r3 & 1) == true) goto L81;
        r1.skipToGroupEnd();
    L87:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L91;
        r14.updateScope(new qs(r27, r28, r29, r31, r33, r34, r35, r36, r37, r38, r40));
        return;
    L91:
        return;
    L81:
        if (ComposerKt.isTraceInProgress() == false) goto L83;
        ComposerKt.traceEventStart(414860860, r3, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:521)");
    L83:
        int r12 = r3;
        SurfaceKt.m3213SurfaceT9BRK9s(r28, null, r29, r31, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(1878374785, true, new TabRowKt$ScrollableTabRowImpl$1(r35, r37, r38, r33, r34, r27, r36), r1, 54), r1, ((((r12 >> 3) & 14) | 12582912) | (r12 & 896)) | (r12 & 7168), 114);
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventEnd();
        goto L87
    L77:
        r0 = false;
        goto L79
    L5:
        if (r1.changed(r27) == false) goto L7;
        int r13 = 4;
    L8:
        r3 = r13 | r40;
        goto L11
    L7:
        r13 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: ScrollableTabRowWithSubcomposeImpl-qhFBPw4, reason: not valid java name */
    private static final void m3266ScrollableTabRowWithSubcomposeImplqhFBPw4(final int r27, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r28, Modifier r29, long r30, long r32, float r34, Function2<? super Composer, ? super Integer, Unit> r35, final Function2<? super Composer, ? super Integer, Unit> r36, final ScrollState r37, Composer r38, final int r39, final int r40) {
        Composer r1 = r38.startRestartGroup(901781420);
        if ((r40 & 1) == 0) goto L6;
        int r3 = r39 | 6;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r40 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r29;
    L36:
        if ((r39 & 3072) == 0) goto L38;
        long r7 = r30;
    L47:
        if ((r39 & 24576) == 0) goto L49;
        long r9 = r32;
    L57:
        int r11 = r40 & 32;
        if (r11 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        float r14 = r34;
    L68:
        int r15 = r40 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r40 & 128) == 0) goto L82;
        r3 = r3 | 12582912;
    L90:
        if ((r40 & 256) == 0) goto L93;
        r3 = r3 | 100663296;
    L101:
        if ((r3 & 38347923) == 38347922) goto L103;
        boolean r0 = true;
    L105:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L138;
        r1.startDefaults();
        if ((r39 & 1) != 0) goto L109;
    L119:
        if (r5 == 0) goto L122;
        r6 = Modifier.Companion;
    L122:
        if ((r40 & 8) == 0) goto L125;
        r7 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(r1, 6);
        r3 = r3 & (-7169);
    L125:
        if ((r40 & 16) == 0) goto L127;
        r9 = TabRowDefaults.INSTANCE.getPrimaryContentColor(r1, 6);
        r3 = r3 & (-57345);
    L127:
        if (r11 == 0) goto L129;
        r14 = TabRowDefaults.INSTANCE.m3259getScrollableTabRowEdgeStartPaddingD9Ej5fM();
    L129:
        if (r15 != 0) goto L130;
    L117:
        Function2<? super Composer, ? super Integer, Unit> r2 = r35;
    L118:
        float r4 = r14;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventStart(901781420, r3, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:834)");
    L134:
        int r8 = ((r3 >> 6) & 14) | 12582912;
        int r10 = r3 >> 3;
        Modifier r16 = r6;
        long r17 = r7;
        long r18 = r9;
        SurfaceKt.m3213SurfaceT9BRK9s(r16, null, r17, r18, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(2077251399, true, new TabRowKt$ScrollableTabRowWithSubcomposeImpl$1(r37, r4, r36, r2, r28, r27), r1, 54), r1, (r8 | (r10 & 896)) | (r10 & 7168), 114);
        if (ComposerKt.isTraceInProgress() == false) goto L137;
        ComposerKt.traceEventEnd();
    L137:
        final Modifier r12 = r6;
        final long r13 = r7;
        final long r19 = r9;
        final float r20 = r4;
        final Function2<? super Composer, ? super Integer, Unit> r21 = r2;
    L139:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L143;
        r110.updateScope(new ss(r27, r28, r12, r13, r19, r20, r21, r36, r37, r39, r40));
        return;
    L143:
        return;
    L130:
        r2 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
        goto L118
    L109:
        if (r1.getDefaultsInvalid() == true) goto L119;
        r1.skipToGroupEnd();
        if ((r40 & 8) == 0) goto L115;
        r3 = r3 & (-7169);
    L115:
        if ((r40 & 16) == 0) goto L117;
        r3 = r3 & (-57345);
        goto L117
    L138:
        r1.skipToGroupEnd();
        r12 = r6;
        r13 = r7;
        r19 = r9;
        r20 = r14;
        r21 = r35;
        goto L139
    L103:
        r0 = false;
        goto L105
    L93:
        if ((r39 & 100663296) != 0) goto L101;
        if (r1.changed(r37) == false) goto L97;
        int r111 = 67108864;
    L98:
        r3 = r3 | r111;
        goto L101
    L97:
        r111 = 33554432;
        goto L98
    L82:
        if ((r39 & 12582912) != 0) goto L90;
        if (r1.changedInstance(r36) == false) goto L86;
        int r112 = 8388608;
    L87:
        r3 = r3 | r112;
        goto L90
    L86:
        r112 = 4194304;
        goto L87
    L72:
        if ((r39 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r35) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L79
    L76:
        r113 = 524288;
        goto L77
    L61:
        if ((196608 & r39) != 0) goto L67;
        r14 = r34;
        if (r1.changed(r14) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L68
    L65:
        r114 = 65536;
        goto L66
    L49:
        if ((r40 & 16) != 0) goto L53;
        r9 = r32;
        if (r1.changed(r9) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
    L54:
        r115 = 8192;
        goto L55
    L53:
        r9 = r32;
        goto L54
    L38:
        if ((r40 & 8) != 0) goto L42;
        r7 = r30;
        if (r1.changed(r7) == false) goto L43;
        int r22 = 2048;
    L44:
        r3 = r3 | r22;
    L43:
        r22 = 1024;
        goto L44
    L42:
        r7 = r30;
        goto L43
    L28:
        if ((r39 & 384) != 0) goto L34;
        r6 = r29;
        if (r1.changed(r6) == false) goto L32;
        int r23 = 256;
    L33:
        r3 = r3 | r23;
        goto L36
    L32:
        r23 = 128;
        goto L33
    L17:
        if ((r39 & 48) != 0) goto L24;
        if (r1.changedInstance(r28) == false) goto L21;
        int r24 = 32;
    L22:
        r3 = r3 | r24;
        goto L24
    L21:
        r24 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r3 = r39;
        goto L14
    L8:
        if (r1.changed(r27) == false) goto L10;
        int r25 = 4;
    L11:
        r3 = r25 | r39;
        goto L14
    L10:
        r25 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary Compatibility.")
    /* JADX INFO: renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    public static final /* synthetic */ void m3268SecondaryScrollableTabRowqhFBPw4(final int r28, Modifier r29, ScrollState r30, long r31, long r33, float r35, Function3 r36, Function2 r37, final Function2 r38, Composer r39, final int r40, final int r41) {
        Composer r12 = r39.startRestartGroup(-712886596);
        if ((r41 & 1) == 0) goto L6;
        int r1 = r40 | 6;
    L13:
        int r2 = r41 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r40 & 384) != 0) goto L36;
        if ((r41 & 4) != 0) goto L32;
        if (r12.changed(r30) == false) goto L32;
        int r5 = 256;
    L33:
        r1 = r1 | r5;
    L32:
        r5 = 128;
    L36:
        if ((r40 & 3072) != 0) goto L47;
        if ((r41 & 8) != 0) goto L43;
        if (r12.changed(r31) == false) goto L43;
        int r7 = 2048;
    L44:
        r1 = r1 | r7;
    L43:
        r7 = 1024;
    L47:
        if ((r40 & 24576) == 0) goto L49;
        long r8 = r33;
    L57:
        int r9 = r41 & 32;
        if (r9 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        float r10 = r35;
    L68:
        int r11 = r41 & 64;
        if (r11 == 0) goto L72;
        r1 = r1 | 1572864;
    L78:
        int r0 = r41 & 128;
        if (r0 == 0) goto L82;
        r1 = r1 | 12582912;
    L89:
        if ((r41 & 256) == 0) goto L92;
        r1 = r1 | 100663296;
    L100:
        if ((r1 & 38347923) == 38347922) goto L102;
        boolean r3 = true;
    L104:
        if (r12.shouldExecute(r3, r1 & 1) == false) goto L152;
        r12.startDefaults();
        if ((r40 & 1) != 0) goto L108;
    L120:
        if (r2 == 0) goto L122;
        Modifier r4 = Modifier.Companion;
    L124:
        if ((r41 & 4) == 0) goto L126;
        ScrollState r6 = ScrollKt.rememberScrollState(0, r12, 0, 1);
        r1 = r1 & (-897);
    L128:
        if ((r41 & 8) == 0) goto L130;
        long r18 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(r12, 6);
        r1 = r1 & (-7169);
    L132:
        if ((r41 & 16) == 0) goto L134;
        long r13 = TabRowDefaults.INSTANCE.getSecondaryContentColor(r12, 6);
        r1 = r1 & (-57345);
    L135:
        if (r9 == 0) goto L137;
        float r14 = TabRowDefaults.INSTANCE.m3259getScrollableTabRowEdgeStartPaddingD9Ej5fM();
    L138:
        if (r11 == 0) goto L140;
        Function3 r15 = ComposableLambdaKt.rememberComposableLambda(407893741, true, new TabRowKt$SecondaryScrollableTabRow$3(r28), r12, 54);
    L141:
        if (r0 == 0) goto L143;
        Function2 r26 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
    L144:
        float r24 = r14;
        long r22 = r13;
        Function3 r25 = r15;
        long r20 = r18;
        Modifier r19 = r4;
        ScrollState r110 = r6;
    L145:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventStart(-712886596, r1, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:1236)");
    L148:
        float r16 = TabRowDefaults.INSTANCE.m3260getScrollableTabRowMinTabWidthD9Ej5fM();
        int r17 = (((((((((r1 & 14) | 100663296) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | ((r1 << 3) & 1879048192);
        Composer r27 = r12;
        m3267SecondaryScrollableTabRowcx2KkNY(r28, r19, r110, r20, r22, r24, r25, r26, r16, r38, r12, r17, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L151;
        ComposerKt.traceEventEnd();
    L151:
        final Modifier r21 = r19;
        final ScrollState r23 = r110;
        final long r32 = r20;
        final long r34 = r22;
        final float r42 = r24;
        final Function3 r43 = r25;
        final Function2 r111 = r26;
    L153:
        ScopeUpdateScope r112 = r27.endRestartGroup();
        if (r112 == null) goto L157;
        r112.updateScope(new ps(r28, r21, r23, r32, r34, r42, r43, r111, r38, r40, r41));
        return;
    L157:
        return;
    L143:
        r26 = r37;
        goto L144
    L140:
        r15 = r36;
        goto L141
    L137:
        r14 = r10;
        goto L138
    L134:
        r13 = r8;
        goto L135
    L130:
        r18 = r31;
        goto L132
    L126:
        r6 = r30;
        goto L128
    L122:
        r4 = r29;
        goto L124
    L108:
        if (r12.getDefaultsInvalid() == true) goto L120;
        r12.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L114;
        r1 = r1 & (-897);
    L114:
        if ((r41 & 8) == 0) goto L117;
        r1 = r1 & (-7169);
    L117:
        if ((r41 & 16) == 0) goto L119;
        r1 = r1 & (-57345);
    L119:
        r19 = r29;
        r110 = r30;
        r20 = r31;
        r25 = r36;
        r26 = r37;
        r22 = r8;
        r24 = r10;
        goto L145
    L152:
        r27 = r12;
        r27.skipToGroupEnd();
        r21 = r29;
        r23 = r30;
        r32 = r31;
        r43 = r36;
        r34 = r8;
        r42 = r10;
        r111 = r37;
        goto L153
    L102:
        r3 = false;
        goto L104
    L92:
        if ((r40 & 100663296) != 0) goto L100;
        if (r12.changedInstance(r38) == false) goto L96;
        int r113 = 67108864;
    L97:
        r1 = r1 | r113;
        goto L100
    L96:
        r113 = 33554432;
        goto L97
    L82:
        if ((r40 & 12582912) != 0) goto L89;
        if (r12.changedInstance(r37) == false) goto L86;
        int r114 = 8388608;
    L87:
        r1 = r1 | r114;
        goto L89
    L86:
        r114 = 4194304;
        goto L87
    L72:
        if ((r40 & 1572864) != 0) goto L78;
        if (r12.changedInstance(r36) == false) goto L76;
        int r115 = 1048576;
    L77:
        r1 = r1 | r115;
        goto L78
    L76:
        r115 = 524288;
        goto L77
    L61:
        if ((196608 & r40) != 0) goto L67;
        r10 = r35;
        if (r12.changed(r10) == false) goto L65;
        int r116 = 131072;
    L66:
        r1 = r1 | r116;
        goto L68
    L65:
        r116 = 65536;
        goto L66
    L49:
        if ((r41 & 16) != 0) goto L53;
        r8 = r33;
        if (r12.changed(r8) == false) goto L54;
        int r44 = 16384;
    L55:
        r1 = r1 | r44;
    L54:
        r44 = 8192;
        goto L55
    L53:
        r8 = r33;
        goto L54
    L17:
        if ((r40 & 48) != 0) goto L25;
        if (r12.changed(r29) == false) goto L21;
        int r45 = 32;
    L22:
        r1 = r1 | r45;
        goto L25
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r1 = r40;
        goto L13
    L8:
        if (r12.changed(r28) == false) goto L10;
        int r46 = 4;
    L11:
        r1 = r46 | r40;
        goto L13
    L10:
        r46 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: PrimaryScrollableTabRow-cx2KkNY, reason: not valid java name */
    public static final void m3261PrimaryScrollableTabRowcx2KkNY(final int r29, Modifier r30, ScrollState r31, long r32, long r34, float r36, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r37, Function2<? super Composer, ? super Integer, Unit> r38, float r39, final Function2<? super Composer, ? super Integer, Unit> r40, Composer r41, final int r42, final int r43) {
        Composer r12 = r41.startRestartGroup(450849184);
        if ((r43 & 1) == 0) goto L6;
        int r1 = r42 | 6;
    L13:
        int r2 = r43 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r42 & 384) != 0) goto L36;
        if ((r43 & 4) != 0) goto L32;
        if (r12.changed(r31) == false) goto L32;
        int r5 = 256;
    L33:
        r1 = r1 | r5;
    L32:
        r5 = 128;
    L36:
        if ((r42 & 3072) != 0) goto L47;
        if ((r43 & 8) != 0) goto L43;
        if (r12.changed(r32) == false) goto L43;
        int r7 = 2048;
    L44:
        r1 = r1 | r7;
    L43:
        r7 = 1024;
    L47:
        if ((r42 & 24576) == 0) goto L49;
        long r8 = r34;
    L57:
        int r9 = r43 & 32;
        if (r9 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        float r10 = r36;
    L68:
        int r11 = r43 & 64;
        if (r11 == 0) goto L72;
        r1 = r1 | 1572864;
    L78:
        int r0 = r43 & 128;
        if (r0 == 0) goto L82;
        r1 = r1 | 12582912;
    L88:
        int r3 = r43 & 256;
        if (r3 == 0) goto L92;
        r1 = r1 | 100663296;
    L99:
        if ((r43 & 512) == 0) goto L102;
        r1 = r1 | 805306368;
    L110:
        if ((r1 & 306783379) == 306783378) goto L112;
        boolean r4 = true;
    L114:
        if (r12.shouldExecute(r4, r1 & 1) == false) goto L165;
        r12.startDefaults();
        if ((r42 & 1) != 0) goto L118;
    L130:
        if (r2 == 0) goto L132;
        Modifier r6 = Modifier.Companion;
    L134:
        if ((r43 & 4) == 0) goto L136;
        ScrollState r13 = ScrollKt.rememberScrollState(0, r12, 0, 1);
        r1 = r1 & (-897);
    L138:
        if ((r43 & 8) == 0) goto L140;
        long r18 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(r12, 6);
        r1 = r1 & (-7169);
    L142:
        if ((r43 & 16) == 0) goto L144;
        long r14 = TabRowDefaults.INSTANCE.getPrimaryContentColor(r12, 6);
        r1 = r1 & (-57345);
    L145:
        if (r9 == 0) goto L147;
        float r15 = TabRowDefaults.INSTANCE.m3259getScrollableTabRowEdgeStartPaddingD9Ej5fM();
    L148:
        if (r11 == 0) goto L150;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r16 = ComposableLambdaKt.rememberComposableLambda(835301263, true, new TabRowKt$PrimaryScrollableTabRow$1(r29), r12, 54);
    L151:
        if (r0 == 0) goto L153;
        Function2<? super Composer, ? super Integer, Unit> r17 = ComposableSingletons$TabRowKt.INSTANCE.m2545getLambda$773954579$material3();
    L154:
        if (r3 == 0) goto L156;
        float r26 = TabRowDefaults.INSTANCE.m3260getScrollableTabRowMinTabWidthD9Ej5fM();
    L157:
        long r21 = r14;
        float r23 = r15;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r24 = r16;
        long r19 = r18;
        ScrollState r110 = r13;
    L158:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventStart(450849184, r1, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
    L161:
        int r20 = (r1 & 14) | (r1 & 112);
        int r22 = r1 >> 3;
        int r25 = ((((r20 | (r22 & 896)) | (r22 & 7168)) | (r22 & 57344)) | ((r1 >> 9) & 458752)) | ((r1 << 12) & 3670016);
        int r27 = r1 << 3;
        int r111 = ((r25 | (29360128 & r27)) | (r27 & 234881024)) | (r1 & 1879048192);
        Composer r28 = r12;
        m3265ScrollableTabRowImplxam5sdo(r29, r6, r19, r21, r23, r26, r110, r24, r17, r40, r12, r111);
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
    L164:
        final Modifier r33 = r6;
        final ScrollState r35 = r110;
        final long r44 = r19;
        final long r45 = r21;
        final float r46 = r23;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r47 = r24;
        final Function2<? super Composer, ? super Integer, Unit> r112 = r17;
        final float r113 = r26;
    L166:
        ScopeUpdateScope r114 = r28.endRestartGroup();
        if (r114 == null) goto L170;
        r114.updateScope(new ts(r29, r33, r35, r44, r45, r46, r47, r112, r113, r40, r42, r43));
        return;
    L170:
        return;
    L156:
        r26 = r39;
        goto L157
    L153:
        r17 = r38;
        goto L154
    L150:
        r16 = r37;
        goto L151
    L147:
        r15 = r10;
        goto L148
    L144:
        r14 = r8;
        goto L145
    L140:
        r18 = r32;
        goto L142
    L136:
        r13 = r31;
        goto L138
    L132:
        r6 = r30;
        goto L134
    L118:
        if (r12.getDefaultsInvalid() == true) goto L130;
        r12.skipToGroupEnd();
        if ((r43 & 4) == 0) goto L124;
        r1 = r1 & (-897);
    L124:
        if ((r43 & 8) == 0) goto L127;
        r1 = r1 & (-7169);
    L127:
        if ((r43 & 16) == 0) goto L129;
        r1 = r1 & (-57345);
    L129:
        r6 = r30;
        r110 = r31;
        r19 = r32;
        r24 = r37;
        r17 = r38;
        r26 = r39;
        r21 = r8;
        r23 = r10;
        goto L158
    L165:
        r28 = r12;
        r28.skipToGroupEnd();
        r33 = r30;
        r35 = r31;
        r44 = r32;
        r47 = r37;
        r113 = r39;
        r45 = r8;
        r46 = r10;
        r112 = r38;
        goto L166
    L112:
        r4 = false;
        goto L114
    L102:
        if ((r42 & 805306368) != 0) goto L110;
        if (r12.changedInstance(r40) == false) goto L106;
        int r115 = 536870912;
    L107:
        r1 = r1 | r115;
        goto L110
    L106:
        r115 = 268435456;
        goto L107
    L92:
        if ((r42 & 100663296) != 0) goto L99;
        if (r12.changed(r39) == false) goto L96;
        int r116 = 67108864;
    L97:
        r1 = r1 | r116;
        goto L99
    L96:
        r116 = 33554432;
        goto L97
    L82:
        if ((r42 & 12582912) != 0) goto L88;
        if (r12.changedInstance(r38) == false) goto L86;
        int r117 = 8388608;
    L87:
        r1 = r1 | r117;
        goto L88
    L86:
        r117 = 4194304;
        goto L87
    L72:
        if ((r42 & 1572864) != 0) goto L78;
        if (r12.changedInstance(r37) == false) goto L76;
        int r118 = 1048576;
    L77:
        r1 = r1 | r118;
        goto L78
    L76:
        r118 = 524288;
        goto L77
    L61:
        if ((196608 & r42) != 0) goto L67;
        r10 = r36;
        if (r12.changed(r10) == false) goto L65;
        int r119 = 131072;
    L66:
        r1 = r1 | r119;
        goto L68
    L65:
        r119 = 65536;
        goto L66
    L49:
        if ((r43 & 16) != 0) goto L53;
        r8 = r34;
        if (r12.changed(r8) == false) goto L54;
        int r48 = 16384;
    L55:
        r1 = r1 | r48;
    L54:
        r48 = 8192;
        goto L55
    L53:
        r8 = r34;
        goto L54
    L17:
        if ((r42 & 48) != 0) goto L25;
        if (r12.changed(r30) == false) goto L21;
        int r49 = 32;
    L22:
        r1 = r1 | r49;
        goto L25
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r1 = r42;
        goto L13
    L8:
        if (r12.changed(r29) == false) goto L10;
        int r50 = 4;
    L11:
        r1 = r50 | r42;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SecondaryScrollableTabRow-cx2KkNY, reason: not valid java name */
    public static final void m3267SecondaryScrollableTabRowcx2KkNY(final int r29, Modifier r30, ScrollState r31, long r32, long r34, float r36, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r37, Function2<? super Composer, ? super Integer, Unit> r38, float r39, final Function2<? super Composer, ? super Integer, Unit> r40, Composer r41, final int r42, final int r43) {
        Composer r12 = r41.startRestartGroup(519094802);
        if ((r43 & 1) == 0) goto L6;
        int r1 = r42 | 6;
    L13:
        int r2 = r43 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r42 & 384) != 0) goto L36;
        if ((r43 & 4) != 0) goto L32;
        if (r12.changed(r31) == false) goto L32;
        int r5 = 256;
    L33:
        r1 = r1 | r5;
    L32:
        r5 = 128;
    L36:
        if ((r42 & 3072) != 0) goto L47;
        if ((r43 & 8) != 0) goto L43;
        if (r12.changed(r32) == false) goto L43;
        int r7 = 2048;
    L44:
        r1 = r1 | r7;
    L43:
        r7 = 1024;
    L47:
        if ((r42 & 24576) == 0) goto L49;
        long r8 = r34;
    L57:
        int r9 = r43 & 32;
        if (r9 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        float r10 = r36;
    L68:
        int r11 = r43 & 64;
        if (r11 == 0) goto L72;
        r1 = r1 | 1572864;
    L78:
        int r0 = r43 & 128;
        if (r0 == 0) goto L82;
        r1 = r1 | 12582912;
    L88:
        int r3 = r43 & 256;
        if (r3 == 0) goto L92;
        r1 = r1 | 100663296;
    L99:
        if ((r43 & 512) == 0) goto L102;
        r1 = r1 | 805306368;
    L110:
        if ((r1 & 306783379) == 306783378) goto L112;
        boolean r4 = true;
    L114:
        if (r12.shouldExecute(r4, r1 & 1) == false) goto L165;
        r12.startDefaults();
        if ((r42 & 1) != 0) goto L118;
    L130:
        if (r2 == 0) goto L132;
        Modifier r6 = Modifier.Companion;
    L134:
        if ((r43 & 4) == 0) goto L136;
        ScrollState r13 = ScrollKt.rememberScrollState(0, r12, 0, 1);
        r1 = r1 & (-897);
    L138:
        if ((r43 & 8) == 0) goto L140;
        long r18 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(r12, 6);
        r1 = r1 & (-7169);
    L142:
        if ((r43 & 16) == 0) goto L144;
        long r14 = TabRowDefaults.INSTANCE.getSecondaryContentColor(r12, 6);
        r1 = r1 & (-57345);
    L145:
        if (r9 == 0) goto L147;
        float r15 = TabRowDefaults.INSTANCE.m3259getScrollableTabRowEdgeStartPaddingD9Ej5fM();
    L148:
        if (r11 == 0) goto L150;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r16 = ComposableLambdaKt.rememberComposableLambda(610355265, true, new TabRowKt$SecondaryScrollableTabRow$1(r29), r12, 54);
    L151:
        if (r0 == 0) goto L153;
        Function2<? super Composer, ? super Integer, Unit> r17 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3();
    L154:
        if (r3 == 0) goto L156;
        float r26 = TabRowDefaults.INSTANCE.m3260getScrollableTabRowMinTabWidthD9Ej5fM();
    L157:
        long r21 = r14;
        float r23 = r15;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r24 = r16;
        long r19 = r18;
        ScrollState r110 = r13;
    L158:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventStart(519094802, r1, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
    L161:
        int r20 = (r1 & 14) | (r1 & 112);
        int r22 = r1 >> 3;
        int r25 = ((((r20 | (r22 & 896)) | (r22 & 7168)) | (r22 & 57344)) | ((r1 >> 9) & 458752)) | ((r1 << 12) & 3670016);
        int r27 = r1 << 3;
        int r111 = ((r25 | (29360128 & r27)) | (r27 & 234881024)) | (r1 & 1879048192);
        Composer r28 = r12;
        m3265ScrollableTabRowImplxam5sdo(r29, r6, r19, r21, r23, r26, r110, r24, r17, r40, r12, r111);
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
    L164:
        final Modifier r33 = r6;
        final ScrollState r35 = r110;
        final long r44 = r19;
        final long r45 = r21;
        final float r46 = r23;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> r47 = r24;
        final Function2<? super Composer, ? super Integer, Unit> r112 = r17;
        final float r113 = r26;
    L166:
        ScopeUpdateScope r114 = r28.endRestartGroup();
        if (r114 == null) goto L170;
        r114.updateScope(new rs(r29, r33, r35, r44, r45, r46, r47, r112, r113, r40, r42, r43));
        return;
    L170:
        return;
    L156:
        r26 = r39;
        goto L157
    L153:
        r17 = r38;
        goto L154
    L150:
        r16 = r37;
        goto L151
    L147:
        r15 = r10;
        goto L148
    L144:
        r14 = r8;
        goto L145
    L140:
        r18 = r32;
        goto L142
    L136:
        r13 = r31;
        goto L138
    L132:
        r6 = r30;
        goto L134
    L118:
        if (r12.getDefaultsInvalid() == true) goto L130;
        r12.skipToGroupEnd();
        if ((r43 & 4) == 0) goto L124;
        r1 = r1 & (-897);
    L124:
        if ((r43 & 8) == 0) goto L127;
        r1 = r1 & (-7169);
    L127:
        if ((r43 & 16) == 0) goto L129;
        r1 = r1 & (-57345);
    L129:
        r6 = r30;
        r110 = r31;
        r19 = r32;
        r24 = r37;
        r17 = r38;
        r26 = r39;
        r21 = r8;
        r23 = r10;
        goto L158
    L165:
        r28 = r12;
        r28.skipToGroupEnd();
        r33 = r30;
        r35 = r31;
        r44 = r32;
        r47 = r37;
        r113 = r39;
        r45 = r8;
        r46 = r10;
        r112 = r38;
        goto L166
    L112:
        r4 = false;
        goto L114
    L102:
        if ((r42 & 805306368) != 0) goto L110;
        if (r12.changedInstance(r40) == false) goto L106;
        int r115 = 536870912;
    L107:
        r1 = r1 | r115;
        goto L110
    L106:
        r115 = 268435456;
        goto L107
    L92:
        if ((r42 & 100663296) != 0) goto L99;
        if (r12.changed(r39) == false) goto L96;
        int r116 = 67108864;
    L97:
        r1 = r1 | r116;
        goto L99
    L96:
        r116 = 33554432;
        goto L97
    L82:
        if ((r42 & 12582912) != 0) goto L88;
        if (r12.changedInstance(r38) == false) goto L86;
        int r117 = 8388608;
    L87:
        r1 = r1 | r117;
        goto L88
    L86:
        r117 = 4194304;
        goto L87
    L72:
        if ((r42 & 1572864) != 0) goto L78;
        if (r12.changedInstance(r37) == false) goto L76;
        int r118 = 1048576;
    L77:
        r1 = r1 | r118;
        goto L78
    L76:
        r118 = 524288;
        goto L77
    L61:
        if ((196608 & r42) != 0) goto L67;
        r10 = r36;
        if (r12.changed(r10) == false) goto L65;
        int r119 = 131072;
    L66:
        r1 = r1 | r119;
        goto L68
    L65:
        r119 = 65536;
        goto L66
    L49:
        if ((r43 & 16) != 0) goto L53;
        r8 = r34;
        if (r12.changed(r8) == false) goto L54;
        int r48 = 16384;
    L55:
        r1 = r1 | r48;
    L54:
        r48 = 8192;
        goto L55
    L53:
        r8 = r34;
        goto L54
    L17:
        if ((r42 & 48) != 0) goto L25;
        if (r12.changed(r30) == false) goto L21;
        int r49 = 32;
    L22:
        r1 = r1 | r49;
        goto L25
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r1 = r42;
        goto L13
    L8:
        if (r12.changed(r29) == false) goto L10;
        int r50 = 4;
    L11:
        r1 = r50 | r42;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }
}
