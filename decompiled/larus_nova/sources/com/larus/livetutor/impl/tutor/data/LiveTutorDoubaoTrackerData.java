package com.larus.livetutor.impl.tutor.data;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.obric.trace.ObricActionBarTrackType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\bN\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJò\u0001\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VHÖ\u0003J\t\u0010W\u001a\u00020\u0005HÖ\u0001J\t\u0010X\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001aR \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001aR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010 R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 ¨\u0006Y"}, d2 = {"Lcom/larus/livetutor/impl/tutor/data/LiveTutorDoubaoTrackerData;", "Ljava/io/Serializable;", "actionBarKey", "", "actionBarTemplateId", "", "actionBarItemId", "reqId", "isLiveTutor", "liveTutorId", "liveTutorRecQueryId", "liveTutorRecQueryTag", "botId", "chatType", "contentSource", "contentSourceEntrance", "currentPage", "scene", "enterMethod", "messageType", "picCnt", "liveTutorPartId", "success", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getActionBarKey", "()Ljava/lang/String;", "setActionBarKey", "(Ljava/lang/String;)V", "getActionBarTemplateId", "()Ljava/lang/Integer;", "setActionBarTemplateId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getActionBarItemId", "setActionBarItemId", "getReqId", "setReqId", "getLiveTutorId", "setLiveTutorId", "getLiveTutorRecQueryId", "setLiveTutorRecQueryId", "getLiveTutorRecQueryTag", "setLiveTutorRecQueryTag", "getBotId", "getChatType", "getContentSource", "setContentSource", "getContentSourceEntrance", "setContentSourceEntrance", "getCurrentPage", "getScene", "setScene", "getEnterMethod", "setEnterMethod", "getMessageType", "getPicCnt", "setPicCnt", "getLiveTutorPartId", "setLiveTutorPartId", "getSuccess", "setSuccess", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/livetutor/impl/tutor/data/LiveTutorDoubaoTrackerData;", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorDoubaoTrackerData implements Serializable {

    @SerializedName(LiveTutorHomeVM.ACTION_BAR_ITEM_ID)
    private String actionBarItemId;

    @SerializedName("action_bar_key")
    private String actionBarKey;

    @SerializedName(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID)
    private Integer actionBarTemplateId;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("chat_type")
    private final String chatType;

    @SerializedName(a.KEY_CONTENT_SOURCE)
    private String contentSource;

    @SerializedName("content_source_entrance")
    private String contentSourceEntrance;

    @SerializedName("current_page")
    private final String currentPage;

    @SerializedName("enter_method")
    private String enterMethod;

    @SerializedName("is_live_tutor")
    private final String isLiveTutor;

    @SerializedName("live_tutor_id")
    private String liveTutorId;

    @SerializedName("live_tutor_part_id")
    private String liveTutorPartId;

    @SerializedName("live_tutor_rec_query_id")
    private String liveTutorRecQueryId;

    @SerializedName("live_tutor_rec_query_tag")
    private String liveTutorRecQueryTag;

    @SerializedName("message_type")
    private final String messageType;

    @SerializedName("pic_cnt")
    private Integer picCnt;

    @SerializedName("req_id")
    private String reqId;

    @SerializedName("scene")
    private String scene;

    @SerializedName("success")
    private Integer success;

    public LiveTutorDoubaoTrackerData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public static /* synthetic */ LiveTutorDoubaoTrackerData copy$default(LiveTutorDoubaoTrackerData r110, String r111, Integer r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, Integer r314, String r315, Integer r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = r110.actionBarKey;
    L7:
        if ((r317 & 2) == 0) goto L9;
        Integer r101 = r110.actionBarTemplateId;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = r110.actionBarItemId;
    L15:
        if ((r317 & 8) == 0) goto L17;
        String r103 = r110.reqId;
    L19:
        if ((r317 & 16) == 0) goto L21;
        String r104 = r110.isLiveTutor;
    L23:
        if ((r317 & 32) == 0) goto L25;
        String r105 = r110.liveTutorId;
    L27:
        if ((r317 & 64) == 0) goto L29;
        String r106 = r110.liveTutorRecQueryId;
    L31:
        if ((r317 & 128) == 0) goto L33;
        String r107 = r110.liveTutorRecQueryTag;
    L35:
        if ((r317 & 256) == 0) goto L37;
        String r113 = r110.botId;
    L39:
        if ((r317 & 512) == 0) goto L41;
        String r114 = r110.chatType;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        String r115 = r110.contentSource;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        String r116 = r110.contentSourceEntrance;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        String r117 = r110.currentPage;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        String r118 = r110.scene;
    L58:
        String r319 = r118;
        if ((r317 & 16384) == 0) goto L61;
        String r119 = r110.enterMethod;
    L62:
        String r320 = r119;
        if ((r317 & 32768) == 0) goto L65;
        String r120 = r110.messageType;
    L66:
        String r321 = r120;
        if ((r317 & 65536) == 0) goto L69;
        Integer r121 = r110.picCnt;
    L70:
        Integer r322 = r121;
        if ((r317 & 131072) == 0) goto L73;
        String r122 = r110.liveTutorPartId;
    L75:
        if ((r317 & 262144) == 0) goto L77;
        Integer r108 = r110.success;
    L79:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r319, r320, r321, r322, r122, r108);
    L77:
        r108 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L70
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
        return this.actionBarKey;
    }

    public final String component10() {
        return this.chatType;
    }

    public final String component11() {
        return this.contentSource;
    }

    public final String component12() {
        return this.contentSourceEntrance;
    }

    public final String component13() {
        return this.currentPage;
    }

    public final String component14() {
        return this.scene;
    }

    public final String component15() {
        return this.enterMethod;
    }

    public final String component16() {
        return this.messageType;
    }

    public final Integer component17() {
        return this.picCnt;
    }

    public final String component18() {
        return this.liveTutorPartId;
    }

    public final Integer component19() {
        return this.success;
    }

    public final Integer component2() {
        return this.actionBarTemplateId;
    }

    public final String component3() {
        return this.actionBarItemId;
    }

    public final String component4() {
        return this.reqId;
    }

    public final String component5() {
        return this.isLiveTutor;
    }

    public final String component6() {
        return this.liveTutorId;
    }

    public final String component7() {
        return this.liveTutorRecQueryId;
    }

    public final String component8() {
        return this.liveTutorRecQueryTag;
    }

    public final String component9() {
        return this.botId;
    }

    public final LiveTutorDoubaoTrackerData copy(String r210, Integer r211, String r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, Integer r318, String r319, Integer r410) {
        return new LiveTutorDoubaoTrackerData(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LiveTutorDoubaoTrackerData) == true) goto L8;
        return false;
    L8:
        LiveTutorDoubaoTrackerData r101 = (LiveTutorDoubaoTrackerData) r100;
        if (Intrinsics.areEqual(this.actionBarKey, r101.actionBarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionBarTemplateId, r101.actionBarTemplateId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionBarItemId, r101.actionBarItemId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reqId, r101.reqId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isLiveTutor, r101.isLiveTutor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liveTutorId, r101.liveTutorId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.liveTutorRecQueryId, r101.liveTutorRecQueryId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.liveTutorRecQueryTag, r101.liveTutorRecQueryTag) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.chatType, r101.chatType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.contentSource, r101.contentSource) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.contentSourceEntrance, r101.contentSourceEntrance) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.currentPage, r101.currentPage) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.messageType, r101.messageType) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.picCnt, r101.picCnt) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.liveTutorPartId, r101.liveTutorPartId) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.success, r101.success) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        String r100 = this.actionBarKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.actionBarTemplateId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.actionBarItemId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.reqId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.isLiveTutor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.liveTutorId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.liveTutorRecQueryId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.liveTutorRecQueryTag;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.botId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.chatType;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.contentSource;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.contentSourceEntrance;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.currentPage;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.scene;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.enterMethod;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.messageType;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.picCnt;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.liveTutorPartId;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Integer r155 = this.success;
        if (r155 == null) goto L79;
        r101 = r155.hashCode();
    L79:
        return r154 + r101;
    L73:
        r153 = r152.hashCode();
        goto L74
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
        return "LiveTutorDoubaoTrackerData(actionBarKey=" + this.actionBarKey + ", actionBarTemplateId=" + this.actionBarTemplateId + ", actionBarItemId=" + this.actionBarItemId + ", reqId=" + this.reqId + ", isLiveTutor=" + this.isLiveTutor + ", liveTutorId=" + this.liveTutorId + ", liveTutorRecQueryId=" + this.liveTutorRecQueryId + ", liveTutorRecQueryTag=" + this.liveTutorRecQueryTag + ", botId=" + this.botId + ", chatType=" + this.chatType + ", contentSource=" + this.contentSource + ", contentSourceEntrance=" + this.contentSourceEntrance + ", currentPage=" + this.currentPage + ", scene=" + this.scene + ", enterMethod=" + this.enterMethod + ", messageType=" + this.messageType + ", picCnt=" + this.picCnt + ", liveTutorPartId=" + this.liveTutorPartId + ", success=" + this.success + ')';
    }

    public final String getActionBarItemId() {
        return this.actionBarItemId;
    }

    public final String getActionBarKey() {
        return this.actionBarKey;
    }

    public final Integer getActionBarTemplateId() {
        return this.actionBarTemplateId;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getChatType() {
        return this.chatType;
    }

    public final String getContentSource() {
        return this.contentSource;
    }

    public final String getContentSourceEntrance() {
        return this.contentSourceEntrance;
    }

    public final String getCurrentPage() {
        return this.currentPage;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getLiveTutorId() {
        return this.liveTutorId;
    }

    public final String getLiveTutorPartId() {
        return this.liveTutorPartId;
    }

    public final String getLiveTutorRecQueryId() {
        return this.liveTutorRecQueryId;
    }

    public final String getLiveTutorRecQueryTag() {
        return this.liveTutorRecQueryTag;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final Integer getPicCnt() {
        return this.picCnt;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Integer getSuccess() {
        return this.success;
    }

    public final String isLiveTutor() {
        return this.isLiveTutor;
    }

    public final void setActionBarItemId(String r100) {
        this.actionBarItemId = r100;
    }

    public final void setActionBarKey(String r100) {
        this.actionBarKey = r100;
    }

    public final void setActionBarTemplateId(Integer r100) {
        this.actionBarTemplateId = r100;
    }

    public final void setContentSource(String r100) {
        this.contentSource = r100;
    }

    public final void setContentSourceEntrance(String r100) {
        this.contentSourceEntrance = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setLiveTutorId(String r100) {
        this.liveTutorId = r100;
    }

    public final void setLiveTutorPartId(String r100) {
        this.liveTutorPartId = r100;
    }

    public final void setLiveTutorRecQueryId(String r100) {
        this.liveTutorRecQueryId = r100;
    }

    public final void setLiveTutorRecQueryTag(String r100) {
        this.liveTutorRecQueryTag = r100;
    }

    public final void setPicCnt(Integer r100) {
        this.picCnt = r100;
    }

    public final void setReqId(String r100) {
        this.reqId = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setSuccess(Integer r100) {
        this.success = r100;
    }

    public LiveTutorDoubaoTrackerData(String r100, Integer r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, Integer r119, String r210, Integer r211) {
        this.actionBarKey = r100;
        this.actionBarTemplateId = r101;
        this.actionBarItemId = r102;
        this.reqId = r103;
        this.isLiveTutor = r104;
        this.liveTutorId = r105;
        this.liveTutorRecQueryId = r106;
        this.liveTutorRecQueryTag = r110;
        this.botId = r111;
        this.chatType = r112;
        this.contentSource = r113;
        this.contentSourceEntrance = r114;
        this.currentPage = r115;
        this.scene = r116;
        this.enterMethod = r117;
        this.messageType = r118;
        this.picCnt = r119;
        this.liveTutorPartId = r210;
        this.success = r211;
    }

    public /* synthetic */ LiveTutorDoubaoTrackerData(String r210, Integer r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r310, String r311, String r312, String r313, String r314, String r315, String r316, Integer r317, String r318, Integer r319, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r104 = "1";
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        String r110 = "7234781073513644036";
    L39:
        if ((r410 & 512) == 0) goto L41;
        String r111 = "default";
    L43:
        if ((r410 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        String r114 = "guide_tutor";
    L55:
        if ((r410 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r410 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        String r116 = "text";
    L67:
        if ((r410 & 65536) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r410 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r410 & 262144) == 0) goto L77;
        Integer r109 = null;
    L78:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r109);
        return;
    L77:
        r109 = r319;
        goto L78
    L73:
        r118 = r318;
        goto L75
    L69:
        r117 = r317;
        goto L71
    L65:
        r116 = r316;
        goto L67
    L61:
        r108 = r315;
        goto L63
    L57:
        r115 = r314;
        goto L59
    L53:
        r114 = r313;
        goto L55
    L49:
        r113 = r312;
        goto L51
    L45:
        r112 = r311;
        goto L47
    L41:
        r111 = r310;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
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
