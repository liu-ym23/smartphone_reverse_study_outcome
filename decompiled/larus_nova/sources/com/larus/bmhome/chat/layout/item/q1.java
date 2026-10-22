package com.larus.bmhome.chat.layout.item;

import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class q1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f304568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t1 f304569b;

    public /* synthetic */ q1(String r100, t1 r101) {
        this.f304568a = r100;
        this.f304569b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f304568a;
        t1 r101 = this.f304569b;
        FLogger.f375446a.i("NestedFileView", "[removeUplinkProgressObserver] localMessageId:" + r100);
        NestedFileCacheManagerService.f313409b.g(r100).removeObserver(r101.f304646s);
    }
}
