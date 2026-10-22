package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.MergeFowardMessageType;
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
public final class MergeForwardMessagesRequest extends Message<MergeForwardMessagesRequest, Builder> {
    public static final ProtoAdapter<MergeForwardMessagesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_LIMITED = null;
    public static final Boolean DEFAULT_NEED_COPY_REACTION = null;
    public static final Boolean DEFAULT_NEED_QUASI_MESSAGE = null;
    public static final String DEFAULT_ORIGIN_MERGE_FORWARD_ID = "";
    public static final String DEFAULT_QUASI_TITLE = "";
    public static final String DEFAULT_THREAD_ID = "";
    public static final MergeFowardMessageType DEFAULT_TYPE = null;
    public static final ProtoAdapter_MergeForwardMessagesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chat_ids;
    public final Boolean limited;
    public final List<String> message_ids;
    public final Boolean need_copy_reaction;
    public final Boolean need_quasi_message;
    public final String origin_merge_forward_id;
    public final String quasi_title;
    public final String thread_id;
    public final List<Transmit2ThreadTarget> thread_targets;
    public final MergeFowardMessageType type;

    public static final class Builder extends Message.Builder<MergeForwardMessagesRequest, Builder> implements d<MergeForwardMessagesRequest> {
        public List<String> chat_ids;
        public Boolean limited;
        public List<String> message_ids;
        public Boolean need_copy_reaction;
        public Boolean need_quasi_message;
        public String origin_merge_forward_id;
        public String quasi_title;
        public String thread_id;
        public List<Transmit2ThreadTarget> thread_targets;
        public MergeFowardMessageType type;

        @Override // com.squareup.wire.Message.Builder
        public MergeForwardMessagesRequest build() {
            String r100 = this.quasi_title;
            if (r100 == null) goto L7;
            return new MergeForwardMessagesRequest(this.chat_ids, this.message_ids, this.quasi_title, this.type, this.limited, this.thread_id, this.thread_targets, this.need_quasi_message, this.need_copy_reaction, this.origin_merge_forward_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "quasi_title"});
        }

        public Builder() {
            this.chat_ids = Internal.newMutableList();
            this.message_ids = Internal.newMutableList();
            this.thread_targets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_ids = r100;
            return this;
        }

        public Builder limited(Boolean r100) {
            this.limited = r100;
            return this;
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }

        public Builder need_copy_reaction(Boolean r100) {
            this.need_copy_reaction = r100;
            return this;
        }

        public Builder need_quasi_message(Boolean r100) {
            this.need_quasi_message = r100;
            return this;
        }

        public Builder origin_merge_forward_id(String r100) {
            this.origin_merge_forward_id = r100;
            return this;
        }

        public Builder quasi_title(String r100) {
            this.quasi_title = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_targets(List<Transmit2ThreadTarget> r100) {
            Internal.checkElementsNotNull(r100);
            this.thread_targets = r100;
            return this;
        }

        public Builder type(MergeFowardMessageType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MergeForwardMessagesRequest extends ProtoAdapter<MergeForwardMessagesRequest> implements c<MergeForwardMessagesRequest> {
        public ProtoAdapter_MergeForwardMessagesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MergeForwardMessagesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MergeForwardMessagesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.quasi_title = "";
            r101.type = MergeFowardMessageType.MERGE_MESSAGE;
            Boolean r102 = Boolean.FALSE;
            r101.limited = r102;
            r101.thread_id = "";
            r101.need_quasi_message = Boolean.TRUE;
            r101.need_copy_reaction = r102;
            r101.origin_merge_forward_id = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L20;
            switch(r104) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L22;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r101.type = MergeFowardMessageType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.origin_merge_forward_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.need_copy_reaction = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.need_quasi_message = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.thread_targets.add(Transmit2ThreadTarget.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.limited = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.quasi_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.message_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L19:
            r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MergeForwardMessagesRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.asRepeated().encodedSizeWithTag(1, r100.chat_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.message_ids)) + r101.encodedSizeWithTag(3, r100.quasi_title);
            MergeFowardMessageType r103 = r100.type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = MergeFowardMessageType.ADAPTER.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.limited;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.thread_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(6, r110);
        L14:
            int r112 = (r109 + r111) + Transmit2ThreadTarget.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.thread_targets);
            Boolean r113 = r100.need_quasi_message;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r113);
        L18:
            int r115 = r112 + r114;
            Boolean r116 = r100.need_copy_reaction;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.origin_merge_forward_id;
            if (r119 == null) goto L26;
            r104 = r101.encodedSizeWithTag(10, r119);
        L26:
            return (r118 + r104) + r100.unknownFields().size();
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MergeForwardMessagesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MergeForwardMessagesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MergeForwardMessagesRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.chat_ids);
            r102.asRepeated().encodeWithTag(r100, 2, r101.message_ids);
            r102.encodeWithTag(r100, 3, r101.quasi_title);
            MergeFowardMessageType r103 = r101.type;
            if (r103 == null) goto L5;
            MergeFowardMessageType.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            Boolean r104 = r101.limited;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L8:
            String r105 = r101.thread_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 6, r105);
        L11:
            Transmit2ThreadTarget.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.thread_targets);
            Boolean r106 = r101.need_quasi_message;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r106);
        L14:
            Boolean r107 = r101.need_copy_reaction;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r107);
        L17:
            String r108 = r101.origin_merge_forward_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 10, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MergeForwardMessagesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MergeForwardMessagesRequest r100 = new ProtoAdapter_MergeForwardMessagesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = MergeFowardMessageType.MERGE_MESSAGE;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_LIMITED = r101;
        DEFAULT_NEED_QUASI_MESSAGE = Boolean.TRUE;
        DEFAULT_NEED_COPY_REACTION = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.quasi_title = this.quasi_title;
        r100.type = this.type;
        r100.limited = this.limited;
        r100.thread_id = this.thread_id;
        r100.thread_targets = Internal.copyOf("thread_targets", this.thread_targets);
        r100.need_quasi_message = this.need_quasi_message;
        r100.need_copy_reaction = this.need_copy_reaction;
        r100.origin_merge_forward_id = this.origin_merge_forward_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MergeForwardMessagesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MergeForwardMessagesRequest(List<String> r110, List<String> r111, String r112, MergeFowardMessageType r113, Boolean r114, String r115, List<Transmit2ThreadTarget> r116, Boolean r210, Boolean r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public MergeForwardMessagesRequest(List<String> r100, List<String> r101, String r102, MergeFowardMessageType r103, Boolean r104, String r105, List<Transmit2ThreadTarget> r106, Boolean r107, Boolean r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.chat_ids = Internal.immutableCopyOf("chat_ids", r100);
        this.message_ids = Internal.immutableCopyOf("message_ids", r101);
        this.quasi_title = r102;
        this.type = r103;
        this.limited = r104;
        this.thread_id = r105;
        this.thread_targets = Internal.immutableCopyOf("thread_targets", r106);
        this.need_quasi_message = r107;
        this.need_copy_reaction = r110;
        this.origin_merge_forward_id = r111;
    }
}
