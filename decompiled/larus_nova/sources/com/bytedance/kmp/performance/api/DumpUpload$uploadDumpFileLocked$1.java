package com.bytedance.kmp.performance.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.performance.api.DumpUpload", f = "IKmpMemoryUpload.kt", i = {0, 0, 1}, l = {93, 94}, m = "uploadDumpFileLocked$performance_release", n = {"storage", "uploadMemoryService", "storage"}, s = {"L$0", "L$1", "L$0"})
public final class DumpUpload$uploadDumpFileLocked$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DumpUpload this$0;

    public DumpUpload$uploadDumpFileLocked$1(DumpUpload r100, Continuation<? super DumpUpload$uploadDumpFileLocked$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
