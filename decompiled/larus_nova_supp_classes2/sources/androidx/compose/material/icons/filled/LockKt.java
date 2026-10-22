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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_lock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Lock", "Landroidx/compose/material/icons/Icons$Filled;", "getLock", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LockKt {
    private static ImageVector _lock;

    public static final ImageVector getLock(Icons.Filled r30) {
        ImageVector r0 = _lock;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Filled.Lock", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(18.0f, 8.0f);
        r7.horizontalLineToRelative(-1.0f);
        r7.lineTo(17.0f, 6.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.76f, -2.24f, -5.0f, -5.0f, -5.0f);
        r7.reflectiveCurveTo(7.0f, 3.24f, 7.0f, 6.0f);
        r7.verticalLineToRelative(2.0f);
        r7.lineTo(6.0f, 8.0f);
        r7.curveToRelative(-1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.0f, 0.9f, -2.0f, 2.0f);
        r7.verticalLineToRelative(10.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        r7.horizontalLineToRelative(12.0f);
        r7.curveToRelative(1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.0f, -0.9f, 2.0f, -2.0f);
        r7.lineTo(20.0f, 10.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        r7.close();
        r7.moveTo(12.0f, 17.0f);
        r7.curveToRelative(-1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.0f, -0.9f, -2.0f, -2.0f);
        r7.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        r7.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        r7.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
        r7.close();
        r7.moveTo(15.1f, 8.0f);
        r7.lineTo(8.9f, 8.0f);
        r7.lineTo(8.9f, 6.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.71f, 1.39f, -3.1f, 3.1f, -3.1f);
        r7.curveToRelative(1.71f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.1f, 1.39f, 3.1f, 3.1f);
        r7.verticalLineToRelative(2.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _lock = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
