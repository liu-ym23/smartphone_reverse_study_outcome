package com.bytedance.navigation.kmp.handler.projection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.navigation.kmp.handler.projection.ProjectionUploadManagerKt", f = "ProjectionUploadManager.kt", i = {0}, l = {36, 37}, m = "runUploadWithOneRetry", n = {"upload"}, s = {"L$0"})
public final class ProjectionUploadManagerKt$runUploadWithOneRetry$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ProjectionUploadManagerKt$runUploadWithOneRetry$1(Continuation<? super ProjectionUploadManagerKt$runUploadWithOneRetry$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ProjectionUploadManagerKt.a(null, this);
    }
}
