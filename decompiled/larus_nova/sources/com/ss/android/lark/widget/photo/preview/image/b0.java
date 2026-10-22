package com.ss.android.lark.widget.photo.preview.image;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f446654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ErrorResult f446655b;

    public b0(n r100, ErrorResult r101) {
        this.f446654a = r100;
        this.f446655b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f446654a.f446677a;     // Catch: Throwable -> L7
        String r101 = this.f446655b.getDisplayMsg();     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        UDToast.show(r100, r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
