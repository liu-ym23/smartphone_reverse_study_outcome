package com.bytedance.timon_monitor_api.pipeline;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.vivo.push.PushClientConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006."}, d2 = {"Lcom/bytedance/timon_monitor_api/pipeline/JSBInfoData;", "Ljava/io/Serializable;", "apiName", "", "pageId", "pageType", PushClientConstants.TAG_CLASS_NAME, "appId", "appName", "jsbPath", "jsbDomain", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAppName", "setAppName", "getClassName", "setClassName", "getJsbDomain", "setJsbDomain", "getJsbPath", "setJsbPath", "getPageId", "setPageId", "getPageType", "setPageType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "timon-monitor-api_release"}, k = 1, mv = {1, 1, 16})
public final class JSBInfoData implements Serializable {

    @SerializedName("api_name")
    private String apiName;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("app_name")
    private String appName;

    @SerializedName("class_name")
    private String className;

    @SerializedName("jsb_domain")
    private String jsbDomain;

    @SerializedName("jsb_path")
    private String jsbPath;

    @SerializedName(a.KEY_PAGE_ID)
    private String pageId;

    @SerializedName("page_type")
    private String pageType;

    public static /* synthetic */ JSBInfoData copy$default(JSBInfoData r100, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.apiName;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.pageId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.pageType;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.className;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.appId;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.appName;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.jsbPath;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.jsbDomain;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.apiName;
    }

    public final String component2() {
        return this.pageId;
    }

    public final String component3() {
        return this.pageType;
    }

    public final String component4() {
        return this.className;
    }

    public final String component5() {
        return this.appId;
    }

    public final String component6() {
        return this.appName;
    }

    public final String component7() {
        return this.jsbPath;
    }

    public final String component8() {
        return this.jsbDomain;
    }

    public final JSBInfoData copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117) {
        return new JSBInfoData(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof JSBInfoData) == false) goto L22;
        JSBInfoData r101 = (JSBInfoData) r100;
        if (Intrinsics.areEqual(this.apiName, r101.apiName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageType, r101.pageType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.jsbPath, r101.jsbPath) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.jsbDomain, r101.jsbDomain) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r100 = this.apiName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.pageId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.pageType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.className;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.appId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.appName;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.jsbPath;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.jsbDomain;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
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

    public String toString() {
        return "JSBInfoData(apiName=" + this.apiName + ", pageId=" + this.pageId + ", pageType=" + this.pageType + ", className=" + this.className + ", appId=" + this.appId + ", appName=" + this.appName + ", jsbPath=" + this.jsbPath + ", jsbDomain=" + this.jsbDomain + ")";
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getJsbDomain() {
        return this.jsbDomain;
    }

    public final String getJsbPath() {
        return this.jsbPath;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final void setApiName(String r100) {
        this.apiName = r100;
    }

    public final void setAppId(String r100) {
        this.appId = r100;
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setClassName(String r100) {
        this.className = r100;
    }

    public final void setJsbDomain(String r100) {
        this.jsbDomain = r100;
    }

    public final void setJsbPath(String r100) {
        this.jsbPath = r100;
    }

    public final void setPageId(String r100) {
        this.pageId = r100;
    }

    public final void setPageType(String r100) {
        this.pageType = r100;
    }

    public JSBInfoData(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.apiName = r100;
        this.pageId = r101;
        this.pageType = r102;
        this.className = r103;
        this.appId = r104;
        this.appName = r105;
        this.jsbPath = r106;
        this.jsbDomain = r107;
    }

    public /* synthetic */ JSBInfoData(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r211 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r211 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r211 & 64) == 0) goto L17;
        String r117 = null;
    L19:
        if ((r211 & 128) == 0) goto L21;
        String r118 = null;
    L22:
        this(r110, r111, r112, r100, r101, r102, r117, r118);
        return;
    L21:
        r118 = r210;
        goto L22
    L17:
        r117 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
