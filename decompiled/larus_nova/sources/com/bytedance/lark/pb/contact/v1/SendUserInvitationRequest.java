package com.bytedance.lark.pb.contact.v1;

import com.huawei.hms.support.api.entity.common.CommonConstant;
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
public final class SendUserInvitationRequest extends Message<SendUserInvitationRequest, Builder> {
    public static final ProtoAdapter<SendUserInvitationRequest> ADAPTER = null;
    public static final String DEFAULT_CONTACT_CONTENT = "";
    public static final Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_SendUserInvitationRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String contact_content;
    public final Type type;

    public static final class Builder extends Message.Builder<SendUserInvitationRequest, Builder> implements d<SendUserInvitationRequest> {
        public String contact_content;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public SendUserInvitationRequest build() {
            Type r100 = this.type;
            if (r100 == null) goto L9;
            if (this.contact_content == null) goto L9;
            return new SendUserInvitationRequest(this.type, this.contact_content, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "type", this.contact_content, "contact_content"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder contact_content(String r100) {
            this.contact_content = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendUserInvitationRequest extends ProtoAdapter<SendUserInvitationRequest> implements c<SendUserInvitationRequest> {
        public ProtoAdapter_SendUserInvitationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendUserInvitationRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendUserInvitationRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            r101.contact_content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.contact_content = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SendUserInvitationRequest r100) {
            return (Type.ADAPTER.encodedSizeWithTag(1, r100.type) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.contact_content)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendUserInvitationRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendUserInvitationRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendUserInvitationRequest r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.type);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.contact_content);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendUserInvitationRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type EMAIL = null;
        public static final Type MOBILE = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("MOBILE", 1, 1);
            MOBILE = r101;
            Type r102 = new Type(CommonConstant.RETKEY.EMAIL, 2, 2);
            EMAIL = r102;
            $VALUES = new Type[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return EMAIL;
        L12:
            return MOBILE;
        L14:
            return UNKNOWN;
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
        ProtoAdapter_SendUserInvitationRequest r100 = new ProtoAdapter_SendUserInvitationRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.contact_content = this.contact_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendUserInvitationRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendUserInvitationRequest(Type r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SendUserInvitationRequest(Type r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.contact_content = r101;
    }
}
