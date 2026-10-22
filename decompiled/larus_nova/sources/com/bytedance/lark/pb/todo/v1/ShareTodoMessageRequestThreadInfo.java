package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ShareTodoMessageRequestThreadInfo extends Message<ShareTodoMessageRequestThreadInfo, Builder> {
    public static final ProtoAdapter<ShareTodoMessageRequestThreadInfo> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_IS_REPLY_IN_THREAD = null;
    public static final String DEFAULT_THREAD_ID = "";
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Boolean is_reply_in_thread;
    public final String thread_id;

    public static final class Builder extends Message.Builder<ShareTodoMessageRequestThreadInfo, Builder> {
        public String chat_id;
        public Boolean is_reply_in_thread;
        public String thread_id;

        @Override // com.squareup.wire.Message.Builder
        public ShareTodoMessageRequestThreadInfo build() {
            return new ShareTodoMessageRequestThreadInfo(this.thread_id, this.chat_id, this.is_reply_in_thread, super.buildUnknownFields());
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

        public Builder is_reply_in_thread(Boolean r100) {
            this.is_reply_in_thread = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ShareTodoMessageRequestThreadInfo extends ProtoAdapter<ShareTodoMessageRequestThreadInfo> {
        public ProtoAdapter_ShareTodoMessageRequestThreadInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareTodoMessageRequestThreadInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShareTodoMessageRequestThreadInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.thread_id = "";
            r101.chat_id = "";
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
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ShareTodoMessageRequestThreadInfo r100) {
            String r101 = r100.thread_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.chat_id;
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
        public /* bridge */ /* synthetic */ ShareTodoMessageRequestThreadInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShareTodoMessageRequestThreadInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShareTodoMessageRequestThreadInfo r101) throws IOException {
            String r102 = r101.thread_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.chat_id;
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
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareTodoMessageRequestThreadInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ShareTodoMessageRequestThreadInfo();
        DEFAULT_IS_REPLY_IN_THREAD = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.thread_id = this.thread_id;
        r100.chat_id = this.chat_id;
        r100.is_reply_in_thread = this.is_reply_in_thread;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShareTodoMessageRequestThreadInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShareTodoMessageRequestThreadInfo(String r100, String r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ShareTodoMessageRequestThreadInfo(String r100, String r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.thread_id = r100;
        this.chat_id = r101;
        this.is_reply_in_thread = r102;
    }
}
