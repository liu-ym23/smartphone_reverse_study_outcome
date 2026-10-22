package io.ktor.client.network.sockets;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.client.engine.d;
import io.ktor.client.plugins.s;
import io.ktor.client.plugins.t;
import io.ktor.client.request.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "cause", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TimeoutExceptionsKt$ByteChannelWithMappedExceptions$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ c $request;

    public TimeoutExceptionsKt$ByteChannelWithMappedExceptions$1(c r100) {
        this.$request = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Throwable invoke2(Throwable r100) {
        Object r101 = null;
        if (r100 == null) goto L10;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Throwable r102 = r100;
    L5:
        if (r102 == null) goto L7;
        Throwable r103 = r102.getCause();
    L8:
        if (r103 == null) goto L12;
        r102 = r102.getCause();
    L12:
        if ((r102 instanceof java.net.SocketTimeoutException) == false) goto L24;
        c r104 = this.$request;
        xwc.c r105 = t.f491748a;
        Intrinsics.checkNotNullParameter(r104, "request");
        StringBuilder r106 = new StringBuilder("Socket timeout has expired [url=");
        r106.append(r104.f491770a);
        r106.append(", socket_timeout=");
        s.b r107 = s.f491744a;
        Intrinsics.checkNotNullParameter(r107, "key");
        Map r108 = (Map) r104.f491775f.b(d.f491644a);
        if (r108 == null) goto L16;
        r101 = r108.get(r107);
    L16:
        s.a r109 = (s.a) r101;
        if (r109 == null) goto L20;
        Object r110 = r109.f491747c;
        if (r110 == null) goto L20;
    L21:
        r106.append(r110);
        r106.append("] ms");
        return new SocketTimeoutException(r106.toString(), r100);
    L20:
        r110 = "unknown";
        goto L21
    L24:
        return r100;
    L7:
        r103 = null;
        goto L8
    L10:
        r102 = null;
        goto L12
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Throwable invoke(Throwable r100) {
        return invoke2(r100);
    }
}
