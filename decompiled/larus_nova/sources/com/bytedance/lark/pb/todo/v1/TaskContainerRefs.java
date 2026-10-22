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
public final class TaskContainerRefs extends Message<TaskContainerRefs, Builder> {
    public static final ProtoAdapter<TaskContainerRefs> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskContainerRef> task_container_refs;

    public static final class Builder extends Message.Builder<TaskContainerRefs, Builder> {
        public List<TaskContainerRef> task_container_refs;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainerRefs build() {
            return new TaskContainerRefs(this.task_container_refs, super.buildUnknownFields());
        }

        public Builder() {
            this.task_container_refs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_container_refs(List<TaskContainerRef> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_container_refs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerRefs extends ProtoAdapter<TaskContainerRefs> {
        public ProtoAdapter_TaskContainerRefs() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerRefs.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainerRefs decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.task_container_refs.add(TaskContainerRef.ADAPTER.decode(r100));
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
        public int encodedSize2(TaskContainerRefs r100) {
            return TaskContainerRef.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.task_container_refs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskContainerRefs decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainerRefs r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainerRefs r101) throws IOException {
            TaskContainerRef.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.task_container_refs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainerRefs r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerRefs();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task_container_refs = Internal.copyOf("task_container_refs", this.task_container_refs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainerRefs.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainerRefs(List<TaskContainerRef> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TaskContainerRefs(List<TaskContainerRef> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.task_container_refs = Internal.immutableCopyOf("task_container_refs", r100);
    }
}
