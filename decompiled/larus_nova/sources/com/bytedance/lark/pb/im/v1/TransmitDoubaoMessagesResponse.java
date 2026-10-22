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
public final class TransmitDoubaoMessagesResponse extends Message<TransmitDoubaoMessagesResponse, Builder> {
    public static final ProtoAdapter<TransmitDoubaoMessagesResponse> ADAPTER = null;
    public static final ProtoAdapter_TransmitDoubaoMessagesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Transmit2ThreadTarget> message2threads;
    public final Map<String, String> message_ids;

    public static final class Builder extends Message.Builder<TransmitDoubaoMessagesResponse, Builder> implements d<TransmitDoubaoMessagesResponse> {
        public Map<String, Transmit2ThreadTarget> message2threads;
        public Map<String, String> message_ids;

        @Override // com.squareup.wire.Message.Builder
        public TransmitDoubaoMessagesResponse build() {
            return new TransmitDoubaoMessagesResponse(this.message_ids, this.message2threads, super.buildUnknownFields());
        }

        public Builder() {
            this.message_ids = Internal.newMutableMap();
            this.message2threads = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message2threads(Map<String, Transmit2ThreadTarget> r100) {
            Internal.checkElementsNotNull(r100);
            this.message2threads = r100;
            return this;
        }

        public Builder message_ids(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TransmitDoubaoMessagesResponse extends ProtoAdapter<TransmitDoubaoMessagesResponse> implements c<TransmitDoubaoMessagesResponse> {
        private final ProtoAdapter<Map<String, Transmit2ThreadTarget>> message2threads;
        private final ProtoAdapter<Map<String, String>> message_ids;

        public ProtoAdapter_TransmitDoubaoMessagesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, TransmitDoubaoMessagesResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.message_ids = ProtoAdapter.newMapAdapter(r100, r100);
            this.message2threads = ProtoAdapter.newMapAdapter(r100, Transmit2ThreadTarget.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TransmitDoubaoMessagesResponse decode(ProtoReader r100) throws IOException {
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
            r101.message2threads.putAll(this.message2threads.decode(r100));
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
        public int encodedSize2(TransmitDoubaoMessagesResponse r100) {
            return (this.message_ids.encodedSizeWithTag(1, r100.message_ids) + this.message2threads.encodedSizeWithTag(2, r100.message2threads)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TransmitDoubaoMessagesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TransmitDoubaoMessagesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TransmitDoubaoMessagesResponse r101) throws IOException {
            this.message_ids.encodeWithTag(r100, 1, r101.message_ids);
            this.message2threads.encodeWithTag(r100, 2, r101.message2threads);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TransmitDoubaoMessagesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TransmitDoubaoMessagesResponse r100 = new ProtoAdapter_TransmitDoubaoMessagesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.message2threads = Internal.copyOf("message2threads", this.message2threads);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TransmitDoubaoMessagesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TransmitDoubaoMessagesResponse(Map<String, String> r100, Map<String, Transmit2ThreadTarget> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TransmitDoubaoMessagesResponse(Map<String, String> r100, Map<String, Transmit2ThreadTarget> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
        this.message2threads = Internal.immutableCopyOf("message2threads", r101);
    }
}
