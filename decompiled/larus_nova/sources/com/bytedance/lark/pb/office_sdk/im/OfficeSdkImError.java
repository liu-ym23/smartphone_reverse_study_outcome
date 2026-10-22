package com.bytedance.lark.pb.office_sdk.im;

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

/* JADX INFO: loaded from: classes20.dex */
public final class OfficeSdkImError extends Message<OfficeSdkImError, Builder> {
    public static final ProtoAdapter<OfficeSdkImError> ADAPTER = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Type type;

    public static final class Builder extends Message.Builder<OfficeSdkImError, Builder> {
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public OfficeSdkImError build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new OfficeSdkImError(this.type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OfficeSdkImError extends ProtoAdapter<OfficeSdkImError> {
        public ProtoAdapter_OfficeSdkImError() {
            super(FieldEncoding.LENGTH_DELIMITED, OfficeSdkImError.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OfficeSdkImError decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.OFFICE_SDK_IM_ERROR_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(OfficeSdkImError r100) {
            return Type.ADAPTER.encodedSizeWithTag(1, r100.type) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OfficeSdkImError decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OfficeSdkImError r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OfficeSdkImError r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OfficeSdkImError r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type OFFICE_SDK_IM_ERROR_BUSINESS_ERROR = null;
        public static final Type OFFICE_SDK_IM_ERROR_BUSINESS_MODULE_NOT_FOUND = null;
        public static final Type OFFICE_SDK_IM_ERROR_CONTAINER_SESSION_MISMATCH = null;
        public static final Type OFFICE_SDK_IM_ERROR_PARSING_PROTOBUF_FAILED = null;
        public static final Type OFFICE_SDK_IM_ERROR_UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("OFFICE_SDK_IM_ERROR_UNKNOWN", 0, 0);
            OFFICE_SDK_IM_ERROR_UNKNOWN = r100;
            Type r101 = new Type("OFFICE_SDK_IM_ERROR_CONTAINER_SESSION_MISMATCH", 1, 10000);
            OFFICE_SDK_IM_ERROR_CONTAINER_SESSION_MISMATCH = r101;
            Type r102 = new Type("OFFICE_SDK_IM_ERROR_BUSINESS_MODULE_NOT_FOUND", 2, 10001);
            OFFICE_SDK_IM_ERROR_BUSINESS_MODULE_NOT_FOUND = r102;
            Type r103 = new Type("OFFICE_SDK_IM_ERROR_PARSING_PROTOBUF_FAILED", 3, 10002);
            OFFICE_SDK_IM_ERROR_PARSING_PROTOBUF_FAILED = r103;
            Type r104 = new Type("OFFICE_SDK_IM_ERROR_BUSINESS_ERROR", 4, 10003);
            OFFICE_SDK_IM_ERROR_BUSINESS_ERROR = r104;
            $VALUES = new Type[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 0) goto L15;
            switch(r100) {
                case 10000: goto L13;
                case 10001: goto L11;
                case 10002: goto L9;
                case 10003: goto L7;
                default: goto L4;
            };
        L4:
            return null;
        L7:
            return OFFICE_SDK_IM_ERROR_BUSINESS_ERROR;
        L9:
            return OFFICE_SDK_IM_ERROR_PARSING_PROTOBUF_FAILED;
        L11:
            return OFFICE_SDK_IM_ERROR_BUSINESS_MODULE_NOT_FOUND;
        L13:
            return OFFICE_SDK_IM_ERROR_CONTAINER_SESSION_MISMATCH;
        L15:
            return OFFICE_SDK_IM_ERROR_UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OfficeSdkImError();
        DEFAULT_TYPE = Type.OFFICE_SDK_IM_ERROR_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OfficeSdkImError.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OfficeSdkImError(Type r100) {
        this(r100, ByteString.EMPTY);
    }

    public OfficeSdkImError(Type r100, ByteString r101) {
        super(ADAPTER, r101);
        this.type = r100;
    }
}
