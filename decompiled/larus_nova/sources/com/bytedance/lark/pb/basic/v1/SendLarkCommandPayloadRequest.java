package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SendLarkCommandPayloadRequest extends com.squareup.wire.Message<SendLarkCommandPayloadRequest, Builder> {
    public static final ProtoAdapter<SendLarkCommandPayloadRequest> ADAPTER = null;
    public static final Integer DEFAULT_CMD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final ProtoAdapter_SendLarkCommandPayloadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer cmd;
    public final ByteString payload;

    public static final class Builder extends com.squareup.wire.Message.Builder<SendLarkCommandPayloadRequest, Builder> implements d<SendLarkCommandPayloadRequest> {
        public Integer cmd;
        public ByteString payload;

        @Override // com.squareup.wire.Message.Builder
        public SendLarkCommandPayloadRequest build() {
            return new SendLarkCommandPayloadRequest(this.payload, this.cmd, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cmd(Integer r100) {
            this.cmd = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendLarkCommandPayloadRequest extends ProtoAdapter<SendLarkCommandPayloadRequest> implements c<SendLarkCommandPayloadRequest> {
        public ProtoAdapter_SendLarkCommandPayloadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendLarkCommandPayloadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendLarkCommandPayloadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.payload = ByteString.EMPTY;
            r101.cmd = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.payload = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.cmd = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(SendLarkCommandPayloadRequest r100) {
            ByteString r101 = r100.payload;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.cmd;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendLarkCommandPayloadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendLarkCommandPayloadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendLarkCommandPayloadRequest r101) throws IOException {
            ByteString r102 = r101.payload;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.cmd;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendLarkCommandPayloadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendLarkCommandPayloadRequest r100 = new ProtoAdapter_SendLarkCommandPayloadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_CMD = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.payload = this.payload;
        r100.cmd = this.cmd;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendLarkCommandPayloadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendLarkCommandPayloadRequest(ByteString r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SendLarkCommandPayloadRequest(ByteString r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.payload = r100;
        this.cmd = r101;
    }
}
