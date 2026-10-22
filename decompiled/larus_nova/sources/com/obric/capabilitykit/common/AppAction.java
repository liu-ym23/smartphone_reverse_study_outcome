package com.obric.capabilitykit.common;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jy\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/AppAction;", "", "packageName", "", "action", "params", "intent", "type", "", "shortcutId", "interfaceName", "targetPkgName", "logPb", "implClassName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getImplClassName", "getIntent", "getInterfaceName", "getLogPb", "getPackageName", "getParams", "setParams", "(Ljava/lang/String;)V", "getShortcutId", "getTargetPkgName", "getType", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppAction {

    @SerializedName("OperationId")
    private final String action;
    private final String implClassName;

    @SerializedName("Intent")
    private final String intent;
    private final String interfaceName;
    private final String logPb;

    @SerializedName("Package")
    private final String packageName;

    @SerializedName("Params")
    private String params;

    @SerializedName("ShortcutId")
    private final String shortcutId;
    private final String targetPkgName;

    @SerializedName("LocalToolType")
    private final int type;

    public AppAction(String r100, String r101, String r102, String r103, int r104, String r105, String r106, String r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.packageName = r100;
        this.action = r101;
        this.params = r102;
        this.intent = r103;
        this.type = r104;
        this.shortcutId = r105;
        this.interfaceName = r106;
        this.targetPkgName = r107;
        this.logPb = r110;
        this.implClassName = r111;
    }

    public /* synthetic */ AppAction(String r110, String r111, String r112, String r113, int r114, String r210, String r211, String r212, String r213, String r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 16) == 0) goto L9;
        ToolType r101 = ToolType.UNDEF;
        int r102 = 1;
    L11:
        if ((r215 & 32) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r215 & 64) == 0) goto L17;
        String r115 = null;
    L19:
        if ((r215 & 128) == 0) goto L21;
        String r116 = null;
    L23:
        if ((r215 & 256) == 0) goto L25;
        String r117 = null;
    L27:
        if ((r215 & 512) == 0) goto L29;
        String r118 = null;
    L30:
        this(r110, r111, r112, r100, r102, r103, r115, r116, r117, r118);
        return;
    L29:
        r118 = r214;
        goto L30
    L25:
        r117 = r213;
        goto L27
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public static /* synthetic */ AppAction copy$default(AppAction r110, String r111, String r112, String r113, String r114, int r115, String r116, String r117, String r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.packageName;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.action;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.params;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.intent;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.type;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.shortcutId;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.interfaceName;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.targetPkgName;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.logPb;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.implClassName;
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

    public final String component1() {
        return this.packageName;
    }

    public final String component10() {
        return this.implClassName;
    }

    public final String component2() {
        return this.action;
    }

    public final String component3() {
        return this.params;
    }

    public final String component4() {
        return this.intent;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.shortcutId;
    }

    public final String component7() {
        return this.interfaceName;
    }

    public final String component8() {
        return this.targetPkgName;
    }

    public final String component9() {
        return this.logPb;
    }

    public final AppAction copy(String r110, String r111, String r112, String r113, int r114, String r115, String r116, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "packageName");
        Intrinsics.checkNotNullParameter(r111, "action");
        Intrinsics.checkNotNullParameter(r112, "params");
        return new AppAction(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppAction) == true) goto L8;
        return false;
    L8:
        AppAction r101 = (AppAction) r100;
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.intent, r101.intent) == true) goto L21;
        return false;
    L21:
        if (this.type == r101.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shortcutId, r101.shortcutId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.interfaceName, r101.interfaceName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.targetPkgName, r101.targetPkgName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.logPb, r101.logPb) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.implClassName, r101.implClassName) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final String getInterfaceName() {
        return this.interfaceName;
    }

    public final String getLogPb() {
        return this.logPb;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getShortcutId() {
        return this.shortcutId;
    }

    public final String getTargetPkgName() {
        return this.targetPkgName;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r100 = ((((this.packageName.hashCode() * 31) + this.action.hashCode()) * 31) + this.params.hashCode()) * 31;
        String r101 = this.intent;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.type) * 31;
        String r105 = this.shortcutId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.interfaceName;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.targetPkgName;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.logPb;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.implClassName;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final void setParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public String toString() {
        return "AppAction(packageName=" + this.packageName + ", action=" + this.action + ", params=" + this.params + ", intent=" + this.intent + ", type=" + this.type + ", shortcutId=" + this.shortcutId + ", interfaceName=" + this.interfaceName + ", targetPkgName=" + this.targetPkgName + ", logPb=" + this.logPb + ", implClassName=" + this.implClassName + ')';
    }
}
