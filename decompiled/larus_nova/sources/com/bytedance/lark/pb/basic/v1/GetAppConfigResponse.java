package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetAppConfigResponse extends com.squareup.wire.Message<GetAppConfigResponse, Builder> {
    public static final ProtoAdapter<GetAppConfigResponse> ADAPTER = null;
    public static final ProtoAdapter_GetAppConfigResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AppConfig app_config;

    public static final class Builder extends com.squareup.wire.Message.Builder<GetAppConfigResponse, Builder> implements d<GetAppConfigResponse> {
        public AppConfig app_config;

        @Override // com.squareup.wire.Message.Builder
        public GetAppConfigResponse build() {
            return new GetAppConfigResponse(this.app_config, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder app_config(AppConfig r100) {
            this.app_config = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAppConfigResponse extends ProtoAdapter<GetAppConfigResponse> implements c<GetAppConfigResponse> {
        public ProtoAdapter_GetAppConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAppConfigResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAppConfigResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.app_config = AppConfig.ADAPTER.decode(r100);
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
        public int encodedSize2(GetAppConfigResponse r100) {
            AppConfig r101 = r100.app_config;
            if (r101 == null) goto L5;
            int r102 = AppConfig.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAppConfigResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAppConfigResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAppConfigResponse r101) throws IOException {
            AppConfig r102 = r101.app_config;
            if (r102 == null) goto L5;
            AppConfig.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAppConfigResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAppConfigResponse r100 = new ProtoAdapter_GetAppConfigResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_config = this.app_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAppConfigResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAppConfigResponse(AppConfig r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetAppConfigResponse(AppConfig r100, ByteString r101) {
        super(ADAPTER, r101);
        this.app_config = r100;
    }
}
