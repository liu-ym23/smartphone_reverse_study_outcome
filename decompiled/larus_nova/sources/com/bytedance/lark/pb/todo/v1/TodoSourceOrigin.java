package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoSourceOrigin extends Message<TodoSourceOrigin, Builder> {
    public static final ProtoAdapter<TodoSourceOrigin> ADAPTER = null;
    public static final TodoSource DEFAULT_SOURCE = null;
    private static final long serialVersionUID = 0;
    public final TodoOrigin origin;
    public final TodoSource source;

    public static final class Builder extends Message.Builder<TodoSourceOrigin, Builder> {
        public TodoOrigin origin;
        public TodoSource source;

        @Override // com.squareup.wire.Message.Builder
        public TodoSourceOrigin build() {
            return new TodoSourceOrigin(this.source, this.origin, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder origin(TodoOrigin r100) {
            this.origin = r100;
            return this;
        }

        public Builder source(TodoSource r100) {
            this.source = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoSourceOrigin extends ProtoAdapter<TodoSourceOrigin> {
        public ProtoAdapter_TodoSourceOrigin() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoSourceOrigin.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoSourceOrigin decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source = TodoSource.UNKNOWN_SOURCE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.source = TodoSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.origin = TodoOrigin.ADAPTER.decode(r100);
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
        public int encodedSize2(TodoSourceOrigin r100) {
            TodoSource r101 = r100.source;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TodoSource.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoOrigin r104 = r100.origin;
            if (r104 == null) goto L10;
            r102 = TodoOrigin.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoSourceOrigin decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoSourceOrigin r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoSourceOrigin r101) throws IOException {
            TodoSource r102 = r101.source;
            if (r102 == null) goto L5;
            TodoSource.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoOrigin r103 = r101.origin;
            if (r103 == null) goto L8;
            TodoOrigin.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoSourceOrigin r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoSourceOrigin();
        DEFAULT_SOURCE = TodoSource.UNKNOWN_SOURCE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source = this.source;
        r100.origin = this.origin;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoSourceOrigin.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoSourceOrigin(TodoSource r100, TodoOrigin r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TodoSourceOrigin(TodoSource r100, TodoOrigin r101, ByteString r102) {
        super(ADAPTER, r102);
        this.source = r100;
        this.origin = r101;
    }
}
