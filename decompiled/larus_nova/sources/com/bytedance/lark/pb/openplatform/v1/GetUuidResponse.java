package com.bytedance.lark.pb.openplatform.v1;

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
public final class GetUuidResponse extends Message<GetUuidResponse, Builder> {
    public static final ProtoAdapter<GetUuidResponse> ADAPTER = null;
    public static final String DEFAULT_UUID = "";
    public static final ProtoAdapter_GetUuidResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String uuid;

    public static final class Builder extends Message.Builder<GetUuidResponse, Builder> implements d<GetUuidResponse> {
        public String uuid;

        @Override // com.squareup.wire.Message.Builder
        public GetUuidResponse build() {
            return new GetUuidResponse(this.uuid, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder uuid(String r100) {
            this.uuid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUuidResponse extends ProtoAdapter<GetUuidResponse> implements c<GetUuidResponse> {
        public ProtoAdapter_GetUuidResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUuidResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUuidResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.uuid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.uuid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetUuidResponse r100) {
            String r101 = r100.uuid;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUuidResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUuidResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUuidResponse r101) throws IOException {
            String r102 = r101.uuid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUuidResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUuidResponse r100 = new ProtoAdapter_GetUuidResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.uuid = this.uuid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUuidResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUuidResponse(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetUuidResponse(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.uuid = r100;
    }
}
