package com.bytedance.navigation.kmp.handler.projection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.navigation.kmp.handler.projection.ProjectionUploadManager", f = "ProjectionUploadManager.kt", i = {0, 0}, l = {185}, m = "uploadSnapshot", n = {"navId", "group"}, s = {"L$1", "L$2"})
final class ProjectionUploadManager$uploadSnapshot$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProjectionUploadManager this$0;

    public ProjectionUploadManager$uploadSnapshot$1(ProjectionUploadManager r100, Continuation<? super ProjectionUploadManager$uploadSnapshot$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ProjectionUploadManager.d(this.this$0, null, this);
    }
}
