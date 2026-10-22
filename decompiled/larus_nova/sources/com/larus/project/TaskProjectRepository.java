package com.larus.project;

import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.im.internal.jni.bean.OmniProject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class TaskProjectRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TaskProjectRepository f366999a = null;

    static {
        f366999a = new TaskProjectRepository();
    }

    public TaskProjectRepository() {
    }

    public final Object a(String r100, Continuation<? super Result<i>> r101) {
        if ((r101 instanceof TaskProjectRepository$getProject$1) == false) goto L7;
        TaskProjectRepository$getProject$1 r102 = (TaskProjectRepository$getProject$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L22:
        if (Result.m9456isSuccessimpl(r107) == false) goto L30;
        com.larus.bmhome.taskskill.service.h r108 = (com.larus.bmhome.taskskill.service.h) r107;
        if (r108 == null) goto L28;
        OmniProject r109 = r108.f314445a;
        if (r109 == null) goto L28;
        r107 = x.a(r109);
    L28:
        r107 = null;
    L30:
        return Result.m9449constructorimpl(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        IProjectListDataSource r110 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r110 != null) goto L18;
        Result.Companion r111 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("project list data source not found")));
    L18:
        r102.label = 1;
        r107 = r110.f(r100, r102);
        if (r107 != r105) goto L22;
        return r105;
    L7:
        r102 = new TaskProjectRepository$getProject$1(this, r101);
        goto L8
    }
}
