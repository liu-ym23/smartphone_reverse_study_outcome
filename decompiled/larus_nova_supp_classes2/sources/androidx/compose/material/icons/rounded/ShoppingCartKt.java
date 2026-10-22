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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_shoppingCart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ShoppingCart", "Landroidx/compose/material/icons/Icons$Rounded;", "getShoppingCart", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShoppingCartKt {
    private static ImageVector _shoppingCart;

    public static final ImageVector getShoppingCart(Icons.Rounded r30) {
        ImageVector r0 = _shoppingCart;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Rounded.ShoppingCart", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(7.0f, 18.0f);
        r7.curveToRelative(-1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.99f, 0.9f, -1.99f, 2.0f);
        r7.reflectiveCurveTo(5.9f, 22.0f, 7.0f, 22.0f);
        r7.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        r7.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        r7.close();
        r7.moveTo(1.0f, 3.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
        r7.horizontalLineToRelative(1.0f);
        r7.lineToRelative(3.6f, 7.59f);
        r7.lineToRelative(-1.35f, 2.44f);
        r7.curveTo(4.52f, 15.37f, 5.48f, 17.0f, 7.0f, 17.0f);
        r7.horizontalLineToRelative(11.0f);
        r7.curveToRelative(0.55f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f, -0.45f, 1.0f, -1.0f);
        r7.reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f);
        r7.lineTo(7.0f, 15.0f);
        r7.lineToRelative(1.1f, -2.0f);
        r7.horizontalLineToRelative(7.45f);
        r7.curveToRelative(0.75f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.41f, -0.41f, 1.75f, -1.03f);
        r7.lineToRelative(3.58f, -6.49f);
        r7.curveToRelative(0.37f, -0.66f, -0.11f, -1.48f, -0.87f, -1.48f);
        r7.lineTo(5.21f, 4.0f);
        r7.lineToRelative(-0.67f, -1.43f);
        r7.curveToRelative(-0.16f, -0.35f, -0.52f, -0.57f, -0.9f, -0.57f);
        r7.lineTo(2.0f, 2.0f);
        r7.curveToRelative(-0.55f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.0f, 0.45f, -1.0f, 1.0f);
        r7.close();
        r7.moveTo(17.0f, 18.0f);
        r7.curveToRelative(-1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.99f, 0.9f, -1.99f, 2.0f);
        r7.reflectiveCurveToRelative(0.89f, 2.0f, 1.99f, 2.0f);
        r7.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        r7.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _shoppingCart = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
