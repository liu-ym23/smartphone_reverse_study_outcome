package androidx.compose.foundation.text.input.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a$\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000fH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0010"}, d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "F", "isSpecified", "", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/Brush;)Z", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorRect", "rtl", "textLayoutSize", "", "roundToNext", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldCoreModifierKt {
    private static final float DefaultCursorThickness = 0.0f;

    static {
        DefaultCursorThickness = Dp.constructor-impl(2);
    }

    public static final /* synthetic */ boolean access$isSpecified(Brush r0) {
        return isSpecified(r0);
    }

    public static final /* synthetic */ float access$roundToNext(float r0) {
        return roundToNext(r0);
    }

    private static final boolean isSpecified(Brush r6) {
        if ((r6 instanceof SolidColor) == true) goto L5;
        return true;
    L5:
        if (((SolidColor) r6).getValue-0d7_KjU() != 16) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L13;
        return false;
    L13:
        return true;
    L7:
        r0 = false;
        goto L8
    }

    private static final float roundToNext(float r2) {
        if (Float.isNaN(r2) == false) goto L5;
        return r2;
    L5:
        if (Float.isInfinite(r2) == false) goto L8;
        return r2;
    L8:
        if (r2 <= MenuKt.ClosedAlphaTarget) goto L10;
        double r0 = Math.ceil(r2);
    L12:
        return (float) r0;
    L10:
        r0 = Math.floor(r2);
        goto L12
    }

    public static final /* synthetic */ Rect access$getCursorRectInScroller(Density r0, Rect r1, boolean r2, int r3) {
        return getCursorRectInScroller(r0, r1, r2, r3);
    }

    private static final Rect getCursorRectInScroller(Density r8, Rect r9, boolean r10, int r11) {
        int r12 = r8.roundToPx-0680j_4(DefaultCursorThickness);
        if (r10 == false) goto L5;
        float r0 = r11 - r9.getRight();
    L6:
        float r2 = r0;
        if (r10 == false) goto L9;
        float r13 = r11 - r9.getRight();
    L11:
        return Rect.copy$default(r9, r2, MenuKt.ClosedAlphaTarget, r13 + r12, MenuKt.ClosedAlphaTarget, 10, null);
    L9:
        r13 = r9.getLeft();
        goto L11
    L5:
        r0 = r9.getLeft();
        goto L6
    }
}
