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
public final class GetChatTodosResponse extends Message<GetChatTodosResponse, Builder> {
    public static final ProtoAdapter<GetChatTodosResponse> ADAPTER = null;
    public static final ProtoAdapter_GetChatTodosResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ChatTodoInfo> assign_to_me_todos;
    public final List<ChatTodoInfo> assign_to_other_todos;

    public static final class Builder extends Message.Builder<GetChatTodosResponse, Builder> implements d<GetChatTodosResponse> {
        public List<ChatTodoInfo> assign_to_me_todos;
        public List<ChatTodoInfo> assign_to_other_todos;

        @Override // com.squareup.wire.Message.Builder
        public GetChatTodosResponse build() {
            return new GetChatTodosResponse(this.assign_to_me_todos, this.assign_to_other_todos, super.buildUnknownFields());
        }

        public Builder() {
            this.assign_to_me_todos = Internal.newMutableList();
            this.assign_to_other_todos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder assign_to_me_todos(List<ChatTodoInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.assign_to_me_todos = r100;
            return this;
        }

        public Builder assign_to_other_todos(List<ChatTodoInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.assign_to_other_todos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetChatTodosResponse extends ProtoAdapter<GetChatTodosResponse> implements c<GetChatTodosResponse> {
        public ProtoAdapter_GetChatTodosResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetChatTodosResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetChatTodosResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.assign_to_me_todos.add(ChatTodoInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.assign_to_other_todos.add(ChatTodoInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(GetChatTodosResponse r100) {
            ProtoAdapter<ChatTodoInfo> r101 = ChatTodoInfo.ADAPTER;
            return (r101.asRepeated().encodedSizeWithTag(1, r100.assign_to_me_todos) + r101.asRepeated().encodedSizeWithTag(2, r100.assign_to_other_todos)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetChatTodosResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetChatTodosResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetChatTodosResponse r101) throws IOException {
            ProtoAdapter<ChatTodoInfo> r102 = ChatTodoInfo.ADAPTER;
            r102.asRepeated().encodeWithTag(r100, 1, r101.assign_to_me_todos);
            r102.asRepeated().encodeWithTag(r100, 2, r101.assign_to_other_todos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetChatTodosResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetChatTodosResponse r100 = new ProtoAdapter_GetChatTodosResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.assign_to_me_todos = Internal.copyOf("assign_to_me_todos", this.assign_to_me_todos);
        r100.assign_to_other_todos = Internal.copyOf("assign_to_other_todos", this.assign_to_other_todos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetChatTodosResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetChatTodosResponse(List<ChatTodoInfo> r100, List<ChatTodoInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetChatTodosResponse(List<ChatTodoInfo> r100, List<ChatTodoInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.assign_to_me_todos = Internal.immutableCopyOf("assign_to_me_todos", r100);
        this.assign_to_other_todos = Internal.immutableCopyOf("assign_to_other_todos", r101);
    }
}
