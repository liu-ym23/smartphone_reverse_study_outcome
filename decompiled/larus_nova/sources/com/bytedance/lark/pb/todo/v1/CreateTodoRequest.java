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
public final class CreateTodoRequest extends Message<CreateTodoRequest, Builder> {
    public static final ProtoAdapter<CreateTodoRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_TO_SEND = "";
    public static final String DEFAULT_PREV_SIBLING_IDENT = "";
    public static final ProtoAdapter_CreateTodoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_to_send;
    public final ContainerSection container_section;
    public final String prev_sibling_ident;
    public final List<Todo> sub_tasks;
    public final List<ContainerSection> task_list_sections;
    public final Todo todo;

    public static final class Builder extends Message.Builder<CreateTodoRequest, Builder> implements d<CreateTodoRequest> {
        public String chat_to_send;
        public ContainerSection container_section;
        public String prev_sibling_ident;
        public List<Todo> sub_tasks;
        public List<ContainerSection> task_list_sections;
        public Todo todo;

        @Override // com.squareup.wire.Message.Builder
        public CreateTodoRequest build() {
            return new CreateTodoRequest(this.todo, this.prev_sibling_ident, this.chat_to_send, this.sub_tasks, this.container_section, this.task_list_sections, super.buildUnknownFields());
        }

        public Builder() {
            this.sub_tasks = Internal.newMutableList();
            this.task_list_sections = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_to_send(String r100) {
            this.chat_to_send = r100;
            return this;
        }

        public Builder container_section(ContainerSection r100) {
            this.container_section = r100;
            return this;
        }

        public Builder prev_sibling_ident(String r100) {
            this.prev_sibling_ident = r100;
            return this;
        }

        public Builder sub_tasks(List<Todo> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_tasks = r100;
            return this;
        }

        public Builder task_list_sections(List<ContainerSection> r100) {
            Internal.checkElementsNotNull(r100);
            this.task_list_sections = r100;
            return this;
        }

        public Builder todo(Todo r100) {
            this.todo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateTodoRequest extends ProtoAdapter<CreateTodoRequest> implements c<CreateTodoRequest> {
        public ProtoAdapter_CreateTodoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateTodoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateTodoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.prev_sibling_ident = "";
            r101.chat_to_send = "";
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
            r101.task_list_sections.add(ContainerSection.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.container_section = ContainerSection.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.sub_tasks.add(Todo.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.chat_to_send = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.prev_sibling_ident = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.todo = Todo.ADAPTER.decode(r100);
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
        public int encodedSize2(CreateTodoRequest r100) {
            Todo r101 = r100.todo;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Todo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.prev_sibling_ident;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.chat_to_send;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + Todo.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.sub_tasks);
            ContainerSection r110 = r100.container_section;
            if (r110 == null) goto L18;
            r102 = ContainerSection.ADAPTER.encodedSizeWithTag(5, r110);
        L18:
            return ((r109 + r102) + ContainerSection.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.task_list_sections)) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateTodoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateTodoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateTodoRequest r101) throws IOException {
            Todo r102 = r101.todo;
            if (r102 == null) goto L5;
            Todo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.prev_sibling_ident;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.chat_to_send;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Todo.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.sub_tasks);
            ContainerSection r105 = r101.container_section;
            if (r105 == null) goto L14;
            ContainerSection.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            ContainerSection.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.task_list_sections);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateTodoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateTodoRequest r100 = new ProtoAdapter_CreateTodoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo = this.todo;
        r100.prev_sibling_ident = this.prev_sibling_ident;
        r100.chat_to_send = this.chat_to_send;
        r100.sub_tasks = Internal.copyOf("sub_tasks", this.sub_tasks);
        r100.container_section = this.container_section;
        r100.task_list_sections = Internal.copyOf("task_list_sections", this.task_list_sections);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateTodoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateTodoRequest(Todo r100, String r110, String r111, List<Todo> r112, ContainerSection r113, List<ContainerSection> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public CreateTodoRequest(Todo r100, String r101, String r102, List<Todo> r103, ContainerSection r104, List<ContainerSection> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.todo = r100;
        this.prev_sibling_ident = r101;
        this.chat_to_send = r102;
        this.sub_tasks = Internal.immutableCopyOf("sub_tasks", r103);
        this.container_section = r104;
        this.task_list_sections = Internal.immutableCopyOf("task_list_sections", r105);
    }
}
