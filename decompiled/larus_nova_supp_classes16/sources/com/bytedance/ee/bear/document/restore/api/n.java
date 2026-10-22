package com.bytedance.ee.bear.document.restore.api;

import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public static Flowable<Boolean> a(final String r5, final long r6, final int r8) {
        if ((System.currentTimeMillis() - r6) > 30000) goto L5;
        int r0 = (r8 * 500) + UploadResult.UPLOAD_CACELL;
        tt5.a.h("SpaceRestorePuller", "pollRestoreTask, taskId: " + r5 + ", times: " + r8 + ", delay: " + r0);
        return Flowable.just(Boolean.TRUE).delay(r0, TimeUnit.MILLISECONDS).flatMap(new j(r5)).flatMap(new k(r5, r6, r8));
    L5:
        return Flowable.error(new TimeoutException("pollRestoreTask timeout. taskId: " + r5));
    }
}
