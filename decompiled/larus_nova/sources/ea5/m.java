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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f471600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f471601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DriveBlockTitleView f471602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f471603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f471604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AnimatorSet f471605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AnimatorSet f471606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AnimatorSet f471607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AnimatorSet f471608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f471609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f471610k;

    public final void c() {
        if (this.f471606g.isRunning() == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        return;
    L11:
        this.f471605f.cancel();
        this.f471607h.cancel();
        if (this.f471610k == true) goto L15;
        return;
    L15:
        if (this.f471609j == false) goto L17;
        AnimatorSet r101 = this.f471608i;
    L18:
        r101.start();
        return;
    L17:
        r101 = this.f471606g;
        goto L18
    L5:
        if (this.f471608i.isRunning() == true) goto L8;
        r100 = false;
        goto L9
    }

    public final void d() {
        ViewGroup.LayoutParams r100 = this.f471600a.getLayoutParams();
        r100.height = this.f471604e;
        this.f471600a.requestLayout();
        this.f471610k = true;
    }

    public final void e() {
        if (this.f471605f.isRunning() == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        return;
    L11:
        this.f471606g.cancel();
        this.f471608i.cancel();
        if (this.f471610k == false) goto L15;
        return;
    L15:
        if (this.f471609j == false) goto L17;
        AnimatorSet r101 = this.f471607h;
    L18:
        r101.start();
        return;
    L17:
        r101 = this.f471605f;
        goto L18
    L5:
        if (this.f471607h.isRunning() == true) goto L8;
        r100 = false;
        goto L9
    }

    public final AnimatorSet a(boolean r110) {
        ValueAnimator r100 = com.bytedance.ee.util.ui.g.d(this.f471601b, 0.0f, -com.bytedance.ee.util.ui.n.d(100));
        DriveBlockTitleView r101 = this.f471602c;
        if (r101 == null) goto L5;
        ValueAnimator r102 = com.bytedance.ee.util.ui.g.a(r101, this.f471603d, 0).setDuration(150);
    L6:
        AnimatorSet r103 = new AnimatorSet();
        if (r110 == false) goto L9;
        ValueAnimator r111 = com.bytedance.ee.util.ui.g.a(this.f471600a, this.f471604e, 0).setDuration(150);
        r111.addListener(new k(this));
        r103.playTogether(new Animator[]{r111, r100, r102});
    L10:
        return r103;
    L9:
        r100.addListener(new k(this));
        r103.playTogether(new Animator[]{r100, r102});
        goto L10
    L5:
        r102 = ObjectAnimator.ofInt(new int[]{0, 1});
        goto L6
    }

    public final AnimatorSet b(boolean r110) {
        ValueAnimator r100 = com.bytedance.ee.util.ui.g.d(this.f471601b, -com.bytedance.ee.util.ui.n.d(100), 0.0f);
        DriveBlockTitleView r101 = this.f471602c;
        if (r101 == null) goto L5;
        ValueAnimator r102 = com.bytedance.ee.util.ui.g.a(r101, 0, this.f471603d).setDuration(150);
    L6:
        AnimatorSet r103 = new AnimatorSet();
        if (r110 == false) goto L9;
        ValueAnimator r111 = com.bytedance.ee.util.ui.g.a(this.f471600a, 0, this.f471604e).setDuration(150);
        r111.addListener(new l(this));
        r103.playTogether(new Animator[]{r111, r100, r102});
    L10:
        return r103;
    L9:
        r100.addListener(new l(this));
        r103.playTogether(new Animator[]{r100, r102});
        goto L10
    L5:
        r102 = ObjectAnimator.ofInt(new int[]{0, 1});
        goto L6
    }

    public m(Context r100, final ProgressBar r101, View r102, DriveBlockTitleView r103) {
        this.f471610k = true;
        this.f471600a = r101;
        this.f471601b = r102;
        this.f471602c = r103;
        this.f471603d = r100.getResources().getDimensionPixelSize(R.dimen.drive_file_block_height);
        this.f471604e = r100.getResources().getDimensionPixelSize(R.dimen.drive_progress_bar_height);
        r101.post(new j(this, r101));
        this.f471606g = a(true);
        this.f471608i = a(false);
        this.f471605f = b(true);
        this.f471607h = b(false);
    }
}
