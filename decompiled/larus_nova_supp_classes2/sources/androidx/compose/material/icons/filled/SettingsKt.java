package androidx.compose.material.icons.filled;

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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Filled;", "getSettings", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SettingsKt {
    private static ImageVector _settings;

    public static final ImageVector getSettings(Icons.Filled r30) {
        ImageVector r0 = _settings;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Filled.Settings", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(19.14f, 12.94f);
        r7.curveToRelative(0.04f, -0.3f, 0.06f, -0.61f, 0.06f, -0.94f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.32f, -0.02f, -0.64f, -0.07f, -0.94f);
        r7.lineToRelative(2.03f, -1.58f);
        r7.curveToRelative(0.18f, -0.14f, 0.23f, -0.41f, 0.12f, -0.61f);
        r7.lineToRelative(-1.92f, -3.32f);
        r7.curveToRelative(-0.12f, -0.22f, -0.37f, -0.29f, -0.59f, -0.22f);
        r7.lineToRelative(-2.39f, 0.96f);
        r7.curveToRelative(-0.5f, -0.38f, -1.03f, -0.7f, -1.62f, -0.94f);
        r7.lineTo(14.4f, 2.81f);
        r7.curveToRelative(-0.04f, -0.24f, -0.24f, -0.41f, -0.48f, -0.41f);
        r7.horizontalLineToRelative(-3.84f);
        r7.curveToRelative(-0.24f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.43f, 0.17f, -0.47f, 0.41f);
        r7.lineTo(9.25f, 5.35f);
        r7.curveTo(8.66f, 5.59f, 8.12f, 5.92f, 7.63f, 6.29f);
        r7.lineTo(5.24f, 5.33f);
        r7.curveToRelative(-0.22f, -0.08f, -0.47f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.59f, 0.22f);
        r7.lineTo(2.74f, 8.87f);
        r7.curveTo(2.62f, 9.08f, 2.66f, 9.34f, 2.86f, 9.48f);
        r7.lineToRelative(2.03f, 1.58f);
        r7.curveTo(4.84f, 11.36f, 4.8f, 11.69f, 4.8f, 12.0f);
        r7.reflectiveCurveToRelative(0.02f, 0.64f, 0.07f, 0.94f);
        r7.lineToRelative(-2.03f, 1.58f);
        r7.curveToRelative(-0.18f, 0.14f, -0.23f, 0.41f, -0.12f, 0.61f);
        r7.lineToRelative(1.92f, 3.32f);
        r7.curveToRelative(0.12f, 0.22f, 0.37f, 0.29f, 0.59f, 0.22f);
        r7.lineToRelative(2.39f, -0.96f);
        r7.curveToRelative(0.5f, 0.38f, 1.03f, 0.7f, 1.62f, 0.94f);
        r7.lineToRelative(0.36f, 2.54f);
        r7.curveToRelative(0.05f, 0.24f, 0.24f, 0.41f, 0.48f, 0.41f);
        r7.horizontalLineToRelative(3.84f);
        r7.curveToRelative(0.24f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.44f, -0.17f, 0.47f, -0.41f);
        r7.lineToRelative(0.36f, -2.54f);
        r7.curveToRelative(0.59f, -0.24f, 1.13f, -0.56f, 1.62f, -0.94f);
        r7.lineToRelative(2.39f, 0.96f);
        r7.curveToRelative(0.22f, 0.08f, 0.47f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.59f, -0.22f);
        r7.lineToRelative(1.92f, -3.32f);
        r7.curveToRelative(0.12f, -0.22f, 0.07f, -0.47f, -0.12f, -0.61f);
        r7.lineTo(19.14f, 12.94f);
        r7.close();
        r7.moveTo(12.0f, 15.6f);
        r7.curveToRelative(-1.98f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.6f, -1.62f, -3.6f, -3.6f);
        r7.reflectiveCurveToRelative(1.62f, -3.6f, 3.6f, -3.6f);
        r7.reflectiveCurveToRelative(3.6f, 1.62f, 3.6f, 3.6f);
        r7.reflectiveCurveTo(13.98f, 15.6f, 12.0f, 15.6f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _settings = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
