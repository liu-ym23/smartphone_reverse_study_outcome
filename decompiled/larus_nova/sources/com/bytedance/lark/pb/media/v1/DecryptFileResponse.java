package com.bytedance.lark.pb.media.v1;

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
public final class DecryptFileResponse extends Message<DecryptFileResponse, Builder> {
    public static final ProtoAdapter<DecryptFileResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_NOT_ENCRYPTED = null;
    public static final ProtoAdapter_DecryptFileResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_not_encrypted;

    public static final class Builder extends Message.Builder<DecryptFileResponse, Builder> implements d<DecryptFileResponse> {
        public Boolean is_not_encrypted;

        @Override // com.squareup.wire.Message.Builder
        public DecryptFileResponse build() {
            return new DecryptFileResponse(this.is_not_encrypted, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_not_encrypted(Boolean r100) {
            this.is_not_encrypted = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DecryptFileResponse extends ProtoAdapter<DecryptFileResponse> implements c<DecryptFileResponse> {
        public ProtoAdapter_DecryptFileResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DecryptFileResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DecryptFileResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_not_encrypted = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.is_not_encrypted = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(DecryptFileResponse r100) {
            Boolean r101 = r100.is_not_encrypted;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecryptFileResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DecryptFileResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DecryptFileResponse r101) throws IOException {
            Boolean r102 = r101.is_not_encrypted;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DecryptFileResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DecryptFileResponse r100 = new ProtoAdapter_DecryptFileResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_NOT_ENCRYPTED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_not_encrypted = this.is_not_encrypted;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DecryptFileResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DecryptFileResponse(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public DecryptFileResponse(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.is_not_encrypted = r100;
    }
}
