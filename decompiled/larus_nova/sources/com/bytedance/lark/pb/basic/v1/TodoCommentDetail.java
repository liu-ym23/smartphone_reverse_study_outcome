package com.bytedance.lark.pb.basic.v1;

import com.bytedance.lark.pb.todo.v1.TodoCommentReaction;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoCommentDetail extends com.squareup.wire.Message<TodoCommentDetail, Builder> {
    public static final ProtoAdapter<TodoCommentDetail> ADAPTER = null;
    public static final String DEFAULT_COMMENT_ID = "";
    public static final TodoCommentType DEFAULT_COMMENT_TYPE = null;
    public static final Integer DEFAULT_POSITION = null;
    private static final long serialVersionUID = 0;
    public final List<TodoAttachmentInfo> attachments;
    public final String comment_id;
    public final TodoCommentType comment_type;
    public final TodoCommentReaction newly_added_reaction;
    public final Integer position;
    public final RichContent rich_content;

    public static final class Builder extends com.squareup.wire.Message.Builder<TodoCommentDetail, Builder> {
        public List<TodoAttachmentInfo> attachments;
        public String comment_id;
        public TodoCommentType comment_type;
        public TodoCommentReaction newly_added_reaction;
        public Integer position;
        public RichContent rich_content;

        @Override // com.squareup.wire.Message.Builder
        public TodoCommentDetail build() {
            return new TodoCommentDetail(this.comment_id, this.comment_type, this.rich_content, this.position, this.attachments, this.newly_added_reaction, super.buildUnknownFields());
        }

        public Builder() {
            this.attachments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder attachments(List<TodoAttachmentInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.attachments = r100;
            return this;
        }

        public Builder comment_id(String r100) {
            this.comment_id = r100;
            return this;
        }

        public Builder comment_type(TodoCommentType r100) {
            this.comment_type = r100;
            return this;
        }

        public Builder newly_added_reaction(TodoCommentReaction r100) {
            this.newly_added_reaction = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder rich_content(RichContent r100) {
            this.rich_content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoCommentDetail extends ProtoAdapter<TodoCommentDetail> {
        public ProtoAdapter_TodoCommentDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoCommentDetail.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoCommentDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.comment_id = "";
            r101.comment_type = TodoCommentType.UNKNOWN_TYPE;
            r101.position = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L18;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.comment_type = TodoCommentType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.newly_added_reaction = TodoCommentReaction.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.attachments.add(TodoAttachmentInfo.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.rich_content = RichContent.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.comment_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoCommentDetail r100) {
            String r101 = r100.comment_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            TodoCommentType r104 = r100.comment_type;
            if (r104 == null) goto L9;
            int r105 = TodoCommentType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            RichContent r107 = r100.rich_content;
            if (r107 == null) goto L13;
            int r108 = RichContent.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.position;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = (r109 + r111) + TodoAttachmentInfo.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.attachments);
            TodoCommentReaction r113 = r100.newly_added_reaction;
            if (r113 == null) goto L22;
            r102 = TodoCommentReaction.ADAPTER.encodedSizeWithTag(6, r113);
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
        public /* bridge */ /* synthetic */ TodoCommentDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoCommentDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoCommentDetail r101) throws IOException {
            String r102 = r101.comment_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            TodoCommentType r103 = r101.comment_type;
            if (r103 == null) goto L8;
            TodoCommentType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            RichContent r104 = r101.rich_content;
            if (r104 == null) goto L11;
            RichContent.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.position;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            TodoAttachmentInfo.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.attachments);
            TodoCommentReaction r106 = r101.newly_added_reaction;
            if (r106 == null) goto L17;
            TodoCommentReaction.ADAPTER.encodeWithTag(r100, 6, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoCommentDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TodoCommentType extends Enum<TodoCommentType> implements WireEnum {
        private static final /* synthetic */ TodoCommentType[] $VALUES = null;
        public static final ProtoAdapter<TodoCommentType> ADAPTER = null;
        public static final TodoCommentType RICH_TEXT = null;
        public static final TodoCommentType UNKNOWN_TYPE = null;
        private final int value;

        static {
            TodoCommentType r100 = new TodoCommentType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            TodoCommentType r101 = new TodoCommentType("RICH_TEXT", 1, 1);
            RICH_TEXT = r101;
            $VALUES = new TodoCommentType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(TodoCommentType.class);
        }

        public static TodoCommentType[] values() {
            return (TodoCommentType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TodoCommentType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return RICH_TEXT;
        L10:
            return UNKNOWN_TYPE;
        }

        public static TodoCommentType valueOf(String r100) {
            return (TodoCommentType) a.a(TodoCommentType.class, r100);
        }

        private TodoCommentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoCommentDetail();
        DEFAULT_COMMENT_TYPE = TodoCommentType.UNKNOWN_TYPE;
        DEFAULT_POSITION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.comment_id = this.comment_id;
        r100.comment_type = this.comment_type;
        r100.rich_content = this.rich_content;
        r100.position = this.position;
        r100.attachments = Internal.copyOf("attachments", this.attachments);
        r100.newly_added_reaction = this.newly_added_reaction;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoCommentDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoCommentDetail(String r100, TodoCommentType r110, RichContent r111, Integer r112, List<TodoAttachmentInfo> r113, TodoCommentReaction r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public TodoCommentDetail(String r100, TodoCommentType r101, RichContent r102, Integer r103, List<TodoAttachmentInfo> r104, TodoCommentReaction r105, ByteString r106) {
        super(ADAPTER, r106);
        this.comment_id = r100;
        this.comment_type = r101;
        this.rich_content = r102;
        this.position = r103;
        this.attachments = Internal.immutableCopyOf("attachments", r104);
        this.newly_added_reaction = r105;
    }
}
