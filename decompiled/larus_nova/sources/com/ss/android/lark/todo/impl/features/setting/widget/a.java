package com.ss.android.lark.todo.impl.features.setting.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.time.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoReminderPickerMenu f444005a;

    public a(TodoReminderPickerMenu r100) {
        this.f444005a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = ((WheelView) this.f444005a.findViewById(R.id.reminder_wheel_normal)).getCurrentItem();
        ArrayList<Integer> r102 = f.f443555a;
        if (r101 >= f.f443555a.size()) goto L24;
        TodoReminderPickerMenu r103 = this.f444005a;
        TodoReminderPickerMenu.a r104 = r103.f444002a;
        if (r104 == null) goto L7;
        r104.a(((WheelView) r103.findViewById(R.id.reminder_wheel_normal)).getCurrentItem());
    L7:
        TodoReminderPickerMenu r105 = this.f444005a;
        Handler r106 = DialogLancet.resolveDialogHandler(r105);
        if (r106 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r105);
        r105.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r105);
        return;
    L17:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r107 == null) goto L21;
        d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r105);
        throw th;
    L10:
        if (Looper.myLooper() == r106.getLooper()) goto L12;
        r106.post(DialogLancet.createDismissRunnable(r105));
        return;
    }
}
