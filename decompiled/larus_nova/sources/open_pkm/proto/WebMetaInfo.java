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
public final class WebMetaInfo extends Message<WebMetaInfo, Builder> {
    public static final ProtoAdapter<WebMetaInfo> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_BOT_ID = "";
    public static final String DEFAULT_EXTENSION_ID = "";
    public static final String DEFAULT_EXTENSION_TYPE = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final String bot_id;
    public final ExtConfig ext_config;
    public final String extension_id;
    public final String extension_type;
    public final String icon;
    public final String name;
    public final WebOfflinePkg offline_pkg;
    public final String version;

    public static final class Builder extends Message.Builder<WebMetaInfo, Builder> {
        public String app_id;
        public String bot_id;
        public ExtConfig ext_config;
        public String extension_id;
        public String extension_type;
        public String icon;
        public String name;
        public WebOfflinePkg offline_pkg;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public WebMetaInfo build() {
            String r100 = this.version;
            if (r100 == null) goto L23;
            if (this.app_id == null) goto L23;
            if (this.bot_id == null) goto L23;
            if (this.icon == null) goto L23;
            if (this.name == null) goto L23;
            if (this.extension_type == null) goto L23;
            if (this.extension_id == null) goto L23;
            if (this.ext_config == null) goto L23;
            if (this.offline_pkg == null) goto L23;
            return new WebMetaInfo(this.version, this.app_id, this.bot_id, this.icon, this.name, this.extension_type, this.extension_id, this.ext_config, this.offline_pkg, super.buildUnknownFields());
        L23:
            throw Internal.missingRequiredFields(new Object[]{r100, "version", this.app_id, "app_id", this.bot_id, "bot_id", this.icon, "icon", this.name, "name", this.extension_type, "extension_type", this.extension_id, "extension_id", this.ext_config, "ext_config", this.offline_pkg, "offline_pkg"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder bot_id(String r100) {
            this.bot_id = r100;
            return this;
        }

        public Builder ext_config(ExtConfig r100) {
            this.ext_config = r100;
            return this;
        }

        public Builder extension_id(String r100) {
            this.extension_id = r100;
            return this;
        }

        public Builder extension_type(String r100) {
            this.extension_type = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder offline_pkg(WebOfflinePkg r100) {
            this.offline_pkg = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WebMetaInfo extends ProtoAdapter<WebMetaInfo> {
        public ProtoAdapter_WebMetaInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WebMetaInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public WebMetaInfo decode2(ProtoReader r100) throws IOException {
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
            r101.offline_pkg = WebOfflinePkg.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.ext_config = ExtConfig.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.extension_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.extension_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.bot_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.version = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(WebMetaInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((((((((r101.encodedSizeWithTag(1, r100.version) + r101.encodedSizeWithTag(2, r100.app_id)) + r101.encodedSizeWithTag(3, r100.bot_id)) + r101.encodedSizeWithTag(4, r100.icon)) + r101.encodedSizeWithTag(5, r100.name)) + r101.encodedSizeWithTag(6, r100.extension_type)) + r101.encodedSizeWithTag(7, r100.extension_id)) + ExtConfig.ADAPTER.encodedSizeWithTag(8, r100.ext_config)) + WebOfflinePkg.ADAPTER.encodedSizeWithTag(9, r100.offline_pkg)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WebMetaInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WebMetaInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WebMetaInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.version);
            r102.encodeWithTag(r100, 2, r101.app_id);
            r102.encodeWithTag(r100, 3, r101.bot_id);
            r102.encodeWithTag(r100, 4, r101.icon);
            r102.encodeWithTag(r100, 5, r101.name);
            r102.encodeWithTag(r100, 6, r101.extension_type);
            r102.encodeWithTag(r100, 7, r101.extension_id);
            ExtConfig.ADAPTER.encodeWithTag(r100, 8, r101.ext_config);
            WebOfflinePkg.ADAPTER.encodeWithTag(r100, 9, r101.offline_pkg);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WebMetaInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WebMetaInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.version = this.version;
        r100.app_id = this.app_id;
        r100.bot_id = this.bot_id;
        r100.icon = this.icon;
        r100.name = this.name;
        r100.extension_type = this.extension_type;
        r100.extension_id = this.extension_id;
        r100.ext_config = this.ext_config;
        r100.offline_pkg = this.offline_pkg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WebMetaInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WebMetaInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, ExtConfig r117, WebOfflinePkg r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public WebMetaInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, ExtConfig r107, WebOfflinePkg r110, ByteString r111) {
        super(ADAPTER, r111);
        this.version = r100;
        this.app_id = r101;
        this.bot_id = r102;
        this.icon = r103;
        this.name = r104;
        this.extension_type = r105;
        this.extension_id = r106;
        this.ext_config = r107;
        this.offline_pkg = r110;
    }
}
