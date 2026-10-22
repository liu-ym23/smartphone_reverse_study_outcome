package gl9;

import android.animation.ValueAnimator;
import com.larus.mirabridge.impl.ui.PluginCircularProgressView;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f481611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f481612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PluginCircularProgressView f481613c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        PluginCircularProgressView r101 = this.f481613c;
        r101.f359349o = ((Float) r100.getAnimatedValue()).floatValue();
        PluginCircularProgressView r102 = this.f481613c;
        r102.f359342h = (this.f481611a - r102.f359349o) + this.f481612b;
        r102.invalidate();
    }

    public c(PluginCircularProgressView r100, float r101, float r102) {
        this.f481613c = r100;
        this.f481611a = r101;
        this.f481612b = r102;
    }
}
