package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetDecryptedContentRequest extends Message<GetDecryptedContentRequest, Builder> {
    public static final ProtoAdapter<GetDecryptedContentRequest> ADAPTER = null;
    public static final ProtoAdapter_GetDecryptedContentRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> decrypted_tokens;

    public static final class Builder extends Message.Builder<GetDecryptedContentRequest, Builder> implements d<GetDecryptedContentRequest> {
        public List<String> decrypted_tokens;

        @Override // com.squareup.wire.Message.Builder
        public GetDecryptedContentRequest build() {
            return new GetDecryptedContentRequest(this.decrypted_tokens, super.buildUnknownFields());
        }

        public Builder() {
            this.decrypted_tokens = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder decrypted_tokens(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.decrypted_tokens = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDecryptedContentRequest extends ProtoAdapter<GetDecryptedContentRequest> implements c<GetDecryptedContentRequest> {
        public ProtoAdapter_GetDecryptedContentRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDecryptedContentRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDecryptedContentRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.decrypted_tokens.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetDecryptedContentRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.decrypted_tokens) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDecryptedContentRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDecryptedContentRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDecryptedContentRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.decrypted_tokens);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDecryptedContentRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDecryptedContentRequest r100 = new ProtoAdapter_GetDecryptedContentRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.decrypted_tokens = Internal.copyOf("decrypted_tokens", this.decrypted_tokens);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDecryptedContentRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDecryptedContentRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetDecryptedContentRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.decrypted_tokens = Internal.immutableCopyOf("decrypted_tokens", r100);
    }
}
