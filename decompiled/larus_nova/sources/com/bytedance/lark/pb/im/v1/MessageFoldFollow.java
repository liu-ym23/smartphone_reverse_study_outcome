package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.MessageFoldDetail;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageFoldFollow extends Message<MessageFoldFollow, Builder> {
    public static final ProtoAdapter<MessageFoldFollow> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Long DEFAULT_FOLLOW_TIME_MS = null;
    public static final MessageFoldDetail.RecallType DEFAULT_RECALL_TYPE = null;
    public static final Long DEFAULT_RECALL_USER_ID = null;
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final Integer count;
    public final Long follow_time_ms;
    public final MessageFoldDetail.RecallType recall_type;
    public final Long recall_user_id;
    public final Long user_id;

    public static final class Builder extends Message.Builder<MessageFoldFollow, Builder> {
        public Integer count;
        public Long follow_time_ms;
        public MessageFoldDetail.RecallType recall_type;
        public Long recall_user_id;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public MessageFoldFollow build() {
            return new MessageFoldFollow(this.user_id, this.count, this.recall_type, this.recall_user_id, this.follow_time_ms, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder follow_time_ms(Long r100) {
            this.follow_time_ms = r100;
            return this;
        }

        public Builder recall_type(MessageFoldDetail.RecallType r100) {
            this.recall_type = r100;
            return this;
        }

        public Builder recall_user_id(Long r100) {
            this.recall_user_id = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageFoldFollow extends ProtoAdapter<MessageFoldFollow> {
        public ProtoAdapter_MessageFoldFollow() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageFoldFollow.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageFoldFollow decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = 0L;
            r101.count = 0;
            r101.recall_type = MessageFoldDetail.RecallType.NOT_RECALL;
            r101.recall_user_id = 0L;
            r101.follow_time_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.recall_type = MessageFoldDetail.RecallType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.recall_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.follow_time_ms = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(MessageFoldFollow r100) {
            Long r101 = r100.user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.count;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            MessageFoldDetail.RecallType r107 = r100.recall_type;
            if (r107 == null) goto L13;
            int r108 = MessageFoldDetail.RecallType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.recall_user_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.follow_time_ms;
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
        public /* bridge */ /* synthetic */ MessageFoldFollow decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageFoldFollow r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageFoldFollow r101) throws IOException {
            Long r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            MessageFoldDetail.RecallType r104 = r101.recall_type;
            if (r104 == null) goto L11;
            MessageFoldDetail.RecallType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.recall_user_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.follow_time_ms;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageFoldFollow r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageFoldFollow();
        DEFAULT_USER_ID = 0L;
        DEFAULT_COUNT = 0;
        DEFAULT_RECALL_TYPE = MessageFoldDetail.RecallType.NOT_RECALL;
        DEFAULT_RECALL_USER_ID = 0L;
        DEFAULT_FOLLOW_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.count = this.count;
        r100.recall_type = this.recall_type;
        r100.recall_user_id = this.recall_user_id;
        r100.follow_time_ms = this.follow_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageFoldFollow.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageFoldFollow(Long r100, Integer r101, MessageFoldDetail.RecallType r110, Long r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MessageFoldFollow(Long r100, Integer r101, MessageFoldDetail.RecallType r102, Long r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.user_id = r100;
        this.count = r101;
        this.recall_type = r102;
        this.recall_user_id = r103;
        this.follow_time_ms = r104;
    }
}
