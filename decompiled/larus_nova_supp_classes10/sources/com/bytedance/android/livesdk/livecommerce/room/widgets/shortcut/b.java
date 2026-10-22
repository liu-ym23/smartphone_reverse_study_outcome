package com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.bytedance.android.livesdk.livecommerce.model.JumpUrl;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ ECAlertDialog a;

        public a(ECAlertDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            k.h(4);
            ECAlertDialog r5 = this.a;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r7 == null) goto L16;
            d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r6.getLooper()) goto L7;
            r6.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.CharSequence] */
    public static ECAlertDialog a(Context r12, ECV2PopupInfo r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "popupInfo");
        ECAlertDialog r0 = new ECAlertDialog(r12);
        r0.setTitle(r13.title);
        List<JumpUrl> r1 = r13.urls;
        ?? r14 = r13.text;
        boolean r2 = false;
        if (r14 != 0) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r14 = "";
    L32:
        r0.setMessage(r14);
        r0.openContentClick();
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L35
        Object r16 = Result.constructor-impl(th.a.f(r12).getString(2131896559));     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r16) == false) goto L40;
        r16 = "    ";
    L40:
        r0.setPositiveButton((String) r16, new a(r0));
        r0.hideNegativeButton();
        k.h(1);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r0);
    L45:
        return r0;
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L44:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    L35:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L11:
        List<JumpUrl> r5 = r1;
        if (r5 != null) goto L14;
    L15:
        r2 = true;
    L16:
        if (r2 == true) goto L32;
        SpannableStringBuilder r3 = new SpannableStringBuilder(r14);
        Iterator r18 = r1.iterator();
    L20:
        if (r18.hasNext() == false) goto L31;
        JumpUrl r6 = (JumpUrl) r18.next();
        String r7 = r6.getKey();
        if (r7 == null) goto L20;
        String r10 = r6.getText();
        if (r10 == null) goto L20;
        String r11 = "${" + r7 + '}';
        int r8 = StringsKt.indexOf$default(r3, r11, 0, false, 6, null);
    L29:
        if (r8 == (-1)) goto L20;
        r3.replace(r8, r11.length() + r8, r10);
        r3.setSpan(new com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.a(r6, r12), r8, r10.length() + r8, 33);
        r8 = StringsKt.indexOf$default(r3, r11, r8 + r10.length(), false, 4, null);
        goto L29
    L31:
        r14 = r3;
        goto L32
    L14:
        if (r5.isEmpty() == false) goto L16;
    L5:
        if (r14.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
