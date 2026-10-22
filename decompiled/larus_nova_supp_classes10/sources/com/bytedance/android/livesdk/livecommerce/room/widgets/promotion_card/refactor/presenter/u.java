package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements Runnable {
    public final /* synthetic */ v.a a;

    public static final class a implements Runnable {
        public final /* synthetic */ u a;

        public a(u r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.b.w().f().setBackgroundColor(-1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public u(v.a r1) {
        this.a = r1;
    }

    public final void a() {
        this.a.b.w().g(0);
        View r0 = this.a.b.w().b(2131372856).f();
        r0.setAlpha(0.0f);
        r0.animate().alpha(1.0f).setDuration(300).setInterpolator(new FastOutSlowInInterpolator()).withEndAction(new a(this)).start();
        View r1 = this.a.b.w().b(2131372857).f();
        r1.setAlpha(0.0f);
        r1.animate().alpha(1.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(300).start();
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
