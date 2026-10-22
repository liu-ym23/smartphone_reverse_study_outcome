package com.bytedance.lark.pb.im.v1;

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
public final class AISessionInfo extends Message<AISessionInfo, Builder> {
    public static final ProtoAdapter<AISessionInfo> ADAPTER = null;
    public static final Long DEFAULT_LAST_NEW_TOPIC_SYSTEM_MSG_POSITION = null;
    public static final Long DEFAULT_SESSION_FIRST_MESSAGE_ID = null;
    public static final String DEFAULT_SESSION_ID = "";
    private static final long serialVersionUID = 0;
    public final Long last_new_topic_system_msg_position;
    public final Long session_first_message_id;
    public final String session_id;
    public final List<String> tool_ids;

    public static final class Builder extends Message.Builder<AISessionInfo, Builder> {
        public Long last_new_topic_system_msg_position;
        public Long session_first_message_id;
        public String session_id;
        public List<String> tool_ids;

        @Override // com.squareup.wire.Message.Builder
        public AISessionInfo build() {
            return new AISessionInfo(this.last_new_topic_system_msg_position, this.tool_ids, this.session_id, this.session_first_message_id, super.buildUnknownFields());
        }

        public Builder() {
            this.tool_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder last_new_topic_system_msg_position(Long r100) {
            this.last_new_topic_system_msg_position = r100;
            return this;
        }

        public Builder session_first_message_id(Long r100) {
            this.session_first_message_id = r100;
            return this;
        }

        public Builder session_id(String r100) {
            this.session_id = r100;
            return this;
        }

        public Builder tool_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.tool_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AISessionInfo extends ProtoAdapter<AISessionInfo> {
        public ProtoAdapter_AISessionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AISessionInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AISessionInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.last_new_topic_system_msg_position = 0L;
            r101.session_id = "";
            r101.session_first_message_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.last_new_topic_system_msg_position = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.tool_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.session_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.session_first_message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AISessionInfo r100) {
            Long r101 = r100.last_new_topic_system_msg_position;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = r103 + r104.asRepeated().encodedSizeWithTag(2, r100.tool_ids);
            String r106 = r100.session_id;
            if (r106 == null) goto L9;
            int r107 = r104.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Long r109 = r100.session_first_message_id;
            if (r109 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r102) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AISessionInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AISessionInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AISessionInfo r101) throws IOException {
            Long r102 = r101.last_new_topic_system_msg_position;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.asRepeated().encodeWithTag(r100, 2, r101.tool_ids);
            String r104 = r101.session_id;
            if (r104 == null) goto L8;
            r103.encodeWithTag(r100, 3, r104);
        L8:
            Long r105 = r101.session_first_message_id;
            if (r105 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AISessionInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AISessionInfo();
        DEFAULT_LAST_NEW_TOPIC_SYSTEM_MSG_POSITION = 0L;
        DEFAULT_SESSION_FIRST_MESSAGE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.last_new_topic_system_msg_position = this.last_new_topic_system_msg_position;
        r100.tool_ids = Internal.copyOf("tool_ids", this.tool_ids);
        r100.session_id = this.session_id;
        r100.session_first_message_id = this.session_first_message_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AISessionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AISessionInfo(Long r100, List<String> r101, String r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AISessionInfo(Long r100, List<String> r101, String r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.last_new_topic_system_msg_position = r100;
        this.tool_ids = Internal.immutableCopyOf("tool_ids", r101);
        this.session_id = r102;
        this.session_first_message_id = r103;
    }
}
