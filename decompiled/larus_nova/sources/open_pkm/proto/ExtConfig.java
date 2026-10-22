package open_pkm.proto;

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
public final class ExtConfig extends Message<ExtConfig, Builder> {
    public static final ProtoAdapter<ExtConfig> ADAPTER = null;
    public static final String DEFAULT_MAIN_URL = "";
    public static final String DEFAULT_MIN_LARK_VERSION = "";
    public static final String DEFAULT_MOBILE_URL = "";
    public static final Boolean DEFAULT_OFFLINE_ENABLE = null;
    public static final String DEFAULT_PC_URL = "";
    public static final Long DEFAULT_PKG_ID = null;
    public static final String DEFAULT_VERSION = "";
    public static final String DEFAULT_V_HOST = "";
    private static final long serialVersionUID = 0;
    public final List<String> fallback_path_list;
    public final String main_url;
    public final String min_lark_version;
    public final String mobile_url;
    public final Boolean offline_enable;
    public final String pc_url;
    public final Long pkg_id;
    public final String v_host;
    public final String version;

    public static final class Builder extends Message.Builder<ExtConfig, Builder> {
        public List<String> fallback_path_list;
        public String main_url;
        public String min_lark_version;
        public String mobile_url;
        public Boolean offline_enable;
        public String pc_url;
        public Long pkg_id;
        public String v_host;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public ExtConfig build() {
            String r100 = this.pc_url;
            if (r100 == null) goto L19;
            if (this.mobile_url == null) goto L19;
            if (this.offline_enable == null) goto L19;
            if (this.min_lark_version == null) goto L19;
            if (this.v_host == null) goto L19;
            if (this.main_url == null) goto L19;
            if (this.pkg_id == null) goto L19;
            return new ExtConfig(this.pc_url, this.mobile_url, this.offline_enable, this.version, this.min_lark_version, this.v_host, this.main_url, this.pkg_id, this.fallback_path_list, super.buildUnknownFields());
        L19:
            throw Internal.missingRequiredFields(new Object[]{r100, "pc_url", this.mobile_url, "mobile_url", this.offline_enable, "offline_enable", this.min_lark_version, "min_lark_version", this.v_host, "v_host", this.main_url, "main_url", this.pkg_id, "pkg_id"});
        }

        public Builder() {
            this.fallback_path_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fallback_path_list(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.fallback_path_list = r100;
            return this;
        }

        public Builder main_url(String r100) {
            this.main_url = r100;
            return this;
        }

        public Builder min_lark_version(String r100) {
            this.min_lark_version = r100;
            return this;
        }

        public Builder mobile_url(String r100) {
            this.mobile_url = r100;
            return this;
        }

        public Builder offline_enable(Boolean r100) {
            this.offline_enable = r100;
            return this;
        }

        public Builder pc_url(String r100) {
            this.pc_url = r100;
            return this;
        }

        public Builder pkg_id(Long r100) {
            this.pkg_id = r100;
            return this;
        }

        public Builder v_host(String r100) {
            this.v_host = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtConfig extends ProtoAdapter<ExtConfig> {
        public ProtoAdapter_ExtConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ExtConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.fallback_path_list.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.pkg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.main_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.v_host = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.min_lark_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.offline_enable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.mobile_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.pc_url = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ExtConfig r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.pc_url) + r101.encodedSizeWithTag(2, r100.mobile_url)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.offline_enable);
            String r103 = r100.version;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(4, r103);
        L7:
            return ((((((r102 + r104) + r101.encodedSizeWithTag(5, r100.min_lark_version)) + r101.encodedSizeWithTag(6, r100.v_host)) + r101.encodedSizeWithTag(7, r100.main_url)) + ProtoAdapter.INT64.encodedSizeWithTag(8, r100.pkg_id)) + r101.asRepeated().encodedSizeWithTag(9, r100.fallback_path_list)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExtConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtConfig r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.pc_url);
            r102.encodeWithTag(r100, 2, r101.mobile_url);
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.offline_enable);
            String r103 = r101.version;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            r102.encodeWithTag(r100, 5, r101.min_lark_version);
            r102.encodeWithTag(r100, 6, r101.v_host);
            r102.encodeWithTag(r100, 7, r101.main_url);
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r101.pkg_id);
            r102.asRepeated().encodeWithTag(r100, 9, r101.fallback_path_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtConfig();
        DEFAULT_OFFLINE_ENABLE = Boolean.FALSE;
        DEFAULT_PKG_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pc_url = this.pc_url;
        r100.mobile_url = this.mobile_url;
        r100.offline_enable = this.offline_enable;
        r100.version = this.version;
        r100.min_lark_version = this.min_lark_version;
        r100.v_host = this.v_host;
        r100.main_url = this.main_url;
        r100.pkg_id = this.pkg_id;
        r100.fallback_path_list = Internal.copyOf("fallback_path_list", this.fallback_path_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtConfig(String r110, String r111, Boolean r112, String r113, String r114, String r115, String r116, Long r117, List<String> r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public ExtConfig(String r100, String r101, Boolean r102, String r103, String r104, String r105, String r106, Long r107, List<String> r110, ByteString r111) {
        super(ADAPTER, r111);
        this.pc_url = r100;
        this.mobile_url = r101;
        this.offline_enable = r102;
        this.version = r103;
        this.min_lark_version = r104;
        this.v_host = r105;
        this.main_url = r106;
        this.pkg_id = r107;
        this.fallback_path_list = Internal.immutableCopyOf("fallback_path_list", r110);
    }
}
