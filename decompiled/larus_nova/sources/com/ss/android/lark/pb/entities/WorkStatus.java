package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class WorkStatus extends com.squareup.wire.Message<WorkStatus, Builder> {
    public static final ProtoAdapter<WorkStatus> ADAPTER = null;
    public static final Long DEFAULT_END_TIME = null;
    public static final Long DEFAULT_START_TIME = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> mdescription_templates;
    public final Long mend_time;
    public final Long mstart_time;
    public final Status mstatus;

    public static final class Builder extends com.squareup.wire.Message.Builder<WorkStatus, Builder> {
        public Map<String, String> mdescription_templates;
        public Long mend_time;
        public Long mstart_time;
        public Status mstatus;

        @Override // com.squareup.wire.Message.Builder
        public WorkStatus build() {
            return new WorkStatus(this.mstatus, this.mstart_time, this.mend_time, this.mdescription_templates, super.buildUnknownFields());
        }

        public Builder() {
            this.mdescription_templates = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder description_templates(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdescription_templates = r100;
            return this;
        }

        public Builder end_time(Long r100) {
            this.mend_time = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.mstart_time = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkStatus extends ProtoAdapter<WorkStatus> {
        private final ProtoAdapter<Map<String, String>> mdescription_templates;

        public ProtoAdapter_WorkStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkStatus.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mdescription_templates = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WorkStatus decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstart_time = 0L;
            r101.mend_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 7: goto L16;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L16:
            r101.mstatus = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mdescription_templates.putAll(this.mdescription_templates.decode(r100));
            goto L3
        L8:
            r101.mend_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.mstart_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WorkStatus r100) {
            Status r101 = r100.mstatus;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Status.ADAPTER.encodedSizeWithTag(7, r101);
        L6:
            Long r104 = r100.mstart_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(8, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.mend_time;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(9, r107);
        L14:
            return ((r106 + r102) + this.mdescription_templates.encodedSizeWithTag(10, r100.mdescription_templates)) + r100.unknownFields().size();
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
            Status r102 = r101.mstatus;
            if (r102 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r100, 7, r102);
        L5:
            Long r103 = r101.mstart_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 8, r103);
        L8:
            Long r104 = r101.mend_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r104);
        L11:
            this.mdescription_templates.encodeWithTag(r100, 10, r101.mdescription_templates);
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
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus = this.mstatus;
        r100.mstart_time = this.mstart_time;
        r100.mend_time = this.mend_time;
        r100.mdescription_templates = Internal.copyOf("mdescription_templates", this.mdescription_templates);
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

    public WorkStatus(Status r100, Long r101, Long r102, Map<String, String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public WorkStatus(Status r100, Long r101, Long r102, Map<String, String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mstatus = r100;
        this.mstart_time = r101;
        this.mend_time = r102;
        this.mdescription_templates = Internal.immutableCopyOf("mdescription_templates", r103);
    }
}
