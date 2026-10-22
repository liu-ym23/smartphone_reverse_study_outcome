package if3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BadgeView f489571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f489572b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f489573a;

        public a(d r100) {
            this.f489573a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Animator r100 = this.f489573a.f489571a.f177933o;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.start();     // Catch: Throwable -> L6
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
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f489572b.setScaleX(1.0f);
        this.f489572b.setScaleY(1.0f);
        this.f489572b.postDelayed(new a(this), 500);
    }

    public d(BadgeView r100, View r101) {
        this.f489571a = r100;
        this.f489572b = r101;
    }
}
