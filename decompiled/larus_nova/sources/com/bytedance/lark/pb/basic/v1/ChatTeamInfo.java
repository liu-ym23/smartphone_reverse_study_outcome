package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatTeamInfo extends com.squareup.wire.Message<ChatTeamInfo, Builder> {
    public static final ProtoAdapter<ChatTeamInfo> ADAPTER = null;
    public static final Long DEFAULT_BIND_TIME = null;
    public static final Boolean DEFAULT_DISCOVERABLE = null;
    public static final Long DEFAULT_ORDER_WEIGHT = null;
    public static final TeamChatType DEFAULT_TEAM_CHAT_TYPE = null;
    public static final Long DEFAULT_TEAM_ID = null;
    private static final long serialVersionUID = 0;
    public final Long bind_time;
    public final Boolean discoverable;
    public final Long order_weight;
    public final TeamChatType team_chat_type;
    public final Long team_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatTeamInfo, Builder> {
        public Long bind_time;
        public Boolean discoverable;
        public Long order_weight;
        public TeamChatType team_chat_type;
        public Long team_id;

        @Override // com.squareup.wire.Message.Builder
        public ChatTeamInfo build() {
            return new ChatTeamInfo(this.team_id, this.team_chat_type, this.bind_time, this.order_weight, this.discoverable, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder bind_time(Long r100) {
            this.bind_time = r100;
            return this;
        }

        public Builder discoverable(Boolean r100) {
            this.discoverable = r100;
            return this;
        }

        public Builder order_weight(Long r100) {
            this.order_weight = r100;
            return this;
        }

        public Builder team_chat_type(TeamChatType r100) {
            this.team_chat_type = r100;
            return this;
        }

        public Builder team_id(Long r100) {
            this.team_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatTeamInfo extends ProtoAdapter<ChatTeamInfo> {
        public ProtoAdapter_ChatTeamInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatTeamInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatTeamInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.team_id = 0L;
            r101.team_chat_type = TeamChatType.TEAM_CHAT_TYPE_UNKNOWN;
            r101.bind_time = 0L;
            r101.order_weight = 0L;
            r101.discoverable = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.team_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.team_chat_type = TeamChatType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.bind_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.order_weight = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.discoverable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatTeamInfo r100) {
            Long r101 = r100.team_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            TeamChatType r104 = r100.team_chat_type;
            if (r104 == null) goto L9;
            int r105 = TeamChatType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.bind_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.order_weight;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.discoverable;
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
        public /* bridge */ /* synthetic */ ChatTeamInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatTeamInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatTeamInfo r101) throws IOException {
            Long r102 = r101.team_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            TeamChatType r103 = r101.team_chat_type;
            if (r103 == null) goto L8;
            TeamChatType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.bind_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.order_weight;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.discoverable;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatTeamInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatTeamInfo();
        DEFAULT_TEAM_ID = 0L;
        DEFAULT_TEAM_CHAT_TYPE = TeamChatType.TEAM_CHAT_TYPE_UNKNOWN;
        DEFAULT_BIND_TIME = 0L;
        DEFAULT_ORDER_WEIGHT = 0L;
        DEFAULT_DISCOVERABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.team_id = this.team_id;
        r100.team_chat_type = this.team_chat_type;
        r100.bind_time = this.bind_time;
        r100.order_weight = this.order_weight;
        r100.discoverable = this.discoverable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatTeamInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatTeamInfo(Long r100, TeamChatType r101, Long r110, Long r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ChatTeamInfo(Long r100, TeamChatType r101, Long r102, Long r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.team_id = r100;
        this.team_chat_type = r101;
        this.bind_time = r102;
        this.order_weight = r103;
        this.discoverable = r104;
    }
}
