package hm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.common.apphost.AppHost;
import com.larus.network.interceptor.BackgroundRequestRejectException;
import com.larus.network.interceptor.http.DoraTaskStatus;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricContextServiceDelegate;
import com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f485956a;

    public b0() {
        this.f485956a = LazyKt.lazy(new a0());
    }

    @Override // hm9.x
    public final SsResponse<?> a(Interceptor.Chain r110, s r111) {
        String r100 = "";
        if (r110 == null) goto L8;
        Request r101 = r110.request();
        if (r101 == null) goto L8;
        String r102 = r101.getHost();
        if (r102 == null) goto L8;
    L9:
        if (r110 == null) goto L16;
        Request r103 = r110.request();
        if (r103 == null) goto L16;
        String r104 = r103.getPath();
        if (r104 == null) goto L16;
        r100 = r104;
    L16:
        Boolean r105 = null;
        if (r111 == null) goto L19;
        Integer r106 = Integer.valueOf(r111.a(r102, r100));
    L21:
        if (r106 != null) goto L24;
    L25:
        if (r111 == null) goto L27;
        r111.e(r102, r100, r106);
    L27:
        if (r111 == null) goto L29;
        s.b(r111, "BackgroundNetworkInterceptor#WhitelistHandler", "[WhitelistHandler]No need continue process current path or host is in white list " + r100 + ' ' + r102 + ",\n path allow list  :" + r111.f485986p + "\n host allow list  :" + r111.f485985o + "\n allowedPathDataMap  :" + r111.f485990t + "\n allowedHostDataMap  :" + r111.f485991u + '\n');
    L29:
        if (r110 != null) goto L31;
        return null;
    L31:
        return r110.proceed(r110.request());
    L24:
        if (r106.intValue() != 3) goto L25;
        boolean r112 = false;
        if (r111 == null) goto L48;
        Intrinsics.checkNotNullParameter(r102, "host");
        Intrinsics.checkNotNullParameter(r100, "path");
        if (r111.f485988r.size() > r111.f485982l) goto L42;
        ConcurrentHashMap<String, Integer> r113 = r111.f485988r;
        Integer r114 = r113.get(r102);
        if (r114 == null) goto L39;
        int r115 = r114.intValue();
    L40:
        r113.put(r102, Integer.valueOf(r115 + 1));
        goto L42
    L39:
        r115 = 0;
    L42:
        if (r111.f485989s.size() > r111.f485982l) goto L48;
        ConcurrentHashMap<String, Integer> r116 = r111.f485989s;
        Integer r117 = r116.get(r100);
        if (r117 == null) goto L46;
        int r118 = r117.intValue();
    L47:
        r116.put(r100, Integer.valueOf(r118 + 1));
        goto L48
    L46:
        r118 = 0;
    L48:
        if (r111 == null) goto L50;
        s.b(r111, "BackgroundNetworkInterceptor#WhitelistHandler", "[WhitelistHandler]No need continue just block this request " + r100 + tb2.c.DEFAULT_TEXT + r102 + ",\n path allow list  :" + r111.f485986p + "\n host allow list  :" + r111.f485985o + "\n allowedPathDataMap  :" + r111.f485990t + "\n allowedHostDataMap  :" + r111.f485991u + '\n');
    L50:
        ObricContextServiceDelegate r107 = ObricContextServiceDelegate.f387837b;
        AppHost.Companion r108 = AppHost.f326268a;
        if (r107.a(r108.getApplication()) == false) goto L63;
        FLogger r109 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("isMainProcessBackground: ");
        IObricBackgroundNetworkBlockService r120 = (IObricBackgroundNetworkBlockService) ServiceManager.get().getService(IObricBackgroundNetworkBlockService.class);
        if (r120 == null) goto L55;
        Boolean r121 = r120.a();
    L56:
        r119.append(r121);
        r109.i("BackgroundNetworkInterceptor#WhitelistHandler", r119.toString());
        IObricBackgroundNetworkBlockService r122 = (IObricBackgroundNetworkBlockService) ServiceManager.get().getService(IObricBackgroundNetworkBlockService.class);
        if (r122 == null) goto L59;
        r112 = Intrinsics.areEqual(r122.a(), Boolean.TRUE);
    L59:
        if (r112 == false) goto L67;
        if (r111 == null) goto L67;
        r111.d(true);
    L67:
        if (((Boolean) this.f485956a.getValue()).booleanValue() == true) goto L85;
        FLogger r123 = FLogger.f375446a;
        StringBuilder r124 = new StringBuilder("request blocked,domain: ");
        r124.append(r102);
        r124.append(",path: ");
        r124.append(r100);
        r124.append(",dora user : ");
        if (r111 == null) goto L71;
        Boolean r125 = Boolean.valueOf(r111.f485975e);
    L72:
        r124.append(r125);
        r124.append("  dora state: ");
        if (r111 == null) goto L75;
        DoraTaskStatus r126 = r111.f485992v;
    L76:
        r124.append(r126);
        r124.append(" music state: ");
        if (r111 == null) goto L79;
        Boolean r127 = Boolean.valueOf(r111.f485993w);
    L80:
        r124.append(r127);
        r124.append(" app is background: ");
        if (r111 == null) goto L83;
        int r128 = s.C;
        r105 = Boolean.valueOf(r108.a().isAppBackground());
    L83:
        r124.append(r105);
        r124.append(' ');
        r123.i("BackgroundNetworkInterceptor#WhitelistHandler", r124.toString());
        goto L85
    L79:
        r127 = null;
        goto L80
    L75:
        r126 = null;
        goto L76
    L71:
        r125 = null;
    L85:
        throw new BackgroundRequestRejectException("Current app is in background, please open network control host: " + r102 + ",path: " + r100);
    L55:
        r121 = null;
        goto L56
    L63:
        if (r108.a().isAppBackground() == false) goto L67;
        if (r111 == null) goto L67;
        r111.d(true);
        goto L67
    L19:
        r106 = null;
    L8:
        r102 = "";
        goto L9
    }
}
