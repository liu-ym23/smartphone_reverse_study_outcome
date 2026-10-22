package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskFieldValueRecord extends Message<TaskFieldValueRecord, Builder> {
    public static final ProtoAdapter<TaskFieldValueRecord> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskField field;
    public final TaskFieldValue new_value;
    public final TaskFieldValue old_value;

    public static final class Builder extends Message.Builder<TaskFieldValueRecord, Builder> {
        public TaskField field;
        public TaskFieldValue new_value;
        public TaskFieldValue old_value;

        @Override // com.squareup.wire.Message.Builder
        public TaskFieldValueRecord build() {
            return new TaskFieldValueRecord(this.field, this.old_value, this.new_value, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder field(TaskField r100) {
            this.field = r100;
            return this;
        }

        public Builder new_value(TaskFieldValue r100) {
            this.new_value = r100;
            return this;
        }

        public Builder old_value(TaskFieldValue r100) {
            this.old_value = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskFieldValueRecord extends ProtoAdapter<TaskFieldValueRecord> {
        public ProtoAdapter_TaskFieldValueRecord() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskFieldValueRecord.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskFieldValueRecord decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.field = TaskField.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.old_value = TaskFieldValue.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.new_value = TaskFieldValue.ADAPTER.decode(r100);
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
        public int encodedSize2(TaskFieldValueRecord r100) {
            TaskField r101 = r100.field;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskField.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TaskFieldValue r104 = r100.old_value;
            if (r104 == null) goto L9;
            int r105 = TaskFieldValue.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            TaskFieldValue r107 = r100.new_value;
            if (r107 == null) goto L14;
            r102 = TaskFieldValue.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ TaskFieldValueRecord decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskFieldValueRecord r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskFieldValueRecord r101) throws IOException {
            TaskField r102 = r101.field;
            if (r102 == null) goto L5;
            TaskField.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskFieldValue r103 = r101.old_value;
            if (r103 == null) goto L8;
            TaskFieldValue.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TaskFieldValue r104 = r101.new_value;
            if (r104 == null) goto L11;
            TaskFieldValue.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskFieldValueRecord r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskFieldValueRecord();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field = this.field;
        r100.old_value = this.old_value;
        r100.new_value = this.new_value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskFieldValueRecord.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskFieldValueRecord(TaskField r100, TaskFieldValue r101, TaskFieldValue r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TaskFieldValueRecord(TaskField r100, TaskFieldValue r101, TaskFieldValue r102, ByteString r103) {
        super(ADAPTER, r103);
        this.field = r100;
        this.old_value = r101;
        this.new_value = r102;
    }
}
