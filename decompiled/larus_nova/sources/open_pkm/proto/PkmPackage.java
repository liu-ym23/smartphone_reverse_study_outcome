package open_pkm.proto;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class PkmPackage extends Message<PkmPackage, Builder> {
    public static final ProtoAdapter<PkmPackage> ADAPTER = null;
    public static final String DEFAULT_MD5 = "";
    public static final String DEFAULT_PKG_NAME = "";
    public static final PkgType DEFAULT_PKG_TYPE = null;
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    public final String f524834md5;
    public final String pkg_name;
    public final PkgType pkg_type;
    public final List<String> pkg_url_list;
    public final UniqueId unique_id;
    public final String version;

    public static final class Builder extends Message.Builder<PkmPackage, Builder> {

        /* JADX INFO: renamed from: md5, reason: collision with root package name */
        public String f524835md5;
        public String pkg_name;
        public PkgType pkg_type;
        public List<String> pkg_url_list;
        public UniqueId unique_id;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public PkmPackage build() {
            UniqueId r100 = this.unique_id;
            if (r100 == null) goto L15;
            if (this.pkg_type == null) goto L15;
            if (this.pkg_name == null) goto L15;
            if (this.f524835md5 == null) goto L15;
            if (this.version == null) goto L15;
            return new PkmPackage(this.unique_id, this.pkg_type, this.pkg_name, this.f524835md5, this.version, this.pkg_url_list, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, BdpAppEventConstant.PARAMS_UNIQUEID, this.pkg_type, "pkg_type", this.pkg_name, "pkg_name", this.f524835md5, "md5", this.version, "version"});
        }

        public Builder() {
            this.pkg_url_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder md5(String r100) {
            this.f524835md5 = r100;
            return this;
        }

        public Builder pkg_name(String r100) {
            this.pkg_name = r100;
            return this;
        }

        public Builder pkg_type(PkgType r100) {
            this.pkg_type = r100;
            return this;
        }

        public Builder pkg_url_list(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.pkg_url_list = r100;
            return this;
        }

        public Builder unique_id(UniqueId r100) {
            this.unique_id = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PkmPackage extends ProtoAdapter<PkmPackage> {
        public ProtoAdapter_PkmPackage() {
            super(FieldEncoding.LENGTH_DELIMITED, PkmPackage.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PkmPackage decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L18;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.pkg_type = PkgType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.pkg_url_list.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.f524835md5 = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.pkg_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.unique_id = UniqueId.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PkmPackage r100) {
            int r101 = UniqueId.ADAPTER.encodedSizeWithTag(1, r100.unique_id) + PkgType.ADAPTER.encodedSizeWithTag(2, r100.pkg_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((((r101 + r102.encodedSizeWithTag(3, r100.pkg_name)) + r102.encodedSizeWithTag(4, r100.f524834md5)) + r102.encodedSizeWithTag(5, r100.version)) + r102.asRepeated().encodedSizeWithTag(6, r100.pkg_url_list)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PkmPackage decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PkmPackage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PkmPackage r101) throws IOException {
            UniqueId.ADAPTER.encodeWithTag(r100, 1, r101.unique_id);
            PkgType.ADAPTER.encodeWithTag(r100, 2, r101.pkg_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 3, r101.pkg_name);
            r102.encodeWithTag(r100, 4, r101.f524834md5);
            r102.encodeWithTag(r100, 5, r101.version);
            r102.asRepeated().encodeWithTag(r100, 6, r101.pkg_url_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PkmPackage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PkmPackage();
        DEFAULT_PKG_TYPE = PkgType.VAR_PKG_TYPE_COMMON;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_id = this.unique_id;
        r100.pkg_type = this.pkg_type;
        r100.pkg_name = this.pkg_name;
        r100.f524835md5 = this.f524834md5;
        r100.version = this.version;
        r100.pkg_url_list = Internal.copyOf("pkg_url_list", this.pkg_url_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PkmPackage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PkmPackage(UniqueId r100, PkgType r110, String r111, String r112, String r113, List<String> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public PkmPackage(UniqueId r100, PkgType r101, String r102, String r103, String r104, List<String> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.unique_id = r100;
        this.pkg_type = r101;
        this.pkg_name = r102;
        this.f524834md5 = r103;
        this.version = r104;
        this.pkg_url_list = Internal.immutableCopyOf("pkg_url_list", r105);
    }
}
