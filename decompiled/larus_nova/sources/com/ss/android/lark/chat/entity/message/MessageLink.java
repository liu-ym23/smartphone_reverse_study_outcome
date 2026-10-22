package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u0004:\u0002+,BW\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0000H\u0096\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010!\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0000H\u0016J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J%\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0010HÆ\u0003J_\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010'\u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u001cHÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageLink;", "Ljava/io/Serializable;", "", "", "Lcom/larksuite/framework/utils/diff/Diffable;", "token", "", "entityIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "messageInfos", "Ljava/util/HashMap;", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "Lkotlin/collections/HashMap;", "chatInfo", "Lcom/ss/android/lark/chat/entity/message/MessageLink$ChatInfo;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Lcom/ss/android/lark/chat/entity/message/MessageLink$ChatInfo;)V", "getToken", "()Ljava/lang/String;", "getEntityIds", "()Ljava/util/ArrayList;", "getMessageInfos", "()Ljava/util/HashMap;", "getChatInfo", "()Lcom/ss/android/lark/chat/entity/message/MessageLink$ChatInfo;", "compareTo", "", "other", "isItemSame", "", "diffable", "isContentSame", "component1", "component2", "component3", "component4", "copy", "equals", "", "hashCode", "toString", "Entity", "ChatInfo", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageLink implements Serializable, Cloneable, Comparable<MessageLink>, b<MessageLink> {
    private final ChatInfo chatInfo;
    private final ArrayList<Long> entityIds;
    private final HashMap<String, MessageInfo> messageInfos;
    private final String token;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageLink$ChatInfo;", "Ljava/io/Serializable;", "chatName", "", "groupType", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "isP2PBot", "", "chatId", "isAuth", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/chat/Chat$Type;ZLjava/lang/String;Z)V", "getChatName", "()Ljava/lang/String;", "getGroupType", "()Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "()Z", "getChatId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatInfo implements Serializable {
        private final String chatId;
        private final String chatName;
        private final Chat.Type groupType;
        private final boolean isAuth;
        private final boolean isP2PBot;

        public static /* synthetic */ ChatInfo copy$default(ChatInfo r100, String r101, Chat.Type r102, boolean r103, String r104, boolean r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.chatName;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.groupType;
        L8:
            Chat.Type r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.isP2PBot;
        L11:
            boolean r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.chatId;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.isAuth;
        L17:
            String r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final String component1() {
            return this.chatName;
        }

        public final Chat.Type component2() {
            return this.groupType;
        }

        public final boolean component3() {
            return this.isP2PBot;
        }

        public final String component4() {
            return this.chatId;
        }

        public final boolean component5() {
            return this.isAuth;
        }

        public final ChatInfo copy(String r100, Chat.Type r101, boolean r110, String r111, boolean r112) {
            return new ChatInfo(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ChatInfo) == true) goto L8;
            return false;
        L8:
            ChatInfo r101 = (ChatInfo) r100;
            if (Intrinsics.areEqual(this.chatName, r101.chatName) == true) goto L12;
            return false;
        L12:
            if (this.groupType == r101.groupType) goto L15;
            return false;
        L15:
            if (this.isP2PBot == r101.isP2PBot) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L21;
            return false;
        L21:
            if (this.isAuth == r101.isAuth) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            String r100 = this.chatName;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Chat.Type r104 = this.groupType;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            int r107 = 1231;
            if (this.isP2PBot == false) goto L13;
            int r108 = 1231;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.chatId;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            int r111 = (r109 + r101) * 31;
            if (this.isAuth == true) goto L23;
            r107 = 1237;
        L23:
            return r111 + r107;
        L13:
            r108 = 1237;
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "ChatInfo(chatName=" + this.chatName + ", groupType=" + this.groupType + ", isP2PBot=" + this.isP2PBot + ", chatId=" + this.chatId + ", isAuth=" + this.isAuth + ')';
        }

        public final String getChatId() {
            return this.chatId;
        }

        public final String getChatName() {
            return this.chatName;
        }

        public final Chat.Type getGroupType() {
            return this.groupType;
        }

        public final boolean isAuth() {
            return this.isAuth;
        }

        public final boolean isP2PBot() {
            return this.isP2PBot;
        }

        public ChatInfo(String r100, Chat.Type r101, boolean r102, String r103, boolean r104) {
            this.chatName = r100;
            this.groupType = r101;
            this.isP2PBot = r102;
            this.chatId = r103;
            this.isAuth = r104;
        }

        public /* synthetic */ ChatInfo(String r100, Chat.Type r101, boolean r102, String r110, boolean r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 8) == 0) goto L5;
            r110 = null;
        L5:
            String r103 = r110;
            if ((r112 & 16) == 0) goto L8;
            boolean r104 = true;
        L9:
            this(r100, r101, r102, r103, r104);
            return;
        L8:
            r104 = r111;
            goto L9
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageLink$Entity;", "Ljava/io/Serializable;", "", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "thread", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/Message;Lcom/ss/android/lark/biz/im/api/ThreadTopic;)V", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "getThread", "()Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Entity implements Serializable, Cloneable {
        private final Message message;
        private final ThreadTopic thread;

        public static /* synthetic */ Entity copy$default(Entity r100, Message r101, ThreadTopic r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.message;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.thread;
        L9:
            return r100.copy(r101, r102);
        }

        public final Message component1() {
            return this.message;
        }

        public final ThreadTopic component2() {
            return this.thread;
        }

        public final Entity copy(Message r100, ThreadTopic r101) {
            return new Entity(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Entity) == true) goto L8;
            return false;
        L8:
            Entity r101 = (Entity) r100;
            if (Intrinsics.areEqual(this.message, r101.message) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.thread, r101.thread) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Message r100 = this.message;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            ThreadTopic r104 = this.thread;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Entity(message=" + this.message + ", thread=" + this.thread + ')';
        }

        public Object clone() {
            return super.clone();
        }

        public final Message getMessage() {
            return this.message;
        }

        public final ThreadTopic getThread() {
            return this.thread;
        }

        public Entity(Message r100, ThreadTopic r101) {
            this.message = r100;
            this.thread = r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageLink copy$default(MessageLink r100, String r101, ArrayList r102, HashMap r103, ChatInfo r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.entityIds;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.messageInfos;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.chatInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MessageLink r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return 0;
    }

    public final String component1() {
        return this.token;
    }

    public final ArrayList<Long> component2() {
        return this.entityIds;
    }

    public final HashMap<String, MessageInfo> component3() {
        return this.messageInfos;
    }

    public final ChatInfo component4() {
        return this.chatInfo;
    }

    public final MessageLink copy(String r100, ArrayList<Long> r101, HashMap<String, MessageInfo> r102, ChatInfo r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "entityIds");
        Intrinsics.checkNotNullParameter(r102, "messageInfos");
        return new MessageLink(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageLink) == true) goto L8;
        return false;
    L8:
        MessageLink r101 = (MessageLink) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityIds, r101.entityIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageInfos, r101.messageInfos) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chatInfo, r101.chatInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.token.hashCode() * 31) + this.entityIds.hashCode()) * 31) + this.messageInfos.hashCode()) * 31;
        ChatInfo r101 = this.chatInfo;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "MessageLink(token=" + this.token + ", entityIds=" + this.entityIds + ", messageInfos=" + this.messageInfos + ", chatInfo=" + this.chatInfo + ')';
    }

    public Object clone() {
        return super.clone();
    }

    public final ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public final ArrayList<Long> getEntityIds() {
        return this.entityIds;
    }

    public final HashMap<String, MessageInfo> getMessageInfos() {
        return this.messageInfos;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MessageLink r100) {
        return compareTo2(r100);
    }

    public boolean isContentSame(MessageLink r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.token, r100.token) == true) goto L9;
        return false;
    L9:
        if (y28.a.b(CollectionsKt.toMutableList(this.messageInfos.values()), CollectionsKt.toMutableList(r100.messageInfos.values())) == true) goto L11;
        return false;
    L11:
        ChatInfo r101 = this.chatInfo;
        if (r101 != null) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
        return false;
    L19:
        return true;
    L14:
        if (r101.equals(r100.chatInfo) == true) goto L16;
        r102 = true;
        goto L17
    }

    public boolean isItemSame(MessageLink r100) {
        if (Intrinsics.areEqual(this, r100) == false) goto L6;
        return true;
    L6:
        String r101 = this.token;
        if (r100 == null) goto L9;
        String r102 = r100.token;
    L11:
        return Intrinsics.areEqual(r101, r102);
    L9:
        r102 = null;
        goto L11
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((MessageLink) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((MessageLink) r100);
    }

    public MessageLink(String r100, ArrayList<Long> r101, HashMap<String, MessageInfo> r102, ChatInfo r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "entityIds");
        Intrinsics.checkNotNullParameter(r102, "messageInfos");
        this.token = r100;
        this.entityIds = r101;
        this.messageInfos = r102;
        this.chatInfo = r103;
    }

    public /* synthetic */ MessageLink(String r100, ArrayList r101, HashMap r102, ChatInfo r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
