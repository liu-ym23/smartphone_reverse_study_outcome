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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccountCircleKt {
    private static ImageVector _accountCircle;

    public static final ImageVector getAccountCircle(Icons.Outlined r47) {
        ImageVector r0 = _accountCircle;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Outlined.AccountCircle", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(12.0f, 2.0f);
        r6.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        r6.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        r6.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        r6.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        r6.close();
        r6.moveTo(7.35f, 18.5f);
        r6.curveTo(8.66f, 17.56f, 10.26f, 17.0f, 12.0f, 17.0f);
        r6.reflectiveCurveToRelative(3.34f, 0.56f, 4.65f, 1.5f);
        r6.curveTo(15.34f, 19.44f, 13.74f, 20.0f, 12.0f, 20.0f);
        r6.reflectiveCurveTo(8.66f, 19.44f, 7.35f, 18.5f);
        r6.close();
        r6.moveTo(18.14f, 17.12f);
        r6.lineTo(18.14f, 17.12f);
        r6.curveTo(16.45f, 15.8f, 14.32f, 15.0f, 12.0f, 15.0f);
        r6.reflectiveCurveToRelative(-4.45f, 0.8f, -6.14f, 2.12f);
        r6.lineToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r6.curveTo(4.7f, 15.73f, 4.0f, 13.95f, 4.0f, 12.0f);
        r6.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -4.42f, 3.58f, -8.0f, 8.0f, -8.0f);
        r6.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
        r6.curveTo(20.0f, 13.95f, 19.3f, 15.73f, 18.14f, 17.12f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(12.0f, 6.0f);
        r8.curveToRelative(-1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.5f, 1.57f, -3.5f, 3.5f);
        r8.reflectiveCurveTo(10.07f, 13.0f, 12.0f, 13.0f);
        r8.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        r8.reflectiveCurveTo(13.93f, 6.0f, 12.0f, 6.0f);
        r8.close();
        r8.moveTo(12.0f, 11.0f);
        r8.curveToRelative(-0.83f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.5f, -0.67f, -1.5f, -1.5f);
        r8.reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f);
        r8.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        r8.reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _accountCircle = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
