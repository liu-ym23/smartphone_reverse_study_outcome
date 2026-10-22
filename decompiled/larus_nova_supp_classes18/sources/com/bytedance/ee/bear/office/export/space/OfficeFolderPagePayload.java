package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public static /* synthetic */ OfficeFolderPagePayload copy$default(OfficeFolderPagePayload r11, Integer r12, int r13, String r14, String r15, String r16, String r17, boolean r18, boolean r19, OfficeSpaceTab r20, OfficeFolderListConfig r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        Integer r2 = r11.ownerType;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r3 = r11.permission;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.parentToken;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.parentSpaceId;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.currentModule;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.folderType;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r8 = r11.isExternal;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r9 = r11.isPersonalFolder;
    L35:
        if ((r22 & 256) == 0) goto L37;
        OfficeSpaceTab r10 = r11.sourceTab;
    L39:
        if ((r22 & 512) == 0) goto L41;
        OfficeFolderListConfig r1 = r11.listConfig;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
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

    public final OfficeFolderPagePayload copy(Integer r13, int r14, String r15, String r16, String r17, String r18, boolean r19, boolean r20, OfficeSpaceTab r21, OfficeFolderListConfig r22) {
        Intrinsics.checkNotNullParameter(r22, "listConfig");
        return new OfficeFolderPagePayload(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeFolderPagePayload) == true) goto L8;
        return false;
    L8:
        OfficeFolderPagePayload r6 = (OfficeFolderPagePayload) r5;
        if (Intrinsics.areEqual(this.ownerType, r6.ownerType) == true) goto L12;
        return false;
    L12:
        if (this.permission == r6.permission) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.parentToken, r6.parentToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parentSpaceId, r6.parentSpaceId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.currentModule, r6.currentModule) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.folderType, r6.folderType) == true) goto L27;
        return false;
    L27:
        if (this.isExternal == r6.isExternal) goto L30;
        return false;
    L30:
        if (this.isPersonalFolder == r6.isPersonalFolder) goto L33;
        return false;
    L33:
        if (this.sourceTab == r6.sourceTab) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.listConfig, r6.listConfig) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.ownerType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.permission) * 31;
        String r4 = this.parentToken;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.parentSpaceId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.currentModule;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.folderType;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        int r16 = 1231;
        if (this.isExternal == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.isPersonalFolder == true) goto L30;
        r16 = 1237;
    L30:
        int r19 = (r18 + r16) * 31;
        OfficeSpaceTab r20 = this.sourceTab;
        if (r20 == null) goto L35;
        r1 = r20.hashCode();
    L35:
        return ((r19 + r1) * 31) + this.listConfig.hashCode();
    L25:
        r17 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
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

    public OfficeFolderPagePayload(Integer r2, int r3, String r4, String r5, String r6, String r7, boolean r8, boolean r9, OfficeSpaceTab r10, OfficeFolderListConfig r11) {
        Intrinsics.checkNotNullParameter(r11, "listConfig");
        this.ownerType = r2;
        this.permission = r3;
        this.parentToken = r4;
        this.parentSpaceId = r5;
        this.currentModule = r6;
        this.folderType = r7;
        this.isExternal = r8;
        this.isPersonalFolder = r9;
        this.sourceTab = r10;
        this.listConfig = r11;
    }
}
