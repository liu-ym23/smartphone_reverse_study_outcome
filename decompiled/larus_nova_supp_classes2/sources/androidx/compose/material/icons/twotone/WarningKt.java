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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_warning", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Warning", "Landroidx/compose/material/icons/Icons$TwoTone;", "getWarning", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WarningKt {
    private static ImageVector _warning;

    public static final ImageVector getWarning(Icons.TwoTone r47) {
        ImageVector r0 = _warning;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Warning", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(4.47f, 19.0f);
        r6.horizontalLineToRelative(15.06f);
        r6.lineTo(12.0f, 5.99f);
        r6.lineTo(4.47f, 19.0f);
        r6.close();
        r6.moveTo(13.0f, 18.0f);
        r6.horizontalLineToRelative(-2.0f);
        r6.verticalLineToRelative(-2.0f);
        r6.horizontalLineToRelative(2.0f);
        r6.verticalLineToRelative(2.0f);
        r6.close();
        r6.moveTo(13.0f, 14.0f);
        r6.horizontalLineToRelative(-2.0f);
        r6.verticalLineToRelative(-4.0f);
        r6.horizontalLineToRelative(2.0f);
        r6.verticalLineToRelative(4.0f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(1.0f, 21.0f);
        r8.horizontalLineToRelative(22.0f);
        r8.lineTo(12.0f, 2.0f);
        r8.lineTo(1.0f, 21.0f);
        r8.close();
        r8.moveTo(4.47f, 19.0f);
        r8.lineTo(12.0f, 5.99f);
        r8.lineTo(19.53f, 19.0f);
        r8.lineTo(4.47f, 19.0f);
        r8.close();
        r8.moveTo(11.0f, 16.0f);
        r8.horizontalLineToRelative(2.0f);
        r8.verticalLineToRelative(2.0f);
        r8.horizontalLineToRelative(-2.0f);
        r8.close();
        r8.moveTo(11.0f, 10.0f);
        r8.horizontalLineToRelative(2.0f);
        r8.verticalLineToRelative(4.0f);
        r8.horizontalLineToRelative(-2.0f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _warning = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
