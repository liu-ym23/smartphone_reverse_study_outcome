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
public final class BitableMainUpdateAddRecordPageRequest extends Message<BitableMainUpdateAddRecordPageRequest, Builder> {
    public static final ProtoAdapter<BitableMainUpdateAddRecordPageRequest> ADAPTER = null;
    public static final String DEFAULT_BLOCK_ID = "";
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final String DEFAULT_DATA = "";
    public static final Integer DEFAULT_TABLE_REV = null;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_VIEW_ID = "";
    public static final ProtoAdapter_BitableMainUpdateAddRecordPageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String block_id;
    public final String container_id;
    public final String data;
    public final Integer table_rev;
    public final String token;
    public final String view_id;

    public static final class Builder extends Message.Builder<BitableMainUpdateAddRecordPageRequest, Builder> implements d<BitableMainUpdateAddRecordPageRequest> {
        public String block_id;
        public String container_id;
        public String data;
        public Integer table_rev;
        public String token;
        public String view_id;

        @Override // com.squareup.wire.Message.Builder
        public BitableMainUpdateAddRecordPageRequest build() {
            return new BitableMainUpdateAddRecordPageRequest(this.container_id, this.token, this.block_id, this.view_id, this.table_rev, this.data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder block_id(String r100) {
            this.block_id = r100;
            return this;
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
        }

        public Builder data(String r100) {
            this.data = r100;
            return this;
        }

        public Builder table_rev(Integer r100) {
            this.table_rev = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder view_id(String r100) {
            this.view_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableMainUpdateAddRecordPageRequest extends ProtoAdapter<BitableMainUpdateAddRecordPageRequest> implements c<BitableMainUpdateAddRecordPageRequest> {
        public ProtoAdapter_BitableMainUpdateAddRecordPageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableMainUpdateAddRecordPageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BitableMainUpdateAddRecordPageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_id = "";
            r101.token = "";
            r101.block_id = "";
            r101.view_id = "";
            r101.table_rev = 0;
            r101.data = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.table_rev = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.view_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.block_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.container_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BitableMainUpdateAddRecordPageRequest r100) {
            String r101 = r100.container_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.token;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.block_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.view_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.table_rev;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.data;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableMainUpdateAddRecordPageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableMainUpdateAddRecordPageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableMainUpdateAddRecordPageRequest r101) throws IOException {
            String r102 = r101.container_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.block_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.view_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.table_rev;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.data;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableMainUpdateAddRecordPageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_BitableMainUpdateAddRecordPageRequest r100 = new ProtoAdapter_BitableMainUpdateAddRecordPageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TABLE_REV = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_id = this.container_id;
        r100.token = this.token;
        r100.block_id = this.block_id;
        r100.view_id = this.view_id;
        r100.table_rev = this.table_rev;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableMainUpdateAddRecordPageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableMainUpdateAddRecordPageRequest(String r100, String r110, String r111, String r112, Integer r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public BitableMainUpdateAddRecordPageRequest(String r100, String r101, String r102, String r103, Integer r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.container_id = r100;
        this.token = r101;
        this.block_id = r102;
        this.view_id = r103;
        this.table_rev = r104;
        this.data = r105;
    }
}
