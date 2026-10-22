package com.larus.home.impl.main.side_bar.data.api;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.home.impl.main.side_bar.data.f1;
import com.larus.home.impl.main.side_bar.data.g1;
import com.larus.home.impl.main.side_bar.data.k0;
import com.larus.home.impl.main.side_bar.p;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class SideBarApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<SideBarApi> f344480a = null;

    public static final class a {
    }

    public SideBarApi() {
    }

    static {
        f344480a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.home.impl.main.side_bar.data.api.a());
    }

    public final Object b(f1 r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof SideBarApi$updateSideBarOrder$1) == false) goto L7;
        SideBarApi$updateSideBarOrder$1 r100 = (SideBarApi$updateSideBarOrder$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SideBarApi$updateSideBarOrder$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L18:
        return Boxing.boxBoolean(((com.larus.network.http.a) r113) instanceof y);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        FlowDowngradeServiceDelegate r104 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r105 = r110.a();
        r112.label = 1;
        r113 = IFlowDowngradeService.a.b(r104, ServiceType.BASIC_SERVICE, g1.class, "/app_framework/sidebar/update_order", r105, null, true, null, null, r112, 1968);
        if (r113 != r102) goto L18;
        return r102;
    L7:
        r100 = new SideBarApi$updateSideBarOrder$1(this, r111);
        goto L8
    }

    public final Object a(long r110, Integer r111, Continuation<? super k0> r210) {
        if ((r210 instanceof SideBarApi$getSideBarList$1) == false) goto L7;
        SideBarApi$getSideBarList$1 r100 = (SideBarApi$getSideBarList$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SideBarApi$getSideBarList$1 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L25:
        return ((com.larus.network.http.a) r102).f360135b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FlowDowngradeServiceDelegate r105 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r106 = new JSONObject();
        r106.put("last_update_time", r110);
        r106.put("sidebar_view_version", p.c());
        if (r111 == null) goto L17;
        r106.put("request_scene", r111.intValue());
    L17:
        Unit r113 = Unit.INSTANCE;
        Pair[] r114 = new Pair[2];
        r114[0] = TuplesKt.to("source", DowngradeSource.COLD_LAUNCH.getValue());
        if (r110 <= 0) goto L20;
        String r107 = "1";
    L21:
        r114[1] = TuplesKt.to("has_cache", r107);
        Map r115 = MapsKt.mapOf(r114);
        r112.label = 1;
        r102 = IFlowDowngradeService.a.b(r105, ServiceType.BASIC_SERVICE, k0.class, "/app_framework/sidebar", r106, null, true, null, r115, r112, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r102 != r103) goto L25;
        return r103;
    L20:
        r107 = "0";
    L7:
        r100 = new SideBarApi$getSideBarList$1(this, r210);
        goto L8
    }
}
