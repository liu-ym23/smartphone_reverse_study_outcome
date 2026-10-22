package com.larus.platform.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.gallery.api.PreviewChangeWay;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0013\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010=\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\u0013\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003JÜ\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\nHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010(R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u0010\u0010\u001eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b,\u0010#R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!¨\u0006G"}, d2 = {"Lcom/larus/platform/api/PrefetchRecommendVideoParam;", "Ljava/io/Serializable;", "messageId", "", "replyId", "enableVideoRecommend", "", "playlistItemIds", "", "clickIndex", "", "cachedVideosPreloadFrom", "Lcom/larus/platform/api/CachedVideosPreloadFrom;", "replyItemIds", "isLastVideo", "Lkotlin/Function0;", "isLastVideoMessageForInnerPage", "lastVideoMessageId", "enterFromRelatedVideoFlow", "imprIndex", "outerFallbackInfo", "Lcom/larus/platform/api/OuterFallbackInfo;", "firstBindPreloadRecommend", "query", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/platform/api/CachedVideosPreloadFrom;Ljava/util/List;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/Integer;Lcom/larus/platform/api/OuterFallbackInfo;ZLjava/util/List;)V", "getMessageId", "()Ljava/lang/String;", "getReplyId", "getEnableVideoRecommend", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPlaylistItemIds", "()Ljava/util/List;", "getClickIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCachedVideosPreloadFrom", "()Lcom/larus/platform/api/CachedVideosPreloadFrom;", "getReplyItemIds", "()Lkotlin/jvm/functions/Function0;", "getLastVideoMessageId", "getEnterFromRelatedVideoFlow", "()Z", "getImprIndex", "getOuterFallbackInfo", "()Lcom/larus/platform/api/OuterFallbackInfo;", "getFirstBindPreloadRecommend", "getQuery", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Lcom/larus/platform/api/CachedVideosPreloadFrom;Ljava/util/List;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/Integer;Lcom/larus/platform/api/OuterFallbackInfo;ZLjava/util/List;)Lcom/larus/platform/api/PrefetchRecommendVideoParam;", "equals", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrefetchRecommendVideoParam implements Serializable {

    @SerializedName("cachedVideosPreloadFrom")
    private final CachedVideosPreloadFrom cachedVideosPreloadFrom;

    @SerializedName(PreviewChangeWay.CLICK_INDEX)
    private final Integer clickIndex;

    @SerializedName("enable_video_recommend")
    private final Boolean enableVideoRecommend;

    @SerializedName("enter_from_related_video_flow")
    private final boolean enterFromRelatedVideoFlow;

    @SerializedName("first_bind_preload_recommend")
    private final boolean firstBindPreloadRecommend;

    @SerializedName("impr_index")
    private final Integer imprIndex;
    private final transient Function0<Boolean> isLastVideo;

    @SerializedName("is_last_video_message")
    private final Boolean isLastVideoMessageForInnerPage;

    @SerializedName("last_video_message_id")
    private final String lastVideoMessageId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("outer_fallback_info")
    private final OuterFallbackInfo outerFallbackInfo;

    @SerializedName("playlist_item_ids")
    private final List<String> playlistItemIds;

    @SerializedName("query")
    private final List<String> query;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID)
    private final String replyId;

    @SerializedName("reply_item_ids")
    private final List<String> replyItemIds;

    public PrefetchRecommendVideoParam() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, false, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PrefetchRecommendVideoParam copy$default(PrefetchRecommendVideoParam r110, String r111, String r112, Boolean r113, List r210, Integer r211, CachedVideosPreloadFrom r212, List r213, Function0 r214, Boolean r215, String r216, boolean r217, Integer r218, OuterFallbackInfo r219, boolean r310, List r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = r110.messageId;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = r110.replyId;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Boolean r102 = r110.enableVideoRecommend;
    L15:
        if ((r312 & 8) == 0) goto L17;
        List r103 = r110.playlistItemIds;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Integer r104 = r110.clickIndex;
    L23:
        if ((r312 & 32) == 0) goto L25;
        CachedVideosPreloadFrom r105 = r110.cachedVideosPreloadFrom;
    L27:
        if ((r312 & 64) == 0) goto L29;
        List r106 = r110.replyItemIds;
    L31:
        if ((r312 & 128) == 0) goto L33;
        Function0 r107 = r110.isLastVideo;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Boolean r114 = r110.isLastVideoMessageForInnerPage;
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r115 = r110.lastVideoMessageId;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        boolean r116 = r110.enterFromRelatedVideoFlow;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Integer r117 = r110.imprIndex;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        OuterFallbackInfo r118 = r110.outerFallbackInfo;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        boolean r119 = r110.firstBindPreloadRecommend;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        List r108 = r110.query;
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
        return this.messageId;
    }

    public final String component10() {
        return this.lastVideoMessageId;
    }

    public final boolean component11() {
        return this.enterFromRelatedVideoFlow;
    }

    public final Integer component12() {
        return this.imprIndex;
    }

    public final OuterFallbackInfo component13() {
        return this.outerFallbackInfo;
    }

    public final boolean component14() {
        return this.firstBindPreloadRecommend;
    }

    public final List<String> component15() {
        return this.query;
    }

    public final String component2() {
        return this.replyId;
    }

    public final Boolean component3() {
        return this.enableVideoRecommend;
    }

    public final List<String> component4() {
        return this.playlistItemIds;
    }

    public final Integer component5() {
        return this.clickIndex;
    }

    public final CachedVideosPreloadFrom component6() {
        return this.cachedVideosPreloadFrom;
    }

    public final List<String> component7() {
        return this.replyItemIds;
    }

    public final Function0<Boolean> component8() {
        return this.isLastVideo;
    }

    public final Boolean component9() {
        return this.isLastVideoMessageForInnerPage;
    }

    public final PrefetchRecommendVideoParam copy(String r110, String r111, Boolean r210, List<String> r211, Integer r212, CachedVideosPreloadFrom r213, List<String> r214, Function0<Boolean> r215, Boolean r216, String r217, boolean r218, Integer r219, OuterFallbackInfo r310, boolean r311, List<String> r312) {
        return new PrefetchRecommendVideoParam(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrefetchRecommendVideoParam) == true) goto L8;
        return false;
    L8:
        PrefetchRecommendVideoParam r101 = (PrefetchRecommendVideoParam) r100;
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableVideoRecommend, r101.enableVideoRecommend) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.playlistItemIds, r101.playlistItemIds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickIndex, r101.clickIndex) == true) goto L24;
        return false;
    L24:
        if (this.cachedVideosPreloadFrom == r101.cachedVideosPreloadFrom) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.replyItemIds, r101.replyItemIds) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isLastVideo, r101.isLastVideo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isLastVideoMessageForInnerPage, r101.isLastVideoMessageForInnerPage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lastVideoMessageId, r101.lastVideoMessageId) == true) goto L39;
        return false;
    L39:
        if (this.enterFromRelatedVideoFlow == r101.enterFromRelatedVideoFlow) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.imprIndex, r101.imprIndex) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.outerFallbackInfo, r101.outerFallbackInfo) == true) goto L48;
        return false;
    L48:
        if (this.firstBindPreloadRecommend == r101.firstBindPreloadRecommend) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.query, r101.query) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r100 = this.messageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.replyId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enableVideoRecommend;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.playlistItemIds;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.clickIndex;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        CachedVideosPreloadFrom r116 = this.cachedVideosPreloadFrom;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.replyItemIds;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Function0<Boolean> r122 = this.isLastVideo;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.isLastVideoMessageForInnerPage;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.lastVideoMessageId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        int r131 = 1231;
        if (this.enterFromRelatedVideoFlow == false) goto L45;
        int r132 = 1231;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.imprIndex;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        OuterFallbackInfo r137 = this.outerFallbackInfo;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        if (this.firstBindPreloadRecommend == true) goto L58;
        r131 = 1237;
    L58:
        int r140 = (r139 + r131) * 31;
        List<String> r141 = this.query;
        if (r141 == null) goto L63;
        r101 = r141.hashCode();
    L63:
        return r140 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = 1237;
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
        return "PrefetchRecommendVideoParam(messageId=" + this.messageId + ", replyId=" + this.replyId + ", enableVideoRecommend=" + this.enableVideoRecommend + ", playlistItemIds=" + this.playlistItemIds + ", clickIndex=" + this.clickIndex + ", cachedVideosPreloadFrom=" + this.cachedVideosPreloadFrom + ", replyItemIds=" + this.replyItemIds + ", isLastVideo=" + this.isLastVideo + ", isLastVideoMessageForInnerPage=" + this.isLastVideoMessageForInnerPage + ", lastVideoMessageId=" + this.lastVideoMessageId + ", enterFromRelatedVideoFlow=" + this.enterFromRelatedVideoFlow + ", imprIndex=" + this.imprIndex + ", outerFallbackInfo=" + this.outerFallbackInfo + ", firstBindPreloadRecommend=" + this.firstBindPreloadRecommend + ", query=" + this.query + ')';
    }

    public final CachedVideosPreloadFrom getCachedVideosPreloadFrom() {
        return this.cachedVideosPreloadFrom;
    }

    public final Integer getClickIndex() {
        return this.clickIndex;
    }

    public final Boolean getEnableVideoRecommend() {
        return this.enableVideoRecommend;
    }

    public final boolean getEnterFromRelatedVideoFlow() {
        return this.enterFromRelatedVideoFlow;
    }

    public final boolean getFirstBindPreloadRecommend() {
        return this.firstBindPreloadRecommend;
    }

    public final Integer getImprIndex() {
        return this.imprIndex;
    }

    public final String getLastVideoMessageId() {
        return this.lastVideoMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final OuterFallbackInfo getOuterFallbackInfo() {
        return this.outerFallbackInfo;
    }

    public final List<String> getPlaylistItemIds() {
        return this.playlistItemIds;
    }

    public final List<String> getQuery() {
        return this.query;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final List<String> getReplyItemIds() {
        return this.replyItemIds;
    }

    public final Function0<Boolean> isLastVideo() {
        return this.isLastVideo;
    }

    public final Boolean isLastVideoMessageForInnerPage() {
        return this.isLastVideoMessageForInnerPage;
    }

    public PrefetchRecommendVideoParam(String r100, String r101, Boolean r102, List<String> r103, Integer r104, CachedVideosPreloadFrom r105, List<String> r106, Function0<Boolean> r107, Boolean r108, String r110, boolean r111, Integer r112, OuterFallbackInfo r113, boolean r114, List<String> r115) {
        this.messageId = r100;
        this.replyId = r101;
        this.enableVideoRecommend = r102;
        this.playlistItemIds = r103;
        this.clickIndex = r104;
        this.cachedVideosPreloadFrom = r105;
        this.replyItemIds = r106;
        this.isLastVideo = r107;
        this.isLastVideoMessageForInnerPage = r108;
        this.lastVideoMessageId = r110;
        this.enterFromRelatedVideoFlow = r111;
        this.imprIndex = r112;
        this.outerFallbackInfo = r113;
        this.firstBindPreloadRecommend = r114;
        this.query = r115;
    }

    public /* synthetic */ PrefetchRecommendVideoParam(String r110, String r111, Boolean r112, List r210, Integer r211, CachedVideosPreloadFrom r212, List r213, Function0 r214, Boolean r215, String r216, boolean r217, Integer r218, OuterFallbackInfo r219, boolean r310, List r311, int r312, DefaultConstructorMarker r313) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r312 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Boolean r102 = Boolean.FALSE;
    L15:
        if ((r312 & 8) == 0) goto L17;
        List r103 = null;
    L18:
        boolean r104 = false;
        if ((r312 & 16) == 0) goto L21;
        Integer r105 = 0;
    L23:
        if ((r312 & 32) == 0) goto L25;
        CachedVideosPreloadFrom r106 = null;
    L27:
        if ((r312 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r312 & 128) == 0) goto L33;
        Function0 r113 = null;
    L35:
        if ((r312 & 256) == 0) goto L37;
        Boolean r114 = null;
    L39:
        if ((r312 & 512) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        boolean r116 = false;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Integer r117 = null;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        OuterFallbackInfo r118 = null;
    L55:
        if ((r312 & 8192) != 0) goto L59;
        r104 = r310;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        List r108 = null;
    L62:
        this(r100, r101, r102, r103, r105, r106, r107, r113, r114, r115, r116, r117, r118, r104, r108);
        return;
    L61:
        r108 = r311;
        goto L62
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
        r113 = r214;
        goto L35
    L29:
        r107 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
