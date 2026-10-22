package if3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ BadgeView a;
    public final /* synthetic */ View b;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Animator r0 = this.a.a.o;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.start();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.b.setScaleX(1.0f);
        this.b.setScaleY(1.0f);
        this.b.postDelayed(new a(this), 500);
    }

    public d(BadgeView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
