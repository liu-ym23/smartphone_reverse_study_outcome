package androidx.compose.material.internal;

import androidx.compose.material3.MenuKt;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/material/internal/Icons;", "", "<init>", "()V", "Filled", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Icons {
    public static final int $stable = 0;
    public static final Icons INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/material/internal/Icons$Filled;", "", "<init>", "()V", "ArrowDropDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getArrowDropDown$material", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_arrowDropDown", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Filled {
        public static final int $stable = 0;
        public static final Filled INSTANCE = null;
        private static ImageVector _arrowDropDown;

        static {
            INSTANCE = new Filled();
            $stable = 8;
        }

        private Filled() {
        }

        public final ImageVector getArrowDropDown$material() {
            ImageVector r0 = _arrowDropDown;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r0);
            return r0;
        L6:
            ImageVector.Builder r1 = new ImageVector.Builder("Filled.ArrowDropDown", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r15 = VectorKt.getDefaultFillType();
            SolidColor r2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
            int r22 = StrokeCap.Companion.getButt-KaPHkGw();
            int r23 = StrokeJoin.Companion.getBevel-LxFBmk8();
            PathBuilder r3 = new PathBuilder();
            r3.moveTo(7.0f, 10.0f);
            r3.lineToRelative(5.0f, 5.0f);
            r3.lineToRelative(5.0f, -5.0f);
            r3.close();
            ImageVector r4 = ImageVector.Builder.addPath-oIyEayM$default(r1, r3.getNodes(), r15, "", r2, 1.0f, null, 1.0f, 1.0f, r22, r23, 1.0f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14336, null).build();
            _arrowDropDown = r4;
            Intrinsics.checkNotNull(r4);
            return r4;
        }
    }

    static {
        INSTANCE = new Icons();
    }

    private Icons() {
    }
}
