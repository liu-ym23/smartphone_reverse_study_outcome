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
public final class FuncParamsX5bf630a906d91308 extends Message<FuncParamsX5bf630a906d91308, Builder> {
    public static final ProtoAdapter<FuncParamsX5bf630a906d91308> ADAPTER = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final String DEFAULT_PACKAGE_NAME = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final ByteString data;
    public final PkmError err;
    public final FileInfo file_info;
    public final String package_name;

    public static final class Builder extends Message.Builder<FuncParamsX5bf630a906d91308, Builder> {
        public ByteString _molten_ctx;
        public ByteString data;
        public PkmError err;
        public FileInfo file_info;
        public String package_name;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX5bf630a906d91308 build() {
            ByteString r100 = this.data;
            if (r100 == null) goto L11;
            if (this.file_info == null) goto L11;
            if (this.package_name == null) goto L11;
            return new FuncParamsX5bf630a906d91308(this.data, this.file_info, this.package_name, this.err, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "data", this.file_info, "file_info", this.package_name, "package_name"});
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

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }

        public Builder err(PkmError r100) {
            this.err = r100;
            return this;
        }

        public Builder file_info(FileInfo r100) {
            this.file_info = r100;
            return this;
        }

        public Builder package_name(String r100) {
            this.package_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX5bf630a906d91308 extends ProtoAdapter<FuncParamsX5bf630a906d91308> {
        public ProtoAdapter_FuncParamsX5bf630a906d91308() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX5bf630a906d91308.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX5bf630a906d91308 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.file_info = FileInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.package_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.err = PkmError.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 255) goto L15;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX5bf630a906d91308 r100) {
            ProtoAdapter<ByteString> r101 = ProtoAdapter.BYTES;
            int r102 = (r101.encodedSizeWithTag(1, r100.data) + FileInfo.ADAPTER.encodedSizeWithTag(2, r100.file_info)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.package_name);
            PkmError r103 = r100.err;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = PkmError.ADAPTER.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            ByteString r107 = r100._molten_ctx;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(255, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX5bf630a906d91308 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX5bf630a906d91308 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX5bf630a906d91308 r101) throws IOException {
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            r102.encodeWithTag(r100, 1, r101.data);
            FileInfo.ADAPTER.encodeWithTag(r100, 2, r101.file_info);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.package_name);
            PkmError r103 = r101.err;
            if (r103 == null) goto L5;
            PkmError.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 255, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX5bf630a906d91308 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX5bf630a906d91308();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_DATA = r100;
        DEFAULT__MOLTEN_CTX = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data = this.data;
        r100.file_info = this.file_info;
        r100.package_name = this.package_name;
        r100.err = this.err;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX5bf630a906d91308.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX5bf630a906d91308(ByteString r100, FileInfo r101, String r110, PkmError r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsX5bf630a906d91308(ByteString r100, FileInfo r101, String r102, PkmError r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.data = r100;
        this.file_info = r101;
        this.package_name = r102;
        this.err = r103;
        this._molten_ctx = r104;
    }
}
