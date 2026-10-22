package yk5;

import android.content.DialogInterface;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f568174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f568175d;

    public static final class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f568176a;

        public a(g r100) {
            this.f568176a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            uk5.d r101 = this.f568176a.f568165v;
            if (r101 == null) goto L6;
            r101.onClick();
            return;
        }
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        g r101 = this.f568174c;
        if (r101.f568165v != null) goto L6;
        return;
    L6:
        if (this.f568175d == true) goto L9;
        RectF r102 = r101.f568166w;
        PointF r103 = r101.f568167x;
        if (r102.contains(r103.x, r103.y) == true) goto L9;
        return;
    L9:
        this.f568174c.f568129b = true;
        g r104 = this.f568174c;
        r104.setOnDismissListener(new a(r104));
        g r105 = this.f568174c;
        Handler r106 = DialogLancet.resolveDialogHandler(r105);
        if (r106 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r105);
        r105.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r105);
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r107 == null) goto L23;
        com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r105);
        throw th;
    L12:
        if (Looper.myLooper() == r106.getLooper()) goto L14;
        r106.post(DialogLancet.createDismissRunnable(r105));
    }

    public j(g r100, boolean r101) {
        this.f568174c = r100;
        this.f568175d = r101;
    }
}
