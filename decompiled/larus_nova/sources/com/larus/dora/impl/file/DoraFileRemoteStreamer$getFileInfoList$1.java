package com.larus.dora.impl.file;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileRemoteStreamer", f = "DoraFileRemoteStreamer.kt", i = {0, 0, 0, 0}, l = {30}, m = "getFileInfoList", n = {"transportType", "fetchFrom", "type", DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "I$0", "J$0"})
public final class DoraFileRemoteStreamer$getFileInfoList$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileRemoteStreamer this$0;

    public DoraFileRemoteStreamer$getFileInfoList$1(DoraFileRemoteStreamer r100, Continuation<? super DoraFileRemoteStreamer$getFileInfoList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(0, null, null, this);
    }
}
