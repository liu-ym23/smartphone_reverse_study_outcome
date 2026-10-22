package androidx.compose.material.icons.sharp;

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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_menu", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Menu", "Landroidx/compose/material/icons/Icons$Sharp;", "getMenu", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuKt {
    private static ImageVector _menu;

    public static final ImageVector getMenu(Icons.Sharp r30) {
        ImageVector r0 = _menu;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Sharp.Menu", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r3 = new PathBuilder();
        r3.moveTo(3.0f, 18.0f);
        r3.horizontalLineToRelative(18.0f);
        r3.verticalLineToRelative(-2.0f);
        r3.lineTo(3.0f, 16.0f);
        r3.verticalLineToRelative(2.0f);
        r3.close();
        r3.moveTo(3.0f, 13.0f);
        r3.horizontalLineToRelative(18.0f);
        r3.verticalLineToRelative(-2.0f);
        r3.lineTo(3.0f, 11.0f);
        r3.verticalLineToRelative(2.0f);
        r3.close();
        r3.moveTo(3.0f, 6.0f);
        r3.verticalLineToRelative(2.0f);
        r3.horizontalLineToRelative(18.0f);
        r3.lineTo(21.0f, 6.0f);
        r3.lineTo(3.0f, 6.0f);
        r3.close();
        ImageVector r4 = ImageVector.Builder.addPath-oIyEayM$default(r1, r3.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _menu = r4;
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
