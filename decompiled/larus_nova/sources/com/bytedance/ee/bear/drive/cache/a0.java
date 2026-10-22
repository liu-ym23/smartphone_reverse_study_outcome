package com.bytedance.ee.bear.drive.cache;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f224045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f224046b;

    public a0(x r100) {
        this.f224045a = "DriveDataService-cleanTempFileWhenInit";
        this.f224046b = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        tt5.a.h("LarkDriveCacheService", "onOldOfflineCacheDeleted(" + this.f224045a + ") - onNext, syncCount: " + r101);
        if (r101.intValue() <= 0) goto L6;
        ((ml5.b) this.f224046b.f224044c.getValue()).b("sync_status_doc_finished", Boolean.TRUE);
        return;
    }
}
