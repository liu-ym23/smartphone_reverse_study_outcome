package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\b\u0010\u0006\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f\u001a#\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"offset", "Landroidx/compose/ui/Modifier;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "offset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "absoluteOffset", "absoluteOffset-VpY3zN4", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OffsetKt {
    public static /* synthetic */ Unit a(float r0, float r1, InspectorInfo r2) {
        return absoluteOffset_VpY3zN4$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(Function1 r0, InspectorInfo r1) {
        return offset$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit c(Function1 r0, InspectorInfo r1) {
        return absoluteOffset$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit d(float r0, float r1, InspectorInfo r2) {
        return offset_VpY3zN4$lambda$0(r0, r1, r2);
    }

    public static final Modifier absoluteOffset(Modifier r3, final Function1<? super Density, IntOffset> r4) {
        return r3.then(new OffsetPxElement(r4, false, new k1(r4)));
    }

    private static final Unit absoluteOffset$lambda$3(Function1 r1, InspectorInfo r2) {
        r2.setName("absoluteOffset");
        r2.getProperties().set("offset", r1);
        return Unit.INSTANCE;
    }

    public static final Modifier offset(Modifier r3, final Function1<? super Density, IntOffset> r4) {
        return r3.then(new OffsetPxElement(r4, true, new j1(r4)));
    }

    private static final Unit offset$lambda$2(Function1 r1, InspectorInfo r2) {
        r2.setName("offset");
        r2.getProperties().set("offset", r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4, reason: not valid java name */
    public static final Modifier m913absoluteOffsetVpY3zN4(Modifier r7, final float r8, final float r9) {
        return r7.then(new OffsetElement(r8, r9, false, new h1(r8, r9), null));
    }

    private static final Unit absoluteOffset_VpY3zN4$lambda$1(float r2, float r3, InspectorInfo r4) {
        r4.setName("absoluteOffset");
        r4.getProperties().set("x", Dp.box-impl(r2));
        r4.getProperties().set("y", Dp.box-impl(r3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: offset-VpY3zN4, reason: not valid java name */
    public static final Modifier m915offsetVpY3zN4(Modifier r7, final float r8, final float r9) {
        return r7.then(new OffsetElement(r8, r9, true, new i1(r8, r9), null));
    }

    private static final Unit offset_VpY3zN4$lambda$0(float r2, float r3, InspectorInfo r4) {
        r4.setName("offset");
        r4.getProperties().set("x", Dp.box-impl(r2));
        r4.getProperties().set("y", Dp.box-impl(r3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m914absoluteOffsetVpY3zN4$default(Modifier r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = Dp.constructor-impl(0);
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = Dp.constructor-impl(0);
    L9:
        return m913absoluteOffsetVpY3zN4(r1, r2, r3);
    }

    /* JADX INFO: renamed from: offset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m916offsetVpY3zN4$default(Modifier r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = Dp.constructor-impl(0);
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = Dp.constructor-impl(0);
    L9:
        return m915offsetVpY3zN4(r1, r2, r3);
    }
}
