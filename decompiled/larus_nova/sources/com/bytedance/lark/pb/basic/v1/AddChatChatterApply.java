package com.bytedance.lark.pb.basic.v1;

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
public final class AddChatChatterApply extends com.squareup.wire.Message<AddChatChatterApply, Builder> {
    public static final ProtoAdapter<AddChatChatterApply> ADAPTER = null;
    public static final String DEFAULT_INVITEE_ID = "";
    public static final String DEFAULT_INVITER_ID = "";
    public static final String DEFAULT_REASON = "";
    public static final Status DEFAULT_STATUS = null;
    public static final Long DEFAULT_TEAM_ID = null;
    public static final String DEFAULT_TEAM_NAME = "";
    public static final Long DEFAULT_TIME = null;
    public static final Ways DEFAULT_WAY = null;
    private static final long serialVersionUID = 0;
    public final String invitee_id;
    public final String inviter_id;
    public final String reason;
    public final Status status;
    public final Long team_id;
    public final String team_name;
    public final Long time;
    public final Ways way;

    public static final class Builder extends com.squareup.wire.Message.Builder<AddChatChatterApply, Builder> {
        public String invitee_id;
        public String inviter_id;
        public String reason;
        public Status status;
        public Long team_id;
        public String team_name;
        public Long time;
        public Ways way;

