package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DocEntity extends com.squareup.wire.Message<DocEntity, Builder> {
    public static final ProtoAdapter<DocEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ElementEntity> element_entity_ref;

    public static final class Builder extends com.squareup.wire.Message.Builder<DocEntity, Builder> {
        public Map<String, ElementEntity> element_entity_ref;

        @Override // com.squareup.wire.Message.Builder
        public DocEntity build() {
            return new DocEntity(this.element_entity_ref, super.buildUnknownFields());
        }

        public Builder() {
            this.element_entity_ref = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder element_entity_ref(Map<String, ElementEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.element_entity_ref = r100;
            return this;
        }
    }

    public static final class ElementEntity extends com.squareup.wire.Message<ElementEntity, Builder> {
        public static final ProtoAdapter<ElementEntity> ADAPTER = null;
        public static final Doc.Type DEFAULT_DOC_TYPE = null;
        public static final String DEFAULT_DOC_URL = "";
        public static final String DEFAULT_TITLE = "";
        public static final String DEFAULT_TOKEN = "";
        private static final long serialVersionUID = 0;
        public final Doc.Type doc_type;
        public final String doc_url;
        public final Icon icon;
        public final String title;
        public final String token;

        public static final class Builder extends com.squareup.wire.Message.Builder<ElementEntity, Builder> {
            public Doc.Type doc_type;
            public String doc_url;
            public Icon icon;
            public String title;
            public String token;

            @Override // com.squareup.wire.Message.Builder
            public ElementEntity build() {
                return new ElementEntity(this.title, this.doc_type, this.token, this.doc_url, this.icon, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder doc_type(Doc.Type r100) {
                this.doc_type = r100;
                return this;
            }

            public Builder doc_url(String r100) {
                this.doc_url = r100;
                return this;
            }

            public Builder icon(Icon r100) {
                this.icon = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder token(String r100) {
                this.token = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ElementEntity extends ProtoAdapter<ElementEntity> {
            public ProtoAdapter_ElementEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, ElementEntity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ElementEntity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title = "";
                r101.doc_type = Doc.Type.UNKNOWN;
                r101.token = "";
                r101.doc_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L24;
                if (r103 != 1) goto L8;
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.doc_type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.doc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 5) goto L15;
                r101.icon = Icon.ADAPTER.decode(r100);
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L24:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ElementEntity r100) {
                String r101 = r100.title;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Doc.Type r104 = r100.doc_type;
                if (r104 == null) goto L9;
                int r105 = Doc.Type.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.token;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.doc_url;
                if (r110 == null) goto L17;
                int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                int r112 = r109 + r111;
                Icon r113 = r100.icon;
                if (r113 == null) goto L22;
                r102 = Icon.ADAPTER.encodedSizeWithTag(5, r113);
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
            public /* bridge */ /* synthetic */ ElementEntity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ElementEntity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ElementEntity r101) throws IOException {
                String r102 = r101.title;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Doc.Type r103 = r101.doc_type;
                if (r103 == null) goto L8;
                Doc.Type.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.token;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.doc_url;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                Icon r106 = r101.icon;
                if (r106 == null) goto L17;
                Icon.ADAPTER.encodeWithTag(r100, 5, r106);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ElementEntity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ElementEntity();
            DEFAULT_DOC_TYPE = Doc.Type.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.title = this.title;
            r100.doc_type = this.doc_type;
            r100.token = this.token;
            r100.doc_url = this.doc_url;
            r100.icon = this.icon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ElementEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ElementEntity(String r100, Doc.Type r101, String r110, String r111, Icon r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public ElementEntity(String r100, Doc.Type r101, String r102, String r103, Icon r104, ByteString r105) {
            super(ADAPTER, r105);
            this.title = r100;
            this.doc_type = r101;
            this.token = r102;
            this.doc_url = r103;
            this.icon = r104;
        }
    }

    public static final class ProtoAdapter_DocEntity extends ProtoAdapter<DocEntity> {
        private final ProtoAdapter<Map<String, ElementEntity>> element_entity_ref;

        public ProtoAdapter_DocEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, DocEntity.class);
            this.element_entity_ref = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ElementEntity.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.element_entity_ref.putAll(this.element_entity_ref.decode(r100));
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
        public int encodedSize2(DocEntity r100) {
            return this.element_entity_ref.encodedSizeWithTag(1, r100.element_entity_ref) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DocEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocEntity r101) throws IOException {
            this.element_entity_ref.encodeWithTag(r100, 1, r101.element_entity_ref);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.element_entity_ref = Internal.copyOf("element_entity_ref", this.element_entity_ref);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocEntity(Map<String, ElementEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public DocEntity(Map<String, ElementEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.element_entity_ref = Internal.immutableCopyOf("element_entity_ref", r100);
    }
}
