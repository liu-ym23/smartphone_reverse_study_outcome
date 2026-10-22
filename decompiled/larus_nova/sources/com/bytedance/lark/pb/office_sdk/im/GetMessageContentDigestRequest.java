package com.bytedance.lark.pb.office_sdk.im;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class GetMessageContentDigestRequest extends Message<GetMessageContentDigestRequest, Builder> {
    public static final ProtoAdapter<GetMessageContentDigestRequest> ADAPTER = null;
    public static final ByteString DEFAULT_MESSAGE_CONTENT = null;
    private static final long serialVersionUID = 0;
    public final ByteString message_content;

    public static final class Builder extends Message.Builder<GetMessageContentDigestRequest, Builder> {
        public ByteString message_content;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageContentDigestRequest build() {
            return new GetMessageContentDigestRequest(this.message_content, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_content(ByteString r100) {
            this.message_content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageContentDigestRequest extends ProtoAdapter<GetMessageContentDigestRequest> {
        public ProtoAdapter_GetMessageContentDigestRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageContentDigestRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageContentDigestRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_content = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.message_content = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(GetMessageContentDigestRequest r100) {
            ByteString r101 = r100.message_content;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetMessageContentDigestRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageContentDigestRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageContentDigestRequest r101) throws IOException {
            ByteString r102 = r101.message_content;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageContentDigestRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetMessageContentDigestRequest();
        DEFAULT_MESSAGE_CONTENT = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_content = this.message_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageContentDigestRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageContentDigestRequest(ByteString r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetMessageContentDigestRequest(ByteString r100, ByteString r101) {
        super(ADAPTER, r101);
        this.message_content = r100;
    }
}
