package com.ss.android.lark.conditional.access.traffic;

import com.bytedance.lark.pb.basic.v1.Command;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.b f418431a;

    public b(d r100) {
        this.f418431a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.e.f439875a.b(Command.PUSH_REQ_REGULATE, this.f418431a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
