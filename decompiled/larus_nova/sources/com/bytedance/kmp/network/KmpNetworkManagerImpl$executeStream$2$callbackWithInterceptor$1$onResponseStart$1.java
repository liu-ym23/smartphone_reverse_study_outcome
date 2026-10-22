package com.bytedance.kmp.network;

import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1", f = "KmpNetworkManagerImpl.kt", i = {}, l = {226, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL}, m = "onResponseStart", n = {}, s = {})
public final class KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1$onResponseStart$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 this$0;

    public KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1$onResponseStart$1(KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 r100, Continuation<? super KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1$onResponseStart$1> r101) {
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
