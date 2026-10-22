package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.office_sdk.basic.DoubaoContent;
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
public final class TransmitDoubaoMessagesRequest extends Message<TransmitDoubaoMessagesRequest, Builder> {
    public static final ProtoAdapter<TransmitDoubaoMessagesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_NEED_QUASI_MESSAGE = null;
    public static final String DEFAULT_QUASI_TITLE = "";
    public static final ProtoAdapter_TransmitDoubaoMessagesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chat_ids;
    public final List<DoubaoContent> doubao_messages;
    public final Boolean need_quasi_message;
    public final String quasi_title;
    public final List<Transmit2ThreadTarget> thread_targets;

    public static final class Builder extends Message.Builder<TransmitDoubaoMessagesRequest, Builder> implements d<TransmitDoubaoMessagesRequest> {
        public List<String> chat_ids;
        public List<DoubaoContent> doubao_messages;
        public Boolean need_quasi_message;
        public String quasi_title;
        public List<Transmit2ThreadTarget> thread_targets;

        @Override // com.squareup.wire.Message.Builder
        public TransmitDoubaoMessagesRequest build() {
            String r100 = this.quasi_title;
            if (r100 == null) goto L7;
            return new TransmitDoubaoMessagesRequest(this.chat_ids, this.thread_targets, this.doubao_messages, this.quasi_title, this.need_quasi_message, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "quasi_title"});
        }

        public Builder() {
            this.chat_ids = Internal.newMutableList();
            this.thread_targets = Internal.newMutableList();
            this.doubao_messages = Internal.newMutableList();
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

        public Builder doubao_messages(List<DoubaoContent> r100) {
            Internal.checkElementsNotNull(r100);
            this.doubao_messages = r100;
            return this;
        }

        public Builder need_quasi_message(Boolean r100) {
            this.need_quasi_message = r100;
            return this;
        }

        public Builder quasi_title(String r100) {
            this.quasi_title = r100;
            return this;
        }

        public Builder thread_targets(List<Transmit2ThreadTarget> r100) {
            Internal.checkElementsNotNull(r100);
            this.thread_targets = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TransmitDoubaoMessagesRequest extends ProtoAdapter<TransmitDoubaoMessagesRequest> implements c<TransmitDoubaoMessagesRequest> {
        public ProtoAdapter_TransmitDoubaoMessagesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, TransmitDoubaoMessagesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TransmitDoubaoMessagesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.quasi_title = "";
            r101.need_quasi_message = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.thread_targets.add(Transmit2ThreadTarget.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.doubao_messages.add(DoubaoContent.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.quasi_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.need_quasi_message = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(TransmitDoubaoMessagesRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.asRepeated().encodedSizeWithTag(1, r100.chat_ids) + Transmit2ThreadTarget.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.thread_targets)) + DoubaoContent.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.doubao_messages)) + r101.encodedSizeWithTag(4, r100.quasi_title);
            Boolean r103 = r100.need_quasi_message;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TransmitDoubaoMessagesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TransmitDoubaoMessagesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TransmitDoubaoMessagesRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.chat_ids);
            Transmit2ThreadTarget.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.thread_targets);
            DoubaoContent.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.doubao_messages);
            r102.encodeWithTag(r100, 4, r101.quasi_title);
            Boolean r103 = r101.need_quasi_message;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TransmitDoubaoMessagesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TransmitDoubaoMessagesRequest r100 = new ProtoAdapter_TransmitDoubaoMessagesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NEED_QUASI_MESSAGE = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
        r100.thread_targets = Internal.copyOf("thread_targets", this.thread_targets);
        r100.doubao_messages = Internal.copyOf("doubao_messages", this.doubao_messages);
        r100.quasi_title = this.quasi_title;
        r100.need_quasi_message = this.need_quasi_message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TransmitDoubaoMessagesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TransmitDoubaoMessagesRequest(List<String> r100, List<Transmit2ThreadTarget> r101, List<DoubaoContent> r110, String r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TransmitDoubaoMessagesRequest(List<String> r100, List<Transmit2ThreadTarget> r101, List<DoubaoContent> r102, String r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.chat_ids = Internal.immutableCopyOf("chat_ids", r100);
        this.thread_targets = Internal.immutableCopyOf("thread_targets", r101);
        this.doubao_messages = Internal.immutableCopyOf("doubao_messages", r102);
        this.quasi_title = r103;
        this.need_quasi_message = r104;
    }
}
