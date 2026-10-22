package open_pkm.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class TtPkgHeader extends Message<TtPkgHeader, Builder> {
    public static final ProtoAdapter<TtPkgHeader> ADAPTER = null;
    public static final String DEFAULT_PKG_INFO = "";
    public static final String DEFAULT_TAG = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Map<String, FileInfo> file_infos;
    public final String pkg_info;
    public final String tag;
    public final Long version;

    public static final class Builder extends Message.Builder<TtPkgHeader, Builder> {
        public Map<String, FileInfo> file_infos;
        public String pkg_info;
        public String tag;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public TtPkgHeader build() {
            String r100 = this.tag;
            if (r100 == null) goto L11;
            if (this.version == null) goto L11;
            if (this.pkg_info == null) goto L11;
            return new TtPkgHeader(this.tag, this.version, this.pkg_info, this.file_infos, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "tag", this.version, "version", this.pkg_info, "pkg_info"});
        }

        public Builder() {
            this.file_infos = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file_infos(Map<String, FileInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.file_infos = r100;
            return this;
        }

        public Builder pkg_info(String r100) {
            this.pkg_info = r100;
            return this;
        }

        public Builder tag(String r100) {
            this.tag = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TtPkgHeader extends ProtoAdapter<TtPkgHeader> {
        private final ProtoAdapter<Map<String, FileInfo>> file_infos;

        public ProtoAdapter_TtPkgHeader() {
            super(FieldEncoding.LENGTH_DELIMITED, TtPkgHeader.class);
            this.file_infos = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, FileInfo.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TtPkgHeader decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.tag = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.pkg_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.file_infos.putAll(this.file_infos.decode(r100));
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
        public int encodedSize2(TtPkgHeader r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.tag) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.version)) + r101.encodedSizeWithTag(3, r100.pkg_info)) + this.file_infos.encodedSizeWithTag(4, r100.file_infos)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TtPkgHeader decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TtPkgHeader r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TtPkgHeader r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.tag);
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.version);
            r102.encodeWithTag(r100, 3, r101.pkg_info);
            this.file_infos.encodeWithTag(r100, 4, r101.file_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TtPkgHeader r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TtPkgHeader();
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tag = this.tag;
        r100.version = this.version;
        r100.pkg_info = this.pkg_info;
        r100.file_infos = Internal.copyOf("file_infos", this.file_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TtPkgHeader.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TtPkgHeader(String r100, Long r101, String r102, Map<String, FileInfo> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TtPkgHeader(String r100, Long r101, String r102, Map<String, FileInfo> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.tag = r100;
        this.version = r101;
        this.pkg_info = r102;
        this.file_infos = Internal.immutableCopyOf("file_infos", r103);
    }
}
