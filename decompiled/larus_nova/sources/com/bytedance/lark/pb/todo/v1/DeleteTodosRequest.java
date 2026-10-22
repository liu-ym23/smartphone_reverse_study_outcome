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
public final class DeleteTodosRequest extends Message<DeleteTodosRequest, Builder> {
    public static final ProtoAdapter<DeleteTodosRequest> ADAPTER = null;
    public static final TodoSource DEFAULT_SOURCE = null;
    public static final ProtoAdapter_DeleteTodosRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TodoSource source;
    public final List<String> todo_guids;

    public static final class Builder extends Message.Builder<DeleteTodosRequest, Builder> implements d<DeleteTodosRequest> {
        public TodoSource source;
        public List<String> todo_guids;

        @Override // com.squareup.wire.Message.Builder
        public DeleteTodosRequest build() {
            return new DeleteTodosRequest(this.todo_guids, this.source, super.buildUnknownFields());
        }

        public Builder() {
            this.todo_guids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder source(TodoSource r100) {
            this.source = r100;
            return this;
        }

        public Builder todo_guids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.todo_guids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteTodosRequest extends ProtoAdapter<DeleteTodosRequest> implements c<DeleteTodosRequest> {
        public ProtoAdapter_DeleteTodosRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteTodosRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeleteTodosRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source = TodoSource.UNKNOWN_SOURCE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.todo_guids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.source = TodoSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DeleteTodosRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.todo_guids);
            TodoSource r102 = r100.source;
            if (r102 == null) goto L5;
            int r103 = TodoSource.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeleteTodosRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeleteTodosRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeleteTodosRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.todo_guids);
            TodoSource r102 = r101.source;
            if (r102 == null) goto L5;
            TodoSource.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeleteTodosRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_DeleteTodosRequest r100 = new ProtoAdapter_DeleteTodosRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SOURCE = TodoSource.UNKNOWN_SOURCE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guids = Internal.copyOf("todo_guids", this.todo_guids);
        r100.source = this.source;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeleteTodosRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeleteTodosRequest(List<String> r100, TodoSource r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DeleteTodosRequest(List<String> r100, TodoSource r101, ByteString r102) {
        super(ADAPTER, r102);
        this.todo_guids = Internal.immutableCopyOf("todo_guids", r100);
        this.source = r101;
    }
}
