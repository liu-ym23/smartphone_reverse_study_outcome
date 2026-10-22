package gm9;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ixigua.lib.track.TrackParams;
import com.larus.network.HttpConst;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f481757a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f481757a = new AtomicBoolean(false);
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Request r102 = r100.request();
    L6:
        if (r100 == null) goto L8;
        SsResponse<?> r103 = r100.proceed(r102);
    L9:
        if (r102 == null) goto L11;
        r101 = r102.getHost();
    L11:
        HttpConst.f359979a.getClass();
        if (Intrinsics.areEqual(r101, HttpConst.f359995i) == true) goto L14;
    L47:
        boolean r104 = false;
    L48:
        if (r104 == true) goto L50;
    L58:
        return r103;
    L50:
        if (this.f481757a.compareAndSet(false, true) == false) goto L58;
        FLogger.f375446a.i("AccountLoginStateInterceptor", "logout by X-Tt-Agw-Login");
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.put("custom", "apiHeaderLoginExpired");     // Catch: JSONException -> L55
    L57:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("basic_frame_common_monitor");
        r107.f21463a.merge(r106);
        r107.b();
        AccountService.f365697a.z("logout_by_x_tt_agw_login", new d(this));
    L55:
        e = move-exception;
        FLogger.f375446a.e("BasicFrameCommonMonitorHelper", "error in BasicFrameCommonMonitorHelper mobBasicFrameCommonMonitor " + e.getLocalizedMessage());
        goto L57
    L14:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L47;
        if (r103 == null) goto L44;
        List<Header> r108 = r103.headers();
        if (r108 == null) goto L44;
        List<Header> r109 = r108;
        if ((r109 instanceof Collection) == true) goto L21;
    L23:
        Iterator<T> r110 = r109.iterator();
    L25:
        if (r110.hasNext() == false) goto L41;
        Header r111 = (Header) r110.next();
        if (r111 == null) goto L33;
        String r112 = r111.getName();
        if (r112 == null) goto L33;
        if (StringsKt.equals(r112, "X-Tt-Agw-Login", true) != true) goto L33;
        boolean r113 = true;
    L34:
        if (r113 == true) goto L36;
    L38:
        boolean r114 = false;
    L39:
        if (r114 == false) goto L25;
        boolean r115 = true;
    L42:
        if (r115 != true) goto L44;
        boolean r116 = true;
    L45:
        if (r116 == false) goto L47;
        r104 = true;
        goto L48
    L36:
        if (Intrinsics.areEqual(r111.getValue(), "0") == false) goto L38;
        r114 = true;
    L33:
        r113 = false;
    L41:
        r115 = false;
        goto L42
    L21:
        if (r109.isEmpty() == false) goto L23;
    L44:
        r116 = false;
        goto L45
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }
}
