package va3;

import android.view.animation.Animation;
import com.bytedance.android.shopping.extensions.k;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f553929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f553930b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        c r101 = this.f553929a;
        r101.postDelayed(r101.f553931a, RangesKt.coerceAtLeast((long) (k.d(Float.valueOf(this.f553930b)) * 1000), 50));
    }

    public b(c r100, float r101) {
        this.f553929a = r100;
        this.f553930b = r101;
    }
}
