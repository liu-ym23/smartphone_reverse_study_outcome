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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_thumbUp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbUp", "Landroidx/compose/material/icons/Icons$TwoTone;", "getThumbUp", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ThumbUpKt {
    private static ImageVector _thumbUp;

    public static final ImageVector getThumbUp(Icons.TwoTone r47) {
        ImageVector r0 = _thumbUp;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.ThumbUp", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(21.0f, 12.0f);
        r6.verticalLineToRelative(-2.0f);
        r6.horizontalLineToRelative(-9.0f);
        r6.lineToRelative(1.34f, -5.34f);
        r6.lineTo(9.0f, 9.0f);
        r6.verticalLineToRelative(10.0f);
        r6.horizontalLineToRelative(9.0f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(9.0f, 21.0f);
        r8.horizontalLineToRelative(9.0f);
        r8.curveToRelative(0.83f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.54f, -0.5f, 1.84f, -1.22f);
        r8.lineToRelative(3.02f, -7.05f);
        r8.curveToRelative(0.09f, -0.23f, 0.14f, -0.47f, 0.14f, -0.73f);
        r8.verticalLineToRelative(-2.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        r8.horizontalLineToRelative(-6.31f);
        r8.lineToRelative(0.95f, -4.57f);
        r8.lineToRelative(0.03f, -0.32f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.41f, -0.17f, -0.79f, -0.44f, -1.06f);
        r8.lineTo(14.17f, 1.0f);
        r8.lineTo(7.58f, 7.59f);
        r8.curveTo(7.22f, 7.95f, 7.0f, 8.45f, 7.0f, 9.0f);
        r8.verticalLineToRelative(10.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        r8.close();
        r8.moveTo(9.0f, 9.0f);
        r8.lineToRelative(4.34f, -4.34f);
        r8.lineTo(12.0f, 10.0f);
        r8.horizontalLineToRelative(9.0f);
        r8.verticalLineToRelative(2.0f);
        r8.lineToRelative(-3.0f, 7.0f);
        r8.horizontalLineTo(9.0f);
        r8.verticalLineTo(9.0f);
        r8.close();
        r8.moveTo(1.0f, 9.0f);
        r8.horizontalLineToRelative(4.0f);
        r8.verticalLineToRelative(12.0f);
        r8.horizontalLineTo(1.0f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _thumbUp = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
