package androidx.compose.material.icons.twotone;

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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_place", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Place", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPlace", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceKt {
    private static ImageVector _place;

    public static final ImageVector getPlace(Icons.TwoTone r47) {
        ImageVector r0 = _place;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Place", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(18.5f, 10.2f);
        r6.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.57f, -2.1f, 5.79f, -6.16f, 9.51f);
        r6.lineTo(12.0f, 20.01f);
        r6.lineToRelative(-0.34f, -0.31f);
        r6.curveTo(7.6f, 15.99f, 5.5f, 12.77f, 5.5f, 10.2f);
        r6.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.84f, 2.82f, -6.7f, 6.5f, -6.7f);
        r6.reflectiveCurveTo(18.5f, 6.35f, 18.5f, 10.2f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(12.0f, 2.0f);
        r8.curveToRelative(4.2f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 8.0f, 3.22f, 8.0f, 8.2f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.32f, -2.67f, 7.25f, -8.0f, 11.8f);
        r8.curveToRelative(-5.33f, -4.55f, -8.0f, -8.48f, -8.0f, -11.8f);
        r8.curveTo(4.0f, 5.22f, 7.8f, 2.0f, 12.0f, 2.0f);
        r8.close();
        r8.moveTo(18.0f, 10.2f);
        r8.curveTo(18.0f, 6.57f, 15.35f, 4.0f, 12.0f, 4.0f);
        r8.reflectiveCurveToRelative(-6.0f, 2.57f, -6.0f, 6.2f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.34f, 1.95f, 5.44f, 6.0f, 9.14f);
        r8.curveTo(16.05f, 15.64f, 18.0f, 12.54f, 18.0f, 10.2f);
        r8.close();
        r8.moveTo(12.0f, 12.0f);
        r8.curveToRelative(-1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.0f, -0.9f, -2.0f, -2.0f);
        r8.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        r8.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        r8.reflectiveCurveTo(13.1f, 12.0f, 12.0f, 12.0f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _place = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
