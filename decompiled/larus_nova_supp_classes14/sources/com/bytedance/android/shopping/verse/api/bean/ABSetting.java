package com.bytedance.android.shopping.verse.api.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R&\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R&\u00109\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R&\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,R \u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\"\u0010B\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010\u0011R \u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR&\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010*\"\u0004\bJ\u0010,R \u0010K\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0019\"\u0004\bM\u0010\u001bR\"\u0010N\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bO\u00105\"\u0004\bP\u00107R&\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010*\"\u0004\bS\u0010,R \u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\b¨\u0006W"}, d2 = {"Lcom/bytedance/android/shopping/verse/api/bean/ABSetting;", "Ljava/io/Serializable;", "()V", "appVersion", "", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "cellTitle", "getCellTitle", "setCellTitle", "cellType", "", "getCellType", "()Ljava/lang/Integer;", "setCellType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "className", "getClassName", "setClassName", "currentValue", "", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "defaultValue", "getDefaultValue", "setDefaultValue", "descriptionText", "getDescriptionText", "setDescriptionText", "isFailed", "", "()Z", "setFailed", "(Z)V", "linesOfBusiness", "", "getLinesOfBusiness", "()Ljava/util/List;", "setLinesOfBusiness", "(Ljava/util/List;)V", "mockEnums", "Lcom/bytedance/android/shopping/verse/api/bean/MockEnums;", "getMockEnums", "()Lcom/bytedance/android/shopping/verse/api/bean/MockEnums;", "setMockEnums", "(Lcom/bytedance/android/shopping/verse/api/bean/MockEnums;)V", "mocked", "getMocked", "()Ljava/lang/Boolean;", "setMocked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "modules", "getModules", "setModules", "owners", "getOwners", "setOwners", "propertyName", "getPropertyName", "setPropertyName", "propertyType", "getPropertyType", "setPropertyType", "serverKey", "getServerKey", "setServerKey", "serverTestCaseDataArray", "getServerTestCaseDataArray", "setServerTestCaseDataArray", "serverValue", "getServerValue", "setServerValue", "stable", "getStable", "setStable", "testCaseMessages", "getTestCaseMessages", "setTestCaseMessages", "valueType", "getValueType", "setValueType", "ec-verse-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ABSetting implements Serializable {

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("cellTitle")
    private String cellTitle;

    @SerializedName("cellType")
    private Integer cellType;

    @Expose
    private String className;

    @SerializedName("currentValue")
    private Object currentValue;

    @SerializedName("defaultData")
    private Object defaultValue;

    @SerializedName("descriptionText")
    private String descriptionText;

    @Expose
    private boolean isFailed;

    @SerializedName("linesOfBusiness")
    private List<String> linesOfBusiness;

    @SerializedName("mockEnums")
    private MockEnums mockEnums;

    @SerializedName("mocked")
    private Boolean mocked;

    @SerializedName("modules")
    private List<String> modules;

    @SerializedName("owners")
    private List<String> owners;

    @SerializedName("propertyName")
    private String propertyName;

    @SerializedName("propertyType")
    private Integer propertyType;

    @SerializedName("serverKey")
    private String serverKey;

    @SerializedName("serverTestCaseDataArray")
    private List<? extends Object> serverTestCaseDataArray;

    @SerializedName("serverValue")
    private Object serverValue;

    @SerializedName("stable")
    private Boolean stable;

    @SerializedName("testCaseMessages")
    private List<String> testCaseMessages;

    @Expose
    private String valueType;

    public ABSetting() {
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCellTitle() {
        return this.cellTitle;
    }

    public final Integer getCellType() {
        return this.cellType;
    }

    public final String getClassName() {
        return this.className;
    }

    public final Object getCurrentValue() {
        return this.currentValue;
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final String getDescriptionText() {
        return this.descriptionText;
    }

    public final List<String> getLinesOfBusiness() {
        return this.linesOfBusiness;
    }

    public final MockEnums getMockEnums() {
        return this.mockEnums;
    }

    public final Boolean getMocked() {
        return this.mocked;
    }

    public final List<String> getModules() {
        return this.modules;
    }

    public final List<String> getOwners() {
        return this.owners;
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public final Integer getPropertyType() {
        return this.propertyType;
    }

    public final String getServerKey() {
        return this.serverKey;
    }

    public final List<Object> getServerTestCaseDataArray() {
        return this.serverTestCaseDataArray;
    }

    public final Object getServerValue() {
        return this.serverValue;
    }

    public final Boolean getStable() {
        return this.stable;
    }

    public final List<String> getTestCaseMessages() {
        return this.testCaseMessages;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final boolean isFailed() {
        return this.isFailed;
    }

    public final void setAppVersion(String r1) {
        this.appVersion = r1;
    }

    public final void setCellTitle(String r1) {
        this.cellTitle = r1;
    }

    public final void setCellType(Integer r1) {
        this.cellType = r1;
    }

    public final void setClassName(String r1) {
        this.className = r1;
    }

    public final void setCurrentValue(Object r1) {
        this.currentValue = r1;
    }

    public final void setDefaultValue(Object r1) {
        this.defaultValue = r1;
    }

    public final void setDescriptionText(String r1) {
        this.descriptionText = r1;
    }

    public final void setFailed(boolean r1) {
        this.isFailed = r1;
    }

    public final void setLinesOfBusiness(List<String> r1) {
        this.linesOfBusiness = r1;
    }

    public final void setMockEnums(MockEnums r1) {
        this.mockEnums = r1;
    }

    public final void setMocked(Boolean r1) {
        this.mocked = r1;
    }

    public final void setModules(List<String> r1) {
        this.modules = r1;
    }

    public final void setOwners(List<String> r1) {
        this.owners = r1;
    }

    public final void setPropertyName(String r1) {
        this.propertyName = r1;
    }

    public final void setPropertyType(Integer r1) {
        this.propertyType = r1;
    }

    public final void setServerKey(String r1) {
        this.serverKey = r1;
    }

    public final void setServerTestCaseDataArray(List<? extends Object> r1) {
        this.serverTestCaseDataArray = r1;
    }

    public final void setServerValue(Object r1) {
        this.serverValue = r1;
    }

    public final void setStable(Boolean r1) {
        this.stable = r1;
    }

    public final void setTestCaseMessages(List<String> r1) {
        this.testCaseMessages = r1;
    }

    public final void setValueType(String r1) {
        this.valueType = r1;
    }
}
