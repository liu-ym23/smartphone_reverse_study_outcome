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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateTodoResponse extends Message<CreateTodoResponse, Builder> {
    public static final ProtoAdapter<CreateTodoResponse> ADAPTER = null;
    public static final ProtoAdapter_CreateTodoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskContainerRef task_container_ref;
    public final List<TaskContainerRef> task_list_container_refs;
    public final Todo todo;

    public static final class Builder extends Message.Builder<CreateTodoResponse, Builder> implements d<CreateTodoResponse> {
        public TaskContainerRef task_container_ref;
        public List<TaskContainerRef> task_list_container_refs;
        public Todo todo;

        @Override // com.squareup.wire.Message.Builder
        public CreateTodoResponse build() {
            return new CreateTodoResponse(this.todo, this.task_container_ref, this.task_list_container_refs, super.buildUnknownFields());
        }

        public Builder() {
            this.task_list_container_refs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder task_container_ref(TaskContainerRef r100) {
            this.task_container_ref = r100;
            return this;
        }

        public Builder task_list_container_refs(List<TaskContainerRef> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_list_container_refs = r100;
            return this;
        }

        public Builder todo(Todo r100) {
            this.todo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateTodoResponse extends ProtoAdapter<CreateTodoResponse> implements c<CreateTodoResponse> {
        public ProtoAdapter_CreateTodoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateTodoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateTodoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.todo = Todo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.task_container_ref = TaskContainerRef.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.task_list_container_refs.add(TaskContainerRef.ADAPTER.decode(r100));
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
        public int encodedSize2(CreateTodoResponse r100) {
            Todo r101 = r100.todo;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Todo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TaskContainerRef r104 = r100.task_container_ref;
            if (r104 == null) goto L10;
            r102 = TaskContainerRef.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + TaskContainerRef.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.task_list_container_refs)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateTodoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateTodoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateTodoResponse r101) throws IOException {
            Todo r102 = r101.todo;
            if (r102 == null) goto L5;
            Todo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskContainerRef r103 = r101.task_container_ref;
            if (r103 == null) goto L8;
            TaskContainerRef.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            TaskContainerRef.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.task_list_container_refs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateTodoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateTodoResponse r100 = new ProtoAdapter_CreateTodoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo = this.todo;
        r100.task_container_ref = this.task_container_ref;
        r100.task_list_container_refs = Internal.copyOf("task_list_container_refs", this.task_list_container_refs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateTodoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateTodoResponse(Todo r100, TaskContainerRef r101, List<TaskContainerRef> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CreateTodoResponse(Todo r100, TaskContainerRef r101, List<TaskContainerRef> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.todo = r100;
        this.task_container_ref = r101;
        this.task_list_container_refs = Internal.immutableCopyOf("task_list_container_refs", r102);
    }
}
