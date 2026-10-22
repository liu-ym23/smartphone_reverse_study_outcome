package com.bytedance.lark.pb.basic.v1;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Draft extends com.squareup.wire.Message<Draft, Builder> {
    public static final ProtoAdapter<Draft> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_EDIT_MESSAGE_ID = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_THREAD_ID = "";
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final DraftAttachmentSnapshot attachment_snapshot;
    public final String chat_id;
    public final CloudDraftContent cloud_draft_content;
    public final String content;
    public final String edit_message_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253483id;
    public final Map<String, String> local_extra;
    public final String message_id;
    public final Message.PartialReplyInfo partial_reply_info;
    public final ScheduleInfo schedule_info;
    public final String thread_id;
    public final Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<Draft, Builder> {
        public DraftAttachmentSnapshot attachment_snapshot;
        public String chat_id;
        public CloudDraftContent cloud_draft_content;
        public String content;
        public String edit_message_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253484id;
        public Map<String, String> local_extra;
        public String message_id;
        public Message.PartialReplyInfo partial_reply_info;
        public ScheduleInfo schedule_info;
        public String thread_id;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public Draft build() {
            String r100 = this.content;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new Draft(this.f253484id, this.chat_id, this.message_id, this.content, this.type, this.edit_message_id, this.thread_id, this.schedule_info, this.partial_reply_info, this.cloud_draft_content, this.local_extra, this.attachment_snapshot, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "content", this.type, "type"});
        }

        public Builder() {
            this.local_extra = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder attachment_snapshot(DraftAttachmentSnapshot r100) {
            this.attachment_snapshot = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder cloud_draft_content(CloudDraftContent r100) {
            this.cloud_draft_content = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder edit_message_id(String r100) {
            this.edit_message_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253484id = r100;
            return this;
        }

        public Builder local_extra(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.local_extra = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder partial_reply_info(Message.PartialReplyInfo r100) {
            this.partial_reply_info = r100;
            return this;
        }

        public Builder schedule_info(ScheduleInfo r100) {
            this.schedule_info = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Draft extends ProtoAdapter<Draft> {
        private final ProtoAdapter<Map<String, String>> local_extra;

        public ProtoAdapter_Draft() {
            super(FieldEncoding.LENGTH_DELIMITED, Draft.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.local_extra = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Draft decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253484id = "";
            r101.chat_id = "";
            r101.message_id = "";
            r101.content = "";
            r101.type = Type.TEXT;
            r101.edit_message_id = "";
            r101.thread_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L24;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L24:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.attachment_snapshot = DraftAttachmentSnapshot.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.local_extra.putAll(this.local_extra.decode(r100));
            goto L3
        L9:
            r101.cloud_draft_content = CloudDraftContent.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.partial_reply_info = Message.PartialReplyInfo.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.schedule_info = ScheduleInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.edit_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.f253484id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Draft r100) {
            String r101 = r100.f253483id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.chat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.message_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ProtoAdapter<String> r110 = ProtoAdapter.STRING;
            int r111 = (r109 + r110.encodedSizeWithTag(4, r100.content)) + Type.ADAPTER.encodedSizeWithTag(5, r100.type);
            String r112 = r100.edit_message_id;
            if (r112 == null) goto L17;
            int r113 = r110.encodedSizeWithTag(6, r112);
        L18:
            int r114 = r111 + r113;
            String r115 = r100.thread_id;
            if (r115 == null) goto L21;
            int r116 = r110.encodedSizeWithTag(7, r115);
        L22:
            int r117 = r114 + r116;
            ScheduleInfo r118 = r100.schedule_info;
            if (r118 == null) goto L25;
            int r119 = ScheduleInfo.ADAPTER.encodedSizeWithTag(8, r118);
        L26:
            int r120 = r117 + r119;
            Message.PartialReplyInfo r121 = r100.partial_reply_info;
            if (r121 == null) goto L29;
            int r122 = Message.PartialReplyInfo.ADAPTER.encodedSizeWithTag(9, r121);
        L30:
            int r123 = r120 + r122;
            CloudDraftContent r124 = r100.cloud_draft_content;
            if (r124 == null) goto L33;
            int r125 = CloudDraftContent.ADAPTER.encodedSizeWithTag(10, r124);
        L34:
            int r126 = (r123 + r125) + this.local_extra.encodedSizeWithTag(11, r100.local_extra);
            DraftAttachmentSnapshot r127 = r100.attachment_snapshot;
            if (r127 == null) goto L38;
            r102 = DraftAttachmentSnapshot.ADAPTER.encodedSizeWithTag(12, r127);
        L38:
            return (r126 + r102) + r100.unknownFields().size();
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
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
        public /* bridge */ /* synthetic */ Draft decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Draft r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Draft r101) throws IOException {
            String r102 = r101.f253483id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.message_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ProtoAdapter<String> r105 = ProtoAdapter.STRING;
            r105.encodeWithTag(r100, 4, r101.content);
            Type.ADAPTER.encodeWithTag(r100, 5, r101.type);
            String r106 = r101.edit_message_id;
            if (r106 == null) goto L14;
            r105.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.thread_id;
            if (r107 == null) goto L17;
            r105.encodeWithTag(r100, 7, r107);
        L17:
            ScheduleInfo r108 = r101.schedule_info;
            if (r108 == null) goto L20;
            ScheduleInfo.ADAPTER.encodeWithTag(r100, 8, r108);
        L20:
            Message.PartialReplyInfo r109 = r101.partial_reply_info;
            if (r109 == null) goto L23;
            Message.PartialReplyInfo.ADAPTER.encodeWithTag(r100, 9, r109);
        L23:
            CloudDraftContent r110 = r101.cloud_draft_content;
            if (r110 == null) goto L26;
            CloudDraftContent.ADAPTER.encodeWithTag(r100, 10, r110);
        L26:
            this.local_extra.encodeWithTag(r100, 11, r101.local_extra);
            DraftAttachmentSnapshot r111 = r101.attachment_snapshot;
            if (r111 == null) goto L29;
            DraftAttachmentSnapshot.ADAPTER.encodeWithTag(r100, 12, r111);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Draft r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ScheduleInfo extends com.squareup.wire.Message<ScheduleInfo, Builder> {
        public static final ProtoAdapter<ScheduleInfo> ADAPTER = null;
        public static final Long DEFAULT_SCHEDULE_TIME = null;
        private static final long serialVersionUID = 0;
        public final ScheduleMessageItem item;
        public final Long schedule_time;

        public static final class Builder extends com.squareup.wire.Message.Builder<ScheduleInfo, Builder> {
            public ScheduleMessageItem item;
            public Long schedule_time;

            @Override // com.squareup.wire.Message.Builder
            public ScheduleInfo build() {
                return new ScheduleInfo(this.item, this.schedule_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder item(ScheduleMessageItem r100) {
                this.item = r100;
                return this;
            }

            public Builder schedule_time(Long r100) {
                this.schedule_time = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ScheduleInfo extends ProtoAdapter<ScheduleInfo> {
            public ProtoAdapter_ScheduleInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ScheduleInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ScheduleInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.schedule_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.item = ScheduleMessageItem.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.schedule_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(ScheduleInfo r100) {
                ScheduleMessageItem r101 = r100.item;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ScheduleMessageItem.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.schedule_time;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ScheduleInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ScheduleInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ScheduleInfo r101) throws IOException {
                ScheduleMessageItem r102 = r101.item;
                if (r102 == null) goto L5;
                ScheduleMessageItem.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.schedule_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ScheduleInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ScheduleInfo();
            DEFAULT_SCHEDULE_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.item = this.item;
            r100.schedule_time = this.schedule_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ScheduleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ScheduleInfo(ScheduleMessageItem r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ScheduleInfo(ScheduleMessageItem r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.item = r100;
            this.schedule_time = r101;
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type EDIT_MESSAGE = null;
        public static final Type INDIVIDUAL_TOPIC = null;
        public static final Type MSG_THREAD = null;
        public static final Type POST = null;
        public static final Type SCHEDULE_MESSAGE = null;
        public static final Type TEXT = null;
        private final int value;

        static {
            Type r100 = new Type(CardAdapter.TEXT, 0, 1);
            TEXT = r100;
            Type r101 = new Type("POST", 1, 2);
            POST = r101;
            Type r102 = new Type("INDIVIDUAL_TOPIC", 2, 3);
            INDIVIDUAL_TOPIC = r102;
            Type r103 = new Type("EDIT_MESSAGE", 3, 4);
            EDIT_MESSAGE = r103;
            Type r104 = new Type("MSG_THREAD", 4, 5);
            MSG_THREAD = r104;
            Type r110 = new Type("SCHEDULE_MESSAGE", 5, 6);
            SCHEDULE_MESSAGE = r110;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r110};
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
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return SCHEDULE_MESSAGE;
        L8:
            return MSG_THREAD;
        L10:
            return EDIT_MESSAGE;
        L12:
            return INDIVIDUAL_TOPIC;
        L14:
            return POST;
        L16:
            return TEXT;
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
        ADAPTER = new ProtoAdapter_Draft();
        DEFAULT_TYPE = Type.TEXT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253484id = this.f253483id;
        r100.chat_id = this.chat_id;
        r100.message_id = this.message_id;
        r100.content = this.content;
        r100.type = this.type;
        r100.edit_message_id = this.edit_message_id;
        r100.thread_id = this.thread_id;
        r100.schedule_info = this.schedule_info;
        r100.partial_reply_info = this.partial_reply_info;
        r100.cloud_draft_content = this.cloud_draft_content;
        r100.local_extra = Internal.copyOf("local_extra", this.local_extra);
        r100.attachment_snapshot = this.attachment_snapshot;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Draft.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Draft(String r110, String r111, String r112, String r113, Type r114, String r210, String r211, ScheduleInfo r212, Message.PartialReplyInfo r213, CloudDraftContent r214, Map<String, String> r215, DraftAttachmentSnapshot r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public Draft(String r100, String r101, String r102, String r103, Type r104, String r105, String r106, ScheduleInfo r107, Message.PartialReplyInfo r110, CloudDraftContent r111, Map<String, String> r112, DraftAttachmentSnapshot r113, ByteString r114) {
        super(ADAPTER, r114);
        this.f253483id = r100;
        this.chat_id = r101;
        this.message_id = r102;
        this.content = r103;
        this.type = r104;
        this.edit_message_id = r105;
        this.thread_id = r106;
        this.schedule_info = r107;
        this.partial_reply_info = r110;
        this.cloud_draft_content = r111;
        this.local_extra = Internal.immutableCopyOf("local_extra", r112);
        this.attachment_snapshot = r113;
    }
}
