package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import android.os.SystemClock;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportException;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T> implements Predicate {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;

    public g(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }

    public final boolean test(Object r5) {
        ImportResult.Detail r6 = (ImportResult.Detail) r5;
        Intrinsics.checkNotNullParameter(r6, "t");
        if (r6.getJob_status() != 0) goto L6;
        return true;
    L6:
        if (r6.getJob_status() < 0) goto L16;
        if (r6.getJob_status() > 2) goto L16;
        if (((SystemClock.uptimeMillis() - this.a) / ((long) UploadResult.UPLOAD_CACELL)) >= this.b) goto L14;
        return false;
    L14:
        throw new TimeoutException("loop import result timeout");
    L16:
        throw new ImportException(r6.getJob_status());
    }
}
