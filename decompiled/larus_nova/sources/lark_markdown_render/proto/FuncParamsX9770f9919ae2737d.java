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
public final class FuncParamsX9770f9919ae2737d extends Message<FuncParamsX9770f9919ae2737d, Builder> {
    public static final ProtoAdapter<FuncParamsX9770f9919ae2737d> ADAPTER = null;
    public static final Boolean DEFAULT_IS_DARK_MODE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Boolean is_dark_mode;

    public static final class Builder extends Message.Builder<FuncParamsX9770f9919ae2737d, Builder> {
        public ByteString _molten_ctx;
        public Boolean is_dark_mode;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX9770f9919ae2737d build() {
            Boolean r100 = this.is_dark_mode;
            if (r100 == null) goto L7;
            return new FuncParamsX9770f9919ae2737d(this.is_dark_mode, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_dark_mode"});
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

        public Builder is_dark_mode(Boolean r100) {
            this.is_dark_mode = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX9770f9919ae2737d extends ProtoAdapter<FuncParamsX9770f9919ae2737d> {
        public ProtoAdapter_FuncParamsX9770f9919ae2737d() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX9770f9919ae2737d.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX9770f9919ae2737d decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.is_dark_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 255) goto L9;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX9770f9919ae2737d r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.is_dark_mode);
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
        public /* bridge */ /* synthetic */ FuncParamsX9770f9919ae2737d decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX9770f9919ae2737d r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX9770f9919ae2737d r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.is_dark_mode);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX9770f9919ae2737d r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX9770f9919ae2737d();
        DEFAULT_IS_DARK_MODE = Boolean.FALSE;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_dark_mode = this.is_dark_mode;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX9770f9919ae2737d.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX9770f9919ae2737d(Boolean r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX9770f9919ae2737d(Boolean r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.is_dark_mode = r100;
        this._molten_ctx = r101;
    }
}
