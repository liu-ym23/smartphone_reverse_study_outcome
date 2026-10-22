package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateTodoRequest extends Message<UpdateTodoRequest, Builder> {
    public static final ProtoAdapter<UpdateTodoRequest> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final ProtoAdapter_UpdateTodoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String container_id;
    public final Todo old_todo;
    public final Todo todo;

    public static final class Builder extends Message.Builder<UpdateTodoRequest, Builder> implements d<UpdateTodoRequest> {
        public String container_id;
        public Todo old_todo;
        public Todo todo;

        @Override // com.squareup.wire.Message.Builder
        public UpdateTodoRequest build() {
            return new UpdateTodoRequest(this.todo, this.old_todo, this.container_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
        }

        public Builder old_todo(Todo r100) {
            this.old_todo = r100;
            return this;
        }

        public Builder todo(Todo r100) {
            this.todo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTodoRequest extends ProtoAdapter<UpdateTodoRequest> implements c<UpdateTodoRequest> {
        public ProtoAdapter_UpdateTodoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTodoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateTodoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.todo = Todo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.old_todo = Todo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.container_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UpdateTodoRequest r100) {
            Todo r101 = r100.todo;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Todo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Todo r104 = r100.old_todo;
            if (r104 == null) goto L9;
            int r105 = Todo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.container_id;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateTodoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateTodoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateTodoRequest r101) throws IOException {
            Todo r102 = r101.todo;
            if (r102 == null) goto L5;
            Todo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Todo r103 = r101.old_todo;
            if (r103 == null) goto L8;
            Todo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.container_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateTodoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateTodoRequest r100 = new ProtoAdapter_UpdateTodoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo = this.todo;
        r100.old_todo = this.old_todo;
        r100.container_id = this.container_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateTodoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateTodoRequest(Todo r100, Todo r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UpdateTodoRequest(Todo r100, Todo r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.todo = r100;
        this.old_todo = r101;
        this.container_id = r102;
    }
}
