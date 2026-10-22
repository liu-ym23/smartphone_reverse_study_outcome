package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutMessageLinkResponse extends Message<PutMessageLinkResponse, Builder> {
    public static final ProtoAdapter<PutMessageLinkResponse> ADAPTER = null;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TOKEN_URL = "";
    private static final long serialVersionUID = 0;
    public final String mtoken;
    public final String mtoken_url;

    public static final class Builder extends Message.Builder<PutMessageLinkResponse, Builder> {
        public String mtoken;
        public String mtoken_url;

        @Override // com.squareup.wire.Message.Builder
        public PutMessageLinkResponse build() {
            String r100 = this.mtoken;
            if (r100 == null) goto L9;
            if (this.mtoken_url == null) goto L9;
            return new PutMessageLinkResponse(this.mtoken, this.mtoken_url, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mtoken", this.mtoken_url, "mtoken_url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder token(String r100) {
            this.mtoken = r100;
            return this;
        }

        public Builder token_url(String r100) {
            this.mtoken_url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutMessageLinkResponse extends ProtoAdapter<PutMessageLinkResponse> {
        public ProtoAdapter_PutMessageLinkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutMessageLinkResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutMessageLinkResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtoken = "";
            r101.mtoken_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mtoken = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtoken_url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PutMessageLinkResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.mtoken) + r101.encodedSizeWithTag(2, r100.mtoken_url)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutMessageLinkResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutMessageLinkResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutMessageLinkResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mtoken);
            r102.encodeWithTag(r100, 2, r101.mtoken_url);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutMessageLinkResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutMessageLinkResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtoken = this.mtoken;
        r100.mtoken_url = this.mtoken_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutMessageLinkResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutMessageLinkResponse(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PutMessageLinkResponse(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtoken = r100;
        this.mtoken_url = r101;
    }
}
