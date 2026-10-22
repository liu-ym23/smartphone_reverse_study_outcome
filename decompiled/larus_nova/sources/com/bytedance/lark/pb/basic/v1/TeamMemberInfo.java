package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TeamMemberInfo extends com.squareup.wire.Message<TeamMemberInfo, Builder> {
    public static final ProtoAdapter<TeamMemberInfo> ADAPTER = null;
    public static final Long DEFAULT_MEMBER_ID = null;
    public static final MetaType DEFAULT_META_TYPE = null;
    public static final Long DEFAULT_ORDERED_WEIGHT = null;
    private static final long serialVersionUID = 0;
    public final TeamMemberChatInfo chat_info;
    public final TeamMemberChatterInfo chatter_info;
    public final Long member_id;
    public final MetaType meta_type;
    public final Long ordered_weight;

    public static final class Builder extends com.squareup.wire.Message.Builder<TeamMemberInfo, Builder> {
        public TeamMemberChatInfo chat_info;
        public TeamMemberChatterInfo chatter_info;
        public Long member_id;
        public MetaType meta_type;
        public Long ordered_weight;

        @Override // com.squareup.wire.Message.Builder
        public TeamMemberInfo build() {
            return new TeamMemberInfo(this.member_id, this.meta_type, this.chat_info, this.chatter_info, this.ordered_weight, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chat_info(TeamMemberChatInfo r100) {
            this.chat_info = r100;
            return this;
        }

        public Builder chatter_info(TeamMemberChatterInfo r100) {
            this.chatter_info = r100;
            return this;
        }

        public Builder member_id(Long r100) {
            this.member_id = r100;
            return this;
        }

        public Builder meta_type(MetaType r100) {
            this.meta_type = r100;
            return this;
        }

        public Builder ordered_weight(Long r100) {
            this.ordered_weight = r100;
            return this;
        }
    }

    public static final enum MetaType extends Enum<MetaType> implements WireEnum {
        private static final /* synthetic */ MetaType[] $VALUES = null;
        public static final ProtoAdapter<MetaType> ADAPTER = null;
        public static final MetaType CHAT = null;
        public static final MetaType CHATTER = null;
        public static final MetaType UNKNOWN = null;
        private final int value;

        static {
            MetaType r100 = new MetaType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            MetaType r101 = new MetaType("CHATTER", 1, 1);
            CHATTER = r101;
            MetaType r102 = new MetaType("CHAT", 2, 2);
            CHAT = r102;
            $VALUES = new MetaType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(MetaType.class);
        }

        public static MetaType[] values() {
            return (MetaType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MetaType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CHAT;
        L12:
            return CHATTER;
        L14:
            return UNKNOWN;
        }

        public static MetaType valueOf(String r100) {
            return (MetaType) a.a(MetaType.class, r100);
        }

        private MetaType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_TeamMemberInfo extends ProtoAdapter<TeamMemberInfo> {
        public ProtoAdapter_TeamMemberInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamMemberInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamMemberInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.member_id = 0L;
            r101.meta_type = MetaType.UNKNOWN;
            r101.ordered_weight = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.member_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.meta_type = MetaType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.chat_info = TeamMemberChatInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.chatter_info = TeamMemberChatterInfo.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.ordered_weight = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(TeamMemberInfo r100) {
            Long r101 = r100.member_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            MetaType r104 = r100.meta_type;
            if (r104 == null) goto L9;
            int r105 = MetaType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TeamMemberChatInfo r107 = r100.chat_info;
            if (r107 == null) goto L13;
            int r108 = TeamMemberChatInfo.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TeamMemberChatterInfo r110 = r100.chatter_info;
            if (r110 == null) goto L17;
            int r111 = TeamMemberChatterInfo.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.ordered_weight;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ TeamMemberInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamMemberInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamMemberInfo r101) throws IOException {
            Long r102 = r101.member_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            MetaType r103 = r101.meta_type;
            if (r103 == null) goto L8;
            MetaType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TeamMemberChatInfo r104 = r101.chat_info;
            if (r104 == null) goto L11;
            TeamMemberChatInfo.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TeamMemberChatterInfo r105 = r101.chatter_info;
            if (r105 == null) goto L14;
            TeamMemberChatterInfo.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.ordered_weight;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamMemberInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamMemberInfo();
        DEFAULT_MEMBER_ID = 0L;
        DEFAULT_META_TYPE = MetaType.UNKNOWN;
        DEFAULT_ORDERED_WEIGHT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.member_id = this.member_id;
        r100.meta_type = this.meta_type;
        r100.chat_info = this.chat_info;
        r100.chatter_info = this.chatter_info;
        r100.ordered_weight = this.ordered_weight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamMemberInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamMemberInfo(Long r100, MetaType r101, TeamMemberChatInfo r110, TeamMemberChatterInfo r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TeamMemberInfo(Long r100, MetaType r101, TeamMemberChatInfo r102, TeamMemberChatterInfo r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.member_id = r100;
        this.meta_type = r101;
        this.chat_info = r102;
        this.chatter_info = r103;
        this.ordered_weight = r104;
    }
}
