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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Star", "Landroidx/compose/material/icons/Icons$TwoTone;", "getStar", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StarKt {
    private static ImageVector _star;

    public static final ImageVector getStar(Icons.TwoTone r47) {
        ImageVector r0 = _star;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Star", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(12.0f, 15.4f);
        r6.lineToRelative(-3.76f, 2.27f);
        r6.lineToRelative(1.0f, -4.28f);
        r6.lineToRelative(-3.32f, -2.88f);
        r6.lineToRelative(4.38f, -0.38f);
        r6.lineToRelative(1.7f, -4.03f);
        r6.lineToRelative(1.71f, 4.04f);
        r6.lineToRelative(4.38f, 0.38f);
        r6.lineToRelative(-3.32f, 2.88f);
        r6.lineToRelative(1.0f, 4.28f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(22.0f, 9.24f);
        r8.lineToRelative(-7.19f, -0.62f);
        r8.lineTo(12.0f, 2.0f);
        r8.lineTo(9.19f, 8.63f);
        r8.lineTo(2.0f, 9.24f);
        r8.lineToRelative(5.46f, 4.73f);
        r8.lineTo(5.82f, 21.0f);
        r8.lineTo(12.0f, 17.27f);
        r8.lineTo(18.18f, 21.0f);
        r8.lineToRelative(-1.63f, -7.03f);
        r8.lineTo(22.0f, 9.24f);
        r8.close();
        r8.moveTo(12.0f, 15.4f);
        r8.lineToRelative(-3.76f, 2.27f);
        r8.lineToRelative(1.0f, -4.28f);
        r8.lineToRelative(-3.32f, -2.88f);
        r8.lineToRelative(4.38f, -0.38f);
        r8.lineTo(12.0f, 6.1f);
        r8.lineToRelative(1.71f, 4.04f);
        r8.lineToRelative(4.38f, 0.38f);
        r8.lineToRelative(-3.32f, 2.88f);
        r8.lineToRelative(1.0f, 4.28f);
        r8.lineTo(12.0f, 15.4f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _star = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
