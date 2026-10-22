package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class TextCellContent extends Message<TextCellContent, Builder> {
    public static final ProtoAdapter<TextCellContent> ADAPTER = null;
    public static final FieldInputType DEFAULT_INPUT_TYPE = null;
    public static final Boolean DEFAULT_IS_EXTEND = null;
    public static final String DEFAULT_LINK_HIGHLIGHT_COLOR = "";
    private static final long serialVersionUID = 0;
    public final List<TextSpan> content;
    public final FieldInputType input_type;
    public final Boolean is_extend;
    public final String link_highlight_color;

    public static final class Builder extends Message.Builder<TextCellContent, Builder> {
        public List<TextSpan> content;
        public FieldInputType input_type;
        public Boolean is_extend;
        public String link_highlight_color;

        @Override // com.squareup.wire.Message.Builder
        public TextCellContent build() {
            String r100 = this.link_highlight_color;
            if (r100 == null) goto L9;
            if (this.is_extend == null) goto L9;
            return new TextCellContent(this.link_highlight_color, this.content, this.is_extend, this.input_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "link_highlight_color", this.is_extend, "is_extend"});
        }

        public Builder() {
            this.content = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(List<TextSpan> r100) {
            Internal.checkElementsNotNull(r100);
            this.content = r100;
            return this;
        }

        public Builder input_type(FieldInputType r100) {
            this.input_type = r100;
            return this;
        }

        public Builder is_extend(Boolean r100) {
            this.is_extend = r100;
            return this;
        }

        public Builder link_highlight_color(String r100) {
            this.link_highlight_color = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TextCellContent extends ProtoAdapter<TextCellContent> {
        public ProtoAdapter_TextCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, TextCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TextCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.link_highlight_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.content.add(TextSpan.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.is_extend = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.input_type = FieldInputType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(TextCellContent r100) {
            int r101 = (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.link_highlight_color) + TextSpan.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.content)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.is_extend);
            FieldInputType r102 = r100.input_type;
            if (r102 == null) goto L5;
            int r103 = FieldInputType.ADAPTER.encodedSizeWithTag(4, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TextCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TextCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TextCellContent r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.link_highlight_color);
            TextSpan.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.content);
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.is_extend);
            FieldInputType r102 = r101.input_type;
            if (r102 == null) goto L5;
            FieldInputType.ADAPTER.encodeWithTag(r100, 4, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TextCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TextCellContent();
        DEFAULT_IS_EXTEND = Boolean.FALSE;
        DEFAULT_INPUT_TYPE = FieldInputType.VAR_FIELD_INPUT_TYPE_NO_LIMIT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.link_highlight_color = this.link_highlight_color;
        r100.content = Internal.copyOf("content", this.content);
        r100.is_extend = this.is_extend;
        r100.input_type = this.input_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TextCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TextCellContent(String r100, List<TextSpan> r101, Boolean r102, FieldInputType r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TextCellContent(String r100, List<TextSpan> r101, Boolean r102, FieldInputType r103, ByteString r104) {
        super(ADAPTER, r104);
        this.link_highlight_color = r100;
        this.content = Internal.immutableCopyOf("content", r101);
        this.is_extend = r102;
        this.input_type = r103;
    }
}
