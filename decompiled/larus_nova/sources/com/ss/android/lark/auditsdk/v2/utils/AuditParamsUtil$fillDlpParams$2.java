package com.ss.android.lark.auditsdk.v2.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.auditsdk.v2.utils.AuditParamsUtil", f = "AuditParamsUtil.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {85, 104}, m = "fillDlpParams", n = {"builder", "chatId", "messageId", "messageSenderId", "messageSenderTenantId", "fileKey", "logInfo", "builder", "chatId", "messageId", "fileKey", "logInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class AuditParamsUtil$fillDlpParams$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuditParamsUtil this$0;

    public AuditParamsUtil$fillDlpParams$2(AuditParamsUtil r100, Continuation<? super AuditParamsUtil$fillDlpParams$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, null, null, this);
    }
}
