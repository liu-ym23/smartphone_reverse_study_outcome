package com.ss.android.downloadlib.addownload.model;

import android.text.TextUtils;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.utils.ToolUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class OrderItem {
    public String bizType;
    public AdDownloadModel downloadModel;
    public boolean eventV3;
    public long lastRequestTime;
    public long nextRequestInterval;
    public String orderAuth;
    public String orderId;
    public long orderTime;
    public String orderUrl;

    public OrderItem() {
    }

    public String getKey() {
        return this.bizType + this.orderId;
    }

    public String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("next_interval", this.nextRequestInterval);     // Catch: JSONException -> L13
        r100.put("last_time", this.lastRequestTime);     // Catch: JSONException -> L13
        r100.put("order_id", this.orderId);     // Catch: JSONException -> L13
        r100.put("biz_type", this.bizType);     // Catch: JSONException -> L13
        r100.put("order_url", this.orderUrl);     // Catch: JSONException -> L13
        if (this.eventV3 == false) goto L6;
        int r101 = 1;
    L7:
        r100.put("event_v3", r101);     // Catch: JSONException -> L13
        AdDownloadModel r102 = this.downloadModel;     // Catch: JSONException -> L13
        if (r102 != null) goto L10;
        JSONObject r103 = null;
    L11:
        r100.put("download_model", r103);     // Catch: JSONException -> L13
        r100.put("order_time", this.orderTime);     // Catch: JSONException -> L13
    L16:
        return r100.toString();
    L10:
        r103 = r102.toJson();     // Catch: JSONException -> L13
        goto L11
    L6:
        r101 = 0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static OrderItem fromString(String r100) {
        OrderItem r101 = new OrderItem();
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return r101;
    L13:
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L12
        r101.nextRequestInterval = ToolUtils.optLong(r102, "next_interval");
        r101.lastRequestTime = ToolUtils.optLong(r102, "last_time");
        r101.orderId = r102.optString("order_id");
        r101.bizType = r102.optString("biz_type");
        r101.orderUrl = r102.optString("order_url");
        boolean r103 = true;
        if (r102.optInt("event_v3", 1) == 1) goto L10;
        r103 = false;
    L10:
        r101.eventV3 = r103;
        r101.downloadModel = AdDownloadModel.fromJson(r102.optJSONObject("download_model"));
        r101.orderTime = ToolUtils.optLong(r102, "order_time");
    L11:
        return r101;
    }
}
