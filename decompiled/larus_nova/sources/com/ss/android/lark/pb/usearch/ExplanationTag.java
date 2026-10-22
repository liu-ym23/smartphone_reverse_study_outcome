package com.ss.android.lark.pb.usearch;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ExplanationTag extends Message<ExplanationTag, Builder> {
    public static final ProtoAdapter<ExplanationTag> ADAPTER = null;
    public static final String DEFAULT_TAG_TYPE = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final TagHover mtag_hover;
    public final TagStyle mtag_style;
    public final String mtag_type;
    public final String mtext;

    public static final class Builder extends Message.Builder<ExplanationTag, Builder> {
        public TagHover mtag_hover;
        public TagStyle mtag_style;
        public String mtag_type;
        public String mtext;

        @Override // com.squareup.wire.Message.Builder
        public ExplanationTag build() {
            return new ExplanationTag(this.mtext, this.mtag_type, this.mtag_style, this.mtag_hover, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder tag_hover(TagHover r100) {
            this.mtag_hover = r100;
            return this;
        }

        public Builder tag_style(TagStyle r100) {
            this.mtag_style = r100;
            return this;
        }

        public Builder tag_type(String r100) {
            this.mtag_type = r100;
            return this;
        }

        public Builder text(String r100) {
            this.mtext = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExplanationTag extends ProtoAdapter<ExplanationTag> {
        public ProtoAdapter_ExplanationTag() {
            super(FieldEncoding.LENGTH_DELIMITED, ExplanationTag.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExplanationTag decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtext = "";
            r101.mtag_type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mtext = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtag_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mtag_style = TagStyle.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mtag_hover = TagHover.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ExplanationTag r100) {
            String r101 = r100.mtext;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtag_type;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TagStyle r107 = r100.mtag_style;
            if (r107 == null) goto L13;
            int r108 = TagStyle.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TagHover r110 = r100.mtag_hover;
            if (r110 == null) goto L18;
            r102 = TagHover.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ExplanationTag decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExplanationTag r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExplanationTag r101) throws IOException {
            String r102 = r101.mtext;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtag_type;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            TagStyle r104 = r101.mtag_style;
            if (r104 == null) goto L11;
            TagStyle.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TagHover r105 = r101.mtag_hover;
            if (r105 == null) goto L14;
            TagHover.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExplanationTag r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TagStyle extends Enum<TagStyle> implements WireEnum {
        private static final /* synthetic */ TagStyle[] $VALUES = null;
        public static final ProtoAdapter<TagStyle> ADAPTER = null;
        public static final TagStyle CRYPTO = null;
        public static final TagStyle HELP_DESK = null;
        public static final TagStyle OFFICIAL_DOC = null;
        public static final TagStyle SHIELD = null;
        public static final TagStyle TEXT = null;
        public static final TagStyle UNKNOWN = null;
        private final int value;

        static {
            TagStyle r100 = new TagStyle("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TagStyle r101 = new TagStyle(CardAdapter.TEXT, 1, 1);
            TEXT = r101;
            TagStyle r102 = new TagStyle("CRYPTO", 2, 2);
            CRYPTO = r102;
            TagStyle r103 = new TagStyle("SHIELD", 3, 3);
            SHIELD = r103;
            TagStyle r104 = new TagStyle("HELP_DESK", 4, 4);
            HELP_DESK = r104;
            TagStyle r105 = new TagStyle("OFFICIAL_DOC", 5, 5);
            OFFICIAL_DOC = r105;
            $VALUES = new TagStyle[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(TagStyle.class);
        }

        public static TagStyle[] values() {
            return (TagStyle[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TagStyle fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return OFFICIAL_DOC;
        L18:
            return HELP_DESK;
        L20:
            return SHIELD;
        L22:
            return CRYPTO;
        L24:
            return TEXT;
        L26:
            return UNKNOWN;
        }

        public static TagStyle valueOf(String r100) {
            return (TagStyle) a.a(TagStyle.class, r100);
        }

        private TagStyle(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExplanationTag();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtext = this.mtext;
        r100.mtag_type = this.mtag_type;
        r100.mtag_style = this.mtag_style;
        r100.mtag_hover = this.mtag_hover;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExplanationTag.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExplanationTag(String r100, String r101, TagStyle r102, TagHover r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ExplanationTag(String r100, String r101, TagStyle r102, TagHover r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mtext = r100;
        this.mtag_type = r101;
        this.mtag_style = r102;
        this.mtag_hover = r103;
    }
}
