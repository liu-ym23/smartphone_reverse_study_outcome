package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.amap.api.col.s.ce;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b)\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bt\u0010uJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0097\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0017R$\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010(\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R$\u00105\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010>\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR0\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR0\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010C\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\"\u0010K\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u001d\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010!R$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010X\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000fR$\u0010\\\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010\u000b\u001a\u0004\bZ\u0010\r\"\u0004\b[\u0010\u000fR$\u0010`\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010\u000b\u001a\u0004\b^\u0010\r\"\u0004\b_\u0010\u000fR$\u0010d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010\u000b\u001a\u0004\bb\u0010\r\"\u0004\bc\u0010\u000fR$\u0010k\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010o\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010f\u001a\u0004\bm\u0010h\"\u0004\bn\u0010jR$\u0010s\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010\u000b\u001a\u0004\bq\u0010\r\"\u0004\br\u0010\u000f¨\u0006v"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;", "Ljava/io/Serializable;", "", "other", "", "equals", "", "toString", "", "hashCode", "dataId", "Ljava/lang/String;", "getDataId", "()Ljava/lang/String;", "setDataId", "(Ljava/lang/String;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getText", "setText", "text", "b", "getOptionType", "setOptionType", "optionType", "c", "getPostscriptText", "setPostscriptText", "postscriptText", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "conditionField", "getConditionField", "setConditionField", "conditionValue", "getConditionValue", "setConditionValue", "logText", "getLogText", "setLogText", "", "minInterval", "Ljava/lang/Long;", "getMinInterval", "()Ljava/lang/Long;", "setMinInterval", "(Ljava/lang/Long;)V", "maxInterval", "getMaxInterval", "setMaxInterval", "type", "getType", "setType", "endTime", "getEndTime", "setEndTime", "rawData", "getRawData", "setRawData", ControlRule.KEY_EXTRA_DATA, "getExtraData", "setExtraData", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "logInfo", "getLogInfo", "setLogInfo", "isManualSelect", "setManualSelect", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectListStatus;", "d", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectListStatus;", "getParentSelectList", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectListStatus;", "setParentSelectList", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectListStatus;)V", "parentSelectList", "e", "getMutex", "setMutex", "mutex", "f", "getStatusPath", "setStatusPath", "statusPath", ce.f26391f, "getTextType", "setTextType", "textType", "h", "getSelectedParentText", "setSelectedParentText", "selectedParentText", RXScreenCaptureService.KEY_INDEX, "Ljava/lang/Integer;", "getOptionRank", "()Ljava/lang/Integer;", "setOptionRank", "(Ljava/lang/Integer;)V", "optionRank", ce.f26395j, "getPosition", "setPosition", "position", ce.f26396k, "getComponentId", "setComponentId", "componentId", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class SelectItemStatus implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f450549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f450550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f450551c;

    @SerializedName("condition_field")
    private String conditionField;

    @SerializedName("condition_value")
    private String conditionValue;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient SelectListStatus f450552d;

    @SerializedName("id")
    private String dataId;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient String f450553e;

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("extra_data")
    private String extraData;

    @SerializedName("extra_info")
    private Map<String, ? extends Object> extraInfo;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient String f450554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient String f450555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient String f450556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient Integer f450557i;

    @SerializedName("is_manual_select")
    private int isManualSelect;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient Integer f450558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient String f450559k;

    @SerializedName("log_info")
    private Map<String, ? extends Object> logInfo;

    @SerializedName("log_text")
    private String logText;

    @SerializedName("max_interval")
    private Long maxInterval;

    @SerializedName("min_interval")
    private Long minInterval;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private String rawData;

    @SerializedName("status")
    private int status;

    @SerializedName("type")
    private String type;

    @AllowImpl
    public int hashCode() {
        String r100 = this.dataId;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "dataId = " + this.dataId + " status = " + this.status + ", statusPath = " + this.f450554f;
    }

    public SelectItemStatus() {
        this.conditionField = "";
        this.conditionValue = "";
    }

    public final String getComponentId() {
        return this.f450559k;
    }

    public final String getConditionField() {
        return this.conditionField;
    }

    public final String getConditionValue() {
        return this.conditionValue;
    }

    public final String getDataId() {
        return this.dataId;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getExtraData() {
        return this.extraData;
    }

    public final Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public final Map<String, Object> getLogInfo() {
        return this.logInfo;
    }

    public final String getLogText() {
        return this.logText;
    }

    public final Long getMaxInterval() {
        return this.maxInterval;
    }

    public final Long getMinInterval() {
        return this.minInterval;
    }

    public final String getMutex() {
        return this.f450553e;
    }

    public final Integer getOptionRank() {
        return this.f450557i;
    }

    public final String getOptionType() {
        return this.f450550b;
    }

    public final SelectListStatus getParentSelectList() {
        return this.f450552d;
    }

    public final Integer getPosition() {
        return this.f450558j;
    }

    public final String getPostscriptText() {
        return this.f450551c;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getSelectedParentText() {
        return this.f450556h;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusPath() {
        return this.f450554f;
    }

    public final String getText() {
        return this.f450549a;
    }

    public final String getTextType() {
        return this.f450555g;
    }

    public final String getType() {
        return this.type;
    }

    public final int isManualSelect() {
        return this.isManualSelect;
    }

    @AllowImpl
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectItemStatus) == true) goto L9;
        return false;
    L9:
        if ((!Intrinsics.areEqual(this.dataId, ((SelectItemStatus) r100).dataId)) == false) goto L11;
        return false;
    L11:
        return true;
    }

    public final void setComponentId(String r100) {
        this.f450559k = r100;
    }

    public final void setConditionField(String r100) {
        this.conditionField = r100;
    }

    public final void setConditionValue(String r100) {
        this.conditionValue = r100;
    }

    public final void setDataId(String r100) {
        this.dataId = r100;
    }

    public final void setEndTime(String r100) {
        this.endTime = r100;
    }

    public final void setExtraData(String r100) {
        this.extraData = r100;
    }

    public final void setExtraInfo(Map<String, ? extends Object> r100) {
        this.extraInfo = r100;
    }

    public final void setLogInfo(Map<String, ? extends Object> r100) {
        this.logInfo = r100;
    }

    public final void setLogText(String r100) {
        this.logText = r100;
    }

    public final void setManualSelect(int r100) {
        this.isManualSelect = r100;
    }

    public final void setMaxInterval(Long r100) {
        this.maxInterval = r100;
    }

    public final void setMinInterval(Long r100) {
        this.minInterval = r100;
    }

    public final void setMutex(String r100) {
        this.f450553e = r100;
    }

    public final void setOptionRank(Integer r100) {
        this.f450557i = r100;
    }

    public final void setOptionType(String r100) {
        this.f450550b = r100;
    }

    public final void setParentSelectList(SelectListStatus r100) {
        this.f450552d = r100;
    }

    public final void setPosition(Integer r100) {
        this.f450558j = r100;
    }

    public final void setPostscriptText(String r100) {
        this.f450551c = r100;
    }

    public final void setRawData(String r100) {
        this.rawData = r100;
    }

    public final void setSelectedParentText(String r100) {
        this.f450556h = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setStatusPath(String r100) {
        this.f450554f = r100;
    }

    public final void setText(String r100) {
        this.f450549a = r100;
    }

    public final void setTextType(String r100) {
        this.f450555g = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
