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

/* JADX INFO: loaded from: classes20.dex */
public final class CreateCommentInfo extends Message<CreateCommentInfo, Builder> {
    public static final ProtoAdapter<CreateCommentInfo> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final String DEFAULT_REPLY_PARENT_ID = "";
    public static final String DEFAULT_REPLY_ROOT_ID = "";
    public static final TodoComment.Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final List<TodoAttachment> attachments;
    public final String cid;
    public final RichContent content;
    public final List<TodoAttachment> file_attachments;
    public final String reply_parent_id;
    public final String reply_root_id;
    public final TodoComment.Type type;

    public static final class Builder extends Message.Builder<CreateCommentInfo, Builder> {
        public List<TodoAttachment> attachments;
        public String cid;
        public RichContent content;
        public List<TodoAttachment> file_attachments;
        public String reply_parent_id;
        public String reply_root_id;
        public TodoComment.Type type;

        @Override // com.squareup.wire.Message.Builder
        public CreateCommentInfo build() {
            return new CreateCommentInfo(this.content, this.reply_parent_id, this.reply_root_id, this.cid, this.attachments, this.type, this.file_attachments, super.buildUnknownFields());
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

        public Builder type(TodoComment.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateCommentInfo extends ProtoAdapter<CreateCommentInfo> {
        public ProtoAdapter_CreateCommentInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateCommentInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateCommentInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.reply_parent_id = "";
            r101.reply_root_id = "";
            r101.cid = "";
            r101.type = TodoComment.Type.UNKNOWN_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L19;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
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
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateCommentInfo r100) {
            RichContent r101 = r100.content;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RichContent.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.reply_parent_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.reply_root_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.cid;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ProtoAdapter<TodoAttachment> r113 = TodoAttachment.ADAPTER;
            int r114 = r112 + r113.asRepeated().encodedSizeWithTag(5, r100.attachments);
            TodoComment.Type r115 = r100.type;
            if (r115 == null) goto L22;
            r102 = TodoComment.Type.ADAPTER.encodedSizeWithTag(6, r115);
        L22:
            return ((r114 + r102) + r113.asRepeated().encodedSizeWithTag(7, r100.file_attachments)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CreateCommentInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateCommentInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateCommentInfo r101) throws IOException {
            RichContent r102 = r101.content;
            if (r102 == null) goto L5;
            RichContent.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.reply_parent_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.reply_root_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.cid;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            ProtoAdapter<TodoAttachment> r106 = TodoAttachment.ADAPTER;
            r106.asRepeated().encodeWithTag(r100, 5, r101.attachments);
            TodoComment.Type r107 = r101.type;
            if (r107 == null) goto L17;
            TodoComment.Type.ADAPTER.encodeWithTag(r100, 6, r107);
        L17:
            r106.asRepeated().encodeWithTag(r100, 7, r101.file_attachments);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateCommentInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CreateCommentInfo();
        DEFAULT_TYPE = TodoComment.Type.UNKNOWN_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
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
        return CreateCommentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateCommentInfo(RichContent r110, String r111, String r112, String r113, List<TodoAttachment> r114, TodoComment.Type r115, List<TodoAttachment> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public CreateCommentInfo(RichContent r100, String r101, String r102, String r103, List<TodoAttachment> r104, TodoComment.Type r105, List<TodoAttachment> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.content = r100;
        this.reply_parent_id = r101;
        this.reply_root_id = r102;
        this.cid = r103;
        this.attachments = Internal.immutableCopyOf("attachments", r104);
        this.type = r105;
        this.file_attachments = Internal.immutableCopyOf("file_attachments", r106);
    }
}
