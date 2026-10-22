package io.ktor.client.plugins.cache.storage;

import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.HttpCacheStorageKt", f = "HttpCacheStorage.kt", i = {0, 0}, l = {57}, m = ComplianceConstants.ComplianceRequest.MARKET_STORE, n = {"$this$store", "url"}, s = {"L$0", "L$1"})
public final class HttpCacheStorageKt$store$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public HttpCacheStorageKt$store$1(Continuation<? super HttpCacheStorageKt$store$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return HttpCacheStorageKt.c(null, null, null, false, this);
    }
}
