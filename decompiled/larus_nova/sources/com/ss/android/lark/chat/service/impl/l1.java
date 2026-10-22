package com.ss.android.lark.chat.service.impl;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.im.sdk.ImSdk;

/* JADX INFO: loaded from: classes35.dex */
public final class l1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ErrorResult f416539a;

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = ImSdk.f425890a.getContext();     // Catch: Throwable -> L7
        String r101 = this.f416539a.getDisplayMsg();     // Catch: Throwable -> L7
        String r102 = UIUtils.getString(r100, R.string.Lark_Legacy_ErrorMessageTip);     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = r102;
    L5:
        LKUIToast.show(r100, r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public l1(ErrorResult r100) {
        this.f416539a = r100;
    }
}
