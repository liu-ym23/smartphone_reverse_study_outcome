package com.bytedance.ee.bear.bizwidget.shareview;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public final View a;
    public Dialog b;
    public TextView c;
    public TextView d;
    public View e;
    public ImageView f;
    public TextView g;
    public TextView h;

    public static final class a {
        public final h a;

        public final void b() {
            h r0 = this.a;
            Dialog r1 = r0.b;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.isShowing() == true) goto L16;
            Dialog r2 = r0.b;
            if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r2);
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            DialogLancet.beforeDialogShow(r2);
            r2.show();
            DialogLancet.afterDialogShow(r2);
            return;
        }

        public a(Context r2) {
            this.a = new h(r2);
        }

        public final void a(ShareType r3) {
            if (r3 != ShareType.Wechat) goto L6;
            this.a.e.setBackgroundResource(2131247768);
            this.a.f.setImageResource(2131238038);
            return;
        L6:
            if (r3 != ShareType.WechatMoments) goto L9;
            this.a.e.setBackgroundResource(2131247768);
            this.a.f.setImageResource(2131238036);
            return;
        L9:
            if (r3 != ShareType.QQ) goto L14;
            this.a.e.setBackgroundResource(2131247752);
            this.a.f.setImageResource(2131238037);
            return;
        }
    }

    public interface b {
        void onDismiss();
    }

    public interface c {
        void a();
    }

    public h(Context r4) {
        View r0 = LayoutInflater.from(r4).inflate(2131564512, null);
        this.a = r0;
        this.c = (TextView) r0.findViewById(2131388772);
        this.d = (TextView) r0.findViewById(2131367794);
        this.e = r0.findViewById(2131386059);
        this.f = (ImageView) r0.findViewById(2131371999);
        this.g = (TextView) r0.findViewById(2131386066);
        this.h = (TextView) r0.findViewById(2131365123);
        Dialog r1 = new Dialog(r4, 2131953413);
        this.b = r1;
        r1.setContentView(r0);
        Window r5 = this.b.getWindow();
        if (r5 == null) goto L5;
        WindowManager.LayoutParams r2 = r5.getAttributes();
        r2.width = -2;
        r2.height = -2;
        r5.setAttributes(r2);
        r5.setBackgroundDrawableResource(2131103546);
    L5:
        this.h.setOnClickListener(new d(this));
    }

    public static void a(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }
}
