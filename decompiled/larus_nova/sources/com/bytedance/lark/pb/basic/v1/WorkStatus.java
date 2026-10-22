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
public final class WorkStatus extends com.squareup.wire.Message<WorkStatus, Builder> {
    public static final ProtoAdapter<WorkStatus> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_END_TIME = null;
    public static final Long DEFAULT_START_TIME = null;
    public static final Status DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String description;
    public final Long end_time;
    public final Long start_time;
    public final Status status;

    public static final class Builder extends com.squareup.wire.Message.Builder<WorkStatus, Builder> {
        public String description;
        public Long end_time;
        public Long start_time;
        public Status status;

        @Override // com.squareup.wire.Message.Builder
        public WorkStatus build() {
            return new WorkStatus(this.status, this.description, this.start_time, this.end_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder end_time(Long r100) {
            this.end_time = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.start_time = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkStatus extends ProtoAdapter<WorkStatus> {
        public ProtoAdapter_WorkStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkStatus.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WorkStatus decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = Status.UNKNOWN;
            r101.description = "";
            r101.start_time = 0L;
            r101.end_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.start_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WorkStatus r100) {
            Status r101 = r100.status;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Status.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.description;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.start_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.end_time;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ WorkStatus decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WorkStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WorkStatus r101) throws IOException {
            Status r102 = r101.status;
            if (r102 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.description;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.start_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.end_time;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WorkStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status ON_LEAVE = null;
        public static final Status ON_MEETING = null;
        public static final Status UNKNOWN = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("ON_LEAVE", 1, 1);
            ON_LEAVE = r101;
            Status r102 = new Status("ON_MEETING", 2, 2);
            ON_MEETING = r102;
            $VALUES = new Status[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return ON_MEETING;
        L12:
            return ON_LEAVE;
        L14:
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
        ADAPTER = new ProtoAdapter_WorkStatus();
        DEFAULT_STATUS = Status.UNKNOWN;
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.description = this.description;
        r100.start_time = this.start_time;
        r100.end_time = this.end_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WorkStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public WorkStatus(Status r100, String r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public WorkStatus(Status r100, String r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.status = r100;
        this.description = r101;
        this.start_time = r102;
        this.end_time = r103;
    }
}
