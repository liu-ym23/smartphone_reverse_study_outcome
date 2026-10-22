package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SendSteamLogsResponse extends Message<SendSteamLogsResponse, Builder> {
    public static final ProtoAdapter<SendSteamLogsResponse> ADAPTER = null;
    public static final String DEFAULT_MESSAGE = "";
    public static final Integer DEFAULT_STATUS_CODE = null;
    public static final ProtoAdapter_SendSteamLogsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String message;
    public final Integer status_code;

    public static final class Builder extends Message.Builder<SendSteamLogsResponse, Builder> implements b<SendSteamLogsResponse> {
        public String message;
        public Integer status_code;

        @Override // com.squareup.wire.Message.Builder
        public SendSteamLogsResponse build() {
            Integer r100 = this.status_code;
            if (r100 == null) goto L9;
            if (this.message == null) goto L9;
            return new SendSteamLogsResponse(this.status_code, this.message, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "status_code", this.message, "message"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message(String r100) {
            this.message = r100;
            return this;
        }

        public Builder status_code(Integer r100) {
            this.status_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendSteamLogsResponse extends ProtoAdapter<SendSteamLogsResponse> implements a<SendSteamLogsResponse> {
        public ProtoAdapter_SendSteamLogsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendSteamLogsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendSteamLogsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status_code = 0;
            r101.message = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.status_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.message = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SendSteamLogsResponse r100) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r100.status_code) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.message)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendSteamLogsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendSteamLogsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendSteamLogsResponse r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.status_code);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.message);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendSteamLogsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendSteamLogsResponse r100 = new ProtoAdapter_SendSteamLogsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status_code = this.status_code;
        r100.message = this.message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendSteamLogsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendSteamLogsResponse(Integer r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SendSteamLogsResponse(Integer r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.status_code = r100;
        this.message = r101;
    }
}
