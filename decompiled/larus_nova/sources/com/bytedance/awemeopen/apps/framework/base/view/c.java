package com.bytedance.awemeopen.apps.framework.base.view;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f193232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiggLayout f193233b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f193234a;

        public final void a() {
            if (((LinkedList) this.f193234a.f193233b.f193149a).size() >= 3) goto L5;
            c r100 = this.f193234a;
            Queue<ImageView> r101 = r100.f193233b.f193149a;
            LinkedList r102 = (LinkedList) r101;
            r102.add(r100.f193232a);
        L5:
            this.f193234a.f193232a.setImageDrawable(null);
            this.f193234a.f193232a.clearAnimation();
            c r103 = this.f193234a;
            r103.f193233b.removeView(r103.f193232a);
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

        public a(c r100) {
            this.f193234a = r100;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f193233b.post(new a(this));
    }

    public c(DiggLayout r100, ImageView r101) {
        this.f193233b = r100;
        this.f193232a = r101;
    }
}
