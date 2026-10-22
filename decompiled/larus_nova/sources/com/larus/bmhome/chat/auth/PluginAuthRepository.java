package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.auth.model.PluginAuthResponse;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.auth.model.PluginItemData;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class PluginAuthRepository {
    public PluginAuthRepository() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String r110, String r111, Continuation<? super PluginItem> r112) {
        if ((r112 instanceof PluginAuthRepository$requestPluginDetail$1) == false) goto L7;
        PluginAuthRepository$requestPluginDetail$1 r100 = (PluginAuthRepository$requestPluginDetail$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PluginAuthRepository$requestPluginDetail$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L17:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof com.larus.network.http.y) == true) goto L22;
        return null;
    L22:
        return (PluginItem) ((com.larus.network.http.y) r105).f360135b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r106 = new JSONObject();
        r106.put("bot_id", r110);
        r106.put("plugin_id", r111);
        Unit r107 = Unit.INSTANCE;
        r113.label = 1;
        r102 = HttpExtKt.k(ServiceType.BASIC_SERVICE, PluginItem.class, "/alice/bot/plugin_detail", r106, null, null, true, null, null, null, r113, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r102 != r103) goto L17;
        return r103;
    L7:
        r100 = new PluginAuthRepository$requestPluginDetail$1(this, r112);
        goto L8
    }

    public final Object a(String r110, String r111, boolean r112, Continuation<? super Boolean> r113) {
        if ((r113 instanceof PluginAuthRepository$requestPluginAuth$1) == false) goto L7;
        PluginAuthRepository$requestPluginAuth$1 r100 = (PluginAuthRepository$requestPluginAuth$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PluginAuthRepository$requestPluginAuth$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L22:
        return Boxing.boxBoolean(((com.larus.network.http.a) r102) instanceof com.larus.network.http.y);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r105 = new JSONObject();
        r105.put("bot_id", r110);
        JSONArray r106 = new JSONArray();
        r106.put(r111);
        Unit r107 = Unit.INSTANCE;
        r105.put("plugin_ids", r106);
        if (r112 == false) goto L17;
        int r108 = 1;
    L18:
        r105.put("op_type", r108);
        r114.label = 1;
        r102 = HttpExtKt.k(ServiceType.BASIC_SERVICE, PluginAuthResponse.class, "/alice/bot/plugin_auth", r105, null, null, true, null, null, null, r114, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r102 != r103) goto L22;
        return r103;
    L17:
        r108 = 2;
    L7:
        r100 = new PluginAuthRepository$requestPluginAuth$1(this, r113);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r110, int r111, int r112, DowngradeSource r113, Continuation<? super PluginItemData> r210) {
        if ((r210 instanceof PluginAuthRepository$requestPluginList$1) == false) goto L7;
        PluginAuthRepository$requestPluginList$1 r100 = (PluginAuthRepository$requestPluginList$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PluginAuthRepository$requestPluginList$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L21:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof com.larus.network.http.y) == true) goto L24;
        return null;
    L24:
        return (PluginItemData) ((com.larus.network.http.y) r105).f360135b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FlowDowngradeServiceDelegate r106 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r107 = new JSONObject();
        r107.put("bot_id", r110);
        r107.put("page_no", r111);
        r107.put("page_size", r112);
        Unit r108 = Unit.INSTANCE;
        if (r113 == null) goto L17;
        Map r115 = MapsKt.mapOf(TuplesKt.to("source", r113.getValue()));
    L18:
        r114.label = 1;
        r102 = IFlowDowngradeService.a.b(r106, ServiceType.BASIC_SERVICE, PluginItemData.class, "/alice/bot/plugin_list", r107, null, true, null, r115, r114, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r102 != r103) goto L21;
        return r103;
    L17:
        r115 = null;
    L7:
        r100 = new PluginAuthRepository$requestPluginList$1(this, r210);
        goto L8
    }
}
