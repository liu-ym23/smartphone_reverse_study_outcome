package com.bytedance.ee.bear.secret;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010:\u001a\u00020\tJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\rHÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00103JÂ\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0007HÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010 \"\u0004\b%\u0010&R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010&R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010+R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010+R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010+R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010+R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b\u0016\u00103\"\u0004\b9\u00105¨\u0006S"}, d2 = {"Lcom/bytedance/ee/bear/secret/SecretLevel;", "Ljava/io/Serializable;", ResourceData.KEY_ID, "", "name", "description", "level", "", "enableProtect", "", "tips", "applyTips", "permissionControl", "Lcom/bytedance/ee/bear/secret/PermissionControl;", "isSelected", "canModify", "applyWarnTips", "applyTipsV2", "searchCheckboxDesc", "applyTipsNotSearchable", "searchable", "searchBoxStatus", "isSelectedSearch", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/secret/PermissionControl;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getLevel", "()I", "getEnableProtect", "()Z", "getTips", "getApplyTips", "getPermissionControl", "()Lcom/bytedance/ee/bear/secret/PermissionControl;", "setSelected", "(Z)V", "getCanModify", "setCanModify", "getApplyWarnTips", "setApplyWarnTips", "(Ljava/lang/String;)V", "getApplyTipsV2", "setApplyTipsV2", "getSearchCheckboxDesc", "setSearchCheckboxDesc", "getApplyTipsNotSearchable", "setApplyTipsNotSearchable", "getSearchable", "()Ljava/lang/Integer;", "setSearchable", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSearchBoxStatus", "setSearchBoxStatus", "setSelectedSearch", "isValid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/secret/PermissionControl;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/secret/SecretLevel;", "equals", "other", "", "hashCode", "toString", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretLevel implements Serializable {
    private final String applyTips;
    private String applyTipsNotSearchable;
    private String applyTipsV2;
    private String applyWarnTips;
    private boolean canModify;
    private final String description;
    private final boolean enableProtect;
    private final String id;
    private boolean isSelected;
    private Integer isSelectedSearch;
    private final int level;
    private final String name;
    private final PermissionControl permissionControl;
    private Integer searchBoxStatus;
    private String searchCheckboxDesc;
    private Integer searchable;
    private final String tips;

    public SecretLevel() {
        this(null, null, null, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ SecretLevel copy$default(SecretLevel r17, String r18, String r19, String r20, int r21, boolean r22, String r23, String r24, PermissionControl r25, boolean r26, boolean r27, String r28, String r29, String r30, String r31, Integer r32, Integer r33, Integer r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        String r2 = r17.id;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r3 = r17.name;
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r4 = r17.description;
    L15:
        if ((r35 & 8) == 0) goto L17;
        int r5 = r17.level;
    L19:
        if ((r35 & 16) == 0) goto L21;
        boolean r6 = r17.enableProtect;
    L23:
        if ((r35 & 32) == 0) goto L25;
        String r7 = r17.tips;
    L27:
        if ((r35 & 64) == 0) goto L29;
        String r8 = r17.applyTips;
    L31:
        if ((r35 & 128) == 0) goto L33;
        PermissionControl r9 = r17.permissionControl;
    L35:
        if ((r35 & 256) == 0) goto L37;
        boolean r10 = r17.isSelected;
    L39:
        if ((r35 & 512) == 0) goto L41;
        boolean r11 = r17.canModify;
    L43:
        if ((r35 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        String r12 = r17.applyWarnTips;
    L47:
        if ((r35 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        String r13 = r17.applyTipsV2;
    L51:
        if ((r35 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        String r14 = r17.searchCheckboxDesc;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        String r15 = r17.applyTipsNotSearchable;
    L58:
        String r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        Integer r16 = r17.searchable;
    L62:
        Integer r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        Integer r110 = r17.searchBoxStatus;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        Integer r1 = r17.isSelectedSearch;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.canModify;
    }

    public final String component11() {
        return this.applyWarnTips;
    }

    public final String component12() {
        return this.applyTipsV2;
    }

    public final String component13() {
        return this.searchCheckboxDesc;
    }

    public final String component14() {
        return this.applyTipsNotSearchable;
    }

    public final Integer component15() {
        return this.searchable;
    }

    public final Integer component16() {
        return this.searchBoxStatus;
    }

    public final Integer component17() {
        return this.isSelectedSearch;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final int component4() {
        return this.level;
    }

    public final boolean component5() {
        return this.enableProtect;
    }

    public final String component6() {
        return this.tips;
    }

    public final String component7() {
        return this.applyTips;
    }

    public final PermissionControl component8() {
        return this.permissionControl;
    }

    public final boolean component9() {
        return this.isSelected;
    }

    public final SecretLevel copy(String r21, String r22, String r23, int r24, boolean r25, String r26, String r27, PermissionControl r28, boolean r29, boolean r30, String r31, String r32, String r33, String r34, Integer r35, Integer r36, Integer r37) {
        Intrinsics.checkNotNullParameter(r21, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r22, "name");
        Intrinsics.checkNotNullParameter(r23, "description");
        Intrinsics.checkNotNullParameter(r26, "tips");
        Intrinsics.checkNotNullParameter(r27, "applyTips");
        Intrinsics.checkNotNullParameter(r28, "permissionControl");
        Intrinsics.checkNotNullParameter(r31, "applyWarnTips");
        Intrinsics.checkNotNullParameter(r32, "applyTipsV2");
        return new SecretLevel(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SecretLevel) == true) goto L8;
        return false;
    L8:
        SecretLevel r6 = (SecretLevel) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L18;
        return false;
    L18:
        if (this.level == r6.level) goto L21;
        return false;
    L21:
        if (this.enableProtect == r6.enableProtect) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tips, r6.tips) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.applyTips, r6.applyTips) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.permissionControl, r6.permissionControl) == true) goto L33;
        return false;
    L33:
        if (this.isSelected == r6.isSelected) goto L36;
        return false;
    L36:
        if (this.canModify == r6.canModify) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.applyWarnTips, r6.applyWarnTips) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.applyTipsV2, r6.applyTipsV2) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.searchCheckboxDesc, r6.searchCheckboxDesc) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.applyTipsNotSearchable, r6.applyTipsNotSearchable) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.searchable, r6.searchable) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.searchBoxStatus, r6.searchBoxStatus) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.isSelectedSearch, r6.isSelectedSearch) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.level) * 31;
        int r2 = 1231;
        if (this.enableProtect == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((((r0 + r1) * 31) + this.tips.hashCode()) * 31) + this.applyTips.hashCode()) * 31) + this.permissionControl.hashCode()) * 31;
        if (this.isSelected == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.canModify == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (((((r5 + r2) * 31) + this.applyWarnTips.hashCode()) * 31) + this.applyTipsV2.hashCode()) * 31;
        String r7 = this.searchCheckboxDesc;
        int r8 = 0;
        if (r7 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r6 + r9) * 31;
        String r11 = this.applyTipsNotSearchable;
        if (r11 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.searchable;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.searchBoxStatus;
        if (r17 != null) goto L29;
        int r18 = 0;
    L30:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.isSelectedSearch;
        if (r20 == null) goto L35;
        r8 = r20.hashCode();
    L35:
        return r19 + r8;
    L29:
        r18 = r17.hashCode();
        goto L30
    L25:
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = r11.hashCode();
        goto L22
    L17:
        r9 = r7.hashCode();
        goto L18
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "SecretLevel(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", level=" + this.level + ", enableProtect=" + this.enableProtect + ", tips=" + this.tips + ", applyTips=" + this.applyTips + ", permissionControl=" + this.permissionControl + ", isSelected=" + this.isSelected + ", canModify=" + this.canModify + ", applyWarnTips=" + this.applyWarnTips + ", applyTipsV2=" + this.applyTipsV2 + ", searchCheckboxDesc=" + this.searchCheckboxDesc + ", applyTipsNotSearchable=" + this.applyTipsNotSearchable + ", searchable=" + this.searchable + ", searchBoxStatus=" + this.searchBoxStatus + ", isSelectedSearch=" + this.isSelectedSearch + ')';
    }

    public final boolean isValid() {
        if (this.id.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getApplyTips() {
        return this.applyTips;
    }

    public final String getApplyTipsNotSearchable() {
        return this.applyTipsNotSearchable;
    }

    public final String getApplyTipsV2() {
        return this.applyTipsV2;
    }

    public final String getApplyWarnTips() {
        return this.applyWarnTips;
    }

    public final boolean getCanModify() {
        return this.canModify;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getEnableProtect() {
        return this.enableProtect;
    }

    public final String getId() {
        return this.id;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final PermissionControl getPermissionControl() {
        return this.permissionControl;
    }

    public final Integer getSearchBoxStatus() {
        return this.searchBoxStatus;
    }

    public final String getSearchCheckboxDesc() {
        return this.searchCheckboxDesc;
    }

    public final Integer getSearchable() {
        return this.searchable;
    }

    public final String getTips() {
        return this.tips;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final Integer isSelectedSearch() {
        return this.isSelectedSearch;
    }

    public final void setApplyTipsNotSearchable(String r1) {
        this.applyTipsNotSearchable = r1;
    }

    public final void setApplyTipsV2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.applyTipsV2 = r2;
    }

    public final void setApplyWarnTips(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.applyWarnTips = r2;
    }

    public final void setCanModify(boolean r1) {
        this.canModify = r1;
    }

    public final void setSearchBoxStatus(Integer r1) {
        this.searchBoxStatus = r1;
    }

    public final void setSearchCheckboxDesc(String r1) {
        this.searchCheckboxDesc = r1;
    }

    public final void setSearchable(Integer r1) {
        this.searchable = r1;
    }

    public final void setSelected(boolean r1) {
        this.isSelected = r1;
    }

    public final void setSelectedSearch(Integer r1) {
        this.isSelectedSearch = r1;
    }

    public SecretLevel(String r11, String r12, String r13, int r14, boolean r15, String r16, String r17, PermissionControl r18, boolean r19, boolean r20, String r21, String r22, String r23, String r24, Integer r25, Integer r26, Integer r27) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r12, "name");
        Intrinsics.checkNotNullParameter(r13, "description");
        Intrinsics.checkNotNullParameter(r16, "tips");
        Intrinsics.checkNotNullParameter(r17, "applyTips");
        Intrinsics.checkNotNullParameter(r18, "permissionControl");
        Intrinsics.checkNotNullParameter(r21, "applyWarnTips");
        Intrinsics.checkNotNullParameter(r22, "applyTipsV2");
        this.id = r11;
        this.name = r12;
        this.description = r13;
        this.level = r14;
        this.enableProtect = r15;
        this.tips = r16;
        this.applyTips = r17;
        this.permissionControl = r18;
        this.isSelected = r19;
        this.canModify = r20;
        this.applyWarnTips = r21;
        this.applyTipsV2 = r22;
        this.searchCheckboxDesc = r23;
        this.applyTipsNotSearchable = r24;
        this.searchable = r25;
        this.searchBoxStatus = r26;
        this.isSelectedSearch = r27;
    }

    public /* synthetic */ SecretLevel(String r27, String r28, String r29, int r30, boolean r31, String r32, String r33, PermissionControl r34, boolean r35, boolean r36, String r37, String r38, String r39, String r40, Integer r41, Integer r42, Integer r43, int r44, DefaultConstructorMarker r45) {
        String r2 = "";
        if ((r44 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r44 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r44 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r44 & 8) == 0) goto L17;
        int r5 = 0;
    L19:
        if ((r44 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r44 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r44 & 128) == 0) goto L33;
        PermissionControl r10 = new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, 4095, null);
    L35:
        if ((r44 & 256) == 0) goto L37;
        boolean r11 = false;
    L39:
        if ((r44 & 512) == 0) goto L41;
        boolean r12 = true;
    L43:
        if ((r44 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r44 & DocUserPermission.USER_PREVIEW) != 0) goto L51;
        r2 = r38;
    L51:
        if ((r44 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r44 & 8192) == 0) goto L57;
        String r15 = null;
    L58:
        String r46 = r15;
        if ((r44 & 16384) == 0) goto L61;
        Integer r16 = 0;
    L63:
        if ((r44 & 32768) == 0) goto L65;
        Integer r6 = 0;
    L67:
        if ((r44 & 65536) == 0) goto L69;
        Integer r0 = null;
    L70:
        this(r1, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r2, r14, r46, r16, r6, r0);
        return;
    L69:
        r0 = r43;
        goto L70
    L65:
        r6 = r42;
        goto L67
    L61:
        r16 = r41;
        goto L63
    L57:
        r15 = r40;
        goto L58
    L53:
        r14 = r39;
        goto L55
    L45:
        r13 = r37;
        goto L47
    L41:
        r12 = r36;
        goto L43
    L37:
        r11 = r35;
        goto L39
    L33:
        r10 = r34;
        goto L35
    L29:
        r9 = r33;
        goto L31
    L25:
        r8 = r32;
        goto L27
    L21:
        r7 = r31;
        goto L23
    L17:
        r5 = r30;
        goto L19
    L13:
        r4 = r29;
        goto L15
    L9:
        r3 = r28;
        goto L11
    L5:
        r1 = r27;
        goto L7
    }
}
