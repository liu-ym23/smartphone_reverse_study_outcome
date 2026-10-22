package vp5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.wikiv2.common.widget.ExpandButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ Drawable a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ExpandButton c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        super.onAnimationEnd(r4);
        ExpandButton r5 = this.c;
        Drawable r0 = this.a;
        String r1 = this.b;
        r5.a.setImageDrawable(r0);
        r5.b.setText(r1);
    }

    public c(ExpandButton r1, Drawable r2, String r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
