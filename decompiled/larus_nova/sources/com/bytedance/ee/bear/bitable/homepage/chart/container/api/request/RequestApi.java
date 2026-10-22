package com.bytedance.ee.bear.bitable.homepage.chart.container.api.request;

import android.net.Uri;
import com.alipay.sdk.m.p.e;
import com.bytedance.ee.bear.bitable.homepage.chart.utils.c;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.larksuite.framework.callback.IGetDataCallback;
import com.lynx.react.bridge.Callback;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ls4.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class RequestApi implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f212439a;

    public static final class a {
    }

    static {
    }

    public RequestApi() {
        this.f212439a = new c();
    }

    @Override // ls4.b
    public final void a(ILynxBridgeContext r110, JSONObject r111, final Callback r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "params");
        String r100 = r111.optString("url");
        String r101 = r111.optString("path");
        Intrinsics.checkNotNull(r100);
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        Object r103 = null;
        if (r102 == true) goto L61;
        Intrinsics.checkNotNull(r101);
        if (r101.length() <= 0) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L27;
        this.f212439a.getClass();
        Uri r105 = c.a(r101);
    L28:
        if (r105 != null) goto L32;
        if (r112 == null) goto L64;
        int r113 = ls4.a.f510532f;
        r112.invoke(new Object[]{ls4.a.C6732a.c("request", "url and path are invalid").a()});
        return;
    L64:
        return;
    L32:
        String r106 = r111.optString(e.f25671s);
        if (r106 != null) goto L35;
    L38:
        boolean r107 = true;
    L39:
        if (r107 == false) goto L43;
        if (r112 == null) goto L65;
        int r114 = ls4.a.f510532f;
        r112.invoke(new Object[]{ls4.a.C6732a.c("request", "method is null").a()});
        return;
    L65:
        return;
    L43:
        String r108 = r106.toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r108, MonitorConstants.CONNECT_TYPE_GET) == false) goto L46;
    L50:
        boolean r109 = r111.optBoolean("needSession", false);
        if (Intrinsics.areEqual(r108, UGCMonitor.TYPE_POST) == false) goto L53;
        r103 = r111.opt("params");
    L53:
        c r115 = this.f212439a;
        if (Intrinsics.areEqual(r108, MonitorConstants.CONNECT_TYPE_GET) == false) goto L56;
        SendHttpRequest.Method r116 = SendHttpRequest.Method.GET;
    L57:
        IGetDataCallback<SendHttpResponse> r117 = new RequestApi$handle$3(r112);
        r115.getClass();
        c.b(r105, r116, r103, r109, r117);
        return;
    L56:
        r116 = SendHttpRequest.Method.POST;
        goto L57
    L46:
        if (Intrinsics.areEqual(r108, UGCMonitor.TYPE_POST) == true) goto L50;
        if (r112 == null) goto L66;
        int r118 = ls4.a.f510532f;
        r112.invoke(new Object[]{ls4.a.C6732a.c("request", "only support get or post method").a()});
        return;
    L66:
        return;
    L35:
        if (r106.length() == 0) goto L38;
        r107 = false;
        goto L39
    L27:
        r105 = null;
        goto L28
    L24:
        r104 = false;
        goto L25
    L61:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L13
        r105 = UriProtector.parse(r100);     // Catch: Throwable -> L13
        Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L17:
        if (Result.m9452exceptionOrNullimpl(r120) == null) goto L28;
        if (r112 == null) goto L63;
        int r121 = ls4.a.f510532f;
        r112.invoke(new Object[]{ls4.a.C6732a.c("request", "url is not valid").a()});
        return;
    L63:
        return;
    L11:
        Throwable th10 = th;
    L15:
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L13:
        th = move-exception;
        th10 = th;
        r105 = null;
        goto L15
    L5:
        r102 = false;
        goto L6
    }
}
