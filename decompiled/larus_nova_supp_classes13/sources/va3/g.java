package va3;

import android.view.animation.Animation;
import com.bytedance.android.shopping.extensions.k;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Animation.AnimationListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ float b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r6) {
        h r7 = this.a;
        r7.postDelayed(r7.a, RangesKt.coerceAtLeast((long) (k.d(Float.valueOf(this.b)) * 1000), 50));
    }

    public g(h r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
