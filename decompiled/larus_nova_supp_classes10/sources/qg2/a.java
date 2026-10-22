package qg2;

import am2.x;
import android.os.Bundle;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.base.model.ad.AdExtra;
import com.bytedance.android.live.base.model.ad.LiveAdRawData;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livesdk.chatroom.utils.k0;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(Bundle r18, FeedItem r19) {
        String r6 = "";
        Intrinsics.checkNotNullParameter(r19, "feedItem");
        if (r18 != null) goto L5;
        return;
    L5:
        if (r19.isAd == false) goto L219;
        AdExtra r0 = r19.adExtra;
        if (r0 == null) goto L221;
        if (r0 == null) goto L220;
        LiveAdRawData r7 = r0.getRawAdData();
        if (r7 == null) goto L222;
        JSONObject r8 = new JSONObject();
        HashMap r9 = new HashMap();
        boolean r11 = false;
        r8.put("room_id", String.valueOf(r19.getRoom().id));     // Catch: JSONException -> L30
        IUser r14 = r19.getRoom().author();     // Catch: JSONException -> L30
        if (r14 == null) goto L17;
        String r15 = r14.getIdString();     // Catch: JSONException -> L30
    L18:
        r8.put("anchor_id", String.valueOf(r15));     // Catch: JSONException -> L30
        Integer r16 = r7.systemOrigin;     // Catch: JSONException -> L30
        if (r16 != null) goto L22;
    L24:
        boolean r17 = false;
    L25:
        r8.put("is_dou_plus_ad", r17);     // Catch: JSONException -> L30
        if (u.l().c(x.class).getMap().containsKey("action_type") == false) goto L28;
        r8.put("action_type", u.l().c(x.class).getMap().get("action_type"));     // Catch: JSONException -> L30
    L28:
        r8.put("enter_from_merge", k1.c());     // Catch: JSONException -> L30
        r8.put("enter_method", k1.d());     // Catch: JSONException -> L30
        r9.put("value", String.valueOf(r7.creativeId));     // Catch: JSONException -> L30
        r9.put("log_extra", String.valueOf(r7.logExtra));     // Catch: JSONException -> L30
        r9.put("ad_id", String.valueOf(r7.adId));     // Catch: JSONException -> L30
    L32:
        ILiveDouPlusService r1 = k.n(ILiveDouPlusService.class);
        HashMap r13 = new HashMap();
        r13.put("ad_extra_data", r8.toString());
        if (r9.isEmpty() == true) goto L36;
        r13.putAll(r9);
    L36:
        r1.logEvent(true, "live_ad", "receive", r13);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L71
        Integer r3 = r7.systemOrigin;     // Catch: Throwable -> L71
        if (r3 != null) goto L41;
    L43:
        boolean r4 = false;
    L44:
        Integer r10 = r7.adSourceType;     // Catch: Throwable -> L71
        if (r10 != null) goto L48;
    L50:
        boolean r12 = false;
    L51:
        Room r110 = r19.getRoom();     // Catch: Throwable -> L71
        Pair[] r111 = new Pair[6];     // Catch: Throwable -> L71
        r111[0] = new Pair("live_is_ad", Boolean.TRUE);     // Catch: Throwable -> L71
        if (r4 == true) goto L55;
        if (r12 == true) goto L55;
        boolean r5 = true;
    L56:
        r111[1] = new Pair("live_is_hard_ad", Boolean.valueOf(r5));     // Catch: Throwable -> L71
        Long r20 = r7.adId;     // Catch: Throwable -> L71
        long r112 = 0;
        if (r20 == null) goto L59;
        long r21 = r20.longValue();     // Catch: Throwable -> L71
    L60:
        r111[2] = new Pair("live_ad_id", Long.valueOf(r21));     // Catch: Throwable -> L71
        Long r22 = r7.creativeId;     // Catch: Throwable -> L71
        if (r22 == null) goto L63;
        r112 = r22.longValue();     // Catch: Throwable -> L71
    L63:
        r111[3] = new Pair("live_ad_creative_id", Long.valueOf(r112));     // Catch: Throwable -> L71
        String r23 = r7.getRit();     // Catch: Throwable -> L71
        if (r23 != null) goto L66;
        r23 = "";
    L66:
        r111[4] = new Pair("live_ad_rit", r23);     // Catch: Throwable -> L71
        String r24 = r7.logExtra;     // Catch: Throwable -> L71
        if (r24 != null) goto L69;
        r24 = "";
    L69:
        r111[5] = new Pair("live_ad_log_extra", r24);     // Catch: Throwable -> L71
        r110.setAdStrategyFeatures(new com.bytedance.android.livesdk.strategy.a(MapsKt.hashMapOf(r111)));     // Catch: Throwable -> L71
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L71
    L73:
        IHostLiveAd r25 = k.f(IHostLiveAd.class);
        if (r25 == null) goto L85;
        String r26 = r7.actionExtra;
        String r27 = r7.liveActionExtra;
        if (r27 != null) goto L78;
    L81:
        boolean r28 = true;
    L82:
        if (r28 == true) goto L84;
        r7.actionExtra = r7.liveActionExtra;
    L84:
        r25.putWebcastFeedRawAdStr(r19.getRoom().id, GsonProtectorUtils.toJson(GsonHelper.get(), r7));
        r7.actionExtra = r26;
        goto L85
    L78:
        if (r27.length() == 0) goto L81;
        r28 = false;
    L85:
        Integer r29 = r7.systemOrigin;
        if (r29 != null) goto L89;
    L91:
        boolean r30 = false;
    L92:
        HashMap r31 = new HashMap();
        Long r32 = r7.adId;
        if (r32 == null) goto L96;
        String r33 = String.valueOf(r32.longValue());
        if (r33 == null) goto L96;
    L97:
        r31.put("ad_id", r33);
        Long r34 = r7.creativeId;
        if (r34 == null) goto L101;
        String r35 = String.valueOf(r34.longValue());
        if (r35 == null) goto L101;
    L102:
        r31.put("value", r35);
        String r36 = r7.logExtra;
        if (r36 == null) goto L106;
        r6 = r36;
    L106:
        r31.put("log_extra", r6);
        UrlModel r37 = r7.trackUrlList;
        if (r37 == null) goto L120;
        List r38 = r37.getUrlList();
        if (r38 == null) goto L120;
        if ((!r38.isEmpty()) == true) goto L114;
        r38 = null;
    L114:
        if (r38 == null) goto L120;
        JSONArray r39 = new JSONArray();
        Iterator r40 = r38.iterator();
    L117:
        if (r40.hasNext() == false) goto L119;
        r39.put((String) r40.next());
        goto L117
    L119:
        String r41 = (String) r31.put("track_url_list", r39.toString());
    L120:
        UrlModel r42 = r7.clickTrackUrlList;
        if (r42 == null) goto L134;
        List r43 = r42.getUrlList();
        if (r43 == null) goto L134;
        if ((!r43.isEmpty()) == true) goto L128;
        r43 = null;
    L128:
        if (r43 == null) goto L134;
        JSONArray r44 = new JSONArray();
        Iterator r45 = r43.iterator();
    L131:
        if (r45.hasNext() == false) goto L133;
        r44.put((String) r45.next());
        goto L131
    L133:
        r31.put("click_track_url_list", r44.toString());
    L134:
        if (r30 == true) goto L142;
        Integer r46 = r7.adSourceType;
        if (r46 != null) goto L139;
    L141:
        boolean r47 = true;
        r18.putBoolean("enter_from_effect_ad", true);
        r18.putSerializable("live_effect_ad_log_extra_map", r31);
    L143:
        r18.putBoolean("enter_from_inner_flow_ad", r47);
        Integer r48 = r7.innerAfterTrackSeconds;
        if (r48 == null) goto L146;
        r18.putInt("inner_flow_ad_delay_track_seconds", r48.intValue());
    L146:
        String r49 = r7.enterFromMerge;
        if (r49 != null) goto L149;
    L152:
        boolean r50 = true;
    L153:
        if (r50 == true) goto L155;
        r18.putString("enter_from_ad_type", r7.enterFromMerge);
    L155:
        String r51 = r7.enterMethod;
        if (r51 != null) goto L158;
    L159:
        r11 = true;
    L160:
        if (r11 == true) goto L162;
        r18.putString("ad_enter_method", r7.enterMethod);
    L162:
        int r52 = k0.a;
        Intrinsics.checkNotNullParameter(r18, "bundle");
        Intrinsics.checkNotNullParameter(r7, "data");
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L195
        JSONArray r54 = new JSONArray();     // Catch: Throwable -> L195
        JSONArray r55 = new JSONArray();     // Catch: Throwable -> L195
        JSONObject r56 = new JSONObject();     // Catch: Throwable -> L195
        List r57 = r7.adFeedbackCategoryTags;     // Catch: Throwable -> L195
        if (r57 == null) goto L178;
        Iterator r58 = r57.iterator();     // Catch: Throwable -> L195
    L167:
        if (r58.hasNext() == false) goto L178;
        Object r59 = r58.next();     // Catch: Throwable -> L195
        if ((r59 instanceof Map) == true) goto L171;
        r59 = null;
    L171:
        Map r60 = (Map) r59;     // Catch: Throwable -> L195
        if (r60 == null) goto L167;
        JSONObject r61 = new JSONObject();     // Catch: Throwable -> L195
        Iterator r62 = r60.entrySet().iterator();     // Catch: Throwable -> L195
    L175:
        if (r62.hasNext() == false) goto L177;
        Map.Entry r63 = (Map.Entry) r62.next();     // Catch: Throwable -> L195
        r61.put((String) r63.getKey(), String.valueOf(r63.getValue()));     // Catch: Throwable -> L195
        goto L175
    L177:
        r54.put(r61);     // Catch: Throwable -> L195
    L178:
        List r64 = r7.adNewFeedbackTags;     // Catch: Throwable -> L195
        if (r64 == null) goto L193;
        Iterator r65 = r64.iterator();     // Catch: Throwable -> L195
    L182:
        if (r65.hasNext() == false) goto L193;
        Object r66 = r65.next();     // Catch: Throwable -> L195
        if ((r66 instanceof Map) == true) goto L186;
        r66 = null;
    L186:
        Map r67 = (Map) r66;     // Catch: Throwable -> L195
        if (r67 == null) goto L182;
        JSONObject r68 = new JSONObject();     // Catch: Throwable -> L195
        Iterator r69 = r67.entrySet().iterator();     // Catch: Throwable -> L195
    L190:
        if (r69.hasNext() == false) goto L192;
        Map.Entry r70 = (Map.Entry) r69.next();     // Catch: Throwable -> L195
        r68.put((String) r70.getKey(), String.valueOf(r70.getValue()));     // Catch: Throwable -> L195
        goto L190
    L192:
        r55.put(r68);     // Catch: Throwable -> L195
    L193:
        r56.put("category_detail", r54);     // Catch: Throwable -> L195
        r56.put("new_filter_words", r55);     // Catch: Throwable -> L195
        k0.b(r18, r56.toString());     // Catch: Throwable -> L195
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L195
        return;
    L195:
        th = move-exception;
        Result.Companion r71 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L158:
        if (r51.length() != 0) goto L160;
    L149:
        if (r49.length() == 0) goto L152;
        r50 = false;
        goto L153
    L139:
        if (r46.intValue() != 2) goto L141;
    L142:
        r47 = true;
        r18.putBoolean("enter_from_dou_plus", true);
        r18.putSerializable("live_douplus_log_extra", r31);
    L101:
        r35 = "";
    L96:
        r33 = "";
        goto L97
    L89:
        if (r29.intValue() != 1) goto L91;
        r30 = true;
        goto L92
    L59:
        r21 = 0;
    L55:
        r5 = false;
        goto L56
    L48:
        if (r10.intValue() != 2) goto L50;
        r12 = true;
        goto L51
    L41:
        if (r3.intValue() != 1) goto L43;
        r4 = true;
    L71:
        th = move-exception;
        Result.Companion r72 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L22:
        if (r16.intValue() != 1) goto L24;
        r17 = true;
        goto L25
    L17:
        r15 = null;
    L30:
        e = move-exception;
        Logger.e(e.getMessage());
        goto L32
    L222:
        return;
    L220:
        return;
    L221:
        return;
    }
}
