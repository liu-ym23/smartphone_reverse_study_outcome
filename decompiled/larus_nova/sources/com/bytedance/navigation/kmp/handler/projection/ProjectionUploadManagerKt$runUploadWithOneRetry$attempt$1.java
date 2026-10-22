package com.bytedance.navigation.kmp.handler.projection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.navigation.kmp.handler.projection.ProjectionUploadManagerKt", f = "ProjectionUploadManager.kt", i = {}, l = {30}, m = "runUploadWithOneRetry$attempt", n = {}, s = {})
public final class ProjectionUploadManagerKt$runUploadWithOneRetry$attempt$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ProjectionUploadManagerKt$runUploadWithOneRetry$attempt$1(Continuation<? super ProjectionUploadManagerKt$runUploadWithOneRetry$attempt$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ProjectionUploadManagerKt.b(null, this);
    }
}
