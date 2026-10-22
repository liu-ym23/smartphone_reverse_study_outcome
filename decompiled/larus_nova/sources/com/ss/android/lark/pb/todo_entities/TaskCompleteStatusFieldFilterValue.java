package com.ss.android.lark.pb.todo_entities;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class TaskCompleteStatusFieldFilterValue extends Message<TaskCompleteStatusFieldFilterValue, Builder> {
    public static final ProtoAdapter<TaskCompleteStatusFieldFilterValue> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskCompleteStatus mtask_complete_status;

    public static final class Builder extends Message.Builder<TaskCompleteStatusFieldFilterValue, Builder> {
        public TaskCompleteStatus mtask_complete_status;

        @Override // com.squareup.wire.Message.Builder
        public TaskCompleteStatusFieldFilterValue build() {
            return new TaskCompleteStatusFieldFilterValue(this.mtask_complete_status, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_complete_status(TaskCompleteStatus r100) {
            this.mtask_complete_status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskCompleteStatusFieldFilterValue extends ProtoAdapter<TaskCompleteStatusFieldFilterValue> {
        public ProtoAdapter_TaskCompleteStatusFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskCompleteStatusFieldFilterValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskCompleteStatusFieldFilterValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.mtask_complete_status = TaskCompleteStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskCompleteStatusFieldFilterValue r100) {
            TaskCompleteStatus r101 = r100.mtask_complete_status;
            if (r101 == null) goto L5;
            int r102 = TaskCompleteStatus.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskCompleteStatusFieldFilterValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskCompleteStatusFieldFilterValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskCompleteStatusFieldFilterValue r101) throws IOException {
            TaskCompleteStatus r102 = r101.mtask_complete_status;
            if (r102 == null) goto L5;
            TaskCompleteStatus.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskCompleteStatusFieldFilterValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TaskCompleteStatus extends Enum<TaskCompleteStatus> implements WireEnum {
        private static final /* synthetic */ TaskCompleteStatus[] $VALUES = null;
        public static final ProtoAdapter<TaskCompleteStatus> ADAPTER = null;
        public static final TaskCompleteStatus ALL = null;
        public static final TaskCompleteStatus COMPLETED = null;
        public static final TaskCompleteStatus UNCOMPLETED = null;
        public static final TaskCompleteStatus UNKNOWN = null;
        private final int value;

        static {
            TaskCompleteStatus r100 = new TaskCompleteStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TaskCompleteStatus r101 = new TaskCompleteStatus("UNCOMPLETED", 1, 1);
            UNCOMPLETED = r101;
            TaskCompleteStatus r102 = new TaskCompleteStatus("COMPLETED", 2, 2);
            COMPLETED = r102;
            TaskCompleteStatus r103 = new TaskCompleteStatus(AccountType.ALL, 3, 3);
            ALL = r103;
            $VALUES = new TaskCompleteStatus[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(TaskCompleteStatus.class);
        }

        public static TaskCompleteStatus[] values() {
            return (TaskCompleteStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TaskCompleteStatus fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return ALL;
        L14:
            return COMPLETED;
        L16:
            return UNCOMPLETED;
        L18:
            return UNKNOWN;
        }

        public static TaskCompleteStatus valueOf(String r100) {
            return (TaskCompleteStatus) a.a(TaskCompleteStatus.class, r100);
        }

        private TaskCompleteStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskCompleteStatusFieldFilterValue();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtask_complete_status = this.mtask_complete_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskCompleteStatusFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskCompleteStatusFieldFilterValue(TaskCompleteStatus r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskCompleteStatusFieldFilterValue(TaskCompleteStatus r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mtask_complete_status = r100;
    }
}
