package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0!2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J(\u0010'\u001a\u00020\u000f*\u00020(2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0!2\u0006\u0010*\u001a\u00020\u000fH\u0016J(\u0010+\u001a\u00020\u000f*\u00020(2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0!2\u0006\u0010,\u001a\u00020\u000fH\u0016J(\u0010-\u001a\u00020\u000f*\u00020(2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0!2\u0006\u0010,\u001a\u00020\u000fH\u0016J(\u0010.\u001a\u00020\u000f*\u00020(2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0!2\u0006\u0010*\u001a\u00020\u000fH\u0016JD\u0010/\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J$\u00102\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010*\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000fJD\u00104\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u00105\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u00106\u001a\u00020\u000f*\u00020)2\u0006\u00107\u001a\u00020\u000fJ\u0012\u00108\u001a\u00020\u000f*\u00020)2\u0006\u00107\u001a\u00020\u000fJ\u0012\u00109\u001a\u00020\u000f*\u00020)2\u0006\u00107\u001a\u00020\u000fJ\t\u0010:\u001a\u00020\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\u0010\u0010=\u001a\u00020\nHÂ\u0003¢\u0006\u0004\b>\u0010?J\t\u0010@\u001a\u00020\fHÆ\u0003J\u0010\u0010A\u001a\u00020\nHÂ\u0003¢\u0006\u0004\bB\u0010?J\t\u0010C\u001a\u00020\u000fHÂ\u0003J\t\u0010D\u001a\u00020\u000fHÂ\u0003J\t\u0010E\u001a\u00020\u0012HÂ\u0003Jj\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\bG\u0010HJ\u0013\u0010I\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020\u000fHÖ\u0001J\t\u0010M\u001a\u00020NHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "maxItemsInMainAxis", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "<init>", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "minIntrinsicMainAxisSize", "crossAxisAvailable", "crossAxisSpacing", "maxIntrinsicMainAxisSize", "arrangementSpacing", "intrinsicCrossAxisSize", "mainAxisAvailable", "maxMainAxisIntrinsicItemSize", "size", "minCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-QuyCDyQ", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "equals", "other", "", "hashCode", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FlowMeasurePolicy implements MultiContentMeasurePolicy, FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final float mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasurePolicy(boolean r1, Arrangement.Horizontal r2, Arrangement.Vertical r3, float r4, CrossAxisAlignment r5, float r6, int r7, int r8, FlowLayoutOverflowState r9, DefaultConstructorMarker r10) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit a(Placeable.PlacementScope r0) {
        return measure_3p2s80s$lambda$1(r0);
    }

    public static /* synthetic */ Unit b(Placeable.PlacementScope r0) {
        return measure_3p2s80s$lambda$0(r0);
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name */
    private final float m887component4D9Ej5fM() {
        return this.mainAxisSpacing;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name */
    private final float m888component6D9Ej5fM() {
        return this.crossAxisArrangementSpacing;
    }

    private final int component7() {
        return this.maxItemsInMainAxis;
    }

    private final int component8() {
        return this.maxLines;
    }

    private final FlowLayoutOverflowState component9() {
        return this.overflow;
    }

    /* JADX INFO: renamed from: copy-QuyCDyQ$default, reason: not valid java name */
    public static /* synthetic */ FlowMeasurePolicy m889copyQuyCDyQ$default(FlowMeasurePolicy r10, boolean r11, Arrangement.Horizontal r12, Arrangement.Vertical r13, float r14, CrossAxisAlignment r15, float r16, int r17, int r18, FlowLayoutOverflowState r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        boolean r2 = r10.isHorizontal;
    L7:
        if ((r20 & 2) == 0) goto L9;
        Arrangement.Horizontal r3 = r10.horizontalArrangement;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Arrangement.Vertical r4 = r10.verticalArrangement;
    L15:
        if ((r20 & 8) == 0) goto L17;
        float r5 = r10.mainAxisSpacing;
    L19:
        if ((r20 & 16) == 0) goto L21;
        CrossAxisAlignment r6 = r10.crossAxisAlignment;
    L23:
        if ((r20 & 32) == 0) goto L25;
        float r7 = r10.crossAxisArrangementSpacing;
    L27:
        if ((r20 & 64) == 0) goto L29;
        int r8 = r10.maxItemsInMainAxis;
    L31:
        if ((r20 & 128) == 0) goto L33;
        int r9 = r10.maxLines;
    L35:
        if ((r20 & 256) == 0) goto L37;
        FlowLayoutOverflowState r1 = r10.overflow;
    L39:
        return r10.m890copyQuyCDyQ(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final boolean component1() {
        return this.isHorizontal;
    }

    public final Arrangement.Horizontal component2() {
        return this.horizontalArrangement;
    }

    public final Arrangement.Vertical component3() {
        return this.verticalArrangement;
    }

    public final CrossAxisAlignment component5() {
        return this.crossAxisAlignment;
    }

    /* JADX INFO: renamed from: copy-QuyCDyQ, reason: not valid java name */
    public final FlowMeasurePolicy m890copyQuyCDyQ(boolean r13, Arrangement.Horizontal r14, Arrangement.Vertical r15, float r16, CrossAxisAlignment r17, float r18, int r19, int r20, FlowLayoutOverflowState r21) {
        return new FlowMeasurePolicy(r13, r14, r15, r16, r17, r18, r19, r20, r21, null);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    public final /* synthetic */ long mo846createConstraintsxF2OJ5Q(int r1, int r2, int r3, int r4, boolean r5) {
        return FlowLineMeasurePolicy.CC.m881$default$createConstraintsxF2OJ5Q(this, r1, r2, r3, r4, r5);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final /* synthetic */ int crossAxisSize(Placeable r1) {
        return FlowLineMeasurePolicy.CC.$default$crossAxisSize(this, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowMeasurePolicy) == true) goto L8;
        return false;
    L8:
        FlowMeasurePolicy r6 = (FlowMeasurePolicy) r5;
        if (this.isHorizontal == r6.isHorizontal) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.horizontalArrangement, r6.horizontalArrangement) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.verticalArrangement, r6.verticalArrangement) == true) goto L18;
        return false;
    L18:
        if (Dp.equals-impl0(this.mainAxisSpacing, r6.mainAxisSpacing) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.crossAxisAlignment, r6.crossAxisAlignment) == true) goto L24;
        return false;
    L24:
        if (Dp.equals-impl0(this.crossAxisArrangementSpacing, r6.crossAxisArrangementSpacing) == true) goto L27;
        return false;
    L27:
        if (this.maxItemsInMainAxis == r6.maxItemsInMainAxis) goto L30;
        return false;
    L30:
        if (this.maxLines == r6.maxLines) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.overflow, r6.overflow) == true) goto L35;
        return false;
    L35:
        return true;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public final /* synthetic */ int getCrossAxisPosition(Placeable r1, int r2, LayoutDirection r3, int r4) {
        return FlowLineMeasurePolicy.CC.$default$getCrossAxisPosition(this, r1, r2, r3, r4);
    }

    public int hashCode() {
        if (this.isHorizontal == false) goto L5;
        int r0 = 1231;
    L7:
        return (((((((((((((((r0 * 31) + this.horizontalArrangement.hashCode()) * 31) + this.verticalArrangement.hashCode()) * 31) + Dp.hashCode-impl(this.mainAxisSpacing)) * 31) + this.crossAxisAlignment.hashCode()) * 31) + Dp.hashCode-impl(this.crossAxisArrangementSpacing)) * 31) + this.maxItemsInMainAxis) * 31) + this.maxLines) * 31) + this.overflow.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final /* synthetic */ int mainAxisSize(Placeable r1) {
        return FlowLineMeasurePolicy.CC.$default$mainAxisSize(this, r1);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final /* synthetic */ MeasureResult placeHelper(Placeable[] r1, MeasureScope r2, int r3, int[] r4, int r5, int r6, int[] r7, int r8, int r9, int r10) {
        return FlowLineMeasurePolicy.CC.$default$placeHelper(this, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final /* synthetic */ void populateMainAxisPositions(int r1, int[] r2, int[] r3, MeasureScope r4) {
        FlowLineMeasurePolicy.CC.$default$populateMainAxisPositions(this, r1, r2, r3, r4);
    }

    public String toString() {
        return "FlowMeasurePolicy(isHorizontal=" + this.isHorizontal + ", horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisSpacing=" + Dp.toString-impl(this.mainAxisSpacing) + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + Dp.toString-impl(this.crossAxisArrangementSpacing) + ", maxItemsInMainAxis=" + this.maxItemsInMainAxis + ", maxLines=" + this.maxLines + ", overflow=" + this.overflow + ')';
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    private static final Unit measure_3p2s80s$lambda$1(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    public final int maxMainAxisIntrinsicItemSize(IntrinsicMeasurable r2, int r3) {
        if (isHorizontal() == false) goto L6;
        return r2.maxIntrinsicWidth(r3);
    L6:
        return r2.maxIntrinsicHeight(r3);
    }

    public final int minCrossAxisIntrinsicItemSize(IntrinsicMeasurable r2, int r3) {
        if (isHorizontal() == false) goto L6;
        return r2.minIntrinsicHeight(r3);
    L6:
        return r2.minIntrinsicWidth(r3);
    }

    public final int minMainAxisIntrinsicItemSize(IntrinsicMeasurable r2, int r3) {
        if (isHorizontal() == false) goto L6;
        return r2.minIntrinsicWidth(r3);
    L6:
        return r2.minIntrinsicHeight(r3);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r11, List<? extends List<? extends IntrinsicMeasurable>> r12, int r13) {
        FlowLayoutOverflowState r0 = this.overflow;
        List r1 = (List) CollectionsKt.getOrNull(r12, 1);
        IntrinsicMeasurable r2 = null;
        if (r1 == null) goto L5;
        IntrinsicMeasurable r3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r1);
    L6:
        List r4 = (List) CollectionsKt.getOrNull(r12, 2);
        if (r4 == null) goto L9;
        r2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r4);
    L9:
        r0.m874setOverflowMeasurableshBUhpc$foundation_layout(r3, r2, isHorizontal(), ConstraintsKt.Constraints$default(0, r13, 0, 0, 13, null));
        if (isHorizontal() == false) goto L15;
        List<? extends IntrinsicMeasurable> r14 = (List) CollectionsKt.firstOrNull(r12);
        if (r14 != null) goto L20;
        r14 = CollectionsKt.emptyList();
    L20:
        return intrinsicCrossAxisSize(r14, r13, r11.roundToPx-0680j_4(this.mainAxisSpacing), r11.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    L15:
        List<? extends IntrinsicMeasurable> r15 = (List) CollectionsKt.firstOrNull(r12);
        if (r15 != null) goto L19;
        r15 = CollectionsKt.emptyList();
    L19:
        return maxIntrinsicMainAxisSize(r15, r13, r11.roundToPx-0680j_4(this.mainAxisSpacing));
    L5:
        r3 = null;
        goto L6
    }

    public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> r11, int r12, int r13) {
        int r0 = this.maxItemsInMainAxis;
        int r1 = r11.size();
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r3 >= r1) goto L12;
        int r7 = maxMainAxisIntrinsicItemSize((IntrinsicMeasurable) ListProtector.get(r11, r3), r12) + r13;
        int r8 = r3 + 1;
        if ((r8 - r5) != r0) goto L7;
    L10:
        r4 = Math.max(r4, (r6 + r7) - r13);
        r5 = r3;
        r6 = 0;
    L11:
        r3 = r8;
        goto L3
    L7:
        if (r8 == r11.size()) goto L10;
        r6 = r6 + r7;
        goto L11
    L12:
        return r4;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r11, List<? extends List<? extends IntrinsicMeasurable>> r12, int r13) {
        FlowLayoutOverflowState r0 = this.overflow;
        List r1 = (List) CollectionsKt.getOrNull(r12, 1);
        IntrinsicMeasurable r2 = null;
        if (r1 == null) goto L5;
        IntrinsicMeasurable r3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r1);
    L6:
        List r4 = (List) CollectionsKt.getOrNull(r12, 2);
        if (r4 == null) goto L9;
        r2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r4);
    L9:
        r0.m874setOverflowMeasurableshBUhpc$foundation_layout(r3, r2, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, r13, 7, null));
        if (isHorizontal() == false) goto L15;
        List<? extends IntrinsicMeasurable> r14 = (List) CollectionsKt.firstOrNull(r12);
        if (r14 != null) goto L20;
        r14 = CollectionsKt.emptyList();
    L20:
        return maxIntrinsicMainAxisSize(r14, r13, r11.roundToPx-0680j_4(this.mainAxisSpacing));
    L15:
        List<? extends IntrinsicMeasurable> r15 = (List) CollectionsKt.firstOrNull(r12);
        if (r15 != null) goto L19;
        r15 = CollectionsKt.emptyList();
    L19:
        return intrinsicCrossAxisSize(r15, r13, r11.roundToPx-0680j_4(this.mainAxisSpacing), r11.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    L5:
        r3 = null;
        goto L6
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m891measure3p2s80s(MeasureScope r19, List<? extends List<? extends Measurable>> r20, long r21) {
        if (this.maxLines == 0) goto L32;
        if (this.maxItemsInMainAxis == 0) goto L32;
        if (r20.isEmpty() == true) goto L32;
        if (Constraints.getMaxHeight-impl(r21) == 0) goto L11;
    L13:
        List r6 = (List) CollectionsKt.first(r20);
        if (r6.isEmpty() == true) goto L16;
        List r1 = (List) CollectionsKt.getOrNull(r20, 1);
        if (r1 == null) goto L20;
        Measurable r3 = (Measurable) CollectionsKt.firstOrNull(r1);
    L21:
        List r0 = (List) CollectionsKt.getOrNull(r20, 2);
        if (r0 == null) goto L24;
        Measurable r4 = (Measurable) CollectionsKt.firstOrNull(r0);
    L25:
        this.overflow.setItemCount$foundation_layout(r6.size());
        this.overflow.m873setOverflowMeasurableshBUhpc$foundation_layout(this, r3, r4, r21);
        Iterator r2 = r6.iterator();
        float r5 = this.mainAxisSpacing;
        float r7 = this.crossAxisArrangementSpacing;
        if (isHorizontal() == false) goto L28;
        LayoutOrientation r8 = LayoutOrientation.Horizontal;
    L30:
        return FlowLayoutKt.m867breakDownItemsdi9J0FM(r19, this, r2, r5, r7, OrientationIndependentConstraints.m928constructorimpl(r21, r8), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    L28:
        r8 = LayoutOrientation.Vertical;
        goto L30
    L24:
        r4 = null;
        goto L25
    L20:
        r3 = null;
        goto L21
    L16:
        return MeasureScope.-CC.layout$default(r19, 0, 0, null, new z0(), 4, null);
    L11:
        if (this.overflow.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.Visible) goto L13;
    L32:
        return MeasureScope.-CC.layout$default(r19, 0, 0, null, new y0(), 4, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r11, List<? extends List<? extends IntrinsicMeasurable>> r12, int r13) {
        FlowLayoutOverflowState r0 = this.overflow;
        List r1 = (List) CollectionsKt.getOrNull(r12, 1);
        IntrinsicMeasurable r2 = null;
        if (r1 == null) goto L5;
        IntrinsicMeasurable r3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r1);
    L6:
        List r4 = (List) CollectionsKt.getOrNull(r12, 2);
        if (r4 == null) goto L9;
        r2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r4);
    L9:
        r0.m874setOverflowMeasurableshBUhpc$foundation_layout(r3, r2, isHorizontal(), ConstraintsKt.Constraints$default(0, r13, 0, 0, 13, null));
        if (isHorizontal() == false) goto L15;
        List<? extends IntrinsicMeasurable> r14 = (List) CollectionsKt.firstOrNull(r12);
        if (r14 != null) goto L20;
        r14 = CollectionsKt.emptyList();
    L20:
        return intrinsicCrossAxisSize(r14, r13, r11.roundToPx-0680j_4(this.mainAxisSpacing), r11.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    L15:
        List<? extends IntrinsicMeasurable> r15 = (List) CollectionsKt.firstOrNull(r12);
        if (r15 != null) goto L19;
        r15 = CollectionsKt.emptyList();
    L19:
        return minIntrinsicMainAxisSize(r15, r13, r11.roundToPx-0680j_4(this.mainAxisSpacing), r11.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    L5:
        r3 = null;
        goto L6
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r11, List<? extends List<? extends IntrinsicMeasurable>> r12, int r13) {
        FlowLayoutOverflowState r0 = this.overflow;
        List r1 = (List) CollectionsKt.getOrNull(r12, 1);
        IntrinsicMeasurable r2 = null;
        if (r1 == null) goto L5;
        IntrinsicMeasurable r3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r1);
    L6:
        List r4 = (List) CollectionsKt.getOrNull(r12, 2);
        if (r4 == null) goto L9;
        r2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(r4);
    L9:
        r0.m874setOverflowMeasurableshBUhpc$foundation_layout(r3, r2, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, r13, 7, null));
        if (isHorizontal() == false) goto L15;
        List<? extends IntrinsicMeasurable> r14 = (List) CollectionsKt.firstOrNull(r12);
        if (r14 != null) goto L20;
        r14 = CollectionsKt.emptyList();
    L20:
        return minIntrinsicMainAxisSize(r14, r13, r11.roundToPx-0680j_4(this.mainAxisSpacing), r11.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    L15:
        List<? extends IntrinsicMeasurable> r15 = (List) CollectionsKt.firstOrNull(r12);
        if (r15 != null) goto L19;
        r15 = CollectionsKt.emptyList();
    L19:
        return intrinsicCrossAxisSize(r15, r13, r11.roundToPx-0680j_4(this.mainAxisSpacing), r11.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    L5:
        r3 = null;
        goto L6
    }

    public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> r30, int r31, int r32, int r33, int r34, int r35, FlowLayoutOverflowState r36) {
        if (r30.isEmpty() == false) goto L5;
        long r1 = IntIntPair.m96constructorimpl(0, 0);
    L66:
        return IntIntPair.m100getFirstimpl(r1);
    L5:
        FlowLayoutBuildingBlocks r25 = new FlowLayoutBuildingBlocks(r34, r36, OrientationIndependentConstraints.m926constructorimpl(0, r31, 0, Integer.MAX_VALUE), r35, r32, r33, null);
        IntrinsicMeasurable r3 = (IntrinsicMeasurable) CollectionsKt.getOrNull(r30, 0);
        if (r3 == null) goto L8;
        int r4 = minCrossAxisIntrinsicItemSize(r3, r31);
    L9:
        if (r3 == null) goto L11;
        int r5 = minMainAxisIntrinsicItemSize(r3, r4);
    L12:
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        boolean r10 = true;
        if (r30.size() <= 1) goto L15;
        boolean r15 = true;
    L16:
        long r17 = IntIntPair.m96constructorimpl(r31, Integer.MAX_VALUE);
        if (r3 != null) goto L19;
        IntIntPair r19 = null;
    L21:
        if (r25.m865getWrapInfoOpUlnko(r15, 0, r17, r19, 0, 0, 0, false, false).isLastItemInContainer() == true) goto L23;
        int r9 = r30.size();
        int r14 = r31;
        int r11 = 0;
        int r16 = 0;
        int r26 = 0;
    L32:
        if (r11 >= r9) goto L64;
        int r12 = r14 - r5;
        int r18 = r11 + 1;
        int r13 = Math.max(r6, r4);
        IntrinsicMeasurable r20 = (IntrinsicMeasurable) CollectionsKt.getOrNull(r30, r18);
        if (r20 == null) goto L36;
        int r110 = minCrossAxisIntrinsicItemSize(r20, r31);
    L37:
        if (r20 == null) goto L39;
        int r21 = minMainAxisIntrinsicItemSize(r20, r110) + r32;
    L41:
        if ((r11 + 2) >= r30.size()) goto L43;
        boolean r111 = true;
    L44:
        int r112 = r18 - r26;
        long r113 = IntIntPair.m96constructorimpl(r12, Integer.MAX_VALUE);
        if (r20 != null) goto L47;
        IntIntPair r114 = null;
    L48:
        int r27 = r110;
        FlowLayoutBuildingBlocks.WrapInfo r115 = r25.m865getWrapInfoOpUlnko(r111, r112, r113, r114, r8, r7, r13, false, false);
        if (r115.isLastItemInLine() == false) goto L62;
        r7 = r7 + (r13 + r33);
        if (r20 == null) goto L53;
        boolean r116 = true;
    L54:
        FlowLayoutBuildingBlocks.WrapEllipsisInfo r22 = r25.getWrapEllipsisInfo(r115, r116, r8, r7, r12, r112);
        int r23 = r21 - r32;
        r8 = r8 + 1;
        if (r115.isLastItemInContainer() == true) goto L56;
        r14 = r31;
        r5 = r23;
        r26 = r18;
        r6 = 0;
    L63:
        r4 = r27;
        r11 = r18;
        r16 = r11;
        goto L32
    L56:
        if (r22 == null) goto L60;
        long r2 = r22.m866getEllipsisSizeOO21N7I();
        if (r22.getPlaceEllipsisOnLastContentLine() == true) goto L60;
        r7 = r7 + (IntIntPair.m101getSecondimpl(r2) + r33);
    L60:
        r16 = r18;
        goto L64
    L53:
        r116 = false;
        goto L54
    L62:
        r6 = r13;
        r14 = r12;
        r5 = r21;
        goto L63
    L47:
        r114 = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r21, r110));
        goto L48
    L43:
        r111 = false;
        goto L44
    L39:
        r21 = 0;
        goto L41
    L36:
        r110 = 0;
    L64:
        r1 = IntIntPair.m96constructorimpl(r7 - r33, r16);
        goto L66
    L23:
        if (r3 != null) goto L26;
        r10 = false;
    L26:
        IntIntPair r24 = r36.m872ellipsisSizeF35zmw$foundation_layout(r10, 0, 0);
        if (r24 == null) goto L29;
        int r28 = IntIntPair.m101getSecondimpl(r24.m104unboximpl());
    L30:
        r1 = IntIntPair.m96constructorimpl(r28, 0);
        goto L66
    L29:
        r28 = 0;
        goto L30
    L19:
        r19 = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r5, r4));
        goto L21
    L15:
        r15 = false;
        goto L16
    L11:
        r5 = 0;
        goto L12
    L8:
        r4 = 0;
        goto L9
    }

    public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> r19, int r20, int r21, int r22, int r23, int r24, FlowLayoutOverflowState r25) {
        if (r19.isEmpty() == true) goto L82;
        int r1 = r19.size();
        int[] r14 = new int[r1];
        int r3 = r19.size();
        int[] r15 = new int[r3];
        int r4 = r19.size();
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L8;
        IntrinsicMeasurable r6 = (IntrinsicMeasurable) ListProtector.get(r19, r5);
        int r7 = minMainAxisIntrinsicItemSize(r6, r20);
        r14[r5] = r7;
        r15[r5] = minCrossAxisIntrinsicItemSize(r6, r7);
        r5 = r5 + 1;
        goto L6
    L8:
        int r8 = Integer.MAX_VALUE;
        if (r24 == Integer.MAX_VALUE) goto L12;
        if (r23 == Integer.MAX_VALUE) goto L12;
        r8 = r23 * r24;
    L12:
        int r9 = 1;
        if (r8 >= r19.size()) goto L20;
        if (r25.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.ExpandIndicator) goto L17;
    L18:
        int r10 = 1;
    L27:
        int r11 = Math.min(r8 - r10, r19.size());
        int r12 = ArraysKt.sum(r14) + ((r19.size() - 1) * r21);
        if (r3 != 0) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == true) goto L71;
        int r16 = r15[0];
        int r17 = ArraysKt.getLastIndex(r15);
        if (1 > r17) goto L40;
        int r18 = 1;
    L35:
        int r26 = r15[r18];
        if (r16 >= r26) goto L38;
        r16 = r26;
    L38:
        if (r18 == r17) goto L40;
        r18 = r18 + 1;
    L40:
        if (r1 != 0) goto L42;
        boolean r2 = true;
    L43:
        if (r2 == true) goto L69;
        int r27 = r14[0];
        int r28 = ArraysKt.getLastIndex(r14);
        if (1 > r28) goto L51;
    L46:
        int r29 = r14[r9];
        if (r27 >= r29) goto L49;
        r27 = r29;
    L49:
        if (r9 == r28) goto L51;
        r9 = r9 + 1;
    L51:
        int r30 = r27;
        int r31 = r12;
        int r32 = r31;
    L52:
        if (r30 > r32) goto L83;
        if (r16 == r20) goto L84;
        r31 = (r30 + r32) / 2;
        int r0 = r32;
        int r110 = r30;
        r11 = r11;
        long r33 = FlowLayoutKt.access$intrinsicCrossAxisSize(r19, r14, r15, r31, r21, r22, r23, r24, r25);
        r16 = IntIntPair.m100getFirstimpl(r33);
        int r34 = IntIntPair.m101getSecondimpl(r33);
        if (r16 > r20) goto L62;
        if (r34 < r11) goto L62;
        if (r16 >= r20) goto L67;
        r32 = r31 - 1;
        r30 = r110;
        goto L52
    L67:
        return r31;
    L62:
        r30 = r31 + 1;
        if (r30 > r0) goto L81;
        r32 = r0;
        goto L52
    L81:
        return r30;
    L84:
        return r31;
    L83:
        return r31;
    L69:
        throw new NoSuchElementException();
    L42:
        r2 = false;
        goto L43
    L71:
        throw new NoSuchElementException();
    L30:
        r13 = false;
        goto L31
    L17:
        if (r25.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator) goto L18;
    L20:
        if (r8 >= r19.size()) goto L22;
    L26:
        r10 = 0;
        goto L27
    L22:
        if (r24 < r25.getMinLinesToShowCollapse$foundation_layout()) goto L26;
        if (r25.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator) goto L26;
    L82:
        return 0;
    }

    private FlowMeasurePolicy(boolean r1, Arrangement.Horizontal r2, Arrangement.Vertical r3, float r4, CrossAxisAlignment r5, float r6, int r7, int r8, FlowLayoutOverflowState r9) {
        this.isHorizontal = r1;
        this.horizontalArrangement = r2;
        this.verticalArrangement = r3;
        this.mainAxisSpacing = r4;
        this.crossAxisAlignment = r5;
        this.crossAxisArrangementSpacing = r6;
        this.maxItemsInMainAxis = r7;
        this.maxLines = r8;
        this.overflow = r9;
    }
}
