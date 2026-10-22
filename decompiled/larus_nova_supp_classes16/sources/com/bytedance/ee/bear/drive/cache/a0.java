package com.bytedance.ee.bear.drive.cache;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ x b;

    public a0(x r2) {
        this.a = "DriveDataService-cleanTempFileWhenInit";
        this.b = r2;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        tt5.a.h("LarkDriveCacheService", "onOldOfflineCacheDeleted(" + this.a + ") - onNext, syncCount: " + r4);
        if (r4.intValue() <= 0) goto L6;
        ((ml5.b) this.b.c.getValue()).b("sync_status_doc_finished", Boolean.TRUE);
        return;
    }
}
