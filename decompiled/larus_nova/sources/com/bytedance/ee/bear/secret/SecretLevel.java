package com.bytedance.ee.bear.secret;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010:\u001a\u00020\tJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\rHÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00103JÂ\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0007HÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010 \"\u0004\b%\u0010&R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010&R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010+R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010+R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010+R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010+R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b\u0016\u00103\"\u0004\b9\u00105¨\u0006S"}, d2 = {"Lcom/bytedance/ee/bear/secret/SecretLevel;", "Ljava/io/Serializable;", "id", "", "name", "description", "level", "", "enableProtect", "", "tips", "applyTips", "permissionControl", "Lcom/bytedance/ee/bear/secret/PermissionControl;", "isSelected", "canModify", "applyWarnTips", "applyTipsV2", "searchCheckboxDesc", "applyTipsNotSearchable", "searchable", "searchBoxStatus", "isSelectedSearch", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/secret/PermissionControl;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getLevel", "()I", "getEnableProtect", "()Z", "getTips", "getApplyTips", "getPermissionControl", "()Lcom/bytedance/ee/bear/secret/PermissionControl;", "setSelected", "(Z)V", "getCanModify", "setCanModify", "getApplyWarnTips", "setApplyWarnTips", "(Ljava/lang/String;)V", "getApplyTipsV2", "setApplyTipsV2", "getSearchCheckboxDesc", "setSearchCheckboxDesc", "getApplyTipsNotSearchable", "setApplyTipsNotSearchable", "getSearchable", "()Ljava/lang/Integer;", "setSearchable", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSearchBoxStatus", "setSearchBoxStatus", "setSelectedSearch", "isValid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/secret/PermissionControl;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/secret/SecretLevel;", "equals", "other", "", "hashCode", "toString", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretLevel implements Serializable {
    private final String applyTips;
    private String applyTipsNotSearchable;
    private String applyTipsV2;
    private String applyWarnTips;
    private boolean canModify;
    private final String description;
    private final boolean enableProtect;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f236989id;
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

    public static /* synthetic */ SecretLevel copy$default(SecretLevel r110, String r111, String r112, String r210, int r211, boolean r212, String r213, String r214, PermissionControl r215, boolean r216, boolean r217, String r218, String r219, String r310, String r311, Integer r312, Integer r313, Integer r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.f236989id;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = r110.description;
    L15:
        if ((r315 & 8) == 0) goto L17;
        int r103 = r110.level;
    L19:
        if ((r315 & 16) == 0) goto L21;
        boolean r104 = r110.enableProtect;
    L23:
        if ((r315 & 32) == 0) goto L25;
        String r105 = r110.tips;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r106 = r110.applyTips;
    L31:
        if ((r315 & 128) == 0) goto L33;
        PermissionControl r107 = r110.permissionControl;
    L35:
        if ((r315 & 256) == 0) goto L37;
        boolean r113 = r110.isSelected;
    L39:
        if ((r315 & 512) == 0) goto L41;
        boolean r114 = r110.canModify;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r110.applyWarnTips;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.applyTipsV2;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r117 = r110.searchCheckboxDesc;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        String r118 = r110.applyTipsNotSearchable;
    L58:
        String r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        Integer r119 = r110.searchable;
    L62:
        Integer r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        Integer r120 = r110.searchBoxStatus;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        Integer r108 = r110.isSelectedSearch;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f236989id;
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

    public final SecretLevel copy(String r210, String r211, String r212, int r213, boolean r214, String r215, String r216, PermissionControl r217, boolean r218, boolean r310, String r311, String r312, String r313, String r314, Integer r315, Integer r316, Integer r317) {
        Intrinsics.checkNotNullParameter(r210, "id");
        Intrinsics.checkNotNullParameter(r211, "name");
        Intrinsics.checkNotNullParameter(r212, "description");
        Intrinsics.checkNotNullParameter(r215, "tips");
        Intrinsics.checkNotNullParameter(r216, "applyTips");
        Intrinsics.checkNotNullParameter(r217, "permissionControl");
        Intrinsics.checkNotNullParameter(r311, "applyWarnTips");
        Intrinsics.checkNotNullParameter(r312, "applyTipsV2");
        return new SecretLevel(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecretLevel) == true) goto L8;
        return false;
    L8:
        SecretLevel r101 = (SecretLevel) r100;
        if (Intrinsics.areEqual(this.f236989id, r101.f236989id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L18;
        return false;
    L18:
        if (this.level == r101.level) goto L21;
        return false;
    L21:
        if (this.enableProtect == r101.enableProtect) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.applyTips, r101.applyTips) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.permissionControl, r101.permissionControl) == true) goto L33;
        return false;
    L33:
        if (this.isSelected == r101.isSelected) goto L36;
        return false;
    L36:
        if (this.canModify == r101.canModify) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.applyWarnTips, r101.applyWarnTips) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.applyTipsV2, r101.applyTipsV2) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.searchCheckboxDesc, r101.searchCheckboxDesc) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.applyTipsNotSearchable, r101.applyTipsNotSearchable) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.searchable, r101.searchable) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.searchBoxStatus, r101.searchBoxStatus) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.isSelectedSearch, r101.isSelectedSearch) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.f236989id.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.level) * 31;
        int r101 = 1231;
        if (this.enableProtect == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((r100 + r102) * 31) + this.tips.hashCode()) * 31) + this.applyTips.hashCode()) * 31) + this.permissionControl.hashCode()) * 31;
        if (this.isSelected == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.canModify == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (((((r105 + r101) * 31) + this.applyWarnTips.hashCode()) * 31) + this.applyTipsV2.hashCode()) * 31;
        String r107 = this.searchCheckboxDesc;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        String r111 = this.applyTipsNotSearchable;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.searchable;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.searchBoxStatus;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.isSelectedSearch;
        if (r120 == null) goto L35;
        r108 = r120.hashCode();
    L35:
        return r119 + r108;
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r107.hashCode();
        goto L18
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "SecretLevel(id=" + this.f236989id + ", name=" + this.name + ", description=" + this.description + ", level=" + this.level + ", enableProtect=" + this.enableProtect + ", tips=" + this.tips + ", applyTips=" + this.applyTips + ", permissionControl=" + this.permissionControl + ", isSelected=" + this.isSelected + ", canModify=" + this.canModify + ", applyWarnTips=" + this.applyWarnTips + ", applyTipsV2=" + this.applyTipsV2 + ", searchCheckboxDesc=" + this.searchCheckboxDesc + ", applyTipsNotSearchable=" + this.applyTipsNotSearchable + ", searchable=" + this.searchable + ", searchBoxStatus=" + this.searchBoxStatus + ", isSelectedSearch=" + this.isSelectedSearch + ')';
    }

    public final boolean isValid() {
        if (this.f236989id.length() <= 0) goto L5;
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
        return this.f236989id;
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

    public final void setApplyTipsNotSearchable(String r100) {
        this.applyTipsNotSearchable = r100;
    }

    public final void setApplyTipsV2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.applyTipsV2 = r100;
    }

    public final void setApplyWarnTips(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.applyWarnTips = r100;
    }

    public final void setCanModify(boolean r100) {
        this.canModify = r100;
    }

    public final void setSearchBoxStatus(Integer r100) {
        this.searchBoxStatus = r100;
    }

    public final void setSearchCheckboxDesc(String r100) {
        this.searchCheckboxDesc = r100;
    }

    public final void setSearchable(Integer r100) {
        this.searchable = r100;
    }

    public final void setSelected(boolean r100) {
        this.isSelected = r100;
    }

    public final void setSelectedSearch(Integer r100) {
        this.isSelectedSearch = r100;
    }

    public SecretLevel(String r110, String r111, String r112, int r113, boolean r114, String r115, String r116, PermissionControl r117, boolean r118, boolean r210, String r211, String r212, String r213, String r214, Integer r215, Integer r216, Integer r217) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "description");
        Intrinsics.checkNotNullParameter(r115, "tips");
        Intrinsics.checkNotNullParameter(r116, "applyTips");
        Intrinsics.checkNotNullParameter(r117, "permissionControl");
        Intrinsics.checkNotNullParameter(r211, "applyWarnTips");
        Intrinsics.checkNotNullParameter(r212, "applyTipsV2");
        this.f236989id = r110;
        this.name = r111;
        this.description = r112;
        this.level = r113;
        this.enableProtect = r114;
        this.tips = r115;
        this.applyTips = r116;
        this.permissionControl = r117;
        this.isSelected = r118;
        this.canModify = r210;
        this.applyWarnTips = r211;
        this.applyTipsV2 = r212;
        this.searchCheckboxDesc = r213;
        this.applyTipsNotSearchable = r214;
        this.searchable = r215;
        this.searchBoxStatus = r216;
        this.isSelectedSearch = r217;
    }

    public /* synthetic */ SecretLevel(String r210, String r211, String r212, int r310, boolean r311, String r312, String r313, PermissionControl r314, boolean r315, boolean r316, String r317, String r318, String r319, String r410, Integer r411, Integer r412, Integer r413, int r414, DefaultConstructorMarker r415) {
        String r100 = "";
        if ((r414 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r414 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r414 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r414 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r414 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r414 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r414 & 128) == 0) goto L33;
        PermissionControl r110 = new PermissionControl(0, 0, 0, 0, false, 0, 0, false, 0, 0, 0, 0, UnixStat.PERM_MASK, null);
    L35:
        if ((r414 & 256) == 0) goto L37;
        boolean r111 = false;
    L39:
        if ((r414 & 512) == 0) goto L41;
        boolean r112 = true;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r414 & 2048) != 0) goto L51;
        r100 = r318;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        String r115 = null;
    L58:
        String r416 = r115;
        if ((r414 & 16384) == 0) goto L61;
        Integer r116 = 0;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        Integer r108 = 0;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        Integer r109 = null;
    L70:
        this(r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r100, r114, r416, r116, r108, r109);
        return;
    L69:
        r109 = r413;
        goto L70
    L65:
        r108 = r412;
        goto L67
    L61:
        r116 = r411;
        goto L63
    L57:
        r115 = r410;
        goto L58
    L53:
        r114 = r319;
        goto L55
    L45:
        r113 = r317;
        goto L47
    L41:
        r112 = r316;
        goto L43
    L37:
        r111 = r315;
        goto L39
    L33:
        r110 = r314;
        goto L35
    L29:
        r107 = r313;
        goto L31
    L25:
        r106 = r312;
        goto L27
    L21:
        r105 = r311;
        goto L23
    L17:
        r104 = r310;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
