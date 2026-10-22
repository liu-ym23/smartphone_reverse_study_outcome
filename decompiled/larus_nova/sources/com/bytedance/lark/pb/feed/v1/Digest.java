package com.bytedance.lark.pb.feed.v1;

import annotation.Debug;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Digest extends Message<Digest, Builder> {
    public static final ProtoAdapter<Digest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Long> chatter_ids;
    public final List<Element> elements;

    public static final class Builder extends Message.Builder<Digest, Builder> {
        public List<Long> chatter_ids;
        public List<Element> elements;

        @Override // com.squareup.wire.Message.Builder
        public Digest build() {
            return new Digest(this.elements, this.chatter_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.elements = Internal.newMutableList();
            this.chatter_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatter_ids = r100;
            return this;
        }

        public Builder elements(List<Element> r100) {
            Internal.checkElementsNotNull(r100);
            this.elements = r100;
            return this;
        }
    }

    public static final class Element extends Message<Element, Builder> {
        public static final ProtoAdapter<Element> ADAPTER = null;
        public static final Tag DEFAULT_TAG = null;
        public static final FieldOptions FIELD_OPTIONS_EMOJI = null;
        public static final FieldOptions FIELD_OPTIONS_TEXT = null;
        private static final long serialVersionUID = 0;
        public final EmojiProperty emoji;
        public final Tag tag;
        public final TextProperty text;

        public static final class Builder extends Message.Builder<Element, Builder> {
            public EmojiProperty emoji;
            public Tag tag;
            public TextProperty text;

            @Override // com.squareup.wire.Message.Builder
            public Element build() {
                return new Element(this.tag, this.text, this.emoji, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder emoji(EmojiProperty r100) {
                this.emoji = r100;
                this.text = null;
                return this;
            }

            public Builder tag(Tag r100) {
                this.tag = r100;
                return this;
            }

            public Builder text(TextProperty r100) {
                this.text = r100;
                this.emoji = null;
                return this;
            }
        }

        public static final class EmojiProperty extends Message<EmojiProperty, Builder> {
            public static final ProtoAdapter<EmojiProperty> ADAPTER = null;
            public static final String DEFAULT_DEFAULT_CONTENT = "";
            public static final String DEFAULT_EMOJI_KEY = "";
            private static final long serialVersionUID = 0;
            public final String default_content;
            public final String emoji_key;

            public static final class Builder extends Message.Builder<EmojiProperty, Builder> {
                public String default_content;
                public String emoji_key;

                @Override // com.squareup.wire.Message.Builder
                public EmojiProperty build() {
                    return new EmojiProperty(this.emoji_key, this.default_content, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder default_content(String r100) {
                    this.default_content = r100;
                    return this;
                }

                public Builder emoji_key(String r100) {
                    this.emoji_key = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_EmojiProperty extends ProtoAdapter<EmojiProperty> {
                public ProtoAdapter_EmojiProperty() {
                    super(FieldEncoding.LENGTH_DELIMITED, EmojiProperty.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public EmojiProperty decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.emoji_key = "";
                    r101.default_content = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.emoji_key = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.default_content = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L9:
                    FieldEncoding r104 = r100.peekFieldEncoding();
                    r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                    goto L3
                L12:
                    r100.endMessage(r102);
                    return r101.build();
                }

                /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
                public int encodedSize2(EmojiProperty r100) {
                    String r101 = r100.emoji_key;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.default_content;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ EmojiProperty decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(EmojiProperty r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, EmojiProperty r101) throws IOException {
                    String r102 = r101.emoji_key;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.default_content;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmojiProperty r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_EmojiProperty();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.emoji_key = this.emoji_key;
                r100.default_content = this.default_content;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return EmojiProperty.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public EmojiProperty(String r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public EmojiProperty(String r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.emoji_key = r100;
                this.default_content = r101;
            }
        }

        public static final class ProtoAdapter_Element extends ProtoAdapter<Element> {
            public ProtoAdapter_Element() {
                super(FieldEncoding.LENGTH_DELIMITED, Element.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Element decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.tag = Tag.TAG_UNSPECIFIED;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.tag = Tag.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 10) goto L10;
                r101.text(TextProperty.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 11) goto L11;
                r101.emoji(EmojiProperty.ADAPTER.decode(r100));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Element r100) {
                Tag r101 = r100.tag;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Tag.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                TextProperty r104 = r100.text;
                if (r104 == null) goto L9;
                int r105 = TextProperty.ADAPTER.encodedSizeWithTag(10, r104);
            L10:
                int r106 = r103 + r105;
                EmojiProperty r107 = r100.emoji;
                if (r107 == null) goto L14;
                r102 = EmojiProperty.ADAPTER.encodedSizeWithTag(11, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Element decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Element r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Element r101) throws IOException {
                Tag r102 = r101.tag;
                if (r102 == null) goto L5;
                Tag.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                TextProperty r103 = r101.text;
                if (r103 == null) goto L8;
                TextProperty.ADAPTER.encodeWithTag(r100, 10, r103);
            L8:
                EmojiProperty r104 = r101.emoji;
                if (r104 == null) goto L11;
                EmojiProperty.ADAPTER.encodeWithTag(r100, 11, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Element r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Tag extends Enum<Tag> implements WireEnum {
            private static final /* synthetic */ Tag[] $VALUES = null;
            public static final ProtoAdapter<Tag> ADAPTER = null;
            public static final Tag EMOJI = null;
            public static final Tag TAG_UNSPECIFIED = null;
            public static final Tag TEXT = null;
            public static final Tag TEXT_WITH_EMOJIS = null;
            private final int value;

            static {
                Tag r100 = new Tag("TAG_UNSPECIFIED", 0, 0);
                TAG_UNSPECIFIED = r100;
                Tag r101 = new Tag(CardAdapter.TEXT, 1, 1);
                TEXT = r101;
                Tag r102 = new Tag("EMOJI", 2, 2);
                EMOJI = r102;
                Tag r103 = new Tag("TEXT_WITH_EMOJIS", 3, 3);
                TEXT_WITH_EMOJIS = r103;
                $VALUES = new Tag[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(Tag.class);
            }

            public static Tag[] values() {
                return (Tag[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Tag fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return TEXT_WITH_EMOJIS;
            L14:
                return EMOJI;
            L16:
                return TEXT;
            L18:
                return TAG_UNSPECIFIED;
            }

            public static Tag valueOf(String r100) {
                return (Tag) a.a(Tag.class, r100);
            }

            private Tag(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class TextProperty extends Message<TextProperty, Builder> {
            public static final ProtoAdapter<TextProperty> ADAPTER = null;
            public static final String DEFAULT_CONTENT = "";
            private static final long serialVersionUID = 0;
            public final String content;

            public static final class Builder extends Message.Builder<TextProperty, Builder> {
                public String content;

                @Override // com.squareup.wire.Message.Builder
                public TextProperty build() {
                    return new TextProperty(this.content, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder content(String r100) {
                    this.content = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_TextProperty extends ProtoAdapter<TextProperty> {
                public ProtoAdapter_TextProperty() {
                    super(FieldEncoding.LENGTH_DELIMITED, TextProperty.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public TextProperty decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.content = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L9;
                    if (r103 != 1) goto L7;
                    r101.content = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(TextProperty r100) {
                    String r101 = r100.content;
                    if (r101 == null) goto L5;
                    int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L7:
                    return r102 + r100.unknownFields().size();
                L5:
                    r102 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ TextProperty decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(TextProperty r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, TextProperty r101) throws IOException {
                    String r102 = r101.content;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextProperty r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_TextProperty();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.content = this.content;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return TextProperty.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public TextProperty(String r100) {
                this(r100, ByteString.EMPTY);
            }

            public TextProperty(String r100, ByteString r101) {
                super(ADAPTER, r101);
                this.content = r100;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Element();
            FIELD_OPTIONS_TEXT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_EMOJI = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            DEFAULT_TAG = Tag.TAG_UNSPECIFIED;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tag = this.tag;
            r100.text = this.text;
            r100.emoji = this.emoji;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Element.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Element(Tag r100, TextProperty r101, EmojiProperty r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Element(Tag r100, TextProperty r101, EmojiProperty r102, ByteString r103) {
            super(ADAPTER, r103);
            if (Internal.countNonNull(r101, r102) > 1) goto L7;
            this.tag = r100;
            this.text = r101;
            this.emoji = r102;
            return;
        L7:
            throw new IllegalArgumentException("at most one of text, emoji may be non-null");
        }
    }

    public static final class ProtoAdapter_Digest extends ProtoAdapter<Digest> {
        public ProtoAdapter_Digest() {
            super(FieldEncoding.LENGTH_DELIMITED, Digest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Digest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.elements.add(Element.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.chatter_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Digest r100) {
            return (Element.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.elements) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(2, r100.chatter_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Digest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Digest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Digest r101) throws IOException {
            Element.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.elements);
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 2, r101.chatter_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Digest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Digest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.elements = Internal.copyOf(SlcElement.KEY_ELEMENTS, this.elements);
        r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Digest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Digest(List<Element> r100, List<Long> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Digest(List<Element> r100, List<Long> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.elements = Internal.immutableCopyOf(SlcElement.KEY_ELEMENTS, r100);
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r101);
    }
}
