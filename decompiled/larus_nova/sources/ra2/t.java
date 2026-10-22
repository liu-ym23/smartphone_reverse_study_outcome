package ra2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchHotMsgView f536833a;

    public t(MatchHotMsgView r100) {
        this.f536833a = r100;
    }

    public final void a() {
        MatchHotMsgView r100 = this.f536833a;
        MatchHotMsgView.b(r100.getScaleAnimatorSets());
        r100.removeCallbacks(r100.f140133o);
        r100.removeCallbacks(r100.f140134p);
        AnimatorSet r101 = new AnimatorSet();
        r100.D = r101;
        r101.play(ObjectAnimator.ofFloat(r100.f140122d, "alpha", new float[]{1.0f, 0.0f}));
        AnimatorSet r102 = r100.D;
        if (r102 == null) goto L5;
        r102.setDuration(200);
    L5:
        AnimatorSet r103 = r100.D;
        if (r103 == null) goto L8;
        r103.addListener(new p(r100));
    L8:
        AnimatorSet r104 = r100.D;
        if (r104 == null) goto L12;
        r104.start();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
