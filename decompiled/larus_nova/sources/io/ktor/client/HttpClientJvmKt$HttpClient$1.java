package io.ktor.client;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpClientJvmKt$HttpClient$1 extends Lambda implements Function1<HttpClientConfig<?>, Unit> {
    public static final HttpClientJvmKt$HttpClient$1 INSTANCE = null;

    static {
        INSTANCE = new HttpClientJvmKt$HttpClient$1();
    }

    public HttpClientJvmKt$HttpClient$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HttpClientConfig<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
