package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import im.v1.QuestionItem;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class AtAIKnowledgeSource extends com.squareup.wire.Message<AtAIKnowledgeSource, Builder> {
    public static final ProtoAdapter<AtAIKnowledgeSource> ADAPTER = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final SourceType DEFAULT_TYPE = null;
    public static final Integer DEFAULT_UNREAD_MESSAGE_END_POS = null;
    public static final Integer DEFAULT_UNREAD_MESSAGE_START_POS = null;
    private static final long serialVersionUID = 0;
    public final String action_id;
    public final QuestionItem question_item;
    public final SourceType type;
    public final Integer unread_message_end_pos;
    public final Integer unread_message_start_pos;

    public static final class Builder extends com.squareup.wire.Message.Builder<AtAIKnowledgeSource, Builder> {
        public String action_id;
        public QuestionItem question_item;
        public SourceType type;
        public Integer unread_message_end_pos;
        public Integer unread_message_start_pos;

        @Override // com.squareup.wire.Message.Builder
        public AtAIKnowledgeSource build() {
            return new AtAIKnowledgeSource(this.type, this.unread_message_start_pos, this.unread_message_end_pos, this.action_id, this.question_item, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_id(String r100) {
            this.action_id = r100;
            return this;
        }

        public Builder question_item(QuestionItem r100) {
            this.question_item = r100;
            return this;
        }

        public Builder type(SourceType r100) {
            this.type = r100;
            return this;
        }

        public Builder unread_message_end_pos(Integer r100) {
            this.unread_message_end_pos = r100;
            return this;
        }

        public Builder unread_message_start_pos(Integer r100) {
            this.unread_message_start_pos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AtAIKnowledgeSource extends ProtoAdapter<AtAIKnowledgeSource> {
        public ProtoAdapter_AtAIKnowledgeSource() {
            super(FieldEncoding.LENGTH_DELIMITED, AtAIKnowledgeSource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AtAIKnowledgeSource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = SourceType.NORMAL;
            r101.unread_message_start_pos = 0;
            r101.unread_message_end_pos = 0;
            r101.action_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.type = SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.unread_message_start_pos = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.unread_message_end_pos = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.action_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.question_item = QuestionItem.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AtAIKnowledgeSource r100) {
            SourceType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SourceType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.unread_message_start_pos;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.unread_message_end_pos;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.action_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            QuestionItem r113 = r100.question_item;
            if (r113 == null) goto L22;
            r102 = QuestionItem.ADAPTER.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ AtAIKnowledgeSource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AtAIKnowledgeSource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AtAIKnowledgeSource r101) throws IOException {
            SourceType r102 = r101.type;
            if (r102 == null) goto L5;
            SourceType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.unread_message_start_pos;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.unread_message_end_pos;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.action_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            QuestionItem r106 = r101.question_item;
            if (r106 == null) goto L17;
            QuestionItem.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AtAIKnowledgeSource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SourceType extends Enum<SourceType> implements WireEnum {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final SourceType FROM_ENTRANCE_CUSTOM = null;
        public static final SourceType FROM_UNREAD_RECOMMEND = null;
        public static final SourceType NORMAL = null;
        private final int value;

        static {
            SourceType r100 = new SourceType(EffectConstants.NORMAL, 0, 0);
            NORMAL = r100;
            SourceType r101 = new SourceType("FROM_UNREAD_RECOMMEND", 1, 1);
            FROM_UNREAD_RECOMMEND = r101;
            SourceType r102 = new SourceType("FROM_ENTRANCE_CUSTOM", 2, 2);
            FROM_ENTRANCE_CUSTOM = r102;
            $VALUES = new SourceType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceType.class);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SourceType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return FROM_ENTRANCE_CUSTOM;
        L12:
            return FROM_UNREAD_RECOMMEND;
        L14:
            return NORMAL;
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) a.a(SourceType.class, r100);
        }

        private SourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AtAIKnowledgeSource();
        DEFAULT_TYPE = SourceType.NORMAL;
        DEFAULT_UNREAD_MESSAGE_START_POS = 0;
        DEFAULT_UNREAD_MESSAGE_END_POS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.unread_message_start_pos = this.unread_message_start_pos;
        r100.unread_message_end_pos = this.unread_message_end_pos;
        r100.action_id = this.action_id;
        r100.question_item = this.question_item;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AtAIKnowledgeSource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AtAIKnowledgeSource(SourceType r100, Integer r101, Integer r110, String r111, QuestionItem r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AtAIKnowledgeSource(SourceType r100, Integer r101, Integer r102, String r103, QuestionItem r104, ByteString r105) {
        super(ADAPTER, r105);
        this.type = r100;
        this.unread_message_start_pos = r101;
        this.unread_message_end_pos = r102;
        this.action_id = r103;
        this.question_item = r104;
    }
}
