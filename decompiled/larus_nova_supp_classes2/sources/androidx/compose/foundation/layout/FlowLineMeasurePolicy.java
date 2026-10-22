package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0016J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0013H\u0016J7\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJg\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010-J(\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020\u0012H\u0016J(\u00102\u001a\u0002032\u0006\u0010'\u001a\u00020\u00122\u0006\u00104\u001a\u00020&2\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020#H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "isHorizontal", "", "()Z", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "mainAxisSize", "", "Landroidx/compose/ui/layout/Placeable;", "crossAxisSize", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "", "mainAxisLayoutSize", "crossAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "getCrossAxisPosition", "placeable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "populateMainAxisPositions", "", "childrenMainAxisSize", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FlowLineMeasurePolicy extends RowColumnMeasurePolicy {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.FlowLineMeasurePolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$crossAxisSize(FlowLineMeasurePolicy r0, Placeable r1) {
            if (r0.isHorizontal() == false) goto L6;
            return r1.getMeasuredHeight();
        L6:
            return r1.getMeasuredWidth();
        }

        public static int $default$mainAxisSize(FlowLineMeasurePolicy r0, Placeable r1) {
            if (r0.isHorizontal() == false) goto L6;
            return r1.getMeasuredWidth();
        L6:
            return r1.getMeasuredHeight();
        }

        public static int $default$getCrossAxisPosition(FlowLineMeasurePolicy r1, Placeable r2, int r3, LayoutDirection r4, int r5) {
            RowColumnParentData r0 = RowColumnImplKt.getRowColumnParentData(r2);
            if (r0 == null) goto L6;
            CrossAxisAlignment r6 = r0.getCrossAxisAlignment();
            if (r6 == null) goto L6;
        L8:
            return r6.align$foundation_layout(r3 - r1.crossAxisSize(r2), r4, r2, r5);
        L6:
            r6 = r1.getCrossAxisAlignment();
            goto L8
        }

        public static void $default$populateMainAxisPositions(FlowLineMeasurePolicy r7, int r8, int[] r9, int[] r10, MeasureScope r11) {
            if (r7.isHorizontal() == false) goto L5;
            r7.getHorizontalArrangement().arrange(r11, r8, r9, r11.getLayoutDirection(), r10);
            return;
        L5:
            r7.getVerticalArrangement().arrange(r11, r8, r9, r10);
        }

        /* JADX INFO: renamed from: $default$createConstraints-xF2OJ5Q, reason: not valid java name */
        public static long m881$default$createConstraintsxF2OJ5Q(FlowLineMeasurePolicy r0, int r1, int r2, int r3, int r4, boolean r5) {
            if (r0.isHorizontal() == false) goto L6;
            return RowKt.createRowConstraints(r5, r1, r2, r3, r4);
        L6:
            return ColumnKt.createColumnConstraints(r5, r1, r2, r3, r4);
        }

        public static MeasureResult $default$placeHelper(final FlowLineMeasurePolicy r15, final Placeable[] r16, MeasureScope r17, final int r18, final int[] r19, int r20, final int r21, final int[] r22, final int r23, final int r24, final int r25) {
            if (r15.isHorizontal() == false) goto L5;
            int r0 = r20;
            int r1 = r21;
        L7:
            if (r15.isHorizontal() == false) goto L9;
            LayoutDirection r2 = LayoutDirection.Ltr;
        L10:
            final LayoutDirection r11 = r2;
            Function1 r14 = new t0(r22, r23, r24, r25, r16, r15, r21, r11, r18, r19);
            return MeasureScope.-CC.layout$default(r17, r0, r1, null, r14, 4, null);
        L9:
            r2 = r17.getLayoutDirection();
            goto L10
        L5:
            r1 = r20;
            r0 = r21;
            goto L7
        }

        public static Unit placeHelper$lambda$1$lambda$0(int[] r15, int r16, int r17, int r18, Placeable[] r19, FlowLineMeasurePolicy r20, int r21, LayoutDirection r22, int r23, int[] r24, Placeable.PlacementScope r25) {
            if (r15 == null) goto L4;
            int r0 = r15[r16];
        L5:
            int r2 = r17;
        L6:
            if (r2 >= r18) goto L13;
            Placeable r4 = r19[r2];
            Intrinsics.checkNotNull(r4);
            int r6 = r20.getCrossAxisPosition(r4, r21, r22, r23) + r0;
            if (r20.isHorizontal() == false) goto L10;
            Placeable.PlacementScope.place$default(r25, r4, r24[r2 - r17], r6, MenuKt.ClosedAlphaTarget, 4, null);
        L11:
            r2 = r2 + 1;
            goto L6
        L10:
            Placeable.PlacementScope.place$default(r25, r4, r6, r24[r2 - r17], MenuKt.ClosedAlphaTarget, 4, null);
            goto L11
        L13:
            return Unit.INSTANCE;
        L4:
            r0 = 0;
            goto L5
        }
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    long mo846createConstraintsxF2OJ5Q(int r1, int r2, int r3, int r4, boolean r5);

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    int crossAxisSize(Placeable r1);

    CrossAxisAlignment getCrossAxisAlignment();

    int getCrossAxisPosition(Placeable r1, int r2, LayoutDirection r3, int r4);

    Arrangement.Horizontal getHorizontalArrangement();

    Arrangement.Vertical getVerticalArrangement();

    boolean isHorizontal();

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    int mainAxisSize(Placeable r1);

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    MeasureResult placeHelper(Placeable[] r1, MeasureScope r2, int r3, int[] r4, int r5, int r6, int[] r7, int r8, int r9, int r10);

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    void populateMainAxisPositions(int r1, int[] r2, int[] r3, MeasureScope r4);
}
