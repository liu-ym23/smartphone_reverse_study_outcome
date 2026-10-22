package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskContainerInfo extends Message<TaskContainerInfo, Builder> {
    public static final ProtoAdapter<TaskContainerInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, SimpleTodo> ancestors;
    public final TaskContainerRef ref;
    public final Todo task;

    public static final class Builder extends Message.Builder<TaskContainerInfo, Builder> {
        public Map<String, SimpleTodo> ancestors;
        public TaskContainerRef ref;
        public Todo task;

        @Override // com.squareup.wire.Message.Builder
        public TaskContainerInfo build() {
            return new TaskContainerInfo(this.task, this.ref, this.ancestors, super.buildUnknownFields());
        }

        public Builder() {
            this.ancestors = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ancestors(Map<String, SimpleTodo> r100) {
            Internal.checkElementsNotNull(r100);
            this.ancestors = r100;
            return this;
        }

        public Builder ref(TaskContainerRef r100) {
            this.ref = r100;
            return this;
        }

        public Builder task(Todo r100) {
            this.task = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerInfo extends ProtoAdapter<TaskContainerInfo> {
        private final ProtoAdapter<Map<String, SimpleTodo>> ancestors;

        public ProtoAdapter_TaskContainerInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerInfo.class);
            this.ancestors = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SimpleTodo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskContainerInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.task = Todo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.ref = TaskContainerRef.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.ancestors.putAll(this.ancestors.decode(r100));
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
        public int encodedSize2(TaskContainerInfo r100) {
            Todo r101 = r100.task;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Todo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TaskContainerRef r104 = r100.ref;
            if (r104 == null) goto L10;
            r102 = TaskContainerRef.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + this.ancestors.encodedSizeWithTag(3, r100.ancestors)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskContainerInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskContainerInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskContainerInfo r101) throws IOException {
            Todo r102 = r101.task;
            if (r102 == null) goto L5;
            Todo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskContainerRef r103 = r101.ref;
            if (r103 == null) goto L8;
            TaskContainerRef.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            this.ancestors.encodeWithTag(r100, 3, r101.ancestors);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskContainerInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.task = this.task;
        r100.ref = this.ref;
        r100.ancestors = Internal.copyOf("ancestors", this.ancestors);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskContainerInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskContainerInfo(Todo r100, TaskContainerRef r101, Map<String, SimpleTodo> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TaskContainerInfo(Todo r100, TaskContainerRef r101, Map<String, SimpleTodo> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.task = r100;
        this.ref = r101;
        this.ancestors = Internal.immutableCopyOf("ancestors", r102);
    }
}
