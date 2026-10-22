package com.bytedance.lark.pb.todo.v1;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Commit extends Message<Commit, Builder> {
    public static final ProtoAdapter<Commit> ADAPTER = null;
    public static final ByteString DEFAULT_ADDED = null;
    public static final Long DEFAULT_CLIENT_MILLI_TIME = null;
    public static final DataType DEFAULT_DATA_TYPE = null;
    public static final ByteString DEFAULT_DELETED = null;
    public static final String DEFAULT_GUID = "";
    public static final Key DEFAULT_KEY = null;
    public static final String DEFAULT_OBJ_GUID = "";
    public static final ObjType DEFAULT_OBJ_TYPE = null;
    public static final String DEFAULT_OPERATION_GUID = "";
    public static final String DEFAULT_OWNER_ID = "";
    public static final OwnerType DEFAULT_OWNER_TYPE = null;
    public static final Platform DEFAULT_PLATFORM = null;
    public static final Long DEFAULT_SERVER_MILLI_TIME = null;
    public static final TodoSource DEFAULT_SOURCE = null;
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final ByteString added;
    public final Long client_milli_time;
    public final DataType data_type;
    public final ByteString deleted;
    public final String guid;
    public final Key key;
    public final String obj_guid;
    public final ObjType obj_type;
    public final String operation_guid;
    public final String owner_id;
    public final OwnerType owner_type;
    public final Platform platform;
    public final Long server_milli_time;
    public final TodoSource source;
    public final String version;

    public static final class Builder extends Message.Builder<Commit, Builder> {
        public ByteString added;
        public Long client_milli_time;
        public DataType data_type;
        public ByteString deleted;
        public String guid;
        public Key key;
        public String obj_guid;
        public ObjType obj_type;
        public String operation_guid;
        public String owner_id;
        public OwnerType owner_type;
        public Platform platform;
        public Long server_milli_time;
        public TodoSource source;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public Commit build() {
            return new Commit(this.guid, this.version, this.obj_type, this.obj_guid, this.key, this.data_type, this.deleted, this.added, this.client_milli_time, this.platform, this.owner_type, this.owner_id, this.operation_guid, this.server_milli_time, this.source, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder added(ByteString r100) {
            this.added = r100;
            return this;
        }

        public Builder client_milli_time(Long r100) {
            this.client_milli_time = r100;
            return this;
        }

        public Builder data_type(DataType r100) {
            this.data_type = r100;
            return this;
        }

        public Builder deleted(ByteString r100) {
            this.deleted = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder key(Key r100) {
            this.key = r100;
            return this;
        }

        public Builder obj_guid(String r100) {
            this.obj_guid = r100;
            return this;
        }

        public Builder obj_type(ObjType r100) {
            this.obj_type = r100;
            return this;
        }

        public Builder operation_guid(String r100) {
            this.operation_guid = r100;
            return this;
        }

        public Builder owner_id(String r100) {
            this.owner_id = r100;
            return this;
        }

        public Builder owner_type(OwnerType r100) {
            this.owner_type = r100;
            return this;
        }

        public Builder platform(Platform r100) {
            this.platform = r100;
            return this;
        }

        public Builder server_milli_time(Long r100) {
            this.server_milli_time = r100;
            return this;
        }

        public Builder source(TodoSource r100) {
            this.source = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final enum DataType extends Enum<DataType> implements WireEnum {
        private static final /* synthetic */ DataType[] $VALUES = null;
        public static final ProtoAdapter<DataType> ADAPTER = null;
        public static final DataType BOOL = null;
        public static final DataType BYTES = null;
        public static final DataType DUE_TIME = null;
        public static final DataType INT_32 = null;
        public static final DataType INT_64 = null;
        public static final DataType REMINDER = null;
        public static final DataType START_AND_DUE_TIME = null;
        public static final DataType STRING = null;
        public static final DataType UNKNOWN_DATA_TYPE = null;
        public static final DataType VEC = null;
        private final int value;

        static {
            DataType r100 = new DataType("UNKNOWN_DATA_TYPE", 0, 0);
            UNKNOWN_DATA_TYPE = r100;
            DataType r101 = new DataType("INT_32", 1, 1);
            INT_32 = r101;
            DataType r102 = new DataType("INT_64", 2, 2);
            INT_64 = r102;
            DataType r103 = new DataType("STRING", 3, 3);
            STRING = r103;
            DataType r104 = new DataType("BOOL", 4, 4);
            BOOL = r104;
            DataType r105 = new DataType("BYTES", 5, 5);
            BYTES = r105;
            DataType r110 = new DataType("VEC", 6, 6);
            VEC = r110;
            DataType r111 = new DataType("DUE_TIME", 7, 7);
            DUE_TIME = r111;
            DataType r112 = new DataType("REMINDER", 8, 8);
            REMINDER = r112;
            DataType r113 = new DataType("START_AND_DUE_TIME", 9, 9);
            START_AND_DUE_TIME = r113;
            $VALUES = new DataType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            ADAPTER = ProtoAdapter.newEnumAdapter(DataType.class);
        }

        public static DataType[] values() {
            return (DataType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DataType fromValue(int r100) {
            switch(r100) {
                case 0: goto L24;
                case 1: goto L22;
                case 2: goto L20;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                case 9: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return START_AND_DUE_TIME;
        L8:
            return REMINDER;
        L10:
            return DUE_TIME;
        L12:
            return VEC;
        L14:
            return BYTES;
        L16:
            return BOOL;
        L18:
            return STRING;
        L20:
            return INT_64;
        L22:
            return INT_32;
        L24:
            return UNKNOWN_DATA_TYPE;
        }

        public static DataType valueOf(String r100) {
            return (DataType) a.a(DataType.class, r100);
        }

        private DataType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class DataTypeBool extends Message<DataTypeBool, Builder> {
        public static final ProtoAdapter<DataTypeBool> ADAPTER = null;
        public static final Boolean DEFAULT_VALUE = null;
        private static final long serialVersionUID = 0;
        public final Boolean value;

        public static final class Builder extends Message.Builder<DataTypeBool, Builder> {
            public Boolean value;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeBool build() {
                return new DataTypeBool(this.value, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder value(Boolean r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeBool extends ProtoAdapter<DataTypeBool> {
            public ProtoAdapter_DataTypeBool() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeBool.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeBool decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.value = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.value = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeBool r100) {
                Boolean r101 = r100.value;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DataTypeBool decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeBool r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeBool r101) throws IOException {
                Boolean r102 = r101.value;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeBool r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeBool();
            DEFAULT_VALUE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.value = this.value;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeBool.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeBool(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public DataTypeBool(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.value = r100;
        }
    }

    public static final class DataTypeDueTime extends Message<DataTypeDueTime, Builder> {
        public static final ProtoAdapter<DataTypeDueTime> ADAPTER = null;
        public static final Long DEFAULT_DUE_TIME = null;
        public static final String DEFAULT_DUE_TIMEZONE = "";
        public static final Boolean DEFAULT_IS_ALL_DAY = null;
        private static final long serialVersionUID = 0;
        public final Long due_time;
        public final String due_timezone;
        public final Boolean is_all_day;

        public static final class Builder extends Message.Builder<DataTypeDueTime, Builder> {
            public Long due_time;
            public String due_timezone;
            public Boolean is_all_day;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeDueTime build() {
                return new DataTypeDueTime(this.due_time, this.due_timezone, this.is_all_day, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder due_time(Long r100) {
                this.due_time = r100;
                return this;
            }

            public Builder due_timezone(String r100) {
                this.due_timezone = r100;
                return this;
            }

            public Builder is_all_day(Boolean r100) {
                this.is_all_day = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeDueTime extends ProtoAdapter<DataTypeDueTime> {
            public ProtoAdapter_DataTypeDueTime() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeDueTime.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeDueTime decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.due_time = 0L;
                r101.due_timezone = "";
                r101.is_all_day = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.due_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.due_timezone = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeDueTime r100) {
                Long r101 = r100.due_time;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.due_timezone;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_all_day;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ DataTypeDueTime decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeDueTime r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeDueTime r101) throws IOException {
                Long r102 = r101.due_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.due_timezone;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.is_all_day;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeDueTime r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeDueTime();
            DEFAULT_DUE_TIME = 0L;
            DEFAULT_IS_ALL_DAY = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.due_time = this.due_time;
            r100.due_timezone = this.due_timezone;
            r100.is_all_day = this.is_all_day;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeDueTime.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeDueTime(Long r100, String r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public DataTypeDueTime(Long r100, String r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.due_time = r100;
            this.due_timezone = r101;
            this.is_all_day = r102;
        }
    }

    public static final class DataTypeInt32 extends Message<DataTypeInt32, Builder> {
        public static final ProtoAdapter<DataTypeInt32> ADAPTER = null;
        public static final Integer DEFAULT_VALUE = null;
        private static final long serialVersionUID = 0;
        public final Integer value;

        public static final class Builder extends Message.Builder<DataTypeInt32, Builder> {
            public Integer value;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeInt32 build() {
                return new DataTypeInt32(this.value, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder value(Integer r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeInt32 extends ProtoAdapter<DataTypeInt32> {
            public ProtoAdapter_DataTypeInt32() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeInt32.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeInt32 decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.value = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.value = ProtoAdapter.INT32.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeInt32 r100) {
                Integer r101 = r100.value;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DataTypeInt32 decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeInt32 r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeInt32 r101) throws IOException {
                Integer r102 = r101.value;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeInt32 r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeInt32();
            DEFAULT_VALUE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.value = this.value;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeInt32.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeInt32(Integer r100) {
            this(r100, ByteString.EMPTY);
        }

        public DataTypeInt32(Integer r100, ByteString r101) {
            super(ADAPTER, r101);
            this.value = r100;
        }
    }

    public static final class DataTypeInt64 extends Message<DataTypeInt64, Builder> {
        public static final ProtoAdapter<DataTypeInt64> ADAPTER = null;
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        public final String value;

        public static final class Builder extends Message.Builder<DataTypeInt64, Builder> {
            public String value;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeInt64 build() {
                return new DataTypeInt64(this.value, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder value(String r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeInt64 extends ProtoAdapter<DataTypeInt64> {
            public ProtoAdapter_DataTypeInt64() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeInt64.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeInt64 decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.value = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.value = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeInt64 r100) {
                String r101 = r100.value;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DataTypeInt64 decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeInt64 r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeInt64 r101) throws IOException {
                String r102 = r101.value;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeInt64 r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeInt64();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.value = this.value;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeInt64.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeInt64(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public DataTypeInt64(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.value = r100;
        }
    }

    public static final class DataTypeReminder extends Message<DataTypeReminder, Builder> {
        public static final ProtoAdapter<DataTypeReminder> ADAPTER = null;
        public static final Boolean DEFAULT_IS_ALL_DAY = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_all_day;
        public final List<TodoReminder> reminders;

        public static final class Builder extends Message.Builder<DataTypeReminder, Builder> {
            public Boolean is_all_day;
            public List<TodoReminder> reminders;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeReminder build() {
                return new DataTypeReminder(this.reminders, this.is_all_day, super.buildUnknownFields());
            }

            public Builder() {
                this.reminders = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_all_day(Boolean r100) {
                this.is_all_day = r100;
                return this;
            }

            public Builder reminders(List<TodoReminder> r100) {
                Internal.checkElementsNotNull(r100);
                this.reminders = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeReminder extends ProtoAdapter<DataTypeReminder> {
            public ProtoAdapter_DataTypeReminder() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeReminder.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeReminder decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_all_day = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.reminders.add(TodoReminder.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeReminder r100) {
                int r101 = TodoReminder.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.reminders);
                Boolean r102 = r100.is_all_day;
                if (r102 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DataTypeReminder decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeReminder r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeReminder r101) throws IOException {
                TodoReminder.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.reminders);
                Boolean r102 = r101.is_all_day;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeReminder r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeReminder();
            DEFAULT_IS_ALL_DAY = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.reminders = Internal.copyOf("reminders", this.reminders);
            r100.is_all_day = this.is_all_day;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeReminder.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeReminder(List<TodoReminder> r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public DataTypeReminder(List<TodoReminder> r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.reminders = Internal.immutableCopyOf("reminders", r100);
            this.is_all_day = r101;
        }
    }

    public static final class DataTypeStartAndDueTime extends Message<DataTypeStartAndDueTime, Builder> {
        public static final ProtoAdapter<DataTypeStartAndDueTime> ADAPTER = null;
        public static final Long DEFAULT_DUE_TIME = null;
        public static final Boolean DEFAULT_IS_ALL_DAY = null;
        public static final Long DEFAULT_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long due_time;
        public final Boolean is_all_day;
        public final Long start_time;

        public static final class Builder extends Message.Builder<DataTypeStartAndDueTime, Builder> {
            public Long due_time;
            public Boolean is_all_day;
            public Long start_time;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeStartAndDueTime build() {
                return new DataTypeStartAndDueTime(this.start_time, this.due_time, this.is_all_day, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder due_time(Long r100) {
                this.due_time = r100;
                return this;
            }

            public Builder is_all_day(Boolean r100) {
                this.is_all_day = r100;
                return this;
            }

            public Builder start_time(Long r100) {
                this.start_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeStartAndDueTime extends ProtoAdapter<DataTypeStartAndDueTime> {
            public ProtoAdapter_DataTypeStartAndDueTime() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeStartAndDueTime.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeStartAndDueTime decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.start_time = 0L;
                r101.due_time = 0L;
                r101.is_all_day = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.start_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.due_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeStartAndDueTime r100) {
                Long r101 = r100.start_time;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.due_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_all_day;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ DataTypeStartAndDueTime decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeStartAndDueTime r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeStartAndDueTime r101) throws IOException {
                Long r102 = r101.start_time;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.due_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.is_all_day;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeStartAndDueTime r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeStartAndDueTime();
            DEFAULT_START_TIME = 0L;
            DEFAULT_DUE_TIME = 0L;
            DEFAULT_IS_ALL_DAY = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.start_time = this.start_time;
            r100.due_time = this.due_time;
            r100.is_all_day = this.is_all_day;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeStartAndDueTime.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeStartAndDueTime(Long r100, Long r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public DataTypeStartAndDueTime(Long r100, Long r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.start_time = r100;
            this.due_time = r101;
            this.is_all_day = r102;
        }
    }

    public static final class DataTypeString extends Message<DataTypeString, Builder> {
        public static final ProtoAdapter<DataTypeString> ADAPTER = null;
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        public final String value;

        public static final class Builder extends Message.Builder<DataTypeString, Builder> {
            public String value;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeString build() {
                return new DataTypeString(this.value, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder value(String r100) {
                this.value = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeString extends ProtoAdapter<DataTypeString> {
            public ProtoAdapter_DataTypeString() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeString.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeString decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.value = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.value = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeString r100) {
                String r101 = r100.value;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DataTypeString decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeString r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeString r101) throws IOException {
                String r102 = r101.value;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeString r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeString();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.value = this.value;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeString.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeString(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public DataTypeString(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.value = r100;
        }
    }

    public static final class DataTypeUserCompletedMilliTime extends Message<DataTypeUserCompletedMilliTime, Builder> {
        public static final ProtoAdapter<DataTypeUserCompletedMilliTime> ADAPTER = null;
        public static final Long DEFAULT_COMPLETED_MILLI_TIME = null;
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final Long completed_milli_time;
        public final String user_id;

        public static final class Builder extends Message.Builder<DataTypeUserCompletedMilliTime, Builder> {
            public Long completed_milli_time;
            public String user_id;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeUserCompletedMilliTime build() {
                return new DataTypeUserCompletedMilliTime(this.user_id, this.completed_milli_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder completed_milli_time(Long r100) {
                this.completed_milli_time = r100;
                return this;
            }

            public Builder user_id(String r100) {
                this.user_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeUserCompletedMilliTime extends ProtoAdapter<DataTypeUserCompletedMilliTime> {
            public ProtoAdapter_DataTypeUserCompletedMilliTime() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeUserCompletedMilliTime.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeUserCompletedMilliTime decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.user_id = "";
                r101.completed_milli_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.user_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.completed_milli_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeUserCompletedMilliTime r100) {
                String r101 = r100.user_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.completed_milli_time;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DataTypeUserCompletedMilliTime decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeUserCompletedMilliTime r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeUserCompletedMilliTime r101) throws IOException {
                String r102 = r101.user_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.completed_milli_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeUserCompletedMilliTime r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeUserCompletedMilliTime();
            DEFAULT_COMPLETED_MILLI_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_id = this.user_id;
            r100.completed_milli_time = this.completed_milli_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeUserCompletedMilliTime.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeUserCompletedMilliTime(String r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public DataTypeUserCompletedMilliTime(String r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.user_id = r100;
            this.completed_milli_time = r101;
        }
    }

    public static final class DataTypeVec extends Message<DataTypeVec, Builder> {
        public static final ProtoAdapter<DataTypeVec> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<ByteString> values;

        public static final class Builder extends Message.Builder<DataTypeVec, Builder> {
            public List<ByteString> values;

            @Override // com.squareup.wire.Message.Builder
            public DataTypeVec build() {
                return new DataTypeVec(this.values, super.buildUnknownFields());
            }

            public Builder() {
                this.values = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder values(List<ByteString> r100) {
                Internal.checkElementsNotNull(r100);
                this.values = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DataTypeVec extends ProtoAdapter<DataTypeVec> {
            public ProtoAdapter_DataTypeVec() {
                super(FieldEncoding.LENGTH_DELIMITED, DataTypeVec.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DataTypeVec decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.values.add(ProtoAdapter.BYTES.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DataTypeVec r100) {
                return ProtoAdapter.BYTES.asRepeated().encodedSizeWithTag(1, r100.values) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DataTypeVec decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DataTypeVec r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DataTypeVec r101) throws IOException {
                ProtoAdapter.BYTES.asRepeated().encodeWithTag(r100, 1, r101.values);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeVec r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DataTypeVec();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.values = Internal.copyOf("values", this.values);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DataTypeVec.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DataTypeVec(List<ByteString> r100) {
            this(r100, ByteString.EMPTY);
        }

        public DataTypeVec(List<ByteString> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.values = Internal.immutableCopyOf("values", r100);
        }
    }

    public static final enum Key extends Enum<Key> implements WireEnum {
        private static final /* synthetic */ Key[] $VALUES = null;
        public static final ProtoAdapter<Key> ADAPTER = null;
        public static final Key CUSTOM_FIELD_VALUE = null;
        public static final Key TASK_CONTAINER_REF = null;
        public static final Key TASK_MODE = null;
        public static final Key TODO_ANCESTOR = null;
        public static final Key TODO_ASSIGNEES = null;
        public static final Key TODO_ATTACHMENTS = null;
        public static final Key TODO_BLOCK_ID = null;
        public static final Key TODO_CAN_EDIT = null;
        public static final Key TODO_COMPLETED_MILLI_TIME = null;
        public static final Key TODO_COMPLETED_TIME = null;
        public static final Key TODO_COMPLETE_MODE = null;
        public static final Key TODO_CUSTOM = null;
        public static final Key TODO_DELETED_TIME = null;
        public static final Key TODO_DEPENDENT = null;
        public static final Key TODO_DESCRIPTION = null;
        public static final Key TODO_DOC_DESCRIPTION = null;
        public static final Key TODO_DUE_TIME = null;
        public static final Key TODO_EXTRA = null;
        public static final Key TODO_FOLLOWERS = null;
        public static final Key TODO_GUID = null;
        public static final Key TODO_HEAD_GUID = null;
        public static final Key TODO_IS_MILESTONE = null;
        public static final Key TODO_ITEMS = null;
        public static final Key TODO_LIST_GUID = null;
        public static final Key TODO_LIST_ITEMS = null;
        public static final Key TODO_LIST_MEMBERS = null;
        public static final Key TODO_LIST_RICH_DESCRIPTION = null;
        public static final Key TODO_LIST_RICH_SUMMARY = null;
        public static final Key TODO_LIST_SUMMARY = null;
        public static final Key TODO_LIST_TYPE = null;
        public static final Key TODO_ORIGIN = null;
        public static final Key TODO_OWNER = null;
        public static final Key TODO_POINTS = null;
        public static final Key TODO_PRE_GUID = null;
        public static final Key TODO_REFER_RESOURCE_IDS = null;
        public static final Key TODO_REMINDERS = null;
        public static final Key TODO_RICH_DESCRIPTION = null;
        public static final Key TODO_RICH_SUMMARY = null;
        public static final Key TODO_RRULE = null;
        public static final Key TODO_SOURCE = null;
        public static final Key TODO_SOURCE_ID = null;
        public static final Key TODO_START_AND_DUE_TIME = null;
        public static final Key TODO_SUB_TASK = null;
        public static final Key TODO_SUMMARY = null;
        public static final Key TODO_USERS_COMPLETED_MILLI_TIME = null;
        public static final Key UNKNOWN_KEY = null;
        public final Boolean deprecated;
        private final int value;

        static {
            Key r100 = new Key("UNKNOWN_KEY", 0, 0, null);
            UNKNOWN_KEY = r100;
            Key r101 = new Key("TODO_GUID", 1, 1, null);
            TODO_GUID = r101;
            Key r102 = new Key("TODO_SUMMARY", 2, 2, null);
            TODO_SUMMARY = r102;
            Key r103 = new Key("TODO_DESCRIPTION", 3, 3, null);
            TODO_DESCRIPTION = r103;
            Key r104 = new Key("TODO_DOC_DESCRIPTION", 4, 4, null);
            TODO_DOC_DESCRIPTION = r104;
            Key r110 = new Key("TODO_ASSIGNEES", 5, 5, null);
            TODO_ASSIGNEES = r110;
            Key r111 = new Key("TODO_REMINDERS", 6, 6, null);
            TODO_REMINDERS = r111;
            Key r112 = new Key("TODO_DUE_TIME", 7, 7, null);
            TODO_DUE_TIME = r112;
            Key r113 = new Key("TODO_DELETED_TIME", 8, 8, null);
            TODO_DELETED_TIME = r113;
            Key r114 = new Key("TODO_COMPLETED_TIME", 9, 9, null);
            TODO_COMPLETED_TIME = r114;
            Key r115 = new Key("TODO_COMPLETE_MODE", 10, 10, null);
            TODO_COMPLETE_MODE = r115;
            Key r105 = new Key("TODO_EXTRA", 11, 11, null);
            TODO_EXTRA = r105;
            Key r106 = new Key("TODO_ITEMS", 12, 12, null);
            TODO_ITEMS = r106;
            Key r107 = new Key("TODO_BLOCK_ID", 13, 13, null);
            TODO_BLOCK_ID = r107;
            Key r108 = new Key("TODO_SOURCE", 14, 14, null);
            TODO_SOURCE = r108;
            Key r109 = new Key("TODO_SOURCE_ID", 15, 15, null);
            TODO_SOURCE_ID = r109;
            Key r116 = new Key("TODO_RICH_SUMMARY", 16, 17, null);
            TODO_RICH_SUMMARY = r116;
            Key r117 = new Key("TODO_RICH_DESCRIPTION", 17, 18, null);
            TODO_RICH_DESCRIPTION = r117;
            Key r118 = new Key("TODO_REFER_RESOURCE_IDS", 18, 19, null);
            TODO_REFER_RESOURCE_IDS = r118;
            Key r119 = new Key("TODO_FOLLOWERS", 19, 20, null);
            TODO_FOLLOWERS = r119;
            Key r120 = new Key("TODO_ORIGIN", 20, 21, null);
            TODO_ORIGIN = r120;
            Key r121 = new Key("TODO_CAN_EDIT", 21, 22, null);
            TODO_CAN_EDIT = r121;
            Key r122 = new Key("TODO_COMPLETED_MILLI_TIME", 22, 23, null);
            TODO_COMPLETED_MILLI_TIME = r122;
            Key r123 = new Key("TODO_USERS_COMPLETED_MILLI_TIME", 23, 24, null);
            TODO_USERS_COMPLETED_MILLI_TIME = r123;
            Key r124 = new Key("TODO_CUSTOM", 24, 25, null);
            TODO_CUSTOM = r124;
            Key r125 = new Key("TODO_RRULE", 25, 26, null);
            TODO_RRULE = r125;
            Key r126 = new Key("TODO_PRE_GUID", 26, 27, null);
            TODO_PRE_GUID = r126;
            Key r127 = new Key("TODO_HEAD_GUID", 27, 28, null);
            TODO_HEAD_GUID = r127;
            Key r128 = new Key("TODO_ANCESTOR", 28, 29, null);
            TODO_ANCESTOR = r128;
            Key r129 = new Key("TODO_SUB_TASK", 29, 30, null);
            TODO_SUB_TASK = r129;
            Key r130 = new Key("TODO_OWNER", 30, 31, Boolean.TRUE);
            TODO_OWNER = r130;
            Key r131 = new Key("TASK_MODE", 31, 32, null);
            TASK_MODE = r131;
            Key r132 = new Key("TODO_ATTACHMENTS", 32, 33, null);
            TODO_ATTACHMENTS = r132;
            Key r133 = new Key("TODO_START_AND_DUE_TIME", 33, 34, null);
            TODO_START_AND_DUE_TIME = r133;
            Key r134 = new Key("TODO_IS_MILESTONE", 34, 35, null);
            TODO_IS_MILESTONE = r134;
            Key r135 = new Key("TODO_DEPENDENT", 35, 36, null);
            TODO_DEPENDENT = r135;
            Key r136 = new Key("TODO_POINTS", 36, 37, null);
            TODO_POINTS = r136;
            Key r137 = new Key("TODO_LIST_GUID", 37, 501, null);
            TODO_LIST_GUID = r137;
            Key r138 = new Key("TODO_LIST_SUMMARY", 38, 502, null);
            TODO_LIST_SUMMARY = r138;
            Key r139 = new Key("TODO_LIST_ITEMS", 39, 503, null);
            TODO_LIST_ITEMS = r139;
            Key r140 = new Key("TODO_LIST_TYPE", 40, 504, null);
            TODO_LIST_TYPE = r140;
            Key r141 = new Key("TODO_LIST_MEMBERS", 41, 505, null);
            TODO_LIST_MEMBERS = r141;
            Key r142 = new Key("TODO_LIST_RICH_SUMMARY", 42, 506, null);
            TODO_LIST_RICH_SUMMARY = r142;
            Key r143 = new Key("TODO_LIST_RICH_DESCRIPTION", 43, 507, null);
            TODO_LIST_RICH_DESCRIPTION = r143;
            Key r144 = new Key("TASK_CONTAINER_REF", 44, 600, null);
            TASK_CONTAINER_REF = r144;
            Key r145 = new Key("CUSTOM_FIELD_VALUE", 45, 601, null);
            CUSTOM_FIELD_VALUE = r145;
            $VALUES = new Key[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145};
            ADAPTER = ProtoAdapter.newEnumAdapter(Key.class);
        }

        public static Key[] values() {
            return (Key[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Key fromValue(int r100) {
            if (r100 == 600) goto L102;
            if (r100 == 601) goto L100;
            switch(r100) {
                case 0: goto L98;
                case 1: goto L96;
                case 2: goto L94;
                case 3: goto L92;
                case 4: goto L90;
                case 5: goto L88;
                case 6: goto L86;
                case 7: goto L84;
                case 8: goto L82;
                case 9: goto L80;
                case 10: goto L78;
                case 11: goto L76;
                case 12: goto L74;
                case 13: goto L72;
                case 14: goto L70;
                case 15: goto L68;
                default: goto L7;
            };
        L7:
            switch(r100) {
                case 17: goto L66;
                case 18: goto L64;
                case 19: goto L62;
                case 20: goto L60;
                case 21: goto L58;
                case 22: goto L56;
                case 23: goto L54;
                case 24: goto L52;
                case 25: goto L50;
                case 26: goto L48;
                case 27: goto L46;
                case 28: goto L44;
                case 29: goto L42;
                case 30: goto L40;
                case 31: goto L38;
                case 32: goto L36;
                case 33: goto L34;
                case 34: goto L32;
                case 35: goto L30;
                case 36: goto L28;
                case 37: goto L26;
                default: goto L8;
            };
        L8:
            switch(r100) {
                case 501: goto L24;
                case 502: goto L22;
                case 503: goto L20;
                case 504: goto L18;
                case 505: goto L16;
                case 506: goto L14;
                case 507: goto L12;
                default: goto L9;
            };
        L9:
            return null;
        L12:
            return TODO_LIST_RICH_DESCRIPTION;
        L14:
            return TODO_LIST_RICH_SUMMARY;
        L16:
            return TODO_LIST_MEMBERS;
        L18:
            return TODO_LIST_TYPE;
        L20:
            return TODO_LIST_ITEMS;
        L22:
            return TODO_LIST_SUMMARY;
        L24:
            return TODO_LIST_GUID;
        L26:
            return TODO_POINTS;
        L28:
            return TODO_DEPENDENT;
        L30:
            return TODO_IS_MILESTONE;
        L32:
            return TODO_START_AND_DUE_TIME;
        L34:
            return TODO_ATTACHMENTS;
        L36:
            return TASK_MODE;
        L38:
            return TODO_OWNER;
        L40:
            return TODO_SUB_TASK;
        L42:
            return TODO_ANCESTOR;
        L44:
            return TODO_HEAD_GUID;
        L46:
            return TODO_PRE_GUID;
        L48:
            return TODO_RRULE;
        L50:
            return TODO_CUSTOM;
        L52:
            return TODO_USERS_COMPLETED_MILLI_TIME;
        L54:
            return TODO_COMPLETED_MILLI_TIME;
        L56:
            return TODO_CAN_EDIT;
        L58:
            return TODO_ORIGIN;
        L60:
            return TODO_FOLLOWERS;
        L62:
            return TODO_REFER_RESOURCE_IDS;
        L64:
            return TODO_RICH_DESCRIPTION;
        L66:
            return TODO_RICH_SUMMARY;
        L68:
            return TODO_SOURCE_ID;
        L70:
            return TODO_SOURCE;
        L72:
            return TODO_BLOCK_ID;
        L74:
            return TODO_ITEMS;
        L76:
            return TODO_EXTRA;
        L78:
            return TODO_COMPLETE_MODE;
        L80:
            return TODO_COMPLETED_TIME;
        L82:
            return TODO_DELETED_TIME;
        L84:
            return TODO_DUE_TIME;
        L86:
            return TODO_REMINDERS;
        L88:
            return TODO_ASSIGNEES;
        L90:
            return TODO_DOC_DESCRIPTION;
        L92:
            return TODO_DESCRIPTION;
        L94:
            return TODO_SUMMARY;
        L96:
            return TODO_GUID;
        L98:
            return UNKNOWN_KEY;
        L100:
            return CUSTOM_FIELD_VALUE;
        L102:
            return TASK_CONTAINER_REF;
        }

        public static Key valueOf(String r100) {
            return (Key) a.a(Key.class, r100);
        }

        private Key(String r100, int r101, int r102, Boolean r103) {
            super(r100, r101);
            this.value = r102;
            this.deprecated = r103;
        }
    }

    public static final enum ObjType extends Enum<ObjType> implements WireEnum {
        private static final /* synthetic */ ObjType[] $VALUES = null;
        public static final ProtoAdapter<ObjType> ADAPTER = null;
        public static final ObjType TODO = null;
        public static final ObjType TODO_LIST = null;
        public static final ObjType UNKNOWN_OBJ_TYPE = null;
        private final int value;

        static {
            ObjType r100 = new ObjType("UNKNOWN_OBJ_TYPE", 0, 0);
            UNKNOWN_OBJ_TYPE = r100;
            ObjType r101 = new ObjType(AlarmSessionType.TODO, 1, 1);
            TODO = r101;
            ObjType r102 = new ObjType("TODO_LIST", 2, 2);
            TODO_LIST = r102;
            $VALUES = new ObjType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ObjType.class);
        }

        public static ObjType[] values() {
            return (ObjType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ObjType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return TODO_LIST;
        L12:
            return TODO;
        L14:
            return UNKNOWN_OBJ_TYPE;
        }

        public static ObjType valueOf(String r100) {
            return (ObjType) a.a(ObjType.class, r100);
        }

        private ObjType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum OwnerType extends Enum<OwnerType> implements WireEnum {
        private static final /* synthetic */ OwnerType[] $VALUES = null;
        public static final ProtoAdapter<OwnerType> ADAPTER = null;
        public static final OwnerType BOT = null;
        public static final OwnerType UNKNOWN_OWNER_TYPE = null;
        public static final OwnerType USER = null;
        private final int value;

        static {
            OwnerType r100 = new OwnerType("UNKNOWN_OWNER_TYPE", 0, 0);
            UNKNOWN_OWNER_TYPE = r100;
            OwnerType r101 = new OwnerType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            OwnerType r102 = new OwnerType("BOT", 2, 2);
            BOT = r102;
            $VALUES = new OwnerType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(OwnerType.class);
        }

        public static OwnerType[] values() {
            return (OwnerType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static OwnerType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return BOT;
        L12:
            return USER;
        L14:
            return UNKNOWN_OWNER_TYPE;
        }

        public static OwnerType valueOf(String r100) {
            return (OwnerType) a.a(OwnerType.class, r100);
        }

        private OwnerType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Platform extends Enum<Platform> implements WireEnum {
        private static final /* synthetic */ Platform[] $VALUES = null;
        public static final ProtoAdapter<Platform> ADAPTER = null;
        public static final Platform ANDROID = null;
        public static final Platform IPHONE = null;
        public static final Platform LINUX = null;
        public static final Platform MAC = null;
        public static final Platform OPEN_PLATFORM = null;
        public static final Platform UNKNOWN_PLATFORM = null;
        public static final Platform WEB = null;
        public static final Platform WINDOWS = null;
        private final int value;

        static {
            Platform r100 = new Platform("UNKNOWN_PLATFORM", 0, 0);
            UNKNOWN_PLATFORM = r100;
            Platform r101 = new Platform("MAC", 1, 1);
            MAC = r101;
            Platform r102 = new Platform("WINDOWS", 2, 2);
            WINDOWS = r102;
            Platform r103 = new Platform("IPHONE", 3, 3);
            IPHONE = r103;
            Platform r104 = new Platform("ANDROID", 4, 4);
            ANDROID = r104;
            Platform r105 = new Platform("LINUX", 5, 5);
            LINUX = r105;
            Platform r110 = new Platform("WEB", 6, 6);
            WEB = r110;
            Platform r111 = new Platform("OPEN_PLATFORM", 7, 7);
            OPEN_PLATFORM = r111;
            $VALUES = new Platform[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Platform.class);
        }

        public static Platform[] values() {
            return (Platform[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Platform fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return OPEN_PLATFORM;
        L8:
            return WEB;
        L10:
            return LINUX;
        L12:
            return ANDROID;
        L14:
            return IPHONE;
        L16:
            return WINDOWS;
        L18:
            return MAC;
        L20:
            return UNKNOWN_PLATFORM;
        }

        public static Platform valueOf(String r100) {
            return (Platform) a.a(Platform.class, r100);
        }

        private Platform(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_Commit extends ProtoAdapter<Commit> {
        public ProtoAdapter_Commit() {
            super(FieldEncoding.LENGTH_DELIMITED, Commit.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Commit decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.version = "";
            r101.obj_type = ObjType.UNKNOWN_OBJ_TYPE;
            r101.obj_guid = "";
            r101.key = Key.UNKNOWN_KEY;
            r101.data_type = DataType.UNKNOWN_DATA_TYPE;
            ByteString r102 = ByteString.EMPTY;
            r101.deleted = r102;
            r101.added = r102;
            r101.client_milli_time = 0L;
            r101.platform = Platform.UNKNOWN_PLATFORM;
            r101.owner_type = OwnerType.UNKNOWN_OWNER_TYPE;
            r101.owner_id = "";
            r101.operation_guid = "";
            r101.server_milli_time = 0L;
            r101.source = TodoSource.TODO;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L40;
            switch(r104) {
                case 1: goto L39;
                case 2: goto L38;
                case 3: goto L48;
                case 4: goto L33;
                case 5: goto L42;
                case 6: goto L52;
                case 7: goto L24;
                case 8: goto L23;
                case 9: goto L22;
                case 10: goto L50;
                case 11: goto L44;
                case 12: goto L13;
                case 13: goto L12;
                case 14: goto L11;
                case 15: goto L46;
                default: goto L6;
            };
        L42:
            r101.key = Key.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r101.owner_type = OwnerType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L46:
            r101.source = TodoSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L48:
            r101.obj_type = ObjType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L36
        L36:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L50:
            r101.platform = Platform.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L52:
            r101.data_type = DataType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.server_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            r101.operation_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.owner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.client_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L23:
            r101.added = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L24:
            r101.deleted = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L33:
            r101.obj_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L38:
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L39:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L40:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Commit r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.version;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ObjType r107 = r100.obj_type;
            if (r107 == null) goto L13;
            int r108 = ObjType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.obj_guid;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Key r113 = r100.key;
            if (r113 == null) goto L21;
            int r114 = Key.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            DataType r116 = r100.data_type;
            if (r116 == null) goto L25;
            int r117 = DataType.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            ByteString r119 = r100.deleted;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BYTES.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            ByteString r122 = r100.added;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Long r125 = r100.client_milli_time;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.INT64.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Platform r128 = r100.platform;
            if (r128 == null) goto L41;
            int r129 = Platform.ADAPTER.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            OwnerType r131 = r100.owner_type;
            if (r131 == null) goto L45;
            int r132 = OwnerType.ADAPTER.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            String r134 = r100.owner_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.STRING.encodedSizeWithTag(12, r134);
        L50:
            int r136 = r133 + r135;
            String r137 = r100.operation_guid;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.STRING.encodedSizeWithTag(13, r137);
        L54:
            int r139 = r136 + r138;
            Long r140 = r100.server_milli_time;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.INT64.encodedSizeWithTag(14, r140);
        L58:
            int r142 = r139 + r141;
            TodoSource r143 = r100.source;
            if (r143 == null) goto L62;
            r102 = TodoSource.ADAPTER.encodedSizeWithTag(15, r143);
        L62:
            return (r142 + r102) + r100.unknownFields().size();
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
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
        public /* bridge */ /* synthetic */ Commit decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Commit r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Commit r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.version;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ObjType r104 = r101.obj_type;
            if (r104 == null) goto L11;
            ObjType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.obj_guid;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Key r106 = r101.key;
            if (r106 == null) goto L17;
            Key.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            DataType r107 = r101.data_type;
            if (r107 == null) goto L20;
            DataType.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            ByteString r108 = r101.deleted;
            if (r108 == null) goto L23;
            ProtoAdapter.BYTES.encodeWithTag(r100, 7, r108);
        L23:
            ByteString r109 = r101.added;
            if (r109 == null) goto L26;
            ProtoAdapter.BYTES.encodeWithTag(r100, 8, r109);
        L26:
            Long r110 = r101.client_milli_time;
            if (r110 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r110);
        L29:
            Platform r111 = r101.platform;
            if (r111 == null) goto L32;
            Platform.ADAPTER.encodeWithTag(r100, 10, r111);
        L32:
            OwnerType r112 = r101.owner_type;
            if (r112 == null) goto L35;
            OwnerType.ADAPTER.encodeWithTag(r100, 11, r112);
        L35:
            String r113 = r101.owner_id;
            if (r113 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r100, 12, r113);
        L38:
            String r114 = r101.operation_guid;
            if (r114 == null) goto L41;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r114);
        L41:
            Long r115 = r101.server_milli_time;
            if (r115 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r100, 14, r115);
        L44:
            TodoSource r116 = r101.source;
            if (r116 == null) goto L47;
            TodoSource.ADAPTER.encodeWithTag(r100, 15, r116);
        L47:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Commit r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Commit();
        DEFAULT_OBJ_TYPE = ObjType.UNKNOWN_OBJ_TYPE;
        DEFAULT_KEY = Key.UNKNOWN_KEY;
        DEFAULT_DATA_TYPE = DataType.UNKNOWN_DATA_TYPE;
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_DELETED = r100;
        DEFAULT_ADDED = r100;
        DEFAULT_CLIENT_MILLI_TIME = 0L;
        DEFAULT_PLATFORM = Platform.UNKNOWN_PLATFORM;
        DEFAULT_OWNER_TYPE = OwnerType.UNKNOWN_OWNER_TYPE;
        DEFAULT_SERVER_MILLI_TIME = 0L;
        DEFAULT_SOURCE = TodoSource.TODO;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.version = this.version;
        r100.obj_type = this.obj_type;
        r100.obj_guid = this.obj_guid;
        r100.key = this.key;
        r100.data_type = this.data_type;
        r100.deleted = this.deleted;
        r100.added = this.added;
        r100.client_milli_time = this.client_milli_time;
        r100.platform = this.platform;
        r100.owner_type = this.owner_type;
        r100.owner_id = this.owner_id;
        r100.operation_guid = this.operation_guid;
        r100.server_milli_time = this.server_milli_time;
        r100.source = this.source;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Commit.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Commit(String r110, String r111, ObjType r210, String r211, Key r212, DataType r213, ByteString r214, ByteString r215, Long r216, Platform r217, OwnerType r218, String r219, String r310, Long r311, TodoSource r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public Commit(String r100, String r101, ObjType r102, String r103, Key r104, DataType r105, ByteString r110, ByteString r111, Long r112, Platform r113, OwnerType r114, String r115, String r116, Long r117, TodoSource r118, ByteString r119) {
        super(ADAPTER, r119);
        this.guid = r100;
        this.version = r101;
        this.obj_type = r102;
        this.obj_guid = r103;
        this.key = r104;
        this.data_type = r105;
        this.deleted = r110;
        this.added = r111;
        this.client_milli_time = r112;
        this.platform = r113;
        this.owner_type = r114;
        this.owner_id = r115;
        this.operation_guid = r116;
        this.server_milli_time = r117;
        this.source = r118;
    }
}
