package com.ss.android.lark.forwardv3.utils;

import android.content.Context;
import com.bytedance.lark.pb.im.v1.FilePermCheckBlockInfo;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f425572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilePermCheckBlockInfo f425573b;

    public d(Context r100, FilePermCheckBlockInfo r101) {
        this.f425572a = r100;
        this.f425573b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.f425572a, this.f425573b.toast);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
