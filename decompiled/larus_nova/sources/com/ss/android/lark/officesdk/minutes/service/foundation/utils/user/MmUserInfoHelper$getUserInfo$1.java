package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper", f = "MmUserInfoHelper.kt", i = {0}, l = {70}, m = "getUserInfo-0E7RQCE", n = {MmEndWindowAvatar.TYPE_SPEAKER}, s = {"L$0"})
public final class MmUserInfoHelper$getUserInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmUserInfoHelper this$0;

    public MmUserInfoHelper$getUserInfo$1(MmUserInfoHelper r100, Continuation<? super MmUserInfoHelper$getUserInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.c(null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
