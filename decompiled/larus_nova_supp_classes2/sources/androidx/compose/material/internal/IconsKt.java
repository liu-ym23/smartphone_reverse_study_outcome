package androidx.compose.material.internal;

import androidx.autofill.HintConstants;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0082\b\u001aK\u0010\b\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0007H\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", HintConstants.AUTOFILL_HINT_NAME, "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "materialPath", "fillAlpha", "", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "MaterialIconDimension", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconsKt {
    private static final float MaterialIconDimension = 24.0f;

    private static final ImageVector materialIcon(String r13, Function1<? super ImageVector.Builder, ImageVector.Builder> r14) {
        return ((ImageVector.Builder) r14.invoke(new ImageVector.Builder(r13, Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null))).build();
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI, reason: not valid java name */
    private static final ImageVector.Builder m2244materialPathYwgOQQI(ImageVector.Builder r17, float r18, float r19, int r20, Function1<? super PathBuilder, Unit> r21) {
        SolidColor r1 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r9 = StrokeCap.Companion.getButt-KaPHkGw();
        int r10 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r2 = new PathBuilder();
        r21.invoke(r2);
        return ImageVector.Builder.addPath-oIyEayM$default(r17, r2.getNodes(), r20, "", r1, r18, null, r19, 1.0f, r9, r10, 1.0f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14336, null);
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m2245materialPathYwgOQQI$default(ImageVector.Builder r19, float r20, float r21, int r22, Function1 r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        float r7 = 1.0f;
    L7:
        if ((r24 & 2) == 0) goto L9;
        float r9 = 1.0f;
    L11:
        if ((r24 & 4) == 0) goto L13;
        int r4 = VectorKt.getDefaultFillType();
    L14:
        SolidColor r0 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int r11 = StrokeCap.Companion.getButt-KaPHkGw();
        int r12 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder r1 = new PathBuilder();
        r23.invoke(r1);
        return ImageVector.Builder.addPath-oIyEayM$default(r19, r1.getNodes(), r4, "", r0, r7, null, r9, 1.0f, r11, r12, 1.0f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14336, null);
    L13:
        r4 = r22;
        goto L14
    L9:
        r9 = r21;
        goto L11
    L5:
        r7 = r20;
        goto L7
    }
}
