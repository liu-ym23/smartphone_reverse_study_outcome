package com.bytedance.lark.pb.todo.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoAssignee extends Message<TodoAssignee, Builder> {
    public static final ProtoAdapter<TodoAssignee> ADAPTER = null;
    public static final String DEFAULT_ASSIGNEE_ID = "";
    public static final String DEFAULT_ASSIGNER_ID = "";
    public static final Long DEFAULT_SORT_POSITION = null;
    public static final TodoItemMemberType DEFAULT_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_USER = null;
    private static final long serialVersionUID = 0;
    public final String assignee_id;
    public final TodoUser assigner;
    public final String assigner_id;
    public final Long sort_position;
    public final TodoItemMemberType type;
    public final User user;

    public static final class Builder extends Message.Builder<TodoAssignee, Builder> {
        public String assignee_id;
        public TodoUser assigner;
        public String assigner_id;
        public Long sort_position;
        public TodoItemMemberType type;
        public User user;

        @Override // com.squareup.wire.Message.Builder
        public TodoAssignee build() {
            return new TodoAssignee(this.assignee_id, this.type, this.assigner_id, this.sort_position, this.assigner, this.user, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder assignee_id(String r100) {
            this.assignee_id = r100;
            return this;
        }

        public Builder assigner(TodoUser r100) {
            this.assigner = r100;
            return this;
        }

        public Builder assigner_id(String r100) {
            this.assigner_id = r100;
            return this;
        }

        public Builder sort_position(Long r100) {
            this.sort_position = r100;
            return this;
        }

        public Builder type(TodoItemMemberType r100) {
            this.type = r100;
            return this;
        }

        public Builder user(User r100) {
            this.user = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoAssignee extends ProtoAdapter<TodoAssignee> {
        public ProtoAdapter_TodoAssignee() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoAssignee.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoAssignee decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.assignee_id = "";
            r101.type = TodoItemMemberType.Unknown;
            r101.assigner_id = "";
            r101.sort_position = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.assignee_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = TodoItemMemberType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.assigner_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.sort_position = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.assigner = TodoUser.ADAPTER.decode(r100);
            goto L3
        L16:
            if (r103 != 100) goto L17;
            r101.user(User.ADAPTER.decode(r100));
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoAssignee r100) {
            String r101 = r100.assignee_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            TodoItemMemberType r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = TodoItemMemberType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.assigner_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.sort_position;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            TodoUser r113 = r100.assigner;
            if (r113 == null) goto L21;
            int r114 = TodoUser.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            User r116 = r100.user;
            if (r116 == null) goto L26;
            r102 = User.ADAPTER.encodedSizeWithTag(100, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ TodoAssignee decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoAssignee r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoAssignee r101) throws IOException {
            String r102 = r101.assignee_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TodoItemMemberType r103 = r101.type;
            if (r103 == null) goto L8;
            TodoItemMemberType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.assigner_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.sort_position;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            TodoUser r106 = r101.assigner;
            if (r106 == null) goto L17;
            TodoUser.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            User r107 = r101.user;
            if (r107 == null) goto L20;
            User.ADAPTER.encodeWithTag(r100, 100, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoAssignee r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class User extends Message<User, Builder> {
        public static final ProtoAdapter<User> ADAPTER = null;
        public static final Long DEFAULT_COMPLETED_MILLI_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long completed_milli_time;
        public final TodoUser user;

        public static final class Builder extends Message.Builder<User, Builder> {
            public Long completed_milli_time;
            public TodoUser user;

            @Override // com.squareup.wire.Message.Builder
            public User build() {
                return new User(this.user, this.completed_milli_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder completed_milli_time(Long r100) {
                this.completed_milli_time = r100;
                return this;
            }

            public Builder user(TodoUser r100) {
                this.user = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_User extends ProtoAdapter<User> {
            public ProtoAdapter_User() {
                super(FieldEncoding.LENGTH_DELIMITED, User.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public User decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.completed_milli_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.user = TodoUser.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.completed_milli_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(User r100) {
                TodoUser r101 = r100.user;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TodoUser.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.completed_milli_time;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ User decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(User r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, User r101) throws IOException {
                TodoUser r102 = r101.user;
                if (r102 == null) goto L5;
                TodoUser.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.completed_milli_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, User r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_User();
            DEFAULT_COMPLETED_MILLI_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user = this.user;
            r100.completed_milli_time = this.completed_milli_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return User.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public User(TodoUser r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public User(TodoUser r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.user = r100;
            this.completed_milli_time = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoAssignee();
        FIELD_OPTIONS_USER = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_TYPE = TodoItemMemberType.Unknown;
        DEFAULT_SORT_POSITION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.assignee_id = this.assignee_id;
        r100.type = this.type;
        r100.assigner_id = this.assigner_id;
        r100.sort_position = this.sort_position;
        r100.assigner = this.assigner;
        r100.user = this.user;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoAssignee.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoAssignee(String r100, TodoItemMemberType r110, String r111, Long r112, TodoUser r113, User r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public TodoAssignee(String r100, TodoItemMemberType r101, String r102, Long r103, TodoUser r104, User r105, ByteString r106) {
        super(ADAPTER, r106);
        this.assignee_id = r100;
        this.type = r101;
        this.assigner_id = r102;
        this.sort_position = r103;
        this.assigner = r104;
        this.user = r105;
    }
}
