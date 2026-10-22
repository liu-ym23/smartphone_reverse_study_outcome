package fl3;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f477696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f477697b;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f477698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f477699b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            int r102 = this.f477698a;
            int r103 = (int) (r102 - (r102 * r101));
            e r104 = this.f477699b;
            View r105 = r104.f477696a;
            if (r104.f477697b == false) goto L5;
            float r106 = r103;
        L6:
            r105.setTranslationY(r106);
            return;
        L5:
            r106 = r101 * (-r102);
            goto L6
        }

        public a(e r100, int r101) {
            this.f477699b = r100;
            this.f477698a = r101;
        }
    }

    public final void a() {
        int r100 = (int) (this.f477696a.getHeight() * 0.075f);
        boolean r101 = this.f477697b;
        if (r101 == false) goto L5;
        long r102 = 300;
    L6:
        View r103 = this.f477696a;
        float[] r104 = new float[2];
        float r105 = 0.0f;
        if (r101 == false) goto L9;
        float r106 = 0.0f;
    L10:
        r104[0] = r106;
        if (r101 == false) goto L13;
        r105 = 1.0f;
    L13:
        r104[1] = r105;
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r103, "alpha", r104);
        r107.setDuration(r102);
        r107.addUpdateListener(new a(this, r100));
        r107.setInterpolator(new gl3.b());
        r107.start();
        return;
    L9:
        r106 = 1.0f;
        goto L10
    L5:
        r102 = 100;
        goto L6
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

    public e(View r100, boolean r101) {
        this.f477696a = r100;
        this.f477697b = r101;
    }
}
