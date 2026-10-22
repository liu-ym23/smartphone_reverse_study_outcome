package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/GlowEdgeEffectCompat;", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "oppositeReleaseDeltaThreshold", "", "oppositeReleaseDelta", "onPull", "", "deltaDistance", "displacement", "onRelease", "onAbsorb", "velocity", "", "releaseWithOppositeDelta", "delta", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class GlowEdgeEffectCompat extends EdgeEffect {
    private float oppositeReleaseDelta;
    private final float oppositeReleaseDeltaThreshold;

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.oppositeReleaseDelta = MenuKt.ClosedAlphaTarget;
        super.onRelease();
    }

    public GlowEdgeEffectCompat(Context r2) {
        super(r2);
        this.oppositeReleaseDeltaThreshold = AndroidDensity_androidKt.Density(r2).toPx-0680j_4(Dp.constructor-impl(1));
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int r2) {
        this.oppositeReleaseDelta = MenuKt.ClosedAlphaTarget;
        super.onAbsorb(r2);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r2) {
        this.oppositeReleaseDelta = MenuKt.ClosedAlphaTarget;
        super.onPull(r2);
    }

    public final void releaseWithOppositeDelta(float r2) {
        float r0 = this.oppositeReleaseDelta + r2;
        this.oppositeReleaseDelta = r0;
        if (Math.abs(r0) <= this.oppositeReleaseDeltaThreshold) goto L6;
        onRelease();
        return;
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r2, float r3) {
        this.oppositeReleaseDelta = MenuKt.ClosedAlphaTarget;
        super.onPull(r2, r3);
    }
}
