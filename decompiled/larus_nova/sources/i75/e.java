package i75;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    public static class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation.AnimationListener f488466a;

        public a() {
            this.f488466a = null;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r100) {
            Animation.AnimationListener r101 = this.f488466a;
            if (r101 == null) goto L6;
            r101.onAnimationEnd(r100);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
            Animation.AnimationListener r101 = this.f488466a;
            if (r101 == null) goto L6;
            r101.onAnimationRepeat(r100);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            Animation.AnimationListener r101 = this.f488466a;
            if (r101 == null) goto L6;
            r101.onAnimationStart(r100);
            return;
        }
    }

    public static void a(View r100) {
        Object r101 = r100.getTag(r100.getId());
        if ((r101 instanceof Disposable) == false) goto L8;
        Disposable r102 = (Disposable) r101;
        if (r102.isDisposed() == true) goto L9;
        r102.dispose();
        tt5.a.b("CrossFadeAnimUtil", "detach auto hide disposable. ");
        return;
    L9:
        return;
    }

    public static void b(View r100) {
        boolean r101 = true;
        if (r100.getVisibility() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L18;
        Animation r103 = r100.getAnimation();
        if (r103 != null) goto L10;
    L14:
        r101 = false;
    L15:
        if (r101 == true) goto L19;
        tt5.a.b("CrossFadeAnimUtil", "hideWithAnim. ");
        a(r100);
        TranslateAnimation r104 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -r100.getHeight());
        r104.setDuration(150);
        r104.setAnimationListener(new d(r100));
        r100.startAnimation(r104);
        return;
    L19:
        return;
    L10:
        if (r103.hasStarted() == false) goto L14;
        if (r103.hasEnded() == true) goto L14;
    L18:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
