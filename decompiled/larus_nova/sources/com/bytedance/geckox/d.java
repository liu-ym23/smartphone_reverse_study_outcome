package com.bytedance.geckox;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f245083a;

    public d(Context r100) {
        this.f245083a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = com.bytedance.gkfs.d.f245158a;     // Catch: Throwable -> L8
        com.bytedance.gkfs.storage.c r101 = new com.bytedance.gkfs.storage.c(0, 0, 0, 0, 0, new com.bytedance.gkfs.storage.d(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));     // Catch: Throwable -> L8
        List<Function0<Unit>> r102 = GkFSUtils.f245072a;     // Catch: Throwable -> L8
        com.bytedance.gkfs.d.c(null, r101, GkFSUtils.a(this.f245083a) * 1024);     // Catch: Throwable -> L6
        return;
    L6:
        th = th;
    L11:
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    L8:
        th = th;
        goto L11
    }
}
