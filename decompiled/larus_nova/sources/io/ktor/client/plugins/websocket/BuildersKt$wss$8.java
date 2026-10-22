package io.ktor.client.plugins.websocket;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.g0;
import io.ktor.http.j0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/request/HttpRequestBuilder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class BuildersKt$wss$8 extends Lambda implements Function1<HttpRequestBuilder, Unit> {
    final /* synthetic */ Integer $port;
    final /* synthetic */ Function1<HttpRequestBuilder, Unit> $request;

    /* JADX WARN: Multi-variable type inference failed */
    public BuildersKt$wss$8(Integer r100, Function1<? super HttpRequestBuilder, Unit> r101) {
        this.$port = r100;
        this.$request = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HttpRequestBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$webSocket");
        g0 r101 = r100.f491758a;
        j0 r102 = j0.f491877c;
        r101.f(j0.f491879e);
        Integer r103 = this.$port;
        if (r103 == null) goto L5;
        g0 r104 = r100.f491758a;
        r104.f491864c = r103.intValue();
    L5:
        this.$request.invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
