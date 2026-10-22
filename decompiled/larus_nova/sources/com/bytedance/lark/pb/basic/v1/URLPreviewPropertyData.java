package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class URLPreviewPropertyData extends com.squareup.wire.Message<URLPreviewPropertyData, Builder> {
    public static final ProtoAdapter<URLPreviewPropertyData> ADAPTER = null;
    public static final URLPreviewComponent.Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, PreviewData> preview_property_data;
    public final RichText rich_text;
    public final URLPreviewComponent.Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<URLPreviewPropertyData, Builder> {
        public Map<Integer, PreviewData> preview_property_data;
        public RichText rich_text;
        public URLPreviewComponent.Type type;

        @Override // com.squareup.wire.Message.Builder
        public URLPreviewPropertyData build() {
            URLPreviewComponent.Type r100 = this.type;
            if (r100 == null) goto L7;
            return new URLPreviewPropertyData(this.type, this.preview_property_data, this.rich_text, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
            this.preview_property_data = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder preview_property_data(Map<Integer, PreviewData> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_property_data = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder type(URLPreviewComponent.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_URLPreviewPropertyData extends ProtoAdapter<URLPreviewPropertyData> {
        private final ProtoAdapter<Map<Integer, PreviewData>> preview_property_data;

        public ProtoAdapter_URLPreviewPropertyData() {
            super(FieldEncoding.LENGTH_DELIMITED, URLPreviewPropertyData.class);
            this.preview_property_data = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, PreviewData.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public URLPreviewPropertyData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = URLPreviewComponent.Type.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.type = URLPreviewComponent.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.preview_property_data.putAll(this.preview_property_data.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.rich_text = RichText.ADAPTER.decode(r100);
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
        public int encodedSize2(URLPreviewPropertyData r100) {
            int r101 = URLPreviewComponent.Type.ADAPTER.encodedSizeWithTag(1, r100.type) + this.preview_property_data.encodedSizeWithTag(2, r100.preview_property_data);
            RichText r102 = r100.rich_text;
            if (r102 == null) goto L5;
            int r103 = RichText.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ URLPreviewPropertyData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(URLPreviewPropertyData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, URLPreviewPropertyData r101) throws IOException {
            URLPreviewComponent.Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            this.preview_property_data.encodeWithTag(r100, 2, r101.preview_property_data);
            RichText r102 = r101.rich_text;
            if (r102 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLPreviewPropertyData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URLPreviewPropertyData();
        DEFAULT_TYPE = URLPreviewComponent.Type.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.preview_property_data = Internal.copyOf("preview_property_data", this.preview_property_data);
        r100.rich_text = this.rich_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return URLPreviewPropertyData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public URLPreviewPropertyData(URLPreviewComponent.Type r100, Map<Integer, PreviewData> r101, RichText r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public URLPreviewPropertyData(URLPreviewComponent.Type r100, Map<Integer, PreviewData> r101, RichText r102, ByteString r103) {
        super(ADAPTER, r103);
        this.type = r100;
        this.preview_property_data = Internal.immutableCopyOf("preview_property_data", r101);
        this.rich_text = r102;
    }
}
