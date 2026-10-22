package li2;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lli2/c;", "", "Lcom/google/gson/JsonObject;", "guessYourLikeList", "Lcom/google/gson/JsonObject;", "getGuessYourLikeList", "()Lcom/google/gson/JsonObject;", "setGuessYourLikeList", "(Lcom/google/gson/JsonObject;)V", "liveSquare", "getLiveSquare", "setLiveSquare", "tabList", "getTabList", "setTabList", "liveApp", "getLiveApp", "setLiveApp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public c(li2.a r210) {
        Intrinsics.checkNotNullParameter(r210, PlayerResolution.SDKKEY.ORIGIN);
        this.guessYourLikeList = new JsonObject();
        List<JsonObject> r100 = r210.d();
        Integer r101 = 0;
        String r102 = "avatar";
        String r103 = InstantPlayContext.NICKNAME;
        if (r100 == null) goto L59;
        Iterator r104 = r100.iterator();
        int r110 = 0;
    L6:
        if (r104.hasNext() == false) goto L58;
        JsonObject r111 = (JsonObject) r104.next();
        JsonObject r105 = new JsonObject();
        Iterator r112 = r104;
        r105.add("type", r111.get("type"));
        r105.addProperty("__uid__", Integer.valueOf(r110));
        JsonObject r106 = new JsonObject();
        JsonObject r107 = r111.getAsJsonObject("live");
        if (r107 != null) goto L10;
        r101 = r101;
        r102 = r102;
        r103 = r103;
    L57:
        r104 = r112;
        r101 = r101;
        r103 = r103;
        r102 = r102;
        goto L6
    L10:
        r106.add("raw_live", r107);
        JsonObject r108 = r111.getAsJsonObject("user");
        if (r108 == null) goto L18;
        JsonObject r113 = new JsonObject();
        r113.add("nick_name", r108.get(r103));
        JsonObject r109 = r108.getAsJsonObject(r102);
        if (r109 == null) goto L15;
        JsonArray r114 = r109.getAsJsonArray(ScoreTags.STAR_URL_LIST);
    L16:
        r113.add(r102, a(r114));
        JsonArray r115 = r108.getAsJsonArray("relation_tags");
        r113.add("relation", a(r115));
        r113.add("relation_tag", a(r115));
        r113.add("identity_tag", a(r108.getAsJsonArray("identity_tags")));
        r113.add("viewers", r107.get("number"));
        r106.add("user", r113);
        goto L18
    L15:
        r114 = null;
    L18:
        JsonObject r116 = new JsonObject();
        r116.add("title", r107.get("title"));
        r116.add("room_id", r107.get("room_id"));
        JsonObject r117 = r107.getAsJsonObject("cover");
        if (r117 == null) goto L21;
        JsonArray r118 = r117.getAsJsonArray(ScoreTags.STAR_URL_LIST);
    L22:
        r116.add("cover", a(r118));
        r116.add(MiniAppConstants.KEY_MINI_APP_STREAM_DATA, r107.get(MiniAppConstants.KEY_MINI_APP_STREAM_DATA));
        r116.add("status", r107.get("status"));
        r116.add(PromotionProductPrivilegesStruct.TAGS, r107.get(PromotionProductPrivilegesStruct.TAGS));
        r116.add("qualities", r107.get("qualities"));
        JsonObject r119 = r107.getAsJsonObject("platform_text_activity");
        if (r119 == null) goto L25;
        JsonObject r120 = r119.getAsJsonObject("icon");
    L26:
        if (r120 == null) goto L46;
        r116.add(com.bytedance.android.ec.core.event.a.KEY_ACTIVITY_LABEL, a(r120.getAsJsonArray(ScoreTags.STAR_URL_LIST)));
        JsonObject r121 = new JsonObject();
        JsonElement r122 = r120.get("width");     // Catch: NumberFormatException -> L35
        if (r122 == null) goto L34;
        Number r123 = r122.getAsNumber();     // Catch: NumberFormatException -> L35
        if (r123 == null) goto L34;
        Integer r124 = Integer.valueOf(r123.intValue());     // Catch: NumberFormatException -> L35
    L36:
        r121.addProperty("width", r124);
        JsonElement r125 = r120.get("height");     // Catch: NumberFormatException -> L44
        if (r125 == null) goto L43;
        Number r126 = r125.getAsNumber();     // Catch: NumberFormatException -> L44
        if (r126 == null) goto L43;
        Integer r127 = Integer.valueOf(r126.intValue());     // Catch: NumberFormatException -> L44
    L45:
        r121.addProperty("height", r127);
        Unit r128 = Unit.INSTANCE;
        r116.add("activity_label_size", r121);
    L43:
        r127 = null;
    L44:
        r127 = r101;
    L34:
        r124 = null;
    L35:
        r124 = r101;
    L46:
        r106.add("live", r116);
        JsonObject r129 = r210.a();
        if (r129 == null) goto L53;
        JsonObject r130 = r129.getAsJsonObject(EventConstant.Key.RAW_DATA);
        if (r130 == null) goto L53;
        JsonElement r131 = r130.getAsJsonObject("raw_ad_data");
        if (r131 == null) goto L53;
        r106.add("ad", r131);
    L53:
        r105.add(BrowserDependency.UrlClickType.CARD, r106);
        JsonObject r132 = this.guessYourLikeList;
        if (r132 == null) goto L56;
        r132.add("feedUI_item" + r110, r105);
    L56:
        r110 = r110 + 1;
        goto L57
    L25:
        r120 = null;
        goto L26
    L21:
        r118 = null;
        goto L22
    L58:
        String r133 = r102;
        String r134 = r103;
    L60:
        JsonObject r135 = this.guessYourLikeList;
        if (r135 == null) goto L63;
        r135.addProperty("feedUI_feedLength", Integer.valueOf(r110));
    L63:
        JsonArray r136 = new JsonArray();
        List<JsonObject> r137 = r210.e();
        if (r137 == null) goto L96;
        Iterator<T> r138 = r137.iterator();
    L67:
        if (r138.hasNext() == false) goto L96;
        JsonObject r139 = (JsonObject) r138.next();
        if (r139.getAsJsonObject("tab_resource") != null) goto L73;
        if ((!Intrinsics.areEqual(r139.get("name").getAsString(), "activity_tab")) == false) goto L73;
        r136.add(r139);
    L73:
        JsonObject r140 = new JsonObject();
        r140.add("id", r139.get("id"));
        JsonObject r141 = r139.getAsJsonObject("tab_resource");
        if (r141 == null) goto L95;
        r140.add("name", r141.get("name"));
        r140.add("tag_url", r141.get("tag_url"));
        r140.add("icon_s", r141.get("tag_url_1"));
        r140.add("icon_layer", r141.get("bg_url_1"));
        r140.add("icon_layer_s", r141.get("bg_url_2"));
        JsonElement r142 = r141.get("extra");
        if (r142 == null) goto L95;
        JsonObject r143 = (JsonObject) new Gson().fromJson(r142.getAsString(), JsonObject.class);     // Catch: Exception -> L133
        r140.add("tab_plan_id", r143.get("ecom_plan_id"));
        r140.add("underscore_color", r143.get("underscore_color"));
        r140.add("tab_category_type", r143.get("category_type"));
        JsonElement r144 = r143.get("tab_width");     // Catch: NumberFormatException -> L132
        if (r144 == null) goto L85;
        Number r145 = r144.getAsNumber();     // Catch: NumberFormatException -> L132
        if (r145 == null) goto L85;
        int r146 = r145.intValue();     // Catch: NumberFormatException -> L132
    L86:
        r140.addProperty("width", Integer.valueOf(r146));
        JsonElement r147 = r143.get("tab_height");     // Catch: NumberFormatException -> L131
        if (r147 == null) goto L93;
        Number r148 = r147.getAsNumber();     // Catch: NumberFormatException -> L131
        if (r148 == null) goto L93;
        int r149 = r148.intValue();     // Catch: NumberFormatException -> L131
    L94:
        r140.addProperty("height", Integer.valueOf(r149));
    L93:
        r149 = 30;
    L85:
        r146 = 56;
    L95:
        r136.add(r140);
    L96:
        JsonObject r150 = new JsonObject();
        r150.add("tabs", r136);
        Unit r151 = Unit.INSTANCE;
        this.tabList = r150;
        this.liveSquare = new JsonObject();
        JsonArray r152 = new JsonArray();
        List<JsonObject> r153 = r210.d();
        if (r153 == null) goto L126;
        Iterator<T> r154 = r153.iterator();
    L100:
        if (r154.hasNext() == false) goto L126;
        JsonObject r155 = (JsonObject) r154.next();
        JsonObject r156 = new JsonObject();
        JsonObject r157 = r155.getAsJsonObject("live");
        if (r157 == null) goto L100;
        JsonObject r158 = r155.getAsJsonObject("user");
        if (r158 == null) goto L100;
        r156.add("room_id", r157.get("room_id"));
        r156.addProperty("liked_count", "NaNw");
        r156.addProperty("follow_count", "NaNw");
        r156.addProperty("_is_recommend", Boolean.TRUE);
        JsonObject r159 = r157.getAsJsonObject("link");
        if (r159 == null) goto L110;
        JsonElement r160 = r159.get("live");
    L111:
        r156.add("link", r160);
        String r161 = r134;
        r156.add("name", r158.get(r161));
        r156.add("id", r158.get("id"));
        r156.add("is_live", r158.get("is_live"));
        JsonElement r162 = r158.get("is_followed");
        if (r162 != null) goto L114;
    L116:
        int r163 = 0;
    L117:
        r156.addProperty("follow_status", Integer.valueOf(r163));
        String r164 = r133;
        JsonObject r165 = r158.getAsJsonObject(r164);
        if (r165 == null) goto L120;
        JsonArray r166 = r165.getAsJsonArray(ScoreTags.STAR_URL_LIST);
    L121:
        r156.add(r164, a(r166));
        JsonObject r167 = r210.c();
        if (r167 == null) goto L124;
        JsonElement r168 = r167.get(CronetDataStorageAccess.LOGID);
    L125:
        r156.add("request_id", r168);
        r152.add(r156);
        r134 = r161;
        r133 = r164;
        goto L100
    L124:
        r168 = null;
        goto L125
    L120:
        r166 = null;
        goto L121
    L114:
        if (r162.getAsBoolean() != true) goto L116;
        r163 = 1;
        goto L117
    L110:
        r160 = null;
    L126:
        JsonObject r169 = this.liveSquare;
        if (r169 == null) goto L129;
        r169.add("renderList", r152);
    L129:
        this.liveApp = r210.b();
        return;
    L59:
        r133 = "avatar";
        r134 = InstantPlayContext.NICKNAME;
        r110 = 0;
        goto L60
    }

    public static JsonElement a(JsonArray r100) {
        if (r100 != null) goto L6;
        return JsonNull.INSTANCE;
    L6:
        if (r100.size() > 0) goto L10;
        return JsonNull.INSTANCE;
    L10:
        return r100.get(0);
    }
}
