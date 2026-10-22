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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_thumbUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbUp", "Landroidx/compose/material/icons/Icons$Outlined;", "getThumbUp", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThumbUpKt {
    private static ImageVector _thumbUp;

    public static final ImageVector getThumbUp(Icons.Outlined r30) {
        ImageVector r0 = _thumbUp;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Outlined.ThumbUp", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(9.0f, 21.0f);
        r7.horizontalLineToRelative(9.0f);
        r7.curveToRelative(0.83f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.54f, -0.5f, 1.84f, -1.22f);
        r7.lineToRelative(3.02f, -7.05f);
        r7.curveToRelative(0.09f, -0.23f, 0.14f, -0.47f, 0.14f, -0.73f);
        r7.verticalLineToRelative(-2.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        r7.horizontalLineToRelative(-6.31f);
        r7.lineToRelative(0.95f, -4.57f);
        r7.lineToRelative(0.03f, -0.32f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.41f, -0.17f, -0.79f, -0.44f, -1.06f);
        r7.lineTo(14.17f, 1.0f);
        r7.lineTo(7.58f, 7.59f);
        r7.curveTo(7.22f, 7.95f, 7.0f, 8.45f, 7.0f, 9.0f);
        r7.verticalLineToRelative(10.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        r7.close();
        r7.moveTo(9.0f, 9.0f);
        r7.lineToRelative(4.34f, -4.34f);
        r7.lineTo(12.0f, 10.0f);
        r7.horizontalLineToRelative(9.0f);
        r7.verticalLineToRelative(2.0f);
        r7.lineToRelative(-3.0f, 7.0f);
        r7.horizontalLineTo(9.0f);
        r7.verticalLineTo(9.0f);
        r7.close();
        r7.moveTo(1.0f, 9.0f);
        r7.horizontalLineToRelative(4.0f);
        r7.verticalLineToRelative(12.0f);
        r7.horizontalLineTo(1.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _thumbUp = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
