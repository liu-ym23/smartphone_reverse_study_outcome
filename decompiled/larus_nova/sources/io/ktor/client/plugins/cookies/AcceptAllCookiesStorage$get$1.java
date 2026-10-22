package io.ktor.client.plugins.cookies;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0, 0}, l = {66}, m = MonitorConstants.CONNECT_TYPE_GET, n = {"this", "requestUrl", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
public final class AcceptAllCookiesStorage$get$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AcceptAllCookiesStorage this$0;

    public AcceptAllCookiesStorage$get$1(AcceptAllCookiesStorage r100, Continuation<? super AcceptAllCookiesStorage$get$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fm(null, this);
    }
}
