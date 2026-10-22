package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetMessageIdsByPositionRequest extends Message<GetMessageIdsByPositionRequest, Builder> {
    public static final ProtoAdapter<GetMessageIdsByPositionRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_COUNT = null;
    public static final Integer DEFAULT_START_POSITION = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetMessageIdsByPositionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Integer count;
    public final Integer start_position;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetMessageIdsByPositionRequest, Builder> implements d<GetMessageIdsByPositionRequest> {
        public String chat_id;
        public Integer count;
        public Integer start_position;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageIdsByPositionRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L9;
            if (this.start_position == null) goto L9;
            return new GetMessageIdsByPositionRequest(this.chat_id, this.start_position, this.count, this.sync_data_strategy, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.start_position, "start_position"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder start_position(Integer r100) {
            this.start_position = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageIdsByPositionRequest extends ProtoAdapter<GetMessageIdsByPositionRequest> implements c<GetMessageIdsByPositionRequest> {
        public ProtoAdapter_GetMessageIdsByPositionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageIdsByPositionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageIdsByPositionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.start_position = 0;
            r101.count = 100;
            r101.sync_data_strategy = SyncDataStrategy.TRY_LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.start_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(GetMessageIdsByPositionRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.start_position);
            Integer r104 = r100.count;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            SyncDataStrategy r108 = r100.sync_data_strategy;
            if (r108 == null) goto L10;
            r105 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(4, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageIdsByPositionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageIdsByPositionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageIdsByPositionRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 2, r101.start_position);
            Integer r103 = r101.count;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            SyncDataStrategy r104 = r101.sync_data_strategy;
            if (r104 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageIdsByPositionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageIdsByPositionRequest r100 = new ProtoAdapter_GetMessageIdsByPositionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_START_POSITION = 0;
        DEFAULT_COUNT = 100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.TRY_LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.start_position = this.start_position;
        r100.count = this.count;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageIdsByPositionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageIdsByPositionRequest(String r100, Integer r101, Integer r102, SyncDataStrategy r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetMessageIdsByPositionRequest(String r100, Integer r101, Integer r102, SyncDataStrategy r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.start_position = r101;
        this.count = r102;
        this.sync_data_strategy = r103;
    }
}
