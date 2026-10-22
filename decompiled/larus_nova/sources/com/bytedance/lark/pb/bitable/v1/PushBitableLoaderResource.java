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
public final class PushBitableLoaderResource extends Message<PushBitableLoaderResource, Builder> {
    public static final ProtoAdapter<PushBitableLoaderResource> ADAPTER = null;
    public static final String DEFAULT_ADD_RECORD_PAGE = "";
    public static final String DEFAULT_BLOCK_ID = "";
    public static final Integer DEFAULT_BLOCK_TYPE = null;
    public static final String DEFAULT_CLIENTVARS = "";
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final String DEFAULT_MAIN_PAGE = "";
    public static final String DEFAULT_RECORD_DATA = "";
    public static final String DEFAULT_VIEW_ID = "";
    public static final ProtoAdapter_PushBitableLoaderResource RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String add_record_page;
    public final String block_id;
    public final Integer block_type;
    public final String clientvars;
    public final String container_id;
    public final String main_page;
    public final String record_data;
    public final String view_id;

    public static final class Builder extends Message.Builder<PushBitableLoaderResource, Builder> implements d<PushBitableLoaderResource> {
        public String add_record_page;
        public String block_id;
        public Integer block_type;
        public String clientvars;
        public String container_id;
        public String main_page;
        public String record_data;
        public String view_id;

        @Override // com.squareup.wire.Message.Builder
        public PushBitableLoaderResource build() {
            return new PushBitableLoaderResource(this.container_id, this.block_id, this.view_id, this.clientvars, this.main_page, this.block_type, this.record_data, this.add_record_page, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder add_record_page(String r100) {
            this.add_record_page = r100;
            return this;
        }

        public Builder block_id(String r100) {
            this.block_id = r100;
            return this;
        }

        public Builder block_type(Integer r100) {
            this.block_type = r100;
            return this;
        }

        public Builder clientvars(String r100) {
            this.clientvars = r100;
            return this;
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
        }

        public Builder main_page(String r100) {
            this.main_page = r100;
            return this;
        }

        public Builder record_data(String r100) {
            this.record_data = r100;
            return this;
        }

        public Builder view_id(String r100) {
            this.view_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushBitableLoaderResource extends ProtoAdapter<PushBitableLoaderResource> implements c<PushBitableLoaderResource> {
        public ProtoAdapter_PushBitableLoaderResource() {
            super(FieldEncoding.LENGTH_DELIMITED, PushBitableLoaderResource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushBitableLoaderResource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_id = "";
            r101.block_id = "";
            r101.view_id = "";
            r101.clientvars = "";
            r101.main_page = "";
            r101.block_type = 0;
            r101.record_data = "";
            r101.add_record_page = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.add_record_page = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.record_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.block_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.main_page = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.clientvars = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.view_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.block_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.container_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushBitableLoaderResource r100) {
            String r101 = r100.container_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.block_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.view_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.clientvars;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.main_page;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.block_type;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.record_data;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.add_record_page;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ PushBitableLoaderResource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushBitableLoaderResource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushBitableLoaderResource r101) throws IOException {
            String r102 = r101.container_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.block_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.view_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.clientvars;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.main_page;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Integer r107 = r101.block_type;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.record_data;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.add_record_page;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushBitableLoaderResource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushBitableLoaderResource r100 = new ProtoAdapter_PushBitableLoaderResource();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_BLOCK_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_id = this.container_id;
        r100.block_id = this.block_id;
        r100.view_id = this.view_id;
        r100.clientvars = this.clientvars;
        r100.main_page = this.main_page;
        r100.block_type = this.block_type;
        r100.record_data = this.record_data;
        r100.add_record_page = this.add_record_page;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushBitableLoaderResource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushBitableLoaderResource(String r110, String r111, String r112, String r113, String r114, Integer r115, String r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public PushBitableLoaderResource(String r100, String r101, String r102, String r103, String r104, Integer r105, String r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.container_id = r100;
        this.block_id = r101;
        this.view_id = r102;
        this.clientvars = r103;
        this.main_page = r104;
        this.block_type = r105;
        this.record_data = r106;
        this.add_record_page = r107;
    }
}
