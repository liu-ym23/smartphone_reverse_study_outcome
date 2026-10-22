package com.ss.android.lark.contact.base.common_ui;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f418560a = null;

    static {
        f418560a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(LarkContext.getApplication(), R.string.Lark_Legacy_NetworkError);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
