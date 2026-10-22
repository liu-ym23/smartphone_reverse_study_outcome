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
public final class URLPreviewComponents extends com.squareup.wire.Message<URLPreviewComponents, Builder> {
    public static final ProtoAdapter<URLPreviewComponents> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> at_ids;
    public final List<String> button_ids;
    public final Map<String, URLPreviewComponent> elements;
    public final List<String> image_ids;
    public final List<String> richtext_ids;
    public final List<String> root_ids;

    public static final class Builder extends com.squareup.wire.Message.Builder<URLPreviewComponents, Builder> {
        public List<String> at_ids;
        public List<String> button_ids;
        public Map<String, URLPreviewComponent> elements;
        public List<String> image_ids;
        public List<String> richtext_ids;
        public List<String> root_ids;

        @Override // com.squareup.wire.Message.Builder
        public URLPreviewComponents build() {
            return new URLPreviewComponents(this.root_ids, this.elements, this.image_ids, this.at_ids, this.button_ids, this.richtext_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.root_ids = Internal.newMutableList();
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

        public Builder root_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.root_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_URLPreviewComponents extends ProtoAdapter<URLPreviewComponents> {
        private final ProtoAdapter<Map<String, URLPreviewComponent>> elements;

        public ProtoAdapter_URLPreviewComponents() {
            super(FieldEncoding.LENGTH_DELIMITED, URLPreviewComponents.class);
            this.elements = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, URLPreviewComponent.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public URLPreviewComponents decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
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
            r101.richtext_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.button_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.at_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.image_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.elements.putAll(this.elements.decode(r100));
            goto L3
        L12:
            r101.root_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(URLPreviewComponents r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((((r101.asRepeated().encodedSizeWithTag(1, r100.root_ids) + this.elements.encodedSizeWithTag(2, r100.elements)) + r101.asRepeated().encodedSizeWithTag(3, r100.image_ids)) + r101.asRepeated().encodedSizeWithTag(4, r100.at_ids)) + r101.asRepeated().encodedSizeWithTag(5, r100.button_ids)) + r101.asRepeated().encodedSizeWithTag(6, r100.richtext_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ URLPreviewComponents decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(URLPreviewComponents r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, URLPreviewComponents r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.root_ids);
            this.elements.encodeWithTag(r100, 2, r101.elements);
            r102.asRepeated().encodeWithTag(r100, 3, r101.image_ids);
            r102.asRepeated().encodeWithTag(r100, 4, r101.at_ids);
            r102.asRepeated().encodeWithTag(r100, 5, r101.button_ids);
            r102.asRepeated().encodeWithTag(r100, 6, r101.richtext_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLPreviewComponents r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URLPreviewComponents();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.root_ids = Internal.copyOf("root_ids", this.root_ids);
        r100.elements = Internal.copyOf(SlcElement.KEY_ELEMENTS, this.elements);
        r100.image_ids = Internal.copyOf("image_ids", this.image_ids);
        r100.at_ids = Internal.copyOf("at_ids", this.at_ids);
        r100.button_ids = Internal.copyOf("button_ids", this.button_ids);
        r100.richtext_ids = Internal.copyOf("richtext_ids", this.richtext_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return URLPreviewComponents.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public URLPreviewComponents(List<String> r100, Map<String, URLPreviewComponent> r110, List<String> r111, List<String> r112, List<String> r113, List<String> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public URLPreviewComponents(List<String> r100, Map<String, URLPreviewComponent> r101, List<String> r102, List<String> r103, List<String> r104, List<String> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.root_ids = Internal.immutableCopyOf("root_ids", r100);
        this.elements = Internal.immutableCopyOf(SlcElement.KEY_ELEMENTS, r101);
        this.image_ids = Internal.immutableCopyOf("image_ids", r102);
        this.at_ids = Internal.immutableCopyOf("at_ids", r103);
        this.button_ids = Internal.immutableCopyOf("button_ids", r104);
        this.richtext_ids = Internal.immutableCopyOf("richtext_ids", r105);
    }
}
