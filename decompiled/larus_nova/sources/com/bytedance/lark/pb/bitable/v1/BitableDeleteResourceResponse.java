package com.bytedance.lark.pb.bitable.v1;

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
public final class BitableDeleteResourceResponse extends Message<BitableDeleteResourceResponse, Builder> {
    public static final ProtoAdapter<BitableDeleteResourceResponse> ADAPTER = null;
    public static final Integer DEFAULT_DELETE_SIZE = null;
    public static final ProtoAdapter_BitableDeleteResourceResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer delete_size;

    public static final class Builder extends Message.Builder<BitableDeleteResourceResponse, Builder> implements d<BitableDeleteResourceResponse> {
        public Integer delete_size;

        @Override // com.squareup.wire.Message.Builder
        public BitableDeleteResourceResponse build() {
            return new BitableDeleteResourceResponse(this.delete_size, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder delete_size(Integer r100) {
            this.delete_size = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableDeleteResourceResponse extends ProtoAdapter<BitableDeleteResourceResponse> implements c<BitableDeleteResourceResponse> {
        public ProtoAdapter_BitableDeleteResourceResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableDeleteResourceResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BitableDeleteResourceResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.delete_size = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.delete_size = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(BitableDeleteResourceResponse r100) {
            Integer r101 = r100.delete_size;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableDeleteResourceResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableDeleteResourceResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableDeleteResourceResponse r101) throws IOException {
            Integer r102 = r101.delete_size;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableDeleteResourceResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_BitableDeleteResourceResponse r100 = new ProtoAdapter_BitableDeleteResourceResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DELETE_SIZE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.delete_size = this.delete_size;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableDeleteResourceResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableDeleteResourceResponse(Integer r100) {
        this(r100, ByteString.EMPTY);
    }

    public BitableDeleteResourceResponse(Integer r100, ByteString r101) {
        super(ADAPTER, r101);
        this.delete_size = r100;
    }
}
