package com.larus.video.impl.sdk;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.sdk.TTVideoEngineStaticServiceImpl", f = "TTVideoEngineStaticServiceImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {221, 310}, m = "downloadUrlUseDataLoader", n = {"url", "cacheKey", DBDefinition.DOWNLOAD_TABLE_NAME, "url", "cacheKey", DBDefinition.DOWNLOAD_TABLE_NAME}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TTVideoEngineStaticServiceImpl this$0;

    public TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1(TTVideoEngineStaticServiceImpl r100, Continuation<? super TTVideoEngineStaticServiceImpl$downloadUrlUseDataLoader$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, null, this);
    }
}
