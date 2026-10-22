package com.bytedance.ee.bear.drive.cache;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f224047a;

    public b0() {
        this.f224047a = "DriveDataService-cleanTempFileWhenInit";
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("LarkDriveCacheService", "onOldOfflineCacheDeleted(" + this.f224047a + ") - onError, error: " + ((Throwable) r100));
    }
}
