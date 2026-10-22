package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.mixfeed.SearchCardUiInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/RemoteCityFilterCardStruct;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "linkedText", "getLinkedText", "setLinkedText", "cityName", "getCityName", "setCityName", "cityCode", "getCityCode", "setCityCode", "conditionField", "getConditionField", "setConditionField", "conditionValue", "getConditionValue", "setConditionValue", "type", "getType", "setType", "", "childrenComponent", "Ljava/util/List;", "getChildrenComponent", "()Ljava/util/List;", "setChildrenComponent", "(Ljava/util/List;)V", "", "isPlaceHolder", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setPlaceHolder", "(Ljava/lang/Integer;)V", "Lcom/ss/android/ugc/aweme/discover/model/RemoteCityStyleConfig;", "styleConfig", "Lcom/ss/android/ugc/aweme/discover/model/RemoteCityStyleConfig;", "getStyleConfig", "()Lcom/ss/android/ugc/aweme/discover/model/RemoteCityStyleConfig;", "setStyleConfig", "(Lcom/ss/android/ugc/aweme/discover/model/RemoteCityStyleConfig;)V", "Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;", "uiInfo", "Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;", "getUiInfo", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;", "setUiInfo", "(Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;)V", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RemoteCityFilterCardStruct {

    @SerializedName("children_component")
    private List<RemoteCityFilterCardStruct> childrenComponent;

    @SerializedName("city_code")
    private String cityCode;

    @SerializedName("city_name")
    private String cityName;

    @SerializedName("condition_field")
    private String conditionField;

    @SerializedName("condition_value")
    private String conditionValue;

    @SerializedName("is_placeholder")
    private Integer isPlaceHolder;

    @SerializedName("linked_text")
    private String linkedText;

    @SerializedName("style_config")
    private RemoteCityStyleConfig styleConfig;

    @SerializedName("text")
    private String text;

    @SerializedName("type")
    private String type;

    @SerializedName("ui_info")
    private SearchCardUiInfo uiInfo;

    public RemoteCityFilterCardStruct() {
        this.isPlaceHolder = 0;
    }

    public final String getType() {
        return this.type;
    }
}
