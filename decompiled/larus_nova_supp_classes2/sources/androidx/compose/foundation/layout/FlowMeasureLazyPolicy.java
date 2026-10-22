package androidx.compose.foundation.layout;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0017\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014\u0012;\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0\u0019J\u001b\u0010.\u001a\u00020-*\u00020+2\u0006\u0010/\u001a\u00020,H\u0002¢\u0006\u0004\b0\u00101J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\u0010\u00105\u001a\u00020\tHÂ\u0003¢\u0006\u0004\b6\u00107J\t\u00108\u001a\u00020\u000bHÆ\u0003J\u0010\u00109\u001a\u00020\tHÂ\u0003¢\u0006\u0004\b:\u00107J\t\u0010;\u001a\u00020\u000eHÂ\u0003J\t\u0010<\u001a\u00020\u000eHÂ\u0003J\t\u0010=\u001a\u00020\u000eHÂ\u0003J\t\u0010>\u001a\u00020\u0012HÂ\u0003J\u001a\u0010?\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014HÂ\u0003JC\u0010@\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017HÂ\u0003¢\u0006\u0002\u0010AJÎ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u00142=\b\u0002\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017HÆ\u0001¢\u0006\u0004\bC\u0010DJ\u0013\u0010E\u001a\u00020\u00032\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u000eHÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010!R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000RE\u0010\u0018\u001a7\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006K"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "itemCount", "", "maxLines", "maxItemsInMainAxis", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "<init>", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Lkotlin/jvm/functions/Function4;", "getMeasurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "measure", "constraints", "measure-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "component10", "component11", "component12", "()Lkotlin/jvm/functions/Function4;", "copy", "copy-E4Q9ldg", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;)Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "equals", "other", "", "hashCode", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FlowMeasureLazyPolicy implements FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Function4<Integer, FlowLineInfo, Composer, Integer, Unit> getComposable;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final int itemCount;
    private final float mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;
    private final List<Function2<Composer, Integer, Unit>> overflowComposables;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasureLazyPolicy(boolean r1, Arrangement.Horizontal r2, Arrangement.Vertical r3, float r4, CrossAxisAlignment r5, float r6, int r7, int r8, int r9, FlowLayoutOverflowState r10, List r11, Function4 r12, DefaultConstructorMarker r13) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit a(Placeable.PlacementScope r0) {
        return measure_0kLqBqw$lambda$1(r0);
    }

    public static /* synthetic */ List b(SubcomposeMeasureScope r0, FlowMeasureLazyPolicy r1, int r2, FlowLineInfo r3) {
        return measure_0kLqBqw$lambda$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ Measurable c(FlowMeasureLazyPolicy r0, SubcomposeMeasureScope r1, boolean r2, int r3) {
        return measure_0kLqBqw$lambda$4(r0, r1, r2, r3);
    }

    private final FlowLayoutOverflowState component10() {
        return this.overflow;
    }

    private final List<Function2<Composer, Integer, Unit>> component11() {
        return this.overflowComposables;
    }

    private final Function4<Integer, FlowLineInfo, Composer, Integer, Unit> component12() {
        return this.getComposable;
    }

    /* JADX INFO: renamed from: component4-D9Ej5fM, reason: not valid java name */
    private final float m882component4D9Ej5fM() {
        return this.mainAxisSpacing;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name */
    private final float m883component6D9Ej5fM() {
        return this.crossAxisArrangementSpacing;
    }

    private final int component7() {
        return this.itemCount;
    }

    private final int component8() {
        return this.maxLines;
    }

    private final int component9() {
        return this.maxItemsInMainAxis;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-E4Q9ldg$default, reason: not valid java name */
    public static /* synthetic */ FlowMeasureLazyPolicy m884copyE4Q9ldg$default(FlowMeasureLazyPolicy r13, boolean r14, Arrangement.Horizontal r15, Arrangement.Vertical r16, float r17, CrossAxisAlignment r18, float r19, int r20, int r21, int r22, FlowLayoutOverflowState r23, List r24, Function4 r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        boolean r2 = r13.isHorizontal;
    L7:
        if ((r26 & 2) == 0) goto L9;
        Arrangement.Horizontal r3 = r13.horizontalArrangement;
    L11:
        if ((r26 & 4) == 0) goto L13;
        Arrangement.Vertical r4 = r13.verticalArrangement;
    L15:
        if ((r26 & 8) == 0) goto L17;
        float r5 = r13.mainAxisSpacing;
    L19:
        if ((r26 & 16) == 0) goto L21;
        CrossAxisAlignment r6 = r13.crossAxisAlignment;
    L23:
        if ((r26 & 32) == 0) goto L25;
        float r7 = r13.crossAxisArrangementSpacing;
    L27:
        if ((r26 & 64) == 0) goto L29;
        int r8 = r13.itemCount;
    L31:
        if ((r26 & 128) == 0) goto L33;
        int r9 = r13.maxLines;
    L35:
        if ((r26 & 256) == 0) goto L37;
        int r10 = r13.maxItemsInMainAxis;
    L39:
        if ((r26 & 512) == 0) goto L41;
        FlowLayoutOverflowState r11 = r13.overflow;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        List r12 = r13.overflowComposables;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        Function4 r1 = r13.getComposable;
    L51:
        return r13.m886copyE4Q9ldg(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public static /* synthetic */ MeasureResult d(FlowMeasureLazyPolicy r0, SubcomposeMeasureScope r1, Constraints r2) {
        return getMeasurePolicy$lambda$0(r0, r1, r2);
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

    /* JADX INFO: renamed from: copy-E4Q9ldg, reason: not valid java name */
    public final FlowMeasureLazyPolicy m886copyE4Q9ldg(boolean r16, Arrangement.Horizontal r17, Arrangement.Vertical r18, float r19, CrossAxisAlignment r20, float r21, int r22, int r23, int r24, FlowLayoutOverflowState r25, List<? extends Function2<? super Composer, ? super Integer, Unit>> r26, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> r27) {
        return new FlowMeasureLazyPolicy(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, null);
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
        if ((r5 instanceof FlowMeasureLazyPolicy) == true) goto L8;
        return false;
    L8:
        FlowMeasureLazyPolicy r6 = (FlowMeasureLazyPolicy) r5;
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
        if (this.itemCount == r6.itemCount) goto L30;
        return false;
    L30:
        if (this.maxLines == r6.maxLines) goto L33;
        return false;
    L33:
        if (this.maxItemsInMainAxis == r6.maxItemsInMainAxis) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.overflow, r6.overflow) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.overflowComposables, r6.overflowComposables) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.getComposable, r6.getComposable) == true) goto L44;
        return false;
    L44:
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
        return (((((((((((((((((((((r0 * 31) + this.horizontalArrangement.hashCode()) * 31) + this.verticalArrangement.hashCode()) * 31) + Dp.hashCode-impl(this.mainAxisSpacing)) * 31) + this.crossAxisAlignment.hashCode()) * 31) + Dp.hashCode-impl(this.crossAxisArrangementSpacing)) * 31) + this.itemCount) * 31) + this.maxLines) * 31) + this.maxItemsInMainAxis) * 31) + this.overflow.hashCode()) * 31) + this.overflowComposables.hashCode()) * 31) + this.getComposable.hashCode();
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
        return "FlowMeasureLazyPolicy(isHorizontal=" + this.isHorizontal + ", horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisSpacing=" + Dp.toString-impl(this.mainAxisSpacing) + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + Dp.toString-impl(this.crossAxisArrangementSpacing) + ", itemCount=" + this.itemCount + ", maxLines=" + this.maxLines + ", maxItemsInMainAxis=" + this.maxItemsInMainAxis + ", overflow=" + this.overflow + ", overflowComposables=" + this.overflowComposables + ", getComposable=" + this.getComposable + ')';
    }

    public final Function2<SubcomposeMeasureScope, Constraints, MeasureResult> getMeasurePolicy() {
        return new u0(this);
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

    public static final /* synthetic */ Function4 access$getGetComposable$p(FlowMeasureLazyPolicy r0) {
        return r0.getComposable;
    }

    private static final Unit measure_0kLqBqw$lambda$1(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-0kLqBqw, reason: not valid java name */
    private final MeasureResult m885measure0kLqBqw(final SubcomposeMeasureScope r13, long r14) {
        if (this.itemCount <= 0) goto L20;
        if (this.maxLines == 0) goto L20;
        if (this.maxItemsInMainAxis == 0) goto L20;
        if (Constraints.getMaxHeight-impl(r14) == 0) goto L11;
    L13:
        ContextualFlowItemIterator r4 = new ContextualFlowItemIterator(this.itemCount, new w0(r13, this));
        this.overflow.setItemCount$foundation_layout(this.itemCount);
        this.overflow.m875setOverflowMeasurablesVKLhPVY$foundation_layout(this, r14, new x0(this, r13));
        float r5 = this.mainAxisSpacing;
        float r6 = this.crossAxisArrangementSpacing;
        if (isHorizontal() == false) goto L16;
        LayoutOrientation r0 = LayoutOrientation.Horizontal;
    L18:
        return FlowLayoutKt.m867breakDownItemsdi9J0FM(r13, this, r4, r5, r6, OrientationIndependentConstraints.m928constructorimpl(r14, r0), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    L16:
        r0 = LayoutOrientation.Vertical;
        goto L18
    L11:
        if (this.overflow.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.Visible) goto L13;
    L20:
        return MeasureScope.-CC.layout$default(r13, 0, 0, null, new v0(), 4, null);
    }

    private static final MeasureResult getMeasurePolicy$lambda$0(FlowMeasureLazyPolicy r2, SubcomposeMeasureScope r3, Constraints r4) {
        return r2.m885measure0kLqBqw(r3, r4.unbox-impl());
    }

    private static final List measure_0kLqBqw$lambda$2(SubcomposeMeasureScope r2, final FlowMeasureLazyPolicy r3, final int r4, final FlowLineInfo r5) {
        return r2.subcompose(Integer.valueOf(r4), ComposableLambdaKt.composableLambdaInstance(-195060736, true, new FlowMeasureLazyPolicy$measure$measurablesIterator$1$1(r3, r4, r5)));
    }

    private static final Measurable measure_0kLqBqw$lambda$4(FlowMeasureLazyPolicy r2, SubcomposeMeasureScope r3, boolean r4, int r5) {
        int r0 = !r4 ? 1 : 0;
        Function2 r1 = (Function2) CollectionsKt.getOrNull(r2.overflowComposables, r0);
        if (r1 == null) goto L5;
        StringBuilder r6 = new StringBuilder();
        r6.append(r4);
        r6.append(r2.itemCount);
        r6.append(r5);
        return (Measurable) CollectionsKt.getOrNull(r3.subcompose(r6.toString(), r1), 0);
    L5:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FlowMeasureLazyPolicy(boolean r1, Arrangement.Horizontal r2, Arrangement.Vertical r3, float r4, CrossAxisAlignment r5, float r6, int r7, int r8, int r9, FlowLayoutOverflowState r10, List<? extends Function2<? super Composer, ? super Integer, Unit>> r11, Function4<? super Integer, ? super FlowLineInfo, ? super Composer, ? super Integer, Unit> r12) {
        this.isHorizontal = r1;
        this.horizontalArrangement = r2;
        this.verticalArrangement = r3;
        this.mainAxisSpacing = r4;
        this.crossAxisAlignment = r5;
        this.crossAxisArrangementSpacing = r6;
        this.itemCount = r7;
        this.maxLines = r8;
        this.maxItemsInMainAxis = r9;
        this.overflow = r10;
        this.overflowComposables = r11;
        this.getComposable = r12;
    }
}
