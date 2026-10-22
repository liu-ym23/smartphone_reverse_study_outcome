package androidx.compose.material.icons.rounded;

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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettings", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SettingsKt {
    private static ImageVector _settings;

    public static final ImageVector getSettings(Icons.Rounded r30) {
        ImageVector r0 = _settings;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Rounded.Settings", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(19.5f, 12.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.23f, -0.01f, -0.45f, -0.03f, -0.68f);
        r7.lineToRelative(1.86f, -1.41f);
        r7.curveToRelative(0.4f, -0.3f, 0.51f, -0.86f, 0.26f, -1.3f);
        r7.lineToRelative(-1.87f, -3.23f);
        r7.curveToRelative(-0.25f, -0.44f, -0.79f, -0.62f, -1.25f, -0.42f);
        r7.lineToRelative(-2.15f, 0.91f);
        r7.curveToRelative(-0.37f, -0.26f, -0.76f, -0.49f, -1.17f, -0.68f);
        r7.lineToRelative(-0.29f, -2.31f);
        r7.curveTo(14.8f, 2.38f, 14.37f, 2.0f, 13.87f, 2.0f);
        r7.horizontalLineToRelative(-3.73f);
        r7.curveTo(9.63f, 2.0f, 9.2f, 2.38f, 9.14f, 2.88f);
        r7.lineTo(8.85f, 5.19f);
        r7.curveToRelative(-0.41f, 0.19f, -0.8f, 0.42f, -1.17f, 0.68f);
        r7.lineTo(5.53f, 4.96f);
        r7.curveToRelative(-0.46f, -0.2f, -1.0f, -0.02f, -1.25f, 0.42f);
        r7.lineTo(2.41f, 8.62f);
        r7.curveToRelative(-0.25f, 0.44f, -0.14f, 0.99f, 0.26f, 1.3f);
        r7.lineToRelative(1.86f, 1.41f);
        r7.curveTo(4.51f, 11.55f, 4.5f, 11.77f, 4.5f, 12.0f);
        r7.reflectiveCurveToRelative(0.01f, 0.45f, 0.03f, 0.68f);
        r7.lineToRelative(-1.86f, 1.41f);
        r7.curveToRelative(-0.4f, 0.3f, -0.51f, 0.86f, -0.26f, 1.3f);
        r7.lineToRelative(1.87f, 3.23f);
        r7.curveToRelative(0.25f, 0.44f, 0.79f, 0.62f, 1.25f, 0.42f);
        r7.lineToRelative(2.15f, -0.91f);
        r7.curveToRelative(0.37f, 0.26f, 0.76f, 0.49f, 1.17f, 0.68f);
        r7.lineToRelative(0.29f, 2.31f);
        r7.curveTo(9.2f, 21.62f, 9.63f, 22.0f, 10.13f, 22.0f);
        r7.horizontalLineToRelative(3.73f);
        r7.curveToRelative(0.5f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.93f, -0.38f, 0.99f, -0.88f);
        r7.lineToRelative(0.29f, -2.31f);
        r7.curveToRelative(0.41f, -0.19f, 0.8f, -0.42f, 1.17f, -0.68f);
        r7.lineToRelative(2.15f, 0.91f);
        r7.curveToRelative(0.46f, 0.2f, 1.0f, 0.02f, 1.25f, -0.42f);
        r7.lineToRelative(1.87f, -3.23f);
        r7.curveToRelative(0.25f, -0.44f, 0.14f, -0.99f, -0.26f, -1.3f);
        r7.lineToRelative(-1.86f, -1.41f);
        r7.curveTo(19.49f, 12.45f, 19.5f, 12.23f, 19.5f, 12.0f);
        r7.close();
        r7.moveTo(12.04f, 15.5f);
        r7.curveToRelative(-1.93f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.5f, -1.57f, -3.5f, -3.5f);
        r7.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        r7.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        r7.reflectiveCurveTo(13.97f, 15.5f, 12.04f, 15.5f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _settings = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
