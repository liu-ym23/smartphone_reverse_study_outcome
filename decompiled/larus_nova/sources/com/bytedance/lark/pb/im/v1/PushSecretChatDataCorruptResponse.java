package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ErrorCode;
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
public final class PushSecretChatDataCorruptResponse extends Message<PushSecretChatDataCorruptResponse, Builder> {
    public static final ProtoAdapter<PushSecretChatDataCorruptResponse> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final ErrorCode DEFAULT_ERROR_CODE = null;
    public static final ProtoAdapter_PushSecretChatDataCorruptResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final ErrorCode error_code;

    public static final class Builder extends Message.Builder<PushSecretChatDataCorruptResponse, Builder> implements d<PushSecretChatDataCorruptResponse> {
        public Long chat_id;
        public ErrorCode error_code;

        @Override // com.squareup.wire.Message.Builder
        public PushSecretChatDataCorruptResponse build() {
            return new PushSecretChatDataCorruptResponse(this.chat_id, this.error_code, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder error_code(ErrorCode r100) {
            this.error_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushSecretChatDataCorruptResponse extends ProtoAdapter<PushSecretChatDataCorruptResponse> implements c<PushSecretChatDataCorruptResponse> {
        public ProtoAdapter_PushSecretChatDataCorruptResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushSecretChatDataCorruptResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushSecretChatDataCorruptResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            r101.error_code = ErrorCode.General;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.error_code = ErrorCode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(PushSecretChatDataCorruptResponse r100) {
            Long r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ErrorCode r104 = r100.error_code;
            if (r104 == null) goto L10;
            r102 = ErrorCode.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushSecretChatDataCorruptResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushSecretChatDataCorruptResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushSecretChatDataCorruptResponse r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ErrorCode r103 = r101.error_code;
            if (r103 == null) goto L8;
            ErrorCode.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushSecretChatDataCorruptResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushSecretChatDataCorruptResponse r100 = new ProtoAdapter_PushSecretChatDataCorruptResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_ERROR_CODE = ErrorCode.General;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.error_code = this.error_code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushSecretChatDataCorruptResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushSecretChatDataCorruptResponse(Long r100, ErrorCode r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushSecretChatDataCorruptResponse(Long r100, ErrorCode r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chat_id = r100;
        this.error_code = r101;
    }
}
