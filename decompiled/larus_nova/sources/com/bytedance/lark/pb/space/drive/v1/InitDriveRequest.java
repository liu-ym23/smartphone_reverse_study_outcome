package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class InitDriveRequest extends Message<InitDriveRequest, Builder> {
    public static final ProtoAdapter<InitDriveRequest> ADAPTER = null;
    public static final String DEFAULT_DEVICE_ID = "";
    public static final Boolean DEFAULT_DISABLE_CDN_DOWNLOAD = null;
    public static final Boolean DEFAULT_DISABLE_SMART_UPLOAD = null;
    public static final EnvType DEFAULT_ENV = null;
    public static final Boolean DEFAULT_FOR_APP = null;
    public static final String DEFAULT_ROOT_PATH = "";
    public static final String DEFAULT_SESSION = "";
    public static final String DEFAULT_STORAGE_PATH = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final String DEFAULT_VERSION = "";
    public static final ProtoAdapter_InitDriveRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String device_id;
    public final Boolean disable_cdn_download;
    public final Boolean disable_smart_upload;
    public final DriveRustConfig drive_rust_config;
    public final EnvType env;
    public final Boolean for_app;
    public final String root_path;
    public final String session;
    public final String storage_path;
    public final String tenant_id;
    public final String user_id;
    public final String version;

    public static final class Builder extends Message.Builder<InitDriveRequest, Builder> implements d<InitDriveRequest> {
        public String device_id;
        public Boolean disable_cdn_download;
        public Boolean disable_smart_upload;
        public DriveRustConfig drive_rust_config;
        public EnvType env;
        public Boolean for_app;
        public String root_path;
        public String session;
        public String storage_path;
        public String tenant_id;
        public String user_id;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public InitDriveRequest build() {
            Boolean r100 = this.for_app;
            if (r100 == null) goto L13;
            if (this.storage_path == null) goto L13;
            if (this.user_id == null) goto L13;
            if (this.session == null) goto L13;
            return new InitDriveRequest(this.for_app, this.storage_path, this.user_id, this.session, this.env, this.device_id, this.version, this.root_path, this.disable_smart_upload, this.disable_cdn_download, this.drive_rust_config, this.tenant_id, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "for_app", this.storage_path, "storage_path", this.user_id, "user_id", this.session, AppbrandHostConstants.SCHEMA_INSPECT.SESSION});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder device_id(String r100) {
            this.device_id = r100;
            return this;
        }

        public Builder disable_cdn_download(Boolean r100) {
            this.disable_cdn_download = r100;
            return this;
        }

        public Builder disable_smart_upload(Boolean r100) {
            this.disable_smart_upload = r100;
            return this;
        }

        public Builder drive_rust_config(DriveRustConfig r100) {
            this.drive_rust_config = r100;
            return this;
        }

        public Builder env(EnvType r100) {
            this.env = r100;
            return this;
        }

        public Builder for_app(Boolean r100) {
            this.for_app = r100;
            return this;
        }

        public Builder root_path(String r100) {
            this.root_path = r100;
            return this;
        }

        public Builder session(String r100) {
            this.session = r100;
            return this;
        }

        public Builder storage_path(String r100) {
            this.storage_path = r100;
            return this;
        }

        public Builder tenant_id(String r100) {
            this.tenant_id = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final enum EnvType extends Enum<EnvType> implements WireEnum {
        private static final /* synthetic */ EnvType[] $VALUES = null;
        public static final ProtoAdapter<EnvType> ADAPTER = null;
        public static final EnvType ONLINE = null;
        public static final EnvType OVERSEA = null;
        public static final EnvType PRE_RELEASE = null;
        public static final EnvType STAGING = null;
        private final int value;

        static {
            EnvType r100 = new EnvType("ONLINE", 0, 1);
            ONLINE = r100;
            EnvType r101 = new EnvType("STAGING", 1, 2);
            STAGING = r101;
            EnvType r102 = new EnvType("PRE_RELEASE", 2, 3);
            PRE_RELEASE = r102;
            EnvType r103 = new EnvType("OVERSEA", 3, 4);
            OVERSEA = r103;
            $VALUES = new EnvType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(EnvType.class);
        }

        public static EnvType[] values() {
            return (EnvType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EnvType fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return OVERSEA;
        L15:
            return PRE_RELEASE;
        L17:
            return STAGING;
        L19:
            return ONLINE;
        }

        public static EnvType valueOf(String r100) {
            return (EnvType) a.a(EnvType.class, r100);
        }

        private EnvType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_InitDriveRequest extends ProtoAdapter<InitDriveRequest> implements c<InitDriveRequest> {
        public ProtoAdapter_InitDriveRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, InitDriveRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InitDriveRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.for_app = r102;
            r101.storage_path = "";
            r101.user_id = "";
            r101.session = "";
            r101.env = EnvType.ONLINE;
            r101.device_id = "";
            r101.version = "";
            r101.root_path = "";
            r101.disable_smart_upload = r102;
            r101.disable_cdn_download = r102;
            r101.tenant_id = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L22;
            switch(r104) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L24;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L24:
            r101.env = EnvType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.drive_rust_config = DriveRustConfig.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.disable_cdn_download = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.disable_smart_upload = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.root_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.session = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.storage_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.for_app = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(InitDriveRequest r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            int r102 = r101.encodedSizeWithTag(1, r100.for_app);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            int r104 = ((r102 + r103.encodedSizeWithTag(2, r100.storage_path)) + r103.encodedSizeWithTag(3, r100.user_id)) + r103.encodedSizeWithTag(4, r100.session);
            EnvType r105 = r100.env;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = EnvType.ADAPTER.encodedSizeWithTag(5, r105);
        L6:
            int r108 = r104 + r107;
            String r109 = r100.device_id;
            if (r109 == null) goto L9;
            int r110 = r103.encodedSizeWithTag(6, r109);
        L10:
            int r111 = r108 + r110;
            String r112 = r100.version;
            if (r112 == null) goto L13;
            int r113 = r103.encodedSizeWithTag(7, r112);
        L14:
            int r114 = r111 + r113;
            String r115 = r100.root_path;
            if (r115 == null) goto L17;
            int r116 = r103.encodedSizeWithTag(8, r115);
        L18:
            int r117 = r114 + r116;
            Boolean r118 = r100.disable_smart_upload;
            if (r118 == null) goto L21;
            int r119 = r101.encodedSizeWithTag(9, r118);
        L22:
            int r120 = r117 + r119;
            Boolean r121 = r100.disable_cdn_download;
            if (r121 == null) goto L25;
            int r122 = r101.encodedSizeWithTag(10, r121);
        L26:
            int r123 = r120 + r122;
            DriveRustConfig r124 = r100.drive_rust_config;
            if (r124 == null) goto L29;
            int r125 = DriveRustConfig.ADAPTER.encodedSizeWithTag(11, r124);
        L30:
            int r126 = r123 + r125;
            String r127 = r100.tenant_id;
            if (r127 == null) goto L34;
            r106 = r103.encodedSizeWithTag(12, r127);
        L34:
            return (r126 + r106) + r100.unknownFields().size();
        L29:
            r125 = 0;
            goto L30
        L25:
            r122 = 0;
            goto L26
        L21:
            r119 = 0;
            goto L22
        L17:
            r116 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ InitDriveRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InitDriveRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InitDriveRequest r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.for_app);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 2, r101.storage_path);
            r103.encodeWithTag(r100, 3, r101.user_id);
            r103.encodeWithTag(r100, 4, r101.session);
            EnvType r104 = r101.env;
            if (r104 == null) goto L5;
            EnvType.ADAPTER.encodeWithTag(r100, 5, r104);
        L5:
            String r105 = r101.device_id;
            if (r105 == null) goto L8;
            r103.encodeWithTag(r100, 6, r105);
        L8:
            String r106 = r101.version;
            if (r106 == null) goto L11;
            r103.encodeWithTag(r100, 7, r106);
        L11:
            String r107 = r101.root_path;
            if (r107 == null) goto L14;
            r103.encodeWithTag(r100, 8, r107);
        L14:
            Boolean r108 = r101.disable_smart_upload;
            if (r108 == null) goto L17;
            r102.encodeWithTag(r100, 9, r108);
        L17:
            Boolean r109 = r101.disable_cdn_download;
            if (r109 == null) goto L20;
            r102.encodeWithTag(r100, 10, r109);
        L20:
            DriveRustConfig r110 = r101.drive_rust_config;
            if (r110 == null) goto L23;
            DriveRustConfig.ADAPTER.encodeWithTag(r100, 11, r110);
        L23:
            String r111 = r101.tenant_id;
            if (r111 == null) goto L26;
            r103.encodeWithTag(r100, 12, r111);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InitDriveRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_InitDriveRequest r100 = new ProtoAdapter_InitDriveRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_FOR_APP = r101;
        DEFAULT_ENV = EnvType.ONLINE;
        DEFAULT_DISABLE_SMART_UPLOAD = r101;
        DEFAULT_DISABLE_CDN_DOWNLOAD = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.for_app = this.for_app;
        r100.storage_path = this.storage_path;
        r100.user_id = this.user_id;
        r100.session = this.session;
        r100.env = this.env;
        r100.device_id = this.device_id;
        r100.version = this.version;
        r100.root_path = this.root_path;
        r100.disable_smart_upload = this.disable_smart_upload;
        r100.disable_cdn_download = this.disable_cdn_download;
        r100.drive_rust_config = this.drive_rust_config;
        r100.tenant_id = this.tenant_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InitDriveRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InitDriveRequest(Boolean r110, String r111, String r112, String r113, EnvType r114, String r210, String r211, String r212, Boolean r213, Boolean r214, DriveRustConfig r215, String r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public InitDriveRequest(Boolean r100, String r101, String r102, String r103, EnvType r104, String r105, String r106, String r107, Boolean r110, Boolean r111, DriveRustConfig r112, String r113, ByteString r114) {
        super(ADAPTER, r114);
        this.for_app = r100;
        this.storage_path = r101;
        this.user_id = r102;
        this.session = r103;
        this.env = r104;
        this.device_id = r105;
        this.version = r106;
        this.root_path = r107;
        this.disable_smart_upload = r110;
        this.disable_cdn_download = r111;
        this.drive_rust_config = r112;
        this.tenant_id = r113;
    }
}
