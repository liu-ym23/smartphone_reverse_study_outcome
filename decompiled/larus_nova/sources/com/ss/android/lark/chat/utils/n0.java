package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f416706a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f416707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f416708b;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.n0$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC4876a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final DialogInterfaceOnClickListenerC4876a f416709a = null;

            static {
                f416709a = new DialogInterfaceOnClickListenerC4876a();
            }

            public DialogInterfaceOnClickListenerC4876a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                r100.dismiss();
            }
        }

        public a(Context r100, String r101) {
            this.f416707a = r100;
            this.f416708b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.larksuite.component.ui.dialog.d r100 = new com.larksuite.component.ui.dialog.d(this.f416707a);     // Catch: Throwable -> L4
            r100.h(this.f416708b);     // Catch: Throwable -> L4
            r100.a(R.id.ud_dialog_btn_primary, R.string.Lark_IMSecureKey_KeyDeletedCantSentMessageContactAdmin_GotItButton, DialogInterfaceOnClickListenerC4876a.f416709a);     // Catch: Throwable -> L4
            r100.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "errorResult");
        Log.i("MessageUtils", "handleMessageDecryptFailedIfNeed, errorCode: " + r100.getErrorCode());
        Context r101 = ImSdk.f425890a.getContext();
        switch(r100.getErrorCode()) {
            case 311100: goto L6;
            case 311101: goto L4;
            case 311102: goto L6;
            case 311103: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        String r102 = r100.getDisplayMsg();
        if (TextUtils.isEmpty(r102) == false) goto L9;
        r102 = UIUtils.getString(r101, R.string.Lark_IMSecureKey_KeyDeletedCantSentMessageContactAdmin_PopupText);
    L9:
        UICallbackExecutor.execute(new a(r101, r102));
        return true;
    }
}
