package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoExtraInfo extends Message<TodoExtraInfo, Builder> {
    public static final ProtoAdapter<TodoExtraInfo> ADAPTER = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final AncestorChange ancestor_change;
    public final TodoCommentCount comment_count;
    public final ProgressChange progress_change;
    public final SubTaskRanksChange sub_task_ranks_change;
    public final Type type;

    public static final class Builder extends Message.Builder<TodoExtraInfo, Builder> {
        public AncestorChange ancestor_change;
        public TodoCommentCount comment_count;
        public ProgressChange progress_change;
        public SubTaskRanksChange sub_task_ranks_change;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public TodoExtraInfo build() {
            return new TodoExtraInfo(this.type, this.comment_count, this.progress_change, this.ancestor_change, this.sub_task_ranks_change, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ancestor_change(AncestorChange r100) {
            this.ancestor_change = r100;
            this.comment_count = null;
            this.progress_change = null;
            this.sub_task_ranks_change = null;
            return this;
        }

        public Builder comment_count(TodoCommentCount r100) {
            this.comment_count = r100;
            this.progress_change = null;
            this.ancestor_change = null;
            this.sub_task_ranks_change = null;
            return this;
        }

        public Builder progress_change(ProgressChange r100) {
            this.progress_change = r100;
            this.comment_count = null;
            this.ancestor_change = null;
            this.sub_task_ranks_change = null;
            return this;
        }

        public Builder sub_task_ranks_change(SubTaskRanksChange r100) {
            this.sub_task_ranks_change = r100;
            this.comment_count = null;
            this.progress_change = null;
            this.ancestor_change = null;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoExtraInfo extends ProtoAdapter<TodoExtraInfo> {
        public ProtoAdapter_TodoExtraInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoExtraInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoExtraInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            if (r103 != 1) goto L7;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            switch(r103) {
                case 101: goto L12;
                case 102: goto L11;
                case 103: goto L10;
                case 104: goto L9;
                default: goto L8;
            };
        L9:
            r101.sub_task_ranks_change(SubTaskRanksChange.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.ancestor_change(AncestorChange.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.progress_change(ProgressChange.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.comment_count(TodoCommentCount.ADAPTER.decode(r100));
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoExtraInfo r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TodoCommentCount r104 = r100.comment_count;
            if (r104 == null) goto L9;
            int r105 = TodoCommentCount.ADAPTER.encodedSizeWithTag(101, r104);
        L10:
            int r106 = r103 + r105;
            ProgressChange r107 = r100.progress_change;
            if (r107 == null) goto L13;
            int r108 = ProgressChange.ADAPTER.encodedSizeWithTag(102, r107);
        L14:
            int r109 = r106 + r108;
            AncestorChange r110 = r100.ancestor_change;
            if (r110 == null) goto L17;
            int r111 = AncestorChange.ADAPTER.encodedSizeWithTag(103, r110);
        L18:
            int r112 = r109 + r111;
            SubTaskRanksChange r113 = r100.sub_task_ranks_change;
            if (r113 == null) goto L22;
            r102 = SubTaskRanksChange.ADAPTER.encodedSizeWithTag(104, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TodoExtraInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoExtraInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoExtraInfo r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TodoCommentCount r103 = r101.comment_count;
            if (r103 == null) goto L8;
            TodoCommentCount.ADAPTER.encodeWithTag(r100, 101, r103);
        L8:
            ProgressChange r104 = r101.progress_change;
            if (r104 == null) goto L11;
            ProgressChange.ADAPTER.encodeWithTag(r100, 102, r104);
        L11:
            AncestorChange r105 = r101.ancestor_change;
            if (r105 == null) goto L14;
            AncestorChange.ADAPTER.encodeWithTag(r100, 103, r105);
        L14:
            SubTaskRanksChange r106 = r101.sub_task_ranks_change;
            if (r106 == null) goto L17;
            SubTaskRanksChange.ADAPTER.encodeWithTag(r100, 104, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoExtraInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ANCESTOR_CHANGE = null;
        public static final Type COMMENT_COUNT = null;
        public static final Type PROGRESS = null;
        public static final Type SUB_TASK_RANKS = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("COMMENT_COUNT", 1, 1);
            COMMENT_COUNT = r101;
            Type r102 = new Type("PROGRESS", 2, 2);
            PROGRESS = r102;
            Type r103 = new Type("ANCESTOR_CHANGE", 3, 3);
            ANCESTOR_CHANGE = r103;
            Type r104 = new Type("SUB_TASK_RANKS", 4, 4);
            SUB_TASK_RANKS = r104;
            $VALUES = new Type[]{r100, r101, r102, r103, r104};
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
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return SUB_TASK_RANKS;
        L16:
            return ANCESTOR_CHANGE;
        L18:
            return PROGRESS;
        L20:
            return COMMENT_COUNT;
        L22:
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
        ADAPTER = new ProtoAdapter_TodoExtraInfo();
        DEFAULT_TYPE = Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.comment_count = this.comment_count;
        r100.progress_change = this.progress_change;
        r100.ancestor_change = this.ancestor_change;
        r100.sub_task_ranks_change = this.sub_task_ranks_change;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoExtraInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoExtraInfo(Type r100, TodoCommentCount r101, ProgressChange r110, AncestorChange r111, SubTaskRanksChange r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TodoExtraInfo(Type r100, TodoCommentCount r101, ProgressChange r102, AncestorChange r103, SubTaskRanksChange r104, ByteString r105) {
        super(ADAPTER, r105);
        if (Internal.countNonNull(r101, r102, r103, r104, new Object[0]) > 1) goto L7;
        this.type = r100;
        this.comment_count = r101;
        this.progress_change = r102;
        this.ancestor_change = r103;
        this.sub_task_ranks_change = r104;
        return;
    L7:
        throw new IllegalArgumentException("at most one of comment_count, progress_change, ancestor_change, sub_task_ranks_change may be non-null");
    }
}
