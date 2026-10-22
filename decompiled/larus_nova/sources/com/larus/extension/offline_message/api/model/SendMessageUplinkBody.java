package com.larus.extension.offline_message.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bµ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010%J¼\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006/"}, d2 = {"Lcom/larus/extension/offline_message/api/model/SendMessageUplinkBody;", "Ljava/io/Serializable;", "conversationId", "", "conversationType", "", "senderId", "contentType", "content", "ttsContent", "ext", "", "localMessageId", "botType", "localConversationId", "botId", "bizContentType", "status", "createTime", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "()Ljava/lang/Long;", "copy", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;)Lcom/larus/extension/offline_message/api/model/SendMessageUplinkBody;", "equals", "", "other", "", "hashCode", "toString", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMessageUplinkBody implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("biz_content_type")
    public String bizContentType;

    @SerializedName("bot_id")
    public String botId;

    @SerializedName("bot_type")
    public int botType;

    @SerializedName("content")
    public String content;

    @SerializedName("content_type")
    public int contentType;

    @SerializedName("conversation_id")
    public String conversationId;

    @SerializedName("conversation_type")
    public int conversationType;

    @SerializedName("create_time")
    public Long createTime;

    @SerializedName("ext")
    public Map<String, String> ext;

    @SerializedName("local_conversation_id")
    public String localConversationId;

    @SerializedName("local_message_id")
    public String localMessageId;

    @SerializedName("sender_id")
    public String senderId;

    @SerializedName("status")
    public int status;

    @SerializedName("tts_content")
    public String ttsContent;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SendMessageUplinkBody() {
        this(null, 0, null, 0, null, null, null, null, 0, null, null, null, 0, null, 16383, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SendMessageUplinkBody copy$default(SendMessageUplinkBody r110, String r111, int r112, String r113, int r114, String r210, String r211, Map r212, String r213, int r214, String r215, String r216, String r217, int r218, Long r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.conversationId;
    L7:
        if ((r310 & 2) == 0) goto L9;
        int r101 = r110.conversationType;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.senderId;
    L15:
        if ((r310 & 8) == 0) goto L17;
        int r103 = r110.contentType;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.content;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.ttsContent;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Map r106 = r110.ext;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r107 = r110.localMessageId;
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r115 = r110.botType;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = r110.localConversationId;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.botId;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.bizContentType;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        int r119 = r110.status;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        Long r108 = r110.createTime;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
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
        return this.conversationId;
    }

    public final String component10() {
        return this.localConversationId;
    }

    public final String component11() {
        return this.botId;
    }

    public final String component12() {
        return this.bizContentType;
    }

    public final int component13() {
        return this.status;
    }

    public final Long component14() {
        return this.createTime;
    }

    public final int component2() {
        return this.conversationType;
    }

    public final String component3() {
        return this.senderId;
    }

    public final int component4() {
        return this.contentType;
    }

    public final String component5() {
        return this.content;
    }

    public final String component6() {
        return this.ttsContent;
    }

    public final Map<String, String> component7() {
        return this.ext;
    }

    public final String component8() {
        return this.localMessageId;
    }

    public final int component9() {
        return this.botType;
    }

    public final SendMessageUplinkBody copy(String r110, int r111, String r112, int r210, String r211, String r212, Map<String, String> r213, String r214, int r215, String r216, String r217, String r218, int r219, Long r310) {
        return new SendMessageUplinkBody(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SendMessageUplinkBody) == true) goto L8;
        return false;
    L8:
        SendMessageUplinkBody r101 = (SendMessageUplinkBody) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.conversationType == r101.conversationType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.senderId, r101.senderId) == true) goto L18;
        return false;
    L18:
        if (this.contentType == r101.contentType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ttsContent, r101.ttsContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L33;
        return false;
    L33:
        if (this.botType == r101.botType) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.localConversationId, r101.localConversationId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.bizContentType, r101.bizContentType) == true) goto L45;
        return false;
    L45:
        if (this.status == r101.status) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.conversationType) * 31;
        String r104 = this.senderId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.contentType) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.ttsContent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.ext;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.localMessageId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (((r115 + r117) * 31) + this.botType) * 31;
        String r119 = this.localConversationId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.botId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.bizContentType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (((r124 + r126) * 31) + this.status) * 31;
        Long r128 = this.createTime;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
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
        return "SendMessageUplinkBody(conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", senderId=" + this.senderId + ", contentType=" + this.contentType + ", content=" + this.content + ", ttsContent=" + this.ttsContent + ", ext=" + this.ext + ", localMessageId=" + this.localMessageId + ", botType=" + this.botType + ", localConversationId=" + this.localConversationId + ", botId=" + this.botId + ", bizContentType=" + this.bizContentType + ", status=" + this.status + ", createTime=" + this.createTime + ')';
    }

    public SendMessageUplinkBody(String r100, int r101, String r102, int r103, String r104, String r105, Map<String, String> r106, String r107, int r108, String r110, String r111, String r112, int r113, Long r114) {
        this.conversationId = r100;
        this.conversationType = r101;
        this.senderId = r102;
        this.contentType = r103;
        this.content = r104;
        this.ttsContent = r105;
        this.ext = r106;
        this.localMessageId = r107;
        this.botType = r108;
        this.localConversationId = r110;
        this.botId = r111;
        this.bizContentType = r112;
        this.status = r113;
        this.createTime = r114;
    }

    public /* synthetic */ SendMessageUplinkBody(String r110, int r111, String r112, int r210, String r211, String r212, Map r213, String r214, int r215, String r216, String r217, String r218, int r219, Long r310, int r311, DefaultConstructorMarker r312) {
        Long r100 = null;
        if ((r311 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        int r102 = 0;
        if ((r311 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r311 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r311 & 64) == 0) goto L29;
        Map r108 = null;
    L31:
        if ((r311 & 128) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r311 & 256) == 0) goto L37;
        int r114 = 0;
    L39:
        if ((r311 & 512) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r311 & 4096) != 0) goto L55;
        r102 = r219;
    L55:
        if ((r311 & 8192) != 0) goto L58;
        r100 = r310;
    L58:
        this(r101, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r102, r100);
        return;
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
        r108 = r213;
        goto L31
    L25:
        r107 = r212;
        goto L27
    L21:
        r106 = r211;
        goto L23
    L17:
        r105 = r210;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
