package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class MovableDocumentInfo extends Message<MovableDocumentInfo, Builder> {
    public static final ProtoAdapter<MovableDocumentInfo> ADAPTER = null;
    public static final Integer DEFAULT_DOCUMENT_ID = null;
    public static final Integer DEFAULT_DOCUMENT_VERSION = null;
    public static final Float DEFAULT_HEIGHT = null;
    public static final Float DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Integer document_id;
    public final Integer document_version;
    public final Float height;
    public final Float width;

    public static final class Builder extends Message.Builder<MovableDocumentInfo, Builder> {
        public Integer document_id;
        public Integer document_version;
        public Float height;
        public Float width;

        @Override // com.squareup.wire.Message.Builder
        public MovableDocumentInfo build() {
            Integer r100 = this.document_id;
            if (r100 == null) goto L13;
            if (this.document_version == null) goto L13;
            if (this.width == null) goto L13;
            if (this.height == null) goto L13;
            return new MovableDocumentInfo(this.document_id, this.document_version, this.width, this.height, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "document_id", this.document_version, "document_version", this.width, "width", this.height, "height"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder document_id(Integer r100) {
            this.document_id = r100;
            return this;
        }

        public Builder document_version(Integer r100) {
            this.document_version = r100;
            return this;
        }

        public Builder height(Float r100) {
            this.height = r100;
            return this;
        }

        public Builder width(Float r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MovableDocumentInfo extends ProtoAdapter<MovableDocumentInfo> {
        public ProtoAdapter_MovableDocumentInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MovableDocumentInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public MovableDocumentInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.document_id = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.document_version = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.height = ProtoAdapter.FLOAT.decode(r100);
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
        public int encodedSize2(MovableDocumentInfo r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.UINT32;
            int r102 = r101.encodedSizeWithTag(1, r100.document_id) + r101.encodedSizeWithTag(2, r100.document_version);
            ProtoAdapter<Float> r103 = ProtoAdapter.FLOAT;
            return ((r102 + r103.encodedSizeWithTag(3, r100.width)) + r103.encodedSizeWithTag(4, r100.height)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MovableDocumentInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MovableDocumentInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MovableDocumentInfo r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
            r102.encodeWithTag(r100, 1, r101.document_id);
            r102.encodeWithTag(r100, 2, r101.document_version);
            ProtoAdapter<Float> r103 = ProtoAdapter.FLOAT;
            r103.encodeWithTag(r100, 3, r101.width);
            r103.encodeWithTag(r100, 4, r101.height);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MovableDocumentInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MovableDocumentInfo();
        DEFAULT_DOCUMENT_ID = 0;
        DEFAULT_DOCUMENT_VERSION = 0;
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_WIDTH = r100;
        DEFAULT_HEIGHT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.document_id = this.document_id;
        r100.document_version = this.document_version;
        r100.width = this.width;
        r100.height = this.height;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MovableDocumentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MovableDocumentInfo(Integer r100, Integer r101, Float r102, Float r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MovableDocumentInfo(Integer r100, Integer r101, Float r102, Float r103, ByteString r104) {
        super(ADAPTER, r104);
        this.document_id = r100;
        this.document_version = r101;
        this.width = r102;
        this.height = r103;
    }
}
