package com.larus.init.task.feed;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes30.dex */
public final class f extends BaseDataSubscriber<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f351254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f351255b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<Void> r100) {
        FLogger.f375446a.w("InitBizPreloadTask", "actionbar_image_prefetch " + this.f351254a + " failed");
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<Void> r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == true) goto L9;
        return;
    L9:
        FLogger.f375446a.d("InitBizPreloadTask", "actionbar_image_prefetch " + this.f351254a + " success cost=" + (System.currentTimeMillis() - this.f351255b) + "ms");
        r100.close();
        return;
    L5:
        if (r100.isFinished() != true) goto L7;
        r101 = true;
        goto L7
    }

    public f(String r100, long r101) {
        this.f351254a = r100;
        this.f351255b = r101;
    }
}
