package com.bytedance.ee.bear.drive.biz.preview.more.save2space;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class e implements Function {
    public final /* synthetic */ String a;

    public /* synthetic */ e(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("AttachmentExecutor", "saveFileToSpace, token: " + du5.b.g(this.a) + ", error: ", r5, false);
        return Flowable.error(r5);
    }
}
