package com.larus.im.bean.message;

import com.larus.im.bean.conversation.ConversationType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u001c\u001a\u00020\rH\u0007¢\u0006\u0002\b\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J]\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/larus/im/bean/message/MessageListRequest;", "", "conversationId", "", "conversationType", "", "contentType", "messageLimit", "maxIndex", "", "businessExt", "", "globalNotifyRemoteMessage", "", "<init>", "(Ljava/lang/String;IIIJLjava/util/Map;Z)V", "getConversationId", "()Ljava/lang/String;", "getConversationType", "()I", "getContentType", "getMessageLimit", "getMaxIndex", "()J", "getBusinessExt", "()Ljava/util/Map;", "getGlobalNotifyRemoteMessage", "()Z", "isRefresh", "MessageListRequest_isRefresh", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListRequest {
    private final Map<String, String> businessExt;
    private final int contentType;
    private final String conversationId;
    private final int conversationType;
    private final boolean globalNotifyRemoteMessage;
    private final long maxIndex;
    private final int messageLimit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageListRequest copy$default(MessageListRequest r100, String r110, int r111, int r112, int r113, long r114, Map r115, boolean r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.conversationId;
    L7:
        if ((r117 & 2) == 0) goto L9;
        int r102 = r100.conversationType;
    L11:
        if ((r117 & 4) == 0) goto L13;
        int r103 = r100.contentType;
    L15:
        if ((r117 & 8) == 0) goto L17;
        int r104 = r100.messageLimit;
    L19:
        if ((r117 & 16) == 0) goto L21;
        long r105 = r100.maxIndex;
    L23:
        if ((r117 & 32) == 0) goto L25;
        Map r106 = r100.businessExt;
    L27:
        if ((r117 & 64) == 0) goto L29;
        boolean r107 = r100.globalNotifyRemoteMessage;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
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

    public final String component1() {
        return this.conversationId;
    }

    public final int component2() {
        return this.conversationType;
    }

    public final int component3() {
        return this.contentType;
    }

    public final int component4() {
        return this.messageLimit;
    }

    public final long component5() {
        return this.maxIndex;
    }

    public final Map<String, String> component6() {
        return this.businessExt;
    }

    public final boolean component7() {
        return this.globalNotifyRemoteMessage;
    }

    public final MessageListRequest copy(String r110, @ConversationType int r111, @MessageContentType int r112, int r113, long r114, Map<String, String> r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "conversationId");
        return new MessageListRequest(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageListRequest) == true) goto L8;
        return false;
    L8:
        MessageListRequest r101 = (MessageListRequest) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.conversationType == r101.conversationType) goto L15;
        return false;
    L15:
        if (this.contentType == r101.contentType) goto L18;
        return false;
    L18:
        if (this.messageLimit == r101.messageLimit) goto L21;
        return false;
    L21:
        if (this.maxIndex == r101.maxIndex) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.businessExt, r101.businessExt) == true) goto L27;
        return false;
    L27:
        if (this.globalNotifyRemoteMessage == r101.globalNotifyRemoteMessage) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.conversationId.hashCode() * 31) + this.conversationType) * 31) + this.contentType) * 31) + this.messageLimit) * 31;
        long r101 = this.maxIndex;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Map<String, String> r103 = this.businessExt;
        if (r103 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.globalNotifyRemoteMessage == false) goto L9;
        int r106 = 1231;
    L11:
        return r105 + r106;
    L9:
        r106 = 1237;
        goto L11
    L5:
        r104 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "MessageListRequest(conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", contentType=" + this.contentType + ", messageLimit=" + this.messageLimit + ", maxIndex=" + this.maxIndex + ", businessExt=" + this.businessExt + ", globalNotifyRemoteMessage=" + this.globalNotifyRemoteMessage + ')';
    }

    public final boolean MessageListRequest_isRefresh() {
        if (this.maxIndex != Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public final Map<String, String> getBusinessExt() {
        return this.businessExt;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final int getConversationType() {
        return this.conversationType;
    }

    public final boolean getGlobalNotifyRemoteMessage() {
        return this.globalNotifyRemoteMessage;
    }

    public final long getMaxIndex() {
        return this.maxIndex;
    }

    public final int getMessageLimit() {
        return this.messageLimit;
    }

    public MessageListRequest(String r100, @ConversationType int r101, @MessageContentType int r102, int r103, long r104, Map<String, String> r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.conversationId = r100;
        this.conversationType = r101;
        this.contentType = r102;
        this.messageLimit = r103;
        this.maxIndex = r104;
        this.businessExt = r105;
        this.globalNotifyRemoteMessage = r106;
    }

    public /* synthetic */ MessageListRequest(String r110, int r111, int r112, int r113, long r114, Map r115, boolean r116, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 2) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r210 & 4) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r210 & 16) == 0) goto L13;
        long r102 = Long.MAX_VALUE;
    L15:
        if ((r210 & 32) == 0) goto L17;
        Map r103 = null;
    L19:
        if ((r210 & 64) == 0) goto L21;
        boolean r117 = true;
    L22:
        this(r110, r100, r101, r113, r102, r103, r117);
        return;
    L21:
        r117 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
