package gl9;

import android.animation.ValueAnimator;
import com.larus.mirabridge.impl.ui.PluginCircularProgressView;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PluginCircularProgressView f481609a;

    public a(PluginCircularProgressView r100) {
        this.f481609a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        PluginCircularProgressView r101 = this.f481609a;
        r101.f359342h = ((Float) r100.getAnimatedValue()).floatValue();
        this.f481609a.invalidate();
    }
}
