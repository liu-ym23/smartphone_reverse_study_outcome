package com.bytedance.ee.bear.drive.test.item;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CompoundButton;
import com.bytedance.ee.bear.drive.services.v;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ c a;

    public e(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        int r7 = v.a;
        y85.a r8 = new y85.a();
        c r0 = this.a;
        CompoundButton r1 = r0.c;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
        r1 = null;
    L5:
        r8.a = r1.isChecked();
        r8.b = r0.f;
        String r2 = r0.g;
        String r3 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r8.c = r2;
        tt5.a.h("DriveSaveCacheManager", "tryToSaveMockData enable=" + Boolean.valueOf(r8.a));     // Catch: Exception -> L15
        com.ss.android.lark.storage.kv.repo.a r4 = ay4.b.d("drive", 6);     // Catch: Exception -> L15
        String r9 = new Gson().toJson(r8);     // Catch: Exception -> L15
        if (r9 == null) goto L13;
        r3 = r9;
    L13:
        r4.putString("KEY_TEST_SAVE_CONFIG", r3);     // Catch: Exception -> L15
    L17:
        UDDialog r10 = this.a.h;
        if (r10 == null) goto L36;
        Handler r5 = DialogLancet.resolveDialogHandler(r10);
        if (r5 != null) goto L22;
    L24:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L27 Exception -> L29
    L33:
        DialogLancet.afterDialogDismiss(r10);
        return;
    L27:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
        throw th;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L27
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L27
        if (r11 == null) goto L33;
        com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L27
        goto L33
    L22:
        if (Looper.myLooper() == r5.getLooper()) goto L24;
        r5.post(DialogLancet.createDismissRunnable(r10));
        return;
    L36:
        return;
    L15:
        e = move-exception;
        tt5.a.k("DriveSaveCacheManager", "tryToSaveMockData fail: " + e);
        goto L17
    }
}
