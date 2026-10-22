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
public final class FuncParamsXdb4ee1acb5817725 extends Message<FuncParamsXdb4ee1acb5817725, Builder> {
    public static final ProtoAdapter<FuncParamsXdb4ee1acb5817725> ADAPTER = null;
    public static final Long DEFAULT_FILE_HANDLE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final PkmError err;
    public final Long file_handle;

    public static final class Builder extends Message.Builder<FuncParamsXdb4ee1acb5817725, Builder> {
        public ByteString _molten_ctx;
        public PkmError err;
        public Long file_handle;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXdb4ee1acb5817725 build() {
            Long r100 = this.file_handle;
            if (r100 == null) goto L7;
            return new FuncParamsXdb4ee1acb5817725(this.file_handle, this.err, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "file_handle"});
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

        public Builder err(PkmError r100) {
            this.err = r100;
            return this;
        }

        public Builder file_handle(Long r100) {
            this.file_handle = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXdb4ee1acb5817725 extends ProtoAdapter<FuncParamsXdb4ee1acb5817725> {
        public ProtoAdapter_FuncParamsXdb4ee1acb5817725() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXdb4ee1acb5817725.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXdb4ee1acb5817725 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.file_handle = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.err = PkmError.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 255) goto L11;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXdb4ee1acb5817725 r100) {
            int r101 = ProtoAdapter.INT64.encodedSizeWithTag(1, r100.file_handle);
            PkmError r102 = r100.err;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = PkmError.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            ByteString r106 = r100._molten_ctx;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXdb4ee1acb5817725 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXdb4ee1acb5817725 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXdb4ee1acb5817725 r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.file_handle);
            PkmError r102 = r101.err;
            if (r102 == null) goto L5;
            PkmError.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXdb4ee1acb5817725 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXdb4ee1acb5817725();
        DEFAULT_FILE_HANDLE = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.file_handle = this.file_handle;
        r100.err = this.err;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXdb4ee1acb5817725.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXdb4ee1acb5817725(Long r100, PkmError r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsXdb4ee1acb5817725(Long r100, PkmError r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.file_handle = r100;
        this.err = r101;
        this._molten_ctx = r102;
    }
}
