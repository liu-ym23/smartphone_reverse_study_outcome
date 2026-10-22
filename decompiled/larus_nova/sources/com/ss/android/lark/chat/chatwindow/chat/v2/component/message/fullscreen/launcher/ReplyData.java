package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import android.os.Bundle;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyData;", "Ljava/io/Serializable;", "messageId", "", "replyType", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyType;", "partialReplyInfo", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyType;Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;)V", "getMessageId", "()Ljava/lang/String;", "getReplyType", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ReplyType;", "getPartialReplyInfo", "()Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo;", "toBundle", "Landroid/os/Bundle;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplyData implements Serializable {
    public static final a Companion = null;
    public static final String KEY_MESSAGE_ID = "key_msg_id";
    public static final String KEY_PARTIAL_REPLY_INFO = "key_reply_partial_info";
    public static final String KEY_REPLY_TYPE = "key_reply_type";
    private final String messageId;
    private final PartialReplyInfo partialReplyInfo;
    private final ReplyType replyType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ReplyData copy$default(ReplyData r100, String r101, ReplyType r102, PartialReplyInfo r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.messageId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.replyType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.partialReplyInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.messageId;
    }

    public final ReplyType component2() {
        return this.replyType;
    }

    public final PartialReplyInfo component3() {
        return this.partialReplyInfo;
    }

    public final ReplyData copy(String r100, ReplyType r101, PartialReplyInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "replyType");
        return new ReplyData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ReplyData) == true) goto L8;
        return false;
    L8:
        ReplyData r101 = (ReplyData) r100;
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L12;
        return false;
    L12:
        if (this.replyType == r101.replyType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.partialReplyInfo, r101.partialReplyInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.messageId.hashCode() * 31) + this.replyType.hashCode()) * 31;
        PartialReplyInfo r101 = this.partialReplyInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ReplyData(messageId=" + this.messageId + ", replyType=" + this.replyType + ", partialReplyInfo=" + this.partialReplyInfo + ')';
    }

    public final Bundle toBundle() {
        Bundle r100 = new Bundle();
        r100.putString(KEY_MESSAGE_ID, this.messageId);
        r100.putInt(KEY_REPLY_TYPE, this.replyType.getValue());
        PartialReplyInfo r101 = this.partialReplyInfo;
        if (r101 == null) goto L5;
        r100.putSerializable(KEY_PARTIAL_REPLY_INFO, r101);
    L5:
        return r100;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final PartialReplyInfo getPartialReplyInfo() {
        return this.partialReplyInfo;
    }

    public final ReplyType getReplyType() {
        return this.replyType;
    }

    @JvmStatic
    public static final ReplyData fromBundle(Bundle r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.getString(KEY_MESSAGE_ID);
        ReplyType.a r102 = ReplyType.Companion;
        int r103 = r100.getInt(KEY_REPLY_TYPE);
        r102.getClass();
        ReplyType r104 = ReplyType.REPLY_NORMAL;
        if (r103 == r104.getValue()) goto L8;
        ReplyType r105 = ReplyType.REPLY_PARTIAL;
        if (r103 != r105.getValue()) goto L8;
        r104 = r105;
    L8:
        Serializable r106 = r100.getSerializable(KEY_PARTIAL_REPLY_INFO);
        if ((r106 instanceof PartialReplyInfo) == false) goto L11;
        PartialReplyInfo r107 = (PartialReplyInfo) r106;
    L12:
        if (r101 != null) goto L15;
        return null;
    L15:
        return new ReplyData(r101, r104, r107);
    L11:
        r107 = null;
        goto L12
    }

    public ReplyData(String r100, ReplyType r101, PartialReplyInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "replyType");
        this.messageId = r100;
        this.replyType = r101;
        this.partialReplyInfo = r102;
    }

    public /* synthetic */ ReplyData(String r100, ReplyType r101, PartialReplyInfo r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
