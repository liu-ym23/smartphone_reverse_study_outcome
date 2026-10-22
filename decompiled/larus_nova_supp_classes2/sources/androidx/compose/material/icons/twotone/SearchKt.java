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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_search", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Search", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSearch", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SearchKt {
    private static ImageVector _search;

    public static final ImageVector getSearch(Icons.TwoTone r30) {
        ImageVector r0 = _search;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Search", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(15.5f, 14.0f);
        r7.horizontalLineToRelative(-0.79f);
        r7.lineToRelative(-0.28f, -0.27f);
        r7.curveTo(15.41f, 12.59f, 16.0f, 11.11f, 16.0f, 9.5f);
        r7.curveTo(16.0f, 5.91f, 13.09f, 3.0f, 9.5f, 3.0f);
        r7.reflectiveCurveTo(3.0f, 5.91f, 3.0f, 9.5f);
        r7.reflectiveCurveTo(5.91f, 16.0f, 9.5f, 16.0f);
        r7.curveToRelative(1.61f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.09f, -0.59f, 4.23f, -1.57f);
        r7.lineToRelative(0.27f, 0.28f);
        r7.verticalLineToRelative(0.79f);
        r7.lineToRelative(5.0f, 4.99f);
        r7.lineTo(20.49f, 19.0f);
        r7.lineToRelative(-4.99f, -5.0f);
        r7.close();
        r7.moveTo(9.5f, 14.0f);
        r7.curveTo(7.01f, 14.0f, 5.0f, 11.99f, 5.0f, 9.5f);
        r7.reflectiveCurveTo(7.01f, 5.0f, 9.5f, 5.0f);
        r7.reflectiveCurveTo(14.0f, 7.01f, 14.0f, 9.5f);
        r7.reflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _search = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
