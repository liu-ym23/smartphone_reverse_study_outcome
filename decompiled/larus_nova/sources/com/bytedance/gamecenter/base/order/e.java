package com.bytedance.gamecenter.base.order;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.gamecenter.base.r;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    public static boolean a(b r100) {
        SharedPreferences r101 = h.a().getSharedPreferences("sp_g_order_download", 0);
        Map<String, ?> r102 = r101.getAll();
        if (r100.f() == true) goto L10;
        if (r102 == null) goto L10;
        if (r102.containsKey(r100.d()) == false) goto L8;
    L9:
        return false;
    L8:
        if (r102.containsKey(r100.getKey()) == true) goto L9;
    L10:
        r100.orderTime = System.currentTimeMillis();
        r101.edit().putString(r100.getKey(), r100.toString()).apply();
        f.c(r100, EventConstants.Label.ADD_ORDER_DOWNLOAD, null);
        return true;
    }

    public static void c(a r100) {
        String r101 = r100.a();     // Catch: Exception -> L6
        String r102 = r100.b();     // Catch: Exception -> L6
        if (e(r101, true, r100) == true) goto L11;
        e(r102, false, r100);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.toString();
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter("GAppOrderDownloaderUtils", "tag");
    }

    public static Boolean b(Context r100, JSONObject r101) {
        String r102 = r101.optString("order_key");
        if (r102 == null) goto L10;
        if (r102.isEmpty() == true) goto L10;
        SharedPreferences.Editor r103 = r100.getSharedPreferences("sp_g_order_download", 0).edit();
        r103.remove(r102);
        r103.apply();
        return Boolean.TRUE;
    L10:
        return Boolean.FALSE;
    }

    public static JSONArray d(Context r110, JSONObject r111) {
        JSONArray r100 = new JSONArray();
        JSONArray r101 = r111.optJSONArray("zhao_xi_game_ids");
        boolean r102 = r111.optBoolean("switch_zhao_xi_game", false);
        boolean r103 = r111.optBoolean("switch_from_source", false);
        boolean r112 = r111.optBoolean("switch_enter_from", false);
        boolean r104 = r.f245056a;
        Intrinsics.checkNotNullParameter("tag_order_download", "tag");
        ArrayList r105 = new ArrayList();
        if (r101 != null) goto L5;
    L15:
        Map<String, ?> r113 = r110.getSharedPreferences("sp_g_order_download", 0).getAll();
        if (r113 != null) goto L18;
        return r100;
    L18:
        Iterator<Map.Entry<String, ?>> r114 = r113.entrySet().iterator();
    L20:
        if (r114.hasNext() == false) goto L47;
        b r106 = b.b(String.valueOf(r114.next().getValue()));
        String r107 = r106.orderId;
        if (r105.contains(r107) == false) goto L26;
        if (r102 == false) goto L20;
        Intrinsics.checkNotNullParameter("tag_order_download", "tag");
    L26:
        AdDownloadModel r108 = r106.downloadModel;
        if (r108 == null) goto L20;
        JSONObject r109 = r108.getExtra();
        if (r109 == null) goto L20;
        String r115 = r109.optString("from_source", "");
        String r116 = r109.optString("enter_from", "");
        if (r103 == true) goto L39;
        if (r115.equals(BdpAppEventConstant.MICRO_APP) == true) goto L39;
        if (r112 == true) goto L39;
        if (r116.equals(SearchResultParam.ENTER_PAGE_GENERAL_SEARCH) == false) goto L20;
    L39:
        String r117 = r109.optString("product_type", "");
        Intrinsics.checkNotNullParameter("tag_order_download", "tag");
        if (r117.equals(BaseConstants.GAME_INFO_LIVE_UNION) == true) goto L20;
        if (r117.equals("search_union") == true) goto L20;
        JSONObject r118 = new JSONObject();     // Catch: Exception -> L46
        String r119 = r109.optString("app_name", "");     // Catch: Exception -> L46
        r118.put("game_id", r107);     // Catch: Exception -> L46
        r118.put(EventConstants.ExtraJson.GAME_NAME, r119);     // Catch: Exception -> L46
        r118.put("order_key", r106.getKey());     // Catch: Exception -> L46
        r100.put(r118);     // Catch: Exception -> L46
        goto L20
    L47:
        return r100;
    L5:
        if (r101.length() <= 0) goto L15;
        int r120 = 0;
    L8:
        if (r120 >= r101.length()) goto L15;
        String r121 = r101.optString(r120, "");
        if (r121 == null) goto L14;
        if (r121.isEmpty() == true) goto L14;
        r105.add(r121);
    L14:
        r120 = r120 + 1;
        goto L8
    }

    public static boolean e(String r100, boolean r101, a r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        SharedPreferences r103 = h.a().getSharedPreferences("sp_g_order_download", 0);
        if (r103.contains(r100) == false) goto L14;
        b r104 = b.b(String.valueOf(r103.getString(r100, "")));
        JSONObject r105 = new JSONObject();
        r105.putOpt(EventConstants.ExtraJson.GAME_NAME, r104.f245028d);     // Catch: Exception -> L10
        r105.putOpt("game_id", r104.orderId);     // Catch: Exception -> L10
        r105.putOpt("is_new_order_data", Boolean.valueOf(r101));     // Catch: Exception -> L10
        r105.putOpt("reserve_type", Integer.valueOf(r102.f245024e));     // Catch: Exception -> L10
        r105.putOpt(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, Integer.valueOf(r102.f245022c));     // Catch: Exception -> L10
        r105.putOpt("client_timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L10
    L12:
        f.b("game_cancel_order", r105, null);
        r103.edit().remove(r100).apply();
        return true;
    L10:
        e = move-exception;
        e.toString();
        boolean r106 = r.f245056a;
        Intrinsics.checkNotNullParameter("GAppOrderDownloaderUtils", "tag");
        goto L12
    L14:
        return false;
    }
}
