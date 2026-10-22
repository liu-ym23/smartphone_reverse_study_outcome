package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskDueTimeUpdateEntity extends Message<TaskDueTimeUpdateEntity, Builder> {
    public static final ProtoAdapter<TaskDueTimeUpdateEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DueTimeEntity new_due_time;
    public final DueTimeEntity old_due_time;

    public static final class Builder extends Message.Builder<TaskDueTimeUpdateEntity, Builder> {
        public DueTimeEntity new_due_time;
        public DueTimeEntity old_due_time;

        @Override // com.squareup.wire.Message.Builder
        public TaskDueTimeUpdateEntity build() {
            return new TaskDueTimeUpdateEntity(this.old_due_time, this.new_due_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder new_due_time(DueTimeEntity r100) {
            this.new_due_time = r100;
            return this;
        }

        public Builder old_due_time(DueTimeEntity r100) {
            this.old_due_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskDueTimeUpdateEntity extends ProtoAdapter<TaskDueTimeUpdateEntity> {
        public ProtoAdapter_TaskDueTimeUpdateEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskDueTimeUpdateEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskDueTimeUpdateEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.old_due_time = DueTimeEntity.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.new_due_time = DueTimeEntity.ADAPTER.decode(r100);
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
        public int encodedSize2(TaskDueTimeUpdateEntity r100) {
            DueTimeEntity r101 = r100.old_due_time;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DueTimeEntity.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            DueTimeEntity r104 = r100.new_due_time;
            if (r104 == null) goto L10;
            r102 = DueTimeEntity.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskDueTimeUpdateEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskDueTimeUpdateEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskDueTimeUpdateEntity r101) throws IOException {
            DueTimeEntity r102 = r101.old_due_time;
            if (r102 == null) goto L5;
            DueTimeEntity.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DueTimeEntity r103 = r101.new_due_time;
            if (r103 == null) goto L8;
            DueTimeEntity.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskDueTimeUpdateEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskDueTimeUpdateEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_due_time = this.old_due_time;
        r100.new_due_time = this.new_due_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskDueTimeUpdateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskDueTimeUpdateEntity(DueTimeEntity r100, DueTimeEntity r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskDueTimeUpdateEntity(DueTimeEntity r100, DueTimeEntity r101, ByteString r102) {
        super(ADAPTER, r102);
        this.old_due_time = r100;
        this.new_due_time = r101;
    }
}
