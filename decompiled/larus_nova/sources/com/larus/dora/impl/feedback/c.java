package com.larus.dora.impl.feedback;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Job f335608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0 f335609b;

    public c(Job r100, p0 r101) {
        this.f335608a = r100;
        this.f335609b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        Job.DefaultImpls.cancel$default(this.f335608a, null, 1, null);     // Catch: Exception -> L5
        this.f335609b.cancel("", true);     // Catch: Exception -> L5
        pk4.j.d("UploadCancellation", "Upload cancelled successfully");     // Catch: Exception -> L5
    L8:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        pk4.j.c("UploadCancellation", "Error during cancellation", e);
        goto L8
    }
}
