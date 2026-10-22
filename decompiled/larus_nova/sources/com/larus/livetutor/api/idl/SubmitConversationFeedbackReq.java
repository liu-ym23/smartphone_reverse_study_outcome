package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016Jn\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\fHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018¨\u0006="}, d2 = {"Lcom/larus/livetutor/api/idl/SubmitConversationFeedbackReq;", "Ljava/io/Serializable;", "bizParams", "Lcom/larus/livetutor/api/idl/BizParams;", "conversationId", "", "feedbackDetail", "Lcom/larus/livetutor/api/idl/FeedbackDetail;", "messageId", "type", "Lcom/larus/livetutor/api/idl/FeedbackType;", FailedBinderCallBack.CALLER_ID, "", "rtcCallId", "tutorId", "<init>", "(Lcom/larus/livetutor/api/idl/BizParams;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/FeedbackDetail;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/FeedbackType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getBizParams", "()Lcom/larus/livetutor/api/idl/BizParams;", "setBizParams", "(Lcom/larus/livetutor/api/idl/BizParams;)V", "getConversationId", "()Ljava/lang/Long;", "setConversationId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFeedbackDetail", "()Lcom/larus/livetutor/api/idl/FeedbackDetail;", "setFeedbackDetail", "(Lcom/larus/livetutor/api/idl/FeedbackDetail;)V", "getMessageId", "setMessageId", "getType", "()Lcom/larus/livetutor/api/idl/FeedbackType;", "setType", "(Lcom/larus/livetutor/api/idl/FeedbackType;)V", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", "getRtcCallId", "setRtcCallId", "getTutorId", "setTutorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/larus/livetutor/api/idl/BizParams;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/FeedbackDetail;Ljava/lang/Long;Lcom/larus/livetutor/api/idl/FeedbackType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/livetutor/api/idl/SubmitConversationFeedbackReq;", "equals", "", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubmitConversationFeedbackReq implements Serializable {

    @SerializedName("biz_params")
    private BizParams bizParams;

    @SerializedName("call_id")
    private String callId;

    @SerializedName("conversation_id")
    private Long conversationId;

    @SerializedName("feedback_detail")
    private FeedbackDetail feedbackDetail;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private Long messageId;

    @SerializedName("rtc_call_id")
    private String rtcCallId;

    @SerializedName("tutor_id")
    private Long tutorId;

    @SerializedName("type")
    private FeedbackType type;

    public SubmitConversationFeedbackReq() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ SubmitConversationFeedbackReq copy$default(SubmitConversationFeedbackReq r100, BizParams r110, Long r111, FeedbackDetail r112, Long r113, FeedbackType r114, String r115, String r116, Long r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        BizParams r101 = r100.bizParams;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = r100.conversationId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        FeedbackDetail r103 = r100.feedbackDetail;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Long r104 = r100.messageId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        FeedbackType r105 = r100.type;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.callId;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.rtcCallId;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Long r108 = r100.tutorId;
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

    public final BizParams component1() {
        return this.bizParams;
    }

    public final Long component2() {
        return this.conversationId;
    }

    public final FeedbackDetail component3() {
        return this.feedbackDetail;
    }

    public final Long component4() {
        return this.messageId;
    }

    public final FeedbackType component5() {
        return this.type;
    }

    public final String component6() {
        return this.callId;
    }

    public final String component7() {
        return this.rtcCallId;
    }

    public final Long component8() {
        return this.tutorId;
    }

    public final SubmitConversationFeedbackReq copy(BizParams r110, Long r111, FeedbackDetail r112, Long r113, FeedbackType r114, String r115, String r116, Long r117) {
        return new SubmitConversationFeedbackReq(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SubmitConversationFeedbackReq) == true) goto L8;
        return false;
    L8:
        SubmitConversationFeedbackReq r101 = (SubmitConversationFeedbackReq) r100;
        if (Intrinsics.areEqual(this.bizParams, r101.bizParams) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.feedbackDetail, r101.feedbackDetail) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L21;
        return false;
    L21:
        if (this.type == r101.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.callId, r101.callId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.rtcCallId, r101.rtcCallId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tutorId, r101.tutorId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        BizParams r100 = this.bizParams;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.conversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        FeedbackDetail r107 = this.feedbackDetail;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.messageId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        FeedbackType r113 = this.type;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.callId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.rtcCallId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.tutorId;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "SubmitConversationFeedbackReq(bizParams=" + this.bizParams + ", conversationId=" + this.conversationId + ", feedbackDetail=" + this.feedbackDetail + ", messageId=" + this.messageId + ", type=" + this.type + ", callId=" + this.callId + ", rtcCallId=" + this.rtcCallId + ", tutorId=" + this.tutorId + ')';
    }

    public final BizParams getBizParams() {
        return this.bizParams;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final Long getConversationId() {
        return this.conversationId;
    }

    public final FeedbackDetail getFeedbackDetail() {
        return this.feedbackDetail;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final String getRtcCallId() {
        return this.rtcCallId;
    }

    public final Long getTutorId() {
        return this.tutorId;
    }

    public final FeedbackType getType() {
        return this.type;
    }

    public final void setBizParams(BizParams r100) {
        this.bizParams = r100;
    }

    public final void setCallId(String r100) {
        this.callId = r100;
    }

    public final void setConversationId(Long r100) {
        this.conversationId = r100;
    }

    public final void setFeedbackDetail(FeedbackDetail r100) {
        this.feedbackDetail = r100;
    }

    public final void setMessageId(Long r100) {
        this.messageId = r100;
    }

    public final void setRtcCallId(String r100) {
        this.rtcCallId = r100;
    }

    public final void setTutorId(Long r100) {
        this.tutorId = r100;
    }

    public final void setType(FeedbackType r100) {
        this.type = r100;
    }

    public SubmitConversationFeedbackReq(BizParams r100, Long r101, FeedbackDetail r102, Long r103, FeedbackType r104, String r105, String r106, Long r107) {
        this.bizParams = r100;
        this.conversationId = r101;
        this.feedbackDetail = r102;
        this.messageId = r103;
        this.type = r104;
        this.callId = r105;
        this.rtcCallId = r106;
        this.tutorId = r107;
    }

    public /* synthetic */ SubmitConversationFeedbackReq(BizParams r110, Long r111, FeedbackDetail r112, Long r113, FeedbackType r114, String r115, String r116, Long r117, int r118, DefaultConstructorMarker r119) {
        Long r100 = null;
        if ((r118 & 1) == 0) goto L5;
        BizParams r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Long r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        FeedbackDetail r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Long r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        FeedbackType r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
}
