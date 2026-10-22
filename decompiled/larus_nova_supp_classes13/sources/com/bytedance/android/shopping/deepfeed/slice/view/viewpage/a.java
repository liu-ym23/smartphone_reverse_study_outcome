package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final Handler a;
    public boolean b;
    public boolean c;
    public long d;
    public long e;
    public final b f;
    public final ViewOnAttachStateChangeListenerC0059a g;
    public final ViewPager2 h;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.viewpage.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC0059a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ a a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        public ViewOnAttachStateChangeListenerC0059a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.b();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void a() {
            a r1 = this.a;
            if (r1.c == false) goto L5;
            return;
        L5:
            if (r1.b == true) goto L18;
            float r6 = r1.h.getHeight();
            if (r6 != 0.0f) goto L10;
            r1.a();
            return;
        L10:
            long r3 = RangesKt.coerceAtLeast(r1.e / 16, 1);
            if (r1.h.beginFakeDrag() == true) goto L13;
            r1.a();
            return;
        L13:
            r1.b = true;
            Ref.LongRef r2 = new Ref.LongRef();
            r2.element = 0;
            Ref.FloatRef r7 = new Ref.FloatRef();
            r7.element = 0.0f;
            new AutoScrollViewPager2$scrollToNext$2(r1, r2, r3, new AutoScrollViewPager2$scrollToNext$1(r1), r6, r7, 16).m811invoke();
            return;
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

    public final void a() {
        if (this.c == false) goto L5;
        return;
    L5:
        this.a.postDelayed(this.f, this.d);
    }

    public final void b() {
        this.a.removeCallbacksAndMessages(null);
        if (this.h.isFakeDragging() == true) goto L8;
    L5:
        this.b = false;
        return;
    L8:
        this.h.endFakeDrag();     // Catch: IllegalStateException -> L7
        goto L5
    }

    public a(ViewPager2 r3) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        this.h = r3;
        this.a = new Handler(Looper.getMainLooper());
        this.d = 2000;
        this.e = 1000;
        this.f = new b(this);
        ViewOnAttachStateChangeListenerC0059a r0 = new ViewOnAttachStateChangeListenerC0059a(this);
        this.g = r0;
        r3.addOnAttachStateChangeListener(r0);
    }
}
