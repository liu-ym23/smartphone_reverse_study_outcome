package com.ss.android.lark.pb.minutes.v1;

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
public final class ByteviewUser extends Message<ByteviewUser, Builder> {
    public static final ProtoAdapter<ByteviewUser> ADAPTER = null;
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final ParticipantType DEFAULT_USER_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String device_id;
    public final String user_id;
    public final ParticipantType user_type;

    public static final class Builder extends Message.Builder<ByteviewUser, Builder> {
        public String device_id;
        public String user_id;
        public ParticipantType user_type;

        @Override // com.squareup.wire.Message.Builder
        public ByteviewUser build() {
            String r100 = this.user_id;
            if (r100 == null) goto L11;
            if (this.device_id == null) goto L11;
            if (this.user_type == null) goto L11;
            return new ByteviewUser(this.user_id, this.device_id, this.user_type, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.device_id, "device_id", this.user_type, "user_type"});
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

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }

        public Builder user_type(ParticipantType r100) {
            this.user_type = r100;
            return this;
        }
    }

    public static final enum ParticipantType extends Enum<ParticipantType> implements WireEnum {
        private static final /* synthetic */ ParticipantType[] $VALUES = null;
        public static final ProtoAdapter<ParticipantType> ADAPTER = null;
        public static final ParticipantType DOC_USER = null;
        public static final ParticipantType LARK_USER = null;
        public static final ParticipantType NEO_GUEST_USER = null;
        public static final ParticipantType NEO_USER = null;
        public static final ParticipantType PSTN_USER = null;
        public static final ParticipantType ROOM = null;
        public static final ParticipantType SIP_USER = null;
        public static final ParticipantType UNKNOW = null;
        private final int value;

        static {
            ParticipantType r100 = new ParticipantType("UNKNOW", 0, 0);
            UNKNOW = r100;
            ParticipantType r101 = new ParticipantType("LARK_USER", 1, 1);
            LARK_USER = r101;
            ParticipantType r102 = new ParticipantType("ROOM", 2, 2);
            ROOM = r102;
            ParticipantType r103 = new ParticipantType("DOC_USER", 3, 3);
            DOC_USER = r103;
            ParticipantType r104 = new ParticipantType("NEO_USER", 4, 4);
            NEO_USER = r104;
            ParticipantType r105 = new ParticipantType("NEO_GUEST_USER", 5, 5);
            NEO_GUEST_USER = r105;
            ParticipantType r110 = new ParticipantType("PSTN_USER", 6, 6);
            PSTN_USER = r110;
            ParticipantType r111 = new ParticipantType("SIP_USER", 7, 7);
            SIP_USER = r111;
            $VALUES = new ParticipantType[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(ParticipantType.class);
        }

        public static ParticipantType[] values() {
            return (ParticipantType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ParticipantType fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
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
            return SIP_USER;
        L8:
            return PSTN_USER;
        L10:
            return NEO_GUEST_USER;
        L12:
            return NEO_USER;
        L14:
            return DOC_USER;
        L16:
            return ROOM;
        L18:
            return LARK_USER;
        L20:
            return UNKNOW;
        }

        public static ParticipantType valueOf(String r100) {
            return (ParticipantType) a.a(ParticipantType.class, r100);
        }

        private ParticipantType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ByteviewUser extends ProtoAdapter<ByteviewUser> {
        public ProtoAdapter_ByteviewUser() {
            super(FieldEncoding.LENGTH_DELIMITED, ByteviewUser.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ByteviewUser decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            r101.device_id = "";
            r101.user_type = ParticipantType.UNKNOW;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.user_type = ParticipantType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ByteviewUser r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.user_id) + r101.encodedSizeWithTag(2, r100.device_id)) + ParticipantType.ADAPTER.encodedSizeWithTag(3, r100.user_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ByteviewUser decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ByteviewUser r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ByteviewUser r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.user_id);
            r102.encodeWithTag(r100, 2, r101.device_id);
            ParticipantType.ADAPTER.encodeWithTag(r100, 3, r101.user_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ByteviewUser r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ByteviewUser();
        DEFAULT_USER_TYPE = ParticipantType.UNKNOW;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.device_id = this.device_id;
        r100.user_type = this.user_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ByteviewUser.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ByteviewUser(String r100, String r101, ParticipantType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ByteviewUser(String r100, String r101, ParticipantType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_id = r100;
        this.device_id = r101;
        this.user_type = r102;
    }
}
