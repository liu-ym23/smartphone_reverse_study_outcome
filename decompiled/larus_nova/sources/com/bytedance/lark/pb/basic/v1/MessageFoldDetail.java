package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageFoldDetail extends com.squareup.wire.Message<MessageFoldDetail, Builder> {
    public static final ProtoAdapter<MessageFoldDetail> ADAPTER = null;
    public static final Long DEFAULT_FOLD_ID = null;
    public static final Integer DEFAULT_LAST_MESSAGE_BADGE_COUNT = null;
    public static final Long DEFAULT_LAST_MESSAGE_ID = null;
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION = null;
    public static final RecallType DEFAULT_RECALL_TYPE = null;
    public static final Long DEFAULT_RECALL_USER_ID = null;
    public static final Long DEFAULT_ROOT_MESSAGE_ID = null;
    public static final Integer DEFAULT_ROOT_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_TOTAL_COUNT = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    public static final Integer DEFAULT_USER_LEN = null;
    private static final long serialVersionUID = 0;
    public final Long fold_id;
    public final Integer last_message_badge_count;
    public final Long last_message_id;
    public final Integer last_message_position;
    public final Message message;
    public final RecallType recall_type;
    public final Long recall_user_id;
    public final Long root_message_id;
    public final Integer root_message_position;
    public final Integer total_count;
    public final Long update_time_ms;
    public final List<FoldUserCount> user_counts;
    public final Integer user_len;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageFoldDetail, Builder> {
        public Long fold_id;
        public Integer last_message_badge_count;
        public Long last_message_id;
        public Integer last_message_position;
        public Message message;
        public RecallType recall_type;
        public Long recall_user_id;
        public Long root_message_id;
        public Integer root_message_position;
        public Integer total_count;
        public Long update_time_ms;
        public List<FoldUserCount> user_counts;
        public Integer user_len;

        @Override // com.squareup.wire.Message.Builder
        public MessageFoldDetail build() {
            return new MessageFoldDetail(this.fold_id, this.message, this.root_message_id, this.root_message_position, this.last_message_id, this.last_message_position, this.last_message_badge_count, this.user_len, this.total_count, this.update_time_ms, this.user_counts, this.recall_type, this.recall_user_id, super.buildUnknownFields());
        }

        public Builder() {
            this.user_counts = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder fold_id(Long r100) {
            this.fold_id = r100;
            return this;
        }

        public Builder last_message_badge_count(Integer r100) {
            this.last_message_badge_count = r100;
            return this;
        }

        public Builder last_message_id(Long r100) {
            this.last_message_id = r100;
            return this;
        }

        public Builder last_message_position(Integer r100) {
            this.last_message_position = r100;
            return this;
        }

        public Builder message(Message r100) {
            this.message = r100;
            return this;
        }

        public Builder recall_type(RecallType r100) {
            this.recall_type = r100;
            return this;
        }

        public Builder recall_user_id(Long r100) {
            this.recall_user_id = r100;
            return this;
        }

        public Builder root_message_id(Long r100) {
            this.root_message_id = r100;
            return this;
        }

        public Builder root_message_position(Integer r100) {
            this.root_message_position = r100;
            return this;
        }

        public Builder total_count(Integer r100) {
            this.total_count = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }

        public Builder user_counts(List<FoldUserCount> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_counts = r100;
            return this;
        }

        public Builder user_len(Integer r100) {
            this.user_len = r100;
            return this;
        }
    }

    public static final class FoldUserCount extends com.squareup.wire.Message<FoldUserCount, Builder> {
        public static final ProtoAdapter<FoldUserCount> ADAPTER = null;
        public static final Integer DEFAULT_COUNT = null;
        public static final Long DEFAULT_USER_ID = null;
        private static final long serialVersionUID = 0;
        public final Integer count;
        public final Long user_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<FoldUserCount, Builder> {
            public Integer count;
            public Long user_id;

            @Override // com.squareup.wire.Message.Builder
            public FoldUserCount build() {
                return new FoldUserCount(this.user_id, this.count, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder count(Integer r100) {
                this.count = r100;
                return this;
            }

            public Builder user_id(Long r100) {
                this.user_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FoldUserCount extends ProtoAdapter<FoldUserCount> {
            public ProtoAdapter_FoldUserCount() {
                super(FieldEncoding.LENGTH_DELIMITED, FoldUserCount.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FoldUserCount decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = 0L;
                r101.count = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.user_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FoldUserCount r100) {
                Long r101 = r100.user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.count;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FoldUserCount decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FoldUserCount r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FoldUserCount r101) throws IOException {
                Long r102 = r101.user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.count;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FoldUserCount r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FoldUserCount();
            DEFAULT_USER_ID = 0L;
            DEFAULT_COUNT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.count = this.count;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FoldUserCount.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public FoldUserCount(Long r100, Integer r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public FoldUserCount(Long r100, Integer r101, ByteString r102) {
            super(ADAPTER, r102);
            this.user_id = r100;
            this.count = r101;
        }
    }

    public static final class ProtoAdapter_MessageFoldDetail extends ProtoAdapter<MessageFoldDetail> {
        public ProtoAdapter_MessageFoldDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageFoldDetail.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageFoldDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.fold_id = 0L;
            r101.root_message_id = 0L;
            r101.root_message_position = 0;
            r101.last_message_id = 0L;
            r101.last_message_position = 0;
            r101.last_message_badge_count = 0;
            r101.user_len = 0;
            r101.total_count = 0;
            r101.update_time_ms = 0L;
            r101.recall_type = RecallType.NOT_RECALL;
            r101.recall_user_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L25;
                case 13: goto L7;
                default: goto L6;
            };
        L25:
            r101.recall_type = RecallType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.recall_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.user_counts.add(FoldUserCount.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.total_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.user_len = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.last_message_badge_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.last_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.last_message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.root_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L20:
            r101.root_message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L21:
            r101.message = Message.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.fold_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageFoldDetail r100) {
            Long r101 = r100.fold_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Message r104 = r100.message;
            if (r104 == null) goto L9;
            int r105 = Message.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.root_message_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.root_message_position;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.last_message_id;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.last_message_position;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.last_message_badge_count;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Integer r122 = r100.user_len;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Integer r125 = r100.total_count;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT32.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Long r128 = r100.update_time_ms;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT64.encodedSizeWithTag(10, r128);
        L42:
            int r130 = (r127 + r129) + FoldUserCount.ADAPTER.asRepeated().encodedSizeWithTag(11, r100.user_counts);
            RecallType r131 = r100.recall_type;
            if (r131 == null) goto L45;
            int r132 = RecallType.ADAPTER.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            Long r134 = r100.recall_user_id;
            if (r134 == null) goto L50;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(13, r134);
        L50:
            return (r133 + r102) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
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
        public /* bridge */ /* synthetic */ MessageFoldDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageFoldDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageFoldDetail r101) throws IOException {
            Long r102 = r101.fold_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Message r103 = r101.message;
            if (r103 == null) goto L8;
            Message.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.root_message_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.root_message_position;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.last_message_id;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            Integer r107 = r101.last_message_position;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.last_message_badge_count;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            Integer r109 = r101.user_len;
            if (r109 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L26:
            Integer r110 = r101.total_count;
            if (r110 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 9, r110);
        L29:
            Long r111 = r101.update_time_ms;
            if (r111 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r111);
        L32:
            FoldUserCount.ADAPTER.asRepeated().encodeWithTag(r100, 11, r101.user_counts);
            RecallType r112 = r101.recall_type;
            if (r112 == null) goto L35;
            RecallType.ADAPTER.encodeWithTag(r100, 12, r112);
        L35:
            Long r113 = r101.recall_user_id;
            if (r113 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r100, 13, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageFoldDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum RecallType extends Enum<RecallType> implements WireEnum {
        private static final /* synthetic */ RecallType[] $VALUES = null;
        public static final ProtoAdapter<RecallType> ADAPTER = null;
        public static final RecallType ENTERPRISE_ADMIN_RECALL = null;
        public static final RecallType GROUP_ADMIN_RECALL = null;
        public static final RecallType GROUP_OWNER_RECALL = null;
        public static final RecallType NOT_RECALL = null;
        public static final RecallType USER_RECALL = null;
        private final int value;

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
            $VALUES = new RecallType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(RecallType.class);
        }

        public static RecallType[] values() {
            return (RecallType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RecallType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return ENTERPRISE_ADMIN_RECALL;
        L16:
            return GROUP_ADMIN_RECALL;
        L18:
            return GROUP_OWNER_RECALL;
        L20:
            return USER_RECALL;
        L22:
            return NOT_RECALL;
        }

        public static RecallType valueOf(String r100) {
            return (RecallType) a.a(RecallType.class, r100);
        }

        private RecallType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageFoldDetail();
        DEFAULT_FOLD_ID = 0L;
        DEFAULT_ROOT_MESSAGE_ID = 0L;
        DEFAULT_ROOT_MESSAGE_POSITION = 0;
        DEFAULT_LAST_MESSAGE_ID = 0L;
        DEFAULT_LAST_MESSAGE_POSITION = 0;
        DEFAULT_LAST_MESSAGE_BADGE_COUNT = 0;
        DEFAULT_USER_LEN = 0;
        DEFAULT_TOTAL_COUNT = 0;
        DEFAULT_UPDATE_TIME_MS = 0L;
        DEFAULT_RECALL_TYPE = RecallType.NOT_RECALL;
        DEFAULT_RECALL_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fold_id = this.fold_id;
        r100.message = this.message;
        r100.root_message_id = this.root_message_id;
        r100.root_message_position = this.root_message_position;
        r100.last_message_id = this.last_message_id;
        r100.last_message_position = this.last_message_position;
        r100.last_message_badge_count = this.last_message_badge_count;
        r100.user_len = this.user_len;
        r100.total_count = this.total_count;
        r100.update_time_ms = this.update_time_ms;
        r100.user_counts = Internal.copyOf("user_counts", this.user_counts);
        r100.recall_type = this.recall_type;
        r100.recall_user_id = this.recall_user_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageFoldDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageFoldDetail(Long r110, Message r111, Long r112, Integer r113, Long r210, Integer r211, Integer r212, Integer r213, Integer r214, Long r215, List<FoldUserCount> r216, RecallType r217, Long r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public MessageFoldDetail(Long r100, Message r101, Long r102, Integer r103, Long r104, Integer r105, Integer r106, Integer r107, Integer r110, Long r111, List<FoldUserCount> r112, RecallType r113, Long r114, ByteString r115) {
        super(ADAPTER, r115);
        this.fold_id = r100;
        this.message = r101;
        this.root_message_id = r102;
        this.root_message_position = r103;
        this.last_message_id = r104;
        this.last_message_position = r105;
        this.last_message_badge_count = r106;
        this.user_len = r107;
        this.total_count = r110;
        this.update_time_ms = r111;
        this.user_counts = Internal.immutableCopyOf("user_counts", r112);
        this.recall_type = r113;
        this.recall_user_id = r114;
    }
}
