package com.bytedance.ee.bear.document.restore.api;

import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y {
    /* JADX WARN: Multi-variable type inference failed */
    public static Flowable<RestoreFileResult> a(final RestoreFileResult r8, final long r9, final int r11) {
        DATA r0 = r8.data;
        if (r0 == 0) goto L5;
        String r1 = ((RestoreFileResult.Data) r0).taskId;
    L6:
        final String r6 = r1;
        if ((System.currentTimeMillis() - r9) > 30000) goto L9;
        int r2 = (r11 * 500) + UploadResult.UPLOAD_CACELL;
        tt5.a.h("WikiRestorePuller", "pollRestoreTask, taskId: " + r6 + ", times: " + r11 + ", delay: " + r2);
        return Flowable.just(Boolean.TRUE).delay(r2, TimeUnit.MILLISECONDS).flatMap(new w(r6)).flatMap(new x(r8, r9, r11, r6));
    L9:
        return Flowable.error(new TimeoutException("pollRestoreTask timeout. taskId: " + r6));
    L5:
        r1 = "null";
        goto L6
    }
}
