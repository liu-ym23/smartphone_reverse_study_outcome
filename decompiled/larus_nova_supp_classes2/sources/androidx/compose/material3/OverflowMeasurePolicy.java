package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00020\r*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/OverflowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/material3/AppBarOverflowState;", "maxItemCount", "", "isVertical", "", "<init>", "(Landroidx/compose/material3/AppBarOverflowState;IZ)V", "getMaxItemCount", "()I", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OverflowMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable = 0;
    private final boolean isVertical;
    private final int maxItemCount;
    private final AppBarOverflowState overflowState;

    public static /* synthetic */ Unit a(List r0, List r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(List r0, List r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$14(r0, r1, r2);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public final int getMaxItemCount() {
        return this.maxItemCount;
    }

    public OverflowMeasurePolicy(AppBarOverflowState r1, int r2, boolean r3) {
        this.overflowState = r1;
        this.maxItemCount = r2;
        this.isVertical = r3;
    }

    private static final Unit measure_3p2s80s$lambda$11(List r12, List r13, Placeable.PlacementScope r14) {
        int r0 = r12.size();
        int r1 = 0;
        int r2 = 0;
        int r10 = 0;
    L3:
        if (r2 >= r0) goto L5;
        Placeable r11 = (Placeable) ListProtector.get(r12, r2);
        Placeable.PlacementScope.placeRelative$default(r14, r11, 0, r10, MenuKt.ClosedAlphaTarget, 4, null);
        r10 = r10 + r11.getHeight();
        r2 = r2 + 1;
        goto L3
    L5:
        if (r13 == null) goto L10;
        int r15 = r13.size();
    L7:
        if (r1 >= r15) goto L10;
        Placeable.PlacementScope.placeRelative$default(r14, (Placeable) ListProtector.get(r13, r1), 0, r10, MenuKt.ClosedAlphaTarget, 4, null);
        r1 = r1 + 1;
    L10:
        return Unit.INSTANCE;
    }

    private static final Unit measure_3p2s80s$lambda$14(List r12, List r13, Placeable.PlacementScope r14) {
        int r0 = r12.size();
        int r1 = 0;
        int r2 = 0;
        int r10 = 0;
    L3:
        if (r2 >= r0) goto L5;
        Placeable r11 = (Placeable) ListProtector.get(r12, r2);
        Placeable.PlacementScope.placeRelative$default(r14, r11, r10, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r10 = r10 + r11.getWidth();
        r2 = r2 + 1;
        goto L3
    L5:
        if (r13 == null) goto L10;
        int r15 = r13.size();
    L7:
        if (r1 >= r15) goto L10;
        Placeable.PlacementScope.placeRelative$default(r14, (Placeable) ListProtector.get(r13, r1), r10, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r1 = r1 + 1;
    L10:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2980measure3p2s80s(MeasureScope r22, List<? extends List<? extends Measurable>> r23, long r24) {
        long r12 = Constraints.copy-Zbe2FdA$default(r24, 0, 0, 0, 0, 10, null);
        List r3 = (List) ListProtector.get(r23, 0);
        int r4 = 1;
        List r1 = (List) ListProtector.get(r23, 1);
        this.overflowState.setTotalItemCount(r3.size());
        if (this.isVertical == false) goto L19;
        if (r1.isEmpty() == false) goto L7;
        Integer r5 = null;
    L15:
        Integer r6 = r5;
        if (r6 == null) goto L32;
        int r7 = r6.intValue();
    L34:
        if (this.isVertical == false) goto L36;
        int r8 = Constraints.getMaxHeight-impl(r24);
    L37:
        int r9 = LayoutUtilKt.subtractConstraintSafely(r8, r7);
        final ArrayList r10 = new ArrayList();
        int r11 = r3.size();
        int r14 = 0;
        int r20 = 0;
    L38:
        if (r14 >= r11) goto L60;
        Placeable r15 = ((Measurable) ListProtector.get(r3, r14)).measure-BRTryo0(r12);
        if (r14 != CollectionsKt.getLastIndex(r3)) goto L42;
        boolean r13 = true;
    L43:
        if (r13 == true) goto L48;
        if (r14 == (this.maxItemCount - 1)) goto L60;
    L48:
        if (this.isVertical == false) goto L50;
        int r2 = r15.getHeight();
    L51:
        if (r2 <= r9) goto L57;
        if (r13 == true) goto L54;
    L56:
        boolean r16 = false;
    L58:
        if (r16 == false) goto L60;
        r10.add(r15);
        r20 = r20 + r2;
        r9 = LayoutUtilKt.subtractConstraintSafely(r9, r2);
        r14 = r14 + 1;
        goto L38
    L54:
        if (r2 > (r9 + r7)) goto L56;
    L57:
        r16 = true;
        goto L58
    L50:
        r2 = r15.getWidth();
        goto L51
    L42:
        r13 = false;
    L60:
        this.overflowState.setVisibleItemCount(r10.size());
        if (r10.size() != r3.size()) goto L63;
        final ArrayList r17 = null;
    L71:
        if (this.isVertical == false) goto L87;
        if (r17 != null) goto L74;
    L102:
        int r18 = 0;
    L103:
        int r19 = r20 + r18;
        if (this.isVertical == false) goto L138;
        if (r10.isEmpty() == false) goto L108;
        Integer r21 = null;
    L116:
        Integer r25 = r21;
        if (r25 == null) goto L119;
        int r26 = r25.intValue();
    L120:
        if (r17 != null) goto L122;
    L135:
        int r27 = 0;
    L136:
        int r28 = Math.max(r26, r27);
    L169:
        if (this.isVertical == false) goto L172;
        return MeasureScope.-CC.layout$default(r22, ConstraintsKt.constrainWidth-K40F9xA(r24, r28), ConstraintsKt.constrainHeight-K40F9xA(r24, r19), null, new kj(r10, r17), 4, null);
    L172:
        return MeasureScope.-CC.layout$default(r22, ConstraintsKt.constrainWidth-K40F9xA(r24, r19), ConstraintsKt.constrainHeight-K40F9xA(r24, r28), null, new lj(r10, r17), 4, null);
    L122:
        if (r17.isEmpty() == false) goto L124;
        Integer r29 = null;
    L132:
        Integer r30 = r29;
        if (r30 == null) goto L135;
        r27 = r30.intValue();
        goto L136
    L124:
        Integer r31 = Integer.valueOf(((Placeable) ListProtector.get(r17, 0)).getWidth());
        int r32 = CollectionsKt.getLastIndex(r17);
        if (1 > r32) goto L131;
    L126:
        Integer r33 = Integer.valueOf(((Placeable) ListProtector.get(r17, r4)).getWidth());
        if (r33.compareTo(r31) <= 0) goto L129;
        r31 = r33;
    L129:
        if (r4 == r32) goto L131;
        r4 = r4 + 1;
    L131:
        r29 = r31;
        goto L132
    L119:
        r26 = 0;
        goto L120
    L108:
        r21 = Integer.valueOf(((Placeable) ListProtector.get(r10, 0)).getWidth());
        int r34 = CollectionsKt.getLastIndex(r10);
        if (1 > r34) goto L116;
        int r35 = 1;
    L111:
        Integer r36 = Integer.valueOf(((Placeable) ListProtector.get(r10, r35)).getWidth());
        if (r36.compareTo(r21) <= 0) goto L114;
        r21 = r36;
    L114:
        if (r35 == r34) goto L116;
        r35 = r35 + 1;
        goto L111
    L138:
        if (r10.isEmpty() == false) goto L140;
        Integer r37 = null;
    L148:
        Integer r38 = r37;
        if (r38 == null) goto L151;
        int r39 = r38.intValue();
    L152:
        if (r17 != null) goto L154;
        int r40 = 0;
    L167:
        r28 = Math.max(r39, r40);
        goto L169
    L154:
        if (r17.isEmpty() == false) goto L156;
        r40 = 0;
        Integer r41 = null;
    L163:
        Integer r42 = r41;
        if (r42 == null) goto L167;
        r40 = r42.intValue();
        goto L167
    L156:
        r40 = 0;
        r41 = Integer.valueOf(((Placeable) ListProtector.get(r17, 0)).getHeight());
        int r43 = CollectionsKt.getLastIndex(r17);
        if (1 > r43) goto L163;
    L158:
        Integer r44 = Integer.valueOf(((Placeable) ListProtector.get(r17, r4)).getHeight());
        if (r44.compareTo(r41) <= 0) goto L161;
        r41 = r44;
    L161:
        if (r4 == r43) goto L163;
        r4 = r4 + 1;
        goto L158
    L151:
        r39 = 0;
        goto L152
    L140:
        r37 = Integer.valueOf(((Placeable) ListProtector.get(r10, 0)).getHeight());
        int r45 = CollectionsKt.getLastIndex(r10);
        if (1 > r45) goto L148;
        int r46 = 1;
    L143:
        Integer r47 = Integer.valueOf(((Placeable) ListProtector.get(r10, r46)).getHeight());
        if (r47.compareTo(r37) <= 0) goto L146;
        r37 = r47;
    L146:
        if (r46 == r45) goto L148;
        r46 = r46 + 1;
        goto L143
    L74:
        if (r17.isEmpty() == false) goto L76;
        Integer r48 = null;
    L84:
        Integer r49 = r48;
        if (r49 == null) goto L102;
        r18 = r49.intValue();
        goto L103
    L76:
        r48 = Integer.valueOf(((Placeable) ListProtector.get(r17, 0)).getHeight());
        int r50 = CollectionsKt.getLastIndex(r17);
        if (1 > r50) goto L84;
        int r51 = 1;
    L79:
        Integer r52 = Integer.valueOf(((Placeable) ListProtector.get(r17, r51)).getHeight());
        if (r52.compareTo(r48) <= 0) goto L82;
        r48 = r52;
    L82:
        if (r51 == r50) goto L84;
        r51 = r51 + 1;
        goto L79
    L87:
        if (r17 == null) goto L102;
        if (r17.isEmpty() == false) goto L91;
        Integer r53 = null;
    L99:
        Integer r54 = r53;
        if (r54 == null) goto L102;
        r18 = r54.intValue();
        goto L103
    L91:
        r53 = Integer.valueOf(((Placeable) ListProtector.get(r17, 0)).getWidth());
        int r55 = CollectionsKt.getLastIndex(r17);
        if (1 > r55) goto L99;
        int r56 = 1;
    L94:
        Integer r57 = Integer.valueOf(((Placeable) ListProtector.get(r17, r56)).getWidth());
        if (r57.compareTo(r53) <= 0) goto L97;
        r53 = r57;
    L97:
        if (r56 == r55) goto L99;
        r56 = r56 + 1;
        goto L94
    L63:
        if (this.isVertical == false) goto L65;
        long r58 = Constraints.copy-Zbe2FdA$default(r12, 0, 0, 0, r9 + r7, 7, null);
    L66:
        r17 = new ArrayList(r1.size());
        int r59 = r1.size();
        int r60 = 0;
    L67:
        if (r60 >= r59) goto L71;
        r17.add(((Measurable) ListProtector.get(r1, r60)).measure-BRTryo0(r58));
        r60 = r60 + 1;
        goto L67
    L65:
        r58 = Constraints.copy-Zbe2FdA$default(r12, 0, r9 + r7, 0, 0, 13, null);
        goto L66
    L36:
        r8 = Constraints.getMaxWidth-impl(r24);
    L32:
        r7 = 0;
        goto L34
    L7:
        r5 = Integer.valueOf(((Measurable) ListProtector.get(r1, 0)).maxIntrinsicHeight(Constraints.getMaxWidth-impl(r24)));
        int r61 = CollectionsKt.getLastIndex(r1);
        if (1 > r61) goto L15;
        int r62 = 1;
    L10:
        Integer r63 = Integer.valueOf(((Measurable) ListProtector.get(r1, r62)).maxIntrinsicHeight(Constraints.getMaxWidth-impl(r24)));
        if (r63.compareTo(r5) <= 0) goto L13;
        r5 = r63;
    L13:
        if (r62 == r61) goto L15;
        r62 = r62 + 1;
        goto L10
    L19:
        if (r1.isEmpty() == false) goto L21;
        Integer r64 = null;
    L29:
        Integer r65 = r64;
        if (r65 == null) goto L32;
        r7 = r65.intValue();
        goto L34
    L21:
        r64 = Integer.valueOf(((Measurable) ListProtector.get(r1, 0)).maxIntrinsicWidth(Constraints.getMaxHeight-impl(r24)));
        int r66 = CollectionsKt.getLastIndex(r1);
        if (1 > r66) goto L29;
        int r67 = 1;
    L24:
        Integer r68 = Integer.valueOf(((Measurable) ListProtector.get(r1, r67)).maxIntrinsicWidth(Constraints.getMaxHeight-impl(r24)));
        if (r68.compareTo(r64) <= 0) goto L27;
        r64 = r68;
    L27:
        if (r67 == r66) goto L29;
        r67 = r67 + 1;
        goto L24
    }

    public /* synthetic */ OverflowMeasurePolicy(AppBarOverflowState r1, int r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }
}
