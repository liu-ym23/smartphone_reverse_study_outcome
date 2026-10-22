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
public final class ScheduleMessage extends com.squareup.wire.Message<ScheduleMessage, Builder> {
    public static final ProtoAdapter<ScheduleMessage> ADAPTER = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Long DEFAULT_SCHEDULE_TIME = null;
    public static final Status DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String message_id;
    public final Long schedule_time;
    public final Status status;

    public static final class Builder extends com.squareup.wire.Message.Builder<ScheduleMessage, Builder> {
        public String message_id;
        public Long schedule_time;
        public Status status;

        @Override // com.squareup.wire.Message.Builder
        public ScheduleMessage build() {
            return new ScheduleMessage(this.message_id, this.schedule_time, this.status, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder schedule_time(Long r100) {
            this.schedule_time = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ScheduleMessage extends ProtoAdapter<ScheduleMessage> {
        public ProtoAdapter_ScheduleMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, ScheduleMessage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ScheduleMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.schedule_time = 0L;
            r101.status = Status.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.schedule_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
        public int encodedSize2(ScheduleMessage r100) {
            String r101 = r100.message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.schedule_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Status r107 = r100.status;
            if (r107 == null) goto L14;
            r102 = Status.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ScheduleMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ScheduleMessage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ScheduleMessage r101) throws IOException {
            String r102 = r101.message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.schedule_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Status r104 = r101.status;
            if (r104 == null) goto L11;
            Status.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ScheduleMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DELETE = null;
        public static final Status FAIL = null;
        public static final Status PENDING = null;
        public static final Status SUCCESS = null;
        public static final Status SUSPEND = null;
        public static final Status UNKNOWN = null;
        public static final Status UPDATE_FAILED = null;
        public static final Status UPDATING = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("PENDING", 1, 1);
            PENDING = r101;
            Status r102 = new Status("SUSPEND", 2, 2);
            SUSPEND = r102;
            Status r103 = new Status("SUCCESS", 3, 3);
            SUCCESS = r103;
            Status r104 = new Status("FAIL", 4, 4);
            FAIL = r104;
            Status r105 = new Status("DELETE", 5, 5);
            DELETE = r105;
            Status r110 = new Status("UPDATING", 6, 20);
            UPDATING = r110;
            Status r111 = new Status("UPDATE_FAILED", 7, 21);
            UPDATE_FAILED = r111;
            $VALUES = new Status[]{r100, r101, r102, r103, r104, r105, r110, r111};
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
            if (r100 == 0) goto L34;
            if (r100 == 1) goto L32;
            if (r100 == 2) goto L30;
            if (r100 == 3) goto L28;
            if (r100 == 4) goto L26;
            if (r100 == 5) goto L24;
            if (r100 == 20) goto L22;
            if (r100 == 21) goto L20;
            return null;
        L20:
            return UPDATE_FAILED;
        L22:
            return UPDATING;
        L24:
            return DELETE;
        L26:
            return FAIL;
        L28:
            return SUCCESS;
        L30:
            return SUSPEND;
        L32:
            return PENDING;
        L34:
            return UNKNOWN;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ScheduleMessage();
        DEFAULT_SCHEDULE_TIME = 0L;
        DEFAULT_STATUS = Status.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.schedule_time = this.schedule_time;
        r100.status = this.status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ScheduleMessage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ScheduleMessage(String r100, Long r101, Status r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ScheduleMessage(String r100, Long r101, Status r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_id = r100;
        this.schedule_time = r101;
        this.status = r102;
    }
}
