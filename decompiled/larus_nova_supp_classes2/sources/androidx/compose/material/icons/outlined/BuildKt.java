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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$Outlined;", "getBuild", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BuildKt {
    private static ImageVector _build;

    public static final ImageVector getBuild(Icons.Outlined r30) {
        ImageVector r0 = _build;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Outlined.Build", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(22.61f, 18.99f);
        r7.lineToRelative(-9.08f, -9.08f);
        r7.curveToRelative(0.93f, -2.34f, 0.45f, -5.1f, -1.44f, -7.0f);
        r7.curveTo(9.79f, 0.61f, 6.21f, 0.4f, 3.66f, 2.26f);
        r7.lineTo(7.5f, 6.11f);
        r7.lineTo(6.08f, 7.52f);
        r7.lineTo(2.25f, 3.69f);
        r7.curveTo(0.39f, 6.23f, 0.6f, 9.82f, 2.9f, 12.11f);
        r7.curveToRelative(1.86f, 1.86f, 4.57f, 2.35f, 6.89f, 1.48f);
        r7.lineToRelative(9.11f, 9.11f);
        r7.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r7.lineToRelative(2.3f, -2.3f);
        r7.curveToRelative(0.4f, -0.38f, 0.4f, -1.01f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.41f);
        r7.close();
        r7.moveTo(19.61f, 20.59f);
        r7.lineToRelative(-9.46f, -9.46f);
        r7.curveToRelative(-0.61f, 0.45f, -1.29f, 0.72f, -2.0f, 0.82f);
        r7.curveToRelative(-1.36f, 0.2f, -2.79f, -0.21f, -3.83f, -1.25f);
        r7.curveTo(3.37f, 9.76f, 2.93f, 8.5f, 3.0f, 7.26f);
        r7.lineToRelative(3.09f, 3.09f);
        r7.lineToRelative(4.24f, -4.24f);
        r7.lineToRelative(-3.09f, -3.09f);
        r7.curveToRelative(1.24f, -0.07f, 2.49f, 0.37f, 3.44f, 1.31f);
        r7.curveToRelative(1.08f, 1.08f, 1.49f, 2.57f, 1.24f, 3.96f);
        r7.curveToRelative(-0.12f, 0.71f, -0.42f, 1.37f, -0.88f, 1.96f);
        r7.lineToRelative(9.45f, 9.45f);
        r7.lineToRelative(-0.88f, 0.89f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _build = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
