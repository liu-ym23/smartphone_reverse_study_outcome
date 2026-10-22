package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_place", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Place", "Landroidx/compose/material/icons/Icons$Outlined;", "getPlace", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceKt {
    private static ImageVector _place;

    public static final ImageVector getPlace(Icons.Outlined r30) {
        ImageVector r0 = _place;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Outlined.Place", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(12.0f, 12.0f);
        r7.curveToRelative(-1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.0f, -0.9f, -2.0f, -2.0f);
        r7.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        r7.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        r7.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
        r7.close();
        r7.moveTo(18.0f, 10.2f);
        r7.curveTo(18.0f, 6.57f, 15.35f, 4.0f, 12.0f, 4.0f);
        r7.reflectiveCurveToRelative(-6.0f, 2.57f, -6.0f, 6.2f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.34f, 1.95f, 5.44f, 6.0f, 9.14f);
        r7.curveToRelative(4.05f, -3.7f, 6.0f, -6.8f, 6.0f, -9.14f);
        r7.close();
        r7.moveTo(12.0f, 2.0f);
        r7.curveToRelative(4.2f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 8.0f, 3.22f, 8.0f, 8.2f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.32f, -2.67f, 7.25f, -8.0f, 11.8f);
        r7.curveToRelative(-5.33f, -4.55f, -8.0f, -8.48f, -8.0f, -11.8f);
        r7.curveTo(4.0f, 5.22f, 7.8f, 2.0f, 12.0f, 2.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _place = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
