package com.ss.android.lark.chat.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f416711a;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f416712a;

        public a(Runnable r100) {
            this.f416712a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f416712a.run();
            r100.dismiss();
        }
    }

    public o0(com.ss.android.lark.chat.service.impl.k1 r100) {
        this.f416711a = r100;
    }

    public final void a() {
        Activity r100 = ImSdkProxy.b().getTopActivity();
        if (r100 != null) goto L6;
        Log.e("MessageUtils", "top activity is null");
        return;
    L6:
        new UDDialogBuilder(r100).message(R.string.Lark_IM_RecalledPicsVideosExceedStorageTime_Title).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_IM_RecalledPicsVideosExceedStorageTime_Send_Button, new a(this.f416711a)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Lark_IM_RecalledPicsVideosExceedStorageTime_Cancel_Button, null).show();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
