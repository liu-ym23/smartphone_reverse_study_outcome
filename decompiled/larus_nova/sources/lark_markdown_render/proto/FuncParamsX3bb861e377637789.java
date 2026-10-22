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
public final class FuncParamsX3bb861e377637789 extends Message<FuncParamsX3bb861e377637789, Builder> {
    public static final ProtoAdapter<FuncParamsX3bb861e377637789> ADAPTER = null;
    public static final Integer DEFAULT_CANVAS_ID = null;
    public static final Integer DEFAULT_DOCUMENT_ID = null;
    public static final Integer DEFAULT_DOCUMENT_VERSION = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Integer canvas_id;
    public final Integer document_id;
    public final Integer document_version;

    public static final class Builder extends Message.Builder<FuncParamsX3bb861e377637789, Builder> {
        public ByteString _molten_ctx;
        public Integer canvas_id;
        public Integer document_id;
        public Integer document_version;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX3bb861e377637789 build() {
            Integer r100 = this.canvas_id;
            if (r100 == null) goto L11;
            if (this.document_id == null) goto L11;
            if (this.document_version == null) goto L11;
            return new FuncParamsX3bb861e377637789(this.canvas_id, this.document_id, this.document_version, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "canvas_id", this.document_id, "document_id", this.document_version, "document_version"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder canvas_id(Integer r100) {
            this.canvas_id = r100;
            return this;
        }

        public Builder document_id(Integer r100) {
            this.document_id = r100;
            return this;
        }

        public Builder document_version(Integer r100) {
            this.document_version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX3bb861e377637789 extends ProtoAdapter<FuncParamsX3bb861e377637789> {
        public ProtoAdapter_FuncParamsX3bb861e377637789() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX3bb861e377637789.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX3bb861e377637789 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.canvas_id = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.document_id = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.document_version = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L12:
            if (r103 != 255) goto L13;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsX3bb861e377637789 r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.UINT32;
            int r102 = (r101.encodedSizeWithTag(1, r100.canvas_id) + r101.encodedSizeWithTag(2, r100.document_id)) + r101.encodedSizeWithTag(3, r100.document_version);
            ByteString r103 = r100._molten_ctx;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX3bb861e377637789 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX3bb861e377637789 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX3bb861e377637789 r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
            r102.encodeWithTag(r100, 1, r101.canvas_id);
            r102.encodeWithTag(r100, 2, r101.document_id);
            r102.encodeWithTag(r100, 3, r101.document_version);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX3bb861e377637789 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX3bb861e377637789();
        DEFAULT_CANVAS_ID = 0;
        DEFAULT_DOCUMENT_ID = 0;
        DEFAULT_DOCUMENT_VERSION = 0;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.canvas_id = this.canvas_id;
        r100.document_id = this.document_id;
        r100.document_version = this.document_version;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX3bb861e377637789.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX3bb861e377637789(Integer r100, Integer r101, Integer r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX3bb861e377637789(Integer r100, Integer r101, Integer r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.canvas_id = r100;
        this.document_id = r101;
        this.document_version = r102;
        this._molten_ctx = r103;
    }
}
