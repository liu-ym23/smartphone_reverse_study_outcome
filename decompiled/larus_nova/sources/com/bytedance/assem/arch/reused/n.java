package com.bytedance.assem.arch.reused;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReusedAssemProxyV1 f193029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f193030b;

    public n(ReusedAssemProxyV1 r100, List r101) {
        this.f193029a = r100;
        this.f193030b = r101;
    }

    public final void a() {
        List r100 = this.f193030b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        Object r102 = null;
        if (r101 == false) goto L18;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r103 = this.f193029a.f192967a;
        if ((r103 instanceof g) == false) goto L15;
        r102 = r103;
    L15:
        g r104 = (g) r102;
        if (r104 == null) goto L26;
        r104.onBind();
        return;
    L26:
        return;
    L18:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r105 = this.f193029a.f192967a;
        if ((r105 instanceof g) == false) goto L22;
        r102 = r105;
    L22:
        g r106 = (g) r102;
        if (r106 == null) goto L28;
        r106.b();
        return;
    L28:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
