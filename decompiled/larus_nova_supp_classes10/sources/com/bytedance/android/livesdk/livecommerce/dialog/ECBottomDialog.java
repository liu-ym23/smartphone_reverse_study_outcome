package com.bytedance.android.livesdk.livecommerce.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECBottomDialog extends AppCompatDialog {
    public b a;
    public ih2.a b;

    public class a implements Runnable {
        public final /* synthetic */ ECBottomDialog a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.J0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ECBottomDialog r1) {
            this.a = r1;
        }
    }

    public interface b {
        void Nc(a r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void cancel() {
        b r0 = this.a;
        if (r0 != null) goto L6;
        super/*android.app.Dialog*/.cancel();
        return;
    L6:
        r0.Nc(new a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r1 = I0(r0).getViewTreeObserver();
        if (r1.isAlive() == false) goto L9;
        r1.removeOnPreDrawListener(this.b);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J0() {
        super/*android.app.Dialog*/.cancel();
    }

    public static View I0(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Window r3 = getWindow();
        if (r3 == null) goto L7;
        this.b = new ih2.a(r3);
        I0(r3).getViewTreeObserver().addOnPreDrawListener(this.b);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r1) {
        return super/*android.app.Dialog*/.onTouchEvent(r1);
    }

    public ECBottomDialog(Context r1, int r2) {
        super(r1, r2);
        this.b = null;
        supportRequestWindowFeature(1);
    }
}
