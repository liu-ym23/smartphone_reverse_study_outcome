package com.bytedance.lark.pb.basic.v1;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Urgent extends com.squareup.wire.Message<Urgent, Builder> {
    public static final ProtoAdapter<Urgent> ADAPTER = null;
    public static final String DEFAULT_ACK_CHATTER_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CLOSED = null;
    public static final Boolean DEFAULT_IS_MUTED = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Long DEFAULT_SEND_TIME = null;
    public static final Status DEFAULT_STATUS = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String ack_chatter_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253593id;
    public final Boolean is_closed;
    public final Boolean is_muted;
    public final String message_id;
    public final Long send_time;
    public final Status status;
    public final Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<Urgent, Builder> {
        public String ack_chatter_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253594id;
        public Boolean is_closed;
        public Boolean is_muted;
        public String message_id;
        public Long send_time;
        public Status status;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public Urgent build() {
            String r100 = this.f253594id;
            if (r100 == null) goto L9;
            if (this.message_id == null) goto L9;
            return new Urgent(this.f253594id, this.message_id, this.type, this.send_time, this.status, this.ack_chatter_id, this.is_closed, this.is_muted, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.message_id, MusicAppletPage.KEY_MESSAGE_ID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder ack_chatter_id(String r100) {
            this.ack_chatter_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253594id = r100;
            return this;
        }

        public Builder is_closed(Boolean r100) {
            this.is_closed = r100;
            return this;
        }

        public Builder is_muted(Boolean r100) {
            this.is_muted = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder send_time(Long r100) {
            this.send_time = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Urgent extends ProtoAdapter<Urgent> {
        public ProtoAdapter_Urgent() {
            super(FieldEncoding.LENGTH_DELIMITED, Urgent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Urgent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253594id = "";
            r101.message_id = "";
            r101.type = Type.APP;
            r101.send_time = 0L;
            r101.status = Status.ME_CREATE;
            r101.ack_chatter_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_closed = r102;
            r101.is_muted = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            switch(r104) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L25;
                case 4: goto L14;
                case 5: goto L23;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L23:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L25:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.is_muted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.is_closed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.ack_chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.send_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.f253594id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Urgent r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253593id) + r101.encodedSizeWithTag(2, r100.message_id);
            Type r103 = r100.type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Type.ADAPTER.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.send_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Status r110 = r100.status;
            if (r110 == null) goto L13;
            int r111 = Status.ADAPTER.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.ack_chatter_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.is_closed;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.is_muted;
            if (r119 == null) goto L26;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
        L26:
            return (r118 + r104) + r100.unknownFields().size();
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Urgent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Urgent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Urgent r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253593id);
            r102.encodeWithTag(r100, 2, r101.message_id);
            Type r103 = r101.type;
            if (r103 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            Long r104 = r101.send_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L8:
            Status r105 = r101.status;
            if (r105 == null) goto L11;
            Status.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.ack_chatter_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            Boolean r107 = r101.is_closed;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L17:
            Boolean r108 = r101.is_muted;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Urgent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ACK_ME = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status ME_ACK = null;
        public static final Status ME_CREATE = null;
        public static final Status URGENT_ME = null;
        private final int value;

        static {
            Status r100 = new Status("ME_CREATE", 0, 1);
            ME_CREATE = r100;
            Status r101 = new Status("ME_ACK", 1, 2);
            ME_ACK = r101;
            Status r102 = new Status("URGENT_ME", 2, 3);
            URGENT_ME = r102;
            Status r103 = new Status("ACK_ME", 3, 4);
            ACK_ME = r103;
            $VALUES = new Status[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return ACK_ME;
        L15:
            return URGENT_ME;
        L17:
            return ME_ACK;
        L19:
            return ME_CREATE;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APP = null;
        public static final Type PHONE = null;
        public static final Type SMS = null;
        private final int value;

        static {
            Type r100 = new Type("APP", 0, 1);
            APP = r100;
            Type r101 = new Type(CancelRetainContactInfoFunctions.SMS, 1, 2);
            SMS = r101;
            Type r102 = new Type("PHONE", 2, 3);
            PHONE = r102;
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
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return PHONE;
        L13:
            return SMS;
        L15:
            return APP;
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
        ADAPTER = new ProtoAdapter_Urgent();
        DEFAULT_TYPE = Type.APP;
        DEFAULT_SEND_TIME = 0L;
        DEFAULT_STATUS = Status.ME_CREATE;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_CLOSED = r100;
        DEFAULT_IS_MUTED = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253594id = this.f253593id;
        r100.message_id = this.message_id;
        r100.type = this.type;
        r100.send_time = this.send_time;
        r100.status = this.status;
        r100.ack_chatter_id = this.ack_chatter_id;
        r100.is_closed = this.is_closed;
        r100.is_muted = this.is_muted;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Urgent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Urgent(String r110, String r111, Type r112, Long r113, Status r114, String r115, Boolean r116, Boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public Urgent(String r100, String r101, Type r102, Long r103, Status r104, String r105, Boolean r106, Boolean r107, ByteString r110) {
        super(ADAPTER, r110);
        this.f253593id = r100;
        this.message_id = r101;
        this.type = r102;
        this.send_time = r103;
        this.status = r104;
        this.ack_chatter_id = r105;
        this.is_closed = r106;
        this.is_muted = r107;
    }
}
