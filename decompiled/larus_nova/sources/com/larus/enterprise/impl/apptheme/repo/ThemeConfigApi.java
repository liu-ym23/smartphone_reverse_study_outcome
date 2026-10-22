package com.larus.enterprise.impl.apptheme.repo;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.http.ServiceType;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class ThemeConfigApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<ThemeConfigApi> f342471a = null;

    public static final class a {
    }

    public ThemeConfigApi() {
    }

    static {
        f342471a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.enterprise.impl.apptheme.repo.a());
    }

    public final Object a(String r110, Continuation<? super com.larus.network.http.a<z89.c>> r111) {
        if ((r111 instanceof ThemeConfigApi$requestThemeConfig$1) == false) goto L7;
        ThemeConfigApi$requestThemeConfig$1 r100 = (ThemeConfigApi$requestThemeConfig$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ThemeConfigApi$requestThemeConfig$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L18:
        return (com.larus.network.http.a) r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        FlowDowngradeServiceDelegate r104 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r105 = new JSONObject();
        r105.put("scene", r110);
        Unit r114 = Unit.INSTANCE;
        Map r106 = MapsKt.mapOf(TuplesKt.to("source", DowngradeSource.COLD_LAUNCH.getValue()));
        r112.label = 1;
        r113 = IFlowDowngradeService.a.b(r104, ServiceType.BASIC_SERVICE, z89.c.class, "/alice/theme/config", r105, null, true, null, r106, r112, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r113 != r102) goto L18;
        return r102;
    L7:
        r100 = new ThemeConfigApi$requestThemeConfig$1(this, r111);
        goto L8
    }
}
