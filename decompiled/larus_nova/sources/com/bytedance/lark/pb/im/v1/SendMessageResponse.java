package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Trace;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SendMessageResponse extends Message<SendMessageResponse, Builder> {
    public static final ProtoAdapter<SendMessageResponse> ADAPTER = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Long DEFAULT_NET_COST = null;
    public static final ProtoAdapter_SendMessageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String message_id;
    public final Long net_cost;
    public final Trace trace;

    public static final class Builder extends Message.Builder<SendMessageResponse, Builder> implements d<SendMessageResponse> {
        public String message_id;
        public Long net_cost;
        public Trace trace;

        @Override // com.squareup.wire.Message.Builder
        public SendMessageResponse build() {
            return new SendMessageResponse(this.message_id, this.net_cost, this.trace, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder net_cost(Long r100) {
            this.net_cost = r100;
            return this;
        }

        public Builder trace(Trace r100) {
            this.trace = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendMessageResponse extends ProtoAdapter<SendMessageResponse> implements c<SendMessageResponse> {
        public ProtoAdapter_SendMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendMessageResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendMessageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.net_cost = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.net_cost = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.trace = Trace.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendMessageResponse r100) {
            String r101 = r100.message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.net_cost;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.UINT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Trace r107 = r100.trace;
            if (r107 == null) goto L14;
            r102 = Trace.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendMessageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendMessageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendMessageResponse r101) throws IOException {
            String r102 = r101.message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.net_cost;
            if (r103 == null) goto L8;
            ProtoAdapter.UINT64.encodeWithTag(r100, 2, r103);
        L8:
            Trace r104 = r101.trace;
            if (r104 == null) goto L11;
            Trace.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendMessageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendMessageResponse r100 = new ProtoAdapter_SendMessageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NET_COST = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.net_cost = this.net_cost;
        r100.trace = this.trace;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendMessageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendMessageResponse(String r100, Long r101, Trace r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SendMessageResponse(String r100, Long r101, Trace r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_id = r100;
        this.net_cost = r101;
        this.trace = r102;
    }
}
