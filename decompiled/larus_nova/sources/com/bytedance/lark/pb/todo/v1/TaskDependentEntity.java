package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskDependentEntity extends Message<TaskDependentEntity, Builder> {
    public static final ProtoAdapter<TaskDependentEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskDependent> new_dependents;
    public final List<TaskDependent> old_dependents;

    public static final class Builder extends Message.Builder<TaskDependentEntity, Builder> {
        public List<TaskDependent> new_dependents;
        public List<TaskDependent> old_dependents;

        @Override // com.squareup.wire.Message.Builder
        public TaskDependentEntity build() {
            return new TaskDependentEntity(this.old_dependents, this.new_dependents, super.buildUnknownFields());
        }

        public Builder() {
            this.old_dependents = Internal.newMutableList();
            this.new_dependents = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder new_dependents(List<TaskDependent> r100) {
            Internal.checkElementsNotNull(r100);
            this.new_dependents = r100;
            return this;
        }

        public Builder old_dependents(List<TaskDependent> r100) {
            Internal.checkElementsNotNull(r100);
            this.old_dependents = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskDependentEntity extends ProtoAdapter<TaskDependentEntity> {
        public ProtoAdapter_TaskDependentEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskDependentEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskDependentEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.old_dependents.add(TaskDependent.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.new_dependents.add(TaskDependent.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskDependentEntity r100) {
            ProtoAdapter<TaskDependent> r101 = TaskDependent.ADAPTER;
            return (r101.asRepeated().encodedSizeWithTag(1, r100.old_dependents) + r101.asRepeated().encodedSizeWithTag(2, r100.new_dependents)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskDependentEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskDependentEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskDependentEntity r101) throws IOException {
            ProtoAdapter<TaskDependent> r102 = TaskDependent.ADAPTER;
            r102.asRepeated().encodeWithTag(r100, 1, r101.old_dependents);
            r102.asRepeated().encodeWithTag(r100, 2, r101.new_dependents);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskDependentEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskDependentEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_dependents = Internal.copyOf("old_dependents", this.old_dependents);
        r100.new_dependents = Internal.copyOf("new_dependents", this.new_dependents);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskDependentEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskDependentEntity(List<TaskDependent> r100, List<TaskDependent> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskDependentEntity(List<TaskDependent> r100, List<TaskDependent> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.old_dependents = Internal.immutableCopyOf("old_dependents", r100);
        this.new_dependents = Internal.immutableCopyOf("new_dependents", r101);
    }
}
