package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public DialogRedirect() {
    }

    public abstract void redirect();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r100, int r101) {
        redirect();     // Catch: Throwable -> L5
        if (r100 == null) goto L16;
    L7:
        r100.dismiss();
        return;
    L16:
        return;
    L5:
        HMSLog.e("DialogRedirect", "Failed to start resolution intent");     // Catch: Throwable -> L9
        if (r100 != null) goto L7;
        return;
    L9:
        th = move-exception;
        if (r100 == null) goto L12;
        r100.dismiss();
    L12:
        throw th;
    }

    public static DialogRedirect getInstance(Activity r100, Intent r101, int r102) {
        return new DialogRedirectImpl(r101, r100, r102);
    }
}
