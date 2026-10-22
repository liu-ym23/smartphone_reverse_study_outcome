package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoDailyRemind extends com.squareup.wire.Message<TodoDailyRemind, Builder> {
    public static final ProtoAdapter<TodoDailyRemind> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TodoDetail> todos;

    public static final class Builder extends com.squareup.wire.Message.Builder<TodoDailyRemind, Builder> {
        public List<TodoDetail> todos;

        @Override // com.squareup.wire.Message.Builder
        public TodoDailyRemind build() {
            return new TodoDailyRemind(this.todos, super.buildUnknownFields());
        }

        public Builder() {
            this.todos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder todos(List<TodoDetail> r100) {
            Internal.checkElementsNotNull(r100);
            this.todos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoDailyRemind extends ProtoAdapter<TodoDailyRemind> {
        public ProtoAdapter_TodoDailyRemind() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoDailyRemind.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoDailyRemind decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.todos.add(TodoDetail.ADAPTER.decode(r100));
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
        public int encodedSize2(TodoDailyRemind r100) {
            return TodoDetail.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.todos) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoDailyRemind decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoDailyRemind r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoDailyRemind r101) throws IOException {
            TodoDetail.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.todos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoDailyRemind r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoDailyRemind();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todos = Internal.copyOf("todos", this.todos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoDailyRemind.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoDailyRemind(List<TodoDetail> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TodoDailyRemind(List<TodoDetail> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.todos = Internal.immutableCopyOf("todos", r100);
    }
}
