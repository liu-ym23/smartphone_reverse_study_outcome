package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class URLPreviewTemplate extends com.squareup.wire.Message<URLPreviewTemplate, Builder> {
    public static final ProtoAdapter<URLPreviewTemplate> ADAPTER = null;
    public static final Long DEFAULT_EXPIRES = null;
    public static final String DEFAULT_ROOT_COMPONENT_ID = "";
    public static final String DEFAULT_TEMPLATE_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> at_ids;
    public final List<String> button_ids;
    public final Map<String, URLPreviewComponent> elements;
    public final Long expires;
    public final List<String> image_ids;
    public final List<String> richtext_ids;
    public final String root_component_id;
    public final String template_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<URLPreviewTemplate, Builder> {
        public List<String> at_ids;
        public List<String> button_ids;
        public Map<String, URLPreviewComponent> elements;
        public Long expires;
        public List<String> image_ids;
        public List<String> richtext_ids;
        public String root_component_id;
        public String template_id;

        @Override // com.squareup.wire.Message.Builder
        public URLPreviewTemplate build() {
            return new URLPreviewTemplate(this.template_id, this.root_component_id, this.elements, this.image_ids, this.at_ids, this.button_ids, this.richtext_ids, this.expires, super.buildUnknownFields());
        }

        public Builder() {
            this.elements = Internal.newMutableMap();
            this.image_ids = Internal.newMutableList();
            this.at_ids = Internal.newMutableList();
            this.button_ids = Internal.newMutableList();
            this.richtext_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder at_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_ids = r100;
            return this;
        }

        public Builder button_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.button_ids = r100;
            return this;
        }

        public Builder elements(Map<String, URLPreviewComponent> r100) {
            Internal.checkElementsNotNull(r100);
            this.elements = r100;
            return this;
        }

        public Builder expires(Long r100) {
            this.expires = r100;
            return this;
        }

        public Builder image_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_ids = r100;
            return this;
        }

        public Builder richtext_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.richtext_ids = r100;
            return this;
        }

        public Builder root_component_id(String r100) {
            this.root_component_id = r100;
            return this;
        }

        public Builder template_id(String r100) {
            this.template_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_URLPreviewTemplate extends ProtoAdapter<URLPreviewTemplate> {
        private final ProtoAdapter<Map<String, URLPreviewComponent>> elements;

        public ProtoAdapter_URLPreviewTemplate() {
            super(FieldEncoding.LENGTH_DELIMITED, URLPreviewTemplate.class);
            this.elements = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, URLPreviewComponent.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public URLPreviewTemplate decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.template_id = "";
            r101.root_component_id = "";
            r101.expires = 0L;
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
            r101.expires = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.richtext_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.button_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.at_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.image_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.elements.putAll(this.elements.decode(r100));
            goto L3
        L13:
            r101.root_component_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.template_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(URLPreviewTemplate r100) {
            String r101 = r100.template_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.root_component_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + this.elements.encodedSizeWithTag(3, r100.elements);
            ProtoAdapter<String> r107 = ProtoAdapter.STRING;
            int r108 = (((r106 + r107.asRepeated().encodedSizeWithTag(4, r100.image_ids)) + r107.asRepeated().encodedSizeWithTag(5, r100.at_ids)) + r107.asRepeated().encodedSizeWithTag(6, r100.button_ids)) + r107.asRepeated().encodedSizeWithTag(7, r100.richtext_ids);
            Long r109 = r100.expires;
            if (r109 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(8, r109);
        L14:
            return (r108 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ URLPreviewTemplate decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(URLPreviewTemplate r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, URLPreviewTemplate r101) throws IOException {
            String r102 = r101.template_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.root_component_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            this.elements.encodeWithTag(r100, 3, r101.elements);
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            r104.asRepeated().encodeWithTag(r100, 4, r101.image_ids);
            r104.asRepeated().encodeWithTag(r100, 5, r101.at_ids);
            r104.asRepeated().encodeWithTag(r100, 6, r101.button_ids);
            r104.asRepeated().encodeWithTag(r100, 7, r101.richtext_ids);
            Long r105 = r101.expires;
            if (r105 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLPreviewTemplate r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URLPreviewTemplate();
        DEFAULT_EXPIRES = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.template_id = this.template_id;
        r100.root_component_id = this.root_component_id;
        r100.elements = Internal.copyOf(SlcElement.KEY_ELEMENTS, this.elements);
        r100.image_ids = Internal.copyOf("image_ids", this.image_ids);
        r100.at_ids = Internal.copyOf("at_ids", this.at_ids);
        r100.button_ids = Internal.copyOf("button_ids", this.button_ids);
        r100.richtext_ids = Internal.copyOf("richtext_ids", this.richtext_ids);
        r100.expires = this.expires;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return URLPreviewTemplate.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public URLPreviewTemplate(String r110, String r111, Map<String, URLPreviewComponent> r112, List<String> r113, List<String> r114, List<String> r115, List<String> r116, Long r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public URLPreviewTemplate(String r100, String r101, Map<String, URLPreviewComponent> r102, List<String> r103, List<String> r104, List<String> r105, List<String> r106, Long r107, ByteString r110) {
        super(ADAPTER, r110);
        this.template_id = r100;
        this.root_component_id = r101;
        this.elements = Internal.immutableCopyOf(SlcElement.KEY_ELEMENTS, r102);
        this.image_ids = Internal.immutableCopyOf("image_ids", r103);
        this.at_ids = Internal.immutableCopyOf("at_ids", r104);
        this.button_ids = Internal.immutableCopyOf("button_ids", r105);
        this.richtext_ids = Internal.immutableCopyOf("richtext_ids", r106);
        this.expires = r107;
    }
}
