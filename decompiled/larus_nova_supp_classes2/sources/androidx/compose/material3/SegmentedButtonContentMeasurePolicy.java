package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006 "}, d2 = {"Landroidx/compose/material3/SegmentedButtonContentMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/AnimationSpec;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "setAnimatable", "(Landroidx/compose/animation/core/Animatable;)V", "initialOffset", "Ljava/lang/Integer;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SegmentedButtonContentMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable = 0;
    private Animatable<Integer, AnimationVector1D> animatable;
    private final AnimationSpec<Integer> animationSpec;
    private Integer initialOffset;
    private final CoroutineScope scope;

    public static /* synthetic */ Unit a(List r0, MeasureScope r1, SegmentedButtonContentMeasurePolicy r2, int r3, List r4, int r5, Placeable.PlacementScope r6) {
        return measure_3p2s80s$lambda$8(r0, r1, r2, r3, r4, r5, r6);
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

    public final Animatable<Integer, AnimationVector1D> getAnimatable() {
        return this.animatable;
    }

    public final AnimationSpec<Integer> getAnimationSpec() {
        return this.animationSpec;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void setAnimatable(Animatable<Integer, AnimationVector1D> r1) {
        this.animatable = r1;
    }

    public SegmentedButtonContentMeasurePolicy(CoroutineScope r1, AnimationSpec<Integer> r2) {
        this.scope = r1;
        this.animationSpec = r2;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3092measure3p2s80s(final MeasureScope r21, List<? extends List<? extends Measurable>> r22, long r23) {
        List r4 = (List) ListProtector.get(r22, 0);
        int r5 = 1;
        List r0 = (List) ListProtector.get(r22, 1);
        final ArrayList r6 = new ArrayList(r4.size());
        int r9 = r4.size();
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L6;
        r6.add(((Measurable) ListProtector.get(r4, r10)).measure-BRTryo0(r23));
        r10 = r10 + 1;
        goto L3
    L6:
        if (r6.isEmpty() == false) goto L8;
        Object r7 = null;
    L16:
        Placeable r8 = (Placeable) r7;
        if (r8 == null) goto L19;
        int r11 = r8.getWidth();
    L20:
        final ArrayList r12 = new ArrayList(r0.size());
        int r13 = r0.size();
        int r14 = 0;
    L21:
        if (r14 >= r13) goto L24;
        r12.add(((Measurable) ListProtector.get(r0, r14)).measure-BRTryo0(r23));
        r14 = r14 + 1;
        goto L21
    L24:
        if (r12.isEmpty() == false) goto L26;
        Object r1 = null;
    L34:
        Placeable r2 = (Placeable) r1;
        if (r2 == null) goto L37;
        Integer r3 = Integer.valueOf(r2.getWidth());
    L39:
        if (r12.isEmpty() == false) goto L41;
        Object r15 = null;
    L48:
        Placeable r16 = (Placeable) r15;
        if (r16 == null) goto L51;
        int r17 = r16.getHeight();
    L52:
        SegmentedButtonDefaults r18 = SegmentedButtonDefaults.INSTANCE;
        int r19 = Math.max(r21.roundToPx-0680j_4(r18.m3097getIconSizeD9Ej5fM()), r11) + r21.roundToPx-0680j_4(SegmentedButtonKt.access$getIconSpacing$p());
        if (r3 == null) goto L55;
        int r20 = r3.intValue();
    L56:
        int r110 = r19 + r20;
        if (r11 != 0) goto L59;
        final int r24 = (-(r21.roundToPx-0680j_4(r18.m3097getIconSizeD9Ej5fM()) + r21.roundToPx-0680j_4(SegmentedButtonKt.access$getIconSpacing$p()))) / 2;
    L60:
        Integer r111 = this.initialOffset;
        if (r111 != null) goto L63;
        this.initialOffset = Integer.valueOf(r24);
    L69:
        final int r25 = r17;
        return MeasureScope.-CC.layout$default(r21, r110, r17, null, new gn(r6, r21, this, r24, r12, r25), 4, null);
    L63:
        Animatable<Integer, AnimationVector1D> r26 = this.animatable;
        if (r26 != null) goto L67;
        Intrinsics.checkNotNull(r111);
        r26 = new Animatable(r111, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), null, null, 12, null);
        this.animatable = r26;
    L67:
        if (r26.getTargetValue().intValue() == r24) goto L69;
        BuildersKt.launch$default(this.scope, null, null, new SegmentedButtonContentMeasurePolicy$measure$1(r26, r24, this, null), 3, null);
        goto L69
    L59:
        r24 = 0;
        goto L60
    L55:
        r20 = 0;
        goto L56
    L51:
        r17 = 0;
        goto L52
    L41:
        r15 = ListProtector.get(r12, 0);
        int r27 = ((Placeable) r15).getHeight();
        int r112 = CollectionsKt.getLastIndex(r12);
        if (1 > r112) goto L48;
    L43:
        Object r113 = ListProtector.get(r12, r5);
        int r114 = ((Placeable) r113).getHeight();
        if (r27 >= r114) goto L46;
        r15 = r113;
        r27 = r114;
    L46:
        if (r5 == r112) goto L48;
        r5 = r5 + 1;
        goto L43
    L37:
        r3 = null;
        goto L39
    L26:
        r1 = ListProtector.get(r12, 0);
        int r28 = ((Placeable) r1).getWidth();
        int r29 = CollectionsKt.getLastIndex(r12);
        if (1 > r29) goto L34;
        int r115 = 1;
    L29:
        Object r116 = ListProtector.get(r12, r115);
        int r117 = ((Placeable) r116).getWidth();
        if (r28 >= r117) goto L32;
        r1 = r116;
        r28 = r117;
    L32:
        if (r115 == r29) goto L34;
        r115 = r115 + 1;
        goto L29
    L19:
        r11 = 0;
        goto L20
    L8:
        r7 = ListProtector.get(r6, 0);
        int r118 = ((Placeable) r7).getWidth();
        int r119 = CollectionsKt.getLastIndex(r6);
        if (1 > r119) goto L16;
        int r120 = 1;
    L11:
        Object r121 = ListProtector.get(r6, r120);
        int r122 = ((Placeable) r121).getWidth();
        if (r118 >= r122) goto L14;
        r7 = r121;
        r118 = r122;
    L14:
        if (r120 == r119) goto L16;
        r120 = r120 + 1;
        goto L11
    }

    private static final Unit measure_3p2s80s$lambda$8(List r14, MeasureScope r15, SegmentedButtonContentMeasurePolicy r16, int r17, List r18, int r19, Placeable.PlacementScope r20) {
        int r3 = r14.size();
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        Placeable r8 = (Placeable) ListProtector.get(r14, r5);
        Placeable.PlacementScope.place$default(r20, r8, 0, (r19 - r8.getHeight()) / 2, MenuKt.ClosedAlphaTarget, 4, null);
        r5 = r5 + 1;
        goto L3
    L5:
        int r0 = r15.roundToPx-0680j_4(SegmentedButtonDefaults.INSTANCE.m3097getIconSizeD9Ej5fM()) + r15.roundToPx-0680j_4(SegmentedButtonKt.access$getIconSpacing$p());
        Animatable<Integer, AnimationVector1D> r1 = r16.animatable;
        if (r1 == null) goto L8;
        int r2 = r1.getValue().intValue();
    L9:
        int r6 = r0 + r2;
        int r7 = r18.size();
    L10:
        if (r4 >= r7) goto L13;
        Placeable r9 = (Placeable) ListProtector.get(r18, r4);
        Placeable.PlacementScope.place$default(r20, r9, r6, (r19 - r9.getHeight()) / 2, MenuKt.ClosedAlphaTarget, 4, null);
        r4 = r4 + 1;
        goto L10
    L13:
        return Unit.INSTANCE;
    L8:
        r2 = r17;
        goto L9
    }
}
