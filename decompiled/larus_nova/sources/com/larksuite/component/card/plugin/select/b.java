package com.larksuite.component.card.plugin.select;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<List<? extends UniversalCardShowSelectMenuPluginModel$OptionsItemModel>, Unit> f283826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> f283827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LKUIDialog f283828c;

    public b(com.larksuite.component.card.plugin.c r100, List r101, LKUIDialog r102) {
        this.f283826a = r100;
        this.f283827b = r101;
        this.f283828c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f283826a.invoke(this.f283827b);
        LKUIDialog r101 = this.f283828c;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r103 == null) goto L16;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
    }
}
