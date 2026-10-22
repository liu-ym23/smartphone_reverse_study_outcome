package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f219074a;

    public i(Context r100) {
        this.f219074a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f219074a.getText(R.string.LarkCCM_Docs_AppLinkDoc_CreateFail_Toast).toString();     // Catch: Throwable -> L4
        Toast.showFailureText(this.f219074a, r100, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
