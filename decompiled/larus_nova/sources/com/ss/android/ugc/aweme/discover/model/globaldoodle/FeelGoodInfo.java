package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001e\u0010-\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R \u00100\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR \u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u00109\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000e¨\u0006<"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeelGoodInfo;", "Ljava/io/Serializable;", "()V", "icon", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeedbackEntranceIconStruct;", "getIcon", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeedbackEntranceIconStruct;", "setIcon", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FeedbackEntranceIconStruct;)V", "lynxEntranceSchema", "", "getLynxEntranceSchema", "()Ljava/lang/String;", "setLynxEntranceSchema", "(Ljava/lang/String;)V", "params", "", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "showEntrance", "", "getShowEntrance", "()Z", "setShowEntrance", "(Z)V", "showEntranceType", "", "getShowEntranceType", "()I", "setShowEntranceType", "(I)V", "showTipsCardIndex", "getShowTipsCardIndex", "setShowTipsCardIndex", "showTipsDuration", "", "getShowTipsDuration", "()J", "setShowTipsDuration", "(J)V", "showTipsStartDelay", "getShowTipsStartDelay", "setShowTipsStartDelay", "showTipsType", "getShowTipsType", "setShowTipsType", "subtitle", "getSubtitle", "setSubtitle", "surveyTask", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchSurveyTask;", "getSurveyTask", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchSurveyTask;", "setSurveyTask", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchSurveyTask;)V", "title", "getTitle", d.f25925o, "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FeelGoodInfo implements Serializable {

    @SerializedName("icon")
    private FeedbackEntranceIconStruct icon;

    @SerializedName("feelgood_lynx_entrance_schema")
    private String lynxEntranceSchema;

    @SerializedName("params")
    private Map<String, String> params;

    @SerializedName("show_entrance")
    private boolean showEntrance;

    @SerializedName("show_entrance_type")
    private int showEntranceType;

    @SerializedName("show_tips_card_index")
    private int showTipsCardIndex;

    @SerializedName("show_tips_duration_ms")
    private long showTipsDuration;

    @SerializedName("show_tips_start_delay_ms")
    private long showTipsStartDelay;

    @SerializedName("show_tips_type")
    private int showTipsType;

    @SerializedName("subtitle")
    private String subtitle;

    @SerializedName("survey_task")
    private SearchSurveyTask surveyTask;

    @SerializedName("title")
    private String title;

    public FeelGoodInfo() {
        this.showTipsDuration = 5000;
    }

    public final FeedbackEntranceIconStruct getIcon() {
        return this.icon;
    }

    public final String getLynxEntranceSchema() {
        return this.lynxEntranceSchema;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final boolean getShowEntrance() {
        return this.showEntrance;
    }

    public final int getShowEntranceType() {
        return this.showEntranceType;
    }

    public final int getShowTipsCardIndex() {
        return this.showTipsCardIndex;
    }

    public final long getShowTipsDuration() {
        return this.showTipsDuration;
    }

    public final long getShowTipsStartDelay() {
        return this.showTipsStartDelay;
    }

    public final int getShowTipsType() {
        return this.showTipsType;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final SearchSurveyTask getSurveyTask() {
        return this.surveyTask;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setIcon(FeedbackEntranceIconStruct r100) {
        this.icon = r100;
    }

    public final void setLynxEntranceSchema(String r100) {
        this.lynxEntranceSchema = r100;
    }

    public final void setParams(Map<String, String> r100) {
        this.params = r100;
    }

    public final void setShowEntrance(boolean r100) {
        this.showEntrance = r100;
    }

    public final void setShowEntranceType(int r100) {
        this.showEntranceType = r100;
    }

    public final void setShowTipsCardIndex(int r100) {
        this.showTipsCardIndex = r100;
    }

    public final void setShowTipsDuration(long r100) {
        this.showTipsDuration = r100;
    }

    public final void setShowTipsStartDelay(long r100) {
        this.showTipsStartDelay = r100;
    }

    public final void setShowTipsType(int r100) {
        this.showTipsType = r100;
    }

    public final void setSubtitle(String r100) {
        this.subtitle = r100;
    }

    public final void setSurveyTask(SearchSurveyTask r100) {
        this.surveyTask = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
