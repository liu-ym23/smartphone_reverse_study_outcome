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
public final class UserConfirmRequest extends Message<UserConfirmRequest, Builder> {
    public static final ProtoAdapter<UserConfirmRequest> ADAPTER = null;
    public static final String DEFAULT_USER_CONFIRM_PARAMS = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_UserConfirmRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String user_confirm_params;

    public static final class Builder extends Message.Builder<UserConfirmRequest, Builder> implements d<UserConfirmRequest> {
        public String user_confirm_params;

        @Override // com.squareup.wire.Message.Builder
        public UserConfirmRequest build() {
            String r100 = this.user_confirm_params;
            if (r100 == null) goto L7;
            return new UserConfirmRequest(this.user_confirm_params, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_confirm_params"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder user_confirm_params(String r100) {
            this.user_confirm_params = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserConfirmRequest extends ProtoAdapter<UserConfirmRequest> implements c<UserConfirmRequest> {
        public ProtoAdapter_UserConfirmRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UserConfirmRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserConfirmRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_confirm_params = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.user_confirm_params = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UserConfirmRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.user_confirm_params) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserConfirmRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserConfirmRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserConfirmRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.user_confirm_params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserConfirmRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UserConfirmRequest r100 = new ProtoAdapter_UserConfirmRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_confirm_params = this.user_confirm_params;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserConfirmRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserConfirmRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public UserConfirmRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.user_confirm_params = r100;
    }
}
