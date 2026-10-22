package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003J~\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001dR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPagePayload;", "Ljava/io/Serializable;", "ownerType", "", "permission", "parentToken", "", "parentSpaceId", "currentModule", "folderType", "isExternal", "", "isPersonalFolder", "sourceTab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "listConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderListConfig;", "<init>", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Lcom/bytedance/ee/bear/office/export/space/OfficeFolderListConfig;)V", "getOwnerType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPermission", "()I", "getParentToken", "()Ljava/lang/String;", "getParentSpaceId", "getCurrentModule", "getFolderType", "()Z", "getSourceTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getListConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeFolderListConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Lcom/bytedance/ee/bear/office/export/space/OfficeFolderListConfig;)Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPagePayload;", "equals", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFolderPagePayload implements Serializable {
    private final String currentModule;
    private final String folderType;
    private final boolean isExternal;
    private final boolean isPersonalFolder;
    private final OfficeFolderListConfig listConfig;
    private final Integer ownerType;
    private final String parentSpaceId;
    private final String parentToken;
    private final int permission;
    private final OfficeSpaceTab sourceTab;

    public static /* synthetic */ OfficeFolderPagePayload copy$default(OfficeFolderPagePayload r110, Integer r111, int r112, String r113, String r114, String r115, String r116, boolean r117, boolean r118, OfficeSpaceTab r210, OfficeFolderListConfig r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Integer r100 = r110.ownerType;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.permission;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.parentToken;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.parentSpaceId;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.currentModule;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.folderType;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r106 = r110.isExternal;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.isPersonalFolder;
    L35:
        if ((r212 & 256) == 0) goto L37;
        OfficeSpaceTab r119 = r110.sourceTab;
    L39:
        if ((r212 & 512) == 0) goto L41;
        OfficeFolderListConfig r108 = r110.listConfig;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Integer component1() {
        return this.ownerType;
    }

    public final OfficeFolderListConfig component10() {
        return this.listConfig;
    }

    public final int component2() {
        return this.permission;
    }

    public final String component3() {
        return this.parentToken;
    }

    public final String component4() {
        return this.parentSpaceId;
    }

    public final String component5() {
        return this.currentModule;
    }

    public final String component6() {
        return this.folderType;
    }

    public final boolean component7() {
        return this.isExternal;
    }

    public final boolean component8() {
        return this.isPersonalFolder;
    }

    public final OfficeSpaceTab component9() {
        return this.sourceTab;
    }

    public final OfficeFolderPagePayload copy(Integer r110, int r111, String r112, String r113, String r114, String r115, boolean r116, boolean r210, OfficeSpaceTab r211, OfficeFolderListConfig r212) {
        Intrinsics.checkNotNullParameter(r212, "listConfig");
        return new OfficeFolderPagePayload(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeFolderPagePayload) == true) goto L8;
        return false;
    L8:
        OfficeFolderPagePayload r101 = (OfficeFolderPagePayload) r100;
        if (Intrinsics.areEqual(this.ownerType, r101.ownerType) == true) goto L12;
        return false;
    L12:
        if (this.permission == r101.permission) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.parentToken, r101.parentToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parentSpaceId, r101.parentSpaceId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.currentModule, r101.currentModule) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.folderType, r101.folderType) == true) goto L27;
        return false;
    L27:
        if (this.isExternal == r101.isExternal) goto L30;
        return false;
    L30:
        if (this.isPersonalFolder == r101.isPersonalFolder) goto L33;
        return false;
    L33:
        if (this.sourceTab == r101.sourceTab) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.listConfig, r101.listConfig) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.ownerType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.permission) * 31;
        String r104 = this.parentToken;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.parentSpaceId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.currentModule;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.folderType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.isExternal == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.isPersonalFolder == true) goto L30;
        r116 = 1237;
    L30:
        int r119 = (r118 + r116) * 31;
        OfficeSpaceTab r120 = this.sourceTab;
        if (r120 == null) goto L35;
        r101 = r120.hashCode();
    L35:
        return ((r119 + r101) * 31) + this.listConfig.hashCode();
    L25:
        r117 = 1237;
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

    public String toString() {
        return "OfficeFolderPagePayload(ownerType=" + this.ownerType + ", permission=" + this.permission + ", parentToken=" + this.parentToken + ", parentSpaceId=" + this.parentSpaceId + ", currentModule=" + this.currentModule + ", folderType=" + this.folderType + ", isExternal=" + this.isExternal + ", isPersonalFolder=" + this.isPersonalFolder + ", sourceTab=" + this.sourceTab + ", listConfig=" + this.listConfig + ')';
    }

    public final String getCurrentModule() {
        return this.currentModule;
    }

    public final String getFolderType() {
        return this.folderType;
    }

    public final OfficeFolderListConfig getListConfig() {
        return this.listConfig;
    }

    public final Integer getOwnerType() {
        return this.ownerType;
    }

    public final String getParentSpaceId() {
        return this.parentSpaceId;
    }

    public final String getParentToken() {
        return this.parentToken;
    }

    public final int getPermission() {
        return this.permission;
    }

    public final OfficeSpaceTab getSourceTab() {
        return this.sourceTab;
    }

    public final boolean isExternal() {
        return this.isExternal;
    }

    public final boolean isPersonalFolder() {
        return this.isPersonalFolder;
    }

    public OfficeFolderPagePayload(Integer r100, int r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, OfficeSpaceTab r110, OfficeFolderListConfig r111) {
        Intrinsics.checkNotNullParameter(r111, "listConfig");
        this.ownerType = r100;
        this.permission = r101;
        this.parentToken = r102;
        this.parentSpaceId = r103;
        this.currentModule = r104;
        this.folderType = r105;
        this.isExternal = r106;
        this.isPersonalFolder = r107;
        this.sourceTab = r110;
        this.listConfig = r111;
    }
}
