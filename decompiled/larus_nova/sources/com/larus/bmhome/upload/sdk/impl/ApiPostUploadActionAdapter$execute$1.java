package com.larus.bmhome.upload.sdk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.ApiPostUploadActionAdapter", f = "ImageUploadSdkBuilder.kt", i = {}, l = {229}, m = "execute", n = {}, s = {})
public final class ApiPostUploadActionAdapter$execute$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApiPostUploadActionAdapter this$0;

    public ApiPostUploadActionAdapter$execute$1(ApiPostUploadActionAdapter r100, Continuation<? super ApiPostUploadActionAdapter$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
