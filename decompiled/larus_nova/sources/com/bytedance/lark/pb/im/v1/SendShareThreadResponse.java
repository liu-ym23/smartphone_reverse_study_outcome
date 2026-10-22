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
public final class SendShareThreadResponse extends Message<SendShareThreadResponse, Builder> {
    public static final ProtoAdapter<SendShareThreadResponse> ADAPTER = null;
    public static final ProtoAdapter_SendShareThreadResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> message_ids;

    public static final class Builder extends Message.Builder<SendShareThreadResponse, Builder> implements d<SendShareThreadResponse> {
        public Map<String, String> message_ids;

        @Override // com.squareup.wire.Message.Builder
        public SendShareThreadResponse build() {
            return new SendShareThreadResponse(this.message_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.message_ids = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_ids(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendShareThreadResponse extends ProtoAdapter<SendShareThreadResponse> implements c<SendShareThreadResponse> {
        private final ProtoAdapter<Map<String, String>> message_ids;

        public ProtoAdapter_SendShareThreadResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendShareThreadResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.message_ids = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendShareThreadResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.message_ids.putAll(this.message_ids.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendShareThreadResponse r100) {
            return this.message_ids.encodedSizeWithTag(1, r100.message_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendShareThreadResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendShareThreadResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendShareThreadResponse r101) throws IOException {
            this.message_ids.encodeWithTag(r100, 1, r101.message_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendShareThreadResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendShareThreadResponse r100 = new ProtoAdapter_SendShareThreadResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendShareThreadResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendShareThreadResponse(Map<String, String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SendShareThreadResponse(Map<String, String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
    }
}
