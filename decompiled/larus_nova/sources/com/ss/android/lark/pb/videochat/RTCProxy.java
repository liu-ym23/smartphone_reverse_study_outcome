package com.ss.android.lark.pb.videochat;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class RTCProxy extends Message<RTCProxy, Builder> {
    public static final ProtoAdapter<RTCProxy> ADAPTER = null;
    public static final String DEFAULT_PASSPORT = "";
    public static final String DEFAULT_PROXY_IP = "";
    public static final Long DEFAULT_PROXY_PORT = null;
    public static final Boolean DEFAULT_STATUS = null;
    public static final String DEFAULT_USER_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mpassport;
    public final String mproxy_ip;
    public final Long mproxy_port;
    public final ProxyType mproxy_type;
    public final Boolean mstatus;
    public final String muser_name;

    public static final class Builder extends Message.Builder<RTCProxy, Builder> {
        public String mpassport;
        public String mproxy_ip;
        public Long mproxy_port;
        public ProxyType mproxy_type;
        public Boolean mstatus;
        public String muser_name;

        @Override // com.squareup.wire.Message.Builder
        public RTCProxy build() {
            Boolean r100 = this.mstatus;
            if (r100 == null) goto L13;
            if (this.mproxy_type == null) goto L13;
            if (this.mproxy_ip == null) goto L13;
            if (this.mproxy_port == null) goto L13;
            return new RTCProxy(this.mstatus, this.mproxy_type, this.mproxy_ip, this.mproxy_port, this.muser_name, this.mpassport, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "mstatus", this.mproxy_type, "mproxy_type", this.mproxy_ip, "mproxy_ip", this.mproxy_port, "mproxy_port"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder passport(String r100) {
            this.mpassport = r100;
            return this;
        }

        public Builder proxy_ip(String r100) {
            this.mproxy_ip = r100;
            return this;
        }

        public Builder proxy_port(Long r100) {
            this.mproxy_port = r100;
            return this;
        }

        public Builder proxy_type(ProxyType r100) {
            this.mproxy_type = r100;
            return this;
        }

        public Builder status(Boolean r100) {
            this.mstatus = r100;
            return this;
        }

        public Builder user_name(String r100) {
            this.muser_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RTCProxy extends ProtoAdapter<RTCProxy> {
        public ProtoAdapter_RTCProxy() {
            super(FieldEncoding.LENGTH_DELIMITED, RTCProxy.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RTCProxy decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstatus = Boolean.FALSE;
            r101.mproxy_ip = "";
            r101.mproxy_port = 0L;
            r101.muser_name = "";
            r101.mpassport = "";
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
            r101.mproxy_type = ProxyType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mpassport = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.muser_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mproxy_port = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.mproxy_ip = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mstatus = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(RTCProxy r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.mstatus) + ProxyType.ADAPTER.encodedSizeWithTag(2, r100.mproxy_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = (r101 + r102.encodedSizeWithTag(3, r100.mproxy_ip)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r100.mproxy_port);
            String r104 = r100.muser_name;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(5, r104);
        L6:
            int r107 = r103 + r106;
            String r108 = r100.mpassport;
            if (r108 == null) goto L10;
            r105 = r102.encodedSizeWithTag(6, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RTCProxy decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RTCProxy r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RTCProxy r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.mstatus);
            ProxyType.ADAPTER.encodeWithTag(r100, 2, r101.mproxy_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 3, r101.mproxy_ip);
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r101.mproxy_port);
            String r103 = r101.muser_name;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 5, r103);
        L5:
            String r104 = r101.mpassport;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 6, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RTCProxy r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum ProxyType extends Enum<ProxyType> implements WireEnum {
        private static final /* synthetic */ ProxyType[] $VALUES = null;
        public static final ProtoAdapter<ProxyType> ADAPTER = null;
        public static final ProxyType HTTP = null;
        public static final ProxyType HTTPS = null;
        public static final ProxyType NONE = null;
        public static final ProxyType SOCKS5 = null;
        public static final ProxyType UNKNOWN = null;
        private final int value;

        static {
            ProxyType r100 = new ProxyType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            ProxyType r101 = new ProxyType("HTTPS", 1, 1);
            HTTPS = r101;
            ProxyType r102 = new ProxyType("SOCKS5", 2, 2);
            SOCKS5 = r102;
            ProxyType r103 = new ProxyType("HTTP", 3, 3);
            HTTP = r103;
            ProxyType r104 = new ProxyType("UNKNOWN", 4, 4);
            UNKNOWN = r104;
            $VALUES = new ProxyType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(ProxyType.class);
        }

        public static ProxyType[] values() {
            return (ProxyType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ProxyType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return UNKNOWN;
        L16:
            return HTTP;
        L18:
            return SOCKS5;
        L20:
            return HTTPS;
        L22:
            return NONE;
        }

        public static ProxyType valueOf(String r100) {
            return (ProxyType) a.a(ProxyType.class, r100);
        }

        private ProxyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RTCProxy();
        DEFAULT_STATUS = Boolean.FALSE;
        DEFAULT_PROXY_PORT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus = this.mstatus;
        r100.mproxy_type = this.mproxy_type;
        r100.mproxy_ip = this.mproxy_ip;
        r100.mproxy_port = this.mproxy_port;
        r100.muser_name = this.muser_name;
        r100.mpassport = this.mpassport;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RTCProxy.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RTCProxy(Boolean r100, ProxyType r110, String r111, Long r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public RTCProxy(Boolean r100, ProxyType r101, String r102, Long r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mstatus = r100;
        this.mproxy_type = r101;
        this.mproxy_ip = r102;
        this.mproxy_port = r103;
        this.muser_name = r104;
        this.mpassport = r105;
    }
}
