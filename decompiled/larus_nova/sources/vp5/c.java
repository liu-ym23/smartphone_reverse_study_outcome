package vp5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.wikiv2.common.widget.ExpandButton;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Drawable f556646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f556647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ExpandButton f556648c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        super.onAnimationEnd(r100);
        ExpandButton r101 = this.f556648c;
        Drawable r102 = this.f556646a;
        String r103 = this.f556647b;
        r101.f240643a.setImageDrawable(r102);
        r101.f240644b.setText(r103);
    }

    public c(ExpandButton r100, Drawable r101, String r102) {
        this.f556648c = r100;
        this.f556646a = r101;
        this.f556647b = r102;
    }
}
