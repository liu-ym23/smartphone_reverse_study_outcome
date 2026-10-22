package com.bytedance.lark.pb.im.v1;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.obric.miniapp.alarm.AccountType;
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
public final class GetMessageReadStateRequest extends Message<GetMessageReadStateRequest, Builder> {
    public static final ProtoAdapter<GetMessageReadStateRequest> ADAPTER = null;
    public static final ListType DEFAULT_LIST_TYPE = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Boolean DEFAULT_NEED_PUSH_MSG = null;
    public static final Boolean DEFAULT_NEED_USERS = null;
    public static final String DEFAULT_QUERY = "";
    public static final String DEFAULT_READ_CURSOR = "";
    public static final String DEFAULT_UNREAD_CURSOR = "";
    public static final ProtoAdapter_GetMessageReadStateRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ListType list_type;
    public final String message_id;
    public final Boolean need_push_msg;
    public final Boolean need_users;
    public final String query;
    public final String read_cursor;
    public final String unread_cursor;

    public static final class Builder extends Message.Builder<GetMessageReadStateRequest, Builder> implements d<GetMessageReadStateRequest> {
        public ListType list_type;
        public String message_id;
        public Boolean need_push_msg;
        public Boolean need_users;
        public String query;
        public String read_cursor;
        public String unread_cursor;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageReadStateRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L9;
            if (this.list_type == null) goto L9;
            return new GetMessageReadStateRequest(this.message_id, this.need_users, this.query, this.list_type, this.read_cursor, this.unread_cursor, this.need_push_msg, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.list_type, "list_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder list_type(ListType r100) {
            this.list_type = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder need_push_msg(Boolean r100) {
            this.need_push_msg = r100;
            return this;
        }

        public Builder need_users(Boolean r100) {
            this.need_users = r100;
            return this;
        }

        public Builder query(String r100) {
            this.query = r100;
            return this;
        }

        public Builder read_cursor(String r100) {
            this.read_cursor = r100;
            return this;
        }

        public Builder unread_cursor(String r100) {
            this.unread_cursor = r100;
            return this;
        }
    }

    public static final enum ListType extends Enum<ListType> implements WireEnum {
        private static final /* synthetic */ ListType[] $VALUES = null;
        public static final ProtoAdapter<ListType> ADAPTER = null;
        public static final ListType ALL = null;
        public static final ListType READ = null;
        public static final ListType UNREAD = null;
        private final int value;

        static {
            ListType r100 = new ListType(AccountType.ALL, 0, 0);
            ALL = r100;
            ListType r101 = new ListType("READ", 1, 1);
            READ = r101;
            ListType r102 = new ListType("UNREAD", 2, 2);
            UNREAD = r102;
            $VALUES = new ListType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ListType.class);
        }

        public static ListType[] values() {
            return (ListType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ListType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return UNREAD;
        L12:
            return READ;
        L14:
            return ALL;
        }

        public static ListType valueOf(String r100) {
            return (ListType) a.a(ListType.class, r100);
        }

        private ListType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetMessageReadStateRequest extends ProtoAdapter<GetMessageReadStateRequest> implements c<GetMessageReadStateRequest> {
        public ProtoAdapter_GetMessageReadStateRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageReadStateRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageReadStateRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.need_users = r102;
            r101.query = "";
            r101.list_type = ListType.ALL;
            r101.read_cursor = "";
            r101.unread_cursor = "";
            r101.need_push_msg = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L17;
            switch(r104) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L19;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.list_type = ListType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.need_push_msg = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.unread_cursor = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.read_cursor = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.query = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.need_users = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMessageReadStateRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.message_id);
            Boolean r103 = r100.need_users;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.query;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = (r106 + r108) + ListType.ADAPTER.encodedSizeWithTag(4, r100.list_type);
            String r110 = r100.read_cursor;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.unread_cursor;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.need_push_msg;
            if (r116 == null) goto L22;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GetMessageReadStateRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageReadStateRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageReadStateRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_id);
            Boolean r103 = r101.need_users;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.query;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            ListType.ADAPTER.encodeWithTag(r100, 4, r101.list_type);
            String r105 = r101.read_cursor;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.unread_cursor;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            Boolean r107 = r101.need_push_msg;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageReadStateRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageReadStateRequest r100 = new ProtoAdapter_GetMessageReadStateRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_NEED_USERS = r101;
        DEFAULT_LIST_TYPE = ListType.ALL;
        DEFAULT_NEED_PUSH_MSG = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.need_users = this.need_users;
        r100.query = this.query;
        r100.list_type = this.list_type;
        r100.read_cursor = this.read_cursor;
        r100.unread_cursor = this.unread_cursor;
        r100.need_push_msg = this.need_push_msg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageReadStateRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageReadStateRequest(String r110, Boolean r111, String r112, ListType r113, String r114, String r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GetMessageReadStateRequest(String r100, Boolean r101, String r102, ListType r103, String r104, String r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.message_id = r100;
        this.need_users = r101;
        this.query = r102;
        this.list_type = r103;
        this.read_cursor = r104;
        this.unread_cursor = r105;
        this.need_push_msg = r106;
    }
}
