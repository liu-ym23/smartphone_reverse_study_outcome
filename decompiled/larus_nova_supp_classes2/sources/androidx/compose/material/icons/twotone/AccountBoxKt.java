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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AccountBoxKt {
    private static ImageVector _accountBox;

    public static final ImageVector getAccountBox(Icons.TwoTone r64) {
        ImageVector r0 = _accountBox;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.AccountBox", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(5.0f, 17.86f);
        r6.curveTo(6.8f, 16.09f, 9.27f, 15.0f, 12.0f, 15.0f);
        r6.reflectiveCurveToRelative(5.2f, 1.09f, 7.0f, 2.86f);
        r6.verticalLineTo(5.0f);
        r6.horizontalLineTo(5.0f);
        r6.verticalLineTo(17.86f);
        r6.close();
        r6.moveTo(12.0f, 6.0f);
        r6.curveToRelative(1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.5f, 1.57f, 3.5f, 3.5f);
        r6.reflectiveCurveTo(13.93f, 13.0f, 12.0f, 13.0f);
        r6.curveToRelative(-1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.5f, -1.57f, -3.5f, -3.5f);
        r6.reflectiveCurveTo(10.07f, 6.0f, 12.0f, 6.0f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(19.0f, 3.0f);
        r8.horizontalLineTo(5.0f);
        r8.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
        r8.verticalLineToRelative(14.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        r8.horizontalLineToRelative(14.0f);
        r8.curveToRelative(1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.0f, -0.9f, 2.0f, -2.0f);
        r8.verticalLineTo(5.0f);
        r8.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
        r8.close();
        r8.moveTo(17.0f, 19.0f);
        r8.horizontalLineTo(7.0f);
        r8.verticalLineToRelative(-0.24f);
        r8.curveTo(8.42f, 17.62f, 10.16f, 17.0f, 12.0f, 17.0f);
        r8.reflectiveCurveToRelative(3.58f, 0.62f, 5.0f, 1.76f);
        r8.verticalLineTo(19.0f);
        r8.close();
        r8.moveTo(19.0f, 17.86f);
        r8.curveTo(17.2f, 16.09f, 14.73f, 15.0f, 12.0f, 15.0f);
        r8.reflectiveCurveToRelative(-5.2f, 1.09f, -7.0f, 2.86f);
        r8.verticalLineTo(5.0f);
        r8.horizontalLineToRelative(14.0f);
        r8.verticalLineTo(17.86f);
        r8.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r49 = VectorKt.getDefaultFillType();
        SolidColor r9 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r56 = r4.getButt-KaPHkGw();
        int r57 = r5.getBevel-LxFBmk8();
        PathBuilder r10 = new PathBuilder();
        r10.moveTo(12.0f, 13.0f);
        r10.curveToRelative(1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.5f, -1.57f, 3.5f, -3.5f);
        r10.reflectiveCurveTo(13.93f, 6.0f, 12.0f, 6.0f);
        r10.curveToRelative(-1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.5f, 1.57f, -3.5f, 3.5f);
        r10.reflectiveCurveTo(10.07f, 13.0f, 12.0f, 13.0f);
        r10.close();
        r10.moveTo(12.0f, 8.0f);
        r10.curveToRelative(0.83f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.5f, 0.67f, 1.5f, 1.5f);
        r10.reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f);
        r10.reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f);
        r10.reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f);
        r10.close();
        ImageVector r11 = ImageVector.Builder.addPath-oIyEayM$default(r1, r10.getNodes(), r49, "", r9, 1.0f, null, 1.0f, 1.0f, r56, r57, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _accountBox = r11;
        Intrinsics.checkNotNull(r11);
        return r11;
    }
}
