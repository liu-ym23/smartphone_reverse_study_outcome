package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.RichContent;
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
public final class CreateCommentRequest extends Message<CreateCommentRequest, Builder> {
    public static final ProtoAdapter<CreateCommentRequest> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final String DEFAULT_REPLY_PARENT_ID = "";
    public static final String DEFAULT_REPLY_ROOT_ID = "";
    public static final String DEFAULT_TODO_GUID = "";
    public static final TodoComment.Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_CreateCommentRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TodoAttachment> attachments;
    public final String cid;
    public final RichContent content;
    public final List<TodoAttachment> file_attachments;
    public final String reply_parent_id;
    public final String reply_root_id;
    public final String todo_guid;
    public final TodoComment.Type type;

    public static final class Builder extends Message.Builder<CreateCommentRequest, Builder> implements d<CreateCommentRequest> {
        public List<TodoAttachment> attachments;
        public String cid;
        public RichContent content;
        public List<TodoAttachment> file_attachments;
        public String reply_parent_id;
        public String reply_root_id;
        public String todo_guid;
        public TodoComment.Type type;

        @Override // com.squareup.wire.Message.Builder
        public CreateCommentRequest build() {
            return new CreateCommentRequest(this.todo_guid, this.content, this.reply_parent_id, this.reply_root_id, this.cid, this.attachments, this.type, this.file_attachments, super.buildUnknownFields());
        }

        public Builder() {
            this.attachments = Internal.newMutableList();
            this.file_attachments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder attachments(List<TodoAttachment> r100) {
            Internal.checkElementsNotNull(r100);
            this.attachments = r100;
            return this;
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder content(RichContent r100) {
            this.content = r100;
            return this;
        }

        public Builder file_attachments(List<TodoAttachment> r100) {
            Internal.checkElementsNotNull(r100);
            this.file_attachments = r100;
            return this;
        }

        public Builder reply_parent_id(String r100) {
            this.reply_parent_id = r100;
            return this;
        }

        public Builder reply_root_id(String r100) {
            this.reply_root_id = r100;
            return this;
        }

        public Builder todo_guid(String r100) {
            this.todo_guid = r100;
            return this;
        }

        public Builder type(TodoComment.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateCommentRequest extends ProtoAdapter<CreateCommentRequest> implements c<CreateCommentRequest> {
        public ProtoAdapter_CreateCommentRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateCommentRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateCommentRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.todo_guid = "";
            r101.reply_parent_id = "";
            r101.reply_root_id = "";
            r101.cid = "";
            r101.type = TodoComment.Type.UNKNOWN_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L20;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.type = TodoComment.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.file_attachments.add(TodoAttachment.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.attachments.add(TodoAttachment.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.reply_root_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.reply_parent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.content = RichContent.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.todo_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateCommentRequest r100) {
            String r101 = r100.todo_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            RichContent r104 = r100.content;
            if (r104 == null) goto L9;
            int r105 = RichContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.reply_parent_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.reply_root_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.cid;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ProtoAdapter<TodoAttachment> r116 = TodoAttachment.ADAPTER;
            int r117 = r115 + r116.asRepeated().encodedSizeWithTag(6, r100.attachments);
            TodoComment.Type r118 = r100.type;
            if (r118 == null) goto L26;
            r102 = TodoComment.Type.ADAPTER.encodedSizeWithTag(7, r118);
        L26:
            return ((r117 + r102) + r116.asRepeated().encodedSizeWithTag(8, r100.file_attachments)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CreateCommentRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateCommentRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateCommentRequest r101) throws IOException {
            String r102 = r101.todo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            RichContent r103 = r101.content;
            if (r103 == null) goto L8;
            RichContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.reply_parent_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.reply_root_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.cid;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            ProtoAdapter<TodoAttachment> r107 = TodoAttachment.ADAPTER;
            r107.asRepeated().encodeWithTag(r100, 6, r101.attachments);
            TodoComment.Type r108 = r101.type;
            if (r108 == null) goto L20;
            TodoComment.Type.ADAPTER.encodeWithTag(r100, 7, r108);
        L20:
            r107.asRepeated().encodeWithTag(r100, 8, r101.file_attachments);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateCommentRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CreateCommentRequest r100 = new ProtoAdapter_CreateCommentRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = TodoComment.Type.UNKNOWN_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guid = this.todo_guid;
        r100.content = this.content;
        r100.reply_parent_id = this.reply_parent_id;
        r100.reply_root_id = this.reply_root_id;
        r100.cid = this.cid;
        r100.attachments = Internal.copyOf("attachments", this.attachments);
        r100.type = this.type;
        r100.file_attachments = Internal.copyOf("file_attachments", this.file_attachments);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateCommentRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateCommentRequest(String r110, RichContent r111, String r112, String r113, String r114, List<TodoAttachment> r115, TodoComment.Type r116, List<TodoAttachment> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public CreateCommentRequest(String r100, RichContent r101, String r102, String r103, String r104, List<TodoAttachment> r105, TodoComment.Type r106, List<TodoAttachment> r107, ByteString r110) {
        super(ADAPTER, r110);
        this.todo_guid = r100;
        this.content = r101;
        this.reply_parent_id = r102;
        this.reply_root_id = r103;
        this.cid = r104;
        this.attachments = Internal.immutableCopyOf("attachments", r105);
        this.type = r106;
        this.file_attachments = Internal.immutableCopyOf("file_attachments", r107);
    }
}
