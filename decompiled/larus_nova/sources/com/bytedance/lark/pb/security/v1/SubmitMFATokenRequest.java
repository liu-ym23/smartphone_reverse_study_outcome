package com.bytedance.lark.pb.security.v1;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
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
public final class SubmitMFATokenRequest extends Message<SubmitMFATokenRequest, Builder> {
    public static final ProtoAdapter<SubmitMFATokenRequest> ADAPTER = null;
    public static final String DEFAULT_MFA_PARAMS = "";
    public static final String DEFAULT_MFA_TOKEN = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_SubmitMFATokenRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String mfa_params;
    public final String mfa_token;

    public static final class Builder extends Message.Builder<SubmitMFATokenRequest, Builder> implements d<SubmitMFATokenRequest> {
        public String mfa_params;
        public String mfa_token;

        @Override // com.squareup.wire.Message.Builder
        public SubmitMFATokenRequest build() {
            String r100 = this.mfa_token;
            if (r100 == null) goto L9;
            if (this.mfa_params == null) goto L9;
            return new SubmitMFATokenRequest(this.mfa_token, this.mfa_params, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mfa_token", this.mfa_params, "mfa_params"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder mfa_params(String r100) {
            this.mfa_params = r100;
            return this;
        }

        public Builder mfa_token(String r100) {
            this.mfa_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubmitMFATokenRequest extends ProtoAdapter<SubmitMFATokenRequest> implements c<SubmitMFATokenRequest> {
        public ProtoAdapter_SubmitMFATokenRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubmitMFATokenRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubmitMFATokenRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mfa_token = "";
            r101.mfa_params = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mfa_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mfa_params = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SubmitMFATokenRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.mfa_token) + r101.encodedSizeWithTag(2, r100.mfa_params)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubmitMFATokenRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubmitMFATokenRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubmitMFATokenRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mfa_token);
            r102.encodeWithTag(r100, 2, r101.mfa_params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubmitMFATokenRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SubmitMFATokenRequest r100 = new ProtoAdapter_SubmitMFATokenRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfa_token = this.mfa_token;
        r100.mfa_params = this.mfa_params;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubmitMFATokenRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubmitMFATokenRequest(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SubmitMFATokenRequest(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mfa_token = r100;
        this.mfa_params = r101;
    }
}
