package io.ktor.client.plugins;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lio/ktor/client/plugins/q$e;", "Lio/ktor/client/request/b;", "<anonymous parameter 0>", "Lio/ktor/client/statement/b;", "response", "", AbsMethodDelegate.TAG_INVOKE, "(Lio/ktor/client/plugins/q$e;Lio/ktor/client/request/b;Lio/ktor/client/statement/b;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class HttpRequestRetry$Configuration$retryOnServerErrors$1 extends Lambda implements Function3<q.e, io.ktor.client.request.b, io.ktor.client.statement.b, Boolean> {
    public static final HttpRequestRetry$Configuration$retryOnServerErrors$1 INSTANCE = null;

    static {
        INSTANCE = new HttpRequestRetry$Configuration$retryOnServerErrors$1();
    }

    public HttpRequestRetry$Configuration$retryOnServerErrors$1() {
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(q.e r100, io.ktor.client.request.b r101, io.ktor.client.statement.b r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$retryIf");
        Intrinsics.checkNotNullParameter(r101, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r102, "response");
        int r103 = r102.d().f491927a;
        boolean r104 = false;
        if (500 > r103) goto L8;
        if (r103 >= 600) goto L8;
        r104 = true;
    L8:
        return Boolean.valueOf(r104);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(q.e r100, io.ktor.client.request.b r101, io.ktor.client.statement.b r102) {
        return invoke2(r100, r101, r102);
    }
}
