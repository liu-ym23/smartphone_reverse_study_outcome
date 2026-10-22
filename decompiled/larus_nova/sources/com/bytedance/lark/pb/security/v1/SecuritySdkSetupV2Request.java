package com.bytedance.lark.pb.security.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SecuritySdkSetupV2Request extends Message<SecuritySdkSetupV2Request, Builder> {
    public static final ProtoAdapter<SecuritySdkSetupV2Request> ADAPTER = null;
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_SECURITY_WORKSPACE_PATH = "";
    public static final String DEFAULT_SESSION = "";
    public static final Long DEFAULT_USER_ID = null;
    public static final ProtoAdapter_SecuritySdkSetupV2Request RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String device_id;
    public final String security_workspace_path;
    public final String session;
    public final Long user_id;

    public static final class Builder extends Message.Builder<SecuritySdkSetupV2Request, Builder> implements d<SecuritySdkSetupV2Request> {
        public String device_id;
        public String security_workspace_path;
        public String session;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public SecuritySdkSetupV2Request build() {
            String r100 = this.security_workspace_path;
            if (r100 == null) goto L13;
            if (this.device_id == null) goto L13;
            if (this.user_id == null) goto L13;
            if (this.session == null) goto L13;
            return new SecuritySdkSetupV2Request(this.security_workspace_path, this.device_id, this.user_id, this.session, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "security_workspace_path", this.device_id, "device_id", this.user_id, "user_id", this.session, AppbrandHostConstants.SCHEMA_INSPECT.SESSION});
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

        public Builder security_workspace_path(String r100) {
            this.security_workspace_path = r100;
            return this;
        }

        public Builder session(String r100) {
            this.session = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SecuritySdkSetupV2Request extends ProtoAdapter<SecuritySdkSetupV2Request> implements c<SecuritySdkSetupV2Request> {
        public ProtoAdapter_SecuritySdkSetupV2Request() {
            super(FieldEncoding.LENGTH_DELIMITED, SecuritySdkSetupV2Request.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SecuritySdkSetupV2Request decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.security_workspace_path = "";
            r101.device_id = "";
            r101.user_id = 0L;
            r101.session = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.security_workspace_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.session = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SecuritySdkSetupV2Request r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.encodedSizeWithTag(1, r100.security_workspace_path) + r101.encodedSizeWithTag(2, r100.device_id)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r100.user_id)) + r101.encodedSizeWithTag(4, r100.session)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SecuritySdkSetupV2Request decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SecuritySdkSetupV2Request r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SecuritySdkSetupV2Request r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.security_workspace_path);
            r102.encodeWithTag(r100, 2, r101.device_id);
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r101.user_id);
            r102.encodeWithTag(r100, 4, r101.session);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SecuritySdkSetupV2Request r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SecuritySdkSetupV2Request r100 = new ProtoAdapter_SecuritySdkSetupV2Request();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.security_workspace_path = this.security_workspace_path;
        r100.device_id = this.device_id;
        r100.user_id = this.user_id;
        r100.session = this.session;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SecuritySdkSetupV2Request.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SecuritySdkSetupV2Request(String r100, String r101, Long r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SecuritySdkSetupV2Request(String r100, String r101, Long r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.security_workspace_path = r100;
        this.device_id = r101;
        this.user_id = r102;
        this.session = r103;
    }
}
