package com.larus.platform.model.showcase;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b8\b\u0087\b\u0018\u00002\u00020\u0001B½\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010@\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010A\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010B\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\t\u0010E\u001a\u00020\u0015HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003JÄ\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\u00152\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\nHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b(\u0010&R\"\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b)\u0010&\"\u0004\b*\u0010+R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b,\u0010!R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010/R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u00104\"\u0004\b5\u00106R\u001a\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u00104\"\u0004\b7\u00106¨\u0006M"}, d2 = {"Lcom/larus/platform/model/showcase/Case;", "", "caseId", "", "title", "shareLink", "iconUrl", "darkIconUrl", SelectInfo.BRIEF, "status", "", "clickTime", "", "deleteTime", "createTime", "caseType", "requestId", "messageList", "", "Lcom/larus/im/bean/message/Message;", "isFromRecommend", "", "isLoading", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;ZZ)V", "getCaseId", "()Ljava/lang/String;", "getTitle", "getShareLink", "getIconUrl", "getDarkIconUrl", "getBrief", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClickTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDeleteTime", "getCreateTime", "setCreateTime", "(Ljava/lang/Long;)V", "getCaseType", "getRequestId", "setRequestId", "(Ljava/lang/String;)V", "getMessageList", "()Ljava/util/List;", "setMessageList", "(Ljava/util/List;)V", "()Z", "setFromRecommend", "(Z)V", "setLoading", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;ZZ)Lcom/larus/platform/model/showcase/Case;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Case {

    @SerializedName(SelectInfo.BRIEF)
    private final String brief;

    @SerializedName("id")
    private final String caseId;

    @SerializedName("case_type")
    private final Integer caseType;

    @SerializedName("click_time")
    private final Long clickTime;

    @SerializedName("create_conversation_time")
    private Long createTime;

    @SerializedName("dark_icon_url")
    private final String darkIconUrl;

    @SerializedName("delete_time")
    private final Long deleteTime;

    @SerializedName("icon_url")
    private final String iconUrl;
    private boolean isFromRecommend;
    private boolean isLoading;
    private transient List<Message> messageList;

    @SerializedName("request_id")
    private String requestId;

    @SerializedName(InvHitPoint.ShareMethod.SHARE_LINK)
    private final String shareLink;

    @SerializedName("user_case_status")
    private Integer status;

    @SerializedName("title")
    private final String title;

    public Case() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Case copy$default(Case r110, String r111, String r112, String r113, String r210, String r211, String r212, Integer r213, Long r214, Long r215, Long r216, Integer r217, String r218, List r219, boolean r310, boolean r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.caseId;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r102 = r110.shareLink;
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r103 = r110.iconUrl;
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r104 = r110.darkIconUrl;
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r105 = r110.brief;
    L27:
        if ((r312 & 64) == 0) goto L29;
        Integer r106 = r110.status;
    L31:
        if ((r312 & 128) == 0) goto L33;
        Long r107 = r110.clickTime;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Long r114 = r110.deleteTime;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Long r115 = r110.createTime;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        Integer r116 = r110.caseType;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        String r117 = r110.requestId;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        List r118 = r110.messageList;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        boolean r119 = r110.isFromRecommend;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        boolean r108 = r110.isLoading;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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
        return this.caseId;
    }

    public final Long component10() {
        return this.createTime;
    }

    public final Integer component11() {
        return this.caseType;
    }

    public final String component12() {
        return this.requestId;
    }

    public final List<Message> component13() {
        return this.messageList;
    }

    public final boolean component14() {
        return this.isFromRecommend;
    }

    public final boolean component15() {
        return this.isLoading;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.shareLink;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final String component5() {
        return this.darkIconUrl;
    }

    public final String component6() {
        return this.brief;
    }

    public final Integer component7() {
        return this.status;
    }

    public final Long component8() {
        return this.clickTime;
    }

    public final Long component9() {
        return this.deleteTime;
    }

    public final Case copy(String r110, String r111, String r210, String r211, String r212, String r213, Integer r214, Long r215, Long r216, Long r217, Integer r218, String r219, List<Message> r310, boolean r311, boolean r312) {
        return new Case(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Case) == true) goto L8;
        return false;
    L8:
        Case r101 = (Case) r100;
        if (Intrinsics.areEqual(this.caseId, r101.caseId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shareLink, r101.shareLink) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkIconUrl, r101.darkIconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.brief, r101.brief) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.clickTime, r101.clickTime) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.deleteTime, r101.deleteTime) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.caseType, r101.caseType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.messageList, r101.messageList) == true) goto L48;
        return false;
    L48:
        if (this.isFromRecommend == r101.isFromRecommend) goto L51;
        return false;
    L51:
        if (this.isLoading == r101.isLoading) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r100 = this.caseId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shareLink;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.iconUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.darkIconUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.brief;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.status;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.clickTime;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.deleteTime;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.createTime;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.caseType;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.requestId;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<Message> r137 = this.messageList;
        if (r137 == null) goto L54;
        r101 = r137.hashCode();
    L54:
        int r138 = (r136 + r101) * 31;
        int r139 = 1231;
        if (this.isFromRecommend == false) goto L57;
        int r140 = 1231;
    L58:
        int r141 = (r138 + r140) * 31;
        if (this.isLoading == true) goto L63;
        r139 = 1237;
    L63:
        return r141 + r139;
    L57:
        r140 = 1237;
        goto L58
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

    public String toString() {
        return "Case(caseId=" + this.caseId + ", title=" + this.title + ", shareLink=" + this.shareLink + ", iconUrl=" + this.iconUrl + ", darkIconUrl=" + this.darkIconUrl + ", brief=" + this.brief + ", status=" + this.status + ", clickTime=" + this.clickTime + ", deleteTime=" + this.deleteTime + ", createTime=" + this.createTime + ", caseType=" + this.caseType + ", requestId=" + this.requestId + ", messageList=" + this.messageList + ", isFromRecommend=" + this.isFromRecommend + ", isLoading=" + this.isLoading + ')';
    }

    public final String getBrief() {
        return this.brief;
    }

    public final String getCaseId() {
        return this.caseId;
    }

    public final Integer getCaseType() {
        return this.caseType;
    }

    public final Long getClickTime() {
        return this.clickTime;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getDarkIconUrl() {
        return this.darkIconUrl;
    }

    public final Long getDeleteTime() {
        return this.deleteTime;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<Message> getMessageList() {
        return this.messageList;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getShareLink() {
        return this.shareLink;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isFromRecommend() {
        return this.isFromRecommend;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    public final void setFromRecommend(boolean r100) {
        this.isFromRecommend = r100;
    }

    public final void setLoading(boolean r100) {
        this.isLoading = r100;
    }

    public final void setMessageList(List<Message> r100) {
        this.messageList = r100;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public Case(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, Long r107, Long r108, Long r110, Integer r111, String r112, List<Message> r113, boolean r114, boolean r115) {
        this.caseId = r100;
        this.title = r101;
        this.shareLink = r102;
        this.iconUrl = r103;
        this.darkIconUrl = r104;
        this.brief = r105;
        this.status = r106;
        this.clickTime = r107;
        this.deleteTime = r108;
        this.createTime = r110;
        this.caseType = r111;
        this.requestId = r112;
        this.messageList = r113;
        this.isFromRecommend = r114;
        this.isLoading = r115;
    }

    public /* synthetic */ Case(String r110, String r111, String r112, String r210, String r211, String r212, Integer r213, Long r214, Long r215, Long r216, Integer r217, String r218, List r219, boolean r310, boolean r311, int r312, DefaultConstructorMarker r313) {
        String r100 = "";
        if ((r312 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r312 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r312 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r312 & 32) == 0) goto L25;
        String r106 = "";
    L26:
        boolean r107 = false;
        if ((r312 & 64) == 0) goto L29;
        Integer r108 = 0;
    L31:
        if ((r312 & 128) == 0) goto L33;
        Long r113 = 0L;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Long r114 = 0L;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Long r115 = 0L;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        Integer r116 = 0;
    L47:
        if ((r312 & 2048) != 0) goto L51;
        r100 = r218;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        List r117 = null;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        boolean r118 = false;
    L59:
        if ((r312 & 16384) != 0) goto L62;
        r107 = r311;
    L62:
        this(r101, r102, r103, r104, r105, r106, r108, r113, r114, r115, r116, r100, r117, r118, r107);
        return;
    L57:
        r118 = r310;
        goto L59
    L53:
        r117 = r219;
        goto L55
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r113 = r214;
        goto L35
    L29:
        r108 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L26
    L21:
        r105 = r211;
        goto L23
    L17:
        r104 = r210;
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
}
