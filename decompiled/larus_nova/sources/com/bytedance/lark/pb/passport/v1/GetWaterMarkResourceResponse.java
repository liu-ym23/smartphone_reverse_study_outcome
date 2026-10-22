package com.bytedance.lark.pb.passport.v1;

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
public final class GetWaterMarkResourceResponse extends Message<GetWaterMarkResourceResponse, Builder> {
    public static final ProtoAdapter<GetWaterMarkResourceResponse> ADAPTER = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final String DEFAULT_PATH = "";
    public static final Boolean DEFAULT_SUCCESS = null;
    public static final ProtoAdapter_GetWaterMarkResourceResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteString data;
    public final String path;
    public final Boolean success;

    public static final class Builder extends Message.Builder<GetWaterMarkResourceResponse, Builder> implements d<GetWaterMarkResourceResponse> {
        public ByteString data;
        public String path;
        public Boolean success;

        @Override // com.squareup.wire.Message.Builder
        public GetWaterMarkResourceResponse build() {
            Boolean r100 = this.success;
            if (r100 == null) goto L7;
            return new GetWaterMarkResourceResponse(this.success, this.path, this.data, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "success"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder success(Boolean r100) {
            this.success = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetWaterMarkResourceResponse extends ProtoAdapter<GetWaterMarkResourceResponse> implements c<GetWaterMarkResourceResponse> {
        public ProtoAdapter_GetWaterMarkResourceResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetWaterMarkResourceResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetWaterMarkResourceResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.success = Boolean.FALSE;
            r101.path = "";
            r101.data = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.success = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetWaterMarkResourceResponse r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.success);
            String r102 = r100.path;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            ByteString r106 = r100.data;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetWaterMarkResourceResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetWaterMarkResourceResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetWaterMarkResourceResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.success);
            String r102 = r101.path;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            ByteString r103 = r101.data;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetWaterMarkResourceResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetWaterMarkResourceResponse r100 = new ProtoAdapter_GetWaterMarkResourceResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SUCCESS = Boolean.FALSE;
        DEFAULT_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.success = this.success;
        r100.path = this.path;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetWaterMarkResourceResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetWaterMarkResourceResponse(Boolean r100, String r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetWaterMarkResourceResponse(Boolean r100, String r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.success = r100;
        this.path = r101;
        this.data = r102;
    }
}
