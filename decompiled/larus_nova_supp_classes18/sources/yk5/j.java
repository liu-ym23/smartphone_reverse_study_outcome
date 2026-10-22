package yk5;

import android.content.DialogInterface;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends t {
    public final /* synthetic */ g c;
    public final /* synthetic */ boolean d;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            uk5.d r2 = this.a.v;
            if (r2 == null) goto L6;
            r2.onClick();
            return;
        }
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        g r5 = this.c;
        if (r5.v != null) goto L6;
        return;
    L6:
        if (this.d == true) goto L9;
        RectF r0 = r5.w;
        PointF r6 = r5.x;
        if (r0.contains(r6.x, r6.y) == true) goto L9;
        return;
    L9:
        this.c.b = true;
        g r7 = this.c;
        r7.setOnDismissListener(new a(r7));
        g r8 = this.c;
        Handler r1 = DialogLancet.resolveDialogHandler(r8);
        if (r1 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r8);
        r8.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r8);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r2 == null) goto L23;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r8);
        throw th;
    L12:
        if (Looper.myLooper() == r1.getLooper()) goto L14;
        r1.post(DialogLancet.createDismissRunnable(r8));
    }

    public j(g r1, boolean r2) {
        this.c = r1;
        this.d = r2;
    }
}
