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
public final class GetTodoResponse extends Message<GetTodoResponse, Builder> {
    public static final ProtoAdapter<GetTodoResponse> ADAPTER = null;
    public static final ProtoAdapter_GetTodoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, SimpleTodo> ancestors;
    public final List<TaskContainer> related_task_lists;
    public final Todo todo;

    public static final class Builder extends Message.Builder<GetTodoResponse, Builder> implements d<GetTodoResponse> {
        public Map<String, SimpleTodo> ancestors;
        public List<TaskContainer> related_task_lists;
        public Todo todo;

        @Override // com.squareup.wire.Message.Builder
        public GetTodoResponse build() {
            return new GetTodoResponse(this.todo, this.ancestors, this.related_task_lists, super.buildUnknownFields());
        }

        public Builder() {
            this.ancestors = Internal.newMutableMap();
            this.related_task_lists = Internal.newMutableList();
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

        public Builder related_task_lists(List<TaskContainer> r100) {
            Internal.checkElementsNotNull(r100);
            this.related_task_lists = r100;
            return this;
        }

        public Builder todo(Todo r100) {
            this.todo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTodoResponse extends ProtoAdapter<GetTodoResponse> implements c<GetTodoResponse> {
        private final ProtoAdapter<Map<String, SimpleTodo>> ancestors;

        public ProtoAdapter_GetTodoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTodoResponse.class);
            this.ancestors = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SimpleTodo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTodoResponse decode(ProtoReader r100) throws IOException {
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
            r101.ancestors.putAll(this.ancestors.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.related_task_lists.add(TaskContainer.ADAPTER.decode(r100));
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
        public int encodedSize2(GetTodoResponse r100) {
            Todo r101 = r100.todo;
            if (r101 == null) goto L5;
            int r102 = Todo.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return ((r102 + this.ancestors.encodedSizeWithTag(2, r100.ancestors)) + TaskContainer.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.related_task_lists)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTodoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTodoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTodoResponse r101) throws IOException {
            Todo r102 = r101.todo;
            if (r102 == null) goto L5;
            Todo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.ancestors.encodeWithTag(r100, 2, r101.ancestors);
            TaskContainer.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.related_task_lists);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTodoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTodoResponse r100 = new ProtoAdapter_GetTodoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo = this.todo;
        r100.ancestors = Internal.copyOf("ancestors", this.ancestors);
        r100.related_task_lists = Internal.copyOf("related_task_lists", this.related_task_lists);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTodoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTodoResponse(Todo r100, Map<String, SimpleTodo> r101, List<TaskContainer> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetTodoResponse(Todo r100, Map<String, SimpleTodo> r101, List<TaskContainer> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.todo = r100;
        this.ancestors = Internal.immutableCopyOf("ancestors", r101);
        this.related_task_lists = Internal.immutableCopyOf("related_task_lists", r102);
    }
}
