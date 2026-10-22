package com.bytedance.gamecenter.base.order;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.gamecenter.base.order.preres.GResourceInfo;
import com.bytedance.gamecenter.base.r;
import com.bytedance.gamecenter.base.v;
import com.bytedance.gamecenter.base.w;
import com.google.gson.Gson;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.model.OrderItem;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.utils.ToolUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends OrderItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f245025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f245026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f245029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GResourceInfo f245030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f245031g;

    public final boolean e() {
        Boolean r100 = this.f245026b;
        if (r100 != null) goto L5;
        this.f245026b = Boolean.FALSE;
        AdDownloadModel r101 = this.downloadModel;
        if (r101 == null) goto L16;
        if (r101.getExtra() == null) goto L16;
        String r102 = this.downloadModel.getExtra().optString("product_type");
        if (TextUtils.isEmpty(r102) == true) goto L16;
        if (r102.equals(BaseConstants.GAME_INFO_LIVE_UNION) == false) goto L16;
        this.f245026b = Boolean.TRUE;
    L16:
        return this.f245026b.booleanValue();
    L5:
        return r100.booleanValue();
    }

    public final boolean f() {
        AdDownloadModel r100 = this.downloadModel;
        if (r100 == null) goto L10;
        JSONObject r101 = r100.getExtra();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.optInt("reserve_type", OrderConstant$RESERVE_TYPE.ORDER_DOWNLOAD.getType()) != OrderConstant$RESERVE_TYPE.ORDER_UPDATE.getType()) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.model.OrderItem
    public final String getKey() {
        String r100 = this.f245029e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (TextUtils.isEmpty(this.f245027c) == false) goto L8;
        this.f245029e = super.getKey();
    L10:
        if (f() == false) goto L19;
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f245029e);
        r101.append("r");
        AdDownloadModel r102 = this.downloadModel;
        if (r102 == null) goto L16;
        JSONObject r103 = r102.getExtra();
        if (r103 == null) goto L16;
        int r104 = r103.optInt("reserve_type", OrderConstant$RESERVE_TYPE.ORDER_DOWNLOAD.getType());
    L17:
        r101.append(r104);
        this.f245029e = r101.toString();
    L16:
        r104 = OrderConstant$RESERVE_TYPE.ORDER_DOWNLOAD.getType();
    L19:
        return this.f245029e;
    L8:
        this.f245029e = super.getKey() + this.f245027c;
        goto L10
    }

    @Override // com.ss.android.downloadlib.addownload.model.OrderItem
    public final String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("next_interval", this.nextRequestInterval);     // Catch: JSONException -> L22
        r100.put("last_time", this.lastRequestTime);     // Catch: JSONException -> L22
        r100.put("order_id", this.orderId);     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(this.f245028d) == true) goto L6;
        r100.put(EventConstants.ExtraJson.GAME_NAME, this.f245028d);     // Catch: JSONException -> L22
    L6:
        r100.put("biz_type", this.bizType);     // Catch: JSONException -> L22
        r100.put("order_url", this.orderUrl);     // Catch: JSONException -> L22
        if (this.eventV3 == false) goto L9;
        int r101 = 1;
    L10:
        r100.put("event_v3", r101);     // Catch: JSONException -> L22
        AdDownloadModel r102 = this.downloadModel;     // Catch: JSONException -> L22
        if (r102 != null) goto L13;
        JSONObject r103 = null;
    L14:
        r100.put("download_model", r103);     // Catch: JSONException -> L22
        r100.put("order_time", this.orderTime);     // Catch: JSONException -> L22
        r100.put("user_id", this.f245027c);     // Catch: JSONException -> L22
        if (w.g() == false) goto L20;
        GResourceInfo r104 = this.f245030f;     // Catch: JSONException -> L22
        if (r104 == null) goto L19;
        r100.put("resource_info", v.a(r104));     // Catch: JSONException -> L22
    L19:
        r100.put("shelved_time", this.f245025a);     // Catch: JSONException -> L22
    L20:
        r100.put("resource_download_flag", this.f245031g);     // Catch: JSONException -> L22
    L25:
        return r100.toString();
    L13:
        r103 = r102.toJson();     // Catch: JSONException -> L22
        goto L14
    L9:
        r101 = 0;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public b() {
        this.f245026b = null;
    }

    public final String c() {
        if (f() == true) goto L5;
        return EventConstants.Tag.ORDER_DOWNLOAD;
    L5:
        return OrderConstant$TAG.TAG_ORDER_UPDATE.getTag();
    }

    public final String d() {
        return super.getKey();
    }

    public static b a(OrderItem r100) {
        b r101 = new b();
        r101.orderId = r100.orderId;
        r101.nextRequestInterval = r100.nextRequestInterval;
        r101.lastRequestTime = r100.lastRequestTime;
        r101.bizType = r100.bizType;
        r101.orderUrl = r100.orderUrl;
        r101.eventV3 = r100.eventV3;
        r101.downloadModel = r100.downloadModel;
        r101.orderTime = r100.orderTime;
        return r101;
    }

    public static b b(String r100) {
        b r101 = new b();
        if (TextUtils.isEmpty(r100) == false) goto L29;
        return r101;
    L29:
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L28
        r101.nextRequestInterval = ToolUtils.optLong(r102, "next_interval");
        r101.lastRequestTime = ToolUtils.optLong(r102, "last_time");
        r101.orderId = r102.optString("order_id");
        r101.f245028d = r102.optString(EventConstants.ExtraJson.GAME_NAME);
        r101.bizType = r102.optString("biz_type");
        r101.orderUrl = r102.optString("order_url");
        boolean r103 = true;
        if (r102.optInt("event_v3", 1) != 1) goto L9;
        boolean r104 = true;
    L10:
        r101.eventV3 = r104;
        r101.downloadModel = AdDownloadModel.fromJson(r102.optJSONObject("download_model"));
        r101.orderTime = ToolUtils.optLong(r102, "order_time");
        r101.f245025a = r102.optLong("shelved_time");
        r101.f245027c = r102.optString("user_id");
        int r105 = ly5.a.f511315a;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "json");
        if (w.g() == true) goto L31;
        boolean r106 = r.f245056a;
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");
    L26:
        r101.f245031g = r102.optInt("resource_download_flag");
        goto L27
    L31:
        String r107 = r102.optString("resource_info");     // Catch: Exception -> L25
        if (r107 == null) goto L26;
        if (r107.length() > 0) goto L19;
        r103 = false;
    L19:
        if (r103 == true) goto L22;
        r107 = null;
    L22:
        if (r107 == null) goto L26;
        r101.f245030f = (GResourceInfo) new Gson().fromJson(r107, GResourceInfo.class);     // Catch: Exception -> L25
    L25:
        boolean r108 = r.f245056a;
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");
        goto L26
    L9:
        r104 = false;
    L27:
        return r101;
    }
}
