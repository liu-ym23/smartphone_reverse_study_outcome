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
public final class QuitTodoRequest extends Message<QuitTodoRequest, Builder> {
    public static final ProtoAdapter<QuitTodoRequest> ADAPTER = null;
    public static final TodoSource DEFAULT_SOURCE = null;
    public static final String DEFAULT_TODO_GUID = "";
    public static final ProtoAdapter_QuitTodoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TodoSource source;
    public final String todo_guid;

    public static final class Builder extends Message.Builder<QuitTodoRequest, Builder> implements d<QuitTodoRequest> {
        public TodoSource source;
        public String todo_guid;

        @Override // com.squareup.wire.Message.Builder
        public QuitTodoRequest build() {
            return new QuitTodoRequest(this.todo_guid, this.source, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder source(TodoSource r100) {
            this.source = r100;
            return this;
        }

        public Builder todo_guid(String r100) {
            this.todo_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuitTodoRequest extends ProtoAdapter<QuitTodoRequest> implements c<QuitTodoRequest> {
        public ProtoAdapter_QuitTodoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, QuitTodoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuitTodoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.todo_guid = "";
            r101.source = TodoSource.UNKNOWN_SOURCE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.todo_guid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(QuitTodoRequest r100) {
            String r101 = r100.todo_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            TodoSource r104 = r100.source;
            if (r104 == null) goto L10;
            r102 = TodoSource.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ QuitTodoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuitTodoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuitTodoRequest r101) throws IOException {
            String r102 = r101.todo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TodoSource r103 = r101.source;
            if (r103 == null) goto L8;
            TodoSource.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuitTodoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_QuitTodoRequest r100 = new ProtoAdapter_QuitTodoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SOURCE = TodoSource.UNKNOWN_SOURCE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guid = this.todo_guid;
        r100.source = this.source;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuitTodoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuitTodoRequest(String r100, TodoSource r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public QuitTodoRequest(String r100, TodoSource r101, ByteString r102) {
        super(ADAPTER, r102);
        this.todo_guid = r100;
        this.source = r101;
    }
}
