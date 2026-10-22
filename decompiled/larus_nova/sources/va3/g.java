package va3;

import android.view.animation.Animation;
import com.bytedance.android.shopping.extensions.k;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f553935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f553936b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        h r101 = this.f553935a;
        r101.postDelayed(r101.f553937a, RangesKt.coerceAtLeast((long) (k.d(Float.valueOf(this.f553936b)) * 1000), 50));
    }

    public g(h r100, float r101) {
        this.f553935a = r100;
        this.f553936b = r101;
    }
}
