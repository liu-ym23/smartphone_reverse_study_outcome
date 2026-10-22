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
public final class GetHongbaoRecvDetailRequest extends Message<GetHongbaoRecvDetailRequest, Builder> {
    public static final ProtoAdapter<GetHongbaoRecvDetailRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_CURSOR = "";
    public static final HongbaoType DEFAULT_HONGBAO_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final ProtoAdapter_GetHongbaoRecvDetailRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer count;
    public final String cursor;
    public final HongbaoType hongbao_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253639id;

    public static final class Builder extends Message.Builder<GetHongbaoRecvDetailRequest, Builder> implements d<GetHongbaoRecvDetailRequest> {
        public Integer count;
        public String cursor;
        public HongbaoType hongbao_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253640id;

        @Override // com.squareup.wire.Message.Builder
        public GetHongbaoRecvDetailRequest build() {
            String r100 = this.f253640id;
            if (r100 == null) goto L7;
            return new GetHongbaoRecvDetailRequest(this.f253640id, this.cursor, this.count, this.hongbao_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder cursor(String r100) {
            this.cursor = r100;
            return this;
        }

        public Builder hongbao_type(HongbaoType r100) {
            this.hongbao_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253640id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetHongbaoRecvDetailRequest extends ProtoAdapter<GetHongbaoRecvDetailRequest> implements c<GetHongbaoRecvDetailRequest> {
        public ProtoAdapter_GetHongbaoRecvDetailRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetHongbaoRecvDetailRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetHongbaoRecvDetailRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253640id = "";
            r101.cursor = "";
            r101.count = 20;
            r101.hongbao_type = HongbaoType.NORMAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.f253640id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.cursor = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.hongbao_type = HongbaoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetHongbaoRecvDetailRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253639id);
            String r103 = r100.cursor;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.count;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            HongbaoType r110 = r100.hongbao_type;
            if (r110 == null) goto L14;
            r104 = HongbaoType.ADAPTER.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetHongbaoRecvDetailRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetHongbaoRecvDetailRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetHongbaoRecvDetailRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253639id);
            String r103 = r101.cursor;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Integer r104 = r101.count;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L8:
            HongbaoType r105 = r101.hongbao_type;
            if (r105 == null) goto L11;
            HongbaoType.ADAPTER.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetHongbaoRecvDetailRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetHongbaoRecvDetailRequest r100 = new ProtoAdapter_GetHongbaoRecvDetailRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_COUNT = 20;
        DEFAULT_HONGBAO_TYPE = HongbaoType.NORMAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253640id = this.f253639id;
        r100.cursor = this.cursor;
        r100.count = this.count;
        r100.hongbao_type = this.hongbao_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetHongbaoRecvDetailRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetHongbaoRecvDetailRequest(String r100, String r101, Integer r102, HongbaoType r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetHongbaoRecvDetailRequest(String r100, String r101, Integer r102, HongbaoType r103, ByteString r104) {
        super(ADAPTER, r104);
        this.f253639id = r100;
        this.cursor = r101;
        this.count = r102;
        this.hongbao_type = r103;
    }
}
