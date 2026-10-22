package com.ss.android.ugc.aweme.discover.mixfeed;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.discover.commodity.utils.GsonToArrayKt;
import com.ss.android.ugc.aweme.discover.commodity.utils.GsonUtil;
import com.ss.android.ugc.aweme.discover.commodity.utils.Objects;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0002{|B\t\b\u0016¢\u0006\u0004\by\u0010zJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000fR$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0016\u0010$\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001eR,\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b,\u0010-R \u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u0010&R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u0010\"R\u0018\u00101\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u0010\u0019R\u0018\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u0010\u0019R\u0018\u00103\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u0010\u0019R\u0018\u00106\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u0010\u0019R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u0010\u0019R\u0018\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b;\u0010:R&\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b<\u0010\u0017R\u0016\u0010=\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b=\u0010\"R\u0016\u0010>\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b>\u0010\u001eR\u0016\u0010?\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b?\u0010\u001eR\u0018\u0010@\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b@\u0010\u0019R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bD\u0010-R\u0016\u0010E\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bE\u0010\u001eR$\u0010F\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0019\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010Q\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010R\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0019\u001a\u0004\bS\u0010H\"\u0004\bT\u0010JR\u0018\u0010U\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bU\u0010\u0019R\"\u0010V\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010\u001e\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\"R\u0016\u0010\\\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\\\u0010\"R$\u0010`\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0019\u001a\u0004\b^\u0010H\"\u0004\b_\u0010JR0\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0017\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR4\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010(\"\u0004\bh\u0010*R\u0013\u0010l\u001a\u0004\u0018\u00010i8F¢\u0006\u0006\u001a\u0004\bj\u0010kR$\u0010n\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0011\u0010t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0013\u0010x\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\bv\u0010w¨\u0006}"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;", "Ljava/io/Serializable;", "", "", "isAwemeMix", "", "setAwemeListElDirty", "", "", "awemeList", "", "Lcom/ss/android/ugc/aweme/feed/model/Aweme;", "transformAweme", "other", "equals", "", "hashCode", "clone", "hydrateType", "setHydrateType", "", "", "loadMoreInfo", "Ljava/util/Map;", "rawData", "Ljava/lang/String;", "schema", "customSchema", "bulletSchema", "height", "I", "width", "originType", "hasVideo", "Z", "cardTypeName", "cardHeight", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/List;", "getAwemeListRaw", "()Ljava/util/List;", "setAwemeListRaw", "(Ljava/util/List;)V", "awemeListRaw", "notInjectAwemeList", "Ljava/lang/Boolean;", "Lcom/google/gson/JsonElement;", "awemeListElement", "isSSR", "templateSource", "hydrateSource", "ssrVersion", "Ljava/lang/Integer;", "ssrTemplateKey", "hydrateUrl", "geckoVersion", "", "minGeckoVersion", "Ljava/lang/Long;", "maxGeckoVersion", "pdpInfo", "isAladdin", "detailIndex", "adStyleType", "adShowFailRefer", "Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchAdDynamicPatchData;", "searchAdDynamicPatchData", "Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchAdDynamicPatchData;", "staticCardNotPlay", "total", "subCardName", "getSubCardName", "()Ljava/lang/String;", "setSubCardName", "(Ljava/lang/String;)V", "c", "J", "getCostAtMainThreadParsingAwemeList", "()J", "setCostAtMainThreadParsingAwemeList", "(J)V", "costAtMainThreadParsingAwemeList", "parentComponentType", "getParentComponentType", "setParentComponentType", "rawDataDiff", "statusCode", "getStatusCode", "()I", "setStatusCode", "(I)V", "isGetedAweme", "isPatchUpdate", "e", "getGeckoTemplateSource", "setGeckoTemplateSource", "geckoTemplateSource", "rawDataPatch", "getRawDataPatch", "()Ljava/util/Map;", "setRawDataPatch", "(Ljava/util/Map;)V", "value", "getAwemeList", "setAwemeList", "Lcom/ss/android/ugc/aweme/feed/model/AwemeRawAd;", "getAwemeRawAd", "()Lcom/ss/android/ugc/aweme/feed/model/AwemeRawAd;", "awemeRawAd", "Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch$IBulletContainerWithData;", "bulletContainerWithData", "Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch$IBulletContainerWithData;", "getBulletContainerWithData", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch$IBulletContainerWithData;", "setBulletContainerWithData", "(Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch$IBulletContainerWithData;)V", "isSSRValue", "()Z", "getHydrateTypeValue", "()Ljava/lang/Integer;", "hydrateTypeValue", "<init>", "()V", "Companion", "IBulletContainerWithData", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public class DynamicPatch implements Serializable, Cloneable {
    public static final String CARD_COMMODITY_BRAND_AD_ECOM_V2 = "commodity_brand_ad_ecom_v2";
    public static final String CARD_TYPE_ECOM_LIVE_TAB_SINGLE = "ecom_live_tab_single";
    public static final String CARD_TYPE_ECOM_SHOP_TAB_SINGLE = "ecom_shop_tab_single";
    public static final String CARD_TYPE_KIWI_HOTSPOT = "kiwi_hotspot";
    public static final Companion Companion = null;
    public static final String KEY_AD_DATA = "ad_data";
    public static final String KEY_AD_MODULE_INFO = "ad_module_info";
    public static final String RAW_AD_DATA = "raw_ad_data";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient List<? extends Object> f450475a;

    @SerializedName("ad_show_fail_refer")
    public String adShowFailRefer;

    @SerializedName("ad_style_type")
    public int adStyleType;

    @SerializedName("aweme_list")
    public List<JsonElement> awemeListElement;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient List<Aweme> f450476b;

    @SerializedName("bullet_schema")
    public String bulletSchema;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient long f450477c;

    @SerializedName("card_height")
    public int cardHeight;

    @SerializedName("card_type_name")
    public String cardTypeName;

    @SerializedName("custom_schema")
    public String customSchema;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient AwemeRawAd f450478d;

    @SerializedName("detail_index")
    public int detailIndex;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient String f450479e;

    @SerializedName("gecko_version")
    public String geckoVersion;

    @SerializedName("has_video")
    public boolean hasVideo;

    @SerializedName("height")
    public int height;

    @SerializedName("hydrate_source")
    public String hydrateSource;

    @SerializedName("hydrate_type")
    private Integer hydrateType;

    @SerializedName("hydrate_url")
    public String hydrateUrl;

    @SerializedName(a.KEY_IS_ALADDIN)
    public boolean isAladdin;
    private boolean isGetedAweme;
    public boolean isPatchUpdate;

    @SerializedName("is_ssr")
    private boolean isSSR;

    @SerializedName("load_more_info")
    public Map<String, ? extends Object> loadMoreInfo;

    @SerializedName("max_gecko_version")
    public Long maxGeckoVersion;

    @SerializedName("min_gecko_version")
    public Long minGeckoVersion;

    @SerializedName("not_inject_aweme_list")
    public Boolean notInjectAwemeList;

    @SerializedName(a.KEY_ORIGIN_TYPE)
    public int originType;
    private String parentComponentType;

    @SerializedName("pdp_info")
    public Map<String, String> pdpInfo;

    @SerializedName(EventConstant.Key.RAW_DATA)
    public String rawData;
    public String rawDataDiff;
    private Map<String, ? extends Object> rawDataPatch;

    @SerializedName("schema")
    public String schema;

    @SerializedName(KEY_AD_DATA)
    public SearchAdDynamicPatchData searchAdDynamicPatchData;

    @SerializedName("ssr_template_key")
    public String ssrTemplateKey;

    @SerializedName("ssr_version")
    public Integer ssrVersion;

    @SerializedName("static_card_not_play")
    public Boolean staticCardNotPlay;
    private int statusCode;
    private String subCardName;

    @SerializedName("template_source")
    public String templateSource;
    public int total;

    @SerializedName("width")
    public int width;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch$Companion;", "", "()V", "CARD_COMMODITY_BRAND_AD_ECOM_V2", "", "CARD_TYPE_AWEME_MIX", "CARD_TYPE_ECOM_LIVE_TAB_SINGLE", "CARD_TYPE_ECOM_SHOP_TAB_SINGLE", "CARD_TYPE_KIWI_HOTSPOT", "KEY_AD_DATA", "KEY_AD_MODULE_INFO", "RAW_AD_DATA", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch$IBulletContainerWithData;", "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public interface IBulletContainerWithData {
    }

    static {
        Companion = new Companion(0);
    }

    public DynamicPatch() {
    }

    public final IBulletContainerWithData getBulletContainerWithData() {
        return null;
    }

    public final void setAwemeListElDirty() {
        this.f450475a = null;
        this.f450476b = null;
    }

    public final void setBulletContainerWithData(IBulletContainerWithData r100) {
    }

    public final List<Aweme> getAwemeList() {
        if (this.f450476b != null) goto L12;
        if (this.awemeListElement == null) goto L12;
        long r100 = System.currentTimeMillis();
        this.f450476b = transformAweme(this.awemeListElement);
        long r101 = System.currentTimeMillis() - r100;
        if (r101 <= 0) goto L12;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L12;
        this.f450477c += r101;
    L12:
        return this.f450476b;
    }

    public final List<Object> getAwemeListRaw() {
        if (this.f450475a != null) goto L13;
        List<JsonElement> r100 = this.awemeListElement;
        if (r100 == null) goto L7;
        List<? extends Object> r101 = a(r100);
    L11:
        this.f450475a = r101;
        goto L13
    L7:
        List<Aweme> r102 = this.f450476b;
        if (r102 == null) goto L10;
        r101 = a(r102);
        goto L11
    L10:
        r101 = null;
    L13:
        return this.f450475a;
    }

    public final Integer getHydrateTypeValue() {
        if (this.isSSR == true) goto L6;
        return null;
    L6:
        Integer r100 = this.hydrateType;
        if (r100 == null) goto L9;
        if (r100 != null) goto L13;
    L14:
        Integer r101 = this.hydrateType;
        if (r101 == null) goto L20;
        if (r101.intValue() != 2) goto L20;
    L22:
        return this.hydrateType;
    L20:
        return 1;
    L13:
        if (r100.intValue() == 1) goto L22;
    L9:
        return 1;
    }

    public int hashCode() {
        String r100 = this.rawData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.schema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.customSchema;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bulletSchema;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cardTypeName;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.height;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean isAwemeMix() {
        return Intrinsics.areEqual("aweme_mix", this.cardTypeName);
    }

    public final boolean isSSRValue() {
        if (this.isSSR == false) goto L17;
        String r100 = this.templateSource;
        if (r100 == null) goto L17;
        if (TextUtils.isEmpty(r100) == true) goto L17;
        String r101 = this.hydrateSource;
        if (r101 != null) goto L11;
    L12:
        String r102 = this.hydrateUrl;
        if (r102 == null) goto L17;
        if (TextUtils.isEmpty(r102) == true) goto L17;
    L16:
        return true;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L16;
    L17:
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final AwemeRawAd getAwemeRawAd() {
        if (this.isGetedAweme == true) goto L14;
        this.isGetedAweme = true;
        JSONObject r100 = new JSONObject(this.rawData);     // Catch: Exception -> L11
        if (r100.has("raw_ad_data") == false) goto L8;
        GsonUtil r101 = GsonUtil.f450371a;     // Catch: Exception -> L11
        String r102 = r100.optString("raw_ad_data");     // Catch: Exception -> L11
        r101.getClass();     // Catch: Exception -> L11
        AwemeRawAd r103 = (AwemeRawAd) GsonUtil.a(r102, AwemeRawAd.class);     // Catch: Exception -> L11
    L9:
        this.f450478d = r103;     // Catch: Exception -> L11
        goto L14
    L8:
        GsonUtil r104 = GsonUtil.f450371a;     // Catch: Exception -> L11
        String r105 = this.rawData;     // Catch: Exception -> L11
        r104.getClass();     // Catch: Exception -> L11
        r103 = (AwemeRawAd) GsonUtil.a(r105, AwemeRawAd.class);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        return this.f450478d;
    }

    public final long getCostAtMainThreadParsingAwemeList() {
        return this.f450477c;
    }

    public final String getGeckoTemplateSource() {
        return this.f450479e;
    }

    public final String getParentComponentType() {
        return this.parentComponentType;
    }

    public final Map<String, Object> getRawDataPatch() {
        return this.rawDataPatch;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getSubCardName() {
        return this.subCardName;
    }

    public final List<Object> a(List<? extends Object> r100) {
        List<Object> r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        long r102 = System.currentTimeMillis();
        r101 = GsonToArrayKt.a(r100);     // Catch: Throwable -> L12 AssertionError -> L19 Exception -> L24
        long r103 = System.currentTimeMillis() - r102;
        if (r103 > 0) goto L10;
    L29:
        return r101;
    L10:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L29;
    L11:
        this.f450477c += r103;
        goto L29
    L19:
        r103 = System.currentTimeMillis() - r102;
        if (r103 <= 0) goto L29;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L29;
    L24:
        r103 = System.currentTimeMillis() - r102;
        if (r103 <= 0) goto L29;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L29;
    L12:
        th = move-exception;
        long r104 = System.currentTimeMillis() - r102;
        if (r104 > 0) goto L16;
    L18:
        throw th;
    L16:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L18;
        this.f450477c += r104;
        goto L18
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DynamicPatch) == true) goto L8;
        return false;
    L8:
        DynamicPatch r101 = (DynamicPatch) r100;
        if (this.height == r101.height) goto L11;
        return false;
    L11:
        Objects.Companion r102 = Objects.f450380a;
        String r103 = this.rawData;
        String r104 = r101.rawData;
        r102.getClass();
        if (Objects.Companion.a(r103, r104) == true) goto L15;
        return false;
    L15:
        if (Objects.Companion.a(this.cardTypeName, r101.cardTypeName) == true) goto L18;
        return false;
    L18:
        if (Objects.Companion.a(this.schema, r101.schema) == true) goto L21;
        return false;
    L21:
        if (Objects.Companion.a(this.bulletSchema, r101.bulletSchema) == true) goto L24;
        return false;
    L24:
        if (Objects.Companion.a(this.customSchema, r101.customSchema) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final void setAwemeList(List<Aweme> r100) {
        this.f450476b = r100;
    }

    public final void setAwemeListRaw(List<? extends Object> r100) {
        this.f450475a = r100;
    }

    public final void setCostAtMainThreadParsingAwemeList(long r100) {
        this.f450477c = r100;
    }

    public final void setGeckoTemplateSource(String r100) {
        this.f450479e = r100;
    }

    public final void setHydrateType(int r100) {
        this.hydrateType = Integer.valueOf(r100);
    }

    public final void setParentComponentType(String r100) {
        this.parentComponentType = r100;
    }

    public final void setRawDataPatch(Map<String, ? extends Object> r100) {
        this.rawDataPatch = r100;
    }

    public final void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public final void setSubCardName(String r100) {
        this.subCardName = r100;
    }

    public final List<Aweme> transformAweme(List<? extends Object> r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        Gson r101 = new Gson();     // Catch: Exception -> L11
        List r102 = (List) r101.fromJson(r101.toJson(r100), new AnonymousClass1().getType());     // Catch: Exception -> L11
        if (r102 == null) goto L14;
        List r103 = CollectionsKt.filterNotNull(r102);     // Catch: Exception -> L11
        if (r103 == null) goto L15;
        return CollectionsKt.toMutableList(r103);
    L15:
        return null;
    L14:
        return null;
    L16:
        return null;
    }
}
