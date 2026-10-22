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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_face", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFace", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FaceKt {
    private static ImageVector _face;

    public static final ImageVector getFace(Icons.TwoTone r81) {
        ImageVector r0 = _face;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Face", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(17.5f, 8.0f);
        r6.curveToRelative(0.46f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.91f, -0.05f, 1.34f, -0.12f);
        r6.curveTo(17.44f, 5.56f, 14.9f, 4.0f, 12.0f, 4.0f);
        r6.curveToRelative(-0.46f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.91f, 0.05f, -1.34f, 0.12f);
        r6.curveTo(12.06f, 6.44f, 14.6f, 8.0f, 17.5f, 8.0f);
        r6.close();
        r6.moveTo(8.08f, 5.03f);
        r6.curveTo(6.37f, 6.0f, 5.05f, 7.58f, 4.42f, 9.47f);
        r6.curveToRelative(1.71f, -0.97f, 3.03f, -2.55f, 3.66f, -4.44f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(12.0f, 2.0f);
        r8.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        r8.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        r8.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        r8.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        r8.close();
        r8.moveTo(12.0f, 4.0f);
        r8.curveToRelative(2.9f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 5.44f, 1.56f, 6.84f, 3.88f);
        r8.curveToRelative(-0.43f, 0.07f, -0.88f, 0.12f, -1.34f, 0.12f);
        r8.curveToRelative(-2.9f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -5.44f, -1.56f, -6.84f, -3.88f);
        r8.curveToRelative(0.43f, -0.07f, 0.88f, -0.12f, 1.34f, -0.12f);
        r8.close();
        r8.moveTo(8.08f, 5.03f);
        r8.curveTo(7.45f, 6.92f, 6.13f, 8.5f, 4.42f, 9.47f);
        r8.curveTo(5.05f, 7.58f, 6.37f, 6.0f, 8.08f, 5.03f);
        r8.close();
        r8.moveTo(12.0f, 20.0f);
        r8.curveToRelative(-4.41f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -8.0f, -3.59f, -8.0f, -8.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.05f, 0.01f, -0.1f, 0.01f, -0.15f);
        r8.curveToRelative(2.6f, -0.98f, 4.68f, -2.99f, 5.74f, -5.55f);
        r8.curveToRelative(1.83f, 2.26f, 4.62f, 3.7f, 7.75f, 3.7f);
        r8.curveToRelative(0.75f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.47f, -0.09f, 2.17f, -0.24f);
        r8.curveToRelative(0.21f, 0.71f, 0.33f, 1.46f, 0.33f, 2.24f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4.41f, -3.59f, 8.0f, -8.0f, 8.0f);
        r8.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r49 = VectorKt.getDefaultFillType();
        SolidColor r9 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r56 = r4.getButt-KaPHkGw();
        int r57 = r5.getBevel-LxFBmk8();
        PathBuilder r10 = new PathBuilder();
        r10.moveTo(9.0f, 13.0f);
        r10.moveToRelative(-1.25f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r10.arcToRelative(1.25f, 1.25f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, true, true, 2.5f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r10.arcToRelative(1.25f, 1.25f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, true, true, -2.5f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        ImageVector.Builder.addPath-oIyEayM$default(r1, r10.getNodes(), r49, "", r9, 1.0f, null, 1.0f, 1.0f, r56, r57, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r66 = VectorKt.getDefaultFillType();
        SolidColor r11 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r73 = r4.getButt-KaPHkGw();
        int r74 = r5.getBevel-LxFBmk8();
        PathBuilder r12 = new PathBuilder();
        r12.moveTo(15.0f, 13.0f);
        r12.moveToRelative(-1.25f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r12.arcToRelative(1.25f, 1.25f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, true, true, 2.5f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r12.arcToRelative(1.25f, 1.25f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, true, true, -2.5f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        ImageVector r13 = ImageVector.Builder.addPath-oIyEayM$default(r1, r12.getNodes(), r66, "", r11, 1.0f, null, 1.0f, 1.0f, r73, r74, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _face = r13;
        Intrinsics.checkNotNull(r13);
        return r13;
    }
}
