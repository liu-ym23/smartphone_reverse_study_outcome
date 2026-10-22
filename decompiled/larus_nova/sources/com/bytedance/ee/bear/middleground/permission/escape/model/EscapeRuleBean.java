package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.google.gson.annotations.SerializedName;
import du5.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\"\u001a\u00020\u0003H\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003JY\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0019¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;", "Ljava/io/Serializable;", "token", "", "type", "", "escapeSetting", "approvalDef", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDef;", "permReqType", "permReqParam", "isWiki", "", "escapeScene", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDef;ILjava/lang/String;ZI)V", "getToken", "()Ljava/lang/String;", "getType", "()I", "getEscapeSetting", "getApprovalDef", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDef;", "getPermReqType", "setPermReqType", "(I)V", "getPermReqParam", "setPermReqParam", "(Ljava/lang/String;)V", "()Z", "setWiki", "(Z)V", "getEscapeScene", "setEscapeScene", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EscapeRuleBean implements Serializable {

    @SerializedName("approval_def")
    private final ApprovalDef approvalDef;
    private int escapeScene;

    @SerializedName("escape_setting")
    private final String escapeSetting;
    private boolean isWiki;

    @SerializedName("perm_req_param")
    private String permReqParam;

    @SerializedName("perm_req_type")
    private int permReqType;
    private final String token;
    private final int type;

    public static /* synthetic */ EscapeRuleBean copy$default(EscapeRuleBean r100, String r110, int r111, String r112, ApprovalDef r113, int r114, String r115, boolean r116, int r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.token;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.type;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.escapeSetting;
    L15:
        if ((r118 & 8) == 0) goto L17;
        ApprovalDef r104 = r100.approvalDef;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.permReqType;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.permReqParam;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.isWiki;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r108 = r100.escapeScene;
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
        return this.token;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.escapeSetting;
    }

    public final ApprovalDef component4() {
        return this.approvalDef;
    }

    public final int component5() {
        return this.permReqType;
    }

    public final String component6() {
        return this.permReqParam;
    }

    public final boolean component7() {
        return this.isWiki;
    }

    public final int component8() {
        return this.escapeScene;
    }

    public final EscapeRuleBean copy(String r110, int r111, String r112, ApprovalDef r113, int r114, String r115, boolean r116, int r117) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "escapeSetting");
        Intrinsics.checkNotNullParameter(r113, "approvalDef");
        Intrinsics.checkNotNullParameter(r115, "permReqParam");
        return new EscapeRuleBean(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EscapeRuleBean) == true) goto L8;
        return false;
    L8:
        EscapeRuleBean r101 = (EscapeRuleBean) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.escapeSetting, r101.escapeSetting) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.approvalDef, r101.approvalDef) == true) goto L21;
        return false;
    L21:
        if (this.permReqType == r101.permReqType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.permReqParam, r101.permReqParam) == true) goto L27;
        return false;
    L27:
        if (this.isWiki == r101.isWiki) goto L30;
        return false;
    L30:
        if (this.escapeScene == r101.escapeScene) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.token.hashCode() * 31) + this.type) * 31) + this.escapeSetting.hashCode()) * 31) + this.approvalDef.hashCode()) * 31) + this.permReqType) * 31) + this.permReqParam.hashCode()) * 31;
        if (this.isWiki == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.escapeScene;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "EscapeRuleBean(token='" + b.i(this.token) + "', type=" + this.type + ", escapeSetting='" + this.escapeSetting + "', approvalDef=" + this.approvalDef + ", permReqType=" + this.permReqType + ", permReqParam='" + this.permReqParam.length() + ", isWiki='" + this.isWiki + "')";
    }

    public final ApprovalDef getApprovalDef() {
        return this.approvalDef;
    }

    public final int getEscapeScene() {
        return this.escapeScene;
    }

    public final String getEscapeSetting() {
        return this.escapeSetting;
    }

    public final String getPermReqParam() {
        return this.permReqParam;
    }

    public final int getPermReqType() {
        return this.permReqType;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isWiki() {
        return this.isWiki;
    }

    public final void setEscapeScene(int r100) {
        this.escapeScene = r100;
    }

    public final void setPermReqParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.permReqParam = r100;
    }

    public final void setPermReqType(int r100) {
        this.permReqType = r100;
    }

    public final void setWiki(boolean r100) {
        this.isWiki = r100;
    }

    public EscapeRuleBean(String r100, int r101, String r102, ApprovalDef r103, int r104, String r105, boolean r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "escapeSetting");
        Intrinsics.checkNotNullParameter(r103, "approvalDef");
        Intrinsics.checkNotNullParameter(r105, "permReqParam");
        this.token = r100;
        this.type = r101;
        this.escapeSetting = r102;
        this.approvalDef = r103;
        this.permReqType = r104;
        this.permReqParam = r105;
        this.isWiki = r106;
        this.escapeScene = r107;
    }

    public /* synthetic */ EscapeRuleBean(String r110, int r111, String r112, ApprovalDef r113, int r114, String r115, boolean r116, int r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 64) == 0) goto L5;
        boolean r117 = false;
    L7:
        if ((r211 & 128) == 0) goto L9;
        int r118 = 0;
    L10:
        this(r110, r111, r112, r113, r114, r115, r117, r118);
        return;
    L9:
        r118 = r210;
        goto L10
    L5:
        r117 = r116;
        goto L7
    }
}
