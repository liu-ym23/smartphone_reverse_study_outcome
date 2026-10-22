package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.material3.MenuKt;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_arrowBack", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowBack", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getArrowBack", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArrowBackKt {
    private static ImageVector _arrowBack;

    public static final ImageVector getArrowBack(Icons.AutoMirrored.Rounded r30) {
        ImageVector r0 = _arrowBack;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("AutoMirrored.Rounded.ArrowBack", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, true, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(19.0f, 11.0f);
        r7.horizontalLineTo(7.83f);
        r7.lineToRelative(4.88f, -4.88f);
        r7.curveToRelative(0.39f, -0.39f, 0.39f, -1.03f, MenuKt.ClosedAlphaTarget, -1.42f);
        r7.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, MenuKt.ClosedAlphaTarget);
        r7.lineToRelative(-6.59f, 6.59f);
        r7.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, MenuKt.ClosedAlphaTarget, 1.41f);
        r7.lineToRelative(6.59f, 6.59f);
        r7.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, MenuKt.ClosedAlphaTarget);
        r7.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, MenuKt.ClosedAlphaTarget, -1.41f);
        r7.lineTo(7.83f, 13.0f);
        r7.horizontalLineTo(19.0f);
        r7.curveToRelative(0.55f, MenuKt.ClosedAlphaTarget, 1.0f, -0.45f, 1.0f, -1.0f);
        r7.reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14336, null).build();
        _arrowBack = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
