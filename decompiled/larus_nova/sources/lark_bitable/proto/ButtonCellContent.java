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
public final class ButtonCellContent extends Message<ButtonCellContent, Builder> {
    public static final ProtoAdapter<ButtonCellContent> ADAPTER = null;
    public static final String DEFAULT_BUTTON_BACKGROUND_COLOR = "";
    public static final String DEFAULT_BUTTON_TEXT = "";
    public static final String DEFAULT_BUTTON_TEXT_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String button_background_color;
    public final String button_text;
    public final String button_text_color;

    public static final class Builder extends Message.Builder<ButtonCellContent, Builder> {
        public String button_background_color;
        public String button_text;
        public String button_text_color;

        @Override // com.squareup.wire.Message.Builder
        public ButtonCellContent build() {
            String r100 = this.button_text;
            if (r100 == null) goto L11;
            if (this.button_background_color == null) goto L11;
            if (this.button_text_color == null) goto L11;
            return new ButtonCellContent(this.button_text, this.button_background_color, this.button_text_color, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "button_text", this.button_background_color, "button_background_color", this.button_text_color, "button_text_color"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder button_background_color(String r100) {
            this.button_background_color = r100;
            return this;
        }

        public Builder button_text(String r100) {
            this.button_text = r100;
            return this;
        }

        public Builder button_text_color(String r100) {
            this.button_text_color = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ButtonCellContent extends ProtoAdapter<ButtonCellContent> {
        public ProtoAdapter_ButtonCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, ButtonCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ButtonCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.button_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.button_background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.button_text_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ButtonCellContent r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.button_text) + r101.encodedSizeWithTag(2, r100.button_background_color)) + r101.encodedSizeWithTag(3, r100.button_text_color)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ButtonCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ButtonCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ButtonCellContent r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.button_text);
            r102.encodeWithTag(r100, 2, r101.button_background_color);
            r102.encodeWithTag(r100, 3, r101.button_text_color);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ButtonCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ButtonCellContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.button_text = this.button_text;
        r100.button_background_color = this.button_background_color;
        r100.button_text_color = this.button_text_color;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ButtonCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ButtonCellContent(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ButtonCellContent(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.button_text = r100;
        this.button_background_color = r101;
        this.button_text_color = r102;
    }
}
