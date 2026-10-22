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
public final class ChangedTodoCollection extends Message<ChangedTodoCollection, Builder> {
    public static final ProtoAdapter<ChangedTodoCollection> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> added_todo_idents;
    public final List<String> deleted_todo_idents;
    public final List<Todo> todos;
    public final List<String> updated_todo_idents;

    public static final class Builder extends Message.Builder<ChangedTodoCollection, Builder> {
        public List<String> added_todo_idents;
        public List<String> deleted_todo_idents;
        public List<Todo> todos;
        public List<String> updated_todo_idents;

        @Override // com.squareup.wire.Message.Builder
        public ChangedTodoCollection build() {
            return new ChangedTodoCollection(this.added_todo_idents, this.updated_todo_idents, this.deleted_todo_idents, this.todos, super.buildUnknownFields());
        }

        public Builder() {
            this.added_todo_idents = Internal.newMutableList();
            this.updated_todo_idents = Internal.newMutableList();
            this.deleted_todo_idents = Internal.newMutableList();
            this.todos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder added_todo_idents(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.added_todo_idents = r100;
            return this;
        }

        public Builder deleted_todo_idents(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.deleted_todo_idents = r100;
            return this;
        }

        public Builder todos(List<Todo> r100) {
            Internal.checkElementsNotNull(r100);
            this.todos = r100;
            return this;
        }

        public Builder updated_todo_idents(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.updated_todo_idents = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChangedTodoCollection extends ProtoAdapter<ChangedTodoCollection> {
        public ProtoAdapter_ChangedTodoCollection() {
            super(FieldEncoding.LENGTH_DELIMITED, ChangedTodoCollection.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChangedTodoCollection decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.added_todo_idents.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.updated_todo_idents.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.deleted_todo_idents.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.todos.add(Todo.ADAPTER.decode(r100));
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
        public int encodedSize2(ChangedTodoCollection r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.asRepeated().encodedSizeWithTag(1, r100.added_todo_idents) + r101.asRepeated().encodedSizeWithTag(2, r100.updated_todo_idents)) + r101.asRepeated().encodedSizeWithTag(3, r100.deleted_todo_idents)) + Todo.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.todos)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChangedTodoCollection decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChangedTodoCollection r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChangedTodoCollection r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.added_todo_idents);
            r102.asRepeated().encodeWithTag(r100, 2, r101.updated_todo_idents);
            r102.asRepeated().encodeWithTag(r100, 3, r101.deleted_todo_idents);
            Todo.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.todos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChangedTodoCollection r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChangedTodoCollection();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.added_todo_idents = Internal.copyOf("added_todo_idents", this.added_todo_idents);
        r100.updated_todo_idents = Internal.copyOf("updated_todo_idents", this.updated_todo_idents);
        r100.deleted_todo_idents = Internal.copyOf("deleted_todo_idents", this.deleted_todo_idents);
        r100.todos = Internal.copyOf("todos", this.todos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChangedTodoCollection.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChangedTodoCollection(List<String> r100, List<String> r101, List<String> r102, List<Todo> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ChangedTodoCollection(List<String> r100, List<String> r101, List<String> r102, List<Todo> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.added_todo_idents = Internal.immutableCopyOf("added_todo_idents", r100);
        this.updated_todo_idents = Internal.immutableCopyOf("updated_todo_idents", r101);
        this.deleted_todo_idents = Internal.immutableCopyOf("deleted_todo_idents", r102);
        this.todos = Internal.immutableCopyOf("todos", r103);
    }
}
