package io.ktor.client.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lio/ktor/client/plugins/q$e;", "Lio/ktor/client/request/HttpRequestBuilder;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/plugins/q$e;Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/Throwable;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpRequestRetry$Configuration$noRetry$2 extends Lambda implements Function3<q.e, HttpRequestBuilder, Throwable, Boolean> {
    public static final HttpRequestRetry$Configuration$noRetry$2 INSTANCE = null;

    static {
        INSTANCE = new HttpRequestRetry$Configuration$noRetry$2();
    }

    public HttpRequestRetry$Configuration$noRetry$2() {
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(q.e r100, HttpRequestBuilder r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
        Intrinsics.checkNotNullParameter(r101, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r102, "<anonymous parameter 1>");
        return Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(q.e r100, HttpRequestBuilder r101, Throwable r102) {
        return invoke2(r100, r101, r102);
    }
}
