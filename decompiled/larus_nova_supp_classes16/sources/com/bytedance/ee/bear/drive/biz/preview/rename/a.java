package com.bytedance.ee.bear.drive.biz.preview.rename;

import com.bytedance.ee.bear.drive.cache.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ DriveRenameUpdatePlugin a;

    public a(DriveRenameUpdatePlugin r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        f85.a r4 = (f85.a) r3;
        this.a.getHost().c.setFileModel(r4);
        this.a.getHost().c.setFileName(((f85.a.C0229a) r4.a).b);
        t r0 = o75.b.a().getCacheManager();
        String r1 = k75.a.d(this.a);
        String r5 = ((f85.a.C0229a) r4.a).b;
        r0.getClass();
        t.q(r1, r5);
    }
}
