package hj3;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.shopping.store.mall.follows.ECLoadingShadowView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ ECLoadingShadowView a;
    public final /* synthetic */ View b;

    public a(ECLoadingShadowView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ObjectAnimator r0 = this.a.a;
        if (r0 == null) goto L8;
        if (r0 == null) goto L8;
        if (r0.isRunning() != true) goto L8;
        return;
    L8:
        ECLoadingShadowView r1 = this.a;
        View r2 = this.b;
        float[] r3 = new float[2];
        r3[0] = 0.0f;
        float r4 = r1.getX();
        Object r5 = this.b.getParent();
        if (r5 == null) goto L24;
        r3[1] = r4 + ((View) r5).getWidth();
        r1.a = ObjectAnimator.ofFloat(r2, "translationX", r3);
        ObjectAnimator r6 = this.a.a;
        if (r6 == null) goto L13;
        r6.setDuration(1000);
    L13:
        ObjectAnimator r7 = this.a.a;
        if (r7 == null) goto L16;
        r7.setRepeatCount(-1);
    L16:
        ObjectAnimator r8 = this.a.a;
        if (r8 == null) goto L19;
        r8.setRepeatMode(1);
    L19:
        ObjectAnimator r9 = this.a.a;
        if (r9 == null) goto L25;
        r9.start();
        return;
    L25:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
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
