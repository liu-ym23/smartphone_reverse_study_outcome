package com.bytedance.lark.pb.passport.v1;

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
public final class GetWaterMarkConfigRequest extends Message<GetWaterMarkConfigRequest, Builder> {
    public static final ProtoAdapter<GetWaterMarkConfigRequest> ADAPTER = null;
    public static final Boolean DEFAULT_DEFAULT_CONFIG = null;
    public static final ProtoAdapter_GetWaterMarkConfigRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean default_config;
    public final PointContext point_context;

    public static final class Builder extends Message.Builder<GetWaterMarkConfigRequest, Builder> implements d<GetWaterMarkConfigRequest> {
        public Boolean default_config;
        public PointContext point_context;

        @Override // com.squareup.wire.Message.Builder
        public GetWaterMarkConfigRequest build() {
            return new GetWaterMarkConfigRequest(this.point_context, this.default_config, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder default_config(Boolean r100) {
            this.default_config = r100;
            return this;
        }

        public Builder point_context(PointContext r100) {
            this.point_context = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetWaterMarkConfigRequest extends ProtoAdapter<GetWaterMarkConfigRequest> implements c<GetWaterMarkConfigRequest> {
        public ProtoAdapter_GetWaterMarkConfigRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetWaterMarkConfigRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetWaterMarkConfigRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.default_config = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.point_context = PointContext.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.default_config = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetWaterMarkConfigRequest r100) {
            PointContext r101 = r100.point_context;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = PointContext.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.default_config;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetWaterMarkConfigRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetWaterMarkConfigRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetWaterMarkConfigRequest r101) throws IOException {
            PointContext r102 = r101.point_context;
            if (r102 == null) goto L5;
            PointContext.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.default_config;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetWaterMarkConfigRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetWaterMarkConfigRequest r100 = new ProtoAdapter_GetWaterMarkConfigRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DEFAULT_CONFIG = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.point_context = this.point_context;
        r100.default_config = this.default_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetWaterMarkConfigRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetWaterMarkConfigRequest(PointContext r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetWaterMarkConfigRequest(PointContext r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.point_context = r100;
        this.default_config = r101;
    }
}
