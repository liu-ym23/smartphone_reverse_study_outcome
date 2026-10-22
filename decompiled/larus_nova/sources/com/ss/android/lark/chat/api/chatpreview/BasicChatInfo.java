package com.ss.android.lark.chat.api.chatpreview;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003Je\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/api/chatpreview/BasicChatInfo;", "Ljava/io/Serializable;", "chatId", "Lcom/ss/android/lark/chat/api/chatpreview/ChatId;", "title", "", "avatarKey", "isThread", "", "isP2P", "p2pChatterId", "chatterType", "Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "isSecret", "isAiKnowLedge", "<init>", "(Lcom/ss/android/lark/chat/api/chatpreview/ChatId;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;ZZ)V", "getChatId", "()Lcom/ss/android/lark/chat/api/chatpreview/ChatId;", "getTitle", "()Ljava/lang/String;", "getAvatarKey", "()Z", "getP2pChatterId", "getChatterType", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BasicChatInfo implements Serializable {
    private final String avatarKey;
    private final ChatId chatId;
    private final Chatter.ChatterType chatterType;
    private final boolean isAiKnowLedge;
    private final boolean isP2P;
    private final boolean isSecret;
    private final boolean isThread;
    private final String p2pChatterId;
    private final String title;

    public static /* synthetic */ BasicChatInfo copy$default(BasicChatInfo r110, ChatId r111, String r112, String r113, boolean r114, boolean r115, String r116, Chatter.ChatterType r117, boolean r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        ChatId r100 = r110.chatId;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.avatarKey;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.isThread;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r104 = r110.isP2P;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.p2pChatterId;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Chatter.ChatterType r106 = r110.chatterType;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.isSecret;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.isAiKnowLedge;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
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

    public final ChatId component1() {
        return this.chatId;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final boolean component4() {
        return this.isThread;
    }

    public final boolean component5() {
        return this.isP2P;
    }

    public final String component6() {
        return this.p2pChatterId;
    }

    public final Chatter.ChatterType component7() {
        return this.chatterType;
    }

    public final boolean component8() {
        return this.isSecret;
    }

    public final boolean component9() {
        return this.isAiKnowLedge;
    }

    public final BasicChatInfo copy(ChatId r110, String r111, String r112, boolean r113, boolean r114, String r115, Chatter.ChatterType r116, boolean r117, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "chatId");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r112, "avatarKey");
        Intrinsics.checkNotNullParameter(r115, "p2pChatterId");
        return new BasicChatInfo(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BasicChatInfo) == true) goto L8;
        return false;
    L8:
        BasicChatInfo r101 = (BasicChatInfo) r100;
        if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L18;
        return false;
    L18:
        if (this.isThread == r101.isThread) goto L21;
        return false;
    L21:
        if (this.isP2P == r101.isP2P) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.p2pChatterId, r101.p2pChatterId) == true) goto L27;
        return false;
    L27:
        if (this.chatterType == r101.chatterType) goto L30;
        return false;
    L30:
        if (this.isSecret == r101.isSecret) goto L33;
        return false;
    L33:
        if (this.isAiKnowLedge == r101.isAiKnowLedge) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.chatId.hashCode() * 31) + this.title.hashCode()) * 31) + this.avatarKey.hashCode()) * 31;
        int r101 = 1231;
        if (this.isThread == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isP2P == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.p2pChatterId.hashCode()) * 31;
        Chatter.ChatterType r106 = this.chatterType;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.isSecret == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.isAiKnowLedge == true) goto L23;
        r101 = 1237;
    L23:
        return r110 + r101;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "BasicChatInfo(chatId=" + this.chatId + ", title=" + this.title + ", avatarKey=" + this.avatarKey + ", isThread=" + this.isThread + ", isP2P=" + this.isP2P + ", p2pChatterId=" + this.p2pChatterId + ", chatterType=" + this.chatterType + ", isSecret=" + this.isSecret + ", isAiKnowLedge=" + this.isAiKnowLedge + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final ChatId getChatId() {
        return this.chatId;
    }

    public final Chatter.ChatterType getChatterType() {
        return this.chatterType;
    }

    public final String getP2pChatterId() {
        return this.p2pChatterId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isAiKnowLedge() {
        return this.isAiKnowLedge;
    }

    public final boolean isP2P() {
        return this.isP2P;
    }

    public final boolean isSecret() {
        return this.isSecret;
    }

    public final boolean isThread() {
        return this.isThread;
    }

    public BasicChatInfo(ChatId r100, String r101, String r102, boolean r103, boolean r104, String r105, Chatter.ChatterType r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        Intrinsics.checkNotNullParameter(r105, "p2pChatterId");
        this.chatId = r100;
        this.title = r101;
        this.avatarKey = r102;
        this.isThread = r103;
        this.isP2P = r104;
        this.p2pChatterId = r105;
        this.chatterType = r106;
        this.isSecret = r107;
        this.isAiKnowLedge = r110;
    }

    public /* synthetic */ BasicChatInfo(ChatId r110, String r111, String r112, boolean r113, boolean r114, String r115, Chatter.ChatterType r210, boolean r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 128) == 0) goto L5;
        boolean r116 = false;
    L7:
        if ((r213 & 256) == 0) goto L9;
        boolean r117 = false;
    L10:
        this(r110, r111, r112, r113, r114, r115, r210, r116, r117);
        return;
    L9:
        r117 = r212;
        goto L10
    L5:
        r116 = r211;
        goto L7
    }
}
