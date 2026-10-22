package fy4;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.blockmenu.BlockMenuPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BlockMenuPanel a;

    public b(BlockMenuPanel r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        int r3 = ((Integer) r2.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams r0 = this.a.o.getLayoutParams();
        r0.height = r3;
        this.a.o.setLayoutParams(r0);
    }
}
