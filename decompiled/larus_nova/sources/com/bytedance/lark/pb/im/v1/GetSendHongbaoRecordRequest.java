package com.bytedance.lark.pb.im.v1;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
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
public final class GetSendHongbaoRecordRequest extends Message<GetSendHongbaoRecordRequest, Builder> {
    public static final ProtoAdapter<GetSendHongbaoRecordRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_CURSOR = "";
    public static final Integer DEFAULT_YEAR = null;
    public static final ProtoAdapter_GetSendHongbaoRecordRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer count;
    public final String cursor;
    public final Integer year;

    public static final class Builder extends Message.Builder<GetSendHongbaoRecordRequest, Builder> implements d<GetSendHongbaoRecordRequest> {
        public Integer count;
        public String cursor;
        public Integer year;

        @Override // com.squareup.wire.Message.Builder
        public GetSendHongbaoRecordRequest build() {
            Integer r100 = this.year;
            if (r100 == null) goto L7;
            return new GetSendHongbaoRecordRequest(this.year, this.cursor, this.count, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR});
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

        public Builder year(Integer r100) {
            this.year = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSendHongbaoRecordRequest extends ProtoAdapter<GetSendHongbaoRecordRequest> implements c<GetSendHongbaoRecordRequest> {
        public ProtoAdapter_GetSendHongbaoRecordRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSendHongbaoRecordRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSendHongbaoRecordRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.year = 0;
            r101.cursor = "";
            r101.count = 20;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.year = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.cursor = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(GetSendHongbaoRecordRequest r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            int r102 = r101.encodedSizeWithTag(1, r100.year);
            String r103 = r100.cursor;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.count;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSendHongbaoRecordRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSendHongbaoRecordRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSendHongbaoRecordRequest r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.year);
            String r103 = r101.cursor;
            if (r103 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L5:
            Integer r104 = r101.count;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSendHongbaoRecordRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetSendHongbaoRecordRequest r100 = new ProtoAdapter_GetSendHongbaoRecordRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_YEAR = 0;
        DEFAULT_COUNT = 20;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.year = this.year;
        r100.cursor = this.cursor;
        r100.count = this.count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSendHongbaoRecordRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSendHongbaoRecordRequest(Integer r100, String r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetSendHongbaoRecordRequest(Integer r100, String r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.year = r100;
        this.cursor = r101;
        this.count = r102;
    }
}
