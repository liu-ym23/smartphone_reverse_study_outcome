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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_locationOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocationOn", "Landroidx/compose/material/icons/Icons$TwoTone;", "getLocationOn", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LocationOnKt {
    private static ImageVector _locationOn;

    public static final ImageVector getLocationOn(Icons.TwoTone r64) {
        ImageVector r0 = _locationOn;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.LocationOn", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(12.0f, 4.0f);
        r6.curveTo(9.24f, 4.0f, 7.0f, 6.24f, 7.0f, 9.0f);
        r6.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.85f, 2.92f, 7.21f, 5.0f, 9.88f);
        r6.curveToRelative(2.11f, -2.69f, 5.0f, -7.0f, 5.0f, -9.88f);
        r6.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.76f, -2.24f, -5.0f, -5.0f, -5.0f);
        r6.close();
        r6.moveTo(12.0f, 11.5f);
        r6.curveToRelative(-1.38f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.5f, -1.12f, -2.5f, -2.5f);
        r6.reflectiveCurveToRelative(1.12f, -2.5f, 2.5f, -2.5f);
        r6.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        r6.reflectiveCurveToRelative(-1.12f, 2.5f, -2.5f, 2.5f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(12.0f, 2.0f);
        r8.curveTo(8.13f, 2.0f, 5.0f, 5.13f, 5.0f, 9.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 5.25f, 7.0f, 13.0f, 7.0f, 13.0f);
        r8.reflectiveCurveToRelative(7.0f, -7.75f, 7.0f, -13.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.87f, -3.13f, -7.0f, -7.0f, -7.0f);
        r8.close();
        r8.moveTo(7.0f, 9.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.76f, 2.24f, -5.0f, 5.0f, -5.0f);
        r8.reflectiveCurveToRelative(5.0f, 2.24f, 5.0f, 5.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.88f, -2.88f, 7.19f, -5.0f, 9.88f);
        r8.curveTo(9.92f, 16.21f, 7.0f, 11.85f, 7.0f, 9.0f);
        r8.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r49 = VectorKt.getDefaultFillType();
        SolidColor r9 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r56 = r4.getButt-KaPHkGw();
        int r57 = r5.getBevel-LxFBmk8();
        PathBuilder r10 = new PathBuilder();
        r10.moveTo(12.0f, 9.0f);
        r10.moveToRelative(-2.5f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r10.arcToRelative(2.5f, 2.5f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, true, true, 5.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r10.arcToRelative(2.5f, 2.5f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, true, true, -5.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        ImageVector r11 = ImageVector.Builder.addPath-oIyEayM$default(r1, r10.getNodes(), r49, "", r9, 1.0f, null, 1.0f, 1.0f, r56, r57, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _locationOn = r11;
        Intrinsics.checkNotNull(r11);
        return r11;
    }
}
