package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Email extends com.squareup.wire.Message<Email, Builder> {
    public static final ProtoAdapter<Email> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_LAST_MESSAGE_ID = "";
    public static final Integer DEFAULT_LAST_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_NEW_MESSAGE_COUNT = null;
    public static final String DEFAULT_OWNER_ID = "";
    public static final Role DEFAULT_ROLE = null;
    public static final String DEFAULT_SUBJECT = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253485id;
    public final String last_message_id;
    public final Integer last_message_position;
    public final Integer new_message_count;
    public final String owner_id;
    public final List<String> reply_draft_ids;
    public final Role role;
    public final String subject;
    public final Long update_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<Email, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253486id;
        public String last_message_id;
        public Integer last_message_position;
        public Integer new_message_count;
        public String owner_id;
        public List<String> reply_draft_ids;
        public Role role;
        public String subject;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public Email build() {
            String r100 = this.f253486id;
            if (r100 == null) goto L7;
            return new Email(this.f253486id, this.owner_id, this.last_message_id, this.new_message_count, this.last_message_position, this.role, this.reply_draft_ids, this.subject, this.update_time, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.reply_draft_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253486id = r100;
            return this;
        }

        public Builder last_message_id(String r100) {
            this.last_message_id = r100;
            return this;
        }

        public Builder last_message_position(Integer r100) {
            this.last_message_position = r100;
            return this;
        }

        public Builder new_message_count(Integer r100) {
            this.new_message_count = r100;
            return this;
        }

        public Builder owner_id(String r100) {
            this.owner_id = r100;
            return this;
        }

        public Builder reply_draft_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.reply_draft_ids = r100;
            return this;
        }

        public Builder role(Role r100) {
            this.role = r100;
            return this;
        }

        public Builder subject(String r100) {
            this.subject = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Email extends ProtoAdapter<Email> {
        public ProtoAdapter_Email() {
            super(FieldEncoding.LENGTH_DELIMITED, Email.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Email decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253486id = "";
            r101.owner_id = "";
            r101.last_message_id = "";
            r101.new_message_count = 0;
            r101.last_message_position = 0;
            r101.role = Role.TO;
            r101.subject = "";
            r101.update_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L21;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.role = Role.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.subject = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.reply_draft_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            r101.last_message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.new_message_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.last_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.owner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.f253486id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Email r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253485id);
            String r103 = r100.owner_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.last_message_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.new_message_count;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.last_message_position;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Role r116 = r100.role;
            if (r116 == null) goto L21;
            int r117 = Role.ADAPTER.encodedSizeWithTag(6, r116);
        L22:
            int r118 = (r115 + r117) + r101.asRepeated().encodedSizeWithTag(7, r100.reply_draft_ids);
            String r119 = r100.subject;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            Long r122 = r100.update_time;
            if (r122 == null) goto L30;
            r104 = ProtoAdapter.INT64.encodedSizeWithTag(9, r122);
        L30:
            return (r121 + r104) + r100.unknownFields().size();
        L25:
            r120 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ Email decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Email r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Email r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253485id);
            String r103 = r101.owner_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.last_message_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Integer r105 = r101.new_message_count;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L11:
            Integer r106 = r101.last_message_position;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L14:
            Role r107 = r101.role;
            if (r107 == null) goto L17;
            Role.ADAPTER.encodeWithTag(r100, 6, r107);
        L17:
            r102.asRepeated().encodeWithTag(r100, 7, r101.reply_draft_ids);
            String r108 = r101.subject;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 8, r108);
        L20:
            Long r109 = r101.update_time;
            if (r109 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Email r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Role extends Enum<Role> implements WireEnum {
        private static final /* synthetic */ Role[] $VALUES = null;
        public static final ProtoAdapter<Role> ADAPTER = null;
        public static final Role CC = null;
        public static final Role STRANGER = null;
        public static final Role TO = null;
        private final int value;

        static {
            Role r100 = new Role("TO", 0, 1);
            TO = r100;
            Role r101 = new Role(PromotionCrossBorderStruct.CLEAR_CC_TYPE, 1, 2);
            CC = r101;
            Role r102 = new Role("STRANGER", 2, 3);
            STRANGER = r102;
            $VALUES = new Role[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Role.class);
        }

        public static Role[] values() {
            return (Role[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Role fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return STRANGER;
        L13:
            return CC;
        L15:
            return TO;
        }

        public static Role valueOf(String r100) {
            return (Role) a.a(Role.class, r100);
        }

        private Role(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Email();
        DEFAULT_NEW_MESSAGE_COUNT = 0;
        DEFAULT_LAST_MESSAGE_POSITION = 0;
        DEFAULT_ROLE = Role.TO;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253486id = this.f253485id;
        r100.owner_id = this.owner_id;
        r100.last_message_id = this.last_message_id;
        r100.new_message_count = this.new_message_count;
        r100.last_message_position = this.last_message_position;
        r100.role = this.role;
        r100.reply_draft_ids = Internal.copyOf("reply_draft_ids", this.reply_draft_ids);
        r100.subject = this.subject;
        r100.update_time = this.update_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Email.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Email(String r110, String r111, String r112, Integer r113, Integer r114, Role r115, List<String> r116, String r117, Long r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public Email(String r100, String r101, String r102, Integer r103, Integer r104, Role r105, List<String> r106, String r107, Long r110, ByteString r111) {
        super(ADAPTER, r111);
        this.f253485id = r100;
        this.owner_id = r101;
        this.last_message_id = r102;
        this.new_message_count = r103;
        this.last_message_position = r104;
        this.role = r105;
        this.reply_draft_ids = Internal.immutableCopyOf("reply_draft_ids", r106);
        this.subject = r107;
        this.update_time = r110;
    }
}
