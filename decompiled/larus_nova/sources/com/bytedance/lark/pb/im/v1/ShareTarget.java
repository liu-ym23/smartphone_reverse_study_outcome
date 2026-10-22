package com.bytedance.lark.pb.im.v1;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ShareTarget extends Message<ShareTarget, Builder> {
    public static final ProtoAdapter<ShareTarget> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Chat to_chat;
    public final Thread to_thread;

    public static final class Builder extends Message.Builder<ShareTarget, Builder> {
        public Chat to_chat;
        public Thread to_thread;

        @Override // com.squareup.wire.Message.Builder
        public ShareTarget build() {
            return new ShareTarget(this.to_chat, this.to_thread, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder to_chat(Chat r100) {
            this.to_chat = r100;
            this.to_thread = null;
            return this;
        }

        public Builder to_thread(Thread r100) {
            this.to_thread = r100;
            this.to_chat = null;
            return this;
        }
    }

    public static final class Chat extends Message<Chat, Builder> {
        public static final ProtoAdapter<Chat> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        private static final long serialVersionUID = 0;
        public final String chat_id;

        public static final class Builder extends Message.Builder<Chat, Builder> {
            public String chat_id;

            @Override // com.squareup.wire.Message.Builder
            public Chat build() {
                String r100 = this.chat_id;
                if (r100 == null) goto L7;
                return new Chat(this.chat_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
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
        }

        public static final class ProtoAdapter_Chat extends ProtoAdapter<Chat> {
            public ProtoAdapter_Chat() {
                super(FieldEncoding.LENGTH_DELIMITED, Chat.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Chat decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chat_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.chat_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Chat r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Chat decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Chat r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Chat r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Chat r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Chat();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chat_id = this.chat_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Chat.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Chat(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public Chat(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.chat_id = r100;
        }
    }

    public static final class ProtoAdapter_ShareTarget extends ProtoAdapter<ShareTarget> {
        public ProtoAdapter_ShareTarget() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareTarget.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShareTarget decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.to_chat(Chat.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.to_thread(Thread.ADAPTER.decode(r100));
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
        public int encodedSize2(ShareTarget r100) {
            Chat r101 = r100.to_chat;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Chat.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Thread r104 = r100.to_thread;
            if (r104 == null) goto L10;
            r102 = Thread.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ShareTarget decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShareTarget r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShareTarget r101) throws IOException {
            Chat r102 = r101.to_chat;
            if (r102 == null) goto L5;
            Chat.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Thread r103 = r101.to_thread;
            if (r103 == null) goto L8;
            Thread.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareTarget r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Thread extends Message<Thread, Builder> {
        public static final ProtoAdapter<Thread> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        public static final String DEFAULT_THREAD_ID = "";
        private static final long serialVersionUID = 0;
        public final String chat_id;
        public final String thread_id;

        public static final class Builder extends Message.Builder<Thread, Builder> {
            public String chat_id;
            public String thread_id;

            @Override // com.squareup.wire.Message.Builder
            public Thread build() {
                String r100 = this.thread_id;
                if (r100 == null) goto L9;
                if (this.chat_id == null) goto L9;
                return new Thread(this.thread_id, this.chat_id, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, CrashHianalyticsData.THREAD_ID, this.chat_id, "chat_id"});
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

            public Builder thread_id(String r100) {
                this.thread_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Thread extends ProtoAdapter<Thread> {
            public ProtoAdapter_Thread() {
                super(FieldEncoding.LENGTH_DELIMITED, Thread.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Thread decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.thread_id = "";
                r101.chat_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.thread_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.chat_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Thread r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                return (r101.encodedSizeWithTag(1, r100.thread_id) + r101.encodedSizeWithTag(2, r100.chat_id)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Thread decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Thread r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Thread r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.thread_id);
                r102.encodeWithTag(r100, 2, r101.chat_id);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Thread r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Thread();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.thread_id = this.thread_id;
            r100.chat_id = this.chat_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Thread.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Thread(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Thread(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.thread_id = r100;
            this.chat_id = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ShareTarget();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.to_chat = this.to_chat;
        r100.to_thread = this.to_thread;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShareTarget.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShareTarget(Chat r100, Thread r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ShareTarget(Chat r100, Thread r101, ByteString r102) {
        super(ADAPTER, r102);
        if (Internal.countNonNull(r100, r101) > 1) goto L7;
        this.to_chat = r100;
        this.to_thread = r101;
        return;
    L7:
        throw new IllegalArgumentException("at most one of to_chat, to_thread may be non-null");
    }
}
