package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class TextSpan extends Message<TextSpan, Builder> {
    public static final ProtoAdapter<TextSpan> ADAPTER = null;
    public static final String DEFAULT_CATEGORY = "";
    public static final String DEFAULT_EN_NAME = "";
    public static final String DEFAULT_INPUT_TYPE = "";
    public static final String DEFAULT_LINK = "";
    public static final Boolean DEFAULT_MENTION_NOTIFY = null;
    public static final Integer DEFAULT_MENTION_TYPE = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final String category;
    public final String en_name;
    public final String input_type;
    public final String link;
    public final Boolean mention_notify;
    public final Integer mention_type;
    public final String name;
    public final String text;
    public final String token;

    public static final class Builder extends Message.Builder<TextSpan, Builder> {
        public String category;
        public String en_name;
        public String input_type;
        public String link;
        public Boolean mention_notify;
        public Integer mention_type;
        public String name;
        public String text;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public TextSpan build() {
            String r100 = this.text;
            if (r100 == null) goto L7;
            return new TextSpan(this.text, this.input_type, this.link, this.category, this.en_name, this.mention_notify, this.token, this.mention_type, this.name, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "text"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder category(String r100) {
            this.category = r100;
            return this;
        }

        public Builder en_name(String r100) {
            this.en_name = r100;
            return this;
        }

        public Builder input_type(String r100) {
            this.input_type = r100;
            return this;
        }

        public Builder link(String r100) {
            this.link = r100;
            return this;
        }

        public Builder mention_notify(Boolean r100) {
            this.mention_notify = r100;
            return this;
        }

        public Builder mention_type(Integer r100) {
            this.mention_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TextSpan extends ProtoAdapter<TextSpan> {
        public ProtoAdapter_TextSpan() {
            super(FieldEncoding.LENGTH_DELIMITED, TextSpan.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TextSpan decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mention_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mention_notify = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.en_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.category = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.input_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TextSpan r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.text);
            String r103 = r100.input_type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.link;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.category;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.en_name;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.mention_notify;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.token;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            Integer r122 = r100.mention_type;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.INT32.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.name;
            if (r125 == null) goto L34;
            r104 = r101.encodedSizeWithTag(9, r125);
        L34:
            return (r124 + r104) + r100.unknownFields().size();
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TextSpan decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TextSpan r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TextSpan r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.text);
            String r103 = r101.input_type;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.link;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.category;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.en_name;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            Boolean r107 = r101.mention_notify;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.token;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            Integer r109 = r101.mention_type;
            if (r109 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.name;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 9, r110);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextSpan r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TextSpan();
        DEFAULT_MENTION_NOTIFY = Boolean.FALSE;
        DEFAULT_MENTION_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.text = this.text;
        r100.input_type = this.input_type;
        r100.link = this.link;
        r100.category = this.category;
        r100.en_name = this.en_name;
        r100.mention_notify = this.mention_notify;
        r100.token = this.token;
        r100.mention_type = this.mention_type;
        r100.name = this.name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TextSpan.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TextSpan(String r110, String r111, String r112, String r113, String r114, Boolean r115, String r116, Integer r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public TextSpan(String r100, String r101, String r102, String r103, String r104, Boolean r105, String r106, Integer r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.text = r100;
        this.input_type = r101;
        this.link = r102;
        this.category = r103;
        this.en_name = r104;
        this.mention_notify = r105;
        this.token = r106;
        this.mention_type = r107;
        this.name = r110;
    }
}
