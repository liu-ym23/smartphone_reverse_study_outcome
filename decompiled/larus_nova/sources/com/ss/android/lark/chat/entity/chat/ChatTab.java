package com.ss.android.lark.chat.entity.chat;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 22\u00020\u0001:\u000223B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003JI\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTab;", "Ljava/io/Serializable;", "id", "", "name", "", "type", "Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;", WsConstants.KEY_PAYLOAD, "Lokio/ByteString;", "payloadString", "serverId", "<init>", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;Lokio/ByteString;Ljava/lang/String;J)V", "getId", "()J", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getType", "()Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;", "setType", "(Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;)V", "getPayload", "()Lokio/ByteString;", "getPayloadString", "setPayloadString", "getServerId", "extra", "Lcom/ss/android/lark/chat/entity/chat/ChatTabExtra;", "getExtra", "()Lcom/ss/android/lark/chat/entity/chat/ChatTabExtra;", "setExtra", "(Lcom/ss/android/lark/chat/entity/chat/ChatTabExtra;)V", "isSingleton", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "ChatTabType", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTab implements Serializable {
    public static final a Companion = null;
    public static final long MESSAGE_LIST_ID = 100001;
    public static final long SPACE_LIST_ID = 100002;
    private ChatTabExtra extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f415156id;
    private String name;
    private final ByteString payload;
    private String payloadString;
    private final long serverId;
    private ChatTabType type;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTab$ChatTabType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MESSAGE", "DOC_SPACE", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "PIN", "MEETING_MINUTE", "CHAT_ANNOUNCEMENT", "URL", "FILE", "TASK", "DOC_FILE_URL_MERGE", "IMAGE_VIDEO_MERGE", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatTabType extends Enum<ChatTabType> {
        public static final ChatTabType CHAT_ANNOUNCEMENT = null;
        public static final a Companion = null;
        public static final ChatTabType DOC = null;
        public static final ChatTabType DOC_FILE_URL_MERGE = null;
        public static final ChatTabType DOC_SPACE = null;
        public static final ChatTabType FILE = null;
        public static final ChatTabType IMAGE_VIDEO_MERGE = null;
        public static final ChatTabType MEETING_MINUTE = null;
        public static final ChatTabType MESSAGE = null;
        public static final ChatTabType PIN = null;
        public static final ChatTabType TASK = null;
        public static final ChatTabType UNKNOWN = null;
        public static final ChatTabType URL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatTabType[] f415157a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415158b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ChatTabType> getEntries() {
            return f415158b;
        }

        static {
            ChatTabType r100 = new ChatTabType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatTabType r101 = new ChatTabType("MESSAGE", 1, 1);
            MESSAGE = r101;
            ChatTabType r102 = new ChatTabType("DOC_SPACE", 2, 2);
            DOC_SPACE = r102;
            ChatTabType r103 = new ChatTabType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3, 3);
            DOC = r103;
            ChatTabType r104 = new ChatTabType("PIN", 4, 4);
            PIN = r104;
            ChatTabType r105 = new ChatTabType("MEETING_MINUTE", 5, 5);
            MEETING_MINUTE = r105;
            ChatTabType r110 = new ChatTabType("CHAT_ANNOUNCEMENT", 6, 6);
            CHAT_ANNOUNCEMENT = r110;
            ChatTabType r111 = new ChatTabType("URL", 7, 7);
            URL = r111;
            ChatTabType r112 = new ChatTabType("FILE", 8, 8);
            FILE = r112;
            ChatTabType r113 = new ChatTabType("TASK", 9, 9);
            TASK = r113;
            ChatTabType r114 = new ChatTabType("DOC_FILE_URL_MERGE", 10, 10);
            DOC_FILE_URL_MERGE = r114;
            ChatTabType r115 = new ChatTabType("IMAGE_VIDEO_MERGE", 11, 11);
            IMAGE_VIDEO_MERGE = r115;
            ChatTabType[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
            f415157a = r106;
            f415158b = EnumEntriesKt.enumEntries(r106);
            Companion = new a();
        }

        public static ChatTabType[] values() {
            return (ChatTabType[]) f415157a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatTabType valueOf(String r100) {
            return (ChatTabType) r27.a.a(ChatTabType.class, r100);
        }

        public ChatTabType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(ChatTab r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (r100.getType() != ChatTabType.DOC) goto L5;
        L10:
            return true;
        L5:
            if (r100.getType() == ChatTabType.URL) goto L10;
            if (r100.getType() == ChatTabType.TASK) goto L10;
            return false;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ChatTab copy$default(ChatTab r100, long r110, String r111, ChatTabType r112, ByteString r113, String r114, long r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        long r101 = r100.f415156id;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r102 = r100.name;
    L11:
        if ((r116 & 4) == 0) goto L13;
        ChatTabType r103 = r100.type;
    L15:
        if ((r116 & 8) == 0) goto L17;
        ByteString r104 = r100.payload;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = r100.payloadString;
    L23:
        if ((r116 & 32) == 0) goto L25;
        long r106 = r100.serverId;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
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

    @JvmStatic
    public static final boolean isChatTabCustom(ChatTab r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public final long component1() {
        return this.f415156id;
    }

    public final String component2() {
        return this.name;
    }

    public final ChatTabType component3() {
        return this.type;
    }

    public final ByteString component4() {
        return this.payload;
    }

    public final String component5() {
        return this.payloadString;
    }

    public final long component6() {
        return this.serverId;
    }

    public final ChatTab copy(long r110, String r111, ChatTabType r112, ByteString r113, String r114, long r115) {
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "type");
        return new ChatTab(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatTab) == true) goto L8;
        return false;
    L8:
        ChatTab r101 = (ChatTab) r100;
        if (this.f415156id == r101.f415156id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (this.type == r101.type) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.payloadString, r101.payloadString) == true) goto L24;
        return false;
    L24:
        if (this.serverId == r101.serverId) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        long r100 = this.f415156id;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31;
        ByteString r102 = this.payload;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.payloadString;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        int r107 = (r105 + r103) * 31;
        long r108 = this.serverId;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatTab(id=" + this.f415156id + ", name=" + this.name + ", type=" + this.type + ", payload=" + this.payload + ", payloadString=" + this.payloadString + ", serverId=" + this.serverId + ')';
    }

    public final boolean isSingleton() {
        ChatTabType r100 = this.type;
        if (r100 != ChatTabType.DOC_SPACE) goto L5;
    L20:
        return true;
    L5:
        if (r100 == ChatTabType.MESSAGE) goto L20;
        if (r100 == ChatTabType.PIN) goto L20;
        if (r100 == ChatTabType.MEETING_MINUTE) goto L20;
        if (r100 == ChatTabType.CHAT_ANNOUNCEMENT) goto L20;
        if (r100 == ChatTabType.FILE) goto L20;
        if (r100 == ChatTabType.DOC_FILE_URL_MERGE) goto L20;
        if (r100 == ChatTabType.IMAGE_VIDEO_MERGE) goto L20;
        return false;
    }

    public final ChatTabExtra getExtra() {
        return this.extra;
    }

    public final long getId() {
        return this.f415156id;
    }

    public final String getName() {
        return this.name;
    }

    public final ByteString getPayload() {
        return this.payload;
    }

    public final String getPayloadString() {
        return this.payloadString;
    }

    public final long getServerId() {
        return this.serverId;
    }

    public final ChatTabType getType() {
        return this.type;
    }

    @JvmStatic
    public static final boolean containsBizTabs(List<ChatTab> r100) {
        Companion.getClass();
        if (r100 == null) goto L15;
        List<ChatTab> r101 = r100;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        if ((!((ChatTab) r102.next()).isSingleton()) == false) goto L11;
        return true;
    L7:
        if (r101.isEmpty() == false) goto L9;
    L15:
        return false;
    }

    public final void setExtra(ChatTabExtra r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setPayloadString(String r100) {
        this.payloadString = r100;
    }

    public final void setType(ChatTabType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    @JvmStatic
    public static final ChatTab preChatTab(String r110, ChatTabType r111, ByteString r112, String r113) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r113, "payloadJson");
        return new ChatTab(-1, r110, r111, r112, r113, -1);
    }

    public ChatTab(long r100, String r101, ChatTabType r102, ByteString r103, String r104, long r105) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f415156id = r100;
        this.name = r101;
        this.type = r102;
        this.payload = r103;
        this.payloadString = r104;
        this.serverId = r105;
        this.extra = new ChatTabExtra(0, 0);
    }
}
