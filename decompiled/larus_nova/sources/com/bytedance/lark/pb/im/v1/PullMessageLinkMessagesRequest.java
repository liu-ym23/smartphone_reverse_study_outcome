package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PullMessageLinkMessagesRequest extends Message<PullMessageLinkMessagesRequest, Builder> {
    public static final ProtoAdapter<PullMessageLinkMessagesRequest> ADAPTER = null;
    public static final Long DEFAULT_OUTER_CHAT_ID = null;
    public static final String DEFAULT_PREVIEW_TOKEN = "";
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final String DEFAULT_TOKEN = "";
    public static final ProtoAdapter_PullMessageLinkMessagesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Long> need_message_ids;
    public final Long outer_chat_id;
    public final String preview_token;
    public final SyncDataStrategy sync_data_strategy;
    public final String token;

    public static final class Builder extends Message.Builder<PullMessageLinkMessagesRequest, Builder> implements d<PullMessageLinkMessagesRequest> {
        public List<Long> need_message_ids;
        public Long outer_chat_id;
        public String preview_token;
        public SyncDataStrategy sync_data_strategy;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public PullMessageLinkMessagesRequest build() {
            return new PullMessageLinkMessagesRequest(this.sync_data_strategy, this.token, this.preview_token, this.need_message_ids, this.outer_chat_id, super.buildUnknownFields());
        }

        public Builder() {
            this.need_message_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder need_message_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.need_message_ids = r100;
            return this;
        }

        public Builder outer_chat_id(Long r100) {
            this.outer_chat_id = r100;
            return this;
        }

        public Builder preview_token(String r100) {
            this.preview_token = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullMessageLinkMessagesRequest extends ProtoAdapter<PullMessageLinkMessagesRequest> implements c<PullMessageLinkMessagesRequest> {
        public ProtoAdapter_PullMessageLinkMessagesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullMessageLinkMessagesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullMessageLinkMessagesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.TRY_LOCAL;
            r101.token = "";
            r101.preview_token = "";
            r101.outer_chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.preview_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.need_message_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.outer_chat_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(PullMessageLinkMessagesRequest r100) {
            SyncDataStrategy r101 = r100.sync_data_strategy;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.token;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.preview_token;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ProtoAdapter<Long> r110 = ProtoAdapter.INT64;
            int r111 = r109 + r110.asRepeated().encodedSizeWithTag(4, r100.need_message_ids);
            Long r112 = r100.outer_chat_id;
            if (r112 == null) goto L18;
            r102 = r110.encodedSizeWithTag(5, r112);
        L18:
            return (r111 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PullMessageLinkMessagesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullMessageLinkMessagesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullMessageLinkMessagesRequest r101) throws IOException {
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.preview_token;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ProtoAdapter<Long> r105 = ProtoAdapter.INT64;
            r105.asRepeated().encodeWithTag(r100, 4, r101.need_message_ids);
            Long r106 = r101.outer_chat_id;
            if (r106 == null) goto L14;
            r105.encodeWithTag(r100, 5, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullMessageLinkMessagesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PullMessageLinkMessagesRequest r100 = new ProtoAdapter_PullMessageLinkMessagesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.TRY_LOCAL;
        DEFAULT_OUTER_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.token = this.token;
        r100.preview_token = this.preview_token;
        r100.need_message_ids = Internal.copyOf("need_message_ids", this.need_message_ids);
        r100.outer_chat_id = this.outer_chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullMessageLinkMessagesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullMessageLinkMessagesRequest(SyncDataStrategy r100, String r101, String r110, List<Long> r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PullMessageLinkMessagesRequest(SyncDataStrategy r100, String r101, String r102, List<Long> r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.sync_data_strategy = r100;
        this.token = r101;
        this.preview_token = r102;
        this.need_message_ids = Internal.immutableCopyOf("need_message_ids", r103);
        this.outer_chat_id = r104;
    }
}
