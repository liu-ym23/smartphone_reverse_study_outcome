package com.bytedance.lark.pb.todo.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoListView extends Message<TodoListView, Builder> {
    public static final ProtoAdapter<TodoListView> ADAPTER = null;
    public static final Integer DEFAULT_ONGOING_CHILD_COUNT = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Integer ongoing_child_count;
    public final Type type;

    public static final class Builder extends Message.Builder<TodoListView, Builder> {
        public Integer ongoing_child_count;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public TodoListView build() {
            return new TodoListView(this.type, this.ongoing_child_count, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ongoing_child_count(Integer r100) {
            this.ongoing_child_count = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoListView extends ProtoAdapter<TodoListView> {
        public ProtoAdapter_TodoListView() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoListView.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoListView decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            r101.ongoing_child_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.ongoing_child_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(TodoListView r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.ongoing_child_count;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TodoListView decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoListView r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoListView r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.ongoing_child_count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoListView r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ALL = null;
        public static final Type ASSIGN_FROM_ME = null;
        public static final Type ASSIGN_TO_ME = null;
        public static final Type COMPLETED = null;
        public static final Type DELETED = null;
        public static final Type FOLLOWED = null;
        public static final Type FROM_DOC = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type(AccountType.ALL, 1, 1);
            ALL = r101;
            Type r102 = new Type("ASSIGN_FROM_ME", 2, 2);
            ASSIGN_FROM_ME = r102;
            Type r103 = new Type("ASSIGN_TO_ME", 3, 3);
            ASSIGN_TO_ME = r103;
            Type r104 = new Type("COMPLETED", 4, 4);
            COMPLETED = r104;
            Type r105 = new Type("DELETED", 5, 5);
            DELETED = r105;
            Type r110 = new Type("FOLLOWED", 6, 6);
            FOLLOWED = r110;
            Type r111 = new Type("FROM_DOC", 7, 7);
            FROM_DOC = r111;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return FROM_DOC;
        L8:
            return FOLLOWED;
        L10:
            return DELETED;
        L12:
            return COMPLETED;
        L14:
            return ASSIGN_TO_ME;
        L16:
            return ASSIGN_FROM_ME;
        L18:
            return ALL;
        L20:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoListView();
        DEFAULT_TYPE = Type.UNKNOWN;
        DEFAULT_ONGOING_CHILD_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.ongoing_child_count = this.ongoing_child_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoListView.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoListView(Type r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TodoListView(Type r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.ongoing_child_count = r101;
    }
}
