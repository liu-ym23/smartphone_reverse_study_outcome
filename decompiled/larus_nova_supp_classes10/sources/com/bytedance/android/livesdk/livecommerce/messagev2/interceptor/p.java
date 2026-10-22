package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuthorOrderLimitInfo;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p extends com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a {
    public boolean e;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ ECAlertDialog a;

        public a(ECAlertDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
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
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r7 == null) goto L16;
            com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r6.getLooper()) goto L7;
            r6.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    public p() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        si2.b0 r1 = null;
        if ((r5 instanceof si2.b0) == true) goto L5;
        r5 = null;
    L5:
        si2.b0 r6 = (si2.b0) r5;
        if (r6 != null) goto L8;
    L23:
        return false;
    L8:
        if (r6.msgType == 0) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        r1 = r6;
    L15:
        if (r1 == null) goto L23;
        Context r7 = getContext();
        if (r7 == null) goto L19;
        f(r7, r1);
    L22:
        return true;
    L19:
        Activity r8 = ECAppInfoService.e.getCurrentActivity();
        if (r8 == null) goto L22;
        f(r8, r1);
        goto L22
    L10:
        if (this.e == false) goto L12;
        r2 = true;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        this.e = r2;
    }

    public final void f(Context r10, si2.b0 r11) {
        ECV2AuthorOrderLimitInfo r12 = r11.authorOrderLimitInfo;
        if (r12 == null) goto L24;
        ECAlertDialog r0 = new ECAlertDialog(r10);
        r0.setTitle(r12.title);
        r0.setMessage(r12.content);
        r0.setPositiveButton(r12.button, new a(r0));
        r0.hideNegativeButton();
        ECDraweeView r1 = new ECDraweeView(r10, null, 0, 6, null);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(w0.a(60.0f), w0.a(60.0f));
        r13.gravity = 1;
        r13.topMargin = w0.a(16.0f);
        r13.bottomMargin = w0.a(8.0f);
        Unit r2 = Unit.INSTANCE;
        r1.setLayoutParams(r13);
        ECUrlModel r14 = new ECUrlModel();
        ECV2AuthorOrderLimitInfo.ICON r3 = r12.icon;
        int r4 = 0;
        if (r3 == null) goto L7;
        int r5 = r3.width;
    L8:
        r14.setWidth(r5);
        ECV2AuthorOrderLimitInfo.ICON r6 = r12.icon;
        if (r6 == null) goto L11;
        r4 = r6.height;
    L11:
        r14.setHeight(r4);
        ECV2AuthorOrderLimitInfo.ICON r15 = r12.icon;
        if (r15 == null) goto L14;
        List<String> r16 = r15.urlList;
    L15:
        r14.setUrlList(r16);
        com.bytedance.android.ec.core.utils.y.a(r1, r14);
        r0.setTopCustomView(r1);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L19:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        return;
    L14:
        r16 = null;
        goto L15
    L7:
        r5 = 0;
        goto L8
    }
}
