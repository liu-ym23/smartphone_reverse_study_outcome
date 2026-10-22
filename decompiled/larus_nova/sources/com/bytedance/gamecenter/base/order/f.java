package com.bytedance.gamecenter.base.order;

import android.text.TextUtils;
import com.bytedance.gamecenter.base.OrderDownloadInfoTrigger;
import com.bytedance.gamecenter.base.r;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b> f245039a = null;

    static {
        f245039a = new ConcurrentHashMap();
    }

    public static void a(JSONObject r100, b r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L14;
        String r102 = r101.f245028d;     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r100.putOpt(EventConstants.ExtraJson.GAME_NAME, r102);     // Catch: Exception -> L8
        return;
    L15:
        return;
    L8:
        e = move-exception;
        e.toString();
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter(OrderDownloadInfoTrigger.TAG, "tag");
        return;
    L14:
        return;
    }

    public static void b(String r100, JSONObject r101, AdDownloadModel r110) {
        if (r101.optInt("reserve_type", OrderConstant$RESERVE_TYPE.ORDER_DOWNLOAD.getType()) != OrderConstant$RESERVE_TYPE.ORDER_UPDATE.getType()) goto L5;
        String r102 = OrderConstant$TAG.TAG_ORDER_UPDATE.getTag();
    L6:
        String r103 = r102;
        if (r110 != null) goto L10;
        r110 = new AdDownloadModel.Builder().setIsAd(false).build();
    L10:
        AdDownloadModel r104 = r110;
        AdDownloadEventConfig r105 = new AdDownloadEventConfig.Builder().setClickButtonTag(r103).setClickItemTag(r103).setIsEnableV3Event(true).setIsEnableClickEvent(false).build();
        DeviceBandwidthSampler.updateNetworkStatus();     // Catch: Throwable -> L17
        if (DeviceBandwidthSampler.isWifi() == false) goto L14;
        String r106 = "1";
    L15:
        r101.put(ParamKeyConstants.WebViewConstants.IS_WIFI, r106);     // Catch: Throwable -> L17
        AdEventHandler.getInstance().sendEvent(r103, r100, r101, r104, r105, new AdDownloadController.Builder().build());     // Catch: Throwable -> L17
        return;
    L14:
        r106 = "0";
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        r102 = EventConstants.Tag.ORDER_DOWNLOAD;
        goto L6
    }

    public static void c(b r100, String r101, JSONObject r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.downloadModel == null) goto L18;
        if (r110 != null) goto L8;
        JSONObject r102 = new JSONObject();
    L15:
        if (r100.e() == false) goto L12;
        r102.put("unified_game_id", r100.orderId);     // Catch: Exception -> L14
        r100.getClass();     // Catch: Exception -> L14
        r102.put("trigger", null);     // Catch: Exception -> L14
        a(r110, r100);     // Catch: Exception -> L14
    L12:
        String r103 = r100.c();
        AdDownloadEventConfig r104 = new AdDownloadEventConfig.Builder().setClickButtonTag(r103).setClickItemTag(r103).setIsEnableV3Event(r100.eventV3).setIsEnableClickEvent(false).build();
        AdEventHandler.getInstance().sendEvent(r103, r101, r102, r100.downloadModel, r104, new AdDownloadController.Builder().build());
        return;
    L8:
        r102 = r110;
        goto L15
    }
}
