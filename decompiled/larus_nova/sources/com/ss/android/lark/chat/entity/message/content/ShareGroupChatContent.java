package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "setChat", "(Lcom/ss/android/lark/chat/entity/chat/Chat;)V", "joinToken", "", "getJoinToken", "()Ljava/lang/String;", "setJoinToken", "(Ljava/lang/String;)V", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "getExpireTime", "()J", "setExpireTime", "(J)V", "joinChatErrState", "Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent$GroupState;", "getJoinChatErrState", "()Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent$GroupState;", "setJoinChatErrState", "(Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent$GroupState;)V", "isContentSame", "", "diffable", "isItemSame", "GroupState", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "ShareGroupChatContent")
public final class ShareGroupChatContent extends Content {
    private Chat chat;
    private long expireTime;
    private GroupState joinChatErrState;
    private String joinToken;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent$GroupState;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "ALREADY_IN_GROUP", "JUST_SHOW_GROUP_INFO", "CAN_JOIN_DIRECTLY", "NEED_APPLY", "PENDING_APPROVAL", "NEED_CREATE_TENANT", "NEED_SWITCH_TENANT", "EXTERNAL_USERS_CANNOT_OPERATE", "INVITER_LEFT", "GROUP_DISBANDED", "SHARING_DISABLED", "SHARE_EXPIRED", "NO_EXTERNAL_COMMUNICATION_AUTHORITY", "GROUP_IS_FULL", "LINK_CERTIFIED_REFUSE", "QR_CODE_CERTIFIED_REFUSE", "SHARE_CARD_CERTIFIED_REFUSE", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GroupState extends Enum<GroupState> implements Serializable {
        public static final GroupState ALREADY_IN_GROUP = null;
        public static final GroupState CAN_JOIN_DIRECTLY = null;
        public static final GroupState EXTERNAL_USERS_CANNOT_OPERATE = null;
        public static final GroupState GROUP_DISBANDED = null;
        public static final GroupState GROUP_IS_FULL = null;
        public static final GroupState INVITER_LEFT = null;
        public static final GroupState JUST_SHOW_GROUP_INFO = null;
        public static final GroupState LINK_CERTIFIED_REFUSE = null;
        public static final GroupState NEED_APPLY = null;
        public static final GroupState NEED_CREATE_TENANT = null;
        public static final GroupState NEED_SWITCH_TENANT = null;
        public static final GroupState NO_EXTERNAL_COMMUNICATION_AUTHORITY = null;
        public static final GroupState PENDING_APPROVAL = null;
        public static final GroupState QR_CODE_CERTIFIED_REFUSE = null;
        public static final GroupState SHARE_CARD_CERTIFIED_REFUSE = null;
        public static final GroupState SHARE_EXPIRED = null;
        public static final GroupState SHARING_DISABLED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupState[] f415342a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415343b = null;

        public static EnumEntries<GroupState> getEntries() {
            return f415343b;
        }

        static {
            GroupState r100 = new GroupState("ALREADY_IN_GROUP", 0);
            ALREADY_IN_GROUP = r100;
            GroupState r101 = new GroupState("JUST_SHOW_GROUP_INFO", 1);
            JUST_SHOW_GROUP_INFO = r101;
            GroupState r102 = new GroupState("CAN_JOIN_DIRECTLY", 2);
            CAN_JOIN_DIRECTLY = r102;
            GroupState r103 = new GroupState("NEED_APPLY", 3);
            NEED_APPLY = r103;
            GroupState r104 = new GroupState("PENDING_APPROVAL", 4);
            PENDING_APPROVAL = r104;
            GroupState r105 = new GroupState("NEED_CREATE_TENANT", 5);
            NEED_CREATE_TENANT = r105;
            GroupState r110 = new GroupState("NEED_SWITCH_TENANT", 6);
            NEED_SWITCH_TENANT = r110;
            GroupState r111 = new GroupState("EXTERNAL_USERS_CANNOT_OPERATE", 7);
            EXTERNAL_USERS_CANNOT_OPERATE = r111;
            GroupState r112 = new GroupState("INVITER_LEFT", 8);
            INVITER_LEFT = r112;
            GroupState r113 = new GroupState("GROUP_DISBANDED", 9);
            GROUP_DISBANDED = r113;
            GroupState r114 = new GroupState("SHARING_DISABLED", 10);
            SHARING_DISABLED = r114;
            GroupState r115 = new GroupState("SHARE_EXPIRED", 11);
            SHARE_EXPIRED = r115;
            GroupState r106 = new GroupState("NO_EXTERNAL_COMMUNICATION_AUTHORITY", 12);
            NO_EXTERNAL_COMMUNICATION_AUTHORITY = r106;
            GroupState r107 = new GroupState("GROUP_IS_FULL", 13);
            GROUP_IS_FULL = r107;
            GroupState r108 = new GroupState("LINK_CERTIFIED_REFUSE", 14);
            LINK_CERTIFIED_REFUSE = r108;
            GroupState r109 = new GroupState("QR_CODE_CERTIFIED_REFUSE", 15);
            QR_CODE_CERTIFIED_REFUSE = r109;
            GroupState r116 = new GroupState("SHARE_CARD_CERTIFIED_REFUSE", 16);
            SHARE_CARD_CERTIFIED_REFUSE = r116;
            GroupState[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
            f415342a = r117;
            f415343b = EnumEntriesKt.enumEntries(r117);
        }

        public static GroupState[] values() {
            return (GroupState[]) f415342a.clone();
        }

        public static GroupState valueOf(String r100) {
            return (GroupState) r27.a.a(GroupState.class, r100);
        }

        public GroupState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ShareGroupChatContent() {
    }

    public final Chat getChat() {
        return this.chat;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final GroupState getJoinChatErrState() {
        return this.joinChatErrState;
    }

    public final String getJoinToken() {
        return this.joinToken;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r100) {
        if ((r100 instanceof ShareGroupChatContent) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        Chat r101 = this.chat;
        if (r101 == null) goto L22;
        ShareGroupChatContent r102 = (ShareGroupChatContent) r100;
        if (r102.chat == null) goto L25;
        Intrinsics.checkNotNull(r101);
        String r103 = r101.getId();
        Chat r104 = r102.chat;
        Intrinsics.checkNotNull(r104);
        if (Intrinsics.areEqual(r103, r104.getId()) == true) goto L17;
        return false;
    L17:
        if (this.expireTime == r102.expireTime) goto L19;
        return false;
    L19:
        if (this.joinChatErrState != r102.joinChatErrState) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    L22:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r100) {
        if ((r100 instanceof ShareGroupChatContent) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        Chat r101 = this.chat;
        if (r101 == null) goto L26;
        ShareGroupChatContent r102 = (ShareGroupChatContent) r100;
        if (r102.chat == null) goto L29;
        String r103 = null;
        if (r101 == null) goto L16;
        String r104 = r101.getId();
    L17:
        Chat r105 = r102.chat;
        if (r105 == null) goto L21;
        r103 = r105.getId();
    L21:
        if (Intrinsics.areEqual(r104, r103) == true) goto L23;
        return false;
    L23:
        if (this.joinChatErrState != r102.joinChatErrState) goto L28;
        return true;
    L28:
        return false;
    L16:
        r104 = null;
        goto L17
    L29:
        return false;
    L26:
        return false;
    }

    public final void setChat(Chat r100) {
        this.chat = r100;
    }

    public final void setExpireTime(long r100) {
        this.expireTime = r100;
    }

    public final void setJoinChatErrState(GroupState r100) {
        this.joinChatErrState = r100;
    }

    public final void setJoinToken(String r100) {
        this.joinToken = r100;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Content) r100);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content, y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Content) r100);
    }
}
