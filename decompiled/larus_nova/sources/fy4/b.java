package fy4;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.blockmenu.BlockMenuPanel;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockMenuPanel f479280a;

    public b(BlockMenuPanel r100) {
        this.f479280a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams r102 = this.f479280a.f217687o.getLayoutParams();
        r102.height = r101;
        this.f479280a.f217687o.setLayoutParams(r102);
    }
}
