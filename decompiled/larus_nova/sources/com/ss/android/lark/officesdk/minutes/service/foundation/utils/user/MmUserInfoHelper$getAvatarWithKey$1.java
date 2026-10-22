package com.ss.android.lark.officesdk.minutes.service.foundation.utils.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper", f = "MmUserInfoHelper.kt", i = {0, 0}, l = {111, 118}, m = "getAvatarWithKey", n = {"config", "pathKey"}, s = {"L$0", "L$1"})
public final class MmUserInfoHelper$getAvatarWithKey$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmUserInfoHelper this$0;

    public MmUserInfoHelper$getAvatarWithKey$1(MmUserInfoHelper r100, Continuation<? super MmUserInfoHelper$getAvatarWithKey$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
