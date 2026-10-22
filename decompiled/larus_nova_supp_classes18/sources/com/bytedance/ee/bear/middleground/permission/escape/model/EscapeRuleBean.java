package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.annotations.SerializedName;
import du5.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\"\u001a\u00020\u0003H\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003JY\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0019¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/EscapeRuleBean;", "Ljava/io/Serializable;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "escapeSetting", "approvalDef", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDef;", "permReqType", "permReqParam", "isWiki", "", "escapeScene", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDef;ILjava/lang/String;ZI)V", "getToken", "()Ljava/lang/String;", "getType", "()I", "getEscapeSetting", "getApprovalDef", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalDef;", "getPermReqType", "setPermReqType", "(I)V", "getPermReqParam", "setPermReqParam", "(Ljava/lang/String;)V", "()Z", "setWiki", "(Z)V", "getEscapeScene", "setEscapeScene", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static /* synthetic */ EscapeRuleBean copy$default(EscapeRuleBean r9, String r10, int r11, String r12, ApprovalDef r13, int r14, String r15, boolean r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.token;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = r9.type;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.escapeSetting;
    L15:
        if ((r18 & 8) == 0) goto L17;
        ApprovalDef r5 = r9.approvalDef;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r6 = r9.permReqType;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.permReqParam;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.isWiki;
    L31:
        if ((r18 & 128) == 0) goto L33;
        int r1 = r9.escapeScene;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
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

    public final EscapeRuleBean copy(String r11, int r12, String r13, ApprovalDef r14, int r15, String r16, boolean r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r13, "escapeSetting");
        Intrinsics.checkNotNullParameter(r14, "approvalDef");
        Intrinsics.checkNotNullParameter(r16, "permReqParam");
        return new EscapeRuleBean(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EscapeRuleBean) == true) goto L8;
        return false;
    L8:
        EscapeRuleBean r6 = (EscapeRuleBean) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (this.type == r6.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.escapeSetting, r6.escapeSetting) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.approvalDef, r6.approvalDef) == true) goto L21;
        return false;
    L21:
        if (this.permReqType == r6.permReqType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.permReqParam, r6.permReqParam) == true) goto L27;
        return false;
    L27:
        if (this.isWiki == r6.isWiki) goto L30;
        return false;
    L30:
        if (this.escapeScene == r6.escapeScene) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.token.hashCode() * 31) + this.type) * 31) + this.escapeSetting.hashCode()) * 31) + this.approvalDef.hashCode()) * 31) + this.permReqType) * 31) + this.permReqParam.hashCode()) * 31;
        if (this.isWiki == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.escapeScene;
    L5:
        r1 = 1237;
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

    public final void setEscapeScene(int r1) {
        this.escapeScene = r1;
    }

    public final void setPermReqParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.permReqParam = r2;
    }

    public final void setPermReqType(int r1) {
        this.permReqType = r1;
    }

    public final void setWiki(boolean r1) {
        this.isWiki = r1;
    }

    public EscapeRuleBean(String r2, int r3, String r4, ApprovalDef r5, int r6, String r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "escapeSetting");
        Intrinsics.checkNotNullParameter(r5, "approvalDef");
        Intrinsics.checkNotNullParameter(r7, "permReqParam");
        this.token = r2;
        this.type = r3;
        this.escapeSetting = r4;
        this.approvalDef = r5;
        this.permReqType = r6;
        this.permReqParam = r7;
        this.isWiki = r8;
        this.escapeScene = r9;
    }

    public /* synthetic */ EscapeRuleBean(String r13, int r14, String r15, ApprovalDef r16, int r17, String r18, boolean r19, int r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 64) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r21 & 128) == 0) goto L9;
        int r11 = 0;
    L10:
        this(r13, r14, r15, r16, r17, r18, r10, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r10 = r19;
        goto L7
    }
}
