package com.bytedance.lark.pb.device.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetDeviceRequest extends Message<SetDeviceRequest, Builder> {
    public static final ProtoAdapter<SetDeviceRequest> ADAPTER = null;
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_DEVICE_PLATFORM = "";
    public static final String DEFAULT_DEVICE_TYPE = "";
    public static final String DEFAULT_INSTALL_ID = "";
    public static final String DEFAULT_OS_VERSION = "";
    public static final ProtoAdapter_SetDeviceRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String app_name;
    public final String device_id;
    public final String device_platform;
    public final String device_type;
    public final String install_id;
    public final String os_version;
    public final Map<String, String> settings_queries;

    public static final class Builder extends Message.Builder<SetDeviceRequest, Builder> implements b<SetDeviceRequest> {
        public String app_name;
        public String device_id;
        public String device_platform;
        public String device_type;
        public String install_id;
        public String os_version;
        public Map<String, String> settings_queries;

        @Override // com.squareup.wire.Message.Builder
        public SetDeviceRequest build() {
            String r100 = this.device_id;
            if (r100 == null) goto L7;
            return new SetDeviceRequest(this.device_id, this.install_id, this.os_version, this.device_type, this.settings_queries, this.app_name, this.device_platform, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "device_id"});
        }

        public Builder() {
            this.settings_queries = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_name(String r100) {
            this.app_name = r100;
            return this;
        }

        public Builder device_id(String r100) {
            this.device_id = r100;
            return this;
        }

        public Builder device_platform(String r100) {
            this.device_platform = r100;
            return this;
        }

        public Builder device_type(String r100) {
            this.device_type = r100;
            return this;
        }

        public Builder install_id(String r100) {
            this.install_id = r100;
            return this;
        }

        public Builder os_version(String r100) {
            this.os_version = r100;
            return this;
        }

        public Builder settings_queries(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.settings_queries = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetDeviceRequest extends ProtoAdapter<SetDeviceRequest> implements a<SetDeviceRequest> {
        private final ProtoAdapter<Map<String, String>> settings_queries;

        public ProtoAdapter_SetDeviceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetDeviceRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.settings_queries = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetDeviceRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.device_id = "";
            r101.install_id = "";
            r101.os_version = "";
            r101.device_type = "";
            r101.app_name = "";
            r101.device_platform = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.device_platform = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.app_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.settings_queries.putAll(this.settings_queries.decode(r100));
            goto L3
        L10:
            r101.device_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.os_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.install_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetDeviceRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.device_id);
            String r103 = r100.install_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.os_version;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.device_type;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = (r109 + r111) + this.settings_queries.encodedSizeWithTag(5, r100.settings_queries);
            String r113 = r100.app_name;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.device_platform;
            if (r116 == null) goto L22;
            r104 = r101.encodedSizeWithTag(7, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetDeviceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetDeviceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetDeviceRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.device_id);
            String r103 = r101.install_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.os_version;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.device_type;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            this.settings_queries.encodeWithTag(r100, 5, r101.settings_queries);
            String r106 = r101.app_name;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.device_platform;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetDeviceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetDeviceRequest r100 = new ProtoAdapter_SetDeviceRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.device_id = this.device_id;
        r100.install_id = this.install_id;
        r100.os_version = this.os_version;
        r100.device_type = this.device_type;
        r100.settings_queries = Internal.copyOf("settings_queries", this.settings_queries);
        r100.app_name = this.app_name;
        r100.device_platform = this.device_platform;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetDeviceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetDeviceRequest(String r110, String r111, String r112, String r113, Map<String, String> r114, String r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public SetDeviceRequest(String r100, String r101, String r102, String r103, Map<String, String> r104, String r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.device_id = r100;
        this.install_id = r101;
        this.os_version = r102;
        this.device_type = r103;
        this.settings_queries = Internal.immutableCopyOf("settings_queries", r104);
        this.app_name = r105;
        this.device_platform = r106;
    }
}
