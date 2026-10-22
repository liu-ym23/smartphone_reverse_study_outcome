package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Chatter;
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
public final class DoubaoTyping extends Message<DoubaoTyping, Builder> {
    public static final ProtoAdapter<DoubaoTyping> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final Chatter chatter;
    public final List<Long> message_ids;
    public final List<TypingMessage> messages;
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<DoubaoTyping, Builder> {
        public Long chat_id;
        public Chatter chatter;
        public List<Long> message_ids;
        public List<TypingMessage> messages;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public DoubaoTyping build() {
            return new DoubaoTyping(this.update_time_ms, this.chat_id, this.message_ids, this.chatter, this.messages, super.buildUnknownFields());
        }

        public Builder() {
            this.message_ids = Internal.newMutableList();
            this.messages = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter(Chatter r100) {
            this.chatter = r100;
            return this;
        }

        public Builder message_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }

        public Builder messages(List<TypingMessage> r100) {
            Internal.checkElementsNotNull(r100);
            this.messages = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DoubaoTyping extends ProtoAdapter<DoubaoTyping> {
        public ProtoAdapter_DoubaoTyping() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoTyping.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DoubaoTyping decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.update_time_ms = 0L;
            r101.chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L12;
            r101.message_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            if (r103 != 5) goto L14;
            r101.chatter = Chatter.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 6) goto L15;
            r101.messages.add(TypingMessage.ADAPTER.decode(r100));
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
        public int encodedSize2(DoubaoTyping r100) {
            Long r101 = r100.update_time_ms;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.chat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(4, r100.message_ids);
            Chatter r107 = r100.chatter;
            if (r107 == null) goto L14;
            r102 = Chatter.ADAPTER.encodedSizeWithTag(5, r107);
        L14:
            return ((r106 + r102) + TypingMessage.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.messages)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DoubaoTyping decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DoubaoTyping r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DoubaoTyping r101) throws IOException {
            Long r102 = r101.update_time_ms;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 4, r101.message_ids);
            Chatter r104 = r101.chatter;
            if (r104 == null) goto L11;
            Chatter.ADAPTER.encodeWithTag(r100, 5, r104);
        L11:
            TypingMessage.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.messages);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DoubaoTyping r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DoubaoTyping();
        DEFAULT_UPDATE_TIME_MS = 0L;
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.update_time_ms = this.update_time_ms;
        r100.chat_id = this.chat_id;
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.chatter = this.chatter;
        r100.messages = Internal.copyOf("messages", this.messages);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DoubaoTyping.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DoubaoTyping(Long r100, Long r101, List<Long> r110, Chatter r111, List<TypingMessage> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public DoubaoTyping(Long r100, Long r101, List<Long> r102, Chatter r103, List<TypingMessage> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.update_time_ms = r100;
        this.chat_id = r101;
        this.message_ids = Internal.immutableCopyOf("message_ids", r102);
        this.chatter = r103;
        this.messages = Internal.immutableCopyOf("messages", r104);
    }
}
