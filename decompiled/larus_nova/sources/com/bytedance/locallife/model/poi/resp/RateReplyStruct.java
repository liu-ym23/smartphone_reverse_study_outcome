package com.bytedance.locallife.model.poi.resp;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0007\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RateReplyStruct;", "Ljava/io/Serializable;", "replyId", "", "text", "replierUserInfo", "Lcom/bytedance/locallife/model/poi/resp/RateReplyUserInfo;", "isLongReply", "", "truncatedText", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/RateReplyUserInfo;Ljava/lang/Boolean;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setLongReply", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getReplierUserInfo", "()Lcom/bytedance/locallife/model/poi/resp/RateReplyUserInfo;", "getReplyId", "()Ljava/lang/String;", "getText", "getTruncatedText", "setTruncatedText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/RateReplyUserInfo;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/locallife/model/poi/resp/RateReplyStruct;", "equals", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RateReplyStruct implements Serializable {
    private Boolean isLongReply;

    @SerializedName("replier_user_info")
    private final RateReplyUserInfo replierUserInfo;

    @SerializedName(NoticeInfo.KEY_REPLY_ID)
    private final String replyId;

    @SerializedName("text")
    private final String text;
    private String truncatedText;

    public RateReplyStruct() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ RateReplyStruct copy$default(RateReplyStruct r100, String r101, String r102, RateReplyUserInfo r103, Boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.replyId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.text;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.replierUserInfo;
    L11:
        RateReplyUserInfo r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isLongReply;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.truncatedText;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.replyId;
    }

    public final String component2() {
        return this.text;
    }

    public final RateReplyUserInfo component3() {
        return this.replierUserInfo;
    }

    public final Boolean component4() {
        return this.isLongReply;
    }

    public final String component5() {
        return this.truncatedText;
    }

    public final RateReplyStruct copy(String r100, String r101, RateReplyUserInfo r110, Boolean r111, String r112) {
        return new RateReplyStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RateReplyStruct) == true) goto L8;
        return false;
    L8:
        RateReplyStruct r101 = (RateReplyStruct) r100;
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.replierUserInfo, r101.replierUserInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isLongReply, r101.isLongReply) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.truncatedText, r101.truncatedText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.replyId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        RateReplyUserInfo r107 = this.replierUserInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isLongReply;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.truncatedText;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "RateReplyStruct(replyId=" + this.replyId + ", text=" + this.text + ", replierUserInfo=" + this.replierUserInfo + ", isLongReply=" + this.isLongReply + ", truncatedText=" + this.truncatedText + ')';
    }

    public final RateReplyUserInfo getReplierUserInfo() {
        return this.replierUserInfo;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTruncatedText() {
        return this.truncatedText;
    }

    public final Boolean isLongReply() {
        return this.isLongReply;
    }

    public final void setLongReply(Boolean r100) {
        this.isLongReply = r100;
    }

    public final void setTruncatedText(String r100) {
        this.truncatedText = r100;
    }

    public RateReplyStruct(String r100, String r101, RateReplyUserInfo r102, Boolean r103, String r104) {
        this.replyId = r100;
        this.text = r101;
        this.replierUserInfo = r102;
        this.isLongReply = r103;
        this.truncatedText = r104;
    }

    public /* synthetic */ RateReplyStruct(String r100, String r101, RateReplyUserInfo r102, Boolean r103, String r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        RateReplyUserInfo r107 = null;
    L15:
        if ((r105 & 8) == 0) goto L17;
        Boolean r108 = null;
    L19:
        if ((r105 & 16) == 0) goto L21;
        String r109 = null;
    L22:
        this(r111, r106, r107, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L5:
        r111 = r100;
        goto L7
    }
}
