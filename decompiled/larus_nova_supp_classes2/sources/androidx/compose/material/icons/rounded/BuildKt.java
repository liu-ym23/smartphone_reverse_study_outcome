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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$Rounded;", "getBuild", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BuildKt {
    private static ImageVector _build;

    public static final ImageVector getBuild(Icons.Rounded r30) {
        ImageVector r0 = _build;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Rounded.Build", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(12.09f, 2.91f);
        r7.curveTo(10.08f, 0.9f, 7.07f, 0.49f, 4.65f, 1.67f);
        r7.lineTo(8.28f, 5.3f);
        r7.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.41f);
        r7.lineTo(6.69f, 8.3f);
        r7.curveToRelative(-0.39f, 0.4f, -1.02f, 0.4f, -1.41f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r7.lineTo(1.65f, 4.67f);
        r7.curveTo(0.48f, 7.1f, 0.89f, 10.09f, 2.9f, 12.1f);
        r7.curveToRelative(1.86f, 1.86f, 4.58f, 2.35f, 6.89f, 1.48f);
        r7.lineToRelative(7.96f, 7.96f);
        r7.curveToRelative(1.03f, 1.03f, 2.69f, 1.03f, 3.71f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r7.curveToRelative(1.03f, -1.03f, 1.03f, -2.69f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.71f);
        r7.lineTo(13.54f, 9.9f);
        r7.curveToRelative(0.92f, -2.34f, 0.44f, -5.1f, -1.45f, -6.99f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _build = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
