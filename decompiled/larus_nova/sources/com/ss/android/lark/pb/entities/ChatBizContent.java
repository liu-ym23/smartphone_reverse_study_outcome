package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatBizContent extends com.squareup.wire.Message<ChatBizContent, Builder> {
    public static final ProtoAdapter<ChatBizContent> ADAPTER = null;
    public static final Long DEFAULT_TEAM_ID = null;
    private static final long serialVersionUID = 0;
    public final TeamChatType mteam_chat_type;
    public final Long mteam_id;
    public final Map<Long, TeamInfo> mteam_infos;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatBizContent, Builder> {
        public TeamChatType mteam_chat_type;
        public Long mteam_id;
        public Map<Long, TeamInfo> mteam_infos;

        @Override // com.squareup.wire.Message.Builder
        public ChatBizContent build() {
            return new ChatBizContent(this.mteam_id, this.mteam_chat_type, this.mteam_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.mteam_infos = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder team_chat_type(TeamChatType r100) {
            this.mteam_chat_type = r100;
            return this;
        }

        public Builder team_id(Long r100) {
            this.mteam_id = r100;
            return this;
        }

        public Builder team_infos(Map<Long, TeamInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mteam_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatBizContent extends ProtoAdapter<ChatBizContent> {
        private final ProtoAdapter<Map<Long, TeamInfo>> mteam_infos;

        public ProtoAdapter_ChatBizContent() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatBizContent.class);
            this.mteam_infos = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, TeamInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatBizContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mteam_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mteam_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mteam_chat_type = TeamChatType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mteam_infos.putAll(this.mteam_infos.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatBizContent r100) {
            Long r101 = r100.mteam_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            TeamChatType r104 = r100.mteam_chat_type;
            if (r104 == null) goto L10;
            r102 = TeamChatType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + this.mteam_infos.encodedSizeWithTag(3, r100.mteam_infos)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatBizContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatBizContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatBizContent r101) throws IOException {
            Long r102 = r101.mteam_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            TeamChatType r103 = r101.mteam_chat_type;
            if (r103 == null) goto L8;
            TeamChatType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            this.mteam_infos.encodeWithTag(r100, 3, r101.mteam_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatBizContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TeamInfo extends com.squareup.wire.Message<TeamInfo, Builder> {
        public static final ProtoAdapter<TeamInfo> ADAPTER = null;
        public static final Long DEFAULT_BIND_TIME = null;
        public static final Boolean DEFAULT_DISCOVERABLE = null;
        public static final Long DEFAULT_TEAM_ID = null;
        private static final long serialVersionUID = 0;
        public final Long mbind_time;
        public final Boolean mdiscoverable;
        public final TeamChatType mteam_chat_type;
        public final Long mteam_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<TeamInfo, Builder> {
            public Long mbind_time;
            public Boolean mdiscoverable;
            public TeamChatType mteam_chat_type;
            public Long mteam_id;

            @Override // com.squareup.wire.Message.Builder
            public TeamInfo build() {
                return new TeamInfo(this.mteam_id, this.mteam_chat_type, this.mbind_time, this.mdiscoverable, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder bind_time(Long r100) {
                this.mbind_time = r100;
                return this;
            }

            public Builder discoverable(Boolean r100) {
                this.mdiscoverable = r100;
                return this;
            }

            public Builder team_chat_type(TeamChatType r100) {
                this.mteam_chat_type = r100;
                return this;
            }

            public Builder team_id(Long r100) {
                this.mteam_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TeamInfo extends ProtoAdapter<TeamInfo> {
            public ProtoAdapter_TeamInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TeamInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TeamInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mteam_id = 0L;
                r101.mbind_time = 0L;
                r101.mdiscoverable = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.mteam_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mteam_chat_type = TeamChatType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mbind_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mdiscoverable = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TeamInfo r100) {
                Long r101 = r100.mteam_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                TeamChatType r104 = r100.mteam_chat_type;
                if (r104 == null) goto L9;
                int r105 = TeamChatType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.mbind_time;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                Boolean r110 = r100.mdiscoverable;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ TeamInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TeamInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TeamInfo r101) throws IOException {
                Long r102 = r101.mteam_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                TeamChatType r103 = r101.mteam_chat_type;
                if (r103 == null) goto L8;
                TeamChatType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.mbind_time;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                Boolean r105 = r101.mdiscoverable;
                if (r105 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TeamInfo();
            DEFAULT_TEAM_ID = 0L;
            DEFAULT_BIND_TIME = 0L;
            DEFAULT_DISCOVERABLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mteam_id = this.mteam_id;
            r100.mteam_chat_type = this.mteam_chat_type;
            r100.mbind_time = this.mbind_time;
            r100.mdiscoverable = this.mdiscoverable;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TeamInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TeamInfo(Long r100, TeamChatType r101, Long r102, Boolean r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public TeamInfo(Long r100, TeamChatType r101, Long r102, Boolean r103, ByteString r104) {
            super(ADAPTER, r104);
            this.mteam_id = r100;
            this.mteam_chat_type = r101;
            this.mbind_time = r102;
            this.mdiscoverable = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatBizContent();
        DEFAULT_TEAM_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mteam_id = this.mteam_id;
        r100.mteam_chat_type = this.mteam_chat_type;
        r100.mteam_infos = Internal.copyOf("mteam_infos", this.mteam_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatBizContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatBizContent(Long r100, TeamChatType r101, Map<Long, TeamInfo> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ChatBizContent(Long r100, TeamChatType r101, Map<Long, TeamInfo> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mteam_id = r100;
        this.mteam_chat_type = r101;
        this.mteam_infos = Internal.immutableCopyOf("mteam_infos", r102);
    }
}
