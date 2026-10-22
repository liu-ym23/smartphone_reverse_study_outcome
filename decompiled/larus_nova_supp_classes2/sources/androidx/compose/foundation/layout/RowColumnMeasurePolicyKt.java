package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RowColumnMeasurePolicyKt {
    public static final MeasureResult measure(RowColumnMeasurePolicy r34, int r35, int r36, int r37, int r38, int r39, MeasureScope r40, List<? extends Measurable> r41, Placeable[] r42, int r43, int r44, int[] r45, int r46) {
        long r14 = r39;
        int r7 = r44 - r43;
        int[] r6 = new int[r7];
        int r4 = r43;
        int r0 = 0;
        int r3 = 0;
        int r17 = 0;
        boolean r18 = false;
        int r19 = 0;
        float r20 = MenuKt.ClosedAlphaTarget;
    L3:
        Integer r21 = null;
        if (r4 >= r44) goto L42;
        Measurable r1 = (Measurable) ListProtector.get(r41, r4);
        RowColumnParentData r23 = RowColumnImplKt.getRowColumnParentData(r1);
        float r24 = RowColumnImplKt.getWeight(r23);
        if (r18 == false) goto L8;
    L11:
        r18 = true;
    L13:
        if (r24 <= MenuKt.ClosedAlphaTarget) goto L15;
        r20 = r20 + r24;
        r17 = r17 + 1;
        r4 = r4;
        r7 = r7;
    L41:
        r4 = r4 + 1;
        r7 = r7;
        goto L3
    L15:
        if (r38 == Integer.MAX_VALUE) goto L21;
        if (r23 == null) goto L21;
        FlowLayoutData r2 = r23.getFlowLayoutData();
        if (r2 == null) goto L21;
        r21 = Integer.valueOf(Math.round(r2.getFillCrossAxisFraction() * r38));
    L21:
        int r22 = r37 - r19;
        Placeable r5 = r42[r4];
        if (r5 != null) goto L37;
        if (r21 == null) goto L26;
        int r25 = r21.intValue();
    L27:
        if (r37 != Integer.MAX_VALUE) goto L29;
        int r26 = Integer.MAX_VALUE;
    L32:
        if (r21 == null) goto L34;
        int r27 = r21.intValue();
    L35:
        r5 = r1.measure-BRTryo0(RowColumnMeasurePolicy.CC.m992createConstraintsxF2OJ5Q$default(r34, 0, r25, r26, r27, false, 16, null));
        goto L37
    L34:
        r27 = r38;
        goto L35
    L29:
        if (r22 >= 0) goto L31;
        r26 = 0;
        goto L32
    L31:
        r26 = r22;
        goto L32
    L26:
        r25 = 0;
    L37:
        int r8 = r34.mainAxisSize(r5);
        int r9 = r34.crossAxisSize(r5);
        r6 = r6;
        r6[r4 - r43] = r8;
        int r10 = r22 - r8;
        if (r10 >= 0) goto L40;
        r10 = 0;
    L40:
        int r11 = Math.min(r39, r10);
        r19 = r19 + (r8 + r11);
        int r12 = Math.max(r3, r9);
        r42[r4] = r5;
        r0 = r11;
        r3 = r12;
        goto L41
    L8:
        if (RowColumnImplKt.isRelative(r23) == true) goto L11;
        r18 = false;
        goto L13
    L42:
        int r13 = r3;
        int r32 = r7;
        if (r17 != 0) goto L45;
        r19 = r19 - r0;
        int r15 = r13;
        int r16 = 0;
    L91:
        if (r18 == false) goto L110;
        int r28 = r43;
        int r29 = 0;
        int r30 = 0;
    L93:
        if (r28 >= r44) goto L109;
        Placeable r31 = r42[r28];
        Intrinsics.checkNotNull(r31);
        CrossAxisAlignment r33 = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(r31));
        if (r33 == null) goto L97;
        Integer r47 = r33.calculateAlignmentLinePosition$foundation_layout(r31);
    L98:
        if (r47 == null) goto L108;
        int r48 = r47.intValue();
        int r49 = r34.crossAxisSize(r31);
        if (r48 == Integer.MIN_VALUE) goto L102;
        int r50 = r47.intValue();
    L103:
        r29 = Math.max(r29, r50);
        if (r48 != Integer.MIN_VALUE) goto L107;
        r48 = r49;
    L107:
        r30 = Math.max(r30, r49 - r48);
        goto L108
    L102:
        r50 = 0;
    L108:
        r28 = r28 + 1;
        goto L93
    L97:
        r47 = null;
        goto L98
    L109:
        int r51 = r29;
    L111:
        int r52 = r19 + r16;
        if (r52 >= 0) goto L114;
        r52 = 0;
    L114:
        int r53 = Math.max(r52, r35);
        int r54 = Math.max(r15, Math.max(r36, r30 + r51));
        int[] r55 = new int[r32];
        r34.populateMainAxisPositions(r53, r6, r55, r40);
        return r34.placeHelper(r42, r40, r51, r55, r53, r54, r45, r46, r43, r44);
    L110:
        r30 = 0;
        r51 = 0;
        goto L111
    L45:
        if (r37 == Integer.MAX_VALUE) goto L47;
        int r56 = r37;
    L48:
        long r110 = r14 * ((long) (r17 - 1));
        long r57 = ((long) (r56 - r19)) - r110;
        if (r57 >= 0) goto L51;
        r57 = 0;
    L51:
        float r58 = r57 / r20;
        int r59 = r43;
    L52:
        if (r59 >= r44) goto L54;
        r57 = r57 - ((long) Math.round(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((Measurable) ListProtector.get(r41, r59))) * r58));
        r59 = r59 + 1;
        goto L52
    L54:
        int r60 = r43;
        int r61 = 0;
    L55:
        if (r60 >= r44) goto L85;
        if (r42[r60] != null) goto L83;
        Measurable r62 = (Measurable) ListProtector.get(r41, r60);
        RowColumnParentData r111 = RowColumnImplKt.getRowColumnParentData(r62);
        float r210 = RowColumnImplKt.getWeight(r111);
        if (r38 != Integer.MAX_VALUE) goto L61;
    L60:
        Integer r112 = null;
    L66:
        if (r210 <= MenuKt.ClosedAlphaTarget) goto L68;
        boolean r211 = true;
    L69:
        if (r211 == true) goto L71;
        InlineClassHelperKt.throwIllegalStateException("All weights <= 0 should have placeables");
    L71:
        int r63 = MathKt.getSign(r57);
        int r212 = r60;
        int r213 = r61;
        long r214 = r57 - ((long) r63);
        int r64 = Math.max(0, Math.round(r210 * r58) + r63);
        if (RowColumnImplKt.getFill(r111) == false) goto L75;
        if (r64 == Integer.MAX_VALUE) goto L75;
        int r65 = r64;
    L76:
        if (r112 == null) goto L78;
        int r113 = r112.intValue();
    L79:
        if (r112 == null) goto L81;
        int r114 = r112.intValue();
    L82:
        int r66 = r113;
        int r115 = r212;
        Placeable r67 = r62.measure-BRTryo0(r34.mo846createConstraintsxF2OJ5Q(r65, r66, r64, r114, true));
        int r68 = r34.mainAxisSize(r67);
        int r69 = r34.crossAxisSize(r67);
        r6[r115 - r43] = r68;
        r61 = r213 + r68;
        int r70 = Math.max(r13, r69);
        r42[r115] = r67;
        r13 = r70;
        r57 = r214;
    L84:
        r60 = r115 + 1;
        r58 = r58;
        goto L55
    L81:
        r114 = r38;
        goto L82
    L78:
        r113 = 0;
    L75:
        r65 = 0;
        goto L76
    L68:
        r211 = false;
        goto L69
    L61:
        if (r111 == null) goto L60;
        FlowLayoutData r215 = r111.getFlowLayoutData();
        if (r215 == null) goto L60;
        r112 = Integer.valueOf(Math.round(r215.getFillCrossAxisFraction() * r38));
        goto L66
    L83:
        r115 = r60;
        goto L84
    L85:
        int r116 = r13;
        r16 = (int) (((long) r61) + r110);
        int r71 = r37 - r19;
        if (r16 >= 0) goto L88;
        r16 = 0;
    L88:
        if (r16 <= r71) goto L90;
        r16 = r71;
    L90:
        r15 = r116;
        goto L91
    L47:
        r56 = r35;
        goto L48
    }

    public static /* synthetic */ MeasureResult measure$default(RowColumnMeasurePolicy r15, int r16, int r17, int r18, int r19, int r20, MeasureScope r21, List r22, Placeable[] r23, int r24, int r25, int[] r26, int r27, int r28, Object r29) {
        if ((r28 & 1024) == 0) goto L5;
        int[] r13 = null;
    L7:
        if ((r28 & 2048) == 0) goto L9;
        int r14 = 0;
    L11:
        return measure(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r13, r14);
    L9:
        r14 = r27;
        goto L11
    L5:
        r13 = r26;
        goto L7
    }
}
