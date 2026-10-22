package com.bytedance.lark.pb.tool.v1;

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
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetNetTypeRequest extends Message<SetNetTypeRequest, Builder> {
    public static final ProtoAdapter<SetNetTypeRequest> ADAPTER = null;
    public static final Integer DEFAULT_INVOKE_ORDER = null;
    public static final NetType DEFAULT_NET_TYPE = null;
    public static final ProtoAdapter_SetNetTypeRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer invoke_order;
    public final NetType net_type;

    public static final class Builder extends Message.Builder<SetNetTypeRequest, Builder> implements b<SetNetTypeRequest> {
        public Integer invoke_order;
        public NetType net_type;

        @Override // com.squareup.wire.Message.Builder
        public SetNetTypeRequest build() {
            Integer r100 = this.invoke_order;
            if (r100 == null) goto L9;
            if (this.net_type == null) goto L9;
            return new SetNetTypeRequest(this.invoke_order, this.net_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "invoke_order", this.net_type, "net_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder invoke_order(Integer r100) {
            this.invoke_order = r100;
            return this;
        }

        public Builder net_type(NetType r100) {
            this.net_type = r100;
            return this;
        }
    }

    public static final enum NetType extends Enum<NetType> implements WireEnum {
        private static final /* synthetic */ NetType[] $VALUES = null;
        public static final ProtoAdapter<NetType> ADAPTER = null;
        public static final NetType OFFLINE = null;
        public static final NetType ONLINE_2G = null;
        public static final NetType ONLINE_3G = null;
        public static final NetType ONLINE_4G = null;
        public static final NetType ONLINE_5G = null;
        public static final NetType ONLINE_WIFI = null;
        public static final NetType ONLINE_WIRED = null;
        private final int value;

        static {
            NetType r100 = new NetType("OFFLINE", 0, 1);
            OFFLINE = r100;
            NetType r101 = new NetType("ONLINE_2G", 1, 2);
            ONLINE_2G = r101;
            NetType r102 = new NetType("ONLINE_3G", 2, 3);
            ONLINE_3G = r102;
            NetType r103 = new NetType("ONLINE_4G", 3, 4);
            ONLINE_4G = r103;
            NetType r104 = new NetType("ONLINE_WIFI", 4, 5);
            ONLINE_WIFI = r104;
            NetType r110 = new NetType("ONLINE_WIRED", 5, 6);
            ONLINE_WIRED = r110;
            NetType r111 = new NetType("ONLINE_5G", 6, 7);
            ONLINE_5G = r111;
            $VALUES = new NetType[]{r100, r101, r102, r103, r104, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(NetType.class);
        }

        public static NetType[] values() {
            return (NetType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static NetType fromValue(int r100) {
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
            return ONLINE_5G;
        L8:
            return ONLINE_WIRED;
        L10:
            return ONLINE_WIFI;
        L12:
            return ONLINE_4G;
        L14:
            return ONLINE_3G;
        L16:
            return ONLINE_2G;
        L18:
            return OFFLINE;
        }

        public static NetType valueOf(String r100) {
            return (NetType) a.a(NetType.class, r100);
        }

        private NetType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_SetNetTypeRequest extends ProtoAdapter<SetNetTypeRequest> implements we6.a<SetNetTypeRequest> {
        public ProtoAdapter_SetNetTypeRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetNetTypeRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetNetTypeRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.invoke_order = 0;
            r101.net_type = NetType.OFFLINE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.invoke_order = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.net_type = NetType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SetNetTypeRequest r100) {
            return (ProtoAdapter.UINT32.encodedSizeWithTag(1, r100.invoke_order) + NetType.ADAPTER.encodedSizeWithTag(2, r100.net_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetNetTypeRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetNetTypeRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetNetTypeRequest r101) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(r100, 1, r101.invoke_order);
            NetType.ADAPTER.encodeWithTag(r100, 2, r101.net_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetNetTypeRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetNetTypeRequest r100 = new ProtoAdapter_SetNetTypeRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_INVOKE_ORDER = 0;
        DEFAULT_NET_TYPE = NetType.OFFLINE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.invoke_order = this.invoke_order;
        r100.net_type = this.net_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetNetTypeRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetNetTypeRequest(Integer r100, NetType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SetNetTypeRequest(Integer r100, NetType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.invoke_order = r100;
        this.net_type = r101;
    }
}
