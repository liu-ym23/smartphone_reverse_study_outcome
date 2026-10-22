package yk5;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends yk5.b {
    public static final String t = null;
    public final FragmentActivity k;
    public final TextView l;
    public final TextView m;
    public final View n;
    public final View o;
    public final int p;
    public int q;
    public final int r;
    public final b s;

    public static final class a {
    }

    public static final class b extends Handler {
        public final /* synthetic */ q a;

        public static final class a implements Runnable {
            public final /* synthetic */ q a;

            public a(q r1) {
                this.a = r1;
            }

            public final void a() {
                q r0 = this.a;
                Handler r1 = DialogLancet.resolveDialogHandler(r0);
                if (r1 != null) goto L5;
            L7:
                DialogLancet.beforeDialogDismiss(r0);
                r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
            L16:
                DialogLancet.afterDialogDismiss(r0);
                return;
            L10:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r0);
                throw th;
            L12:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
                Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
                if (r2 == null) goto L16;
                com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
                goto L16
            L5:
                if (Looper.myLooper() == r1.getLooper()) goto L7;
                r1.post(DialogLancet.createDismissRunnable(r0));
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

        public b(q r1) {
            this.a = r1;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (this.a.isShowing() == false) goto L9;
            q r3 = this.a;
            r3.b = true;
            sk5.d.b r4 = r3.j;
            if (r4 == null) goto L7;
            ((vk5.b) r4).b();
        L7:
            post(new a(this.a));
            String r5 = q.t;
            tt5.a.h(q.t, "auto dismiss dialog");
            return;
        }
    }

    static {
        t = q.class.getSimpleName();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s.removeMessages(this.p);
    }

    @Override // yk5.b, android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L6;
        r4.addFlags(262144);
        r4.setGravity(8388659);
        r4.setLayout(-2, this.r + this.o.getMeasuredHeight());
        return;
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        String r0 = t;
        tt5.a.b(r0, "onTouchEvent: " + r4);
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.s.hasMessages(this.p) == false) goto L7;
        return false;
    L7:
        if (r4.getAction() == 4) goto L9;
        return false;
    L9:
        if (this.s.hasMessages(this.p) == true) goto L11;
        this.s.sendEmptyMessageDelayed(this.p, this.q);
        return true;
    L11:
        tt5.a.h(r0, "already setup timer");
        return true;
    }

    public q(FragmentActivity r3, Window r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "currentActiveWindow");
        super(r3, r4, 2131953747);
        this.k = r3;
        this.p = 2;
        this.q = 2000;
        this.s = new b(this);
        View r5 = LayoutInflater.from(r3).inflate(2131564123, null);
        this.a = r5;
        this.l = (TextView) r5.findViewById(2131381458);
        this.m = (TextView) this.a.findViewById(2131381456);
        this.n = this.a.findViewById(2131381455);
        this.o = this.a.findViewById(2131381457);
        this.r = r3.getResources().getDimensionPixelSize(2131167883);
    }

    @Override // yk5.b
    public final void e(int r2, int r3, int r4) {
        this.o.setBackgroundTintList(ColorStateList.valueOf(r2));
        this.n.setBackgroundTintList(ColorStateList.valueOf(r2));
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.o.setOutlineSpotShadowColor(r3);
        this.o.setOutlineAmbientShadowColor(r3);
        this.n.setOutlineSpotShadowColor(r3);
        this.n.setOutlineAmbientShadowColor(r3);
        return;
    }
}
