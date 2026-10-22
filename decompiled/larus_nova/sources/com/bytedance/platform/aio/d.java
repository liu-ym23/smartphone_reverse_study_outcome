package com.bytedance.platform.aio;

import com.bytedance.platform.aio.channel.RpcException;
import com.bytedance.platform.aio.channel.RpcExceptionMonitorLevel;
import com.bytedance.revenue.platform.api.core.rx.l;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {
    public static final <R> j57.a<R> a(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        l r101 = l.f267516a;
        return new j57.a(Observable.error(r100), null, r100);
    }

    public static final RpcException c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        return new RpcException("container_scope_already_stopped", r100 + " container scope already stopped", g(new Exception()), RpcExceptionMonitorLevel.INFO, null, 16, null);
    }

    public static final RpcException d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        return new RpcException("do_not_have_container_scope", r100 + " do not have container scope", g(new Exception()), RpcExceptionMonitorLevel.INFO, null, 16, null);
    }

    public static final RpcException f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        return new RpcException("interface_not_defined", "interface " + r100 + " not defined", g(new Exception()), RpcExceptionMonitorLevel.ERROR, null, 16, null);
    }

    public static final Map<String, String> g(Throwable r100) {
        Pair[] r101 = new Pair[1];
        if (r100 == null) goto L10;
        String r102 = ExceptionsKt.stackTraceToString(r100);
        if (r102 == null) goto L10;
        r101[0] = TuplesKt.to("stackTrace", r102);
        return com.bytedance.revenue.platform.api.core.d.a(r101);
    L10:
        return MapsKt.emptyMap();
    }

    public static final RpcException b(String r100, Throwable r110) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return new RpcException("biz_error", r100, g(r110), RpcExceptionMonitorLevel.ERROR, null, 16, null);
    }

    public static final RpcException e(String r100, Throwable r110) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return new RpcException("internal_error", r100, g(r110), RpcExceptionMonitorLevel.ERROR, null, 16, null);
    }
}
