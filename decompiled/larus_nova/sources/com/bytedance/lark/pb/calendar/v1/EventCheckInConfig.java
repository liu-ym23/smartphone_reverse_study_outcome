package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class EventCheckInConfig extends Message<EventCheckInConfig, Builder> {
    public static final ProtoAdapter<EventCheckInConfig> ADAPTER = null;
    public static final Boolean DEFAULT_CHECK_IN_ENABLE = null;
    public static final Boolean DEFAULT_NEED_NOTIFY_ATTENDEES = null;
    private static final long serialVersionUID = 0;
    public final Boolean check_in_enable;
    public final CheckInTime check_in_end_time;
    public final CheckInTime check_in_start_time;
    public final Boolean need_notify_attendees;

    public static final class Builder extends Message.Builder<EventCheckInConfig, Builder> {
        public Boolean check_in_enable;
        public CheckInTime check_in_end_time;
        public CheckInTime check_in_start_time;
        public Boolean need_notify_attendees;

        @Override // com.squareup.wire.Message.Builder
        public EventCheckInConfig build() {
            return new EventCheckInConfig(this.check_in_enable, this.check_in_start_time, this.check_in_end_time, this.need_notify_attendees, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder check_in_enable(Boolean r100) {
            this.check_in_enable = r100;
            return this;
        }

        public Builder check_in_end_time(CheckInTime r100) {
            this.check_in_end_time = r100;
            return this;
        }

        public Builder check_in_start_time(CheckInTime r100) {
            this.check_in_start_time = r100;
            return this;
        }

        public Builder need_notify_attendees(Boolean r100) {
            this.need_notify_attendees = r100;
            return this;
        }
    }

    public static final class CheckInTime extends Message<CheckInTime, Builder> {
        public static final ProtoAdapter<CheckInTime> ADAPTER = null;
        public static final Long DEFAULT_DURATION = null;
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Long duration;
        public final Type type;

        public static final class Builder extends Message.Builder<CheckInTime, Builder> {
            public Long duration;
            public Type type;

            @Override // com.squareup.wire.Message.Builder
            public CheckInTime build() {
                return new CheckInTime(this.type, this.duration, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder duration(Long r100) {
                this.duration = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CheckInTime extends ProtoAdapter<CheckInTime> {
            public ProtoAdapter_CheckInTime() {
                super(FieldEncoding.LENGTH_DELIMITED, CheckInTime.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CheckInTime decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = Type.BeforeEventStart;
                r101.duration = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.duration = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(CheckInTime r100) {
                Type r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.duration;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CheckInTime decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CheckInTime r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CheckInTime r101) throws IOException {
                Type r102 = r101.type;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.duration;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckInTime r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type AfterEventEnd = null;
            public static final Type AfterEventStart = null;
            public static final Type BeforeEventStart = null;
            private final int value;

            static {
                Type r100 = new Type("BeforeEventStart", 0, 1);
                BeforeEventStart = r100;
                Type r101 = new Type("AfterEventStart", 1, 2);
                AfterEventStart = r101;
                Type r102 = new Type("AfterEventEnd", 2, 3);
                AfterEventEnd = r102;
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
                return AfterEventEnd;
            L13:
                return AfterEventStart;
            L15:
                return BeforeEventStart;
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
            ADAPTER = new ProtoAdapter_CheckInTime();
            DEFAULT_TYPE = Type.BeforeEventStart;
            DEFAULT_DURATION = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.duration = this.duration;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CheckInTime.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CheckInTime(Type r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public CheckInTime(Type r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.duration = r101;
        }
    }

    public static final class ProtoAdapter_EventCheckInConfig extends ProtoAdapter<EventCheckInConfig> {
        public ProtoAdapter_EventCheckInConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, EventCheckInConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EventCheckInConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.check_in_enable = r102;
            r101.need_notify_attendees = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.check_in_enable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.check_in_start_time = CheckInTime.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.check_in_end_time = CheckInTime.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.need_notify_attendees = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EventCheckInConfig r100) {
            Boolean r101 = r100.check_in_enable;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            CheckInTime r104 = r100.check_in_start_time;
            if (r104 == null) goto L9;
            int r105 = CheckInTime.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            CheckInTime r107 = r100.check_in_end_time;
            if (r107 == null) goto L13;
            int r108 = CheckInTime.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.need_notify_attendees;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ EventCheckInConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EventCheckInConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EventCheckInConfig r101) throws IOException {
            Boolean r102 = r101.check_in_enable;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            CheckInTime r103 = r101.check_in_start_time;
            if (r103 == null) goto L8;
            CheckInTime.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            CheckInTime r104 = r101.check_in_end_time;
            if (r104 == null) goto L11;
            CheckInTime.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.need_notify_attendees;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EventCheckInConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EventCheckInConfig();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_CHECK_IN_ENABLE = r100;
        DEFAULT_NEED_NOTIFY_ATTENDEES = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.check_in_enable = this.check_in_enable;
        r100.check_in_start_time = this.check_in_start_time;
        r100.check_in_end_time = this.check_in_end_time;
        r100.need_notify_attendees = this.need_notify_attendees;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EventCheckInConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EventCheckInConfig(Boolean r100, CheckInTime r101, CheckInTime r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public EventCheckInConfig(Boolean r100, CheckInTime r101, CheckInTime r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.check_in_enable = r100;
        this.check_in_start_time = r101;
        this.check_in_end_time = r102;
        this.need_notify_attendees = r103;
    }
}
