package com.bytedance.lark.pb.im.v1;

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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetChatQRCodeInfoRequest extends Message<GetChatQRCodeInfoRequest, Builder> {
    public static final ProtoAdapter<GetChatQRCodeInfoRequest> ADAPTER = null;
    public static final PlatformType DEFAULT_PLATFORM_TYPE = null;
    public static final String DEFAULT_TOKEN = "";
    public static final ProtoAdapter_GetChatQRCodeInfoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final PlatformType platform_type;
    public final String token;

    public static final class Builder extends Message.Builder<GetChatQRCodeInfoRequest, Builder> implements d<GetChatQRCodeInfoRequest> {
        public PlatformType platform_type;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public GetChatQRCodeInfoRequest build() {
            String r100 = this.token;
            if (r100 == null) goto L7;
            return new GetChatQRCodeInfoRequest(this.token, this.platform_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "token"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder platform_type(PlatformType r100) {
            this.platform_type = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final enum PlatformType extends Enum<PlatformType> implements WireEnum {
        private static final /* synthetic */ PlatformType[] $VALUES = null;
        public static final ProtoAdapter<PlatformType> ADAPTER = null;
        public static final PlatformType PlatformAndroid = null;
        public static final PlatformType PlatformIPhone = null;
        public static final PlatformType PlatformIpad = null;
        public static final PlatformType PlatformMac = null;
        public static final PlatformType PlatformPassport = null;
        public static final PlatformType PlatformWebAdmin = null;
        public static final PlatformType PlatformWebOther = null;
        public static final PlatformType PlatformWindows = null;
        private final int value;

        static {
            PlatformType r100 = new PlatformType("PlatformIPhone", 0, 1);
            PlatformIPhone = r100;
            PlatformType r101 = new PlatformType("PlatformAndroid", 1, 2);
            PlatformAndroid = r101;
            PlatformType r102 = new PlatformType("PlatformWebAdmin", 2, 3);
            PlatformWebAdmin = r102;
            PlatformType r103 = new PlatformType("PlatformWebOther", 3, 4);
            PlatformWebOther = r103;
            PlatformType r104 = new PlatformType("PlatformWindows", 4, 5);
            PlatformWindows = r104;
            PlatformType r110 = new PlatformType("PlatformMac", 5, 6);
            PlatformMac = r110;
            PlatformType r111 = new PlatformType("PlatformPassport", 6, 7);
            PlatformPassport = r111;
            PlatformType r112 = new PlatformType("PlatformIpad", 7, 8);
            PlatformIpad = r112;
            $VALUES = new PlatformType[]{r100, r101, r102, r103, r104, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(PlatformType.class);
        }

        public static PlatformType[] values() {
            return (PlatformType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PlatformType fromValue(int r100) {
            switch(r100) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return PlatformIpad;
        L8:
            return PlatformPassport;
        L10:
            return PlatformMac;
        L12:
            return PlatformWindows;
        L14:
            return PlatformWebOther;
        L16:
            return PlatformWebAdmin;
        L18:
            return PlatformAndroid;
        L20:
            return PlatformIPhone;
        }

        public static PlatformType valueOf(String r100) {
            return (PlatformType) a.a(PlatformType.class, r100);
        }

        private PlatformType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetChatQRCodeInfoRequest extends ProtoAdapter<GetChatQRCodeInfoRequest> implements c<GetChatQRCodeInfoRequest> {
        public ProtoAdapter_GetChatQRCodeInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatQRCodeInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatQRCodeInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.platform_type = PlatformType.PlatformIPhone;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.platform_type = PlatformType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(GetChatQRCodeInfoRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.token);
            PlatformType r102 = r100.platform_type;
            if (r102 == null) goto L5;
            int r103 = PlatformType.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatQRCodeInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatQRCodeInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatQRCodeInfoRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.token);
            PlatformType r102 = r101.platform_type;
            if (r102 == null) goto L5;
            PlatformType.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatQRCodeInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatQRCodeInfoRequest r100 = new ProtoAdapter_GetChatQRCodeInfoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PLATFORM_TYPE = PlatformType.PlatformIPhone;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.platform_type = this.platform_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatQRCodeInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatQRCodeInfoRequest(String r100, PlatformType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetChatQRCodeInfoRequest(String r100, PlatformType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.token = r100;
        this.platform_type = r101;
    }
}
