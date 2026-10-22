package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserDeviceInfo extends Message<UserDeviceInfo, Builder> {
    public static final ProtoAdapter<UserDeviceInfo> ADAPTER = null;
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_DEVICE_PLATFORM = "";
    public static final String DEFAULT_INSTALL_ID = "";
    private static final long serialVersionUID = 0;
    public final String app_name;
    public final String device_id;
    public final String device_platform;
    public final String install_id;
    public final Map<String, String> settings_queries;

    public static final class Builder extends Message.Builder<UserDeviceInfo, Builder> {
        public String app_name;
        public String device_id;
        public String device_platform;
        public String install_id;
        public Map<String, String> settings_queries;

        @Override // com.squareup.wire.Message.Builder
        public UserDeviceInfo build() {
            return new UserDeviceInfo(this.device_id, this.install_id, this.device_platform, this.app_name, this.settings_queries, super.buildUnknownFields());
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

        public Builder install_id(String r100) {
            this.install_id = r100;
            return this;
        }

        public Builder settings_queries(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.settings_queries = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserDeviceInfo extends ProtoAdapter<UserDeviceInfo> {
        private final ProtoAdapter<Map<String, String>> settings_queries;

        public ProtoAdapter_UserDeviceInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UserDeviceInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.settings_queries = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserDeviceInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.device_id = "";
            r101.install_id = "";
            r101.device_platform = "";
            r101.app_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.install_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.device_platform = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.app_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.settings_queries.putAll(this.settings_queries.decode(r100));
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
        public int encodedSize2(UserDeviceInfo r100) {
            String r101 = r100.device_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.install_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.device_platform;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.app_name;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            return ((r109 + r102) + this.settings_queries.encodedSizeWithTag(5, r100.settings_queries)) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserDeviceInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserDeviceInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserDeviceInfo r101) throws IOException {
            String r102 = r101.device_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.install_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.device_platform;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.app_name;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            this.settings_queries.encodeWithTag(r100, 5, r101.settings_queries);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserDeviceInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserDeviceInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.device_id = this.device_id;
        r100.install_id = this.install_id;
        r100.device_platform = this.device_platform;
        r100.app_name = this.app_name;
        r100.settings_queries = Internal.copyOf("settings_queries", this.settings_queries);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserDeviceInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserDeviceInfo(String r100, String r101, String r110, String r111, Map<String, String> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UserDeviceInfo(String r100, String r101, String r102, String r103, Map<String, String> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.device_id = r100;
        this.install_id = r101;
        this.device_platform = r102;
        this.app_name = r103;
        this.settings_queries = Internal.immutableCopyOf("settings_queries", r104);
    }
}
