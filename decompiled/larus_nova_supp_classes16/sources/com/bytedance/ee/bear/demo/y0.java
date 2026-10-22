package com.bytedance.ee.bear.demo;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y0 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog a;
    public final /* synthetic */ SpaceEditText b;
    public final /* synthetic */ OfficeCCMDemoActivity c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SpaceEditText a;
        public final /* synthetic */ OfficeCCMDemoActivity b;
        public final /* synthetic */ AlertDialog c;

        public a(SpaceEditText r1, OfficeCCMDemoActivity r2, AlertDialog r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Editable r5 = this.a.getText();
            ik5.a r0 = null;
            if (r5 == null) goto L5;
            String r6 = r5.toString();
        L6:
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            String r7 = StringsKt.trim(r6).toString();
            if (StringsKt.isBlank(r7) == false) goto L12;
            Toast.showText(this.b, "URL 不能为空");
            return;
        L12:
            ik5.a r1 = this.b.d;
            if (r1 == null) goto L15;
            r0 = r1;
        L16:
            r0.r2(r7, "officesdk_demo");
            Toast.showText(this.b, "已加入预加载队列");
            AlertDialog r8 = this.c;
            Handler r2 = DialogLancet.resolveDialogHandler(r8);
            if (r2 != null) goto L19;
        L21:
            DialogLancet.beforeDialogDismiss(r8);
            r8.dismiss();     // Catch: Throwable -> L24 Exception -> L26
        L30:
            DialogLancet.afterDialogDismiss(r8);
            return;
        L24:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r8);
            throw th;
        L26:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
            if (r3 == null) goto L30;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
            goto L30
        L19:
            if (Looper.myLooper() == r2.getLooper()) goto L21;
            r2.post(DialogLancet.createDismissRunnable(r8));
            return;
        L15:
            Intrinsics.throwUninitializedPropertyAccessException("docsSdk");
            goto L16
        L5:
            r6 = null;
            goto L6
        }
    }

    public y0(AlertDialog r1, SpaceEditText r2, OfficeCCMDemoActivity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r5) {
        this.a.getButton(-1).setOnClickListener(new a(this.b, this.c, this.a));
    }
}
