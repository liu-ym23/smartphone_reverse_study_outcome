package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TypingMessage extends Message<TypingMessage, Builder> {
    public static final ProtoAdapter<TypingMessage> ADAPTER = null;
    public static final Long DEFAULT_MSG_ID = null;
    public static final Long DEFAULT_THREAD_ID = null;
    private static final long serialVersionUID = 0;
    public final Long msg_id;
    public final Long thread_id;

    public static final class Builder extends Message.Builder<TypingMessage, Builder> {
        public Long msg_id;
        public Long thread_id;

        @Override // com.squareup.wire.Message.Builder
        public TypingMessage build() {
            return new TypingMessage(this.msg_id, this.thread_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder msg_id(Long r100) {
            this.msg_id = r100;
            return this;
        }

        public Builder thread_id(Long r100) {
            this.thread_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TypingMessage extends ProtoAdapter<TypingMessage> {
        public ProtoAdapter_TypingMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, TypingMessage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TypingMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msg_id = 0L;
            r101.thread_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.msg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.thread_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(TypingMessage r100) {
            Long r101 = r100.msg_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.thread_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TypingMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TypingMessage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TypingMessage r101) throws IOException {
            Long r102 = r101.msg_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.thread_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TypingMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TypingMessage();
        DEFAULT_MSG_ID = 0L;
        DEFAULT_THREAD_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msg_id = this.msg_id;
        r100.thread_id = this.thread_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TypingMessage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TypingMessage(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TypingMessage(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.msg_id = r100;
        this.thread_id = r101;
    }
}
