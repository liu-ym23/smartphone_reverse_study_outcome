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
public final class ProgressCellContent extends Message<ProgressCellContent, Builder> {
    public static final ProtoAdapter<ProgressCellContent> ADAPTER = null;
    public static final String DEFAULT_PROGRESS_BACKGROUND_COLOR = "";
    public static final String DEFAULT_PROGRESS_COLOR = "";
    public static final Float DEFAULT_PROGRESS_PERCENTAGE = null;
    public static final String DEFAULT_PROGRESS_TEXT = "";
    private static final long serialVersionUID = 0;
    public final String progress_background_color;
    public final String progress_color;
    public final Float progress_percentage;
    public final String progress_text;

    public static final class Builder extends Message.Builder<ProgressCellContent, Builder> {
        public String progress_background_color;
        public String progress_color;
        public Float progress_percentage;
        public String progress_text;

        @Override // com.squareup.wire.Message.Builder
        public ProgressCellContent build() {
            String r100 = this.progress_background_color;
            if (r100 == null) goto L13;
            if (this.progress_color == null) goto L13;
            if (this.progress_percentage == null) goto L13;
            if (this.progress_text == null) goto L13;
            return new ProgressCellContent(this.progress_background_color, this.progress_color, this.progress_percentage, this.progress_text, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "progress_background_color", this.progress_color, "progress_color", this.progress_percentage, "progress_percentage", this.progress_text, "progress_text"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder progress_background_color(String r100) {
            this.progress_background_color = r100;
            return this;
        }

        public Builder progress_color(String r100) {
            this.progress_color = r100;
            return this;
        }

        public Builder progress_percentage(Float r100) {
            this.progress_percentage = r100;
            return this;
        }

        public Builder progress_text(String r100) {
            this.progress_text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ProgressCellContent extends ProtoAdapter<ProgressCellContent> {
        public ProtoAdapter_ProgressCellContent() {
            super(FieldEncoding.LENGTH_DELIMITED, ProgressCellContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ProgressCellContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.progress_background_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.progress_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.progress_percentage = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.progress_text = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ProgressCellContent r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.progress_background_color) + r101.encodedSizeWithTag(2, r100.progress_color)) + ProtoAdapter.FLOAT.encodedSizeWithTag(3, r100.progress_percentage)) + r101.encodedSizeWithTag(4, r100.progress_text)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ProgressCellContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ProgressCellContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ProgressCellContent r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.progress_background_color);
            r102.encodeWithTag(r100, 2, r101.progress_color);
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r101.progress_percentage);
            r102.encodeWithTag(r100, 4, r101.progress_text);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProgressCellContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ProgressCellContent();
        DEFAULT_PROGRESS_PERCENTAGE = Float.valueOf(0.0f);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.progress_background_color = this.progress_background_color;
        r100.progress_color = this.progress_color;
        r100.progress_percentage = this.progress_percentage;
        r100.progress_text = this.progress_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ProgressCellContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ProgressCellContent(String r100, String r101, Float r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ProgressCellContent(String r100, String r101, Float r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.progress_background_color = r100;
        this.progress_color = r101;
        this.progress_percentage = r102;
        this.progress_text = r103;
    }
}
