package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatApplication extends com.squareup.wire.Message<ChatApplication, Builder> {
    public static final ProtoAdapter<ChatApplication> ADAPTER = null;
    public static final Long DEFAULT_APPLY_TIME = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_EXTRA_MESSAGE = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_READ = null;
    public static final Long DEFAULT_PROCESSED_TIME = null;
    public static final Status DEFAULT_STATUS = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Long apply_time;
    public final String chat_id;
    public final ContactSummary contact_summary;
    public final String extra_message;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253447id;
    public final Boolean is_read;
    public final Long processed_time;
    public final Status status;
    public final Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatApplication, Builder> {
        public Long apply_time;
        public String chat_id;
        public ContactSummary contact_summary;
        public String extra_message;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253448id;
        public Boolean is_read;
        public Long processed_time;
        public Status status;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public ChatApplication build() {
            return new ChatApplication(this.f253448id, this.type, this.chat_id, this.contact_summary, this.apply_time, this.processed_time, this.status, this.is_read, this.extra_message, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder apply_time(Long r100) {
            this.apply_time = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder contact_summary(ContactSummary r100) {
            this.contact_summary = r100;
            return this;
        }

        public Builder extra_message(String r100) {
            this.extra_message = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253448id = r100;
            return this;
        }

        public Builder is_read(Boolean r100) {
            this.is_read = r100;
            return this;
        }

        public Builder processed_time(Long r100) {
            this.processed_time = r100;
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

    public static final class ProtoAdapter_ChatApplication extends ProtoAdapter<ChatApplication> {
        public ProtoAdapter_ChatApplication() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatApplication.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatApplication decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253448id = "";
            r101.type = Type.UNKNOWN_TYPE;
            r101.chat_id = "";
            r101.apply_time = 0L;
            r101.processed_time = 0L;
            r101.status = Status.UNKNOWN_STATUS;
            r101.is_read = Boolean.FALSE;
            r101.extra_message = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L26;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L24;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L24:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L26:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.extra_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.is_read = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.processed_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.apply_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.contact_summary = ContactSummary.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.f253448id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatApplication r100) {
            String r101 = r100.f253447id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Type r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.chat_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ContactSummary r110 = r100.contact_summary;
            if (r110 == null) goto L17;
            int r111 = ContactSummary.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.apply_time;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.processed_time;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Status r119 = r100.status;
            if (r119 == null) goto L29;
            int r120 = Status.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_read;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.extra_message;
            if (r125 == null) goto L38;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            return (r124 + r102) + r100.unknownFields().size();
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatApplication decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatApplication r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatApplication r101) throws IOException {
            String r102 = r101.f253447id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Type r103 = r101.type;
            if (r103 == null) goto L8;
            Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.chat_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ContactSummary r105 = r101.contact_summary;
            if (r105 == null) goto L14;
            ContactSummary.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.apply_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.processed_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Status r108 = r101.status;
            if (r108 == null) goto L23;
            Status.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.is_read;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.extra_message;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatApplication r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status AGREED = null;
        public static final Status DELETED = null;
        public static final Status EXPIRED = null;
        public static final Status PENDING = null;
        public static final Status REFUSED = null;
        public static final Status UNKNOWN_STATUS = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r100;
            Status r101 = new Status("PENDING", 1, 1);
            PENDING = r101;
            Status r102 = new Status("AGREED", 2, 2);
            AGREED = r102;
            Status r103 = new Status("REFUSED", 3, 3);
            REFUSED = r103;
            Status r104 = new Status("DELETED", 4, 4);
            DELETED = r104;
            Status r105 = new Status("EXPIRED", 5, 5);
            EXPIRED = r105;
            $VALUES = new Status[]{r100, r101, r102, r103, r104, r105};
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
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return EXPIRED;
        L18:
            return DELETED;
        L20:
            return REFUSED;
        L22:
            return AGREED;
        L24:
            return PENDING;
        L26:
            return UNKNOWN_STATUS;
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
        public static final Type FRIEND = null;
        public static final Type JOIN_CHAT = null;
        public static final Type UNKNOWN_TYPE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type("FRIEND", 1, 1);
            FRIEND = r101;
            Type r102 = new Type("JOIN_CHAT", 2, 2);
            JOIN_CHAT = r102;
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
            return JOIN_CHAT;
        L12:
            return FRIEND;
        L14:
            return UNKNOWN_TYPE;
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
        ADAPTER = new ProtoAdapter_ChatApplication();
        DEFAULT_TYPE = Type.UNKNOWN_TYPE;
        DEFAULT_APPLY_TIME = 0L;
        DEFAULT_PROCESSED_TIME = 0L;
        DEFAULT_STATUS = Status.UNKNOWN_STATUS;
        DEFAULT_IS_READ = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253448id = this.f253447id;
        r100.type = this.type;
        r100.chat_id = this.chat_id;
        r100.contact_summary = this.contact_summary;
        r100.apply_time = this.apply_time;
        r100.processed_time = this.processed_time;
        r100.status = this.status;
        r100.is_read = this.is_read;
        r100.extra_message = this.extra_message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatApplication.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatApplication(String r110, Type r111, String r112, ContactSummary r113, Long r114, Long r115, Status r116, Boolean r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public ChatApplication(String r100, Type r101, String r102, ContactSummary r103, Long r104, Long r105, Status r106, Boolean r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.f253447id = r100;
        this.type = r101;
        this.chat_id = r102;
        this.contact_summary = r103;
        this.apply_time = r104;
        this.processed_time = r105;
        this.status = r106;
        this.is_read = r107;
        this.extra_message = r110;
    }
}
