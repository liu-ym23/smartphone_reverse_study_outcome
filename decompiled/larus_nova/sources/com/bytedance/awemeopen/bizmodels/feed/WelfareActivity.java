package com.bytedance.awemeopen.bizmodels.feed;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b-\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0016J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00104\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00105\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJÌ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u00010BH\u0096\u0002J\b\u0010C\u001a\u00020DH\u0016J\u0006\u0010E\u001a\u00020\u0014J\u0006\u0010F\u001a\u00020\u0014J\u0006\u0010G\u001a\u00020\u0014J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b%\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b-\u0010\u001b¨\u0006I"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/WelfareActivity;", "Ljava/io/Serializable;", "title", "", "description", "projectId", "", "projectName", "projectSchema", "organizationName", "organizationId", "organizationSecId", "donateMoney", "donateSponsor", "donateRange", "", "donateDeadline", "usedDonateMoney", "donateUserCount", "newMatchDonateUser", "", AiBotPollingAuthResult.STATUS_EXPIRED, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;[ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getDescription", "()Ljava/lang/String;", "getDonateDeadline", "getDonateMoney", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDonateRange", "()[I", "getDonateSponsor", "getDonateUserCount", "getExpired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNewMatchDonateUser", "getOrganizationId", "getOrganizationName", "getOrganizationSecId", "getProjectId", "()J", "getProjectName", "getProjectSchema", "getTitle", "getUsedDonateMoney", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;[ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/awemeopen/bizmodels/feed/WelfareActivity;", "equals", "other", "", "hashCode", "", "isMatchDonateEnable", "isWelfareActivityExpired", "isWelfareActivityFinish", "toString", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WelfareActivity implements Serializable {

    @SerializedName("description")
    private final String description;

    @SerializedName("match_donate_deadline")
    private final String donateDeadline;

    @SerializedName("match_donate_money")
    private final Long donateMoney;

    @SerializedName("match_donate_range")
    private final int[] donateRange;

    @SerializedName("match_donate_sponsor")
    private final String donateSponsor;

    @SerializedName("match_donate_user_cnt")
    private final Long donateUserCount;

    @SerializedName("match_donate_expired")
    private final Boolean expired;

    @SerializedName("new_match_donate_user")
    private final Boolean newMatchDonateUser;

    @SerializedName("org_aweme_user_id")
    private final Long organizationId;

    @SerializedName("org_short_name")
    private final String organizationName;

    @SerializedName("org_aweme_sec_user_id")
    private final String organizationSecId;

    @SerializedName("proj_id")
    private final long projectId;

    @SerializedName("proj_name")
    private final String projectName;

    @SerializedName("proj_schema_url")
    private final String projectSchema;

    @SerializedName("title")
    private final String title;

    @SerializedName("used_match_donate_money")
    private final Long usedDonateMoney;

    public static /* synthetic */ WelfareActivity copy$default(WelfareActivity r110, String r111, String r112, long r210, String r211, String r212, String r213, Long r214, String r215, Long r216, String r217, int[] r218, String r310, Long r311, Long r312, Boolean r313, Boolean r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.description;
    L11:
        if ((r315 & 4) == 0) goto L13;
        long r102 = r110.projectId;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.projectName;
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r104 = r110.projectSchema;
    L23:
        if ((r315 & 32) == 0) goto L25;
        String r105 = r110.organizationName;
    L27:
        if ((r315 & 64) == 0) goto L29;
        Long r106 = r110.organizationId;
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r113 = r110.organizationSecId;
    L35:
        if ((r315 & 256) == 0) goto L37;
        Long r114 = r110.donateMoney;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r115 = r110.donateSponsor;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        int[] r116 = r110.donateRange;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r117 = r110.donateDeadline;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        Long r118 = r110.usedDonateMoney;
    L54:
        Long r317 = r118;
        if ((r315 & 8192) == 0) goto L57;
        Long r119 = r110.donateUserCount;
    L58:
        Long r318 = r119;
        if ((r315 & 16384) == 0) goto L61;
        Boolean r120 = r110.newMatchDonateUser;
    L63:
        if ((r315 & 32768) == 0) goto L65;
        Boolean r107 = r110.expired;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r317, r318, r120, r107);
    L65:
        r107 = r314;
        goto L67
    L61:
        r120 = r313;
        goto L63
    L57:
        r119 = r312;
        goto L58
    L53:
        r118 = r311;
        goto L54
    L49:
        r117 = r310;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
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
        return this.title;
    }

    public final String component10() {
        return this.donateSponsor;
    }

    public final int[] component11() {
        return this.donateRange;
    }

    public final String component12() {
        return this.donateDeadline;
    }

    public final Long component13() {
        return this.usedDonateMoney;
    }

    public final Long component14() {
        return this.donateUserCount;
    }

    public final Boolean component15() {
        return this.newMatchDonateUser;
    }

    public final Boolean component16() {
        return this.expired;
    }

    public final String component2() {
        return this.description;
    }

    public final long component3() {
        return this.projectId;
    }

    public final String component4() {
        return this.projectName;
    }

    public final String component5() {
        return this.projectSchema;
    }

    public final String component6() {
        return this.organizationName;
    }

    public final Long component7() {
        return this.organizationId;
    }

    public final String component8() {
        return this.organizationSecId;
    }

    public final Long component9() {
        return this.donateMoney;
    }

    public final WelfareActivity copy(String r210, String r211, long r212, String r213, String r214, String r215, Long r216, String r217, Long r218, String r310, int[] r311, String r312, Long r313, Long r314, Boolean r315, Boolean r316) {
        return new WelfareActivity(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316);
    }

    public String toString() {
        return "WelfareActivity(title=" + this.title + ", description=" + this.description + ", projectId=" + this.projectId + ", projectName=" + this.projectName + ", projectSchema=" + this.projectSchema + ", organizationName=" + this.organizationName + ", organizationId=" + this.organizationId + ", organizationSecId=" + this.organizationSecId + ", donateMoney=" + this.donateMoney + ", donateSponsor=" + this.donateSponsor + ", donateRange=" + Arrays.toString(this.donateRange) + ", donateDeadline=" + this.donateDeadline + ", usedDonateMoney=" + this.usedDonateMoney + ", donateUserCount=" + this.donateUserCount + ", newMatchDonateUser=" + this.newMatchDonateUser + ", expired=" + this.expired + ')';
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.description;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.projectId;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.projectName;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.projectSchema;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.organizationName;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        Long r118 = this.organizationId;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.organizationSecId;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        Long r124 = this.donateMoney;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.donateSponsor;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (r126 + r128) * 31;
        int[] r130 = this.donateRange;
        if (r130 == null) goto L41;
        int r131 = Arrays.hashCode(r130);
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.donateDeadline;
        if (r133 == null) goto L45;
        int r134 = r133.hashCode();
    L46:
        int r135 = (r132 + r134) * 31;
        Long r136 = this.usedDonateMoney;
        if (r136 == null) goto L49;
        int r137 = r136.hashCode();
    L50:
        int r138 = (r135 + r137) * 31;
        Long r139 = this.donateUserCount;
        if (r139 == null) goto L53;
        int r140 = r139.hashCode();
    L54:
        int r141 = (r138 + r140) * 31;
        Boolean r142 = this.newMatchDonateUser;
        if (r142 == null) goto L57;
        int r143 = r142.hashCode();
    L58:
        int r144 = (r141 + r143) * 31;
        Boolean r145 = this.expired;
        if (r145 == null) goto L62;
        r101 = r145.hashCode();
    L62:
        return r144 + r101;
    L57:
        r143 = 0;
        goto L58
    L53:
        r140 = 0;
        goto L54
    L49:
        r137 = 0;
        goto L50
    L45:
        r134 = 0;
        goto L46
    L41:
        r131 = 0;
        goto L42
    L37:
        r128 = 0;
        goto L38
    L33:
        r125 = 0;
        goto L34
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean isMatchDonateEnable() {
        String r100 = this.donateSponsor;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean isWelfareActivityExpired() {
        return Intrinsics.areEqual(this.expired, Boolean.TRUE);
    }

    public final boolean isWelfareActivityFinish() {
        return Intrinsics.areEqual(this.usedDonateMoney, this.donateMoney);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDonateDeadline() {
        return this.donateDeadline;
    }

    public final Long getDonateMoney() {
        return this.donateMoney;
    }

    public final int[] getDonateRange() {
        return this.donateRange;
    }

    public final String getDonateSponsor() {
        return this.donateSponsor;
    }

    public final Long getDonateUserCount() {
        return this.donateUserCount;
    }

    public final Boolean getExpired() {
        return this.expired;
    }

    public final Boolean getNewMatchDonateUser() {
        return this.newMatchDonateUser;
    }

    public final Long getOrganizationId() {
        return this.organizationId;
    }

    public final String getOrganizationName() {
        return this.organizationName;
    }

    public final String getOrganizationSecId() {
        return this.organizationSecId;
    }

    public final long getProjectId() {
        return this.projectId;
    }

    public final String getProjectName() {
        return this.projectName;
    }

    public final String getProjectSchema() {
        return this.projectSchema;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getUsedDonateMoney() {
        return this.usedDonateMoney;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(WelfareActivity.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.awemeopen.bizmodels.feed.WelfareActivity");
        WelfareActivity r102 = (WelfareActivity) r100;
        if (Intrinsics.areEqual(this.title, r102.title) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.description, r102.description) == true) goto L19;
        return false;
    L19:
        if (this.projectId == r102.projectId) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.projectName, r102.projectName) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.projectSchema, r102.projectSchema) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.organizationName, r102.organizationName) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.organizationId, r102.organizationId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.organizationSecId, r102.organizationSecId) == true) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.donateMoney, r102.donateMoney) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.donateSponsor, r102.donateSponsor) == true) goto L42;
        return false;
    L42:
        int[] r103 = this.donateRange;
        if (r103 == null) goto L51;
        int[] r104 = r102.donateRange;
        if (r104 != null) goto L48;
        return false;
    L48:
        if (Arrays.equals(r103, r104) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.donateDeadline, r102.donateDeadline) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.usedDonateMoney, r102.usedDonateMoney) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.donateUserCount, r102.donateUserCount) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.newMatchDonateUser, r102.newMatchDonateUser) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.expired, r102.expired) == true) goto L68;
        return false;
    L68:
        return true;
    L51:
        if (r102.donateRange == null) goto L54;
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public WelfareActivity(String r100, String r101, long r102, String r103, String r104, String r110, Long r111, String r112, Long r113, String r114, int[] r115, String r116, Long r117, Long r118, Boolean r119, Boolean r210) {
        this.title = r100;
        this.description = r101;
        this.projectId = r102;
        this.projectName = r103;
        this.projectSchema = r104;
        this.organizationName = r110;
        this.organizationId = r111;
        this.organizationSecId = r112;
        this.donateMoney = r113;
        this.donateSponsor = r114;
        this.donateRange = r115;
        this.donateDeadline = r116;
        this.usedDonateMoney = r117;
        this.donateUserCount = r118;
        this.newMatchDonateUser = r119;
        this.expired = r210;
    }

    public /* synthetic */ WelfareActivity(String r210, String r211, long r212, String r213, String r214, String r215, Long r216, String r310, Long r311, String r312, int[] r313, String r314, Long r315, Long r316, Boolean r317, Boolean r318, int r319, DefaultConstructorMarker r410) {
        if ((r319 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r319 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r319 & 4) == 0) goto L13;
        long r102 = -1;
    L15:
        if ((r319 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r319 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r319 & 32) == 0) goto L25;
        String r110 = null;
    L27:
        if ((r319 & 64) == 0) goto L29;
        Long r111 = null;
    L31:
        if ((r319 & 256) == 0) goto L33;
        Long r112 = null;
    L35:
        if ((r319 & 512) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r319 & 1024) == 0) goto L41;
        int[] r114 = null;
    L43:
        if ((r319 & 2048) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r319 & 4096) == 0) goto L49;
        Long r116 = null;
    L51:
        if ((r319 & 8192) == 0) goto L53;
        Long r117 = null;
    L55:
        if ((r319 & 16384) == 0) goto L57;
        Boolean r118 = null;
    L59:
        if ((r319 & 32768) == 0) goto L61;
        Boolean r217 = null;
    L62:
        this(r100, r101, r102, r103, r104, r110, r111, r310, r112, r113, r114, r115, r116, r117, r118, r217);
        return;
    L61:
        r217 = r318;
        goto L62
    L57:
        r118 = r317;
        goto L59
    L53:
        r117 = r316;
        goto L55
    L49:
        r116 = r315;
        goto L51
    L45:
        r115 = r314;
        goto L47
    L41:
        r114 = r313;
        goto L43
    L37:
        r113 = r312;
        goto L39
    L33:
        r112 = r311;
        goto L35
    L29:
        r111 = r216;
        goto L31
    L25:
        r110 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
