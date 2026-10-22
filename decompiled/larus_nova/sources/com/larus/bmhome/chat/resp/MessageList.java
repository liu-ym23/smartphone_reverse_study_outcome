package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.IMMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0010\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/resp/MessageList;", "", "messageList", "", "Lcom/larus/im/bean/IMMsg;", "Lcom/larus/bmhome/chat/resp/PushMessage;", "regenList", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "getMessageList", "()Ljava/util/List;", "getRegenList", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageList {

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("message_list")
    private final List<IMMsg> messageList;

    @SerializedName("regen_list")
    private final List<IMMsg> regenList;

    public MessageList() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageList copy$default(MessageList r100, List r101, List r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.messageList;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.regenList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.hasMore;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<IMMsg> component1() {
        return this.messageList;
    }

    public final List<IMMsg> component2() {
        return this.regenList;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final MessageList copy(List<IMMsg> r100, List<IMMsg> r101, boolean r102) {
        return new MessageList(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageList) == true) goto L8;
        return false;
    L8:
        MessageList r101 = (MessageList) r100;
        if (Intrinsics.areEqual(this.messageList, r101.messageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.regenList, r101.regenList) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<IMMsg> r100 = this.messageList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<IMMsg> r104 = this.regenList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.hasMore == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MessageList(messageList=" + this.messageList + ", regenList=" + this.regenList + ", hasMore=" + this.hasMore + ')';
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<IMMsg> getMessageList() {
        return this.messageList;
    }

    public final List<IMMsg> getRegenList() {
        return this.regenList;
    }

    public MessageList(List<IMMsg> r100, List<IMMsg> r101, boolean r102) {
        this.messageList = r100;
        this.regenList = r101;
        this.hasMore = r102;
    }

    public /* synthetic */ MessageList(List r100, List r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
