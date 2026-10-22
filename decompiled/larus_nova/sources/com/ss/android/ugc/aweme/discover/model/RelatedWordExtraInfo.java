package com.ss.android.ugc.aweme.discover.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.commodity.utils.Objects;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR \u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006 "}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/RelatedWordExtraInfo;", "Ljava/io/Serializable;", "()V", "accessibilityText", "", "getAccessibilityText", "()Ljava/lang/String;", "setAccessibilityText", "(Ljava/lang/String;)V", "imgDesc", "getImgDesc", "imgHeight", "getImgHeight", "imgUrl", "getImgUrl", "imgWidth", "getImgWidth", "relatedHot", "getRelatedHot", "setRelatedHot", "schema", "getSchema", "setSchema", "wordsType", "getWordsType", "setWordsType", "equals", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "hashCode", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RelatedWordExtraInfo implements Serializable {

    @SerializedName("accessibility_text")
    private String accessibilityText;

    @SerializedName("img_desc")
    private final String imgDesc;

    @SerializedName("img_height")
    private final String imgHeight;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    private final String imgUrl;

    @SerializedName("img_width")
    private final String imgWidth;

    @SerializedName("related_hot")
    private String relatedHot;

    @SerializedName("schema")
    private String schema;

    @SerializedName("words_type")
    private String wordsType;

    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L7;
        if (r100 == null) goto L7;
        r101 = r100.hashCode();
    L7:
        return 31 + r101;
    }

    public RelatedWordExtraInfo() {
        this.relatedHot = "";
        this.wordsType = "";
        this.imgDesc = "";
        this.imgUrl = "";
        this.imgHeight = "";
        this.imgWidth = "";
        this.accessibilityText = "";
    }

    public final String getAccessibilityText() {
        return this.accessibilityText;
    }

    public final String getImgDesc() {
        return this.imgDesc;
    }

    public final String getImgHeight() {
        return this.imgHeight;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final String getImgWidth() {
        return this.imgWidth;
    }

    public final String getRelatedHot() {
        return this.relatedHot;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getWordsType() {
        return this.wordsType;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        RelatedWordExtraInfo r101 = (RelatedWordExtraInfo) r100;
        Objects.Companion r102 = Objects.f450380a;
        String r103 = this.schema;
        if (r101 == null) goto L8;
        String r104 = r101.schema;
    L9:
        r102.getClass();
        return Objects.Companion.a(r103, r104);
    L8:
        r104 = null;
        goto L9
    }

    public final void setAccessibilityText(String r100) {
        this.accessibilityText = r100;
    }

    public final void setRelatedHot(String r100) {
        this.relatedHot = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setWordsType(String r100) {
        this.wordsType = r100;
    }
}
