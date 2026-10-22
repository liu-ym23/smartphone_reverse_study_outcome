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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_phone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Phone", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPhone", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PhoneKt {
    private static ImageVector _phone;

    public static final ImageVector getPhone(Icons.TwoTone r47) {
        ImageVector r0 = _phone;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Phone", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(19.0f, 17.47f);
        r6.curveToRelative(-0.88f, -0.07f, -1.75f, -0.22f, -2.6f, -0.45f);
        r6.lineToRelative(-1.19f, 1.19f);
        r6.curveToRelative(1.2f, 0.41f, 2.48f, 0.67f, 3.8f, 0.75f);
        r6.verticalLineToRelative(-1.49f);
        r6.close();
        r6.moveTo(5.03f, 5.0f);
        r6.curveToRelative(0.09f, 1.32f, 0.35f, 2.59f, 0.75f, 3.8f);
        r6.lineToRelative(1.2f, -1.2f);
        r6.curveToRelative(-0.23f, -0.84f, -0.38f, -1.71f, -0.44f, -2.6f);
        r6.horizontalLineTo(5.03f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(9.07f, 7.57f);
        r8.curveTo(8.7f, 6.45f, 8.5f, 5.25f, 8.5f, 4.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        r8.lineTo(4.0f, 3.0f);
        r8.curveToRelative(-0.55f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.0f, 0.45f, -1.0f, 1.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 9.39f, 7.61f, 17.0f, 17.0f, 17.0f);
        r8.curveToRelative(0.55f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, -0.45f, 1.0f, -1.0f);
        r8.verticalLineToRelative(-3.49f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
        r8.curveToRelative(-1.24f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.45f, -0.2f, -3.57f, -0.57f);
        r8.curveToRelative(-0.1f, -0.04f, -0.21f, -0.05f, -0.31f, -0.05f);
        r8.curveToRelative(-0.26f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.51f, 0.1f, -0.71f, 0.29f);
        r8.lineToRelative(-2.2f, 2.2f);
        r8.curveToRelative(-2.83f, -1.45f, -5.15f, -3.76f, -6.59f, -6.59f);
        r8.lineToRelative(2.2f, -2.2f);
        r8.curveToRelative(0.28f, -0.28f, 0.36f, -0.67f, 0.25f, -1.02f);
        r8.close();
        r8.moveTo(16.4f, 17.02f);
        r8.curveToRelative(0.85f, 0.24f, 1.72f, 0.39f, 2.6f, 0.45f);
        r8.verticalLineToRelative(1.49f);
        r8.curveToRelative(-1.32f, -0.09f, -2.59f, -0.35f, -3.8f, -0.75f);
        r8.lineToRelative(1.2f, -1.19f);
        r8.close();
        r8.moveTo(5.79f, 8.8f);
        r8.curveToRelative(-0.41f, -1.21f, -0.67f, -2.48f, -0.76f, -3.8f);
        r8.horizontalLineToRelative(1.5f);
        r8.curveToRelative(0.07f, 0.89f, 0.22f, 1.76f, 0.46f, 2.59f);
        r8.lineTo(5.79f, 8.8f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _phone = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
