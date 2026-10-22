package io.ktor.client.request;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.http.g0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/http/g0;", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/http/g0;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpRequestKt$invoke$2 extends Lambda implements Function1<g0, Unit> {
    public static final HttpRequestKt$invoke$2 INSTANCE = null;

    static {
        INSTANCE = new HttpRequestKt$invoke$2();
    }

    public HttpRequestKt$invoke$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(g0 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
