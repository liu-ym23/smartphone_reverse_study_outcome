package com.larus.uaigc.service;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.service.LocalMediaMenuShareHelper", f = "LocalMediaMenuShareHelper.kt", i = {0, 0}, l = {96, 101}, m = "resolveLocalShareUri", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "filePath"}, s = {"L$0", "L$1"})
final class LocalMediaMenuShareHelper$resolveLocalShareUri$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u this$0;

    public LocalMediaMenuShareHelper$resolveLocalShareUri$1(u r100, Continuation<? super LocalMediaMenuShareHelper$resolveLocalShareUri$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return u.a(this.this$0, null, null, false, this);
    }
}
