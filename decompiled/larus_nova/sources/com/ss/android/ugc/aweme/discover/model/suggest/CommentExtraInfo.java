package com.ss.android.ugc.aweme.discover.model.suggest;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b;\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010`\u001a\u00020\u0000J\u0006\u00106\u001a\u00020\u000bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001c\u0010%\u001a\u00020&8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR \u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\tR \u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\tR \u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR \u0010B\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\tR \u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\tR \u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\tR \u0010K\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\tR \u0010N\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0007\"\u0004\bP\u0010\tR \u0010Q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\tR \u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0007\"\u0004\bV\u0010\tR \u0010W\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0007\"\u0004\bY\u0010\tR \u0010Z\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0007\"\u0004\b\\\u0010\tR \u0010]\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0007\"\u0004\b_\u0010\t¨\u0006a"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/suggest/CommentExtraInfo;", "Ljava/io/Serializable;", "()V", "_iconOffset", "", "awemeLiveStatus", "getAwemeLiveStatus", "()Ljava/lang/String;", "setAwemeLiveStatus", "(Ljava/lang/String;)V", "display", "", "getDisplay", "()Z", "setDisplay", "(Z)V", "ecomCoverImageUrl", "getEcomCoverImageUrl", "setEcomCoverImageUrl", "ecomSearchResultProductId", "getEcomSearchResultProductId", "setEcomSearchResultProductId", "firstQueryExtraInfo", "getFirstQueryExtraInfo", "setFirstQueryExtraInfo", "highlight", "getHighlight", "setHighlight", "iconDesc", "getIconDesc", "setIconDesc", "iconHeight", "getIconHeight", "setIconHeight", "iconIsDynamic", "getIconIsDynamic", "setIconIsDynamic", "iconOffset", "", "getIconOffset", "()I", "setIconOffset", "(I)V", "iconText", "getIconText", "setIconText", "iconUrl", "getIconUrl", "setIconUrl", "iconWidth", "getIconWidth", "setIconWidth", "isMultiQueryPushInputWord", "setMultiQueryPushInputWord", "needTabFrequencyControl", "getNeedTabFrequencyControl", "setNeedTabFrequencyControl", "notInsertGuessWord", "getNotInsertGuessWord", "setNotInsertGuessWord", "qrecForSearch", "getQrecForSearch", "setQrecForSearch", "realSearchWord", "getRealSearchWord", "setRealSearchWord", "recommendReason", "getRecommendReason", "setRecommendReason", "relInfo", "getRelInfo", "setRelInfo", "relatedWordsType", "getRelatedWordsType", "setRelatedWordsType", "sarFrom", "getSarFrom", "setSarFrom", "searchPassParamsStruct", "getSearchPassParamsStruct", "setSearchPassParamsStruct", "specialType", "getSpecialType", "setSpecialType", "tagIcon", "getTagIcon", "setTagIcon", "tagType", "getTagType", "setTagType", "toastInfo", "getToastInfo", "setToastInfo", "wordPrefix", "getWordPrefix", "setWordPrefix", "copyForStore", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentExtraInfo implements Serializable {

    @SerializedName("offset")
    private final String _iconOffset;

    @SerializedName("aweme_live_status")
    private String awemeLiveStatus;

    @SerializedName("display")
    private boolean display;

    @SerializedName("ecom_cover_image_url")
    private String ecomCoverImageUrl;

    @SerializedName("ecom_search_result_product_id")
    private String ecomSearchResultProductId;

    @SerializedName("first_query_extra_info")
    private String firstQueryExtraInfo;

    @SerializedName("highlight")
    private String highlight;

    @SerializedName("icon_desc")
    private String iconDesc;

    @SerializedName("icon_height")
    private String iconHeight;

    @SerializedName("icon_is_dynamic")
    private String iconIsDynamic;
    private int iconOffset;

    @SerializedName("feeds_icon_text")
    private String iconText;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("icon_width")
    private String iconWidth;

    @SerializedName("is_multi_query_push_input_word")
    private String isMultiQueryPushInputWord;

    @SerializedName("need_tab_frequency_control")
    private String needTabFrequencyControl;

    @SerializedName("not_insert_guess_word")
    private String notInsertGuessWord;

    @SerializedName("qrec_for_search")
    private String qrecForSearch;

    @SerializedName("real_search_word")
    private String realSearchWord;

    @SerializedName("recommend_reason")
    private String recommendReason;

    @SerializedName("rel_info")
    private String relInfo;

    @SerializedName("related_words_type")
    private String relatedWordsType;

    @SerializedName("sar_from")
    private String sarFrom;

    @SerializedName("search_pass_params_struct")
    private String searchPassParamsStruct;

    @SerializedName("special_type")
    private String specialType;

    @SerializedName("tag_icon")
    private String tagIcon;

    @SerializedName(a.KEY_TAG_TYPE)
    private String tagType;

    @SerializedName("toast_info")
    private String toastInfo;

    @SerializedName("word_prefix")
    private String wordPrefix;

    public final CommentExtraInfo copyForStore() {
        CommentExtraInfo r100 = new CommentExtraInfo();
        r100.display = this.display;
        r100.highlight = this.highlight;
        r100.relInfo = this.relInfo;
        r100.qrecForSearch = this.qrecForSearch;
        r100.relatedWordsType = this.relatedWordsType;
        r100.sarFrom = this.sarFrom;
        r100.recommendReason = this.recommendReason;
        r100.ecomSearchResultProductId = this.ecomSearchResultProductId;
        r100.ecomCoverImageUrl = this.ecomCoverImageUrl;
        r100.awemeLiveStatus = this.awemeLiveStatus;
        r100.wordPrefix = this.wordPrefix;
        r100.iconOffset = getIconOffset();
        r100.notInsertGuessWord = this.notInsertGuessWord;
        r100.realSearchWord = this.realSearchWord;
        r100.toastInfo = this.toastInfo;
        String r101 = this.searchPassParamsStruct;
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L26;
        String r104 = this.searchPassParamsStruct;
        JSONArray r105 = new JSONArray(r104);     // Catch: Exception -> L24
        int r106 = r105.length();     // Catch: Exception -> L24
    L12:
        if (r102 >= r106) goto L22;
        Object r107 = r105.get(r102);     // Catch: Exception -> L24
        JSONObject r108 = null;
        if ((r107 instanceof JSONObject) == true) goto L16;
        r107 = null;
    L16:
        JSONObject r109 = (JSONObject) r107;     // Catch: Exception -> L24
        if (r109 == null) goto L19;
        r108 = JSONObjectProtectorUtils.getJSONObject(r109, "pass_params_content");     // Catch: Exception -> L24
    L19:
        if (r108 == null) goto L21;
        r108.remove("params_to_engine");     // Catch: Exception -> L24
    L21:
        r102 = r102 + 1;     // Catch: Exception -> L24
        goto L12
    L22:
        r100.searchPassParamsStruct = String.valueOf(r104);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L26:
        r100.tagType = this.tagType;
        return r100;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @AllowImpl
    public final int getIconOffset() {
        String r100 = this._iconOffset;
        if (r100 == null) goto L7;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L7;
        return r101.intValue();
    L7:
        return 0;
    }

    public final boolean needTabFrequencyControl() {
        return Intrinsics.areEqual(this.needTabFrequencyControl, "1");
    }

    public CommentExtraInfo() {
        this.notInsertGuessWord = "";
        this.realSearchWord = "";
        this.toastInfo = "";
        this.needTabFrequencyControl = "0";
    }

    public final String getAwemeLiveStatus() {
        return this.awemeLiveStatus;
    }

    public final boolean getDisplay() {
        return this.display;
    }

    public final String getEcomCoverImageUrl() {
        return this.ecomCoverImageUrl;
    }

    public final String getEcomSearchResultProductId() {
        return this.ecomSearchResultProductId;
    }

    public final String getFirstQueryExtraInfo() {
        return this.firstQueryExtraInfo;
    }

    public final String getHighlight() {
        return this.highlight;
    }

    public final String getIconDesc() {
        return this.iconDesc;
    }

    public final String getIconHeight() {
        return this.iconHeight;
    }

    public final String getIconIsDynamic() {
        return this.iconIsDynamic;
    }

    public final String getIconText() {
        return this.iconText;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconWidth() {
        return this.iconWidth;
    }

    public final String getNeedTabFrequencyControl() {
        return this.needTabFrequencyControl;
    }

    public final String getNotInsertGuessWord() {
        return this.notInsertGuessWord;
    }

    public final String getQrecForSearch() {
        return this.qrecForSearch;
    }

    public final String getRealSearchWord() {
        return this.realSearchWord;
    }

    public final String getRecommendReason() {
        return this.recommendReason;
    }

    public final String getRelInfo() {
        return this.relInfo;
    }

    public final String getRelatedWordsType() {
        return this.relatedWordsType;
    }

    public final String getSarFrom() {
        return this.sarFrom;
    }

    public final String getSearchPassParamsStruct() {
        return this.searchPassParamsStruct;
    }

    public final String getSpecialType() {
        return this.specialType;
    }

    public final String getTagIcon() {
        return this.tagIcon;
    }

    public final String getTagType() {
        return this.tagType;
    }

    public final String getToastInfo() {
        return this.toastInfo;
    }

    public final String getWordPrefix() {
        return this.wordPrefix;
    }

    public final String isMultiQueryPushInputWord() {
        return this.isMultiQueryPushInputWord;
    }

    public final void setAwemeLiveStatus(String r100) {
        this.awemeLiveStatus = r100;
    }

    public final void setDisplay(boolean r100) {
        this.display = r100;
    }

    public final void setEcomCoverImageUrl(String r100) {
        this.ecomCoverImageUrl = r100;
    }

    public final void setEcomSearchResultProductId(String r100) {
        this.ecomSearchResultProductId = r100;
    }

    public final void setFirstQueryExtraInfo(String r100) {
        this.firstQueryExtraInfo = r100;
    }

    public final void setHighlight(String r100) {
        this.highlight = r100;
    }

    public final void setIconDesc(String r100) {
        this.iconDesc = r100;
    }

    public final void setIconHeight(String r100) {
        this.iconHeight = r100;
    }

    public final void setIconIsDynamic(String r100) {
        this.iconIsDynamic = r100;
    }

    public final void setIconOffset(int r100) {
        this.iconOffset = r100;
    }

    public final void setIconText(String r100) {
        this.iconText = r100;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public final void setIconWidth(String r100) {
        this.iconWidth = r100;
    }

    public final void setMultiQueryPushInputWord(String r100) {
        this.isMultiQueryPushInputWord = r100;
    }

    public final void setNeedTabFrequencyControl(String r100) {
        this.needTabFrequencyControl = r100;
    }

    public final void setNotInsertGuessWord(String r100) {
        this.notInsertGuessWord = r100;
    }

    public final void setQrecForSearch(String r100) {
        this.qrecForSearch = r100;
    }

    public final void setRealSearchWord(String r100) {
        this.realSearchWord = r100;
    }

    public final void setRecommendReason(String r100) {
        this.recommendReason = r100;
    }

    public final void setRelInfo(String r100) {
        this.relInfo = r100;
    }

    public final void setRelatedWordsType(String r100) {
        this.relatedWordsType = r100;
    }

    public final void setSarFrom(String r100) {
        this.sarFrom = r100;
    }

    public final void setSearchPassParamsStruct(String r100) {
        this.searchPassParamsStruct = r100;
    }

    public final void setSpecialType(String r100) {
        this.specialType = r100;
    }

    public final void setTagIcon(String r100) {
        this.tagIcon = r100;
    }

    public final void setTagType(String r100) {
        this.tagType = r100;
    }

    public final void setToastInfo(String r100) {
        this.toastInfo = r100;
    }

    public final void setWordPrefix(String r100) {
        this.wordPrefix = r100;
    }
}
