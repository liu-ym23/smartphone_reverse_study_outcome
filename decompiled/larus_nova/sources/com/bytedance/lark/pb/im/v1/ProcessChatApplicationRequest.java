package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ChatApplication;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class ProcessChatApplicationRequest extends Message<ProcessChatApplicationRequest, Builder> {
    public static final ProtoAdapter<ProcessChatApplicationRequest> ADAPTER = null;
    public static final Boolean DEFAULT_AUTH_SYNC = null;
    public static final String DEFAULT_ID = "";
    public static final ChatApplication.Status DEFAULT_STATUS = null;
    public static final String DEFAULT_USER_ID = "";
    public static final ProtoAdapter_ProcessChatApplicationRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean auth_sync;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253647id;
    public final ChatApplication.Status status;
    public final String user_id;

    public static final class Builder extends Message.Builder<ProcessChatApplicationRequest, Builder> implements d<ProcessChatApplicationRequest> {
        public Boolean auth_sync;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253648id;
        public ChatApplication.Status status;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public ProcessChatApplicationRequest build() {
            return new ProcessChatApplicationRequest(this.f253648id, this.status, this.user_id, this.auth_sync, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auth_sync(Boolean r100) {
            this.auth_sync = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253648id = r100;
            return this;
        }

        public Builder status(ChatApplication.Status r100) {
            this.status = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ProcessChatApplicationRequest extends ProtoAdapter<ProcessChatApplicationRequest> implements c<ProcessChatApplicationRequest> {
        public ProtoAdapter_ProcessChatApplicationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ProcessChatApplicationRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ProcessChatApplicationRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253648id = "";
            r101.status = ChatApplication.Status.UNKNOWN_STATUS;
            r101.user_id = "";
            r101.auth_sync = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.f253648id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.status = ChatApplication.Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.auth_sync = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ProcessChatApplicationRequest r100) {
            String r101 = r100.f253647id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ChatApplication.Status r104 = r100.status;
            if (r104 == null) goto L9;
            int r105 = ChatApplication.Status.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.user_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.auth_sync;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ProcessChatApplicationRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ProcessChatApplicationRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ProcessChatApplicationRequest r101) throws IOException {
            String r102 = r101.f253647id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ChatApplication.Status r103 = r101.status;
            if (r103 == null) goto L8;
            ChatApplication.Status.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.user_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.auth_sync;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ProcessChatApplicationRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ProcessChatApplicationRequest r100 = new ProtoAdapter_ProcessChatApplicationRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = ChatApplication.Status.UNKNOWN_STATUS;
        DEFAULT_AUTH_SYNC = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253648id = this.f253647id;
        r100.status = this.status;
        r100.user_id = this.user_id;
        r100.auth_sync = this.auth_sync;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ProcessChatApplicationRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ProcessChatApplicationRequest(String r100, ChatApplication.Status r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ProcessChatApplicationRequest(String r100, ChatApplication.Status r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.f253647id = r100;
        this.status = r101;
        this.user_id = r102;
        this.auth_sync = r103;
    }
}
