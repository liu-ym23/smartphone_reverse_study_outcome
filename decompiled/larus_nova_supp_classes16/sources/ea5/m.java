package ea5;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.drive.biz.preview.block.DriveBlockTitleView;
import com.bytedance.ee.bear.drive.view.widget.ProgressBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public final ProgressBar a;
    public final View b;
    public final DriveBlockTitleView c;
    public final int d;
    public final int e;
    public final AnimatorSet f;
    public final AnimatorSet g;
    public final AnimatorSet h;
    public final AnimatorSet i;
    public boolean j;
    public boolean k;

    public final void c() {
        if (this.g.isRunning() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        this.f.cancel();
        this.h.cancel();
        if (this.k == true) goto L15;
        return;
    L15:
        if (this.j == false) goto L17;
        AnimatorSet r1 = this.i;
    L18:
        r1.start();
        return;
    L17:
        r1 = this.g;
        goto L18
    L5:
        if (this.i.isRunning() == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void d() {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        r0.height = this.e;
        this.a.requestLayout();
        this.k = true;
    }

    public final void e() {
        if (this.f.isRunning() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        this.g.cancel();
        this.i.cancel();
        if (this.k == false) goto L15;
        return;
    L15:
        if (this.j == false) goto L17;
        AnimatorSet r1 = this.h;
    L18:
        r1.start();
        return;
    L17:
        r1 = this.f;
        goto L18
    L5:
        if (this.h.isRunning() == true) goto L8;
        r0 = false;
        goto L9
    }

    public final AnimatorSet a(boolean r10) {
        ValueAnimator r0 = com.bytedance.ee.util.ui.g.d(this.b, 0.0f, -com.bytedance.ee.util.ui.n.d(100));
        DriveBlockTitleView r1 = this.c;
        if (r1 == null) goto L5;
        Animator r2 = com.bytedance.ee.util.ui.g.a(r1, this.d, 0).setDuration(150);
    L6:
        AnimatorSet r6 = new AnimatorSet();
        if (r10 == false) goto L9;
        ValueAnimator r11 = com.bytedance.ee.util.ui.g.a(this.a, this.e, 0).setDuration(150);
        r11.addListener(new k(this));
        r6.playTogether(new Animator[]{r11, r0, r2});
    L10:
        return r6;
    L9:
        r0.addListener(new k(this));
        r6.playTogether(new Animator[]{r0, r2});
        goto L10
    L5:
        r2 = ObjectAnimator.ofInt(new int[]{0, 1});
        goto L6
    }

    public final AnimatorSet b(boolean r10) {
        ValueAnimator r0 = com.bytedance.ee.util.ui.g.d(this.b, -com.bytedance.ee.util.ui.n.d(100), 0.0f);
        DriveBlockTitleView r1 = this.c;
        if (r1 == null) goto L5;
        Animator r2 = com.bytedance.ee.util.ui.g.a(r1, 0, this.d).setDuration(150);
    L6:
        AnimatorSet r6 = new AnimatorSet();
        if (r10 == false) goto L9;
        ValueAnimator r11 = com.bytedance.ee.util.ui.g.a(this.a, 0, this.e).setDuration(150);
        r11.addListener(new l(this));
        r6.playTogether(new Animator[]{r11, r0, r2});
    L10:
        return r6;
    L9:
        r0.addListener(new l(this));
        r6.playTogether(new Animator[]{r0, r2});
        goto L10
    L5:
        r2 = ObjectAnimator.ofInt(new int[]{0, 1});
        goto L6
    }

    public m(Context r2, final ProgressBar r3, View r4, DriveBlockTitleView r5) {
        this.k = true;
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r2.getResources().getDimensionPixelSize(2131166311);
        this.e = r2.getResources().getDimensionPixelSize(2131166325);
        r3.post(new j(this, r3));
        this.g = a(true);
        this.i = a(false);
        this.f = b(true);
        this.h = b(false);
    }
}
