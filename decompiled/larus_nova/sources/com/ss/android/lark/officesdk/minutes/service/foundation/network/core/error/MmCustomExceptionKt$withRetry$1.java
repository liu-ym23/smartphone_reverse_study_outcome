package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt", f = "MmCustomException.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {24, 41}, m = "withRetry", n = {WikiFolderPushPlugin.OPT, "maxRetries", DBDefinition.RETRY_COUNT, WikiFolderPushPlugin.OPT, "lastError", "maxRetries", DBDefinition.RETRY_COUNT}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
public final class MmCustomExceptionKt$withRetry$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public MmCustomExceptionKt$withRetry$1(Continuation<? super MmCustomExceptionKt$withRetry$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = MmCustomExceptionKt.a(0, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
