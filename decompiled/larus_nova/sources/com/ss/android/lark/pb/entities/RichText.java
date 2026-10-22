package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class RichText extends com.squareup.wire.Message<RichText, Builder> {
    public static final ProtoAdapter<RichText> ADAPTER = null;
    public static final String DEFAULT_INNER_TEXT = "";
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<String> manchor_ids;
    public final List<String> mat_ids;
    public final List<String> mat_user_group_ids;
    public final List<String> mdocs_ids;
    public final List<String> melement_ids;
    public final RichTextElements melements;
    public final List<String> mi18n_ids;
    public final List<String> mimage_ids;
    public final String minner_text;
    public final List<String> minteractive_ids;
    public final List<String> mmarkdown_ids;
    public final List<String> mmedia_ids;
    public final List<String> mmention_ids;
    public final Integer mversion;

    public static final class Builder extends com.squareup.wire.Message.Builder<RichText, Builder> {
        public List<String> manchor_ids;
        public List<String> mat_ids;
        public List<String> mat_user_group_ids;
        public List<String> mdocs_ids;
        public List<String> melement_ids;
        public RichTextElements melements;
        public List<String> mi18n_ids;
        public List<String> mimage_ids;
        public String minner_text;
        public List<String> minteractive_ids;
        public List<String> mmarkdown_ids;
        public List<String> mmedia_ids;
        public List<String> mmention_ids;
        public Integer mversion;

        @Override // com.squareup.wire.Message.Builder
        public RichText build() {
            String r100 = this.minner_text;
            if (r100 == null) goto L9;
            if (this.melements == null) goto L9;
            return new RichText(this.melement_ids, this.minner_text, this.melements, this.mimage_ids, this.mat_ids, this.manchor_ids, this.mi18n_ids, this.mmedia_ids, this.mdocs_ids, this.minteractive_ids, this.mmention_ids, this.mversion, this.mat_user_group_ids, this.mmarkdown_ids, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "minner_text", this.melements, "melements"});
        }

        public Builder() {
            this.melement_ids = Internal.newMutableList();
            this.mimage_ids = Internal.newMutableList();
            this.mat_ids = Internal.newMutableList();
            this.manchor_ids = Internal.newMutableList();
            this.mi18n_ids = Internal.newMutableList();
            this.mmedia_ids = Internal.newMutableList();
            this.mdocs_ids = Internal.newMutableList();
            this.minteractive_ids = Internal.newMutableList();
            this.mmention_ids = Internal.newMutableList();
            this.mat_user_group_ids = Internal.newMutableList();
            this.mmarkdown_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder anchor_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.manchor_ids = r100;
            return this;
        }

        public Builder at_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mat_ids = r100;
            return this;
        }

        public Builder at_user_group_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mat_user_group_ids = r100;
            return this;
        }

        public Builder docs_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdocs_ids = r100;
            return this;
        }

        public Builder element_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.melement_ids = r100;
            return this;
        }

        public Builder elements(RichTextElements r100) {
            this.melements = r100;
            return this;
        }

        public Builder i18n_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_ids = r100;
            return this;
        }

        public Builder image_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mimage_ids = r100;
            return this;
        }

        public Builder inner_text(String r100) {
            this.minner_text = r100;
            return this;
        }

        public Builder interactive_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.minteractive_ids = r100;
            return this;
        }

        public Builder markdown_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmarkdown_ids = r100;
            return this;
        }

        public Builder media_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmedia_ids = r100;
            return this;
        }

        public Builder mention_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmention_ids = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.mversion = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RichText extends ProtoAdapter<RichText> {
        public ProtoAdapter_RichText() {
            super(FieldEncoding.LENGTH_DELIMITED, RichText.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RichText decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.minner_text = "";
            r101.mversion = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L6;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L7:
            r101.mmarkdown_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.mat_user_group_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.mversion = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.mmention_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.minteractive_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.mdocs_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.mmedia_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            r101.mi18n_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            r101.manchor_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L16:
            r101.mat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.mimage_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L18:
            r101.melements = RichTextElements.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.minner_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.melement_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RichText r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (((((((((r101.asRepeated().encodedSizeWithTag(1, r100.melement_ids) + r101.encodedSizeWithTag(2, r100.minner_text)) + RichTextElements.ADAPTER.encodedSizeWithTag(3, r100.melements)) + r101.asRepeated().encodedSizeWithTag(5, r100.mimage_ids)) + r101.asRepeated().encodedSizeWithTag(6, r100.mat_ids)) + r101.asRepeated().encodedSizeWithTag(7, r100.manchor_ids)) + r101.asRepeated().encodedSizeWithTag(8, r100.mi18n_ids)) + r101.asRepeated().encodedSizeWithTag(9, r100.mmedia_ids)) + r101.asRepeated().encodedSizeWithTag(10, r100.mdocs_ids)) + r101.asRepeated().encodedSizeWithTag(11, r100.minteractive_ids)) + r101.asRepeated().encodedSizeWithTag(12, r100.mmention_ids);
            Integer r103 = r100.mversion;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(13, r103);
        L7:
            return (((r102 + r104) + r101.asRepeated().encodedSizeWithTag(14, r100.mat_user_group_ids)) + r101.asRepeated().encodedSizeWithTag(15, r100.mmarkdown_ids)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
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
            r102.asRepeated().encodeWithTag(r100, 1, r101.melement_ids);
            r102.encodeWithTag(r100, 2, r101.minner_text);
            RichTextElements.ADAPTER.encodeWithTag(r100, 3, r101.melements);
            r102.asRepeated().encodeWithTag(r100, 5, r101.mimage_ids);
            r102.asRepeated().encodeWithTag(r100, 6, r101.mat_ids);
            r102.asRepeated().encodeWithTag(r100, 7, r101.manchor_ids);
            r102.asRepeated().encodeWithTag(r100, 8, r101.mi18n_ids);
            r102.asRepeated().encodeWithTag(r100, 9, r101.mmedia_ids);
            r102.asRepeated().encodeWithTag(r100, 10, r101.mdocs_ids);
            r102.asRepeated().encodeWithTag(r100, 11, r101.minteractive_ids);
            r102.asRepeated().encodeWithTag(r100, 12, r101.mmention_ids);
            Integer r103 = r101.mversion;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 13, r103);
        L5:
            r102.asRepeated().encodeWithTag(r100, 14, r101.mat_user_group_ids);
            r102.asRepeated().encodeWithTag(r100, 15, r101.mmarkdown_ids);
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
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.melement_ids = Internal.copyOf("melement_ids", this.melement_ids);
        r100.minner_text = this.minner_text;
        r100.melements = this.melements;
        r100.mimage_ids = Internal.copyOf("mimage_ids", this.mimage_ids);
        r100.mat_ids = Internal.copyOf("mat_ids", this.mat_ids);
        r100.manchor_ids = Internal.copyOf("manchor_ids", this.manchor_ids);
        r100.mi18n_ids = Internal.copyOf("mi18n_ids", this.mi18n_ids);
        r100.mmedia_ids = Internal.copyOf("mmedia_ids", this.mmedia_ids);
        r100.mdocs_ids = Internal.copyOf("mdocs_ids", this.mdocs_ids);
        r100.minteractive_ids = Internal.copyOf("minteractive_ids", this.minteractive_ids);
        r100.mmention_ids = Internal.copyOf("mmention_ids", this.mmention_ids);
        r100.mversion = this.mversion;
        r100.mat_user_group_ids = Internal.copyOf("mat_user_group_ids", this.mat_user_group_ids);
        r100.mmarkdown_ids = Internal.copyOf("mmarkdown_ids", this.mmarkdown_ids);
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

    public RichText(List<String> r110, String r111, RichTextElements r112, List<String> r210, List<String> r211, List<String> r212, List<String> r213, List<String> r214, List<String> r215, List<String> r216, List<String> r217, Integer r218, List<String> r219, List<String> r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public RichText(List<String> r100, String r101, RichTextElements r102, List<String> r103, List<String> r104, List<String> r105, List<String> r110, List<String> r111, List<String> r112, List<String> r113, List<String> r114, Integer r115, List<String> r116, List<String> r117, ByteString r118) {
        super(ADAPTER, r118);
        this.melement_ids = Internal.immutableCopyOf("melement_ids", r100);
        this.minner_text = r101;
        this.melements = r102;
        this.mimage_ids = Internal.immutableCopyOf("mimage_ids", r103);
        this.mat_ids = Internal.immutableCopyOf("mat_ids", r104);
        this.manchor_ids = Internal.immutableCopyOf("manchor_ids", r105);
        this.mi18n_ids = Internal.immutableCopyOf("mi18n_ids", r110);
        this.mmedia_ids = Internal.immutableCopyOf("mmedia_ids", r111);
        this.mdocs_ids = Internal.immutableCopyOf("mdocs_ids", r112);
        this.minteractive_ids = Internal.immutableCopyOf("minteractive_ids", r113);
        this.mmention_ids = Internal.immutableCopyOf("mmention_ids", r114);
        this.mversion = r115;
        this.mat_user_group_ids = Internal.immutableCopyOf("mat_user_group_ids", r116);
        this.mmarkdown_ids = Internal.immutableCopyOf("mmarkdown_ids", r117);
    }
}
