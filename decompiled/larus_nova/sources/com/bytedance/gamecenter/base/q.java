package com.bytedance.gamecenter.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.gamecenter.base.order.GlobalDownloadCompleteListener;
import com.bytedance.gamecenter.base.order.OrderConstant$RESERVE_TYPE;
import com.bytedance.gamecenter.base.order.preres.GGameResItem;
import com.bytedance.gamecenter.base.order.preres.GResourceDownloadFinishInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.TTDownloader;
import com.ss.android.downloadlib.addownload.model.OrderItem;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.utils.ToolUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class q {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile q f245047i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f245048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f245049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f245050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f245051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, Object> f245052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f245053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f245054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f245055h;

    public static void e() {
        int r100 = ly5.a.f511315a;
        boolean r101 = false;
        SharedPreferences r102 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_order_game_online", 0);     // Catch: Exception -> L28
        Map<String, ?> r103 = r102.getAll();     // Catch: Exception -> L28
        if (r103 != null) goto L6;
    L7:
        r101 = true;
    L8:
        if (r101 == false) goto L10;
        boolean r104 = r.f245056a;     // Catch: Exception -> L28
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");     // Catch: Exception -> L28
        return;
    L10:
        Iterator<Map.Entry<String, ?>> r105 = r103.entrySet().iterator();     // Catch: Exception -> L28
    L12:
        if (r105.hasNext() == false) goto L43;
        Map.Entry<String, ?> r106 = r105.next();     // Catch: Exception -> L28
        Object r107 = r106.getValue();     // Catch: Exception -> L28
        if (r107 == null) goto L18;
        String r108 = r107.toString();     // Catch: Exception -> L28
        if (r108 == null) goto L18;
        GGameResItem r109 = (GGameResItem) new Gson().fromJson(r108, GGameResItem.class);     // Catch: Exception -> L28
    L19:
        if (r109 == null) goto L12;
        r109.getShelvedTime();     // Catch: Exception -> L28
        System.currentTimeMillis();     // Catch: Exception -> L28
        boolean r110 = r.f245056a;     // Catch: Exception -> L28
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");     // Catch: Exception -> L28
        if (r109.getShelvedTime() <= 0) goto L12;
        if ((System.currentTimeMillis() - (r109.getShelvedTime() * ((long) 1000))) <= 604800000) goto L12;
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");     // Catch: Exception -> L28
        if (ly5.a.b(r109) == false) goto L12;
        ly5.a.a(r109);     // Catch: Exception -> L28
        r102.edit().remove(r106.getKey()).apply();     // Catch: Exception -> L28
    L18:
        r109 = null;
        goto L19
    L43:
        return;
    L6:
        if (r103.isEmpty() == false) goto L8;
    L28:
        boolean r111 = r.f245056a;
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");
    }

    public static q l() {
        if (f245047i != null) goto L15;
        monitor-enter(q.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f245047i != null) goto L9;
        f245047i = new q();     // Catch: Throwable -> L11
    L9:
        monitor-exit(q.class);     // Catch: Throwable -> L11
    L15:
        return f245047i;
    }

    public final JSONObject h() {
        JSONObject r100 = this.f245050c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        JSONObject r101 = this.f245049b;
        if (r101 == null) goto L9;
        this.f245050c = r101.optJSONObject(AdDownloadModel.JsonKey.DOWNLOAD_SETTINGS);
    L9:
        if (this.f245050c != null) goto L12;
        this.f245050c = new JSONObject();
    L12:
        return this.f245050c;
    }

    public final JSONObject k() {
        JSONObject r100 = this.f245051d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        JSONObject r101 = this.f245049b;
        if (r101 == null) goto L8;
        JSONObject r102 = r101.optJSONObject("h5_download_settings");
    L9:
        if (r102 != null) goto L11;
        r102 = new JSONObject();
    L11:
        JSONObject r103 = h();
        Iterator<String> r104 = r103.keys();
    L12:
        if (r104 == null) goto L21;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L14:
        if (r104.hasNext() == false) goto L21;
        String r105 = r104.next();     // Catch: JSONException -> L19
        if (r102.has(r105) == true) goto L12;
        r102.put(r105, r103.opt(r105));     // Catch: JSONException -> L19
    L21:
        this.f245051d = r102;
        return r102;
    L8:
        r102 = null;
        goto L9
    }

    public q() {
        this.f245048a = false;
        this.f245054g = new n();
    }

    public static GResourceDownloadFinishInfo i(String r100) {
        my5.a r101 = my5.a.h();
        r101.getClass();
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        if (TextUtils.isEmpty(r100) == true) goto L12;
        GResourceDownloadFinishInfo r103 = r101.f(r100);
        if (r103 == null) goto L8;
        int r104 = r103.getDownloadStatus();
    L10:
        if (r104 != (-3)) goto L12;
        return r103;
    L8:
        r104 = 0;
    L12:
        return null;
    }

    public static GResourceDownloadFinishInfo j(String r100) {
        my5.a r101 = my5.a.h();
        r101.getClass();
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    L11:
        return null;
    L5:
        GResourceDownloadFinishInfo r103 = r101.e(r100);
        if (r103 != null) goto L9;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        goto L11
    L9:
        if (r103.getDownloadStatus() != (-3)) goto L11;
        return r103;
    }

    public final JSONObject m(JSONObject r100) {
        JSONObject r101 = h();
        Iterator<String> r102 = r101.keys();
    L3:
        if (r102 == null) goto L12;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L5:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: JSONException -> L10
        if (r100.has(r103) == true) goto L3;
        r100.put(r103, r101.opt(r103));     // Catch: JSONException -> L10
    L12:
        return r100;
    }

    public static void b(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L17;
        JSONObject r102 = r100.optJSONObject("extra");
        if (r102 == null) goto L13;
        ToolUtils.copyJson(r101, r102);
        return;
    L13:
        r100.put("extra", r101);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        return;
    }

    public static void q(String r100, Boolean r110) {
        int r101 = ly5.a.f511315a;
        boolean r111 = r110.booleanValue();
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        boolean r104 = r.f245056a;
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");
        return;
    L12:
        SharedPreferences r105 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_order_game_online", 0);
        String r106 = r105.getString(r100, "");
        GGameResItem r107 = null;
        if (r106 == null) goto L15;
        GGameResItem r108 = (GGameResItem) GsonProtectorUtils.fromJson(new Gson(), r106, GGameResItem.class);
    L16:
        Objects.toString(r108);
        boolean r109 = r.f245056a;
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");
        if (r108 != null) goto L19;
        return;
    L19:
        if (r108.getUseRes() != r111) goto L22;
        r102 = false;
    L22:
        if (r102 == false) goto L24;
        r107 = r108;
    L24:
        if (r107 == null) goto L29;
        r107.setUseRes(r111);
        r105.edit().putString(r100, v.a(r107)).apply();
        return;
    L29:
        return;
    L15:
        r108 = null;
        goto L16
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final void d(Context r100, JSONObject r101) {
        if (this.f245053f != null) goto L5;
        this.f245053f = new f(r100);
    L5:
        f r102 = this.f245053f;
        r102.getClass();
        com.bytedance.gamecenter.base.order.a r103 = new com.bytedance.gamecenter.base.order.a();
        r103.f245023d = r101.optString("game_id", "");
        r103.f245024e = r101.optInt("reserve_type", OrderConstant$RESERVE_TYPE.ORDER_DOWNLOAD.getType());
        r103.f245022c = r101.optInt(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, 0);
        r102.f244981a.getClass();
        g.a.f244983a.e(r103);
    }

    public final Pair<String, String> f(String r100, Map<String, Object> r101) {
        String r102 = "";
        b r103 = this.f245055h;     // Catch: Exception -> L19
        if (r103 == null) goto L18;
        Function1<String, String> r104 = r103.f244944b;     // Catch: Exception -> L19
        if (r104 == null) goto L9;
        String r105 = r104.invoke(null);     // Catch: Exception -> L19
    L28:
        Function2<String, String, Map<String, Object>> r106 = this.f245055h.f244945c;     // Catch: Exception -> L17
        if (r106 == null) goto L20;
        Map<String, Object> r107 = r106.invoke(r100, "");     // Catch: Exception -> L17
        if (r101 == null) goto L15;
        r107.putAll(r101);     // Catch: Exception -> L17
    L15:
        r102 = v.a(r107);     // Catch: Exception -> L17
    L20:
        String r108 = r102;
        r102 = r105;
    L22:
        if (TextUtils.isEmpty(r102) == false) goto L25;
        r102 = "1026220034";
    L25:
        return new Pair(r102, r108);
    L9:
        r105 = "";
        goto L28
    L18:
        r108 = "";
    L19:
        r105 = "";
        goto L20
    }

    public final void n(Context r100, JSONObject r101) {
        if (r101.optInt("action_type") != 1) goto L26;
        JSONObject r102 = r101.optJSONObject("order_info");
        if (this.f245053f != null) goto L7;
        this.f245053f = new f(r100);
    L7:
        f r103 = this.f245053f;
        r103.getClass();
        if (r102 == null) goto L31;
        String r104 = r102.optString("order_id");
        String r105 = r102.optString("order_url");
        ky5.a r106 = new ky5.a();
        r106.a(r102.optJSONObject("download_model"));
        AdDownloadModel r107 = jy5.a.a(r100, r106);
        if (TextUtils.isEmpty(r104) == false) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty("game") == false) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r105) == true) goto L29;
        if (r107 == null) goto L32;
        OrderItem r108 = new OrderItem();
        r108.orderId = r104;
        r108.bizType = "game";
        r108.orderUrl = r105;
        r108.eventV3 = r106.f506660y;
        r108.downloadModel = r107;
        d r109 = r103.f244981a;
        r109.getClass();
        JSONObject r110 = l().f245049b;
        if (r110 != null) goto L22;
        r110 = new JSONObject();
    L22:
        if (r110.optInt("order_download_mode", 1) != 0) goto L24;
        r109.f244955d.getOrderDownloader().addOrder(r108);
        return;
    L24:
        g.a.f244983a.c(r108);
        return;
    L32:
        return;
    L29:
        return;
    L31:
        return;
    }

    public static void c(String r100, List r110, JSONObject r111) {
        int r101 = com.bytedance.gamecenter.base.multicdn.a.f245008a;
        if (r110.isEmpty() == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter("GMultiCDNSupAllGameOPt", "tag");
        return;
    L8:
        String r104 = r111.optString("compressed_download_url");
        String r105 = r111.optString("micro_pkg_download_url");
        String r106 = r111.optString("patch_download_url");
        JSONArray r107 = r111.optJSONArray("micro_pkg_backup_urls");
        if (r107 == null) goto L11;
        List<String> r108 = ky5.b.b(r107);
    L12:
        JSONArray r109 = r111.optJSONArray("compressed_backup_urls");
        if (r109 == null) goto L15;
        List<String> r112 = ky5.b.b(r109);
    L16:
        JSONArray r113 = r111.optJSONArray("patch_backup_urls");
        if (r113 == null) goto L19;
        List<String> r114 = ky5.b.b(r113);
    L20:
        com.bytedance.gamecenter.base.multicdn.a.a(r100, r110, r104, r108, r105, r112, r106, r114);
        return;
    L19:
        r114 = null;
        goto L20
    L15:
        r112 = null;
        goto L16
    L11:
        r108 = null;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public final boolean a(Context r210, JSONObject r211, JSONObject r212) {
        int r100 = r211.optInt("action_type");
        if (r100 != 0) goto L65;
        JSONObject r101 = r211.optJSONObject("download_info");
        b(r101, r212);
        f r102 = this.f245053f;
        if (r102 == null) goto L134;
        if (r210 == null) goto L135;
        if (r101 == null) goto L142;
        r101.optString("download_url");
        r101.optString(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP);
        r101.optInt("token");
        r101.optInt(AdDownloadModel.JsonKey.NEED_WIFI);
        Pair<String, String> r110 = l().f(r101.optString("extra"), null);
        r110.toString();
        JSONObject r111 = f.a(r210, r101, true);
        boolean r103 = r111.optBoolean("enable_click_start_opt");
        r111.optString("download_url");
        r111.optString(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP);
        r111.optInt("token");
        r111.optInt(AdDownloadModel.JsonKey.NEED_WIFI);
        ky5.a r104 = new ky5.a();
        r104.a(r111);
        AdDownloadModel r105 = jy5.a.a(r210, r104);
        if (TextUtils.isEmpty(r104.f506656u) == true) goto L12;
        String r106 = r104.f506656u;
    L50:
        boolean r107 = r104.f506660y;
        AdDownloadEventConfig r108 = new AdDownloadEventConfig.Builder().setClickItemTag(r106).setClickButtonTag(r106).setDownloadScene(0).setIsEnableClickEvent(true).setIsEnableV3Event(r107).build();
        boolean r109 = r104.f506658w;
        int r112 = r104.f506659x;
        if (l().k().optInt("add_to_download_manager", 0) != 1) goto L53;
        boolean r113 = true;
    L55:
        if (l().h().optInt(AdDownloadController.JsonKey.ENABLE_SHOW_COMPLIANCE_DIALOG, 0) != 1) goto L57;
        boolean r114 = true;
    L58:
        AdDownloadController r115 = new AdDownloadController.Builder().setLinkMode(0).setDownloadMode(0).setIsEnableBackDialog(true).setIsAddToDownloadManage(r113).setIsEnableMultipleDownload(r109).setDowloadChunkCount(r112).setShouldUseNewWebView(false).setEnableShowComplianceDialog(r114).build();
        if (r105.getTaskKeyObject() == null) goto L61;
        r115.setEnableDownloadHandlerTaskKey(true);
    L61:
        l().getClass();
        r115.setEnableClickStartOptForGameUnion(r103);
        String r116 = r110.getFirst();
        String r117 = r110.getSecond();
        if (r111.has("enable_new_activity") == false) goto L64;
        r115.setEnableNewActivity(r111.optBoolean("enable_new_activity", false));
    L64:
        r102.f244981a.b(r210, r104, r105, r108, r115, r111);
        return false;
    L57:
        r114 = false;
        goto L58
    L53:
        r113 = false;
        goto L55
    L12:
        String r118 = r104.f506639d;
        if (r118 == null) goto L40;
        int r119 = r118.hashCode();
        if (r119 == 110924) goto L30;
        if (r119 == 989204668) goto L26;
        if (r119 == 1001100552) goto L22;
    L31:
        byte r120 = -1;
    L33:
        if (r120 == 0) goto L39;
        if (r120 == 1) goto L38;
        if (r120 != 2) goto L40;
        String r121 = "game_room_app_ad";
    L41:
        if (r121 == null) goto L43;
    L49:
        r106 = r121;
        goto L50
    L43:
        if (TextUtils.isEmpty(r104.f506640e) == true) goto L49;
        if (TextUtils.isDigitsOnly(r104.f506640e) == false) goto L49;
        if (CastIntegerProtector.parseInt(r104.f506640e) != 3) goto L49;
        r106 = "game_room_app_ad";
        goto L50
    L38:
        r121 = "article_match_app_ad";
        goto L41
    L39:
        r121 = "article_card_app_ad";
        goto L41
    L22:
        if (r118.equals("game_room") == false) goto L31;
        r120 = 2;
        goto L33
    L26:
        if (r118.equals("recommend") == false) goto L31;
        r120 = 1;
        goto L33
    L30:
        if (r118.equals("pgc") == false) goto L31;
        r120 = 0;
    L40:
        r121 = null;
        goto L41
    L142:
        return false;
    L135:
        return false;
    L134:
        return false;
    L65:
        if (r100 != 1) goto L75;
        JSONObject r122 = r211.optJSONObject("order_info");
        b(r122, r212);
        n r123 = this.f245054g;
        r123.getClass();
        if (r122 == null) goto L143;
        String r124 = r122.optString("order_id");
        String r125 = r122.optString("has_reserve_url");
        if (TextUtils.isEmpty(r124) == false) goto L72;
        return false;
    L72:
        if (TextUtils.isEmpty(r125) == true) goto L144;
        HashMap r126 = new HashMap();
        r126.put("unified_game_id", r124);
        String r127 = n.c(r125, r126);
        i r128 = new i(r123, r122);
        DownloadComponentManager.getInstance().submitCPUTask(new m(r127, r128));
        return false;
    L144:
        return false;
    L143:
        return false;
    L75:
        if (r100 != 3) goto L139;
        JSONObject r129 = r211.optJSONObject("download_info");
        b(r129, r212);
        my5.a r130 = my5.a.h();
        if (r129 != null) goto L79;
        r130.m(0, 0);
        return false;
    L79:
        Object r131 = null;
        if (r130.b(r129, null, 2) == false) goto L127;
        long r132 = 0;
        if (r130.g(r129) != 4) goto L85;
    L87:
        boolean r133 = true;
    L88:
        if (r133 == false) goto L127;
        String r134 = r129.optString("download_url");
        boolean r135 = r129.optBoolean("only_wifi");
        AdDownloadModel r136 = (AdDownloadModel) ((ConcurrentHashMap) r130.f516378c).get(r134);
        if (r136 != null) goto L93;
        r136 = my5.a.c(r129);
    L94:
        if (r136 == null) goto L96;
        r132 = r136.getId();
    L96:
        com.bytedance.gamecenter.base.order.g.c(r129, false);
        TTDownloader r137 = TTDownloader.inst(com.bytedance.gamecenter.base.order.h.a());
        r137.action(r134, r132, 2, r130.f516376a, new AdDownloadController.Builder().build());
        String r138 = r129.optString("md5");
        SharedPreferences r139 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_game_res_click_start", 0);
        if (r138 != null) goto L99;
    L102:
        boolean r140 = true;
    L103:
        if (r140 == false) goto L129;
    L123:
        boolean r141 = false;
    L124:
        if (r141 == false) goto L126;
        int r142 = my5.c.f516387a;
        my5.c.a("pre_click_start", r129.toString(), 0);
        com.bytedance.gamecenter.base.order.g.b(r129, false);
    L126:
        return true;
    L129:
        Map<String, ?> r143 = r139.getAll();     // Catch: Throwable -> L122
        if (r143.isEmpty() == true) goto L121;
        Iterator<Map.Entry<String, ?>> r144 = r143.entrySet().iterator();     // Catch: Throwable -> L122
    L110:
        if (r144.hasNext() == false) goto L123;
        Map.Entry<String, ?> r145 = r144.next();     // Catch: Throwable -> L122
        String r146 = r145.getKey();     // Catch: Throwable -> L122
        Object r147 = r145.getValue();     // Catch: Throwable -> L122
        if (Intrinsics.areEqual(r146, r138) == false) goto L110;
        if ((r147 instanceof Boolean) == false) goto L117;
        r131 = r147;
    L117:
        Boolean r148 = (Boolean) r131;     // Catch: Throwable -> L122
        if (r148 == null) goto L121;
        r141 = r148.booleanValue();     // Catch: Throwable -> L122
    L121:
        r141 = true;
    L122:
        boolean r149 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameRecordSpUtils", "tag");
        goto L123
    L99:
        if (r138.length() == 0) goto L102;
        r140 = false;
        goto L103
    L93:
        r136.setNeedWifi(r135);
        goto L94
    L85:
        if (ToolUtils.getExternalAvailableSpaceBytes(0) >= r129.optLong("size")) goto L87;
        boolean r150 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        r129.optString("download_url");
        r130.m(3, 0);
        int r151 = my5.c.f516387a;
        my5.c.a("pre_fail_start", r129.toString(), 3);
        r133 = false;
    L127:
        boolean r152 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return false;
    L139:
        return false;
    }

    public final void g(Context r100, JSONObject r101, b r102) {
        Context r103 = com.bytedance.gamecenter.base.order.h.f245041a;
        if (w.e() == true) goto L5;
        boolean r104 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_ContextOpt", "tag");
    L8:
        this.f245050c = null;
        this.f245051d = null;
        this.f245049b = r101;
        this.f245055h = r102;
        this.f245054g.getClass();
        if (r100 != null) goto L17;
    L15:
        my5.a r105 = my5.a.h();
        r105.getClass();
        l().getClass();
        r105.l();
        return;
    L17:
        TTDownloader.inst(r100).addDownloadCompletedListener(new GlobalDownloadCompleteListener());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.toString();
        goto L15
    L5:
        if (r100 != null) goto L7;
        boolean r106 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_ContextOpt", "tag");
        goto L8
    L7:
        com.bytedance.gamecenter.base.order.h.f245041a = r100.getApplicationContext();
        goto L8
    }

    public final void p(Context r100, JSONObject r101, JSONObject r102) {
        int r103 = r101.optInt("action_type");
        if (r103 != 0) goto L8;
        JSONObject r104 = r101.optJSONObject("download_info");
        b(r104, r102);
        f r105 = this.f245053f;
        if (r105 == null) goto L20;
        r105.c(r100, r104);
        return;
    L20:
        return;
    L8:
        if (r103 != 1) goto L14;
        JSONObject r106 = r101.optJSONObject("order_info");
        b(r106, r102);
        n r107 = this.f245054g;
        if (r106 != null) goto L12;
        r107.getClass();
        return;
    L12:
        Map<String, p> r108 = r107.f245009a;
        HashMap r109 = (HashMap) r108;
        r109.remove(r106.optString("order_id"));
        return;
    L14:
        if (r103 != 3) goto L24;
        JSONObject r110 = r101.optJSONObject("download_info");
        b(r110, r102);
        my5.a r111 = my5.a.h();
        r111.getClass();
        Objects.toString(r110);
        boolean r112 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        if (r110 != null) goto L18;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return;
    L18:
        int r113 = r110.optInt("token", -1);
        String r114 = r110.optString("download_url");
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        Map<Integer, p> r115 = r111.f516380e;
        ConcurrentHashMap r116 = (ConcurrentHashMap) r115;
        r116.remove(Integer.valueOf(r113));
        Map<Integer, p> r117 = r111.f516381f;
        ConcurrentHashMap r118 = (ConcurrentHashMap) r117;
        r118.remove(Integer.valueOf(r113));
        TTDownloader.inst(com.bytedance.gamecenter.base.order.h.a()).unbind(r114, r113);
        return;
    }

    public final void o(Context r100, JSONObject r101, JSONObject r102, p r103) {
        int r104 = r101.optInt("action_type");
        if (r104 != 0) goto L9;
        JSONObject r105 = r101.optJSONObject("download_info");
        b(r105, r102);
        if (this.f245053f != null) goto L7;
        this.f245053f = new f(r100);
    L7:
        this.f245053f.b(r100, r105, r103, false);
        return;
    L9:
        if (r104 != 1) goto L23;
        JSONObject r106 = r101.optJSONObject("order_info");
        b(r106, r102);
        n r107 = this.f245054g;
        r107.getClass();
        if (r106 == null) goto L44;
        if (r103 == null) goto L53;
        String r108 = r106.optString("order_id");
        String r109 = r106.optString("has_reserve_url");
        if (TextUtils.isEmpty(r108) == false) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(r109) == true) goto L54;
        HashMap r110 = new HashMap();
        r110.put("unified_game_id", r108);
        String r111 = n.c(r109, r110);
        h r112 = new h(r107, r103);
        DownloadComponentManager.getInstance().submitCPUTask(new m(r111, r112));
        if (TextUtils.isEmpty(r108) == true) goto L46;
        ((HashMap) r107.f245009a).put(r108, r103);
        return;
    L46:
        return;
    L54:
        return;
    L53:
        return;
    L44:
        return;
    L23:
        if (r104 != 2) goto L27;
        if (r103 == null) goto L48;
        r103.onShow();
        return;
    L48:
        return;
    L27:
        if (r104 != 3) goto L50;
        JSONObject r113 = r101.optJSONObject("download_info");
        b(r113, r102);
        my5.a r114 = my5.a.h();
        r114.getClass();
        if (r113 != null) goto L31;
        boolean r115 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return;
    L31:
        int r116 = r113.optInt("token");
        String r117 = r113.optString("download_url");
        if (r114.b(r113, r103, 1) == true) goto L34;
        boolean r118 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return;
    L34:
        if (r103 == null) goto L36;
        Map<Integer, p> r119 = r114.f516380e;
        ConcurrentHashMap r120 = (ConcurrentHashMap) r119;
        r120.put(Integer.valueOf(r116), r103);
    L36:
        AdDownloadModel r121 = (AdDownloadModel) ((ConcurrentHashMap) r114.f516378c).get(r117);
        if (r121 != null) goto L41;
        r121 = my5.a.c(r113);
        if (r121 == null) goto L41;
        ((ConcurrentHashMap) r114.f516378c).put(r117, r121);
    L41:
        TTDownloader.inst(com.bytedance.gamecenter.base.order.h.a()).bind(r116, r114.f516382g, r121);
        return;
    }
}
