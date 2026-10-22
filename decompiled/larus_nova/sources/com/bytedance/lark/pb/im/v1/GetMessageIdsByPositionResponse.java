package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetMessageIdsByPositionResponse extends Message<GetMessageIdsByPositionResponse, Builder> {
    public static final ProtoAdapter<GetMessageIdsByPositionResponse> ADAPTER = null;
    public static final ProtoAdapter_GetMessageIdsByPositionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, com.bytedance.lark.pb.basic.v1.Message.Type> message_id_types;
    public final Map<Integer, String> message_ids;

    public static final class Builder extends Message.Builder<GetMessageIdsByPositionResponse, Builder> implements d<GetMessageIdsByPositionResponse> {
        public Map<String, com.bytedance.lark.pb.basic.v1.Message.Type> message_id_types;
        public Map<Integer, String> message_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageIdsByPositionResponse build() {
            return new GetMessageIdsByPositionResponse(this.message_ids, this.message_id_types, super.buildUnknownFields());
        }

        public Builder() {
            this.message_ids = Internal.newMutableMap();
            this.message_id_types = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_id_types(Map<String, com.bytedance.lark.pb.basic.v1.Message.Type> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_id_types = r100;
            return this;
        }

        public Builder message_ids(Map<Integer, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageIdsByPositionResponse extends ProtoAdapter<GetMessageIdsByPositionResponse> implements c<GetMessageIdsByPositionResponse> {
        private final ProtoAdapter<Map<String, com.bytedance.lark.pb.basic.v1.Message.Type>> message_id_types;
        private final ProtoAdapter<Map<Integer, String>> message_ids;

        public ProtoAdapter_GetMessageIdsByPositionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageIdsByPositionResponse.class);
            ProtoAdapter<Integer> r100 = ProtoAdapter.INT32;
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            this.message_ids = ProtoAdapter.newMapAdapter(r100, r101);
            this.message_id_types = ProtoAdapter.newMapAdapter(r101, com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageIdsByPositionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.message_ids.putAll(this.message_ids.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.message_id_types.putAll(this.message_id_types.decode(r100));
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
        public int encodedSize2(GetMessageIdsByPositionResponse r100) {
            return (this.message_ids.encodedSizeWithTag(1, r100.message_ids) + this.message_id_types.encodedSizeWithTag(2, r100.message_id_types)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageIdsByPositionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageIdsByPositionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageIdsByPositionResponse r101) throws IOException {
            this.message_ids.encodeWithTag(r100, 1, r101.message_ids);
            this.message_id_types.encodeWithTag(r100, 2, r101.message_id_types);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageIdsByPositionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageIdsByPositionResponse r100 = new ProtoAdapter_GetMessageIdsByPositionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.message_id_types = Internal.copyOf("message_id_types", this.message_id_types);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageIdsByPositionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageIdsByPositionResponse(Map<Integer, String> r100, Map<String, com.bytedance.lark.pb.basic.v1.Message.Type> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetMessageIdsByPositionResponse(Map<Integer, String> r100, Map<String, com.bytedance.lark.pb.basic.v1.Message.Type> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
        this.message_id_types = Internal.immutableCopyOf("message_id_types", r101);
    }
}
