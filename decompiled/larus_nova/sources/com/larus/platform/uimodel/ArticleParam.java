package com.larus.platform.uimodel;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0016HÆ\u0003Jæ\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\u0006HÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006I"}, d2 = {"Lcom/larus/platform/uimodel/ArticleParam;", "Ljava/io/Serializable;", "enterAid", "", "enterFrom", "rank", "", "lastMessageId", "imprIndex", "reqId", "slideMode", "cardPosition", "cardSubPosition", "richMediaType", "moduleSource", "modulePosition", "messageId", "botId", "sectionId", "replyId", "searchId", "recommendType", "Lcom/larus/platform/uimodel/VideoParam$RecommendType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/uimodel/VideoParam$RecommendType;)V", "getEnterAid", "()Ljava/lang/String;", "getEnterFrom", "getRank", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastMessageId", "getImprIndex", "getReqId", "getSlideMode", "getCardPosition", "getCardSubPosition", "getRichMediaType", "getModuleSource", "getModulePosition", "getMessageId", "getBotId", "getSectionId", "getReplyId", "getSearchId", "getRecommendType", "()Lcom/larus/platform/uimodel/VideoParam$RecommendType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/uimodel/VideoParam$RecommendType;)Lcom/larus/platform/uimodel/ArticleParam;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ArticleParam implements Serializable {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION)
    private final String cardPosition;

    @SerializedName("card_sub_position")
    private final String cardSubPosition;

    @SerializedName("enter_aid")
    private final String enterAid;

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("impr_index")
    private final Integer imprIndex;

    @SerializedName("last_message_id")
    private final String lastMessageId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("module_position")
    private final String modulePosition;

    @SerializedName("module_source")
    private final String moduleSource;

    @SerializedName("rank")
    private final Integer rank;

    @SerializedName(a.KEY_RECOMMEND_TYPE)
    private final VideoParam.RecommendType recommendType;

    @SerializedName(NoticeInfo.KEY_REPLY_ID)
    private final String replyId;

    @SerializedName("req_id")
    private final String reqId;

    @SerializedName("rich_media_type")
    private final String richMediaType;

    @SerializedName("search_id")
    private final String searchId;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("slide_mode")
    private final String slideMode;

    public ArticleParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public static /* synthetic */ ArticleParam copy$default(ArticleParam r110, String r111, String r112, Integer r210, String r211, Integer r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, VideoParam.RecommendType r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = r110.enterAid;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.enterFrom;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Integer r102 = r110.rank;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = r110.lastMessageId;
    L19:
        if ((r316 & 16) == 0) goto L21;
        Integer r104 = r110.imprIndex;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = r110.reqId;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = r110.slideMode;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = r110.cardPosition;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r113 = r110.cardSubPosition;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r114 = r110.richMediaType;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = r110.moduleSource;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r116 = r110.modulePosition;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r117 = r110.messageId;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r118 = r110.botId;
    L58:
        String r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        String r119 = r110.sectionId;
    L62:
        String r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        String r120 = r110.replyId;
    L66:
        String r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        String r121 = r110.searchId;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        VideoParam.RecommendType r108 = r110.recommendType;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
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
        return this.enterAid;
    }

    public final String component10() {
        return this.richMediaType;
    }

    public final String component11() {
        return this.moduleSource;
    }

    public final String component12() {
        return this.modulePosition;
    }

    public final String component13() {
        return this.messageId;
    }

    public final String component14() {
        return this.botId;
    }

    public final String component15() {
        return this.sectionId;
    }

    public final String component16() {
        return this.replyId;
    }

    public final String component17() {
        return this.searchId;
    }

    public final VideoParam.RecommendType component18() {
        return this.recommendType;
    }

    public final String component2() {
        return this.enterFrom;
    }

    public final Integer component3() {
        return this.rank;
    }

    public final String component4() {
        return this.lastMessageId;
    }

    public final Integer component5() {
        return this.imprIndex;
    }

    public final String component6() {
        return this.reqId;
    }

    public final String component7() {
        return this.slideMode;
    }

    public final String component8() {
        return this.cardPosition;
    }

    public final String component9() {
        return this.cardSubPosition;
    }

    public final ArticleParam copy(String r210, String r211, Integer r212, String r213, Integer r214, String r215, String r216, String r217, String r218, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, VideoParam.RecommendType r318) {
        return new ArticleParam(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ArticleParam) == true) goto L8;
        return false;
    L8:
        ArticleParam r101 = (ArticleParam) r100;
        if (Intrinsics.areEqual(this.enterAid, r101.enterAid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rank, r101.rank) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lastMessageId, r101.lastMessageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imprIndex, r101.imprIndex) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.reqId, r101.reqId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.slideMode, r101.slideMode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cardPosition, r101.cardPosition) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.cardSubPosition, r101.cardSubPosition) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.richMediaType, r101.richMediaType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.moduleSource, r101.moduleSource) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.modulePosition, r101.modulePosition) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L60;
        return false;
    L60:
        if (this.recommendType == r101.recommendType) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        String r100 = this.enterAid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterFrom;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.rank;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.lastMessageId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.imprIndex;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.reqId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.slideMode;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.cardPosition;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.cardSubPosition;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.richMediaType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.moduleSource;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.modulePosition;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.messageId;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.botId;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.sectionId;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.replyId;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.searchId;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        VideoParam.RecommendType r152 = this.recommendType;
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

    public String toString() {
        return "ArticleParam(enterAid=" + this.enterAid + ", enterFrom=" + this.enterFrom + ", rank=" + this.rank + ", lastMessageId=" + this.lastMessageId + ", imprIndex=" + this.imprIndex + ", reqId=" + this.reqId + ", slideMode=" + this.slideMode + ", cardPosition=" + this.cardPosition + ", cardSubPosition=" + this.cardSubPosition + ", richMediaType=" + this.richMediaType + ", moduleSource=" + this.moduleSource + ", modulePosition=" + this.modulePosition + ", messageId=" + this.messageId + ", botId=" + this.botId + ", sectionId=" + this.sectionId + ", replyId=" + this.replyId + ", searchId=" + this.searchId + ", recommendType=" + this.recommendType + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getCardPosition() {
        return this.cardPosition;
    }

    public final String getCardSubPosition() {
        return this.cardSubPosition;
    }

    public final String getEnterAid() {
        return this.enterAid;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final Integer getImprIndex() {
        return this.imprIndex;
    }

    public final String getLastMessageId() {
        return this.lastMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getModulePosition() {
        return this.modulePosition;
    }

    public final String getModuleSource() {
        return this.moduleSource;
    }

    public final Integer getRank() {
        return this.rank;
    }

    public final VideoParam.RecommendType getRecommendType() {
        return this.recommendType;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final String getRichMediaType() {
        return this.richMediaType;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSlideMode() {
        return this.slideMode;
    }

    public ArticleParam(String r100, String r101, Integer r102, String r103, Integer r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, VideoParam.RecommendType r210) {
        this.enterAid = r100;
        this.enterFrom = r101;
        this.rank = r102;
        this.lastMessageId = r103;
        this.imprIndex = r104;
        this.reqId = r105;
        this.slideMode = r106;
        this.cardPosition = r110;
        this.cardSubPosition = r111;
        this.richMediaType = r112;
        this.moduleSource = r113;
        this.modulePosition = r114;
        this.messageId = r115;
        this.botId = r116;
        this.sectionId = r117;
        this.replyId = r118;
        this.searchId = r119;
        this.recommendType = r210;
    }

    public /* synthetic */ ArticleParam(String r210, String r211, Integer r212, String r213, Integer r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, VideoParam.RecommendType r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r112 = "";
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r115 = "";
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r107 = "";
    L59:
        if ((r318 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r318 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        VideoParam.RecommendType r109 = VideoParam.RecommendType.Non;
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r107 = r313;
        goto L59
    L53:
        r115 = r312;
        goto L55
    L49:
        r114 = r311;
        goto L51
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r219;
        goto L43
    L37:
        r111 = r218;
        goto L39
    L33:
        r110 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
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
