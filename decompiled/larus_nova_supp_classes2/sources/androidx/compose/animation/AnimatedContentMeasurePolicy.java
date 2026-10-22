package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\b\u001a\u00020\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\"\u0010\u0017\u001a\u00020\u0013*\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\"\u0010\u0019\u001a\u00020\u0013*\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\"\u0010\u001a\u001a\u00020\u0013*\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentTransitionScopeImpl<?> rootScope;

    public final AnimatedContentTransitionScopeImpl<?> getRootScope() {
        return this.rootScope;
    }

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl<?> r1) {
        this.rootScope = r1;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r6, List<? extends IntrinsicMeasurable> r7, int r8) {
        if (r7.isEmpty() == false) goto L5;
        Integer r9 = null;
    L12:
        Integer r10 = r9;
        if (r10 != null) goto L15;
        return 0;
    L15:
        return r10.intValue();
    L5:
        r9 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, 0)).maxIntrinsicHeight(r8));
        int r1 = CollectionsKt.getLastIndex(r7);
        int r2 = 1;
        if (1 > r1) goto L12;
    L7:
        Integer r3 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, r2)).maxIntrinsicHeight(r8));
        if (r3.compareTo(r9) <= 0) goto L10;
        r9 = r3;
    L10:
        if (r2 == r1) goto L12;
        r2 = r2 + 1;
        goto L7
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r6, List<? extends IntrinsicMeasurable> r7, int r8) {
        if (r7.isEmpty() == false) goto L5;
        Integer r9 = null;
    L12:
        Integer r10 = r9;
        if (r10 != null) goto L15;
        return 0;
    L15:
        return r10.intValue();
    L5:
        r9 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, 0)).maxIntrinsicWidth(r8));
        int r1 = CollectionsKt.getLastIndex(r7);
        int r2 = 1;
        if (1 > r1) goto L12;
    L7:
        Integer r3 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, r2)).maxIntrinsicWidth(r8));
        if (r3.compareTo(r9) <= 0) goto L10;
        r9 = r3;
    L10:
        if (r2 == r1) goto L12;
        r2 = r2 + 1;
        goto L7
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m113measure3p2s80s(MeasureScope r26, List<? extends Measurable> r27, long r28) {
        int r4 = r27.size();
        final Placeable[] r5 = new Placeable[r4];
        long r6 = IntSize.Companion.getZero-YbymL2g();
        List<? extends Measurable> r8 = r27;
        int r9 = r8.size();
        int r11 = 0;
    L3:
        int r15 = 1;
        if (r11 >= r9) goto L17;
        Measurable r10 = (Measurable) ListProtector.get(r27, r11);
        Object r12 = r10.getParentData();
        if ((r12 instanceof AnimatedContentTransitionScopeImpl.ChildData) == false) goto L8;
        AnimatedContentTransitionScopeImpl.ChildData r13 = (AnimatedContentTransitionScopeImpl.ChildData) r12;
    L9:
        if (r13 != null) goto L11;
    L13:
        r15 = 0;
    L14:
        if (r15 == 0) goto L16;
        Placeable r7 = r10.measure-BRTryo0(r28);
        int r14 = r7.getWidth();
        long r16 = IntSize.constructor-impl((((long) r14) << 32) | (((long) r7.getHeight()) & 4294967295L));
        Unit r17 = Unit.INSTANCE;
        r5[r11] = r7;
        r6 = r16;
    L16:
        r11 = r11 + 1;
        goto L3
    L11:
        if (r13.isTarget() != true) goto L13;
    L8:
        r13 = null;
        goto L9
    L17:
        int r18 = r8.size();
        int r19 = 0;
    L18:
        if (r19 >= r18) goto L24;
        Measurable r110 = (Measurable) ListProtector.get(r27, r19);
        if (r5[r19] != null) goto L22;
        r5[r19] = r110.measure-BRTryo0(r28);
    L22:
        r19 = r19 + 1;
        goto L18
    L24:
        if (r26.isLookingAhead() == false) goto L26;
        final int r2 = (int) (r6 >> 32);
    L51:
        if (r26.isLookingAhead() == false) goto L53;
        final int r111 = (int) (r6 & 4294967295L);
    L77:
        if (r26.isLookingAhead() == true) goto L79;
        this.rootScope.m138setMeasuredSizeozmzZPI$animation(IntSize.constructor-impl((((long) r2) << 32) | (((long) r111) & 4294967295L)));
    L79:
        int r112 = r2;
        int r20 = r111;
        return MeasureScope.-CC.layout$default(r26, r112, r20, null, new AnimatedContentMeasurePolicy$measure$3(r5, this, r2, r111), 4, null);
    L53:
        if (r4 != 0) goto L55;
        boolean r1 = true;
    L56:
        if (r1 == false) goto L58;
        Placeable r113 = null;
    L73:
        if (r113 == null) goto L75;
        r111 = r113.getHeight();
        goto L77
    L75:
        r111 = 0;
        goto L77
    L58:
        Placeable r3 = r5[0];
        int r21 = ArraysKt.getLastIndex(r5);
        if (r21 != 0) goto L61;
    L60:
        r113 = r3;
        goto L73
    L61:
        if (r3 == null) goto L63;
        int r22 = r3.getHeight();
    L64:
        if (1 > r21) goto L60;
    L65:
        Placeable r23 = r5[r15];
        if (r23 == null) goto L68;
        int r24 = r23.getHeight();
    L69:
        if (r22 >= r24) goto L71;
        r3 = r23;
        r22 = r24;
    L71:
        if (r15 == r21) goto L60;
        r15 = r15 + 1;
        goto L65
    L68:
        r24 = 0;
        goto L69
    L63:
        r22 = 0;
        goto L64
    L55:
        r1 = false;
        goto L56
    L26:
        if (r4 != 0) goto L28;
        boolean r25 = true;
    L29:
        if (r25 == false) goto L31;
        Placeable r29 = null;
    L47:
        if (r29 == null) goto L49;
        r2 = r29.getWidth();
        goto L51
    L49:
        r2 = 0;
        goto L51
    L31:
        r29 = r5[0];
        int r30 = ArraysKt.getLastIndex(r5);
        if (r30 == 0) goto L47;
        if (r29 == null) goto L36;
        int r31 = r29.getWidth();
    L37:
        if (1 > r30) goto L47;
        int r32 = 1;
    L39:
        Placeable r33 = r5[r32];
        if (r33 == null) goto L42;
        int r114 = r33.getWidth();
    L43:
        if (r31 >= r114) goto L45;
        r29 = r33;
        r31 = r114;
    L45:
        if (r32 == r30) goto L47;
        r32 = r32 + 1;
        goto L39
    L42:
        r114 = 0;
        goto L43
    L36:
        r31 = 0;
        goto L37
    L28:
        r25 = false;
        goto L29
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r6, List<? extends IntrinsicMeasurable> r7, int r8) {
        if (r7.isEmpty() == false) goto L5;
        Integer r9 = null;
    L12:
        Integer r10 = r9;
        if (r10 != null) goto L15;
        return 0;
    L15:
        return r10.intValue();
    L5:
        r9 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, 0)).minIntrinsicHeight(r8));
        int r1 = CollectionsKt.getLastIndex(r7);
        int r2 = 1;
        if (1 > r1) goto L12;
    L7:
        Integer r3 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, r2)).minIntrinsicHeight(r8));
        if (r3.compareTo(r9) <= 0) goto L10;
        r9 = r3;
    L10:
        if (r2 == r1) goto L12;
        r2 = r2 + 1;
        goto L7
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r6, List<? extends IntrinsicMeasurable> r7, int r8) {
        if (r7.isEmpty() == false) goto L5;
        Integer r9 = null;
    L12:
        Integer r10 = r9;
        if (r10 != null) goto L15;
        return 0;
    L15:
        return r10.intValue();
    L5:
        r9 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, 0)).minIntrinsicWidth(r8));
        int r1 = CollectionsKt.getLastIndex(r7);
        int r2 = 1;
        if (1 > r1) goto L12;
    L7:
        Integer r3 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, r2)).minIntrinsicWidth(r8));
        if (r3.compareTo(r9) <= 0) goto L10;
        r9 = r3;
    L10:
        if (r2 == r1) goto L12;
        r2 = r2 + 1;
        goto L7
    }
}
