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
public final class SetAccessTokenOnlyRequest extends Message<SetAccessTokenOnlyRequest, Builder> {
    public static final ProtoAdapter<SetAccessTokenOnlyRequest> ADAPTER = null;
    public static final String DEFAULT_ACCESS_TOKEN = "";
    public static final String DEFAULT_USER_ID = "";
    public static final ProtoAdapter_SetAccessTokenOnlyRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String access_token;
    public final String user_id;

    public static final class Builder extends Message.Builder<SetAccessTokenOnlyRequest, Builder> implements b<SetAccessTokenOnlyRequest> {
        public String access_token;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public SetAccessTokenOnlyRequest build() {
            String r100 = this.access_token;
            if (r100 == null) goto L7;
            return new SetAccessTokenOnlyRequest(this.access_token, this.user_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "access_token"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder access_token(String r100) {
            this.access_token = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetAccessTokenOnlyRequest extends ProtoAdapter<SetAccessTokenOnlyRequest> implements a<SetAccessTokenOnlyRequest> {
        public ProtoAdapter_SetAccessTokenOnlyRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetAccessTokenOnlyRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetAccessTokenOnlyRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.access_token = "";
            r101.user_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.access_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SetAccessTokenOnlyRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.access_token);
            String r103 = r100.user_id;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(2, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetAccessTokenOnlyRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetAccessTokenOnlyRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetAccessTokenOnlyRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.access_token);
            String r103 = r101.user_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetAccessTokenOnlyRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetAccessTokenOnlyRequest r100 = new ProtoAdapter_SetAccessTokenOnlyRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.access_token = this.access_token;
        r100.user_id = this.user_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetAccessTokenOnlyRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetAccessTokenOnlyRequest(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SetAccessTokenOnlyRequest(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.access_token = r100;
        this.user_id = r101;
    }
}
