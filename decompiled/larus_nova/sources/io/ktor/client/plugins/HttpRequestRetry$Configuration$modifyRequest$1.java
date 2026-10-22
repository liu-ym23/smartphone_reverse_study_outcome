package io.ktor.client.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/client/plugins/q$c;", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/plugins/q$c;Lio/ktor/client/request/HttpRequestBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpRequestRetry$Configuration$modifyRequest$1 extends Lambda implements Function2<q.c, HttpRequestBuilder, Unit> {
    public static final HttpRequestRetry$Configuration$modifyRequest$1 INSTANCE = null;

    static {
        INSTANCE = new HttpRequestRetry$Configuration$modifyRequest$1();
    }

    public HttpRequestRetry$Configuration$modifyRequest$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(q.c r100, HttpRequestBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
        Intrinsics.checkNotNullParameter(r101, "it");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(q.c r100, HttpRequestBuilder r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