        @Override // com.squareup.wire.Message.Builder
        public AddChatChatterApply build() {
            Status r100 = this.status;
            if (r100 == null) goto L13;
            if (this.time == null) goto L13;
            if (this.way == null) goto L13;
            if (this.invitee_id == null) goto L13;
            return new AddChatChatterApply(this.reason, this.status, this.time, this.way, this.inviter_id, this.invitee_id, this.team_id, this.team_name, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "status", this.time, "time", this.way, "way", this.invitee_id, "invitee_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder invitee_id(String r100) {
            this.invitee_id = r100;
            return this;
        }

        public Builder inviter_id(String r100) {
            this.inviter_id = r100;
            return this;
        }

        public Builder reason(String r100) {
            this.reason = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder team_id(Long r100) {
            this.team_id = r100;
            return this;
        }

        public Builder team_name(String r100) {
            this.team_name = r100;
            return this;
        }

        public Builder time(Long r100) {
            this.time = r100;
            return this;
        }

        public Builder way(Ways r100) {
            this.way = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AddChatChatterApply extends ProtoAdapter<AddChatChatterApply> {
        public ProtoAdapter_AddChatChatterApply() {
            super(FieldEncoding.LENGTH_DELIMITED, AddChatChatterApply.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AddChatChatterApply decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.reason = "";
            r101.status = Status.UNKNOWN_STATUS;
            r101.time = 0L;
            r101.way = Ways.UNKNOWN_WAY;
            r101.inviter_id = "";
            r101.invitee_id = "";
            r101.team_id = 0L;
            r101.team_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L25;
                case 3: goto L15;
                case 4: goto L23;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L23:
            r101.way = Ways.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L25:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.team_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.team_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.invitee_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.inviter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L20:
            r101.reason = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AddChatChatterApply r100) {
            String r101 = r100.reason;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + Status.ADAPTER.encodedSizeWithTag(2, r100.status);
            ProtoAdapter<Long> r105 = ProtoAdapter.INT64;
            int r106 = (r104 + r105.encodedSizeWithTag(3, r100.time)) + Ways.ADAPTER.encodedSizeWithTag(4, r100.way);
            String r107 = r100.inviter_id;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            ProtoAdapter<String> r110 = ProtoAdapter.STRING;
            int r111 = r109 + r110.encodedSizeWithTag(6, r100.invitee_id);
            Long r112 = r100.team_id;
            if (r112 == null) goto L13;
            int r113 = r105.encodedSizeWithTag(7, r112);
        L14:
            int r114 = r111 + r113;
            String r115 = r100.team_name;
            if (r115 == null) goto L18;
            r102 = r110.encodedSizeWithTag(8, r115);
        L18:
            return (r114 + r102) + r100.unknownFields().size();
        L13:
            r113 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AddChatChatterApply decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AddChatChatterApply r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AddChatChatterApply r101) throws IOException {
            String r102 = r101.reason;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Status.ADAPTER.encodeWithTag(r100, 2, r101.status);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.encodeWithTag(r100, 3, r101.time);
            Ways.ADAPTER.encodeWithTag(r100, 4, r101.way);
            String r104 = r101.inviter_id;
            if (r104 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r104);
        L8:
            ProtoAdapter<String> r105 = ProtoAdapter.STRING;
            r105.encodeWithTag(r100, 6, r101.invitee_id);
            Long r106 = r101.team_id;
            if (r106 == null) goto L11;
            r103.encodeWithTag(r100, 7, r106);
        L11:
            String r107 = r101.team_name;
            if (r107 == null) goto L14;
            r105.encodeWithTag(r100, 8, r107);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AddChatChatterApply r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status APPROVED = null;
        public static final Status PROCESSING = null;
        public static final Status REFUSED = null;
        public static final Status UNKNOWN_STATUS = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r100;
            Status r101 = new Status("APPROVED", 1, 1);
            APPROVED = r101;
            Status r102 = new Status("REFUSED", 2, 2);
            REFUSED = r102;
            Status r103 = new Status("PROCESSING", 3, 3);
            PROCESSING = r103;
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
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return PROCESSING;
        L14:
            return REFUSED;
        L16:
            return APPROVED;
        L18:
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

    public static final enum Ways extends Enum<Ways> implements WireEnum {
        private static final /* synthetic */ Ways[] $VALUES = null;
        public static final ProtoAdapter<Ways> ADAPTER = null;
        public static final Ways UNKNOWN_WAY = null;
        public static final Ways VIA_CALENDAR = null;
        public static final Ways VIA_CHAT_LINKED_PAGE = null;
        public static final Ways VIA_DEPARTMENT_STRUCTURE = null;
        public static final Ways VIA_INVITATION = null;
        public static final Ways VIA_LINK = null;
        public static final Ways VIA_QR_CODE = null;
        public static final Ways VIA_SEARCH = null;
        public static final Ways VIA_SHARE = null;
        public static final Ways VIA_TEAM_OPEN_CHAT = null;
        public static final Ways VIA_TEAM_PRIVATE_DISCOVERABLE = null;
        private final int value;

        static {
            Ways r100 = new Ways("UNKNOWN_WAY", 0, 0);
            UNKNOWN_WAY = r100;
            Ways r101 = new Ways("VIA_SHARE", 1, 1);
            VIA_SHARE = r101;
            Ways r102 = new Ways("VIA_INVITATION", 2, 2);
            VIA_INVITATION = r102;
            Ways r103 = new Ways("VIA_QR_CODE", 3, 3);
            VIA_QR_CODE = r103;
            Ways r104 = new Ways("VIA_SEARCH", 4, 4);
            VIA_SEARCH = r104;
            Ways r105 = new Ways("VIA_DEPARTMENT_STRUCTURE", 5, 5);
            VIA_DEPARTMENT_STRUCTURE = r105;
            Ways r110 = new Ways("VIA_LINK", 6, 6);
            VIA_LINK = r110;
            Ways r111 = new Ways("VIA_TEAM_OPEN_CHAT", 7, 7);
            VIA_TEAM_OPEN_CHAT = r111;
            Ways r112 = new Ways("VIA_CALENDAR", 8, 8);
            VIA_CALENDAR = r112;
            Ways r113 = new Ways("VIA_TEAM_PRIVATE_DISCOVERABLE", 9, 9);
            VIA_TEAM_PRIVATE_DISCOVERABLE = r113;
            Ways r114 = new Ways("VIA_CHAT_LINKED_PAGE", 10, 10);
            VIA_CHAT_LINKED_PAGE = r114;
            $VALUES = new Ways[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
            ADAPTER = ProtoAdapter.newEnumAdapter(Ways.class);
        }

        public static Ways[] values() {
            return (Ways[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Ways fromValue(int r100) {
            switch(r100) {
                case 0: goto L26;
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L18;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L12;
                case 8: goto L10;
                case 9: goto L8;
                case 10: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return VIA_CHAT_LINKED_PAGE;
        L8:
            return VIA_TEAM_PRIVATE_DISCOVERABLE;
        L10:
            return VIA_CALENDAR;
        L12:
            return VIA_TEAM_OPEN_CHAT;
        L14:
            return VIA_LINK;
        L16:
            return VIA_DEPARTMENT_STRUCTURE;
        L18:
            return VIA_SEARCH;
        L20:
            return VIA_QR_CODE;
        L22:
            return VIA_INVITATION;
        L24:
            return VIA_SHARE;
        L26:
            return UNKNOWN_WAY;
        }

        public static Ways valueOf(String r100) {
            return (Ways) a.a(Ways.class, r100);
        }

        private Ways(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AddChatChatterApply();
        DEFAULT_STATUS = Status.UNKNOWN_STATUS;
        DEFAULT_TIME = 0L;
        DEFAULT_WAY = Ways.UNKNOWN_WAY;
        DEFAULT_TEAM_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reason = this.reason;
        r100.status = this.status;
        r100.time = this.time;
        r100.way = this.way;
        r100.inviter_id = this.inviter_id;
        r100.invitee_id = this.invitee_id;
        r100.team_id = this.team_id;
        r100.team_name = this.team_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AddChatChatterApply.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AddChatChatterApply(String r110, Status r111, Long r112, Ways r113, String r114, String r115, Long r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public AddChatChatterApply(String r100, Status r101, Long r102, Ways r103, String r104, String r105, Long r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.reason = r100;
        this.status = r101;
        this.time = r102;
        this.way = r103;
        this.inviter_id = r104;
        this.invitee_id = r105;
        this.team_id = r106;
        this.team_name = r107;
    }
}
