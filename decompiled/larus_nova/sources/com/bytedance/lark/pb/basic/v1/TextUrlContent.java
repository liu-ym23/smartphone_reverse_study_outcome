package com.bytedance.lark.pb.basic.v1;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TextUrlContent extends com.squareup.wire.Message<TextUrlContent, Builder> {
    public static final ProtoAdapter<TextUrlContent> ADAPTER = null;
    public static final Boolean DEFAULT_IS_HIDDEN = null;
    public static final Integer DEFAULT_SEQUENCE_ID = null;
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    public static final Type DEFAULT_TYPE = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final ImageSet icon;
    public final Boolean is_hidden;
    public final Integer sequence_id;
    public final String summary;
    public final String text;
    public final String title;
    public final Type type;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<TextUrlContent, Builder> {
        public ImageSet icon;
        public Boolean is_hidden;
        public Integer sequence_id;
        public String summary;
        public String text;
        public String title;
        public Type type;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public TextUrlContent build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new TextUrlContent(this.type, this.text, this.sequence_id, this.url, this.title, this.summary, this.icon, this.is_hidden, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder icon(ImageSet r100) {
            this.icon = r100;
            return this;
        }

        public Builder is_hidden(Boolean r100) {
            this.is_hidden = r100;
            return this;
        }

        public Builder sequence_id(Integer r100) {
            this.sequence_id = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TextUrlContent extends ProtoAdapter<TextUrlContent> {
        public ProtoAdapter_TextUrlContent() {
            super(FieldEncoding.LENGTH_DELIMITED, TextUrlContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TextUrlContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            r101.text = "";
            r101.sequence_id = 0;
            r101.url = "";
            r101.title = "";
            r101.summary = "";
            r101.is_hidden = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 100) goto L9;
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            switch(r103) {
                case 200: goto L16;
                case 201: goto L15;
                case 202: goto L14;
                case 203: goto L13;
                case 204: goto L12;
                case 205: goto L11;
                default: goto L10;
            };
        L11:
            r101.is_hidden = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.icon = ImageSet.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.summary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.sequence_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TextUrlContent r100) {
            int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.type);
            String r102 = r100.text;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(100, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.sequence_id;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT32.encodedSizeWithTag(200, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.url;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.STRING.encodedSizeWithTag(201, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.title;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.STRING.encodedSizeWithTag(202, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.summary;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.STRING.encodedSizeWithTag(203, r115);
        L22:
            int r117 = r114 + r116;
            ImageSet r118 = r100.icon;
            if (r118 == null) goto L25;
            int r119 = ImageSet.ADAPTER.encodedSizeWithTag(204, r118);
        L26:
            int r120 = r117 + r119;
            Boolean r121 = r100.is_hidden;
            if (r121 == null) goto L30;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(205, r121);
        L30:
            return (r120 + r103) + r100.unknownFields().size();
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TextUrlContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TextUrlContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TextUrlContent r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            String r102 = r101.text;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 100, r102);
        L5:
            Integer r103 = r101.sequence_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 200, r103);
        L8:
            String r104 = r101.url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 201, r104);
        L11:
            String r105 = r101.title;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 202, r105);
        L14:
            String r106 = r101.summary;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 203, r106);
        L17:
            ImageSet r107 = r101.icon;
            if (r107 == null) goto L20;
            ImageSet.ADAPTER.encodeWithTag(r100, 204, r107);
        L20:
            Boolean r108 = r101.is_hidden;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 205, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextUrlContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type TEXT = null;
        public static final Type UNKNOWN = null;
        public static final Type URL = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type(CardAdapter.TEXT, 1, 1);
            TEXT = r101;
            Type r102 = new Type("URL", 2, 2);
            URL = r102;
            $VALUES = new Type[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return URL;
        L12:
            return TEXT;
        L14:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TextUrlContent();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_SEQUENCE_ID = 0;
        DEFAULT_IS_HIDDEN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.text = this.text;
        r100.sequence_id = this.sequence_id;
        r100.url = this.url;
        r100.title = this.title;
        r100.summary = this.summary;
        r100.icon = this.icon;
        r100.is_hidden = this.is_hidden;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TextUrlContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TextUrlContent(Type r110, String r111, Integer r112, String r113, String r114, String r115, ImageSet r116, Boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public TextUrlContent(Type r100, String r101, Integer r102, String r103, String r104, String r105, ImageSet r106, Boolean r107, ByteString r110) {
        super(ADAPTER, r110);
        this.type = r100;
        this.text = r101;
        this.sequence_id = r102;
        this.url = r103;
        this.title = r104;
        this.summary = r105;
        this.icon = r106;
        this.is_hidden = r107;
    }
}
