package zf1;

import android.animation.ValueAnimator;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0.b f571646a;

    public c0(b0.b r100) {
        this.f571646a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        b0 r101 = this.f571646a.f571644a;
        int r102 = ((Integer) r100.getAnimatedValue()).intValue();
        DataCenter r103 = r101.f571631b;
        if (r103 == null) goto L6;
        r103.put("data_backtrack_progress_changed", new f(r102));
        return;
    }
}
