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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_warning", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Warning", "Landroidx/compose/material/icons/Icons$Rounded;", "getWarning", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WarningKt {
    private static ImageVector _warning;

    public static final ImageVector getWarning(Icons.Rounded r30) {
        ImageVector r0 = _warning;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Rounded.Warning", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(4.47f, 21.0f);
        r7.horizontalLineToRelative(15.06f);
        r7.curveToRelative(1.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.5f, -1.67f, 1.73f, -3.0f);
        r7.lineTo(13.73f, 4.99f);
        r7.curveToRelative(-0.77f, -1.33f, -2.69f, -1.33f, -3.46f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r7.lineTo(2.74f, 18.0f);
        r7.curveToRelative(-0.77f, 1.33f, 0.19f, 3.0f, 1.73f, 3.0f);
        r7.close();
        r7.moveTo(12.0f, 14.0f);
        r7.curveToRelative(-0.55f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.0f, -0.45f, -1.0f, -1.0f);
        r7.verticalLineToRelative(-2.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
        r7.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        r7.verticalLineToRelative(2.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        r7.close();
        r7.moveTo(13.0f, 18.0f);
        r7.horizontalLineToRelative(-2.0f);
        r7.verticalLineToRelative(-2.0f);
        r7.horizontalLineToRelative(2.0f);
        r7.verticalLineToRelative(2.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _warning = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
