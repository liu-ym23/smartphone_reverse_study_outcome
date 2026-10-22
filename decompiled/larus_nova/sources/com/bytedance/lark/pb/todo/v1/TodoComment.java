package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.RichContent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TodoComment extends Message<TodoComment, Builder> {
    public static final ProtoAdapter<TodoComment> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_CREATE_MILLI_TIME = null;
    public static final FromType DEFAULT_FROM_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final String DEFAULT_REPLY_PARENT_ID = "";
    public static final String DEFAULT_REPLY_ROOT_ID = "";
    public static final Status DEFAULT_STATUS = null;
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_MILLI_TIME = null;
    private static final long serialVersionUID = 0;
    public final List<TodoAttachment> attachments;
    public final String cid;
    public final Long create_milli_time;
    public final List<TodoAttachment> file_attachments;
    public final FromType from_type;
    public final TodoUser from_user;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253779id;
    public final Integer position;
    public final List<TodoCommentReaction> reactions;
    public final String reply_parent_id;
    public final String reply_root_id;
    public final RichContent rich_content;
    public final Status status;
    public final Type type;
    public final Long update_milli_time;

    public static final class Builder extends Message.Builder<TodoComment, Builder> {
        public List<TodoAttachment> attachments;
        public String cid;
        public Long create_milli_time;
        public List<TodoAttachment> file_attachments;
        public FromType from_type;
        public TodoUser from_user;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253780id;
        public Integer position;
        public List<TodoCommentReaction> reactions;
        public String reply_parent_id;
        public String reply_root_id;
        public RichContent rich_content;
        public Status status;
        public Type type;
        public Long update_milli_time;

        @Override // com.squareup.wire.Message.Builder
        public TodoComment build() {
            return new TodoComment(this.f253780id, this.rich_content, this.from_type, this.from_user, this.status, this.create_milli_time, this.update_milli_time, this.reply_parent_id, this.reply_root_id, this.position, this.cid, this.type, this.attachments, this.reactions, this.file_attachments, super.buildUnknownFields());
        }

        public Builder() {
            this.attachments = Internal.newMutableList();
            this.reactions = Internal.newMutableList();
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

        public Builder create_milli_time(Long r100) {
            this.create_milli_time = r100;
            return this;
        }

        public Builder file_attachments(List<TodoAttachment> r100) {
            Internal.checkElementsNotNull(r100);
            this.file_attachments = r100;
            return this;
        }

        public Builder from_type(FromType r100) {
            this.from_type = r100;
            return this;
        }

        public Builder from_user(TodoUser r100) {
            this.from_user = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253780id = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder reactions(List<TodoCommentReaction> r100) {
            Internal.checkElementsNotNull(r100);
            this.reactions = r100;
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

        public Builder rich_content(RichContent r100) {
            this.rich_content = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder update_milli_time(Long r100) {
            this.update_milli_time = r100;
            return this;
        }
    }

    public static final enum FromType extends Enum<FromType> implements WireEnum {
        private static final /* synthetic */ FromType[] $VALUES = null;
        public static final ProtoAdapter<FromType> ADAPTER = null;
        public static final FromType UNKNOWN_FROM_TYPE = null;
        public static final FromType USER = null;
        private final int value;

        static {
            FromType r100 = new FromType("UNKNOWN_FROM_TYPE", 0, 0);
            UNKNOWN_FROM_TYPE = r100;
            FromType r101 = new FromType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            $VALUES = new FromType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(FromType.class);
        }

        public static FromType[] values() {
            return (FromType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static FromType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return USER;
        L10:
            return UNKNOWN_FROM_TYPE;
        }

        public static FromType valueOf(String r100) {
            return (FromType) a.a(FromType.class, r100);
        }

        private FromType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_TodoComment extends ProtoAdapter<TodoComment> {
        public ProtoAdapter_TodoComment() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoComment.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TodoComment decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253780id = "";
            r101.from_type = FromType.UNKNOWN_FROM_TYPE;
            r101.status = Status.UNKNOWN_STATUS;
            r101.create_milli_time = 0L;
            r101.update_milli_time = 0L;
            r101.reply_parent_id = "";
            r101.reply_root_id = "";
            r101.position = 0;
            r101.cid = "";
            r101.type = Type.UNKNOWN_TYPE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L31;
            switch(r103) {
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L37;
                case 4: goto L24;
                case 5: goto L35;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L33;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L33:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L35:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L37:
            r101.from_type = FromType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.file_attachments.add(TodoAttachment.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.reactions.add(TodoCommentReaction.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.attachments.add(TodoAttachment.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.reply_root_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.reply_parent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.update_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.create_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L24:
            r101.from_user = TodoUser.ADAPTER.decode(r100);
            goto L3
        L29:
            r101.rich_content = RichContent.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.f253780id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L31:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TodoComment r100) {
            String r101 = r100.f253779id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            RichContent r104 = r100.rich_content;
            if (r104 == null) goto L9;
            int r105 = RichContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            FromType r107 = r100.from_type;
            if (r107 == null) goto L13;
            int r108 = FromType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            TodoUser r110 = r100.from_user;
            if (r110 == null) goto L17;
            int r111 = TodoUser.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Status r113 = r100.status;
            if (r113 == null) goto L21;
            int r114 = Status.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Long r116 = r100.create_milli_time;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT64.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.update_milli_time;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.reply_parent_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            String r125 = r100.reply_root_id;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.STRING.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Integer r128 = r100.position;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.INT32.encodedSizeWithTag(10, r128);
        L42:
            int r130 = r127 + r129;
            String r131 = r100.cid;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.STRING.encodedSizeWithTag(11, r131);
        L46:
            int r133 = r130 + r132;
            Type r134 = r100.type;
            if (r134 == null) goto L49;
            r102 = Type.ADAPTER.encodedSizeWithTag(12, r134);
        L49:
            int r135 = r133 + r102;
            ProtoAdapter<TodoAttachment> r136 = TodoAttachment.ADAPTER;
            return (((r135 + r136.asRepeated().encodedSizeWithTag(13, r100.attachments)) + TodoCommentReaction.ADAPTER.asRepeated().encodedSizeWithTag(14, r100.reactions)) + r136.asRepeated().encodedSizeWithTag(15, r100.file_attachments)) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ TodoComment decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TodoComment r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TodoComment r101) throws IOException {
            String r102 = r101.f253779id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            RichContent r103 = r101.rich_content;
            if (r103 == null) goto L8;
            RichContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            FromType r104 = r101.from_type;
            if (r104 == null) goto L11;
            FromType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            TodoUser r105 = r101.from_user;
            if (r105 == null) goto L14;
            TodoUser.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Status r106 = r101.status;
            if (r106 == null) goto L17;
            Status.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Long r107 = r101.create_milli_time;
            if (r107 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r107);
        L20:
            Long r108 = r101.update_milli_time;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.reply_parent_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            String r110 = r101.reply_root_id;
            if (r110 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r110);
        L29:
            Integer r111 = r101.position;
            if (r111 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r111);
        L32:
            String r112 = r101.cid;
            if (r112 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r100, 11, r112);
        L35:
            Type r113 = r101.type;
            if (r113 == null) goto L38;
            Type.ADAPTER.encodeWithTag(r100, 12, r113);
        L38:
            ProtoAdapter<TodoAttachment> r114 = TodoAttachment.ADAPTER;
            r114.asRepeated().encodeWithTag(r100, 13, r101.attachments);
            TodoCommentReaction.ADAPTER.asRepeated().encodeWithTag(r100, 14, r101.reactions);
            r114.asRepeated().encodeWithTag(r100, 15, r101.file_attachments);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TodoComment r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DELETED = null;
        public static final Status EDITED = null;
        public static final Status NORMAL = null;
        public static final Status UNKNOWN_STATUS = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r100;
            Status r101 = new Status(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            Status r102 = new Status("EDITED", 2, 2);
            EDITED = r102;
            Status r103 = new Status("DELETED", 3, 3);
            DELETED = r103;
            $VALUES = new Status[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return DELETED;
        L14:
            return EDITED;
        L16:
            return NORMAL;
        L18:
            return UNKNOWN_STATUS;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type RICH_TEXT = null;
        public static final Type UNKNOWN_TYPE = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type("RICH_TEXT", 1, 1);
            RICH_TEXT = r101;
            $VALUES = new Type[]{r100, r101};
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
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return RICH_TEXT;
        L10:
            return UNKNOWN_TYPE;
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
        ADAPTER = new ProtoAdapter_TodoComment();
        DEFAULT_FROM_TYPE = FromType.UNKNOWN_FROM_TYPE;
        DEFAULT_STATUS = Status.UNKNOWN_STATUS;
        DEFAULT_CREATE_MILLI_TIME = 0L;
        DEFAULT_UPDATE_MILLI_TIME = 0L;
        DEFAULT_POSITION = 0;
        DEFAULT_TYPE = Type.UNKNOWN_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253780id = this.f253779id;
        r100.rich_content = this.rich_content;
        r100.from_type = this.from_type;
        r100.from_user = this.from_user;
        r100.status = this.status;
        r100.create_milli_time = this.create_milli_time;
        r100.update_milli_time = this.update_milli_time;
        r100.reply_parent_id = this.reply_parent_id;
        r100.reply_root_id = this.reply_root_id;
        r100.position = this.position;
        r100.cid = this.cid;
        r100.type = this.type;
        r100.attachments = Internal.copyOf("attachments", this.attachments);
        r100.reactions = Internal.copyOf("reactions", this.reactions);
        r100.file_attachments = Internal.copyOf("file_attachments", this.file_attachments);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TodoComment.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TodoComment(String r110, RichContent r111, FromType r210, TodoUser r211, Status r212, Long r213, Long r214, String r215, String r216, Integer r217, String r218, Type r219, List<TodoAttachment> r310, List<TodoCommentReaction> r311, List<TodoAttachment> r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public TodoComment(String r100, RichContent r101, FromType r102, TodoUser r103, Status r104, Long r105, Long r110, String r111, String r112, Integer r113, String r114, Type r115, List<TodoAttachment> r116, List<TodoCommentReaction> r117, List<TodoAttachment> r118, ByteString r119) {
        super(ADAPTER, r119);
        this.f253779id = r100;
        this.rich_content = r101;
        this.from_type = r102;
        this.from_user = r103;
        this.status = r104;
        this.create_milli_time = r105;
        this.update_milli_time = r110;
        this.reply_parent_id = r111;
        this.reply_root_id = r112;
        this.position = r113;
        this.cid = r114;
        this.type = r115;
        this.attachments = Internal.immutableCopyOf("attachments", r116);
        this.reactions = Internal.immutableCopyOf("reactions", r117);
        this.file_attachments = Internal.immutableCopyOf("file_attachments", r118);
    }
}
