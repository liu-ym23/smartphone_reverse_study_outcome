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
public final class FuncParamsXf48f33eae5ff1bb1 extends Message<FuncParamsXf48f33eae5ff1bb1, Builder> {
    public static final ProtoAdapter<FuncParamsXf48f33eae5ff1bb1> ADAPTER = null;
    public static final Integer DEFAULT_DOCUMENT_ID = null;
    public static final Integer DEFAULT_DOCUMENT_VERSION = null;
    public static final Integer DEFAULT_INSTANCE_ID = null;
    public static final Float DEFAULT_X = null;
    public static final Float DEFAULT_Y = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Integer document_id;
    public final Integer document_version;
    public final Integer instance_id;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Float f508265x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Float f508266y;

    public static final class Builder extends Message.Builder<FuncParamsXf48f33eae5ff1bb1, Builder> {
        public ByteString _molten_ctx;
        public Integer document_id;
        public Integer document_version;
        public Integer instance_id;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Float f508267x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Float f508268y;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXf48f33eae5ff1bb1 build() {
            Integer r100 = this.instance_id;
            if (r100 == null) goto L15;
            if (this.document_id == null) goto L15;
            if (this.document_version == null) goto L15;
            if (this.f508267x == null) goto L15;
            if (this.f508268y == null) goto L15;
            return new FuncParamsXf48f33eae5ff1bb1(this.instance_id, this.document_id, this.document_version, this.f508267x, this.f508268y, this._molten_ctx, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "instance_id", this.document_id, "document_id", this.document_version, "document_version", this.f508267x, "x", this.f508268y, "y"});
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

        public Builder document_id(Integer r100) {
            this.document_id = r100;
            return this;
        }

        public Builder document_version(Integer r100) {
            this.document_version = r100;
            return this;
        }

        public Builder instance_id(Integer r100) {
            this.instance_id = r100;
            return this;
        }

        public Builder x(Float r100) {
            this.f508267x = r100;
            return this;
        }

        public Builder y(Float r100) {
            this.f508268y = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXf48f33eae5ff1bb1 extends ProtoAdapter<FuncParamsXf48f33eae5ff1bb1> {
        public ProtoAdapter_FuncParamsXf48f33eae5ff1bb1() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXf48f33eae5ff1bb1.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXf48f33eae5ff1bb1 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.instance_id = ProtoAdapter.UINT32.decode(r100);
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
            if (r103 != 4) goto L14;
            r101.f508267x = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.f508268y = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L16:
            if (r103 != 255) goto L17;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXf48f33eae5ff1bb1 r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.UINT32;
            int r102 = (r101.encodedSizeWithTag(1, r100.instance_id) + r101.encodedSizeWithTag(2, r100.document_id)) + r101.encodedSizeWithTag(3, r100.document_version);
            ProtoAdapter<Float> r103 = ProtoAdapter.FLOAT;
            int r104 = (r102 + r103.encodedSizeWithTag(4, r100.f508265x)) + r103.encodedSizeWithTag(5, r100.f508266y);
            ByteString r105 = r100._molten_ctx;
            if (r105 == null) goto L5;
            int r106 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r105);
        L7:
            return (r104 + r106) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXf48f33eae5ff1bb1 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXf48f33eae5ff1bb1 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXf48f33eae5ff1bb1 r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
            r102.encodeWithTag(r100, 1, r101.instance_id);
            r102.encodeWithTag(r100, 2, r101.document_id);
            r102.encodeWithTag(r100, 3, r101.document_version);
            ProtoAdapter<Float> r103 = ProtoAdapter.FLOAT;
            r103.encodeWithTag(r100, 4, r101.f508265x);
            r103.encodeWithTag(r100, 5, r101.f508266y);
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXf48f33eae5ff1bb1 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXf48f33eae5ff1bb1();
        DEFAULT_INSTANCE_ID = 0;
        DEFAULT_DOCUMENT_ID = 0;
        DEFAULT_DOCUMENT_VERSION = 0;
        Float r100 = Float.valueOf(0.0f);
        DEFAULT_X = r100;
        DEFAULT_Y = r100;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.instance_id = this.instance_id;
        r100.document_id = this.document_id;
        r100.document_version = this.document_version;
        r100.f508267x = this.f508265x;
        r100.f508268y = this.f508266y;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXf48f33eae5ff1bb1.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXf48f33eae5ff1bb1(Integer r100, Integer r110, Integer r111, Float r112, Float r113, ByteString r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public FuncParamsXf48f33eae5ff1bb1(Integer r100, Integer r101, Integer r102, Float r103, Float r104, ByteString r105, ByteString r106) {
        super(ADAPTER, r106);
        this.instance_id = r100;
        this.document_id = r101;
        this.document_version = r102;
        this.f508265x = r103;
        this.f508266y = r104;
        this._molten_ctx = r105;
    }
}
