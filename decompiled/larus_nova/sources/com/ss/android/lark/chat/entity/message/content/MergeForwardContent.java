package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.alipay.sdk.m.x.d;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.export.entity.message.Content;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001mB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010h\u001a\u00020,2\b\u0010i\u001a\u0004\u0018\u00010jH\u0096\u0002J\b\u0010k\u001a\u00020cH\u0016J\b\u0010l\u001a\u00020\u0000H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR(\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001c\u00102\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u001a\u00105\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010-\"\u0004\b6\u0010/R\u001a\u00107\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001c\u00109\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\b\"\u0004\b;\u0010\nR\u001c\u0010<\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010\nR\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\u001a\u0010N\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\b\"\u0004\bP\u0010\nR\u001a\u0010Q\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\b\"\u0004\bS\u0010\nR,\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\f0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010(\"\u0004\bW\u0010*R&\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020Y0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010(\"\u0004\b[\u0010*R&\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020]0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010(\"\u0004\b_\u0010*R\u001a\u0010`\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010-\"\u0004\ba\u0010/R\u001a\u0010b\u001a\u00020cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g¨\u0006n"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "", "<init>", "()V", "threadOwnerDisplayName", "", "getThreadOwnerDisplayName", "()Ljava/lang/String;", "setThreadOwnerDisplayName", "(Ljava/lang/String;)V", "messages", "", "Lcom/ss/android/lark/chat/entity/message/Message;", "getMessages", "()Ljava/util/List;", "setMessages", "(Ljava/util/List;)V", "type", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "getType", "()Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "setType", "(Lcom/ss/android/lark/chat/entity/chat/Chat$Type;)V", "groupChatName", "getGroupChatName", "setGroupChatName", "p2pCreatorName", "getP2pCreatorName", "setP2pCreatorName", "p2pPartnerName", "getP2pPartnerName", "setP2pPartnerName", "quasiTitle", "getQuasiTitle", "setQuasiTitle", "chatters", "", "Lcom/ss/android/lark/chat/entity/chatter/ChatterInfo;", "getChatters", "()Ljava/util/Map;", "setChatters", "(Ljava/util/Map;)V", "isTranslated", "", "()Z", "setTranslated", "(Z)V", "isManualTranslated", "setManualTranslated", "messageId", "getMessageId", "setMessageId", "isFromPrivateTopic", "setFromPrivateTopic", "isReplyInThread", "setReplyInThread", "title", "getTitle", d.f25925o, "subtitle", "getSubtitle", "setSubtitle", "originChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getOriginChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "setOriginChat", "(Lcom/ss/android/lark/chat/entity/chat/Chat;)V", "thread", "Lcom/bytedance/lark/pb/basic/v1/Thread;", "getThread", "()Lcom/bytedance/lark/pb/basic/v1/Thread;", "setThread", "(Lcom/bytedance/lark/pb/basic/v1/Thread;)V", "threadId", "getThreadId", "setThreadId", "p2pThreadCreatorName", "getP2pThreadCreatorName", "setP2pThreadCreatorName", "p2pThreadPartnerName", "getP2pThreadPartnerName", "setP2pThreadPartnerName", "reactionMap", "Lcom/ss/android/lark/chat/entity/reaction/Reaction;", "getReactionMap", "setReactionMap", "reactionChatterMap", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getReactionChatterMap", "setReactionChatterMap", "messageThreadMap", "Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent$MessageThread;", "getMessageThreadMap", "setMessageThreadMap", "isCopyFromDoubao", "setCopyFromDoubao", "fromType", "", "getFromType", "()I", "setFromType", "(I)V", "equals", "content", "", "hashCode", "clone", "MessageThread", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "MergeForwardContent")
public final class MergeForwardContent extends Content implements Cloneable {
    private Map<String, ? extends ChatterInfo> chatters;
    private int fromType;
    private String groupChatName;
    private boolean isCopyFromDoubao;
    private boolean isFromPrivateTopic;
    private boolean isManualTranslated;
    private boolean isReplyInThread;
    private boolean isTranslated;
    private String messageId;
    private Map<String, MessageThread> messageThreadMap;
    private List<? extends Message> messages;
    private Chat originChat;
    private String p2pCreatorName;
    private String p2pPartnerName;
    private String p2pThreadCreatorName;
    private String p2pThreadPartnerName;
    private String quasiTitle;
    private Map<String, ? extends Chatter> reactionChatterMap;
    private Map<String, ? extends List<? extends Reaction>> reactionMap;
    private String subtitle;
    private Thread thread;
    private String threadId;
    private String threadOwnerDisplayName;
    private String title;
    private Chat.Type type;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent$MessageThread;", "Ljava/io/Serializable;", "<init>", "()V", "replyCount", "", "getReplyCount", "()I", "setReplyCount", "(I)V", "latestReplyTime", "", "getLatestReplyTime", "()J", "setLatestReplyTime", "(J)V", "childMessages", "", "Lcom/ss/android/lark/chat/entity/message/Message;", "getChildMessages", "()Ljava/util/List;", "setChildMessages", "(Ljava/util/List;)V", "reactionMap", "", "", "", "Lcom/ss/android/lark/chat/entity/reaction/Reaction;", "getReactionMap", "()Ljava/util/Map;", "setReactionMap", "(Ljava/util/Map;)V", "equals", "", "other", "", "hashCode", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageThread implements Serializable {
        private List<Message> childMessages;
        private long latestReplyTime;
        private Map<String, ? extends List<? extends Reaction>> reactionMap;
        private int replyCount;

        public int hashCode() {
            int r100 = this.replyCount * 31;
            long r101 = this.latestReplyTime;
            return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.childMessages.hashCode()) * 31) + this.reactionMap.hashCode();
        }

        public MessageThread() {
            this.childMessages = new ArrayList();
            this.reactionMap = new HashMap();
        }

        public final List<Message> getChildMessages() {
            return this.childMessages;
        }

        public final long getLatestReplyTime() {
            return this.latestReplyTime;
        }

        public final Map<String, List<Reaction>> getReactionMap() {
            return this.reactionMap;
        }

        public final int getReplyCount() {
            return this.replyCount;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MessageThread) == true) goto L8;
            return false;
        L8:
            MessageThread r101 = (MessageThread) r100;
            if (this.replyCount == r101.replyCount) goto L11;
        L17:
            return false;
        L11:
            if (this.latestReplyTime != r101.latestReplyTime) goto L17;
            if (Intrinsics.areEqual(this.childMessages, r101.childMessages) == false) goto L17;
            if (Intrinsics.areEqual(this.reactionMap, r101.reactionMap) == false) goto L17;
            return true;
        }

        public final void setChildMessages(List<Message> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.childMessages = r100;
        }

        public final void setLatestReplyTime(long r100) {
            this.latestReplyTime = r100;
        }

        public final void setReactionMap(Map<String, ? extends List<? extends Reaction>> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.reactionMap = r100;
        }

        public final void setReplyCount(int r100) {
            this.replyCount = r100;
        }
    }

    public int hashCode() {
        List<? extends Message> r100 = this.messages;
        int r101 = 0;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Chat.Type r104 = this.type;
        if (r104 == null) goto L9;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.groupChatName;
        if (r107 == null) goto L13;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.p2pCreatorName;
        if (r110 == null) goto L17;
        Intrinsics.checkNotNull(r110);
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.p2pPartnerName;
        if (r113 == null) goto L22;
        Intrinsics.checkNotNull(r113);
        r101 = r113.hashCode();
    L22:
        return ((((((((r112 + r101) * 31) + this.p2pThreadCreatorName.hashCode()) * 31) + this.p2pThreadPartnerName.hashCode()) * 31) + this.threadOwnerDisplayName.hashCode()) * 31) + this.messageThreadMap.hashCode();
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public MergeForwardContent() {
        this.threadOwnerDisplayName = "";
        this.title = "";
        this.subtitle = "";
        this.threadId = "";
        this.p2pThreadCreatorName = "";
        this.p2pThreadPartnerName = "";
        this.reactionMap = new HashMap();
        this.reactionChatterMap = new HashMap();
        this.messageThreadMap = new HashMap();
        this.fromType = -1;
    }

    public MergeForwardContent clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.MergeForwardContent");
        MergeForwardContent r101 = (MergeForwardContent) r100;
        ArrayList r102 = new ArrayList();
        List<? extends Message> r103 = this.messages;
        if (r103 == null) goto L8;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r102.add(((Message) r104.next()).clone());
    L8:
        r101.messages = r102;
        return r101;
    }

    public final Map<String, ChatterInfo> getChatters() {
        return this.chatters;
    }

    public final int getFromType() {
        return this.fromType;
    }

    public final String getGroupChatName() {
        return this.groupChatName;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final Map<String, MessageThread> getMessageThreadMap() {
        return this.messageThreadMap;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final Chat getOriginChat() {
        return this.originChat;
    }

    public final String getP2pCreatorName() {
        return this.p2pCreatorName;
    }

    public final String getP2pPartnerName() {
        return this.p2pPartnerName;
    }

    public final String getP2pThreadCreatorName() {
        return this.p2pThreadCreatorName;
    }

    public final String getP2pThreadPartnerName() {
        return this.p2pThreadPartnerName;
    }

    public final String getQuasiTitle() {
        return this.quasiTitle;
    }

    public final Map<String, Chatter> getReactionChatterMap() {
        return this.reactionChatterMap;
    }

    public final Map<String, List<Reaction>> getReactionMap() {
        return this.reactionMap;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final Thread getThread() {
        return this.thread;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final String getThreadOwnerDisplayName() {
        return this.threadOwnerDisplayName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Chat.Type getType() {
        return this.type;
    }

    public final boolean isCopyFromDoubao() {
        return this.isCopyFromDoubao;
    }

    public final boolean isFromPrivateTopic() {
        return this.isFromPrivateTopic;
    }

    public final boolean isManualTranslated() {
        return this.isManualTranslated;
    }

    public final boolean isReplyInThread() {
        return this.isReplyInThread;
    }

    public final boolean isTranslated() {
        return this.isTranslated;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8614clone() {
        return clone();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MergeForwardContent) == true) goto L8;
        return false;
    L8:
        List<? extends Message> r101 = this.messages;
        if (r101 == null) goto L14;
        if (Intrinsics.areEqual(r101, ((MergeForwardContent) r100).messages) == false) goto L15;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
        return false;
    L19:
        MergeForwardContent r103 = (MergeForwardContent) r100;
        if (this.type == r103.type) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.p2pThreadCreatorName, r103.p2pThreadCreatorName) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.p2pThreadPartnerName, r103.p2pThreadPartnerName) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.threadOwnerDisplayName, r103.threadOwnerDisplayName) == true) goto L31;
        return false;
    L31:
        String r104 = this.groupChatName;
        if (r104 == null) goto L37;
        if (Intrinsics.areEqual(r104, r103.groupChatName) == false) goto L38;
    L39:
        boolean r105 = false;
    L40:
        if (r105 == false) goto L42;
        return false;
    L42:
        String r106 = this.p2pCreatorName;
        if (r106 == null) goto L48;
        if (Intrinsics.areEqual(r106, r103.p2pCreatorName) == false) goto L49;
    L50:
        boolean r107 = false;
    L51:
        if (r107 == false) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.messageThreadMap, r103.messageThreadMap) == true) goto L56;
        return false;
    L56:
        Thread r108 = this.thread;
        if (r108 == null) goto L61;
        Integer r109 = r108.reply_count;
        if (r109 == null) goto L61;
        int r110 = r109.intValue();
    L62:
        Thread r111 = r103.thread;
        if (r111 == null) goto L66;
        Integer r112 = r111.reply_count;
        if (r112 == null) goto L66;
    L68:
        if (r110 == r112.intValue()) goto L70;
        return false;
    L70:
        String r113 = this.p2pPartnerName;
        String r114 = r103.p2pPartnerName;
        if (r113 != null) goto L77;
        if (r114 == null) goto L78;
        return false;
    L78:
        return true;
    L77:
        return Intrinsics.areEqual(r113, r114);
    L66:
        r112 = 0;
    L61:
        r110 = 0;
    L49:
        r107 = true;
        goto L51
    L48:
        if (r103.p2pCreatorName == null) goto L50;
    L38:
        r105 = true;
        goto L40
    L37:
        if (r103.groupChatName == null) goto L39;
    L15:
        r102 = true;
        goto L17
    L14:
        if (((MergeForwardContent) r100).messages == null) goto L16;
        goto L15
    }

    public final void setChatters(Map<String, ? extends ChatterInfo> r100) {
        this.chatters = r100;
    }

    public final void setCopyFromDoubao(boolean r100) {
        this.isCopyFromDoubao = r100;
    }

    public final void setFromPrivateTopic(boolean r100) {
        this.isFromPrivateTopic = r100;
    }

    public final void setFromType(int r100) {
        this.fromType = r100;
    }

    public final void setGroupChatName(String r100) {
        this.groupChatName = r100;
    }

    public final void setManualTranslated(boolean r100) {
        this.isManualTranslated = r100;
    }

    public final void setMessageId(String r100) {
        this.messageId = r100;
    }

    public final void setMessageThreadMap(Map<String, MessageThread> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.messageThreadMap = r100;
    }

    public final void setMessages(List<? extends Message> r100) {
        this.messages = r100;
    }

    public final void setOriginChat(Chat r100) {
        this.originChat = r100;
    }

    public final void setP2pCreatorName(String r100) {
        this.p2pCreatorName = r100;
    }

    public final void setP2pPartnerName(String r100) {
        this.p2pPartnerName = r100;
    }

    public final void setP2pThreadCreatorName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.p2pThreadCreatorName = r100;
    }

    public final void setP2pThreadPartnerName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.p2pThreadPartnerName = r100;
    }

    public final void setQuasiTitle(String r100) {
        this.quasiTitle = r100;
    }

    public final void setReactionChatterMap(Map<String, ? extends Chatter> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reactionChatterMap = r100;
    }

    public final void setReactionMap(Map<String, ? extends List<? extends Reaction>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reactionMap = r100;
    }

    public final void setReplyInThread(boolean r100) {
        this.isReplyInThread = r100;
    }

    public final void setSubtitle(String r100) {
        this.subtitle = r100;
    }

    public final void setThread(Thread r100) {
        this.thread = r100;
    }

    public final void setThreadId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.threadId = r100;
    }

    public final void setThreadOwnerDisplayName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.threadOwnerDisplayName = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTranslated(boolean r100) {
        this.isTranslated = r100;
    }

    public final void setType(Chat.Type r100) {
        this.type = r100;
    }
}
