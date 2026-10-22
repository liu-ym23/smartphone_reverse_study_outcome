package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchSurveyTask;", "Ljava/io/Serializable;", "()V", "commonConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/CommonConfig;", "getCommonConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/CommonConfig;", "setCommonConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/CommonConfig;)V", "delayDuration", "", "getDelayDuration", "()Ljava/lang/Integer;", "setDelayDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "formConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FormConfig;", "getFormConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FormConfig;", "setFormConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/FormConfig;)V", "surveyType", "getSurveyType", "()I", "setSurveyType", "(I)V", DBDefinition.TASK_ID, "", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchSurveyTask implements Serializable {

    @SerializedName("common_config")
    private CommonConfig commonConfig;

    @SerializedName("delay_duration")
    private Integer delayDuration;

    @SerializedName("form_config")
    private FormConfig formConfig;

    @SerializedName("survey_type")
    private int surveyType;

    @SerializedName("task_id")
    private String taskId;

    public SearchSurveyTask() {
    }

    public final CommonConfig getCommonConfig() {
        return this.commonConfig;
    }

    public final Integer getDelayDuration() {
        return this.delayDuration;
    }

    public final FormConfig getFormConfig() {
        return this.formConfig;
    }

    public final int getSurveyType() {
        return this.surveyType;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setCommonConfig(CommonConfig r100) {
        this.commonConfig = r100;
    }

    public final void setDelayDuration(Integer r100) {
        this.delayDuration = r100;
    }

    public final void setFormConfig(FormConfig r100) {
        this.formConfig = r100;
    }

    public final void setSurveyType(int r100) {
        this.surveyType = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }
}
