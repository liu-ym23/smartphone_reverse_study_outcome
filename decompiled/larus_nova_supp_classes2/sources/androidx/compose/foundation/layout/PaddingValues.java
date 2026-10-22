package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateLeftPadding", "Landroidx/compose/ui/unit/Dp;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "Absolute", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PaddingValues {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0018\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\r\u0010\nR\u0018\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u000b\u0012\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM$annotations", "()V", "F", "getTop-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getBottom-D9Ej5fM$annotations", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "()F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Absolute implements PaddingValues {
        public static final int $stable = 0;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float r1, float r2, float r3, float r4, DefaultConstructorMarker r5) {
            this(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m974getBottomD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m975getLeftD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m976getRightD9Ej5fM$annotations() {
        }

        /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m977getTopD9Ej5fM$annotations() {
        }

        public int hashCode() {
            return (((((Dp.hashCode-impl(this.left) * 31) + Dp.hashCode-impl(this.top)) * 31) + Dp.hashCode-impl(this.right)) * 31) + Dp.hashCode-impl(this.bottom);
        }

        public String toString() {
            return "PaddingValues.Absolute(left=" + Dp.toString-impl(this.left) + ", top=" + Dp.toString-impl(this.top) + ", right=" + Dp.toString-impl(this.right) + ", bottom=" + Dp.toString-impl(this.bottom) + ')';
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
        public float mo898calculateBottomPaddingD9Ej5fM() {
            return this.bottom;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
        public float mo901calculateTopPaddingD9Ej5fM() {
            return this.top;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
        public float mo899calculateLeftPaddingu2uoSUM(LayoutDirection r1) {
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
        public float mo900calculateRightPaddingu2uoSUM(LayoutDirection r1) {
            return this.right;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof Absolute) == true) goto L5;
            return false;
        L5:
            Absolute r5 = (Absolute) r4;
            if (Dp.equals-impl0(this.left, r5.left) == true) goto L8;
            return false;
        L8:
            if (Dp.equals-impl0(this.top, r5.top) == true) goto L10;
            return false;
        L10:
            if (Dp.equals-impl0(this.right, r5.right) == true) goto L12;
            return false;
        L12:
            if (Dp.equals-impl0(this.bottom, r5.bottom) == false) goto L18;
            return true;
        L18:
            return false;
        }

        private Absolute(float r4, float r5, float r6, float r7) {
            this.left = r4;
            this.top = r5;
            this.right = r6;
            this.bottom = r7;
            boolean r0 = true;
            if (r4 < MenuKt.ClosedAlphaTarget) goto L5;
            boolean r8 = true;
        L7:
            if (r5 < MenuKt.ClosedAlphaTarget) goto L9;
            boolean r9 = true;
        L10:
            boolean r10 = r8 & r9;
            if (r6 < MenuKt.ClosedAlphaTarget) goto L13;
            boolean r11 = true;
        L14:
            boolean r12 = r10 & r11;
            if (r7 >= MenuKt.ClosedAlphaTarget) goto L19;
            r0 = false;
        L19:
            if ((r12 & r0) == true) goto L22;
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
            return;
        L22:
            return;
        L13:
            r11 = false;
            goto L14
        L9:
            r9 = false;
            goto L10
        L5:
            r8 = false;
            goto L7
        }

        public /* synthetic */ Absolute(float r8, float r9, float r10, float r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L5;
            r8 = Dp.constructor-impl(0);
        L5:
            float r2 = r8;
            if ((r12 & 2) == 0) goto L8;
            r9 = Dp.constructor-impl(0);
        L8:
            float r3 = r9;
            if ((r12 & 4) == 0) goto L11;
            r10 = Dp.constructor-impl(0);
        L11:
            float r4 = r10;
            if ((r12 & 8) == 0) goto L14;
            r11 = Dp.constructor-impl(0);
        L14:
            this(r2, r3, r4, r11, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/foundation/layout/PaddingValues;", "getZero$annotations", "getZero", "()Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final PaddingValues Zero = null;

        private Companion() {
        }

        public static /* synthetic */ void getZero$annotations() {
        }

        static {
            $$INSTANCE = new Companion();
            Zero = new Absolute(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        }

        public final PaddingValues getZero() {
            return Zero;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    float mo898calculateBottomPaddingD9Ej5fM();

    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    float mo899calculateLeftPaddingu2uoSUM(LayoutDirection r1);

    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    float mo900calculateRightPaddingu2uoSUM(LayoutDirection r1);

    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    float mo901calculateTopPaddingD9Ej5fM();
}
