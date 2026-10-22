package com.bytedance.android.livesdk.livecommerce.utils;

import android.app.Dialog;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y0 {
    public static final /* synthetic */ int d = 0;
    public final View a;
    public c b;
    public int c;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ y0 a;

        public a(y0 r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            y0 r0 = this.a;
            if (r0.c != 0) goto L5;
            r0.c = r0.a.getHeight();
        L5:
            y0 r1 = this.a;
            if (r1.c != r1.a.getHeight()) goto L8;
            return;
        L8:
            y0 r2 = this.a;
            if ((r2.c - r2.a.getHeight()) <= 200) goto L13;
            c r3 = this.a.b;
            if (r3 == null) goto L16;
            r3.b();
        L16:
            y0 r4 = this.a;
            r4.c = r4.a.getHeight();
            return;
        L13:
            c r5 = this.a.b;
            if (r5 == null) goto L16;
            r5.a();
            goto L16
        }
    }

    public static final class b {
    }

    public interface c {
        void a();

        void b();
    }

    static {
    }

    public y0(Dialog r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        View r6 = r5.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L10;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L10;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L10:
        this.a = r6;
        if (r6 == null) goto L16;
        ViewTreeObserver r7 = r6.getViewTreeObserver();
        if (r7 == null) goto L17;
        r7.addOnGlobalLayoutListener(new a(this));
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r6 = null;
        goto L10
    }
}
