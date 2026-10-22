package com.bytedance.lark.pb.todo.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class TaskSortedInfo extends Message<TaskSortedInfo, Builder> {
    public static final ProtoAdapter<TaskSortedInfo> ADAPTER = null;
    public static final Long DEFAULT_COMPLETED_MILLI_TIME = null;
    public static final Long DEFAULT_CREATE_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    public static final String DEFAULT_RANK = "";
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_MILLI_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long completed_milli_time;
    public final Long create_milli_time;
    public final TaskFieldValue custom_field_value;
    public final Commit.DataTypeDueTime due_time;
    public final String guid;
    public final String rank;
    public final Commit.DataTypeStartAndDueTime start_and_due_time;
    public final DataTypeStartTime start_time;
    public final Type type;
    public final Long update_milli_time;

    public static final class Builder extends Message.Builder<TaskSortedInfo, Builder> {
        public Long completed_milli_time;
        public Long create_milli_time;
        public TaskFieldValue custom_field_value;
        public Commit.DataTypeDueTime due_time;
        public String guid;
        public String rank;
        public Commit.DataTypeStartAndDueTime start_and_due_time;
        public DataTypeStartTime start_time;
        public Type type;
        public Long update_milli_time;

        @Override // com.squareup.wire.Message.Builder
        public TaskSortedInfo build() {
            return new TaskSortedInfo(this.guid, this.create_milli_time, this.type, this.start_and_due_time, this.rank, this.update_milli_time, this.due_time, this.completed_milli_time, this.custom_field_value, this.start_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder completed_milli_time(Long r100) {
            this.completed_milli_time = r100;
            this.rank = null;
            this.update_milli_time = null;
            this.due_time = null;
            this.custom_field_value = null;
            this.start_time = null;
            return this;
        }

        public Builder create_milli_time(Long r100) {
            this.create_milli_time = r100;
            return this;
        }

        public Builder custom_field_value(TaskFieldValue r100) {
            this.custom_field_value = r100;
            this.rank = null;
            this.update_milli_time = null;
            this.due_time = null;
            this.completed_milli_time = null;
            this.start_time = null;
            return this;
        }

        public Builder due_time(Commit.DataTypeDueTime r100) {
            this.due_time = r100;
            this.rank = null;
            this.update_milli_time = null;
            this.completed_milli_time = null;
            this.custom_field_value = null;
            this.start_time = null;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder rank(String r100) {
            this.rank = r100;
            this.update_milli_time = null;
            this.due_time = null;
            this.completed_milli_time = null;
            this.custom_field_value = null;
            this.start_time = null;
            return this;
        }

        public Builder start_and_due_time(Commit.DataTypeStartAndDueTime r100) {
            this.start_and_due_time = r100;
            return this;
        }

        public Builder start_time(DataTypeStartTime r100) {
            this.start_time = r100;
            this.rank = null;
            this.update_milli_time = null;
            this.due_time = null;
            this.completed_milli_time = null;
            this.custom_field_value = null;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder update_milli_time(Long r100) {
            this.update_milli_time = r100;
            this.rank = null;
            this.due_time = null;
            this.completed_milli_time = null;
            this.custom_field_value = null;
            this.start_time = null;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskSortedInfo extends ProtoAdapter<TaskSortedInfo> {
        public ProtoAdapter_TaskSortedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSortedInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskSortedInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.create_milli_time = 0L;
            r101.type = Type.UNKNOWN;
            r101.rank("");
            r101.update_milli_time(0L);
            r101.completed_milli_time(0L);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L28;
            if (r103 != 1) goto L8;
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.create_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.start_and_due_time = Commit.DataTypeStartAndDueTime.ADAPTER.decode(r100);
            goto L3
        L13:
            switch(r103) {
                case 101: goto L20;
                case 102: goto L19;
                case 103: goto L18;
                case 104: goto L17;
                case 105: goto L16;
                case 106: goto L15;
                default: goto L14;
            };
        L15:
            r101.start_time(DataTypeStartTime.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.custom_field_value(TaskFieldValue.ADAPTER.decode(r100));
            goto L3
        L17:
            r101.completed_milli_time(ProtoAdapter.INT64.decode(r100));
            goto L3
        L18:
            r101.due_time(Commit.DataTypeDueTime.ADAPTER.decode(r100));
            goto L3
        L19:
            r101.update_milli_time(ProtoAdapter.INT64.decode(r100));
            goto L3
        L20:
            r101.rank(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L28:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskSortedInfo r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.create_milli_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Type r107 = r100.type;
            if (r107 == null) goto L13;
            int r108 = Type.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Commit.DataTypeStartAndDueTime r110 = r100.start_and_due_time;
            if (r110 == null) goto L17;
            int r111 = Commit.DataTypeStartAndDueTime.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.rank;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(101, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.update_milli_time;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(102, r116);
        L26:
            int r118 = r115 + r117;
            Commit.DataTypeDueTime r119 = r100.due_time;
            if (r119 == null) goto L29;
            int r120 = Commit.DataTypeDueTime.ADAPTER.encodedSizeWithTag(103, r119);
        L30:
            int r121 = r118 + r120;
            Long r122 = r100.completed_milli_time;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(104, r122);
        L34:
            int r124 = r121 + r123;
            TaskFieldValue r125 = r100.custom_field_value;
            if (r125 == null) goto L37;
            int r126 = TaskFieldValue.ADAPTER.encodedSizeWithTag(105, r125);
        L38:
            int r127 = r124 + r126;
            DataTypeStartTime r128 = r100.start_time;
            if (r128 == null) goto L42;
            r102 = DataTypeStartTime.ADAPTER.encodedSizeWithTag(106, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TaskSortedInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskSortedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskSortedInfo r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.create_milli_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Type r104 = r101.type;
            if (r104 == null) goto L11;
            Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Commit.DataTypeStartAndDueTime r105 = r101.start_and_due_time;
            if (r105 == null) goto L14;
            Commit.DataTypeStartAndDueTime.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.rank;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 101, r106);
        L17:
            Long r107 = r101.update_milli_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 102, r107);
        L20:
            Commit.DataTypeDueTime r108 = r101.due_time;
            if (r108 == null) goto L23;
            Commit.DataTypeDueTime.ADAPTER.encodeWithTag(r100, 103, r108);
        L23:
            Long r109 = r101.completed_milli_time;
            if (r109 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r100, 104, r109);
        L26:
            TaskFieldValue r110 = r101.custom_field_value;
            if (r110 == null) goto L29;
            TaskFieldValue.ADAPTER.encodeWithTag(r100, 105, r110);
        L29:
            DataTypeStartTime r111 = r101.start_time;
            if (r111 == null) goto L32;
            DataTypeStartTime.ADAPTER.encodeWithTag(r100, 106, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskSortedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type COMPLETE_MILLI_TIME = null;
        public static final Type CUSTOM_FIELD_VALUE = null;
        public static final Type DATA_TYPE_DUE_TIME = null;
        public static final Type DATA_TYPE_START_TIME = null;
        public static final Type RANK = null;
        public static final Type UNKNOWN = null;
        public static final Type UPDATE_MILLI_TIME = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("RANK", 1, 1);
            RANK = r101;
            Type r102 = new Type("UPDATE_MILLI_TIME", 2, 2);
            UPDATE_MILLI_TIME = r102;
            Type r103 = new Type("DATA_TYPE_DUE_TIME", 3, 3);
            DATA_TYPE_DUE_TIME = r103;
            Type r104 = new Type("COMPLETE_MILLI_TIME", 4, 4);
            COMPLETE_MILLI_TIME = r104;
            Type r105 = new Type("CUSTOM_FIELD_VALUE", 5, 5);
            CUSTOM_FIELD_VALUE = r105;
            Type r110 = new Type("DATA_TYPE_START_TIME", 6, 6);
            DATA_TYPE_START_TIME = r110;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110};
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
            switch(r100) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DATA_TYPE_START_TIME;
        L8:
            return CUSTOM_FIELD_VALUE;
        L10:
            return COMPLETE_MILLI_TIME;
        L12:
            return DATA_TYPE_DUE_TIME;
        L14:
            return UPDATE_MILLI_TIME;
        L16:
            return RANK;
        L18:
            return UNKNOWN;
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
        ADAPTER = new ProtoAdapter_TaskSortedInfo();
        DEFAULT_CREATE_MILLI_TIME = 0L;
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_UPDATE_MILLI_TIME = 0L;
        DEFAULT_COMPLETED_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.create_milli_time = this.create_milli_time;
        r100.type = this.type;
        r100.start_and_due_time = this.start_and_due_time;
        r100.rank = this.rank;
        r100.update_milli_time = this.update_milli_time;
        r100.due_time = this.due_time;
        r100.completed_milli_time = this.completed_milli_time;
        r100.custom_field_value = this.custom_field_value;
        r100.start_time = this.start_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskSortedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskSortedInfo(String r110, Long r111, Type r112, Commit.DataTypeStartAndDueTime r113, String r114, Long r115, Commit.DataTypeDueTime r116, Long r210, TaskFieldValue r211, DataTypeStartTime r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public TaskSortedInfo(String r100, Long r101, Type r102, Commit.DataTypeStartAndDueTime r103, String r104, Long r105, Commit.DataTypeDueTime r106, Long r107, TaskFieldValue r110, DataTypeStartTime r111, ByteString r112) {
        super(ADAPTER, r112);
        if (Internal.countNonNull(r104, r105, r106, r107, new Object[]{r110, r111}) > 1) goto L7;
        this.guid = r100;
        this.create_milli_time = r101;
        this.type = r102;
        this.start_and_due_time = r103;
        this.rank = r104;
        this.update_milli_time = r105;
        this.due_time = r106;
        this.completed_milli_time = r107;
        this.custom_field_value = r110;
        this.start_time = r111;
        return;
    L7:
        throw new IllegalArgumentException("at most one of rank, update_milli_time, due_time, completed_milli_time, custom_field_value, start_time may be non-null");
    }
}
