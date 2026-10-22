package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ a a;

    public l(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        a r5 = this.a;
        r5.e.j(r5.d, "start_import_file");
    }
}
