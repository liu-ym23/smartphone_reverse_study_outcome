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
public final class URLPreviewStyleData extends com.squareup.wire.Message<URLPreviewStyleData, Builder> {
    public static final ProtoAdapter<URLPreviewStyleData> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, PreviewData> preview_style_data;

    public static final class Builder extends com.squareup.wire.Message.Builder<URLPreviewStyleData, Builder> {
        public Map<Integer, PreviewData> preview_style_data;

        @Override // com.squareup.wire.Message.Builder
        public URLPreviewStyleData build() {
            return new URLPreviewStyleData(this.preview_style_data, super.buildUnknownFields());
        }

        public Builder() {
            this.preview_style_data = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder preview_style_data(Map<Integer, PreviewData> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_style_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_URLPreviewStyleData extends ProtoAdapter<URLPreviewStyleData> {
        private final ProtoAdapter<Map<Integer, PreviewData>> preview_style_data;

        public ProtoAdapter_URLPreviewStyleData() {
            super(FieldEncoding.LENGTH_DELIMITED, URLPreviewStyleData.class);
            this.preview_style_data = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, PreviewData.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public URLPreviewStyleData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 2) goto L7;
            r101.preview_style_data.putAll(this.preview_style_data.decode(r100));
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
        public int encodedSize2(URLPreviewStyleData r100) {
            return this.preview_style_data.encodedSizeWithTag(2, r100.preview_style_data) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ URLPreviewStyleData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(URLPreviewStyleData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, URLPreviewStyleData r101) throws IOException {
            this.preview_style_data.encodeWithTag(r100, 2, r101.preview_style_data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLPreviewStyleData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URLPreviewStyleData();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_style_data = Internal.copyOf("preview_style_data", this.preview_style_data);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return URLPreviewStyleData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public URLPreviewStyleData(Map<Integer, PreviewData> r100) {
        this(r100, ByteString.EMPTY);
    }

    public URLPreviewStyleData(Map<Integer, PreviewData> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.preview_style_data = Internal.immutableCopyOf("preview_style_data", r100);
    }
}
