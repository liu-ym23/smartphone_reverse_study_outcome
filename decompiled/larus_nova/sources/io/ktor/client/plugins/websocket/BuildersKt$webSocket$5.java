package io.ktor.client.plugins.websocket;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/request/HttpRequestBuilder;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class BuildersKt$webSocket$5 extends Lambda implements Function1<HttpRequestBuilder, Unit> {
    final /* synthetic */ String $host;
    final /* synthetic */ v $method;
    final /* synthetic */ String $path;
    final /* synthetic */ Integer $port;
    final /* synthetic */ Function1<HttpRequestBuilder, Unit> $request;

    /* JADX WARN: Multi-variable type inference failed */
    public BuildersKt$webSocket$5(v r100, String r101, Integer r102, String r103, Function1<? super HttpRequestBuilder, Unit> r104) {
        this.$method = r100;
        this.$host = r101;
        this.$port = r102;
        this.$path = r103;
        this.$request = r104;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HttpRequestBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$webSocket");
        v r101 = this.$method;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f491759b = r101;
        io.ktor.client.request.d.a(r100, this.$host, this.$port, this.$path);
        this.$request.invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
