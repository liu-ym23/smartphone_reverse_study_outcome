package com.bytedance.lark.pb.sync.v1;

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
public final class SubscribeTopicResponse extends Message<SubscribeTopicResponse, Builder> {
    public static final ProtoAdapter<SubscribeTopicResponse> ADAPTER = null;
    public static final SubscribeStatusCode DEFAULT_CODE = null;
    public static final String DEFAULT_MSG = "";
    public static final ProtoAdapter_SubscribeTopicResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SubscribeStatusCode code;
    public final String msg;

    public static final class Builder extends Message.Builder<SubscribeTopicResponse, Builder> implements d<SubscribeTopicResponse> {
        public SubscribeStatusCode code;
        public String msg;

        @Override // com.squareup.wire.Message.Builder
        public SubscribeTopicResponse build() {
            SubscribeStatusCode r100 = this.code;
            if (r100 == null) goto L7;
            return new SubscribeTopicResponse(this.code, this.msg, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "code"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(SubscribeStatusCode r100) {
            this.code = r100;
            return this;
        }

        public Builder msg(String r100) {
            this.msg = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeTopicResponse extends ProtoAdapter<SubscribeTopicResponse> implements c<SubscribeTopicResponse> {
        public ProtoAdapter_SubscribeTopicResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeTopicResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeTopicResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.code = SubscribeStatusCode.SUCCESS;
            r101.msg = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.code = SubscribeStatusCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeTopicResponse r100) {
            int r101 = SubscribeStatusCode.ADAPTER.encodedSizeWithTag(1, r100.code);
            String r102 = r100.msg;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeTopicResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeTopicResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscribeTopicResponse r101) throws IOException {
            SubscribeStatusCode.ADAPTER.encodeWithTag(r100, 1, r101.code);
            String r102 = r101.msg;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscribeTopicResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SubscribeTopicResponse r100 = new ProtoAdapter_SubscribeTopicResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CODE = SubscribeStatusCode.SUCCESS;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.code = this.code;
        r100.msg = this.msg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubscribeTopicResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubscribeTopicResponse(SubscribeStatusCode r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SubscribeTopicResponse(SubscribeStatusCode r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.code = r100;
        this.msg = r101;
    }
}
