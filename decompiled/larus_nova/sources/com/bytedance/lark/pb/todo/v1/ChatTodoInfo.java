package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatTodoInfo extends Message<ChatTodoInfo, Builder> {
    public static final ProtoAdapter<ChatTodoInfo> ADAPTER = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_MESSAGE_POSITION = null;
    public static final Long DEFAULT_SEND_TIME = null;
    private static final long serialVersionUID = 0;
    public final String message_id;
    public final Integer message_position;
    public final Long send_time;
    public final Chatter sender;
    public final Todo todo;

    public static final class Builder extends Message.Builder<ChatTodoInfo, Builder> {
        public String message_id;
        public Integer message_position;
        public Long send_time;
        public Chatter sender;
        public Todo todo;

        @Override // com.squareup.wire.Message.Builder
        public ChatTodoInfo build() {
            return new ChatTodoInfo(this.todo, this.message_position, this.message_id, this.sender, this.send_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder message_position(Integer r100) {
            this.message_position = r100;
            return this;
        }

        public Builder send_time(Long r100) {
            this.send_time = r100;
            return this;
        }

        public Builder sender(Chatter r100) {
            this.sender = r100;
            return this;
        }

        public Builder todo(Todo r100) {
            this.todo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatTodoInfo extends ProtoAdapter<ChatTodoInfo> {
        public ProtoAdapter_ChatTodoInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatTodoInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatTodoInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_position = 0;
            r101.message_id = "";
            r101.send_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.todo = Todo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.sender = Chatter.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.send_time = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(ChatTodoInfo r100) {
            Todo r101 = r100.todo;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Todo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.message_position;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.message_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Chatter r110 = r100.sender;
            if (r110 == null) goto L17;
            int r111 = Chatter.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.send_time;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ ChatTodoInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatTodoInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatTodoInfo r101) throws IOException {
            Todo r102 = r101.todo;
            if (r102 == null) goto L5;
            Todo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.message_position;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.message_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Chatter r105 = r101.sender;
            if (r105 == null) goto L14;
            Chatter.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.send_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatTodoInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatTodoInfo();
        DEFAULT_MESSAGE_POSITION = 0;
        DEFAULT_SEND_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo = this.todo;
        r100.message_position = this.message_position;
        r100.message_id = this.message_id;
        r100.sender = this.sender;
        r100.send_time = this.send_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatTodoInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatTodoInfo(Todo r100, Integer r101, String r110, Chatter r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ChatTodoInfo(Todo r100, Integer r101, String r102, Chatter r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.todo = r100;
        this.message_position = r101;
        this.message_id = r102;
        this.sender = r103;
        this.send_time = r104;
    }
}
