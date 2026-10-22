package com.ss.android.lark.pb.ug_reach;

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
public final class TextElement extends Message<TextElement, Builder> {
    public static final ProtoAdapter<TextElement> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final TextType mtype;

    public static final class Builder extends Message.Builder<TextElement, Builder> {
        public String mcontent;
        public TextType mtype;

        @Override // com.squareup.wire.Message.Builder
        public TextElement build() {
            return new TextElement(this.mtype, this.mcontent, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder type(TextType r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TextElement extends ProtoAdapter<TextElement> {
        public ProtoAdapter_TextElement() {
            super(FieldEncoding.LENGTH_DELIMITED, TextElement.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TextElement decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcontent = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mtype = TextType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mcontent = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TextElement r100) {
            TextType r101 = r100.mtype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TextType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mcontent;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TextElement decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TextElement r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TextElement r101) throws IOException {
            TextType r102 = r101.mtype;
            if (r102 == null) goto L5;
            TextType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mcontent;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextElement r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TextType extends Enum<TextType> implements WireEnum {
        private static final /* synthetic */ TextType[] $VALUES = null;
        public static final ProtoAdapter<TextType> ADAPTER = null;
        public static final TextType HTML = null;
        public static final TextType PLAIN = null;
        public static final TextType UNKNOWN = null;
        private final int value;

        static {
            TextType r100 = new TextType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TextType r101 = new TextType("PLAIN", 1, 1);
            PLAIN = r101;
            TextType r102 = new TextType("HTML", 2, 2);
            HTML = r102;
            $VALUES = new TextType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(TextType.class);
        }

        public static TextType[] values() {
            return (TextType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TextType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return HTML;
        L12:
            return PLAIN;
        L14:
            return UNKNOWN;
        }

        public static TextType valueOf(String r100) {
            return (TextType) a.a(TextType.class, r100);
        }

        private TextType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TextElement();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mcontent = this.mcontent;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TextElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TextElement(TextType r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TextElement(TextType r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtype = r100;
        this.mcontent = r101;
    }
}
