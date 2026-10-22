package com.ss.android.lark.flow.feed.long_click;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f423404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowFeedDialogBuilder f423405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UDDialog f423406c;

    public c(Ref.BooleanRef r100, FlowFeedDialogBuilder r101, UDDialog r102) {
        this.f423404a = r100;
        this.f423405b = r101;
        this.f423406c = r102;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        Ref.BooleanRef r103 = this.f423404a;
        r103.element = FlowFeedDialogBuilder.b(this.f423405b, r101.getRawX(), r101.getRawY());
        return this.f423404a.element;
    L5:
        if (r102 != 1) goto L7;
        boolean r104 = FlowFeedDialogBuilder.b(this.f423405b, r101.getRawX(), r101.getRawY());
        if (this.f423404a.element == false) goto L30;
        if (r104 == false) goto L30;
        UDDialog r105 = this.f423406c;
        Handler r106 = DialogLancet.resolveDialogHandler(r105);
        if (r106 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(r105);
        r105.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(r105);
        goto L30
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r105);
        throw th;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r107 == null) goto L27;
        com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
        goto L27
    L16:
        if (Looper.myLooper() == r106.getLooper()) goto L18;
        r106.post(DialogLancet.createDismissRunnable(r105));
    L30:
        Ref.BooleanRef r108 = this.f423404a;
        boolean r109 = r108.element;
        r108.element = false;
        return r109;
    L7:
        if (r102 != 3) goto L36;
        this.f423404a.element = false;
        return false;
    L36:
        return this.f423404a.element;
    }
}
