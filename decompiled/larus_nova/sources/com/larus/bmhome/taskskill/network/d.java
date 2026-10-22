package com.larus.bmhome.taskskill.network;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b*\b\u0080\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014HÆ\u0003Jµ\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\n2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014HÆ\u0001J\u0013\u0010:\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\nHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0016\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lcom/larus/bmhome/taskskill/network/ConnectorRemoteItem;", "", "connectorId", "", "name", CommonConstant.KEY_DISPLAY_NAME, "description", "displayDescription", "icon", "type", "", "installStatus", "connectStatus", "enabled", "", "skillPackageId", "skillType", "recommend", Constants.OperatorKey.KEY_VENDOR, "runtimeTypes", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIZLjava/lang/String;IZILjava/util/List;)V", "getConnectorId", "()Ljava/lang/String;", "getName", "getDisplayName", "getDescription", "getDisplayDescription", "getIcon", "getType", "()I", "getInstallStatus", "getConnectStatus", "getEnabled", "()Z", "getSkillPackageId", "getSkillType", "getRecommend", "getVendor", "getRuntimeTypes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("connect_status")
    private final int connectStatus;

    @SerializedName("connector_id")
    private final String connectorId;

    @SerializedName("description")
    private final String description;

    @SerializedName("display_description")
    private final String displayDescription;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("icon")
    private final String icon;

    @SerializedName(MonitorConstants.APP_INSTALL_STATUS)
    private final int installStatus;

    @SerializedName("name")
    private final String name;

    @SerializedName("recommend")
    private final boolean recommend;

    @SerializedName("runtime_types")
    private final List<Integer> runtimeTypes;

    @SerializedName("skill_package_id")
    private final String skillPackageId;

    @SerializedName("skill_type")
    private final int skillType;

    @SerializedName("type")
    private final int type;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    private final int f314375vendor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.connectorId, r101.connectorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.displayDescription, r101.displayDescription) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L27;
        return false;
    L27:
        if (this.type == r101.type) goto L30;
        return false;
    L30:
        if (this.installStatus == r101.installStatus) goto L33;
        return false;
    L33:
        if (this.connectStatus == r101.connectStatus) goto L36;
        return false;
    L36:
        if (this.enabled == r101.enabled) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.skillPackageId, r101.skillPackageId) == true) goto L42;
        return false;
    L42:
        if (this.skillType == r101.skillType) goto L45;
        return false;
    L45:
        if (this.recommend == r101.recommend) goto L48;
        return false;
    L48:
        if (this.f314375vendor == r101.f314375vendor) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.runtimeTypes, r101.runtimeTypes) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        String r100 = this.connectorId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.displayName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.description;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.displayDescription;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.icon;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((((((r115 + r117) * 31) + this.type) * 31) + this.installStatus) * 31) + this.connectStatus) * 31;
        int r119 = 1231;
        if (this.enabled == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.skillPackageId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (((r121 + r123) * 31) + this.skillType) * 31;
        if (this.recommend == true) goto L38;
        r119 = 1237;
    L38:
        int r125 = (((r124 + r119) * 31) + this.f314375vendor) * 31;
        List<Integer> r126 = this.runtimeTypes;
        if (r126 == null) goto L43;
        r101 = r126.hashCode();
    L43:
        return r125 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = 1237;
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConnectorRemoteItem(connectorId=" + this.connectorId + ", name=" + this.name + ", displayName=" + this.displayName + ", description=" + this.description + ", displayDescription=" + this.displayDescription + ", icon=" + this.icon + ", type=" + this.type + ", installStatus=" + this.installStatus + ", connectStatus=" + this.connectStatus + ", enabled=" + this.enabled + ", skillPackageId=" + this.skillPackageId + ", skillType=" + this.skillType + ", recommend=" + this.recommend + ", vendor=" + this.f314375vendor + ", runtimeTypes=" + this.runtimeTypes + ')';
    }

    public d() {
        this.connectorId = null;
        this.name = null;
        this.displayName = null;
        this.description = null;
        this.displayDescription = null;
        this.icon = null;
        this.type = 0;
        this.installStatus = 0;
        this.connectStatus = 0;
        this.enabled = false;
        this.skillPackageId = null;
        this.skillType = 0;
        this.recommend = false;
        this.f314375vendor = 0;
        this.runtimeTypes = null;
    }

    public final int a() {
        return this.connectStatus;
    }

    public final String b() {
        return this.connectorId;
    }

    public final String c() {
        return this.description;
    }

    public final String d() {
        return this.displayDescription;
    }

    public final String e() {
        return this.displayName;
    }

    public final boolean f() {
        return this.enabled;
    }

    public final String g() {
        return this.icon;
    }

    public final int getType() {
        return this.type;
    }

    public final int h() {
        return this.installStatus;
    }

    public final String i() {
        return this.name;
    }

    public final int j() {
        return this.skillType;
    }
}
