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
public final class PackageDownloadContext extends Message<PackageDownloadContext, Builder> {
    public static final ProtoAdapter<PackageDownloadContext> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final PkmPackage pkg;
    public final UniqueId unique_id;

    public static final class Builder extends Message.Builder<PackageDownloadContext, Builder> {
        public PkmPackage pkg;
        public UniqueId unique_id;

        @Override // com.squareup.wire.Message.Builder
        public PackageDownloadContext build() {
            PkmPackage r100 = this.pkg;
            if (r100 == null) goto L9;
            if (this.unique_id == null) goto L9;
            return new PackageDownloadContext(this.pkg, this.unique_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "pkg", this.unique_id, BdpAppEventConstant.PARAMS_UNIQUEID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder pkg(PkmPackage r100) {
            this.pkg = r100;
            return this;
        }

        public Builder unique_id(UniqueId r100) {
            this.unique_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PackageDownloadContext extends ProtoAdapter<PackageDownloadContext> {
        public ProtoAdapter_PackageDownloadContext() {
            super(FieldEncoding.LENGTH_DELIMITED, PackageDownloadContext.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PackageDownloadContext decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.pkg = PkmPackage.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.unique_id = UniqueId.ADAPTER.decode(r100);
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
        public int encodedSize2(PackageDownloadContext r100) {
            return (PkmPackage.ADAPTER.encodedSizeWithTag(1, r100.pkg) + UniqueId.ADAPTER.encodedSizeWithTag(2, r100.unique_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PackageDownloadContext decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PackageDownloadContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PackageDownloadContext r101) throws IOException {
            PkmPackage.ADAPTER.encodeWithTag(r100, 1, r101.pkg);
            UniqueId.ADAPTER.encodeWithTag(r100, 2, r101.unique_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PackageDownloadContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PackageDownloadContext();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pkg = this.pkg;
        r100.unique_id = this.unique_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PackageDownloadContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PackageDownloadContext(PkmPackage r100, UniqueId r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PackageDownloadContext(PkmPackage r100, UniqueId r101, ByteString r102) {
        super(ADAPTER, r102);
        this.pkg = r100;
        this.unique_id = r101;
    }
}
