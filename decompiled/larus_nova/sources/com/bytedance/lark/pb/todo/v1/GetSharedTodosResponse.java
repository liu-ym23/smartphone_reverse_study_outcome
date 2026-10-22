package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetSharedTodosResponse extends Message<GetSharedTodosResponse, Builder> {
    public static final ProtoAdapter<GetSharedTodosResponse> ADAPTER = null;
    public static final ProtoAdapter_GetSharedTodosResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, SimpleTodo> ancestors;
    public final Map<String, ContainerTaskFieldAssociations> container_field_associations;
    public final Map<String, TaskContainer> related_task_lists;
    public final List<Todo> todos;

    public static final class Builder extends Message.Builder<GetSharedTodosResponse, Builder> implements d<GetSharedTodosResponse> {
        public Map<String, SimpleTodo> ancestors;
        public Map<String, ContainerTaskFieldAssociations> container_field_associations;
        public Map<String, TaskContainer> related_task_lists;
        public List<Todo> todos;

        @Override // com.squareup.wire.Message.Builder
        public GetSharedTodosResponse build() {
            return new GetSharedTodosResponse(this.todos, this.ancestors, this.related_task_lists, this.container_field_associations, super.buildUnknownFields());
        }

        public Builder() {
            this.todos = Internal.newMutableList();
            this.ancestors = Internal.newMutableMap();
            this.related_task_lists = Internal.newMutableMap();
            this.container_field_associations = Internal.newMutableMap();
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

        public Builder container_field_associations(Map<String, ContainerTaskFieldAssociations> r100) {
            Internal.checkElementsNotNull(r100);
            this.container_field_associations = r100;
            return this;
        }

        public Builder related_task_lists(Map<String, TaskContainer> r100) {
            Internal.checkElementsNotNull(r100);
            this.related_task_lists = r100;
            return this;
        }

        public Builder todos(List<Todo> r100) {
            Internal.checkElementsNotNull(r100);
            this.todos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSharedTodosResponse extends ProtoAdapter<GetSharedTodosResponse> implements c<GetSharedTodosResponse> {
        private final ProtoAdapter<Map<String, SimpleTodo>> ancestors;
        private final ProtoAdapter<Map<String, ContainerTaskFieldAssociations>> container_field_associations;
        private final ProtoAdapter<Map<String, TaskContainer>> related_task_lists;

        public ProtoAdapter_GetSharedTodosResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSharedTodosResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.ancestors = ProtoAdapter.newMapAdapter(r100, SimpleTodo.ADAPTER);
            this.related_task_lists = ProtoAdapter.newMapAdapter(r100, TaskContainer.ADAPTER);
            this.container_field_associations = ProtoAdapter.newMapAdapter(r100, ContainerTaskFieldAssociations.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSharedTodosResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 2) goto L8;
            r101.todos.add(Todo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.ancestors.putAll(this.ancestors.decode(r100));
            goto L3
        L10:
            if (r103 != 4) goto L12;
            r101.related_task_lists.putAll(this.related_task_lists.decode(r100));
            goto L3
        L12:
            if (r103 != 5) goto L13;
            r101.container_field_associations.putAll(this.container_field_associations.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetSharedTodosResponse r100) {
            return (((Todo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.todos) + this.ancestors.encodedSizeWithTag(3, r100.ancestors)) + this.related_task_lists.encodedSizeWithTag(4, r100.related_task_lists)) + this.container_field_associations.encodedSizeWithTag(5, r100.container_field_associations)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSharedTodosResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSharedTodosResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSharedTodosResponse r101) throws IOException {
            Todo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.todos);
            this.ancestors.encodeWithTag(r100, 3, r101.ancestors);
            this.related_task_lists.encodeWithTag(r100, 4, r101.related_task_lists);
            this.container_field_associations.encodeWithTag(r100, 5, r101.container_field_associations);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSharedTodosResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetSharedTodosResponse r100 = new ProtoAdapter_GetSharedTodosResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todos = Internal.copyOf("todos", this.todos);
        r100.ancestors = Internal.copyOf("ancestors", this.ancestors);
        r100.related_task_lists = Internal.copyOf("related_task_lists", this.related_task_lists);
        r100.container_field_associations = Internal.copyOf("container_field_associations", this.container_field_associations);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSharedTodosResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSharedTodosResponse(List<Todo> r100, Map<String, SimpleTodo> r101, Map<String, TaskContainer> r102, Map<String, ContainerTaskFieldAssociations> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetSharedTodosResponse(List<Todo> r100, Map<String, SimpleTodo> r101, Map<String, TaskContainer> r102, Map<String, ContainerTaskFieldAssociations> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.todos = Internal.immutableCopyOf("todos", r100);
        this.ancestors = Internal.immutableCopyOf("ancestors", r101);
        this.related_task_lists = Internal.immutableCopyOf("related_task_lists", r102);
        this.container_field_associations = Internal.immutableCopyOf("container_field_associations", r103);
    }
}
