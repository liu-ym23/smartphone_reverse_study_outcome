package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b \n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\bJ\u0010KR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR$\u0010@\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR(\u0010I\u001a\b\u0012\u0004\u0012\u00020B0A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BusinessItem;", "Ljava/io/Serializable;", "", "dataId", "Ljava/lang/String;", "getDataId", "()Ljava/lang/String;", "setDataId", "(Ljava/lang/String;)V", "logText", "getLogText", "setLogText", "type", "getType", "setType", "conditionField", "getConditionField", "setConditionField", "conditionValue", "getConditionValue", "setConditionValue", "", "maxInterval", "Ljava/lang/Long;", "getMaxInterval", "()Ljava/lang/Long;", "setMaxInterval", "(Ljava/lang/Long;)V", "minInterval", "getMinInterval", "setMinInterval", "", "", "logInfo", "Ljava/util/Map;", "getLogInfo", "()Ljava/util/Map;", "setLogInfo", "(Ljava/util/Map;)V", "extraInfo", "getExtraInfo", "setExtraInfo", ControlRule.KEY_EXTRA_DATA, "getExtraData", "setExtraData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getNeedMutex", "setNeedMutex", "needMutex", "b", "getText", "setText", "text", "c", "getStatusPath", "setStatusPath", "statusPath", "d", "getTextType", "setTextType", "textType", "e", "getComponentId", "setComponentId", "componentId", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "f", "Ljava/util/Set;", "getRenderItemList", "()Ljava/util/Set;", "setRenderItemList", "(Ljava/util/Set;)V", "renderItemList", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BusinessItem implements Serializable {
    public static final Companion Companion = null;
    public static final String TYPE_FILTER = "filter";
    public static final String TYPE_SORT = "sort";
    public static final String TYPE_TAB = "tab";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f450509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f450510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f450511c;

    @SerializedName("condition_field")
    private String conditionField;

    @SerializedName("condition_value")
    private String conditionValue;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient String f450512d;

    @SerializedName("data_id")
    private String dataId;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient String f450513e;

    @SerializedName("extra_data")
    private String extraData;

    @SerializedName("extra_info")
    private Map<String, ? extends Object> extraInfo;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient Set<RenderItem> f450514f;

    @SerializedName("log_info")
    private Map<String, ? extends Object> logInfo;

    @SerializedName("log_text")
    private String logText;

    @SerializedName("max_interval")
    private Long maxInterval;

    @SerializedName("min_interval")
    private Long minInterval;

    @SerializedName("type")
    private String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BusinessItem$Companion;", "", "()V", "TYPE_FILTER", "", "TYPE_SORT", "TYPE_TAB", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public BusinessItem() {
        this.f450514f = new LinkedHashSet();
    }

    public final String getComponentId() {
        return this.f450513e;
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

    public final String getNeedMutex() {
        return this.f450509a;
    }

    public final Set<RenderItem> getRenderItemList() {
        return this.f450514f;
    }

    public final String getStatusPath() {
        return this.f450511c;
    }

    public final String getText() {
        return this.f450510b;
    }

    public final String getTextType() {
        return this.f450512d;
    }

    public final String getType() {
        return this.type;
    }

    public final void setComponentId(String r100) {
        this.f450513e = r100;
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

    public final void setMaxInterval(Long r100) {
        this.maxInterval = r100;
    }

    public final void setMinInterval(Long r100) {
        this.minInterval = r100;
    }

    public final void setNeedMutex(String r100) {
        this.f450509a = r100;
    }

    public final void setRenderItemList(Set<RenderItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f450514f = r100;
    }

    public final void setStatusPath(String r100) {
        this.f450511c = r100;
    }

    public final void setText(String r100) {
        this.f450510b = r100;
    }

    public final void setTextType(String r100) {
        this.f450512d = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
