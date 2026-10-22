package com.bytedance.lark.pb.im.v1;

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
public final class GetHongbaoInfoRequest extends Message<GetHongbaoInfoRequest, Builder> {
    public static final ProtoAdapter<GetHongbaoInfoRequest> ADAPTER = null;
    public static final HongbaoType DEFAULT_HONGBAO_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final ProtoAdapter_GetHongbaoInfoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final HongbaoType hongbao_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253637id;

    public static final class Builder extends Message.Builder<GetHongbaoInfoRequest, Builder> implements d<GetHongbaoInfoRequest> {
        public HongbaoType hongbao_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253638id;

        @Override // com.squareup.wire.Message.Builder
        public GetHongbaoInfoRequest build() {
            String r100 = this.f253638id;
            if (r100 == null) goto L7;
            return new GetHongbaoInfoRequest(this.f253638id, this.hongbao_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder hongbao_type(HongbaoType r100) {
            this.hongbao_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253638id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetHongbaoInfoRequest extends ProtoAdapter<GetHongbaoInfoRequest> implements c<GetHongbaoInfoRequest> {
        public ProtoAdapter_GetHongbaoInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetHongbaoInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetHongbaoInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253638id = "";
            r101.hongbao_type = HongbaoType.NORMAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253638id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.hongbao_type = HongbaoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetHongbaoInfoRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253637id);
            HongbaoType r102 = r100.hongbao_type;
            if (r102 == null) goto L5;
            int r103 = HongbaoType.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetHongbaoInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetHongbaoInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetHongbaoInfoRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253637id);
            HongbaoType r102 = r101.hongbao_type;
            if (r102 == null) goto L5;
            HongbaoType.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetHongbaoInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetHongbaoInfoRequest r100 = new ProtoAdapter_GetHongbaoInfoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HONGBAO_TYPE = HongbaoType.NORMAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253638id = this.f253637id;
        r100.hongbao_type = this.hongbao_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetHongbaoInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetHongbaoInfoRequest(String r100, HongbaoType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetHongbaoInfoRequest(String r100, HongbaoType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f253637id = r100;
        this.hongbao_type = r101;
    }
}
