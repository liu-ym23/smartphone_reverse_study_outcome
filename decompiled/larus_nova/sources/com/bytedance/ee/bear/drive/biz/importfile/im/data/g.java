package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import android.os.SystemClock;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportException;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f223052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f223053b;

    public g(long r100, long r101) {
        this.f223052a = r100;
        this.f223053b = r101;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        ImportResult.Detail r101 = (ImportResult.Detail) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        if (r101.getJob_status() != 0) goto L6;
        return true;
    L6:
        if (r101.getJob_status() < 0) goto L16;
        if (r101.getJob_status() > 2) goto L16;
        if (((SystemClock.uptimeMillis() - this.f223052a) / ((long) 1000)) >= this.f223053b) goto L14;
        return false;
    L14:
        throw new TimeoutException("loop import result timeout");
    L16:
        throw new ImportException(r101.getJob_status());
    }
}
