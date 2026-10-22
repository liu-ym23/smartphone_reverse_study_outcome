package com.ss.android.lark.flow.feed.long_click;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDDialog f423403a;

    public b(UDDialog r100) {
        this.f423403a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        int r109 = r103 - r101;
        int r110 = r104 - r102;
        int r111 = r107 - r105;
        int r112 = r108 - r106;
        if (r111 <= 0) goto L24;
        if (r112 <= 0) goto L28;
        if (r109 != r111) goto L7;
        if (r110 != r112) goto L7;
        return;
    L7:
        com.ss.android.lark.flow.feed.utils.b.d("FeedFlowDialogBuilder", "item  size changed, dismiss dialog");
        UDDialog r113 = this.f423403a;
        Handler r114 = DialogLancet.resolveDialogHandler(r113);
        if (r114 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r113);
        r113.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r113);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r113);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r115 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r115 == null) goto L21;
        com.bytedance.crash.d.d(r115, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r114.getLooper()) goto L12;
        r114.post(DialogLancet.createDismissRunnable(r113));
        return;
    L28:
        return;
    }
}
