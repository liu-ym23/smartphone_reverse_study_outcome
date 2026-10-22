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
public final class TaskCriticalPath extends Message<TaskCriticalPath, Builder> {
    public static final ProtoAdapter<TaskCriticalPath> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskDependentRef> dependent_refs;
    public final List<String> task_guids;

    public static final class Builder extends Message.Builder<TaskCriticalPath, Builder> {
        public List<TaskDependentRef> dependent_refs;
        public List<String> task_guids;

        @Override // com.squareup.wire.Message.Builder
        public TaskCriticalPath build() {
            return new TaskCriticalPath(this.task_guids, this.dependent_refs, super.buildUnknownFields());
        }

        public Builder() {
            this.task_guids = Internal.newMutableList();
            this.dependent_refs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder dependent_refs(List<TaskDependentRef> r100) {
            Internal.checkElementsNotNull(r100);
            this.dependent_refs = r100;
            return this;
        }

        public Builder task_guids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_guids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskCriticalPath extends ProtoAdapter<TaskCriticalPath> {
        public ProtoAdapter_TaskCriticalPath() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskCriticalPath.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskCriticalPath decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.task_guids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.dependent_refs.add(TaskDependentRef.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskCriticalPath r100) {
            return (ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.task_guids) + TaskDependentRef.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.dependent_refs)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskCriticalPath decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskCriticalPath r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskCriticalPath r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.task_guids);
            TaskDependentRef.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.dependent_refs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskCriticalPath r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskCriticalPath();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_guids = Internal.copyOf("task_guids", this.task_guids);
        r100.dependent_refs = Internal.copyOf("dependent_refs", this.dependent_refs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskCriticalPath.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskCriticalPath(List<String> r100, List<TaskDependentRef> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TaskCriticalPath(List<String> r100, List<TaskDependentRef> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.task_guids = Internal.immutableCopyOf("task_guids", r100);
        this.dependent_refs = Internal.immutableCopyOf("dependent_refs", r101);
    }
}
