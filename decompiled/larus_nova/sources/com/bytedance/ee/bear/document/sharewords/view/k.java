package com.bytedance.ee.bear.document.sharewords.view;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f221849a;

    public k(Context r100) {
        this.f221849a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.f221849a, R.string.LarkCCM_Docs_FwdSection_Failed_Toast);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
