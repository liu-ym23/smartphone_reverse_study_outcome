package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskItemMember extends Message<TaskItemMember, Builder> {
    public static final ProtoAdapter<TaskItemMember> ADAPTER = null;
    public static final TodoItemMemberType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final TodoChat chat;

    /* JADX INFO: renamed from: doc, reason: collision with root package name */
    public final TodoDoc f253777doc;
    public final TodoItemMemberType type;
    public final TodoUser user;

    public static final class Builder extends Message.Builder<TaskItemMember, Builder> {
        public TodoChat chat;

        /* JADX INFO: renamed from: doc, reason: collision with root package name */
        public TodoDoc f253778doc;
        public TodoItemMemberType type;
        public TodoUser user;

        @Override // com.squareup.wire.Message.Builder
        public TaskItemMember build() {
            return new TaskItemMember(this.type, this.user, this.chat, this.f253778doc, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat(TodoChat r100) {
            this.chat = r100;
            this.user = null;
            this.f253778doc = null;
            return this;
        }

        public Builder doc(TodoDoc r100) {
            this.f253778doc = r100;
            this.user = null;
            this.chat = null;
            return this;
        }

        public Builder type(TodoItemMemberType r100) {
            this.type = r100;
            return this;
        }

        public Builder user(TodoUser r100) {
            this.user = r100;
            this.chat = null;
            this.f253778doc = null;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskItemMember extends ProtoAdapter<TaskItemMember> {
        public ProtoAdapter_TaskItemMember() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskItemMember.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskItemMember decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = TodoItemMemberType.Unknown;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            if (r103 != 1) goto L7;
            r101.type = TodoItemMemberType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            switch(r103) {
                case 100: goto L11;
                case 101: goto L10;
                case 102: goto L9;
                default: goto L8;
            };
        L9:
            r101.doc(TodoDoc.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.chat(TodoChat.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.user(TodoUser.ADAPTER.decode(r100));
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskItemMember r100) {
            TodoItemMemberType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TodoItemMemberType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoUser r104 = r100.user;
            if (r104 == null) goto L9;
            int r105 = TodoUser.ADAPTER.encodedSizeWithTag(100, r104);
        L10:
            int r106 = r103 + r105;
            TodoChat r107 = r100.chat;
            if (r107 == null) goto L13;
            int r108 = TodoChat.ADAPTER.encodedSizeWithTag(101, r107);
        L14:
            int r109 = r106 + r108;
            TodoDoc r110 = r100.f253777doc;
            if (r110 == null) goto L18;
            r102 = TodoDoc.ADAPTER.encodedSizeWithTag(102, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TaskItemMember decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskItemMember r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskItemMember r101) throws IOException {
            TodoItemMemberType r102 = r101.type;
            if (r102 == null) goto L5;
            TodoItemMemberType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoUser r103 = r101.user;
            if (r103 == null) goto L8;
            TodoUser.ADAPTER.encodeWithTag(r100, 100, r103);
        L8:
            TodoChat r104 = r101.chat;
            if (r104 == null) goto L11;
            TodoChat.ADAPTER.encodeWithTag(r100, 101, r104);
        L11:
            TodoDoc r105 = r101.f253777doc;
            if (r105 == null) goto L14;
            TodoDoc.ADAPTER.encodeWithTag(r100, 102, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskItemMember r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskItemMember();
        DEFAULT_TYPE = TodoItemMemberType.Unknown;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.user = this.user;
        r100.chat = this.chat;
        r100.f253778doc = this.f253777doc;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskItemMember.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskItemMember(TodoItemMemberType r100, TodoUser r101, TodoChat r102, TodoDoc r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TaskItemMember(TodoItemMemberType r100, TodoUser r101, TodoChat r102, TodoDoc r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r101, r102, r103) > 1) goto L7;
        this.type = r100;
        this.user = r101;
        this.chat = r102;
        this.f253777doc = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of user, chat, doc may be non-null");
    }
}
