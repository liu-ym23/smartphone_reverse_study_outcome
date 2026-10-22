package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AIInfoContext extends com.squareup.wire.Message<AIInfoContext, Builder> {
    public static final ProtoAdapter<AIInfoContext> ADAPTER = null;
    public static final Long DEFAULT_AI_CHAT_MODE_ID = null;
    public static final Boolean DEFAULT_IS_NEW_TOPIC = null;
    public static final Long DEFAULT_ROOT_ROUND_ID = null;
    private static final long serialVersionUID = 0;
    public final Long ai_chat_mode_id;
    public final ChatContext chat_context;
    public final Boolean is_new_topic;
    public final QuickActionInfo quick_action_info;
    public final Long root_round_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<AIInfoContext, Builder> {
        public Long ai_chat_mode_id;
        public ChatContext chat_context;
        public Boolean is_new_topic;
        public QuickActionInfo quick_action_info;
        public Long root_round_id;

        @Override // com.squareup.wire.Message.Builder
        public AIInfoContext build() {
            return new AIInfoContext(this.ai_chat_mode_id, this.quick_action_info, this.chat_context, this.is_new_topic, this.root_round_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(Long r100) {
            this.ai_chat_mode_id = r100;
            return this;
        }

        public Builder chat_context(ChatContext r100) {
            this.chat_context = r100;
            return this;
        }

        public Builder is_new_topic(Boolean r100) {
            this.is_new_topic = r100;
            return this;
        }

        public Builder quick_action_info(QuickActionInfo r100) {
            this.quick_action_info = r100;
            return this;
        }

        public Builder root_round_id(Long r100) {
            this.root_round_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AIInfoContext extends ProtoAdapter<AIInfoContext> {
        public ProtoAdapter_AIInfoContext() {
            super(FieldEncoding.LENGTH_DELIMITED, AIInfoContext.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AIInfoContext decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.ai_chat_mode_id = 0L;
            r101.is_new_topic = Boolean.FALSE;
            r101.root_round_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.ai_chat_mode_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.quick_action_info = QuickActionInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L12;
            r101.chat_context = ChatContext.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 6) goto L14;
            r101.is_new_topic = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 7) goto L15;
            r101.root_round_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AIInfoContext r100) {
            Long r101 = r100.ai_chat_mode_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            QuickActionInfo r104 = r100.quick_action_info;
            if (r104 == null) goto L9;
            int r105 = QuickActionInfo.ADAPTER.encodedSizeWithTag(3, r104);
        L10:
            int r106 = r103 + r105;
            ChatContext r107 = r100.chat_context;
            if (r107 == null) goto L13;
            int r108 = ChatContext.ADAPTER.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_new_topic;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.root_round_id;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(7, r113);
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
        public /* bridge */ /* synthetic */ AIInfoContext decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AIInfoContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AIInfoContext r101) throws IOException {
            Long r102 = r101.ai_chat_mode_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            QuickActionInfo r103 = r101.quick_action_info;
            if (r103 == null) goto L8;
            QuickActionInfo.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            ChatContext r104 = r101.chat_context;
            if (r104 == null) goto L11;
            ChatContext.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.is_new_topic;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r105);
        L14:
            Long r106 = r101.root_round_id;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 7, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIInfoContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIInfoContext();
        DEFAULT_AI_CHAT_MODE_ID = 0L;
        DEFAULT_IS_NEW_TOPIC = Boolean.FALSE;
        DEFAULT_ROOT_ROUND_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ai_chat_mode_id = this.ai_chat_mode_id;
        r100.quick_action_info = this.quick_action_info;
        r100.chat_context = this.chat_context;
        r100.is_new_topic = this.is_new_topic;
        r100.root_round_id = this.root_round_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AIInfoContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AIInfoContext(Long r100, QuickActionInfo r101, ChatContext r110, Boolean r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AIInfoContext(Long r100, QuickActionInfo r101, ChatContext r102, Boolean r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.ai_chat_mode_id = r100;
        this.quick_action_info = r101;
        this.chat_context = r102;
        this.is_new_topic = r103;
        this.root_round_id = r104;
    }
}
