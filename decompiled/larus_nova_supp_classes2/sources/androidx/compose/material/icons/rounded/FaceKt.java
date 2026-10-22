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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_face", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face", "Landroidx/compose/material/icons/Icons$Rounded;", "getFace", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FaceKt {
    private static ImageVector _face;

    public static final ImageVector getFace(Icons.Rounded r30) {
        ImageVector r0 = _face;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Rounded.Face", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(10.25f, 13.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.69f, -0.56f, 1.25f, -1.25f, 1.25f);
        r7.reflectiveCurveTo(7.75f, 13.69f, 7.75f, 13.0f);
        r7.reflectiveCurveTo(8.31f, 11.75f, 9.0f, 11.75f);
        r7.reflectiveCurveTo(10.25f, 12.31f, 10.25f, 13.0f);
        r7.close();
        r7.moveTo(15.0f, 11.75f);
        r7.curveToRelative(-0.69f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.25f, 0.56f, -1.25f, 1.25f);
        r7.reflectiveCurveToRelative(0.56f, 1.25f, 1.25f, 1.25f);
        r7.reflectiveCurveToRelative(1.25f, -0.56f, 1.25f, -1.25f);
        r7.reflectiveCurveTo(15.69f, 11.75f, 15.0f, 11.75f);
        r7.close();
        r7.moveTo(22.0f, 12.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 5.52f, -4.48f, 10.0f, -10.0f, 10.0f);
        r7.reflectiveCurveTo(2.0f, 17.52f, 2.0f, 12.0f);
        r7.reflectiveCurveTo(6.48f, 2.0f, 12.0f, 2.0f);
        r7.reflectiveCurveTo(22.0f, 6.48f, 22.0f, 12.0f);
        r7.close();
        r7.moveTo(20.0f, 12.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.78f, -0.12f, -1.53f, -0.33f, -2.24f);
        r7.curveTo(18.97f, 9.91f, 18.25f, 10.0f, 17.5f, 10.0f);
        r7.curveToRelative(-3.13f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -5.92f, -1.44f, -7.76f, -3.69f);
        r7.curveTo(8.69f, 8.87f, 6.6f, 10.88f, 4.0f, 11.86f);
        r7.curveTo(4.01f, 11.9f, 4.0f, 11.95f, 4.0f, 12.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4.41f, 3.59f, 8.0f, 8.0f, 8.0f);
        r7.reflectiveCurveTo(20.0f, 16.41f, 20.0f, 12.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _face = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
