package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"rememberPagerMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PagerMeasurePolicyKt {
    /* JADX INFO: renamed from: rememberPagerMeasurePolicy-8u0NR3k, reason: not valid java name */
    public static final LazyLayoutMeasurePolicy m1264rememberPagerMeasurePolicy8u0NR3k(Function0<PagerLazyLayoutItemProvider> r21, PagerState r22, PaddingValues r23, boolean r24, Orientation r25, int r26, float r27, PageSize r28, Alignment.Horizontal r29, Alignment.Vertical r30, SnapPosition r31, CoroutineScope r32, Function0<Integer> r33, Composer r34, int r35, int r36) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-1294131537, r35, r36, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:58)");
    L6:
        if (((r35 & 112) ^ 48) <= 32) goto L12;
        if (r34.changed(r22) == false) goto L12;
    L13:
        boolean r4 = true;
    L16:
        if (((r35 & 896) ^ 384) <= 256) goto L20;
        if (r34.changed(r23) == false) goto L20;
    L21:
        boolean r7 = true;
    L23:
        boolean r5 = r4 | r7;
        if (((r35 & 7168) ^ 3072) <= 2048) goto L28;
        if (r34.changed(r24) == false) goto L28;
    L29:
        boolean r8 = true;
    L31:
        boolean r6 = r5 | r8;
        if (((57344 & r35) ^ 24576) <= 16384) goto L36;
        if (r34.changed(r25.ordinal()) == false) goto L36;
    L37:
        boolean r9 = true;
    L39:
        boolean r10 = r6 | r9;
        if (((234881024 & r35) ^ 100663296) <= 67108864) goto L44;
        if (r34.changed(r29) == false) goto L44;
    L45:
        boolean r11 = true;
    L47:
        boolean r12 = r10 | r11;
        if (((1879048192 & r35) ^ 805306368) <= 536870912) goto L52;
        if (r34.changed(r30) == false) goto L52;
    L53:
        boolean r13 = true;
    L55:
        boolean r14 = r12 | r13;
        if (((3670016 & r35) ^ 1572864) <= 1048576) goto L60;
        if (r34.changed(r27) == false) goto L60;
    L61:
        boolean r15 = true;
    L63:
        boolean r16 = r14 | r15;
        if (((29360128 & r35) ^ 12582912) <= 8388608) goto L70;
        if (r34.changed(r28) == false) goto L70;
    L71:
        boolean r17 = true;
    L73:
        boolean r18 = r16 | r17;
        if (((r36 & 14) ^ 6) <= 4) goto L80;
        if (r34.changed(r31) == false) goto L80;
    L81:
        boolean r19 = true;
    L83:
        boolean r20 = r18 | r19;
        if (((r36 & 896) ^ 384) <= 256) goto L90;
        if (r34.changed(r33) == false) goto L90;
    L91:
        boolean r2 = true;
    L93:
        boolean r3 = r2 | r20;
        if (((458752 & r35) ^ 196608) <= 131072) goto L100;
        if (r34.changed(r26) == false) goto L100;
    L101:
        boolean r110 = true;
    L103:
        boolean r1 = (r3 | r110) | r34.changed(r32);
        Object r37 = r34.rememberedValue();
        if (r1 == false) goto L106;
    L107:
        r37 = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(r22, r25, r23, r24, r27, r28, r21, r33, r30, r29, r26, r31, r32);
        r34.updateRememberedValue(r37);
    L108:
        LazyLayoutMeasurePolicy r38 = (LazyLayoutMeasurePolicy) r37;
        if (ComposerKt.isTraceInProgress() == false) goto L111;
        ComposerKt.traceEventEnd();
    L111:
        return r38;
    L106:
        if (r37 != Composer.Companion.getEmpty()) goto L108;
    L100:
        if ((r35 & 196608) == 131072) goto L101;
        r110 = false;
    L90:
        if ((r36 & 384) == 256) goto L91;
        r2 = false;
    L80:
        if ((r36 & 6) == 4) goto L81;
        r19 = false;
    L70:
        if ((12582912 & r35) == 8388608) goto L71;
        r17 = false;
    L60:
        if ((r35 & 1572864) == 1048576) goto L61;
        r15 = false;
    L52:
        if ((r35 & 805306368) == 536870912) goto L53;
        r13 = false;
    L44:
        if ((r35 & 100663296) == 67108864) goto L45;
        r11 = false;
    L36:
        if ((r35 & 24576) == 16384) goto L37;
        r9 = false;
    L28:
        if ((r35 & 3072) == 2048) goto L29;
        r8 = false;
    L20:
        if ((r35 & 384) == 256) goto L21;
        r7 = false;
    L12:
        if ((r35 & 48) == 32) goto L13;
        r4 = false;
        goto L16
    }
}
