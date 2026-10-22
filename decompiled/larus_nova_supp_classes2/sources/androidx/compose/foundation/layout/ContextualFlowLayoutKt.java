package androidx.compose.foundation.layout;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a\u008e\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u001d21\u0010\u0010\u001a-\u0012\u0004\u0012\u00020\u001e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001f\u001a\u00ad\u0001\u0010 \u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010-\u001a\u00ad\u0001\u0010.\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010'\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001a7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"ContextualFlowRow", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualRowMeasurementHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualColumnMeasureHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextualFlowLayoutKt {
    private static final Unit ContextualFlowColumn$lambda$5(int r13, Modifier r14, Arrangement.Vertical r15, Arrangement.Horizontal r16, Alignment.Horizontal r17, int r18, int r19, ContextualFlowColumnOverflow r20, Function4 r21, int r22, int r23, Composer r24, int r25) {
        ContextualFlowColumn(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit ContextualFlowRow$lambda$2(int r13, Modifier r14, Arrangement.Horizontal r15, Arrangement.Vertical r16, Alignment.Vertical r17, int r18, int r19, ContextualFlowRowOverflow r20, Function4 r21, int r22, int r23, Composer r24, int r25) {
        ContextualFlowRow(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(int r0, Modifier r1, Arrangement.Vertical r2, Arrangement.Horizontal r3, Alignment.Horizontal r4, int r5, int r6, ContextualFlowColumnOverflow r7, Function4 r8, int r9, int r10, Composer r11, int r12) {
        return ContextualFlowColumn$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit b(int r0, Modifier r1, Arrangement.Horizontal r2, Arrangement.Vertical r3, Alignment.Vertical r4, int r5, int r6, ContextualFlowRowOverflow r7, Function4 r8, int r9, int r10, Composer r11, int r12) {
        return ContextualFlowRow$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualColumnMeasureHelper(Arrangement.Vertical r21, Arrangement.Horizontal r22, Alignment.Horizontal r23, int r24, int r25, FlowLayoutOverflowState r26, int r27, List<? extends Function2<? super Composer, ? super Integer, Unit>> r28, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> r29, Composer r30, int r31) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-676633639, r31, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:424)");
    L5:
        boolean r5 = false;
        if (((r31 & 14) ^ 6) <= 4) goto L12;
        if (r30.changed(r21) == false) goto L12;
    L13:
        boolean r4 = true;
    L16:
        if (((r31 & 112) ^ 48) <= 32) goto L20;
        if (r30.changed(r22) == false) goto L20;
    L21:
        boolean r7 = true;
    L23:
        boolean r6 = r4 | r7;
        if (((r31 & 896) ^ 384) <= 256) goto L28;
        if (r30.changed(r23) == false) goto L28;
    L29:
        boolean r8 = true;
    L31:
        boolean r9 = r6 | r8;
        if (((r31 & 7168) ^ 3072) <= 2048) goto L36;
        if (r30.changed(r24) == false) goto L36;
    L37:
        boolean r10 = true;
    L39:
        boolean r11 = r9 | r10;
        if (((57344 & r31) ^ 24576) <= 16384) goto L44;
        if (r30.changed(r25) == false) goto L44;
    L45:
        boolean r12 = true;
    L47:
        boolean r13 = (r11 | r12) | r30.changed(r26);
        if (((3670016 & r31) ^ 1572864) <= 1048576) goto L52;
        if (r30.changed(r27) == false) goto L52;
    L53:
        boolean r14 = true;
    L55:
        boolean r15 = r13 | r14;
        if (((234881024 & r31) ^ 100663296) <= 67108864) goto L60;
        if (r30.changed(r29) == false) goto L60;
    L61:
        r5 = true;
    L62:
        boolean r2 = r15 | r5;
        Object r16 = r30.rememberedValue();
        if (r2 == false) goto L65;
    L66:
        r16 = new FlowMeasureLazyPolicy(false, r22, r21, r21.mo812getSpacingD9Ej5fM(), CrossAxisAlignment.Companion.horizontal$foundation_layout(r23), r22.mo812getSpacingD9Ej5fM(), r27, r25, r24, r26, r28, r29, null).getMeasurePolicy();
        r30.updateRememberedValue(r16);
    L67:
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> r17 = (Function2) r16;
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventEnd();
    L70:
        return r17;
    L65:
        if (r16 != Composer.Companion.getEmpty()) goto L67;
    L60:
        if ((r31 & 100663296) != 67108864) goto L62;
    L52:
        if ((r31 & 1572864) == 1048576) goto L53;
        r14 = false;
    L44:
        if ((r31 & 24576) == 16384) goto L45;
        r12 = false;
    L36:
        if ((r31 & 3072) == 2048) goto L37;
        r10 = false;
    L28:
        if ((r31 & 384) == 256) goto L29;
        r8 = false;
    L20:
        if ((r31 & 48) == 32) goto L21;
        r7 = false;
    L12:
        if ((r31 & 6) == 4) goto L13;
        r4 = false;
        goto L16
    }

    public static final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> contextualRowMeasurementHelper(Arrangement.Horizontal r21, Arrangement.Vertical r22, Alignment.Vertical r23, int r24, int r25, FlowLayoutOverflowState r26, int r27, List<? extends Function2<? super Composer, ? super Integer, Unit>> r28, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> r29, Composer r30, int r31) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(962906403, r31, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:384)");
    L5:
        boolean r5 = false;
        if (((r31 & 14) ^ 6) <= 4) goto L12;
        if (r30.changed(r21) == false) goto L12;
    L13:
        boolean r4 = true;
    L16:
        if (((r31 & 112) ^ 48) <= 32) goto L20;
        if (r30.changed(r22) == false) goto L20;
    L21:
        boolean r7 = true;
    L23:
        boolean r6 = r4 | r7;
        if (((r31 & 896) ^ 384) <= 256) goto L28;
        if (r30.changed(r23) == false) goto L28;
    L29:
        boolean r8 = true;
    L31:
        boolean r9 = r6 | r8;
        if (((r31 & 7168) ^ 3072) <= 2048) goto L36;
        if (r30.changed(r24) == false) goto L36;
    L37:
        boolean r10 = true;
    L39:
        boolean r11 = r9 | r10;
        if (((57344 & r31) ^ 24576) <= 16384) goto L44;
        if (r30.changed(r25) == false) goto L44;
    L45:
        boolean r12 = true;
    L47:
        boolean r13 = (r11 | r12) | r30.changed(r26);
        if (((3670016 & r31) ^ 1572864) <= 1048576) goto L52;
        if (r30.changed(r27) == false) goto L52;
    L53:
        boolean r14 = true;
    L55:
        boolean r15 = r13 | r14;
        if (((234881024 & r31) ^ 100663296) <= 67108864) goto L60;
        if (r30.changed(r29) == false) goto L60;
    L61:
        r5 = true;
    L62:
        boolean r2 = r15 | r5;
        Object r16 = r30.rememberedValue();
        if (r2 == false) goto L65;
    L66:
        r16 = new FlowMeasureLazyPolicy(true, r21, r22, r21.mo812getSpacingD9Ej5fM(), CrossAxisAlignment.Companion.vertical$foundation_layout(r23), r22.mo812getSpacingD9Ej5fM(), r27, r25, r24, r26, r28, r29, null).getMeasurePolicy();
        r30.updateRememberedValue(r16);
    L67:
        Function2<SubcomposeMeasureScope, Constraints, MeasureResult> r17 = (Function2) r16;
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventEnd();
    L70:
        return r17;
    L65:
        if (r16 != Composer.Companion.getEmpty()) goto L67;
    L60:
        if ((r31 & 100663296) != 67108864) goto L62;
    L52:
        if ((r31 & 1572864) == 1048576) goto L53;
        r14 = false;
    L44:
        if ((r31 & 24576) == 16384) goto L45;
        r12 = false;
    L36:
        if ((r31 & 3072) == 2048) goto L37;
        r10 = false;
    L28:
        if ((r31 & 384) == 256) goto L29;
        r8 = false;
    L20:
        if ((r31 & 48) == 32) goto L21;
        r7 = false;
    L12:
        if ((r31 & 6) == 4) goto L13;
        r4 = false;
        goto L16
    }

    @Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    public static final void ContextualFlowColumn(final int r24, Modifier r25, Arrangement.Vertical r26, Arrangement.Horizontal r27, Alignment.Horizontal r28, int r29, int r30, ContextualFlowColumnOverflow r31, final Function4<? super ContextualFlowColumnScope, ? super Integer, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r1 = r33.startRestartGroup(1986851536);
        if ((r35 & 1) == 0) goto L6;
        int r3 = r34 | 6;
    L13:
        int r4 = r35 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r35 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r8 = r35 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Arrangement.Horizontal r12 = r27;
    L46:
        int r13 = r35 & 16;
        if (r13 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Alignment.Horizontal r14 = r28;
    L57:
        int r15 = r35 & 32;
        if (r15 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r17 = r35 & 64;
        if (r17 == 0) goto L71;
        r3 = r3 | 1572864;
    L77:
        int r0 = r35 & 128;
        if (r0 == 0) goto L81;
        r3 = r3 | 12582912;
    L88:
        if ((r35 & 256) == 0) goto L91;
        r3 = r3 | 100663296;
    L98:
        if ((38347923 & r3) == 38347922) goto L100;
        boolean r2 = true;
    L102:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L150;
        if (r4 == 0) goto L105;
        final Modifier r5 = Modifier.Companion;
    L106:
        if (r6 == 0) goto L108;
        Arrangement.Vertical r7 = Arrangement.INSTANCE.getTop();
    L109:
        if (r8 == 0) goto L111;
        Arrangement.Horizontal r9 = Arrangement.INSTANCE.getStart();
    L112:
        if (r13 == 0) goto L114;
        Alignment.Horizontal r10 = Alignment.Companion.getStart();
    L115:
        int r11 = Integer.MAX_VALUE;
        if (r15 == 0) goto L118;
        int r23 = Integer.MAX_VALUE;
    L119:
        if (r17 != 0) goto L122;
        r11 = r30;
    L122:
        if (r0 == 0) goto L124;
        ContextualFlowColumnOverflow r16 = ContextualFlowColumnOverflow.Companion.getClip();
    L126:
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventStart(1986851536, r3, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:154)");
    L128:
        int r18 = 29360128 & r3;
        if (r18 != 8388608) goto L131;
        boolean r19 = true;
    L132:
        Object r110 = r1.rememberedValue();
        if (r19 == false) goto L135;
    L136:
        r110 = r16.createOverflowState$foundation_layout();
        r1.updateRememberedValue(r110);
    L137:
        FlowLayoutOverflowState r111 = (FlowLayoutOverflowState) r110;
        if (r18 != 8388608) goto L140;
        boolean r112 = true;
    L141:
        Object r113 = r1.rememberedValue();
        if (r112 == true) goto L145;
        Object r114 = r113;
        if (r113 == Composer.Companion.getEmpty()) goto L145;
    L146:
        List r115 = (List) r114;
        ComposableLambda r20 = ComposableLambdaKt.rememberComposableLambda(620176540, true, new ContextualFlowLayoutKt$ContextualFlowColumn$measurePolicy$1(r32), r1, 54);
        int r21 = r3 >> 6;
        int r116 = ((((r21 & 14) | 100663296) | (r21 & 112)) | (r21 & 896)) | (r21 & 7168);
        int r22 = ((r21 & 57344) | r116) | ((r3 << 18) & 3670016);
        SubcomposeLayoutKt.SubcomposeLayout(r5, contextualColumnMeasureHelper(r7, r9, r10, r23, r11, r111, r24, r115, r20, r1, r22), r1, (r3 >> 3) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L149;
        ComposerKt.traceEventEnd();
    L149:
        final Arrangement.Vertical r36 = r7;
        final Arrangement.Horizontal r37 = r9;
        final Alignment.Horizontal r38 = r10;
        final int r39 = r11;
        final int r40 = r23;
        final ContextualFlowColumnOverflow r41 = r16;
    L151:
        ScopeUpdateScope r117 = r1.endRestartGroup();
        if (r117 == null) goto L155;
        r117.updateScope(new w(r24, r5, r36, r37, r38, r40, r39, r41, r32, r34, r35));
        return;
    L155:
        return;
    L145:
        ArrayList r118 = new ArrayList();
        r16.addOverflowComposables$foundation_layout(r111, r118);
        r1.updateRememberedValue(r118);
        r114 = r118;
        goto L146
    L140:
        r112 = false;
        goto L141
    L135:
        if (r110 != Composer.Companion.getEmpty()) goto L137;
    L131:
        r19 = false;
        goto L132
    L124:
        r16 = r31;
        goto L126
    L118:
        r23 = r29;
        goto L119
    L114:
        r10 = r14;
        goto L115
    L111:
        r9 = r12;
        goto L112
    L108:
        r7 = r26;
        goto L109
    L105:
        r5 = r25;
        goto L106
    L150:
        r1.skipToGroupEnd();
        r5 = r25;
        r36 = r26;
        r40 = r29;
        r39 = r30;
        r41 = r31;
        r37 = r12;
        r38 = r14;
        goto L151
    L100:
        r2 = false;
        goto L102
    L91:
        if ((r34 & 100663296) != 0) goto L98;
        if (r1.changedInstance(r32) == false) goto L95;
        int r42 = 67108864;
    L96:
        r3 = r3 | r42;
        goto L98
    L95:
        r42 = 33554432;
        goto L96
    L81:
        if ((r34 & 12582912) != 0) goto L88;
        if (r1.changed(r31) == false) goto L85;
        int r119 = 8388608;
    L86:
        r3 = r3 | r119;
        goto L88
    L85:
        r119 = 4194304;
        goto L86
    L71:
        if ((r34 & 1572864) != 0) goto L77;
        if (r1.changed(r30) == false) goto L75;
        int r120 = 1048576;
    L76:
        r3 = r3 | r120;
        goto L77
    L75:
        r120 = 524288;
        goto L76
    L61:
        if ((r34 & 196608) != 0) goto L67;
        if (r1.changed(r29) == false) goto L65;
        int r121 = 131072;
    L66:
        r3 = r3 | r121;
        goto L67
    L65:
        r121 = 65536;
        goto L66
    L50:
        if ((r34 & 24576) != 0) goto L56;
        r14 = r28;
        if (r1.changed(r14) == false) goto L54;
        int r122 = 16384;
    L55:
        r3 = r3 | r122;
        goto L57
    L54:
        r122 = 8192;
        goto L55
    L39:
        if ((r34 & 3072) != 0) goto L45;
        r12 = r27;
        if (r1.changed(r12) == false) goto L43;
        int r123 = 2048;
    L44:
        r3 = r3 | r123;
        goto L46
    L43:
        r123 = 1024;
        goto L44
    L28:
        if ((r34 & 384) != 0) goto L35;
        if (r1.changed(r26) == false) goto L32;
        int r43 = 256;
    L33:
        r3 = r3 | r43;
        goto L35
    L32:
        r43 = 128;
        goto L33
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r1.changed(r25) == false) goto L21;
        int r44 = 32;
    L22:
        r3 = r3 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r3 = r34;
        goto L13
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r45 = 4;
    L11:
        r3 = r45 | r34;
        goto L13
    L10:
        r45 = 2;
        goto L11
    }

    @Deprecated(message = "ContextualFlowLayouts are no longer maintained")
    public static final void ContextualFlowRow(final int r24, Modifier r25, Arrangement.Horizontal r26, Arrangement.Vertical r27, Alignment.Vertical r28, int r29, int r30, ContextualFlowRowOverflow r31, final Function4<? super ContextualFlowRowScope, ? super Integer, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r1 = r33.startRestartGroup(-294153140);
        if ((r35 & 1) == 0) goto L6;
        int r3 = r34 | 6;
    L13:
        int r4 = r35 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r35 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r8 = r35 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Arrangement.Vertical r12 = r27;
    L46:
        int r13 = r35 & 16;
        if (r13 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Alignment.Vertical r14 = r28;
    L57:
        int r15 = r35 & 32;
        if (r15 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        int r17 = r35 & 64;
        if (r17 == 0) goto L71;
        r3 = r3 | 1572864;
    L77:
        int r0 = r35 & 128;
        if (r0 == 0) goto L81;
        r3 = r3 | 12582912;
    L88:
        if ((r35 & 256) == 0) goto L91;
        r3 = r3 | 100663296;
    L98:
        if ((38347923 & r3) == 38347922) goto L100;
        boolean r2 = true;
    L102:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L150;
        if (r4 == 0) goto L105;
        final Modifier r5 = Modifier.Companion;
    L106:
        if (r6 == 0) goto L108;
        Arrangement.Horizontal r7 = Arrangement.INSTANCE.getStart();
    L109:
        if (r8 == 0) goto L111;
        Arrangement.Vertical r9 = Arrangement.INSTANCE.getTop();
    L112:
        if (r13 == 0) goto L114;
        Alignment.Vertical r10 = Alignment.Companion.getTop();
    L115:
        int r11 = Integer.MAX_VALUE;
        if (r15 == 0) goto L118;
        int r23 = Integer.MAX_VALUE;
    L119:
        if (r17 != 0) goto L122;
        r11 = r30;
    L122:
        if (r0 == 0) goto L124;
        ContextualFlowRowOverflow r16 = ContextualFlowRowOverflow.Companion.getClip();
    L126:
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventStart(-294153140, r3, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:79)");
    L128:
        int r18 = 29360128 & r3;
        if (r18 != 8388608) goto L131;
        boolean r19 = true;
    L132:
        Object r110 = r1.rememberedValue();
        if (r19 == false) goto L135;
    L136:
        r110 = r16.createOverflowState$foundation_layout();
        r1.updateRememberedValue(r110);
    L137:
        FlowLayoutOverflowState r111 = (FlowLayoutOverflowState) r110;
        if (r18 != 8388608) goto L140;
        boolean r112 = true;
    L141:
        Object r113 = r1.rememberedValue();
        if (r112 == true) goto L145;
        Object r114 = r113;
        if (r113 == Composer.Companion.getEmpty()) goto L145;
    L146:
        List r115 = (List) r114;
        ComposableLambda r20 = ComposableLambdaKt.rememberComposableLambda(-1677845586, true, new ContextualFlowLayoutKt$ContextualFlowRow$measurePolicy$1(r32), r1, 54);
        int r21 = r3 >> 6;
        int r116 = ((((r21 & 14) | 100663296) | (r21 & 112)) | (r21 & 896)) | (r21 & 7168);
        int r22 = ((r21 & 57344) | r116) | ((r3 << 18) & 3670016);
        SubcomposeLayoutKt.SubcomposeLayout(r5, contextualRowMeasurementHelper(r7, r9, r10, r23, r11, r111, r24, r115, r20, r1, r22), r1, (r3 >> 3) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L149;
        ComposerKt.traceEventEnd();
    L149:
        final Arrangement.Horizontal r36 = r7;
        final Arrangement.Vertical r37 = r9;
        final Alignment.Vertical r38 = r10;
        final int r39 = r11;
        final int r40 = r23;
        final ContextualFlowRowOverflow r41 = r16;
    L151:
        ScopeUpdateScope r117 = r1.endRestartGroup();
        if (r117 == null) goto L155;
        r117.updateScope(new v(r24, r5, r36, r37, r38, r40, r39, r41, r32, r34, r35));
        return;
    L155:
        return;
    L145:
        ArrayList r118 = new ArrayList();
        r16.addOverflowComposables$foundation_layout(r111, r118);
        r1.updateRememberedValue(r118);
        r114 = r118;
        goto L146
    L140:
        r112 = false;
        goto L141
    L135:
        if (r110 != Composer.Companion.getEmpty()) goto L137;
    L131:
        r19 = false;
        goto L132
    L124:
        r16 = r31;
        goto L126
    L118:
        r23 = r29;
        goto L119
    L114:
        r10 = r14;
        goto L115
    L111:
        r9 = r12;
        goto L112
    L108:
        r7 = r26;
        goto L109
    L105:
        r5 = r25;
        goto L106
    L150:
        r1.skipToGroupEnd();
        r5 = r25;
        r36 = r26;
        r40 = r29;
        r39 = r30;
        r41 = r31;
        r37 = r12;
        r38 = r14;
        goto L151
    L100:
        r2 = false;
        goto L102
    L91:
        if ((r34 & 100663296) != 0) goto L98;
        if (r1.changedInstance(r32) == false) goto L95;
        int r42 = 67108864;
    L96:
        r3 = r3 | r42;
        goto L98
    L95:
        r42 = 33554432;
        goto L96
    L81:
        if ((r34 & 12582912) != 0) goto L88;
        if (r1.changed(r31) == false) goto L85;
        int r119 = 8388608;
    L86:
        r3 = r3 | r119;
        goto L88
    L85:
        r119 = 4194304;
        goto L86
    L71:
        if ((r34 & 1572864) != 0) goto L77;
        if (r1.changed(r30) == false) goto L75;
        int r120 = 1048576;
    L76:
        r3 = r3 | r120;
        goto L77
    L75:
        r120 = 524288;
        goto L76
    L61:
        if ((r34 & 196608) != 0) goto L67;
        if (r1.changed(r29) == false) goto L65;
        int r121 = 131072;
    L66:
        r3 = r3 | r121;
        goto L67
    L65:
        r121 = 65536;
        goto L66
    L50:
        if ((r34 & 24576) != 0) goto L56;
        r14 = r28;
        if (r1.changed(r14) == false) goto L54;
        int r122 = 16384;
    L55:
        r3 = r3 | r122;
        goto L57
    L54:
        r122 = 8192;
        goto L55
    L39:
        if ((r34 & 3072) != 0) goto L45;
        r12 = r27;
        if (r1.changed(r12) == false) goto L43;
        int r123 = 2048;
    L44:
        r3 = r3 | r123;
        goto L46
    L43:
        r123 = 1024;
        goto L44
    L28:
        if ((r34 & 384) != 0) goto L35;
        if (r1.changed(r26) == false) goto L32;
        int r43 = 256;
    L33:
        r3 = r3 | r43;
        goto L35
    L32:
        r43 = 128;
        goto L33
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r1.changed(r25) == false) goto L21;
        int r44 = 32;
    L22:
        r3 = r3 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r3 = r34;
        goto L13
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r45 = 4;
    L11:
        r3 = r45 | r34;
        goto L13
    L10:
        r45 = 2;
        goto L11
    }
}
