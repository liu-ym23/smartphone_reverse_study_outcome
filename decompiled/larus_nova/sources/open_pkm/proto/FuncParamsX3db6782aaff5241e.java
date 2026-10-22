package open_pkm.proto;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX3db6782aaff5241e extends Message<FuncParamsX3db6782aaff5241e, Builder> {
    public static final ProtoAdapter<FuncParamsX3db6782aaff5241e> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final PkmPackage pkg;
    public final TtPkgHeader pkg_header;
    public final UniqueId unique_id;

    public static final class Builder extends Message.Builder<FuncParamsX3db6782aaff5241e, Builder> {
        public ByteString _molten_ctx;
        public PkmPackage pkg;
        public TtPkgHeader pkg_header;
        public UniqueId unique_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX3db6782aaff5241e build() {
            UniqueId r100 = this.unique_id;
            if (r100 == null) goto L11;
            if (this.pkg == null) goto L11;
            if (this.pkg_header == null) goto L11;
            return new FuncParamsX3db6782aaff5241e(this.unique_id, this.pkg, this.pkg_header, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, BdpAppEventConstant.PARAMS_UNIQUEID, this.pkg, "pkg", this.pkg_header, "pkg_header"});
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

        public Builder pkg(PkmPackage r100) {
            this.pkg = r100;
            return this;
        }

        public Builder pkg_header(TtPkgHeader r100) {
            this.pkg_header = r100;
            return this;
        }

        public Builder unique_id(UniqueId r100) {
            this.unique_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX3db6782aaff5241e extends ProtoAdapter<FuncParamsX3db6782aaff5241e> {
        public ProtoAdapter_FuncParamsX3db6782aaff5241e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX3db6782aaff5241e.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX3db6782aaff5241e decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.unique_id = UniqueId.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.pkg = PkmPackage.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.pkg_header = TtPkgHeader.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncParamsX3db6782aaff5241e r100) {
            int r101 = (UniqueId.ADAPTER.encodedSizeWithTag(1, r100.unique_id) + PkmPackage.ADAPTER.encodedSizeWithTag(2, r100.pkg)) + TtPkgHeader.ADAPTER.encodedSizeWithTag(3, r100.pkg_header);
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
        public /* bridge */ /* synthetic */ FuncParamsX3db6782aaff5241e decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX3db6782aaff5241e r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX3db6782aaff5241e r101) throws IOException {
            UniqueId.ADAPTER.encodeWithTag(r100, 1, r101.unique_id);
            PkmPackage.ADAPTER.encodeWithTag(r100, 2, r101.pkg);
            TtPkgHeader.ADAPTER.encodeWithTag(r100, 3, r101.pkg_header);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX3db6782aaff5241e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX3db6782aaff5241e();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_id = this.unique_id;
        r100.pkg = this.pkg;
        r100.pkg_header = this.pkg_header;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX3db6782aaff5241e.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX3db6782aaff5241e(UniqueId r100, PkmPackage r101, TtPkgHeader r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX3db6782aaff5241e(UniqueId r100, PkmPackage r101, TtPkgHeader r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.unique_id = r100;
        this.pkg = r101;
        this.pkg_header = r102;
        this._molten_ctx = r103;
    }
}
