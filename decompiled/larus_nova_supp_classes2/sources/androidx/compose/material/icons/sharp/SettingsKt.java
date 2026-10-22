package androidx.compose.material.icons.sharp;

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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Sharp;", "getSettings", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SettingsKt {
    private static ImageVector _settings;

    public static final ImageVector getSettings(Icons.Sharp r30) {
        ImageVector r0 = _settings;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Sharp.Settings", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(19.44f, 12.99f);
        r7.lineToRelative(-0.01f, 0.02f);
        r7.curveToRelative(0.04f, -0.33f, 0.08f, -0.67f, 0.08f, -1.01f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.34f, -0.03f, -0.66f, -0.07f, -0.99f);
        r7.lineToRelative(0.01f, 0.02f);
        r7.lineToRelative(2.44f, -1.92f);
        r7.lineToRelative(-2.43f, -4.22f);
        r7.lineToRelative(-2.87f, 1.16f);
        r7.lineToRelative(0.01f, 0.01f);
        r7.curveToRelative(-0.52f, -0.4f, -1.09f, -0.74f, -1.71f, -1.0f);
        r7.horizontalLineToRelative(0.01f);
        r7.lineTo(14.44f, 2.0f);
        r7.horizontalLineTo(9.57f);
        r7.lineToRelative(-0.44f, 3.07f);
        r7.horizontalLineToRelative(0.01f);
        r7.curveToRelative(-0.62f, 0.26f, -1.19f, 0.6f, -1.71f, 1.0f);
        r7.lineToRelative(0.01f, -0.01f);
        r7.lineToRelative(-2.88f, -1.17f);
        r7.lineToRelative(-2.44f, 4.22f);
        r7.lineToRelative(2.44f, 1.92f);
        r7.lineToRelative(0.01f, -0.02f);
        r7.curveToRelative(-0.04f, 0.33f, -0.07f, 0.65f, -0.07f, 0.99f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.34f, 0.03f, 0.68f, 0.08f, 1.01f);
        r7.lineToRelative(-0.01f, -0.02f);
        r7.lineToRelative(-2.1f, 1.65f);
        r7.lineToRelative(-0.33f, 0.26f);
        r7.lineToRelative(2.43f, 4.2f);
        r7.lineToRelative(2.88f, -1.15f);
        r7.lineToRelative(-0.02f, -0.04f);
        r7.curveToRelative(0.53f, 0.41f, 1.1f, 0.75f, 1.73f, 1.01f);
        r7.horizontalLineToRelative(-0.03f);
        r7.lineTo(9.58f, 22.0f);
        r7.horizontalLineToRelative(4.85f);
        r7.reflectiveCurveToRelative(0.03f, -0.18f, 0.06f, -0.42f);
        r7.lineToRelative(0.38f, -2.65f);
        r7.horizontalLineToRelative(-0.01f);
        r7.curveToRelative(0.62f, -0.26f, 1.2f, -0.6f, 1.73f, -1.01f);
        r7.lineToRelative(-0.02f, 0.04f);
        r7.lineToRelative(2.88f, 1.15f);
        r7.lineToRelative(2.43f, -4.2f);
        r7.reflectiveCurveToRelative(-0.14f, -0.12f, -0.33f, -0.26f);
        r7.lineToRelative(-2.11f, -1.66f);
        r7.close();
        r7.moveTo(12.0f, 15.5f);
        r7.curveToRelative(-1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.5f, -1.57f, -3.5f, -3.5f);
        r7.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        r7.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        r7.reflectiveCurveToRelative(-1.57f, 3.5f, -3.5f, 3.5f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _settings = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
