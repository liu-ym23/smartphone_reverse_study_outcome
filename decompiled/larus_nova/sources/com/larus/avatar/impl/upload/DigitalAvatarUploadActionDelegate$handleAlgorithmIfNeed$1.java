package com.larus.avatar.impl.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avatar.impl.upload.DigitalAvatarUploadActionDelegate", f = "DigitalAvatarUploadActionDelegate.kt", i = {0, 0, 1, 1, 1}, l = {199, 202}, m = "handleAlgorithmIfNeed", n = {"filteredUriList", "actionContext", "filteredUriList", "actionContext", "pendingPreGenPairs"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
final class DigitalAvatarUploadActionDelegate$handleAlgorithmIfNeed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalAvatarUploadActionDelegate this$0;

    public DigitalAvatarUploadActionDelegate$handleAlgorithmIfNeed$1(DigitalAvatarUploadActionDelegate r100, Continuation<? super DigitalAvatarUploadActionDelegate$handleAlgorithmIfNeed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DigitalAvatarUploadActionDelegate.b(this.this$0, null, this);
    }
}
