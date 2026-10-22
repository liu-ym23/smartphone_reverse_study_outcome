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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_refresh", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Refresh", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRefresh", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RefreshKt {
    private static ImageVector _refresh;

    public static final ImageVector getRefresh(Icons.TwoTone r30) {
        ImageVector r0 = _refresh;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Refresh", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(17.65f, 6.35f);
        r7.curveTo(16.2f, 4.9f, 14.21f, 4.0f, 12.0f, 4.0f);
        r7.curveToRelative(-4.42f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -7.99f, 3.58f, -7.99f, 8.0f);
        r7.reflectiveCurveToRelative(3.57f, 8.0f, 7.99f, 8.0f);
        r7.curveToRelative(3.73f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 6.84f, -2.55f, 7.73f, -6.0f);
        r7.horizontalLineToRelative(-2.08f);
        r7.curveToRelative(-0.82f, 2.33f, -3.04f, 4.0f, -5.65f, 4.0f);
        r7.curveToRelative(-3.31f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -6.0f, -2.69f, -6.0f, -6.0f);
        r7.reflectiveCurveToRelative(2.69f, -6.0f, 6.0f, -6.0f);
        r7.curveToRelative(1.66f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.14f, 0.69f, 4.22f, 1.78f);
        r7.lineTo(13.0f, 11.0f);
        r7.horizontalLineToRelative(7.0f);
        r7.verticalLineTo(4.0f);
        r7.lineToRelative(-2.35f, 2.35f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _refresh = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
