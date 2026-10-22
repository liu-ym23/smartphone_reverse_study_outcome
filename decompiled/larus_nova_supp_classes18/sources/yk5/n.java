package yk5;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends yk5.b {
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
        public final /* synthetic */ n a;

        public static final class a implements Runnable {
            public final /* synthetic */ n a;

            public a(n r1) {
                this.a = r1;
            }

            public final void a() {
                n r0 = this.a;
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

        public b(n r1) {
            this.a = r1;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (this.a.isShowing() == false) goto L9;
            n r3 = this.a;
            r3.b = true;
            sk5.d.b r4 = r3.j;
            if (r4 == null) goto L7;
            ((vk5.b) r4).b();
        L7:
            post(new a(this.a));
            String r5 = n.t;
            tt5.a.h(n.t, "auto dismiss dialog");
            return;
        }
    }

    static {
        t = n.class.getSimpleName();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s.removeMessages(this.r);
    }

    @Override // yk5.b, ep5.a, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (this.q > 0) goto L10;
        return;
    L10:
        if (this.s.hasMessages(this.r) == true) goto L17;
        this.s.sendEmptyMessageDelayed(this.r, this.q);
        return;
    L17:
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public n(FragmentActivity r3, Window r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "currentActiveWindow");
        super(r3, r4, 2131953437);
        this.k = r3;
        this.r = 1;
        this.s = new b(this);
        View r5 = LayoutInflater.from(r3).inflate(2131564121, null);
        this.a = r5;
        this.l = (TextView) r5.findViewById(2131381458);
        this.m = (TextView) this.a.findViewById(2131381456);
        this.n = this.a.findViewById(2131381455);
        this.o = this.a.findViewById(2131381457);
        this.p = r3.getResources().getDimensionPixelSize(2131167883);
        this.q = -1;
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
