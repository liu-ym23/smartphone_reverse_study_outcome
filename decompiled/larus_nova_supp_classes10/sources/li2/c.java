package li2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lli2/c;", "", "Lcom/google/gson/JsonObject;", "guessYourLikeList", "Lcom/google/gson/JsonObject;", "getGuessYourLikeList", "()Lcom/google/gson/JsonObject;", "setGuessYourLikeList", "(Lcom/google/gson/JsonObject;)V", "liveSquare", "getLiveSquare", "setLiveSquare", "tabList", "getTabList", "setTabList", "liveApp", "getLiveApp", "setLiveApp", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("GYLList")
    private JsonObject guessYourLikeList;

    @SerializedName("LIVE_APP")
    private JsonObject liveApp;

    @SerializedName("live_square")
    private JsonObject liveSquare;

    @SerializedName("TabList")
    private JsonObject tabList;

    public static final class a {
    }

    static {
    }

    public c(li2.a r21) {
        Intrinsics.checkNotNullParameter(r21, "origin");
        this.guessYourLikeList = new JsonObject();
        List<JsonObject> r1 = r21.d();
        Integer r4 = 0;
        String r7 = "avatar";
        String r8 = "nickname";
        if (r1 == null) goto L59;
        Iterator r2 = r1.iterator();
        int r14 = 0;
    L6:
        if (r2.hasNext() == false) goto L58;
        JsonObject r15 = (JsonObject) r2.next();
        JsonObject r3 = new JsonObject();
        Iterator r16 = r2;
        r3.add(LocationMonitorConst.TYPE, r15.get(LocationMonitorConst.TYPE));
        r3.addProperty("__uid__", Integer.valueOf(r14));
        JsonObject r5 = new JsonObject();
        JsonObject r6 = r15.getAsJsonObject("live");
        if (r6 != null) goto L10;
        r4 = r4;
        r7 = r7;
        r8 = r8;
    L57:
        r2 = r16;
        r4 = r4;
        r8 = r8;
        r7 = r7;
        goto L6
    L10:
        r5.add("raw_live", r6);
        JsonObject r9 = r15.getAsJsonObject("user");
        if (r9 == null) goto L18;
        JsonObject r17 = new JsonObject();
        r17.add("nick_name", r9.get(r8));
        JsonObject r10 = r9.getAsJsonObject(r7);
        if (r10 == null) goto L15;
        JsonArray r11 = r10.getAsJsonArray("url_list");
    L16:
        r17.add(r7, a(r11));
        JsonArray r12 = r9.getAsJsonArray("relation_tags");
        r17.add("relation", a(r12));
        r17.add("relation_tag", a(r12));
        r17.add("identity_tag", a(r9.getAsJsonArray("identity_tags")));
        r17.add("viewers", r6.get("number"));
        r5.add("user", r17);
        goto L18
    L15:
        r11 = null;
    L18:
        JsonObject r13 = new JsonObject();
        r13.add("title", r6.get("title"));
        r13.add("room_id", r6.get("room_id"));
        JsonObject r18 = r6.getAsJsonObject("cover");
        if (r18 == null) goto L21;
        JsonArray r19 = r18.getAsJsonArray("url_list");
    L22:
        r13.add("cover", a(r19));
        r13.add("stream_data", r6.get("stream_data"));
        r13.add("status", r6.get("status"));
        r13.add("tags", r6.get("tags"));
        r13.add("qualities", r6.get("qualities"));
        JsonObject r20 = r6.getAsJsonObject("platform_text_activity");
        if (r20 == null) goto L25;
        JsonObject r22 = r20.getAsJsonObject("icon");
    L26:
        if (r22 == null) goto L46;
        r13.add("activity_label", a(r22.getAsJsonArray("url_list")));
        JsonObject r23 = new JsonObject();
        JsonElement r24 = r22.get("width");     // Catch: NumberFormatException -> L35
        if (r24 == null) goto L34;
        Number r25 = r24.getAsNumber();     // Catch: NumberFormatException -> L35
        if (r25 == null) goto L34;
        Integer r26 = Integer.valueOf(r25.intValue());     // Catch: NumberFormatException -> L35
    L36:
        r23.addProperty("width", r26);
        JsonElement r27 = r22.get("height");     // Catch: NumberFormatException -> L44
        if (r27 == null) goto L43;
        Number r28 = r27.getAsNumber();     // Catch: NumberFormatException -> L44
        if (r28 == null) goto L43;
        Integer r29 = Integer.valueOf(r28.intValue());     // Catch: NumberFormatException -> L44
    L45:
        r23.addProperty("height", r29);
        Unit r30 = Unit.INSTANCE;
        r13.add("activity_label_size", r23);
    L43:
        r29 = null;
    L44:
        r29 = r4;
    L34:
        r26 = null;
    L35:
        r26 = r4;
    L46:
        r5.add("live", r13);
        JsonObject r31 = r21.a();
        if (r31 == null) goto L53;
        JsonObject r32 = r31.getAsJsonObject("raw_data");
        if (r32 == null) goto L53;
        JsonObject r33 = r32.getAsJsonObject("raw_ad_data");
        if (r33 == null) goto L53;
        r5.add("ad", r33);
    L53:
        r3.add("card", r5);
        JsonObject r34 = this.guessYourLikeList;
        if (r34 == null) goto L56;
        r34.add("feedUI_item" + r14, r3);
    L56:
        r14 = r14 + 1;
        goto L57
    L25:
        r22 = null;
        goto L26
    L21:
        r19 = null;
        goto L22
    L58:
        String r110 = r7;
        String r111 = r8;
    L60:
        JsonObject r35 = this.guessYourLikeList;
        if (r35 == null) goto L63;
        r35.addProperty("feedUI_feedLength", Integer.valueOf(r14));
    L63:
        JsonArray r36 = new JsonArray();
        List<JsonObject> r37 = r21.e();
        if (r37 == null) goto L96;
        Iterator<T> r38 = r37.iterator();
    L67:
        if (r38.hasNext() == false) goto L96;
        JsonObject r39 = (JsonObject) r38.next();
        if (r39.getAsJsonObject("tab_resource") != null) goto L73;
        if ((!Intrinsics.areEqual(r39.get("name").getAsString(), "activity_tab")) == false) goto L73;
        r36.add(r39);
    L73:
        JsonObject r112 = new JsonObject();
        r112.add("id", r39.get("id"));
        JsonObject r40 = r39.getAsJsonObject("tab_resource");
        if (r40 == null) goto L95;
        r112.add("name", r40.get("name"));
        r112.add("tag_url", r40.get("tag_url"));
        r112.add("icon_s", r40.get("tag_url_1"));
        r112.add("icon_layer", r40.get("bg_url_1"));
        r112.add("icon_layer_s", r40.get("bg_url_2"));
        JsonElement r41 = r40.get("extra");
        if (r41 == null) goto L95;
        JsonObject r42 = (JsonObject) new Gson().fromJson(r41.getAsString(), JsonObject.class);     // Catch: Exception -> L133
        r112.add("tab_plan_id", r42.get("ecom_plan_id"));
        r112.add("underscore_color", r42.get("underscore_color"));
        r112.add("tab_category_type", r42.get("category_type"));
        JsonElement r43 = r42.get("tab_width");     // Catch: NumberFormatException -> L132
        if (r43 == null) goto L85;
        Number r44 = r43.getAsNumber();     // Catch: NumberFormatException -> L132
        if (r44 == null) goto L85;
        int r45 = r44.intValue();     // Catch: NumberFormatException -> L132
    L86:
        r112.addProperty("width", Integer.valueOf(r45));
        JsonElement r46 = r42.get("tab_height");     // Catch: NumberFormatException -> L131
        if (r46 == null) goto L93;
        Number r47 = r46.getAsNumber();     // Catch: NumberFormatException -> L131
        if (r47 == null) goto L93;
        int r48 = r47.intValue();     // Catch: NumberFormatException -> L131
    L94:
        r112.addProperty("height", Integer.valueOf(r48));
    L93:
        r48 = 30;
    L85:
        r45 = 56;
    L95:
        r36.add(r112);
    L96:
        JsonObject r49 = new JsonObject();
        r49.add("tabs", r36);
        Unit r50 = Unit.INSTANCE;
        this.tabList = r49;
        this.liveSquare = new JsonObject();
        JsonArray r51 = new JsonArray();
        List<JsonObject> r52 = r21.d();
        if (r52 == null) goto L126;
        Iterator<T> r53 = r52.iterator();
    L100:
        if (r53.hasNext() == false) goto L126;
        JsonObject r54 = (JsonObject) r53.next();
        JsonObject r55 = new JsonObject();
        JsonObject r113 = r54.getAsJsonObject("live");
        if (r113 == null) goto L100;
        JsonObject r56 = r54.getAsJsonObject("user");
        if (r56 == null) goto L100;
        r55.add("room_id", r113.get("room_id"));
        r55.addProperty("liked_count", "NaNw");
        r55.addProperty("follow_count", "NaNw");
        r55.addProperty("_is_recommend", Boolean.TRUE);
        JsonObject r114 = r113.getAsJsonObject("link");
        if (r114 == null) goto L110;
        JsonElement r115 = r114.get("live");
    L111:
        r55.add("link", r115);
        String r116 = r111;
        r55.add("name", r56.get(r116));
        r55.add("id", r56.get("id"));
        r55.add("is_live", r56.get("is_live"));
        JsonElement r117 = r56.get("is_followed");
        if (r117 != null) goto L114;
    L116:
        int r118 = 0;
    L117:
        r55.addProperty("follow_status", Integer.valueOf(r118));
        String r119 = r110;
        JsonObject r57 = r56.getAsJsonObject(r119);
        if (r57 == null) goto L120;
        JsonArray r58 = r57.getAsJsonArray("url_list");
    L121:
        r55.add(r119, a(r58));
        JsonObject r59 = r21.c();
        if (r59 == null) goto L124;
        JsonElement r60 = r59.get("logid");
    L125:
        r55.add("request_id", r60);
        r51.add(r55);
        r111 = r116;
        r110 = r119;
        goto L100
    L124:
        r60 = null;
        goto L125
    L120:
        r58 = null;
        goto L121
    L114:
        if (r117.getAsBoolean() != true) goto L116;
        r118 = 1;
        goto L117
    L110:
        r115 = null;
    L126:
        JsonObject r61 = this.liveSquare;
        if (r61 == null) goto L129;
        r61.add("renderList", r51);
    L129:
        this.liveApp = r21.b();
        return;
    L59:
        r110 = "avatar";
        r111 = "nickname";
        r14 = 0;
        goto L60
    }

    public static JsonElement a(JsonArray r1) {
        if (r1 != null) goto L6;
        return JsonNull.INSTANCE;
    L6:
        if (r1.size() > 0) goto L10;
        return JsonNull.INSTANCE;
    L10:
        return r1.get(0);
    }
}
