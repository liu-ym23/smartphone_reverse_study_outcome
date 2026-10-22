package hj3;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.shopping.store.mall.follows.ECLoadingShadowView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECLoadingShadowView f485404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f485405b;

    public a(ECLoadingShadowView r100, View r101) {
        this.f485404a = r100;
        this.f485405b = r101;
    }

    public final void a() {
        ObjectAnimator r100 = this.f485404a.f185523a;
        if (r100 == null) goto L8;
        if (r100 == null) goto L8;
        if (r100.isRunning() != true) goto L8;
        return;
    L8:
        ECLoadingShadowView r101 = this.f485404a;
        View r102 = this.f485405b;
        float[] r103 = new float[2];
        r103[0] = 0.0f;
        float r104 = r101.getX();
        Object r105 = this.f485405b.getParent();
        if (r105 == null) goto L24;
        r103[1] = r104 + ((View) r105).getWidth();
        r101.f185523a = ObjectAnimator.ofFloat(r102, LiveDegradeFpsAnimator.TRANSLATION_X, r103);
        ObjectAnimator r106 = this.f485404a.f185523a;
        if (r106 == null) goto L13;
        r106.setDuration(1000);
    L13:
        ObjectAnimator r107 = this.f485404a.f185523a;
        if (r107 == null) goto L16;
        r107.setRepeatCount(-1);
    L16:
        ObjectAnimator r108 = this.f485404a.f185523a;
        if (r108 == null) goto L19;
        r108.setRepeatMode(1);
    L19:
        ObjectAnimator r109 = this.f485404a.f185523a;
        if (r109 == null) goto L25;
        r109.start();
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
