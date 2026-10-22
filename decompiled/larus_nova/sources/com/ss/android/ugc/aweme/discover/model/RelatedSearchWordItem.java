package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.commodity.utils.Objects;
import com.ss.android.ugc.aweme.discover.model.suggest.Word;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class RelatedSearchWordItem implements Serializable {
    public transient boolean isMobShow;

    @SerializedName("related_img")
    private String relatedImg;

    @SerializedName("related_word")
    private String relatedWord;

    @SerializedName("extra_info")
    private RelatedWordExtraInfo relatedWordExtraInfo;
    public transient boolean replaceQueryAfterClick;

    @SerializedName("search_query")
    private String searchQuery;

    @SerializedName("search_query_id")
    private String searchQueryId;

    @SerializedName("word_record")
    private Word word;

    @AllowImpl
    public int hashCode() {
        String r100 = this.relatedWord;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = (r102 + 31) * 31;
        String r104 = this.relatedImg;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Word r107 = this.word;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        RelatedWordExtraInfo r110 = this.relatedWordExtraInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.searchQuery;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.searchQueryId;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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

    public RelatedSearchWordItem() {
        this.isMobShow = false;
        this.replaceQueryAfterClick = false;
    }

    @AllowImpl
    public String getRelatedImg() {
        return this.relatedImg;
    }

    @AllowImpl
    public String getRelatedWord() {
        return this.relatedWord;
    }

    @AllowImpl
    public RelatedWordExtraInfo getRelatedWordExtraInfo() {
        return this.relatedWordExtraInfo;
    }

    @AllowImpl
    public String getSearchQuery() {
        return this.searchQuery;
    }

    @AllowImpl
    public String getSearchQueryId() {
        return this.searchQueryId;
    }

    @AllowImpl
    public Word getWord() {
        return this.word;
    }

    @AllowImpl
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RelatedSearchWordItem) == true) goto L8;
        return false;
    L8:
        RelatedSearchWordItem r101 = (RelatedSearchWordItem) r100;
        if (Objects.a(this.relatedWord, r101.relatedWord) == true) goto L12;
        return false;
    L12:
        if (Objects.a(this.relatedImg, r101.relatedImg) == true) goto L15;
        return false;
    L15:
        if (Objects.a(this.relatedWordExtraInfo, r101.relatedWordExtraInfo) == true) goto L18;
        return false;
    L18:
        if (Objects.a(this.searchQuery, r101.searchQuery) == true) goto L21;
        return false;
    L21:
        if (Objects.a(this.searchQueryId, r101.searchQueryId) == true) goto L24;
        return false;
    L24:
        return Objects.a(this.word, r101.word);
    }

    @AllowImpl
    public void setRelatedImg(String r100) {
        this.relatedImg = r100;
    }

    @AllowImpl
    public void setRelatedWord(String r100) {
        this.relatedWord = r100;
    }

    @AllowImpl
    public void setRelatedWordExtraInfo(RelatedWordExtraInfo r100) {
        this.relatedWordExtraInfo = r100;
    }
}
