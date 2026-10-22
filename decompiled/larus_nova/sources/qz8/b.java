package qz8;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jé\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001a¨\u0006F"}, d2 = {"Lcom/larus/commercecredit/impl/entity/BasicInfo;", "", "titleLeft", "", "titleRight", "description", "bgImgPortraitUrl", "bgImgLandscapeUrl", "copyLinkText", "creditRuleButtonText", "creditRuleButtonSchema", "douyinInviteText", "wechatInviteText", "stepTitle", "stepList", "", "Lcom/larus/commercecredit/impl/entity/Step;", "totalAwardCreditLinkText", "totalAwardCreditLinkSchema", "totalInviteLinkText", "totalInviteLinkSchema", "totalAwardCreditText", "totalParticipantText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitleLeft", "()Ljava/lang/String;", "getTitleRight", "getDescription", "getBgImgPortraitUrl", "getBgImgLandscapeUrl", "getCopyLinkText", "getCreditRuleButtonText", "getCreditRuleButtonSchema", "getDouyinInviteText", "getWechatInviteText", "getStepTitle", "getStepList", "()Ljava/util/List;", "getTotalAwardCreditLinkText", "getTotalAwardCreditLinkSchema", "getTotalInviteLinkText", "getTotalInviteLinkSchema", "getTotalAwardCreditText", "getTotalParticipantText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("bg_img_landscape_url")
    private final String bgImgLandscapeUrl;

    @SerializedName("bg_img_portrait_url")
    private final String bgImgPortraitUrl;

    @SerializedName("copy_link_text")
    private final String copyLinkText;

    @SerializedName("credit_rule_button_schema")
    private final String creditRuleButtonSchema;

    @SerializedName("credit_rule_button_text")
    private final String creditRuleButtonText;

    @SerializedName("description")
    private final String description;

    @SerializedName("douyin_invite_text")
    private final String douyinInviteText;

    @SerializedName("step_list")
    private final List<o> stepList;

    @SerializedName("step_title")
    private final String stepTitle;

    @SerializedName("title_left")
    private final String titleLeft;

    @SerializedName("title_right")
    private final String titleRight;

    @SerializedName("total_award_credit_link_schema")
    private final String totalAwardCreditLinkSchema;

    @SerializedName("total_award_credit_link_text")
    private final String totalAwardCreditLinkText;

    @SerializedName("total_award_credit_text")
    private final String totalAwardCreditText;

    @SerializedName("total_invite_link_schema")
    private final String totalInviteLinkSchema;

    @SerializedName("total_invite_link_text")
    private final String totalInviteLinkText;

    @SerializedName("total_participant_text")
    private final String totalParticipantText;

    @SerializedName("wechat_invite_text")
    private final String wechatInviteText;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.titleLeft, r101.titleLeft) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.titleRight, r101.titleRight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgImgPortraitUrl, r101.bgImgPortraitUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bgImgLandscapeUrl, r101.bgImgLandscapeUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.copyLinkText, r101.copyLinkText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.creditRuleButtonText, r101.creditRuleButtonText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.creditRuleButtonSchema, r101.creditRuleButtonSchema) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.douyinInviteText, r101.douyinInviteText) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.wechatInviteText, r101.wechatInviteText) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.stepTitle, r101.stepTitle) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.stepList, r101.stepList) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.totalAwardCreditLinkText, r101.totalAwardCreditLinkText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.totalAwardCreditLinkSchema, r101.totalAwardCreditLinkSchema) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.totalInviteLinkText, r101.totalInviteLinkText) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.totalInviteLinkSchema, r101.totalInviteLinkSchema) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.totalAwardCreditText, r101.totalAwardCreditText) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.totalParticipantText, r101.totalParticipantText) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        String r100 = this.titleLeft;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.titleRight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.description;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bgImgPortraitUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bgImgLandscapeUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.copyLinkText;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.creditRuleButtonText;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.creditRuleButtonSchema;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.douyinInviteText;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.wechatInviteText;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.stepTitle;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        List<o> r134 = this.stepList;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.totalAwardCreditLinkText;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.totalAwardCreditLinkSchema;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.totalInviteLinkText;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.totalInviteLinkSchema;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.totalAwardCreditText;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.totalParticipantText;
        if (r152 == null) goto L75;
        r101 = r152.hashCode();
    L75:
        return r151 + r101;
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
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
        return "BasicInfo(titleLeft=" + this.titleLeft + ", titleRight=" + this.titleRight + ", description=" + this.description + ", bgImgPortraitUrl=" + this.bgImgPortraitUrl + ", bgImgLandscapeUrl=" + this.bgImgLandscapeUrl + ", copyLinkText=" + this.copyLinkText + ", creditRuleButtonText=" + this.creditRuleButtonText + ", creditRuleButtonSchema=" + this.creditRuleButtonSchema + ", douyinInviteText=" + this.douyinInviteText + ", wechatInviteText=" + this.wechatInviteText + ", stepTitle=" + this.stepTitle + ", stepList=" + this.stepList + ", totalAwardCreditLinkText=" + this.totalAwardCreditLinkText + ", totalAwardCreditLinkSchema=" + this.totalAwardCreditLinkSchema + ", totalInviteLinkText=" + this.totalInviteLinkText + ", totalInviteLinkSchema=" + this.totalInviteLinkSchema + ", totalAwardCreditText=" + this.totalAwardCreditText + ", totalParticipantText=" + this.totalParticipantText + ')';
    }

    public b() {
        this.titleLeft = null;
        this.titleRight = null;
        this.description = null;
        this.bgImgPortraitUrl = null;
        this.bgImgLandscapeUrl = null;
        this.copyLinkText = null;
        this.creditRuleButtonText = null;
        this.creditRuleButtonSchema = null;
        this.douyinInviteText = null;
        this.wechatInviteText = null;
        this.stepTitle = null;
        this.stepList = null;
        this.totalAwardCreditLinkText = null;
        this.totalAwardCreditLinkSchema = null;
        this.totalInviteLinkText = null;
        this.totalInviteLinkSchema = null;
        this.totalAwardCreditText = null;
        this.totalParticipantText = null;
    }

    public final String a() {
        return this.bgImgPortraitUrl;
    }

    public final String b() {
        return this.copyLinkText;
    }

    public final String c() {
        return this.creditRuleButtonSchema;
    }

    public final String d() {
        return this.creditRuleButtonText;
    }

    public final String e() {
        return this.description;
    }

    public final String f() {
        return this.douyinInviteText;
    }

    public final List<o> g() {
        return this.stepList;
    }

    public final String h() {
        return this.titleLeft;
    }

    public final String i() {
        return this.titleRight;
    }

    public final String j() {
        return this.wechatInviteText;
    }
}
