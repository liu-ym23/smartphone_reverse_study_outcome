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
public final class FuncParamsX8cff7ec6f21a8edd extends Message<FuncParamsX8cff7ec6f21a8edd, Builder> {
    public static final ProtoAdapter<FuncParamsX8cff7ec6f21a8edd> ADAPTER = null;
    public static final Float DEFAULT_CONTAINER_WIDTH = null;
    public static final String DEFAULT_PROPERTY_STRING = "";
    public static final Integer DEFAULT_TYPE_ID = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Float container_width;
    public final String property_string;
    public final Integer type_id;

    public static final class Builder extends Message.Builder<FuncParamsX8cff7ec6f21a8edd, Builder> {
        public ByteString _molten_ctx;
        public Float container_width;
        public String property_string;
        public Integer type_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX8cff7ec6f21a8edd build() {
            Integer r100 = this.type_id;
            if (r100 == null) goto L11;
            if (this.container_width == null) goto L11;
            if (this.property_string == null) goto L11;
            return new FuncParamsX8cff7ec6f21a8edd(this.type_id, this.container_width, this.property_string, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "type_id", this.container_width, "container_width", this.property_string, "property_string"});
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

        public Builder container_width(Float r100) {
            this.container_width = r100;
            return this;
        }

        public Builder property_string(String r100) {
            this.property_string = r100;
            return this;
        }

        public Builder type_id(Integer r100) {
            this.type_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX8cff7ec6f21a8edd extends ProtoAdapter<FuncParamsX8cff7ec6f21a8edd> {
        public ProtoAdapter_FuncParamsX8cff7ec6f21a8edd() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX8cff7ec6f21a8edd.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX8cff7ec6f21a8edd decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.type_id = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.container_width = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.property_string = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsX8cff7ec6f21a8edd r100) {
            int r101 = (ProtoAdapter.UINT32.encodedSizeWithTag(1, r100.type_id) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, r100.container_width)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.property_string);
            ByteString r102 = r100._molten_ctx;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX8cff7ec6f21a8edd decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX8cff7ec6f21a8edd r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX8cff7ec6f21a8edd r101) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(r100, 1, r101.type_id);
            ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r101.container_width);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.property_string);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX8cff7ec6f21a8edd r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX8cff7ec6f21a8edd();
        DEFAULT_TYPE_ID = 0;
        DEFAULT_CONTAINER_WIDTH = Float.valueOf(0.0f);
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type_id = this.type_id;
        r100.container_width = this.container_width;
        r100.property_string = this.property_string;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX8cff7ec6f21a8edd.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX8cff7ec6f21a8edd(Integer r100, Float r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX8cff7ec6f21a8edd(Integer r100, Float r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.type_id = r100;
        this.container_width = r101;
        this.property_string = r102;
        this._molten_ctx = r103;
    }
}
