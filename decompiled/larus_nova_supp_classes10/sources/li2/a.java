package li2;

import com.bytedance.android.ec.model.g;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007R\u001c\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010R\u001c\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u0010R\u001c\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010¨\u0006)"}, d2 = {"Lli2/a;", "Lcom/bytedance/android/ec/model/g;", "", "Lcom/google/gson/JsonObject;", "itemCards", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "cursor", "I", "getCursor", "()I", "abTest", "Lcom/google/gson/JsonObject;", "getAbTest", "()Lcom/google/gson/JsonObject;", "adParams", "a", "", "hasMore", "Z", "getHasMore", "()Z", "tabs", "getTabs", "", "showTabId", "Ljava/lang/String;", "getShowTabId", "()Ljava/lang/String;", "multiTabs", "e", "extra", "c", "extraV2", "getExtraV2", "bgConfig", "b", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends g {

    @SerializedName("ab")
    private final JsonObject abTest;

    @SerializedName("ad")
    private final JsonObject adParams;

    @SerializedName("bg_config")
    private final JsonObject bgConfig;

    @SerializedName("cursor")
    private final int cursor;

    @SerializedName("extra")
    private final JsonObject extra;

    @SerializedName("extra_v2")
    private final JsonObject extraV2;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("item_cards")
    private final List<JsonObject> itemCards;

    @SerializedName("multi_tabs")
    private final List<JsonObject> multiTabs;

    @SerializedName("show_tab_id")
    private final String showTabId;

    @SerializedName("tabs")
    private final List<JsonObject> tabs;

    public a() {
    }

    public final JsonObject a() {
        return this.adParams;
    }

    public final JsonObject b() {
        return this.bgConfig;
    }

    public final JsonObject c() {
        return this.extra;
    }

    public final List<JsonObject> d() {
        return this.itemCards;
    }

    public final List<JsonObject> e() {
        return this.multiTabs;
    }
}
