package open_pkm.proto;

import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
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
public final class PkmMeta extends Message<PkmMeta, Builder> {
    public static final ProtoAdapter<PkmMeta> ADAPTER = null;
    public static final String DEFAULT_APP_VERSION = "";
    public static final Boolean DEFAULT_IS_PREVIEW = null;
    private static final long serialVersionUID = 0;
    public final String app_version;
    public final Boolean is_preview;
    public final MetaInfo meta;
    public final PkmPackage pkg;
    public final UniqueId unique_id;

    public static final class Builder extends Message.Builder<PkmMeta, Builder> {
        public String app_version;
        public Boolean is_preview;
        public MetaInfo meta;
        public PkmPackage pkg;
        public UniqueId unique_id;

        @Override // com.squareup.wire.Message.Builder
        public PkmMeta build() {
            UniqueId r100 = this.unique_id;
            if (r100 == null) goto L15;
            if (this.is_preview == null) goto L15;
            if (this.meta == null) goto L15;
            if (this.app_version == null) goto L15;
            if (this.pkg == null) goto L15;
            return new PkmMeta(this.unique_id, this.is_preview, this.meta, this.app_version, this.pkg, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, BdpAppEventConstant.PARAMS_UNIQUEID, this.is_preview, VrBgLogData.KEY_IS_PREVIEW, this.meta, "meta", this.app_version, "app_version", this.pkg, "pkg"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_version(String r100) {
            this.app_version = r100;
            return this;
        }

        public Builder is_preview(Boolean r100) {
            this.is_preview = r100;
            return this;
        }

        public Builder meta(MetaInfo r100) {
            this.meta = r100;
            return this;
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

    public static final class ProtoAdapter_PkmMeta extends ProtoAdapter<PkmMeta> {
        public ProtoAdapter_PkmMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, PkmMeta.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PkmMeta decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.unique_id = UniqueId.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_preview = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.meta = MetaInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.app_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.pkg = PkmPackage.ADAPTER.decode(r100);
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
        public int encodedSize2(PkmMeta r100) {
            return ((((UniqueId.ADAPTER.encodedSizeWithTag(1, r100.unique_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_preview)) + MetaInfo.ADAPTER.encodedSizeWithTag(3, r100.meta)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r100.app_version)) + PkmPackage.ADAPTER.encodedSizeWithTag(5, r100.pkg)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PkmMeta decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PkmMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PkmMeta r101) throws IOException {
            UniqueId.ADAPTER.encodeWithTag(r100, 1, r101.unique_id);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_preview);
            MetaInfo.ADAPTER.encodeWithTag(r100, 3, r101.meta);
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r101.app_version);
            PkmPackage.ADAPTER.encodeWithTag(r100, 5, r101.pkg);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PkmMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PkmMeta();
        DEFAULT_IS_PREVIEW = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_id = this.unique_id;
        r100.is_preview = this.is_preview;
        r100.meta = this.meta;
        r100.app_version = this.app_version;
        r100.pkg = this.pkg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PkmMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PkmMeta(UniqueId r100, Boolean r101, MetaInfo r110, String r111, PkmPackage r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PkmMeta(UniqueId r100, Boolean r101, MetaInfo r102, String r103, PkmPackage r104, ByteString r105) {
        super(ADAPTER, r105);
        this.unique_id = r100;
        this.is_preview = r101;
        this.meta = r102;
        this.app_version = r103;
        this.pkg = r104;
    }
}
