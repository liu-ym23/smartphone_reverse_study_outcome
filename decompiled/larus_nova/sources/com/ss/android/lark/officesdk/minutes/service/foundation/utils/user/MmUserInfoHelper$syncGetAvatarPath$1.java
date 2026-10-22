package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper", f = "MmUserInfoHelper.kt", i = {}, l = {216}, m = "syncGetAvatarPath-yxL6bBk", n = {}, s = {})
public final class MmUserInfoHelper$syncGetAvatarPath$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmUserInfoHelper this$0;

    public MmUserInfoHelper$syncGetAvatarPath$1(MmUserInfoHelper r100, Continuation<? super MmUserInfoHelper$syncGetAvatarPath$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.g(null, null, 0, 0.0f, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
