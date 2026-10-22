package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0012\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\t*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tR\u0015\u0010\u0016\u001a\u00020\t*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/EdgeEffectCompat;", "", "<init>", "()V", "create", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", "onPullDistanceCompat", "", "deltaDistance", "displacement", "onAbsorbCompat", "", "velocity", "", "absorbToRelaxIfNeeded", "edgeEffectLength", "density", "Landroidx/compose/ui/unit/Density;", "onReleaseWithOppositeDelta", "delta", "distanceCompat", "getDistanceCompat", "(Landroid/widget/EdgeEffect;)F", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EdgeEffectCompat {
    public static final int $stable = 0;
    public static final EdgeEffectCompat INSTANCE = null;

    static {
        INSTANCE = new EdgeEffectCompat();
    }

    private EdgeEffectCompat() {
    }

    public final EdgeEffect create(Context r3) {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return Api31Impl.INSTANCE.create(r3, null);
    L6:
        return new GlowEdgeEffectCompat(r3);
    }

    public final float getDistanceCompat(EdgeEffect r3) {
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        return MenuKt.ClosedAlphaTarget;
    L7:
        return Api31Impl.INSTANCE.getDistance(r3);
    }

    public final void onAbsorbCompat(EdgeEffect r3, int r4) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        r3.onAbsorb(r4);
        return;
    L7:
        if (r3.isFinished() == false) goto L10;
        r3.onAbsorb(r4);
        return;
    }

    public final void onReleaseWithOppositeDelta(EdgeEffect r2, float r3) {
        if ((r2 instanceof GlowEdgeEffectCompat) == false) goto L5;
        ((GlowEdgeEffectCompat) r2).releaseWithOppositeDelta(r3);
        return;
    L5:
        r2.onRelease();
    }

    public final float onPullDistanceCompat(EdgeEffect r3, float r4, float r5) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        r3.onPull(r4, r5);
        return r4;
    L5:
        return Api31Impl.INSTANCE.onPullDistance(r3, r4, r5);
    }

    public final float absorbToRelaxIfNeeded(EdgeEffect r2, float r3, float r4, Density r5) {
        if (EdgeEffectCompat_androidKt.access$flingDistance(r5, r3) > (getDistanceCompat(r2) * r4)) goto L5;
        onAbsorbCompat(r2, MathKt.roundToInt(r3));
        return r3;
    L5:
        return MenuKt.ClosedAlphaTarget;
    }
}
