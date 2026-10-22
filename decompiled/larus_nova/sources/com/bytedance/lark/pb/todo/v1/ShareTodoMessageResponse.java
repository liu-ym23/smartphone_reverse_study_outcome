package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class ShareTodoMessageResponse extends Message<ShareTodoMessageResponse, Builder> {
    public static final ProtoAdapter<ShareTodoMessageResponse> ADAPTER = null;
    public static final ProtoAdapter_ShareTodoMessageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> chat_id2message_ids;
    public final List<ShareFailedChat> failed_chats;
    public final Map<String, Share2ThreadTarget> message2threads;

    public static final class Builder extends Message.Builder<ShareTodoMessageResponse, Builder> implements d<ShareTodoMessageResponse> {
        public Map<String, String> chat_id2message_ids;
        public List<ShareFailedChat> failed_chats;
        public Map<String, Share2ThreadTarget> message2threads;

        @Override // com.squareup.wire.Message.Builder
        public ShareTodoMessageResponse build() {
            return new ShareTodoMessageResponse(this.chat_id2message_ids, this.message2threads, this.failed_chats, super.buildUnknownFields());
        }

        public Builder() {
            this.chat_id2message_ids = Internal.newMutableMap();
            this.message2threads = Internal.newMutableMap();
            this.failed_chats = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id2message_ids(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_id2message_ids = r100;
            return this;
        }

        public Builder failed_chats(List<ShareFailedChat> r100) {
            Internal.checkElementsNotNull(r100);
            this.failed_chats = r100;
            return this;
        }

        public Builder message2threads(Map<String, Share2ThreadTarget> r100) {
            Internal.checkElementsNotNull(r100);
            this.message2threads = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ShareTodoMessageResponse extends ProtoAdapter<ShareTodoMessageResponse> implements c<ShareTodoMessageResponse> {
        private final ProtoAdapter<Map<String, String>> chat_id2message_ids;
        private final ProtoAdapter<Map<String, Share2ThreadTarget>> message2threads;

        public ProtoAdapter_ShareTodoMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareTodoMessageResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.chat_id2message_ids = ProtoAdapter.newMapAdapter(r100, r100);
            this.message2threads = ProtoAdapter.newMapAdapter(r100, Share2ThreadTarget.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShareTodoMessageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id2message_ids.putAll(this.chat_id2message_ids.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.message2threads.putAll(this.message2threads.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.failed_chats.add(ShareFailedChat.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ShareTodoMessageResponse r100) {
            return ((this.chat_id2message_ids.encodedSizeWithTag(1, r100.chat_id2message_ids) + this.message2threads.encodedSizeWithTag(2, r100.message2threads)) + ShareFailedChat.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.failed_chats)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ShareTodoMessageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShareTodoMessageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShareTodoMessageResponse r101) throws IOException {
            this.chat_id2message_ids.encodeWithTag(r100, 1, r101.chat_id2message_ids);
            this.message2threads.encodeWithTag(r100, 2, r101.message2threads);
            ShareFailedChat.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.failed_chats);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareTodoMessageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Share2ThreadTarget extends Message<Share2ThreadTarget, Builder> {
        public static final ProtoAdapter<Share2ThreadTarget> ADAPTER = null;
        public static final String DEFAULT_CHANNEL_ID = "";
        public static final Boolean DEFAULT_IS_REPLY_IN_THREAD = null;
        public static final String DEFAULT_THREAD_ID = "";
        private static final long serialVersionUID = 0;
        public final String channel_id;
        public final Boolean is_reply_in_thread;
        public final String thread_id;

        public static final class Builder extends Message.Builder<Share2ThreadTarget, Builder> {
            public String channel_id;
            public Boolean is_reply_in_thread;
            public String thread_id;

            @Override // com.squareup.wire.Message.Builder
            public Share2ThreadTarget build() {
                return new Share2ThreadTarget(this.thread_id, this.channel_id, this.is_reply_in_thread, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder channel_id(String r100) {
                this.channel_id = r100;
                return this;
            }

            public Builder is_reply_in_thread(Boolean r100) {
                this.is_reply_in_thread = r100;
                return this;
            }

            public Builder thread_id(String r100) {
                this.thread_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Share2ThreadTarget extends ProtoAdapter<Share2ThreadTarget> {
            public ProtoAdapter_Share2ThreadTarget() {
                super(FieldEncoding.LENGTH_DELIMITED, Share2ThreadTarget.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Share2ThreadTarget decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.thread_id = "";
                r101.channel_id = "";
                r101.is_reply_in_thread = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.thread_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.channel_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.is_reply_in_thread = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Share2ThreadTarget r100) {
                String r101 = r100.thread_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.channel_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Boolean r107 = r100.is_reply_in_thread;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Share2ThreadTarget decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Share2ThreadTarget r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Share2ThreadTarget r101) throws IOException {
                String r102 = r101.thread_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.channel_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                Boolean r104 = r101.is_reply_in_thread;
                if (r104 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Share2ThreadTarget r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Share2ThreadTarget();
            DEFAULT_IS_REPLY_IN_THREAD = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.thread_id = this.thread_id;
            r100.channel_id = this.channel_id;
            r100.is_reply_in_thread = this.is_reply_in_thread;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Share2ThreadTarget.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Share2ThreadTarget(String r100, String r101, Boolean r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Share2ThreadTarget(String r100, String r101, Boolean r102, ByteString r103) {
            super(ADAPTER, r103);
            this.thread_id = r100;
            this.channel_id = r101;
            this.is_reply_in_thread = r102;
        }
    }

    public static final class ShareFailedChat extends Message<ShareFailedChat, Builder> {
        public static final ProtoAdapter<ShareFailedChat> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        public static final String DEFAULT_CHAT_NAME = "";
        public static final Integer DEFAULT_ERROR_CODE = null;
        private static final long serialVersionUID = 0;
        public final String chat_id;
        public final String chat_name;
        public final Integer error_code;

        public static final class Builder extends Message.Builder<ShareFailedChat, Builder> {
            public String chat_id;
            public String chat_name;
            public Integer error_code;

            @Override // com.squareup.wire.Message.Builder
            public ShareFailedChat build() {
                return new ShareFailedChat(this.error_code, this.chat_id, this.chat_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chat_id(String r100) {
                this.chat_id = r100;
                return this;
            }

            public Builder chat_name(String r100) {
                this.chat_name = r100;
                return this;
            }

            public Builder error_code(Integer r100) {
                this.error_code = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ShareFailedChat extends ProtoAdapter<ShareFailedChat> {
            public ProtoAdapter_ShareFailedChat() {
                super(FieldEncoding.LENGTH_DELIMITED, ShareFailedChat.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ShareFailedChat decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.error_code = 0;
                r101.chat_id = "";
                r101.chat_name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.error_code = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.chat_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.chat_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ShareFailedChat r100) {
                Integer r101 = r100.error_code;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.chat_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.chat_name;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ShareFailedChat decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ShareFailedChat r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ShareFailedChat r101) throws IOException {
                Integer r102 = r101.error_code;
                if (r102 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.chat_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.chat_name;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareFailedChat r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShareFailedChat();
            DEFAULT_ERROR_CODE = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.error_code = this.error_code;
            r100.chat_id = this.chat_id;
            r100.chat_name = this.chat_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ShareFailedChat.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ShareFailedChat(Integer r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ShareFailedChat(Integer r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.error_code = r100;
            this.chat_id = r101;
            this.chat_name = r102;
        }
    }

    static {
        ProtoAdapter_ShareTodoMessageResponse r100 = new ProtoAdapter_ShareTodoMessageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id2message_ids = Internal.copyOf("chat_id2message_ids", this.chat_id2message_ids);
        r100.message2threads = Internal.copyOf("message2threads", this.message2threads);
        r100.failed_chats = Internal.copyOf("failed_chats", this.failed_chats);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShareTodoMessageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShareTodoMessageResponse(Map<String, String> r100, Map<String, Share2ThreadTarget> r101, List<ShareFailedChat> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ShareTodoMessageResponse(Map<String, String> r100, Map<String, Share2ThreadTarget> r101, List<ShareFailedChat> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id2message_ids = Internal.immutableCopyOf("chat_id2message_ids", r100);
        this.message2threads = Internal.immutableCopyOf("message2threads", r101);
        this.failed_chats = Internal.immutableCopyOf("failed_chats", r102);
    }
}
