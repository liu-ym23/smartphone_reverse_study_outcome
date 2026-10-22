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
public final class FuncParamsX9cdbe2b96ec2b9d9 extends Message<FuncParamsX9cdbe2b96ec2b9d9, Builder> {
    public static final ProtoAdapter<FuncParamsX9cdbe2b96ec2b9d9> ADAPTER = null;
    public static final Integer DEFAULT_DEVICE_TYPE = null;
    public static final Boolean DEFAULT_IS_DARK_MODE = null;
    public static final Float DEFAULT_ZOOM_LEVEL = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Integer device_type;
    public final Boolean is_dark_mode;
    public final Float zoom_level;

    public static final class Builder extends Message.Builder<FuncParamsX9cdbe2b96ec2b9d9, Builder> {
        public ByteString _molten_ctx;
        public Integer device_type;
        public Boolean is_dark_mode;
        public Float zoom_level;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX9cdbe2b96ec2b9d9 build() {
            Integer r100 = this.device_type;
            if (r100 == null) goto L11;
            if (this.is_dark_mode == null) goto L11;
            if (this.zoom_level == null) goto L11;
            return new FuncParamsX9cdbe2b96ec2b9d9(this.device_type, this.is_dark_mode, this.zoom_level, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "device_type", this.is_dark_mode, "is_dark_mode", this.zoom_level, "zoom_level"});
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

        public Builder device_type(Integer r100) {
            this.device_type = r100;
            return this;
        }

        public Builder is_dark_mode(Boolean r100) {
            this.is_dark_mode = r100;
            return this;
        }

        public Builder zoom_level(Float r100) {
            this.zoom_level = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX9cdbe2b96ec2b9d9 extends ProtoAdapter<FuncParamsX9cdbe2b96ec2b9d9> {
        public ProtoAdapter_FuncParamsX9cdbe2b96ec2b9d9() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX9cdbe2b96ec2b9d9.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX9cdbe2b96ec2b9d9 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.device_type = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_dark_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.zoom_level = ProtoAdapter.FLOAT.decode(r100);
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
        public int encodedSize2(FuncParamsX9cdbe2b96ec2b9d9 r100) {
            int r101 = (ProtoAdapter.UINT32.encodedSizeWithTag(1, r100.device_type) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_dark_mode)) + ProtoAdapter.FLOAT.encodedSizeWithTag(3, r100.zoom_level);
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
        public /* bridge */ /* synthetic */ FuncParamsX9cdbe2b96ec2b9d9 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX9cdbe2b96ec2b9d9 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX9cdbe2b96ec2b9d9 r101) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(r100, 1, r101.device_type);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_dark_mode);
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r101.zoom_level);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX9cdbe2b96ec2b9d9 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX9cdbe2b96ec2b9d9();
        DEFAULT_DEVICE_TYPE = 0;
        DEFAULT_IS_DARK_MODE = Boolean.FALSE;
        DEFAULT_ZOOM_LEVEL = Float.valueOf(0.0f);
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.device_type = this.device_type;
        r100.is_dark_mode = this.is_dark_mode;
        r100.zoom_level = this.zoom_level;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX9cdbe2b96ec2b9d9.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX9cdbe2b96ec2b9d9(Integer r100, Boolean r101, Float r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX9cdbe2b96ec2b9d9(Integer r100, Boolean r101, Float r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.device_type = r100;
        this.is_dark_mode = r101;
        this.zoom_level = r102;
        this._molten_ctx = r103;
    }
}
