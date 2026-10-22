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
public final class GetTodoUsersByChatterIdsResponse extends Message<GetTodoUsersByChatterIdsResponse, Builder> {
    public static final ProtoAdapter<GetTodoUsersByChatterIdsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetTodoUsersByChatterIdsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TodoUser> users;

    public static final class Builder extends Message.Builder<GetTodoUsersByChatterIdsResponse, Builder> implements d<GetTodoUsersByChatterIdsResponse> {
        public List<TodoUser> users;

        @Override // com.squareup.wire.Message.Builder
        public GetTodoUsersByChatterIdsResponse build() {
            return new GetTodoUsersByChatterIdsResponse(this.users, super.buildUnknownFields());
        }

        public Builder() {
            this.users = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder users(List<TodoUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.users = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTodoUsersByChatterIdsResponse extends ProtoAdapter<GetTodoUsersByChatterIdsResponse> implements c<GetTodoUsersByChatterIdsResponse> {
        public ProtoAdapter_GetTodoUsersByChatterIdsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTodoUsersByChatterIdsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTodoUsersByChatterIdsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 2) goto L7;
            r101.users.add(TodoUser.ADAPTER.decode(r100));
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
        public int encodedSize2(GetTodoUsersByChatterIdsResponse r100) {
            return TodoUser.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.users) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTodoUsersByChatterIdsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTodoUsersByChatterIdsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTodoUsersByChatterIdsResponse r101) throws IOException {
            TodoUser.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.users);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTodoUsersByChatterIdsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTodoUsersByChatterIdsResponse r100 = new ProtoAdapter_GetTodoUsersByChatterIdsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.users = Internal.copyOf("users", this.users);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTodoUsersByChatterIdsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTodoUsersByChatterIdsResponse(List<TodoUser> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetTodoUsersByChatterIdsResponse(List<TodoUser> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.users = Internal.immutableCopyOf("users", r100);
    }
}
