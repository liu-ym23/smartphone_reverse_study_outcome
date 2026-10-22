package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageBehavior extends Message<MessageBehavior, Builder> {
    public static final ProtoAdapter<MessageBehavior> ADAPTER = null;
    public static final Integer DEFAULT_CODE = null;
    public static final MessageDisplayMode DEFAULT_MESSAGE_DISPLAY_MODE = null;
    private static final long serialVersionUID = 0;
    public final Integer code;
    public final MessageDisplayMode message_display_mode;

    public static final class Builder extends Message.Builder<MessageBehavior, Builder> {
        public Integer code;
        public MessageDisplayMode message_display_mode;

        @Override // com.squareup.wire.Message.Builder
        public MessageBehavior build() {
            return new MessageBehavior(this.message_display_mode, this.code, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(Integer r100) {
            this.code = r100;
            return this;
        }

        public Builder message_display_mode(MessageDisplayMode r100) {
            this.message_display_mode = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageBehavior extends ProtoAdapter<MessageBehavior> {
        public ProtoAdapter_MessageBehavior() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageBehavior.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageBehavior decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_display_mode = MessageDisplayMode.UNKNOWN_MODE;
            r101.code = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.message_display_mode = MessageDisplayMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageBehavior r100) {
            MessageDisplayMode r101 = r100.message_display_mode;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = MessageDisplayMode.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.code;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageBehavior decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageBehavior r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageBehavior r101) throws IOException {
            MessageDisplayMode r102 = r101.message_display_mode;
            if (r102 == null) goto L5;
            MessageDisplayMode.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.code;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageBehavior r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageBehavior();
        DEFAULT_MESSAGE_DISPLAY_MODE = MessageDisplayMode.UNKNOWN_MODE;
        DEFAULT_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_display_mode = this.message_display_mode;
        r100.code = this.code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageBehavior.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageBehavior(MessageDisplayMode r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MessageBehavior(MessageDisplayMode r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message_display_mode = r100;
        this.code = r101;
    }
}
