package com.bytedance.android.window.shop.home.presenter;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements Runnable {
    public final /* synthetic */ ECWindowCroppedStyleAnimationPresenter.a a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ n a;

        public a(n r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Float r5 = (Float) r4;
            float r2 = 0.0f;
            if (r5.floatValue() > 0) goto L6;
            ECWindowCroppedStyleAnimationPresenter r6 = this.a.a.a;
            int r0 = ECWindowCroppedStyleAnimationPresenter.B;
            r6.c0().setY(this.a.a.a.e0().getHeight());
            ((FrameLayout) this.a.a.a.r.getValue()).setY(0.0f);
            return;
        L6:
            if (r5.floatValue() >= 1) goto L18;
            ECWindowCroppedStyleAnimationPresenter r7 = this.a.a.a;
            int r1 = ECWindowCroppedStyleAnimationPresenter.B;
            Pair r3 = (Pair) r7.O().getOffsetState().getValue();
            if (r3 == null) goto L12;
            Integer r8 = (Integer) r3.getFirst();
            if (r8 == null) goto L12;
            Float r9 = Float.valueOf(r8.intValue());
        L13:
            if (r9 == null) goto L15;
            r2 = Math.abs(r9.floatValue()) - r7.W();
        L15:
            r7.c0().setY(r7.e0().getHeight() - r2);
            ((FrameLayout) r7.r.getValue()).setY(-r2);
            return;
        L12:
            r9 = null;
            goto L13
        }
    }

    public n(ECWindowCroppedStyleAnimationPresenter.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.O().getSubCollapseProgress().observe(this.a.a.U(), new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
