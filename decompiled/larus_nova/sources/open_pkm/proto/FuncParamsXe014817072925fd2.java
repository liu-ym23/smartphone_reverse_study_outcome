package open_pkm.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXe014817072925fd2 extends Message<FuncParamsXe014817072925fd2, Builder> {
    public static final ProtoAdapter<FuncParamsXe014817072925fd2> ADAPTER = null;
    public static final ByteString DEFAULT_ZIP_CONTENT = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final ByteString zip_content;

    public static final class Builder extends Message.Builder<FuncParamsXe014817072925fd2, Builder> {
        public ByteString _molten_ctx;
        public ByteString zip_content;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXe014817072925fd2 build() {
            ByteString r100 = this.zip_content;
            if (r100 == null) goto L7;
            return new FuncParamsXe014817072925fd2(this.zip_content, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "zip_content"});
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

        public Builder zip_content(ByteString r100) {
            this.zip_content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXe014817072925fd2 extends ProtoAdapter<FuncParamsXe014817072925fd2> {
        public ProtoAdapter_FuncParamsXe014817072925fd2() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXe014817072925fd2.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXe014817072925fd2 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.zip_content = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsXe014817072925fd2 r100) {
            ProtoAdapter<ByteString> r101 = ProtoAdapter.BYTES;
            int r102 = r101.encodedSizeWithTag(1, r100.zip_content);
            ByteString r103 = r100._molten_ctx;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(255, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXe014817072925fd2 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXe014817072925fd2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXe014817072925fd2 r101) throws IOException {
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            r102.encodeWithTag(r100, 1, r101.zip_content);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXe014817072925fd2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXe014817072925fd2();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_ZIP_CONTENT = r100;
        DEFAULT__MOLTEN_CTX = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.zip_content = this.zip_content;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXe014817072925fd2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXe014817072925fd2(ByteString r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsXe014817072925fd2(ByteString r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.zip_content = r100;
        this._molten_ctx = r101;
    }
}
