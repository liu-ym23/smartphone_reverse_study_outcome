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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_favorite", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Favorite", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFavorite", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FavoriteKt {
    private static ImageVector _favorite;

    public static final ImageVector getFavorite(Icons.TwoTone r47) {
        ImageVector r0 = _favorite;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Favorite", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(16.5f, 5.0f);
        r6.curveToRelative(-1.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.04f, 0.99f, -3.56f, 2.36f);
        r6.horizontalLineToRelative(-1.87f);
        r6.curveTo(10.54f, 5.99f, 9.04f, 5.0f, 7.5f, 5.0f);
        r6.curveTo(5.5f, 5.0f, 4.0f, 6.5f, 4.0f, 8.5f);
        r6.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.89f, 3.14f, 5.74f, 7.9f, 10.05f);
        r6.lineToRelative(0.1f, 0.1f);
        r6.lineToRelative(0.1f, -0.1f);
        r6.curveTo(16.86f, 14.24f, 20.0f, 11.39f, 20.0f, 8.5f);
        r6.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.0f, -1.5f, -3.5f, -3.5f, -3.5f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(16.5f, 3.0f);
        r8.curveToRelative(-1.74f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.41f, 0.81f, -4.5f, 2.09f);
        r8.curveTo(10.91f, 3.81f, 9.24f, 3.0f, 7.5f, 3.0f);
        r8.curveTo(4.42f, 3.0f, 2.0f, 5.42f, 2.0f, 8.5f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.78f, 3.4f, 6.86f, 8.55f, 11.54f);
        r8.lineTo(12.0f, 21.35f);
        r8.lineToRelative(1.45f, -1.32f);
        r8.curveTo(18.6f, 15.36f, 22.0f, 12.28f, 22.0f, 8.5f);
        r8.curveTo(22.0f, 5.42f, 19.58f, 3.0f, 16.5f, 3.0f);
        r8.close();
        r8.moveTo(12.1f, 18.55f);
        r8.lineToRelative(-0.1f, 0.1f);
        r8.lineToRelative(-0.1f, -0.1f);
        r8.curveTo(7.14f, 14.24f, 4.0f, 11.39f, 4.0f, 8.5f);
        r8.curveTo(4.0f, 6.5f, 5.5f, 5.0f, 7.5f, 5.0f);
        r8.curveToRelative(1.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.04f, 0.99f, 3.57f, 2.36f);
        r8.horizontalLineToRelative(1.87f);
        r8.curveTo(13.46f, 5.99f, 14.96f, 5.0f, 16.5f, 5.0f);
        r8.curveToRelative(2.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.5f, 1.5f, 3.5f, 3.5f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.89f, -3.14f, 5.74f, -7.9f, 10.05f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _favorite = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
