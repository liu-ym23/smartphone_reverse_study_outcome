package com.larus.dora.impl.file.upload;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.upload.DoraFileUploaderImpl", f = "DoraFileUploaderImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {231}, m = "uploadFile", n = {"task", "trigger", "file", "uploadUrl", "uploadTextSem", "uploadResult", MapMonitorConst.ATTEMPT, DyPayConstant.KEY_START_TIME}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "J$0"})
public final class DoraFileUploaderImpl$uploadFile$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileUploaderImpl this$0;

    public DoraFileUploaderImpl$uploadFile$1(DoraFileUploaderImpl r100, Continuation<? super DoraFileUploaderImpl$uploadFile$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraFileUploaderImpl r101 = this.this$0;
        int r102 = DoraFileUploaderImpl.f335757e;
        return r101.e(null, null, this);
    }
}
