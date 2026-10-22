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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_checkCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CheckCircle", "Landroidx/compose/material/icons/Icons$TwoTone;", "getCheckCircle", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CheckCircleKt {
    private static ImageVector _checkCircle;

    public static final ImageVector getCheckCircle(Icons.TwoTone r47) {
        ImageVector r0 = _checkCircle;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.CheckCircle", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(12.0f, 4.0f);
        r6.curveToRelative(-4.41f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -8.0f, 3.59f, -8.0f, 8.0f);
        r6.reflectiveCurveToRelative(3.59f, 8.0f, 8.0f, 8.0f);
        r6.reflectiveCurveToRelative(8.0f, -3.59f, 8.0f, -8.0f);
        r6.reflectiveCurveToRelative(-3.59f, -8.0f, -8.0f, -8.0f);
        r6.close();
        r6.moveTo(10.0f, 17.0f);
        r6.lineToRelative(-4.0f, -4.0f);
        r6.lineToRelative(1.41f, -1.41f);
        r6.lineTo(10.0f, 14.17f);
        r6.lineToRelative(6.59f, -6.59f);
        r6.lineTo(18.0f, 9.0f);
        r6.lineToRelative(-8.0f, 8.0f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r11 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(12.0f, 2.0f);
        r7.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        r7.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        r7.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        r7.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        r7.close();
        r7.moveTo(12.0f, 20.0f);
        r7.curveToRelative(-4.41f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -8.0f, -3.59f, -8.0f, -8.0f);
        r7.reflectiveCurveToRelative(3.59f, -8.0f, 8.0f, -8.0f);
        r7.reflectiveCurveToRelative(8.0f, 3.59f, 8.0f, 8.0f);
        r7.reflectiveCurveToRelative(-3.59f, 8.0f, -8.0f, 8.0f);
        r7.close();
        r7.moveTo(16.59f, 7.58f);
        r7.lineTo(10.0f, 14.17f);
        r7.lineToRelative(-2.59f, -2.58f);
        r7.lineTo(6.0f, 13.0f);
        r7.lineToRelative(4.0f, 4.0f);
        r7.lineToRelative(8.0f, -8.0f);
        r7.close();
        ImageVector r8 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r32, "", r11, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _checkCircle = r8;
        Intrinsics.checkNotNull(r8);
        return r8;
    }
}
