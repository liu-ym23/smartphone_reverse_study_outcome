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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f216550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Dialog f216551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f216552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f216553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f216554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f216555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f216556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f216557h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f216558a;

        public final void b() {
            h r100 = this.f216558a;
            Dialog r101 = r100.f216551b;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.isShowing() == true) goto L16;
            Dialog r102 = r100.f216551b;
            if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r102);
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            DialogLancet.beforeDialogShow(r102);
            r102.show();
            DialogLancet.afterDialogShow(r102);
            return;
        }

        public a(Context r100) {
            this.f216558a = new h(r100);
        }

        public final void a(ShareType r100) {
            if (r100 != ShareType.Wechat) goto L6;
            this.f216558a.f216554e.setBackgroundResource(R.drawable.share_wechat_button_bg);
            this.f216558a.f216555f.setImageResource(R.drawable.icon_pop_wechat_mini_nor);
            return;
        L6:
            if (r100 != ShareType.WechatMoments) goto L9;
            this.f216558a.f216554e.setBackgroundResource(R.drawable.share_wechat_button_bg);
            this.f216558a.f216555f.setImageResource(R.drawable.icon_pop_moments_mini_nor);
            return;
        L9:
            if (r100 != ShareType.QQ) goto L14;
            this.f216558a.f216554e.setBackgroundResource(R.drawable.share_qq_button_bg);
            this.f216558a.f216555f.setImageResource(R.drawable.icon_pop_qq_mini_nor);
            return;
        }
    }

    public interface b {
        void onDismiss();
    }

    public interface c {
        void a();
    }

    public h(Context r100) {
        View r101 = LayoutInflater.from(r100).inflate(R.layout.share_link_dialog_layout, null);
        this.f216550a = r101;
        this.f216552c = (TextView) r101.findViewById(R.id.title);
        this.f216553d = (TextView) r101.findViewById(R.id.content);
        this.f216554e = r101.findViewById(R.id.share_btn);
        this.f216555f = (ImageView) r101.findViewById(R.id.external_app_icon);
        this.f216556g = (TextView) r101.findViewById(R.id.share_channel_text);
        this.f216557h = (TextView) r101.findViewById(R.id.cancel_btn);
        Dialog r102 = new Dialog(r100, R.style.ShareLinkDialogStyle);
        this.f216551b = r102;
        r102.setContentView(r101);
        Window r103 = this.f216551b.getWindow();
        if (r103 == null) goto L5;
        WindowManager.LayoutParams r104 = r103.getAttributes();
        r104.width = -2;
        r104.height = -2;
        r103.setAttributes(r104);
        r103.setBackgroundDrawableResource(R.color.lkui_transparent);
    L5:
        this.f216557h.setOnClickListener(new d(this));
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }
}
