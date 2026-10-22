package com.ss.android.lark.widget.menu;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.ui.BaseDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f446487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.c f446488b;

    public c(b.c r100, List r101) {
        this.f446488b = r100;
        this.f446487a = r101;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        b.a r104 = (b.a) ListProtector.get(this.f446487a, r102);
        if (r104 == null) goto L26;
        b.InterfaceC5405b r105 = r104.f446473b;
        if (r105 == null) goto L33;
        r105.a();
        if (this.f446488b.f446483a.isShowing() == false) goto L30;
        BaseDialog r106 = this.f446488b.f446483a;
        Handler r107 = DialogLancet.resolveDialogHandler(r106);
        if (r107 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r106);
        r106.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r106);
        return;
    L19:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r108 == null) goto L23;
        d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r106);
        throw th;
    L12:
        if (Looper.myLooper() == r107.getLooper()) goto L14;
        r107.post(DialogLancet.createDismissRunnable(r106));
        return;
    L30:
        return;
    L33:
        return;
    }
}
