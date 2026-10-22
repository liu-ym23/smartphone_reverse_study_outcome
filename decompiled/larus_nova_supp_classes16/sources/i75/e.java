package i75;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {

    public static class a implements Animation.AnimationListener {
        public final Animation.AnimationListener a;

        public a() {
            this.a = null;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r2) {
            Animation.AnimationListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onAnimationEnd(r2);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r2) {
            Animation.AnimationListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onAnimationRepeat(r2);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r2) {
            Animation.AnimationListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onAnimationStart(r2);
            return;
        }
    }

    public static void a(View r1) {
        Object r2 = r1.getTag(r1.getId());
        if ((r2 instanceof Disposable) == false) goto L8;
        Disposable r3 = (Disposable) r2;
        if (r3.isDisposed() == true) goto L9;
        r3.dispose();
        tt5.a.b("CrossFadeAnimUtil", "detach auto hide disposable. ");
        return;
    L9:
        return;
    }

    public static void b(View r4) {
        boolean r1 = true;
        if (r4.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        Animation r2 = r4.getAnimation();
        if (r2 != null) goto L10;
    L14:
        r1 = false;
    L15:
        if (r1 == true) goto L19;
        tt5.a.b("CrossFadeAnimUtil", "hideWithAnim. ");
        a(r4);
        TranslateAnimation r3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -r4.getHeight());
        r3.setDuration(150);
        r3.setAnimationListener(new d(r4));
        r4.startAnimation(r3);
        return;
    L19:
        return;
    L10:
        if (r2.hasStarted() == false) goto L14;
        if (r2.hasEnded() == true) goto L14;
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
