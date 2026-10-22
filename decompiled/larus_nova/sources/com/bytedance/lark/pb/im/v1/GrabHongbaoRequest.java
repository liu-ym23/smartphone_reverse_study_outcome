package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GrabHongbaoRequest extends Message<GrabHongbaoRequest, Builder> {
    public static final ProtoAdapter<GrabHongbaoRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final HongbaoType DEFAULT_HONGBAO_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_RETURN_NAME_AUTH = null;
    public static final ProtoAdapter_GrabHongbaoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final DeviceInfo device_info;
    public final HongbaoType hongbao_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253643id;
    public final Boolean is_return_name_auth;

    public static final class Builder extends Message.Builder<GrabHongbaoRequest, Builder> implements d<GrabHongbaoRequest> {
        public Long chat_id;
        public DeviceInfo device_info;
        public HongbaoType hongbao_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253644id;
        public Boolean is_return_name_auth;

        @Override // com.squareup.wire.Message.Builder
        public GrabHongbaoRequest build() {
            String r100 = this.f253644id;
            if (r100 == null) goto L7;
            return new GrabHongbaoRequest(this.f253644id, this.is_return_name_auth, this.hongbao_type, this.chat_id, this.device_info, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder device_info(DeviceInfo r100) {
            this.device_info = r100;
            return this;
        }

        public Builder hongbao_type(HongbaoType r100) {
            this.hongbao_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253644id = r100;
            return this;
        }

        public Builder is_return_name_auth(Boolean r100) {
            this.is_return_name_auth = r100;
            return this;
        }
    }

    public static final class DeviceInfo extends Message<DeviceInfo, Builder> {
        public static final ProtoAdapter<DeviceInfo> ADAPTER = null;
        public static final String DEFAULT_FINANCE_SDK_VERSION = "";
        private static final long serialVersionUID = 0;
        public final String finance_sdk_version;

        public static final class Builder extends Message.Builder<DeviceInfo, Builder> {
            public String finance_sdk_version;

            @Override // com.squareup.wire.Message.Builder
            public DeviceInfo build() {
                return new DeviceInfo(this.finance_sdk_version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder finance_sdk_version(String r100) {
                this.finance_sdk_version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DeviceInfo extends ProtoAdapter<DeviceInfo> {
            public ProtoAdapter_DeviceInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DeviceInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DeviceInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.finance_sdk_version = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.finance_sdk_version = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DeviceInfo r100) {
                String r101 = r100.finance_sdk_version;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DeviceInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DeviceInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DeviceInfo r101) throws IOException {
                String r102 = r101.finance_sdk_version;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeviceInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DeviceInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.finance_sdk_version = this.finance_sdk_version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DeviceInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DeviceInfo(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public DeviceInfo(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.finance_sdk_version = r100;
        }
    }

    public static final class ProtoAdapter_GrabHongbaoRequest extends ProtoAdapter<GrabHongbaoRequest> implements c<GrabHongbaoRequest> {
        public ProtoAdapter_GrabHongbaoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GrabHongbaoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GrabHongbaoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253644id = "";
            r101.is_return_name_auth = Boolean.FALSE;
            r101.hongbao_type = HongbaoType.NORMAL;
            r101.chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.f253644id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_return_name_auth = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.hongbao_type = HongbaoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.device_info = DeviceInfo.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GrabHongbaoRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253643id);
            Boolean r102 = r100.is_return_name_auth;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            HongbaoType r106 = r100.hongbao_type;
            if (r106 == null) goto L9;
            int r107 = HongbaoType.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Long r109 = r100.chat_id;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.INT64.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            DeviceInfo r112 = r100.device_info;
            if (r112 == null) goto L18;
            r103 = DeviceInfo.ADAPTER.encodedSizeWithTag(5, r112);
        L18:
            return (r111 + r103) + r100.unknownFields().size();
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GrabHongbaoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GrabHongbaoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GrabHongbaoRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253643id);
            Boolean r102 = r101.is_return_name_auth;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            HongbaoType r103 = r101.hongbao_type;
            if (r103 == null) goto L8;
            HongbaoType.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Long r104 = r101.chat_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L11:
            DeviceInfo r105 = r101.device_info;
            if (r105 == null) goto L14;
            DeviceInfo.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GrabHongbaoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GrabHongbaoRequest r100 = new ProtoAdapter_GrabHongbaoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_RETURN_NAME_AUTH = Boolean.FALSE;
        DEFAULT_HONGBAO_TYPE = HongbaoType.NORMAL;
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253644id = this.f253643id;
        r100.is_return_name_auth = this.is_return_name_auth;
        r100.hongbao_type = this.hongbao_type;
        r100.chat_id = this.chat_id;
        r100.device_info = this.device_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GrabHongbaoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GrabHongbaoRequest(String r100, Boolean r101, HongbaoType r110, Long r111, DeviceInfo r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public GrabHongbaoRequest(String r100, Boolean r101, HongbaoType r102, Long r103, DeviceInfo r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253643id = r100;
        this.is_return_name_auth = r101;
        this.hongbao_type = r102;
        this.chat_id = r103;
        this.device_info = r104;
    }
}
