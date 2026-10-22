package com.bytedance.timonbase.network;

import android.os.Build;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.cache.TMCacheService;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class TMNetworkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f270814b = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J6\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H'¨\u0006\n"}, d2 = {"Lcom/bytedance/timonbase/network/TMNetworkService$RequestService;", "", "", "token", "", "params", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/timonbase/network/a;", "Lcom/bytedance/timonbase/network/b;", "getSettings", "timonbase_release"}, k = 1, mv = {1, 4, 0})
    public interface RequestService {
        @GET("/api/timon_config_proxy/config/get")
        Call<a<b>> getSettings(@Header(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG) String r100, @QueryMap Map<String, String> r101);
    }

    public static a a() {
        Map<String, String> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("app_id", String.valueOf(TMEnv.f270770d)), TuplesKt.to("channel", TMEnv.f270771e), TuplesKt.to("client_version", String.valueOf(TMEnv.f270774h)), TuplesKt.to("platform", "android"), TuplesKt.to("device_type", Build.MODEL), TuplesKt.to("device_brand", Build.BRAND), TuplesKt.to("os_version", Build.VERSION.RELEASE)});
        String r101 = TMEnv.f270775i.invoke();
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L10:
        String r103 = TMEnv.f270776j;
        if (r103.length() <= 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        r100.put("uid", r103);
    L16:
        RequestService r105 = (RequestService) f270814b.getValue();
        String r106 = "t=0;n=" + (TMCacheService.b().getBoolean("is_new_user", true) ? 1 : 0);
        TMCacheService.b().putBoolean("is_new_user", false);
        return r105.getSettings(r106, r100).execute().body();
    L13:
        r104 = false;
        goto L14
    L8:
        if (new Regex("\\d+").matches(r101) == false) goto L10;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_DID, r101);
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    static {
        f270813a = LazyKt.lazy(TMNetworkService$retrofit$2.INSTANCE);
        f270814b = LazyKt.lazy(TMNetworkService$networkService$2.INSTANCE);
    }
}
