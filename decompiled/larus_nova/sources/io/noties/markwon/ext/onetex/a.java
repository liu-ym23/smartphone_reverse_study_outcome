package io.noties.markwon.ext.onetex;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Runnable f492392v;

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);     // Catch: Throwable -> L7
        Runnable r100 = this.f492392v;     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        r100.run();     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public a(Runnable r100) {
        this.f492392v = r100;
        super("latex-parse");
    }
}
