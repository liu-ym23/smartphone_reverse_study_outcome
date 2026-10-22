package com.ss.android.lark.chat.entity.message;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.export.entity.message.Content;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0005CDEFGB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u000201J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010;\u001a\u00020\bH\u0016J\u0013\u0010<\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u00010>H\u0096\u0002J\b\u0010?\u001a\u00020\u001cH\u0016J\u0012\u0010@\u001a\u0002012\b\u0010A\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010B\u001a\u0002012\b\u0010A\u001a\u0004\u0018\u00010\u0000H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006H"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "builder", "Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$Builder;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$Builder;)V", "foldId", "", "getFoldId", "()Ljava/lang/String;", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "rootMessageId", "getRootMessageId", "rootMessagePosition", "", "getRootMessagePosition", "()J", "lastMessageId", "getLastMessageId", "lastMessagePosition", "getLastMessagePosition", "lastMessageBadgeCount", "getLastMessageBadgeCount", "userLength", "", "getUserLength", "()I", "totalCount", "getTotalCount", "updateTimeMs", "getUpdateTimeMs", "userCounts", "", "Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$FoldUserCount;", "getUserCounts", "()Ljava/util/List;", "recallType", "Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$RecallType;", "getRecallType", "()Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$RecallType;", "recallChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getRecallChatter", "()Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "enableFollow", "", "getEnableFollow", "()Z", "content", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "getContent", "()Lcom/ss/android/lark/chat/export/entity/message/Content;", "getCardType", "Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$CardType;", "isFakeFold", "toString", "equals", "other", "", "hashCode", "isItemSame", "diffable", "isContentSame", "FoldUserCount", "RecallType", "CardType", "Builder", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageFoldDetail implements y28.b<MessageFoldDetail>, Serializable {
    public static final a Companion = null;
    private final Builder builder;
    private final Content content;
    private final boolean enableFollow;
    private final String foldId;
    private final long lastMessageBadgeCount;
    private final String lastMessageId;
    private final long lastMessagePosition;
    private final Message message;
    private final ChatChatter recallChatter;
    private final RecallType recallType;
    private final String rootMessageId;
    private final long rootMessagePosition;
    private final int totalCount;
    private final long updateTimeMs;
    private final List<b> userCounts;
    private final int userLength;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010G\u001a\u00020HJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0014J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\u0014J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010L\u001a\u00020#J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010K\u001a\u00020#J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0014J\u0014\u0010.\u001a\u00020\u00002\f\u0010K\u001a\b\u0012\u0004\u0012\u0002000/J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u000206J\u0010\u0010;\u001a\u00020\u00002\b\u0010N\u001a\u0004\u0018\u00010<J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010O\u001a\u00020BR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001a\u0010+\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R \u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006P"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$Builder;", "Ljava/io/Serializable;", "<init>", "()V", "foldId", "", "getFoldId", "()Ljava/lang/String;", "setFoldId", "(Ljava/lang/String;)V", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "setMessage", "(Lcom/ss/android/lark/chat/entity/message/Message;)V", "rootMessageId", "getRootMessageId", "setRootMessageId", "rootMessagePosition", "", "getRootMessagePosition", "()J", "setRootMessagePosition", "(J)V", "lastMessageId", "getLastMessageId", "setLastMessageId", "lastMessagePos", "getLastMessagePos", "setLastMessagePos", "lastMessageBadgeCount", "getLastMessageBadgeCount", "setLastMessageBadgeCount", "userLength", "", "getUserLength", "()I", "setUserLength", "(I)V", "totalCount", "getTotalCount", "setTotalCount", "updateTimeMs", "getUpdateTimeMs", "setUpdateTimeMs", "userCounts", "", "Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$FoldUserCount;", "getUserCounts", "()Ljava/util/List;", "setUserCounts", "(Ljava/util/List;)V", "recallType", "Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$RecallType;", "getRecallType", "()Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$RecallType;", "setRecallType", "(Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$RecallType;)V", "recallChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getRecallChatter", "()Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "setRecallChatter", "(Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;)V", "enableFollow", "", "getEnableFollow", "()Z", "setEnableFollow", "(Z)V", "build", "Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail;", RemoteMessageConst.MSGID, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "count", "length", "time", "chatChatter", "enable", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder implements Serializable {
        private boolean enableFollow;
        private String foldId;
        private long lastMessageBadgeCount;
        private String lastMessageId;
        private long lastMessagePos;
        private Message message;
        private ChatChatter recallChatter;
        private RecallType recallType;
        private String rootMessageId;
        private long rootMessagePosition;
        private int totalCount;
        private long updateTimeMs;
        private List<b> userCounts;
        private int userLength;

        public final MessageFoldDetail build() {
            return new MessageFoldDetail(this);
        }

        public Builder() {
            this.foldId = "";
            this.rootMessageId = "";
            this.rootMessagePosition = -1;
            this.lastMessageId = "";
            this.lastMessagePos = -1;
            this.userCounts = CollectionsKt.emptyList();
            this.recallType = RecallType.NOT_RECALL;
        }

        public final boolean getEnableFollow() {
            return this.enableFollow;
        }

        public final String getFoldId() {
            return this.foldId;
        }

        public final long getLastMessageBadgeCount() {
            return this.lastMessageBadgeCount;
        }

        public final String getLastMessageId() {
            return this.lastMessageId;
        }

        public final long getLastMessagePos() {
            return this.lastMessagePos;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final ChatChatter getRecallChatter() {
            return this.recallChatter;
        }

        public final RecallType getRecallType() {
            return this.recallType;
        }

        public final String getRootMessageId() {
            return this.rootMessageId;
        }

        public final long getRootMessagePosition() {
            return this.rootMessagePosition;
        }

        public final int getTotalCount() {
            return this.totalCount;
        }

        public final long getUpdateTimeMs() {
            return this.updateTimeMs;
        }

        public final List<b> getUserCounts() {
            return this.userCounts;
        }

        public final int getUserLength() {
            return this.userLength;
        }

        public final Builder enableFollow(boolean r100) {
            this.enableFollow = r100;
            return this;
        }

        public final Builder foldId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "foldId");
            this.foldId = r100;
            return this;
        }

        public final Builder lastMessageBadgeCount(long r100) {
            this.lastMessageBadgeCount = r100;
            return this;
        }

        public final Builder lastMessageId(String r100) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
            this.lastMessageId = r100;
            return this;
        }

        public final Builder lastMessagePos(long r100) {
            this.lastMessagePos = r100;
            return this;
        }

        public final Builder message(Message r100) {
            this.message = r100;
            return this;
        }

        public final Builder recallChatter(ChatChatter r100) {
            this.recallChatter = r100;
            return this;
        }

        public final Builder recallType(RecallType r100) {
            Intrinsics.checkNotNullParameter(r100, "recallType");
            this.recallType = r100;
            return this;
        }

        public final Builder rootMessageId(String r100) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
            this.rootMessageId = r100;
            return this;
        }

        public final Builder rootMessagePosition(long r100) {
            this.rootMessagePosition = r100;
            return this;
        }

        public final void setEnableFollow(boolean r100) {
            this.enableFollow = r100;
        }

        public final void setFoldId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.foldId = r100;
        }

        public final void setLastMessageBadgeCount(long r100) {
            this.lastMessageBadgeCount = r100;
        }

        public final void setLastMessageId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.lastMessageId = r100;
        }

        public final void setLastMessagePos(long r100) {
            this.lastMessagePos = r100;
        }

        public final void setMessage(Message r100) {
            this.message = r100;
        }

        public final void setRecallChatter(ChatChatter r100) {
            this.recallChatter = r100;
        }

        public final void setRecallType(RecallType r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.recallType = r100;
        }

        public final void setRootMessageId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.rootMessageId = r100;
        }

        public final void setRootMessagePosition(long r100) {
            this.rootMessagePosition = r100;
        }

        public final void setTotalCount(int r100) {
            this.totalCount = r100;
        }

        public final void setUpdateTimeMs(long r100) {
            this.updateTimeMs = r100;
        }

        public final void setUserCounts(List<b> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.userCounts = r100;
        }

        public final void setUserLength(int r100) {
            this.userLength = r100;
        }

        public final Builder totalCount(int r100) {
            this.totalCount = r100;
            return this;
        }

        public final Builder updateTimeMs(long r100) {
            this.updateTimeMs = r100;
            return this;
        }

        public final Builder userCounts(List<b> r100) {
            Intrinsics.checkNotNullParameter(r100, "count");
            this.userCounts = r100;
            return this;
        }

        public final Builder userLength(int r100) {
            this.userLength = r100;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$CardType;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "FOLD_CARD", "SYSTEM_MSG", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CardType extends Enum<CardType> {
        public static final CardType FOLD_CARD = null;
        public static final CardType LOADING = null;
        public static final CardType SYSTEM_MSG = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardType[] f415236a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415237b = null;

        public static EnumEntries<CardType> getEntries() {
            return f415237b;
        }

        static {
            CardType r100 = new CardType("LOADING", 0);
            LOADING = r100;
            CardType r101 = new CardType("FOLD_CARD", 1);
            FOLD_CARD = r101;
            CardType r102 = new CardType("SYSTEM_MSG", 2);
            SYSTEM_MSG = r102;
            CardType[] r103 = {r100, r101, r102};
            f415236a = r103;
            f415237b = EnumEntriesKt.enumEntries(r103);
        }

        public static CardType[] values() {
            return (CardType[]) f415236a.clone();
        }

        public static CardType valueOf(String r100) {
            return (CardType) r27.a.a(CardType.class, r100);
        }

        public CardType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageFoldDetail$RecallType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT_RECALL", "USER_RECALL", "GROUP_OWNER_RECALL", "GROUP_ADMIN_RECALL", "ENTERPRISE_ADMIN_RECALL", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RecallType extends Enum<RecallType> {
        public static final a Companion = null;
        public static final RecallType ENTERPRISE_ADMIN_RECALL = null;
        public static final RecallType GROUP_ADMIN_RECALL = null;
        public static final RecallType GROUP_OWNER_RECALL = null;
        public static final RecallType NOT_RECALL = null;
        public static final RecallType USER_RECALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecallType[] f415238a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415239b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RecallType> getEntries() {
            return f415239b;
        }

        static {
            RecallType r100 = new RecallType("NOT_RECALL", 0, 0);
            NOT_RECALL = r100;
            RecallType r101 = new RecallType("USER_RECALL", 1, 1);
            USER_RECALL = r101;
            RecallType r102 = new RecallType("GROUP_OWNER_RECALL", 2, 2);
            GROUP_OWNER_RECALL = r102;
            RecallType r103 = new RecallType("GROUP_ADMIN_RECALL", 3, 3);
            GROUP_ADMIN_RECALL = r103;
            RecallType r104 = new RecallType("ENTERPRISE_ADMIN_RECALL", 4, 4);
            ENTERPRISE_ADMIN_RECALL = r104;
            RecallType[] r105 = {r100, r101, r102, r103, r104};
            f415238a = r105;
            f415239b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static RecallType[] values() {
            return (RecallType[]) f415238a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final RecallType fromValue(int r100) {
            Companion.getClass();
            RecallType[] r101 = values();
            if (r100 >= 0) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L11;
            return r101[r100];
        L11:
            return NOT_RECALL;
        L5:
            if (r100 >= r101.length) goto L7;
            r102 = true;
            goto L8
        }

        public static RecallType valueOf(String r100) {
            return (RecallType) r27.a.a(RecallType.class, r100);
        }

        public RecallType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChatChatter f415240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f415241b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f415240a, r101.f415240a) == true) goto L12;
            return false;
        L12:
            if (this.f415241b == r101.f415241b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f415240a.hashCode() * 31) + this.f415241b;
        }

        public final String toString() {
            return "FoldUserCount(user=" + this.f415240a + ", count=" + this.f415241b + ')';
        }

        public b(ChatChatter r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "user");
            this.f415240a = r100;
            this.f415241b = r101;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final Builder newBuilder() {
        Companion.getClass();
        return new Builder();
    }

    public int hashCode() {
        Message r100 = this.message;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((((((((((((((((((((r101 * 31) + this.rootMessageId.hashCode()) * 31) + ((int) this.rootMessagePosition)) * 31) + this.lastMessageId.hashCode()) * 31) + ((int) this.lastMessagePosition)) * 31) + ((int) this.lastMessageBadgeCount)) * 31) + this.userLength) * 31) + this.totalCount) * 31) + ((int) this.updateTimeMs)) * 31) + this.userCounts.hashCode()) * 31) + this.recallType.hashCode()) * 31;
        ChatChatter r103 = this.recallChatter;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L11:
        return ((((r102 + r104) * 31) + this.foldId.hashCode()) * 31) + Boolean.compare(this.enableFollow, false);
    L9:
        r104 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L6
    }

    public final boolean isFakeFold() {
        if (this.updateTimeMs != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "MessageFoldDetail {foldId: " + this.foldId + "; rootMessagePosition: " + this.rootMessagePosition + "; lastMessagePosition: " + this.lastMessagePosition + "; userLength: " + this.userLength + "; totalCount: " + this.totalCount + " enableFollow: " + this.enableFollow + " }";
    }

    public final CardType getCardType() {
        if (isFakeFold() == false) goto L7;
        return CardType.LOADING;
    L7:
        if (this.totalCount == 0) goto L14;
        if (this.recallType.compareTo(RecallType.NOT_RECALL) > 0) goto L14;
        return CardType.FOLD_CARD;
    L14:
        return CardType.SYSTEM_MSG;
    }

    public final Builder builder() {
        return this.builder;
    }

    public final Content getContent() {
        return this.content;
    }

    public final boolean getEnableFollow() {
        return this.enableFollow;
    }

    public final String getFoldId() {
        return this.foldId;
    }

    public final long getLastMessageBadgeCount() {
        return this.lastMessageBadgeCount;
    }

    public final String getLastMessageId() {
        return this.lastMessageId;
    }

    public final long getLastMessagePosition() {
        return this.lastMessagePosition;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final ChatChatter getRecallChatter() {
        return this.recallChatter;
    }

    public final RecallType getRecallType() {
        return this.recallType;
    }

    public final String getRootMessageId() {
        return this.rootMessageId;
    }

    public final long getRootMessagePosition() {
        return this.rootMessagePosition;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public final List<b> getUserCounts() {
        return this.userCounts;
    }

    public final int getUserLength() {
        return this.userLength;
    }

    public MessageFoldDetail(Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.builder = r100;
        this.foldId = r100.getFoldId();
        this.message = r100.getMessage();
        this.rootMessageId = r100.getRootMessageId();
        this.rootMessagePosition = r100.getRootMessagePosition();
        this.lastMessageId = r100.getLastMessageId();
        this.lastMessagePosition = r100.getLastMessagePos();
        this.lastMessageBadgeCount = r100.getLastMessageBadgeCount();
        this.userLength = r100.getUserLength();
        this.totalCount = r100.getTotalCount();
        this.updateTimeMs = r100.getUpdateTimeMs();
        this.userCounts = r100.getUserCounts();
        this.recallType = r100.getRecallType();
        this.recallChatter = r100.getRecallChatter();
        this.enableFollow = r100.getEnableFollow();
        Message r101 = r100.getMessage();
        if (r101 == null) goto L5;
        Content r102 = r101.getContent();
    L6:
        this.content = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MessageFoldDetail) == true) goto L5;
        return false;
    L5:
        MessageFoldDetail r101 = (MessageFoldDetail) r100;
        if (Objects.equals(this.message, r101.message) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.rootMessageId, r101.rootMessageId) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(Long.valueOf(this.rootMessagePosition), Long.valueOf(r101.rootMessagePosition)) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(this.lastMessageId, r101.lastMessageId) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(Long.valueOf(this.lastMessagePosition), Long.valueOf(r101.lastMessagePosition)) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(Long.valueOf(this.lastMessageBadgeCount), Long.valueOf(r101.lastMessageBadgeCount)) == true) goto L18;
        return false;
    L18:
        if (Objects.equals(Integer.valueOf(this.userLength), Integer.valueOf(r101.userLength)) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(Integer.valueOf(this.totalCount), Integer.valueOf(r101.totalCount)) == true) goto L22;
        return false;
    L22:
        if (Objects.equals(Long.valueOf(this.updateTimeMs), Long.valueOf(r101.updateTimeMs)) == true) goto L24;
        return false;
    L24:
        if (Objects.equals(this.userCounts, r101.userCounts) == true) goto L26;
        return false;
    L26:
        if (Objects.equals(this.recallType, r101.recallType) == true) goto L28;
        return false;
    L28:
        if (Objects.equals(this.recallChatter, r101.recallChatter) == true) goto L30;
        return false;
    L30:
        if (Objects.equals(this.foldId, r101.foldId) == true) goto L32;
        return false;
    L32:
        if (Objects.equals(Boolean.valueOf(this.enableFollow), Boolean.valueOf(r101.enableFollow)) == false) goto L48;
        return true;
    L48:
        return false;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((MessageFoldDetail) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((MessageFoldDetail) r100);
    }

    public boolean isContentSame(MessageFoldDetail r100) {
        return Intrinsics.areEqual(this, r100);
    }

    public boolean isItemSame(MessageFoldDetail r100) {
        return Intrinsics.areEqual(this, r100);
    }
}
