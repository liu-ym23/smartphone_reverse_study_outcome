package com.larus.office.base.watermark.rc;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.rc.ResourceCenterUploadHelper", f = "ResourceCenterUploadHelper.kt", i = {0}, l = {170}, m = "deleteSafely", n = {"resourceIds"}, s = {"L$0"})
public final class ResourceCenterUploadHelper$deleteSafely$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceCenterUploadHelper this$0;

    public ResourceCenterUploadHelper$deleteSafely$1(ResourceCenterUploadHelper r100, Continuation<? super ResourceCenterUploadHelper$deleteSafely$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
