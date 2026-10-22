package com.bytedance.awemeopen.apps.framework.base.view;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Animation.AnimationListener {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ DiggLayout b;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        public final void a() {
            if (((LinkedList) this.a.b.a).size() >= 3) goto L5;
            c r0 = this.a;
            Queue<ImageView> r1 = r0.b.a;
            LinkedList r2 = (LinkedList) r1;
            r2.add(r0.a);
        L5:
            this.a.a.setImageDrawable(null);
            this.a.a.clearAnimation();
            c r3 = this.a;
            r3.b.removeView(r3.a);
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

        public a(c r1) {
            this.a = r1;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        this.b.post(new a(this));
    }

    public c(DiggLayout r1, ImageView r2) {
        this.b = r1;
        this.a = r2;
    }
}
