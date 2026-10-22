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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_notifications", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Notifications", "Landroidx/compose/material/icons/Icons$TwoTone;", "getNotifications", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NotificationsKt {
    private static ImageVector _notifications;

    public static final ImageVector getNotifications(Icons.TwoTone r47) {
        ImageVector r0 = _notifications;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Notifications", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(12.0f, 6.5f);
        r6.curveToRelative(-2.49f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, -4.0f, 2.02f, -4.0f, 4.5f);
        r6.verticalLineToRelative(6.0f);
        r6.horizontalLineToRelative(8.0f);
        r6.verticalLineToRelative(-6.0f);
        r6.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.48f, -1.51f, -4.5f, -4.0f, -4.5f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(12.0f, 22.0f);
        r8.curveToRelative(1.1f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2.0f, -0.9f, 2.0f, -2.0f);
        r8.horizontalLineToRelative(-4.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        r8.close();
        r8.moveTo(18.0f, 16.0f);
        r8.verticalLineToRelative(-5.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -3.07f, -1.63f, -5.64f, -4.5f, -6.32f);
        r8.lineTo(13.5f, 4.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        r8.reflectiveCurveToRelative(-1.5f, 0.67f, -1.5f, 1.5f);
        r8.verticalLineToRelative(0.68f);
        r8.curveTo(7.64f, 5.36f, 6.0f, 7.92f, 6.0f, 11.0f);
        r8.verticalLineToRelative(5.0f);
        r8.lineToRelative(-2.0f, 2.0f);
        r8.verticalLineToRelative(1.0f);
        r8.horizontalLineToRelative(16.0f);
        r8.verticalLineToRelative(-1.0f);
        r8.lineToRelative(-2.0f, -2.0f);
        r8.close();
        r8.moveTo(16.0f, 17.0f);
        r8.lineTo(8.0f, 17.0f);
        r8.verticalLineToRelative(-6.0f);
        r8.curveToRelative(androidx.compose.material3.MenuKt.ClosedAlphaTarget, -2.48f, 1.51f, -4.5f, 4.0f, -4.5f);
        r8.reflectiveCurveToRelative(4.0f, 2.02f, 4.0f, 4.5f);
        r8.verticalLineToRelative(6.0f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _notifications = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
