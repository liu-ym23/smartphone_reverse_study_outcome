package com.bytedance.android.shopping.mall.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kk.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends Dialog {
    public static final /* synthetic */ int h = 0;
    public final Handler a;
    public boolean b;
    public final RunnableC0115b c;
    public final int d;
    public int e;
    public int f;
    public final TextView g;

    public static final class a {
        public static void a(Context r2, final String r3, final int r4, int r5, int r6, final int r7) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "message");
            final b r1 = new b(r2);
            r1.e = r5;
            r1.f = r6;
            Intrinsics.checkNotNullParameter(r3, "message");
            d.c(new MallToast$makeShow$1(r1, r3, r7, r4));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.widget.b$b, reason: collision with other inner class name */
    public static final class RunnableC0115b implements Runnable {
        public final /* synthetic */ b a;

        public RunnableC0115b(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            d.c(new MallToast$hidePopupToast$1(r0));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.b = true;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.b = false;
        this.a.removeCallbacks(this.c);
    }

    public b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, 2131954215);
        this.a = new Handler(Looper.getMainLooper());
        this.c = new RunnableC0115b(this);
        this.d = -UIUtils.getStatusBarHeight(r4);
        View r5 = LayoutInflater.from(r4).inflate(2131560788, null);     // Catch: Exception -> L34
        if (r5 == null) goto L6;
        LinearLayout r0 = (LinearLayout) r5.findViewById(2131370790);     // Catch: Exception -> L34
    L6:
        this.g = (TextView) r5.findViewById(2131370791);     // Catch: Exception -> L34
        setContentView(r5);     // Catch: Exception -> L34
        Window r6 = getWindow();     // Catch: Exception -> L34
        if (r6 == null) goto L9;
        r6.addFlags(8);     // Catch: Exception -> L34
    L9:
        Window r7 = getWindow();     // Catch: Exception -> L34
        if (r7 == null) goto L12;
        r7.addFlags(32);     // Catch: Exception -> L34
    L12:
        Window r8 = getWindow();     // Catch: Exception -> L34
        if (r8 == null) goto L15;
        r8.addFlags(16);     // Catch: Exception -> L34
    L15:
        Window r9 = getWindow();     // Catch: Exception -> L34
        if (r9 == null) goto L18;
        r9.addFlags(512);     // Catch: Exception -> L34
    L18:
        Window r10 = getWindow();     // Catch: Exception -> L34
        if (r10 == null) goto L21;
        r10.setLayout(-2, -2);     // Catch: Exception -> L34
    L21:
        Window r11 = getWindow();     // Catch: Exception -> L34
        if (r11 == null) goto L30;
        View r12 = r11.getDecorView();     // Catch: Exception -> L34
        if (c.e == false) goto L28;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L34
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L34
        if (r1 == c.a) goto L28;
        c.a(r1, "getDecorView");     // Catch: Exception -> L34
    L28:
        if (r12 == null) goto L30;
        r12.setTag("ignore_eye_protection");     // Catch: Exception -> L34
    L30:
        Window r13 = getWindow();     // Catch: Exception -> L34
        if (r13 == null) goto L39;
        r13.setGravity(17);     // Catch: Exception -> L34
        return;
    L39:
        return;
    L34:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }
}
