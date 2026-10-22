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
public final class RichText extends com.squareup.wire.Message<RichText, Builder> {
    public static final ProtoAdapter<RichText> ADAPTER = null;
    public static final String DEFAULT_INNER_TEXT = "";
    public static final Integer DEFAULT_RICH_TEXT_VERSION = null;
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<String> anchor_ids;
    public final List<String> at_ids;
    public final List<String> at_user_group_ids;
    public final List<String> docs_ids;
    public final List<String> element_ids;
    public final Map<String, RichTextElement> elements;
    public final List<String> image_ids;
    public final String inner_text;
    public final List<String> markdown_ids;
    public final List<String> media_ids;
    public final List<String> mention_ids;
    public final Integer rich_text_version;
    public final Integer version;

    public static final class Builder extends com.squareup.wire.Message.Builder<RichText, Builder> {
        public List<String> anchor_ids;
        public List<String> at_ids;
        public List<String> at_user_group_ids;
        public List<String> docs_ids;
        public List<String> element_ids;
        public Map<String, RichTextElement> elements;
        public List<String> image_ids;
        public String inner_text;
        public List<String> markdown_ids;
        public List<String> media_ids;
        public List<String> mention_ids;
        public Integer rich_text_version;
        public Integer version;

        @Override // com.squareup.wire.Message.Builder
        public RichText build() {
            String r100 = this.inner_text;
            if (r100 == null) goto L7;
            return new RichText(this.element_ids, this.inner_text, this.elements, this.image_ids, this.at_ids, this.anchor_ids, this.version, this.media_ids, this.docs_ids, this.mention_ids, this.rich_text_version, this.at_user_group_ids, this.markdown_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "inner_text"});
        }

        public Builder() {
            this.element_ids = Internal.newMutableList();
            this.elements = Internal.newMutableMap();
            this.image_ids = Internal.newMutableList();
            this.at_ids = Internal.newMutableList();
            this.anchor_ids = Internal.newMutableList();
            this.media_ids = Internal.newMutableList();
            this.docs_ids = Internal.newMutableList();
            this.mention_ids = Internal.newMutableList();
            this.at_user_group_ids = Internal.newMutableList();
            this.markdown_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder anchor_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.anchor_ids = r100;
            return this;
        }

