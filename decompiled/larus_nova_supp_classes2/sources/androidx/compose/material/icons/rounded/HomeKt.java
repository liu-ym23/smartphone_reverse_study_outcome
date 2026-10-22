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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_home", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Home", "Landroidx/compose/material/icons/Icons$Rounded;", "getHome", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HomeKt {
    private static ImageVector _home;

    public static final ImageVector getHome(Icons.Rounded r30) {
        ImageVector r0 = _home;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Rounded.Home", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(10.0f, 19.0f);
        r7.verticalLineToRelative(-5.0f);
        r7.horizontalLineToRelative(4.0f);
        r7.verticalLineToRelative(5.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        r7.horizontalLineToRelative(3.0f);
        r7.curveToRelative(0.55f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, -0.45f, 1.0f, -1.0f);
        r7.verticalLineToRelative(-7.0f);
        r7.horizontalLineToRelative(1.7f);
        r7.curveToRelative(0.46f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.68f, -0.57f, 0.33f, -0.87f);
        r7.lineTo(12.67f, 3.6f);
        r7.curveToRelative(-0.38f, -0.34f, -0.96f, -0.34f, -1.34f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r7.lineToRelative(-8.36f, 7.53f);
        r7.curveToRelative(-0.34f, 0.3f, -0.13f, 0.87f, 0.33f, 0.87f);
        r7.horizontalLineTo(5.0f);
        r7.verticalLineToRelative(7.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        r7.horizontalLineToRelative(3.0f);
        r7.curveToRelative(0.55f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, -0.45f, 1.0f, -1.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _home = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
