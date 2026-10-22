package com.bytedance.lark.pb.basic.v1;

import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class DynamicNetStatusResponse extends com.squareup.wire.Message<DynamicNetStatusResponse, Builder> {
    public static final ProtoAdapter<DynamicNetStatusResponse> ADAPTER = null;
    public static final NetStatus DEFAULT_NET_STATUS = null;
    public static final ProtoAdapter_DynamicNetStatusResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final NetStatus net_status;

    public static final class Builder extends com.squareup.wire.Message.Builder<DynamicNetStatusResponse, Builder> implements b<DynamicNetStatusResponse> {
        public NetStatus net_status;

        @Override // com.squareup.wire.Message.Builder
        public DynamicNetStatusResponse build() {
            NetStatus r100 = this.net_status;
            if (r100 == null) goto L7;
            return new DynamicNetStatusResponse(this.net_status, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, IOnekeyLoginService.ResponseConstants.NET_STATUS});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder net_status(NetStatus r100) {
            this.net_status = r100;
            return this;
        }
    }

    public static final enum NetStatus extends Enum<NetStatus> implements WireEnum {
        private static final /* synthetic */ NetStatus[] $VALUES = null;
        public static final ProtoAdapter<NetStatus> ADAPTER = null;
        public static final NetStatus EVALUATING = null;
        public static final NetStatus EXCELLENT = null;
        public static final NetStatus NET_UNAVAILABLE = null;
        public static final NetStatus OFFLINE = null;
        public static final NetStatus PROXY_OFFLINE = null;
        public static final NetStatus SERVICE_UNAVAILABLE = null;
        public static final NetStatus WEAK = null;
        private final int value;

        static {
            NetStatus r100 = new NetStatus("EXCELLENT", 0, 1);
            EXCELLENT = r100;
            NetStatus r101 = new NetStatus("EVALUATING", 1, 2);
            EVALUATING = r101;
            NetStatus r102 = new NetStatus("WEAK", 2, 3);
            WEAK = r102;
            NetStatus r103 = new NetStatus("NET_UNAVAILABLE", 3, 4);
            NET_UNAVAILABLE = r103;
            NetStatus r104 = new NetStatus("SERVICE_UNAVAILABLE", 4, 5);
            SERVICE_UNAVAILABLE = r104;
            NetStatus r110 = new NetStatus("OFFLINE", 5, 6);
            OFFLINE = r110;
            NetStatus r111 = new NetStatus("PROXY_OFFLINE", 6, 7);
            PROXY_OFFLINE = r111;
            $VALUES = new NetStatus[]{r100, r101, r102, r103, r104, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(NetStatus.class);
        }

        public static NetStatus[] values() {
            return (NetStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static NetStatus fromValue(int r100) {
            switch(r100) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return PROXY_OFFLINE;
        L8:
            return OFFLINE;
        L10:
            return SERVICE_UNAVAILABLE;
        L12:
            return NET_UNAVAILABLE;
        L14:
            return WEAK;
        L16:
            return EVALUATING;
        L18:
            return EXCELLENT;
        }

        public static NetStatus valueOf(String r100) {
            return (NetStatus) a.a(NetStatus.class, r100);
        }

        private NetStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_DynamicNetStatusResponse extends ProtoAdapter<DynamicNetStatusResponse> implements we6.a<DynamicNetStatusResponse> {
        public ProtoAdapter_DynamicNetStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DynamicNetStatusResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DynamicNetStatusResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.net_status = NetStatus.EXCELLENT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.net_status = NetStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DynamicNetStatusResponse r100) {
            return NetStatus.ADAPTER.encodedSizeWithTag(1, r100.net_status) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DynamicNetStatusResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DynamicNetStatusResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DynamicNetStatusResponse r101) throws IOException {
            NetStatus.ADAPTER.encodeWithTag(r100, 1, r101.net_status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DynamicNetStatusResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DynamicNetStatusResponse r100 = new ProtoAdapter_DynamicNetStatusResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NET_STATUS = NetStatus.EXCELLENT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.net_status = this.net_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DynamicNetStatusResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DynamicNetStatusResponse(NetStatus r100) {
        this(r100, ByteString.EMPTY);
    }

    public DynamicNetStatusResponse(NetStatus r100, ByteString r101) {
        super(ADAPTER, r101);
        this.net_status = r100;
    }
}
