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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_person", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Person", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPerson", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PersonKt {
    private static ImageVector _person;

    public static final ImageVector getPerson(Icons.TwoTone r64) {
        ImageVector r0 = _person;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Person", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(12.0f, 16.0f);
        r6.curveToRelative(-2.69f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -5.77f, 1.28f, -6.0f, 2.0f);
        r6.horizontalLineToRelative(12.0f);
        r6.curveToRelative(-0.2f, -0.71f, -3.3f, -2.0f, -6.0f, -2.0f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(12.0f, 8.0f);
        r8.moveToRelative(-2.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r8.arcToRelative(2.0f, 2.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, true, true, 4.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r8.arcToRelative(2.0f, 2.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, true, true, -4.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 0.3f, null, 0.3f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r49 = VectorKt.getDefaultFillType();
        SolidColor r9 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r56 = r4.getButt-KaPHkGw();
        int r57 = r5.getBevel-LxFBmk8();
        PathBuilder r10 = new PathBuilder();
        r10.moveTo(12.0f, 14.0f);
        r10.curveToRelative(-2.67f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -8.0f, 1.34f, -8.0f, 4.0f);
        r10.verticalLineToRelative(2.0f);
        r10.horizontalLineToRelative(16.0f);
        r10.verticalLineToRelative(-2.0f);
        r10.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.66f, -5.33f, -4.0f, -8.0f, -4.0f);
        r10.close();
        r10.moveTo(6.0f, 18.0f);
        r10.curveToRelative(0.22f, -0.72f, 3.31f, -2.0f, 6.0f, -2.0f);
        r10.curveToRelative(2.7f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 5.8f, 1.29f, 6.0f, 2.0f);
        r10.lineTo(6.0f, 18.0f);
        r10.close();
        r10.moveTo(12.0f, 12.0f);
        r10.curveToRelative(2.21f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4.0f, -1.79f, 4.0f, -4.0f);
        r10.reflectiveCurveToRelative(-1.79f, -4.0f, -4.0f, -4.0f);
        r10.reflectiveCurveToRelative(-4.0f, 1.79f, -4.0f, 4.0f);
        r10.reflectiveCurveToRelative(1.79f, 4.0f, 4.0f, 4.0f);
        r10.close();
        r10.moveTo(12.0f, 6.0f);
        r10.curveToRelative(1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.0f, 0.9f, 2.0f, 2.0f);
        r10.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
        r10.reflectiveCurveToRelative(-2.0f, -0.9f, -2.0f, -2.0f);
        r10.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        r10.close();
        ImageVector r11 = ImageVector.Builder.addPath-oIyEayM$default(r1, r10.getNodes(), r49, "", r9, 1.0f, null, 1.0f, 1.0f, r56, r57, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _person = r11;
        Intrinsics.checkNotNull(r11);
        return r11;
    }
}
