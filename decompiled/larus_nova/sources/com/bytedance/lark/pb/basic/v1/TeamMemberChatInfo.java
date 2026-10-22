package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TeamMemberChatInfo extends com.squareup.wire.Message<TeamMemberChatInfo, Builder> {
    public static final ProtoAdapter<TeamMemberChatInfo> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Boolean DEFAULT_HAS_LEAVE_CHATTER = null;
    public static final Boolean DEFAULT_OPERATOR_IN_CHAT = null;
    private static final long serialVersionUID = 0;
    public final Chat chat;
    public final Long chat_id;
    public final Integer count;
    public final Boolean has_leave_chatter;
    public final Boolean operator_in_chat;

    public static final class Builder extends com.squareup.wire.Message.Builder<TeamMemberChatInfo, Builder> {
        public Chat chat;
        public Long chat_id;
        public Integer count;
        public Boolean has_leave_chatter;
        public Boolean operator_in_chat;

        @Override // com.squareup.wire.Message.Builder
        public TeamMemberChatInfo build() {
            return new TeamMemberChatInfo(this.chat_id, this.count, this.chat, this.has_leave_chatter, this.operator_in_chat, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chat(Chat r100) {
            this.chat = r100;
            return this;
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder has_leave_chatter(Boolean r100) {
            this.has_leave_chatter = r100;
            return this;
        }

        public Builder operator_in_chat(Boolean r100) {
            this.operator_in_chat = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TeamMemberChatInfo extends ProtoAdapter<TeamMemberChatInfo> {
        public ProtoAdapter_TeamMemberChatInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamMemberChatInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamMemberChatInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            r101.count = 0;
            Boolean r102 = Boolean.FALSE;
            r101.has_leave_chatter = r102;
            r101.operator_in_chat = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.chat = Chat.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.has_leave_chatter = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.operator_in_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TeamMemberChatInfo r100) {
            Long r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.count;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Chat r107 = r100.chat;
            if (r107 == null) goto L13;
            int r108 = Chat.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.has_leave_chatter;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.operator_in_chat;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TeamMemberChatInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamMemberChatInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamMemberChatInfo r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Chat r104 = r101.chat;
            if (r104 == null) goto L11;
            Chat.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.has_leave_chatter;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.operator_in_chat;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamMemberChatInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamMemberChatInfo();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_HAS_LEAVE_CHATTER = r100;
        DEFAULT_OPERATOR_IN_CHAT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.count = this.count;
        r100.chat = this.chat;
        r100.has_leave_chatter = this.has_leave_chatter;
        r100.operator_in_chat = this.operator_in_chat;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamMemberChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamMemberChatInfo(Long r100, Integer r101, Chat r110, Boolean r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TeamMemberChatInfo(Long r100, Integer r101, Chat r102, Boolean r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.chat_id = r100;
        this.count = r101;
        this.chat = r102;
        this.has_leave_chatter = r103;
        this.operator_in_chat = r104;
    }
}
