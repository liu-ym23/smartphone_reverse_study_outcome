package com.ss.android.lark.videosend.tools;

import android.app.Application;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f445015a;

    public i(String r100) {
        this.f445015a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Application r100 = LarkContext.getApplication();     // Catch: Throwable -> L4
        String r101 = this.f445015a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
        UDToast.show(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
