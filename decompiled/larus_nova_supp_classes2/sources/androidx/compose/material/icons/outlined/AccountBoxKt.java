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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$Outlined;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccountBoxKt {
    private static ImageVector _accountBox;

    public static final ImageVector getAccountBox(Icons.Outlined r30) {
        ImageVector r0 = _accountBox;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Outlined.AccountBox", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(19.0f, 3.0f);
        r7.horizontalLineTo(5.0f);
        r7.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
        r7.verticalLineToRelative(14.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        r7.horizontalLineToRelative(14.0f);
        r7.curveToRelative(1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.0f, -0.9f, 2.0f, -2.0f);
        r7.verticalLineTo(5.0f);
        r7.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
        r7.close();
        r7.moveTo(17.0f, 19.0f);
        r7.horizontalLineTo(7.0f);
        r7.verticalLineToRelative(-0.24f);
        r7.curveTo(8.42f, 17.62f, 10.16f, 17.0f, 12.0f, 17.0f);
        r7.reflectiveCurveToRelative(3.58f, 0.62f, 5.0f, 1.76f);
        r7.verticalLineTo(19.0f);
        r7.close();
        r7.moveTo(19.0f, 17.86f);
        r7.curveTo(17.2f, 16.09f, 14.73f, 15.0f, 12.0f, 15.0f);
        r7.reflectiveCurveToRelative(-5.2f, 1.09f, -7.0f, 2.86f);
        r7.verticalLineTo(5.0f);
        r7.horizontalLineToRelative(14.0f);
        r7.verticalLineTo(17.86f);
        r7.close();
        r7.moveTo(12.0f, 13.0f);
        r7.curveToRelative(1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.5f, -1.57f, 3.5f, -3.5f);
        r7.reflectiveCurveTo(13.93f, 6.0f, 12.0f, 6.0f);
        r7.curveToRelative(-1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.5f, 1.57f, -3.5f, 3.5f);
        r7.reflectiveCurveTo(10.07f, 13.0f, 12.0f, 13.0f);
        r7.close();
        r7.moveTo(12.0f, 8.0f);
        r7.curveToRelative(0.83f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.5f, 0.67f, 1.5f, 1.5f);
        r7.reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f);
        r7.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        r7.reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _accountBox = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
