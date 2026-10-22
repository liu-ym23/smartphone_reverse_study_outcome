package fl3;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ boolean b;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ e b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            float r6 = r5.getAnimatedFraction();
            int r0 = this.a;
            int r1 = (int) (r0 - (r0 * r6));
            e r2 = this.b;
            View r3 = r2.a;
            if (r2.b == false) goto L5;
            float r7 = r1;
        L6:
            r3.setTranslationY(r7);
            return;
        L5:
            r7 = r6 * (-r0);
            goto L6
        }

        public a(e r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void a() {
        int r0 = (int) (this.a.getHeight() * 0.075f);
        boolean r1 = this.b;
        if (r1 == false) goto L5;
        long r2 = 300;
    L6:
        View r4 = this.a;
        float[] r5 = new float[2];
        float r6 = 0.0f;
        if (r1 == false) goto L9;
        float r8 = 0.0f;
    L10:
        r5[0] = r8;
        if (r1 == false) goto L13;
        r6 = 1.0f;
    L13:
        r5[1] = r6;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r4, "alpha", r5);
        r3.setDuration(r2);
        r3.addUpdateListener(new a(this, r0));
        r3.setInterpolator(new gl3.b());
        r3.start();
        return;
    L9:
        r8 = 1.0f;
        goto L10
    L5:
        r2 = 100;
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

    public e(View r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
