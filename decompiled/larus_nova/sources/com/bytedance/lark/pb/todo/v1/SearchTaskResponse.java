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
public final class SearchTaskResponse extends Message<SearchTaskResponse, Builder> {
    public static final ProtoAdapter<SearchTaskResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_TOKEN = "";
    public static final ProtoAdapter_SearchTaskResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, TodoContainers> guid_to_containers;
    public final Map<String, SearchTodoExtraInfo> guid_to_extra;
    public final Map<String, SimpleTodo> guid_to_parent_todo;
    public final Boolean has_more;
    public final List<Todo> todos;
    public final String token;

    public static final class Builder extends Message.Builder<SearchTaskResponse, Builder> implements d<SearchTaskResponse> {
        public Map<String, TodoContainers> guid_to_containers;
        public Map<String, SearchTodoExtraInfo> guid_to_extra;
        public Map<String, SimpleTodo> guid_to_parent_todo;
        public Boolean has_more;
        public List<Todo> todos;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public SearchTaskResponse build() {
            return new SearchTaskResponse(this.todos, this.token, this.has_more, this.guid_to_parent_todo, this.guid_to_containers, this.guid_to_extra, super.buildUnknownFields());
        }

        public Builder() {
            this.todos = Internal.newMutableList();
            this.guid_to_parent_todo = Internal.newMutableMap();
            this.guid_to_containers = Internal.newMutableMap();
            this.guid_to_extra = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder guid_to_containers(Map<String, TodoContainers> r100) {
            Internal.checkElementsNotNull(r100);
            this.guid_to_containers = r100;
            return this;
        }

        public Builder guid_to_extra(Map<String, SearchTodoExtraInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.guid_to_extra = r100;
            return this;
        }

        public Builder guid_to_parent_todo(Map<String, SimpleTodo> r100) {
            Internal.checkElementsNotNull(r100);
            this.guid_to_parent_todo = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder todos(List<Todo> r100) {
            Internal.checkElementsNotNull(r100);
            this.todos = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchTaskResponse extends ProtoAdapter<SearchTaskResponse> implements c<SearchTaskResponse> {
        private final ProtoAdapter<Map<String, TodoContainers>> guid_to_containers;
        private final ProtoAdapter<Map<String, SearchTodoExtraInfo>> guid_to_extra;
        private final ProtoAdapter<Map<String, SimpleTodo>> guid_to_parent_todo;

        public ProtoAdapter_SearchTaskResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTaskResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.guid_to_parent_todo = ProtoAdapter.newMapAdapter(r100, SimpleTodo.ADAPTER);
            this.guid_to_containers = ProtoAdapter.newMapAdapter(r100, TodoContainers.ADAPTER);
            this.guid_to_extra = ProtoAdapter.newMapAdapter(r100, SearchTodoExtraInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchTaskResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.token = "";
            r101.has_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.guid_to_extra.putAll(this.guid_to_extra.decode(r100));
            goto L3
        L8:
            r101.guid_to_containers.putAll(this.guid_to_containers.decode(r100));
            goto L3
        L9:
            r101.guid_to_parent_todo.putAll(this.guid_to_parent_todo.decode(r100));
            goto L3
        L10:
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.todos.add(Todo.ADAPTER.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchTaskResponse r100) {
            int r101 = Todo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.todos);
            String r102 = r100.token;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.has_more;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return ((((r105 + r103) + this.guid_to_parent_todo.encodedSizeWithTag(4, r100.guid_to_parent_todo)) + this.guid_to_containers.encodedSizeWithTag(5, r100.guid_to_containers)) + this.guid_to_extra.encodedSizeWithTag(6, r100.guid_to_extra)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchTaskResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchTaskResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchTaskResponse r101) throws IOException {
            Todo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.todos);
            String r102 = r101.token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.has_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            this.guid_to_parent_todo.encodeWithTag(r100, 4, r101.guid_to_parent_todo);
            this.guid_to_containers.encodeWithTag(r100, 5, r101.guid_to_containers);
            this.guid_to_extra.encodeWithTag(r100, 6, r101.guid_to_extra);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchTaskResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SearchTaskResponse r100 = new ProtoAdapter_SearchTaskResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todos = Internal.copyOf("todos", this.todos);
        r100.token = this.token;
        r100.has_more = this.has_more;
        r100.guid_to_parent_todo = Internal.copyOf("guid_to_parent_todo", this.guid_to_parent_todo);
        r100.guid_to_containers = Internal.copyOf("guid_to_containers", this.guid_to_containers);
        r100.guid_to_extra = Internal.copyOf("guid_to_extra", this.guid_to_extra);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchTaskResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchTaskResponse(List<Todo> r100, String r110, Boolean r111, Map<String, SimpleTodo> r112, Map<String, TodoContainers> r113, Map<String, SearchTodoExtraInfo> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public SearchTaskResponse(List<Todo> r100, String r101, Boolean r102, Map<String, SimpleTodo> r103, Map<String, TodoContainers> r104, Map<String, SearchTodoExtraInfo> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.todos = Internal.immutableCopyOf("todos", r100);
        this.token = r101;
        this.has_more = r102;
        this.guid_to_parent_todo = Internal.immutableCopyOf("guid_to_parent_todo", r103);
        this.guid_to_containers = Internal.immutableCopyOf("guid_to_containers", r104);
        this.guid_to_extra = Internal.immutableCopyOf("guid_to_extra", r105);
    }
}
