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
public final class StageCellContent extends Message<StageCellContent, Builder> {
    public static final ProtoAdapter<StageCellContent> ADAPTER = null;
    public static final String DEFAULT_STAGE_BACKGROUND_COLOR = "";
    public static final String DEFAULT_STAGE_STATUS = "";
    public static final String DEFAULT_STAGE_TEXT = "";
    public static final String DEFAULT_STAGE_TEXT_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String stage_background_color;
    public final String stage_status;
    public final String stage_text;
    public final String stage_text_color;

    public static final class Builder extends Message.Builder<StageCellContent, Builder> {
        public String stage_background_color;
        public String stage_status;
        public String stage_text;
        public String stage_text_color;

        @Override // com.squareup.wire.Message.Builder
        public StageCellContent build() {
            String r100 = this.stage_background_color;
            if (r100 == null) goto L13;
            if (this.stage_text == null) goto L13;
            if (this.stage_text_color == null) goto L13;
            if (this.stage_status == null) goto L13;
            return new StageCellContent(this.stage_background_color, this.stage_text, this.stage_text_color, this.stage_status, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "stage_background_color", this.stage_text, "stage_text", this.stage_text_color, "stage_text_color", this.stage_status, "stage_status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder stage_background_color(String r100) {
            this.stage_background_color = r100;
            return this;
        }

        public Builder stage_status(String r100) {
            this.stage_status = r100;
            return this;
        }

        public Builder stage_text(String r100) {
            this.stage_text = r100;
            return this;
        }

        public Builder stage_text_color(String r100) {
            this.stage_text_color = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_StageCellContent extends ProtoAdapter<StageCellContent> {
        public ProtoAdapter_StageCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, StageCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public StageCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.stage_background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.stage_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.stage_text_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.stage_status = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(StageCellContent r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.stage_background_color) + r101.encodedSizeWithTag(2, r100.stage_text)) + r101.encodedSizeWithTag(3, r100.stage_text_color)) + r101.encodedSizeWithTag(4, r100.stage_status)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StageCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StageCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StageCellContent r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.stage_background_color);
            r102.encodeWithTag(r100, 2, r101.stage_text);
            r102.encodeWithTag(r100, 3, r101.stage_text_color);
            r102.encodeWithTag(r100, 4, r101.stage_status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StageCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StageCellContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.stage_background_color = this.stage_background_color;
        r100.stage_text = this.stage_text;
        r100.stage_text_color = this.stage_text_color;
        r100.stage_status = this.stage_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return StageCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public StageCellContent(String r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public StageCellContent(String r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.stage_background_color = r100;
        this.stage_text = r101;
        this.stage_text_color = r102;
        this.stage_status = r103;
    }
}
