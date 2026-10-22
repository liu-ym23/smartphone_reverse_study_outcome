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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSend$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getSend", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SendKt {
    private static ImageVector _send;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.TwoTone.Send", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.TwoTone.Send", imports = {"androidx.compose.material.icons.automirrored.twotone.Send"}))
    public static /* synthetic */ void getSend$annotations(Icons.TwoTone r0) {
    }

    public static final ImageVector getSend(Icons.TwoTone r47) {
        ImageVector r0 = _send;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        ImageVector.Builder r1 = new ImageVector.Builder("TwoTone.Send", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 96, null);
        int r15 = VectorKt.getDefaultFillType();
        Color.Companion r2 = Color.Companion;
        SolidColor r3 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        StrokeCap.Companion r4 = StrokeCap.Companion;
        int r22 = r4.getButt-KaPHkGw();
        StrokeJoin.Companion r5 = StrokeJoin.Companion;
        int r23 = r5.getBevel-LxFBmk8();
        PathBuilder r6 = new PathBuilder();
        r6.moveTo(4.0f, 8.25f);
        r6.lineToRelative(7.51f, 1.0f);
        r6.lineToRelative(-7.5f, -3.22f);
        r6.close();
        r6.moveTo(4.01f, 17.97f);
        r6.lineToRelative(7.5f, -3.22f);
        r6.lineToRelative(-7.51f, 1.0f);
        r6.close();
        ImageVector.Builder.addPath-oIyEayM$default(r1, r6.getNodes(), r15, "", r3, 0.3f, null, 0.3f, 1.0f, r22, r23, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null);
        int r32 = VectorKt.getDefaultFillType();
        SolidColor r7 = new SolidColor(r2.getBlack-0d7_KjU(), null);
        int r39 = r4.getButt-KaPHkGw();
        int r40 = r5.getBevel-LxFBmk8();
        PathBuilder r8 = new PathBuilder();
        r8.moveTo(2.01f, 3.0f);
        r8.lineTo(2.0f, 10.0f);
        r8.lineToRelative(15.0f, 2.0f);
        r8.lineToRelative(-15.0f, 2.0f);
        r8.lineToRelative(0.01f, 7.0f);
        r8.lineTo(23.0f, 12.0f);
        r8.lineTo(2.01f, 3.0f);
        r8.close();
        r8.moveTo(4.0f, 8.25f);
        r8.lineTo(4.0f, 6.03f);
        r8.lineToRelative(7.51f, 3.22f);
        r8.lineToRelative(-7.51f, -1.0f);
        r8.close();
        r8.moveTo(4.01f, 17.97f);
        r8.verticalLineToRelative(-2.22f);
        r8.lineToRelative(7.51f, -1.0f);
        r8.lineToRelative(-7.51f, 3.22f);
        r8.close();
        ImageVector r9 = ImageVector.Builder.addPath-oIyEayM$default(r1, r8.getNodes(), r32, "", r7, 1.0f, null, 1.0f, 1.0f, r39, r40, 1.0f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14336, null).build();
        _send = r9;
        Intrinsics.checkNotNull(r9);
        return r9;
    }
}
