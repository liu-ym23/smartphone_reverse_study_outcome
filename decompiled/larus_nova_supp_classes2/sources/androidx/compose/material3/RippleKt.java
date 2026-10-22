package androidx.compose.material3;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/ColorProducer;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "LocalRippleConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/RippleConfiguration;", "getLocalRippleConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DefaultBoundedRipple", "Landroidx/compose/material3/RippleNodeFactory;", "DefaultUnboundedRipple", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RippleKt {
    private static final RippleNodeFactory DefaultBoundedRipple = null;
    private static final RippleNodeFactory DefaultUnboundedRipple = null;
    private static final ProvidableCompositionLocal<RippleConfiguration> LocalRippleConfiguration = null;

    public static /* synthetic */ RippleConfiguration a() {
        return LocalRippleConfiguration$lambda$0();
    }

    static {
        LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new xk(), 1, null);
        Dp.Companion r7 = Dp.Companion;
        float r3 = r7.getUnspecified-D9Ej5fM();
        Color.Companion r8 = Color.Companion;
        DefaultBoundedRipple = new RippleNodeFactory(true, r3, r8.getUnspecified-0d7_KjU(), null);
        DefaultUnboundedRipple = new RippleNodeFactory(false, r7.getUnspecified-D9Ej5fM(), r8.getUnspecified-0d7_KjU(), null);
    }

    private static final RippleConfiguration LocalRippleConfiguration$lambda$0() {
        return new RippleConfiguration(0, null, 3, null);
    }

    public static final ProvidableCompositionLocal<RippleConfiguration> getLocalRippleConfiguration() {
        return LocalRippleConfiguration;
    }

    /* JADX INFO: renamed from: ripple-H2RKhps, reason: not valid java name */
    public static final IndicationNodeFactory m3030rippleH2RKhps(boolean r7, float r8, long r9) {
        if (Dp.equals-impl0(r8, Dp.Companion.getUnspecified-D9Ej5fM()) == false) goto L11;
        if (Color.equals-impl0(r9, Color.Companion.getUnspecified-0d7_KjU()) == false) goto L11;
        if (r7 == false) goto L12;
        return DefaultBoundedRipple;
    L12:
        return DefaultUnboundedRipple;
    L11:
        return new RippleNodeFactory(r7, r8, r9, null);
    }

    /* JADX INFO: renamed from: ripple-wH6b6FI, reason: not valid java name */
    public static final IndicationNodeFactory m3032ripplewH6b6FI(ColorProducer r2, boolean r3, float r4) {
        return new RippleNodeFactory(r3, r4, r2, null);
    }

    /* JADX INFO: renamed from: ripple-H2RKhps$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m3031rippleH2RKhps$default(boolean r0, float r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r0 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r2 = Color.Companion.getUnspecified-0d7_KjU();
    L12:
        return m3030rippleH2RKhps(r0, r1, r2);
    }

    /* JADX INFO: renamed from: ripple-wH6b6FI$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m3033ripplewH6b6FI$default(ColorProducer r0, boolean r1, float r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        return m3032ripplewH6b6FI(r0, r1, r2);
    }
}
