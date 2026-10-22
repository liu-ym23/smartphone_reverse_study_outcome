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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_edit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Edit", "Landroidx/compose/material/icons/Icons$Outlined;", "getEdit", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditKt {
    private static ImageVector _edit;

    public static final ImageVector getEdit(Icons.Outlined r30) {
        ImageVector r0 = _edit;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Outlined.Edit", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(14.06f, 9.02f);
        r7.lineToRelative(0.92f, 0.92f);
        r7.lineTo(5.92f, 19.0f);
        r7.lineTo(5.0f, 19.0f);
        r7.verticalLineToRelative(-0.92f);
        r7.lineToRelative(9.06f, -9.06f);
        r7.moveTo(17.66f, 3.0f);
        r7.curveToRelative(-0.25f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.51f, 0.1f, -0.7f, 0.29f);
        r7.lineToRelative(-1.83f, 1.83f);
        r7.lineToRelative(3.75f, 3.75f);
        r7.lineToRelative(1.83f, -1.83f);
        r7.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.41f);
        r7.lineToRelative(-2.34f, -2.34f);
        r7.curveToRelative(-0.2f, -0.2f, -0.45f, -0.29f, -0.71f, -0.29f);
        r7.close();
        r7.moveTo(14.06f, 6.19f);
        r7.lineTo(3.0f, 17.25f);
        r7.lineTo(3.0f, 21.0f);
        r7.horizontalLineToRelative(3.75f);
        r7.lineTo(17.81f, 9.94f);
        r7.lineToRelative(-3.75f, -3.75f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _edit = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
