package com.larus.im.internal.core.job;

import com.larus.im.depend.IAIJobExperimentProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final boolean a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(j38.a.f497135a, "<this>");     // Catch: Throwable -> L8
        IAIJobExperimentProvider r101 = (IAIJobExperimentProvider) ServiceManager.get().getService(IAIJobExperimentProvider.class);     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        boolean r102 = r101.a();     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        com.larus.im.internal.delegate.a.f348188b.e("AIJobExperiment", "read lark event experiment failed: " + r104);
        r103 = Boolean.FALSE;
    L15:
        return ((Boolean) r103).booleanValue();
    L5:
        r102 = false;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
