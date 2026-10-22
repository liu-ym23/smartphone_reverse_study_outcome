package n3c;

import android.text.TextUtils;
import com.bytedance.lark.policy.model.ErrorCode;
import com.bytedance.lark.policy.utils.EventTrace;
import com.google.gson.JsonObject;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements ne6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f517028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Boolean> f517029b = null;

    public l() {
    }

    static {
        f517028a = new l();
        f517029b = new LinkedHashMap();
    }

    @Override // ne6.c
    public final void b() {
        ((LinkedHashMap) f517029b).clear();
        ScsLogger.d("Network", "clearFirstRequestFlagMap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ne6.c
    public final JSONObject a(String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, "data");
        HttpMethod r100 = HttpMethod.GET;
        HttpParams r101 = new HttpParams();
        HttpHeaders r102 = new HttpHeaders();
        LinkedHashMap r103 = new LinkedHashMap();
        HttpMethod r104 = HttpMethod.POST;
        Intrinsics.checkNotNullParameter(r104, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r110, "path");
        Iterator<String> r105 = r111.keys();
    L4:
        if (r105.hasNext() == false) goto L6;
        String r106 = r105.next();
        Intrinsics.checkNotNull(r106);
        Object r107 = r111.get(r106);
        Intrinsics.checkNotNullParameter(r106, "key");
        Intrinsics.checkNotNullParameter(r107, "value");
        r103.put(r106, r107);
        goto L4
    L6:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r108 = new com.ss.android.lark.security.compliance.infra.network.a(r110, r104, r101, r102, new JSONObject(r103), true);
        r108.c("");
        Map<String, Boolean> r109 = f517029b;
        boolean r112 = true;
        if (((Boolean) ((LinkedHashMap) r109).get(r110)) != null) goto L9;
        boolean r113 = true;
    L10:
        r109.put(r110, Boolean.valueOf(r113));
        int r114 = ScsLogger.f440428a;
        ScsLogger.d("Network", "url: " + r110 + ",isFirstRequest:" + ((LinkedHashMap) r109).get(r110));
        ScsLogger.d("Network", "doRealRequest.");
        int r115 = com.ss.android.lark.scs.policy.engine.manage.d.f439852c;
        User r116 = com.ss.android.lark.scs.policy.engine.manage.d.a.a().a().getForegroundUser();
        if (r116 != null) goto L13;
    L14:
        ScsLogger.c("Network", "user is null or user do not hasValidSession");
        String r117 = u4c.a.f548750a;
        Pair[] r118 = new Pair[3];
        r118[0] = TuplesKt.to("user", String.valueOf(r116));
        if (r116 == null) goto L17;
        String r119 = r116.getSession();
    L18:
        r118[1] = TuplesKt.to("session_is_empty", Boolean.valueOf(TextUtils.isEmpty(r119)));
        if (r116 == null) goto L21;
        Boolean r120 = Boolean.valueOf(r116.isAnonymous());
    L22:
        r118[2] = TuplesKt.to("isAnonymous", r120);
        u4c.a.a("scs_policy_engine_user_session_invalid", MapsKt.mapOf(r118), null, null, 0, 28);
        if (com.bytedance.lark.policy.utils.c.c().n() == true) goto L46;
        return null;
    L46:
        int r121 = com.ss.android.lark.security.compliance.infra.network.service.a.f440453a;     // Catch: Exception -> L30 JSONException -> L43
        com.ss.android.lark.security.compliance.infra.network.h r122 = (com.ss.android.lark.security.compliance.infra.network.h) Observable.create(new d(r108)).singleOrError().retryWhen(f.f517020a).blockingGet();     // Catch: Exception -> L30 JSONException -> L43
        ScsLogger.d("Network", "doRealRequest, return resp.");     // Catch: Exception -> L30 JSONException -> L43
        JsonObject r123 = (JsonObject) r122.f440448d;     // Catch: Exception -> L30 JSONException -> L43
        if (r123 == null) goto L49;
    L50:
        return new JSONObject(r123.toString());
    L49:
        return null;
    L43:
        e = move-exception;
        int r124 = ScsLogger.f440428a;
        ScsLogger.c("Network", "parse json error: path: " + r108.f440432a + ",requestBody:" + r108.f440436e + ',' + e.getMessage());
        int r125 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.NETWORK_REQUEST_ERROR, "json parse error: path: " + r108.f440432a + "},msg:" + e.getMessage(), null, 12);
        return null;
    L30:
        e = move-exception;
        if ((e.getCause() instanceof NetworkErrorResultException) == false) goto L42;
        Throwable r126 = e.getCause();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException");
        NetworkErrorResultException r127 = (NetworkErrorResultException) r126;
        Boolean r128 = (Boolean) ((LinkedHashMap) f517029b).get(r108.f440432a);
        if (r128 == null) goto L37;
        r112 = r128.booleanValue();
    L37:
        if (r127.getNetworkErrorResult().getErrorCode() != (-2)) goto L39;
    L40:
        int r129 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.NETWORK_REQUEST_ERROR, "network request error,path:" + r108.f440432a + ",isFirstRequest:" + r112 + ",errMsg:" + r127.getNetworkErrorResult().getErrorMessage(), null, 12);
    L41:
        int r130 = ScsLogger.f440428a;
        ScsLogger.c("Network", "network error: path: " + r108.f440432a + ",requestBody:" + r108.f440436e + ",isFirstRequest:" + r112 + ",errorInfo:" + r127.getNetworkErrorResult());
        return null;
    L39:
        if (r127.getNetworkErrorResult().getErrorCode() != (-6)) goto L41;
    L42:
        int r131 = ScsLogger.f440428a;
        ScsLogger.c("Network", "unknown network error: path: " + r108.f440432a + ",requestBody:" + r108.f440436e + ",doRealRequest,msg:" + e.getMessage());
        int r132 = EventTrace.f253882a;
        EventTrace.e(ErrorCode.NETWORK_REQUEST_ERROR, "unknown network error: path: " + r108.f440432a + "},msg:" + e.getMessage(), null, 12);
        return null;
    L21:
        r120 = null;
        goto L22
    L17:
        r119 = null;
        goto L18
    L13:
        if (r116.hasValidSession() == true) goto L46;
    L9:
        r113 = false;
        goto L10
    }

    @Override // ne6.c
    public final void c(String r110, JSONObject r111, Function1<? super JSONObject, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "callback");
        HttpMethod r100 = HttpMethod.GET;
        HttpParams r101 = new HttpParams();
        HttpHeaders r102 = new HttpHeaders();
        LinkedHashMap r103 = new LinkedHashMap();
        HttpMethod r104 = HttpMethod.POST;
        Intrinsics.checkNotNullParameter(r104, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r110, "path");
        Iterator<String> r105 = r111.keys();
    L4:
        if (r105.hasNext() == false) goto L6;
        String r106 = r105.next();
        Intrinsics.checkNotNull(r106);
        Object r107 = r111.get(r106);
        Intrinsics.checkNotNullParameter(r106, "key");
        Intrinsics.checkNotNullParameter(r107, "value");
        r103.put(r106, r107);
        goto L4
    L6:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r113 = new com.ss.android.lark.security.compliance.infra.network.a(r110, r104, r101, r102, new JSONObject(r103), true);
        r113.c("");
        Map<String, Boolean> r108 = f517029b;
        if (((Boolean) ((LinkedHashMap) r108).get(r110)) != null) goto L9;
        boolean r109 = true;
    L10:
        r108.put(r110, Boolean.valueOf(r109));
        int r114 = ScsLogger.f440428a;
        ScsLogger.d("Network", "postDataAsync: url: " + r110 + ",isFirstRequest:" + ((LinkedHashMap) r108).get(r110));
        int r115 = com.ss.android.lark.scs.policy.engine.manage.d.f439852c;
        User r116 = com.ss.android.lark.scs.policy.engine.manage.d.a.a().a().getForegroundUser();
        if (r116 != null) goto L13;
    L14:
        ScsLogger.c("Network", "user is null or user do not hasValidSession");
        String r117 = u4c.a.f548750a;
        Pair[] r118 = new Pair[3];
        r118[0] = TuplesKt.to("user", String.valueOf(r116));
        if (r116 == null) goto L17;
        String r119 = r116.getSession();
    L18:
        r118[1] = TuplesKt.to("session_is_empty", Boolean.valueOf(TextUtils.isEmpty(r119)));
        if (r116 == null) goto L21;
        Boolean r120 = Boolean.valueOf(r116.isAnonymous());
    L22:
        r118[2] = TuplesKt.to("isAnonymous", r120);
        u4c.a.a("scs_policy_engine_user_session_invalid", MapsKt.mapOf(r118), null, null, 0, 28);
        if (com.bytedance.lark.policy.utils.c.c().n() == true) goto L25;
        r112.invoke(null);
        return;
    L25:
        ScsLogger.d("Network", "doRealRequestNonblocking.");
        int r121 = com.ss.android.lark.security.compliance.infra.network.service.a.f440453a;
        Observable.create(new g(r113)).singleOrError().subscribeOn(Schedulers.io()).retryWhen(i.f517024a).subscribe(new j(r112), new k(r113, r112));
        return;
    L21:
        r120 = null;
        goto L22
    L17:
        r119 = null;
        goto L18
    L13:
        if (r116.hasValidSession() == true) goto L25;
    L9:
        r109 = false;
        goto L10
    }
}
