package com.larus.image.loader;

import android.util.Pair;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.utils.y0;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class ImageUrlProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageUrlProvider f350954a = null;

    public static final class a extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    static {
        f350954a = new ImageUrlProvider();
    }

    public ImageUrlProvider() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r210, String r211, m r212, Continuation<? super String> r213) {
        String r100 = r210;
        if ((r213 instanceof ImageUrlProvider$getRenewUrl$1) == false) goto L7;
        ImageUrlProvider$getRenewUrl$1 r101 = (ImageUrlProvider$getRenewUrl$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ImageUrlProvider$getRenewUrl$1 r110 = r101;
        Object r103 = r110.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r110.label;
        boolean r111 = false;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        m r106 = (m) r110.L$2;
        String r107 = (String) r110.L$1;
        String r108 = (String) r110.L$0;
        ResultKt.throwOnFailure(r103);
        String r109 = r107;
        String r112 = r108;
        Object r113 = r103;
        m r114 = r106;
    L50:
        com.larus.network.http.a r115 = (com.larus.network.http.a) r113;
        y r116 = (y) r115.f360135b;
        if (r116 == null) goto L57;
        List<f> r117 = r116.a();
        if (r117 == null) goto L57;
        f r118 = (f) CollectionsKt.firstOrNull(r117);
        if (r118 == null) goto L57;
        String r119 = r118.a();
    L58:
        PThreadPoolExecutor r120 = j.f350978a;
        h r121 = new h();
        r121.f350970a = Boxing.boxInt(0);
        r121.f350975f = r109;
        r121.f350971b = r112;
        r121.f350973d = r112;
        r121.f350972c = Boxing.boxInt(0);
        r121.f350974e = r119;
        boolean r122 = r115 instanceof com.larus.network.http.f;
        long r123 = 0;
        if (r122 == false) goto L61;
        Long r124 = Boxing.boxLong(((com.larus.network.http.f) r115).f360157d.getCode());
    L62:
        r121.f350976g = r124;
        Intrinsics.checkNotNullParameter(r121, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        j.f350978a.execute(new i(r121));
        if (r119 != null) goto L65;
    L68:
        boolean r125 = true;
    L69:
        if (r125 == true) goto L93;
        if (y0.e(r119) == false) goto L93;
        ImageUrlStorage.f350955a.getClass();
        if (r112 != null) goto L75;
    L78:
        boolean r126 = true;
    L79:
        if (r126 == true) goto L87;
        if (r119 != null) goto L82;
    L83:
        r111 = true;
    L84:
        if (r111 == true) goto L87;
        BuildersKt.launch$default((CoroutineScope) ImageUrlStorage.f350958d.getValue(), null, null, new ImageUrlStorage$add$1(r112, r119, null), 3, null);
        goto L87
    L82:
        if (r119.length() != 0) goto L84;
    L87:
        w.a(BenefitStore.FROM_SERVER, r109, r112, false, 0);
        if (r114 == null) goto L91;
        r114.b(BenefitStore.FROM_SERVER);
    L91:
        return y0.c(r119, "flow_renew", "2").toString();
    L75:
        if (r112.length() == 0) goto L78;
        r126 = false;
    L93:
        if (r122 == false) goto L95;
        r123 = ((com.larus.network.http.f) r115).f360157d.getCode();
    L95:
        w.a(PlayerResolution.SDKKEY.ORIGIN, r109, r112, true, r123);
        if (r114 == null) goto L99;
        r114.b(PlayerResolution.SDKKEY.ORIGIN);
    L99:
        return y0.c(r112, "flow_renew", "0").toString();
    L65:
        if (r119.length() == 0) goto L68;
        r125 = false;
        goto L69
    L61:
        r124 = Boxing.boxLong(0);
    L57:
        r119 = null;
        goto L58
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        m r127 = (m) r110.L$2;
        String r128 = (String) r110.L$1;
        String r129 = (String) r110.L$0;
        ResultKt.throwOnFailure(r103);
        m r130 = r127;
        r100 = r129;
        Object r131 = r103;
    L25:
        String r132 = (String) r131;
        if (r132 != null) goto L28;
    L31:
        boolean r133 = true;
    L32:
        if (r133 == true) goto L41;
        boolean r134 = b0.f350967a;
        if (b0.c(y0.j(r132)) == false) goto L36;
        ImageUrlStorage.f350955a.getClass();
        ImageUrlStorage.g(r100);
        goto L41
    L36:
        w.a("cache", r128, r100, false, 0);
        PThreadPoolExecutor r135 = j.f350978a;
        h r136 = new h();
        r136.f350970a = Boxing.boxInt(0);
        r136.f350975f = r128;
        r136.f350971b = r100;
        r136.f350973d = r100;
        r136.f350972c = Boxing.boxInt(1);
        Intrinsics.checkNotNullParameter(r136, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        j.f350978a.execute(new i(r136));
        if (r130 == null) goto L40;
        r130.b("cache");
    L40:
        return y0.c(r132, "flow_renew", "1").toString();
    L41:
        m r137 = r130;
        String r138 = r128;
    L43:
        JSONObject r139 = new JSONObject();
        r139.put("url", r100);
        Pair<String, String> r140 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a());
        LinkedHashMap r141 = new LinkedHashMap();
        if (r140 == null) goto L46;
        r141.put(r140.first, r140.second);
    L46:
        r110.L$0 = r100;
        r110.L$1 = r138;
        r110.L$2 = r137;
        r110.label = 2;
        m r142 = r137;
        String r143 = r100;
        r113 = HttpExtKt.k(ServiceType.BASIC_TEC, y.class, "/alice/upload/refresh_file_url", r139, null, r141, false, null, null, null, r110, TTVideoEngineInterface.PLAYER_OPTION_DUMMYSURFACE_FORBID);
        if (r113 != r104) goto L49;
        return r104;
    L49:
        r109 = r138;
        r114 = r142;
        r112 = r143;
        goto L50
    L28:
        if (r132.length() == 0) goto L31;
        r133 = false;
        goto L32
    L16:
        ResultKt.throwOnFailure(r103);
        if ((o.a() & 8) == 0) goto L19;
        boolean r144 = true;
    L20:
        if (r144 == true) goto L42;
        ImageUrlStorage r145 = ImageUrlStorage.f350955a;
        r110.L$0 = r100;
        r128 = r211;
        r110.L$1 = r128;
        r110.L$2 = r212;
        r110.label = 1;
        r145.getClass();
        Object r146 = ImageUrlStorage.c(r100, r110);
        if (r146 != r104) goto L24;
        return r104;
    L24:
        r131 = r146;
        r130 = r212;
        goto L25
    L42:
        r138 = r211;
        r137 = r212;
        goto L43
    L19:
        r144 = false;
    L7:
        r101 = new ImageUrlProvider$getRenewUrl$1(this, r213);
        goto L8
    }
}
