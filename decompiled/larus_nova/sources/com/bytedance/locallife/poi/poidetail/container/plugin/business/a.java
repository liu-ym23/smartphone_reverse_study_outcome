package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiBusinessAutoScrollPlugin f264055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.locallife.poi.poidetail.container.mob.f f264056b;

    public a(PoiBusinessAutoScrollPlugin r100, com.bytedance.locallife.poi.poidetail.container.mob.f r101) {
        this.f264055a = r100;
        this.f264056b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PoiBusinessAutoScrollPlugin r100 = this.f264055a;     // Catch: Throwable -> L4
        com.bytedance.locallife.poi.poidetail.container.mob.f r101 = this.f264056b;     // Catch: Throwable -> L4
        int r102 = PoiBusinessAutoScrollPlugin.f263890r;     // Catch: Throwable -> L4
        r100.D(r101, "success", null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