        public Builder at_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_ids = r100;
            return this;
        }

        public Builder at_user_group_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.at_user_group_ids = r100;
            return this;
        }

        public Builder docs_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.docs_ids = r100;
            return this;
        }

        public Builder element_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.element_ids = r100;
            return this;
        }

        public Builder elements(Map<String, RichTextElement> r100) {
            Internal.checkElementsNotNull(r100);
            this.elements = r100;
            return this;
        }

        public Builder image_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_ids = r100;
            return this;
        }

        public Builder inner_text(String r100) {
            this.inner_text = r100;
            return this;
        }

        public Builder markdown_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.markdown_ids = r100;
            return this;
        }

        public Builder media_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.media_ids = r100;
            return this;
        }

        public Builder mention_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mention_ids = r100;
            return this;
        }

        public Builder rich_text_version(Integer r100) {
            this.rich_text_version = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RichText extends ProtoAdapter<RichText> {
        private final ProtoAdapter<Map<String, RichTextElement>> elements;

        public ProtoAdapter_RichText() {
            super(FieldEncoding.LENGTH_DELIMITED, RichText.class);
            this.elements = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, RichTextElement.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RichText decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.inner_text = "";
            r101.version = 0;
            r101.rich_text_version = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r101.markdown_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.at_user_group_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.rich_text_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.mention_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.docs_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.media_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.anchor_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            r101.at_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L16:
            r101.image_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.elements.putAll(this.elements.decode(r100));
            goto L3
        L18:
            r101.inner_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.element_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RichText r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((((r101.asRepeated().encodedSizeWithTag(1, r100.element_ids) + r101.encodedSizeWithTag(2, r100.inner_text)) + this.elements.encodedSizeWithTag(3, r100.elements)) + r101.asRepeated().encodedSizeWithTag(4, r100.image_ids)) + r101.asRepeated().encodedSizeWithTag(5, r100.at_ids)) + r101.asRepeated().encodedSizeWithTag(6, r100.anchor_ids);
            Integer r103 = r100.version;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(7, r103);
        L6:
            int r106 = (((r102 + r105) + r101.asRepeated().encodedSizeWithTag(8, r100.media_ids)) + r101.asRepeated().encodedSizeWithTag(9, r100.docs_ids)) + r101.asRepeated().encodedSizeWithTag(10, r100.mention_ids);
            Integer r107 = r100.rich_text_version;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(11, r107);
        L10:
            return (((r106 + r104) + r101.asRepeated().encodedSizeWithTag(12, r100.at_user_group_ids)) + r101.asRepeated().encodedSizeWithTag(13, r100.markdown_ids)) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RichText decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RichText r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RichText r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.element_ids);
            r102.encodeWithTag(r100, 2, r101.inner_text);
            this.elements.encodeWithTag(r100, 3, r101.elements);
            r102.asRepeated().encodeWithTag(r100, 4, r101.image_ids);
            r102.asRepeated().encodeWithTag(r100, 5, r101.at_ids);
            r102.asRepeated().encodeWithTag(r100, 6, r101.anchor_ids);
            Integer r103 = r101.version;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r103);
        L5:
            r102.asRepeated().encodeWithTag(r100, 8, r101.media_ids);
            r102.asRepeated().encodeWithTag(r100, 9, r101.docs_ids);
            r102.asRepeated().encodeWithTag(r100, 10, r101.mention_ids);
            Integer r104 = r101.rich_text_version;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r104);
        L8:
            r102.asRepeated().encodeWithTag(r100, 12, r101.at_user_group_ids);
            r102.asRepeated().encodeWithTag(r100, 13, r101.markdown_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RichText r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RichText();
        DEFAULT_VERSION = 0;
        DEFAULT_RICH_TEXT_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.element_ids = Internal.copyOf("element_ids", this.element_ids);
        r100.inner_text = this.inner_text;
        r100.elements = Internal.copyOf(SlcElement.KEY_ELEMENTS, this.elements);
        r100.image_ids = Internal.copyOf("image_ids", this.image_ids);
        r100.at_ids = Internal.copyOf("at_ids", this.at_ids);
        r100.anchor_ids = Internal.copyOf("anchor_ids", this.anchor_ids);
        r100.version = this.version;
        r100.media_ids = Internal.copyOf("media_ids", this.media_ids);
        r100.docs_ids = Internal.copyOf("docs_ids", this.docs_ids);
        r100.mention_ids = Internal.copyOf("mention_ids", this.mention_ids);
        r100.rich_text_version = this.rich_text_version;
        r100.at_user_group_ids = Internal.copyOf("at_user_group_ids", this.at_user_group_ids);
        r100.markdown_ids = Internal.copyOf("markdown_ids", this.markdown_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RichText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public RichText(List<String> r110, String r111, Map<String, RichTextElement> r112, List<String> r113, List<String> r210, List<String> r211, Integer r212, List<String> r213, List<String> r214, List<String> r215, Integer r216, List<String> r217, List<String> r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public RichText(List<String> r100, String r101, Map<String, RichTextElement> r102, List<String> r103, List<String> r104, List<String> r105, Integer r106, List<String> r107, List<String> r110, List<String> r111, Integer r112, List<String> r113, List<String> r114, ByteString r115) {
        super(ADAPTER, r115);
        this.element_ids = Internal.immutableCopyOf("element_ids", r100);
        this.inner_text = r101;
        this.elements = Internal.immutableCopyOf(SlcElement.KEY_ELEMENTS, r102);
        this.image_ids = Internal.immutableCopyOf("image_ids", r103);
        this.at_ids = Internal.immutableCopyOf("at_ids", r104);
        this.anchor_ids = Internal.immutableCopyOf("anchor_ids", r105);
        this.version = r106;
        this.media_ids = Internal.immutableCopyOf("media_ids", r107);
        this.docs_ids = Internal.immutableCopyOf("docs_ids", r110);
        this.mention_ids = Internal.immutableCopyOf("mention_ids", r111);
        this.rich_text_version = r112;
        this.at_user_group_ids = Internal.immutableCopyOf("at_user_group_ids", r113);
        this.markdown_ids = Internal.immutableCopyOf("markdown_ids", r114);
    }
}
