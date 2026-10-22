package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b6\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bï\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u00107\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020\u000bJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0017\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0015HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0015HÆ\u0003Jñ\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u0015HÆ\u0001J\u0006\u0010M\u001a\u00020\u0006J\u0013\u0010N\u001a\u00020\u000b2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0006HÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\u0016\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010'R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 R\u0016\u0010\u001c\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00100¨\u0006X"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "Landroid/os/Parcelable;", "conversationId", "", "senderId", "userType", "", "messageStatusLocal", "messageStatus", "contentType", "isNewBlockType", "", "content", "contentBlock", "", "Lcom/obric/aiagent/assistant/idl/bean/Block;", "ext", "", "localMessageId", "messageId", "localIndex", "", "serverIndex", "sectionId", "businessExt", "", "replyId", "bizContentType", "createTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIZLjava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;J)V", "getConversationId", "()Ljava/lang/String;", "getSenderId", "getUserType", "()I", "getMessageStatusLocal", "getMessageStatus", "getContentType", "()Z", "getContent", "getContentBlock", "()Ljava/util/List;", "getExt", "()Ljava/util/Map;", "getLocalMessageId", "getMessageId", "getLocalIndex", "()J", "getServerIndex", "getSectionId", "getBusinessExt", "getReplyId", "getBizContentType", "getCreateTime", "isBlockType", "isOldBlockType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMMessage implements Parcelable {
    public static final Parcelable.Creator<IMMessage> CREATOR = null;

    @SerializedName("biz_content_type")
    private final String bizContentType;

    @SerializedName("business_ext")
    private final Map<String, String> businessExt;

    @SerializedName("content")
    private final String content;

    @SerializedName("content_block")
    private final List<Block> contentBlock;

    @SerializedName("content_type")
    private final int contentType;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("ext")
    private final Map<String, String> ext;

    @SerializedName("is_new_block_type")
    private final boolean isNewBlockType;

    @SerializedName("local_index")
    private final long localIndex;

    @SerializedName("local_message_id")
    private final String localMessageId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("message_status")
    private final int messageStatus;

    @SerializedName("message_status_local")
    private final int messageStatusLocal;

    @SerializedName(NoticeInfo.KEY_REPLY_ID)
    private final String replyId;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("sender_id")
    private final String senderId;

    @SerializedName("server_index")
    private final long serverIndex;

    @SerializedName("user_type")
    private final int userType;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<IMMessage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final IMMessage createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            String r100 = r210.readString();
            String r101 = r210.readString();
            int r102 = r210.readInt();
            int r103 = r210.readInt();
            int r104 = r210.readInt();
            int r105 = r210.readInt();
            int r106 = 0;
            if (r210.readInt() == 0) goto L5;
            boolean r107 = true;
        L6:
            String r110 = r210.readString();
            LinkedHashMap r111 = null;
            if (r210.readInt() != 0) goto L9;
            ArrayList r112 = null;
        L13:
            if (r210.readInt() != 0) goto L15;
        L14:
            LinkedHashMap r108 = r111;
            String r113 = r210.readString();
            String r114 = r210.readString();
            long r115 = r210.readLong();
            long r116 = r210.readLong();
            String r117 = r210.readString();
            int r118 = r210.readInt();
            LinkedHashMap r109 = new LinkedHashMap(r118);
        L19:
            if (r106 == r118) goto L22;
            r109.put(r210.readString(), r210.readString());
            r106 = r106 + 1;
            r118 = r118;
            r115 = r115;
            goto L19
        L22:
            return new IMMessage(r100, r101, r102, r103, r104, r105, r107, r110, r112, r108, r113, r114, r115, r116, r117, r109, r210.readString(), r210.readString(), r210.readLong());
        L15:
            int r119 = r210.readInt();
            r111 = new LinkedHashMap(r119);
            int r120 = 0;
        L16:
            if (r120 == r119) goto L14;
            r111.put(r210.readString(), r210.readString());
            r120 = r120 + 1;
            goto L16
        L9:
            int r121 = r210.readInt();
            r112 = new ArrayList(r121);
            int r122 = 0;
        L10:
            if (r122 == r121) goto L13;
            r112.add(r210.readSerializable());
            r122 = r122 + 1;
            goto L10
        L5:
            r107 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final IMMessage[] newArray(int r100) {
            return new IMMessage[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public IMMessage() {
        this(null, null, 0, 0, 0, 0, false, null, null, null, null, null, 0, 0, null, null, null, null, 0, 524287, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMMessage copy$default(IMMessage r110, String r111, String r112, int r210, int r211, int r212, int r213, boolean r214, String r215, List r216, Map r217, String r218, String r219, long r310, long r311, String r312, Map r313, String r314, String r315, long r316, int r410, Object r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = r110.conversationId;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = r110.senderId;
    L11:
        if ((r410 & 4) == 0) goto L13;
        int r102 = r110.userType;
    L15:
        if ((r410 & 8) == 0) goto L17;
        int r103 = r110.messageStatusLocal;
    L19:
        if ((r410 & 16) == 0) goto L21;
        int r104 = r110.messageStatus;
    L23:
        if ((r410 & 32) == 0) goto L25;
        int r105 = r110.contentType;
    L27:
        if ((r410 & 64) == 0) goto L29;
        boolean r106 = r110.isNewBlockType;
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r107 = r110.content;
    L35:
        if ((r410 & 256) == 0) goto L37;
        List r113 = r110.contentBlock;
    L39:
        if ((r410 & 512) == 0) goto L41;
        Map r114 = r110.ext;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        String r115 = r110.localMessageId;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r116 = r110.messageId;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        long r117 = r110.localIndex;
    L54:
        long r317 = r117;
        if ((r410 & 8192) == 0) goto L57;
        long r118 = r110.serverIndex;
    L58:
        long r318 = r118;
        if ((r410 & 16384) == 0) goto L61;
        String r119 = r110.sectionId;
    L63:
        if ((32768 & r410) == 0) goto L65;
        Map r120 = r110.businessExt;
    L66:
        Map r319 = r120;
        if ((r410 & 65536) == 0) goto L69;
        String r121 = r110.replyId;
    L70:
        String r320 = r121;
        if ((r410 & 131072) == 0) goto L73;
        String r122 = r110.bizContentType;
    L74:
        String r321 = r119;
        String r322 = r122;
        if ((r410 & 262144) == 0) goto L77;
        long r123 = r110.createTime;
    L79:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r317, r318, r321, r319, r320, r322, r123);
    L77:
        r123 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L54
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
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

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final String component11() {
        return this.localMessageId;
    }

    public final String component12() {
        return this.messageId;
    }

    public final long component13() {
        return this.localIndex;
    }

    public final long component14() {
        return this.serverIndex;
    }

    public final String component15() {
        return this.sectionId;
    }

    public final Map<String, String> component16() {
        return this.businessExt;
    }

    public final String component17() {
        return this.replyId;
    }

    public final String component18() {
        return this.bizContentType;
    }

    public final long component19() {
        return this.createTime;
    }

    public final String component2() {
        return this.senderId;
    }

    public final int component3() {
        return this.userType;
    }

    public final int component4() {
        return this.messageStatusLocal;
    }

    public final int component5() {
        return this.messageStatus;
    }

    public final int component6() {
        return this.contentType;
    }

    public final boolean component7() {
        return this.isNewBlockType;
    }

    public final String component8() {
        return this.content;
    }

    public final List<Block> component9() {
        return this.contentBlock;
    }

    public final IMMessage copy(String r210, String r211, int r212, int r213, int r310, int r311, boolean r312, String r313, List<Block> r314, Map<String, String> r315, String r316, String r317, long r318, long r410, String r411, Map<String, String> r412, String r413, String r414, long r415) {
        Intrinsics.checkNotNullParameter(r210, "conversationId");
        Intrinsics.checkNotNullParameter(r211, "senderId");
        Intrinsics.checkNotNullParameter(r316, "localMessageId");
        Intrinsics.checkNotNullParameter(r317, "messageId");
        Intrinsics.checkNotNullParameter(r412, "businessExt");
        return new IMMessage(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IMMessage) == true) goto L8;
        return false;
    L8:
        IMMessage r101 = (IMMessage) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.senderId, r101.senderId) == true) goto L15;
        return false;
    L15:
        if (this.userType == r101.userType) goto L18;
        return false;
    L18:
        if (this.messageStatusLocal == r101.messageStatusLocal) goto L21;
        return false;
    L21:
        if (this.messageStatus == r101.messageStatus) goto L24;
        return false;
    L24:
        if (this.contentType == r101.contentType) goto L27;
        return false;
    L27:
        if (this.isNewBlockType == r101.isNewBlockType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.contentBlock, r101.contentBlock) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L45;
        return false;
    L45:
        if (this.localIndex == r101.localIndex) goto L48;
        return false;
    L48:
        if (this.serverIndex == r101.serverIndex) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.businessExt, r101.businessExt) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.replyId, r101.replyId) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.bizContentType, r101.bizContentType) == true) goto L63;
        return false;
    L63:
        if (this.createTime == r101.createTime) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.conversationId.hashCode() * 31) + this.senderId.hashCode()) * 31) + this.userType) * 31) + this.messageStatusLocal) * 31) + this.messageStatus) * 31) + this.contentType) * 31;
        if (this.isNewBlockType == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.content;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        List<Block> r107 = this.contentBlock;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.ext;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((((r109 + r111) * 31) + this.localMessageId.hashCode()) * 31) + this.messageId.hashCode()) * 31;
        long r113 = this.localIndex;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.serverIndex;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        String r117 = this.sectionId;
        if (r117 != null) goto L21;
        int r118 = 0;
    L22:
        int r119 = (((r116 + r118) * 31) + this.businessExt.hashCode()) * 31;
        String r120 = this.replyId;
        if (r120 != null) goto L25;
        int r121 = 0;
    L26:
        int r122 = (r119 + r121) * 31;
        String r123 = this.bizContentType;
        if (r123 == null) goto L30;
        r104 = r123.hashCode();
    L30:
        int r124 = (r122 + r104) * 31;
        long r125 = this.createTime;
        return r124 + ((int) (r125 ^ (r125 >>> 32)));
    L25:
        r121 = r120.hashCode();
        goto L26
    L21:
        r118 = r117.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "IMMessage(conversationId=" + this.conversationId + ", senderId=" + this.senderId + ", userType=" + this.userType + ", messageStatusLocal=" + this.messageStatusLocal + ", messageStatus=" + this.messageStatus + ", contentType=" + this.contentType + ", isNewBlockType=" + this.isNewBlockType + ", content=" + this.content + ", contentBlock=" + this.contentBlock + ", ext=" + this.ext + ", localMessageId=" + this.localMessageId + ", messageId=" + this.messageId + ", localIndex=" + this.localIndex + ", serverIndex=" + this.serverIndex + ", sectionId=" + this.sectionId + ", businessExt=" + this.businessExt + ", replyId=" + this.replyId + ", bizContentType=" + this.bizContentType + ", createTime=" + this.createTime + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.conversationId);
        r100.writeString(this.senderId);
        r100.writeInt(this.userType);
        r100.writeInt(this.messageStatusLocal);
        r100.writeInt(this.messageStatus);
        r100.writeInt(this.contentType);
        r100.writeInt(this.isNewBlockType ? 1 : 0);
        r100.writeString(this.content);
        List<Block> r102 = this.contentBlock;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        Map<String, String> r103 = this.ext;
        if (r103 != null) goto L12;
        r100.writeInt(0);
    L16:
        r100.writeString(this.localMessageId);
        r100.writeString(this.messageId);
        r100.writeLong(this.localIndex);
        r100.writeLong(this.serverIndex);
        r100.writeString(this.sectionId);
        Map<String, String> r104 = this.businessExt;
        r100.writeInt(r104.size());
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        Map.Entry<String, String> r106 = r105.next();
        r100.writeString(r106.getKey());
        r100.writeString(r106.getValue());
        goto L18
    L20:
        r100.writeString(this.replyId);
        r100.writeString(this.bizContentType);
        r100.writeLong(this.createTime);
        return;
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<Map.Entry<String, String>> r107 = r103.entrySet().iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        Map.Entry<String, String> r108 = r107.next();
        r100.writeString(r108.getKey());
        r100.writeString(r108.getValue());
        goto L14
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Block> r109 = r102.iterator();
    L7:
        if (r109.hasNext() == false) goto L9;
        r100.writeSerializable(r109.next());
        goto L7
    }

    public final boolean isOldBlockType() {
        if (this.contentType == 9999) goto L5;
    L7:
        return false;
    L5:
        if (this.isNewBlockType == true) goto L7;
        return true;
    }

    public final boolean isBlockType() {
        if (isOldBlockType() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isNewBlockType == true) goto L8;
        return false;
    }

    public final String getBizContentType() {
        return this.bizContentType;
    }

    public final Map<String, String> getBusinessExt() {
        return this.businessExt;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Block> getContentBlock() {
        return this.contentBlock;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final long getLocalIndex() {
        return this.localIndex;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getMessageStatus() {
        return this.messageStatus;
    }

    public final int getMessageStatusLocal() {
        return this.messageStatusLocal;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final long getServerIndex() {
        return this.serverIndex;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final boolean isNewBlockType() {
        return this.isNewBlockType;
    }

    public IMMessage(String r100, String r101, int r110, int r111, int r112, int r113, boolean r114, String r115, List<Block> r116, Map<String, String> r117, String r118, String r119, long r210, long r211, String r212, Map<String, String> r213, String r214, String r215, long r216) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "senderId");
        Intrinsics.checkNotNullParameter(r118, "localMessageId");
        Intrinsics.checkNotNullParameter(r119, "messageId");
        Intrinsics.checkNotNullParameter(r213, "businessExt");
        this.conversationId = r100;
        this.senderId = r101;
        this.userType = r110;
        this.messageStatusLocal = r111;
        this.messageStatus = r112;
        this.contentType = r113;
        this.isNewBlockType = r114;
        this.content = r115;
        this.contentBlock = r116;
        this.ext = r117;
        this.localMessageId = r118;
        this.messageId = r119;
        this.localIndex = r210;
        this.serverIndex = r211;
        this.sectionId = r212;
        this.businessExt = r213;
        this.replyId = r214;
        this.bizContentType = r215;
        this.createTime = r216;
    }

    public /* synthetic */ IMMessage(String r210, String r211, int r212, int r213, int r214, int r215, boolean r310, String r311, List r312, Map r313, String r314, String r315, long r316, long r317, String r410, Map r411, String r412, String r413, long r414, int r415, DefaultConstructorMarker r416) {
        String r100 = "";
        if ((r415 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r415 & 2) == 0) goto L9;
        String r102 = "";
    L10:
        int r103 = -1;
        if ((r415 & 4) == 0) goto L13;
        int r104 = -1;
    L15:
        if ((r415 & 8) == 0) goto L17;
        int r105 = -1;
    L19:
        if ((r415 & 16) == 0) goto L21;
        int r106 = -1;
    L23:
        if ((r415 & 32) != 0) goto L27;
        r103 = r215;
    L27:
        if ((r415 & 64) == 0) goto L29;
        boolean r107 = false;
    L30:
        String r110 = null;
        if ((r415 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r415 & 256) == 0) goto L37;
        List r111 = null;
    L39:
        if ((r415 & 512) == 0) goto L41;
        Map r112 = null;
    L43:
        if ((r415 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r415 & 2048) != 0) goto L50;
        r100 = r315;
    L50:
        long r114 = -1;
        if ((r415 & 4096) == 0) goto L53;
        long r115 = -1;
    L55:
        if ((r415 & 8192) != 0) goto L59;
        r114 = r317;
    L59:
        if ((r415 & 16384) == 0) goto L61;
        String r116 = null;
    L63:
        if ((r415 & 32768) == 0) goto L65;
        Map r117 = new LinkedHashMap();
    L67:
        if ((r415 & 65536) == 0) goto L69;
        String r216 = null;
    L71:
        if ((r415 & 131072) != 0) goto L75;
        r110 = r413;
    L75:
        if ((r415 & 262144) == 0) goto L77;
        long r217 = 0;
    L78:
        this(r101, r102, r104, r105, r106, r103, r107, r108, r111, r112, r113, r100, r115, r114, r116, r117, r216, r110, r217);
        return;
    L77:
        r217 = r414;
        goto L78
    L69:
        r216 = r412;
        goto L71
    L65:
        r117 = r411;
        goto L67
    L61:
        r116 = r410;
        goto L63
    L53:
        r115 = r316;
        goto L55
    L45:
        r113 = r314;
        goto L47
    L41:
        r112 = r313;
        goto L43
    L37:
        r111 = r312;
        goto L39
    L33:
        r108 = r311;
        goto L35
    L29:
        r107 = r310;
        goto L30
    L21:
        r106 = r214;
        goto L23
    L17:
        r105 = r213;
        goto L19
    L13:
        r104 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L10
    L5:
        r101 = r210;
        goto L7
    }
}
