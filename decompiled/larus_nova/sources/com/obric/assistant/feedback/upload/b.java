package com.obric.assistant.feedback.upload;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.feedback.upload.bean.ReportUploadTask;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements com.obric.assistant.feedback.upload.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingDeque<ReportUploadTask> f389281b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f389281b = new LinkedBlockingDeque();
    }

    public final boolean a(ReportUploadTask r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        this.f389281b.addLast(r100);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.e("InMemoryReportUploadTaskManager", "offerTask failed", r103);
        r102 = Boolean.FALSE;
    L12:
        return ((Boolean) r102).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
