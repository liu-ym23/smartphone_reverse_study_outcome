package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class VoteContent extends Message<VoteContent, Builder> {
    public static final ProtoAdapter<VoteContent> ADAPTER = null;
    public static final VoteContainerType DEFAULT_CONTAINER_TYPE = null;
    public static final Long DEFAULT_INITIATOR = null;
    public static final Boolean DEFAULT_IS_PUBLIC = null;
    public static final Long DEFAULT_MAX_PICK_NUM = null;
    public static final Long DEFAULT_MIN_PICK_NUM = null;
    public static final String DEFAULT_SCOPE_ID = "";
    public static final VoteScopeType DEFAULT_SCOPE_TYPE = null;
    public static final VoteStatus DEFAULT_STATUS = null;
    public static final String DEFAULT_TOPIC = "";
    public static final Long DEFAULT_UUID = null;
    public static final VoteMessageType DEFAULT_VOTE_MESSAGE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final VoteContainerType container_type;
    public final Long initiator;
    public final Boolean is_public;
    public final Long max_pick_num;
    public final Long min_pick_num;
    public final List<VoteOption> options;
    public final String scope_id;
    public final VoteScopeType scope_type;
    public final VoteStatus status;
    public final String topic;
    public final Long uuid;
    public final VoteMessageType vote_message_type;

    public static final class Builder extends Message.Builder<VoteContent, Builder> {
        public VoteContainerType container_type;
        public Long initiator;
        public Boolean is_public;
        public Long max_pick_num;
        public Long min_pick_num;
        public List<VoteOption> options;
        public String scope_id;
        public VoteScopeType scope_type;
        public VoteStatus status;
        public String topic;
        public Long uuid;
        public VoteMessageType vote_message_type;

        @Override // com.squareup.wire.Message.Builder
        public VoteContent build() {
            return new VoteContent(this.uuid, this.scope_id, this.scope_type, this.container_type, this.topic, this.min_pick_num, this.max_pick_num, this.is_public, this.options, this.status, this.initiator, this.vote_message_type, super.buildUnknownFields());
        }

        public Builder() {
            this.options = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_type(VoteContainerType r100) {
            this.container_type = r100;
            return this;
        }

        public Builder initiator(Long r100) {
            this.initiator = r100;
            return this;
        }

        public Builder is_public(Boolean r100) {
            this.is_public = r100;
            return this;
        }

        public Builder max_pick_num(Long r100) {
            this.max_pick_num = r100;
            return this;
        }

        public Builder min_pick_num(Long r100) {
            this.min_pick_num = r100;
            return this;
        }

        public Builder options(List<VoteOption> r100) {
            Internal.checkElementsNotNull(r100);
            this.options = r100;
            return this;
        }

        public Builder scope_id(String r100) {
            this.scope_id = r100;
            return this;
        }

        public Builder scope_type(VoteScopeType r100) {
            this.scope_type = r100;
            return this;
        }

        public Builder status(VoteStatus r100) {
            this.status = r100;
            return this;
        }

        public Builder topic(String r100) {
            this.topic = r100;
            return this;
        }

        public Builder uuid(Long r100) {
            this.uuid = r100;
            return this;
        }

        public Builder vote_message_type(VoteMessageType r100) {
            this.vote_message_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_VoteContent extends ProtoAdapter<VoteContent> {
        public ProtoAdapter_VoteContent() {
            super(FieldEncoding.LENGTH_DELIMITED, VoteContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VoteContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.uuid = 0L;
            r101.scope_id = "";
            r101.scope_type = VoteScopeType.UNKNOWN_SCOPE;
            r101.container_type = VoteContainerType.UNKNOWN_CONTAINER;
            r101.topic = "";
            r101.min_pick_num = 0L;
            r101.max_pick_num = 0L;
            r101.is_public = Boolean.FALSE;
            r101.status = VoteStatus.OPEN;
            r101.initiator = 0L;
            r101.vote_message_type = VoteMessageType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L31;
            switch(r103) {
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L37;
                case 4: goto L33;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L39;
                case 11: goto L11;
                case 12: goto L35;
                default: goto L6;
            };
        L33:
            r101.container_type = VoteContainerType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L35:
            r101.vote_message_type = VoteMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L37:
            r101.scope_type = VoteScopeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L39:
            r101.status = VoteStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.initiator = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.options.add(VoteOption.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.is_public = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.max_pick_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.min_pick_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.topic = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.scope_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.uuid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L31:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(VoteContent r100) {
            Long r101 = r100.uuid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.scope_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            VoteScopeType r107 = r100.scope_type;
            if (r107 == null) goto L13;
            int r108 = VoteScopeType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            VoteContainerType r110 = r100.container_type;
            if (r110 == null) goto L17;
            int r111 = VoteContainerType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.topic;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.min_pick_num;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.max_pick_num;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_public;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = (r121 + r123) + VoteOption.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.options);
            VoteStatus r125 = r100.status;
            if (r125 == null) goto L37;
            int r126 = VoteStatus.ADAPTER.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.initiator;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            VoteMessageType r131 = r100.vote_message_type;
            if (r131 == null) goto L46;
            r102 = VoteMessageType.ADAPTER.encodedSizeWithTag(12, r131);
        L46:
            return (r130 + r102) + r100.unknownFields().size();
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ VoteContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VoteContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VoteContent r101) throws IOException {
            Long r102 = r101.uuid;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.scope_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            VoteScopeType r104 = r101.scope_type;
            if (r104 == null) goto L11;
            VoteScopeType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            VoteContainerType r105 = r101.container_type;
            if (r105 == null) goto L14;
            VoteContainerType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.topic;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.min_pick_num;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.max_pick_num;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.is_public;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            VoteOption.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.options);
            VoteStatus r110 = r101.status;
            if (r110 == null) goto L29;
            VoteStatus.ADAPTER.encodeWithTag(r100, 10, r110);
        L29:
            Long r111 = r101.initiator;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 11, r111);
        L32:
            VoteMessageType r112 = r101.vote_message_type;
            if (r112 == null) goto L35;
            VoteMessageType.ADAPTER.encodeWithTag(r100, 12, r112);
        L35:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VoteContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VoteContent();
        DEFAULT_UUID = 0L;
        DEFAULT_SCOPE_TYPE = VoteScopeType.UNKNOWN_SCOPE;
        DEFAULT_CONTAINER_TYPE = VoteContainerType.UNKNOWN_CONTAINER;
        DEFAULT_MIN_PICK_NUM = 0L;
        DEFAULT_MAX_PICK_NUM = 0L;
        DEFAULT_IS_PUBLIC = Boolean.FALSE;
        DEFAULT_STATUS = VoteStatus.OPEN;
        DEFAULT_INITIATOR = 0L;
        DEFAULT_VOTE_MESSAGE_TYPE = VoteMessageType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.uuid = this.uuid;
        r100.scope_id = this.scope_id;
        r100.scope_type = this.scope_type;
        r100.container_type = this.container_type;
        r100.topic = this.topic;
        r100.min_pick_num = this.min_pick_num;
        r100.max_pick_num = this.max_pick_num;
        r100.is_public = this.is_public;
        r100.options = Internal.copyOf("options", this.options);
        r100.status = this.status;
        r100.initiator = this.initiator;
        r100.vote_message_type = this.vote_message_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VoteContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VoteContent(Long r110, String r111, VoteScopeType r112, VoteContainerType r113, String r114, Long r210, Long r211, Boolean r212, List<VoteOption> r213, VoteStatus r214, Long r215, VoteMessageType r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public VoteContent(Long r100, String r101, VoteScopeType r102, VoteContainerType r103, String r104, Long r105, Long r106, Boolean r107, List<VoteOption> r110, VoteStatus r111, Long r112, VoteMessageType r113, ByteString r114) {
        super(ADAPTER, r114);
        this.uuid = r100;
        this.scope_id = r101;
        this.scope_type = r102;
        this.container_type = r103;
        this.topic = r104;
        this.min_pick_num = r105;
        this.max_pick_num = r106;
        this.is_public = r107;
        this.options = Internal.immutableCopyOf("options", r110);
        this.status = r111;
        this.initiator = r112;
        this.vote_message_type = r113;
    }
}
