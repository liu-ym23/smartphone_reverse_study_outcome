package go7;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ug.sdk.share.api.entity.ActivityInfo;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.network.model.GetSignInfoResponse;
import com.bytedance.ug.sdk.share.impl.network.model.SignInfo;
import java.util.Iterator;
import oo7.c;
import oo7.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static void a(JSONObject r100) {
        eo7.a r101 = eo7.a.b.f473353a;     // Catch: JSONException -> L17
        jn7.a r102 = r101.f473332f;     // Catch: JSONException -> L17
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getDeviceId();     // Catch: JSONException -> L17
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r100.put("ug_share_did", r104);     // Catch: JSONException -> L17
    L9:
        jn7.a r105 = r101.f473332f;     // Catch: JSONException -> L17
        if (r105 == null) goto L13;
        r103 = r105.getAppId();     // Catch: JSONException -> L17
    L13:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        r100.put("ug_share_aid", r103);     // Catch: JSONException -> L17
    L15:
        r100.put("tag", "ug_sdk_share");     // Catch: JSONException -> L17
        r100.put("ug_share_v_code", String.valueOf(241059));     // Catch: JSONException -> L17
        r100.put("ug_share_v_name", "2.4.1-rc.59");     // Catch: JSONException -> L17
        r100.put("ug_share_os_api", String.valueOf(Build.VERSION.SDK_INT));     // Catch: JSONException -> L17
        r100.put("ug_share_platform", "android");     // Catch: JSONException -> L17
        r100.put("params_for_special", "performance");     // Catch: JSONException -> L17
        return;
    L5:
        r104 = null;
    L17:
        e = move-exception;
        k.b(e.toString());
    }

    public static void c(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("status", r100);     // Catch: JSONException -> L5
    L7:
        a(r101);
        c.a("ug_sdk_share_clipboard_detect_result", r101);
        return;
    L5:
        e = move-exception;
        k.b(e.toString());
        goto L7
    }

    public static void b(JSONObject r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Iterator<String> r102 = r101.keys();
    L6:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        r100.put(r103, r101.get(r103));     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public static void e(ShareContent r100, boolean r101) {
        JSONObject r102 = new JSONObject();
        if (r100 != null) goto L14;
    L12:
        a(r102);
        c.a("ug_sdk_share_authorize_popup_click", r102);
        return;
    L14:
        r102.put(ShareConstants.KEY_PANEL_TYPE, r100.getFrom());     // Catch: JSONException -> L10
        r102.put(WsConstants.KEY_CHANNEL_TYPE, ShareChannelType.getShareItemTypeName(r100.getShareChanelType()));     // Catch: JSONException -> L10
        r102.put("share_type", ShareStrategy.getStrategyStr(r100.getShareStrategy()));     // Catch: JSONException -> L10
        if (r101 == false) goto L7;
        String r103 = LocationMonitorConst.SUBMIT;
    L8:
        r102.put("click_result", r103);     // Catch: JSONException -> L10
        r102.put("panel_id", r100.getPanelId());     // Catch: JSONException -> L10
        r102.put("resource_id", r100.getResourceId());     // Catch: JSONException -> L10
        b(r102, r100.getLogEventParams());     // Catch: JSONException -> L10
        goto L12
    L7:
        r103 = "cancel";
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void f(ShareContent r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r102 = new JSONObject();
        r102.put(ShareConstants.KEY_PANEL_TYPE, r100.getFrom());     // Catch: JSONException -> L11
        r102.put(WsConstants.KEY_CHANNEL_TYPE, ShareChannelType.getShareItemTypeName(r100.getShareChanelType()));     // Catch: JSONException -> L11
        r102.put("share_type", ShareStrategy.getStrategyStr(r100.getShareStrategy()));     // Catch: JSONException -> L11
        if (r101 == false) goto L8;
        String r103 = "1";
    L9:
        r102.put("had_authorize", r103);     // Catch: JSONException -> L11
        r102.put("panel_id", r100.getPanelId());     // Catch: JSONException -> L11
        r102.put("resource_id", r100.getResourceId());     // Catch: JSONException -> L11
        b(r102, r100.getLogEventParams());     // Catch: JSONException -> L11
    L13:
        a(r102);
        c.a("ug_sdk_share_authorize_popup_request", r102);
        return;
    L8:
        r103 = "0";
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static void g(boolean r100, String r101, long r102) {
        JSONObject r103 = new JSONObject();
        if (r100 == false) goto L6;
        int r104 = 1;
    L13:
        r103.put("is_success", r104);     // Catch: JSONException -> L9
        r103.put("failed_reason", r101);     // Catch: JSONException -> L9
        r103.put("total_duration", r102);     // Catch: JSONException -> L9
    L11:
        a(r103);
        c.a("ug_sdk_share_initial_interface_request", r103);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L6:
        r104 = 0;
        goto L13
    }

    public static void i(ShareContent r100, ShareContentType r101, GetSignInfoResponse r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L14
        if (r100 == null) goto L8;
        r104.put("panel_id", r100.getPanelId());     // Catch: Throwable -> L14
        r104.put(WsConstants.KEY_CHANNEL_TYPE, ShareChannelType.getShareItemTypeName(r100.getShareChanelType()));     // Catch: Throwable -> L14
        if (r101 == null) goto L7;
        r104.put("content_type", r101.getTypeName());     // Catch: Throwable -> L14
    L7:
        r104.put("resource_id", r100.getResourceId());     // Catch: Throwable -> L14
        r104.put("title", r100.getTitle());     // Catch: Throwable -> L14
        r104.put("url", r100.getTargetUrl());     // Catch: Throwable -> L14
    L8:
        if (r102 == null) goto L12;
        r104.put("result", r102.getStatus());     // Catch: Throwable -> L14
        SignInfo r105 = r102.getSignInfo();     // Catch: Throwable -> L14
        if (r105 == null) goto L12;
        r104.put("log_id", r105.getLogId());     // Catch: Throwable -> L14
        r104.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r105.getStrategy());     // Catch: Throwable -> L14
    L12:
        r104.put("failed_reason", r103);     // Catch: Throwable -> L14
        c.a("ug_sdk_share_signature_result", r104);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        k.b(th.toString());
    }

    public static void d(ShareContent r100, boolean r101, String r102, int r103, long r104) {
        JSONObject r105 = new JSONObject();
        if (r100 != null) goto L14;
    L12:
        a(r105);
        c.a("ug_sdk_share_hidden_interface_write", r105);
        return;
    L14:
        r105.put(ShareConstants.KEY_PANEL_TYPE, r100.getFrom());     // Catch: JSONException -> L10
        r105.put(WsConstants.KEY_CHANNEL_TYPE, ShareChannelType.getShareItemTypeName(r100.getShareChanelType()));     // Catch: JSONException -> L10
        r105.put("share_type", ShareStrategy.getStrategyStr(r100.getShareStrategy()));     // Catch: JSONException -> L10
        if (r101 == false) goto L7;
        String r106 = "success";
    L8:
        r105.put("condition", r106);     // Catch: JSONException -> L10
        r105.put("panel_id", r100.getPanelId());     // Catch: JSONException -> L10
        r105.put("hidden_str", r102);     // Catch: JSONException -> L10
        r105.put("resource_id", r100.getResourceId());     // Catch: JSONException -> L10
        r105.put("status", r103);     // Catch: JSONException -> L10
        r105.put("total_duration", r104);     // Catch: JSONException -> L10
        b(r105, r100.getLogEventParams());     // Catch: JSONException -> L10
        goto L12
    L7:
        r106 = " failed";
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void h(boolean r100, String r101, String r102, String r103, ActivityInfo r104) {
        JSONObject r105 = new JSONObject();
        r105.put("recognize_type", r101);     // Catch: JSONException -> L18
        if (r100 == false) goto L6;
        int r106 = 1;
    L7:
        r105.put("is_success", r106);     // Catch: JSONException -> L18
        r105.put("failed_reason", r102);     // Catch: JSONException -> L18
        r105.put("open_url", r103);     // Catch: JSONException -> L18
        String r107 = "";
        if (r104 != null) goto L11;
        String r108 = "";
    L12:
        r105.put("activity_id", r108);     // Catch: JSONException -> L18
        if (r104 == null) goto L16;
        r107 = r104.getName();     // Catch: JSONException -> L18
    L16:
        r105.put("activity_name", r107);     // Catch: JSONException -> L18
    L20:
        a(r105);
        c.a("ug_sdk_share_recognize_interface_request", r105);
        return;
    L11:
        r108 = r104.getId();     // Catch: JSONException -> L18
        goto L12
    L6:
        r106 = 0;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }
}
