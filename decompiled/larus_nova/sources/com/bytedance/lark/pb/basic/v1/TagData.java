package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TagData extends com.squareup.wire.Message<TagData, Builder> {
    public static final ProtoAdapter<TagData> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TagDataItem> tag_data_items;

    public static final class Builder extends com.squareup.wire.Message.Builder<TagData, Builder> {
        public List<TagDataItem> tag_data_items;

        @Override // com.squareup.wire.Message.Builder
        public TagData build() {
            return new TagData(this.tag_data_items, super.buildUnknownFields());
        }

        public Builder() {
            this.tag_data_items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder tag_data_items(List<TagDataItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.tag_data_items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TagData extends ProtoAdapter<TagData> {
        public ProtoAdapter_TagData() {
            super(FieldEncoding.LENGTH_DELIMITED, TagData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TagData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.tag_data_items.add(TagDataItem.ADAPTER.decode(r100));
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
        public int encodedSize2(TagData r100) {
            return TagDataItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.tag_data_items) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TagData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TagData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TagData r101) throws IOException {
            TagDataItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.tag_data_items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TagData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TagDataItem extends com.squareup.wire.Message<TagDataItem, Builder> {
        public static final ProtoAdapter<TagDataItem> ADAPTER = null;
        public static final Integer DEFAULT_PRIORITY = null;
        public static final RequestTagTypeEnum DEFAULT_REQ_TAG_TYPE = null;
        public static final ResponseTagTypeEnum DEFAULT_RESP_TAG_TYPE = null;
        public static final String DEFAULT_TAG_ID = "";
        public static final String DEFAULT_TEXT_VAL = "";
        private static final long serialVersionUID = 0;
        public final Integer priority;
        public final RequestTagTypeEnum req_tag_type;
        public final ResponseTagTypeEnum resp_tag_type;
        public final String tag_id;
        public final String text_val;

        public static final class Builder extends com.squareup.wire.Message.Builder<TagDataItem, Builder> {
            public Integer priority;
            public RequestTagTypeEnum req_tag_type;
            public ResponseTagTypeEnum resp_tag_type;
            public String tag_id;
            public String text_val;

            @Override // com.squareup.wire.Message.Builder
            public TagDataItem build() {
                return new TagDataItem(this.text_val, this.tag_id, this.req_tag_type, this.resp_tag_type, this.priority, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder priority(Integer r100) {
                this.priority = r100;
                return this;
            }

            public Builder req_tag_type(RequestTagTypeEnum r100) {
                this.req_tag_type = r100;
                return this;
            }

            public Builder resp_tag_type(ResponseTagTypeEnum r100) {
                this.resp_tag_type = r100;
                return this;
            }

            public Builder tag_id(String r100) {
                this.tag_id = r100;
                return this;
            }

            public Builder text_val(String r100) {
                this.text_val = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TagDataItem extends ProtoAdapter<TagDataItem> {
            public ProtoAdapter_TagDataItem() {
                super(FieldEncoding.LENGTH_DELIMITED, TagDataItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TagDataItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.text_val = "";
                r101.tag_id = "";
                r101.req_tag_type = RequestTagTypeEnum.UNKNOWN_TAG_TYPE;
                r101.resp_tag_type = ResponseTagTypeEnum.RELATION_TAG_UNSET;
                r101.priority = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L27;
                if (r103 != 1) goto L8;
                r101.text_val = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.tag_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.req_tag_type = RequestTagTypeEnum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.resp_tag_type = ResponseTagTypeEnum.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.priority = ProtoAdapter.INT32.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L27:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TagDataItem r100) {
                String r101 = r100.text_val;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.tag_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                RequestTagTypeEnum r107 = r100.req_tag_type;
                if (r107 == null) goto L13;
                int r108 = RequestTagTypeEnum.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                ResponseTagTypeEnum r110 = r100.resp_tag_type;
                if (r110 == null) goto L17;
                int r111 = ResponseTagTypeEnum.ADAPTER.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Integer r113 = r100.priority;
                if (r113 == null) goto L22;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
            L22:
                return (r112 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ TagDataItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TagDataItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TagDataItem r101) throws IOException {
                String r102 = r101.text_val;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.tag_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                RequestTagTypeEnum r104 = r101.req_tag_type;
                if (r104 == null) goto L11;
                RequestTagTypeEnum.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                ResponseTagTypeEnum r105 = r101.resp_tag_type;
                if (r105 == null) goto L14;
                ResponseTagTypeEnum.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                Integer r106 = r101.priority;
                if (r106 == null) goto L17;
                ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TagDataItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TagDataItem();
            DEFAULT_REQ_TAG_TYPE = RequestTagTypeEnum.UNKNOWN_TAG_TYPE;
            DEFAULT_RESP_TAG_TYPE = ResponseTagTypeEnum.RELATION_TAG_UNSET;
            DEFAULT_PRIORITY = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.text_val = this.text_val;
            r100.tag_id = this.tag_id;
            r100.req_tag_type = this.req_tag_type;
            r100.resp_tag_type = this.resp_tag_type;
            r100.priority = this.priority;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TagDataItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TagDataItem(String r100, String r101, RequestTagTypeEnum r110, ResponseTagTypeEnum r111, Integer r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public TagDataItem(String r100, String r101, RequestTagTypeEnum r102, ResponseTagTypeEnum r103, Integer r104, ByteString r105) {
            super(ADAPTER, r105);
            this.text_val = r100;
            this.tag_id = r101;
            this.req_tag_type = r102;
            this.resp_tag_type = r103;
            this.priority = r104;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TagData();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tag_data_items = Internal.copyOf("tag_data_items", this.tag_data_items);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TagData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TagData(List<TagDataItem> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TagData(List<TagDataItem> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.tag_data_items = Internal.immutableCopyOf("tag_data_items", r100);
    }
}
