package com.bytedance.ee.bear.drive.cache;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ String a;

    public b0() {
        this.a = "DriveDataService-cleanTempFileWhenInit";
    }

    public final void accept(Object r3) {
        tt5.a.h("LarkDriveCacheService", "onOldOfflineCacheDeleted(" + this.a + ") - onError, error: " + ((Throwable) r3));
    }
}
