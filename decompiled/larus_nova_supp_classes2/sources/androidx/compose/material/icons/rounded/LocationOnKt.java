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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_locationOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocationOn", "Landroidx/compose/material/icons/Icons$Rounded;", "getLocationOn", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LocationOnKt {
    private static ImageVector _locationOn;

    public static final ImageVector getLocationOn(Icons.Rounded r30) {
        ImageVector r0 = _locationOn;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("Rounded.LocationOn", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r22 = StrokeCap.Companion.getButt-KaPHkGw();
        int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r7 = new PathBuilder();
        r7.moveTo(12.0f, 2.0f);
        r7.curveToRelative(-4.2f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -8.0f, 3.22f, -8.0f, 8.2f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 3.18f, 2.45f, 6.92f, 7.34f, 11.23f);
        r7.curveToRelative(0.38f, 0.33f, 0.95f, 0.33f, 1.33f, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        r7.curveTo(17.55f, 17.12f, 20.0f, 13.38f, 20.0f, 10.2f);
        r7.curveTo(20.0f, 5.22f, 16.2f, 2.0f, 12.0f, 2.0f);
        r7.close();
        r7.moveTo(12.0f, 12.0f);
        r7.curveToRelative(-1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.0f, -0.9f, -2.0f, -2.0f);
        r7.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -1.1f, 0.9f, -2.0f, 2.0f, -2.0f);
        r7.curveToRelative(1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.0f, 0.9f, 2.0f, 2.0f);
        r7.curveTo(14.0f, 11.1f, 13.1f, 12.0f, 12.0f, 12.0f);
        r7.close();
        ImageVector r3 = ImageVector.Builder.addPath-oIyEayM$default(r1, r7.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _locationOn = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
