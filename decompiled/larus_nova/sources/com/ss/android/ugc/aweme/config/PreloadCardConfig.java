package com.ss.android.ugc.aweme.config;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\bH\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0016\u0010\u001f\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/aweme/config/PreloadCardConfig;", "Ljava/io/Serializable;", "()V", "cardType", "", "getCardType", "()I", "cardTypeName", "", "getCardTypeName", "()Ljava/lang/String;", "firstScreenIndexLimit", "getFirstScreenIndexLimit", "kevaSchema", "getKevaSchema", "setKevaSchema", "(Ljava/lang/String;)V", "noUseRecyclerViewPool", "", "getNoUseRecyclerViewPool", "()Z", "onlyPreloadTemplate", "getOnlyPreloadTemplate", "preloadCount", "getPreloadCount", "rawData", "getRawData", "rawDataSettingKey", "getRawDataSettingKey", "schema", "getSchema", "useAsync", "getUseAsync", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class PreloadCardConfig implements Serializable {

    @SerializedName(a.KEY_CARD_TYPE)
    private final int cardType;

    @SerializedName("card_type_name")
    private final String cardTypeName;

    @SerializedName("first_screen_index_limit")
    private final int firstScreenIndexLimit;
    private String kevaSchema;

    @SerializedName("no_use_recycler_pool")
    private final boolean noUseRecyclerViewPool;

    @SerializedName("only_preload_template")
    private final int onlyPreloadTemplate;

    @SerializedName("preload_count")
    private final int preloadCount;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private final String rawData;

    @SerializedName("raw_data_setting_key")
    private final String rawDataSettingKey;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("use_async")
    private final boolean useAsync;

    public String toString() {
        return "PreloadCardConfig(cardTypeName=" + this.cardTypeName + ", preloadCount=" + this.preloadCount + ", firstScreenIndexLimit=" + this.firstScreenIndexLimit + ", schema=" + this.schema + ", rawData=" + this.rawData + ", rawDataSettingKey=" + this.rawDataSettingKey + ", cardType=" + this.cardType + ')';
    }

    public PreloadCardConfig() {
        this.useAsync = true;
    }

    public final int getCardType() {
        return this.cardType;
    }

    public final String getCardTypeName() {
        return this.cardTypeName;
    }

    public final int getFirstScreenIndexLimit() {
        return this.firstScreenIndexLimit;
    }

    public final String getKevaSchema() {
        return this.kevaSchema;
    }

    public final boolean getNoUseRecyclerViewPool() {
        return this.noUseRecyclerViewPool;
    }

    public final int getOnlyPreloadTemplate() {
        return this.onlyPreloadTemplate;
    }

    public final int getPreloadCount() {
        return this.preloadCount;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getRawDataSettingKey() {
        return this.rawDataSettingKey;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean getUseAsync() {
        return this.useAsync;
    }

    public final void setKevaSchema(String r100) {
        this.kevaSchema = r100;
    }
}
