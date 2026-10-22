package com.bytedance.ies.ezpermission.core.task;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class BasePermissionTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BasePermissionTask f248587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f248588b;

    public abstract Object b(Continuation<? super Unit> r100);

    public BasePermissionTask(a r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        this.f248588b = r100;
    }

    public final Object a(Continuation<? super Unit> r100) {
        if ((r100 instanceof BasePermissionTask$finish$1) == false) goto L7;
        BasePermissionTask$finish$1 r101 = (BasePermissionTask$finish$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        BasePermissionTask r106 = this.f248587a;
        if (r106 == null) goto L20;
        r101.label = 1;
        if (r106.b(r101) != r104) goto L20;
        return r104;
    L7:
        r101 = new BasePermissionTask$finish$1(this, r100);
        goto L8
    }
}
