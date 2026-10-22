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
public final class EditingMessageInfo extends com.squareup.wire.Message<EditingMessageInfo, Builder> {
    public static final ProtoAdapter<EditingMessageInfo> ADAPTER = null;
    public static final Integer DEFAULT_BASE_EDIT_VERSION = null;
    public static final Message.Type DEFAULT_MESSAGE_TYPE = null;
    public static final EditRequestStatus DEFAULT_REQUEST_STATUS = null;
    public static final Long DEFAULT_REQUEST_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final Integer base_edit_version;
    public final EditMessageContent content;
    public final Message.Type message_type;
    public final EditRequestStatus request_status;
    public final Long request_time_ms;

    public static final class Builder extends com.squareup.wire.Message.Builder<EditingMessageInfo, Builder> {
        public Integer base_edit_version;
        public EditMessageContent content;
        public Message.Type message_type;
        public EditRequestStatus request_status;
        public Long request_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public EditingMessageInfo build() {
            return new EditingMessageInfo(this.message_type, this.content, this.request_time_ms, this.request_status, this.base_edit_version, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder base_edit_version(Integer r100) {
            this.base_edit_version = r100;
            return this;
        }

        public Builder content(EditMessageContent r100) {
            this.content = r100;
            return this;
        }

        public Builder message_type(Message.Type r100) {
            this.message_type = r100;
            return this;
        }

        public Builder request_status(EditRequestStatus r100) {
            this.request_status = r100;
            return this;
        }

        public Builder request_time_ms(Long r100) {
            this.request_time_ms = r100;
            return this;
        }
    }

    public static final enum EditRequestStatus extends Enum<EditRequestStatus> implements WireEnum {
        private static final /* synthetic */ EditRequestStatus[] $VALUES = null;
        public static final ProtoAdapter<EditRequestStatus> ADAPTER = null;
        public static final EditRequestStatus FAILED = null;
        public static final EditRequestStatus NO_REQUEST = null;
        public static final EditRequestStatus UNKNOWN = null;
        public static final EditRequestStatus WATING = null;
        private final int value;

        static {
            EditRequestStatus r100 = new EditRequestStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            EditRequestStatus r101 = new EditRequestStatus("NO_REQUEST", 1, 1);
            NO_REQUEST = r101;
            EditRequestStatus r102 = new EditRequestStatus("WATING", 2, 2);
            WATING = r102;
            EditRequestStatus r103 = new EditRequestStatus("FAILED", 3, 3);
            FAILED = r103;
            $VALUES = new EditRequestStatus[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(EditRequestStatus.class);
        }

        public static EditRequestStatus[] values() {
            return (EditRequestStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EditRequestStatus fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return FAILED;
        L14:
            return WATING;
        L16:
            return NO_REQUEST;
        L18:
            return UNKNOWN;
        }

        public static EditRequestStatus valueOf(String r100) {
            return (EditRequestStatus) a.a(EditRequestStatus.class, r100);
        }

        private EditRequestStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_EditingMessageInfo extends ProtoAdapter<EditingMessageInfo> {
        public ProtoAdapter_EditingMessageInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, EditingMessageInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EditingMessageInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_type = Message.Type.UNKNOWN;
            r101.request_time_ms = 0L;
            r101.request_status = EditRequestStatus.UNKNOWN;
            r101.base_edit_version = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.message_type = Message.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.content = EditMessageContent.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.request_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.request_status = EditRequestStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.base_edit_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EditingMessageInfo r100) {
            Message.Type r101 = r100.message_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Message.Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            EditMessageContent r104 = r100.content;
            if (r104 == null) goto L9;
            int r105 = EditMessageContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.request_time_ms;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            EditRequestStatus r110 = r100.request_status;
            if (r110 == null) goto L17;
            int r111 = EditRequestStatus.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.base_edit_version;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ EditingMessageInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EditingMessageInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EditingMessageInfo r101) throws IOException {
            Message.Type r102 = r101.message_type;
            if (r102 == null) goto L5;
            Message.Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            EditMessageContent r103 = r101.content;
            if (r103 == null) goto L8;
            EditMessageContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.request_time_ms;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            EditRequestStatus r105 = r101.request_status;
            if (r105 == null) goto L14;
            EditRequestStatus.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.base_edit_version;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EditingMessageInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EditingMessageInfo();
        DEFAULT_MESSAGE_TYPE = Message.Type.UNKNOWN;
        DEFAULT_REQUEST_TIME_MS = 0L;
        DEFAULT_REQUEST_STATUS = EditRequestStatus.UNKNOWN;
        DEFAULT_BASE_EDIT_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_type = this.message_type;
        r100.content = this.content;
        r100.request_time_ms = this.request_time_ms;
        r100.request_status = this.request_status;
        r100.base_edit_version = this.base_edit_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EditingMessageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EditingMessageInfo(Message.Type r100, EditMessageContent r101, Long r110, EditRequestStatus r111, Integer r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public EditingMessageInfo(Message.Type r100, EditMessageContent r101, Long r102, EditRequestStatus r103, Integer r104, ByteString r105) {
        super(ADAPTER, r105);
        this.message_type = r100;
        this.content = r101;
        this.request_time_ms = r102;
        this.request_status = r103;
        this.base_edit_version = r104;
    }
}
